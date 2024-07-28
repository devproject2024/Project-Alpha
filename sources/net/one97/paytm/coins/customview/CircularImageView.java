package net.one97.paytm.coins.customview;

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
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import net.one97.paytm.coins.model.a;

public class CircularImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f16734a;

    public CircularImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean isInEditMode() {
        return super.isInEditMode();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Drawable drawable = getDrawable();
        if (drawable != null && getWidth() != 0 && getHeight() != 0) {
            try {
                Bitmap copy = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                int width = getWidth();
                getHeight();
                if (this.f16734a) {
                    a.C0251a aVar = a.f16779a;
                    if (copy != null) {
                        if (!copy.isRecycled()) {
                            int width2 = copy.getWidth() + 5;
                            int height = copy.getHeight() + 5;
                            bitmap2 = Bitmap.createBitmap(width2, height, Bitmap.Config.ARGB_8888);
                            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                            BitmapShader bitmapShader = new BitmapShader(copy, tileMode, tileMode);
                            Paint paint = new Paint();
                            paint.setAntiAlias(true);
                            paint.setShader(bitmapShader);
                            Canvas canvas2 = new Canvas(bitmap2);
                            float f2 = (width2 > height ? (float) height : (float) width2) / 2.0f;
                            canvas2.drawCircle((float) (width2 / 2), (float) (height / 2), f2, paint);
                            paint.setShader((Shader) null);
                            paint.setStyle(Paint.Style.STROKE);
                            paint.setColor(Color.rgb(240, 240, 240));
                            paint.setStrokeWidth(5.0f);
                            canvas2.drawCircle((float) (width2 / 2), (float) (height / 2), f2 - 2.0f, paint);
                            bitmap = bitmap2;
                        }
                    }
                    bitmap2 = null;
                    bitmap = bitmap2;
                } else {
                    if (!(copy.getWidth() == width && copy.getHeight() == width)) {
                        copy = Bitmap.createScaledBitmap(copy, width, width, false);
                    }
                    bitmap = Bitmap.createBitmap(copy.getWidth(), copy.getHeight(), Bitmap.Config.ARGB_8888);
                    Canvas canvas3 = new Canvas(bitmap);
                    Paint paint2 = new Paint();
                    Rect rect = new Rect(0, 0, copy.getWidth(), copy.getHeight());
                    paint2.setAntiAlias(true);
                    paint2.setFilterBitmap(true);
                    paint2.setDither(true);
                    canvas3.drawARGB(0, 0, 0, 0);
                    paint2.setColor(Color.parseColor("#BAB399"));
                    canvas3.drawCircle(((float) (copy.getWidth() / 2)) + 0.7f, ((float) (copy.getHeight() / 2)) + 0.7f, ((float) (copy.getWidth() / 2)) + 0.1f, paint2);
                    paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                    canvas3.drawBitmap(copy, rect, rect, paint2);
                }
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            } catch (OutOfMemoryError unused) {
            }
        }
    }

    public void setCircularBorder(boolean z) {
        this.f16734a = z;
    }
}
