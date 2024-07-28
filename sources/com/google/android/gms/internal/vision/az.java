package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public abstract class az<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zzls = new Map.Entry[0];
    private transient bc<Map.Entry<K, V>> zzlt;
    private transient bc<K> zzlu;
    private transient av<V> zzlv;

    public static <K, V> az<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        at.a(k, v);
        at.a(k2, v2);
        at.a(k3, v3);
        at.a(k4, v4);
        return be.zza(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    public abstract V get(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    public abstract bc<Map.Entry<K, V>> zzce();

    /* access modifiers changed from: package-private */
    public abstract bc<K> zzcf();

    /* access modifiers changed from: package-private */
    public abstract av<V> zzcg();

    az() {
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
        return ((av) values()).contains(obj);
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
        return bh.a((bc) entrySet());
    }

    public String toString() {
        int size = size();
        if (size >= 0) {
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
        StringBuilder sb2 = new StringBuilder(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE.length() + 40);
        sb2.append(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE);
        sb2.append(" cannot be negative but was: ");
        sb2.append(size);
        throw new IllegalArgumentException(sb2.toString());
    }

    public /* synthetic */ Set entrySet() {
        bc<Map.Entry<K, V>> bcVar = this.zzlt;
        if (bcVar != null) {
            return bcVar;
        }
        bc<Map.Entry<K, V>> zzce = zzce();
        this.zzlt = zzce;
        return zzce;
    }

    public /* synthetic */ Collection values() {
        av<V> avVar = this.zzlv;
        if (avVar != null) {
            return avVar;
        }
        av<V> zzcg = zzcg();
        this.zzlv = zzcg;
        return zzcg;
    }

    public /* synthetic */ Set keySet() {
        bc<K> bcVar = this.zzlu;
        if (bcVar != null) {
            return bcVar;
        }
        bc<K> zzcf = zzcf();
        this.zzlu = zzcf;
        return zzcf;
    }
}
