package com.google.android.gms.internal.vision;

final class ea {

    /* renamed from: a  reason: collision with root package name */
    private static final dw<?> f11079a = new dy();

    /* renamed from: b  reason: collision with root package name */
    private static final dw<?> f11080b = c();

    private static dw<?> c() {
        try {
            return (dw) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static dw<?> a() {
        return f11079a;
    }

    static dw<?> b() {
        dw<?> dwVar = f11080b;
        if (dwVar != null) {
            return dwVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
