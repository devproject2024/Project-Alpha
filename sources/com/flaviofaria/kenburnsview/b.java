package com.flaviofaria.kenburnsview;

import android.graphics.RectF;

public final class b {
    protected static float a(float f2, int i2) {
        float pow = (float) Math.pow(10.0d, (double) i2);
        return ((float) Math.round(f2 * pow)) / pow;
    }

    protected static boolean a(RectF rectF, RectF rectF2) {
        return Math.abs(a(a(rectF), 3) - a(a(rectF2), 3)) <= 0.01f;
    }

    protected static float a(RectF rectF) {
        return rectF.width() / rectF.height();
    }
}
