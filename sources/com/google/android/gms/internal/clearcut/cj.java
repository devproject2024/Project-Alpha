package com.google.android.gms.internal.clearcut;

final class cj {

    /* renamed from: a  reason: collision with root package name */
    private static final ch f9244a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final ch f9245b = new ci();

    static ch a() {
        return f9244a;
    }

    static ch b() {
        return f9245b;
    }

    private static ch c() {
        try {
            return (ch) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
