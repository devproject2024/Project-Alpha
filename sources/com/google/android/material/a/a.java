package com.google.android.material.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.a.a.b;
import androidx.interpolator.a.a.c;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f35800a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f35801b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f35802c = new androidx.interpolator.a.a.a();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f35803d = new c();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f35804e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static int a(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * ((float) (i3 - i2)));
    }
}
