package com.bumptech.glide.e.b;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.e.b.f;

public abstract class a<R> implements g<R> {

    /* renamed from: a  reason: collision with root package name */
    private final g<Drawable> f6540a;

    /* access modifiers changed from: protected */
    public abstract Bitmap a(R r);

    public a(g<Drawable> gVar) {
        this.f6540a = gVar;
    }

    public final f<R> a(com.bumptech.glide.load.a aVar, boolean z) {
        return new C0089a(this.f6540a.a(aVar, z));
    }

    /* renamed from: com.bumptech.glide.e.b.a$a  reason: collision with other inner class name */
    final class C0089a implements f<R> {

        /* renamed from: b  reason: collision with root package name */
        private final f<Drawable> f6542b;

        C0089a(f<Drawable> fVar) {
            this.f6542b = fVar;
        }

        public final boolean a(R r, f.a aVar) {
            return this.f6542b.a(new BitmapDrawable(aVar.f().getResources(), a.this.a(r)), aVar);
        }
    }
}
