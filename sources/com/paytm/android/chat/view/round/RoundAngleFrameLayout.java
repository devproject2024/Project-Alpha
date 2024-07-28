package com.paytm.android.chat.view.round;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.paytm.android.chat.R;

public class RoundAngleFrameLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private float f42620a;

    /* renamed from: b  reason: collision with root package name */
    private float f42621b;

    /* renamed from: c  reason: collision with root package name */
    private float f42622c;

    /* renamed from: d  reason: collision with root package name */
    private float f42623d;

    /* renamed from: e  reason: collision with root package name */
    private Paint f42624e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f42625f;

    public RoundAngleFrameLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RoundAngleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundAngleFrameLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundAngleFrameLayout);
            float dimension = obtainStyledAttributes.getDimension(R.styleable.RoundAngleFrameLayout_all_radius, 0.0f);
            this.f42620a = obtainStyledAttributes.getDimension(R.styleable.RoundAngleFrameLayout_topLeftRadius, dimension);
            this.f42621b = obtainStyledAttributes.getDimension(R.styleable.RoundAngleFrameLayout_topRightRadius, dimension);
            this.f42622c = obtainStyledAttributes.getDimension(R.styleable.RoundAngleFrameLayout_bottomLeftRadius, dimension);
            this.f42623d = obtainStyledAttributes.getDimension(R.styleable.RoundAngleFrameLayout_bottomRightRadius, dimension);
            obtainStyledAttributes.recycle();
        }
        this.f42624e = new Paint();
        this.f42624e.setColor(-1);
        this.f42624e.setAntiAlias(true);
        this.f42624e.setStyle(Paint.Style.FILL);
        this.f42624e.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        this.f42625f = new Paint();
        this.f42625f.setXfermode((Xfermode) null);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight()), this.f42625f, 31);
        super.dispatchDraw(canvas);
        if (this.f42620a > 0.0f) {
            Path path = new Path();
            path.moveTo(0.0f, this.f42620a);
            path.lineTo(0.0f, 0.0f);
            path.lineTo(this.f42620a, 0.0f);
            float f2 = this.f42620a;
            path.arcTo(new RectF(0.0f, 0.0f, f2 * 2.0f, f2 * 2.0f), -90.0f, -90.0f);
            path.close();
            canvas.drawPath(path, this.f42624e);
        }
        if (this.f42621b > 0.0f) {
            int width = getWidth();
            Path path2 = new Path();
            float f3 = (float) width;
            path2.moveTo(f3 - this.f42621b, 0.0f);
            path2.lineTo(f3, 0.0f);
            path2.lineTo(f3, this.f42621b);
            float f4 = this.f42621b;
            path2.arcTo(new RectF(f3 - (f4 * 2.0f), 0.0f, f3, f4 * 2.0f), 0.0f, -90.0f);
            path2.close();
            canvas.drawPath(path2, this.f42624e);
        }
        if (this.f42622c > 0.0f) {
            int height = getHeight();
            Path path3 = new Path();
            float f5 = (float) height;
            path3.moveTo(0.0f, f5 - this.f42622c);
            path3.lineTo(0.0f, f5);
            path3.lineTo(this.f42622c, f5);
            float f6 = this.f42622c;
            path3.arcTo(new RectF(0.0f, f5 - (f6 * 2.0f), f6 * 2.0f, f5), 90.0f, 90.0f);
            path3.close();
            canvas.drawPath(path3, this.f42624e);
        }
        if (this.f42623d > 0.0f) {
            int height2 = getHeight();
            int width2 = getWidth();
            Path path4 = new Path();
            float f7 = (float) width2;
            float f8 = (float) height2;
            path4.moveTo(f7 - this.f42623d, f8);
            path4.lineTo(f7, f8);
            path4.lineTo(f7, f8 - this.f42623d);
            float f9 = this.f42623d;
            path4.arcTo(new RectF(f7 - (f9 * 2.0f), f8 - (f9 * 2.0f), f7, f8), 0.0f, 90.0f);
            path4.close();
            canvas.drawPath(path4, this.f42624e);
        }
        canvas.restore();
    }
}
