package com.google.android.gms.internal.p001firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.cr  reason: invalid package */
final class cr extends cy {
    private final int zzne;
    private final int zznf;

    cr(byte[] bArr, int i2, int i3) {
        super(bArr);
        zzc(i2, i2 + i3, bArr.length);
        this.zzne = i2;
        this.zznf = i3;
    }

    public final byte zzq(int i2) {
        int size = size();
        if (((size - (i2 + 1)) | i2) >= 0) {
            return this.zznh[this.zzne + i2];
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
    public final byte zzr(int i2) {
        return this.zznh[this.zzne + i2];
    }

    public final int size() {
        return this.zznf;
    }

    /* access modifiers changed from: protected */
    public final int zzgp() {
        return this.zzne;
    }
}
