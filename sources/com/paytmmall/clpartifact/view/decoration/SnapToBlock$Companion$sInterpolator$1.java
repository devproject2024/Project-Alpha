package com.paytmmall.clpartifact.view.decoration;

import android.view.animation.Interpolator;

public final class SnapToBlock$Companion$sInterpolator$1 implements Interpolator {
    public final float getInterpolation(float f2) {
        float f3 = f2 - 1.0f;
        return (f3 * f3 * f3) + 1.0f;
    }

    SnapToBlock$Companion$sInterpolator$1() {
    }
}
