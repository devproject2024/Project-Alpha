package com.google.android.gms.internal.vision;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class fm<K, V> extends LinkedHashMap<K, V> {
    private static final fm zzyv;
    private boolean zzrp = true;

    private fm() {
    }

    private fm(Map<K, V> map) {
        super(map);
    }

    public static <K, V> fm<K, V> zzhc() {
        return zzyv;
    }

    public final void zza(fm<K, V> fmVar) {
        zzhe();
        if (!fmVar.isEmpty()) {
            putAll(fmVar);
        }
    }

    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final void clear() {
        zzhe();
        super.clear();
    }

    public final V put(K k, V v) {
        zzhe();
        ek.a(k);
        ek.a(v);
        return super.put(k, v);
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        zzhe();
        for (Object next : map.keySet()) {
            ek.a(next);
            ek.a(map.get(next));
        }
        super.putAll(map);
    }

    public final V remove(Object obj) {
        zzhe();
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.fm.equals(java.lang.Object):boolean");
    }

    private static int zzr(Object obj) {
        if (obj instanceof byte[]) {
            return ek.c((byte[]) obj);
        }
        if (!(obj instanceof en)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        int i2 = 0;
        for (Map.Entry entry : entrySet()) {
            i2 += zzr(entry.getValue()) ^ zzr(entry.getKey());
        }
        return i2;
    }

    public final fm<K, V> zzhd() {
        return isEmpty() ? new fm<>() : new fm<>(this);
    }

    public final void zzdp() {
        this.zzrp = false;
    }

    public final boolean isMutable() {
        return this.zzrp;
    }

    private final void zzhe() {
        if (!this.zzrp) {
            throw new UnsupportedOperationException();
        }
    }

    static {
        fm fmVar = new fm();
        zzyv = fmVar;
        fmVar.zzrp = false;
    }
}
