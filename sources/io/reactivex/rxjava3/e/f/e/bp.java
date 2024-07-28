package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;

public final class bp<T> extends a<T, T> {
    public bp(u<T> uVar) {
        super(uVar);
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47082a;

        /* renamed from: b  reason: collision with root package name */
        c f47083b;

        public final void onNext(T t) {
        }

        a(w<? super T> wVar) {
            this.f47082a = wVar;
        }

        public final void onSubscribe(c cVar) {
            this.f47083b = cVar;
            this.f47082a.onSubscribe(this);
        }

        public final void onError(Throwable th) {
            this.f47082a.onError(th);
        }

        public final void onComplete() {
            this.f47082a.onComplete();
        }

        public final void dispose() {
            this.f47083b.dispose();
        }

        public final boolean isDisposed() {
            return this.f47083b.isDisposed();
        }
    }
}
