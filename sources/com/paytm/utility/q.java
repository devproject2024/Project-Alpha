package com.paytm.utility;

import android.text.TextUtils;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private static int f43849a = 1000;

    public static void a() {
    }

    public static void b() {
    }

    public static void c() {
    }

    public static void d() {
    }

    public static void a(String str) {
        int i2;
        if (x.j && str != null && str.length() > (i2 = f43849a)) {
            str.substring(0, i2);
            e(str.substring(f43849a));
        }
    }

    public static void b(String str) {
        int i2;
        if (x.j && !TextUtils.isEmpty(str) && str != null && str.length() > (i2 = f43849a)) {
            str.substring(0, i2);
            e(str.substring(f43849a));
        }
    }

    public static void c(String str) {
        if (x.j) {
            TextUtils.isEmpty(str);
        }
    }

    public static void d(String str) {
        if (x.j && !TextUtils.isEmpty(str)) {
            e(str);
        }
    }

    private static void e(String str) {
        if (str != null) {
            for (int i2 = 0; i2 < str.length(); i2 += f43849a) {
                if (f43849a + i2 < str.length()) {
                    str.substring(i2, f43849a + i2);
                } else {
                    str.substring(i2);
                }
            }
        }
    }
}
