package com.bumptech.glide.load.d.a;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.b.a.e;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.c;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import java.io.File;

public final class b implements l<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final e f7132a;

    /* renamed from: b  reason: collision with root package name */
    private final l<Bitmap> f7133b;

    public final /* synthetic */ boolean a(Object obj, File file, i iVar) {
        return this.f7133b.a(new e(((BitmapDrawable) ((v) obj).b()).getBitmap(), this.f7132a), file, iVar);
    }

    public b(e eVar, l<Bitmap> lVar) {
        this.f7132a = eVar;
        this.f7133b = lVar;
    }

    public final c a(i iVar) {
        return this.f7133b.a(iVar);
    }
}
