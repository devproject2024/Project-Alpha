package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.e.l;

public final class q<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final ac<? extends T> f47617a;

    public q(ac<? extends T> acVar) {
        this.f47617a = acVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f47617a.a(a(wVar));
    }

    public static <T> aa<T> a(w<? super T> wVar) {
        return new a(wVar);
    }

    static final class a<T> extends l<T> implements aa<T> {
        private static final long serialVersionUID = 3786543492451018833L;
        c upstream;

        a(w<? super T> wVar) {
            super(wVar);
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            complete(t);
        }

        public final void onError(Throwable th) {
            error(th);
        }

        public final void dispose() {
            super.dispose();
            this.upstream.dispose();
        }
    }
}
