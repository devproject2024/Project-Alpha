package com.google.android.gms.internal.vision;

final class bb<E> extends ay<E> {
    static final ay<Object> zzlx = new bb(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzly;

    bb(Object[] objArr, int i2) {
        this.zzly = objArr;
        this.size = i2;
    }

    /* access modifiers changed from: package-private */
    public final int zzca() {
        return 0;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzbz() {
        return this.zzly;
    }

    /* access modifiers changed from: package-private */
    public final int zzcb() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i2) {
        System.arraycopy(this.zzly, 0, objArr, i2, this.size);
        return i2 + this.size;
    }

    public final E get(int i2) {
        al.a(i2, this.size);
        return this.zzly[i2];
    }
}
