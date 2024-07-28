package com.bumptech.glide.e.b;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.e.b.f;

public final class i<R> implements f<R> {

    /* renamed from: a  reason: collision with root package name */
    private final a f6555a;

    interface a {
        Animation a(Context context);
    }

    i(a aVar) {
        this.f6555a = aVar;
    }

    public final boolean a(R r, f.a aVar) {
        View f2 = aVar.f();
        if (f2 == null) {
            return false;
        }
        f2.clearAnimation();
        f2.startAnimation(this.f6555a.a(f2.getContext()));
        return false;
    }
}
