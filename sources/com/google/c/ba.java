package com.google.c;

final class ba {

    /* renamed from: a  reason: collision with root package name */
    private static final ay f37744a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final ay f37745b = new az();

    static ay a() {
        return f37744a;
    }

    static ay b() {
        return f37745b;
    }

    private static ay c() {
        try {
            return (ay) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
