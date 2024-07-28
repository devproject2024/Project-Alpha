package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.nio.charset.Charset;

class dj extends dk {
    protected final byte[] zzsk;

    dj(byte[] bArr) {
        if (bArr != null) {
            this.zzsk = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zzeu() {
        return 0;
    }

    public byte zzao(int i2) {
        return this.zzsk[i2];
    }

    /* access modifiers changed from: package-private */
    public byte zzap(int i2) {
        return this.zzsk[i2];
    }

    public int size() {
        return this.zzsk.length;
    }

    public final cz zzf(int i2, int i3) {
        int zzc = zzc(0, i3, size());
        if (zzc == 0) {
            return cz.zzsd;
        }
        return new dg(this.zzsk, zzeu(), zzc);
    }

    /* access modifiers changed from: protected */
    public void zza(byte[] bArr, int i2, int i3, int i4) {
        System.arraycopy(this.zzsk, 0, bArr, 0, i4);
    }

    /* access modifiers changed from: package-private */
    public final void zza(da daVar) throws IOException {
        daVar.a(this.zzsk, zzeu(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzsk, zzeu(), size(), charset);
    }

    public final boolean zzes() {
        int zzeu = zzeu();
        return hj.a(this.zzsk, zzeu, size() + zzeu);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cz) || size() != ((cz) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof dj)) {
            return obj.equals(this);
        }
        dj djVar = (dj) obj;
        int zzet = zzet();
        int zzet2 = djVar.zzet();
        if (zzet == 0 || zzet2 == 0 || zzet == zzet2) {
            return zza(djVar, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(cz czVar, int i2, int i3) {
        if (i3 > czVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i3);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i3 > czVar.size()) {
            int size2 = czVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i3);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(czVar instanceof dj)) {
            return czVar.zzf(0, i3).equals(zzf(0, i3));
        } else {
            dj djVar = (dj) czVar;
            byte[] bArr = this.zzsk;
            byte[] bArr2 = djVar.zzsk;
            int zzeu = zzeu() + i3;
            int zzeu2 = zzeu();
            int zzeu3 = djVar.zzeu();
            while (zzeu2 < zzeu) {
                if (bArr[zzeu2] != bArr2[zzeu3]) {
                    return false;
                }
                zzeu2++;
                zzeu3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i2, int i3, int i4) {
        return ek.a(i2, this.zzsk, zzeu(), i4);
    }
}
