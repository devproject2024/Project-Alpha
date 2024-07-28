package com.alipay.mobile.nebula.appcenter.apphandler;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.a.b;
import com.alipay.mobile.h5container.api.H5PageData;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.H5EventHandlerService;
import com.alipay.mobile.nebula.appcenter.api.H5AppInstallListen;
import com.alipay.mobile.nebula.appcenter.apphandler.loadingview.H5LoadingManager;
import com.alipay.mobile.nebula.appcenter.apphandler.loadingview.H5LoadingTypeListen;
import com.alipay.mobile.nebula.appcenter.apphandler.loadingview.H5LoadingUtil;
import com.alipay.mobile.nebula.appcenter.apphandler.loadingview.H5LoadingViewImpl;
import com.alipay.mobile.nebula.appcenter.apphandler.loadingview.H5NebulaAppCacheManager;
import com.alipay.mobile.nebula.appcenter.appsync.H5NbOfflineType;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadCallback;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadRequest;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.appcenter.model.AppReq;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.appcenter.util.H5LoadingApp;
import com.alipay.mobile.nebula.callback.H5AppInstallProcess;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5FallbackStreamProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.startParam.H5StartParamManager;
import com.alipay.mobile.nebula.tiny.H5TinyFallBackData;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ParamParser;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class H5AppHandler {
    public static final String CHECK_KEY = "nebulaStartflag";
    public static final String CHECK_VALUE = "yes";
    private static final String PERF_IS_LOCAL_KEY = "is_local";
    private static final String PERF_OPENAPP_TIME_KEY = "perf_open_app_time";
    /* access modifiers changed from: private */
    public static String TAG = "H5AppHandler";
    private static final int TIME = 1000;
    private static final String appInfoEmptyUrl = "https://render.alipay.com/p/s/tinyapperror/?appId=%s&errorCode=1001";
    private static final int defaultTime = 30;
    /* access modifiers changed from: private */
    public static String downloadFail = "downloadFail";
    public static H5EventHandlerService h5EventHandlerService = null;
    public static String h5_enablenbhandler = "h5_enablenbhandler";
    /* access modifiers changed from: private */
    public static String installFail = "installFail";
    private static boolean isFirstStartApp = true;
    /* access modifiers changed from: private */
    public static final H5AppPrepareData prepareData = new H5AppPrepareData();
    public static final String sAppIcon = "appIcon";
    public static final String sAppName = "appName";
    /* access modifiers changed from: private */
    public static int waitCount = 0;
    /* access modifiers changed from: private */
    public static int waitMax = 4;

    interface FallBackListen {
        void canGoFallback(boolean z, String str);
    }

    public static boolean hasCheckParam(Bundle bundle) {
        return bundle != null && bundle.containsKey(CHECK_KEY) && TextUtils.equals(bundle.getString(CHECK_KEY), CHECK_VALUE);
    }

    /* access modifiers changed from: private */
    public static void paramParse(Bundle bundle) {
        H5ParamParser.parse(bundle, H5Param.LONG_NB_UPDATE, false);
        H5ParamParser.parse(bundle, H5Param.LONG_NB_OFFLINE, false);
        H5ParamParser.parse(bundle, H5Param.LONG_NB_URL, false);
        H5ParamParser.parse(bundle, "nbversion", false);
        H5ParamParser.parse(bundle, H5Param.LONG_NB_OFFMODE, false);
    }

    private static void getAppStartFromWhere(Bundle bundle) {
        String str = "inner";
        if (bundle != null) {
            boolean z = false;
            try {
                if (bundle.containsKey("startFromExternal")) {
                    Object obj = bundle.get("startFromExternal");
                    if (obj instanceof Boolean) {
                        z = ((Boolean) obj).booleanValue();
                    } else if (obj instanceof String) {
                        z = Boolean.parseBoolean((String) obj);
                    }
                }
                if (z) {
                    str = "outer";
                }
            } catch (Throwable th) {
                H5Log.d(TAG, "throwable is ".concat(String.valueOf(th)));
            }
            bundle.putString("app_startup_type", str);
        }
    }

    private static Bundle setStartParam(String str, String str2, Bundle bundle) {
        if (((H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName())) == null) {
            return null;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString(sAppIcon, str2);
        bundle2.putString("appName", str);
        H5EventHandlerService h5EventHandlerService2 = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
        if (h5EventHandlerService2 != null) {
            int i2 = bundle.getInt(h5EventHandlerService2.getMultiProcessTag());
            H5Log.d(TAG, "lpid ".concat(String.valueOf(i2)));
            if (i2 != 0) {
                bundle2.putInt(h5EventHandlerService2.getMultiProcessTag(), i2);
            }
        }
        return bundle2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:111:0x029e A[SYNTHETIC, Splitter:B:111:0x029e] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0356  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x035d  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0361  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x03e0  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x03fb  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0457 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x04cc  */
    /* JADX WARNING: Removed duplicated region for block: B:191:0x04cf  */
    /* JADX WARNING: Removed duplicated region for block: B:199:0x04f5  */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0507  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0532  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void syncApp(com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppInfo r29) {
        /*
            r7 = r29
        L_0x0002:
            com.alipay.mobile.nebula.appcenter.apphandler.H5AppPrepareData r0 = prepareData
            r0.clear()
            com.alipay.mobile.nebula.appcenter.apphandler.H5AppPrepareData r0 = prepareData
            long r1 = java.lang.System.currentTimeMillis()
            r0.setBeginTime(r1)
            com.alipay.mobile.h5container.service.H5EventHandlerService r0 = h5EventHandlerService
            if (r0 != 0) goto L_0x0022
            java.lang.Class<com.alipay.mobile.h5container.service.H5EventHandlerService> r0 = com.alipay.mobile.h5container.service.H5EventHandlerService.class
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.findServiceByInterface(r0)
            com.alipay.mobile.h5container.service.H5EventHandlerService r0 = (com.alipay.mobile.h5container.service.H5EventHandlerService) r0
            h5EventHandlerService = r0
        L_0x0022:
            java.lang.Class<com.alipay.mobile.nebula.provider.H5AppProvider> r0 = com.alipay.mobile.nebula.provider.H5AppProvider.class
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r0)
            r12 = r0
            com.alipay.mobile.nebula.provider.H5AppProvider r12 = (com.alipay.mobile.nebula.provider.H5AppProvider) r12
            if (r12 != 0) goto L_0x0032
            return
        L_0x0032:
            java.lang.String r0 = r7.targetAppId
            boolean r0 = com.alipay.mobile.nebula.appcenter.util.H5AppUtil.isOffLine(r0)
            if (r0 == 0) goto L_0x0042
            java.lang.String r0 = r7.targetAppId
            android.os.Bundle r1 = r7.params
            r12.showOfflinePage(r0, r1)
            return
        L_0x0042:
            r1 = 0
            waitCount = r1
            android.os.Bundle r0 = r7.params
            getAppStartFromWhere(r0)
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            android.os.Bundle r2 = r7.params
            if (r2 == 0) goto L_0x005b
            android.os.Bundle r0 = r7.params
            java.lang.Object r0 = r0.clone()
            android.os.Bundle r0 = (android.os.Bundle) r0
        L_0x005b:
            r13 = r0
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r0 = r7.targetAppId
            java.lang.String r4 = r12.getVersion(r0)
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r2
            java.lang.String r0 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r7.targetAppId
            r2.append(r3)
            java.lang.String r3 = " getVersion "
            r2.append(r3)
            r2.append(r4)
            java.lang.String r3 = " cost:"
            r2.append(r3)
            r2.append(r5)
            java.lang.String r2 = r2.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r0, r2)
            com.alipay.mobile.nebula.appcenter.apphandler.H5AppPrepareData r0 = prepareData
            r0.setGetDBVersionTime(r5)
            java.lang.String r0 = r7.targetAppId
            com.alipay.mobile.nebula.appcenter.model.AppInfo r0 = r12.getAppInfo(r0, r4)
            r8 = 1
            if (r0 == 0) goto L_0x009e
            r2 = 1
            goto L_0x009f
        L_0x009e:
            r2 = 0
        L_0x009f:
            boolean r3 = com.alipay.mobile.nebula.appcenter.apphandler.H5InstallAppAdvice.enableUseDevMode(r13)
            if (r3 != 0) goto L_0x00ca
            java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r3 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
            java.lang.String r3 = r3.getName()
            java.lang.Object r3 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r3)
            com.alipay.mobile.nebula.provider.H5ConfigProvider r3 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r3
            if (r3 == 0) goto L_0x00ca
            java.lang.String r5 = "h5_clear_dev_app"
            java.lang.String r3 = r3.getConfigWithProcessCache(r5)
            java.lang.String r5 = "no"
            boolean r3 = r5.equalsIgnoreCase(r3)
            if (r3 != 0) goto L_0x00ca
            com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList r3 = com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList.getInstance()
            java.lang.String r5 = r7.targetAppId
            r3.remove(r5)
        L_0x00ca:
            com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList r3 = com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList.getInstance()
            java.lang.String r5 = r7.targetAppId
            boolean r3 = r3.contains(r5)
            java.lang.String r5 = ""
            if (r3 == 0) goto L_0x011f
            com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList r0 = com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList.getInstance()
            java.lang.String r2 = r7.targetAppId
            r0.setUseDevMode(r2, r8)
            com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList r0 = com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList.getInstance()
            java.lang.String r2 = r7.targetAppId
            com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppInfo r0 = r0.getDevInfo(r2)
            java.lang.String r2 = r0.nbsv
            java.lang.String r5 = r0.nbsn
            java.lang.String r3 = r7.targetAppId
            java.lang.String r6 = r0.nbsv
            com.alipay.mobile.nebula.appcenter.model.AppInfo r3 = r12.getAppInfo(r3, r6)
            if (r3 != 0) goto L_0x00fb
            r6 = 0
            goto L_0x00fc
        L_0x00fb:
            r6 = 1
        L_0x00fc:
            java.lang.String r9 = TAG
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "nbsv "
            r10.<init>(r11)
            java.lang.String r0 = r0.nbsv
            r10.append(r0)
            java.lang.String r0 = " hasAppInfo:"
            r10.append(r0)
            r10.append(r6)
            java.lang.String r0 = r10.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r9, r0)
            r11 = r2
            r9 = r3
            r14 = r5
            r10 = r6
            r15 = 1
            goto L_0x012d
        L_0x011f:
            com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList r3 = com.alipay.mobile.nebula.appcenter.apphandler.H5DevAppList.getInstance()
            java.lang.String r6 = r7.targetAppId
            r3.setUseDevMode(r6, r1)
            r9 = r0
            r10 = r2
            r11 = r5
            r14 = r11
            r15 = 0
        L_0x012d:
            com.alipay.mobile.nebula.appcenter.util.H5AppUtil.mergeConmonStartParam(r13, r9)
            paramParse(r13)
            boolean r0 = com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList.enablePreferList()
            if (r0 == 0) goto L_0x01b4
            boolean r0 = com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList.enableUsePrefer(r13)
            if (r0 == 0) goto L_0x0198
            boolean r0 = com.alipay.mobile.nebula.appcenter.apphandler.H5InstallAppAdvice.enableUseDevMode(r13)
            if (r0 == 0) goto L_0x0167
            java.lang.String r0 = "nbsv"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r13, (java.lang.String) r0)
            java.lang.String r2 = "nbsn"
            java.lang.String r2 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r13, (java.lang.String) r2)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 != 0) goto L_0x0198
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x0198
            com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList r3 = com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList.getInstance()
            java.lang.String r5 = r7.targetAppId
            r3.add(r5, r0, r2)
            goto L_0x0198
        L_0x0167:
            com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList r0 = com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList.getInstance()
            java.lang.String r2 = r7.targetAppId
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x0198
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "deleteAppInfo "
            r1.<init>(r2)
            java.lang.String r2 = r7.targetAppId
            r1.append(r2)
            java.lang.String r2 = " from H5PreferAppList"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r0, r1)
            com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList r0 = com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList.getInstance()
            java.lang.String r1 = r7.targetAppId
            r0.deleteAppInfoWithAppId(r1)
            goto L_0x0002
        L_0x0198:
            boolean r0 = com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList.enableUsePrefer(r13)
            if (r0 != 0) goto L_0x01b4
            boolean r0 = com.alipay.mobile.nebula.appcenter.apphandler.H5InstallAppAdvice.enableUseDevMode(r13)
            if (r0 != 0) goto L_0x01b4
            com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList r0 = com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList.getInstance()
            java.lang.String r2 = r7.targetAppId
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x01b4
            com.alipay.mobile.nebula.appcenter.apphandler.H5PreferAppList.startCheckPermissionScheme(r29)
            return
        L_0x01b4:
            java.lang.String r0 = "nbversion"
            java.lang.String r2 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r13, (java.lang.String) r0)
            java.lang.String r0 = "nboffline"
            java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r13, (java.lang.String) r0)
            java.lang.String r0 = "nbupdate"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r13, (java.lang.String) r0)
            java.lang.String r3 = "nburl"
            java.lang.String r5 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r13, (java.lang.String) r3)
            java.lang.String r3 = "nboffmode"
            java.lang.String r3 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r13, (java.lang.String) r3)
            boolean r16 = com.alipay.mobile.nebula.util.H5Utils.isTinyApp(r9)
            if (r16 == 0) goto L_0x01f3
            java.lang.String r1 = r7.targetAppId
            boolean r1 = com.alipay.mobile.nebula.util.H5KeepAliveUtil.enableKeepAlive(r13, r1)
            if (r1 != 0) goto L_0x01f3
            java.lang.Class<com.alipay.mobile.h5container.service.H5EventHandlerService> r1 = com.alipay.mobile.h5container.service.H5EventHandlerService.class
            java.lang.String r1 = r1.getName()
            java.lang.Object r1 = com.alipay.mobile.nebula.util.H5Utils.findServiceByInterface(r1)
            com.alipay.mobile.h5container.service.H5EventHandlerService r1 = (com.alipay.mobile.h5container.service.H5EventHandlerService) r1
            if (r1 == 0) goto L_0x01f3
            java.lang.String r8 = r7.targetAppId
            r1.stopLiteProcessByAppIdInServer(r8)
        L_0x01f3:
            com.alipay.mobile.nebula.appcenter.rpcblacklist.H5RpcBlackList r1 = com.alipay.mobile.nebula.appcenter.rpcblacklist.H5RpcBlackList.getInstance()
            java.lang.String r8 = r7.targetAppId
            boolean r1 = r1.contains(r8)
            java.lang.String r8 = "syncforce"
            if (r1 != 0) goto L_0x0207
            if (r10 != 0) goto L_0x0205
            goto L_0x0207
        L_0x0205:
            r1 = r0
            goto L_0x0208
        L_0x0207:
            r1 = r8
        L_0x0208:
            if (r10 == 0) goto L_0x032f
            java.lang.String r0 = "strictReqRate"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r13, (java.lang.String) r0)     // Catch:{ Exception -> 0x031a }
            boolean r18 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x031a }
            if (r18 != 0) goto L_0x021e
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x031a }
            r18 = r0
            goto L_0x0220
        L_0x021e:
            r18 = 0
        L_0x0220:
            if (r18 != 0) goto L_0x028e
            java.lang.String r0 = "preReqRate"
            java.lang.String r0 = r12.getConfigExtra(r0)     // Catch:{ Exception -> 0x0281 }
            com.alibaba.a.e r0 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r0)     // Catch:{ Exception -> 0x0281 }
            if (r0 == 0) goto L_0x028e
            boolean r19 = r0.isEmpty()     // Catch:{ Exception -> 0x0281 }
            if (r19 != 0) goto L_0x028e
            r19 = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x027f }
            r1.<init>()     // Catch:{ Exception -> 0x027f }
            r20 = r14
            int r14 = r9.app_channel     // Catch:{ Exception -> 0x030d }
            r1.append(r14)     // Catch:{ Exception -> 0x030d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x030d }
            boolean r1 = r0.containsKey(r1)     // Catch:{ Exception -> 0x030d }
            if (r1 == 0) goto L_0x025f
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x030d }
            r1.<init>()     // Catch:{ Exception -> 0x030d }
            int r14 = r9.app_channel     // Catch:{ Exception -> 0x030d }
            r1.append(r14)     // Catch:{ Exception -> 0x030d }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x030d }
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x030d }
            goto L_0x0265
        L_0x025f:
            java.lang.String r1 = "common"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r0, (java.lang.String) r1)     // Catch:{ Exception -> 0x030d }
        L_0x0265:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x030d }
            if (r1 != 0) goto L_0x0278
            int r18 = java.lang.Integer.parseInt(r0)     // Catch:{ all -> 0x0270 }
            goto L_0x0292
        L_0x0270:
            r0 = move-exception
            r1 = r0
            java.lang.String r0 = TAG     // Catch:{ Exception -> 0x030d }
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r0, (java.lang.Throwable) r1)     // Catch:{ Exception -> 0x030d }
            goto L_0x0292
        L_0x0278:
            r18 = 2592000(0x278d00, float:3.632166E-39)
            r0 = 2592000(0x278d00, float:3.632166E-39)
            goto L_0x0294
        L_0x027f:
            r0 = move-exception
            goto L_0x0284
        L_0x0281:
            r0 = move-exception
            r19 = r1
        L_0x0284:
            r20 = r14
        L_0x0286:
            r25 = r8
            r28 = r11
            r27 = r12
            goto L_0x0325
        L_0x028e:
            r19 = r1
            r20 = r14
        L_0x0292:
            r0 = r18
        L_0x0294:
            if (r0 == 0) goto L_0x0310
            java.lang.String r1 = r9.update_app_time     // Catch:{ Exception -> 0x030d }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x030d }
            if (r1 != 0) goto L_0x0310
            java.lang.String r1 = r9.update_app_time     // Catch:{ all -> 0x02fb }
            r18 = r15
            long r14 = java.lang.Long.parseLong(r1)     // Catch:{ all -> 0x02f3 }
            long r21 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x02f3 }
            long r21 = r21 - r14
            r23 = 1000(0x3e8, double:4.94E-321)
            long r25 = r21 / r23
            r28 = r11
            r27 = r12
            long r11 = (long) r0
            int r1 = (r25 > r11 ? 1 : (r25 == r11 ? 0 : -1))
            if (r1 <= 0) goto L_0x02bb
            r1 = 1
            goto L_0x02bc
        L_0x02bb:
            r1 = 0
        L_0x02bc:
            java.lang.String r11 = TAG     // Catch:{ all -> 0x02ef }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x02ef }
            r25 = r8
            java.lang.String r8 = "updateTime:"
            r12.<init>(r8)     // Catch:{ all -> 0x02ed }
            r12.append(r14)     // Catch:{ all -> 0x02ed }
            java.lang.String r8 = " timeDiff:"
            r12.append(r8)     // Catch:{ all -> 0x02ed }
            long r14 = r21 / r23
            r12.append(r14)     // Catch:{ all -> 0x02ed }
            java.lang.String r8 = " strictReqRat:"
            r12.append(r8)     // Catch:{ all -> 0x02ed }
            r12.append(r0)     // Catch:{ all -> 0x02ed }
            java.lang.String r0 = " timeout "
            r12.append(r0)     // Catch:{ all -> 0x02ed }
            r12.append(r1)     // Catch:{ all -> 0x02ed }
            java.lang.String r0 = r12.toString()     // Catch:{ all -> 0x02ed }
            com.alipay.mobile.nebula.util.H5Log.d(r11, r0)     // Catch:{ all -> 0x02ed }
            goto L_0x032d
        L_0x02ed:
            r0 = move-exception
            goto L_0x0305
        L_0x02ef:
            r0 = move-exception
            r25 = r8
            goto L_0x0305
        L_0x02f3:
            r0 = move-exception
            r25 = r8
            r28 = r11
            r27 = r12
            goto L_0x0304
        L_0x02fb:
            r0 = move-exception
            r25 = r8
            r28 = r11
            r27 = r12
            r18 = r15
        L_0x0304:
            r1 = 0
        L_0x0305:
            java.lang.String r8 = TAG     // Catch:{ Exception -> 0x030b }
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r8, (java.lang.Throwable) r0)     // Catch:{ Exception -> 0x030b }
            goto L_0x032d
        L_0x030b:
            r0 = move-exception
            goto L_0x0328
        L_0x030d:
            r0 = move-exception
            goto L_0x0286
        L_0x0310:
            r25 = r8
            r28 = r11
            r27 = r12
            r18 = r15
            r1 = 0
            goto L_0x032d
        L_0x031a:
            r0 = move-exception
            r19 = r1
            r25 = r8
            r28 = r11
            r27 = r12
            r20 = r14
        L_0x0325:
            r18 = r15
            r1 = 0
        L_0x0328:
            java.lang.String r8 = TAG
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r8, (java.lang.Throwable) r0)
        L_0x032d:
            r8 = r1
            goto L_0x033c
        L_0x032f:
            r19 = r1
            r25 = r8
            r28 = r11
            r27 = r12
            r20 = r14
            r18 = r15
            r8 = 0
        L_0x033c:
            java.lang.String r0 = "yes"
            if (r9 == 0) goto L_0x0351
            java.lang.String r1 = r9.fromPreset
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0351
            java.lang.String r1 = TAG
            java.lang.String r8 = " appInfo is fromPreset set Timeout"
            com.alipay.mobile.nebula.util.H5Log.w(r1, r8)
            r8 = 1
        L_0x0351:
            java.lang.String r11 = "synctry"
            if (r8 == 0) goto L_0x035d
            if (r10 == 0) goto L_0x035a
            r12 = r11
            goto L_0x035f
        L_0x035a:
            r12 = r25
            goto L_0x035f
        L_0x035d:
            r12 = r19
        L_0x035f:
            if (r9 == 0) goto L_0x037a
            com.alipay.mobile.nebula.appcenter.apphandler.loadingview.H5NebulaAppCacheManager.setAppType(r7, r9, r13)
            java.lang.String r1 = r9.version
            java.lang.String r14 = TAG
            java.lang.String r15 = java.lang.String.valueOf(r1)
            r16 = r0
            java.lang.String r0 = "nebulaVersion "
            java.lang.String r0 = r0.concat(r15)
            com.alipay.mobile.nebula.util.H5Log.d(r14, r0)
            r7.nebulaVersion = r1
            goto L_0x037c
        L_0x037a:
            r16 = r0
        L_0x037c:
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r14 = "targetAppId:"
            r1.<init>(r14)
            java.lang.String r14 = r7.targetAppId
            r1.append(r14)
            java.lang.String r14 = " wantNebulaVersion:"
            r1.append(r14)
            r1.append(r2)
            java.lang.String r15 = " syncOffline:"
            r1.append(r15)
            r1.append(r6)
            java.lang.String r15 = " syncUpdate:"
            r1.append(r15)
            r1.append(r12)
            java.lang.String r15 = " currentNbVersion:"
            r1.append(r15)
            r1.append(r4)
            java.lang.String r15 = " nbUrl:"
            r1.append(r15)
            r1.append(r5)
            java.lang.String r15 = "nbOffMode: "
            r1.append(r15)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r0, r1)
            com.alipay.mobile.nebula.appcenter.apphandler.H5AppPrepareData r0 = prepareData
            r0.setRequestMode(r12)
            com.alipay.mobile.nebula.appcenter.apphandler.H5AppPrepareData r0 = prepareData
            r0.setOfflineMode(r6, r3)
            com.alipay.mobile.nebula.appcenter.apphandler.H5AppPrepareData r0 = prepareData
            java.lang.String r1 = r7.targetAppId
            r0.setAppId(r1)
            com.alipay.mobile.nebula.appcenter.apphandler.H5AppPrepareData r0 = prepareData
            java.lang.String r1 = r7.nebulaVersion
            r0.setVersion(r1)
            boolean r0 = android.text.TextUtils.equals(r12, r11)
            if (r0 != 0) goto L_0x03fb
            r15 = r25
            boolean r0 = android.text.TextUtils.equals(r12, r15)
            if (r0 == 0) goto L_0x03eb
            r19 = r3
            goto L_0x03ff
        L_0x03eb:
            r0 = 0
            r1 = r29
            r2 = r6
            r19 = r3
            r3 = r0
            r4 = r12
            r6 = r9
            r7 = r19
            r8 = r13
            updateSuccess(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x03fb:
            r19 = r3
            r15 = r25
        L_0x03ff:
            int r0 = com.alipay.mobile.nebula.appcenter.util.H5AppUtil.compareVersion(r4, r2)
            java.lang.String r1 = TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r25 = r15
            java.lang.String r15 = "currentNbVersion"
            r3.<init>(r15)
            r3.append(r4)
            r3.append(r14)
            r3.append(r2)
            java.lang.String r4 = " "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r3 = r3.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r1, r3)
            r1 = -1
            if (r0 == r1) goto L_0x044d
            com.alipay.mobile.nebula.appcenter.rpcblacklist.H5RpcBlackList r0 = com.alipay.mobile.nebula.appcenter.rpcblacklist.H5RpcBlackList.getInstance()
            java.lang.String r1 = r7.targetAppId
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x044d
            if (r10 == 0) goto L_0x044d
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x044d
            if (r8 == 0) goto L_0x0440
            goto L_0x044d
        L_0x0440:
            r3 = 0
            r1 = r29
            r2 = r6
            r4 = r12
            r6 = r9
            r7 = r19
            r8 = r13
            updateSuccess(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        L_0x044d:
            com.alipay.mobile.nebula.appcenter.apphandler.loadingview.H5LoadingManager r0 = getLoadingImpl()
            boolean r1 = r11.equals(r12)
            if (r1 == 0) goto L_0x047c
            if (r9 == 0) goto L_0x047c
            java.lang.String r1 = "sync"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x047c
            java.lang.String r1 = r9.app_id
            java.lang.String r2 = r9.version
            r14 = r27
            boolean r1 = r14.isAvailable(r1, r2)
            if (r1 != 0) goto L_0x0471
        L_0x046e:
            r4 = r25
            goto L_0x047f
        L_0x0471:
            java.lang.String r1 = r9.app_id
            java.lang.String r2 = r9.version
            boolean r1 = r14.isInstalled(r1, r2)
            if (r1 != 0) goto L_0x047e
            goto L_0x046e
        L_0x047c:
            r14 = r27
        L_0x047e:
            r4 = r12
        L_0x047f:
            com.alipay.mobile.nebula.appcenter.apphandler.H5AppPrepareData r1 = prepareData
            r2 = 1
            r1.setPageStatus(r2)
            java.lang.String r1 = r7.targetAppId
            java.lang.String r2 = r7.nebulaVersion
            java.lang.String r1 = r14.getIconUrl(r1, r2)
            java.lang.String r2 = r7.targetAppId
            java.lang.String r3 = r7.nebulaVersion
            java.lang.String r2 = r14.getAppName(r2, r3)
            android.os.Bundle r3 = r7.params
            java.lang.String r8 = "NebulaWalletAppName"
            r3.putString(r8, r2)
            android.os.Bundle r3 = r7.params
            android.os.Bundle r2 = setStartParam(r2, r1, r3)
            java.lang.String r3 = r7.targetAppId
            java.lang.String r1 = r7.targetAppId
            int r8 = getTimeout(r1, r4, r13, r9)
            r1 = r0
            r15 = r5
            r5 = r29
            r21 = r6
            r6 = r8
            r1.open(r2, r3, r4, r5, r6)
            android.os.Bundle r1 = r7.params
            java.lang.String r2 = "packageLoadingShown"
            r3 = 1
            r1.putBoolean(r2, r3)
            java.util.HashMap r8 = new java.util.HashMap
            r8.<init>()
            com.alipay.mobile.nebula.appcenter.model.AppReq r6 = new com.alipay.mobile.nebula.appcenter.model.AppReq
            r6.<init>()
            boolean r1 = android.text.TextUtils.equals(r12, r11)
            if (r1 == 0) goto L_0x04cf
            r6.reqmode = r11
            goto L_0x04d3
        L_0x04cf:
            r1 = r25
            r6.reqmode = r1
        L_0x04d3:
            boolean r1 = com.alipay.mobile.nebula.util.H5Utils.isTinyApp(r9)
            java.lang.String r2 = "NO"
            if (r1 != 0) goto L_0x04e5
            java.lang.String r1 = r7.targetAppId
            int r1 = r1.length()
            r3 = 15
            if (r1 <= r3) goto L_0x04e7
        L_0x04e5:
            r6.stableRpc = r2
        L_0x04e7:
            java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r1 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
            java.lang.String r1 = r1.getName()
            java.lang.Object r1 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r1)
            com.alipay.mobile.nebula.provider.H5ConfigProvider r1 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r1
            if (r1 == 0) goto L_0x0505
            java.lang.String r3 = "H5_loading_use_stableRpc"
            java.lang.String r1 = r1.getConfig(r3)
            r3 = r16
            boolean r1 = r3.equalsIgnoreCase(r1)
            if (r1 != 0) goto L_0x0505
            r6.stableRpc = r2
        L_0x0505:
            if (r18 == 0) goto L_0x0532
            java.lang.String r1 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "useDev "
            r2.<init>(r3)
            r5 = r28
            r2.append(r5)
            java.lang.String r3 = " nbsn:"
            r2.append(r3)
            r3 = r20
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r1, r2)
            java.lang.String r1 = r7.targetAppId
            r8.put(r1, r5)
            java.lang.String r1 = r7.targetAppId
            setDevReq(r1, r6)
            goto L_0x053f
        L_0x0532:
            r5 = r28
            java.lang.String r1 = r7.targetAppId
            java.lang.String r1 = r14.getWalletConfigNebulaVersion(r1)
            java.lang.String r2 = r7.targetAppId
            r8.put(r2, r1)
        L_0x053f:
            com.alipay.mobile.nebula.appcenter.apphandler.H5AppPrepareData r1 = prepareData
            long r2 = java.lang.System.currentTimeMillis()
            r1.setRequestBeginTime(r2)
            r16 = 1
            com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler$1 r17 = new com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler$1
            r1 = r17
            r2 = r29
            r3 = r14
            r4 = r21
            r18 = r6
            r6 = r10
            r7 = r0
            r0 = r8
            r8 = r12
            r9 = r15
            r10 = r19
            r11 = r13
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r5 = 0
            r6 = 1
            r8 = 0
            long r1 = java.lang.System.currentTimeMillis()
            java.lang.Long r9 = java.lang.Long.valueOf(r1)
            java.util.List r10 = getResourcePackageList(r13)
            r1 = r14
            r2 = r0
            r3 = r16
            r4 = r17
            r7 = r18
            r1.updateAppWithReqFinally(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler.syncApp(com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppInfo):void");
    }

    /* access modifiers changed from: private */
    public static List<String> getResourcePackageList(Bundle bundle) {
        b parseArray = H5Utils.parseArray(H5Utils.getString(bundle, "nbpkgres"));
        ArrayList arrayList = new ArrayList();
        if (parseArray != null) {
            try {
                if (parseArray.size() > 0) {
                    Iterator<Object> it2 = parseArray.iterator();
                    while (it2.hasNext()) {
                        arrayList.add((String) it2.next());
                    }
                }
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static void updateFail(String str, String str2, H5StartAppInfo h5StartAppInfo, H5LoadingManager h5LoadingManager, String str3, AppInfo appInfo, String str4, String str5, Bundle bundle, boolean z) {
        String str6 = str2;
        H5StartAppInfo h5StartAppInfo2 = h5StartAppInfo;
        H5LoadingManager h5LoadingManager2 = h5LoadingManager;
        String str7 = str;
        if (TextUtils.equals(str, "syncforce")) {
            prepareData.setEndTime(System.currentTimeMillis());
            prepareData.setErrorCode("0");
            prepareData.setNbUrl(str2);
            prepareData.uploadPrepareLog();
            if (!TextUtils.isEmpty(str2)) {
                exitPageAndOpenUrl(str2, h5LoadingManager);
            } else if (z) {
                doShowError(h5StartAppInfo, "RpcError", h5LoadingManager);
            } else {
                logError(h5StartAppInfo, "appNotExist");
                exitPageAndOpenUrl(String.format(appInfoEmptyUrl, new Object[]{str4}), h5LoadingManager);
            }
        } else {
            setSyncOffline(h5StartAppInfo, str3, h5LoadingManager, str, str2, appInfo, str5, bundle);
        }
    }

    /* access modifiers changed from: private */
    public static void exitPageAndOpenUrl(final String str, final H5LoadingManager h5LoadingManager) {
        if (h5LoadingManager != null) {
            if (h5LoadingManager.getPageStatues() == 2) {
                H5Log.d(TAG, "has show fail not open");
                return;
            }
            playExitAnimation(h5LoadingManager, 500);
            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                public final void run() {
                    if (h5LoadingManager.isReady()) {
                        h5LoadingManager.exit();
                        H5Utils.openUrl(str);
                        return;
                    }
                    int unused = H5AppHandler.waitCount = H5AppHandler.waitCount + 1;
                    String access$200 = H5AppHandler.TAG;
                    H5Log.d(access$200, "exitPageAndOpenUrl not ready ,send again " + H5AppHandler.waitCount);
                    if (H5AppHandler.waitCount <= H5AppHandler.waitMax) {
                        H5AppHandler.exitPageAndOpenUrl(str, h5LoadingManager);
                    }
                }
            }, 1000);
        }
    }

    private static void playExitAnimation(final H5LoadingManager h5LoadingManager, int i2) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public final void run() {
                H5LoadingManager h5LoadingManager = h5LoadingManager;
                if (h5LoadingManager != null && h5LoadingManager.isReady()) {
                    H5Log.d(H5AppHandler.TAG, "playExitAnimation");
                    h5LoadingManager.playExitAnimation();
                }
            }
        }, (long) i2);
    }

    /* access modifiers changed from: private */
    public static void updateSuccess(H5StartAppInfo h5StartAppInfo, String str, H5LoadingManager h5LoadingManager, String str2, String str3, AppInfo appInfo, String str4, Bundle bundle) {
        setSyncOffline(h5StartAppInfo, str, h5LoadingManager, str2, str3, appInfo, str4, bundle);
    }

    /* access modifiers changed from: private */
    public static void setDevReq(String str, AppReq appReq) {
        if (appReq != null) {
            appReq.scene = H5DevAppList.getInstance().getDevInfo(str).nbsn;
            appReq.nbsource = "debug";
        }
    }

    private static void updateNebulaAppAsync(final String str, final Bundle bundle) {
        ScheduledThreadPoolExecutor scheduledExecutor = H5Utils.getScheduledExecutor();
        if (scheduledExecutor != null) {
            scheduledExecutor.schedule(new Runnable() {
                public final void run() {
                    HashMap hashMap = new HashMap();
                    H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
                    if (h5AppProvider != null) {
                        AppReq appReq = new AppReq();
                        appReq.reqmode = "async";
                        if (H5DevAppList.getInstance().contains(str)) {
                            hashMap.put(str, H5DevAppList.getInstance().getDevInfo(str).nbsv);
                            H5AppHandler.setDevReq(str, appReq);
                        } else {
                            hashMap.put(str, h5AppProvider.getWalletConfigNebulaVersion(str));
                        }
                        String access$200 = H5AppHandler.TAG;
                        H5Log.d(access$200, "updateNebulaAppAsync appId:" + str);
                        h5AppProvider.updateAppWithReqFinally(hashMap, true, (H5AppInstallProcess) null, true, false, appReq, false, Long.valueOf(System.currentTimeMillis()), H5AppHandler.getResourcePackageList(bundle));
                    }
                }
            }, 5, TimeUnit.SECONDS);
        }
    }

    /* access modifiers changed from: private */
    public static void offlineFail(String str, H5LoadingManager h5LoadingManager, H5StartAppInfo h5StartAppInfo, String str2, AppInfo appInfo, String str3) {
        prepareData.setEndTime(System.currentTimeMillis());
        prepareData.setErrorCode("0");
        if (!TextUtils.isEmpty(str)) {
            prepareData.setNbUrl(str);
            prepareData.uploadPrepareLog();
            exitPageAndOpenUrl(str, h5LoadingManager);
            return;
        }
        showError(h5LoadingManager, h5StartAppInfo, str2, appInfo, str3);
    }

    private static void preInstallTinyApp(H5AppProvider h5AppProvider) {
        H5AppCenterPresetProvider h5AppCenterPresetProvider = (H5AppCenterPresetProvider) H5Utils.getProvider(H5AppCenterPresetProvider.class.getName());
        if (h5AppCenterPresetProvider != null) {
            String tinyCommonApp = h5AppCenterPresetProvider.getTinyCommonApp();
            if (!TextUtils.isEmpty(tinyCommonApp)) {
                String version = h5AppProvider.getVersion(tinyCommonApp);
                if (!h5AppProvider.isInstalled(tinyCommonApp, version)) {
                    long currentTimeMillis = System.currentTimeMillis();
                    boolean isAvailable = h5AppProvider.isAvailable(tinyCommonApp, version);
                    if (isAvailable) {
                        h5AppProvider.installApp(tinyCommonApp, version);
                    } else {
                        h5AppProvider.downloadApp(tinyCommonApp, version);
                    }
                    String str = TAG;
                    H5Log.d(str, "TinyCommonApp is not install  isAvailable: " + isAvailable + " " + (System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
                H5Log.d(TAG, "TinyCommonApp is install");
            }
        }
    }

    private static void setSyncOffline(H5StartAppInfo h5StartAppInfo, String str, H5LoadingManager h5LoadingManager, String str2, String str3, AppInfo appInfo, String str4, Bundle bundle) {
        final H5LoadingManager h5LoadingManager2;
        H5StartAppInfo h5StartAppInfo2 = h5StartAppInfo;
        String str5 = str;
        H5LoadingManager h5LoadingManager3 = h5LoadingManager;
        AppInfo appInfo2 = appInfo;
        Bundle bundle2 = bundle;
        if (TextUtils.equals(str, H5NbOfflineType.sync) || H5AppUtil.enableDSL(bundle)) {
            H5LoadingApp.put(h5StartAppInfo2.targetAppId, h5StartAppInfo2.nebulaVersion);
            H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
            if (h5AppProvider != null && appInfo2 != null) {
                boolean isAvailable = h5AppProvider.isAvailable(h5StartAppInfo2.targetAppId, appInfo2.version);
                String str6 = TAG;
                H5Log.d(str6, "syncOffline=sync " + h5StartAppInfo2.targetAppId + " " + appInfo2.version + " " + isAvailable);
                h5StartAppInfo2.params.putBoolean(PERF_IS_LOCAL_KEY, isAvailable);
                h5StartAppInfo2.params.putLong(PERF_OPENAPP_TIME_KEY, SystemClock.elapsedRealtime());
                if (!isAvailable) {
                    String str7 = !TextUtils.isEmpty(str4) ? str4 : str5;
                    if (h5LoadingManager3 == null) {
                        H5LoadingManager loadingImpl = getLoadingImpl();
                        String iconUrl = h5AppProvider.getIconUrl(h5StartAppInfo2.targetAppId, h5StartAppInfo2.nebulaVersion);
                        String appName = h5AppProvider.getAppName(h5StartAppInfo2.targetAppId, h5StartAppInfo2.nebulaVersion);
                        h5StartAppInfo2.params.putString(H5Param.LONG_WALLET_APP_NAME, appName);
                        loadingImpl.open(setStartParam(appName, iconUrl, h5StartAppInfo2.params), h5StartAppInfo2.targetAppId, str7, h5StartAppInfo, getTimeout(h5StartAppInfo2.targetAppId, str, bundle2, appInfo2));
                        h5StartAppInfo2.params.putBoolean(H5Param.LONG_PACKAGE_LOADING_SHOWN, true);
                        prepareData.setPageStatus(1);
                        h5LoadingManager2 = loadingImpl;
                    } else {
                        H5LoadingTypeListen h5LoadingTypeListen = H5LoadingUtil.getH5LoadingTypeListen();
                        if (h5LoadingTypeListen != null) {
                            h5LoadingTypeListen.onGetType(str, getTimeout(h5StartAppInfo2.targetAppId, str7, bundle2, appInfo2), h5StartAppInfo2.targetAppId);
                        }
                        h5LoadingManager2 = h5LoadingManager3;
                    }
                    prepareData.setDownloadTime(System.currentTimeMillis());
                    String str8 = h5StartAppInfo2.targetAppId;
                    String str9 = appInfo2.version;
                    final H5AppProvider h5AppProvider2 = h5AppProvider;
                    final H5StartAppInfo h5StartAppInfo3 = h5StartAppInfo;
                    final AppInfo appInfo3 = appInfo;
                    final String str10 = str2;
                    final Bundle bundle3 = bundle;
                    final String str11 = str3;
                    final String str12 = str4;
                    h5AppProvider.downloadApp(str8, str9, new H5DownloadCallback() {
                        public final void onCancel(H5DownloadRequest h5DownloadRequest) {
                        }

                        public final void onPrepare(H5DownloadRequest h5DownloadRequest) {
                        }

                        public final void onProgress(H5DownloadRequest h5DownloadRequest, int i2) {
                        }

                        public final void onFinish(H5DownloadRequest h5DownloadRequest, String str) {
                            H5AppHandler.prepareData.setInstallTime(System.currentTimeMillis());
                            H5Log.d(H5AppHandler.TAG, "onFinish:".concat(String.valueOf(str)));
                            H5Utils.getExecutor(H5ThreadType.URGENT_DISPLAY).execute(new Runnable() {
                                public void run() {
                                    if (h5AppProvider2 != null) {
                                        h5AppProvider2.installApp(h5StartAppInfo3.targetAppId, appInfo3.version, (H5AppInstallListen) new H5AppInstallListen() {
                                            public void getResult(boolean z, boolean z2) {
                                                H5Log.d(H5AppHandler.TAG, "install getResult ".concat(String.valueOf(z)));
                                                if (z) {
                                                    H5AppHandler.openApp(h5StartAppInfo3, h5LoadingManager2, str10, bundle3);
                                                } else {
                                                    H5AppHandler.offlineFail(str11, h5LoadingManager2, h5StartAppInfo3, H5AppHandler.installFail, appInfo3, str12);
                                                }
                                            }
                                        });
                                    }
                                }
                            });
                        }

                        public final void onFailed(H5DownloadRequest h5DownloadRequest, int i2, String str) {
                            if (appInfo3 == null) {
                                H5Log.d(H5AppHandler.TAG, "appInfo == null");
                                return;
                            }
                            H5LogProvider h5LogProvider = (H5LogProvider) H5Utils.getProvider(H5LogProvider.class.getName());
                            if (h5LogProvider != null) {
                                h5LogProvider.log("h5_tinyApp_downloadFail", "tiny app download failed", appInfo3.app_id, str, String.valueOf(i2));
                            }
                            String access$200 = H5AppHandler.TAG;
                            H5Log.d(access$200, "onFailed" + i2 + str);
                            H5AppHandler.offlineFail(str11, h5LoadingManager2, h5StartAppInfo3, H5AppHandler.downloadFail, appInfo3, str12);
                        }
                    });
                    return;
                }
                boolean isInstalled = h5AppProvider.isInstalled(h5StartAppInfo2.targetAppId, appInfo2.version);
                H5Log.d(TAG, "isInstall ".concat(String.valueOf(isInstalled)));
                if (!isInstalled) {
                    prepareData.setInstallTime(System.currentTimeMillis());
                    String str13 = h5StartAppInfo2.targetAppId;
                    String str14 = appInfo2.version;
                    final H5StartAppInfo h5StartAppInfo4 = h5StartAppInfo;
                    final H5LoadingManager h5LoadingManager4 = h5LoadingManager;
                    final String str15 = str2;
                    final Bundle bundle4 = bundle;
                    final String str16 = str3;
                    final AppInfo appInfo4 = appInfo;
                    final String str17 = str4;
                    h5AppProvider.installApp(str13, str14, (H5AppInstallListen) new H5AppInstallListen() {
                        public final void getResult(boolean z, boolean z2) {
                            H5Log.d(H5AppHandler.TAG, "install result:".concat(String.valueOf(z)));
                            if (z) {
                                H5AppHandler.openApp(h5StartAppInfo4, h5LoadingManager4, str15, bundle4);
                            } else {
                                H5AppHandler.offlineFail(str16, h5LoadingManager4, h5StartAppInfo4, H5AppHandler.installFail, appInfo4, str17);
                            }
                        }
                    });
                    return;
                }
            } else {
                return;
            }
        } else if (!H5AppUtil.isH5AppPkg(appInfo)) {
            offlineNebulaAppAsync(h5StartAppInfo2.targetAppId, appInfo2);
        }
        openApp(h5StartAppInfo, h5LoadingManager, str2, bundle2);
    }

    private static void offlineNebulaAppAsync(final String str, final AppInfo appInfo) {
        final H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
        if (h5AppProvider != null && appInfo != null) {
            boolean isInstalled = h5AppProvider.isInstalled(str, appInfo.version);
            if (!isInstalled) {
                boolean isAvailable = h5AppProvider.isAvailable(str, appInfo.version);
                String str2 = TAG;
                H5Log.d(str2, "offlineNebulaAppAsync App appId:" + str + " version:" + appInfo.version + " isAvailable:" + isAvailable);
                if (!isAvailable) {
                    String str3 = TAG;
                    H5Log.d(str3, "offlineNebulaAppAsync :downloadApp appId:" + str + " version:" + appInfo.version);
                    h5AppProvider.downloadApp(str, appInfo.version, new H5DownloadCallback() {
                        public final void onCancel(H5DownloadRequest h5DownloadRequest) {
                        }

                        public final void onPrepare(H5DownloadRequest h5DownloadRequest) {
                        }

                        public final void onProgress(H5DownloadRequest h5DownloadRequest, int i2) {
                        }

                        public final void onFinish(H5DownloadRequest h5DownloadRequest, String str) {
                            H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
                                public void run() {
                                    H5AppHandler.install(str, appInfo.version, h5AppProvider);
                                }
                            });
                        }

                        public final void onFailed(H5DownloadRequest h5DownloadRequest, int i2, String str) {
                            H5Log.d(H5AppHandler.TAG, "offlineNebulaAppAsync onFailed:".concat(String.valueOf(str)));
                        }
                    });
                    return;
                }
                String str4 = TAG;
                H5Log.d(str4, "offlineNebulaAppAsync App appId:" + str + " version:" + appInfo.version + " to install ");
                install(str, appInfo.version, h5AppProvider);
                logInstallStatus(str, appInfo.version, isInstalled);
                return;
            }
            String str5 = TAG;
            H5Log.d(str5, "offlineNebulaAppAsync App appId:" + str + " version:" + appInfo.version + " is install ");
        }
    }

    private static void logInstallStatus(String str, String str2, boolean z) {
        H5LogProvider h5LogProvider = H5AppUtil.getH5LogProvider();
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5LogProvider != null && h5ConfigProvider != null) {
            h5LogProvider.log("H5_APP_INSTALL_STATUS", "monitor", "", "appId=" + str + "^version=" + str2 + "^isInstall=" + z + "^installPackageConfig=" + h5ConfigProvider.getConfig("h5_installPackageConfig"), (String) null);
        }
    }

    /* access modifiers changed from: private */
    public static void install(final String str, final String str2, final H5AppProvider h5AppProvider) {
        H5Utils.getExecutor(H5ThreadType.URGENT_DISPLAY).execute(new Runnable() {
            public final void run() {
                h5AppProvider.installApp(str, str2);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void openApp(H5StartAppInfo h5StartAppInfo, H5LoadingManager h5LoadingManager, String str, Bundle bundle) {
        try {
            prepareData.setEndTime(System.currentTimeMillis());
            prepareData.setErrorCode("1");
            prepareData.uploadPrepareLog();
            if (!TextUtils.equals(str, "synctry") && !TextUtils.equals(str, "syncforce")) {
                updateNebulaAppAsync(h5StartAppInfo.targetAppId, bundle);
            }
            if (h5LoadingManager != null) {
                exitAndStartApp(h5StartAppInfo, h5LoadingManager);
            } else {
                startApp(h5StartAppInfo, h5LoadingManager);
            }
        } catch (Exception e2) {
            String str2 = TAG;
            H5Log.e(str2, "startApp [targetAppId] " + h5StartAppInfo.targetAppId + " failed!", e2);
        }
    }

    public static void exitAndStartApp(final H5StartAppInfo h5StartAppInfo, final H5LoadingManager h5LoadingManager) {
        int i2;
        if (h5StartAppInfo != null) {
            if (h5LoadingManager != null) {
                boolean pageDestroy = h5LoadingManager.pageDestroy();
                H5Log.d(TAG, "destroy:".concat(String.valueOf(pageDestroy)));
                if (pageDestroy) {
                    H5Log.d(TAG, "has exit not startApp");
                    return;
                }
            }
            if (h5LoadingManager != null && h5LoadingManager.getPageStatues() == 3) {
                H5Log.d(TAG, "H5PageStatues.HAS_START_APP not startApp again");
            } else if (h5LoadingManager == null || h5LoadingManager.getPageStatues() != 2) {
                if (h5LoadingManager != null) {
                    h5LoadingManager.setPageStatue(3);
                }
                if (H5NebulaAppCacheManager.NEBULA_H5TINY_APP.equals(h5StartAppInfo.nebulaAppType)) {
                    long currentTimeMillis = System.currentTimeMillis() - h5LoadingManager.getStartLoadingTime();
                    long j = 0;
                    if (currentTimeMillis <= 300 && currentTimeMillis >= 0) {
                        j = 300 - currentTimeMillis;
                    }
                    int i3 = (int) j;
                    H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
                    if (h5ConfigProvider != null) {
                        String config = h5ConfigProvider.getConfig("h5_openLoadingDelay");
                        if (!TextUtils.isEmpty(config) && CHECK_VALUE.equalsIgnoreCase(config)) {
                            i2 = i3 + 300;
                            playExitAnimation(h5LoadingManager, i3);
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                public final void run() {
                                    H5Log.d(H5AppHandler.TAG, "begin startApp openMultiProcess");
                                    H5AppHandler.startApp(h5StartAppInfo, h5LoadingManager);
                                }
                            }, (long) i2);
                            new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                                public final void run() {
                                    H5LoadingManager h5LoadingManager = h5LoadingManager;
                                    if (h5LoadingManager != null && h5LoadingManager.isReady()) {
                                        H5Log.d(H5AppHandler.TAG, "exit");
                                        h5LoadingManager.exit();
                                    }
                                }
                            }, 2500);
                        }
                    }
                    i2 = i3;
                    playExitAnimation(h5LoadingManager, i3);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            H5Log.d(H5AppHandler.TAG, "begin startApp openMultiProcess");
                            H5AppHandler.startApp(h5StartAppInfo, h5LoadingManager);
                        }
                    }, (long) i2);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            H5LoadingManager h5LoadingManager = h5LoadingManager;
                            if (h5LoadingManager != null && h5LoadingManager.isReady()) {
                                H5Log.d(H5AppHandler.TAG, "exit");
                                h5LoadingManager.exit();
                            }
                        }
                    }, 2500);
                } else if (isFirstStartApp) {
                    isFirstStartApp = false;
                    playExitAnimation(h5LoadingManager, 500);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            H5LoadingManager h5LoadingManager = h5LoadingManager;
                            if (h5LoadingManager != null && h5LoadingManager.isReady()) {
                                H5Log.d(H5AppHandler.TAG, "exit");
                                h5LoadingManager.exit();
                            }
                        }
                    }, 1000);
                    H5Log.d(TAG, "isFirstStartApp startApp");
                    startApp(h5StartAppInfo, h5LoadingManager);
                } else {
                    playExitAnimation(h5LoadingManager, 500);
                    new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                        public final void run() {
                            H5LoadingManager h5LoadingManager = h5LoadingManager;
                            if (h5LoadingManager != null && h5LoadingManager.isReady()) {
                                H5Log.d(H5AppHandler.TAG, H5PageData.FROM_TYPE_START_APP);
                                H5AppHandler.startApp(h5StartAppInfo, h5LoadingManager);
                                H5Log.d(H5AppHandler.TAG, "exit");
                                h5LoadingManager.exit();
                            }
                        }
                    }, 1000);
                }
            } else {
                H5Log.d(TAG, "H5PageStatues.SHOW_FAIL not startApp again");
            }
        }
    }

    /* access modifiers changed from: private */
    public static void startApp(final H5StartAppInfo h5StartAppInfo, H5LoadingManager h5LoadingManager) {
        if (h5LoadingManager != null && h5LoadingManager.getPageStatues() == 2) {
            H5Log.d(TAG, "pageStatues.currentPageStatues == PageStatues.SHOW_FAIL not startApp again");
        } else if (H5Utils.isMain()) {
            H5Utils.getExecutor(H5ThreadType.URGENT_DISPLAY).execute(new Runnable() {
                public final void run() {
                    H5AppHandler.finalStartApp(h5StartAppInfo);
                }
            });
        } else {
            finalStartApp(h5StartAppInfo);
        }
    }

    /* access modifiers changed from: private */
    public static void finalStartApp(H5StartAppInfo h5StartAppInfo) {
        String str = TAG;
        H5Log.d(str, "startApp " + h5StartAppInfo.targetAppId + " nebulaAppType:" + h5StartAppInfo.nebulaAppType);
        h5StartAppInfo.params.putString(CHECK_KEY, CHECK_VALUE);
        H5NebulaAppCacheManager.putAppType(h5StartAppInfo.targetAppId, h5StartAppInfo);
        if (h5StartAppInfo.params.containsKey(H5Param.NEBULA_LOADING_VERSION)) {
            h5StartAppInfo.params.remove(H5Param.NEBULA_LOADING_VERSION);
        }
        Bundle bundle = h5StartAppInfo.params;
        bundle.putString(H5Param.NEBULA_LOADING_VERSION, h5StartAppInfo.targetAppId + "_" + h5StartAppInfo.nebulaVersion);
        H5LoadingApp.remove(h5StartAppInfo.targetAppId);
        com.alipay.mobile.framework.b.a().f14954a.a(h5StartAppInfo.sourceAppId, h5StartAppInfo.targetAppId, h5StartAppInfo.params);
    }

    private static void logError(H5StartAppInfo h5StartAppInfo, String str) {
        H5LogProvider h5LogProvider = (H5LogProvider) H5Utils.getProvider(H5LogProvider.class.getName());
        if (h5LogProvider != null) {
            h5LogProvider.log("H5_APP_PREPARE", "monitor", "", "appId=" + h5StartAppInfo.targetAppId + "^step=" + str, (String) null);
        }
    }

    private static void showError(final H5LoadingManager h5LoadingManager, final H5StartAppInfo h5StartAppInfo, String str, AppInfo appInfo, String str2) {
        if ((downloadFail.equals(str) || installFail.equals(str)) && "try".equals(str2)) {
            goFallback(appInfo, new FallBackListen() {
                public final void canGoFallback(boolean z, String str) {
                    String access$200 = H5AppHandler.TAG;
                    H5Log.d(access$200, "goFallback " + z + " reason:" + str);
                    if (z) {
                        h5StartAppInfo.params.remove(H5Param.NEBULA_FORCE_OFFLINE);
                        H5AppHandler.exitAndStartApp(h5StartAppInfo, h5LoadingManager);
                        return;
                    }
                    H5AppHandler.doShowError(h5StartAppInfo, str, h5LoadingManager);
                }
            });
        } else {
            doShowError(h5StartAppInfo, str, h5LoadingManager);
        }
    }

    /* access modifiers changed from: private */
    public static void doShowError(H5StartAppInfo h5StartAppInfo, String str, final H5LoadingManager h5LoadingManager) {
        logError(h5StartAppInfo, str);
        H5DevAppList.getInstance().setUseDevMode(h5StartAppInfo.targetAppId, false);
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            public final void run() {
                H5LoadingManager h5LoadingManager = h5LoadingManager;
                if (h5LoadingManager == null || !h5LoadingManager.isReady()) {
                    H5Log.d(H5AppHandler.TAG, "h5page is null");
                    H5Utils.runOnMain(new Runnable() {
                        public void run() {
                            if (h5LoadingManager == null || !h5LoadingManager.isReady()) {
                                H5Log.d(H5AppHandler.TAG, "h5page is null not try");
                                return;
                            }
                            H5Log.d(H5AppHandler.TAG, "sendToWebFail again");
                            h5LoadingManager.sendToWebFail();
                        }
                    }, 1000);
                    return;
                }
                H5Log.d(H5AppHandler.TAG, "sendToWebFail");
                h5LoadingManager.sendToWebFail();
            }
        }, 1000);
    }

    private static void goFallback(AppInfo appInfo, FallBackListen fallBackListen) {
        final H5FallbackStreamProvider h5FallbackStreamProvider = (H5FallbackStreamProvider) H5Utils.getProvider(H5FallbackStreamProvider.class.getName());
        if (!(h5FallbackStreamProvider == null || appInfo == null)) {
            H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
            if (h5ConfigProvider != null && "no".equalsIgnoreCase(h5ConfigProvider.getConfig("h5_tiny_app_fallback"))) {
                fallBackListen.canGoFallback(false, "configIsClose");
                return;
            } else if (H5Utils.isTinyApp(appInfo) || fallBackListen == null) {
                final String str = appInfo.fallback_base_url + "api_permission";
                final String str2 = appInfo.fallback_base_url + H5StartParamManager.appConfig;
                H5Log.d(TAG, "api_permission " + str + " appConfigUrl:" + str2);
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    final AppInfo appInfo2 = appInfo;
                    final FallBackListen fallBackListen2 = fallBackListen;
                    H5Utils.getExecutor(H5ThreadType.RPC).execute(new Runnable() {
                        public final void run() {
                            try {
                                byte[] readBytes = H5Utils.readBytes(h5FallbackStreamProvider.getFallbackInputStream(str));
                                byte[] readBytes2 = H5Utils.readBytes(h5FallbackStreamProvider.getFallbackInputStream(str2));
                                if (!(readBytes == null || readBytes2 == null)) {
                                    HashMap hashMap = new HashMap();
                                    hashMap.put(appInfo2.version, readBytes);
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put(appInfo2.version, readBytes2);
                                    H5TinyFallBackData.apiPermissionByte.put(appInfo2.app_id, hashMap);
                                    H5TinyFallBackData.appConfigByte.put(appInfo2.app_id, hashMap2);
                                    if (fallBackListen2 != null) {
                                        fallBackListen2.canGoFallback(true, "fallBackSuccess");
                                        return;
                                    }
                                }
                            } catch (Throwable th) {
                                H5Log.e(H5AppHandler.TAG, th);
                            }
                            FallBackListen fallBackListen = fallBackListen2;
                            if (fallBackListen != null) {
                                fallBackListen.canGoFallback(false, "fallbackNetError");
                            }
                        }
                    });
                    return;
                }
            } else {
                fallBackListen.canGoFallback(true, "");
                return;
            }
        }
        if (fallBackListen != null) {
            fallBackListen.canGoFallback(false, "fallbackAppInfoIsEmpty");
        }
    }

    public static boolean useStartApp() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null) {
            return true;
        }
        String config = h5ConfigProvider.getConfig(h5_enablenbhandler);
        return TextUtils.isEmpty(config) || !"no".equalsIgnoreCase(config);
    }

    public static boolean isSyncType(String str) {
        return "syncforce".equals(str) || H5NbOfflineType.sync.equals(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x0106 A[SYNTHETIC, Splitter:B:46:0x0106] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int getTimeout(java.lang.String r8, java.lang.String r9, android.os.Bundle r10, com.alipay.mobile.nebula.appcenter.model.AppInfo r11) {
        /*
            java.lang.Class<com.alipay.mobile.nebula.provider.H5ConfigProvider> r0 = com.alipay.mobile.nebula.provider.H5ConfigProvider.class
            java.lang.String r0 = r0.getName()
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r0)
            com.alipay.mobile.nebula.provider.H5ConfigProvider r0 = (com.alipay.mobile.nebula.provider.H5ConfigProvider) r0
            r1 = -1
            if (r0 == 0) goto L_0x001e
            java.lang.String r2 = "h5_loading_timeout"
            java.lang.String r0 = r0.getConfig(r2)
            java.lang.String r2 = "no"
            boolean r0 = r2.equalsIgnoreCase(r0)
            if (r0 == 0) goto L_0x001e
            return r1
        L_0x001e:
            java.lang.String r0 = "force"
            java.lang.String r2 = "try"
            if (r10 == 0) goto L_0x0078
            java.lang.String r3 = "nbprepareTime"
            java.lang.String r10 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r10, (java.lang.String) r3)
            com.alibaba.a.e r10 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r10)
            if (r10 == 0) goto L_0x0078
            boolean r3 = r10.isEmpty()
            if (r3 != 0) goto L_0x0078
            boolean r3 = isSyncType(r9)
            if (r3 == 0) goto L_0x003f
            r3 = r0
            goto L_0x0040
        L_0x003f:
            r3 = r2
        L_0x0040:
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r10, (java.lang.String) r3)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0078
            int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ all -> 0x0072 }
            java.lang.String r5 = TAG     // Catch:{ all -> 0x0072 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0072 }
            java.lang.String r7 = "data "
            r6.<init>(r7)     // Catch:{ all -> 0x0072 }
            r6.append(r10)     // Catch:{ all -> 0x0072 }
            java.lang.String r10 = " key "
            r6.append(r10)     // Catch:{ all -> 0x0072 }
            r6.append(r3)     // Catch:{ all -> 0x0072 }
            java.lang.String r10 = " "
            r6.append(r10)     // Catch:{ all -> 0x0072 }
            r6.append(r4)     // Catch:{ all -> 0x0072 }
            java.lang.String r10 = r6.toString()     // Catch:{ all -> 0x0072 }
            com.alipay.mobile.nebula.util.H5Log.d(r5, r10)     // Catch:{ all -> 0x0072 }
            return r4
        L_0x0072:
            r10 = move-exception
            java.lang.String r3 = TAG
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r3, (java.lang.Throwable) r10)
        L_0x0078:
            java.lang.Class<com.alipay.mobile.nebula.provider.H5AppProvider> r10 = com.alipay.mobile.nebula.provider.H5AppProvider.class
            java.lang.String r10 = r10.getName()
            java.lang.Object r10 = com.alipay.mobile.nebula.util.H5Utils.getProvider(r10)
            com.alipay.mobile.nebula.provider.H5AppProvider r10 = (com.alipay.mobile.nebula.provider.H5AppProvider) r10
            if (r10 == 0) goto L_0x0116
            java.lang.String r3 = "expireTime"
            java.lang.String r10 = r10.getConfigExtra(r3)
            com.alibaba.a.e r10 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r10)
            java.lang.String r3 = TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r8)
            java.lang.String r8 = " prepareTime :"
            r4.append(r8)
            r4.append(r10)
            java.lang.String r8 = " loadingType:"
            r4.append(r8)
            r4.append(r9)
            java.lang.String r8 = r4.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r3, r8)
            if (r10 == 0) goto L_0x0113
            boolean r8 = r10.isEmpty()
            if (r8 != 0) goto L_0x0113
            java.lang.String r8 = "switch"
            java.lang.String r8 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r10, (java.lang.String) r8)
            java.lang.String r3 = "0"
            boolean r8 = r3.equals(r8)
            if (r8 != 0) goto L_0x0112
            if (r11 == 0) goto L_0x0116
            int r8 = r11.app_channel
            java.lang.String r8 = java.lang.String.valueOf(r8)
            r11 = 0
            com.alibaba.a.e r8 = com.alipay.mobile.nebula.util.H5Utils.getJSONObject(r10, r8, r11)
            if (r8 == 0) goto L_0x00fb
            boolean r10 = r8.isEmpty()
            if (r10 != 0) goto L_0x00fb
            boolean r10 = isSyncType(r9)
            if (r10 == 0) goto L_0x00e4
            goto L_0x00fc
        L_0x00e4:
            java.lang.String r10 = "synctry"
            boolean r10 = android.text.TextUtils.equals(r9, r10)
            if (r10 == 0) goto L_0x00f1
            java.lang.String r0 = "tryup"
            goto L_0x00fc
        L_0x00f1:
            boolean r9 = android.text.TextUtils.equals(r9, r2)
            if (r9 == 0) goto L_0x00fb
            java.lang.String r0 = "tryoff"
            goto L_0x00fc
        L_0x00fb:
            r0 = r11
        L_0x00fc:
            java.lang.String r8 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r8, (java.lang.String) r0)
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x0116
            int r8 = java.lang.Integer.parseInt(r8)     // Catch:{ all -> 0x010b }
            return r8
        L_0x010b:
            r8 = move-exception
            java.lang.String r9 = TAG
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r9, (java.lang.Throwable) r8)
            goto L_0x0116
        L_0x0112:
            return r1
        L_0x0113:
            r8 = 30
            return r8
        L_0x0116:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler.getTimeout(java.lang.String, java.lang.String, android.os.Bundle, com.alipay.mobile.nebula.appcenter.model.AppInfo):int");
    }

    private static H5LoadingManager getLoadingImpl() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null && "no".equalsIgnoreCase(h5ConfigProvider.getConfig("h5_newloadpage"))) {
            return new H5LoadingViewImpl();
        }
        com.alipay.mobile.framework.b.a();
        return new H5LoadingViewImpl();
    }
}
