package com.google.android.gms.internal.icing;

final class bn {

    /* renamed from: a  reason: collision with root package name */
    private static final bl<?> f10095a = new bo();

    /* renamed from: b  reason: collision with root package name */
    private static final bl<?> f10096b = c();

    private static bl<?> c() {
        try {
            return (bl) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static bl<?> a() {
        return f10095a;
    }

    static bl<?> b() {
        bl<?> blVar = f10096b;
        if (blVar != null) {
            return blVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
