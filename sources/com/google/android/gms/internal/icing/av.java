package com.google.android.gms.internal.icing;

import java.util.Comparator;

final class av implements Comparator<at> {
    av() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        at atVar = (at) obj;
        at atVar2 = (at) obj2;
        ay ayVar = (ay) atVar.iterator();
        ay ayVar2 = (ay) atVar2.iterator();
        while (ayVar.hasNext() && ayVar2.hasNext()) {
            int compare = Integer.compare(at.zza(ayVar.a()), at.zza(ayVar2.a()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(atVar.size(), atVar2.size());
    }
}
