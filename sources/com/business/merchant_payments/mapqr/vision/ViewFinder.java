package com.business.merchant_payments.mapqr.vision;

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
import com.business.merchant_payments.R;
import com.business.merchant_payments.mapqr.vision.camera.CameraSource;
import com.google.android.gms.common.images.a;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;

public final class ViewFinder extends View {
    public static final long ANIMATION_DELAY = 80;
    public static final int CURRENT_POINT_OPACITY = 160;
    public static final int MAX_FRAME_HEIGHT = 675;
    public static final int MAX_FRAME_WIDTH = 1200;
    public static final int MAX_RESULT_POINTS = 20;
    public static final int MIN_FRAME_HEIGHT = 240;
    public static final int MIN_FRAME_WIDTH = 240;
    public static final int POINT_SIZE = 6;
    public static final int[] SCANNER_ALPHA = {0, 64, 128, 192, PriceRangeSeekBar.INVALID_POINTER_ID, 192, 128, 64};
    public static final String TAG = ViewFinder.class.getSimpleName();
    public static final int frameOffset = 0;
    public boolean isScanOnly;
    public final int laserColor;
    public CameraSource mCameraSource;
    public final int maskColor;
    public final Paint paint = new Paint(1);
    public Bitmap resultBitmap;
    public final int resultColor;
    public final int resultPointColor;
    public int scannerAlpha;
    public boolean swipingOn;

    public static int findDesiredDimensionInRange(int i2, int i3, int i4) {
        int i5 = (int) ((((double) i2) * 5.0d) / 9.0d);
        return i5 < i3 ? i3 : i5 > i4 ? i4 : i5;
    }

    public static int findScanOnlyDesiredDimensionInRange(int i2, int i3, int i4) {
        int i5 = (int) ((((double) i2) * 5.8d) / 8.0d);
        return i5 < i3 ? i3 : i5 > i4 ? i4 : i5;
    }

    public ViewFinder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources = getResources();
        this.maskColor = resources.getColor(R.color.viewfinder_mask);
        this.resultColor = resources.getColor(R.color.result_view);
        this.laserColor = resources.getColor(R.color.viewfinder_laser);
        this.resultPointColor = resources.getColor(R.color.possible_result_points);
        this.scannerAlpha = 0;
    }

    public final void setScanOnly(boolean z) {
        this.isScanOnly = z;
    }

    public final Rect getScanOnlyFramingRect() {
        Point screenResolution = getScreenResolution();
        if (screenResolution == null) {
            return null;
        }
        int findScanOnlyDesiredDimensionInRange = findScanOnlyDesiredDimensionInRange(screenResolution.x, 240, MAX_FRAME_WIDTH);
        findScanOnlyDesiredDimensionInRange(screenResolution.y, 240, 675);
        int i2 = (screenResolution.x - findScanOnlyDesiredDimensionInRange) / 2;
        int height = (getHeight() - findScanOnlyDesiredDimensionInRange) / 2;
        return new Rect(i2, height, i2 + findScanOnlyDesiredDimensionInRange, findScanOnlyDesiredDimensionInRange + height);
    }

    public final synchronized Rect getFramingRect() {
        if (this.isScanOnly) {
            return getScanOnlyFramingRect();
        }
        Point screenResolution = getScreenResolution();
        if (screenResolution == null) {
            return null;
        }
        int findDesiredDimensionInRange = findDesiredDimensionInRange(screenResolution.x, 240, MAX_FRAME_WIDTH);
        findDesiredDimensionInRange(screenResolution.y, 240, 675);
        int i2 = (screenResolution.x - findDesiredDimensionInRange) / 2;
        int height = (getHeight() - findDesiredDimensionInRange) / 2;
        return new Rect(i2, height, i2 + findDesiredDimensionInRange, findDesiredDimensionInRange + height);
    }

    public final void onDraw(Canvas canvas) {
        Rect framingRect = getFramingRect();
        Rect framingRectInPreview = getFramingRectInPreview();
        if (framingRect != null && framingRectInPreview != null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.paint.setColor(this.resultBitmap != null ? this.resultColor : this.maskColor);
            if (this.swipingOn) {
                canvas.drawRect(0.0f, 0.0f, (float) width, (float) height, this.paint);
            } else {
                Canvas canvas2 = canvas;
                float f2 = (float) width;
                canvas2.drawRect(0.0f, 0.0f, f2, (float) framingRect.top, this.paint);
                canvas.drawRect(0.0f, (float) framingRect.top, (float) framingRect.left, (float) (framingRect.bottom + 1), this.paint);
                canvas2.drawRect((float) (framingRect.right + 1), (float) framingRect.top, f2, (float) (framingRect.bottom + 1), this.paint);
                canvas2.drawRect(0.0f, (float) (framingRect.bottom + 1), f2, (float) height, this.paint);
            }
            if (this.resultBitmap != null) {
                this.paint.setAlpha(160);
                canvas.drawBitmap(this.resultBitmap, (Rect) null, framingRect, this.paint);
                return;
            }
            this.paint.setColor(this.laserColor);
            this.paint.setAlpha(SCANNER_ALPHA[this.scannerAlpha]);
            this.scannerAlpha = (this.scannerAlpha + 1) % SCANNER_ALPHA.length;
            framingRect.width();
            framingRectInPreview.width();
            framingRect.height();
            framingRectInPreview.height();
            int i2 = framingRect.left;
            postInvalidateDelayed(80, i2 - 6, framingRect.top - 6, framingRect.right + 6, framingRect.bottom + 6);
        }
    }

    public final void drawViewfinder() {
        Bitmap bitmap = this.resultBitmap;
        this.resultBitmap = null;
        if (bitmap != null) {
            bitmap.recycle();
        }
        invalidate();
    }

    public final void drawResultBitmap(Bitmap bitmap) {
        this.resultBitmap = bitmap;
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
        int i2 = rect.left;
        int i3 = cameraResolution.y;
        int i4 = screenResolution.x;
        rect.left = (i2 * i3) / i4;
        rect.right = (rect.right * i3) / i4;
        int i5 = rect.top;
        int i6 = cameraResolution.x;
        int i7 = screenResolution.y;
        int i8 = (i5 * (i6 + i5)) / i7;
        rect.top = i8;
        rect.bottom = (rect.bottom * (i6 + i8)) / i7;
        return rect;
    }

    public final void setCameraSource(CameraSource cameraSource) {
        this.mCameraSource = cameraSource;
    }

    public final Point getCameraResolution() {
        CameraSource cameraSource = this.mCameraSource;
        if (cameraSource == null) {
            return null;
        }
        a previewSize = cameraSource.getPreviewSize();
        if (previewSize == null) {
            return getScreenResolution();
        }
        return new Point(previewSize.f8720a, previewSize.f8721b);
    }

    public final void setSwipingOn(boolean z) {
        this.swipingOn = z;
    }
}
