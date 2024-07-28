package com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import com.squareup.picasso.ah;

public class CircleTransform implements ah {
    private float mBorderWidth;
    private final int mColor;
    private final String mKey;

    public CircleTransform(float f2, int i2) {
        this.mBorderWidth = f2;
        this.mKey = "circle(" + f2 + ", " + i2 + ")";
        this.mColor = i2;
    }

    public Bitmap transform(Bitmap bitmap) {
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f2 = ((float) min) / 2.0f;
        canvas.drawCircle(f2, f2, f2, paint);
        paint.setShader((Shader) null);
        paint.setColor(this.mColor);
        paint.setStrokeWidth(this.mBorderWidth);
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(f2, f2, f2 - (this.mBorderWidth / 2.0f), paint);
        createBitmap.recycle();
        return createBitmap2;
    }

    public String key() {
        return this.mKey;
    }
}
