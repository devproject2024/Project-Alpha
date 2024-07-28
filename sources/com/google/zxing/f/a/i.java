package com.google.zxing.f.a;

import com.google.zxing.f.a;
import java.lang.reflect.Array;

final class i {

    /* renamed from: a  reason: collision with root package name */
    private static final float[][] f40455a = ((float[][]) Array.newInstance(float.class, new int[]{a.f40412a.length, 8}));

    static {
        int i2;
        for (int i3 = 0; i3 < a.f40412a.length; i3++) {
            int i4 = a.f40412a[i3];
            int i5 = i4 & 1;
            int i6 = i4;
            int i7 = 0;
            while (i7 < 8) {
                float f2 = 0.0f;
                while (true) {
                    i2 = i6 & 1;
                    if (i2 != i5) {
                        break;
                    }
                    f2 += 1.0f;
                    i6 >>= 1;
                }
                f40455a[i3][(8 - i7) - 1] = f2 / 17.0f;
                i7++;
                i5 = i2;
            }
        }
    }

    static int a(int[] iArr) {
        float a2 = (float) com.google.zxing.b.a.a.a(iArr);
        int[] iArr2 = new int[8];
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 17; i4++) {
            if (((float) (iArr[i3] + i2)) <= (a2 / 34.0f) + ((((float) i4) * a2) / 17.0f)) {
                i2 += iArr[i3];
                i3++;
            }
            iArr2[i3] = iArr2[i3] + 1;
        }
        long j = 0;
        int i5 = 0;
        while (i5 < 8) {
            long j2 = j;
            for (int i6 = 0; i6 < iArr2[i5]; i6++) {
                j2 = (j2 << 1) | ((long) (i5 % 2 == 0 ? 1 : 0));
            }
            i5++;
            j = j2;
        }
        int i7 = (int) j;
        int i8 = -1;
        if (a.a(i7) == -1) {
            i7 = -1;
        }
        if (i7 != -1) {
            return i7;
        }
        int a3 = com.google.zxing.b.a.a.a(iArr);
        float[] fArr = new float[8];
        if (a3 > 1) {
            for (int i9 = 0; i9 < 8; i9++) {
                fArr[i9] = ((float) iArr[i9]) / ((float) a3);
            }
        }
        int i10 = 0;
        float f2 = Float.MAX_VALUE;
        while (true) {
            float[][] fArr2 = f40455a;
            if (i10 >= fArr2.length) {
                return i8;
            }
            float[] fArr3 = fArr2[i10];
            float f3 = 0.0f;
            for (int i11 = 0; i11 < 8; i11++) {
                float f4 = fArr3[i11] - fArr[i11];
                f3 += f4 * f4;
                if (f3 >= f2) {
                    break;
                }
            }
            if (f3 < f2) {
                i8 = a.f40412a[i10];
                f2 = f3;
            }
            i10++;
        }
    }
}
