package kotlin.h;

public class c extends b {
    public static final int a(double d2) {
        if (Double.isNaN(d2)) {
            throw new IllegalArgumentException("Cannot round NaN value.");
        } else if (d2 > 2.147483647E9d) {
            return Integer.MAX_VALUE;
        } else {
            if (d2 < -2.147483648E9d) {
                return Integer.MIN_VALUE;
            }
            return (int) Math.round(d2);
        }
    }

    public static final int a(float f2) {
        if (!Float.isNaN(f2)) {
            return Math.round(f2);
        }
        throw new IllegalArgumentException("Cannot round NaN value.");
    }
}
