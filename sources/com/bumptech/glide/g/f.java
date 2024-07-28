package com.bumptech.glide.g;

import android.os.Build;
import android.os.SystemClock;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final double f6615a;

    static {
        double d2 = 1.0d;
        if (Build.VERSION.SDK_INT >= 17) {
            d2 = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f6615a = d2;
    }

    public static long a() {
        if (Build.VERSION.SDK_INT >= 17) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }

    public static double a(long j) {
        return ((double) (a() - j)) * f6615a;
    }
}
