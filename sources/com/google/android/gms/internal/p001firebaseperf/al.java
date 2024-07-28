package com.google.android.gms.internal.p001firebaseperf;

import android.content.Context;
import android.content.pm.PackageManager;
import com.alipay.mobile.nebulacore.ui.H5TransProgressContent;
import java.net.MalformedURLException;
import java.net.URL;

/* renamed from: com.google.android.gms.internal.firebase-perf.al  reason: invalid package */
public final class al {

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f9496a;

    public static String a(String str) {
        try {
            URL url = new URL(str);
            String query = url.getQuery();
            if (query != null) {
                str = str.substring(0, str.indexOf(query) - 1);
            }
            String userInfo = url.getUserInfo();
            if (userInfo == null) {
                return str;
            }
            return str.replace(String.valueOf(userInfo).concat("@"), "");
        } catch (MalformedURLException unused) {
            return str;
        }
    }

    public static String b(String str) {
        int lastIndexOf;
        if (str.length() <= 2000) {
            return str;
        }
        if (str.charAt(H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY) == '/') {
            return str.substring(0, H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY);
        }
        try {
            if (new URL(str).getPath().lastIndexOf(47) < 0 || (lastIndexOf = str.lastIndexOf(47, 1999)) < 0) {
                return str.substring(0, H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY);
            }
            return str.substring(0, lastIndexOf);
        } catch (MalformedURLException unused) {
            return str.substring(0, H5TransProgressContent.DEFAULT_SHOW_CLOSE_DELAY);
        }
    }

    public static int a(byte[] bArr) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 4 && i2 < bArr.length) {
            i3 |= (bArr[i2] & 255) << (i2 << 3);
            i2++;
        }
        return i3;
    }

    public static boolean a(Context context) {
        Boolean bool = f9496a;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            f9496a = valueOf;
            return valueOf.booleanValue();
        } catch (PackageManager.NameNotFoundException | NullPointerException e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            if (valueOf2.length() != 0) {
                "No perf logcat meta data found ".concat(valueOf2);
            } else {
                new String("No perf logcat meta data found ");
            }
            return false;
        }
    }
}
