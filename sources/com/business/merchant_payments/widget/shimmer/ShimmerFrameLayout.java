package com.business.merchant_payments.widget.shimmer;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.business.merchant_payments.R;
import com.business.merchant_payments.widget.shimmer.Shimmer;

public class ShimmerFrameLayout extends FrameLayout {
    public final Paint mContentPaint = new Paint();
    public final ShimmerDrawable mShimmerDrawable = new ShimmerDrawable();

    public ShimmerFrameLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init(context, attributeSet);
    }

    public ShimmerFrameLayout(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        setWillNotDraw(false);
        this.mShimmerDrawable.setCallback(this);
        if (attributeSet == null) {
            setShimmer(new Shimmer.AlphaHighlightBuilder().build());
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ShimmerFrameLayout, 0, 0);
        try {
            setShimmer(((!obtainStyledAttributes.hasValue(R.styleable.ShimmerFrameLayout_shimmer_colored) || !obtainStyledAttributes.getBoolean(R.styleable.ShimmerFrameLayout_shimmer_colored, false)) ? new Shimmer.AlphaHighlightBuilder() : new Shimmer.ColorHighlightBuilder()).consumeAttributes(obtainStyledAttributes).build());
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public ShimmerFrameLayout setShimmer(Shimmer shimmer) {
        this.mShimmerDrawable.setShimmer(shimmer);
        if (shimmer == null || !shimmer.clipToChildren) {
            setLayerType(0, (Paint) null);
        } else {
            setLayerType(2, this.mContentPaint);
        }
        return this;
    }

    public void startShimmer() {
        this.mShimmerDrawable.startShimmer();
    }

    public void stopShimmer() {
        this.mShimmerDrawable.stopShimmer();
    }

    public boolean isShimmerStarted() {
        return this.mShimmerDrawable.isShimmerStarted();
    }

    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.mShimmerDrawable.setBounds(0, 0, getWidth(), getHeight());
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mShimmerDrawable.maybeStartShimmer();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopShimmer();
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.mShimmerDrawable.draw(canvas);
    }

    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.mShimmerDrawable;
    }
}
