package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.dj  reason: invalid package */
final class dj {

    /* renamed from: a  reason: collision with root package name */
    private static final dh<?> f9558a = new dg();

    /* renamed from: b  reason: collision with root package name */
    private static final dh<?> f9559b = c();

    private static dh<?> c() {
        try {
            return (dh) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static dh<?> a() {
        return f9558a;
    }

    static dh<?> b() {
        dh<?> dhVar = f9559b;
        if (dhVar != null) {
            return dhVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
