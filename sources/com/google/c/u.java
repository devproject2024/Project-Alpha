package com.google.c;

final class u {

    /* renamed from: a  reason: collision with root package name */
    private static final s<?> f37912a = new t();

    /* renamed from: b  reason: collision with root package name */
    private static final s<?> f37913b = c();

    private static s<?> c() {
        try {
            return (s) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static s<?> a() {
        return f37912a;
    }

    static s<?> b() {
        s<?> sVar = f37913b;
        if (sVar != null) {
            return sVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
