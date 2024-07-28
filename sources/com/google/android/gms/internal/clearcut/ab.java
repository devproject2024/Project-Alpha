package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

public abstract class ab implements Serializable, Iterable<Byte> {
    public static final ab zzfi = new ai(bh.f9209b);
    private static final af zzfj = (v.a() ? new aj((byte) 0) : new ad((byte) 0));
    private int zzfk = 0;

    ab() {
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

    public static ab zzb(byte[] bArr, int i2, int i3) {
        return new ai(zzfj.a(bArr, i2, i3));
    }

    public static ab zzf(String str) {
        return new ai(str.getBytes(bh.f9208a));
    }

    static ag zzk(int i2) {
        return new ag(i2, (byte) 0);
    }

    public abstract boolean equals(Object obj);

    public final int hashCode() {
        int i2 = this.zzfk;
        if (i2 == 0) {
            int size = size();
            i2 = zza(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzfk = i2;
        }
        return i2;
    }

    public /* synthetic */ Iterator iterator() {
        return new ac(this);
    }

    public abstract int size();

    public final String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size())});
    }

    /* access modifiers changed from: protected */
    public abstract int zza(int i2, int i3, int i4);

    public abstract ab zza(int i2, int i3);

    /* access modifiers changed from: protected */
    public abstract String zza(Charset charset);

    /* access modifiers changed from: package-private */
    public abstract void zza(aa aaVar) throws IOException;

    public abstract boolean zzaa();

    /* access modifiers changed from: protected */
    public final int zzab() {
        return this.zzfk;
    }

    public abstract byte zzj(int i2);

    public final String zzz() {
        return size() == 0 ? "" : zza(bh.f9208a);
    }
}
