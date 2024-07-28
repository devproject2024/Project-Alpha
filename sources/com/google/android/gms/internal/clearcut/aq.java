package com.google.android.gms.internal.clearcut;

final class aq {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f9160a = b();

    public static ar a() {
        Class<?> cls = f9160a;
        if (cls != null) {
            try {
                return (ar) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return ar.f9161a;
    }

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }
}
