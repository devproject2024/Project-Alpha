package com.google.android.gms.internal.vision;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class cz implements Serializable, Iterable<Byte> {
    public static final cz zzsd = new dj(ek.f11112b);
    private static final df zzse = (cs.a() ? new dm((byte) 0) : new dd((byte) 0));
    private static final Comparator<cz> zzsf = new db();
    private int zzmm = 0;

    cz() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b2) {
        return b2 & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(da daVar) throws IOException;

    /* access modifiers changed from: protected */
    public abstract void zza(byte[] bArr, int i2, int i3, int i4);

    public abstract byte zzao(int i2);

    /* access modifiers changed from: package-private */
    public abstract byte zzap(int i2);

    /* access modifiers changed from: protected */
    public abstract int zzb(int i2, int i3, int i4);

    public abstract boolean zzes();

    public abstract cz zzf(int i2, int i3);

    public static cz zza(byte[] bArr, int i2, int i3) {
        zzc(i2, i2 + i3, bArr.length);
        return new dj(zzse.a(bArr, i2, i3));
    }

    static cz zzd(byte[] bArr) {
        return new dj(bArr);
    }

    static cz zzb(byte[] bArr, int i2, int i3) {
        return new dg(bArr, i2, i3);
    }

    public static cz zzw(String str) {
        return new dj(str.getBytes(ek.f11111a));
    }

    public final String zzer() {
        return size() == 0 ? "" : zza(ek.f11111a);
    }

    public final int hashCode() {
        int i2 = this.zzmm;
        if (i2 == 0) {
            int size = size();
            i2 = zzb(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzmm = i2;
        }
        return i2;
    }

    static dh zzaq(int i2) {
        return new dh(i2, (byte) 0);
    }

    /* access modifiers changed from: protected */
    public final int zzet() {
        return this.zzmm;
    }

    static int zzc(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(32);
            sb.append("Beginning index: ");
            sb.append(i2);
            sb.append(" < 0");
            throw new IndexOutOfBoundsException(sb.toString());
        } else if (i3 < i2) {
            StringBuilder sb2 = new StringBuilder(66);
            sb2.append("Beginning index larger than ending index: ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(i3);
            throw new IndexOutOfBoundsException(sb2.toString());
        } else {
            StringBuilder sb3 = new StringBuilder(37);
            sb3.append("End index: ");
            sb3.append(i3);
            sb3.append(" >= ");
            sb3.append(i4);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public final String toString() {
        Locale locale = Locale.ROOT;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.toHexString(System.identityHashCode(this));
        objArr[1] = Integer.valueOf(size());
        objArr[2] = size() <= 50 ? gx.a(this) : String.valueOf(gx.a(zzf(0, 47))).concat(AppConstants.DOTS);
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public /* synthetic */ Iterator iterator() {
        return new dc(this);
    }
}
