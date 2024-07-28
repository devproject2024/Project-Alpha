package com.bumptech.glide.load.d.f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.a.w;
import com.bumptech.glide.load.i;

public final class b implements e<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f7247a;

    public b(Resources resources) {
        this.f7247a = (Resources) j.a(resources, "Argument must not be null");
    }

    public final v<BitmapDrawable> a(v<Bitmap> vVar, i iVar) {
        return w.a(this.f7247a, vVar);
    }
}
