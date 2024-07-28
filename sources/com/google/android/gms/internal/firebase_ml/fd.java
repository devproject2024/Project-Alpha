package com.google.android.gms.internal.firebase_ml;

final class fd {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f9876a = a("libcore.io.Memory");

    /* renamed from: b  reason: collision with root package name */
    private static final boolean f9877b = (a("org.robolectric.Robolectric") != null);

    static boolean a() {
        return f9876a != null && !f9877b;
    }

    static Class<?> b() {
        return f9876a;
    }

    private static <T> Class<T> a(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
