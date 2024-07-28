package net.one97.paytm.upi.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class CircularImageView extends AppCompatImageView {
    private int dimen;
    private boolean isCircularBorder;

    public CircularImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean isInEditMode() {
        return super.isInEditMode();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (drawable != null && getWidth() != 0 && getHeight() != 0) {
            try {
                if (drawable instanceof BitmapDrawable) {
                    Bitmap copy = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                    int width = getWidth();
                    getHeight();
                    if (this.isCircularBorder) {
                        bitmap = getCircularBitmapWithWhiteBorder(copy, this.dimen);
                    } else {
                        bitmap = getRoundedCroppedBitmap(copy, width);
                    }
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                } else if (drawable instanceof ColorDrawable) {
                    drawSolidColor(canvas, (ColorDrawable) drawable);
                }
            } catch (OutOfMemoryError unused) {
            }
        }
    }

    private void drawSolidColor(Canvas canvas, ColorDrawable colorDrawable) {
        Paint paint = new Paint(1);
        paint.setColor(colorDrawable.getColor());
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, (((float) getWidth()) / 2.0f) - ((float) this.dimen), paint);
        if (this.isCircularBorder && this.dimen != 0) {
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth((float) this.dimen);
            paint.setColor(-1);
            canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, (((float) getWidth()) / 2.0f) - ((float) this.dimen), paint);
        }
    }

    public final Bitmap getCircularBitmapWithWhiteBorder(Bitmap bitmap, int i2) {
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        int width = bitmap.getWidth() + i2;
        int height = bitmap.getHeight() + i2;
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        Canvas canvas = new Canvas(createBitmap);
        float f2 = (width > height ? (float) height : (float) width) / 2.0f;
        float f3 = (float) (width / 2);
        float f4 = (float) (height / 2);
        canvas.drawCircle(f3, f4, f2, paint);
        paint.setShader((Shader) null);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.rgb(240, 240, 240));
        paint.setStrokeWidth((float) i2);
        canvas.drawCircle(f3, f4, f2 - ((float) (i2 / 2)), paint);
        return createBitmap;
    }

    public static Bitmap getRoundedCroppedBitmap(Bitmap bitmap, int i2) {
        if (!(bitmap.getWidth() == i2 && bitmap.getHeight() == i2)) {
            bitmap = Bitmap.createScaledBitmap(bitmap, i2, i2, false);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        paint.setDither(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(Color.parseColor("#BAB399"));
        canvas.drawCircle(((float) (bitmap.getWidth() / 2)) + 0.7f, ((float) (bitmap.getHeight() / 2)) + 0.7f, ((float) (bitmap.getWidth() / 2)) + 0.1f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public void setCircularBorder(boolean z, int i2) {
        this.isCircularBorder = z;
        this.dimen = i2;
    }
}
