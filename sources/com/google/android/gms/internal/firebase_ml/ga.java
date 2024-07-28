package com.google.android.gms.internal.firebase_ml;

final class ga {

    /* renamed from: a  reason: collision with root package name */
    private static final fy<?> f9912a = new fx();

    /* renamed from: b  reason: collision with root package name */
    private static final fy<?> f9913b = c();

    private static fy<?> c() {
        try {
            return (fy) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static fy<?> a() {
        return f9912a;
    }

    static fy<?> b() {
        fy<?> fyVar = f9913b;
        if (fyVar != null) {
            return fyVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
