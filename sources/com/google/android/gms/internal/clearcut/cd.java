package com.google.android.gms.internal.clearcut;

final class cd implements cl {

    /* renamed from: a  reason: collision with root package name */
    private cl[] f9239a;

    cd(cl... clVarArr) {
        this.f9239a = clVarArr;
    }

    public final boolean a(Class<?> cls) {
        for (cl a2 : this.f9239a) {
            if (a2.a(cls)) {
                return true;
            }
        }
        return false;
    }

    public final ck b(Class<?> cls) {
        for (cl clVar : this.f9239a) {
            if (clVar.a(cls)) {
                return clVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
