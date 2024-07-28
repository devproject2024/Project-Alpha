package com.google.zxing.e;

import com.google.zxing.a;
import com.google.zxing.b.b;
import com.google.zxing.g;
import com.google.zxing.h;
import com.google.zxing.w;
import java.util.Map;

public final class l extends z {
    public final b a(String str, a aVar, int i2, int i3, Map<g, ?> map) throws w {
        if (aVar == a.EAN_8) {
            return super.a(str, aVar, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode EAN_8, but got ".concat(String.valueOf(aVar)));
    }

    public final boolean[] a(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + y.b(str);
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
        boolean[] zArr = new boolean[67];
        int a2 = a(zArr, 0, y.f40402b, true) + 0;
        for (int i2 = 0; i2 <= 3; i2++) {
            a2 += a(zArr, a2, y.f40405e[Character.digit(str.charAt(i2), 10)], false);
        }
        int a3 = a2 + a(zArr, a2, y.f40403c, false);
        for (int i3 = 4; i3 <= 7; i3++) {
            a3 += a(zArr, a3, y.f40405e[Character.digit(str.charAt(i3), 10)], true);
        }
        a(zArr, a3, y.f40402b, true);
        return zArr;
    }
}
