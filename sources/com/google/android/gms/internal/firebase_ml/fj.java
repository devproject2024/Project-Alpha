package com.google.android.gms.internal.firebase_ml;

import java.util.Comparator;

final class fj implements Comparator<fh> {
    fj() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        fh fhVar = (fh) obj;
        fh fhVar2 = (fh) obj2;
        fm fmVar = (fm) fhVar.iterator();
        fm fmVar2 = (fm) fhVar2.iterator();
        while (fmVar.hasNext() && fmVar2.hasNext()) {
            int compare = Integer.compare(fh.zzb(fmVar.a()), fh.zzb(fmVar2.a()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(fhVar.size(), fhVar2.size());
    }
}
