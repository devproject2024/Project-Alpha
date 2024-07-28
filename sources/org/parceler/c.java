package org.parceler;

public final class c {
    public static int a(int i2) {
        if (i2 < 0) {
            throw new f("Expected size must be non-negative");
        } else if (i2 < 3) {
            return i2 + 1;
        } else {
            if (i2 < 1073741824) {
                return (int) ((((float) i2) / 0.75f) + 1.0f);
            }
            return Integer.MAX_VALUE;
        }
    }
}
