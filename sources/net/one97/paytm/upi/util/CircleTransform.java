package net.one97.paytm.upi.util;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import com.squareup.picasso.ah;
import kotlin.g.b.k;

public final class CircleTransform implements ah {
    public final String key() {
        return "circle";
    }

    public final Bitmap transform(Bitmap bitmap) {
        k.c(bitmap, "source");
        int min = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        if (!k.a((Object) createBitmap, (Object) bitmap)) {
            bitmap.recycle();
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(min, min, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f2 = ((float) min) / 2.0f;
        canvas.drawCircle(f2, f2, f2, paint);
        createBitmap.recycle();
        k.a((Object) createBitmap2, "bitmap");
        return createBitmap2;
    }
}
