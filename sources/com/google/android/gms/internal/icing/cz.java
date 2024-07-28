package com.google.android.gms.internal.icing;

import java.util.Iterator;
import java.util.Map;

final class cz implements cw {
    cz() {
    }

    public final cu<?, ?> a() {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> a(Object obj) {
        return (cx) obj;
    }

    public final Object b(Object obj) {
        ((cx) obj).zzah();
        return obj;
    }

    public final Object a(Object obj, Object obj2) {
        cx cxVar = (cx) obj;
        cx cxVar2 = (cx) obj2;
        if (!cxVar2.isEmpty()) {
            if (!cxVar.isMutable()) {
                cxVar = cxVar.zzcj();
            }
            cxVar.zza(cxVar2);
        }
        return cxVar;
    }

    public final int c(Object obj) {
        cx cxVar = (cx) obj;
        if (cxVar.isEmpty()) {
            return 0;
        }
        Iterator it2 = cxVar.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
