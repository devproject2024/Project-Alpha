package com.google.android.gms.internal.firebase_ml;

final class hg implements ho {

    /* renamed from: a  reason: collision with root package name */
    private ho[] f9958a;

    hg(ho... hoVarArr) {
        this.f9958a = hoVarArr;
    }

    public final boolean a(Class<?> cls) {
        for (ho a2 : this.f9958a) {
            if (a2.a(cls)) {
                return true;
            }
        }
        return false;
    }

    public final hl b(Class<?> cls) {
        for (ho hoVar : this.f9958a) {
            if (hoVar.a(cls)) {
                return hoVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
