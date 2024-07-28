package com.alipay.mobile.nebula.appcenter.apphandler;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import com.alipay.mobile.a.a;
import com.alipay.mobile.framework.app.b;
import com.alipay.mobile.h5container.service.H5AppCenterService;
import com.alipay.mobile.nebula.appcenter.H5AppDBService;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;

public class H5InstallAppAdvice implements a {
    public static final String DEV_APP_ID = "20001101";
    private static final String H5App = "H5App";
    private static final String TAG = "H5InstallAppAdvice";
    public static final String debug = "debug";
    public static final String h5_appDebugMode = "h5_appDebugMode";
    public static final String h5_appDebugRpc = "h5_appDebugRpc";
    public static final String nbsource = "nbsource";
    private static final String tinyApp = "tinyApp";

    public void onCallAfter(String str, Object obj, Object[] objArr) {
    }

    public void onCallBefore(String str, Object obj, Object[] objArr) {
    }

    public void onExecutionAfter(String str, Object obj, Object[] objArr) {
    }

    public Pair<Boolean, Object> onExecutionAround(String str, Object obj, Object[] objArr) {
        return null;
    }

    public void onExecutionBefore(String str, Object obj, Object[] objArr) {
    }

    public Pair<Boolean, Object> onCallAround(String str, Object obj, Object[] objArr) {
        H5AppDBService appDBService;
        if (TextUtils.equals(str, "void com.alipay.mobile.core.impl.MicroApplicationContextImpl.installApp(String, String, Bundle, FragmentActivity)") && objArr != null) {
            try {
                if (objArr.length >= 3) {
                    boolean z = false;
                    String str2 = "";
                    String str3 = objArr[0] instanceof String ? objArr[0] : str2;
                    if (objArr[1] instanceof String) {
                        str2 = objArr[1];
                    }
                    Bundle bundle = objArr[2] instanceof Bundle ? objArr[2] : null;
                    H5Log.d(TAG, "sourceAppId " + str3 + " targetAppId:" + str2 + " param:" + bundle);
                    if (!enableHandleInstallApp()) {
                        return null;
                    }
                    if (bundle != null && bundle.containsKey(nbsource) && TextUtils.equals(bundle.getString(nbsource), "debug")) {
                        z = true;
                    }
                    if (z && !TextUtils.isEmpty(str2)) {
                        H5AppCenterService h5AppCenterService = (H5AppCenterService) H5Utils.findServiceByInterface(H5AppCenterService.class.getName());
                        if (!(h5AppCenterService == null || (appDBService = h5AppCenterService.getAppDBService()) == null)) {
                            appDBService.getAppInfo(str2, appDBService.getHighestAppVersion(str2));
                        }
                        new b();
                        com.alipay.mobile.framework.b.a();
                        com.alipay.mobile.framework.b.a().f14954a.a(str3, str2, bundle);
                        return new Pair<>(Boolean.TRUE, (Object) null);
                    }
                }
            } catch (Exception e2) {
                H5Log.e(TAG, (Throwable) e2);
            }
        }
        return null;
    }

    public static boolean enableHandleInstallApp() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null) {
            return true;
        }
        String config = h5ConfigProvider.getConfig(h5_appDebugMode);
        return TextUtils.isEmpty(config) || !"no".equalsIgnoreCase(config);
    }

    public static boolean enableUseDevMode(Bundle bundle) {
        return (bundle != null && bundle.containsKey(nbsource) && TextUtils.equals(bundle.getString(nbsource), "debug")) && enableHandleInstallApp();
    }

    public static boolean enableUseDevRPC() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider == null) {
            return true;
        }
        String config = h5ConfigProvider.getConfig(h5_appDebugRpc);
        return TextUtils.isEmpty(config) || !"no".equalsIgnoreCase(config);
    }

    public static void finishDevApp() {
        com.alipay.mobile.framework.b.a();
    }
}
