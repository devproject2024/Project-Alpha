package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

final class fo implements fl {
    fo() {
    }

    public final Map<?, ?> a(Object obj) {
        return (fm) obj;
    }

    public final fj<?, ?> b() {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> b(Object obj) {
        return (fm) obj;
    }

    public final boolean c(Object obj) {
        return !((fm) obj).isMutable();
    }

    public final Object d(Object obj) {
        ((fm) obj).zzdp();
        return obj;
    }

    public final Object a() {
        return fm.zzhc().zzhd();
    }

    public final Object a(Object obj, Object obj2) {
        fm fmVar = (fm) obj;
        fm fmVar2 = (fm) obj2;
        if (!fmVar2.isEmpty()) {
            if (!fmVar.isMutable()) {
                fmVar = fmVar.zzhd();
            }
            fmVar.zza(fmVar2);
        }
        return fmVar;
    }

    public final int e(Object obj) {
        fm fmVar = (fm) obj;
        if (fmVar.isEmpty()) {
            return 0;
        }
        Iterator it2 = fmVar.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
