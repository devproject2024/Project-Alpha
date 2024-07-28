package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.nio.charset.Charset;

class bd extends ba {
    protected final byte[] zzgf;

    bd(byte[] bArr) {
        if (bArr != null) {
            this.zzgf = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zzan() {
        return 0;
    }

    public byte zzk(int i2) {
        return this.zzgf[i2];
    }

    /* access modifiers changed from: package-private */
    public byte zzl(int i2) {
        return this.zzgf[i2];
    }

    public int size() {
        return this.zzgf.length;
    }

    public final at zza(int i2, int i3) {
        int zzb = zzb(0, i3, size());
        if (zzb == 0) {
            return at.zzfy;
        }
        return new aw(this.zzgf, zzan(), zzb);
    }

    /* access modifiers changed from: package-private */
    public final void zza(aq aqVar) throws IOException {
        aqVar.a(this.zzgf, zzan(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzgf, zzan(), size(), charset);
    }

    public final boolean zzal() {
        int zzan = zzan();
        return er.a(this.zzgf, zzan, size() + zzan);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof at) || size() != ((at) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof bd)) {
            return obj.equals(this);
        }
        bd bdVar = (bd) obj;
        int zzam = zzam();
        int zzam2 = bdVar.zzam();
        if (zzam == 0 || zzam2 == 0 || zzam == zzam2) {
            return zza(bdVar, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(at atVar, int i2, int i3) {
        if (i3 > atVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i3);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i3 > atVar.size()) {
            int size2 = atVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i3);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(atVar instanceof bd)) {
            return atVar.zza(0, i3).equals(zza(0, i3));
        } else {
            bd bdVar = (bd) atVar;
            byte[] bArr = this.zzgf;
            byte[] bArr2 = bdVar.zzgf;
            int zzan = zzan() + i3;
            int zzan2 = zzan();
            int zzan3 = bdVar.zzan();
            while (zzan2 < zzan) {
                if (bArr[zzan2] != bArr2[zzan3]) {
                    return false;
                }
                zzan2++;
                zzan3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zza(int i2, int i3, int i4) {
        return bx.a(i2, this.zzgf, zzan(), i4);
    }
}
