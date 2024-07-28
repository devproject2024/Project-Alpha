package com.google.android.gms.internal.firebase_ml;

import java.util.Map;

final class hj implements hk {
    hj() {
    }

    public final hi<?, ?> a(Object obj) {
        return ((hf) obj).f9957a;
    }

    public final Map<?, ?> b(Object obj) {
        return (hh) obj;
    }

    public final Object c(Object obj) {
        ((hh) obj).zztm();
        return obj;
    }

    public final Object a(Object obj, Object obj2) {
        hh hhVar = (hh) obj;
        hh hhVar2 = (hh) obj2;
        if (!hhVar2.isEmpty()) {
            if (!hhVar.isMutable()) {
                hhVar = hhVar.zzvv();
            }
            hhVar.zza(hhVar2);
        }
        return hhVar;
    }

    public final int a(int i2, Object obj, Object obj2) {
        hh hhVar = (hh) obj;
        hf hfVar = (hf) obj2;
        int i3 = 0;
        if (hhVar.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : hhVar.entrySet()) {
            i3 += ft.l(i2) + ft.q(hf.a(hfVar.f9957a, entry.getKey(), entry.getValue()));
        }
        return i3;
    }
}
