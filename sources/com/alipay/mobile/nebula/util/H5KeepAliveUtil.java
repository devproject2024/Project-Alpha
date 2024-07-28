package com.alipay.mobile.nebula.util;

import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.a.b;
import com.alibaba.a.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.alipay.mobile.nebula.appcenter.apphandler.H5AppHandler;
import com.alipay.mobile.nebula.provider.H5ConfigProvider;

public class H5KeepAliveUtil {
    private static final String TAG = "H5KeepAliveUtil";

    public static boolean enableKeepAlive(Bundle bundle, String str) {
        return H5Param.DEFAULT_LONG_PRESSO_LOGIN.equalsIgnoreCase(H5Utils.getString(bundle, "enableKeepAlive")) && configOpen(bundle) && openAllKeepAlive(str);
    }

    private static boolean configOpen(Bundle bundle) {
        b parseArray;
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null) {
            String config = h5ConfigProvider.getConfig("h5_NotKeepAliveList");
            if (!TextUtils.isEmpty(config) && (parseArray = H5Utils.parseArray(config)) != null && !parseArray.isEmpty()) {
                String string = H5Utils.getString(bundle, "startFromExternal");
                if (!TextUtils.isEmpty(string) && parseArray.contains(string)) {
                    H5Log.d(TAG, "sceneId " + string + "setEnableKeepAlive");
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean openAllKeepAlive(String str) {
        H5ConfigProvider h5ConfigProvider = (H5ConfigProvider) H5Utils.getProvider(H5ConfigProvider.class.getName());
        if (h5ConfigProvider != null) {
            String config = h5ConfigProvider.getConfig("h5_keepAliveBlackList");
            if (!TextUtils.isEmpty(config)) {
                b parseArray = H5Utils.parseArray(config);
                if (!TextUtils.isEmpty(str) && parseArray != null && parseArray.contains(str)) {
                    H5Log.d(TAG, " not keepAlive appId is in BlackList ".concat(String.valueOf(str)));
                    return false;
                }
            }
            e parseObject = H5Utils.parseObject(h5ConfigProvider.getConfig("h5_appKeepAliveConfig"));
            if (parseObject == null || parseObject.isEmpty() || !H5AppHandler.CHECK_VALUE.equalsIgnoreCase(H5Utils.getString(parseObject, "shouldKeepAlive"))) {
                return false;
            }
            return true;
        }
        return false;
    }
}
