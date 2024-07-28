package com.google.android.gms.internal.vision;

final class fh implements fp {

    /* renamed from: a  reason: collision with root package name */
    private fp[] f11137a;

    fh(fp... fpVarArr) {
        this.f11137a = fpVarArr;
    }

    public final boolean a(Class<?> cls) {
        for (fp a2 : this.f11137a) {
            if (a2.a(cls)) {
                return true;
            }
        }
        return false;
    }

    public final fr b(Class<?> cls) {
        for (fp fpVar : this.f11137a) {
            if (fpVar.a(cls)) {
                return fpVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
