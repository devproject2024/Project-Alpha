package com.google.android.gms.internal.p001firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.b  reason: invalid package */
final class b<K, V> extends hs<Map.Entry<K, V>> {
    /* access modifiers changed from: private */
    public final transient int size;
    private final transient hq<K, V> zzaf;
    private final transient int zzag = 0;
    /* access modifiers changed from: private */
    public final transient Object[] zzy;

    b(hq<K, V> hqVar, Object[] objArr, int i2, int i3) {
        this.zzaf = hqVar;
        this.zzy = objArr;
        this.size = i3;
    }

    public final e<Map.Entry<K, V>> zzb() {
        return (e) zzf().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i2) {
        return zzf().zza(objArr, i2);
    }

    /* access modifiers changed from: package-private */
    public final hm<Map.Entry<K, V>> zzo() {
        return new hw(this);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zzaf.get(key))) {
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
