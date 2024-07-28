package com.google.zxing.g.a;

final class g {

    /* renamed from: c  reason: collision with root package name */
    private static final int[][] f40509c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* renamed from: a  reason: collision with root package name */
    final f f40510a;

    /* renamed from: b  reason: collision with root package name */
    final byte f40511b;

    private g(int i2) {
        this.f40510a = f.forBits((i2 >> 3) & 3);
        this.f40511b = (byte) (i2 & 7);
    }

    static int a(int i2, int i3) {
        return Integer.bitCount(i2 ^ i3);
    }

    static g b(int i2, int i3) {
        g c2 = c(i2, i3);
        if (c2 != null) {
            return c2;
        }
        return c(i2 ^ 21522, i3 ^ 21522);
    }

    private static g c(int i2, int i3) {
        int bitCount;
        int i4 = Integer.MAX_VALUE;
        int i5 = 0;
        for (int[] iArr : f40509c) {
            int i6 = iArr[0];
            if (i6 == i2 || i6 == i3) {
                return new g(iArr[1]);
            }
            int bitCount2 = Integer.bitCount(i2 ^ i6);
            if (bitCount2 < i4) {
                i5 = iArr[1];
                i4 = bitCount2;
            }
            if (i2 != i3 && (bitCount = Integer.bitCount(i6 ^ i3)) < i4) {
                i5 = iArr[1];
                i4 = bitCount;
            }
        }
        if (i4 <= 3) {
            return new g(i5);
        }
        return null;
    }

    public final int hashCode() {
        return (this.f40510a.ordinal() << 3) | this.f40511b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (this.f40510a == gVar.f40510a && this.f40511b == gVar.f40511b) {
            return true;
        }
        return false;
    }
}
