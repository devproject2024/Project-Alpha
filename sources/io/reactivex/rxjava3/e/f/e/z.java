package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;

public final class z<T> extends a<T, Long> {
    public z(u<T> uVar) {
        super(uVar);
    }

    public final void subscribeActual(w<? super Long> wVar) {
        this.f46900a.subscribe(new a(wVar));
    }

    static final class a implements w<Object>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super Long> f47569a;

        /* renamed from: b  reason: collision with root package name */
        c f47570b;

        /* renamed from: c  reason: collision with root package name */
        long f47571c;

        a(w<? super Long> wVar) {
            this.f47569a = wVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47570b, cVar)) {
                this.f47570b = cVar;
                this.f47569a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47570b.dispose();
        }

        public final boolean isDisposed() {
            return this.f47570b.isDisposed();
        }

        public final void onNext(Object obj) {
            this.f47571c++;
        }

        public final void onError(Throwable th) {
            this.f47569a.onError(th);
        }

        public final void onComplete() {
            this.f47569a.onNext(Long.valueOf(this.f47571c));
            this.f47569a.onComplete();
        }
    }
}
