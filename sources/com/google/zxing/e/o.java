package com.google.zxing.e;

import com.google.zxing.a;
import com.google.zxing.b.b;
import com.google.zxing.g;
import com.google.zxing.w;
import java.util.Map;

public final class o extends s {

    /* renamed from: a  reason: collision with root package name */
    private static final int[] f40387a = {1, 1, 1, 1};

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f40388b = {3, 1, 1};

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f40389c = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    public final b a(String str, a aVar, int i2, int i3, Map<g, ?> map) throws w {
        if (aVar == a.ITF) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(aVar)));
    }

    public final boolean[] a(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        } else if (length <= 80) {
            boolean[] zArr = new boolean[((length * 9) + 9)];
            int a2 = a(zArr, 0, f40387a, true);
            for (int i2 = 0; i2 < length; i2 += 2) {
                int digit = Character.digit(str.charAt(i2), 10);
                int digit2 = Character.digit(str.charAt(i2 + 1), 10);
                int[] iArr = new int[10];
                for (int i3 = 0; i3 < 5; i3++) {
                    int i4 = i3 * 2;
                    int[][] iArr2 = f40389c;
                    iArr[i4] = iArr2[digit][i3];
                    iArr[i4 + 1] = iArr2[digit2][i3];
                }
                a2 += a(zArr, a2, iArr, true);
            }
            a(zArr, a2, f40388b, true);
            return zArr;
        } else {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
    }
}
