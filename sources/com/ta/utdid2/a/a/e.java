package com.ta.utdid2.a.a;

public final class e {
    public static boolean a(String str) {
        return str == null || str.length() <= 0;
    }

    public static int b(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i2 = 0;
        for (char c2 : str.toCharArray()) {
            i2 = (i2 * 31) + c2;
        }
        return i2;
    }
}
