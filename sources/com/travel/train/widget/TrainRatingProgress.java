package com.travel.train.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.travel.train.R;

public class TrainRatingProgress extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f28353a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f28354b;

    /* renamed from: c  reason: collision with root package name */
    private TextPaint f28355c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f28356d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f28357e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f28358f;

    /* renamed from: g  reason: collision with root package name */
    private int f28359g;

    /* renamed from: h  reason: collision with root package name */
    private int f28360h;

    /* renamed from: i  reason: collision with root package name */
    private Float f28361i;
    private int j;
    private int k;
    private int l;
    private int m = 0;
    private int n = 0;

    public TrainRatingProgress(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public TrainRatingProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public TrainRatingProgress(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    /* JADX INFO: finally extract failed */
    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BusRatingProgress, 0, 0);
            try {
                this.f28357e = obtainStyledAttributes.getBoolean(R.styleable.BusRatingProgress_showProgressText, true);
                this.f28359g = obtainStyledAttributes.getColor(R.styleable.BusRatingProgress_backgroundColor, 17170432);
                this.f28358f = obtainStyledAttributes.getColor(R.styleable.BusRatingProgress_progressColor, 17170432);
                this.f28361i = Float.valueOf(obtainStyledAttributes.getFloat(R.styleable.BusRatingProgress_progress, 0.0f));
                this.f28360h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BusRatingProgress_strokeWidthProgress, 10);
                this.j = obtainStyledAttributes.getColor(R.styleable.BusRatingProgress_textColor, 17170444);
                obtainStyledAttributes.recycle();
                this.f28356d = new Paint();
                this.f28356d.setAntiAlias(true);
                this.f28356d.setStyle(Paint.Style.STROKE);
                this.f28356d.setStrokeWidth((float) this.f28360h);
                this.f28356d.setColor(this.f28359g);
                this.f28353a = new Paint();
                this.f28353a.setAntiAlias(true);
                this.f28353a.setStyle(Paint.Style.STROKE);
                this.f28353a.setStrokeWidth((float) this.f28360h);
                this.f28353a.setColor(this.f28358f);
                this.f28353a.setStrokeCap(Paint.Cap.ROUND);
                this.f28355c = new TextPaint();
                this.f28355c.setColor(this.j);
                this.f28354b = new RectF();
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
        this.f28354b.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i2 - getPaddingRight()), (float) (i3 - getPaddingBottom()));
        this.f28355c.setTextSize((float) (i2 / 5));
        TextPaint textPaint = this.f28355c;
        this.k = (i2 / 2) - ((int) (textPaint.measureText(this.f28361i + "%") / 2.0f));
        this.l = (int) (((float) (i3 / 2)) - ((this.f28355c.descent() + this.f28355c.ascent()) / 2.0f));
        this.m = i2;
        this.n = i3;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f28353a.setStyle(Paint.Style.STROKE);
        canvas.drawArc(this.f28354b, 0.0f, 360.0f, false, this.f28356d);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f28354b, 270.0f, Float.valueOf((this.f28361i.floatValue() * 360.0f) / 5.0f).floatValue(), false, this.f28353a);
        if (this.f28357e) {
            canvas.drawText(this.f28361i + "%", (float) this.k, (float) this.l, this.f28355c);
        }
    }

    public void setStrokeWidth(int i2) {
        this.f28360h = i2;
        invalidate();
    }

    public void setTextColor(int i2) {
        this.j = i2;
        invalidate();
    }

    public int getPrimaryProgressColor() {
        return this.f28358f;
    }

    public void setPrimaryProgressColor(int i2) {
        this.f28358f = i2;
        this.f28353a.setColor(i2);
        invalidate();
    }

    public Float getProgress() {
        return this.f28361i;
    }

    public void setProgress(Float f2) {
        this.f28361i = f2;
        invalidate();
    }

    public int getBackgroundColor() {
        return this.f28359g;
    }

    public void setBackgroundColor(int i2) {
        this.f28359g = i2;
        invalidate();
    }
}
