package com.bumptech.glide.load.b.a;

import com.bumptech.glide.g.k;
import com.bumptech.glide.load.b.a.m;
import java.util.Queue;

abstract class d<T extends m> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f6737a = k.a(20);

    /* access modifiers changed from: package-private */
    public abstract T a();

    d() {
    }

    /* access modifiers changed from: package-private */
    public final T b() {
        T t = (m) this.f6737a.poll();
        return t == null ? a() : t;
    }

    public final void a(T t) {
        if (this.f6737a.size() < 20) {
            this.f6737a.offer(t);
        }
    }
}
