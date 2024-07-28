package com.travel.train.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.travel.train.R;

public class TrainHorizontalProgress extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f28346a;

    /* renamed from: b  reason: collision with root package name */
    private int f28347b;

    /* renamed from: c  reason: collision with root package name */
    private int f28348c;

    /* renamed from: d  reason: collision with root package name */
    private int f28349d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f28350e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f28351f;

    /* renamed from: g  reason: collision with root package name */
    private RectF f28352g;

    public TrainHorizontalProgress(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public TrainHorizontalProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public TrainHorizontalProgress(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    /* JADX INFO: finally extract failed */
    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BusHorizontalProgress, 0, 0);
            try {
                this.f28346a = obtainStyledAttributes.getColor(R.styleable.BusHorizontalProgress_backgroundColorHorizontal, 17170432);
                this.f28347b = obtainStyledAttributes.getColor(R.styleable.BusHorizontalProgress_progressColorHorizontal, 17170432);
                this.f28348c = obtainStyledAttributes.getInt(R.styleable.BusHorizontalProgress_progressHorizontal, 0);
                this.f28349d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BusHorizontalProgress_strokeWidthHorizontal, 8);
                obtainStyledAttributes.recycle();
                this.f28350e = new Paint();
                this.f28350e.setAntiAlias(true);
                this.f28350e.setStyle(Paint.Style.FILL);
                this.f28350e.setStrokeWidth((float) this.f28349d);
                this.f28350e.setColor(this.f28346a);
                this.f28350e.setStrokeCap(Paint.Cap.ROUND);
                this.f28351f = new Paint();
                this.f28351f.setAntiAlias(true);
                this.f28351f.setStyle(Paint.Style.FILL);
                this.f28351f.setStrokeWidth((float) this.f28349d);
                this.f28351f.setColor(this.f28347b);
                this.f28351f.setStrokeCap(Paint.Cap.ROUND);
                this.f28352g = new RectF();
            } catch (Throwable th) {
                obtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            throw new IllegalArgumentException("Must have to pass the attributes");
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f28352g.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i2 - getPaddingRight()), (float) (i3 - getPaddingBottom()));
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(this.f28352g, (float) (getHeight() / 2), (float) (getHeight() / 2), this.f28350e);
        RectF rectF = new RectF();
        rectF.set((float) getPaddingLeft(), (float) getPaddingTop(), ((float) ((getWidth() - getPaddingRight()) * this.f28348c)) / 100.0f, (float) (getHeight() - getPaddingBottom()));
        canvas.drawRoundRect(rectF, (float) (getHeight() / 2), (float) (getHeight() / 2), this.f28351f);
    }

    public int getmBackgroundColor() {
        return this.f28346a;
    }

    public void setmBackgroundColor(int i2) {
        this.f28346a = i2;
        this.f28350e.setColor(i2);
        invalidate();
    }

    public int getmPrimaryProgressColor() {
        return this.f28347b;
    }

    public void setmPrimaryProgressColor(int i2) {
        this.f28347b = i2;
        this.f28351f.setColor(i2);
        invalidate();
    }

    public int getmProgress() {
        return this.f28348c;
    }

    public void setProgress(int i2) {
        this.f28348c = i2;
        invalidate();
    }

    public int getmStrokeWidth() {
        return this.f28349d;
    }
}
