package com.google.android.gms.internal.measurement;

final class cj {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f10524a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f10525b = (a("org.robolectric.Robolectric") != null);

    static boolean a() {
        return f10524a != null && !f10525b;
    }

    static Class<?> b() {
        return f10524a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
