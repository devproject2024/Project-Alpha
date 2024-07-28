package com.facebook.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.facebook.shimmer.a;

public class ShimmerFrameLayout extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Paint f7440a = new Paint();

    /* renamed from: b  reason: collision with root package name */
    private final b f7441b = new b();

    /* renamed from: c  reason: collision with root package name */
    private boolean f7442c = true;

    public ShimmerFrameLayout(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        this.f7441b.setCallback(this);
        if (attributeSet == null) {
            a(new a.C0106a().b());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
        try {
            a(((!obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_shimmer_colored) || !obtainStyledAttributes.getBoolean(R.styleable.ShimmerFrameLayout_shimmer_colored, false)) ? new a.C0106a() : new a.c()).a(obtainStyledAttributes).b());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private ShimmerFrameLayout a(a aVar) {
        this.f7441b.a(aVar);
        if (aVar == null || !aVar.o) {
            setLayerType(0, (Paint) null);
        } else {
            setLayerType(2, this.f7440a);
        }
        return this;
    }

    public final void a() {
        b bVar = this.f7441b;
        if (bVar.f7453a != null && !bVar.a() && bVar.getCallback() != null) {
            bVar.f7453a.start();
        }
    }

    public final void b() {
        b bVar = this.f7441b;
        if (bVar.f7453a != null && bVar.a()) {
            bVar.f7453a.cancel();
        }
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f7441b.setBounds(0, 0, getWidth(), getHeight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f7441b.b();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f7442c) {
            this.f7441b.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f7441b;
    }
}
