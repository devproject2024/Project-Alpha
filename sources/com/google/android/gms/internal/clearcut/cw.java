package com.google.android.gms.internal.clearcut;

final class cw {

    /* renamed from: a  reason: collision with root package name */
    private static final cu f9260a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final cu f9261b = new cv();

    static cu a() {
        return f9260a;
    }

    static cu b() {
        return f9261b;
    }

    private static cu c() {
        try {
            return (cu) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
