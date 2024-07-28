package com.flaviofaria.kenburnsview;

import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import java.util.Random;

public final class c implements e {

    /* renamed from: a  reason: collision with root package name */
    private final Random f31047a;

    /* renamed from: b  reason: collision with root package name */
    private long f31048b;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f31049c;

    /* renamed from: d  reason: collision with root package name */
    private d f31050d;

    /* renamed from: e  reason: collision with root package name */
    private RectF f31051e;

    public c() {
        this(new AccelerateDecelerateInterpolator());
    }

    private c(Interpolator interpolator) {
        this.f31047a = new Random(System.currentTimeMillis());
        this.f31048b = 10000;
        this.f31049c = interpolator;
    }

    public final d a(RectF rectF, RectF rectF2) {
        boolean z;
        boolean z2 = false;
        RectF rectF3 = null;
        if (!(this.f31050d == null)) {
            rectF3 = this.f31050d.f31053b;
            z2 = !rectF.equals(this.f31051e);
            z = !b.a(rectF3, rectF2);
        } else {
            z = false;
        }
        if (rectF3 == null || z2 || z) {
            rectF3 = b(rectF, rectF2);
        }
        this.f31050d = new d(rectF3, b(rectF, rectF2), this.f31048b, this.f31049c);
        this.f31051e = new RectF(rectF);
        return this.f31050d;
    }

    private RectF b(RectF rectF, RectF rectF2) {
        RectF rectF3;
        if (b.a(rectF) > b.a(rectF2)) {
            rectF3 = new RectF(0.0f, 0.0f, (rectF.height() / rectF2.height()) * rectF2.width(), rectF.height());
        } else {
            rectF3 = new RectF(0.0f, 0.0f, rectF.width(), (rectF.width() / rectF2.width()) * rectF2.height());
        }
        float a2 = (b.a(this.f31047a.nextFloat(), 2) * 0.25f) + 0.75f;
        float width = rectF3.width() * a2;
        float height = a2 * rectF3.height();
        int width2 = (int) (rectF.width() - width);
        int height2 = (int) (rectF.height() - height);
        int i2 = 0;
        int nextInt = width2 > 0 ? this.f31047a.nextInt(width2) : 0;
        if (height2 > 0) {
            i2 = this.f31047a.nextInt(height2);
        }
        float f2 = (float) nextInt;
        float f3 = (float) i2;
        return new RectF(f2, f3, width + f2, height + f3);
    }
}
