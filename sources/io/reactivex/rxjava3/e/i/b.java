package io.reactivex.rxjava3.e.i;

import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.e.c.h;
import io.reactivex.rxjava3.e.j.g;
import io.reactivex.rxjava3.h.a;
import org.a.c;

public abstract class b<T, R> implements k<T>, h<R> {

    /* renamed from: e  reason: collision with root package name */
    protected final org.a.b<? super R> f47722e;

    /* renamed from: f  reason: collision with root package name */
    protected c f47723f;

    /* renamed from: g  reason: collision with root package name */
    protected h<T> f47724g;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f47725h;

    /* renamed from: i  reason: collision with root package name */
    protected int f47726i;

    public b(org.a.b<? super R> bVar) {
        this.f47722e = bVar;
    }

    public final void onSubscribe(c cVar) {
        if (g.validate(this.f47723f, cVar)) {
            this.f47723f = cVar;
            if (cVar instanceof h) {
                this.f47724g = (h) cVar;
            }
            this.f47722e.onSubscribe(this);
        }
    }

    public void onError(Throwable th) {
        if (this.f47725h) {
            a.a(th);
            return;
        }
        this.f47725h = true;
        this.f47722e.onError(th);
    }

    /* access modifiers changed from: protected */
    public final void a(Throwable th) {
        io.reactivex.rxjava3.c.b.b(th);
        this.f47723f.cancel();
        onError(th);
    }

    public void onComplete() {
        if (!this.f47725h) {
            this.f47725h = true;
            this.f47722e.onComplete();
        }
    }

    /* access modifiers changed from: protected */
    public final int a(int i2) {
        h<T> hVar = this.f47724g;
        if (hVar == null || (i2 & 4) != 0) {
            return 0;
        }
        int requestFusion = hVar.requestFusion(i2);
        if (requestFusion != 0) {
            this.f47726i = requestFusion;
        }
        return requestFusion;
    }

    public void request(long j) {
        this.f47723f.request(j);
    }

    public void cancel() {
        this.f47723f.cancel();
    }

    public boolean isEmpty() {
        return this.f47724g.isEmpty();
    }

    public void clear() {
        this.f47724g.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
