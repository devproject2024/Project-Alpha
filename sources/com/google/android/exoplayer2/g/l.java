package com.google.android.exoplayer2.g;

import android.text.TextUtils;

public final class l {

    /* renamed from: a  reason: collision with root package name */
    private static int f32538a = 0;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f32539b = true;

    public static void a() {
    }

    public static void b() {
    }

    public static void c() {
    }

    public static void d() {
    }

    public static void a(String str, Throwable th) {
        if (!f32539b) {
            c(str, th);
        }
    }

    public static void b(String str, Throwable th) {
        if (!f32539b) {
            c(str, th);
        }
    }

    private static String c(String str, Throwable th) {
        if (th == null) {
            return str;
        }
        String message = th.getMessage();
        if (TextUtils.isEmpty(message)) {
            return str;
        }
        return str + " - " + message;
    }
}
