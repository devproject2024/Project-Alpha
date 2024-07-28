package com.google.android.gms.internal.p001firebaseperf;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.google.android.gms.internal.firebase-perf.er  reason: invalid package */
public final class er<K, V> extends LinkedHashMap<K, V> {
    private static final er zzsz;
    private boolean zzmw = true;

    private er() {
    }

    private er(Map<K, V> map) {
        super(map);
    }

    public static <K, V> er<K, V> zzii() {
        return zzsz;
    }

    public final void zza(er<K, V> erVar) {
        zzik();
        if (!erVar.isEmpty()) {
            putAll(erVar);
        }
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final void clear() {
        zzik();
        super.clear();
    }

    public final V put(K k, V v) {
        zzik();
        dt.a(k);
        dt.a(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzik();
        for (Object next : map.keySet()) {
            dt.a(next);
            dt.a(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzik();
        return super.remove(obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x005d
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L_0x0059
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L_0x0016
        L_0x0014:
            r7 = 0
            goto L_0x005a
        L_0x0016:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x001e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0059
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L_0x0035
            goto L_0x0014
        L_0x0035:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L_0x0052
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L_0x0052
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L_0x0056
        L_0x0052:
            boolean r3 = r4.equals(r3)
        L_0x0056:
            if (r3 != 0) goto L_0x001e
            goto L_0x0014
        L_0x0059:
            r7 = 1
        L_0x005a:
            if (r7 == 0) goto L_0x005d
            return r0
        L_0x005d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p001firebaseperf.er.equals(java.lang.Object):boolean");
    }

    private static int zzh(Object obj) {
        if (obj instanceof byte[]) {
            return dt.c((byte[]) obj);
        }
        if (!(obj instanceof ds)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i2 = 0;
        for (Map.Entry entry : entrySet()) {
            i2 += zzh(entry.getValue()) ^ zzh(entry.getKey());
        }
        return i2;
    }

    public final er<K, V> zzij() {
        return isEmpty() ? new er<>() : new er<>(this);
    }

    public final void zzgi() {
        this.zzmw = false;
    }

    public final boolean isMutable() {
        return this.zzmw;
    }

    private final void zzik() {
        if (!this.zzmw) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        er erVar = new er();
        zzsz = erVar;
        erVar.zzmw = false;
    }
}
