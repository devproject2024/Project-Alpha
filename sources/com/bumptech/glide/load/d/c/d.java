package com.bumptech.glide.load.d.c;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.b.v;

final class d extends b<Drawable> {
    public final void d() {
    }

    static v<Drawable> a(Drawable drawable) {
        if (drawable != null) {
            return new d(drawable);
        }
        return null;
    }

    private d(Drawable drawable) {
        super(drawable);
    }

    public final Class<Drawable> a() {
        return this.f7202a.getClass();
    }

    public final int c() {
        return Math.max(1, this.f7202a.getIntrinsicWidth() * this.f7202a.getIntrinsicHeight() * 4);
    }
}
