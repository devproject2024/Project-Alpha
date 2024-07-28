package com.google.zxing.e;

import com.google.zxing.a;
import com.google.zxing.b.b;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.w;
import java.util.Map;

public final class ab extends z {
    public final b a(String str, a aVar, int i2, int i3, Map<g, ?> map) throws w {
        if (aVar == a.UPC_E) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode UPC_E, but got ".concat(String.valueOf(aVar)));
    }

    public final boolean[] a(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + y.b(aa.b(str));
            } catch (h e2) {
                throw new IllegalArgumentException(e2);
            }
        } else if (length == 8) {
            try {
                if (!y.a((CharSequence) str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (h unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 8 digits long, but got ".concat(String.valueOf(length)));
        }
        int digit = Character.digit(str.charAt(0), 10);
        if (digit == 0 || digit == 1) {
            int i2 = aa.f40359a[digit][Character.digit(str.charAt(7), 10)];
            boolean[] zArr = new boolean[51];
            int a2 = a(zArr, 0, y.f40402b, true) + 0;
            for (int i3 = 1; i3 <= 6; i3++) {
                int digit2 = Character.digit(str.charAt(i3), 10);
                if (((i2 >> (6 - i3)) & 1) == 1) {
                    digit2 += 10;
                }
                a2 += a(zArr, a2, y.f40406f[digit2], false);
            }
            a(zArr, a2, y.f40404d, false);
            return zArr;
        }
        throw new IllegalArgumentException("Number system must be 0 or 1");
    }
}
