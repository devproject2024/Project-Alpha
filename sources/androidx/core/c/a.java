package androidx.core.c;

public final class a {
    public static float a(float f2, float f3, float f4) {
        return f2 < f3 ? f3 : f2 > f4 ? f4 : f2;
    }

    public static int a(int i2, int i3, int i4) {
        return i2 < i3 ? i3 : i2 > i4 ? i4 : i2;
    }

    public static long a(long j, long j2) {
        if (j < 0) {
            return 0;
        }
        return j > j2 ? j2 : j;
    }
}
