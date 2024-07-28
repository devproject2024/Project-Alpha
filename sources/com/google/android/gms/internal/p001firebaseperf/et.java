package com.google.android.gms.internal.p001firebaseperf;

import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.et  reason: invalid package */
final class et implements eu {
    et() {
    }

    public final es<?, ?> a(Object obj) {
        return ((ep) obj).f9603a;
    }

    public final Map<?, ?> b(Object obj) {
        return (er) obj;
    }

    public final Object c(Object obj) {
        ((er) obj).zzgi();
        return obj;
    }

    public final Object a(Object obj, Object obj2) {
        er erVar = (er) obj;
        er erVar2 = (er) obj2;
        if (!erVar2.isEmpty()) {
            if (!erVar.isMutable()) {
                erVar = erVar.zzij();
            }
            erVar.zza(erVar2);
        }
        return erVar;
    }

    public final int a(int i2, Object obj, Object obj2) {
        er erVar = (er) obj;
        ep epVar = (ep) obj2;
        int i3 = 0;
        if (erVar.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : erVar.entrySet()) {
            i3 += da.l(i2) + da.q(ep.a(epVar.f9603a, entry.getKey(), entry.getValue()));
        }
        return i3;
    }
}
