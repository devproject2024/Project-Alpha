package io.reactivex.rxjava3.e.f.c;

import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.n;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.e.l;

public final class j<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final n<T> f46868a;

    public j(n<T> nVar) {
        this.f46868a = nVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46868a.a(a(wVar));
    }

    public static <T> m<T> a(w<? super T> wVar) {
        return new a(wVar);
    }

    static final class a<T> extends l<T> implements m<T> {
        private static final long serialVersionUID = 7603343402964826922L;
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

        public final void onComplete() {
            complete();
        }

        public final void dispose() {
            super.dispose();
            this.upstream.dispose();
        }
    }
}
