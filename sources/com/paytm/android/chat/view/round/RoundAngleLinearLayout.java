package com.paytm.android.chat.view.round;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Region;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.paytm.android.chat.R;

public class RoundAngleLinearLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    public Path f42626a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f42627b;

    /* renamed from: c  reason: collision with root package name */
    public RectF f42628c;

    /* renamed from: d  reason: collision with root package name */
    private float[] f42629d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f42630e;

    /* renamed from: f  reason: collision with root package name */
    private Region f42631f;

    public RoundAngleLinearLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundAngleLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleLinearLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f42629d = new float[8];
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundAngleLinearLayout);
        this.f42627b = obtainStyledAttributes.getBoolean(R.styleable.RoundAngleLinearLayout_clip_background, true);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundAngleLinearLayout_default_radius, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundAngleLinearLayout_top_left_radius, dimensionPixelSize);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundAngleLinearLayout_top_right_radius, dimensionPixelSize);
        int dimensionPixelSize4 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundAngleLinearLayout_bottom_left_radius, dimensionPixelSize);
        int dimensionPixelSize5 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.RoundAngleLinearLayout_bottom_right_radius, dimensionPixelSize);
        obtainStyledAttributes.recycle();
        float[] fArr = this.f42629d;
        float f2 = (float) dimensionPixelSize2;
        fArr[0] = f2;
        fArr[1] = f2;
        float f3 = (float) dimensionPixelSize3;
        fArr[2] = f3;
        fArr[3] = f3;
        float f4 = (float) dimensionPixelSize5;
        fArr[4] = f4;
        fArr[5] = f4;
        float f5 = (float) dimensionPixelSize4;
        fArr[6] = f5;
        fArr[7] = f5;
        this.f42628c = new RectF();
        this.f42626a = new Path();
        this.f42631f = new Region();
        this.f42630e = new Paint();
        this.f42630e.setColor(-1);
        this.f42630e.setAntiAlias(true);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.f42628c.set(0.0f, 0.0f, (float) i2, (float) i3);
        RectF rectF = new RectF();
        rectF.left = (float) getPaddingLeft();
        rectF.top = (float) getPaddingTop();
        rectF.right = this.f42628c.width() - ((float) getPaddingRight());
        rectF.bottom = this.f42628c.height() - ((float) getPaddingBottom());
        this.f42626a.reset();
        this.f42626a.addRoundRect(rectF, this.f42629d, Path.Direction.CW);
        this.f42631f.setPath(this.f42626a, new Region((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom));
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(this.f42628c, (Paint) null, 31);
        super.dispatchDraw(canvas);
        this.f42630e.setColor(-1);
        this.f42630e.setStyle(Paint.Style.FILL);
        if (Build.VERSION.SDK_INT <= 27) {
            this.f42630e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
            canvas.drawPath(this.f42626a, this.f42630e);
        } else {
            this.f42630e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
            Path path = new Path();
            path.addRect(0.0f, 0.0f, (float) ((int) this.f42628c.width()), (float) ((int) this.f42628c.height()), Path.Direction.CW);
            path.op(this.f42626a, Path.Op.DIFFERENCE);
            canvas.drawPath(path, this.f42630e);
        }
        canvas.restore();
    }

    public void draw(Canvas canvas) {
        if (this.f42627b) {
            if (Build.VERSION.SDK_INT <= 27) {
                canvas.save();
                canvas.clipPath(this.f42626a);
                super.draw(canvas);
            } else {
                canvas.saveLayer(this.f42628c, (Paint) null, 31);
                super.draw(canvas);
                Paint paint = new Paint();
                paint.setColor(-1);
                paint.setStyle(Paint.Style.FILL);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
                Path path = new Path();
                path.addRect(0.0f, 0.0f, (float) ((int) this.f42628c.width()), (float) ((int) this.f42628c.height()), Path.Direction.CW);
                path.op(this.f42626a, Path.Op.DIFFERENCE);
                canvas.drawPath(path, paint);
            }
            canvas.restore();
            return;
        }
        super.draw(canvas);
    }
}
