package com.alipay.mobile.h5container.api;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.alipay.mobile.nebula.util.H5Log;
import java.util.HashMap;
import java.util.Set;

public class H5SsoFlagHolder {
    public static final String TAG = "H5SsoFlagHolder";
    public static boolean sCopyToMmstat = true;
    private static HashMap<String, Boolean> sLoginFlag = new HashMap<>();
    private static long sTbLoginTime = 0;

    public static void initFlag(Set<String> set) {
        if (set != null && !set.isEmpty() && sLoginFlag.isEmpty()) {
            for (String next : set) {
                H5Log.d(TAG, "initFlag ".concat(String.valueOf(next)));
                sLoginFlag.put(next, Boolean.TRUE);
            }
        }
    }

    public static boolean getFlag(String str) {
        boolean booleanValue = sLoginFlag.containsKey(str) ? sLoginFlag.get(str).booleanValue() : false;
        H5Log.d(TAG, "getFlag domain " + str + " flag " + booleanValue);
        return booleanValue;
    }

    public static void setFlag(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            H5Log.d(TAG, "setFlag domain " + str + " flag " + z);
            sLoginFlag.put(str, Boolean.valueOf(z));
        }
    }

    public static void setNeedAutoLogin(boolean z) {
        H5Log.d(TAG, "setNeedAutoLogin:".concat(String.valueOf(z)));
        for (String put : sLoginFlag.keySet()) {
            sLoginFlag.put(put, Boolean.valueOf(z));
        }
        sTbLoginTime = 0;
    }

    public static long getTbLoginTime() {
        return sTbLoginTime;
    }

    public static void setTbLoginTime(long j) {
        H5Log.d(TAG, "setTbLoginTime ".concat(String.valueOf(j)));
        sTbLoginTime = j;
    }

    public static boolean copyCookieToMmstat(Context context, boolean z, String str) {
        if (z && sCopyToMmstat && !TextUtils.isEmpty(str)) {
            String[] split = str.split(";");
            if (split.length <= 0) {
                return false;
            }
            for (String trim : split) {
                String[] split2 = trim.trim().split("=");
                if (split2.length == 2) {
                    String str2 = split2[0];
                    String str3 = split2[1];
                    if (TextUtils.equals(str2, "unb")) {
                        CookieManager instance = CookieManager.getInstance();
                        instance.setAcceptCookie(true);
                        instance.setCookie(".mmstat.com", "cnaui=" + str3 + ";");
                        CookieSyncManager.createInstance(context).sync();
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
