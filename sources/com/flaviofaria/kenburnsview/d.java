package com.flaviofaria.kenburnsview;

import android.graphics.RectF;
import android.view.animation.Interpolator;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    RectF f31052a;

    /* renamed from: b  reason: collision with root package name */
    RectF f31053b;

    /* renamed from: c  reason: collision with root package name */
    final RectF f31054c = new RectF();

    /* renamed from: d  reason: collision with root package name */
    float f31055d;

    /* renamed from: e  reason: collision with root package name */
    float f31056e;

    /* renamed from: f  reason: collision with root package name */
    float f31057f;

    /* renamed from: g  reason: collision with root package name */
    float f31058g;

    /* renamed from: h  reason: collision with root package name */
    long f31059h;

    /* renamed from: i  reason: collision with root package name */
    Interpolator f31060i;

    public d(RectF rectF, RectF rectF2, long j, Interpolator interpolator) {
        if (b.a(rectF, rectF2)) {
            this.f31052a = rectF;
            this.f31053b = rectF2;
            this.f31059h = j;
            this.f31060i = interpolator;
            this.f31055d = rectF2.width() - rectF.width();
            this.f31056e = rectF2.height() - rectF.height();
            this.f31057f = rectF2.centerX() - rectF.centerX();
            this.f31058g = rectF2.centerY() - rectF.centerY();
            return;
        }
        throw new a();
    }
}
