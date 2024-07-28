package com.google.android.gms.internal.vision;

import java.util.Comparator;

final class db implements Comparator<cz> {
    db() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        cz czVar = (cz) obj;
        cz czVar2 = (cz) obj2;
        di diVar = (di) czVar.iterator();
        di diVar2 = (di) czVar2.iterator();
        while (diVar.hasNext() && diVar2.hasNext()) {
            int compare = Integer.compare(cz.zza(diVar.a()), cz.zza(diVar2.a()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(czVar.size(), czVar2.size());
    }
}
