package net.one97.paytm.common.widgets;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import com.android.volley.toolbox.NetworkImageView;

public class RoundedImageView extends NetworkImageView {
    public RoundedImageView(Context context) {
        super(context);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoundedImageView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Drawable drawable = getDrawable();
        if (Build.VERSION.SDK_INT >= 21 && (drawable instanceof VectorDrawable)) {
            super.onDraw(canvas);
        } else if (drawable != null && getWidth() != 0 && getHeight() != 0 && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
            Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
            int width = getWidth();
            getHeight();
            if (!(copy.getWidth() == width && copy.getHeight() == width)) {
                float f2 = (float) width;
                float width2 = f2 / ((float) copy.getWidth());
                float height = f2 / ((float) copy.getHeight());
                float f3 = f2 / 2.0f;
                Matrix matrix = new Matrix();
                matrix.setScale(width2, height, f3, f3);
                Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                canvas2.setMatrix(matrix);
                canvas2.drawBitmap(copy, f3 - ((float) (copy.getWidth() / 2)), f3 - ((float) (copy.getHeight() / 2)), new Paint(2));
                copy = createBitmap;
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(copy.getWidth(), copy.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas3 = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, copy.getWidth(), copy.getHeight());
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            paint.setDither(true);
            canvas3.drawARGB(0, 0, 0, 0);
            paint.setColor(Color.parseColor("#BAB399"));
            canvas3.drawCircle(((float) (copy.getWidth() / 2)) + 0.7f, ((float) (copy.getHeight() / 2)) + 0.7f, ((float) (copy.getWidth() / 2)) + 0.1f, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas3.drawBitmap(copy, rect, rect, paint);
            if (canvas != null) {
                canvas.drawBitmap(createBitmap2, 0.0f, 0.0f, (Paint) null);
            }
        }
    }

    public void setErrorImageResId(int i2) {
        super.setErrorImageResId(i2);
    }

    public void setImageResource(int i2) {
        super.setImageResource(i2);
    }
}
