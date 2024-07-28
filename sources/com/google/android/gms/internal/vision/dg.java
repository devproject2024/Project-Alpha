package com.google.android.gms.internal.vision;

final class dg extends dj {
    private final int zzsh;
    private final int zzsi;

    dg(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzc(i2, i2 + i3, bArr.length);
        this.zzsh = i2;
        this.zzsi = i3;
    }

    public final byte zzao(int i2) {
        int size = size();
        if (((size - (i2 + 1)) | i2) >= 0) {
            return this.zzsk[this.zzsh + i2];
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i2);
        sb2.append(", ");
        sb2.append(size);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: package-private */
    public final byte zzap(int i2) {
        return this.zzsk[this.zzsh + i2];
    }

    public final int size() {
        return this.zzsi;
    }

    /* access modifiers changed from: protected */
    public final int zzeu() {
        return this.zzsh;
    }

    /* access modifiers changed from: protected */
    public final void zza(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.zzsk, zzeu(), bArr, 0, i4);
    }
}
