package com.google.zxing.e.a;

import com.google.zxing.e.r;
import com.google.zxing.m;

public abstract class a extends r {

    /* renamed from: a  reason: collision with root package name */
    protected final int[] f40310a = new int[4];

    /* renamed from: b  reason: collision with root package name */
    protected final int[] f40311b = new int[8];

    /* renamed from: c  reason: collision with root package name */
    protected final float[] f40312c = new float[4];

    /* renamed from: d  reason: collision with root package name */
    protected final float[] f40313d = new float[4];

    /* renamed from: e  reason: collision with root package name */
    protected final int[] f40314e;

    /* renamed from: f  reason: collision with root package name */
    protected final int[] f40315f;

    protected a() {
        int[] iArr = this.f40311b;
        this.f40314e = new int[(iArr.length / 2)];
        this.f40315f = new int[(iArr.length / 2)];
    }

    protected static int a(int[] iArr, int[][] iArr2) throws m {
        for (int i2 = 0; i2 < iArr2.length; i2++) {
            if (a(iArr, iArr2[i2], 0.45f) < 0.2f) {
                return i2;
            }
        }
        throw m.getNotFoundInstance();
    }

    protected static void a(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i2 = 0;
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] > f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] + 1;
    }

    protected static void b(int[] iArr, float[] fArr) {
        float f2 = fArr[0];
        int i2 = 0;
        for (int i3 = 1; i3 < iArr.length; i3++) {
            if (fArr[i3] < f2) {
                f2 = fArr[i3];
                i2 = i3;
            }
        }
        iArr[i2] = iArr[i2] - 1;
    }

    protected static boolean a(int[] iArr) {
        int i2 = iArr[0] + iArr[1];
        float f2 = ((float) i2) / ((float) ((iArr[2] + i2) + iArr[3]));
        if (f2 >= 0.7916667f && f2 <= 0.89285713f) {
            int i3 = Integer.MIN_VALUE;
            int i4 = Integer.MAX_VALUE;
            for (int i5 : iArr) {
                if (i5 > i3) {
                    i3 = i5;
                }
                if (i5 < i4) {
                    i4 = i5;
                }
            }
            if (i3 < i4 * 10) {
                return true;
            }
        }
        return false;
    }
}
