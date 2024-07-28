package net.one97.scanner.camera;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.common.images.a;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import net.one97.scanner.R;

public final class ViewFinder extends View {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f72454b = {0, 64, 128, 192, PriceRangeSeekBar.INVALID_POINTER_ID, 192, 128, 64};

    /* renamed from: c  reason: collision with root package name */
    private static final String f72455c = ViewFinder.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    public final int f72456a;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f72457d = new Paint(1);

    /* renamed from: e  reason: collision with root package name */
    private Bitmap f72458e;

    /* renamed from: f  reason: collision with root package name */
    private final int f72459f;

    /* renamed from: g  reason: collision with root package name */
    private final int f72460g;

    /* renamed from: h  reason: collision with root package name */
    private final int f72461h;

    /* renamed from: i  reason: collision with root package name */
    private int f72462i;
    private boolean j;
    private d k;
    private boolean l;

    public ViewFinder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.f72456a = resources.getColor(R.color.viewfinder_mask);
        this.f72459f = resources.getColor(R.color.result_view);
        this.f72460g = resources.getColor(R.color.viewfinder_laser);
        this.f72461h = resources.getColor(R.color.possible_result_points);
        this.f72462i = 0;
    }

    public final void setScanOnly(boolean z) {
        this.j = z;
    }

    public final Rect getScanOnlyFramingRect() {
        Point screenResolution = getScreenResolution();
        if (screenResolution == null) {
            return null;
        }
        int i2 = (int) ((((double) screenResolution.x) * 5.8d) / 8.0d);
        if (i2 < 240) {
            i2 = 240;
        } else if (i2 > 1200) {
            i2 = com.business.merchant_payments.mapqr.vision.ViewFinder.MAX_FRAME_WIDTH;
        }
        int i3 = screenResolution.y;
        int i4 = (screenResolution.x - i2) / 2;
        int height = (getHeight() - i2) / 2;
        return new Rect(i4, height, i4 + i2, i2 + height);
    }

    public final synchronized Rect getFramingRect() {
        if (this.j) {
            return getScanOnlyFramingRect();
        }
        Point screenResolution = getScreenResolution();
        if (screenResolution == null) {
            return null;
        }
        int i2 = (int) ((((double) screenResolution.x) * 5.0d) / 9.0d);
        if (i2 < 240) {
            i2 = 240;
        } else if (i2 > 1200) {
            i2 = com.business.merchant_payments.mapqr.vision.ViewFinder.MAX_FRAME_WIDTH;
        }
        int i3 = screenResolution.y;
        int i4 = (screenResolution.x - i2) / 2;
        int height = (getHeight() - i2) / 2;
        return new Rect(i4, height, i4 + i2, i2 + height);
    }

    public final void onDraw(Canvas canvas) {
        Rect framingRect = getFramingRect();
        Rect framingRectInPreview = getFramingRectInPreview();
        if (framingRect != null && framingRectInPreview != null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.f72457d.setColor(this.f72458e != null ? this.f72459f : this.f72456a);
            if (this.l) {
                canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, this.f72457d);
            } else {
                float f2 = (float) width;
                canvas.drawRect(0.0f, 0.0f, f2, (float) framingRect.top, this.f72457d);
                Canvas canvas2 = canvas;
                canvas2.drawRect(0.0f, (float) framingRect.top, (float) framingRect.left, (float) (framingRect.bottom + 1), this.f72457d);
                float f3 = f2;
                canvas2.drawRect((float) (framingRect.right + 1), (float) framingRect.top, f3, (float) (framingRect.bottom + 1), this.f72457d);
                canvas2.drawRect(0.0f, (float) (framingRect.bottom + 1), f3, (float) height, this.f72457d);
            }
            if (this.f72458e != null) {
                this.f72457d.setAlpha(160);
                canvas.drawBitmap(this.f72458e, (Rect) null, framingRect, this.f72457d);
                return;
            }
            this.f72457d.setColor(this.f72460g);
            this.f72457d.setAlpha(f72454b[this.f72462i]);
            this.f72462i = (this.f72462i + 1) % f72454b.length;
            framingRect.width();
            framingRectInPreview.width();
            framingRect.height();
            framingRectInPreview.height();
            int i2 = framingRect.left;
            int i3 = framingRect.top;
            postInvalidateDelayed(80, framingRect.left - 6, framingRect.top - 6, framingRect.right + 6, framingRect.bottom + 6);
        }
    }

    public final void a() {
        Bitmap bitmap = this.f72458e;
        this.f72458e = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }

    public final Point getScreenResolution() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public final Rect getFramingRectInPreview() {
        Rect framingRect = getFramingRect();
        if (framingRect == null) {
            return null;
        }
        Rect rect = new Rect(framingRect);
        Point cameraResolution = getCameraResolution();
        Point screenResolution = getScreenResolution();
        if (cameraResolution == null || screenResolution == null) {
            return null;
        }
        rect.left = (rect.left * cameraResolution.y) / screenResolution.x;
        rect.right = (rect.right * cameraResolution.y) / screenResolution.x;
        rect.top = (rect.top * (cameraResolution.x + rect.top)) / screenResolution.y;
        rect.bottom = (rect.bottom * (cameraResolution.x + rect.top)) / screenResolution.y;
        return rect;
    }

    public final void setCameraSource(d dVar) {
        this.k = dVar;
    }

    public final Point getCameraResolution() {
        d dVar = this.k;
        if (dVar == null) {
            return null;
        }
        a aVar = dVar.f72470f;
        if (aVar == null) {
            return getScreenResolution();
        }
        return new Point(aVar.f8720a, aVar.f8721b);
    }

    public final void setSwipingOn(boolean z) {
        this.l = z;
    }
}
