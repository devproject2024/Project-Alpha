package com.alipay.mobile.nebulaappcenter.app;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import com.alibaba.a.e;
import com.alipay.mobile.nebula.appcenter.H5BaseApp;
import com.alipay.mobile.nebula.appcenter.H5PresetInfo;
import com.alipay.mobile.nebula.appcenter.H5PresetPkg;
import com.alipay.mobile.nebula.appcenter.api.H5AppInstallListen;
import com.alipay.mobile.nebula.appcenter.api.H5LoadPresetListen;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppScoreList;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadCallback;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest;
import com.alipay.mobile.nebula.appcenter.download.H5ExternalDownloadManager;
import com.alipay.mobile.nebula.appcenter.downloadImpl.H5AppDownLoadImpl;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.appcenter.wifidownload.H5WifiDownloadList;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.provider.H5PatchProvider;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5NetworkUtil;
import com.alipay.mobile.nebula.util.H5SecurityUtil;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.util.H5ZipUtil;
import com.alipay.mobile.nebula.util.monitor.H5Monitor;
import com.alipay.mobile.nebula.util.monitor.H5MonitorModel;
import com.alipay.mobile.nebulaappcenter.util.H5AppGlobal;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class H5App implements H5BaseApp, H5DownloadCallback {
    private static final String H5NebulaApp = "H5NebulaApp";
    /* access modifiers changed from: private */
    public String TAG = H5NebulaApp;
    /* access modifiers changed from: private */
    public AppInfo appInfo;
    private final String appsPath = H5AppGlobal.getInstallPath(H5AppGlobal.INSTALL_APP_PATH);
    private boolean asyncInstall = false;
    private Context context = H5Utils.getContext();
    private H5DownloadCallback downloadCallback;
    private String downloadScene;
    /* access modifiers changed from: private */
    public H5NebulaDBService h5AppDBService = H5NebulaDBService.getInstance();
    /* access modifiers changed from: private */
    public H5ExternalDownloadManager h5ExternalDownloadManager = ((H5ExternalDownloadManager) H5Utils.getProvider(H5ExternalDownloadManager.class.getName()));
    /* access modifiers changed from: private */
    public boolean h5PatchFail = false;
    private H5NetworkUtil.NetworkListener networkListener;
    /* access modifiers changed from: private */
    public boolean preInstall = false;

    public H5App() {
        if (this.h5ExternalDownloadManager == null) {
            H5Log.w(this.TAG, "h5ExternalDownloadManager == null use H5AppDownLoadImpl");
            this.h5ExternalDownloadManager = new H5AppDownLoadImpl();
        }
    }

    public String getAppId() {
        AppInfo appInfo2 = this.appInfo;
        if (appInfo2 != null) {
            return appInfo2.app_id;
        }
        return null;
    }

    private boolean enablePatch() {
        boolean z;
        H5ConfigProvider h5ConfigProvider;
        if (((H5PatchProvider) H5Utils.getProvider(H5PatchProvider.class.getName())) == null) {
            H5Log.e(this.TAG, "H5PatchProvider ==null not use patch");
            z = false;
        } else {
            z = !TextUtils.isEmpty(getLastPkgPath(this.appInfo.app_id));
            if (!z && (h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName())) != null && !"no".equalsIgnoreCase(h5ConfigProvider.getConfig("h5_clear_patch"))) {
                clearPatchDBInfo();
            }
        }
        H5Log.d(this.TAG, "enablePatch ".concat(String.valueOf(z)));
        return z;
    }

    public void setAppInfo(AppInfo appInfo2) {
        this.appInfo = appInfo2;
        if (appInfo2 != null) {
            this.TAG += "_" + appInfo2.app_id + "_" + appInfo2.version;
        }
    }

    public String getDownloadUrl() {
        AppInfo appInfo2 = this.appInfo;
        if (appInfo2 == null) {
            return null;
        }
        if (TextUtils.isEmpty(appInfo2.patch) || !enablePatch()) {
            return this.appInfo.package_url;
        }
        return this.appInfo.patch;
    }

    public String getDownloadLocalPath() {
        return getDownloadedFilePath();
    }

    public String getAppVersion() {
        AppInfo appInfo2 = this.appInfo;
        if (appInfo2 != null) {
            return appInfo2.version;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void doDownloadApp() {
        H5DownloadRequest downLoadRequest = getDownLoadRequest();
        if (TextUtils.isEmpty(downLoadRequest.getDownloadUrl()) || !downLoadRequest.getDownloadUrl().startsWith("http")) {
            return;
        }
        if (this.h5ExternalDownloadManager != null) {
            H5AppUtil.appCenterLog("H5_APP_DOWNLOAD", this.appInfo, "^step=start");
            try {
                if (!this.h5ExternalDownloadManager.isDownloading(downLoadRequest.getDownloadUrl())) {
                    synchronized (H5App.class) {
                        if (!this.h5ExternalDownloadManager.isDownloading(downLoadRequest.getDownloadUrl())) {
                            this.h5ExternalDownloadManager.addDownload(downLoadRequest, this);
                        }
                    }
                }
                initNetWorkListen();
            } catch (Throwable th) {
                H5Log.e(this.TAG, th);
            }
        } else {
            H5Log.e(this.TAG, "doDownloadApp h5ExternalDownloadManager is null");
        }
    }

    private H5DownloadRequest getDownLoadRequest() {
        String downloadUrl = getDownloadUrl();
        H5DownloadRequest h5DownloadRequest = new H5DownloadRequest();
        h5DownloadRequest.setAppId(getAppId());
        h5DownloadRequest.setVersion(getAppVersion());
        AppInfo appInfo2 = this.appInfo;
        if (appInfo2 != null) {
            h5DownloadRequest.setDescription(appInfo2.app_dsec);
            h5DownloadRequest.setTitle(this.appInfo.name);
        }
        h5DownloadRequest.setDownloadUrl(downloadUrl);
        h5DownloadRequest.setFileName(getDownLoadFileName());
        h5DownloadRequest.setScene(this.downloadScene);
        return h5DownloadRequest;
    }

    private void initNetWorkListen() {
        if (this.networkListener == null) {
            AppInfo appInfo2 = this.appInfo;
            if (appInfo2 != null && appInfo2.auto_install == 1) {
                return;
            }
            if (this.downloadCallback != null) {
                H5Log.d(this.TAG, " has downloadCallback not cacel");
                return;
            }
            this.networkListener = new H5NetworkUtil.NetworkListener() {
                public void onNetworkChanged(H5NetworkUtil.Network network, H5NetworkUtil.Network network2) {
                    if (network2 != H5NetworkUtil.Network.NETWORK_WIFI) {
                        final String downloadUrl = H5App.this.getDownloadUrl();
                        H5Log.d(H5App.this.TAG, " net change is not wifi and auto!=1 so cancel ".concat(String.valueOf(downloadUrl)));
                        if (H5App.this.h5ExternalDownloadManager != null) {
                            H5Utils.executeOrdered(H5App.H5NebulaApp, new Runnable() {
                                public void run() {
                                    try {
                                        H5App.this.h5ExternalDownloadManager.cancel(downloadUrl);
                                    } catch (Throwable th) {
                                        H5Log.e(H5App.this.TAG, th);
                                    }
                                }
                            });
                        }
                    }
                }
            };
            H5NetworkUtil.getInstance().addListener(this.networkListener);
        }
    }

    public void onPrepare(H5DownloadRequest h5DownloadRequest) {
        H5DownloadCallback h5DownloadCallback = this.downloadCallback;
        if (h5DownloadCallback != null) {
            h5DownloadCallback.onPrepare(h5DownloadRequest);
        }
    }

    public void onCancel(H5DownloadRequest h5DownloadRequest) {
        H5AppUtil.appCenterLog("H5_APP_DOWNLOAD", this.appInfo, "^step=cancel");
        H5Log.d(this.TAG, "download onCancel");
        if (this.networkListener != null) {
            H5NetworkUtil.getInstance().removeListener(this.networkListener);
            this.networkListener = null;
        }
        H5DownloadCallback h5DownloadCallback = this.downloadCallback;
        if (h5DownloadCallback != null) {
            h5DownloadCallback.onCancel(h5DownloadRequest);
        }
    }

    public void onFailed(H5DownloadRequest h5DownloadRequest, int i2, String str) {
        AppInfo appInfo2 = this.appInfo;
        H5AppUtil.appCenterLog("H5_APP_DOWNLOAD", appInfo2, "^step=fail^err=[" + i2 + "]" + str);
        if (this.appInfo != null) {
            String str2 = this.TAG;
            H5Log.d(str2, "appId:" + this.appInfo.app_id + " version:" + this.appInfo.version + " download onFailed, errorCode:" + i2 + ",errorMsg:" + str);
        }
        if (this.networkListener != null) {
            H5NetworkUtil.getInstance().removeListener(this.networkListener);
            this.networkListener = null;
        }
        H5DownloadCallback h5DownloadCallback = this.downloadCallback;
        if (h5DownloadCallback != null) {
            h5DownloadCallback.onFailed(h5DownloadRequest, i2, str);
        }
        AppInfo appInfo3 = this.appInfo;
        if (appInfo3 != null) {
            H5WifiDownloadList.put(appInfo3.app_id, this.appInfo.version);
        }
    }

    public void onProgress(H5DownloadRequest h5DownloadRequest, int i2) {
        H5DownloadCallback h5DownloadCallback = this.downloadCallback;
        if (h5DownloadCallback != null) {
            h5DownloadCallback.onProgress(h5DownloadRequest, i2);
        }
    }

    public void onFinish(H5DownloadRequest h5DownloadRequest, String str) {
        if (this.appInfo != null) {
            String str2 = this.TAG;
            H5Log.d(str2, "NebulaApp offline package download finished: appName:" + this.appInfo.name + " appId:" + this.appInfo.app_id + " version:" + this.appInfo.version + " savePath:" + str);
        }
        AppInfo appInfo2 = this.appInfo;
        H5AppUtil.appCenterLog("H5_APP_DOWNLOAD", appInfo2, "^step=success^downloadScene=" + this.downloadScene);
        if (this.networkListener != null) {
            H5NetworkUtil.getInstance().removeListener(this.networkListener);
            this.networkListener = null;
        }
        H5DownloadCallback h5DownloadCallback = this.downloadCallback;
        if (h5DownloadCallback != null) {
            h5DownloadCallback.onFinish(h5DownloadRequest, str);
        } else if (this.appInfo == null) {
        } else {
            if (disableAllPreInstall()) {
                H5AppUtil.broadcastForH5Download(getAppId(), getAppVersion());
                return;
            }
            e parseObject = H5Utils.parseObject(this.appInfo.extend_info_jo);
            if ((parseObject == null || parseObject.getIntValue(H5AppUtil.preset) != 1) && !H5AppScoreList.getInstance().isInStrategy(this.appInfo.app_id, 1)) {
                H5Utils.executeOrdered(H5NebulaApp, new Runnable() {
                    public void run() {
                        if (H5App.this.h5PatchFail) {
                            H5Log.d(H5App.this.TAG, "h5PatchFail to installApp");
                            H5App.this.installApp();
                            return;
                        }
                        H5App h5App = H5App.this;
                        String access$500 = h5App.getLastPkgPath(h5App.appInfo.app_id);
                        String access$000 = H5App.this.TAG;
                        H5Log.d(access$000, "pre install app : " + H5App.this.appInfo.app_id + " getLastPkgPath:" + access$500);
                        if (!TextUtils.isEmpty(access$500)) {
                            H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
                            if (h5AppProvider != null) {
                                String version = h5AppProvider.getVersion(H5App.this.appInfo.app_id);
                                if (H5AppUtil.compareVersion(version, H5App.this.appInfo.version) == 1) {
                                    String access$0002 = H5App.this.TAG;
                                    H5Log.d(access$0002, "currentVersion " + version + " > appInfo.version:" + H5App.this.appInfo.version + " not to preInstall");
                                    H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
                                    if (h5ConfigProvider != null && !"no".equalsIgnoreCase(h5ConfigProvider.getConfigWithProcessCache("h5_preInstall_compare_version"))) {
                                        return;
                                    }
                                }
                            }
                            boolean unused = H5App.this.preInstall = true;
                            H5App.this.installApp();
                            return;
                        }
                        H5AppUtil.broadcastForH5Download(H5App.this.getAppId(), H5App.this.getAppVersion());
                    }
                });
            } else {
                H5Utils.executeOrdered(H5NebulaApp, new Runnable() {
                    public void run() {
                        boolean unused = H5App.this.preInstall = true;
                        H5App.this.installApp();
                    }
                });
            }
        }
    }

    private boolean disableAllPreInstall() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        return h5ConfigProvider != null && "no".equalsIgnoreCase(h5ConfigProvider.getConfigWithProcessCache("h5_enableAllPreInstall"));
    }

    public boolean installApp() {
        boolean z;
        if (isPkgAvailable()) {
            z = installApp(getDownloadedFilePath());
        } else {
            z = isInstalled();
        }
        if (this.appInfo != null) {
            String str = this.TAG;
            H5Log.d(str, "installApp appId:" + this.appInfo.app_id + " version:" + this.appInfo.version + " " + z);
        }
        return z;
    }

    public boolean installApp(H5AppInstallListen h5AppInstallListen) {
        boolean installApp = installApp();
        if (h5AppInstallListen != null) {
            h5AppInstallListen.getResult(installApp, this.h5PatchFail);
        }
        return installApp;
    }

    public boolean installApp(boolean z) {
        this.asyncInstall = z;
        return installApp();
    }

    public void presetAppPackage(InputStream inputStream, boolean z) {
        if (presetH5pkg(inputStream, getInstalledPath())) {
            onInstallComplete(true);
        }
    }

    public void presetApp(InputStream inputStream, H5LoadPresetListen h5LoadPresetListen) {
        String installedPath = getInstalledPath();
        boolean presetH5pkg = presetH5pkg(inputStream, installedPath);
        if (h5LoadPresetListen != null) {
            String str = this.TAG;
            H5Log.d(str, "presetApp " + presetH5pkg + " " + installedPath);
            if (presetH5pkg) {
                onInstallComplete(true);
                h5LoadPresetListen.getPresetPath(installedPath);
                return;
            }
            h5LoadPresetListen.getPresetPath((String) null);
        }
    }

    public boolean presetH5pkg(InputStream inputStream, String str) {
        try {
            H5Monitor.behavior(new H5MonitorModel().start().appendSubappId(this.appInfo.app_id).appendPackageVersion(this.appInfo.version).seedId(H5MonitorModel.SEED_ID_OFFLINE_UNZIP));
            long currentTimeMillis = System.currentTimeMillis();
            if (H5FileUtil.exists(new File(str))) {
                String str2 = this.TAG;
                H5Log.e(str2, str + " presetAppPackage has exits,not to unzip");
                H5Monitor.behavior(new H5MonitorModel().success().appendSubappId(this.appInfo.app_id).appendPackageVersion(this.appInfo.version).seedId(H5MonitorModel.SEED_ID_OFFLINE_UNZIP).appendCostTime(System.currentTimeMillis() - currentTimeMillis));
                return true;
            } else if (!H5ZipUtil.unZip(inputStream, str)) {
                H5FileUtil.delete(str);
                H5Log.e(this.TAG, "unzip preset failed");
                H5Monitor.exception(new H5MonitorModel().fail().appendSubappId(this.appInfo.app_id).appendPackageVersion(this.appInfo.version).appendMessage("unzip preset failed").exceptionType(H5MonitorModel.EXCEPTION_OFFLINE_UNZIP).appendExtParams("destPath", str));
                closeStream(inputStream);
                return false;
            } else {
                H5Monitor.behavior(new H5MonitorModel().success().appendSubappId(this.appInfo.app_id).appendPackageVersion(this.appInfo.version).seedId(H5MonitorModel.SEED_ID_OFFLINE_UNZIP).appendCostTime(System.currentTimeMillis() - currentTimeMillis));
                closeStream(inputStream);
                return true;
            }
        } catch (Exception e2) {
            H5Log.e(this.TAG, (Throwable) e2);
            H5FileUtil.delete(str);
            return false;
        } finally {
            closeStream(inputStream);
        }
    }

    private void closeStream(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e2) {
                H5Log.e(this.TAG, (Throwable) e2);
            }
        }
    }

    private String getFileName(String str) {
        if (!TextUtils.isEmpty(str)) {
            return H5SecurityUtil.getMD5(str);
        }
        return getAppVersion();
    }

    private String getDownLoadFileName() {
        return getAppId() + "-" + getFileName(this.appInfo.package_url);
    }

    public String getDownloadedFilePath() {
        String defaultDownloadDir = H5DownloadRequest.getDefaultDownloadDir(H5Utils.getContext());
        if (TextUtils.isEmpty(defaultDownloadDir) || "/".equals(defaultDownloadDir)) {
            return "";
        }
        String str = defaultDownloadDir + "/" + getDownLoadFileName();
        H5Log.d(this.TAG, "downloadedFilePath:".concat(String.valueOf(str)));
        return str;
    }

    public boolean isPkgAvailable() {
        String downloadedFilePath = getDownloadedFilePath();
        boolean exists = H5FileUtil.exists(downloadedFilePath);
        String str = this.TAG;
        H5Log.d(str, "isPkgAvailable: path:" + downloadedFilePath + " isAvailable:" + exists);
        return exists;
    }

    public boolean isInstalled() {
        if (this.appInfo == null) {
            return false;
        }
        File file = new File(getInstalledPath());
        H5Log.d(this.TAG, "isInstalled: " + file.exists() + " appId:" + this.appInfo.app_id + " version:" + this.appInfo.version);
        if (file.exists()) {
            try {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    int length = listFiles.length;
                    H5Log.d(this.TAG, "isInstalled length:".concat(String.valueOf(length)));
                    if (length < 4) {
                        String str = "";
                        boolean z = false;
                        for (File name : listFiles) {
                            String name2 = name.getName();
                            H5Log.d(this.TAG, "install dir file ".concat(String.valueOf(name2)));
                            str = str + "_" + name2;
                            if (name2.contains("tar")) {
                                z = true;
                            }
                        }
                        H5LogProvider h5LogProvider = (H5LogProvider) H5Utils.getProvider(H5LogProvider.class.getName());
                        if (h5LogProvider != null) {
                            h5LogProvider.log("h5_nebulaApp_intallApp_exception", getAppId(), getAppVersion(), str, (String) null);
                        }
                        if (!H5Utils.isMain()) {
                            H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
                            if (h5ConfigProvider != null && !"no".equalsIgnoreCase(h5ConfigProvider.getConfig("h5_delete_installAppFile")) && H5AppUtil.isH5AppPkg(this.appInfo) && !z) {
                                H5AppUtil.deleteNebulaInstallFileAndDB(file.getAbsolutePath(), this.appInfo.app_id);
                                H5Log.d(this.TAG, "install file is broken delete return notInstall");
                                return false;
                            }
                        } else {
                            H5Log.d(this.TAG, "in Main thread not delete");
                        }
                    }
                    return true;
                }
            } catch (Exception e2) {
                H5Log.e(this.TAG, (Throwable) e2);
            }
        }
        return false;
    }

    public String getInstalledPath() {
        if (this.appInfo == null) {
            return "";
        }
        String str = this.appsPath + getInstallFileName();
        H5Log.d(this.TAG, "getInstalledPath:".concat(String.valueOf(str)));
        return str;
    }

    private String getInstallFileName() {
        return getAppId() + "/" + getFileName(this.appInfo.package_url) + "/";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x02dd, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean installApp(java.lang.String... r15) {
        /*
            r14 = this;
            monitor-enter(r14)
            r0 = 0
            r1 = 0
            com.alipay.mobile.nebula.appcenter.model.AppInfo r2 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            if (r2 != 0) goto L_0x0009
            monitor-exit(r14)
            return r1
        L_0x0009:
            if (r15 == 0) goto L_0x001f
            int r2 = r15.length     // Catch:{ Exception -> 0x02af }
            if (r2 <= 0) goto L_0x001f
            r0 = r15[r1]     // Catch:{ Exception -> 0x02af }
            java.lang.String r15 = r14.TAG     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "installApp filePath:"
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = r2.concat(r3)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.H5Log.d(r15, r2)     // Catch:{ Exception -> 0x02af }
        L_0x001f:
            boolean r15 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x02af }
            if (r15 != 0) goto L_0x02dc
            java.io.File r15 = new java.io.File     // Catch:{ Exception -> 0x02af }
            r15.<init>(r0)     // Catch:{ Exception -> 0x02af }
            boolean r2 = r15.exists()     // Catch:{ Exception -> 0x02af }
            if (r2 != 0) goto L_0x0039
            java.lang.String r15 = r14.TAG     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "installApp !file.exists()"
            com.alipay.mobile.nebula.util.H5Log.d(r15, r2)     // Catch:{ Exception -> 0x02af }
            monitor-exit(r14)
            return r1
        L_0x0039:
            boolean r2 = r14.isInstalled()     // Catch:{ Exception -> 0x02af }
            r3 = 1
            if (r2 == 0) goto L_0x0049
            java.lang.String r15 = r14.TAG     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "is install return"
            com.alipay.mobile.nebula.util.H5Log.d(r15, r2)     // Catch:{ Exception -> 0x02af }
            monitor-exit(r14)
            return r3
        L_0x0049:
            com.alipay.mobile.nebula.appcenter.model.AppInfo r2 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = r2.patch     // Catch:{ Exception -> 0x02af }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x02af }
            if (r2 == 0) goto L_0x0160
            java.lang.String r2 = "H5_APP_UNZIP"
            com.alipay.mobile.nebula.appcenter.model.AppInfo r4 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = "^step=start^isPatch=no"
            com.alipay.mobile.nebula.appcenter.util.H5AppUtil.appCenterLog(r2, r4, r5)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel     // Catch:{ Exception -> 0x02af }
            r2.<init>()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.start()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r4 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r4 = r4.app_id     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.appendSubappId(r4)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r4 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r4 = r4.version     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.appendPackageVersion(r4)     // Catch:{ Exception -> 0x02af }
            java.lang.String r4 = "H5_CONTAINER_OFFLINE_UNZIP"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.seedId(r4)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r2)     // Catch:{ Exception -> 0x02af }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r2 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = r2.app_id     // Catch:{ Exception -> 0x02af }
            r14.deleteOldPkgByFullInstall(r2)     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = r14.getInstalledPath()     // Catch:{ Exception -> 0x02af }
            boolean r2 = com.alipay.mobile.nebula.util.H5ZipUtil.unZip((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x02af }
            java.lang.String r6 = r14.TAG     // Catch:{ Exception -> 0x02af }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02af }
            r7.<init>()     // Catch:{ Exception -> 0x02af }
            java.lang.String r8 = r14.getAppId()     // Catch:{ Exception -> 0x02af }
            r7.append(r8)     // Catch:{ Exception -> 0x02af }
            java.lang.String r8 = " installApp spend unzip "
            r7.append(r8)     // Catch:{ Exception -> 0x02af }
            long r8 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02af }
            long r8 = r8 - r4
            r7.append(r8)     // Catch:{ Exception -> 0x02af }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.H5Log.d(r6, r7)     // Catch:{ Exception -> 0x02af }
            if (r2 == 0) goto L_0x00f8
            boolean r2 = r14.isInstalled()     // Catch:{ Exception -> 0x02af }
            if (r2 != 0) goto L_0x00bc
            goto L_0x00f8
        L_0x00bc:
            com.alipay.mobile.nebula.util.H5FileUtil.delete((java.io.File) r15)     // Catch:{ Exception -> 0x02af }
            r14.onInstallComplete(r3)     // Catch:{ Exception -> 0x02af }
            java.lang.String r15 = "H5_APP_UNZIP"
            com.alipay.mobile.nebula.appcenter.model.AppInfo r2 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r6 = "^step=success^isPatch=no"
            com.alipay.mobile.nebula.appcenter.util.H5AppUtil.appCenterLog(r15, r2, r6)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel     // Catch:{ Exception -> 0x02af }
            r15.<init>()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.success()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r2 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = r2.version     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendPackageVersion(r2)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r2 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = r2.app_id     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendSubappId(r2)     // Catch:{ Exception -> 0x02af }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02af }
            long r6 = r6 - r4
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendCostTime(r6)     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "H5_CONTAINER_OFFLINE_UNZIP"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.seedId(r2)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r15)     // Catch:{ Exception -> 0x02af }
            monitor-exit(r14)
            return r3
        L_0x00f8:
            java.lang.String r2 = ""
            java.lang.String r2 = com.alipay.mobile.nebula.util.H5SecurityUtil.getFileMd5(r0)     // Catch:{ Exception -> 0x0112 }
            java.lang.String r3 = r14.TAG     // Catch:{ Exception -> 0x0112 }
            java.lang.String r4 = "H5_APP_UNZIP fail"
            com.alipay.mobile.nebula.util.H5Log.d(r3, r4)     // Catch:{ Exception -> 0x0112 }
            com.alipay.mobile.nebula.util.H5FileUtil.delete((java.io.File) r15)     // Catch:{ Exception -> 0x0112 }
            java.lang.String r15 = "H5_APP_UNZIP"
            com.alipay.mobile.nebula.appcenter.model.AppInfo r3 = r14.appInfo     // Catch:{ Exception -> 0x0112 }
            java.lang.String r4 = "^step=fail^isPatch=no"
            com.alipay.mobile.nebula.appcenter.util.H5AppUtil.appCenterLog(r15, r3, r4)     // Catch:{ Exception -> 0x0112 }
            goto L_0x011a
        L_0x0112:
            r15 = move-exception
            java.lang.String r3 = r14.TAG     // Catch:{ Exception -> 0x02af }
            java.lang.String r4 = "installApp delete exception"
            com.alipay.mobile.nebula.util.H5Log.e(r3, r4, r15)     // Catch:{ Exception -> 0x02af }
        L_0x011a:
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel     // Catch:{ Exception -> 0x02af }
            r15.<init>()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.fail()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r3 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r3 = r3.app_id     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendSubappId(r3)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r3 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r3 = r3.version     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendPackageVersion(r3)     // Catch:{ Exception -> 0x02af }
            java.lang.String r3 = "ContainerOfflineUnzipFail"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.exceptionType(r3)     // Catch:{ Exception -> 0x02af }
            java.lang.String r3 = "unzip failed"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendMessage(r3)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendMd5(r2)     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "filePath"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendExtParams(r2, r0)     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "destPath"
            java.lang.String r3 = r14.getInstalledPath()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendExtParams(r2, r3)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r15)     // Catch:{ Exception -> 0x02af }
            java.lang.String r15 = r14.TAG     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "installApp !unZipResult || !isInstalled() return false"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r15, (java.lang.String) r2)     // Catch:{ Exception -> 0x02af }
            monitor-exit(r14)
            return r1
        L_0x0160:
            java.lang.String r2 = "H5_APP_UNZIP"
            com.alipay.mobile.nebula.appcenter.model.AppInfo r4 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r5 = "^step=start^isPatch=yes"
            com.alipay.mobile.nebula.appcenter.util.H5AppUtil.appCenterLog(r2, r4, r5)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel     // Catch:{ Exception -> 0x02af }
            r2.<init>()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.start()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r4 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r4 = r4.app_id     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.appendSubappId(r4)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r4 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r4 = r4.version     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.appendPackageVersion(r4)     // Catch:{ Exception -> 0x02af }
            java.lang.String r4 = "H5_CONTAINER_OFFLINE_UNZIP"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.seedId(r4)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r2)     // Catch:{ Exception -> 0x02af }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = r14.TAG     // Catch:{ Exception -> 0x02af }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x02af }
            java.lang.String r7 = "h5App patcher update. appId: "
            r6.<init>(r7)     // Catch:{ Exception -> 0x02af }
            java.lang.String r7 = r14.getAppId()     // Catch:{ Exception -> 0x02af }
            r6.append(r7)     // Catch:{ Exception -> 0x02af }
            java.lang.String r7 = "; filePath = "
            r6.append(r7)     // Catch:{ Exception -> 0x02af }
            r6.append(r0)     // Catch:{ Exception -> 0x02af }
            java.lang.String r7 = " patch:"
            r6.append(r7)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r7 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r7 = r7.patch     // Catch:{ Exception -> 0x02af }
            r6.append(r7)     // Catch:{ Exception -> 0x02af }
            java.lang.String r6 = r6.toString()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.H5Log.d(r2, r6)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r2 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = r2.app_id     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = r14.getLastPkgPath(r2)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r6 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r6 = r6.app_id     // Catch:{ Exception -> 0x02af }
            boolean r6 = r14.patchH5File(r0, r6, r2)     // Catch:{ Exception -> 0x02af }
            r14.h5PatchFail = r6     // Catch:{ Exception -> 0x02af }
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r7 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r7 = r7.getName()     // Catch:{ Exception -> 0x02af }
            java.lang.Object r7 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r7)     // Catch:{ Exception -> 0x02af }
            r8 = r7
            com.alipay.mobile.nebula.provider.H5LogProvider r8 = (com.alipay.mobile.nebula.provider.H5LogProvider) r8     // Catch:{ Exception -> 0x02af }
            if (r8 == 0) goto L_0x01f4
            java.lang.String r9 = "h5_nebulaApp_installApp_patch"
            java.lang.String r10 = r14.getAppId()     // Catch:{ Exception -> 0x02af }
            java.lang.String r11 = r14.getAppVersion()     // Catch:{ Exception -> 0x02af }
            java.lang.String r7 = "success="
            java.lang.String r12 = java.lang.String.valueOf(r6)     // Catch:{ Exception -> 0x02af }
            java.lang.String r12 = r7.concat(r12)     // Catch:{ Exception -> 0x02af }
            r13 = 0
            r8.log(r9, r10, r11, r12, r13)     // Catch:{ Exception -> 0x02af }
        L_0x01f4:
            if (r6 != 0) goto L_0x026e
            com.alipay.mobile.nebula.appcenter.model.AppInfo r15 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r15 = r15.app_id     // Catch:{ Exception -> 0x02af }
            r14.deleteOldPkgByFullInstall(r15)     // Catch:{ Exception -> 0x02af }
            java.lang.String r15 = ""
            java.lang.String r15 = com.alipay.mobile.nebula.util.H5SecurityUtil.getFileMd5(r0)     // Catch:{ Exception -> 0x0204 }
            goto L_0x020c
        L_0x0204:
            r2 = move-exception
            java.lang.String r3 = r14.TAG     // Catch:{ Exception -> 0x02af }
            java.lang.String r4 = "compute md5 failed"
            com.alipay.mobile.nebula.util.H5Log.e(r3, r4, r2)     // Catch:{ Exception -> 0x02af }
        L_0x020c:
            com.alipay.mobile.nebula.util.H5FileUtil.delete((java.lang.String) r0)     // Catch:{ Exception -> 0x02af }
            r14.clearPatchDBInfo()     // Catch:{ Exception -> 0x02af }
            boolean r2 = r14.preInstall     // Catch:{ Exception -> 0x02af }
            if (r2 == 0) goto L_0x021c
            boolean r2 = com.alipay.mobile.nebula.util.H5Utils.isInWifi()     // Catch:{ Exception -> 0x02af }
            if (r2 == 0) goto L_0x021f
        L_0x021c:
            r14.doDownloadApp()     // Catch:{ Exception -> 0x02af }
        L_0x021f:
            java.lang.String r2 = r14.TAG     // Catch:{ Exception -> 0x02af }
            java.lang.String r3 = "installApp !patcherResult return false"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "H5_APP_UNZIP"
            com.alipay.mobile.nebula.appcenter.model.AppInfo r3 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r4 = "^step=fail^isPatch=yes"
            com.alipay.mobile.nebula.appcenter.util.H5AppUtil.appCenterLog(r2, r3, r4)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel     // Catch:{ Exception -> 0x02af }
            r2.<init>()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.fail()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r3 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r3 = r3.app_id     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.appendSubappId(r3)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r3 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r3 = r3.version     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.appendPackageVersion(r3)     // Catch:{ Exception -> 0x02af }
            java.lang.String r3 = "unzip patch failed"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.appendMessage(r3)     // Catch:{ Exception -> 0x02af }
            java.lang.String r3 = "ContainerOfflineUnzipFail"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r2 = r2.exceptionType(r3)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r2.appendMd5(r15)     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "filePath"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendExtParams(r2, r0)     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "destPath"
            java.lang.String r3 = r14.getInstalledPath()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendExtParams(r2, r3)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5Monitor.exception(r15)     // Catch:{ Exception -> 0x02af }
            monitor-exit(r14)
            return r1
        L_0x026e:
            com.alipay.mobile.nebula.util.H5FileUtil.delete((java.io.File) r15)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.H5FileUtil.delete((java.lang.String) r2)     // Catch:{ Exception -> 0x02af }
            r14.onInstallComplete(r3)     // Catch:{ Exception -> 0x02af }
            java.lang.String r15 = "H5_APP_UNZIP"
            com.alipay.mobile.nebula.appcenter.model.AppInfo r2 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r6 = "^step=success^isPatch=yes"
            com.alipay.mobile.nebula.appcenter.util.H5AppUtil.appCenterLog(r15, r2, r6)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = new com.alipay.mobile.nebula.util.monitor.H5MonitorModel     // Catch:{ Exception -> 0x02af }
            r15.<init>()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.success()     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r2 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = r2.version     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendPackageVersion(r2)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r2 = r14.appInfo     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = r2.app_id     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendSubappId(r2)     // Catch:{ Exception -> 0x02af }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x02af }
            long r6 = r6 - r4
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.appendCostTime(r6)     // Catch:{ Exception -> 0x02af }
            java.lang.String r2 = "H5_CONTAINER_OFFLINE_UNZIP"
            com.alipay.mobile.nebula.util.monitor.H5MonitorModel r15 = r15.seedId(r2)     // Catch:{ Exception -> 0x02af }
            com.alipay.mobile.nebula.util.monitor.H5Monitor.behavior(r15)     // Catch:{ Exception -> 0x02af }
            monitor-exit(r14)
            return r3
        L_0x02ad:
            r15 = move-exception
            goto L_0x02de
        L_0x02af:
            r15 = move-exception
            java.lang.String r2 = r14.TAG     // Catch:{ all -> 0x02ad }
            java.lang.String r3 = "error"
            com.alipay.mobile.nebula.util.H5Log.e(r2, r3, r15)     // Catch:{ all -> 0x02ad }
            java.lang.String r15 = r14.getInstalledPath()     // Catch:{ all -> 0x02ad }
            com.alipay.mobile.nebula.util.H5FileUtil.delete((java.lang.String) r15)     // Catch:{ all -> 0x02ad }
            com.alipay.mobile.nebula.util.H5FileUtil.delete((java.lang.String) r0)     // Catch:{ all -> 0x02ad }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r15 = r14.appInfo     // Catch:{ all -> 0x02ad }
            java.lang.String r15 = r15.patch     // Catch:{ all -> 0x02ad }
            boolean r15 = android.text.TextUtils.isEmpty(r15)     // Catch:{ all -> 0x02ad }
            if (r15 != 0) goto L_0x02d9
            java.lang.String r15 = r14.TAG     // Catch:{ all -> 0x02ad }
            java.lang.String r0 = "h5App patcher fail And downloadAll start."
            com.alipay.mobile.nebula.util.H5Log.d(r15, r0)     // Catch:{ all -> 0x02ad }
            r14.clearPatchDBInfo()     // Catch:{ all -> 0x02ad }
            r14.downloadApp()     // Catch:{ all -> 0x02ad }
            goto L_0x02dc
        L_0x02d9:
            r14.onInstallComplete(r1)     // Catch:{ all -> 0x02ad }
        L_0x02dc:
            monitor-exit(r14)
            return r1
        L_0x02de:
            monitor-exit(r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulaappcenter.app.H5App.installApp(java.lang.String[]):boolean");
    }

    private void clearPatchDBInfo() {
        H5Log.d(this.TAG, "clearPatchDBInfo ");
        AppInfo appInfo2 = this.appInfo;
        appInfo2.patch = "";
        H5NebulaDBService h5NebulaDBService = this.h5AppDBService;
        if (h5NebulaDBService != null) {
            h5NebulaDBService.saveAppInfo(appInfo2, true);
        }
    }

    public final void downloadApp() {
        setWalletPreset();
        if (this.downloadCallback != null) {
            if (isPkgAvailable() || isInstalled()) {
                this.downloadCallback.onFinish(getDownLoadRequest(), getDownloadedFilePath());
                return;
            } else if (isDownloading()) {
                this.downloadCallback.onCancel(getDownLoadRequest());
                return;
            }
        } else if (isPkgAvailable() || isInstalled() || isDownloading()) {
            return;
        }
        doDownloadApp();
    }

    public void downloadApp(H5DownloadCallback h5DownloadCallback) {
        downloadApp(h5DownloadCallback, (String) null);
    }

    public void downloadApp(H5DownloadCallback h5DownloadCallback, String str) {
        this.downloadCallback = h5DownloadCallback;
        this.downloadScene = str;
        downloadApp();
    }

    private void setWalletPreset() {
        H5AppCenterPresetProvider h5AppCenterPresetProvider = (H5AppCenterPresetProvider) H5Utils.getProvider(H5AppCenterPresetProvider.class.getName());
        if (h5AppCenterPresetProvider != null && h5AppCenterPresetProvider.getH5PresetPkg() != null) {
            try {
                H5PresetPkg h5PresetPkg = h5AppCenterPresetProvider.getH5PresetPkg();
                if (h5PresetPkg.getPreSetInfo() != null && h5PresetPkg.getPreSetInfo().containsKey(getAppId()) && !isInstalled()) {
                    H5PresetInfo h5PresetInfo = h5PresetPkg.getPreSetInfo().get(getAppId());
                    String str = h5PresetInfo.appId;
                    String str2 = h5PresetInfo.version;
                    String str3 = this.TAG;
                    H5Log.d(str3, "setWalletPreset getPreSetInfo  " + str + " " + str2);
                    if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && TextUtils.equals(str2, getAppVersion())) {
                        AssetManager assets = this.context.getAssets();
                        InputStream open = assets.open(h5PresetPkg.getPresetPath() + str);
                        if (open != null) {
                            String str4 = this.TAG;
                            H5Log.d(str4, "setWalletPreset " + getAppId() + " " + getAppVersion());
                            presetAppPackage(open, true);
                        }
                    }
                }
            } catch (Exception e2) {
                H5Log.e(this.TAG, "setWalletPreset not exist", e2);
            }
        }
    }

    public boolean isDownloading() {
        if (this.h5ExternalDownloadManager == null) {
            H5Log.e(this.TAG, "isDownloading h5ExternalDownloadManager==null");
        }
        H5ExternalDownloadManager h5ExternalDownloadManager2 = this.h5ExternalDownloadManager;
        return h5ExternalDownloadManager2 != null && h5ExternalDownloadManager2.isDownloading(getDownloadUrl());
    }

    private void deleteOldPkgByFullInstall(String str) {
        String str2 = this.appsPath + str + "/";
        if (H5FileUtil.exists(str2)) {
            H5Log.d(this.TAG, "deleteOldPkgByFullInstall ".concat(String.valueOf(str2)));
            H5FileUtil.delete(str2);
        }
    }

    /* access modifiers changed from: private */
    public String getLastPkgPath(String str) {
        AppInfo appInfo2;
        String findInstallAppVersion = this.h5AppDBService.findInstallAppVersion(str);
        if (!TextUtils.isEmpty(findInstallAppVersion) && !TextUtils.isEmpty(str) && !findInstallAppVersion.equals(getAppVersion()) && (appInfo2 = this.h5AppDBService.getAppInfo(str, findInstallAppVersion)) != null) {
            H5App h5App = new H5App();
            h5App.setAppInfo(appInfo2);
            String installedPath = h5App.getInstalledPath();
            if (H5FileUtil.exists(installedPath)) {
                String str2 = this.TAG;
                H5Log.d(str2, "lastInstallPath:" + installedPath + " lastVersion:" + appInfo2.version);
                return installedPath;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0076, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009d, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onInstallComplete(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            com.alipay.mobile.nebula.appcenter.model.AppInfo r0 = r3.appInfo     // Catch:{ all -> 0x009e }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            java.lang.String r0 = r3.TAG     // Catch:{ all -> 0x009e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x009e }
            java.lang.String r2 = "onInstallComplete:"
            r1.<init>(r2)     // Catch:{ all -> 0x009e }
            r1.append(r4)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = " version:"
            r1.append(r2)     // Catch:{ all -> 0x009e }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r2 = r3.appInfo     // Catch:{ all -> 0x009e }
            java.lang.String r2 = r2.version     // Catch:{ all -> 0x009e }
            r1.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r2 = " appId:"
            r1.append(r2)     // Catch:{ all -> 0x009e }
            com.alipay.mobile.nebula.appcenter.model.AppInfo r2 = r3.appInfo     // Catch:{ all -> 0x009e }
            java.lang.String r2 = r2.app_id     // Catch:{ all -> 0x009e }
            r1.append(r2)     // Catch:{ all -> 0x009e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x009e }
            com.alipay.mobile.nebula.util.H5Log.d(r0, r1)     // Catch:{ all -> 0x009e }
            if (r4 == 0) goto L_0x009c
            boolean r4 = r3.asyncInstall     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x0077
            java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r4 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
            java.lang.String r4 = r4.getName()     // Catch:{ all -> 0x0094 }
            java.lang.Object r4 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r4)     // Catch:{ all -> 0x0094 }
            com.alipay.mobile.nebula.provider.H5ConfigProvider r4 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r4     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x0075
            java.lang.String r0 = "H5_async_install"
            java.lang.String r4 = r4.getConfigWithProcessCache(r0)     // Catch:{ all -> 0x0094 }
            java.lang.String r0 = "no"
            boolean r4 = r0.equalsIgnoreCase(r4)     // Catch:{ all -> 0x0094 }
            if (r4 == 0) goto L_0x0067
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r4 = r3.h5AppDBService     // Catch:{ all -> 0x0094 }
            java.lang.String r0 = r3.getAppId()     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = r3.getAppVersion()     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = r3.getInstalledPath()     // Catch:{ all -> 0x0094 }
            r4.insertInstalledAppInfo(r0, r1, r2)     // Catch:{ all -> 0x0094 }
            monitor-exit(r3)
            return
        L_0x0067:
            java.lang.String r4 = "IO"
            java.util.concurrent.ThreadPoolExecutor r4 = com.alipay.mobile.nebula.util.H5Utils.getExecutor(r4)     // Catch:{ all -> 0x0094 }
            com.alipay.mobile.nebulaappcenter.app.H5App$4 r0 = new com.alipay.mobile.nebulaappcenter.app.H5App$4     // Catch:{ all -> 0x0094 }
            r0.<init>()     // Catch:{ all -> 0x0094 }
            r4.execute(r0)     // Catch:{ all -> 0x0094 }
        L_0x0075:
            monitor-exit(r3)
            return
        L_0x0077:
            com.alipay.mobile.nebulaappcenter.app.H5NebulaDBService r4 = r3.h5AppDBService     // Catch:{ all -> 0x0094 }
            java.lang.String r0 = r3.getAppId()     // Catch:{ all -> 0x0094 }
            java.lang.String r1 = r3.getAppVersion()     // Catch:{ all -> 0x0094 }
            java.lang.String r2 = r3.getInstalledPath()     // Catch:{ all -> 0x0094 }
            r4.insertInstalledAppInfo(r0, r1, r2)     // Catch:{ all -> 0x0094 }
            java.lang.String r4 = r3.getAppId()     // Catch:{ all -> 0x0094 }
            java.lang.String r0 = r3.getAppVersion()     // Catch:{ all -> 0x0094 }
            com.alipay.mobile.nebula.appcenter.util.H5AppUtil.broadcastForH5Install(r4, r0)     // Catch:{ all -> 0x0094 }
            goto L_0x009c
        L_0x0094:
            r4 = move-exception
            java.lang.String r0 = r3.TAG     // Catch:{ all -> 0x009e }
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.Throwable) r4)     // Catch:{ all -> 0x009e }
            monitor-exit(r3)
            return
        L_0x009c:
            monitor-exit(r3)
            return
        L_0x009e:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulaappcenter.app.H5App.onInstallComplete(boolean):void");
    }

    private boolean patchH5File(String str, String str2, String str3) throws Exception {
        String str4;
        String str5;
        boolean z = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) {
            return false;
        }
        File file = new File(str);
        String str6 = H5DownloadRequest.getDefaultDownloadDir(H5Utils.getContext()) + "/" + getAppId() + "_patch/";
        if (H5ZipUtil.unZip(str, str6)) {
            String str7 = str6 + "/patch";
            e parseObject = H5Utils.parseObject(loadJsonFromFile(str6 + "/md5.json"));
            if (parseObject == null || parseObject.isEmpty()) {
                str5 = "";
                str4 = str5;
            } else {
                String string = H5Utils.getString(parseObject, "old");
                str4 = H5Utils.getString(parseObject, "patch");
                str5 = string;
            }
            H5Log.d(this.TAG, "oldMd5 : " + str5 + ", patchMd5: " + str4);
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str4)) {
                H5PatchProvider h5PatchProvider = (H5PatchProvider) H5Utils.getProvider(H5PatchProvider.class.getName());
                if (h5PatchProvider != null) {
                    z = h5PatchProvider.patcherDir(this.context, getInstalledPath(), str3, str7, str5, str4);
                } else {
                    H5Log.e(this.TAG, "h5PatchProvider==null , setProvider for H5PatchProvider");
                }
                H5Log.d(this.TAG, "patcherResult :" + z + " appId:" + str2 + " version:" + this.appInfo.version);
                H5FileUtil.delete(str6);
            }
            return z;
        }
        H5FileUtil.delete(str6);
        H5FileUtil.delete(file);
        throw new Exception();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        com.alipay.mobile.nebula.util.H5Log.e(r5.TAG, (java.lang.Throwable) r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        com.alipay.mobile.nebula.util.H5Log.d(r5.TAG, r6.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x002a, code lost:
        r6 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c A[ExcHandler: FileNotFoundException (r6v2 'e' java.io.FileNotFoundException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.lang.String loadJsonFromFile(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0031 }
            r1.<init>(r6)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0031 }
            java.io.BufferedReader r6 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0031 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0031 }
            r2.<init>(r1)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0031 }
            r6.<init>(r2)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0031 }
            r2 = 1024(0x400, float:1.435E-42)
            char[] r2 = new char[r2]     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0031 }
        L_0x0018:
            int r3 = r6.read(r2)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0031 }
            if (r3 <= 0) goto L_0x0023
            r4 = 0
            r0.append(r2, r4, r3)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0031 }
            goto L_0x0018
        L_0x0023:
            r6.close()     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0031 }
            r1.close()     // Catch:{ IOException -> 0x002a, FileNotFoundException -> 0x003c }
            goto L_0x0046
        L_0x002a:
            r6 = move-exception
            java.lang.String r1 = r5.TAG     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0031 }
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r1, (java.lang.Throwable) r6)     // Catch:{ FileNotFoundException -> 0x003c, IOException -> 0x0031 }
            goto L_0x0046
        L_0x0031:
            r6 = move-exception
            java.lang.String r1 = r5.TAG
            java.lang.String r6 = r6.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r1, r6)
            goto L_0x0046
        L_0x003c:
            r6 = move-exception
            java.lang.String r1 = r5.TAG
            java.lang.String r6 = r6.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r1, r6)
        L_0x0046:
            java.lang.String r6 = r0.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulaappcenter.app.H5App.loadJsonFromFile(java.lang.String):java.lang.String");
    }

    public boolean isAvailable() {
        return isInstalled() || isPkgAvailable();
    }
}
