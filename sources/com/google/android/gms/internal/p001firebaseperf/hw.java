package com.google.android.gms.internal.p001firebaseperf;

import java.util.AbstractMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.hw  reason: invalid package */
final class hw extends hm<Map.Entry<K, V>> {
    private final /* synthetic */ b zzae;

    hw(b bVar) {
        this.zzae = bVar;
    }

    public final int size() {
        return this.zzae.size;
    }

    public final /* synthetic */ Object get(int i2) {
        cc.a(i2, this.zzae.size);
        int i3 = i2 * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zzae.zzy[i3], this.zzae.zzy[i3 + 1]);
    }
}
