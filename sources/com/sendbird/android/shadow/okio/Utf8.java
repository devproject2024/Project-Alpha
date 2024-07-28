package com.sendbird.android.shadow.okio;

public final class Utf8 {
    private Utf8() {
    }

    public static long size(String str) {
        return size(str, 0, str.length());
    }

    public static long size(String str, int i2, int i3) {
        long j;
        char c2;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        } else if (i2 < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i2)));
        } else if (i3 < i2) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i3 + " < " + i2);
        } else if (i3 <= str.length()) {
            long j2 = 0;
            while (i2 < i3) {
                char charAt = str.charAt(i2);
                if (charAt < 128) {
                    j2++;
                } else {
                    if (charAt < 2048) {
                        j = 2;
                    } else if (charAt < 55296 || charAt > 57343) {
                        j = 3;
                    } else {
                        int i4 = i2 + 1;
                        if (i4 < i3) {
                            c2 = str.charAt(i4);
                        } else {
                            c2 = 0;
                        }
                        if (charAt > 56319 || c2 < 56320 || c2 > 57343) {
                            j2++;
                            i2 = i4;
                        } else {
                            j2 += 4;
                            i2 += 2;
                        }
                    }
                    j2 += j;
                }
                i2++;
            }
            return j2;
        } else {
            throw new IllegalArgumentException("endIndex > string.length: " + i3 + " > " + str.length());
        }
    }
}
