package com.travel.bus.busticket.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.travel.bus.R;

public class BusHorizontalProgress extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f22493a;

    /* renamed from: b  reason: collision with root package name */
    private int f22494b;

    /* renamed from: c  reason: collision with root package name */
    private int f22495c;

    /* renamed from: d  reason: collision with root package name */
    private int f22496d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f22497e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f22498f;

    /* renamed from: g  reason: collision with root package name */
    private RectF f22499g;

    public BusHorizontalProgress(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public BusHorizontalProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public BusHorizontalProgress(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context, attributeSet);
    }

    /* JADX INFO: finally extract failed */
    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BusHorizontalProgress, 0, 0);
            try {
                this.f22493a = obtainStyledAttributes.getColor(R.styleable.BusHorizontalProgress_backgroundColorHorizontal, 17170432);
                this.f22494b = obtainStyledAttributes.getColor(R.styleable.BusHorizontalProgress_progressColorHorizontal, 17170432);
                this.f22495c = obtainStyledAttributes.getInt(R.styleable.BusHorizontalProgress_progressHorizontal, 0);
                this.f22496d = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BusHorizontalProgress_strokeWidthHorizontal, 8);
                obtainStyledAttributes.recycle();
                this.f22497e = new Paint();
                this.f22497e.setAntiAlias(true);
                this.f22497e.setStyle(Paint.Style.FILL);
                this.f22497e.setStrokeWidth((float) this.f22496d);
                this.f22497e.setColor(this.f22493a);
                this.f22497e.setStrokeCap(Paint.Cap.ROUND);
                this.f22498f = new Paint();
                this.f22498f.setAntiAlias(true);
                this.f22498f.setStyle(Paint.Style.FILL);
                this.f22498f.setStrokeWidth((float) this.f22496d);
                this.f22498f.setColor(this.f22494b);
                this.f22498f.setStrokeCap(Paint.Cap.ROUND);
                this.f22499g = new RectF();
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
        this.f22499g.set((float) getPaddingLeft(), (float) getPaddingTop(), (float) (i2 - getPaddingRight()), (float) (i3 - getPaddingBottom()));
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRoundRect(this.f22499g, (float) (getHeight() / 2), (float) (getHeight() / 2), this.f22497e);
        RectF rectF = new RectF();
        rectF.set((float) getPaddingLeft(), (float) getPaddingTop(), ((float) ((getWidth() - getPaddingRight()) * this.f22495c)) / 100.0f, (float) (getHeight() - getPaddingBottom()));
        canvas.drawRoundRect(rectF, (float) (getHeight() / 2), (float) (getHeight() / 2), this.f22498f);
    }

    public int getmBackgroundColor() {
        return this.f22493a;
    }

    public void setmBackgroundColor(int i2) {
        this.f22493a = i2;
        this.f22497e.setColor(i2);
        invalidate();
    }

    public int getmPrimaryProgressColor() {
        return this.f22494b;
    }

    public void setmPrimaryProgressColor(int i2) {
        this.f22494b = i2;
        this.f22498f.setColor(i2);
        invalidate();
    }

    public int getmProgress() {
        return this.f22495c;
    }

    public void setProgress(int i2) {
        this.f22495c = i2;
        invalidate();
    }

    public int getmStrokeWidth() {
        return this.f22496d;
    }

    public void setmStrokeWidth(int i2) {
        this.f22496d = i2;
        float f2 = (float) i2;
        this.f22497e.setStrokeWidth(f2);
        this.f22498f.setStrokeWidth(f2);
        invalidate();
    }
}
