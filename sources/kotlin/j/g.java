package kotlin.j;

import kotlin.j.d;

public class g extends f {
    public static final double a(double d2) {
        if (d2 < 10.0d) {
            return 10.0d;
        }
        return d2;
    }

    public static final float a(float f2, float f3) {
        return f2 > f3 ? f3 : f2;
    }

    public static final long a(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static final int b(int i2, int i3) {
        return i2 < i3 ? i3 : i2;
    }

    public static final int c(int i2, int i3) {
        return i2 > i3 ? i3 : i2;
    }

    public static final d a(int i2, int i3) {
        if (i3 > Integer.MIN_VALUE) {
            return new d(i2, i3 - 1);
        }
        d.a aVar = d.f47946e;
        return d.f47947f;
    }

    public static final int a(int i2, int i3, int i4) {
        if (i3 > i4) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i4 + " is less than minimum " + i3 + '.');
        } else if (i2 < i3) {
            return i3;
        } else {
            return i2 > i4 ? i4 : i2;
        }
    }
}
