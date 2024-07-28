package net.one97.paytm.coins.customview;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import com.squareup.picasso.ah;

public final class a implements ah {
    public final String key() {
        return "circle";
    }

    public final Bitmap transform(Bitmap bitmap) {
        int max = Math.max(bitmap.getWidth(), bitmap.getHeight());
        int max2 = Math.max(bitmap.getWidth(), bitmap.getHeight());
        Bitmap createBitmap = Bitmap.createBitmap(max2, max2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawColor(-1);
        canvas.drawBitmap(bitmap, (float) ((max2 - bitmap.getWidth()) / 2), (float) ((max2 - bitmap.getHeight()) / 2), (Paint) null);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(max, max, bitmap.getConfig());
        Canvas canvas2 = new Canvas(createBitmap2);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(createBitmap, tileMode, tileMode));
        paint.setAntiAlias(true);
        float f2 = ((float) max) / 2.0f;
        canvas2.drawCircle(f2, f2, f2, paint);
        createBitmap.recycle();
        return createBitmap2;
    }
}
