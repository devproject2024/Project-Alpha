package com.business.merchant_payments.mapqr.vision;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.business.merchant_payments.mapqr.vision.camera.GraphicOverlay;
import com.google.android.gms.vision.barcode.Barcode;

public class BarcodeGraphic extends GraphicOverlay.Graphic {
    public static final int[] COLOR_CHOICES = {-16776961, -16711681, -16711936};
    public static int mCurrentColorIndex;
    public volatile Barcode mBarcode;
    public int mId;
    public Paint mRectPaint;
    public Paint mTextPaint;

    public BarcodeGraphic(GraphicOverlay graphicOverlay) {
        super(graphicOverlay);
        int[] iArr = COLOR_CHOICES;
        int length = (mCurrentColorIndex + 1) % iArr.length;
        mCurrentColorIndex = length;
        int i2 = iArr[length];
        Paint paint = new Paint();
        this.mRectPaint = paint;
        paint.setColor(i2);
        this.mRectPaint.setStyle(Paint.Style.STROKE);
        this.mRectPaint.setStrokeWidth(4.0f);
        Paint paint2 = new Paint();
        this.mTextPaint = paint2;
        paint2.setColor(i2);
        this.mTextPaint.setTextSize(36.0f);
    }

    public int getId() {
        return this.mId;
    }

    public void setId(int i2) {
        this.mId = i2;
    }

    public Barcode getBarcode() {
        return this.mBarcode;
    }

    public void updateItem(Barcode barcode) {
        this.mBarcode = barcode;
        postInvalidate();
    }

    public void draw(Canvas canvas) {
        Barcode barcode = this.mBarcode;
        if (barcode != null) {
            RectF rectF = new RectF(barcode.a());
            rectF.left = translateX(rectF.left);
            rectF.top = translateY(rectF.top);
            rectF.right = translateX(rectF.right);
            rectF.bottom = translateY(rectF.bottom);
            canvas.drawRect(rectF, this.mRectPaint);
            canvas.drawText(barcode.f12553b, rectF.left, rectF.bottom, this.mTextPaint);
        }
    }
}
