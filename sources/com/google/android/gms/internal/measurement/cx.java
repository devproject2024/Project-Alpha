package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.nio.charset.Charset;

class cx extends cy {
    protected final byte[] zzb;

    cx(byte[] bArr) {
        if (bArr != null) {
            this.zzb = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zze() {
        return 0;
    }

    public byte zza(int i2) {
        return this.zzb[i2];
    }

    /* access modifiers changed from: package-private */
    public byte zzb(int i2) {
        return this.zzb[i2];
    }

    public int zza() {
        return this.zzb.length;
    }

    public final cm zza(int i2, int i3) {
        int zzb2 = zzb(0, i3, zza());
        if (zzb2 == 0) {
            return cm.zza;
        }
        return new cu(this.zzb, zze(), zzb2);
    }

    /* access modifiers changed from: package-private */
    public final void zza(cn cnVar) throws IOException {
        cnVar.a(this.zzb, zze(), zza());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzb, zze(), zza(), charset);
    }

    public final boolean zzc() {
        int zze = zze();
        return gw.a(this.zzb, zze, zza() + zze);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof cm) || zza() != ((cm) obj).zza()) {
            return false;
        }
        if (zza() == 0) {
            return true;
        }
        if (!(obj instanceof cx)) {
            return obj.equals(this);
        }
        cx cxVar = (cx) obj;
        int zzd = zzd();
        int zzd2 = cxVar.zzd();
        if (zzd == 0 || zzd2 == 0 || zzd == zzd2) {
            return zza(cxVar, 0, zza());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(cm cmVar, int i2, int i3) {
        if (i3 > cmVar.zza()) {
            int zza = zza();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i3);
            sb.append(zza);
            throw new IllegalArgumentException(sb.toString());
        } else if (i3 > cmVar.zza()) {
            int zza2 = cmVar.zza();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i3);
            sb2.append(", ");
            sb2.append(zza2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(cmVar instanceof cx)) {
            return cmVar.zza(0, i3).equals(zza(0, i3));
        } else {
            cx cxVar = (cx) cmVar;
            byte[] bArr = this.zzb;
            byte[] bArr2 = cxVar.zzb;
            int zze = zze() + i3;
            int zze2 = zze();
            int zze3 = cxVar.zze();
            while (zze2 < zze) {
                if (bArr[zze2] != bArr2[zze3]) {
                    return false;
                }
                zze2++;
                zze3++;
            }
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public final int zza(int i2, int i3, int i4) {
        return dx.a(i2, this.zzb, zze(), i4);
    }
}
