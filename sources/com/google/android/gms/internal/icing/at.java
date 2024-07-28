package com.google.android.gms.internal.icing;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

public abstract class at implements Serializable, Iterable<Byte> {
    public static final at zzfy = new bd(bx.f10120b);
    private static final az zzfz = (ao.a() ? new bc((byte) 0) : new ax((byte) 0));
    private static final Comparator<at> zzgb = new av();
    private int zzga = 0;

    at() {
    }

    /* access modifiers changed from: private */
    public static int zza(byte b2) {
        return b2 & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: protected */
    public abstract int zza(int i2, int i3, int i4);

    public abstract at zza(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(aq aqVar) throws IOException;

    public abstract boolean zzal();

    public abstract byte zzk(int i2);

    /* access modifiers changed from: package-private */
    public abstract byte zzl(int i2);

    public static at zzp(String str) {
        return new bd(str.getBytes(bx.f10119a));
    }

    public final String zzak() {
        return size() == 0 ? "" : zza(bx.f10119a);
    }

    public final int hashCode() {
        int i2 = this.zzga;
        if (i2 == 0) {
            int size = size();
            i2 = zza(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzga = i2;
        }
        return i2;
    }

    static bb zzm(int i2) {
        return new bb(i2, (byte) 0);
    }

    /* access modifiers changed from: protected */
    public final int zzam() {
        return this.zzga;
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
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public /* synthetic */ Iterator iterator() {
        return new as(this);
    }
}
