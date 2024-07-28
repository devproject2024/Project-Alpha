package com.alipay.mobile.nebulacore.appcenter.parse;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.text.TextUtils;
import androidx.localbroadcastmanager.a.a;
import com.alipay.mobile.h5container.api.H5PageLoader;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.appcenter.util.H5AppInstallStep;
import com.alipay.mobile.nebula.callback.H5AppInstallProcess;
import com.alipay.mobile.nebula.data.H5Trace;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5AppUrlMapProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.alipay.mobile.nebula.tiny.H5TinyFallBackData;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5NetworkUtil;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import com.alipay.mobile.nebula.webview.H5ResContentList;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.api.H5ParseResult;
import com.alipay.mobile.nebulacore.appcenter.center.H5GlobalTempPkg;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.util.NebulaUtil;
import com.alipay.mobile.nebulacore.wallet.H5Logger;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class H5ContentPackage extends ConcurrentHashMap<String, byte[]> {
    private static final int DEFAULT_MAX_PREPARE_WAIT_MS = 5000;
    private static final int RETRY_LIMIT = 3;
    private final String EXTRA_KEY_APP_ID = "app_id";
    private final String EXTRA_KEY_APP_VERSION = "version";
    /* access modifiers changed from: private */
    public String TAG = "H5ContentPackage";
    /* access modifiers changed from: private */
    public String appId;
    /* access modifiers changed from: private */
    public H5AppProvider appProvider;
    private boolean canDegrade = false;
    public String currentUseVersion;
    private BroadcastReceiver downLoadReceiver = null;
    private boolean downloadReceiverRegistered = false;
    /* access modifiers changed from: private */
    public String fallbackReason;
    H5AppUrlMapProvider h5AppUrlMapProvider;
    private boolean hasCheck;
    private boolean hasHandleSessionTabData = false;
    private BroadcastReceiver installReceiver = null;
    private boolean installReceiverRegistered = false;
    /* access modifiers changed from: private */
    public boolean isResPackage;
    private boolean isResourceApp;
    /* access modifiers changed from: private */
    public Bundle params;
    private CountDownLatch parseLatch;
    /* access modifiers changed from: private */
    public boolean preload;
    private int retryCount = 0;
    /* access modifiers changed from: private */
    public String tarPath;
    private boolean triggerDownload;
    /* access modifiers changed from: private */
    public String version;

    public H5ContentPackage(Bundle bundle, boolean z, boolean z2, boolean z3) {
        this.triggerDownload = z;
        this.appId = H5Utils.getString(bundle, "appId");
        this.params = bundle;
        this.appProvider = (H5AppProvider) Nebula.getProviderManager().getProvider(H5AppProvider.class.getName());
        this.hasCheck = z2;
        this.isResPackage = z3;
        this.isResourceApp = isResourceApp(this.appId, this.appProvider);
        this.h5AppUrlMapProvider = (H5AppUrlMapProvider) Nebula.getProviderManager().getProvider(H5AppUrlMapProvider.class.getName());
    }

    public void setPreload(boolean z) {
        this.preload = z;
    }

    public void prepareContent(ConditionVariable conditionVariable) {
        if (this.appProvider == null) {
            H5Log.e(this.TAG, "failed to get app provider!");
            return;
        }
        this.version = H5Utils.getString(this.params, "appVersion");
        if (TextUtils.isEmpty(this.version)) {
            if (enableUseDegrade()) {
                this.version = getHighestVersion(this.appId);
            } else {
                this.version = this.appProvider.getVersion(this.appId);
            }
        }
        this.TAG = "H5ContentPackage_" + this.appId + "_" + this.version;
        boolean z = !TextUtils.isEmpty(this.currentUseVersion) && !TextUtils.isEmpty(this.version) && !this.version.equalsIgnoreCase(this.currentUseVersion);
        boolean isInstalled = this.appProvider.isInstalled(this.appId, this.version);
        String str = this.TAG;
        H5Log.d(str, "prepareContent appId:" + this.appId + "appVersion " + this.version + " installed:" + isInstalled + " currentUseVersion:" + this.currentUseVersion);
        if (z || isEmpty()) {
            H5ContentPackage h5ContentPackage = H5GlobalTempPkg.getInstance().getH5ContentPackage(this.appId);
            if (h5ContentPackage != null) {
                String str2 = this.TAG;
                H5Log.d(str2, "H5GlobalTempPkg contain " + this.appId + " " + h5ContentPackage.currentUseVersion);
                if (!TextUtils.isEmpty(this.version) && TextUtils.equals(this.version, h5ContentPackage.currentUseVersion)) {
                    H5Log.d(this.TAG, "H5GlobalTempPkg contain contain this version not parse");
                    return;
                }
            }
            if (!isInstalled) {
                final boolean isAvailable = this.appProvider.isAvailable(this.appId, this.version);
                H5Log.d(this.TAG, "isAvailable ".concat(String.valueOf(isAvailable)));
                handleSessionTabData(false, this.params, (String) null);
                setTinyAppFallBackData();
                if (!this.appProvider.isNebulaApp(this.appId)) {
                    downloadContent();
                    registerInstallReceiver();
                    this.fallbackReason = "isNotNebulaApp";
                } else if (Nebula.isTinyResAppId(this.appId) && !"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_use_preset_tinyCommonRes"))) {
                    if (this.parseLatch == null) {
                        this.parseLatch = new CountDownLatch(1);
                    }
                    final long currentTimeMillis = System.currentTimeMillis();
                    H5Utils.getExecutor(H5ThreadType.URGENT_DISPLAY).execute(new Runnable() {
                        public void run() {
                            String processName;
                            H5GlobalTempPkg.getInstance().prepareContent(H5ContentPackage.this.appId);
                            H5ContentPackage.this.closeWait(currentTimeMillis, (ConditionVariable) null);
                            String access$200 = H5ContentPackage.this.TAG;
                            H5Log.d(access$200, "66666692 tinyResApp prepareContent cost " + (System.currentTimeMillis() - currentTimeMillis));
                            if (!H5ContentPackage.this.preload || (processName = H5Utils.getProcessName()) == null || !processName.contains("lite1")) {
                                H5Utils.getScheduledExecutor().schedule(new Runnable() {
                                    public void run() {
                                        String access$200 = H5ContentPackage.this.TAG;
                                        H5Log.d(access$200, "66666692 tinyResApp prepare preload:" + H5ContentPackage.this.preload);
                                        Nebula.prepare(H5ContentPackage.this.appProvider, H5ContentPackage.this.appId, H5ContentPackage.this.version, (H5AppInstallProcess) null);
                                    }
                                }, 5, TimeUnit.SECONDS);
                            } else {
                                H5Log.d(H5ContentPackage.this.TAG, "66666692 tinyResApp in preLoadLite1 not prepare");
                            }
                        }
                    });
                } else if (enableUseDegrade()) {
                    if (this.parseLatch == null) {
                        this.parseLatch = new CountDownLatch(1);
                    }
                    final long currentTimeMillis2 = System.currentTimeMillis();
                    final ConditionVariable conditionVariable2 = conditionVariable;
                    H5Utils.getExecutor(H5ThreadType.URGENT_DISPLAY).execute(new Runnable() {
                        public void run() {
                            H5GlobalTempPkg.getInstance().prepareContent(H5ContentPackage.this.appId);
                            H5ContentPackage.this.closeWait(currentTimeMillis2, (ConditionVariable) null);
                            H5ContentPackage.this.prepareApp(conditionVariable2, isAvailable);
                        }
                    });
                } else {
                    prepareApp(conditionVariable, isAvailable);
                }
            } else {
                parseContent(false, this.appProvider.getInstallPath(this.appId, this.version), conditionVariable, false);
            }
        } else {
            H5Log.d(this.TAG, "!versionChanged return");
        }
    }

    /* access modifiers changed from: private */
    public void prepareApp(ConditionVariable conditionVariable, boolean z) {
        if (!z) {
            this.fallbackReason = "notDownload_" + H5NetworkUtil.getInstance().getNetworkString();
            registerDownLoadReceiver();
        } else if (this.isResPackage) {
            registerInstallReceiver();
        } else if (!"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("H5_wait_installApp"))) {
            parseContent(false, this.appProvider.getInstallPath(this.appId, this.version), conditionVariable, true);
            return;
        }
        Nebula.prepareApp(this.appProvider, this.appId, this.version, this.hasCheck, this.isResPackage, new H5AppInstallProcess() {
            public void onResult(boolean z, boolean z2) {
            }

            public void prepare(H5AppInstallStep h5AppInstallStep, String str) {
            }
        });
    }

    public void setCanDegrade(boolean z) {
        H5Log.d(this.TAG, "setCanDegrade : ".concat(String.valueOf(z)));
        this.canDegrade = z;
    }

    private boolean enableUseDegrade() {
        if (!this.canDegrade) {
            return false;
        }
        return NebulaUtil.enableResDegrade();
    }

    private String getHighestVersion(String str) {
        H5AppDBService appDBService;
        H5AppCenterService h5AppCenterService = (H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName());
        if (h5AppCenterService == null || (appDBService = h5AppCenterService.getAppDBService()) == null) {
            return "";
        }
        String highestAppVersion = appDBService.getHighestAppVersion(str);
        H5Log.d(this.TAG, "highestVersion : ".concat(String.valueOf(highestAppVersion)));
        return highestAppVersion;
    }

    private void setTinyAppFallBackData() {
        if (!this.isResPackage && H5Utils.getBoolean(this.params, H5Param.isTinyApp, false)) {
            byte[] removeApiPermission = H5TinyFallBackData.removeApiPermission(this.appId, this.version);
            byte[] removeAppConfigByte = H5TinyFallBackData.removeAppConfigByte(this.appId, this.version);
            if (!(removeApiPermission == null || Nebula.getH5TinyAppService() == null)) {
                Nebula.getH5TinyAppService().put(this.appId, removeApiPermission);
            }
            if (removeAppConfigByte != null) {
                H5StartParamManager.getInstance().put(this.appId, removeAppConfigByte);
            }
        }
    }

    public void releaseContent() {
        String str = this.TAG;
        H5Log.d(str, "releaseContent appId " + this.appId + " version " + this.version);
        countDownLatch();
        clear();
        unregisterInstallReceiver();
        unregisterDownLoadReceiver();
    }

    private void downloadContent() {
        if (this.triggerDownload) {
            int i2 = this.retryCount;
            if (i2 >= 3) {
                H5Log.w(this.TAG, "abort retry to download app.");
                return;
            }
            this.retryCount = i2 + 1;
            String str = this.TAG;
            H5Log.w(str, "downloadContent " + this.appId);
            H5AppProvider h5AppProvider = this.appProvider;
            if (h5AppProvider != null) {
                h5AppProvider.downloadApp(this.appId, this.version);
            }
        }
    }

    /* access modifiers changed from: private */
    public void hotUpdateApp(final boolean z, final String str) {
        H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
            public void run() {
                if (H5ContentPackage.this.appProvider == null) {
                    H5Log.e(H5ContentPackage.this.TAG, "failed to get app provider!");
                    return;
                }
                try {
                    if (!H5ContentPackage.this.isResPackage) {
                        String access$200 = H5ContentPackage.this.TAG;
                        H5Log.d(access$200, "hotVersion " + str + " appVersion:" + H5ContentPackage.this.version);
                        if (!TextUtils.equals(str, H5ContentPackage.this.version)) {
                            return;
                        }
                    }
                    if (!TextUtils.isEmpty(str)) {
                        String unused = H5ContentPackage.this.version = str;
                    }
                    if (z) {
                        String access$2002 = H5ContentPackage.this.TAG;
                        H5Log.d(access$2002, "install app:" + H5ContentPackage.this.appId + " version:" + H5ContentPackage.this.version);
                        H5ContentPackage.this.appProvider.installApp(H5ContentPackage.this.appId, H5ContentPackage.this.version);
                    }
                    final String installPath = H5ContentPackage.this.appProvider.getInstallPath(H5ContentPackage.this.appId, H5ContentPackage.this.version);
                    H5Utils.runOnMain(new Runnable() {
                        public void run() {
                            H5ContentPackage.this.parseContent(true, installPath, (ConditionVariable) null, false);
                        }
                    });
                } catch (Exception e2) {
                    H5Log.e(H5ContentPackage.this.TAG, (Throwable) e2);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public void parseContent(boolean z, String str, ConditionVariable conditionVariable, boolean z2) {
        H5Log.d(this.TAG, "parseContent " + this.appId + " " + str);
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder("nebulasessiontracker parseContent outer sessionid ");
        sb.append(H5Utils.getString(this.params, H5Param.SESSION_ID));
        H5Log.d(str2, sb.toString());
        if (this.appProvider == null) {
            H5Log.e(this.TAG, "failed to get app provider!");
            return;
        }
        String str3 = null;
        try {
            if (!TextUtils.isEmpty(str)) {
                str3 = "file://".concat(String.valueOf(str));
                if (!str3.endsWith("/")) {
                    str3 = str3 + "/";
                }
            }
            if (!TextUtils.isEmpty(str3)) {
                Uri parseUrl = H5UrlHelper.parseUrl(str3);
                if (parseUrl != null) {
                    this.tarPath = parseUrl.getPath() + "/" + this.appId + ".tar";
                }
                if (this.params.containsKey(H5Param.OFFLINE_HOST)) {
                    this.params.remove(H5Param.OFFLINE_HOST);
                }
                this.params.putString(H5Param.OFFLINE_HOST, str3);
            }
            final long currentTimeMillis = System.currentTimeMillis();
            if (conditionVariable == null && !z && this.parseLatch == null) {
                this.parseLatch = new CountDownLatch(1);
            }
            final boolean z3 = z2;
            final Bundle copyBundle = Nebula.copyBundle(this.params);
            final ConditionVariable conditionVariable2 = conditionVariable;
            final boolean z4 = z;
            H5Utils.getExecutor(H5ThreadType.URGENT_DISPLAY).execute(new ParseRunnable(H5Utils.getString(this.params, H5Param.SESSION_ID)) {
                public void run() {
                    boolean z = true;
                    if (z3) {
                        long currentTimeMillis = System.currentTimeMillis();
                        H5ContentPackage.this.appProvider.installApp(H5ContentPackage.this.appId, H5ContentPackage.this.version, true);
                        H5Log.d(H5ContentPackage.this.TAG, "installApp spend allCoast " + (System.currentTimeMillis() - currentTimeMillis));
                    }
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    H5ParseResult parsePackage = H5PackageParser.parsePackage(copyBundle, concurrentHashMap);
                    H5Log.d(H5ContentPackage.this.TAG, "parse appId " + H5ContentPackage.this.appId + " errorCode " + parsePackage.code);
                    if (parsePackage.code != 0) {
                        z = false;
                    }
                    if (z) {
                        H5ContentPackage.this.clear();
                        H5ContentPackage.this.putAll(concurrentHashMap);
                        H5ContentPackage h5ContentPackage = H5ContentPackage.this;
                        h5ContentPackage.currentUseVersion = h5ContentPackage.version;
                        H5MonitorModel appendCostTime = new H5MonitorModel().success().seedId(H5MonitorModel.SEED_ID_PREPARE_RES).appendSubappId(H5ContentPackage.this.appId).appendPackageVersion(H5ContentPackage.this.version).appendCostTime(System.currentTimeMillis() - parsePackage.verifyStart);
                        StringBuilder sb = new StringBuilder();
                        sb.append(parsePackage.loadStart - parsePackage.verifyStart);
                        H5MonitorModel appendExtParams = appendCostTime.appendExtParams("verifyCost", sb.toString());
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(parsePackage.loadEnd - parsePackage.loadStart);
                        H5MonitorModel appendExtParams2 = appendExtParams.appendExtParams("loadCost", sb2.toString());
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(System.currentTimeMillis() - parsePackage.loadEnd);
                        H5Monitor.behavior(appendExtParams2.appendExtParams("copyCost", sb3.toString()));
                        H5ContentPackage.this.closeWait(currentTimeMillis, conditionVariable2);
                        H5LogProvider h5LogProvider = (H5LogProvider) H5Utils.getProvider(H5LogProvider.class.getName());
                        if (h5LogProvider != null) {
                            h5LogProvider.logV2("H5_APP_VERIFY", "", "", "isNebulaApp=" + H5ContentPackage.this.appProvider.isNebulaApp(H5ContentPackage.this.appId), "", "appId=" + H5ContentPackage.this.appId + "^version=" + H5ContentPackage.this.version + "^step=success", "H-MM");
                        }
                    } else {
                        String unused = H5ContentPackage.this.fallbackReason = "verifyFail_" + parsePackage.msg;
                        H5ContentPackage.this.closeWait(currentTimeMillis, conditionVariable2);
                        H5LogProvider h5LogProvider2 = (H5LogProvider) H5Utils.getProvider(H5LogProvider.class.getName());
                        if (h5LogProvider2 != null) {
                            String str = parsePackage.msg;
                            if (z3) {
                                String unused2 = H5ContentPackage.this.fallbackReason = H5ContentPackage.this.fallbackReason + "_patchFail";
                                str = str + "_patchFail";
                            }
                            h5LogProvider2.logV2("H5_APP_VERIFY", "", "errorMsg=".concat(String.valueOf(str)), "isNebulaApp=" + H5ContentPackage.this.appProvider.isNebulaApp(H5ContentPackage.this.appId), "", "appId=" + H5ContentPackage.this.appId + "^version=" + H5ContentPackage.this.version + "^step=fail^errorCode=" + parsePackage.code, "H-MM");
                        }
                    }
                    H5Log.d(H5ContentPackage.this.TAG, "nebulasessiontracker parseContent inner sessionid " + this.sid);
                    H5ContentPackage h5ContentPackage2 = H5ContentPackage.this;
                    h5ContentPackage2.handleSessionTabData(z, h5ContentPackage2.params, this.sid);
                    if (z && z4) {
                        String str2 = "appId=" + H5ContentPackage.this.appId + "^version=" + H5ContentPackage.this.version + "^publicId=" + H5Utils.getString(H5ContentPackage.this.params, H5Param.PUBLIC_ID) + "^url=" + H5Utils.getString(H5ContentPackage.this.params, "url");
                        H5LogProvider h5LogProvider3 = (H5LogProvider) Nebula.getProviderManager().getProvider(H5LogProvider.class.getName());
                        if (h5LogProvider3 != null && TextUtils.equals(H5PageLoader.mainUrl, H5Utils.getString(H5ContentPackage.this.params, "url"))) {
                            h5LogProvider3.logV2("H5_AL_SESSION_UPDATEPACKAGE_SUCCESS", "diagnose", str2, (String) null, (String) null, "appId=" + H5ContentPackage.this.appId + "^version=" + H5ContentPackage.this.version, "H-MM");
                        }
                    }
                    if (parsePackage.code == 6) {
                        String string = H5Utils.getString(H5ContentPackage.this.params, "url");
                        String str3 = "appId=" + H5ContentPackage.this.appId + "^version=" + H5ContentPackage.this.version + "^publicId=" + H5Utils.getString(H5ContentPackage.this.params, H5Param.PUBLIC_ID) + "^url=" + string + "^errorCode" + parsePackage;
                        H5LogProvider h5LogProvider4 = (H5LogProvider) Nebula.getProviderManager().getProvider(H5LogProvider.class.getName());
                        if (h5LogProvider4 != null && TextUtils.equals(string, H5PageLoader.mainUrl)) {
                            h5LogProvider4.logV2("H5_AL_SESSION_VERIFYTAR_FAIL", "diagnose", str3, "tarPath=" + H5ContentPackage.this.tarPath, (String) null, "appId=" + H5ContentPackage.this.appId + "^version=" + H5ContentPackage.this.version, "H-MM");
                        }
                        HashMap hashMap = new HashMap();
                        hashMap.put("url", string);
                        hashMap.put("tarPath", H5ContentPackage.this.tarPath);
                        H5Logger.mtBizReport(H5Logger.MTBIZ_H5, "H5_VERIFYTAR_FAILED", "1", hashMap);
                    }
                    H5Trace.event("h5PageReady", (String) null, new String[0]);
                }
            });
            if (conditionVariable != null) {
                conditionVariable.close();
                conditionVariable.block(5000);
            }
        } catch (Exception e2) {
            H5Log.e(this.TAG, (Throwable) e2);
        }
    }

    /* access modifiers changed from: private */
    public void closeWait(long j, ConditionVariable conditionVariable) {
        CountDownLatch countDownLatch = this.parseLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
            this.parseLatch = null;
            String str = this.TAG;
            H5Log.d(str, "parseLatch block " + (System.currentTimeMillis() - j));
        }
        if (conditionVariable != null) {
            conditionVariable.open();
            String str2 = this.TAG;
            H5Log.d(str2, "conditionVariable block " + (System.currentTimeMillis() - j));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00df, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x012c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x012e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void handleSessionTabData(boolean r5, android.os.Bundle r6, java.lang.String r7) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = r4.hasHandleSessionTabData     // Catch:{ all -> 0x012f }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r4)
            return
        L_0x0007:
            r0 = 1
            r4.hasHandleSessionTabData = r0     // Catch:{ all -> 0x012f }
            r0 = 0
            java.lang.String r1 = r4.TAG     // Catch:{ all -> 0x012f }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x012f }
            java.lang.String r3 = "##tabbar## handleSessionTabData isH5GlobalPackage "
            r2.<init>(r3)     // Catch:{ all -> 0x012f }
            boolean r3 = r4.isResPackage     // Catch:{ all -> 0x012f }
            r2.append(r3)     // Catch:{ all -> 0x012f }
            java.lang.String r3 = ", isReady "
            r2.append(r3)     // Catch:{ all -> 0x012f }
            r2.append(r5)     // Catch:{ all -> 0x012f }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x012f }
            com.alipay.mobile.nebula.util.H5Log.d(r1, r2)     // Catch:{ all -> 0x012f }
            boolean r1 = r4.isResPackage     // Catch:{ all -> 0x012f }
            if (r1 != 0) goto L_0x012d
            boolean r1 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x012f }
            if (r1 == 0) goto L_0x0039
            java.lang.String r7 = "sessionId"
            java.lang.String r7 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r6, (java.lang.String) r7)     // Catch:{ all -> 0x012f }
        L_0x0039:
            com.alipay.mobile.nebulacore.api.NebulaService r1 = com.alipay.mobile.nebulacore.Nebula.getService()     // Catch:{ all -> 0x012f }
            com.alipay.mobile.h5container.api.H5Session r7 = r1.getSession(r7)     // Catch:{ all -> 0x012f }
            boolean r1 = r7 instanceof com.alipay.mobile.nebulacore.core.H5SessionImpl     // Catch:{ all -> 0x012f }
            if (r1 == 0) goto L_0x012b
            r1 = r7
            com.alipay.mobile.nebulacore.core.H5SessionImpl r1 = (com.alipay.mobile.nebulacore.core.H5SessionImpl) r1     // Catch:{ all -> 0x012f }
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabObserver r1 = r1.getH5SessionTabObserver()     // Catch:{ all -> 0x012f }
            if (r1 != 0) goto L_0x0050
            goto L_0x012b
        L_0x0050:
            if (r5 != 0) goto L_0x00e0
            java.lang.String r5 = "cdnBaseUrl"
            java.lang.String r5 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r6, (java.lang.String) r5)     // Catch:{ all -> 0x012f }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x012f }
            if (r6 == 0) goto L_0x0065
            java.lang.String r6 = r4.TAG     // Catch:{ all -> 0x012f }
            java.lang.String r0 = "cdn url empty!"
            com.alipay.mobile.nebula.util.H5Log.w(r6, r0)     // Catch:{ all -> 0x012f }
        L_0x0065:
            if (r5 == 0) goto L_0x0080
            java.lang.String r6 = "/"
            boolean r6 = r5.endsWith(r6)     // Catch:{ all -> 0x012f }
            if (r6 != 0) goto L_0x0080
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x012f }
            r6.<init>()     // Catch:{ all -> 0x012f }
            r6.append(r5)     // Catch:{ all -> 0x012f }
            java.lang.String r5 = "/"
            r6.append(r5)     // Catch:{ all -> 0x012f }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x012f }
        L_0x0080:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x012f }
            r6.<init>()     // Catch:{ all -> 0x012f }
            r6.append(r5)     // Catch:{ all -> 0x012f }
            java.lang.String r5 = "tabBar.json"
            r6.append(r5)     // Catch:{ all -> 0x012f }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x012f }
            java.lang.String r6 = r4.TAG     // Catch:{ all -> 0x012f }
            java.lang.String r0 = "##tabbar## handleSessionTabData !isReady fallback final url "
            java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x012f }
            java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x012f }
            com.alipay.mobile.nebula.util.H5Log.d(r6, r0)     // Catch:{ all -> 0x012f }
            java.lang.String r6 = r4.TAG     // Catch:{ all -> 0x012f }
            java.lang.String r0 = "##tabbar## handleSessionTabData !isReady tabDataStr "
            java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x012f }
            java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x012f }
            com.alipay.mobile.nebula.util.H5Log.d(r6, r0)     // Catch:{ all -> 0x012f }
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x012f }
            if (r6 == 0) goto L_0x00b9
            java.lang.String r5 = "stupid"
        L_0x00b9:
            com.alipay.mobile.nebulacore.core.H5SessionImpl r7 = (com.alipay.mobile.nebulacore.core.H5SessionImpl) r7     // Catch:{ all -> 0x012f }
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabObserver r6 = r7.getH5SessionTabObserver()     // Catch:{ all -> 0x012f }
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabObserver$H5SessionTabListener r6 = r6.setData(r5)     // Catch:{ all -> 0x012f }
            java.lang.String r7 = r4.TAG     // Catch:{ all -> 0x012f }
            java.lang.String r0 = "##tabbar## handleSessionTabData !isReady listener "
            java.lang.String r1 = java.lang.String.valueOf(r6)     // Catch:{ all -> 0x012f }
            java.lang.String r0 = r0.concat(r1)     // Catch:{ all -> 0x012f }
            com.alipay.mobile.nebula.util.H5Log.d(r7, r0)     // Catch:{ all -> 0x012f }
            if (r6 == 0) goto L_0x00de
            java.lang.String r7 = r4.TAG     // Catch:{ all -> 0x012f }
            java.lang.String r0 = "##tabbar## handleSessionTabData !isReady onDataParsed"
            com.alipay.mobile.nebula.util.H5Log.d(r7, r0)     // Catch:{ all -> 0x012f }
            r6.onDataParsed(r5)     // Catch:{ all -> 0x012f }
        L_0x00de:
            monitor-exit(r4)
            return
        L_0x00e0:
            java.lang.String r5 = r4.appId     // Catch:{ all -> 0x012f }
            byte[] r5 = com.alipay.mobile.nebula.util.H5TabbarUtils.getTabDataByAppId(r5)     // Catch:{ all -> 0x012f }
            if (r5 == 0) goto L_0x00ed
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x012f }
            r0.<init>(r5)     // Catch:{ all -> 0x012f }
        L_0x00ed:
            java.lang.String r5 = r4.TAG     // Catch:{ all -> 0x012f }
            java.lang.String r6 = "##tabbar## handleSessionTabData isReady tabBarData "
            java.lang.String r1 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x012f }
            java.lang.String r6 = r6.concat(r1)     // Catch:{ all -> 0x012f }
            com.alipay.mobile.nebula.util.H5Log.d(r5, r6)     // Catch:{ all -> 0x012f }
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x012f }
            if (r5 == 0) goto L_0x0105
            java.lang.String r0 = "stupid"
        L_0x0105:
            com.alipay.mobile.nebulacore.core.H5SessionImpl r7 = (com.alipay.mobile.nebulacore.core.H5SessionImpl) r7     // Catch:{ all -> 0x012f }
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabObserver r5 = r7.getH5SessionTabObserver()     // Catch:{ all -> 0x012f }
            com.alipay.mobile.nebulacore.tabbar.H5SessionTabObserver$H5SessionTabListener r5 = r5.setData(r0)     // Catch:{ all -> 0x012f }
            java.lang.String r6 = r4.TAG     // Catch:{ all -> 0x012f }
            java.lang.String r7 = "##tabbar## handleSessionTabData isReady listener "
            java.lang.String r1 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x012f }
            java.lang.String r7 = r7.concat(r1)     // Catch:{ all -> 0x012f }
            com.alipay.mobile.nebula.util.H5Log.d(r6, r7)     // Catch:{ all -> 0x012f }
            if (r5 == 0) goto L_0x012d
            java.lang.String r6 = r4.TAG     // Catch:{ all -> 0x012f }
            java.lang.String r7 = "##tabbar## handleSessionTabData isReady onDataParsed"
            com.alipay.mobile.nebula.util.H5Log.d(r6, r7)     // Catch:{ all -> 0x012f }
            r5.onDataParsed(r0)     // Catch:{ all -> 0x012f }
            goto L_0x012d
        L_0x012b:
            monitor-exit(r4)
            return
        L_0x012d:
            monitor-exit(r4)
            return
        L_0x012f:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackage.handleSessionTabData(boolean, android.os.Bundle, java.lang.String):void");
    }

    private void countDownLatch() {
        CountDownLatch countDownLatch = this.parseLatch;
        if (countDownLatch != null) {
            countDownLatch.countDown();
            this.parseLatch = null;
        }
    }

    public byte[] get(String str) {
        try {
            if (this.parseLatch != null && this.parseLatch.getCount() > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                H5Log.d(this.TAG, "begin wait for ".concat(String.valueOf(str)));
                if (this.parseLatch != null) {
                    this.parseLatch.await(3, TimeUnit.SECONDS);
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                H5Log.d(this.TAG, "wait parse elapse ".concat(String.valueOf(currentTimeMillis2)));
                if (currentTimeMillis2 >= 3000) {
                    this.fallbackReason = "wait_appParse_timeout";
                    countDownLatch();
                }
            }
            if (this.h5AppUrlMapProvider != null) {
                str = this.h5AppUrlMapProvider.mapUrl(str, this.appId, this.version);
            }
            byte[] bArr = (byte[]) super.get(str);
            if (bArr != null) {
                String str2 = this.TAG;
                H5Log.d(str2, "package " + this.appId + " target " + str);
                if (H5ResContentList.enableResHttpCache() && this.isResourceApp) {
                    H5ResContentList.getInstance().add(str, bArr);
                    return null;
                }
            } else if (TextUtils.isEmpty(this.fallbackReason)) {
                this.fallbackReason = "notMatch";
            }
            return bArr;
        } catch (Throwable th) {
            H5Log.e(this.TAG, "latch exception:".concat(String.valueOf(th)));
            this.fallbackReason = th.toString();
            countDownLatch();
            return null;
        }
    }

    private boolean isResourceApp(String str, H5AppProvider h5AppProvider) {
        if (TextUtils.isEmpty(str) || h5AppProvider == null) {
            return false;
        }
        return h5AppProvider.isResourceApp(str);
    }

    private BroadcastReceiver getInstallReceiver() {
        if (this.installReceiver == null) {
            this.installReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    if (intent != null) {
                        String string = H5Utils.getString(intent.getExtras(), "app_id");
                        String string2 = H5Utils.getString(intent.getExtras(), "source");
                        String string3 = H5Utils.getString(intent.getExtras(), "version");
                        String access$200 = H5ContentPackage.this.TAG;
                        H5Log.d(access$200, "installReceiver receivedId:" + string + " hotVersion:" + string3 + " currentAppId:" + H5ContentPackage.this.appId);
                        if (H5ContentPackage.this.appId != null && H5ContentPackage.this.appId.equals(string)) {
                            String access$2002 = H5ContentPackage.this.TAG;
                            H5Log.d(access$2002, "received installedReceiver " + H5ContentPackage.this.appId + " to parseContent " + string2);
                            if (H5ContentPackage.this.unregisterInstallReceiver()) {
                                H5ContentPackage.this.hotUpdateApp(false, string3);
                            }
                        }
                    }
                }
            };
        }
        return this.installReceiver;
    }

    private synchronized void registerInstallReceiver() {
        if (!this.installReceiverRegistered) {
            this.installReceiverRegistered = true;
            a a2 = a.a(H5Utils.getContext());
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.alipay.mobile.android.h5app.installstatus");
            String str = this.TAG;
            H5Log.d(str, "registerInstallReceiver ：appId:" + this.appId + " version:" + this.version);
            a2.a(getInstallReceiver(), intentFilter);
        }
    }

    /* access modifiers changed from: private */
    public synchronized boolean unregisterInstallReceiver() {
        String str = this.TAG;
        H5Log.d(str, this.appId + " unregisterInstallReceiver " + this.installReceiverRegistered);
        if (!this.installReceiverRegistered) {
            return false;
        }
        this.installReceiverRegistered = false;
        a.a(H5Utils.getContext()).a(getInstallReceiver());
        return true;
    }

    public BroadcastReceiver getDownLoadReceiver() {
        if (this.downLoadReceiver == null) {
            this.downLoadReceiver = new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    if (intent != null && intent.getExtras() != null) {
                        String string = H5Utils.getString(intent.getExtras(), "app_id");
                        String string2 = H5Utils.getString(intent.getExtras(), "version");
                        String access$200 = H5ContentPackage.this.TAG;
                        H5Log.d(access$200, "downLoadReceiver receivedId:" + string + " hotVersion:" + string2 + " currentAppId:" + H5ContentPackage.this.appId);
                        if (H5ContentPackage.this.appId != null && H5ContentPackage.this.appId.equals(string)) {
                            String access$2002 = H5ContentPackage.this.TAG;
                            H5Log.d(access$2002, "received downLoadReceiver download " + H5ContentPackage.this.appId + " to parseContent ");
                            if (H5ContentPackage.this.unregisterDownLoadReceiver()) {
                                H5ContentPackage.this.hotUpdateApp(true, string2);
                            }
                        }
                    }
                }
            };
        }
        return this.downLoadReceiver;
    }

    private synchronized void registerDownLoadReceiver() {
        if (!this.downloadReceiverRegistered) {
            this.downloadReceiverRegistered = true;
            a a2 = a.a(H5Utils.getContext());
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.alipay.mobile.android.h5app.download");
            String str = this.TAG;
            H5Log.d(str, "registerDownLoadReceiver ：appId:" + this.appId + " version:" + this.version);
            a2.a(getDownLoadReceiver(), intentFilter);
        }
    }

    /* access modifiers changed from: private */
    public synchronized boolean unregisterDownLoadReceiver() {
        String str = this.TAG;
        H5Log.d(str, this.appId + " unregisterDownLoadReceiver " + this.downloadReceiverRegistered);
        if (!this.downloadReceiverRegistered) {
            return false;
        }
        this.downloadReceiverRegistered = false;
        a.a(H5Utils.getContext()).a(getDownLoadReceiver());
        return true;
    }

    public String getAppId() {
        return this.appId;
    }

    public Bundle getParams() {
        return this.params;
    }

    public String getVersion() {
        return this.version;
    }

    public String getFallbackReason() {
        return this.fallbackReason;
    }

    class ParseRunnable implements Runnable {
        String sid;

        public void run() {
        }

        public ParseRunnable(String str) {
            this.sid = str;
        }
    }
}
