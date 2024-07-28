package net.one97.paytm;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import net.one97.paytm.wallet.newdesign.a;

public class CircularImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f51823a;

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
                Bitmap copy = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                int width = getWidth();
                getHeight();
                if (this.f51823a) {
                    bitmap = a.a(copy);
                } else {
                    if (!(copy.getWidth() == width && copy.getHeight() == width)) {
                        copy = Bitmap.createScaledBitmap(copy, width, width, false);
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
                    canvas2.drawCircle(((float) (copy.getWidth() / 2)) + 0.7f, ((float) (copy.getHeight() / 2)) + 0.7f, ((float) (copy.getWidth() / 2)) + 0.1f, paint);
                    paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                    canvas2.drawBitmap(copy, rect, rect, paint);
                    bitmap = createBitmap;
                }
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            } catch (OutOfMemoryError unused) {
            }
        }
    }

    public void setCircularBorder(boolean z) {
        this.f51823a = z;
    }
}
