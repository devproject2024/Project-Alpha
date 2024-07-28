package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.a.f;
import com.bumptech.glide.load.b.v;
import java.util.concurrent.locks.Lock;

final class p {

    /* renamed from: a  reason: collision with root package name */
    private static final e f7168a = new f() {
        public final void a(Bitmap bitmap) {
        }
    };

    static v<Bitmap> a(e eVar, Drawable drawable, int i2, int i3) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (!(current instanceof Animatable)) {
            bitmap = b(eVar, current, i2, i3);
            z = true;
        } else {
            bitmap = null;
        }
        if (!z) {
            eVar = f7168a;
        }
        return e.a(bitmap, eVar);
    }

    private static Bitmap b(e eVar, Drawable drawable, int i2, int i3) {
        if (i2 == Integer.MIN_VALUE && drawable.getIntrinsicWidth() <= 0) {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                StringBuilder sb = new StringBuilder("Unable to draw ");
                sb.append(drawable);
                sb.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            return null;
        } else if (i3 != Integer.MIN_VALUE || drawable.getIntrinsicHeight() > 0) {
            if (drawable.getIntrinsicWidth() > 0) {
                i2 = drawable.getIntrinsicWidth();
            }
            if (drawable.getIntrinsicHeight() > 0) {
                i3 = drawable.getIntrinsicHeight();
            }
            Lock a2 = ad.a();
            a2.lock();
            Bitmap a3 = eVar.a(i2, i3, Bitmap.Config.ARGB_8888);
            try {
                Canvas canvas = new Canvas(a3);
                drawable.setBounds(0, 0, i2, i3);
                drawable.draw(canvas);
                canvas.setBitmap((Bitmap) null);
                return a3;
            } finally {
                a2.unlock();
            }
        } else {
            if (Log.isLoggable("DrawableToBitmap", 5)) {
                StringBuilder sb2 = new StringBuilder("Unable to draw ");
                sb2.append(drawable);
                sb2.append(" to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
            }
            return null;
        }
    }
}
