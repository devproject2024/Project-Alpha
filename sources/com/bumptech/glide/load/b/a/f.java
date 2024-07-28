package com.bumptech.glide.load.b.a;

import android.graphics.Bitmap;

public class f implements e {
    public final void a() {
    }

    public final void a(int i2) {
    }

    public void a(Bitmap bitmap) {
        bitmap.recycle();
    }

    public final Bitmap a(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }

    public final Bitmap b(int i2, int i3, Bitmap.Config config) {
        return Bitmap.createBitmap(i2, i3, config);
    }
}
