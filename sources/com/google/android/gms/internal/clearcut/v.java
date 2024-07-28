package com.google.android.gms.internal.clearcut;

final class v {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f9430a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f9431b = (a("org.robolectric.Robolectric") != null);

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    static boolean a() {
        return f9430a != null && !f9431b;
    }

    static Class<?> b() {
        return f9430a;
    }
}
