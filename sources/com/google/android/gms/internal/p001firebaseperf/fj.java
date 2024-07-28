package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.fj  reason: invalid package */
final class fj {

    /* renamed from: a  reason: collision with root package name */
    private static final fh f9626a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final fh f9627b = new fg();

    static fh a() {
        return f9626a;
    }

    static fh b() {
        return f9627b;
    }

    private static fh c() {
        try {
            return (fh) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
