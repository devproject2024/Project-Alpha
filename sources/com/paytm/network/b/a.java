package com.paytm.network.b;

import android.graphics.Bitmap;
import androidx.a.e;
import com.android.volley.toolbox.ImageLoader;

public final class a extends e<String, Bitmap> implements ImageLoader.ImageCache {
    public final /* synthetic */ int sizeOf(Object obj, Object obj2) {
        Bitmap bitmap = (Bitmap) obj2;
        if (b.a() >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public a(int i2) {
        super(i2);
        b.a("BitmapMemoryCache", "Size: ".concat(String.valueOf(i2)));
    }

    public final Bitmap getBitmap(String str) {
        return (Bitmap) get(str);
    }

    public final void putBitmap(String str, Bitmap bitmap) {
        put(str, bitmap);
    }
}
