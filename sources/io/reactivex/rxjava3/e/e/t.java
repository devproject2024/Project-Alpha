package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.c.j;
import io.reactivex.rxjava3.e.k.n;
import io.reactivex.rxjava3.e.k.q;

public abstract class t<T, U, V> extends v implements w<T>, n<U, V> {

    /* renamed from: a  reason: collision with root package name */
    protected final w<? super V> f46734a;

    /* renamed from: b  reason: collision with root package name */
    protected final j<U> f46735b;

    /* renamed from: c  reason: collision with root package name */
    protected volatile boolean f46736c;

    /* renamed from: d  reason: collision with root package name */
    protected volatile boolean f46737d;

    /* renamed from: e  reason: collision with root package name */
    protected Throwable f46738e;

    public void a(w<? super V> wVar, U u) {
    }

    public t(w<? super V> wVar, j<U> jVar) {
        this.f46734a = wVar;
        this.f46735b = jVar;
    }

    public final boolean a() {
        return this.f46736c;
    }

    public final boolean b() {
        return this.f46737d;
    }

    public final boolean c() {
        return this.f46739f.getAndIncrement() == 0;
    }

    /* access modifiers changed from: protected */
    public final void a(U u, c cVar) {
        w<? super V> wVar = this.f46734a;
        j<U> jVar = this.f46735b;
        if (this.f46739f.get() != 0 || !this.f46739f.compareAndSet(0, 1)) {
            jVar.offer(u);
            if (!c()) {
                return;
            }
        } else {
            a(wVar, u);
            if (a(-1) == 0) {
                return;
            }
        }
        q.a(jVar, wVar, cVar, this);
    }

    public final void b(U u, c cVar) {
        w<? super V> wVar = this.f46734a;
        j<U> jVar = this.f46735b;
        if (this.f46739f.get() != 0 || !this.f46739f.compareAndSet(0, 1)) {
            jVar.offer(u);
            if (!c()) {
                return;
            }
        } else if (jVar.isEmpty()) {
            a(wVar, u);
            if (a(-1) == 0) {
                return;
            }
        } else {
            jVar.offer(u);
        }
        q.a(jVar, wVar, cVar, this);
    }

    public final Throwable d() {
        return this.f46738e;
    }

    public final int a(int i2) {
        return this.f46739f.addAndGet(i2);
    }
}
