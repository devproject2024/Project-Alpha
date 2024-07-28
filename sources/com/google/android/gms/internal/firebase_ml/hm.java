package com.google.android.gms.internal.firebase_ml;

final class hm {

    /* renamed from: a  reason: collision with root package name */
    private static final hk f9961a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final hk f9962b = new hj();

    static hk a() {
        return f9961a;
    }

    static hk b() {
        return f9962b;
    }

    private static hk c() {
        try {
            return (hk) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
