package com.google.android.gms.internal.clearcut;

final class av {

    /* renamed from: a  reason: collision with root package name */
    private static final as<?> f9166a = new at();

    /* renamed from: b  reason: collision with root package name */
    private static final as<?> f9167b = c();

    static as<?> a() {
        return f9166a;
    }

    static as<?> b() {
        as<?> asVar = f9167b;
        if (asVar != null) {
            return asVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    private static as<?> c() {
        try {
            return (as) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
