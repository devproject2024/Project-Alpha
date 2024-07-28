package com.google.android.gms.internal.p001firebaseperf;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.d  reason: invalid package */
final class d<K> extends hs<K> {
    private final transient hq<K, ?> zzaf;
    private final transient hm<K> zzr;

    d(hq<K, ?> hqVar, hm<K> hmVar) {
        this.zzaf = hqVar;
        this.zzr = hmVar;
    }

    public final e<K> zzb() {
        return (e) zzf().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i2) {
        return zzf().zza(objArr, i2);
    }

    public final hm<K> zzf() {
        return this.zzr;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zzaf.get(obj) != null;
    }

    public final int size() {
        return this.zzaf.size();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
