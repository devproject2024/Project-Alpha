package com.google.android.gms.internal.icing;

final class bj {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f10086a = b();

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static bm a() {
        Class<?> cls = f10086a;
        if (cls != null) {
            try {
                return (bm) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return bm.f10090a;
    }
}
