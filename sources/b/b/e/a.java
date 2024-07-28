package b.b.e;

public final class a {
    static long[] a(int i2, int i3) {
        long[] jArr = new long[4];
        jArr[0] = (((long) i3) & 4294967295L) | ((((long) i2) & 4294967295L) << 32);
        for (int i4 = 1; i4 < 4; i4++) {
            long j = jArr[i4 - 1];
            jArr[i4] = ((j ^ (j >> 30)) * 1812433253) + ((long) i4);
        }
        return jArr;
    }
}
