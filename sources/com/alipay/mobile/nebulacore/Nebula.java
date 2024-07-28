package com.alipay.mobile.nebulacore;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.widget.Toast;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.framework.app.f;
import com.alipay.mobile.h5container.api.H5Bridge;
import com.alipay.mobile.h5container.api.H5BridgeContext;
import com.alipay.mobile.h5container.api.H5CallBack;
import com.alipay.mobile.h5container.api.H5Context;
import com.alipay.mobile.h5container.api.H5CoreNode;
import com.alipay.mobile.h5container.api.H5Event;
import com.alipay.mobile.h5container.api.H5ImageListener;
import com.alipay.mobile.h5container.api.H5ImageLoader;
import com.alipay.mobile.h5container.api.H5Page;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.h5container.api.H5PluginManager;
import com.alipay.mobile.h5container.api.H5Session;
import com.alipay.mobile.h5container.service.H5EventHandlerService;
import com.alipay.mobile.h5container.service.H5Service;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.download.H5DownloadCallback;
import com.alipay.mobile.nebula.appcenter.res.H5ResourceManager;
import com.alipay.mobile.nebula.appcenter.util.H5AppInstallStep;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.callback.H5AppInstallProcess;
import com.alipay.mobile.nebula.dev.H5BugMeManager;
import com.alipay.mobile.nebula.process.H5EventHandler;
import com.alipay.mobile.nebula.provider.H5ActivityProvider;
import com.alipay.mobile.nebula.provider.H5AppCenterPresetProvider;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.provider.H5EnvProvider;
import com.alipay.mobile.nebula.provider.H5ImageProvider;
import com.alipay.mobile.nebula.provider.H5LogProvider;
import com.alipay.mobile.nebula.provider.H5ProviderManager;
import com.alipay.mobile.nebula.tinypermission.H5ApiManager;
import com.alipay.mobile.nebula.util.H5FileUtil;
import com.alipay.mobile.nebula.util.H5ImageUtil;
import com.alipay.mobile.nebula.util.H5KeepAliveUtil;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5ParamParser;
import com.alipay.mobile.nebula.util.H5StatusBarUtils;
import com.alipay.mobile.nebula.util.H5ThreadType;
import com.alipay.mobile.nebula.util.H5UrlHelper;
import com.alipay.mobile.nebula.util.H5Utils;
import com.alipay.mobile.nebula.wallet.H5ThreadPoolFactory;
import com.alipay.mobile.nebulacore.api.NebulaService;
import com.alipay.mobile.nebulacore.core.H5EventDispatcher;
import com.alipay.mobile.nebulacore.core.H5SessionImpl;
import com.alipay.mobile.nebulacore.core.NebulaServiceImpl;
import com.alipay.mobile.nebulacore.dev.provider.H5BugMeManagerImpl;
import com.alipay.mobile.nebulacore.env.H5Environment;
import com.alipay.mobile.nebulacore.manager.H5ProviderManagerImpl;
import com.alipay.mobile.nebulacore.ui.H5Activity;
import com.alipay.mobile.nebulacore.ui.H5FragmentManager;
import com.alipay.mobile.nebulacore.ui.H5TransActivity;
import com.alipay.mobile.nebulacore.util.AndroidBug5497Workaround;
import com.alipay.mobile.nebulacore.wallet.WalletContext;
import com.alipay.mobile.nebulacore.web.H5BridgePolicy;
import com.business.merchant_payments.utility.StringUtility;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class Nebula {
    public static final boolean DEBUG = H5Utils.isDebuggable(H5Utils.getContext());
    public static final String DSL_ERROR = "dsl_error";
    public static final String H5_PAGE_RESUME = "h5_page_resume";
    public static final String HAS_H5_PKG = "hasH5Pkg";
    public static Class[] LITE_PROCESS_H5TRANS_ACTIVITY = {H5TransActivity.H5TransActivity1.class, H5TransActivity.H5TransActivity2.class, H5TransActivity.H5TransActivity3.class, H5TransActivity.H5TransActivity4.class, H5TransActivity.H5TransActivity5.class};
    public static Class[] LITE_PROCESS_H5_ACTIVITY = {H5Activity.H5Activity1.class, H5Activity.H5Activity2.class, H5Activity.H5Activity3.class, H5Activity.H5Activity4.class, H5Activity.H5Activity5.class};
    public static final int LOAD_FROM_CORE = 1;
    public static final int LOAD_FROM_UC = 0;
    private static final String TAG = "H5Nebula";
    private static String appResume = "appResume";
    private static H5EventDispatcher eventDispatcher;
    private static H5BugMeManager h5BugMeManager;
    private static H5EventHandler h5EventHandler;
    private static H5ApiManager h5TinyAppService;
    public static boolean h5_dev_uc = false;
    public static boolean isDSL = false;
    private static int pageId = 0;
    private static Boolean root = null;
    private static NebulaService service;
    private static Boolean support = null;
    private static int webViewId = 1;

    public static int getWebViewId() {
        int i2 = webViewId;
        webViewId = i2 + 1;
        return i2;
    }

    public static int getPageId() {
        int i2 = pageId;
        pageId = i2 + 1;
        return i2;
    }

    public static NebulaService getService() {
        synchronized (Nebula.class) {
            if (service == null) {
                service = new NebulaServiceImpl();
            }
        }
        return service;
    }

    public static H5EventDispatcher getDispatcher() {
        synchronized (Nebula.class) {
            if (eventDispatcher == null) {
                eventDispatcher = new H5EventDispatcher();
            }
        }
        return eventDispatcher;
    }

    public static H5BugMeManager getH5BugMeManager() {
        synchronized (Nebula.class) {
            if (h5BugMeManager == null) {
                h5BugMeManager = new H5BugMeManagerImpl();
            }
        }
        return h5BugMeManager;
    }

    public static H5ProviderManager getProviderManager() {
        return H5ProviderManagerImpl.getInstance();
    }

    public static boolean isDelayRender(Bundle bundle) {
        boolean z = H5Utils.getBoolean(bundle, H5Param.LONG_DELAY_RENDER, false);
        if (!z) {
            return false;
        }
        H5Log.d(TAG, "param delayRender ".concat(String.valueOf(z)));
        boolean z2 = H5Utils.getBoolean(H5Utils.parseObject(H5Environment.getConfig(H5Utils.KEY_H5_COMMON_CONFIG)), "h5_enableDelayRender", false);
        H5Log.d(TAG, "config delayRender ".concat(String.valueOf(z2)));
        return z2;
    }

    public static List<PackageInfo> getPackageInfos(Context context) {
        try {
            return context.getPackageManager().getInstalledPackages(0);
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            return null;
        }
    }

    public static String getUCMPackageName(List<PackageInfo> list) {
        if (list == null) {
            return null;
        }
        for (PackageInfo next : list) {
            if (next.packageName.equals("com.UCMobile")) {
                return "com.UCMobile";
            }
            if (next.packageName.equals("com.UCMobile.intl")) {
                return "com.UCMobile.intl";
            }
            if (next.packageName.equals("com.UCMobile.yunos")) {
                return "com.UCMobile.yunos";
            }
        }
        return null;
    }

    public static void startUCMIntentLoadUrl(Context context, Uri uri, String str, H5BridgeContext h5BridgeContext) {
        if (str != null) {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setDataAndType(uri, "text/html");
            intent.setPackage(str);
            intent.setComponent(new ComponentName(str, "com.UCMobile.main.UCMobile"));
            intent.putExtra("uc_partner", "UCM_OPEN_FROM_ALIPAY_WEBVIEWSDK");
            try {
                context.startActivity(intent);
                if (h5BridgeContext != null) {
                    h5BridgeContext.sendSuccess();
                }
            } catch (Exception e2) {
                H5Log.e(TAG, "startActivity exception.", e2);
                if (h5BridgeContext != null) {
                    h5BridgeContext.sendBridgeResult("success", Boolean.FALSE);
                }
            }
        }
    }

    public static void startExtActivity(Intent intent) throws Exception {
        if (intent == null) {
            H5Log.w(TAG, "invalid event parameter");
            return;
        }
        Context context = H5Utils.getContext();
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static boolean isRooted() {
        Boolean bool = root;
        if (bool != null) {
            return bool.booleanValue();
        }
        Object obj = null;
        boolean z = false;
        boolean z2 = true;
        try {
            obj = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{"ro.secure"});
        } catch (Throwable th) {
            H5Log.e("root", "root " + th.getMessage());
        }
        if ((obj == null || !"1".equals(obj)) && obj != null && "0".equals(obj)) {
            z = true;
        }
        if (z || (!new File("/system/bin/su").exists() && !new File("/system/xbin/su").exists())) {
            z2 = z;
        }
        Boolean valueOf = Boolean.valueOf(z2);
        root = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean useH5StatusBar(H5Page h5Page) {
        if (h5Page == null) {
            return false;
        }
        boolean z = H5Utils.getBoolean(h5Page.getParams(), H5Param.LONG_TRANSPARENT, false);
        if (!H5StatusBarUtils.isSupport() || !H5StatusBarUtils.isConfigSupport() || z) {
            return false;
        }
        return true;
    }

    public static boolean isTinyResAppId(String str) {
        H5AppCenterPresetProvider h5AppCenterPresetProvider = (H5AppCenterPresetProvider) getProviderManager().getProvider(H5AppCenterPresetProvider.class.getName());
        if (h5AppCenterPresetProvider != null) {
            return TextUtils.equals(str, h5AppCenterPresetProvider.getTinyCommonApp());
        }
        return false;
    }

    public static void prepareApp(final H5AppProvider h5AppProvider, final String str, final String str2, boolean z, boolean z2, final H5AppInstallProcess h5AppInstallProcess) {
        if (isTinyResAppId(str)) {
            final long currentTimeMillis = System.currentTimeMillis();
            final H5AppProvider h5AppProvider2 = h5AppProvider;
            final String str3 = str;
            final String str4 = str2;
            final H5AppInstallProcess h5AppInstallProcess2 = h5AppInstallProcess;
            H5Utils.getExecutor(H5ThreadType.URGENT).execute(new Runnable() {
                public final void run() {
                    try {
                        Nebula.prepare(h5AppProvider2, str3, str4, h5AppInstallProcess2);
                        H5Log.d(Nebula.TAG, "H5GlobalTempPkg cost " + (System.currentTimeMillis() - currentTimeMillis));
                    } catch (Throwable th) {
                        H5Log.e(Nebula.TAG, th);
                    }
                }
            });
            return;
        }
        H5Utils.getExecutor(H5ThreadType.IO).execute(new Runnable() {
            public final void run() {
                Nebula.prepare(h5AppProvider, str, str2, h5AppInstallProcess);
            }
        });
    }

    public static void prepare(H5AppProvider h5AppProvider, String str, String str2, H5AppInstallProcess h5AppInstallProcess) {
        if (!TextUtils.isEmpty(str)) {
            if (!h5AppProvider.isAvailable(str, str2)) {
                H5Log.d(TAG, "prepareApp:downloadApp appId:" + str + " version:" + str2);
                if (h5AppInstallProcess != null) {
                    h5AppInstallProcess.prepare(H5AppInstallStep.APP_INSTALL_STEP_DOWNLOAD, str);
                }
                h5AppProvider.downloadApp(str, str2, (H5DownloadCallback) null, (String) null);
                return;
            }
            H5Log.d(TAG, "prepareApp:install App appId:" + str + " version:" + str2);
            if (h5AppInstallProcess != null) {
                h5AppInstallProcess.prepare(H5AppInstallStep.APP_INSTALL_STEP_UNZIP, str);
            }
            h5AppProvider.installApp(str, str2);
        }
    }

    public static void commonParamParse(Bundle bundle) {
        H5ParamParser.parseMagicOptions(bundle, TAG);
        H5ParamParser.parse(bundle, H5Param.LONG_DELAY_RENDER, false);
        H5ParamParser.parse(bundle, H5Param.LONG_TRANSPARENT, false);
        H5ParamParser.parse(bundle, H5Param.LONG_FULLSCREEN, false);
        H5ParamParser.parse(bundle, H5Param.LONG_LANDSCAPE, false);
        H5ParamParser.parse(bundle, H5Param.LONG_TRANS_ANIMATE, false);
        H5ParamParser.parse(bundle, H5Param.NAV_SEARCH_BAR_PLACEHOLDER, false);
        H5ParamParser.parse(bundle, H5Param.NAV_SEARCH_BAR_VALUE, false);
        H5ParamParser.parse(bundle, H5Param.NAV_SEARCH_BAR_MAX_LENGTH, false);
    }

    public static Intent commonStartActivity(Context context, Bundle bundle) {
        int i2;
        Class cls;
        try {
            if (getH5EventHandler() != null) {
                i2 = getH5EventHandler().getLitePid();
                H5Log.d(TAG, "lpid ".concat(String.valueOf(i2)));
            } else {
                i2 = 0;
            }
            boolean z = H5Utils.getBoolean(bundle, H5Param.LONG_TRANSPARENT, false);
            boolean z2 = H5Utils.getBoolean(bundle, H5Param.LONG_FULLSCREEN, false);
            String string = H5Utils.getString(bundle, H5Param.LONG_LANDSCAPE);
            if (z2) {
                H5Log.d(TAG, "fullScreen true,put transparent ");
                bundle.putBoolean(H5Param.LONG_TRANSPARENT, true);
            }
            boolean isDelayRender = isDelayRender(bundle);
            bundle.putBoolean(H5Param.LONG_DELAY_RENDER, isDelayRender);
            H5Log.d(TAG, "config delayRender " + isDelayRender + " isTransparent " + z + " lpid:" + i2);
            H5ActivityProvider h5ActivityProvider = (H5ActivityProvider) getProviderManager().getProvider(H5ActivityProvider.class.getName());
            Class h5ActivityImpl = h5ActivityProvider != null ? h5ActivityProvider.getH5ActivityImpl() : null;
            if (h5ActivityImpl != null) {
                H5Log.d(TAG, "get getH5ActivityImpl form ".concat(String.valueOf(h5ActivityImpl)));
            } else {
                if (i2 == 0) {
                    if (!isDelayRender) {
                        if (!z) {
                            cls = H5Activity.class;
                        }
                    }
                    cls = H5TransActivity.class;
                } else {
                    getH5EventHandler().prepare();
                    if (!isDelayRender) {
                        if (!z) {
                            cls = LITE_PROCESS_H5_ACTIVITY[i2 - 1];
                        }
                    }
                    cls = LITE_PROCESS_H5TRANS_ACTIVITY[i2 - 1];
                }
                h5ActivityImpl = cls;
            }
            Intent intent = new Intent(context, h5ActivityImpl);
            intent.putExtra("showLoadingView", z);
            intent.addFlags(65536);
            intent.putExtra(H5Param.LONG_FULLSCREEN, z2);
            intent.putExtra(H5Param.LONG_LANDSCAPE, string);
            intent.putExtras(bundle);
            return intent;
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
            return null;
        }
    }

    public static void openInBrowser(H5Page h5Page, String str, H5BridgeContext h5BridgeContext) {
        Uri parseUrl = H5UrlHelper.parseUrl(str);
        if (parseUrl != null) {
            String scheme = parseUrl.getScheme();
            H5Log.d(TAG, "openInBrowser scheme ".concat(String.valueOf(scheme)));
            if (h5Page != null) {
                String uCMPackageName = getUCMPackageName(getPackageInfos(h5Page.getContext().getContext()));
                if (!TextUtils.isEmpty(uCMPackageName) && (TextUtils.equals(scheme, "http") || TextUtils.equals(scheme, "https"))) {
                    startUCMIntentLoadUrl(h5Page.getContext().getContext(), parseUrl, uCMPackageName, h5BridgeContext);
                    return;
                }
            }
            Intent intent = new Intent("android.intent.action.VIEW", parseUrl);
            intent.setFlags(268435456);
            if (intent.resolveActivity(H5Environment.getContext().getPackageManager()) != null) {
                H5Environment.startActivity((H5Context) null, intent);
                if (h5BridgeContext != null) {
                    h5BridgeContext.sendSuccess();
                }
            } else if (h5BridgeContext != null) {
                h5BridgeContext.sendBridgeResult("success", Boolean.FALSE);
            }
        }
    }

    public static boolean enableOpenScheme(String str) {
        H5EnvProvider h5EnvProvider;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) getProviderManager().getProvider(H5ConfigProvider.class.getName());
        if (!(h5ConfigProvider == null || !"no".equalsIgnoreCase(h5ConfigProvider.getConfig("h5_enableStartAppWithScheme"))) || (h5EnvProvider = (H5EnvProvider) getProviderManager().getProvider(H5EnvProvider.class.getName())) == null || !h5EnvProvider.goToSchemeService(str)) {
            return false;
        }
        return true;
    }

    public static void loadImage(String str, H5ImageListener h5ImageListener) {
        H5ImageUtil.loadImage(str, h5ImageListener);
    }

    public static void loadImageKeepSize(String str, final H5ImageListener h5ImageListener) {
        H5ImageProvider h5ImageProvider = (H5ImageProvider) getProviderManager().getProvider(H5ImageProvider.class.getName());
        if (h5ImageProvider != null) {
            h5ImageProvider.loadImageKeepSize(str, new H5ImageListener() {
                public final void onImage(Bitmap bitmap) {
                    H5ImageListener h5ImageListener = h5ImageListener;
                    if (h5ImageListener != null) {
                        h5ImageListener.onImage(bitmap);
                    }
                }
            });
        } else {
            H5Utils.getExecutor(H5ThreadType.RPC).execute(new H5ImageLoader(str, new H5ImageListener() {
                public final void onImage(Bitmap bitmap) {
                    H5ImageListener h5ImageListener = h5ImageListener;
                    if (h5ImageListener != null) {
                        h5ImageListener.onImage(bitmap);
                    }
                }
            }));
        }
    }

    public static void initSession(String str, Bundle bundle, H5Context h5Context) {
        String str2;
        f microApplication;
        try {
            if (TextUtils.isEmpty(str) || TextUtils.equals("10000111", str)) {
                str2 = H5Environment.getSessionId(h5Context, bundle);
            } else {
                str2 = "session_".concat(String.valueOf(str));
            }
            if ((h5Context instanceof WalletContext) && (microApplication = ((WalletContext) h5Context).getMicroApplication()) != null) {
                str2 = str2 + "_" + microApplication.hashCode();
            }
            bundle.putString(H5Param.SESSION_ID, str2);
            H5Log.d(TAG, "sessionId ".concat(String.valueOf(str2)));
            getService().getSession(str2);
        } catch (Exception e2) {
            H5Log.e(TAG, (Throwable) e2);
        }
    }

    public static void setWindowSoftInputMode(Activity activity, String str, Bundle bundle, boolean z) {
        H5Utils.getBoolean(bundle, H5Param.LONG_FULLSCREEN, false);
        String string = H5Utils.getString(bundle, "adjustResize");
        if (!H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_enableNewAdjustInput")) && H5AppHandler.CHECK_VALUE.equalsIgnoreCase(string)) {
            H5Log.d(TAG, "useResize ".concat(String.valueOf(string)));
        } else if (!canSet(str)) {
            return;
        }
        H5Log.d(TAG, " AndroidBug5497Workaround ");
        AndroidBug5497Workaround.assistActivity(activity, z);
    }

    private static boolean canSet(String str) {
        e parseObject = H5Utils.parseObject(H5Environment.getConfigWithProcessCache("h5_setH5AndroidBug5497Workaround"));
        if (parseObject == null || parseObject.isEmpty()) {
            return false;
        }
        for (String next : parseObject.keySet()) {
            try {
                b bVar = (b) parseObject.get(next);
                if (TextUtils.equals(str, next) && (bVar == null || bVar.isEmpty() || bVar.contains(Integer.valueOf(Build.VERSION.SDK_INT)))) {
                    return true;
                }
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
        return false;
    }

    public static void removeBridgeTimeParam(e eVar) {
        if (eVar != null && !"no".equalsIgnoreCase(H5Environment.getConfig("h5_removeBridgeTimeParam"))) {
            if (eVar.containsKey(H5Param.ASYNCINDEX)) {
                eVar.remove(H5Param.ASYNCINDEX);
            }
            if (eVar.containsKey("perf_prepare_time")) {
                eVar.remove("perf_prepare_time");
            }
            if (eVar.containsKey("perf_open_app_time")) {
                eVar.remove("perf_open_app_time");
            }
            if (eVar.containsKey("is_preload")) {
                eVar.remove("is_preload");
            }
            if (eVar.containsKey("is_local")) {
                eVar.remove("is_local");
            }
            if (eVar.containsKey("LITE_PROCESS_ID")) {
                eVar.remove("LITE_PROCESS_ID");
            }
            if (eVar.containsKey("REALLY_STARTAPP")) {
                eVar.remove("REALLY_STARTAPP");
            }
            if (eVar.containsKey("REALLY_DOSTARTAPP")) {
                eVar.remove("REALLY_DOSTARTAPP");
            }
            if (eVar.containsKey(H5Param.LONG_PACKAGE_LOADING_SHOWN)) {
                eVar.remove(H5Param.LONG_PACKAGE_LOADING_SHOWN);
            }
        }
    }

    public static String loadJsBridge(HashMap<String, String> hashMap, int i2, int i3) {
        String raw = H5ResourceManager.getRaw(R.raw.h5_bridge);
        if (DEBUG && H5FileUtil.exists("/sdcard/h5_bridge_debug.js")) {
            raw = H5FileUtil.read("/sdcard/h5_bridge_debug.js");
        }
        if (TextUtils.isEmpty(raw)) {
            H5Log.d(TAG, "no bridge data defined!");
            return raw;
        }
        String str = "";
        for (String next : hashMap.keySet()) {
            str = str + ";AlipayJSBridge." + next + "=" + hashMap.get(next) + ";";
        }
        if (!TextUtils.isEmpty(str)) {
            raw = raw.replace("AlipayJSBridge.startupParams='{startupParams}'", str);
        } else {
            H5Log.d(TAG, "no params data defined!");
        }
        if (H5BridgePolicy.get() == 1) {
            raw = raw.replace("var messenger=window.__alipayConsole__||window.console,log=messenger.log", "var messenger=window,log=window.prompt");
        }
        if (i2 == 1) {
            raw = raw.replace("console.log(\"begin load AlipayJSBridge\");", "console.log(\"begin load AlipayJSBridge from core raw\");");
        } else if (i2 == 0) {
            raw = raw.replace("console.log(\"begin load AlipayJSBridge\");", "console.log(\"begin load AlipayJSBridge from uc provider\");");
        }
        return patchJsBridge(raw.replace("'{APVIEWID}'", String.valueOf(i3)));
    }

    private static String patchJsBridge(String str) {
        String configWithProcessCache = H5Environment.getConfigWithProcessCache("h5_patchJsBridge");
        if (TextUtils.isEmpty(configWithProcessCache)) {
            return str;
        }
        return str + StringUtility.NEW_LINE + configWithProcessCache;
    }

    public static void initInfo(final String str, final Activity activity) {
        H5Utils.runOnMain(new Runnable() {
            public final void run() {
                Nebula.initTaskInfo(str, activity);
            }
        }, 5000);
    }

    /* access modifiers changed from: private */
    public static void initTaskInfo(final String str, final Activity activity) {
        if (Build.VERSION.SDK_INT >= 21 && H5Utils.isInTinyProcess()) {
            try {
                H5ThreadPoolFactory.getSingleThreadExecutor().execute(new Runnable() {
                    public final void run() {
                        H5AppProvider h5AppProvider;
                        Activity activity = activity;
                        if (activity != null && !activity.isFinishing() && (h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName())) != null) {
                            final String walletAppName = h5AppProvider.getWalletAppName(str);
                            final String walletIconUrl = h5AppProvider.getWalletIconUrl(str);
                            H5Log.d(Nebula.TAG, "appName " + walletAppName + " logUrl " + walletIconUrl);
                            if (!TextUtils.isEmpty(walletIconUrl)) {
                                Nebula.loadImage(walletIconUrl, new H5ImageListener() {
                                    public void onImage(Bitmap bitmap) {
                                        H5Log.d(Nebula.TAG, "logUrl " + walletIconUrl + " Bitmap " + bitmap);
                                        if (Build.VERSION.SDK_INT >= 21) {
                                            activity.setTaskDescription(new ActivityManager.TaskDescription(walletAppName, bitmap, 0));
                                        }
                                    }
                                });
                            } else if (Build.VERSION.SDK_INT >= 21) {
                                activity.setTaskDescription(new ActivityManager.TaskDescription(walletAppName, (Bitmap) null, 0));
                            }
                        }
                    }
                });
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
    }

    public static boolean dispatchProcess(H5Event h5Event, H5BridgeContext h5BridgeContext) {
        if (getH5EventHandler() == null || !getH5EventHandler().enableHandler(h5Event.getAction())) {
            return false;
        }
        getH5EventHandler().handlerAction(h5Event, h5BridgeContext);
        H5Log.d(TAG, "H5ProcessUtil handlerAction ");
        return true;
    }

    public static H5EventHandler getH5EventHandler() {
        if (h5EventHandler == null) {
            h5EventHandler = (H5EventHandler) H5Utils.findServiceByInterface(H5EventHandlerService.class.getName());
        }
        return h5EventHandler;
    }

    public static boolean needPageKeepAlive(H5Page h5Page, Activity activity) {
        if (!H5Utils.isInTinyProcess() || !(activity instanceof H5Activity)) {
            return false;
        }
        H5Session session = getService().getSession(H5Utils.getString(h5Page.getParams(), H5Param.SESSION_ID));
        if (session != null && (session instanceof H5SessionImpl)) {
            H5SessionImpl h5SessionImpl = (H5SessionImpl) session;
            if (h5SessionImpl.getH5SessionTabManager() != null) {
                int countTabFragments = h5SessionImpl.getH5SessionTabManager().countTabFragments();
                H5FragmentManager h5FragmentManager = ((H5Activity) activity).getH5FragmentManager();
                if (h5FragmentManager != null && h5FragmentManager.getFragmentCount() == countTabFragments && isTaskRoot(activity)) {
                    return true;
                }
            }
        }
        if (((H5Activity) activity).getH5FragmentManager().getFragmentCount() != 1 || !isTaskRoot(activity)) {
            return false;
        }
        return true;
    }

    public static Stack<H5Page> getSessionPagesWithOutPrerender(Stack<H5Page> stack) {
        Stack stack2 = (Stack) stack.clone();
        Stack<H5Page> stack3 = (Stack) stack2.clone();
        Iterator it2 = stack2.iterator();
        while (it2.hasNext()) {
            H5Page h5Page = (H5Page) it2.next();
            if (H5Utils.getBoolean(h5Page.getParams(), H5Param.LONG_ISPRERENDER, false)) {
                stack3.remove(h5Page);
            }
        }
        return stack3;
    }

    public static void doKeepAlive(Activity activity, Bundle bundle) {
        boolean enableKeepAlive = H5KeepAliveUtil.enableKeepAlive(bundle, H5Utils.getString(bundle, "appId"));
        if (enableKeepAlive && H5Utils.getBoolean(bundle, DSL_ERROR, false)) {
            H5Log.d(TAG, "dslError true set enableKeepAlive==false");
            enableKeepAlive = false;
        }
        H5EventHandler h5EventHandler2 = getH5EventHandler();
        if (h5EventHandler2 != null) {
            h5EventHandler2.moveTaskToBackAndStop(activity, enableKeepAlive);
        }
    }

    public static boolean isTaskRoot(Activity activity) {
        return activity.isTaskRoot();
    }

    public static void moveTaskToBack(Activity activity) {
        if (getH5EventHandler() != null) {
            getH5EventHandler().moveTaskToBack(activity);
        }
    }

    public static int getHeight(H5Page h5Page, float f2, DisplayMetrics displayMetrics) {
        String configWithProcessCache = H5Environment.getConfigWithProcessCache("h5_getWebViewHeight");
        if (TextUtils.isEmpty(configWithProcessCache) || !"no".equalsIgnoreCase(configWithProcessCache)) {
            return Math.round(((float) h5Page.getWebView().getView().getHeight()) / f2);
        }
        if (displayMetrics != null) {
            return Math.round(((float) displayMetrics.heightPixels) / f2);
        }
        return 0;
    }

    public static boolean useSW(Bundle bundle) {
        boolean z = H5Utils.getBoolean(bundle, H5Param.isTinyApp, false);
        boolean equalsIgnoreCase = H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Utils.getString(bundle, H5Param.USE_SW));
        if (z || equalsIgnoreCase) {
            return true;
        }
        return false;
    }

    public static void sendAppResume(H5Bridge h5Bridge, Bundle bundle) {
        if (h5Bridge != null) {
            h5Bridge.sendDataWarpToWeb(appResume, H5Utils.toJSONObject(bundle), (H5CallBack) null);
        }
    }

    public static void clearServiceWork(Bundle bundle) {
        H5Service h5Service;
        if (useSW(bundle) && (h5Service = (H5Service) H5Utils.findServiceByInterface(H5Service.class.getName())) != null) {
            String string = H5Utils.getString(bundle, H5Param.ONLINE_HOST);
            H5Log.d(TAG, "swHost ".concat(String.valueOf(string)));
            if (!TextUtils.isEmpty(string)) {
                h5Service.clearServiceWorker(string);
            }
        }
    }

    public static boolean disableHWACByUCStyle() {
        return H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Environment.getConfigWithProcessCache("h5_disableHWACByUCStyle"));
    }

    public static void checkOffline(final Activity activity, final String str) {
        try {
            H5ThreadPoolFactory.getSingleThreadExecutor().execute(new Runnable() {
                public final void run() {
                    if (H5AppUtil.isOffLine(str)) {
                        H5Log.w(Nebula.TAG, "appId:" + str + " isOffline,not to startPage");
                        H5LogProvider h5LogProvider = (H5LogProvider) Nebula.getProviderManager().getProvider(H5LogProvider.class.getName());
                        if (h5LogProvider != null) {
                            h5LogProvider.log("h5_app_offline", str, "app is offline, not to start page", (String) null, (String) null, (String) null);
                        }
                        if (H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Environment.getConfig("h5_use_log_offline"))) {
                            H5Utils.runOnMain(new Runnable() {
                                public void run() {
                                    String str;
                                    if (activity != null && !activity.isFinishing()) {
                                        Context context = H5Utils.getContext();
                                        if (H5Environment.getResources() == null) {
                                            str = "";
                                        } else {
                                            str = H5Environment.getResources().getString(R.string.h5_app_offline);
                                        }
                                        Toast.makeText(context, str, 0).show();
                                        activity.finish();
                                    }
                                }
                            });
                            return;
                        }
                        Activity activity = activity;
                        if (activity != null && !activity.isFinishing() && H5Utils.isMainProcess()) {
                            activity.finish();
                            H5AppProvider h5AppProvider = (H5AppProvider) Nebula.getProviderManager().getProvider(H5AppProvider.class.getName());
                            if (h5AppProvider != null) {
                                h5AppProvider.showOfflinePage(str, (Bundle) null);
                            }
                        }
                    }
                }
            });
        } catch (Throwable th) {
            H5Log.e(TAG, "catch exception ", th);
        }
    }

    public static H5LogProvider getH5LogHandler() {
        return (H5LogProvider) getProviderManager().getProvider(H5LogProvider.class.getName());
    }

    public static H5ApiManager getH5TinyAppService() {
        if (h5TinyAppService == null) {
            h5TinyAppService = (H5ApiManager) getProviderManager().getProvider(H5ApiManager.class.getName());
        }
        return h5TinyAppService;
    }

    public static boolean enableThrow() {
        return H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Environment.getConfig("h5_plugin_throwException"));
    }

    public static Bundle copyBundle(Bundle bundle) {
        Bundle bundle2;
        if (bundle == null) {
            bundle = new Bundle();
        }
        try {
            bundle2 = (Bundle) bundle.clone();
        } catch (Throwable th) {
            H5Log.e(TAG, th);
            bundle2 = null;
        }
        H5Log.d(TAG, "copyBundle ".concat(String.valueOf(bundle2)));
        return bundle2;
    }

    public static boolean supportJsaApi(H5Page h5Page, String str) {
        if (support == null) {
            long currentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            H5CoreNode h5CoreNode = h5Page;
            while (!TextUtils.isEmpty(str) && !z && h5CoreNode != null) {
                H5PluginManager pluginManager = h5CoreNode.getPluginManager();
                H5CoreNode parent = h5CoreNode.getParent();
                z = pluginManager.canHandle(str);
                h5CoreNode = parent;
            }
            support = Boolean.valueOf(z);
            H5Log.d(TAG, "supportGetLocation: " + support + " " + (System.currentTimeMillis() - currentTimeMillis));
        }
        return support.booleanValue();
    }
}
