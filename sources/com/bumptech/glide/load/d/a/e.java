package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import com.bumptech.glide.g.j;
import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.b.v;

public final class e implements r, v<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f7138a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bumptech.glide.load.b.a.e f7139b;

    public static e a(Bitmap bitmap, com.bumptech.glide.load.b.a.e eVar) {
        if (bitmap == null) {
            return null;
        }
        return new e(bitmap, eVar);
    }

    public e(Bitmap bitmap, com.bumptech.glide.load.b.a.e eVar) {
        this.f7138a = (Bitmap) j.a(bitmap, "Bitmap must not be null");
        this.f7139b = (com.bumptech.glide.load.b.a.e) j.a(eVar, "BitmapPool must not be null");
    }

    public final Class<Bitmap> a() {
        return Bitmap.class;
    }

    public final int c() {
        return k.a(this.f7138a);
    }

    public final void d() {
        this.f7139b.a(this.f7138a);
    }

    public final void e() {
        this.f7138a.prepareToDraw();
    }

    public final /* bridge */ /* synthetic */ Object b() {
        return this.f7138a;
    }
}
