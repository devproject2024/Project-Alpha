package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.nio.charset.Charset;

class ai extends ah {
    protected final byte[] zzfp;

    ai(byte[] bArr) {
        this.zzfp = bArr;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ab) || size() != ((ab) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof ai)) {
            return obj.equals(this);
        }
        ai aiVar = (ai) obj;
        int zzab = zzab();
        int zzab2 = aiVar.zzab();
        if (zzab == 0 || zzab2 == 0 || zzab == zzab2) {
            return zza(aiVar, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzfp.length;
    }

    /* access modifiers changed from: protected */
    public final int zza(int i2, int i3, int i4) {
        return bh.a(i2, this.zzfp, zzac(), i4);
    }

    public final ab zza(int i2, int i3) {
        int zzb = zzb(0, i3, size());
        return zzb == 0 ? ab.zzfi : new ae(this.zzfp, zzac(), zzb);
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzfp, zzac(), size(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zza(aa aaVar) throws IOException {
        aaVar.a(this.zzfp, zzac(), size());
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(ab abVar, int i2, int i3) {
        if (i3 > abVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i3);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i3 > abVar.size()) {
            int size2 = abVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i3);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(abVar instanceof ai)) {
            return abVar.zza(0, i3).equals(zza(0, i3));
        } else {
            ai aiVar = (ai) abVar;
            byte[] bArr = this.zzfp;
            byte[] bArr2 = aiVar.zzfp;
            int zzac = zzac() + i3;
            int zzac2 = zzac();
            int zzac3 = aiVar.zzac();
            while (zzac2 < zzac) {
                if (bArr[zzac2] != bArr2[zzac3]) {
                    return false;
                }
                zzac2++;
                zzac3++;
            }
            return true;
        }
    }

    public final boolean zzaa() {
        int zzac = zzac();
        return ed.a(this.zzfp, zzac, size() + zzac);
    }

    /* access modifiers changed from: protected */
    public int zzac() {
        return 0;
    }

    public byte zzj(int i2) {
        return this.zzfp[i2];
    }
}
