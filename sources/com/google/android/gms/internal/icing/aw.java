package com.google.android.gms.internal.icing;

final class aw extends bd {
    private final int zzgc;
    private final int zzgd;

    aw(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzb(i2, i2 + i3, bArr.length);
        this.zzgc = i2;
        this.zzgd = i3;
    }

    public final byte zzk(int i2) {
        int size = size();
        if (((size - (i2 + 1)) | i2) >= 0) {
            return this.zzgf[this.zzgc + i2];
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
    public final byte zzl(int i2) {
        return this.zzgf[this.zzgc + i2];
    }

    public final int size() {
        return this.zzgd;
    }

    /* access modifiers changed from: protected */
    public final int zzan() {
        return this.zzgc;
    }
}
