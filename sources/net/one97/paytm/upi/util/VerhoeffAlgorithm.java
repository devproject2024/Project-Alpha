package net.one97.paytm.upi.util;

public class VerhoeffAlgorithm {

    /* renamed from: d  reason: collision with root package name */
    static int[][] f69546d = {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 2, 3, 4, 0, 6, 7, 8, 9, 5}, new int[]{2, 3, 4, 0, 1, 7, 8, 9, 5, 6}, new int[]{3, 4, 0, 1, 2, 8, 9, 5, 6, 7}, new int[]{4, 0, 1, 2, 3, 9, 5, 6, 7, 8}, new int[]{5, 9, 8, 7, 6, 0, 4, 3, 2, 1}, new int[]{6, 5, 9, 8, 7, 1, 0, 4, 3, 2}, new int[]{7, 6, 5, 9, 8, 2, 1, 0, 4, 3}, new int[]{8, 7, 6, 5, 9, 3, 2, 1, 0, 4}, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}};
    static int[] inv = {0, 4, 3, 2, 1, 5, 6, 7, 8, 9};
    static int[][] p = {new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, new int[]{1, 5, 7, 6, 2, 8, 3, 0, 9, 4}, new int[]{5, 8, 0, 3, 7, 9, 6, 1, 4, 2}, new int[]{8, 9, 1, 6, 0, 4, 3, 5, 2, 7}, new int[]{9, 4, 5, 3, 1, 2, 6, 8, 7, 0}, new int[]{4, 2, 8, 6, 5, 7, 3, 9, 0, 1}, new int[]{2, 7, 9, 3, 8, 0, 6, 4, 1, 5}, new int[]{7, 0, 4, 6, 9, 1, 3, 2, 5, 8}};

    public static boolean validateVerhoeff(String str) {
        int[] stringToReversedIntArray = stringToReversedIntArray(str);
        int i2 = 0;
        for (int i3 = 0; i3 < stringToReversedIntArray.length; i3++) {
            i2 = f69546d[i2][p[i3 % 8][stringToReversedIntArray[i3]]];
        }
        if (i2 == 0) {
            return true;
        }
        return false;
    }

    private static int[] stringToReversedIntArray(String str) {
        int[] iArr = new int[str.length()];
        int i2 = 0;
        while (i2 < str.length()) {
            int i3 = i2 + 1;
            iArr[i2] = Integer.parseInt(str.substring(i2, i3));
            i2 = i3;
        }
        return reverse(iArr);
    }

    private static int[] reverse(int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i2 = 0;
        while (i2 < iArr.length) {
            int i3 = i2 + 1;
            iArr2[i2] = iArr[iArr.length - i3];
            i2 = i3;
        }
        return iArr2;
    }
}
