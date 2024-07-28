package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.eq  reason: invalid package */
final class eq implements ey {

    /* renamed from: a  reason: collision with root package name */
    private ey[] f9606a;

    eq(ey... eyVarArr) {
        this.f9606a = eyVarArr;
    }

    public final boolean a(Class<?> cls) {
        for (ey a2 : this.f9606a) {
            if (a2.a(cls)) {
                return true;
            }
        }
        return false;
    }

    public final ev b(Class<?> cls) {
        for (ey eyVar : this.f9606a) {
            if (eyVar.a(cls)) {
                return eyVar.b(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
