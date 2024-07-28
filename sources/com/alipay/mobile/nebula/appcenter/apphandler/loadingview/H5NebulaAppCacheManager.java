package com.alipay.mobile.nebula.appcenter.apphandler.loadingview;

import android.os.Bundle;
import android.text.TextUtils;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.appcenter.apphandler.H5StartAppInfo;
import com.alipay.mobile.nebula.appcenter.model.AppInfo;
import com.alipay.mobile.nebula.appcenter.util.H5AppUtil;
import com.alipay.mobile.nebula.provider.H5AppProvider;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;
import com.alipay.mobile.nebula.util.H5Log;
import com.alipay.mobile.nebula.util.H5Utils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5NebulaAppCacheManager {
    public static final String NEBULA_H5TINY_APP = "nebulaH5TinyApp";
    public static final String NEBULA_H5_APP = "nebulaH5App";
    public static final String NEBULA_NATIVE_TINY_APP = "nebulaNativeTinyApp";
    private static final String TAG = "H5NebulaAppCacheManager";
    private static Map<String, H5StartAppInfo> nebulaAppType = new ConcurrentHashMap();

    public static void putAppType(String str, H5StartAppInfo h5StartAppInfo) {
        nebulaAppType.put(str, h5StartAppInfo);
    }

    private static boolean enableUseCache() {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        return h5ConfigProvider == null || !"no".equalsIgnoreCase(h5ConfigProvider.getConfigWithProcessCache(TAG));
    }

    public static String getAppType(String str) {
        H5StartAppInfo h5StartAppInfo;
        if (TextUtils.isEmpty(str) || !enableUseCache() || (h5StartAppInfo = nebulaAppType.get(str)) == null) {
            return null;
        }
        H5Log.d(TAG, str + " getAppType " + h5StartAppInfo);
        return h5StartAppInfo.nebulaAppType;
    }

    public static void setAppType(H5StartAppInfo h5StartAppInfo, AppInfo appInfo, Bundle bundle) {
        if (H5Utils.isTinyApp(appInfo)) {
            h5StartAppInfo.nebulaAppType = NEBULA_H5TINY_APP;
        } else if (H5AppUtil.isRNApp(appInfo)) {
            h5StartAppInfo.nebulaAppType = NEBULA_NATIVE_TINY_APP;
        } else {
            h5StartAppInfo.nebulaAppType = "nebulaH5App";
        }
        h5StartAppInfo.enableMultiProcess = openMultiFromParam(bundle, NEBULA_H5TINY_APP.equals(h5StartAppInfo.nebulaAppType));
        if (NEBULA_H5TINY_APP.equals(h5StartAppInfo.nebulaAppType)) {
            h5StartAppInfo.useAppX = true;
        } else {
            h5StartAppInfo.useAppX = H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Utils.getString(bundle, H5Param.ENABLE_DSL));
        }
    }

    private static boolean openMultiFromParam(Bundle bundle, boolean z) {
        String string = H5Utils.getString(bundle, H5Param.ENABLE_MULTI_PROCESS);
        if (TextUtils.isEmpty(string)) {
            return z;
        }
        return H5AppHandler.CHECK_VALUE.equalsIgnoreCase(string);
    }

    public static boolean isH5TinyApp(String str) {
        return NEBULA_H5TINY_APP.equals(str);
    }

    public static boolean useAppX(String str) {
        if (TextUtils.isEmpty(str) || !enableUseCache()) {
            return false;
        }
        H5StartAppInfo h5StartAppInfo = nebulaAppType.get(str);
        if (h5StartAppInfo == null) {
            H5Log.d(TAG, "useAppX type == null");
            H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
            if (h5AppProvider != null) {
                AppInfo appInfo = h5AppProvider.getAppInfo(str);
                if (H5Utils.isTinyApp(appInfo)) {
                    return true;
                }
                Bundle bundle = new Bundle();
                H5AppUtil.mergeConmonStartParam(bundle, appInfo);
                return H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Utils.getString(bundle, H5Param.ENABLE_DSL));
            }
        }
        H5Log.d(TAG, str + " useAppX " + h5StartAppInfo);
        return h5StartAppInfo.useAppX;
    }

    public static boolean enableMulti(String str, Bundle bundle) {
        H5StartAppInfo h5StartAppInfo = nebulaAppType.get(str);
        if (h5StartAppInfo != null) {
            return h5StartAppInfo.enableMultiProcess;
        }
        H5Log.d(TAG, "enableMulti h5StartAppInfo == null");
        H5AppProvider h5AppProvider = (H5AppProvider) H5Utils.getProvider(H5AppProvider.class.getName());
        if (h5AppProvider == null) {
            return false;
        }
        AppInfo appInfo = h5AppProvider.getAppInfo(str);
        Bundle copyBundle = H5AppUtil.copyBundle(bundle);
        H5AppUtil.mergeConmonStartParam(copyBundle, appInfo);
        return openMultiFromParam(copyBundle, H5Utils.isTinyApp(appInfo));
    }
}
