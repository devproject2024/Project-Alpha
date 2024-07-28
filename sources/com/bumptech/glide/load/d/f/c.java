package com.bumptech.glide.load.d.f;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.i;

public final class c implements e<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final e f7248a;

    /* renamed from: b  reason: collision with root package name */
    private final e<Bitmap, byte[]> f7249b;

    /* renamed from: c  reason: collision with root package name */
    private final e<com.bumptech.glide.load.d.e.c, byte[]> f7250c;

    public c(e eVar, e<Bitmap, byte[]> eVar2, e<com.bumptech.glide.load.d.e.c, byte[]> eVar3) {
        this.f7248a = eVar;
        this.f7249b = eVar2;
        this.f7250c = eVar3;
    }

    public final v<byte[]> a(v<Drawable> vVar, i iVar) {
        Drawable b2 = vVar.b();
        if (b2 instanceof BitmapDrawable) {
            return this.f7249b.a(com.bumptech.glide.load.d.a.e.a(((BitmapDrawable) b2).getBitmap(), this.f7248a), iVar);
        }
        if (b2 instanceof com.bumptech.glide.load.d.e.c) {
            return this.f7250c.a(vVar, iVar);
        }
        return null;
    }
}
