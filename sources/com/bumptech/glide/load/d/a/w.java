package com.bumptech.glide.load.d.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.b.v;

public final class w implements r, v<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f7186a;

    /* renamed from: b  reason: collision with root package name */
    private final v<Bitmap> f7187b;

    public static v<BitmapDrawable> a(Resources resources, v<Bitmap> vVar) {
        if (vVar == null) {
            return null;
        }
        return new w(resources, vVar);
    }

    private w(Resources resources, v<Bitmap> vVar) {
        this.f7186a = (Resources) j.a(resources, "Argument must not be null");
        this.f7187b = (v) j.a(vVar, "Argument must not be null");
    }

    public final Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    public final int c() {
        return this.f7187b.c();
    }

    public final void d() {
        this.f7187b.d();
    }

    public final void e() {
        v<Bitmap> vVar = this.f7187b;
        if (vVar instanceof r) {
            ((r) vVar).e();
        }
    }

    public final /* synthetic */ Object b() {
        return new BitmapDrawable(this.f7186a, this.f7187b.b());
    }
}
