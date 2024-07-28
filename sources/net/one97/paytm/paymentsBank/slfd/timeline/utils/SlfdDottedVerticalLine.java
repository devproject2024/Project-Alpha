package net.one97.paytm.paymentsBank.slfd.timeline.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import net.one97.paytm.paymentsBank.R;

public class SlfdDottedVerticalLine extends View {

    /* renamed from: a  reason: collision with root package name */
    Paint f19381a;

    /* renamed from: b  reason: collision with root package name */
    Path f19382b;

    public SlfdDottedVerticalLine(Context context) {
        super(context);
        a();
    }

    public SlfdDottedVerticalLine(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public SlfdDottedVerticalLine(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    public SlfdDottedVerticalLine(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a();
    }

    private void a() {
        this.f19381a = new Paint();
        this.f19381a.setColor(getResources().getColor(R.color.green));
        this.f19381a.setStrokeWidth(5.0f);
        this.f19381a.setStyle(Paint.Style.STROKE);
        this.f19382b = new Path();
        this.f19381a.setPathEffect(new DashPathEffect(new float[]{20.0f, 20.0f}, 0.0f));
        getResources();
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, (Paint) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine((float) getWidth(), 0.0f, (float) getWidth(), (float) getHeight(), this.f19381a);
    }
}
