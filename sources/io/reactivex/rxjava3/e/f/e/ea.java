package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.i.b;
import java.util.concurrent.TimeUnit;

public final class ea<T> extends a<T, b<T>> {

    /* renamed from: b  reason: collision with root package name */
    final x f47369b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f47370c;

    public ea(u<T> uVar, TimeUnit timeUnit, x xVar) {
        super(uVar);
        this.f47369b = xVar;
        this.f47370c = timeUnit;
    }

    public final void subscribeActual(w<? super b<T>> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47370c, this.f47369b));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super b<T>> f47371a;

        /* renamed from: b  reason: collision with root package name */
        final TimeUnit f47372b;

        /* renamed from: c  reason: collision with root package name */
        final x f47373c;

        /* renamed from: d  reason: collision with root package name */
        long f47374d;

        /* renamed from: e  reason: collision with root package name */
        c f47375e;

        a(w<? super b<T>> wVar, TimeUnit timeUnit, x xVar) {
            this.f47371a = wVar;
            this.f47373c = xVar;
            this.f47372b = timeUnit;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47375e, cVar)) {
                this.f47375e = cVar;
                this.f47374d = x.a(this.f47372b);
                this.f47371a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47375e.dispose();
        }

        public final boolean isDisposed() {
            return this.f47375e.isDisposed();
        }

        public final void onNext(T t) {
            long a2 = x.a(this.f47372b);
            long j = this.f47374d;
            this.f47374d = a2;
            this.f47371a.onNext(new b(t, a2 - j, this.f47372b));
        }

        public final void onError(Throwable th) {
            this.f47371a.onError(th);
        }

        public final void onComplete() {
            this.f47371a.onComplete();
        }
    }
}
