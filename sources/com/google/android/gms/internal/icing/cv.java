package com.google.android.gms.internal.icing;

final class cv implements da {

    /* renamed from: a  reason: collision with root package name */
    private da[] f10146a;

    cv(da... daVarArr) {
        this.f10146a = daVarArr;
    }

    public final boolean a(Class<?> cls) {
        for (da a2 : this.f10146a) {
            if (a2.a(cls)) {
                return true;
            }
        }
        return false;
    }

    public final db b(Class<?> cls) {
        for (da daVar : this.f10146a) {
            if (daVar.a(cls)) {
                return daVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
