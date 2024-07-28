package net.one97.paytm.passbook.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class DottedLine extends View {

    /* renamed from: a  reason: collision with root package name */
    private Paint f57174a;

    /* renamed from: b  reason: collision with root package name */
    private int f57175b = -3355444;

    public DottedLine(Context context) {
        super(context);
    }

    public DottedLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DottedLine(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public DottedLine(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void setColor(int i2) {
        this.f57175b = i2;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f57174a == null) {
            this.f57174a = new Paint();
            this.f57174a.setColor(this.f57175b);
            this.f57174a.setStrokeWidth((float) getWidth());
            this.f57174a.setPathEffect(new DashPathEffect(new float[]{20.0f, 7.0f}, 0.0f));
        }
        canvas.drawLine(0.0f, 0.0f, 0.0f, (float) getHeight(), this.f57174a);
    }
}
