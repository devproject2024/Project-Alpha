package com.google.android.gms.internal.measurement;

final class fp {

    /* renamed from: a  reason: collision with root package name */
    private static final fn f10656a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final fn f10657b = new fm();

    static fn a() {
        return f10656a;
    }

    static fn b() {
        return f10657b;
    }

    private static fn c() {
        try {
            return (fn) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
