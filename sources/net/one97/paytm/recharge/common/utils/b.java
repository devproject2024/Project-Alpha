package net.one97.paytm.recharge.common.utils;

import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.a.a.a;
import androidx.interpolator.a.a.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final Interpolator f61535a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final Interpolator f61536b = new a();

    /* renamed from: c  reason: collision with root package name */
    public static final Interpolator f61537c = new c();

    /* renamed from: d  reason: collision with root package name */
    public static final Interpolator f61538d = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }
}
