package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.j.g;

public final class bh<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final org.a.a<? extends T> f47055a;

    public bh(org.a.a<? extends T> aVar) {
        this.f47055a = aVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f47055a.a(new a(wVar));
    }

    static final class a<T> implements k<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47056a;

        /* renamed from: b  reason: collision with root package name */
        org.a.c f47057b;

        a(w<? super T> wVar) {
            this.f47056a = wVar;
        }

        public final void onComplete() {
            this.f47056a.onComplete();
        }

        public final void onError(Throwable th) {
            this.f47056a.onError(th);
        }

        public final void onNext(T t) {
            this.f47056a.onNext(t);
        }

        public final void onSubscribe(org.a.c cVar) {
            if (g.validate(this.f47057b, cVar)) {
                this.f47057b = cVar;
                this.f47056a.onSubscribe(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        public final void dispose() {
            this.f47057b.cancel();
            this.f47057b = g.CANCELLED;
        }

        public final boolean isDisposed() {
            return this.f47057b == g.CANCELLED;
        }
    }
}
