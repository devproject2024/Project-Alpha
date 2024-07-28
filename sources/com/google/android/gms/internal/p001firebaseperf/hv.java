package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.hv  reason: invalid package */
final class hv<E> extends hm<E> {
    static final hm<Object> zzac = new hv(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzad;

    hv(Object[] objArr, int i2) {
        this.zzad = objArr;
        this.size = i2;
    }

    /* access modifiers changed from: package-private */
    public final int zzd() {
        return 0;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzc() {
        return this.zzad;
    }

    /* access modifiers changed from: package-private */
    public final int zze() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i2) {
        System.arraycopy(this.zzad, 0, objArr, i2, this.size);
        return i2 + this.size;
    }

    public final E get(int i2) {
        cc.a(i2, this.size);
        return this.zzad[i2];
    }
}
