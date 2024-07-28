package com.google.android.gms.internal.vision;

final class cs {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f11015a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f11016b = (a("org.robolectric.Robolectric") != null);

    static boolean a() {
        return f11015a != null && !f11016b;
    }

    static Class<?> b() {
        return f11015a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
