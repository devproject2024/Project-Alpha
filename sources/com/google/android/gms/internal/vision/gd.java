package com.google.android.gms.internal.vision;

final class gd {

    /* renamed from: a  reason: collision with root package name */
    private static final gb f11167a = c();

    /* renamed from: b  reason: collision with root package name */
    private static final gb f11168b = new ga();

    static gb a() {
        return f11167a;
    }

    static gb b() {
        return f11168b;
    }

    private static gb c() {
        try {
            return (gb) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
