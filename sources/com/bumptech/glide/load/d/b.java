package com.bumptech.glide.load.d;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.v;

public class b<T> implements v<T> {

    /* renamed from: a  reason: collision with root package name */
    protected final T f7197a;

    public final int c() {
        return 1;
    }

    public final void d() {
    }

    public b(T t) {
        this.f7197a = j.a(t, "Argument must not be null");
    }

    public final Class<T> a() {
        return this.f7197a.getClass();
    }

    public final T b() {
        return this.f7197a;
    }
}
