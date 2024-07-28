package com.alipay.mobile.nebula.appcenter.util;

import android.text.TextUtils;
import com.alipay.mobile.nebula.util.H5Log;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class H5LoadingApp {
    private static final String TAG = "H5LoadingApp";
    private static Map<String, String> loadingReadyVersion = new ConcurrentHashMap();

    public static void put(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            loadingReadyVersion.put(str, str2);
        }
    }

    public static void remove(String str) {
        if (!TextUtils.isEmpty(str)) {
            loadingReadyVersion.remove(str);
        }
    }

    public static boolean contain(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !TextUtils.equals(str2, loadingReadyVersion.get(str))) {
            return false;
        }
        H5Log.d(TAG, "appId " + str + " version:" + str2 + " is on loading not delete");
        return true;
    }
}
