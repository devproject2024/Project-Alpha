package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

final class o implements p {

    /* renamed from: a  reason: collision with root package name */
    private final ViewOverlay f36498a;

    o(View view) {
        this.f36498a = view.getOverlay();
    }

    public final void a(Drawable drawable) {
        this.f36498a.add(drawable);
    }

    public final void b(Drawable drawable) {
        this.f36498a.remove(drawable);
    }
}
