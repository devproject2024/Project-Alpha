package com.google.android.gms.internal.firebase_ml;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import net.one97.paytm.nativesdk.instruments.upipush.view.UpiPushView;

final class ic extends fh {
    static final int[] zzcox = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, UpiPushView.REQUEST_CODE_UPI_CHECK_BALANCE, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zzcoy;
    /* access modifiers changed from: private */
    public final fh zzcoz;
    /* access modifiers changed from: private */
    public final fh zzcpa;
    private final int zzcpb;
    private final int zzcpc;

    private ic(fh fhVar, fh fhVar2) {
        this.zzcoz = fhVar;
        this.zzcpa = fhVar2;
        this.zzcpb = fhVar.size();
        this.zzcoy = this.zzcpb + fhVar2.size();
        this.zzcpc = Math.max(fhVar.zztr(), fhVar2.zztr()) + 1;
    }

    static fh zza(fh fhVar, fh fhVar2) {
        if (fhVar2.size() == 0) {
            return fhVar;
        }
        if (fhVar.size() == 0) {
            return fhVar2;
        }
        int size = fhVar.size() + fhVar2.size();
        if (size < 128) {
            return zzb(fhVar, fhVar2);
        }
        if (fhVar instanceof ic) {
            ic icVar = (ic) fhVar;
            if (icVar.zzcpa.size() + fhVar2.size() < 128) {
                return new ic(icVar.zzcoz, zzb(icVar.zzcpa, fhVar2));
            } else if (icVar.zzcoz.zztr() > icVar.zzcpa.zztr() && icVar.zztr() > fhVar2.zztr()) {
                return new ic(icVar.zzcoz, new ic(icVar.zzcpa, fhVar2));
            }
        }
        if (size >= zzdz(Math.max(fhVar.zztr(), fhVar2.zztr()) + 1)) {
            return new ic(fhVar, fhVar2);
        }
        ie ieVar = new ie((byte) 0);
        ieVar.a(fhVar);
        ieVar.a(fhVar2);
        fh pop = ieVar.f9988a.pop();
        while (!ieVar.f9988a.isEmpty()) {
            pop = new ic(ieVar.f9988a.pop(), pop, (Cif) null);
        }
        return pop;
    }

    private static fh zzb(fh fhVar, fh fhVar2) {
        int size = fhVar.size();
        int size2 = fhVar2.size();
        byte[] bArr = new byte[(size + size2)];
        fhVar.zza(bArr, 0, 0, size);
        fhVar2.zza(bArr, 0, size, size2);
        return new fr(bArr);
    }

    static int zzdz(int i2) {
        int[] iArr = zzcox;
        if (i2 >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i2];
    }

    public final byte zzcw(int i2) {
        zzg(i2, this.zzcoy);
        return zzcx(i2);
    }

    /* access modifiers changed from: package-private */
    public final byte zzcx(int i2) {
        int i3 = this.zzcpb;
        if (i2 < i3) {
            return this.zzcoz.zzcx(i2);
        }
        return this.zzcpa.zzcx(i2 - i3);
    }

    public final int size() {
        return this.zzcoy;
    }

    public final fm zzto() {
        return new Cif(this);
    }

    /* access modifiers changed from: protected */
    public final int zztr() {
        return this.zzcpc;
    }

    /* access modifiers changed from: protected */
    public final boolean zzts() {
        return this.zzcoy >= zzdz(this.zzcpc);
    }

    public final fh zzf(int i2, int i3) {
        int zzd = zzd(i2, i3, this.zzcoy);
        if (zzd == 0) {
            return fh.zzchp;
        }
        if (zzd == this.zzcoy) {
            return this;
        }
        int i4 = this.zzcpb;
        if (i3 <= i4) {
            return this.zzcoz.zzf(i2, i3);
        }
        if (i2 >= i4) {
            return this.zzcpa.zzf(i2 - i4, i3 - i4);
        }
        fh fhVar = this.zzcoz;
        return new ic(fhVar.zzf(i2, fhVar.size()), this.zzcpa.zzf(0, i3 - this.zzcpb));
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i2, int i3, int i4) {
        int i5 = i2 + i4;
        int i6 = this.zzcpb;
        if (i5 <= i6) {
            this.zzcoz.zzb(bArr, i2, i3, i4);
        } else if (i2 >= i6) {
            this.zzcpa.zzb(bArr, i2 - i6, i3, i4);
        } else {
            int i7 = i6 - i2;
            this.zzcoz.zzb(bArr, i2, i3, i7);
            this.zzcpa.zzb(bArr, 0, i3 + i7, i4 - i7);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(ff ffVar) throws IOException {
        this.zzcoz.zza(ffVar);
        this.zzcpa.zza(ffVar);
    }

    /* access modifiers changed from: protected */
    public final String zzb(Charset charset) {
        byte[] bArr;
        int size = size();
        if (size == 0) {
            bArr = gk.f9936b;
        } else {
            byte[] bArr2 = new byte[size];
            zzb(bArr2, 0, 0, size);
            bArr = bArr2;
        }
        return new String(bArr, charset);
    }

    public final boolean zztq() {
        int zzb = this.zzcoz.zzb(0, 0, this.zzcpb);
        fh fhVar = this.zzcpa;
        if (fhVar.zzb(zzb, 0, fhVar.size()) == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.zzcpb;
        if (i5 <= i6) {
            return this.zzcoz.zzb(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.zzcpa.zzb(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.zzcpa.zzb(this.zzcoz.zzb(i2, i3, i7), 0, i4 - i7);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fh)) {
            return false;
        }
        fh fhVar = (fh) obj;
        if (this.zzcoy != fhVar.size()) {
            return false;
        }
        if (this.zzcoy == 0) {
            return true;
        }
        int zztt = zztt();
        int zztt2 = fhVar.zztt();
        if (zztt != 0 && zztt2 != 0 && zztt != zztt2) {
            return false;
        }
        ih ihVar = new ih(this, (byte) 0);
        fo foVar = (fo) ihVar.next();
        ih ihVar2 = new ih(fhVar, (byte) 0);
        fo foVar2 = (fo) ihVar2.next();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int size = foVar.size() - i2;
            int size2 = foVar2.size() - i3;
            int min = Math.min(size, size2);
            if (i2 == 0) {
                z = foVar.zza(foVar2, i3, min);
            } else {
                z = foVar2.zza(foVar, i2, min);
            }
            if (!z) {
                return false;
            }
            i4 += min;
            int i5 = this.zzcoy;
            if (i4 < i5) {
                if (min == size) {
                    foVar = (fo) ihVar.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
                if (min == size2) {
                    foVar2 = (fo) ihVar2.next();
                    i3 = 0;
                } else {
                    i3 += min;
                }
            } else if (i4 == i5) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int zzc(int i2, int i3, int i4) {
        int i5 = i3 + i4;
        int i6 = this.zzcpb;
        if (i5 <= i6) {
            return this.zzcoz.zzc(i2, i3, i4);
        }
        if (i3 >= i6) {
            return this.zzcpa.zzc(i2, i3 - i6, i4);
        }
        int i7 = i6 - i3;
        return this.zzcpa.zzc(this.zzcoz.zzc(i2, i3, i7), 0, i4 - i7);
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    /* synthetic */ ic(fh fhVar, fh fhVar2, Cif ifVar) {
        this(fhVar, fhVar2);
    }
}
