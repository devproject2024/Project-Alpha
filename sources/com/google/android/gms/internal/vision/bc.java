package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class bc<E> extends av<E> implements Set<E> {
    @NullableDecl
    private transient ay<E> zzlz;

    bc() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        return bh.a(this, obj);
    }

    public int hashCode() {
        return bh.a(this);
    }

    public ay<E> zzcc() {
        ay<E> ayVar = this.zzlz;
        if (ayVar != null) {
            return ayVar;
        }
        ay<E> zzch = zzch();
        this.zzlz = zzch;
        return zzch;
    }

    /* access modifiers changed from: package-private */
    public ay<E> zzch() {
        return ay.zza(toArray());
    }

    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
