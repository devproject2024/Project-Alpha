package com.google.zxing.e;

import com.google.zxing.a;
import com.google.zxing.b.b;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.w;
import java.util.Map;

public final class j extends z {
    public final b a(String str, a aVar, int i2, int i3, Map<g, ?> map) throws w {
        if (aVar == a.EAN_13) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_13, but got ".concat(String.valueOf(aVar)));
    }

    public final boolean[] a(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + y.b(str);
            } catch (h e2) {
                throw new IllegalArgumentException(e2);
            }
        } else if (length == 13) {
            try {
                if (!y.a((CharSequence) str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (h unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        } else {
            throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
        }
        int i2 = i.f40377a[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int a2 = a(zArr, 0, y.f40402b, true) + 0;
        for (int i3 = 1; i3 <= 6; i3++) {
            int digit = Character.digit(str.charAt(i3), 10);
            if (((i2 >> (6 - i3)) & 1) == 1) {
                digit += 10;
            }
            a2 += a(zArr, a2, y.f40406f[digit], false);
        }
        int a3 = a2 + a(zArr, a2, y.f40403c, false);
        for (int i4 = 7; i4 <= 12; i4++) {
            a3 += a(zArr, a3, y.f40405e[Character.digit(str.charAt(i4), 10)], true);
        }
        a(zArr, a3, y.f40402b, true);
        return zArr;
    }
}
