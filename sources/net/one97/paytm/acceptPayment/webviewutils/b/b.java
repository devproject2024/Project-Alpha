package net.one97.paytm.acceptPayment.webviewutils.b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import com.squareup.picasso.af;
import com.squareup.picasso.w;
import java.io.ByteArrayOutputStream;
import net.one97.paytm.acceptPayment.webviewutils.c.a;

public final class b implements af {

    /* renamed from: a  reason: collision with root package name */
    a f52252a;

    /* renamed from: b  reason: collision with root package name */
    public int f52253b = -1;

    public final void onPrepareLoad(Drawable drawable) {
    }

    public b(a aVar) {
        this.f52252a = aVar;
    }

    public final void onBitmapLoaded(final Bitmap bitmap, w.d dVar) {
        new Thread(new Runnable() {
            public final void run() {
                float height = ((float) bitmap.getHeight()) / (((float) bitmap.getWidth()) * 1.0f);
                int i2 = b.this.f52253b;
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Bitmap.createScaledBitmap(bitmap, i2, (int) (((float) i2) * height), false).compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                b.this.f52252a.c(Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
            }
        }).start();
    }

    public final void onBitmapFailed(Exception exc, Drawable drawable) {
        this.f52252a.i();
    }
}
