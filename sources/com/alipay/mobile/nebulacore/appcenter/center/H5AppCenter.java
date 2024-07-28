package com.alipay.mobile.nebulacore.appcenter.center;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.service.H5EventHandlerService;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5EnvProvider;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ParamParser;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebulacore.Nebula;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.business.merchant_payments.settlement.helper.P4BSettlementsDataHelperMP;
import com.sendbird.android.constant.StringSet;
import java.util.Iterator;

public class H5AppCenter {
    private static final String TAG = "H5AppCenter";
    private static final String TINY_APP_CREATE = "com.alipay.mobile.nebula.tinyAppCreate";
    private static H5AppProvider appProvider;

    /* JADX WARNING: Removed duplicated region for block: B:49:0x0165  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.Bundle setupPage(android.os.Bundle r16, boolean r17, boolean r18, com.alipay.mobile.h5container.api.H5Context r19) {
        /*
            r0 = r16
            r1 = r17
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5AppProvider> r4 = com.alipay.mobile.nebula.provider.H5AppProvider.class
            java.lang.String r4 = r4.getName()
            com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl r5 = com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl.getInstance()
            java.lang.Object r4 = r5.getProvider(r4)
            com.alipay.mobile.nebula.provider.H5AppProvider r4 = (com.alipay.mobile.nebula.provider.H5AppProvider) r4
            appProvider = r4
            java.lang.String r4 = "appId"
            java.lang.String r5 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r0, (java.lang.String) r4)
            boolean r6 = com.alipay.mobile.nebula.util.H5Utils.isMainProcess()
            java.lang.String r7 = "isNotTinyProcess"
            r0.putBoolean(r7, r6)
            com.alipay.mobile.nebula.provider.H5AppProvider r6 = appProvider
            r8 = 0
            if (r6 == 0) goto L_0x0036
            boolean r6 = r6.isH5App(r5)
            if (r6 == 0) goto L_0x0036
            r6 = 1
            goto L_0x0037
        L_0x0036:
            r6 = 0
        L_0x0037:
            com.alipay.mobile.nebula.provider.H5AppProvider r9 = appProvider
            if (r9 == 0) goto L_0x0043
            boolean r9 = r9.isNebulaApp(r5)
            if (r9 == 0) goto L_0x0043
            r9 = 1
            goto L_0x0044
        L_0x0043:
            r9 = 0
        L_0x0044:
            if (r9 == 0) goto L_0x0047
            r6 = 1
        L_0x0047:
            java.lang.String r10 = "isH5app"
            r0.putBoolean(r10, r6)
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "setupPage appId "
            r10.<init>(r11)
            r10.append(r5)
            java.lang.String r11 = " isH5App "
            r10.append(r11)
            r10.append(r6)
            java.lang.String r11 = " isNebulaApp:"
            r10.append(r11)
            r10.append(r9)
            java.lang.String r10 = r10.toString()
            java.lang.String r11 = "H5AppCenter"
            com.alipay.mobile.nebula.util.H5Log.d(r11, r10)
            java.lang.String r10 = "isNebulaApp"
            r0.putBoolean(r10, r9)
            boolean r10 = com.alipay.mobile.nebula.appcenter.util.H5AppUtil.isH5ContainerAppId(r5)
            if (r10 != 0) goto L_0x0081
            r0.putString(r4, r5)
            setupH5App(r0, r9, r1)
        L_0x0081:
            boolean r10 = com.alipay.mobile.h5container.api.H5Flag.ucReady
            if (r10 != 0) goto L_0x0093
            java.lang.String r10 = "firstInitNotInitGlobalPackage"
            boolean r10 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r0, (java.lang.String) r10, (boolean) r8)
            if (r10 == 0) goto L_0x0093
            java.lang.String r10 = "!H5Flag.ucReady && FIRST_INIT_USE_ANDROID_WEBVIEW not H5GlobalPackage.prepare()"
            com.alipay.mobile.nebula.util.H5Log.d(r11, r10)
            goto L_0x00a7
        L_0x0093:
            boolean r10 = com.alipay.mobile.nebula.util.H5Utils.isInTinyProcess()
            if (r10 != 0) goto L_0x00a7
            java.lang.String r10 = "IO"
            java.util.concurrent.ThreadPoolExecutor r10 = com.alipay.mobile.nebula.util.H5Utils.getExecutor(r10)
            com.alipay.mobile.nebulacore.appcenter.center.H5AppCenter$1 r12 = new com.alipay.mobile.nebulacore.appcenter.center.H5AppCenter$1
            r12.<init>()
            r10.execute(r12)
        L_0x00a7:
            checkAcceleratePackage(r5, r0)
            initTinyAppRes(r0, r8)
            addLauncherParamResourcePackage(r5, r0)
            java.lang.String r10 = "isTinyApp"
            boolean r10 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r0, (java.lang.String) r10, (boolean) r8)
            if (r10 == 0) goto L_0x00f3
            java.lang.String r12 = "appVersion"
            java.lang.String r13 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r0, (java.lang.String) r12)
            android.content.Context r14 = com.alipay.mobile.nebula.util.H5Utils.getContext()
            androidx.localbroadcastmanager.a.a r14 = androidx.localbroadcastmanager.a.a.a((android.content.Context) r14)
            android.content.Intent r15 = new android.content.Intent
            r15.<init>()
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "tinyApp create, appId is "
            r7.<init>(r8)
            r7.append(r5)
            java.lang.String r8 = " , appVersion is "
            r7.append(r8)
            r7.append(r13)
            java.lang.String r7 = r7.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r11, r7)
            java.lang.String r7 = "com.alipay.mobile.nebula.tinyAppCreate"
            r15.setAction(r7)
            r15.putExtra(r4, r5)
            r15.putExtra(r12, r13)
            r14.a((android.content.Intent) r15)
        L_0x00f3:
            java.lang.String r4 = "launchParamsTag"
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r0, (java.lang.String) r4)
            java.lang.String r7 = "page"
            java.lang.String r7 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r0, (java.lang.String) r7)
            boolean r8 = android.text.TextUtils.isEmpty(r7)
            if (r8 != 0) goto L_0x0113
            java.lang.String r4 = java.lang.String.valueOf(r7)
            java.lang.String r8 = " get launchParamsTag from page:"
            java.lang.String r4 = r8.concat(r4)
            com.alipay.mobile.nebula.util.H5Log.d(r11, r4)
            r4 = r7
        L_0x0113:
            long r7 = java.lang.System.currentTimeMillis()
            r12 = 0
            if (r9 == 0) goto L_0x0132
            if (r10 == 0) goto L_0x0121
            android.os.ConditionVariable r12 = new android.os.ConditionVariable
            r12.<init>()
        L_0x0121:
            boolean r9 = android.text.TextUtils.isEmpty(r4)
            if (r9 != 0) goto L_0x012e
            if (r12 != 0) goto L_0x012e
            android.os.ConditionVariable r12 = new android.os.ConditionVariable
            r12.<init>()
        L_0x012e:
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackagePool.preparePackage(r0, r1, r12)
            goto L_0x013f
        L_0x0132:
            com.alipay.mobile.nebula.provider.H5AppProvider r9 = appProvider
            if (r9 == 0) goto L_0x0141
            boolean r9 = r9.hasPackage(r5, r12)
            if (r9 == 0) goto L_0x0141
            com.alipay.mobile.nebulacore.appcenter.parse.H5ContentPackagePool.preparePackage(r0, r1, r12)
        L_0x013f:
            r1 = 1
            goto L_0x0142
        L_0x0141:
            r1 = 0
        L_0x0142:
            java.lang.String r9 = "hasH5Pkg"
            r0.putBoolean(r9, r1)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r9 = "H5ContentPackagePool.preparePackage cost "
            r1.<init>(r9)
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r7
            r1.append(r9)
            java.lang.String r1 = r1.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r11, r1)
            java.lang.String r1 = "backBehavior"
            boolean r7 = com.alipay.mobile.nebula.util.H5Utils.contains((android.os.Bundle) r0, (java.lang.String) r1)
            if (r7 != 0) goto L_0x0189
            if (r6 == 0) goto L_0x016a
            java.lang.String r6 = "pop"
            goto L_0x016c
        L_0x016a:
            java.lang.String r6 = "back"
        L_0x016c:
            r0.putString(r1, r6)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r7 = "set "
            r1.<init>(r7)
            r1.append(r5)
            java.lang.String r7 = " back behavior as "
            r1.append(r7)
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r11, r1)
        L_0x0189:
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L_0x01b0
            com.alipay.mobile.nebula.startParam.H5StartParamManager r1 = com.alipay.mobile.nebula.startParam.H5StartParamManager.getInstance()
            android.os.Bundle r1 = r1.getH5StartParam(r5, r4)
            if (r1 == 0) goto L_0x01d2
            boolean r4 = r1.isEmpty()
            if (r4 != 0) goto L_0x01d2
            java.lang.String r4 = java.lang.String.valueOf(r1)
            java.lang.String r5 = "launchParamsTag "
            java.lang.String r4 = r5.concat(r4)
            com.alipay.mobile.nebula.util.H5Log.d(r11, r4)
            r0.putAll(r1)
            goto L_0x01d2
        L_0x01b0:
            com.alipay.mobile.nebula.startParam.H5StartParamManager r1 = com.alipay.mobile.nebula.startParam.H5StartParamManager.getInstance()
            java.lang.String r4 = "index"
            android.os.Bundle r1 = r1.getH5StartParam(r5, r4)
            if (r1 == 0) goto L_0x01d2
            boolean r4 = r1.isEmpty()
            if (r4 != 0) goto L_0x01d2
            java.lang.String r4 = java.lang.String.valueOf(r1)
            java.lang.String r5 = "launcher "
            java.lang.String r4 = r5.concat(r4)
            com.alipay.mobile.nebula.util.H5Log.d(r11, r4)
            r0.putAll(r1)
        L_0x01d2:
            com.alipay.mobile.nebula.util.H5ParamParser.parseMagicOptions(r0, r11)
            r1 = 0
            com.alipay.mobile.nebula.util.H5ParamParser.parse(r0, r1)
            java.lang.String r4 = "preAuth"
            boolean r5 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r0, (java.lang.String) r4, (boolean) r1)
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r0, (java.lang.String) r4)
            if (r5 != 0) goto L_0x01f5
            java.lang.String r5 = "YES"
            boolean r5 = r5.equalsIgnoreCase(r4)
            if (r5 != 0) goto L_0x01f5
            java.lang.String r5 = "TRUE"
            boolean r4 = r5.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x01f6
        L_0x01f5:
            r1 = 1
        L_0x01f6:
            java.lang.String r4 = "requestPreAuth"
            r0.putBoolean(r4, r1)
            java.lang.String r1 = "prepare_app"
            com.alipay.mobile.nebulacore.util.H5TimeUtil.timeLog(r1, r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.appcenter.center.H5AppCenter.setupPage(android.os.Bundle, boolean, boolean, com.alipay.mobile.h5container.api.H5Context):android.os.Bundle");
    }

    public static void initTinyAppRes(Bundle bundle, boolean z) {
        H5AppCenterPresetProvider h5AppCenterPresetProvider;
        boolean equalsIgnoreCase = H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Utils.getString(bundle, "tinyPubRes"));
        if ((H5Utils.getBoolean(bundle, H5Param.isTinyApp, false) || equalsIgnoreCase) && (h5AppCenterPresetProvider = (H5AppCenterPresetProvider) Nebula.getProviderManager().getProvider(H5AppCenterPresetProvider.class.getName())) != null) {
            String tinyCommonApp = h5AppCenterPresetProvider.getTinyCommonApp();
            if (!TextUtils.isEmpty(tinyCommonApp) && (!"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_addTinyRes")))) {
                H5GlobalPackage.addResourcePackage(H5GlobalPackage.TINY_RES_KEY, tinyCommonApp, false, z);
            }
        }
    }

    private static boolean openInstallVersion() {
        return !"no".equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_useInstallVersion"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01e6  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01ee  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x023d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x024a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.os.Bundle setupH5App(android.os.Bundle r18, boolean r19, boolean r20) {
        /*
            r1 = r18
            com.alipay.mobile.nebula.provider.H5AppProvider r0 = appProvider
            java.lang.String r2 = "H5AppCenter"
            if (r0 != 0) goto L_0x000e
            java.lang.String r0 = "failed to get app info!"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r2, (java.lang.String) r0)
            return r1
        L_0x000e:
            r3 = 0
            java.lang.String r0 = "appId"
            java.lang.String r12 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r1, (java.lang.String) r0)
            java.lang.String r0 = "nebula_loading_version"
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r1, (java.lang.String) r0)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            java.lang.String r13 = ""
            r14 = 1
            if (r5 != 0) goto L_0x007e
            boolean r5 = r4.startsWith(r12)
            if (r5 == 0) goto L_0x007e
            boolean r5 = openInstallVersion()
            if (r5 == 0) goto L_0x007e
            r1.remove(r0)     // Catch:{ all -> 0x0078 }
            java.lang.String r0 = "_"
            java.lang.String[] r0 = r4.split(r0)     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x007e
            int r4 = r0.length     // Catch:{ all -> 0x0078 }
            r5 = 2
            if (r4 != r5) goto L_0x007e
            r4 = r0[r14]     // Catch:{ all -> 0x0078 }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0078 }
            if (r0 != 0) goto L_0x007e
            java.lang.Class<com.alipay.mobile.h5container.service.H5AppCenterService> r0 = com.alipay.mobile.h5container.service.H5AppCenterService.class
            java.lang.String r0 = r0.getName()     // Catch:{ all -> 0x0078 }
            java.lang.Object r0 = com.alipay.mobile.nebula.util.H5Utils.findServiceByInterface(r0)     // Catch:{ all -> 0x0078 }
            com.alipay.mobile.h5container.service.H5AppCenterService r0 = (com.alipay.mobile.h5container.service.H5AppCenterService) r0     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x007e
            com.alipay.mobile.nebula.appcenter.H5AppDBService r0 = r0.getAppDBService()     // Catch:{ all -> 0x0078 }
            if (r0 == 0) goto L_0x007e
            com.alipay.mobile.nebula.appcenter.model.AppInfo r3 = r0.getAppInfo(r12, r4)     // Catch:{ all -> 0x0078 }
            if (r3 == 0) goto L_0x0072
            java.lang.String r0 = "use loadingVer "
            java.lang.String r5 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0070 }
            java.lang.String r0 = r0.concat(r5)     // Catch:{ all -> 0x0070 }
            com.alipay.mobile.nebula.util.H5Log.d(r2, r0)     // Catch:{ all -> 0x0070 }
            goto L_0x007f
        L_0x0070:
            r0 = move-exception
            goto L_0x007a
        L_0x0072:
            java.lang.String r0 = "appInfo is null not use installAppVersion"
            com.alipay.mobile.nebula.util.H5Log.d(r2, r0)     // Catch:{ all -> 0x0078 }
            goto L_0x007e
        L_0x0078:
            r0 = move-exception
            r4 = r13
        L_0x007a:
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r2, (java.lang.Throwable) r0)
            goto L_0x007f
        L_0x007e:
            r4 = r13
        L_0x007f:
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0098
            com.alipay.mobile.nebula.provider.H5AppProvider r0 = appProvider
            java.lang.String r4 = r0.getVersion(r12)
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r5 = "get appVersion "
            java.lang.String r0 = r5.concat(r0)
            com.alipay.mobile.nebula.util.H5Log.d(r2, r0)
        L_0x0098:
            java.lang.String r0 = "installVersion"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r1, (java.lang.String) r0)
            boolean r5 = android.text.TextUtils.isEmpty(r0)
            if (r5 != 0) goto L_0x00b3
            java.lang.String r4 = java.lang.String.valueOf(r0)
            java.lang.String r5 = "use installVersion "
            java.lang.String r4 = r5.concat(r4)
            com.alipay.mobile.nebula.util.H5Log.d(r2, r4)
            goto L_0x00b4
        L_0x00b3:
            r0 = r4
        L_0x00b4:
            java.lang.String r4 = java.lang.String.valueOf(r0)
            java.lang.String r5 = "appCenterVersion: "
            java.lang.String r4 = r5.concat(r4)
            com.alipay.mobile.nebula.util.H5Log.d(r2, r4)
            if (r19 == 0) goto L_0x00c8
            if (r20 != 0) goto L_0x00c8
            com.alipay.mobile.nebula.appcenter.util.H5AppUtil.setH5AppCenterProvider(r12, r0)
        L_0x00c8:
            java.lang.String r4 = "appVersion"
            r1.putString(r4, r0)
            java.lang.String r4 = "version"
            r1.putString(r4, r0)
            if (r3 != 0) goto L_0x00db
            com.alipay.mobile.nebula.provider.H5AppProvider r3 = appProvider
            com.alipay.mobile.nebula.appcenter.model.AppInfo r3 = r3.getAppInfo(r12, r0)
        L_0x00db:
            if (r3 == 0) goto L_0x00f3
            java.lang.String r4 = r3.release_type
            java.lang.String r5 = "release_type"
            r1.putString(r5, r4)
            java.lang.String r4 = r3.extend_info_jo
            com.alibaba.a.e r4 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r4)
            java.lang.String r5 = "package_nick"
            java.lang.String r4 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r4, (java.lang.String) r5)
            r1.putString(r5, r4)
        L_0x00f3:
            boolean r3 = com.alipay.mobile.nebula.util.H5Utils.isTinyApp(r3)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r12)
            java.lang.String r5 = " isH5tinyApp "
            r4.append(r5)
            r4.append(r3)
            java.lang.String r4 = r4.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r2, r4)
            if (r3 == 0) goto L_0x011b
            java.lang.String r4 = "isH5app"
            r1.putBoolean(r4, r14)
            r4 = 4
            java.lang.String r5 = "app_channel"
            r1.putInt(r5, r4)
        L_0x011b:
            java.lang.String r15 = "isTinyApp"
            r1.putBoolean(r15, r3)
            com.alipay.mobile.nebula.provider.H5AppProvider r4 = appProvider
            java.lang.String r4 = r4.getH5AppCdnBaseUrl(r12, r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "appId "
            r5.<init>(r6)
            r5.append(r12)
            java.lang.String r7 = " appVersion"
            r5.append(r7)
            r5.append(r0)
            java.lang.String r7 = "  cdnHost "
            r5.append(r7)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r2, r5)
            java.lang.String r5 = "debugCdn"
            java.lang.String r5 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r1, (java.lang.String) r5)
            android.content.Context r7 = com.alipay.mobile.nebula.util.H5Utils.getContext()
            boolean r7 = com.alipay.mobile.nebula.util.H5Utils.isDebuggable(r7)
            if (r7 == 0) goto L_0x016f
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 != 0) goto L_0x016f
            java.lang.String r4 = java.net.URLDecoder.decode(r5)
            java.lang.String r5 = java.lang.String.valueOf(r4)
            java.lang.String r7 = "set cdn host as debugCdn "
            java.lang.String r5 = r7.concat(r5)
            com.alipay.mobile.nebula.util.H5Log.d(r2, r5)
        L_0x016f:
            java.lang.String r5 = "cdnBaseUrl"
            r1.putString(r5, r4)
            com.alipay.mobile.nebula.provider.H5AppProvider r4 = appProvider
            java.lang.String r11 = r4.getInstallPath(r12, r0)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r6)
            r4.append(r12)
            java.lang.String r5 = " installPath "
            r4.append(r5)
            r4.append(r11)
            java.lang.String r4 = r4.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r2, r4)
            boolean r4 = android.text.TextUtils.isEmpty(r11)
            if (r4 == 0) goto L_0x01e6
            com.alipay.mobile.nebula.provider.H5AppProvider r4 = appProvider
            boolean r4 = r4.hasPackage(r12, r0)
            if (r4 == 0) goto L_0x01e6
            com.alipay.mobile.nebula.provider.H5ProviderManager r4 = com.alipay.mobile.nebulacore.Nebula.getProviderManager()
            java.lang.Class<com.alipay.mobile.nebula.provider.H5LogProvider> r5 = com.alipay.mobile.nebula.provider.H5LogProvider.class
            java.lang.String r5 = r5.getName()
            java.lang.Object r4 = r4.getProvider(r5)
            com.alipay.mobile.nebula.provider.H5LogProvider r4 = (com.alipay.mobile.nebula.provider.H5LogProvider) r4
            if (r4 == 0) goto L_0x01e6
            com.alipay.mobile.nebula.provider.H5AppProvider r5 = appProvider
            boolean r5 = r5.isInstalled(r12, r0)
            java.lang.String r7 = java.lang.String.valueOf(r5)
            java.lang.String r5 = "url"
            java.lang.String r8 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r1, (java.lang.String) r5)
            r9 = 0
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            java.lang.String r6 = "appId="
            r5.<init>(r6)
            r5.append(r12)
            java.lang.String r6 = "^version="
            r5.append(r6)
            r5.append(r0)
            java.lang.String r10 = r5.toString()
            java.lang.String r5 = "H5_APP_UNZIPPATH_ERROR"
            java.lang.String r16 = "H-MM"
            r6 = r12
            r17 = r11
            r11 = r16
            r4.logV2(r5, r6, r7, r8, r9, r10, r11)
            goto L_0x01e8
        L_0x01e6:
            r17 = r11
        L_0x01e8:
            boolean r4 = android.text.TextUtils.isEmpty(r17)
            if (r4 != 0) goto L_0x0214
            java.lang.String r4 = java.lang.String.valueOf(r17)
            java.lang.String r5 = "file://"
            java.lang.String r4 = r5.concat(r4)
            java.lang.String r5 = "/"
            boolean r6 = r4.endsWith(r5)
            if (r6 != 0) goto L_0x020f
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r4)
            r6.append(r5)
            java.lang.String r4 = r6.toString()
        L_0x020f:
            java.lang.String r5 = "offlineHost"
            r1.putString(r5, r4)
        L_0x0214:
            com.alipay.mobile.nebula.provider.H5AppProvider r4 = appProvider
            java.lang.String r4 = r4.getExtraJo(r12, r0)
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x0242
            com.alibaba.a.e r4 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r4)
            if (r4 == 0) goto L_0x0242
            boolean r5 = r4.isEmpty()
            if (r5 != 0) goto L_0x0242
            java.lang.String r5 = "usePresetPopmenu"
            java.lang.String r4 = r4.getString(r5)
            boolean r6 = android.text.TextUtils.isEmpty(r4)
            if (r6 != 0) goto L_0x023d
            r1.putString(r5, r4)
            goto L_0x0242
        L_0x023d:
            java.lang.String r4 = "NO"
            r1.putString(r5, r4)
        L_0x0242:
            com.alipay.mobile.nebula.provider.H5AppProvider r4 = appProvider
            java.util.Map r0 = r4.getExtra(r12, r0)
            if (r0 == 0) goto L_0x028f
            java.lang.String r4 = "launchParams"
            java.lang.Object r5 = r0.get(r4)
            r13 = r5
            java.lang.String r13 = (java.lang.String) r13
            boolean r5 = android.text.TextUtils.isEmpty(r13)
            if (r5 != 0) goto L_0x027b
            r1.putString(r4, r13)
            initAppParams(r13, r1)
            boolean r4 = com.alipay.mobile.nebula.appcenter.util.H5AppUtil.enableDSL(r18)
            if (r4 == 0) goto L_0x027b
            java.lang.String r4 = "h5_enableDSL"
            java.lang.String r4 = com.alipay.mobile.nebulacore.env.H5Environment.getConfig(r4)
            java.lang.String r5 = "no"
            boolean r4 = r5.equalsIgnoreCase(r4)
            if (r4 != 0) goto L_0x027b
            java.lang.String r4 = "enableDSL set isTinyApp true"
            com.alipay.mobile.nebula.util.H5Log.d(r2, r4)
            r1.putBoolean(r15, r14)
        L_0x027b:
            java.lang.String r2 = "host"
            java.lang.Object r0 = r0.get(r2)
            java.lang.String r0 = (java.lang.String) r0
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            if (r4 != 0) goto L_0x028f
            r1.putString(r2, r0)
            initAppHost(r0, r1)
        L_0x028f:
            initAppUrl(r12, r1, r13, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.appcenter.center.H5AppCenter.setupH5App(android.os.Bundle, boolean, boolean):android.os.Bundle");
    }

    private static void initAppParams(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            H5Log.w(TAG, "invalid launch parameters");
        } else {
            H5ParamParser.setLauncherParams(H5Utils.parseObject(str), bundle);
        }
    }

    private static void initAppHost(String str, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            H5Log.w(TAG, "invalid app host parameters");
            return;
        }
        e parseObject = H5Utils.parseObject(str);
        if (parseObject == null || parseObject.isEmpty()) {
            H5Log.w(TAG, "can't parse host parameter as json");
            return;
        }
        boolean z = H5Utils.getBoolean(parseObject, "enable", true);
        H5Log.w(TAG, "map host enabled ".concat(String.valueOf(z)));
        bundle.putBoolean(H5Param.MAP_HOST, z);
        String str2 = null;
        if (H5Utils.isDebuggable(H5Utils.getContext())) {
            H5ProviderManager h5ProviderManager = H5Utils.getH5ProviderManager();
            H5EnvProvider h5EnvProvider = h5ProviderManager != null ? (H5EnvProvider) h5ProviderManager.getProvider(H5EnvProvider.class.getName()) : null;
            if (h5EnvProvider != null) {
                str2 = h5EnvProvider.getRpcUrl();
            }
            if (!TextUtils.isEmpty(str2) && str2.contains("alipay.com")) {
                str2 = H5Utils.getString(parseObject, P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT);
            } else if (!TextUtils.isEmpty(str2) && str2.contains("test.alipay.net")) {
                str2 = H5Utils.getString(parseObject, "test");
            } else if (TextUtils.isEmpty(str2) || !str2.contains("mobilegwpre.alipay.com")) {
                str2 = H5Utils.getString(parseObject, "dev");
            } else {
                str2 = H5Utils.getString(parseObject, "pre");
            }
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = H5Utils.getString(parseObject, P4BSettlementsDataHelperMP.ONLINE_SETTLEMENT);
        }
        if (!TextUtils.isEmpty(str2) && !str2.endsWith("/")) {
            str2 = str2 + "/";
        }
        bundle.putString(H5Param.ONLINE_HOST, str2);
        Nebula.clearServiceWork(bundle);
        H5EventHandlerService h5EventHandlerService = (H5EventHandlerService) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
        if (h5EventHandlerService != null) {
            h5EventHandlerService.setStartParams(bundle);
        }
        H5Log.d(TAG, "onlineHost ".concat(String.valueOf(str2)));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b0  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void initAppUrl(java.lang.String r10, android.os.Bundle r11, java.lang.String r12, boolean r13) {
        /*
            java.lang.String r0 = "entry"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r11, (java.lang.String) r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0017
            java.lang.String r0 = "urlInBase64"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r11, (java.lang.String) r0)
            r1 = 0
            goto L_0x0018
        L_0x0017:
            r1 = 1
        L_0x0018:
            boolean r4 = android.text.TextUtils.isEmpty(r0)
            java.lang.String r5 = "H5AppCenter"
            r6 = 0
            if (r4 != 0) goto L_0x003d
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.base64ToString(r0, r3)     // Catch:{ IllegalArgumentException -> 0x0037 }
            if (r1 == 0) goto L_0x0035
            java.lang.String r1 = "/www/"
            java.lang.String r4 = java.lang.String.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x0032 }
            java.lang.String r0 = r1.concat(r4)     // Catch:{ IllegalArgumentException -> 0x0032 }
            goto L_0x0035
        L_0x0032:
            r1 = move-exception
            r6 = r0
            goto L_0x0038
        L_0x0035:
            r6 = r0
            goto L_0x003d
        L_0x0037:
            r1 = move-exception
        L_0x0038:
            java.lang.String r0 = "exception detail"
            com.alipay.mobile.nebula.util.H5Log.e(r5, r0, r1)
        L_0x003d:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r1 = "url"
            if (r0 == 0) goto L_0x0057
            java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r11, (java.lang.String) r1)
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r4 = "getUrl form LONG_URL:"
            java.lang.String r0 = r4.concat(r0)
            com.alipay.mobile.nebula.util.H5Log.d(r5, r0)
        L_0x0057:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            java.lang.String r4 = "u"
            if (r0 == 0) goto L_0x0071
            java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r11, (java.lang.String) r4)
            java.lang.String r0 = java.lang.String.valueOf(r6)
            java.lang.String r7 = "getUrl form URL:"
            java.lang.String r0 = r7.concat(r0)
            com.alipay.mobile.nebula.util.H5Log.d(r5, r0)
        L_0x0071:
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x00aa
            boolean r0 = android.text.TextUtils.isEmpty(r12)
            if (r0 != 0) goto L_0x00aa
            com.alibaba.a.e r12 = com.alipay.mobile.nebula.util.H5Utils.parseObject(r12)
            java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r12, (java.lang.String) r1)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            if (r0 == 0) goto L_0x009d
            java.lang.String r6 = com.alipay.mobile.nebula.util.H5Utils.getString((com.alibaba.a.e) r12, (java.lang.String) r4)
            java.lang.String r12 = java.lang.String.valueOf(r6)
            java.lang.String r0 = "getUrl form launchParams u "
            java.lang.String r12 = r0.concat(r12)
            com.alipay.mobile.nebula.util.H5Log.d(r5, r12)
            goto L_0x00aa
        L_0x009d:
            java.lang.String r12 = java.lang.String.valueOf(r6)
            java.lang.String r0 = "getUrl form launchParams url "
            java.lang.String r12 = r0.concat(r12)
            com.alipay.mobile.nebula.util.H5Log.d(r5, r12)
        L_0x00aa:
            boolean r12 = android.text.TextUtils.isEmpty(r6)
            if (r12 == 0) goto L_0x00b6
            java.lang.String r10 = "both url and entry are empty, FATAL_ERROR!"
            com.alipay.mobile.nebula.util.H5Log.e((java.lang.String) r5, (java.lang.String) r10)
            return
        L_0x00b6:
            java.lang.String r12 = "onlineHost"
            java.lang.String r12 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r11, (java.lang.String) r12)
            java.lang.String r0 = "offlineHost"
            java.lang.String r0 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r11, (java.lang.String) r0)
            java.lang.String r7 = "mapHost"
            boolean r7 = com.alipay.mobile.nebula.util.H5Utils.getBoolean((android.os.Bundle) r11, (java.lang.String) r7, (boolean) r3)
            java.lang.String r8 = "/"
            boolean r9 = r6.startsWith(r8)
            if (r9 == 0) goto L_0x00d8
            int r9 = r6.length()
            java.lang.String r6 = r6.substring(r2, r9)
        L_0x00d8:
            android.net.Uri r9 = com.alipay.mobile.nebula.util.H5UrlHelper.parseUrl(r6)
            if (r9 == 0) goto L_0x010c
            java.lang.String r9 = r9.getScheme()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 == 0) goto L_0x010c
            if (r7 == 0) goto L_0x00fa
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r12)
            r0.append(r6)
            java.lang.String r12 = r0.toString()
            goto L_0x0109
        L_0x00fa:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r0)
            r12.append(r6)
            java.lang.String r12 = r12.toString()
        L_0x0109:
            r6 = r12
            r12 = r7
            goto L_0x0129
        L_0x010c:
            boolean r7 = android.text.TextUtils.isEmpty(r12)
            if (r7 != 0) goto L_0x011a
            boolean r12 = r6.startsWith(r12)
            if (r12 == 0) goto L_0x011a
            r12 = 1
            goto L_0x0129
        L_0x011a:
            boolean r12 = android.text.TextUtils.isEmpty(r0)
            if (r12 != 0) goto L_0x0128
            boolean r12 = r6.startsWith(r0)
            if (r12 == 0) goto L_0x0128
            r12 = 0
            goto L_0x0129
        L_0x0128:
            r12 = 2
        L_0x0129:
            if (r13 != 0) goto L_0x013a
            java.lang.String r13 = "enableDSL"
            java.lang.String r13 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r11, (java.lang.String) r13)
            java.lang.String r0 = "yes"
            boolean r13 = r0.equalsIgnoreCase(r13)
            if (r13 == 0) goto L_0x017c
        L_0x013a:
            java.lang.String r13 = "page"
            java.lang.String r13 = com.alipay.mobile.nebula.util.H5Utils.getString((android.os.Bundle) r11, (java.lang.String) r13)
            boolean r0 = android.text.TextUtils.isEmpty(r13)
            if (r0 != 0) goto L_0x017c
            r0 = 35
            int r0 = r6.indexOf(r0)
            r7 = -1
            if (r0 == r7) goto L_0x017c
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r9 = "page:"
            r7.<init>(r9)
            r7.append(r13)
            java.lang.String r9 = " beforeUrl "
            r7.append(r9)
            r7.append(r6)
            java.lang.String r7 = r7.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r5, r7)
            int r0 = r0 + r2
            java.lang.String r0 = r6.substring(r3, r0)
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            r2.append(r13)
            java.lang.String r6 = r2.toString()
        L_0x017c:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            java.lang.String r0 = "set final url "
            r13.<init>(r0)
            r13.append(r6)
            java.lang.String r0 = " appType "
            r13.append(r0)
            r13.append(r12)
            java.lang.String r13 = r13.toString()
            com.alipay.mobile.nebula.util.H5Log.d(r5, r13)
            com.alipay.mobile.h5container.api.H5PageLoader.mainUrl = r6
            r11.putString(r1, r6)
            r11.remove(r4)
            java.lang.String r13 = "appType"
            r11.putInt(r13, r12)
            boolean r11 = r6.startsWith(r8)
            if (r11 == 0) goto L_0x01c0
            java.lang.String r11 = "h5_getAppFromServer"
            java.lang.String r11 = com.alipay.mobile.nebulacore.env.H5Environment.getConfig(r11)
            java.lang.String r12 = "no"
            boolean r11 = r12.equalsIgnoreCase(r11)
            if (r11 == 0) goto L_0x01b8
            return
        L_0x01b8:
            com.alipay.mobile.nebula.provider.H5AppProvider r11 = appProvider
            if (r11 != 0) goto L_0x01bd
            return
        L_0x01bd:
            r11.getAppFromServerWhenAppIsEmpty(r10)
        L_0x01c0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.nebulacore.appcenter.center.H5AppCenter.initAppUrl(java.lang.String, android.os.Bundle, java.lang.String, boolean):void");
    }

    private static void checkAcceleratePackage(String str, Bundle bundle) {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName());
        String acceleratePackageId = getAcceleratePackageId(bundle.getString("url"));
        if (!TextUtils.isEmpty(acceleratePackageId)) {
            b parseArray = h5ConfigProvider != null ? H5Utils.parseArray(h5ConfigProvider.getConfig("h5_apPkgSrcWhitelist")) : null;
            H5Log.d(TAG, "acceleratePackageId: ".concat(String.valueOf(acceleratePackageId)));
            if (parseArray != null && parseArray.contains(bundle.getString("appId"))) {
                H5Log.d(TAG, "check acceleratePackage");
                H5AppProvider h5AppProvider = appProvider;
                if (h5AppProvider != null && h5AppProvider.hasPackage(acceleratePackageId, (String) null)) {
                    H5GlobalPackage.addResourcePackage(str, acceleratePackageId, false, false);
                }
            }
        }
    }

    private static String getAcceleratePackageId(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return H5UrlHelper.getParam(H5UrlHelper.parseUrl(str), "_apPkgId", "");
    }

    private static void addLauncherParamResourcePackage(String str, Bundle bundle) {
        H5ConfigProvider h5ConfigProvider;
        b parseArray = H5Utils.parseArray(H5Utils.getString(bundle, "nbpkgres"));
        if (parseArray != null && !parseArray.isEmpty() && (h5ConfigProvider = (H5ConfigProvider) Nebula.getProviderManager().getProvider(H5ConfigProvider.class.getName())) != null) {
            e parseObject = H5Utils.parseObject(h5ConfigProvider.getConfig("h5_pkgresmode"));
            String string = H5Utils.getString(parseObject, "switchextend");
            int i2 = 3;
            try {
                i2 = Integer.parseInt(H5Utils.getString(parseObject, "limit", "3"));
            } catch (NumberFormatException e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
            if (!StringSet.off.equalsIgnoreCase(string)) {
                try {
                    if (parseArray.size() <= 0) {
                        return;
                    }
                    if (parseArray.size() > i2) {
                        H5Log.d(TAG, "packageList.size() : " + parseArray.size() + " limit : " + i2);
                        return;
                    }
                    Iterator<Object> it2 = parseArray.iterator();
                    while (it2.hasNext()) {
                        Object next = it2.next();
                        if (!next.equals(str)) {
                            H5GlobalPackage.addResourcePackage(str, (String) next, true, false);
                        }
                    }
                } catch (Throwable th) {
                    H5Log.e(TAG, th);
                }
            }
        }
    }
}
