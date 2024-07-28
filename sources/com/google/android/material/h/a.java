package com.google.android.material.h;

import android.graphics.Typeface;

public final class a extends f {

    /* renamed from: a  reason: collision with root package name */
    public boolean f36359a;

    /* renamed from: b  reason: collision with root package name */
    private final Typeface f36360b;

    /* renamed from: c  reason: collision with root package name */
    private final C0606a f36361c;

    /* renamed from: com.google.android.material.h.a$a  reason: collision with other inner class name */
    public interface C0606a {
        void a(Typeface typeface);
    }

    public a(C0606a aVar, Typeface typeface) {
        this.f36360b = typeface;
        this.f36361c = aVar;
    }

    public final void a(Typeface typeface, boolean z) {
        a(typeface);
    }

    public final void a(int i2) {
        a(this.f36360b);
    }

    private void a(Typeface typeface) {
        if (!this.f36359a) {
            this.f36361c.a(typeface);
        }
    }
}
