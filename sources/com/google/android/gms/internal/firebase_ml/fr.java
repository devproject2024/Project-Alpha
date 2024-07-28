package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.nio.charset.Charset;

class fr extends fo {
    protected final byte[] bytes;

    fr(byte[] bArr) {
        if (bArr != null) {
            this.bytes = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zztu() {
        return 0;
    }

    public byte zzcw(int i2) {
        return this.bytes[i2];
    }

    /* access modifiers changed from: package-private */
    public byte zzcx(int i2) {
        return this.bytes[i2];
    }

    public int size() {
        return this.bytes.length;
    }

    public final fh zzf(int i2, int i3) {
        int zzd = zzd(i2, i3, size());
        if (zzd == 0) {
            return fh.zzchp;
        }
        return new fk(this.bytes, zztu() + i2, zzd);
    }

    /* access modifiers changed from: protected */
    public void zzb(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.bytes, i2, bArr, i3, i4);
    }

    /* access modifiers changed from: package-private */
    public final void zza(ff ffVar) throws IOException {
        ffVar.a(this.bytes, zztu(), size());
    }

    /* access modifiers changed from: protected */
    public final String zzb(Charset charset) {
        return new String(this.bytes, zztu(), size(), charset);
    }

    public final boolean zztq() {
        int zztu = zztu();
        return g.a(this.bytes, zztu, size() + zztu);
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i2, int i3, int i4) {
        int zztu = zztu() + i3;
        return g.a(i2, this.bytes, zztu, i4 + zztu);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fh) || size() != ((fh) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof fr)) {
            return obj.equals(this);
        }
        fr frVar = (fr) obj;
        int zztt = zztt();
        int zztt2 = frVar.zztt();
        if (zztt == 0 || zztt2 == 0 || zztt == zztt2) {
            return zza(frVar, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(fh fhVar, int i2, int i3) {
        if (i3 <= fhVar.size()) {
            int i4 = i2 + i3;
            if (i4 > fhVar.size()) {
                int size = fhVar.size();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: ");
                sb.append(i2);
                sb.append(", ");
                sb.append(i3);
                sb.append(", ");
                sb.append(size);
                throw new IllegalArgumentException(sb.toString());
            } else if (!(fhVar instanceof fr)) {
                return fhVar.zzf(i2, i4).equals(zzf(0, i3));
            } else {
                fr frVar = (fr) fhVar;
                byte[] bArr = this.bytes;
                byte[] bArr2 = frVar.bytes;
                int zztu = zztu() + i3;
                int zztu2 = zztu();
                int zztu3 = frVar.zztu() + i2;
                while (zztu2 < zztu) {
                    if (bArr[zztu2] != bArr2[zztu3]) {
                        return false;
                    }
                    zztu2++;
                    zztu3++;
                }
                return true;
            }
        } else {
            int size2 = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i3);
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    /* access modifiers changed from: protected */
    public final int zzc(int i2, int i3, int i4) {
        return gk.a(i2, this.bytes, zztu() + i3, i4);
    }
}
