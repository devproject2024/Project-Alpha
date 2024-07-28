package com.google.android.gms.internal.icing;

final class dl {

    /* renamed from: a  reason: collision with root package name */
    private static final dj f10166a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final dj f10167b = new dm();

    static dj a() {
        return f10166a;
    }

    static dj b() {
        return f10167b;
    }

    private static dj c() {
        try {
            return (dj) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
