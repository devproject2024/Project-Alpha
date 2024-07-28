package com.google.zxing.g.a;

public enum h {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);
    
    private final int bits;
    private final int[] characterCountBitsForVersions;

    private h(int[] iArr, int i2) {
        this.characterCountBitsForVersions = iArr;
        this.bits = i2;
    }

    public static h forBits(int i2) {
        if (i2 == 0) {
            return TERMINATOR;
        }
        if (i2 == 1) {
            return NUMERIC;
        }
        if (i2 == 2) {
            return ALPHANUMERIC;
        }
        if (i2 == 3) {
            return STRUCTURED_APPEND;
        }
        if (i2 == 4) {
            return BYTE;
        }
        if (i2 == 5) {
            return FNC1_FIRST_POSITION;
        }
        if (i2 == 7) {
            return ECI;
        }
        if (i2 == 8) {
            return KANJI;
        }
        if (i2 == 9) {
            return FNC1_SECOND_POSITION;
        }
        if (i2 == 13) {
            return HANZI;
        }
        throw new IllegalArgumentException();
    }

    public final int getBits() {
        return this.bits;
    }

    public final int getCharacterCountBits(j jVar) {
        int i2 = jVar.f40515a;
        return this.characterCountBitsForVersions[i2 <= 9 ? 0 : i2 <= 26 ? (char) 1 : 2];
    }
}
