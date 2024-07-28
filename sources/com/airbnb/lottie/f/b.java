package com.airbnb.lottie.f;

import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public final class b {
    private static float a(float f2) {
        return f2 <= 0.0031308f ? f2 * 12.92f : (float) ((Math.pow((double) f2, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float b(float f2) {
        return f2 <= 0.04045f ? f2 / 12.92f : (float) Math.pow((double) ((f2 + 0.055f) / 1.055f), 2.4000000953674316d);
    }

    public static int a(float f2, int i2, int i3) {
        if (i2 == i3) {
            return i2;
        }
        float f3 = ((float) ((i2 >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID)) / 255.0f;
        float b2 = b(((float) ((i2 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID)) / 255.0f);
        float b3 = b(((float) ((i2 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID)) / 255.0f);
        float b4 = b(((float) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID)) / 255.0f);
        float b5 = b(((float) ((i3 >> 16) & PriceRangeSeekBar.INVALID_POINTER_ID)) / 255.0f);
        float b6 = b(((float) ((i3 >> 8) & PriceRangeSeekBar.INVALID_POINTER_ID)) / 255.0f);
        float b7 = b4 + (f2 * (b(((float) (i3 & PriceRangeSeekBar.INVALID_POINTER_ID)) / 255.0f) - b4));
        return (Math.round(a(b2 + ((b5 - b2) * f2)) * 255.0f) << 16) | (Math.round((f3 + (((((float) ((i3 >> 24) & PriceRangeSeekBar.INVALID_POINTER_ID)) / 255.0f) - f3) * f2)) * 255.0f) << 24) | (Math.round(a(b3 + ((b6 - b3) * f2)) * 255.0f) << 8) | Math.round(a(b7) * 255.0f);
    }
}
