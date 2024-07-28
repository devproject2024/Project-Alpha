package com.google.zxing.e;

import com.google.zxing.a;
import com.google.zxing.b.b;
import com.google.zxing.g;
import com.google.zxing.v;
import com.google.zxing.w;
import java.util.Map;

public abstract class s implements v {
    public int a() {
        return 10;
    }

    public abstract boolean[] a(String str);

    public b a(String str, a aVar, int i2, int i3, Map<g, ?> map) throws w {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i2 < 0 || i3 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i2 + 'x' + i3);
        } else {
            int a2 = a();
            if (map != null && map.containsKey(g.MARGIN)) {
                a2 = Integer.parseInt(map.get(g.MARGIN).toString());
            }
            return a(a(str), i2, i3, a2);
        }
    }

    private static b a(boolean[] zArr, int i2, int i3, int i4) {
        int length = zArr.length;
        int i5 = i4 + length;
        int max = Math.max(i2, i5);
        int max2 = Math.max(1, i3);
        int i6 = max / i5;
        b bVar = new b(max, max2);
        int i7 = (max - (length * i6)) / 2;
        int i8 = 0;
        while (i8 < length) {
            if (zArr[i8]) {
                bVar.a(i7, 0, i6, max2);
            }
            i8++;
            i7 += i6;
        }
        return bVar;
    }

    protected static int a(boolean[] zArr, int i2, int[] iArr, boolean z) {
        int length = iArr.length;
        int i3 = i2;
        boolean z2 = z;
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            int i6 = iArr[i4];
            int i7 = i3;
            int i8 = 0;
            while (i8 < i6) {
                zArr[i7] = z2;
                i8++;
                i7++;
            }
            i5 += i6;
            z2 = !z2;
            i4++;
            i3 = i7;
        }
        return i5;
    }
}
