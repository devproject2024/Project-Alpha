package androidx.core.graphics;

import android.graphics.Color;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final ThreadLocal<double[]> f2971a = new ThreadLocal<>();

    private static float a(float f2, float f3) {
        if (f2 < 0.0f) {
            return 0.0f;
        }
        return f2 > f3 ? f3 : f2;
    }

    public static int a(int i2, int i3) {
        int alpha = Color.alpha(i3);
        int alpha2 = Color.alpha(i2);
        int i4 = 255 - (((255 - alpha) * (255 - alpha2)) / PriceRangeSeekBar.INVALID_POINTER_ID);
        return Color.argb(i4, a(Color.red(i2), alpha2, Color.red(i3), alpha, i4), a(Color.green(i2), alpha2, Color.green(i3), alpha, i4), a(Color.blue(i2), alpha2, Color.blue(i3), alpha, i4));
    }

    private static int a(int i2, int i3, int i4, int i5, int i6) {
        if (i6 == 0) {
            return 0;
        }
        return (((i2 * PriceRangeSeekBar.INVALID_POINTER_ID) * i3) + ((i4 * i5) * (255 - i3))) / (i6 * PriceRangeSeekBar.INVALID_POINTER_ID);
    }

    private static double c(int i2, int i3) {
        if (Color.alpha(i3) == 255) {
            if (Color.alpha(i2) < 255) {
                i2 = a(i2, i3);
            }
            double a2 = a(i2) + 0.05d;
            double a3 = a(i3) + 0.05d;
            return Math.max(a2, a3) / Math.min(a2, a3);
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i3));
    }

    public static int a(int i2, int i3, float f2) {
        int alpha = Color.alpha(i3);
        int i4 = PriceRangeSeekBar.INVALID_POINTER_ID;
        if (alpha == 255) {
            double d2 = (double) f2;
            if (c(b(i2, PriceRangeSeekBar.INVALID_POINTER_ID), i3) < d2) {
                return -1;
            }
            int i5 = 0;
            for (int i6 = 0; i6 <= 10 && i4 - i5 > 1; i6++) {
                int i7 = (i5 + i4) / 2;
                if (c(b(i2, i7), i3) < d2) {
                    i5 = i7;
                } else {
                    i4 = i7;
                }
            }
            return i4;
        }
        throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i3));
    }

    public static void a(int i2, int i3, int i4, float[] fArr) {
        float f2;
        float f3;
        float f4 = ((float) i2) / 255.0f;
        float f5 = ((float) i3) / 255.0f;
        float f6 = ((float) i4) / 255.0f;
        float max = Math.max(f4, Math.max(f5, f6));
        float min = Math.min(f4, Math.min(f5, f6));
        float f7 = max - min;
        float f8 = (max + min) / 2.0f;
        if (max == min) {
            f3 = 0.0f;
            f2 = 0.0f;
        } else {
            f3 = max == f4 ? ((f5 - f6) / f7) % 6.0f : max == f5 ? ((f6 - f4) / f7) + 2.0f : ((f4 - f5) / f7) + 4.0f;
            f2 = f7 / (1.0f - Math.abs((2.0f * f8) - 1.0f));
        }
        float f9 = (f3 * 60.0f) % 360.0f;
        if (f9 < 0.0f) {
            f9 += 360.0f;
        }
        fArr[0] = a(f9, 360.0f);
        fArr[1] = a(f2, 1.0f);
        fArr[2] = a(f8, 1.0f);
    }

    public static void a(int i2, float[] fArr) {
        a(Color.red(i2), Color.green(i2), Color.blue(i2), fArr);
    }

    public static int b(int i2, int i3) {
        if (i3 >= 0 && i3 <= 255) {
            return (i2 & 16777215) | (i3 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static double a(int i2) {
        double d2;
        double d3;
        double d4;
        double d5;
        double[] dArr = f2971a.get();
        if (dArr == null) {
            dArr = new double[3];
            f2971a.set(dArr);
        }
        int red = Color.red(i2);
        int green = Color.green(i2);
        int blue = Color.blue(i2);
        if (dArr.length == 3) {
            double d6 = ((double) red) / 255.0d;
            if (d6 < 0.04045d) {
                d2 = d6 / 12.92d;
            } else {
                d2 = Math.pow((d6 + 0.055d) / 1.055d, 2.4d);
            }
            double d7 = ((double) green) / 255.0d;
            if (d7 < 0.04045d) {
                d4 = d7 / 12.92d;
                d3 = 2.4d;
            } else {
                d3 = 2.4d;
                d4 = Math.pow((d7 + 0.055d) / 1.055d, 2.4d);
            }
            double d8 = ((double) blue) / 255.0d;
            if (d8 < 0.04045d) {
                d5 = d8 / 12.92d;
            } else {
                d5 = Math.pow((d8 + 0.055d) / 1.055d, d3);
            }
            dArr[0] = ((0.4124d * d2) + (0.3576d * d4) + (0.1805d * d5)) * 100.0d;
            dArr[1] = ((0.2126d * d2) + (0.7152d * d4) + (0.0722d * d5)) * 100.0d;
            dArr[2] = ((d2 * 0.0193d) + (d4 * 0.1192d) + (d5 * 0.9505d)) * 100.0d;
            return dArr[1] / 100.0d;
        }
        throw new IllegalArgumentException("outXyz must have a length of 3.");
    }
}
