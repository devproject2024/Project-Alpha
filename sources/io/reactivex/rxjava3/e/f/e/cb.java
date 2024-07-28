package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.o;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;

public final class cb<T> extends a<T, o<T>> {
    public cb(u<T> uVar) {
        super(uVar);
    }

    public final void subscribeActual(w<? super o<T>> wVar) {
        this.f46900a.subscribe(new a(wVar));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super o<T>> f47153a;

        /* renamed from: b  reason: collision with root package name */
        c f47154b;

        a(w<? super o<T>> wVar) {
            this.f47153a = wVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47154b, cVar)) {
                this.f47154b = cVar;
                this.f47153a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47154b.dispose();
        }

        public final boolean isDisposed() {
            return this.f47154b.isDisposed();
        }

        public final void onNext(T t) {
            this.f47153a.onNext(o.a(t));
        }

        public final void onError(Throwable th) {
            this.f47153a.onNext(o.a(th));
            this.f47153a.onComplete();
        }

        public final void onComplete() {
            this.f47153a.onNext(o.e());
            this.f47153a.onComplete();
        }
    }
}
