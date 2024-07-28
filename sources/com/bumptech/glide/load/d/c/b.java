package com.bumptech.glide.load.d.c;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.r;
import com.bumptech.glide.load.b.v;
import com.bumptech.glide.load.d.e.c;

public abstract class b<T extends Drawable> implements r, v<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f7202a;

    public b(T t) {
        this.f7202a = (Drawable) j.a(t, "Argument must not be null");
    }

    public void e() {
        T t = this.f7202a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof c) {
            ((c) t).a().prepareToDraw();
        }
    }

    public final /* synthetic */ Object b() {
        Drawable.ConstantState constantState = this.f7202a.getConstantState();
        if (constantState == null) {
            return this.f7202a;
        }
        return constantState.newDrawable();
    }
}
