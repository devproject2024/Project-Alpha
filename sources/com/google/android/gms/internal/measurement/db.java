package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Arrays;

final class db extends cz {

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f10547d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f10548e;

    /* renamed from: f  reason: collision with root package name */
    private int f10549f;

    /* renamed from: g  reason: collision with root package name */
    private int f10550g;

    /* renamed from: h  reason: collision with root package name */
    private int f10551h;

    /* renamed from: i  reason: collision with root package name */
    private int f10552i;
    private int j;
    private int k;

    private db(byte[] bArr, int i2) {
        super((byte) 0);
        this.k = Integer.MAX_VALUE;
        this.f10547d = bArr;
        this.f10549f = i2 + 0;
        this.f10551h = 0;
        this.f10552i = this.f10551h;
        this.f10548e = false;
    }

    public final int a() throws IOException {
        if (t()) {
            this.j = 0;
            return 0;
        }
        this.j = v();
        int i2 = this.j;
        if ((i2 >>> 3) != 0) {
            return i2;
        }
        throw eg.zzd();
    }

    public final void a(int i2) throws eg {
        if (this.j != i2) {
            throw eg.zze();
        }
    }

    public final boolean b(int i2) throws IOException {
        int a2;
        int i3 = i2 & 7;
        int i4 = 0;
        if (i3 == 0) {
            if (this.f10549f - this.f10551h >= 10) {
                while (i4 < 10) {
                    byte[] bArr = this.f10547d;
                    int i5 = this.f10551h;
                    this.f10551h = i5 + 1;
                    if (bArr[i5] < 0) {
                        i4++;
                    }
                }
                throw eg.zzc();
            }
            while (i4 < 10) {
                if (A() < 0) {
                    i4++;
                }
            }
            throw eg.zzc();
            return true;
        } else if (i3 == 1) {
            f(8);
            return true;
        } else if (i3 == 2) {
            f(v());
            return true;
        } else if (i3 == 3) {
            do {
                a2 = a();
                if (a2 == 0 || !b(a2)) {
                    a(((i2 >>> 3) << 3) | 4);
                }
                a2 = a();
                break;
            } while (!b(a2));
            a(((i2 >>> 3) << 3) | 4);
            return true;
        } else if (i3 == 4) {
            return false;
        } else {
            if (i3 == 5) {
                f(4);
                return true;
            }
            throw eg.zzf();
        }
    }

    public final double b() throws IOException {
        return Double.longBitsToDouble(y());
    }

    public final float c() throws IOException {
        return Float.intBitsToFloat(x());
    }

    public final long d() throws IOException {
        return w();
    }

    public final long e() throws IOException {
        return w();
    }

    public final int f() throws IOException {
        return v();
    }

    public final long g() throws IOException {
        return y();
    }

    public final int h() throws IOException {
        return x();
    }

    public final boolean i() throws IOException {
        return w() != 0;
    }

    public final String j() throws IOException {
        int v = v();
        if (v > 0) {
            int i2 = this.f10549f;
            int i3 = this.f10551h;
            if (v <= i2 - i3) {
                String str = new String(this.f10547d, i3, v, dx.f10606a);
                this.f10551h += v;
                return str;
            }
        }
        if (v == 0) {
            return "";
        }
        if (v < 0) {
            throw eg.zzb();
        }
        throw eg.zza();
    }

    public final String k() throws IOException {
        int v = v();
        if (v > 0) {
            int i2 = this.f10549f;
            int i3 = this.f10551h;
            if (v <= i2 - i3) {
                String b2 = gw.b(this.f10547d, i3, v);
                this.f10551h += v;
                return b2;
            }
        }
        if (v == 0) {
            return "";
        }
        if (v <= 0) {
            throw eg.zzb();
        }
        throw eg.zza();
    }

    public final cm l() throws IOException {
        byte[] bArr;
        int v = v();
        if (v > 0) {
            int i2 = this.f10549f;
            int i3 = this.f10551h;
            if (v <= i2 - i3) {
                cm zza = cm.zza(this.f10547d, i3, v);
                this.f10551h += v;
                return zza;
            }
        }
        if (v == 0) {
            return cm.zza;
        }
        if (v > 0) {
            int i4 = this.f10549f;
            int i5 = this.f10551h;
            if (v <= i4 - i5) {
                this.f10551h = v + i5;
                bArr = Arrays.copyOfRange(this.f10547d, i5, this.f10551h);
                return cm.zza(bArr);
            }
        }
        if (v > 0) {
            throw eg.zza();
        } else if (v == 0) {
            bArr = dx.f10607b;
            return cm.zza(bArr);
        } else {
            throw eg.zzb();
        }
    }

    public final int m() throws IOException {
        return v();
    }

    public final int n() throws IOException {
        return v();
    }

    public final int o() throws IOException {
        return x();
    }

    public final long p() throws IOException {
        return y();
    }

    public final int q() throws IOException {
        return e(v());
    }

    public final long r() throws IOException {
        return a(w());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int v() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.f10551h
            int r1 = r5.f10549f
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.f10547d
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.f10551h = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006b
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0068
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002d:
            r1 = r3
            goto L_0x0068
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0068
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006b
        L_0x0068:
            r5.f10551h = r1
            return r0
        L_0x006b:
            long r0 = r5.s()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.db.v():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long w() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.f10551h
            int r1 = r11.f10549f
            if (r1 == r0) goto L_0x00b8
            byte[] r2 = r11.f10547d
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.f10551h = r3
            long r0 = (long) r0
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00b8
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0025
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0022:
            long r2 = (long) r0
            goto L_0x00b5
        L_0x0025:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0036
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r2 = r9
            goto L_0x00b5
        L_0x0036:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0044
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0022
        L_0x0044:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005b
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x0057:
            long r2 = r3 ^ r1
            r1 = r0
            goto L_0x00b5
        L_0x005b:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x006d:
            long r2 = r3 ^ r5
            goto L_0x00b5
        L_0x0070:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0083
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x0057
        L_0x0083:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0096
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x006d
        L_0x0096:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b3
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00b8
            goto L_0x00b4
        L_0x00b3:
            r1 = r0
        L_0x00b4:
            r2 = r3
        L_0x00b5:
            r11.f10551h = r1
            return r2
        L_0x00b8:
            long r0 = r11.s()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.db.w():long");
    }

    /* access modifiers changed from: package-private */
    public final long s() throws IOException {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte A = A();
            j2 |= ((long) (A & Byte.MAX_VALUE)) << i2;
            if ((A & 128) == 0) {
                return j2;
            }
        }
        throw eg.zzc();
    }

    private final int x() throws IOException {
        int i2 = this.f10551h;
        if (this.f10549f - i2 >= 4) {
            byte[] bArr = this.f10547d;
            this.f10551h = i2 + 4;
            return ((bArr[i2 + 3] & 255) << 24) | (bArr[i2] & 255) | ((bArr[i2 + 1] & 255) << 8) | ((bArr[i2 + 2] & 255) << 16);
        }
        throw eg.zza();
    }

    private final long y() throws IOException {
        int i2 = this.f10551h;
        if (this.f10549f - i2 >= 8) {
            byte[] bArr = this.f10547d;
            this.f10551h = i2 + 8;
            return ((((long) bArr[i2 + 7]) & 255) << 56) | (((long) bArr[i2]) & 255) | ((((long) bArr[i2 + 1]) & 255) << 8) | ((((long) bArr[i2 + 2]) & 255) << 16) | ((((long) bArr[i2 + 3]) & 255) << 24) | ((((long) bArr[i2 + 4]) & 255) << 32) | ((((long) bArr[i2 + 5]) & 255) << 40) | ((((long) bArr[i2 + 6]) & 255) << 48);
        }
        throw eg.zza();
    }

    public final int c(int i2) throws eg {
        if (i2 >= 0) {
            int u = i2 + u();
            int i3 = this.k;
            if (u <= i3) {
                this.k = u;
                z();
                return i3;
            }
            throw eg.zza();
        }
        throw eg.zzb();
    }

    private final void z() {
        this.f10549f += this.f10550g;
        int i2 = this.f10549f;
        int i3 = i2 - this.f10552i;
        int i4 = this.k;
        if (i3 > i4) {
            this.f10550g = i3 - i4;
            this.f10549f = i2 - this.f10550g;
            return;
        }
        this.f10550g = 0;
    }

    public final void d(int i2) {
        this.k = i2;
        z();
    }

    public final boolean t() throws IOException {
        return this.f10551h == this.f10549f;
    }

    public final int u() {
        return this.f10551h - this.f10552i;
    }

    private final byte A() throws IOException {
        int i2 = this.f10551h;
        if (i2 != this.f10549f) {
            byte[] bArr = this.f10547d;
            this.f10551h = i2 + 1;
            return bArr[i2];
        }
        throw eg.zza();
    }

    private final void f(int i2) throws IOException {
        if (i2 >= 0) {
            int i3 = this.f10549f;
            int i4 = this.f10551h;
            if (i2 <= i3 - i4) {
                this.f10551h = i4 + i2;
                return;
            }
        }
        if (i2 < 0) {
            throw eg.zzb();
        }
        throw eg.zza();
    }

    /* synthetic */ db(byte[] bArr, int i2, byte b2) {
        this(bArr, i2);
    }
}
