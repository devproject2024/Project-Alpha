package com.google.android.gms.internal.measurement;

final class dk {

    /* renamed from: a  reason: collision with root package name */
    private static final dj<?> f10577a = new dl();

    /* renamed from: b  reason: collision with root package name */
    private static final dj<?> f10578b = c();

    private static dj<?> c() {
        try {
            return (dj) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static dj<?> a() {
        return f10577a;
    }

    static dj<?> b() {
        dj<?> djVar = f10578b;
        if (djVar != null) {
            return djVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
