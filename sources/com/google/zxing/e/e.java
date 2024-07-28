package com.google.zxing.e;

import com.google.zxing.b.a;
import com.google.zxing.d;
import com.google.zxing.h;
import com.google.zxing.m;
import com.google.zxing.r;
import com.google.zxing.t;
import java.util.Arrays;
import java.util.Map;

public final class e extends r {

    /* renamed from: a  reason: collision with root package name */
    static final int[] f40367a = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};

    /* renamed from: b  reason: collision with root package name */
    private final boolean f40368b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f40369c;

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f40370d;

    /* renamed from: e  reason: collision with root package name */
    private final int[] f40371e;

    public e() {
        this(false);
    }

    public e(boolean z) {
        this(z, (byte) 0);
    }

    private e(boolean z, byte b2) {
        this.f40368b = z;
        this.f40369c = false;
        this.f40370d = new StringBuilder(20);
        this.f40371e = new int[9];
    }

    public final r a(int i2, a aVar, Map<com.google.zxing.e, ?> map) throws m, d, h {
        char c2;
        char c3;
        String str;
        char c4;
        int i3;
        a aVar2 = aVar;
        int[] iArr = this.f40371e;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f40370d;
        sb.setLength(0);
        int i4 = aVar2.f39881b;
        int c5 = aVar2.c(0);
        int length = iArr.length;
        int i5 = c5;
        boolean z = false;
        int i6 = 0;
        while (c5 < i4) {
            if (aVar2.a(c5) != z) {
                iArr[i6] = iArr[i6] + 1;
                int i7 = i2;
            } else {
                if (i6 != length - 1) {
                    int i8 = i2;
                    i6++;
                } else if (a(iArr) != 148 || !aVar2.a(Math.max(0, i5 - ((c5 - i5) / 2)), i5)) {
                    int i9 = i2;
                    i5 += iArr[0] + iArr[1];
                    int i10 = i6 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i10);
                    iArr[i10] = 0;
                    iArr[i6] = 0;
                    i6--;
                } else {
                    int[] iArr2 = {i5, c5};
                    int c6 = aVar2.c(iArr2[1]);
                    int i11 = aVar2.f39881b;
                    while (true) {
                        a(aVar2, c6, iArr);
                        int a2 = a(iArr);
                        if (a2 >= 0) {
                            int i12 = 0;
                            while (true) {
                                int[] iArr3 = f40367a;
                                if (i12 < iArr3.length) {
                                    if (iArr3[i12] == a2) {
                                        c2 = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i12);
                                        break;
                                    }
                                    i12++;
                                } else if (a2 == 148) {
                                    c2 = '*';
                                } else {
                                    throw m.getNotFoundInstance();
                                }
                            }
                            sb.append(c2);
                            int i13 = c6;
                            for (int i14 : iArr) {
                                i13 += i14;
                            }
                            int c7 = aVar2.c(i13);
                            if (c2 == '*') {
                                sb.setLength(sb.length() - 1);
                                int i15 = 0;
                                for (int i16 : iArr) {
                                    i15 += i16;
                                }
                                int i17 = (c7 - c6) - i15;
                                if (c7 == i11 || (i17 << 1) >= i15) {
                                    if (this.f40368b) {
                                        int length2 = sb.length() - 1;
                                        int i18 = 0;
                                        for (int i19 = 0; i19 < length2; i19++) {
                                            i18 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f40370d.charAt(i19));
                                        }
                                        if (sb.charAt(length2) == "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i18 % 43)) {
                                            sb.setLength(length2);
                                        } else {
                                            throw d.getChecksumInstance();
                                        }
                                    }
                                    if (sb.length() != 0) {
                                        if (this.f40369c) {
                                            int length3 = sb.length();
                                            StringBuilder sb2 = new StringBuilder(length3);
                                            int i20 = 0;
                                            while (i20 < length3) {
                                                char charAt = sb.charAt(i20);
                                                if (charAt == '+' || charAt == '$' || charAt == '%' || charAt == '/') {
                                                    i20++;
                                                    char charAt2 = sb.charAt(i20);
                                                    if (charAt != '$') {
                                                        if (charAt != '%') {
                                                            if (charAt != '+') {
                                                                if (charAt == '/') {
                                                                    if (charAt2 >= 'A' && charAt2 <= 'O') {
                                                                        i3 = charAt2 - ' ';
                                                                    } else if (charAt2 == 'Z') {
                                                                        c4 = ':';
                                                                        sb2.append(c4);
                                                                    } else {
                                                                        throw h.getFormatInstance();
                                                                    }
                                                                }
                                                            } else if (charAt2 < 'A' || charAt2 > 'Z') {
                                                                throw h.getFormatInstance();
                                                            } else {
                                                                i3 = charAt2 + ' ';
                                                            }
                                                        } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                                                            i3 = charAt2 - '&';
                                                        } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                                                            i3 = charAt2 - 11;
                                                        } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                                                            i3 = charAt2 + 16;
                                                        } else if (charAt2 >= 'P' && charAt2 <= 'T') {
                                                            i3 = charAt2 + '+';
                                                        } else if (charAt2 != 'U') {
                                                            if (charAt2 == 'V') {
                                                                c4 = '@';
                                                            } else if (charAt2 == 'W') {
                                                                c4 = '`';
                                                            } else if (charAt2 == 'X' || charAt2 == 'Y' || charAt2 == 'Z') {
                                                                c4 = 127;
                                                            } else {
                                                                throw h.getFormatInstance();
                                                            }
                                                            sb2.append(c4);
                                                        }
                                                        c4 = 0;
                                                        sb2.append(c4);
                                                    } else if (charAt2 < 'A' || charAt2 > 'Z') {
                                                        throw h.getFormatInstance();
                                                    } else {
                                                        i3 = charAt2 - '@';
                                                    }
                                                    c4 = (char) i3;
                                                    sb2.append(c4);
                                                } else {
                                                    sb2.append(charAt);
                                                }
                                                i20++;
                                            }
                                            c3 = 1;
                                            str = sb2.toString();
                                        } else {
                                            c3 = 1;
                                            str = sb.toString();
                                        }
                                        float f2 = (float) i2;
                                        return new r(str, (byte[]) null, new t[]{new t(((float) (iArr2[c3] + iArr2[0])) / 2.0f, f2), new t(((float) c6) + (((float) i15) / 2.0f), f2)}, com.google.zxing.a.CODE_39);
                                    }
                                    throw m.getNotFoundInstance();
                                }
                                throw m.getNotFoundInstance();
                            }
                            int i21 = i2;
                            c6 = c7;
                        } else {
                            throw m.getNotFoundInstance();
                        }
                    }
                }
                iArr[i6] = 1;
                z = !z;
            }
            c5++;
        }
        throw m.getNotFoundInstance();
    }

    private static int a(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i3) {
                        i5--;
                        if ((i11 << 1) >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            } else if (i5 <= 3) {
                return -1;
            } else {
                i2 = i3;
            }
        }
    }
}
