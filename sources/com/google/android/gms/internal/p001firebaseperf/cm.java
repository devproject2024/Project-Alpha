package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.cm  reason: invalid package */
final class cm {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f9523a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f9524b = (a("org.robolectric.Robolectric") != null);

    static boolean a() {
        return f9523a != null && !f9524b;
    }

    static Class<?> b() {
        return f9523a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
