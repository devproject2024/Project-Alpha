package com.google.c;

final class q {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?> f37903a = b();

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static r a() {
        r a2 = a("getEmptyRegistry");
        if (a2 != null) {
            return a2;
        }
        return r.f37904a;
    }

    private static final r a(String str) {
        Class<?> cls = f37903a;
        if (cls == null) {
            return null;
        }
        try {
            return (r) cls.getDeclaredMethod(str, new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
