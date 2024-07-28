package com.alipay.imobile.network.quake.h.c;

import android.os.Build;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    private static String f14892a = (Build.MANUFACTURER + Build.MODEL);

    public static String a() {
        return f14892a;
    }

    public static boolean a(String str) throws MalformedURLException {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String host = new URL(str).getHost();
        return !TextUtils.isEmpty(host) && host.contains("mobilegw") && host.contains("alipay");
    }
}
