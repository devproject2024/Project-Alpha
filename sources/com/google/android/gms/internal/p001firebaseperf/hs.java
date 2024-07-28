package com.google.android.gms.internal.p001firebaseperf;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.hs  reason: invalid package */
public abstract class hs<E> extends hl<E> implements Set<E> {
    @NullableDecl
    private transient hm<E> zzx;

    hs() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        return f.a(this, obj);
    }

    public int hashCode() {
        return f.a(this);
    }

    public hm<E> zzf() {
        hm<E> hmVar = this.zzx;
        if (hmVar != null) {
            return hmVar;
        }
        hm<E> zzo = zzo();
        this.zzx = zzo;
        return zzo;
    }

    /* access modifiers changed from: package-private */
    public hm<E> zzo() {
        return hm.zza(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
