package com.google.android.gms.internal.vision;

final class fn {

    /* renamed from: a  reason: collision with root package name */
    private static final fl f11142a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final fl f11143b = new fo();

    static fl a() {
        return f11142a;
    }

    static fl b() {
        return f11143b;
    }

    private static fl c() {
        try {
            return (fl) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
