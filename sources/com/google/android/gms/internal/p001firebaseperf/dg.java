package com.google.android.gms.internal.p001firebaseperf;

import com.google.android.gms.internal.p001firebaseperf.dq;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.dg  reason: invalid package */
final class dg extends dh<Object> {
    dg() {
    }

    /* access modifiers changed from: package-private */
    public final boolean a(ex exVar) {
        return exVar instanceof dq.b;
    }

    /* access modifiers changed from: package-private */
    public final di<Object> a(Object obj) {
        return ((dq.b) obj).zzqz;
    }

    /* access modifiers changed from: package-private */
    public final di<Object> b(Object obj) {
        dq.b bVar = (dq.b) obj;
        if (bVar.zzqz.f9556b) {
            bVar.zzqz = (di) bVar.zzqz.clone();
        }
        return bVar.zzqz;
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
