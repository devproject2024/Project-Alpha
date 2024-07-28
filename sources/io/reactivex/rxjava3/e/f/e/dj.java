package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;

public final class dj<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f47289b;

    public dj(u<T> uVar, long j) {
        super(uVar);
        this.f47289b = j;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47289b));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47290a;

        /* renamed from: b  reason: collision with root package name */
        long f47291b;

        /* renamed from: c  reason: collision with root package name */
        c f47292c;

        a(w<? super T> wVar, long j) {
            this.f47290a = wVar;
            this.f47291b = j;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47292c, cVar)) {
                this.f47292c = cVar;
                this.f47290a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            long j = this.f47291b;
            if (j != 0) {
                this.f47291b = j - 1;
            } else {
                this.f47290a.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            this.f47290a.onError(th);
        }

        public final void onComplete() {
            this.f47290a.onComplete();
        }

        public final void dispose() {
            this.f47292c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47292c.isDisposed();
        }
    }
}
