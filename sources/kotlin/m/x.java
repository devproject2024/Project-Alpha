package kotlin.m;

import kotlin.g.b.k;

public class x extends w {
    public static final Integer c(String str) {
        boolean z;
        int i2;
        k.d(str, "$this$toIntOrNull");
        k.d(str, "$this$toIntOrNull");
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i3 = 0;
        char charAt = str.charAt(0);
        int i4 = -2147483647;
        int i5 = 1;
        if (k.a((int) charAt, 48) >= 0) {
            z = false;
            i5 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                i4 = Integer.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z = false;
            }
        }
        int i6 = -59652323;
        while (i5 < length) {
            int digit = Character.digit(str.charAt(i5), 10);
            if (digit < 0) {
                return null;
            }
            if ((i3 < i6 && (i6 != -59652323 || i3 < (i6 = i4 / 10))) || (i2 = i3 * 10) < i4 + digit) {
                return null;
            }
            i3 = i2 - digit;
            i5++;
        }
        if (!z) {
            i3 = -i3;
        }
        return Integer.valueOf(i3);
    }

    public static final Long d(String str) {
        k.d(str, "$this$toLongOrNull");
        return p.e(str);
    }

    public static final Long e(String str) {
        String str2 = str;
        k.d(str2, "$this$toLongOrNull");
        int length = str.length();
        if (length == 0) {
            return null;
        }
        boolean z = false;
        char charAt = str2.charAt(0);
        long j = -9223372036854775807L;
        int i2 = 1;
        if (k.a((int) charAt, 48) >= 0) {
            i2 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                j = Long.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            }
        }
        long j2 = 0;
        long j3 = -256204778801521550L;
        while (i2 < length) {
            int digit = Character.digit(str2.charAt(i2), 10);
            if (digit < 0) {
                return null;
            }
            if (j2 < j3) {
                if (j3 == -256204778801521550L) {
                    j3 = j / 10;
                    if (j2 < j3) {
                    }
                }
                return null;
            }
            long j4 = j2 * 10;
            long j5 = (long) digit;
            if (j4 < j + j5) {
                return null;
            }
            j2 = j4 - j5;
            i2++;
        }
        if (!z) {
            j2 = -j2;
        }
        return Long.valueOf(j2);
    }
}
