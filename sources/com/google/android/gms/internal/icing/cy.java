package com.google.android.gms.internal.icing;

final class cy {

    /* renamed from: a  reason: collision with root package name */
    private static final cw f10147a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final cw f10148b = new cz();

    static cw a() {
        return f10147a;
    }

    static cw b() {
        return f10148b;
    }

    private static cw c() {
        try {
            return (cw) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
