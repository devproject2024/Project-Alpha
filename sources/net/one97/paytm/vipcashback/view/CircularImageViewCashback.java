package net.one97.paytm.vipcashback.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Xfermode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

public class CircularImageViewCashback extends AppCompatImageView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f21029a;

    public CircularImageViewCashback(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean isInEditMode() {
        return super.isInEditMode();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Drawable drawable = getDrawable();
        if (drawable != null && getWidth() != 0 && getHeight() != 0) {
            try {
                Bitmap copy = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                getWidth();
                int height = getHeight();
                if (!(copy.getWidth() == height && copy.getHeight() == height)) {
                    copy = Bitmap.createScaledBitmap(copy, height, height, false);
                }
                Bitmap createBitmap = Bitmap.createBitmap(copy.getWidth(), copy.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas2 = new Canvas(createBitmap);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, copy.getWidth(), copy.getHeight());
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                paint.setDither(true);
                canvas2.drawARGB(0, 0, 0, 0);
                paint.setColor(Color.parseColor("#BAB399"));
                canvas2.drawCircle((float) (copy.getWidth() / 2), (float) (copy.getHeight() / 2), (float) ((copy.getWidth() / 2) - 2), paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas2.drawBitmap(copy, rect, rect, paint);
                if (this.f21029a) {
                    paint.setXfermode((Xfermode) null);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setColor(Color.rgb(240, 240, 240));
                    paint.setStrokeWidth(2.0f);
                    canvas2.drawCircle((float) (copy.getWidth() / 2), (float) (copy.getHeight() / 2), ((float) (copy.getWidth() / 2)) - 1.3f, paint);
                }
                canvas.drawBitmap(createBitmap, 0.0f, 0.0f, (Paint) null);
            } catch (OutOfMemoryError unused) {
            }
        }
    }

    public void setCircularBorder(boolean z) {
        this.f21029a = z;
    }
}
