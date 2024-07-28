package com.google.android.gms.internal.vision;

import java.util.AbstractMap;
import java.util.Map;

final class bg extends ay<Map.Entry<K, V>> {
    private final /* synthetic */ bd zzmf;

    bg(bd bdVar) {
        this.zzmf = bdVar;
    }

    public final int size() {
        return this.zzmf.size;
    }

    public final /* synthetic */ Object get(int i2) {
        al.a(i2, this.zzmf.size);
        int i3 = i2 * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zzmf.zzmb[i3], this.zzmf.zzmb[i3 + 1]);
    }
}
