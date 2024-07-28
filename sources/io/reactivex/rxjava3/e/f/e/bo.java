package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;

public final class bo<T> extends a<T, T> {
    public bo(u<T> uVar) {
        super(uVar);
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47080a;

        /* renamed from: b  reason: collision with root package name */
        c f47081b;

        a(w<? super T> wVar) {
            this.f47080a = wVar;
        }

        public final void dispose() {
            this.f47081b.dispose();
        }

        public final boolean isDisposed() {
            return this.f47081b.isDisposed();
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47081b, cVar)) {
                this.f47081b = cVar;
                this.f47080a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f47080a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f47080a.onError(th);
        }

        public final void onComplete() {
            this.f47080a.onComplete();
        }
    }
}
