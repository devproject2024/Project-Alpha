package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.util.Log;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.a.f;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a;
import java.io.IOException;

public final class d extends a<Bitmap> {

    /* renamed from: b  reason: collision with root package name */
    private final e f7137b = new f();

    public final v<Bitmap> a(ImageDecoder.Source source, int i2, int i3, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException {
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, onHeaderDecodedListener);
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            StringBuilder sb = new StringBuilder("Decoded [");
            sb.append(decodeBitmap.getWidth());
            sb.append("x");
            sb.append(decodeBitmap.getHeight());
            sb.append("] for [");
            sb.append(i2);
            sb.append("x");
            sb.append(i3);
            sb.append("]");
        }
        return new e(decodeBitmap, this.f7137b);
    }
}
