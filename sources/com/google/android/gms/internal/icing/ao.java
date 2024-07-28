package com.google.android.gms.internal.icing;

final class ao {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f10056a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f10057b = (a("org.robolectric.Robolectric") != null);

    static boolean a() {
        return f10056a != null && !f10057b;
    }

    static Class<?> b() {
        return f10056a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
