package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

final class fb implements ey {
    fb() {
    }

    public final Map<?, ?> a(Object obj) {
        return (ez) obj;
    }

    public final ew<?, ?> b() {
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> b(Object obj) {
        return (ez) obj;
    }

    public final boolean c(Object obj) {
        return !((ez) obj).zzd();
    }

    public final Object d(Object obj) {
        ((ez) obj).zzc();
        return obj;
    }

    public final Object a() {
        return ez.zza().zzb();
    }

    public final Object a(Object obj, Object obj2) {
        ez ezVar = (ez) obj;
        ez ezVar2 = (ez) obj2;
        if (!ezVar2.isEmpty()) {
            if (!ezVar.zzd()) {
                ezVar = ezVar.zzb();
            }
            ezVar.zza(ezVar2);
        }
        return ezVar;
    }

    public final int e(Object obj) {
        ez ezVar = (ez) obj;
        if (ezVar.isEmpty()) {
            return 0;
        }
        Iterator it2 = ezVar.entrySet().iterator();
        if (!it2.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it2.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
