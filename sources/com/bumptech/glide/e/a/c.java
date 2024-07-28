package com.bumptech.glide.e.a;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.e.d;
import com.bumptech.glide.g.k;

public abstract class c<T> implements j<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f6513a;

    /* renamed from: b  reason: collision with root package name */
    private final int f6514b;

    /* renamed from: c  reason: collision with root package name */
    private d f6515c;

    public final void a() {
    }

    public final void b() {
    }

    public final void b(Drawable drawable) {
    }

    public final void b(i iVar) {
    }

    public final void c() {
    }

    public final void c(Drawable drawable) {
    }

    public c() {
        this((byte) 0);
    }

    public c(byte b2) {
        if (k.a(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            this.f6513a = Integer.MIN_VALUE;
            this.f6514b = Integer.MIN_VALUE;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
    }

    public final void a(i iVar) {
        iVar.a(this.f6513a, this.f6514b);
    }

    public final void a(d dVar) {
        this.f6515c = dVar;
    }

    public final d d() {
        return this.f6515c;
    }
}
