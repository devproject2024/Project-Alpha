package com.google.android.gms.internal.clearcut;

import java.util.Iterator;
import java.util.Map;

final class ci implements ch {
    ci() {
    }

    public final Object a() {
        return cg.zzbz().zzca();
    }

    public final Object a(Object obj, Object obj2) {
        cg cgVar = (cg) obj;
        cg cgVar2 = (cg) obj2;
        if (!cgVar2.isEmpty()) {
            if (!cgVar.isMutable()) {
                cgVar = cgVar.zzca();
            }
            cgVar.zza(cgVar2);
        }
        return cgVar;
    }

    public final Map<?, ?> a(Object obj) {
        return (cg) obj;
    }

    public final cf<?, ?> b() {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> b(Object obj) {
        return (cg) obj;
    }

    public final boolean c(Object obj) {
        return !((cg) obj).isMutable();
    }

    public final Object d(Object obj) {
        ((cg) obj).zzv();
        return obj;
    }

    public final int e(Object obj) {
        cg cgVar = (cg) obj;
        if (cgVar.isEmpty()) {
            return 0;
        }
        Iterator it2 = cgVar.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
