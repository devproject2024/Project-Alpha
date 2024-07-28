package com.google.zxing.e;

import com.google.zxing.e;
import com.google.zxing.m;
import com.google.zxing.r;
import com.google.zxing.t;
import java.util.Arrays;
import java.util.Map;

public final class a extends r {

    /* renamed from: a  reason: collision with root package name */
    static final char[] f40304a = "0123456789-$:/.+ABCD".toCharArray();

    /* renamed from: b  reason: collision with root package name */
    static final int[] f40305b = {3, 6, 9, 96, 18, 66, 33, 36, 48, 72, 12, 24, 69, 81, 84, 21, 26, 41, 11, 14};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f40306c = {'A', 'B', 'C', 'D'};

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f40307d = new StringBuilder(20);

    /* renamed from: e  reason: collision with root package name */
    private int[] f40308e = new int[80];

    /* renamed from: f  reason: collision with root package name */
    private int f40309f = 0;

    public final r a(int i2, com.google.zxing.b.a aVar, Map<e, ?> map) throws m {
        com.google.zxing.b.a aVar2 = aVar;
        Map<e, ?> map2 = map;
        Arrays.fill(this.f40308e, 0);
        this.f40309f = 0;
        int d2 = aVar2.d(0);
        int i3 = aVar2.f39881b;
        if (d2 < i3) {
            int i4 = 0;
            boolean z = true;
            while (d2 < i3) {
                if (aVar2.a(d2) != z) {
                    i4++;
                } else {
                    a(i4);
                    z = !z;
                    i4 = 1;
                }
                d2++;
            }
            a(i4);
            int i5 = 1;
            while (i5 < this.f40309f) {
                int b2 = b(i5);
                if (b2 != -1 && a(f40306c, f40304a[b2])) {
                    int i6 = 0;
                    for (int i7 = i5; i7 < i5 + 7; i7++) {
                        i6 += this.f40308e[i7];
                    }
                    if (i5 == 1 || this.f40308e[i5 - 1] >= i6 / 2) {
                        this.f40307d.setLength(0);
                        int i8 = i5;
                        while (true) {
                            int b3 = b(i8);
                            if (b3 != -1) {
                                this.f40307d.append((char) b3);
                                i8 += 8;
                                if ((this.f40307d.length() <= 1 || !a(f40306c, f40304a[b3])) && i8 < this.f40309f) {
                                    int i9 = i2;
                                }
                            } else {
                                throw m.getNotFoundInstance();
                            }
                        }
                        int i10 = i8 - 1;
                        int i11 = this.f40308e[i10];
                        int i12 = 0;
                        for (int i13 = -8; i13 < -1; i13++) {
                            i12 += this.f40308e[i8 + i13];
                        }
                        if (i8 >= this.f40309f || i11 >= i12 / 2) {
                            int[] iArr = {0, 0, 0, 0};
                            int[] iArr2 = {0, 0, 0, 0};
                            int length = this.f40307d.length() - 1;
                            int i14 = i5;
                            int i15 = 0;
                            while (true) {
                                int i16 = f40305b[this.f40307d.charAt(i15)];
                                for (int i17 = 6; i17 >= 0; i17--) {
                                    int i18 = (i17 & 1) + ((i16 & 1) << 1);
                                    iArr[i18] = iArr[i18] + this.f40308e[i14 + i17];
                                    iArr2[i18] = iArr2[i18] + 1;
                                    i16 >>= 1;
                                }
                                if (i15 >= length) {
                                    break;
                                }
                                i14 += 8;
                                i15++;
                            }
                            float[] fArr = new float[4];
                            float[] fArr2 = new float[4];
                            int i19 = 0;
                            for (int i20 = 2; i19 < i20; i20 = 2) {
                                fArr2[i19] = 0.0f;
                                int i21 = i19 + 2;
                                fArr2[i21] = ((((float) iArr[i19]) / ((float) iArr2[i19])) + (((float) iArr[i21]) / ((float) iArr2[i21]))) / 2.0f;
                                fArr[i19] = fArr2[i21];
                                fArr[i21] = ((((float) iArr[i21]) * 2.0f) + 1.5f) / ((float) iArr2[i21]);
                                i19++;
                            }
                            int i22 = i5;
                            int i23 = 0;
                            loop8:
                            while (true) {
                                int i24 = f40305b[this.f40307d.charAt(i23)];
                                int i25 = 6;
                                while (i25 >= 0) {
                                    int i26 = (i25 & 1) + ((i24 & 1) << 1);
                                    float f2 = (float) this.f40308e[i22 + i25];
                                    if (f2 >= fArr2[i26] && f2 <= fArr[i26]) {
                                        i24 >>= 1;
                                        i25--;
                                    }
                                }
                                if (i23 < length) {
                                    i22 += 8;
                                    i23++;
                                } else {
                                    for (int i27 = 0; i27 < this.f40307d.length(); i27++) {
                                        StringBuilder sb = this.f40307d;
                                        sb.setCharAt(i27, f40304a[sb.charAt(i27)]);
                                    }
                                    if (a(f40306c, this.f40307d.charAt(0))) {
                                        StringBuilder sb2 = this.f40307d;
                                        if (!a(f40306c, sb2.charAt(sb2.length() - 1))) {
                                            throw m.getNotFoundInstance();
                                        } else if (this.f40307d.length() > 3) {
                                            if (map2 == null || !map2.containsKey(e.RETURN_CODABAR_START_END)) {
                                                StringBuilder sb3 = this.f40307d;
                                                sb3.deleteCharAt(sb3.length() - 1);
                                                this.f40307d.deleteCharAt(0);
                                            }
                                            int i28 = 0;
                                            for (int i29 = 0; i29 < i5; i29++) {
                                                i28 += this.f40308e[i29];
                                            }
                                            float f3 = (float) i28;
                                            while (i5 < i10) {
                                                i28 += this.f40308e[i5];
                                                i5++;
                                            }
                                            float f4 = (float) i2;
                                            return new r(this.f40307d.toString(), (byte[]) null, new t[]{new t(f3, f4), new t((float) i28, f4)}, com.google.zxing.a.CODABAR);
                                        } else {
                                            throw m.getNotFoundInstance();
                                        }
                                    } else {
                                        throw m.getNotFoundInstance();
                                    }
                                }
                            }
                            throw m.getNotFoundInstance();
                        }
                        throw m.getNotFoundInstance();
                    }
                }
                int i30 = i2;
                i5 += 2;
            }
            throw m.getNotFoundInstance();
        }
        throw m.getNotFoundInstance();
    }

    private void a(int i2) {
        int[] iArr = this.f40308e;
        int i3 = this.f40309f;
        iArr[i3] = i2;
        this.f40309f = i3 + 1;
        int i4 = this.f40309f;
        if (i4 >= iArr.length) {
            int[] iArr2 = new int[(i4 << 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f40308e = iArr2;
        }
    }

    static boolean a(char[] cArr, char c2) {
        if (cArr != null) {
            for (char c3 : cArr) {
                if (c3 == c2) {
                    return true;
                }
            }
        }
        return false;
    }

    private int b(int i2) {
        int i3 = i2 + 7;
        if (i3 >= this.f40309f) {
            return -1;
        }
        int[] iArr = this.f40308e;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        int i6 = Integer.MAX_VALUE;
        int i7 = 0;
        for (int i8 = i2; i8 < i3; i8 += 2) {
            int i9 = iArr[i8];
            if (i9 < i6) {
                i6 = i9;
            }
            if (i9 > i7) {
                i7 = i9;
            }
        }
        int i10 = (i6 + i7) / 2;
        int i11 = 0;
        for (int i12 = i2 + 1; i12 < i3; i12 += 2) {
            int i13 = iArr[i12];
            if (i13 < i4) {
                i4 = i13;
            }
            if (i13 > i11) {
                i11 = i13;
            }
        }
        int i14 = (i4 + i11) / 2;
        int i15 = 128;
        int i16 = 0;
        for (int i17 = 0; i17 < 7; i17++) {
            i15 >>= 1;
            if (iArr[i2 + i17] > ((i17 & 1) == 0 ? i10 : i14)) {
                i16 |= i15;
            }
        }
        while (true) {
            int[] iArr2 = f40305b;
            if (i5 >= iArr2.length) {
                return -1;
            }
            if (iArr2[i5] == i16) {
                return i5;
            }
            i5++;
        }
    }
}
