package com.google.android.gms.internal.measurement;

import java.util.Comparator;

final class co implements Comparator<cm> {
    co() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        cm cmVar = (cm) obj;
        cm cmVar2 = (cm) obj2;
        cw cwVar = (cw) cmVar.iterator();
        cw cwVar2 = (cw) cmVar2.iterator();
        while (cwVar.hasNext() && cwVar2.hasNext()) {
            int compare = Integer.compare(cm.zzb(cwVar.a()), cm.zzb(cwVar2.a()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(cmVar.zza(), cmVar2.zza());
    }
}
