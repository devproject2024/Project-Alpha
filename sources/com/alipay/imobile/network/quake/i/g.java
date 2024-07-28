package com.alipay.imobile.network.quake.i;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;
import com.alipay.imobile.network.quake.c;
import java.net.IDN;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeZone f14903a = TimeZone.getTimeZone("GMT");

    /* renamed from: b  reason: collision with root package name */
    private static final char[] f14904b = "0123456789ABCDEF".toCharArray();

    public static int a(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static String a(Context context) {
        Locale locale;
        try {
            locale = context.getResources().getConfiguration().locale;
        } catch (Exception unused) {
            String str = c.f14737a;
            com.alipay.iap.android.common.b.c.j();
            locale = null;
        }
        if (locale == null) {
            return "";
        }
        if (Locale.CHINA.equals(locale)) {
            return "zh-Hans";
        }
        if (Locale.TAIWAN.equals(locale)) {
            return "zh-Hant";
        }
        if (locale.equals(new Locale("zh", "HK"))) {
            return "zh-HK";
        }
        return locale.getLanguage() + "-" + locale.getCountry();
    }

    public static boolean a() {
        return Looper.myLooper() != null && Looper.myLooper() == Looper.getMainLooper();
    }

    public static boolean b(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 16384);
            return (applicationInfo == null || (applicationInfo.flags & 2) == 0) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
            String str = c.f14737a;
            com.alipay.iap.android.common.b.c.j();
            return false;
        }
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            String str2 = c.f14737a;
            com.alipay.iap.android.common.b.c.g();
            return false;
        }
        try {
            URL url = new URL(str);
            return url.getHost().contains("mobilegw") && url.getHost().contains("alipay") && url.getHost().lastIndexOf("alipay.com") != -1;
        } catch (MalformedURLException unused) {
            String str3 = c.f14737a;
            com.alipay.iap.android.common.b.c.j();
        }
        return false;
    }

    public static ThreadFactory c(final String str) {
        return new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, str);
                thread.setDaemon(true);
                return thread;
            }
        };
    }

    public static String a(String str, int i2, int i3) {
        int i4;
        while (true) {
            if (i2 >= i3) {
                i2 = i3;
                break;
            }
            char charAt = str.charAt(i2);
            if (charAt != 9 && charAt != 10 && charAt != 12 && charAt != 13 && charAt != ' ') {
                break;
            }
            i2++;
        }
        int i5 = i3 - 1;
        while (true) {
            if (i5 >= i2) {
                char charAt2 = str.charAt(i5);
                if (charAt2 != 9 && charAt2 != 10 && charAt2 != 12 && charAt2 != 13 && charAt2 != ' ') {
                    i4 = i5 + 1;
                    break;
                }
                i5--;
            } else {
                i4 = i2;
                break;
            }
        }
        return str.substring(i2, i4);
    }

    public static String a(String str) {
        boolean z;
        try {
            String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
            if (lowerCase.isEmpty()) {
                return null;
            }
            int i2 = 0;
            while (true) {
                z = true;
                if (i2 >= lowerCase.length()) {
                    z = false;
                    break;
                }
                char charAt = lowerCase.charAt(i2);
                if (charAt <= 31) {
                    break;
                } else if (charAt >= 127) {
                    break;
                } else if (" #%/:?@[\\]".indexOf(charAt) != -1) {
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            String str2 = c.f14737a;
            com.alipay.iap.android.common.b.c.j();
            return null;
        }
    }
}
