package com.paytm.utility;

public final class y {

    /* renamed from: a  reason: collision with root package name */
    static int[][] f43875a = {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 2, 3, 4, 0, 6, 7, 8, 9, 5}, new int[]{2, 3, 4, 0, 1, 7, 8, 9, 5, 6}, new int[]{3, 4, 0, 1, 2, 8, 9, 5, 6, 7}, new int[]{4, 0, 1, 2, 3, 9, 5, 6, 7, 8}, new int[]{5, 9, 8, 7, 6, 0, 4, 3, 2, 1}, new int[]{6, 5, 9, 8, 7, 1, 0, 4, 3, 2}, new int[]{7, 6, 5, 9, 8, 2, 1, 0, 4, 3}, new int[]{8, 7, 6, 5, 9, 3, 2, 1, 0, 4}, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}};

    /* renamed from: b  reason: collision with root package name */
    static int[][] f43876b = {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 5, 7, 6, 2, 8, 3, 0, 9, 4}, new int[]{5, 8, 0, 3, 7, 9, 6, 1, 4, 2}, new int[]{8, 9, 1, 6, 0, 4, 3, 5, 2, 7}, new int[]{9, 4, 5, 3, 1, 2, 6, 8, 7, 0}, new int[]{4, 2, 8, 6, 5, 7, 3, 9, 0, 1}, new int[]{2, 7, 9, 3, 8, 0, 6, 4, 1, 5}, new int[]{7, 0, 4, 6, 9, 1, 3, 2, 5, 8}};

    /* renamed from: c  reason: collision with root package name */
    static int[] f43877c = {0, 4, 3, 2, 1, 5, 6, 7, 8, 9};

    public static boolean a(String str) {
        int[] iArr = new int[str.length()];
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + 1;
            iArr[i2] = Integer.parseInt(str.substring(i2, i3));
            i2 = i3;
        }
        int[] iArr2 = new int[iArr.length];
        int i4 = 0;
        while (i4 < iArr.length) {
            int i5 = i4 + 1;
            iArr2[i4] = iArr[iArr.length - i5];
            i4 = i5;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < iArr2.length; i7++) {
            i6 = f43875a[i6][f43876b[i7 % 8][iArr2[i7]]];
        }
        if (i6 == 0) {
            return true;
        }
        return false;
    }
}
