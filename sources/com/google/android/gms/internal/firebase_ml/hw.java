package com.google.android.gms.internal.firebase_ml;

final class hw {

    /* renamed from: a  reason: collision with root package name */
    private static final hu f9976a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final hu f9977b = new hx();

    static hu a() {
        return f9976a;
    }

    static hu b() {
        return f9977b;
    }

    private static hu c() {
        try {
            return (hu) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
