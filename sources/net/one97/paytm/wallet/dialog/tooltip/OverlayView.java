package net.one97.paytm.wallet.dialog.tooltip;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.View;
import net.one97.paytm.wallet.R;

public class OverlayView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final int f70319a = R.integer.simpletooltip_overlay_alpha;

    /* renamed from: b  reason: collision with root package name */
    private View f70320b;

    /* renamed from: c  reason: collision with root package name */
    private Bitmap f70321c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f70322d = true;

    /* renamed from: e  reason: collision with root package name */
    private final int f70323e;

    /* renamed from: f  reason: collision with root package name */
    private final float f70324f;

    /* renamed from: g  reason: collision with root package name */
    private final int f70325g;

    public boolean isInEditMode() {
        return true;
    }

    OverlayView(Context context, View view, int i2, float f2, int i3) {
        super(context);
        this.f70320b = view;
        this.f70324f = f2;
        this.f70323e = i2;
        this.f70325g = i3;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Bitmap bitmap;
        if (this.f70322d || (bitmap = this.f70321c) == null || bitmap.isRecycled()) {
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            if (measuredWidth > 0 && measuredHeight > 0) {
                Bitmap bitmap2 = this.f70321c;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    this.f70321c.recycle();
                }
                this.f70321c = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(this.f70321c);
                RectF rectF = new RectF(0.0f, 0.0f, (float) measuredWidth, (float) measuredHeight);
                Paint paint = new Paint(1);
                paint.setColor(this.f70325g);
                paint.setAntiAlias(true);
                paint.setAlpha(getResources().getInteger(f70319a));
                canvas2.drawRect(rectF, paint);
                paint.setColor(0);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OUT));
                RectF b2 = c.b(this.f70320b);
                RectF b3 = c.b(this);
                float f2 = b2.left - b3.left;
                float f3 = b2.top - b3.top;
                float f4 = this.f70324f;
                RectF rectF2 = new RectF(f2 - f4, f3 - f4, f2 + ((float) this.f70320b.getMeasuredWidth()) + this.f70324f, f3 + ((float) this.f70320b.getMeasuredHeight()) + this.f70324f);
                if (this.f70323e == 1) {
                    canvas2.drawRect(rectF2, paint);
                } else {
                    canvas2.drawOval(rectF2, paint);
                }
                this.f70322d = false;
            }
        }
        Bitmap bitmap3 = this.f70321c;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            canvas.drawBitmap(this.f70321c, 0.0f, 0.0f, (Paint) null);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f70322d = true;
    }

    public View getAnchorView() {
        return this.f70320b;
    }

    public void setAnchorView(View view) {
        this.f70320b = view;
        invalidate();
    }
}
