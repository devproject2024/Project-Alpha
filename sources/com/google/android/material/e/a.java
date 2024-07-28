package com.google.android.material.e;

import android.content.Context;
import android.graphics.Color;
import com.google.android.material.R;
import com.google.android.material.h.b;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f36266a;

    /* renamed from: b  reason: collision with root package name */
    private final int f36267b;

    /* renamed from: c  reason: collision with root package name */
    private final int f36268c;

    /* renamed from: d  reason: collision with root package name */
    private final float f36269d;

    public a(Context context) {
        this.f36266a = b.a(context, R.attr.elevationOverlayEnabled, false);
        this.f36267b = com.google.android.material.b.a.a(context, R.attr.elevationOverlayColor);
        this.f36268c = com.google.android.material.b.a.a(context, R.attr.colorSurface);
        this.f36269d = context.getResources().getDisplayMetrics().density;
    }

    public final int a(int i2, float f2) {
        if (!this.f36266a) {
            return i2;
        }
        if (!(androidx.core.graphics.a.b(i2, PriceRangeSeekBar.INVALID_POINTER_ID) == this.f36268c)) {
            return i2;
        }
        float f3 = this.f36269d;
        float f4 = 0.0f;
        if (f3 > 0.0f && f2 > 0.0f) {
            f4 = Math.min(((((float) Math.log1p((double) (f2 / f3))) * 4.5f) + 2.0f) / 100.0f, 1.0f);
        }
        return androidx.core.graphics.a.b(com.google.android.material.b.a.a(androidx.core.graphics.a.b(i2, PriceRangeSeekBar.INVALID_POINTER_ID), this.f36267b, f4), Color.alpha(i2));
    }
}
