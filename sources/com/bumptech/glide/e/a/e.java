package com.bumptech.glide.e.a;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.e.b.f;

public abstract class e<Z> extends k<ImageView, Z> implements f.a {

    /* renamed from: b  reason: collision with root package name */
    private Animatable f6516b;

    /* access modifiers changed from: protected */
    public abstract void a(Z z);

    public e(ImageView imageView) {
        super(imageView);
    }

    public final Drawable e() {
        return ((ImageView) this.f6523a).getDrawable();
    }

    public final void d(Drawable drawable) {
        ((ImageView) this.f6523a).setImageDrawable(drawable);
    }

    public final void b(Drawable drawable) {
        super.b(drawable);
        b((Object) null);
        d(drawable);
    }

    public final void c(Drawable drawable) {
        super.c(drawable);
        b((Object) null);
        d(drawable);
    }

    public final void a(Drawable drawable) {
        super.a(drawable);
        Animatable animatable = this.f6516b;
        if (animatable != null) {
            animatable.stop();
        }
        b((Object) null);
        d(drawable);
    }

    public final void a(Z z, f<? super Z> fVar) {
        if (fVar == null || !fVar.a(z, this)) {
            b(z);
        } else {
            c(z);
        }
    }

    public final void a() {
        Animatable animatable = this.f6516b;
        if (animatable != null) {
            animatable.start();
        }
    }

    public final void b() {
        Animatable animatable = this.f6516b;
        if (animatable != null) {
            animatable.stop();
        }
    }

    private void b(Z z) {
        a(z);
        c(z);
    }

    private void c(Z z) {
        if (z instanceof Animatable) {
            this.f6516b = (Animatable) z;
            this.f6516b.start();
            return;
        }
        this.f6516b = null;
    }
}
