package net.one97.paytm.recharge.legacy.catalog.widget;

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
import kotlin.g.b.k;

public final class CircularImageViewRecharge extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private boolean f62988a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CircularImageViewRecharge(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k.c(context, "ctx");
        k.c(attributeSet, "attrs");
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3;
        Drawable drawable = getDrawable();
        if (drawable != null && getWidth() != 0 && getHeight() != 0) {
            try {
                Bitmap copy = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
                int width = getWidth();
                getHeight();
                if (this.f62988a) {
                    if (copy == null || copy.isRecycled()) {
                        bitmap3 = null;
                    } else {
                        int width2 = copy.getWidth() + 5;
                        int height = copy.getHeight() + 5;
                        bitmap3 = Bitmap.createBitmap(width2, height, Bitmap.Config.ARGB_8888);
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        BitmapShader bitmapShader = new BitmapShader(copy, tileMode, tileMode);
                        Paint paint = new Paint();
                        paint.setAntiAlias(true);
                        paint.setShader(bitmapShader);
                        Canvas canvas2 = new Canvas(bitmap3);
                        float f2 = (width2 > height ? (float) height : (float) width2) / 2.0f;
                        canvas2.drawCircle((float) (width2 / 2), (float) (height / 2), f2, paint);
                        paint.setShader((Shader) null);
                        paint.setStyle(Paint.Style.STROKE);
                        paint.setColor(Color.rgb(240, 240, 240));
                        paint.setStrokeWidth(5.0f);
                        canvas2.drawCircle((float) (width2 / 2), (float) (height / 2), f2 - 2.0f, paint);
                    }
                    bitmap = bitmap3;
                } else {
                    k.a((Object) copy, "bitmap");
                    if (copy.getWidth() != width || copy.getHeight() != width) {
                        if (copy.getWidth() >= copy.getHeight()) {
                            bitmap2 = Bitmap.createBitmap(copy, (copy.getWidth() / 2) - (copy.getHeight() / 2), 0, copy.getHeight(), copy.getHeight());
                            k.a((Object) bitmap2, "Bitmap.createBitmap(\n   …tmap.height\n            )");
                        } else {
                            bitmap2 = Bitmap.createBitmap(copy, 0, (copy.getHeight() / 2) - (copy.getWidth() / 2), copy.getWidth(), copy.getWidth());
                            k.a((Object) bitmap2, "Bitmap.createBitmap(\n   …itmap.width\n            )");
                        }
                        copy = Bitmap.createScaledBitmap(bitmap2, width, width, false);
                        k.a((Object) copy, "Bitmap.createScaledBitma…p, radius, radius, false)");
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
                    k.a((Object) bitmap, "output");
                }
                if (canvas != null) {
                    if (bitmap == null) {
                        k.a();
                    }
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                }
            } catch (OutOfMemoryError unused) {
            }
        }
    }
}
