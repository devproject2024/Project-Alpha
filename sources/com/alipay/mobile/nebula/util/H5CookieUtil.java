package com.alipay.mobile.nebula.util;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;

public class H5CookieUtil {
    public static String getCookie(String str) {
        try {
            CookieManager instance = CookieManager.getInstance();
            String cookie = instance.getCookie(str);
            if (!TextUtils.isEmpty(cookie)) {
                return cookie;
            }
            Uri parseUrl = H5UrlHelper.parseUrl(str);
            String host = parseUrl != null ? parseUrl.getHost() : null;
            return (parseUrl == null || TextUtils.isEmpty(host)) ? cookie : instance.getCookie(host);
        } catch (Throwable th) {
            H5Log.e("H5CookieUtil", th);
            return null;
        }
    }

    public static void setCookie(String str, String str2) {
        try {
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            instance.setCookie(str, str2);
            CookieSyncManager.createInstance(H5Utils.getContext()).sync();
        } catch (Throwable th) {
            H5Log.e("H5CookieUtil", th);
        }
    }
}
