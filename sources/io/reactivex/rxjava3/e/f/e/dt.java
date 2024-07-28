package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;

public final class dt<T> extends a<T, T> {
    public dt(u<T> uVar) {
        super(uVar);
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47332a;

        /* renamed from: b  reason: collision with root package name */
        c f47333b;

        /* renamed from: c  reason: collision with root package name */
        T f47334c;

        a(w<? super T> wVar) {
            this.f47332a = wVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47333b, cVar)) {
                this.f47333b = cVar;
                this.f47332a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f47334c = t;
        }

        public final void onError(Throwable th) {
            this.f47334c = null;
            this.f47332a.onError(th);
        }

        public final void dispose() {
            this.f47334c = null;
            this.f47333b.dispose();
        }

        public final boolean isDisposed() {
            return this.f47333b.isDisposed();
        }

        public final void onComplete() {
            T t = this.f47334c;
            if (t != null) {
                this.f47334c = null;
                this.f47332a.onNext(t);
            }
            this.f47332a.onComplete();
        }
    }
}
