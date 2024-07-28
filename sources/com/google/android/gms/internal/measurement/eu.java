package com.google.android.gms.internal.measurement;

final class eu implements fc {

    /* renamed from: a  reason: collision with root package name */
    private fc[] f10633a;

    eu(fc... fcVarArr) {
        this.f10633a = fcVarArr;
    }

    public final boolean a(Class<?> cls) {
        for (fc a2 : this.f10633a) {
            if (a2.a(cls)) {
                return true;
            }
        }
        return false;
    }

    public final fd b(Class<?> cls) {
        for (fc fcVar : this.f10633a) {
            if (fcVar.a(cls)) {
                return fcVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
