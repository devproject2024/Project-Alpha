package com.google.android.gms.internal.measurement;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

public abstract class cm implements Serializable, Iterable<Byte> {
    public static final cm zza = new cx(dx.f10607b);
    private static final ct zzb = (cj.a() ? new da((byte) 0) : new cq((byte) 0));
    private static final Comparator<cm> zzd = new co();
    private int zzc = 0;

    cm() {
    }

    /* access modifiers changed from: private */
    public static int zzb(byte b2) {
        return b2 & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract byte zza(int i2);

    public abstract int zza();

    /* access modifiers changed from: protected */
    public abstract int zza(int i2, int i3, int i4);

    public abstract cm zza(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(cn cnVar) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract byte zzb(int i2);

    public abstract boolean zzc();

    public static cm zza(byte[] bArr, int i2, int i3) {
        zzb(i2, i2 + i3, bArr.length);
        return new cx(zzb.a(bArr, i2, i3));
    }

    static cm zza(byte[] bArr) {
        return new cx(bArr);
    }

    public static cm zza(String str) {
        return new cx(str.getBytes(dx.f10606a));
    }

    public final String zzb() {
        return zza() == 0 ? "" : zza(dx.f10606a);
    }

    public final int hashCode() {
        int i2 = this.zzc;
        if (i2 == 0) {
            int zza2 = zza();
            i2 = zza(zza2, 0, zza2);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzc = i2;
        }
        return i2;
    }

    static cv zzc(int i2) {
        return new cv(i2, (byte) 0);
    }

    /* access modifiers changed from: protected */
    public final int zzd() {
        return this.zzc;
    }

    static int zzb(int i2, int i3, int i4) {
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
        objArr[1] = Integer.valueOf(zza());
        objArr[2] = zza() <= 50 ? gj.a(this) : String.valueOf(gj.a(zza(0, 47))).concat(AppConstants.DOTS);
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }

    public /* synthetic */ Iterator iterator() {
        return new cp(this);
    }
}
