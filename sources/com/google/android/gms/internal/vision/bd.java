package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

final class bd<K, V> extends bc<Map.Entry<K, V>> {
    /* access modifiers changed from: private */
    public final transient int size;
    private final transient az<K, V> zzma;
    /* access modifiers changed from: private */
    public final transient Object[] zzmb;
    private final transient int zzmc = 0;

    bd(az<K, V> azVar, Object[] objArr, int i2, int i3) {
        this.zzma = azVar;
        this.zzmb = objArr;
        this.size = i3;
    }

    public final bk<Map.Entry<K, V>> zzby() {
        return (bk) zzcc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i2) {
        return zzcc().zza(objArr, i2);
    }

    /* access modifiers changed from: package-private */
    public final ay<Map.Entry<K, V>> zzch() {
        return new bg(this);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zzma.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
