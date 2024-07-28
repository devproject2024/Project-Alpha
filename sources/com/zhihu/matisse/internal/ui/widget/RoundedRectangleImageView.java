package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class RoundedRectangleImageView extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private float f45881a;

    /* renamed from: b  reason: collision with root package name */
    private Path f45882b;

    /* renamed from: c  reason: collision with root package name */
    private RectF f45883c;

    public RoundedRectangleImageView(Context context) {
        super(context);
        a(context);
    }

    public RoundedRectangleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public RoundedRectangleImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(context);
    }

    private void a(Context context) {
        this.f45881a = context.getResources().getDisplayMetrics().density * 2.0f;
        this.f45882b = new Path();
        this.f45883c = new RectF();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f45883c.set(0.0f, 0.0f, (float) getMeasuredWidth(), (float) getMeasuredHeight());
        Path path = this.f45882b;
        RectF rectF = this.f45883c;
        float f2 = this.f45881a;
        path.addRoundRect(rectF, f2, f2, Path.Direction.CW);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.clipPath(this.f45882b);
        super.onDraw(canvas);
    }
}
