package com.google.android.gms.internal.measurement;

final class fa {

    /* renamed from: a  reason: collision with root package name */
    private static final ey f10640a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final ey f10641b = new fb();

    static ey a() {
        return f10640a;
    }

    static ey b() {
        return f10641b;
    }

    private static ey c() {
        try {
            return (ey) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
