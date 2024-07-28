package net.one97.paytm.utils;

import android.graphics.Bitmap;
import androidx.a.e;
import com.android.volley.toolbox.ImageLoader;
import com.paytm.utility.a;
import com.paytm.utility.b;

public final class h extends e<String, Bitmap> implements ImageLoader.ImageCache {
    public final /* synthetic */ int sizeOf(Object obj, Object obj2) {
        Bitmap bitmap = (Bitmap) obj2;
        if (b.d() >= 12) {
            return bitmap.getByteCount();
        }
        return bitmap.getRowBytes() * bitmap.getHeight();
    }

    public h(int i2) {
        super(i2);
        a.c();
    }

    public final Bitmap getBitmap(String str) {
        return (Bitmap) get(str);
    }

    public final void putBitmap(String str, Bitmap bitmap) {
        put(str, bitmap);
    }
}
