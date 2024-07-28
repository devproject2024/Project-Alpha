package com.google.android.gms.internal.firebase_ml;

import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.upi.util.UpiConstants;

public abstract class fh implements Serializable, Iterable<Byte> {
    public static final fh zzchp = new fr(gk.f9936b);
    private static final fn zzchq = (fd.a() ? new fq((byte) 0) : new fl((byte) 0));
    private static final Comparator<fh> zzchr = new fj();
    private int zzamb = 0;

    fh() {
    }

    /* access modifiers changed from: private */
    public static int zzb(byte b2) {
        return b2 & 255;
    }

    public abstract boolean equals(Object obj);

    public abstract int size();

    /* access modifiers changed from: package-private */
    public abstract void zza(ff ffVar) throws IOException;

    /* access modifiers changed from: protected */
    public abstract int zzb(int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public abstract String zzb(Charset charset);

    /* access modifiers changed from: protected */
    public abstract void zzb(byte[] bArr, int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public abstract int zzc(int i2, int i3, int i4);

    public abstract byte zzcw(int i2);

    /* access modifiers changed from: package-private */
    public abstract byte zzcx(int i2);

    public abstract fh zzf(int i2, int i3);

    public abstract boolean zztq();

    /* access modifiers changed from: protected */
    public abstract int zztr();

    /* access modifiers changed from: protected */
    public abstract boolean zzts();

    /* renamed from: zzto */
    public fm iterator() {
        return new fg(this);
    }

    public static fh zzc(byte[] bArr, int i2, int i3) {
        zzd(i2, i2 + i3, bArr.length);
        return new fr(zzchq.a(bArr, i2, i3));
    }

    public static fh zzcj(String str) {
        return new fr(str.getBytes(gk.f9935a));
    }

    public static fh zzb(InputStream inputStream) throws IOException {
        fh fhVar;
        ArrayList arrayList = new ArrayList();
        int i2 = UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS;
        while (true) {
            byte[] bArr = new byte[i2];
            int i3 = 0;
            while (i3 < i2) {
                int read = inputStream.read(bArr, i3, i2 - i3);
                if (read == -1) {
                    break;
                }
                i3 += read;
            }
            if (i3 == 0) {
                fhVar = null;
            } else {
                fhVar = zzc(bArr, 0, i3);
            }
            if (fhVar == null) {
                break;
            }
            arrayList.add(fhVar);
            i2 = Math.min(i2 << 1, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        }
        int size = arrayList.size();
        if (size == 0) {
            return zzchp;
        }
        return zza(arrayList.iterator(), size);
    }

    private static fh zza(Iterator<fh> it2, int i2) {
        if (i2 <= 0) {
            throw new IllegalArgumentException(String.format("length (%s) must be >= 1", new Object[]{Integer.valueOf(i2)}));
        } else if (i2 == 1) {
            return it2.next();
        } else {
            int i3 = i2 >>> 1;
            fh zza = zza(it2, i3);
            fh zza2 = zza(it2, i2 - i3);
            if (Integer.MAX_VALUE - zza.size() >= zza2.size()) {
                return ic.zza(zza, zza2);
            }
            int size = zza.size();
            int size2 = zza2.size();
            StringBuilder sb = new StringBuilder(53);
            sb.append("ByteString would be too long: ");
            sb.append(size);
            sb.append("+");
            sb.append(size2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    @Deprecated
    public final void zza(byte[] bArr, int i2, int i3, int i4) {
        zzd(0, i4 + 0, size());
        zzd(i3, i3 + i4, bArr.length);
        if (i4 > 0) {
            zzb(bArr, 0, i3, i4);
        }
    }

    public final String zztp() {
        return size() == 0 ? "" : zzb(gk.f9935a);
    }

    public final int hashCode() {
        int i2 = this.zzamb;
        if (i2 == 0) {
            int size = size();
            i2 = zzc(size, 0, size);
            if (i2 == 0) {
                i2 = 1;
            }
            this.zzamb = i2;
        }
        return i2;
    }

    static fp zzcy(int i2) {
        return new fp(i2, (byte) 0);
    }

    /* access modifiers changed from: protected */
    public final int zztt() {
        return this.zzamb;
    }

    static void zzg(int i2, int i3) {
        if (((i3 - (i2 + 1)) | i2) >= 0) {
            return;
        }
        if (i2 < 0) {
            StringBuilder sb = new StringBuilder(22);
            sb.append("Index < 0: ");
            sb.append(i2);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Index > length: ");
        sb2.append(i2);
        sb2.append(", ");
        sb2.append(i3);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    static int zzd(int i2, int i3, int i4) {
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
        objArr[2] = size() <= 50 ? iu.a(this) : String.valueOf(iu.a(zzf(0, 47))).concat(AppConstants.DOTS);
        return String.format(locale, "<ByteString@%s size=%d contents=\"%s\">", objArr);
    }
}
