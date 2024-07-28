package com.squareup.b;

import java.io.IOException;

public enum q {
    VARINT(0),
    FIXED64(1),
    LENGTH_DELIMITED(2),
    START_GROUP(3),
    END_GROUP(4),
    FIXED32(5);
    
    public static final int FIXED_32_SIZE = 4;
    public static final int FIXED_64_SIZE = 8;
    public static final int TAG_TYPE_BITS = 3;
    private static final int TAG_TYPE_MASK = 7;
    private final int value;

    public static q valueOf(int i2) throws IOException {
        int i3 = i2 & 7;
        if (i3 == 0) {
            return VARINT;
        }
        if (i3 == 1) {
            return FIXED64;
        }
        if (i3 == 2) {
            return LENGTH_DELIMITED;
        }
        if (i3 == 3) {
            return START_GROUP;
        }
        if (i3 == 4) {
            return END_GROUP;
        }
        if (i3 == 5) {
            return FIXED32;
        }
        throw new IOException("No WireType for type " + i3);
    }

    private q(int i2) {
        this.value = i2;
    }

    public final int value() {
        return this.value;
    }
}
