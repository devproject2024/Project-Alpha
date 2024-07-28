package com.business.merchant_payments.widget.shimmer;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public final class ShimmerDrawable extends Drawable {
    public final Rect mDrawRect = new Rect();
    public final Matrix mShaderMatrix = new Matrix();
    public Shimmer mShimmer;
    public final Paint mShimmerPaint = new Paint();
    public final ValueAnimator.AnimatorUpdateListener mUpdateListener = new ValueAnimator.AnimatorUpdateListener() {
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ShimmerDrawable.this.invalidateSelf();
        }
    };
    public ValueAnimator mValueAnimator;

    private float offset(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    public final void setAlpha(int i2) {
    }

    public final void setColorFilter(ColorFilter colorFilter) {
    }

    public ShimmerDrawable() {
        this.mShimmerPaint.setAntiAlias(true);
    }

    public final void setShimmer(Shimmer shimmer) {
        this.mShimmer = shimmer;
        if (shimmer != null) {
            this.mShimmerPaint.setXfermode(new PorterDuffXfermode(this.mShimmer.alphaShimmer ? PorterDuff.Mode.DST_IN : PorterDuff.Mode.SRC_IN));
        }
        updateShader();
        updateValueAnimator();
        invalidateSelf();
    }

    public final void startShimmer() {
        if (this.mValueAnimator != null && !isShimmerStarted() && getCallback() != null) {
            this.mValueAnimator.start();
        }
    }

    public final void stopShimmer() {
        if (this.mValueAnimator != null && isShimmerStarted()) {
            this.mValueAnimator.cancel();
        }
    }

    public final boolean isShimmerStarted() {
        ValueAnimator valueAnimator = this.mValueAnimator;
        return valueAnimator != null && valueAnimator.isStarted();
    }

    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDrawRect.set(0, 0, rect.width(), rect.height());
        updateShader();
        maybeStartShimmer();
    }

    public final void draw(Canvas canvas) {
        float f2;
        float f3;
        if (this.mShimmer != null && this.mShimmerPaint.getShader() != null) {
            float tan = (float) Math.tan(Math.toRadians((double) this.mShimmer.tilt));
            float height = ((float) this.mDrawRect.height()) + (((float) this.mDrawRect.width()) * tan);
            float width = ((float) this.mDrawRect.width()) + (tan * ((float) this.mDrawRect.height()));
            ValueAnimator valueAnimator = this.mValueAnimator;
            float f4 = 0.0f;
            float animatedFraction = valueAnimator != null ? valueAnimator.getAnimatedFraction() : 0.0f;
            int i2 = this.mShimmer.direction;
            if (i2 != 1) {
                if (i2 == 2) {
                    f2 = offset(width, -width, animatedFraction);
                } else if (i2 != 3) {
                    f2 = offset(-width, width, animatedFraction);
                } else {
                    f3 = offset(height, -height, animatedFraction);
                }
                this.mShaderMatrix.reset();
                this.mShaderMatrix.setRotate(this.mShimmer.tilt, ((float) this.mDrawRect.width()) / 2.0f, ((float) this.mDrawRect.height()) / 2.0f);
                this.mShaderMatrix.postTranslate(f2, f4);
                this.mShimmerPaint.getShader().setLocalMatrix(this.mShaderMatrix);
                canvas.drawRect(this.mDrawRect, this.mShimmerPaint);
            }
            f3 = offset(-height, height, animatedFraction);
            f4 = f3;
            f2 = 0.0f;
            this.mShaderMatrix.reset();
            this.mShaderMatrix.setRotate(this.mShimmer.tilt, ((float) this.mDrawRect.width()) / 2.0f, ((float) this.mDrawRect.height()) / 2.0f);
            this.mShaderMatrix.postTranslate(f2, f4);
            this.mShimmerPaint.getShader().setLocalMatrix(this.mShaderMatrix);
            canvas.drawRect(this.mDrawRect, this.mShimmerPaint);
        }
    }

    public final int getOpacity() {
        Shimmer shimmer = this.mShimmer;
        if (shimmer != null) {
            return (shimmer.clipToChildren || shimmer.alphaShimmer) ? -3 : -1;
        }
        return -1;
    }

    private void updateValueAnimator() {
        boolean z;
        if (this.mShimmer != null) {
            ValueAnimator valueAnimator = this.mValueAnimator;
            if (valueAnimator != null) {
                z = valueAnimator.isStarted();
                this.mValueAnimator.cancel();
                this.mValueAnimator.removeAllUpdateListeners();
            } else {
                z = false;
            }
            Shimmer shimmer = this.mShimmer;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, ((float) (shimmer.repeatDelay / shimmer.animationDuration)) + 1.0f});
            this.mValueAnimator = ofFloat;
            ofFloat.setRepeatMode(this.mShimmer.repeatMode);
            this.mValueAnimator.setRepeatCount(this.mShimmer.repeatCount);
            ValueAnimator valueAnimator2 = this.mValueAnimator;
            Shimmer shimmer2 = this.mShimmer;
            valueAnimator2.setDuration(shimmer2.animationDuration + shimmer2.repeatDelay);
            this.mValueAnimator.addUpdateListener(this.mUpdateListener);
            if (z) {
                this.mValueAnimator.start();
            }
        }
    }

    public final void maybeStartShimmer() {
        Shimmer shimmer;
        ValueAnimator valueAnimator = this.mValueAnimator;
        if (valueAnimator != null && !valueAnimator.isStarted() && (shimmer = this.mShimmer) != null && shimmer.autoStart && getCallback() != null) {
            this.mValueAnimator.start();
        }
    }

    /* JADX WARNING: type inference failed for: r3v6, types: [android.graphics.LinearGradient] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void updateShader() {
        /*
            r19 = this;
            r0 = r19
            android.graphics.Rect r1 = r19.getBounds()
            int r2 = r1.width()
            int r1 = r1.height()
            if (r2 == 0) goto L_0x0075
            if (r1 == 0) goto L_0x0075
            com.business.merchant_payments.widget.shimmer.Shimmer r3 = r0.mShimmer
            if (r3 == 0) goto L_0x0075
            int r2 = r3.width(r2)
            com.business.merchant_payments.widget.shimmer.Shimmer r3 = r0.mShimmer
            int r1 = r3.height(r1)
            com.business.merchant_payments.widget.shimmer.Shimmer r3 = r0.mShimmer
            int r4 = r3.shape
            r5 = 1
            if (r4 == r5) goto L_0x0049
            int r3 = r3.direction
            r4 = 0
            if (r3 == r5) goto L_0x0030
            r6 = 3
            if (r3 == r6) goto L_0x0030
            r5 = 0
        L_0x0030:
            if (r5 == 0) goto L_0x0033
            r2 = 0
        L_0x0033:
            if (r5 != 0) goto L_0x0036
            r1 = 0
        L_0x0036:
            android.graphics.LinearGradient r11 = new android.graphics.LinearGradient
            float r6 = (float) r2
            float r7 = (float) r1
            com.business.merchant_payments.widget.shimmer.Shimmer r1 = r0.mShimmer
            int[] r8 = r1.colors
            float[] r9 = r1.positions
            android.graphics.Shader$TileMode r10 = android.graphics.Shader.TileMode.CLAMP
            r4 = 0
            r5 = 0
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            goto L_0x0070
        L_0x0049:
            android.graphics.RadialGradient r3 = new android.graphics.RadialGradient
            float r4 = (float) r2
            r5 = 1073741824(0x40000000, float:2.0)
            float r13 = r4 / r5
            float r4 = (float) r1
            float r14 = r4 / r5
            int r1 = java.lang.Math.max(r2, r1)
            double r1 = (double) r1
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r4 = java.lang.Math.sqrt(r4)
            double r1 = r1 / r4
            float r15 = (float) r1
            com.business.merchant_payments.widget.shimmer.Shimmer r1 = r0.mShimmer
            int[] r2 = r1.colors
            float[] r1 = r1.positions
            android.graphics.Shader$TileMode r18 = android.graphics.Shader.TileMode.CLAMP
            r12 = r3
            r16 = r2
            r17 = r1
            r12.<init>(r13, r14, r15, r16, r17, r18)
        L_0x0070:
            android.graphics.Paint r1 = r0.mShimmerPaint
            r1.setShader(r3)
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.business.merchant_payments.widget.shimmer.ShimmerDrawable.updateShader():void");
    }
}
