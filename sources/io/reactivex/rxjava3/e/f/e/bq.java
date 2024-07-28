package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.b;
import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.c.e;

public final class bq<T> extends b implements e<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47084a;

    public bq(u<T> uVar) {
        this.f47084a = uVar;
    }

    public final void b(d dVar) {
        this.f47084a.subscribe(new a(dVar));
    }

    public final p<T> U_() {
        return io.reactivex.rxjava3.h.a.a(new bp(this.f47084a));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final d f47085a;

        /* renamed from: b  reason: collision with root package name */
        c f47086b;

        public final void onNext(T t) {
        }

        a(d dVar) {
            this.f47085a = dVar;
        }

        public final void onSubscribe(c cVar) {
            this.f47086b = cVar;
            this.f47085a.onSubscribe(this);
        }

        public final void onError(Throwable th) {
            this.f47085a.onError(th);
        }

        public final void onComplete() {
            this.f47085a.onComplete();
        }

        public final void dispose() {
            this.f47086b.dispose();
        }

        public final boolean isDisposed() {
            return this.f47086b.isDisposed();
        }
    }
}
