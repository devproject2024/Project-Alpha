package com.google.zxing.e.a;

public final class f {
    public static int a(int[] iArr, int i2, boolean z) {
        int[] iArr2 = iArr;
        int i3 = i2;
        int i4 = 0;
        for (int i5 : iArr2) {
            i4 += i5;
        }
        int length = iArr2.length;
        int i6 = i4;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        while (true) {
            int i10 = length - 1;
            if (i7 >= i10) {
                return i8;
            }
            int i11 = 1 << i7;
            int i12 = i9 | i11;
            int i13 = i8;
            int i14 = 1;
            while (i14 < iArr2[i7]) {
                int i15 = i6 - i14;
                int i16 = length - i7;
                int i17 = i16 - 2;
                int a2 = a(i15 - 1, i17);
                if (z && i12 == 0) {
                    int i18 = i16 - 1;
                    if (i15 - i18 >= i18) {
                        a2 -= a(i15 - i16, i17);
                    }
                }
                if (i16 - 1 > 1) {
                    int i19 = i15 - i17;
                    int i20 = 0;
                    while (i19 > i3) {
                        i20 += a((i15 - i19) - 1, i16 - 3);
                        i19--;
                        int[] iArr3 = iArr;
                    }
                    a2 -= i20 * (i10 - i7);
                } else if (i15 > i3) {
                    a2--;
                }
                i13 += a2;
                i14++;
                i12 &= ~i11;
                iArr2 = iArr;
            }
            i6 -= i14;
            i7++;
            iArr2 = iArr;
            i8 = i13;
            i9 = i12;
        }
    }

    private static int a(int i2, int i3) {
        int i4 = i2 - i3;
        if (i4 > i3) {
            int i5 = i4;
            i4 = i3;
            i3 = i5;
        }
        int i6 = 1;
        int i7 = 1;
        while (i2 > i3) {
            i6 *= i2;
            if (i7 <= i4) {
                i6 /= i7;
                i7++;
            }
            i2--;
        }
        while (i7 <= i4) {
            i6 /= i7;
            i7++;
        }
        return i6;
    }
}
