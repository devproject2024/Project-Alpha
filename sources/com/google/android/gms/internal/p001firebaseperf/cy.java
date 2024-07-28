package com.google.android.gms.internal.p001firebaseperf;

import java.io.IOException;
import java.nio.charset.Charset;

/* renamed from: com.google.android.gms.internal.firebase-perf.cy  reason: invalid package */
class cy extends cv {
    protected final byte[] zznh;

    cy(byte[] bArr) {
        if (bArr != null) {
            this.zznh = bArr;
            return;
        }
        throw new NullPointerException();
    }

    /* access modifiers changed from: protected */
    public int zzgp() {
        return 0;
    }

    public byte zzq(int i2) {
        return this.zznh[i2];
    }

    /* access modifiers changed from: package-private */
    public byte zzr(int i2) {
        return this.zznh[i2];
    }

    public int size() {
        return this.zznh.length;
    }

    public final co zze(int i2, int i3) {
        int zzc = zzc(0, i3, size());
        if (zzc == 0) {
            return co.zznb;
        }
        return new cr(this.zznh, zzgp(), zzc);
    }

    /* access modifiers changed from: package-private */
    public final void zza(cl clVar) throws IOException {
        clVar.a(this.zznh, zzgp(), size());
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zznh, zzgp(), size(), charset);
    }

    public final boolean zzgn() {
        int zzgp = zzgp();
        return go.a(this.zznh, zzgp, size() + zzgp);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof co) || size() != ((co) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof cy)) {
            return obj.equals(this);
        }
        cy cyVar = (cy) obj;
        int zzgo = zzgo();
        int zzgo2 = cyVar.zzgo();
        if (zzgo == 0 || zzgo2 == 0 || zzgo == zzgo2) {
            return zza(cyVar, 0, size());
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(co coVar, int i2, int i3) {
        if (i3 > coVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i3);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        } else if (i3 > coVar.size()) {
            int size2 = coVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: 0, ");
            sb2.append(i3);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        } else if (!(coVar instanceof cy)) {
            return coVar.zze(0, i3).equals(zze(0, i3));
        } else {
            cy cyVar = (cy) coVar;
            if (gm.a(this.zznh, zzgp(), cyVar.zznh, cyVar.zzgp(), i3) == -1) {
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i2, int i3, int i4) {
        return dt.a(i2, this.zznh, zzgp(), i4);
    }
}
