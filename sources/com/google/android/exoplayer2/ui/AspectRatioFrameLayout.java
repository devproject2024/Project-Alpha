package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public final class AspectRatioFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final b f33522a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public a f33523b;

    /* renamed from: c  reason: collision with root package name */
    private float f33524c;

    /* renamed from: d  reason: collision with root package name */
    private int f33525d;

    public interface a {
    }

    public AspectRatioFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f33525d = 0;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.AspectRatioFrameLayout, 0, 0);
            try {
                this.f33525d = obtainStyledAttributes.getInt(R.styleable.AspectRatioFrameLayout_resize_mode, 0);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.f33522a = new b(this, (byte) 0);
    }

    public final void setAspectRatio(float f2) {
        if (this.f33524c != f2) {
            this.f33524c = f2;
            requestLayout();
        }
    }

    public final void setAspectRatioListener(a aVar) {
        this.f33523b = aVar;
    }

    public final int getResizeMode() {
        return this.f33525d;
    }

    public final void setResizeMode(int i2) {
        if (this.f33525d != i2) {
            this.f33525d = i2;
            requestLayout();
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i2, int i3) {
        float f2;
        float f3;
        super.onMeasure(i2, i3);
        if (this.f33524c > 0.0f) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            float f4 = (float) measuredWidth;
            float f5 = (float) measuredHeight;
            float f6 = f4 / f5;
            float f7 = (this.f33524c / f6) - 1.0f;
            if (Math.abs(f7) <= 0.01f) {
                this.f33522a.a(this.f33524c, f6, false);
                return;
            }
            int i4 = this.f33525d;
            if (i4 != 0) {
                if (i4 == 1) {
                    f3 = this.f33524c;
                } else if (i4 != 2) {
                    if (i4 == 4) {
                        if (f7 <= 0.0f) {
                            f3 = this.f33524c;
                        }
                        f2 = this.f33524c;
                    }
                    this.f33522a.a(this.f33524c, f6, true);
                    super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
                } else {
                    f2 = this.f33524c;
                }
                measuredHeight = (int) (f4 / f3);
                this.f33522a.a(this.f33524c, f6, true);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
            if (f7 > 0.0f) {
                f3 = this.f33524c;
                measuredHeight = (int) (f4 / f3);
                this.f33522a.a(this.f33524c, f6, true);
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
            }
            f2 = this.f33524c;
            measuredWidth = (int) (f5 * f2);
            this.f33522a.a(this.f33524c, f6, true);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824));
        }
    }

    final class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private float f33527b;

        /* renamed from: c  reason: collision with root package name */
        private float f33528c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f33529d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f33530e;

        private b() {
        }

        /* synthetic */ b(AspectRatioFrameLayout aspectRatioFrameLayout, byte b2) {
            this();
        }

        public final void a(float f2, float f3, boolean z) {
            this.f33527b = f2;
            this.f33528c = f3;
            this.f33529d = z;
            if (!this.f33530e) {
                this.f33530e = true;
                AspectRatioFrameLayout.this.post(this);
            }
        }

        public final void run() {
            this.f33530e = false;
            if (AspectRatioFrameLayout.this.f33523b != null) {
                a unused = AspectRatioFrameLayout.this.f33523b;
            }
        }
    }
}
