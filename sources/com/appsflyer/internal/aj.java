package com.appsflyer.internal;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public class aj {
    /* renamed from: ı  reason: contains not printable characters */
    public static void m152(int i2, int i3, boolean z, int i4, int[] iArr, int[][] iArr2, int[] iArr3) {
        int[] iArr4 = iArr;
        if (!z) {
            m153(iArr);
        }
        int i5 = i2;
        int i6 = i3;
        int i7 = 0;
        while (i7 < i4) {
            int i8 = i5 ^ iArr4[i7];
            int i9 = (i8 >>> 16) & PriceRangeSeekBar.INVALID_POINTER_ID;
            int i10 = (i8 >>> 8) & PriceRangeSeekBar.INVALID_POINTER_ID;
            int i11 = i8 & PriceRangeSeekBar.INVALID_POINTER_ID;
            int[] iArr5 = iArr2[0];
            i7++;
            int i12 = i6 ^ ((iArr2[2][i10] ^ (iArr5[i8 >>> 24] + iArr2[1][i9])) + iArr2[3][i11]);
            i6 = i8;
            i5 = i12;
        }
        int i13 = iArr4[iArr4.length - 2] ^ i5;
        int i14 = iArr4[iArr4.length - 1] ^ i6;
        if (!z) {
            m153(iArr);
        }
        iArr3[0] = i14;
        iArr3[1] = i13;
    }

    /* renamed from: ı  reason: contains not printable characters */
    private static void m153(int[] iArr) {
        for (int i2 = 0; i2 < iArr.length / 2; i2++) {
            int i3 = iArr[i2];
            iArr[i2] = iArr[(iArr.length - i2) - 1];
            iArr[(iArr.length - i2) - 1] = i3;
        }
    }
}
