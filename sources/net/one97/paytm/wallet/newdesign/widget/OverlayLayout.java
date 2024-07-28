package net.one97.paytm.wallet.newdesign.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class OverlayLayout extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    private int f71486a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f71487b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f71488c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f71489d = 0;

    public OverlayLayout(Context context) {
        super(context);
    }

    public OverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OverlayLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    public void setViewDetails(int i2, int i3, int i4, int i5) {
        this.f71486a = i2;
        this.f71487b = i3;
        this.f71488c = i4;
        this.f71489d = i5;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(16777215);
        paint.setAlpha(0);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        paint.setAntiAlias(true);
        int i2 = this.f71486a;
        int i3 = this.f71487b;
        canvas.drawRoundRect((float) i2, (float) i3, (float) (this.f71488c + i2), (float) (this.f71489d + i3), 10.0f, 10.0f, paint);
        super.onDraw(canvas);
    }
}
