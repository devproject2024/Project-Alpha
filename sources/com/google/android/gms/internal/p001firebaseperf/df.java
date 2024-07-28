package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.df  reason: invalid package */
final class df {

    /* renamed from: a  reason: collision with root package name */
    private static final Class<?> f9553a = b();

    private static Class<?> b() {
        try {
            return Class.forName("com.google.protobuf.ExtensionRegistry");
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static de a() {
        Class<?> cls = f9553a;
        if (cls != null) {
            try {
                return (de) cls.getDeclaredMethod("getEmptyRegistry", new Class[0]).invoke((Object) null, new Object[0]);
            } catch (Exception unused) {
            }
        }
        return de.f9548a;
    }
}
