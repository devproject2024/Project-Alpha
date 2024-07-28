package com.google.c;

final class d {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f37833a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f37834b = (a("org.robolectric.Robolectric") != null);

    static boolean a() {
        return f37833a != null && !f37834b;
    }

    static Class<?> b() {
        return f37833a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
