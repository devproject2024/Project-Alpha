package com.google.android.gms.internal.vision;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class bf<K> extends bc<K> {
    private final transient ay<K> zzlq;
    private final transient az<K, ?> zzma;

    bf(az<K, ?> azVar, ay<K> ayVar) {
        this.zzma = azVar;
        this.zzlq = ayVar;
    }

    public final bk<K> zzby() {
        return (bk) zzcc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i2) {
        return zzcc().zza(objArr, i2);
    }

    public final ay<K> zzcc() {
        return this.zzlq;
    }

    public final boolean contains(@NullableDecl Object obj) {
        return this.zzma.get(obj) != null;
    }

    public final int size() {
        return this.zzma.size();
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
