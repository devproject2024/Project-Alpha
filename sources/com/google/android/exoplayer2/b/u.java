package com.google.android.exoplayer2.b;

import com.google.android.exoplayer2.g.a;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import java.util.Arrays;

final class u {

    /* renamed from: a  reason: collision with root package name */
    final int f31259a;

    /* renamed from: b  reason: collision with root package name */
    final float f31260b;

    /* renamed from: c  reason: collision with root package name */
    final float f31261c;

    /* renamed from: d  reason: collision with root package name */
    final float f31262d;

    /* renamed from: e  reason: collision with root package name */
    final int f31263e = (this.t * 2);

    /* renamed from: f  reason: collision with root package name */
    short[] f31264f;

    /* renamed from: g  reason: collision with root package name */
    int f31265g;

    /* renamed from: h  reason: collision with root package name */
    short[] f31266h;

    /* renamed from: i  reason: collision with root package name */
    int f31267i;
    int j;
    int k;
    int l;
    int m;
    int n;
    int o;
    int p;
    int q;
    private final int r;
    private final int s;
    private final int t;
    private final short[] u;
    private short[] v;

    public u(int i2, int i3, float f2, float f3, int i4) {
        this.r = i2;
        this.f31259a = i3;
        this.f31260b = f2;
        this.f31261c = f3;
        this.f31262d = ((float) i2) / ((float) i4);
        this.s = i2 / 400;
        this.t = i2 / 65;
        int i5 = this.f31263e;
        this.u = new short[i5];
        this.f31264f = new short[(i5 * i3)];
        this.f31266h = new short[(i5 * i3)];
        this.v = new short[(i5 * i3)];
    }

    public final int a() {
        return this.f31267i * this.f31259a * 2;
    }

    /* access modifiers changed from: package-private */
    public final short[] a(short[] sArr, int i2, int i3) {
        int length = sArr.length;
        int i4 = this.f31259a;
        int i5 = length / i4;
        if (i2 + i3 <= i5) {
            return sArr;
        }
        return Arrays.copyOf(sArr, (((i5 * 3) / 2) + i3) * i4);
    }

    private void b(short[] sArr, int i2, int i3) {
        this.f31266h = a(this.f31266h, this.f31267i, i3);
        int i4 = this.f31259a;
        System.arraycopy(sArr, i2 * i4, this.f31266h, this.f31267i * i4, i4 * i3);
        this.f31267i += i3;
    }

    private void c(short[] sArr, int i2, int i3) {
        int i4 = this.f31263e / i3;
        int i5 = this.f31259a;
        int i6 = i3 * i5;
        int i7 = i2 * i5;
        for (int i8 = 0; i8 < i4; i8++) {
            int i9 = 0;
            for (int i10 = 0; i10 < i6; i10++) {
                i9 += sArr[(i8 * i6) + i7 + i10];
            }
            this.u[i8] = (short) (i9 / i6);
        }
    }

    private int a(short[] sArr, int i2, int i3, int i4) {
        int i5 = i2 * this.f31259a;
        int i6 = 1;
        int i7 = 0;
        int i8 = 0;
        int i9 = PriceRangeSeekBar.INVALID_POINTER_ID;
        while (i3 <= i4) {
            int i10 = 0;
            for (int i11 = 0; i11 < i3; i11++) {
                i10 += Math.abs(sArr[i5 + i11] - sArr[(i5 + i3) + i11]);
            }
            if (i10 * i7 < i6 * i3) {
                i7 = i3;
                i6 = i10;
            }
            if (i10 * i9 > i8 * i3) {
                i9 = i3;
                i8 = i10;
            }
            i3++;
        }
        this.p = i6 / i7;
        this.q = i8 / i9;
        return i7;
    }

    /* access modifiers changed from: package-private */
    public final void b() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8 = this.f31267i;
        float f2 = this.f31260b;
        float f3 = this.f31261c;
        float f4 = f2 / f3;
        float f5 = this.f31262d * f3;
        double d2 = (double) f4;
        float f6 = 1.0f;
        int i9 = 1;
        if (d2 > 1.00001d || d2 < 0.99999d) {
            int i10 = this.f31265g;
            if (i10 >= this.f31263e) {
                int i11 = 0;
                while (true) {
                    int i12 = this.m;
                    if (i12 > 0) {
                        int min = Math.min(this.f31263e, i12);
                        b(this.f31264f, i11, min);
                        this.m -= min;
                        i11 += min;
                    } else {
                        short[] sArr = this.f31264f;
                        int i13 = this.r;
                        int i14 = i13 > 4000 ? i13 / 4000 : 1;
                        if (this.f31259a == i9 && i14 == i9) {
                            i5 = a(sArr, i11, this.s, this.t);
                        } else {
                            c(sArr, i11, i14);
                            int a2 = a(this.u, 0, this.s / i14, this.t / i14);
                            if (i14 != i9) {
                                int i15 = a2 * i14;
                                int i16 = i14 * 4;
                                int i17 = i15 - i16;
                                int i18 = i15 + i16;
                                int i19 = this.s;
                                if (i17 >= i19) {
                                    i19 = i17;
                                }
                                int i20 = this.t;
                                if (i18 > i20) {
                                    i18 = i20;
                                }
                                if (this.f31259a == i9) {
                                    i5 = a(sArr, i11, i19, i18);
                                } else {
                                    c(sArr, i11, i9);
                                    i5 = a(this.u, 0, i19, i18);
                                }
                            } else {
                                i5 = a2;
                            }
                        }
                        int i21 = this.p;
                        int i22 = i21 != 0 && this.n != 0 && this.q <= i21 * 3 && i21 * 2 > this.o * 3 ? this.n : i5;
                        this.o = this.p;
                        this.n = i5;
                        if (d2 > 1.0d) {
                            short[] sArr2 = this.f31264f;
                            if (f4 >= 2.0f) {
                                i7 = (int) (((float) i22) / (f4 - f6));
                            } else {
                                this.m = (int) ((((float) i22) * (2.0f - f4)) / (f4 - f6));
                                i7 = i22;
                            }
                            this.f31266h = a(this.f31266h, this.f31267i, i7);
                            int i23 = i7;
                            short[] sArr3 = sArr2;
                            a(i7, this.f31259a, this.f31266h, this.f31267i, sArr3, i11, sArr3, i11 + i22);
                            this.f31267i += i23;
                            i11 += i22 + i23;
                        } else {
                            int i24 = i22;
                            short[] sArr4 = this.f31264f;
                            if (f4 < 0.5f) {
                                i6 = (int) ((((float) i24) * f4) / (f6 - f4));
                            } else {
                                this.m = (int) ((((float) i24) * ((2.0f * f4) - f6)) / (f6 - f4));
                                i6 = i24;
                            }
                            int i25 = i24 + i6;
                            this.f31266h = a(this.f31266h, this.f31267i, i25);
                            int i26 = this.f31259a;
                            System.arraycopy(sArr4, i11 * i26, this.f31266h, this.f31267i * i26, i26 * i24);
                            a(i6, this.f31259a, this.f31266h, this.f31267i + i24, sArr4, i11 + i24, sArr4, i11);
                            this.f31267i += i25;
                            i11 += i6;
                        }
                    }
                    if (this.f31263e + i11 > i10) {
                        break;
                    }
                    f6 = 1.0f;
                    i9 = 1;
                }
                int i27 = this.f31265g - i11;
                short[] sArr5 = this.f31264f;
                int i28 = this.f31259a;
                System.arraycopy(sArr5, i11 * i28, sArr5, 0, i28 * i27);
                this.f31265g = i27;
            }
        } else {
            b(this.f31264f, 0, this.f31265g);
            this.f31265g = 0;
        }
        if (f5 != 1.0f && this.f31267i != i8) {
            int i29 = this.r;
            int i30 = (int) (((float) i29) / f5);
            while (true) {
                if (i30 <= 16384 && i29 <= 16384) {
                    break;
                }
                i30 /= 2;
                i29 /= 2;
            }
            int i31 = this.f31267i - i8;
            this.v = a(this.v, this.j, i31);
            short[] sArr6 = this.f31266h;
            int i32 = this.f31259a;
            System.arraycopy(sArr6, i8 * i32, this.v, this.j * i32, i32 * i31);
            this.f31267i = i8;
            this.j += i31;
            int i33 = 0;
            while (true) {
                i2 = this.j;
                if (i33 >= i2 - 1) {
                    break;
                }
                while (true) {
                    i3 = this.k;
                    int i34 = (i3 + 1) * i30;
                    i4 = this.l;
                    if (i34 <= i4 * i29) {
                        break;
                    }
                    this.f31266h = a(this.f31266h, this.f31267i, 1);
                    int i35 = 0;
                    while (true) {
                        int i36 = this.f31259a;
                        if (i35 >= i36) {
                            break;
                        }
                        short[] sArr7 = this.v;
                        int i37 = (i33 * i36) + i35;
                        short s2 = sArr7[i37];
                        short s3 = sArr7[i37 + i36];
                        int i38 = this.k;
                        int i39 = i38 * i30;
                        int i40 = (i38 + 1) * i30;
                        int i41 = i40 - (this.l * i29);
                        int i42 = i40 - i39;
                        this.f31266h[(this.f31267i * i36) + i35] = (short) (((s2 * i41) + ((i42 - i41) * s3)) / i42);
                        i35++;
                    }
                    this.l++;
                    this.f31267i++;
                }
                this.k = i3 + 1;
                if (this.k == i29) {
                    this.k = 0;
                    a.b(i4 == i30);
                    this.l = 0;
                }
                i33++;
            }
            int i43 = i2 - 1;
            if (i43 != 0) {
                short[] sArr8 = this.v;
                int i44 = this.f31259a;
                System.arraycopy(sArr8, i43 * i44, sArr8, 0, (i2 - i43) * i44);
                this.j -= i43;
            }
        }
    }

    private static void a(int i2, int i3, short[] sArr, int i4, short[] sArr2, int i5, short[] sArr3, int i6) {
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = (i5 * i3) + i7;
            int i9 = (i6 * i3) + i7;
            int i10 = (i4 * i3) + i7;
            for (int i11 = 0; i11 < i2; i11++) {
                sArr[i10] = (short) (((sArr2[i8] * (i2 - i11)) + (sArr3[i9] * i11)) / i2);
                i10 += i3;
                i8 += i3;
                i9 += i3;
            }
        }
    }
}
