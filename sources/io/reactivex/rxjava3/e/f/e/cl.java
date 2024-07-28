package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.a.d;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public final class cl<T, R> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super p<T>, ? extends u<R>> f47178b;

    public cl(u<T> uVar, h<? super p<T>, ? extends u<R>> hVar) {
        super(uVar);
        this.f47178b = hVar;
    }

    public final void subscribeActual(w<? super R> wVar) {
        io.reactivex.rxjava3.j.b a2 = io.reactivex.rxjava3.j.b.a();
        try {
            u uVar = (u) Objects.requireNonNull(this.f47178b.apply(a2), "The selector returned a null ObservableSource");
            b bVar = new b(wVar);
            uVar.subscribe(bVar);
            this.f46900a.subscribe(new a(a2, bVar));
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            d.error(th, (w<?>) wVar);
        }
    }

    static final class a<T> implements w<T> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.j.b<T> f47179a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<c> f47180b;

        a(io.reactivex.rxjava3.j.b<T> bVar, AtomicReference<c> atomicReference) {
            this.f47179a = bVar;
            this.f47180b = atomicReference;
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.f47180b, cVar);
        }

        public final void onNext(T t) {
            this.f47179a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f47179a.onError(th);
        }

        public final void onComplete() {
            this.f47179a.onComplete();
        }
    }

    static final class b<R> extends AtomicReference<c> implements w<R>, c {
        private static final long serialVersionUID = 854110278590336484L;
        final w<? super R> downstream;
        c upstream;

        b(w<? super R> wVar) {
            this.downstream = wVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(R r) {
            this.downstream.onNext(r);
        }

        public final void onError(Throwable th) {
            io.reactivex.rxjava3.e.a.c.dispose(this);
            this.downstream.onError(th);
        }

        public final void onComplete() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
            this.downstream.onComplete();
        }

        public final void dispose() {
            this.upstream.dispose();
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return this.upstream.isDisposed();
        }
    }
}
