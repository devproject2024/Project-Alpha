package com.google.android.gms.internal.firebase_ml;

final class aw<E> extends as<E> {
    static final as<Object> zzalt = new aw(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzalu;

    aw(Object[] objArr, int i2) {
        this.zzalu = objArr;
        this.size = i2;
    }

    /* access modifiers changed from: package-private */
    public final int zzjm() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzjo() {
        return false;
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzjl() {
        return this.zzalu;
    }

    /* access modifiers changed from: package-private */
    public final int zzjn() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i2) {
        System.arraycopy(this.zzalu, 0, objArr, 0, this.size);
        return this.size + 0;
    }

    public final E get(int i2) {
        ap.a(i2, this.size);
        return this.zzalu[i2];
    }
}
