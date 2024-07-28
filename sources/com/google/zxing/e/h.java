package com.google.zxing.e;

import com.google.zxing.a;
import com.google.zxing.b.b;
import com.google.zxing.g;
import com.google.zxing.w;
import java.util.Map;

public final class h extends s {
    public final b a(String str, a aVar, int i2, int i3, Map<g, ?> map) throws w {
        if (aVar == a.CODE_93) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_93, but got ".concat(String.valueOf(aVar)));
    }

    public final boolean[] a(String str) {
        int length = str.length();
        if (length <= 80) {
            int[] iArr = new int[9];
            a(g.f40372a[47], iArr);
            boolean[] zArr = new boolean[(((str.length() + 2 + 2) * 9) + 1)];
            int a2 = a(zArr, 0, iArr);
            for (int i2 = 0; i2 < length; i2++) {
                a(g.f40372a["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(i2))], iArr);
                a2 += a(zArr, a2, iArr);
            }
            int a3 = a(str, 20);
            a(g.f40372a[a3], iArr);
            int a4 = a2 + a(zArr, a2, iArr);
            a(g.f40372a[a(str + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(a3), 15)], iArr);
            int a5 = a4 + a(zArr, a4, iArr);
            a(g.f40372a[47], iArr);
            zArr[a5 + a(zArr, a5, iArr)] = true;
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }

    private static void a(int i2, int[] iArr) {
        for (int i3 = 0; i3 < 9; i3++) {
            int i4 = 1;
            if (((1 << (8 - i3)) & i2) == 0) {
                i4 = 0;
            }
            iArr[i3] = i4;
        }
    }

    private static int a(boolean[] zArr, int i2, int[] iArr) {
        int i3 = i2;
        int i4 = 0;
        while (i4 < 9) {
            int i5 = i3 + 1;
            zArr[i3] = iArr[i4] != 0;
            i4++;
            i3 = i5;
        }
        return 9;
    }

    private static int a(String str, int i2) {
        int i3 = 0;
        int i4 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            i3 += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i4;
            i4++;
            if (i4 > i2) {
                i4 = 1;
            }
        }
        return i3 % 47;
    }
}
