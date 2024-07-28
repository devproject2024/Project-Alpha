package com.google.android.gms.internal.measurement;

final class cu extends cx {
    private final int zzc;
    private final int zzd;

    cu(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzb(i2, i2 + i3, bArr.length);
        this.zzc = i2;
        this.zzd = i3;
    }

    public final byte zza(int i2) {
        int zza = zza();
        if (((zza - (i2 + 1)) | i2) >= 0) {
            return this.zzb[this.zzc + i2];
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
        sb2.append(zza);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    /* access modifiers changed from: package-private */
    public final byte zzb(int i2) {
        return this.zzb[this.zzc + i2];
    }

    public final int zza() {
        return this.zzd;
    }

    /* access modifiers changed from: protected */
    public final int zze() {
        return this.zzc;
    }
}
