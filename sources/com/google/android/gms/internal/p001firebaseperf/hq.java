package com.google.android.gms.internal.p001firebaseperf;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.hq  reason: invalid package */
public abstract class hq<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zzs = new Map.Entry[0];
    private transient hs<Map.Entry<K, V>> zzt;
    private transient hs<K> zzu;
    private transient hl<V> zzv;

    public static <K, V> hq<K, V> zzj() {
        return hu.zzaa;
    }

    public abstract V get(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    public abstract hs<Map.Entry<K, V>> zzk();

    /* access modifiers changed from: package-private */
    public abstract hs<K> zzl();

    /* access modifiers changed from: package-private */
    public abstract hl<V> zzm();

    /* access modifiers changed from: package-private */
    public abstract boolean zzn();

    public static <K, V> hq<K, V> zza(Map<? extends K, ? extends V> map) {
        if (!(map instanceof hq) || (map instanceof SortedMap)) {
            Set<Map.Entry<? extends K, ? extends V>> entrySet = map.entrySet();
            boolean z = entrySet instanceof Collection;
            ht htVar = new ht(z ? entrySet.size() : 4);
            if (z) {
                htVar.a(htVar.f9699a + entrySet.size());
            }
            for (Map.Entry entry : entrySet) {
                htVar.a(entry.getKey(), entry.getValue());
            }
            return htVar.a();
        }
        hq<K, V> hqVar = (hq) map;
        hqVar.zzn();
        return hqVar;
    }

    hq() {
    }

    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((hl) values()).contains(obj);
    }

    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public int hashCode() {
        return f.a((hs) entrySet());
    }

    public String toString() {
        int size = size();
        hj.a(size, ImagePickerUtils.IMAGE_PICKER_KEY_SIZE);
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    public /* synthetic */ Set entrySet() {
        hs<Map.Entry<K, V>> hsVar = this.zzt;
        if (hsVar != null) {
            return hsVar;
        }
        hs<Map.Entry<K, V>> zzk = zzk();
        this.zzt = zzk;
        return zzk;
    }

    public /* synthetic */ Collection values() {
        hl<V> hlVar = this.zzv;
        if (hlVar != null) {
            return hlVar;
        }
        hl<V> zzm = zzm();
        this.zzv = zzm;
        return zzm;
    }

    public /* synthetic */ Set keySet() {
        hs<K> hsVar = this.zzu;
        if (hsVar != null) {
            return hsVar;
        }
        hs<K> zzl = zzl();
        this.zzu = zzl;
        return zzl;
    }
}
