package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.ew  reason: invalid package */
final class ew {

    /* renamed from: a  reason: collision with root package name */
    private static final eu f9611a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final eu f9612b = new et();

    static eu a() {
        return f9611a;
    }

    static eu b() {
        return f9612b;
    }

    private static eu c() {
        try {
            return (eu) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
