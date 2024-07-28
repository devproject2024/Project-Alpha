package io.reactivex.rxjava3.e.i;

import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.e.c.c;
import io.reactivex.rxjava3.e.c.h;
import io.reactivex.rxjava3.e.j.g;

public abstract class a<T, R> implements c<T>, h<R> {

    /* renamed from: e  reason: collision with root package name */
    protected final c<? super R> f47717e;

    /* renamed from: f  reason: collision with root package name */
    protected org.a.c f47718f;

    /* renamed from: g  reason: collision with root package name */
    protected h<T> f47719g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f47720h;

    /* renamed from: i  reason: collision with root package name */
    protected int f47721i;

    public a(c<? super R> cVar) {
        this.f47717e = cVar;
    }

    public final void onSubscribe(org.a.c cVar) {
        if (g.validate(this.f47718f, cVar)) {
            this.f47718f = cVar;
            if (cVar instanceof h) {
                this.f47719g = (h) cVar;
            }
            this.f47717e.onSubscribe(this);
        }
    }

    public void onError(Throwable th) {
        if (this.f47720h) {
            io.reactivex.rxjava3.h.a.a(th);
            return;
        }
        this.f47720h = true;
        this.f47717e.onError(th);
    }

    /* access modifiers changed from: protected */
    public final void a(Throwable th) {
        b.b(th);
        this.f47718f.cancel();
        onError(th);
    }

    public void onComplete() {
        if (!this.f47720h) {
            this.f47720h = true;
            this.f47717e.onComplete();
        }
    }

    /* access modifiers changed from: protected */
    public final int a(int i2) {
        h<T> hVar = this.f47719g;
        if (hVar == null || (i2 & 4) != 0) {
            return 0;
        }
        int requestFusion = hVar.requestFusion(i2);
        if (requestFusion != 0) {
            this.f47721i = requestFusion;
        }
        return requestFusion;
    }

    public void request(long j) {
        this.f47718f.request(j);
    }

    public void cancel() {
        this.f47718f.cancel();
    }

    public boolean isEmpty() {
        return this.f47719g.isEmpty();
    }

    public void clear() {
        this.f47719g.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
