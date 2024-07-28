package com.google.android.gms.internal.firebase_ml;

final class fk extends fr {
    private final int zzchs;
    private final int zzcht;

    fk(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzd(i2, i2 + i3, bArr.length);
        this.zzchs = i2;
        this.zzcht = i3;
    }

    public final byte zzcw(int i2) {
        zzg(i2, size());
        return this.bytes[this.zzchs + i2];
    }

    /* access modifiers changed from: package-private */
    public final byte zzcx(int i2) {
        return this.bytes[this.zzchs + i2];
    }

    public final int size() {
        return this.zzcht;
    }

    /* access modifiers changed from: protected */
    public final int zztu() {
        return this.zzchs;
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.bytes, zztu() + i2, bArr, i3, i4);
    }
}
