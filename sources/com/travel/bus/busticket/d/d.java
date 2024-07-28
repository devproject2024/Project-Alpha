package com.travel.bus.busticket.d;

import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.travel.bus.busticket.widgets.BusHorizontalProgress;
import com.travel.bus.busticket.widgets.BusRatingProgress;

public final class d extends Animation {

    /* renamed from: a  reason: collision with root package name */
    boolean f22119a = true;

    /* renamed from: b  reason: collision with root package name */
    private BusRatingProgress f22120b;

    /* renamed from: c  reason: collision with root package name */
    private BusHorizontalProgress f22121c;

    /* renamed from: d  reason: collision with root package name */
    private float f22122d;

    /* renamed from: e  reason: collision with root package name */
    private float f22123e;

    public d(BusRatingProgress busRatingProgress, float f2) {
        this.f22120b = busRatingProgress;
        this.f22122d = 0.0f;
        this.f22123e = f2;
        this.f22119a = true;
    }

    public d(BusHorizontalProgress busHorizontalProgress, float f2) {
        this.f22121c = busHorizontalProgress;
        this.f22122d = 0.0f;
        this.f22123e = f2;
        this.f22119a = false;
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f2, Transformation transformation) {
        super.applyTransformation(f2, transformation);
        float f3 = this.f22122d;
        float f4 = f3 + ((this.f22123e - f3) * f2);
        if (this.f22119a) {
            this.f22120b.setProgress(Float.valueOf(f4));
        } else {
            this.f22121c.setProgress((int) f4);
        }
    }
}
