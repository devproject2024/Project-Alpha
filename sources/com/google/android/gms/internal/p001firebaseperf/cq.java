package com.google.android.gms.internal.p001firebaseperf;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.firebase-perf.cq  reason: invalid package */
final class cq implements Comparator<co> {
    cq() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        co coVar = (co) obj;
        co coVar2 = (co) obj2;
        ct ctVar = (ct) coVar.iterator();
        ct ctVar2 = (ct) coVar2.iterator();
        while (ctVar.hasNext() && ctVar2.hasNext()) {
            int compare = Integer.compare(co.zza(ctVar.a()), co.zza(ctVar2.a()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(coVar.size(), coVar2.size());
    }
}
