package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.e.c.f;

public abstract class a<T, R> implements w<T>, f<R> {

    /* renamed from: b  reason: collision with root package name */
    protected final w<? super R> f46714b;

    /* renamed from: c  reason: collision with root package name */
    protected c f46715c;

    /* renamed from: d  reason: collision with root package name */
    protected f<T> f46716d;

    /* renamed from: e  reason: collision with root package name */
    protected boolean f46717e;

    /* renamed from: f  reason: collision with root package name */
    protected int f46718f;

    public a(w<? super R> wVar) {
        this.f46714b = wVar;
    }

    public final void onSubscribe(c cVar) {
        if (io.reactivex.rxjava3.e.a.c.validate(this.f46715c, cVar)) {
            this.f46715c = cVar;
            if (cVar instanceof f) {
                this.f46716d = (f) cVar;
            }
            this.f46714b.onSubscribe(this);
        }
    }

    public void onError(Throwable th) {
        if (this.f46717e) {
            io.reactivex.rxjava3.h.a.a(th);
            return;
        }
        this.f46717e = true;
        this.f46714b.onError(th);
    }

    /* access modifiers changed from: protected */
    public final void a(Throwable th) {
        b.b(th);
        this.f46715c.dispose();
        onError(th);
    }

    public void onComplete() {
        if (!this.f46717e) {
            this.f46717e = true;
            this.f46714b.onComplete();
        }
    }

    /* access modifiers changed from: protected */
    public final int a(int i2) {
        f<T> fVar = this.f46716d;
        if (fVar == null || (i2 & 4) != 0) {
            return 0;
        }
        int requestFusion = fVar.requestFusion(i2);
        if (requestFusion != 0) {
            this.f46718f = requestFusion;
        }
        return requestFusion;
    }

    public void dispose() {
        this.f46715c.dispose();
    }

    public boolean isDisposed() {
        return this.f46715c.isDisposed();
    }

    public boolean isEmpty() {
        return this.f46716d.isEmpty();
    }

    public void clear() {
        this.f46716d.clear();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
