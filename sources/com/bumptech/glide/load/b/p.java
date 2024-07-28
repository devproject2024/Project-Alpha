package com.bumptech.glide.load.b;

import com.bumptech.glide.g.j;
import com.bumptech.glide.load.g;

final class p<Z> implements v<Z> {

    /* renamed from: a  reason: collision with root package name */
    final boolean f6930a;

    /* renamed from: b  reason: collision with root package name */
    final v<Z> f6931b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f6932c;

    /* renamed from: d  reason: collision with root package name */
    private final a f6933d;

    /* renamed from: e  reason: collision with root package name */
    private final g f6934e;

    /* renamed from: f  reason: collision with root package name */
    private int f6935f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6936g;

    interface a {
        void a(g gVar, p<?> pVar);
    }

    p(v<Z> vVar, boolean z, boolean z2, g gVar, a aVar) {
        this.f6931b = (v) j.a(vVar, "Argument must not be null");
        this.f6930a = z;
        this.f6932c = z2;
        this.f6934e = gVar;
        this.f6933d = (a) j.a(aVar, "Argument must not be null");
    }

    public final Class<Z> a() {
        return this.f6931b.a();
    }

    public final Z b() {
        return this.f6931b.b();
    }

    public final int c() {
        return this.f6931b.c();
    }

    public final synchronized void d() {
        if (this.f6935f > 0) {
            throw new IllegalStateException("Cannot recycle a resource while it is still acquired");
        } else if (!this.f6936g) {
            this.f6936g = true;
            if (this.f6932c) {
                this.f6931b.d();
            }
        } else {
            throw new IllegalStateException("Cannot recycle a resource that has already been recycled");
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void e() {
        if (!this.f6936g) {
            this.f6935f++;
        } else {
            throw new IllegalStateException("Cannot acquire a recycled resource");
        }
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        boolean z;
        synchronized (this) {
            if (this.f6935f > 0) {
                z = true;
                int i2 = this.f6935f - 1;
                this.f6935f = i2;
                if (i2 != 0) {
                    z = false;
                }
            } else {
                throw new IllegalStateException("Cannot release a recycled or not yet acquired resource");
            }
        }
        if (z) {
            this.f6933d.a(this.f6934e, this);
        }
    }

    public final synchronized String toString() {
        return "EngineResource{isMemoryCacheable=" + this.f6930a + ", listener=" + this.f6933d + ", key=" + this.f6934e + ", acquired=" + this.f6935f + ", isRecycled=" + this.f6936g + ", resource=" + this.f6931b + '}';
    }
}
