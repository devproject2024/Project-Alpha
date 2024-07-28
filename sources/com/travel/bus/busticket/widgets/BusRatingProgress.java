package com.travel.bus.busticket.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.travel.bus.R;

public class BusRatingProgress extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f22500a;

    /* renamed from: b  reason: collision with root package name */
    private RectF f22501b;

    /* renamed from: c  reason: collision with root package name */
    private TextPaint f22502c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f22503d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f22504e = false;

    /* renamed from: f  reason: collision with root package name */
    private int f22505f;

    /* renamed from: g  reason: collision with root package name */
    private int f22506g;

    /* renamed from: h  reason: collision with root package name */
    private int f22507h;

    /* renamed from: i  reason: collision with root package name */
    private Float f22508i;
    private int j;
    private int k;
    private int l;
    private int m = 0;
    private int n = 0;

    public BusRatingProgress(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public BusRatingProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public BusRatingProgress(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    /* JADX INFO: finally extract failed */
    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BusRatingProgress, 0, 0);
            try {
                this.f22504e = obtainStyledAttributes.getBoolean(R.styleable.BusRatingProgress_showProgressText, true);
                this.f22506g = obtainStyledAttributes.getColor(R.styleable.BusRatingProgress_backgroundColor, 17170432);
                this.f22505f = obtainStyledAttributes.getColor(R.styleable.BusRatingProgress_progressColor, 17170432);
                this.f22508i = Float.valueOf(obtainStyledAttributes.getFloat(R.styleable.BusRatingProgress_progress, 0.0f));
                this.f22507h = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BusRatingProgress_strokeWidthProgress, 10);
                this.j = obtainStyledAttributes.getColor(R.styleable.BusRatingProgress_textColor, 17170444);
                obtainStyledAttributes.recycle();
                this.f22503d = new Paint();
                this.f22503d.setAntiAlias(true);
                this.f22503d.setStyle(Paint.Style.STROKE);
                this.f22503d.setStrokeWidth((float) this.f22507h);
                this.f22503d.setColor(this.f22506g);
                this.f22500a = new Paint();
                this.f22500a.setAntiAlias(true);
                this.f22500a.setStyle(Paint.Style.STROKE);
                this.f22500a.setStrokeWidth((float) this.f22507h);
                this.f22500a.setColor(this.f22505f);
                this.f22500a.setStrokeCap(Paint.Cap.ROUND);
                this.f22502c = new TextPaint();
                this.f22502c.setColor(this.j);
                this.f22501b = new RectF();
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
        this.f22501b.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i2 - getPaddingRight()), (float) (i3 - getPaddingBottom()));
        this.f22502c.setTextSize((float) (i2 / 5));
        TextPaint textPaint = this.f22502c;
        this.k = (i2 / 2) - ((int) (textPaint.measureText(this.f22508i + "%") / 2.0f));
        this.l = (int) (((float) (i3 / 2)) - ((this.f22502c.descent() + this.f22502c.ascent()) / 2.0f));
        this.m = i2;
        this.n = i3;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f22500a.setStyle(Paint.Style.STROKE);
        canvas.drawArc(this.f22501b, 0.0f, 360.0f, false, this.f22503d);
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f22501b, 270.0f, Float.valueOf((this.f22508i.floatValue() * 360.0f) / 5.0f).floatValue(), false, this.f22500a);
        if (this.f22504e) {
            canvas.drawText(this.f22508i + "%", (float) this.k, (float) this.l, this.f22502c);
        }
    }

    public void setDrawText(boolean z) {
        this.f22504e = z;
        invalidate();
    }

    public void setStrokeWidth(int i2) {
        this.f22507h = i2;
        invalidate();
    }

    public void setTextColor(int i2) {
        this.j = i2;
        invalidate();
    }

    public int getPrimaryProgressColor() {
        return this.f22505f;
    }

    public void setPrimaryProgressColor(int i2) {
        this.f22505f = i2;
        this.f22500a.setColor(i2);
        invalidate();
    }

    public Float getProgress() {
        return this.f22508i;
    }

    public void setProgress(Float f2) {
        this.f22508i = f2;
        invalidate();
    }

    public int getBackgroundColor() {
        return this.f22506g;
    }

    public void setBackgroundColor(int i2) {
        this.f22506g = i2;
        invalidate();
    }
}
