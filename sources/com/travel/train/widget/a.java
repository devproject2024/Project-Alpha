package com.travel.train.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class a extends Animation {

    /* renamed from: a  reason: collision with root package name */
    boolean f28362a = true;

    /* renamed from: b  reason: collision with root package name */
    private TrainRatingProgress f28363b;

    /* renamed from: c  reason: collision with root package name */
    private TrainHorizontalProgress f28364c;

    /* renamed from: d  reason: collision with root package name */
    private float f28365d;

    /* renamed from: e  reason: collision with root package name */
    private float f28366e;

    public a(TrainRatingProgress trainRatingProgress, float f2) {
        this.f28363b = trainRatingProgress;
        this.f28365d = 0.0f;
        this.f28366e = f2;
        this.f28362a = true;
    }

    public a(TrainHorizontalProgress trainHorizontalProgress, float f2) {
        this.f28364c = trainHorizontalProgress;
        this.f28365d = 0.0f;
        this.f28366e = f2;
        this.f28362a = false;
    }

    /* access modifiers changed from: protected */
    public final void applyTransformation(float f2, Transformation transformation) {
        super.applyTransformation(f2, transformation);
        float f3 = this.f28365d;
        float f4 = f3 + ((this.f28366e - f3) * f2);
        if (this.f28362a) {
            this.f28363b.setProgress(Float.valueOf(f4));
        } else {
            this.f28364c.setProgress((int) f4);
        }
    }
}
