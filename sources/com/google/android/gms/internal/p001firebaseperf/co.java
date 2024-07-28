package com.google.android.gms.internal.p001firebaseperf;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-perf.co  reason: invalid package */
public abstract class co implements Serializable, Iterable<Byte> {
    public static final co zznb = new cy(dt.f9582b);
    private static final cu zznc = (cm.a() ? new cx((byte) 0) : new cs((byte) 0));
    private static final Comparator<co> zznd = new cq();
    private int zzak = 0;

    co() {
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
    public abstract void zza(cl clVar) throws IOException;

    /* access modifiers changed from: protected */
    public abstract int zzb(int i2, int i3, int i4);

    public abstract co zze(int i2, int i3);

    public abstract boolean zzgn();

    public abstract byte zzq(int i2);

    /* access modifiers changed from: package-private */
    public abstract byte zzr(int i2);

    public static co zzag(String str) {
        return new cy(str.getBytes(dt.f9581a));
    }

    public final String zzgm() {
        return size() == 0 ? "" : zza(dt.f9581a);
    }

    public final int hashCode() {
        int i2 = this.zzak;
        if (i2 == 0) {
            int size = size();
            i2 = zzb(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzak = i2;
        }
        return i2;
    }

    static cw zzs(int i2) {
        return new cw(i2, (byte) 0);
    }

    /* access modifiers changed from: protected */
    public final int zzgo() {
        return this.zzak;
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
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    public /* synthetic */ Iterator iterator() {
        return new cn(this);
    }
}
