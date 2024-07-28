package com.business.merchant_payments.widget;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.core.content.b;
import com.business.merchant_payments.R;
import com.business.merchant_payments.common.AnimationListener;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DotProgressBar extends View {
    public static final int LEFT_DIRECTION = -1;
    public static final int RIGHT_DIRECTION = 1;
    public float animatedRadius;
    public int animationDirection;
    public long animationTime;
    public float bounceDotRadius;
    public int dotAmount;
    public int dotPosition;
    public float dotRadius;
    public int endColor;
    public Paint endPaint;
    public ValueAnimator endValueAnimator;
    public boolean isFirstLaunch = true;
    public boolean isXCoordinateChange = false;
    public Paint primaryPaint;
    public int startColor;
    public Paint startPaint;
    public ValueAnimator startValueAnimator;
    public float xCoordinate;

    @Retention(RetentionPolicy.SOURCE)
    public @interface AnimationDirection {
    }

    public static /* synthetic */ int access$308(DotProgressBar dotProgressBar) {
        int i2 = dotProgressBar.dotPosition;
        dotProgressBar.dotPosition = i2 + 1;
        return i2;
    }

    public DotProgressBar(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        initializeAttributes(attributeSet);
        init();
    }

    public DotProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        initializeAttributes(attributeSet);
        init();
    }

    public DotProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initializeAttributes(attributeSet);
        init();
    }

    public DotProgressBar(Context context) {
        super(context);
        initializeAttributes((AttributeSet) null);
        init();
    }

    public static int darker(int i2, float f2) {
        return Color.argb(Color.alpha(i2), Math.max((int) (((float) Color.red(i2)) * f2), 0), Math.max((int) (((float) Color.green(i2)) * f2), 0), Math.max((int) (((float) Color.blue(i2)) * f2), 0));
    }

    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        if (this.dotRadius <= 0.0f) {
            if (getMeasuredHeight() > getMeasuredWidth()) {
                this.dotRadius = (float) ((getMeasuredWidth() / this.dotAmount) / 4);
            } else {
                this.dotRadius = (float) (getMeasuredHeight() / 4);
            }
        }
        float f2 = this.dotRadius;
        this.bounceDotRadius = (f2 / 3.0f) + f2;
        int i4 = this.dotAmount;
        float f3 = (((float) i4) * f2 * 2.0f) + (f2 * ((float) (i4 - 1)));
        if (!this.isXCoordinateChange) {
            this.xCoordinate = ((((float) getMeasuredWidth()) - f3) / 2.0f) + this.dotRadius;
        } else {
            this.xCoordinate = 10.0f;
        }
        setMeasuredDimension(View.resolveSizeAndState(((int) (f3 + ((float) getPaddingLeft()) + ((float) getPaddingRight()))) + ((int) this.bounceDotRadius), i2, 0), getMeasuredHeight());
    }

    public void setXCoordinateChange(boolean z) {
        this.isXCoordinateChange = z;
    }

    private void initializeAttributes(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(attributeSet, R.styleable.DotProgressBar, 0, 0);
            try {
                setDotAmount(obtainStyledAttributes.getInteger(R.styleable.DotProgressBar_amount, 3));
                setDotRadius(obtainStyledAttributes.getInteger(R.styleable.DotProgressBar_circleSize, 8));
                long integer = (long) obtainStyledAttributes.getInteger(R.styleable.DotProgressBar_duration, getResources().getInteger(17694721));
                this.animationTime = integer;
                setAnimationTime(integer);
                setStartColor(obtainStyledAttributes.getInteger(R.styleable.DotProgressBar_startColor, b.c(getContext(), R.color.light_blue_A700)));
                setEndColor(obtainStyledAttributes.getInteger(R.styleable.DotProgressBar_endColor, b.c(getContext(), R.color.light_blue_A400)));
                setAnimationDirection(obtainStyledAttributes.getInt(R.styleable.DotProgressBar_animationDirection, 1));
            } finally {
                obtainStyledAttributes.recycle();
            }
        } else {
            setDotAmount(5);
            setAnimationTime((long) getResources().getInteger(17694721));
            setStartColor(b.c(getContext(), R.color.light_blue_A700));
            setEndColor(b.c(getContext(), R.color.light_blue_A400));
            setAnimationDirection(1);
        }
    }

    private void init() {
        Paint paint = new Paint(5);
        this.primaryPaint = paint;
        paint.setColor(this.startColor);
        this.primaryPaint.setStrokeJoin(Paint.Join.ROUND);
        this.primaryPaint.setStrokeCap(Paint.Cap.ROUND);
        this.primaryPaint.setStrokeWidth(20.0f);
        this.startPaint = new Paint(this.primaryPaint);
        this.endPaint = new Paint(this.primaryPaint);
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.startColor, this.endColor});
        this.startValueAnimator = ofInt;
        ofInt.setDuration(this.animationTime);
        this.startValueAnimator.setEvaluator(new ArgbEvaluator());
        this.startValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DotProgressBar.this.startPaint.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        ValueAnimator ofInt2 = ValueAnimator.ofInt(new int[]{this.endColor, this.startColor});
        this.endValueAnimator = ofInt2;
        ofInt2.setDuration(this.animationTime);
        this.endValueAnimator.setEvaluator(new ArgbEvaluator());
        this.endValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DotProgressBar.this.endPaint.setColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
    }

    public void setDotAmount(int i2) {
        this.dotAmount = i2;
    }

    public void setDotRadius(int i2) {
        this.dotRadius = (float) i2;
    }

    public void setStartColor(int i2) {
        this.startColor = i2;
    }

    public void setEndColor(int i2) {
        this.endColor = i2;
    }

    public void setAnimationTime(long j) {
        this.animationTime = j;
    }

    private void setDotPosition(int i2) {
        this.dotPosition = i2;
    }

    public void setxCoordinate(float f2) {
        this.xCoordinate = f2;
    }

    public void changeDotAmount(int i2) {
        stopAnimation();
        setDotAmount(i2);
        setDotPosition(0);
        reinitialize();
    }

    public void changeStartColor(int i2) {
        stopAnimation();
        setStartColor(i2);
        reinitialize();
    }

    public void changeEndColor(int i2) {
        stopAnimation();
        setEndColor(i2);
        reinitialize();
    }

    public void changeAnimationTime(long j) {
        stopAnimation();
        setAnimationTime(j);
        reinitialize();
    }

    public void changeAnimationDirection(int i2) {
        setAnimationDirection(i2);
    }

    public int getAnimationDirection() {
        return this.animationDirection;
    }

    public void setAnimationDirection(int i2) {
        this.animationDirection = i2;
    }

    public void reinitialize() {
        init();
        requestLayout();
        startAnimation();
    }

    private void drawCirclesLeftToRight(Canvas canvas, float f2) {
        float f3 = 0.0f;
        for (int i2 = 0; i2 < this.dotAmount; i2++) {
            drawCircles(canvas, i2, f3, f2);
            f3 += this.dotRadius * 3.0f;
        }
    }

    private void drawCirclesRightToLeft(Canvas canvas, float f2) {
        float f3 = 0.0f;
        for (int i2 = this.dotAmount - 1; i2 >= 0; i2--) {
            drawCircles(canvas, i2, f3, f2);
            f3 += this.dotRadius * 3.0f;
        }
    }

    private void drawCircles(Canvas canvas, int i2, float f2, float f3) {
        int i3 = this.dotPosition;
        if (i3 == i2) {
            drawCircleUp(canvas, f2, f3);
        } else if ((i2 == this.dotAmount - 1 && i3 == 0 && !this.isFirstLaunch) || this.dotPosition - 1 == i2) {
            drawCircleDown(canvas, f2, f3);
        } else {
            drawCircle(canvas, f2);
        }
    }

    private void drawCircleUp(Canvas canvas, float f2, float f3) {
        canvas.drawCircle(this.xCoordinate + f2, (float) (getMeasuredHeight() / 2), this.dotRadius + f3, this.startPaint);
    }

    private void drawCircle(Canvas canvas, float f2) {
        canvas.drawCircle(this.xCoordinate + f2, (float) (getMeasuredHeight() / 2), this.dotRadius, this.primaryPaint);
    }

    private void drawCircleDown(Canvas canvas, float f2, float f3) {
        canvas.drawCircle(this.xCoordinate + f2, (float) (getMeasuredHeight() / 2), this.bounceDotRadius - f3, this.endPaint);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.animationDirection < 0) {
            drawCirclesRightToLeft(canvas, this.animatedRadius);
        } else {
            drawCirclesLeftToRight(canvas, this.animatedRadius);
        }
    }

    private void stopAnimation() {
        clearAnimation();
        postInvalidate();
    }

    private void startAnimation() {
        BounceAnimation bounceAnimation = new BounceAnimation();
        bounceAnimation.setDuration(this.animationTime);
        bounceAnimation.setRepeatCount(-1);
        bounceAnimation.setInterpolator(new LinearInterpolator());
        bounceAnimation.setAnimationListener(new AnimationListener() {
            public void onAnimationRepeat(Animation animation) {
                DotProgressBar.access$308(DotProgressBar.this);
                if (DotProgressBar.this.dotPosition == DotProgressBar.this.dotAmount) {
                    int unused = DotProgressBar.this.dotPosition = 0;
                }
                DotProgressBar.this.startValueAnimator.start();
                if (!DotProgressBar.this.isFirstLaunch) {
                    DotProgressBar.this.endValueAnimator.start();
                }
                boolean unused2 = DotProgressBar.this.isFirstLaunch = false;
            }
        });
        startAnimation(bounceAnimation);
    }

    public void setVisibility(int i2) {
        super.setVisibility(i2);
        if (i2 == 8 || i2 == 4) {
            stopAnimation();
        } else {
            startAnimation();
        }
    }

    public void onDetachedFromWindow() {
        stopAnimation();
        super.onDetachedFromWindow();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startAnimation();
    }

    public class BounceAnimation extends Animation {
        public BounceAnimation() {
        }

        public void applyTransformation(float f2, Transformation transformation) {
            super.applyTransformation(f2, transformation);
            DotProgressBar dotProgressBar = DotProgressBar.this;
            float unused = dotProgressBar.animatedRadius = (dotProgressBar.bounceDotRadius - DotProgressBar.this.dotRadius) * f2;
            DotProgressBar.this.invalidate();
        }
    }
}
