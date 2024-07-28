package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.bv;
import java.io.IOException;
import java.util.Map;

final class bo extends bl<Object> {
    bo() {
    }

    /* access modifiers changed from: package-private */
    public final boolean a(dd ddVar) {
        return ddVar instanceof bv.d;
    }

    /* access modifiers changed from: package-private */
    public final bq<Object> a(Object obj) {
        return ((bv.d) obj).zzko;
    }

    /* access modifiers changed from: package-private */
    public final bq<Object> b(Object obj) {
        bv.d dVar = (bv.d) obj;
        if (dVar.zzko.f10101b) {
            dVar.zzko = (bq) dVar.zzko.clone();
        }
        return dVar.zzko;
    }

    /* access modifiers changed from: package-private */
    public final void c(Object obj) {
        a(obj).b();
    }

    /* access modifiers changed from: package-private */
    public final int a(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void b(Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }
}
