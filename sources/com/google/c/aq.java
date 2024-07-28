package com.google.c;

final class aq {

    /* renamed from: a  reason: collision with root package name */
    private static final ao f37727a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final ao f37728b = new ap();

    static ao a() {
        return f37727a;
    }

    static ao b() {
        return f37728b;
    }

    private static ao c() {
        try {
            return (ao) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
