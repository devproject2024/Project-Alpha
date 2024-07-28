package com.bumptech.glide.e.b;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.bumptech.glide.e.b.f;

public final class d implements f<Drawable> {

    /* renamed from: a  reason: collision with root package name */
    private final int f6548a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f6549b;

    public final /* synthetic */ boolean a(Object obj, f.a aVar) {
        Drawable drawable = (Drawable) obj;
        Drawable e2 = aVar.e();
        if (e2 == null) {
            e2 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{e2, drawable});
        transitionDrawable.setCrossFadeEnabled(this.f6549b);
        transitionDrawable.startTransition(this.f6548a);
        aVar.d(transitionDrawable);
        return true;
    }

    public d(int i2, boolean z) {
        this.f6548a = i2;
        this.f6549b = z;
    }
}
