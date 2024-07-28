package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.q;

public final class ch<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final q<? super Throwable> f47162b;

    public ch(u<T> uVar, q<? super Throwable> qVar) {
        super(uVar);
        this.f47162b = qVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47162b));
    }

    public static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47163a;

        /* renamed from: b  reason: collision with root package name */
        final q<? super Throwable> f47164b;

        /* renamed from: c  reason: collision with root package name */
        c f47165c;

        public a(w<? super T> wVar, q<? super Throwable> qVar) {
            this.f47163a = wVar;
            this.f47164b = qVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47165c, cVar)) {
                this.f47165c = cVar;
                this.f47163a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f47163a.onNext(t);
        }

        public final void onError(Throwable th) {
            try {
                if (this.f47164b.test(th)) {
                    this.f47163a.onComplete();
                } else {
                    this.f47163a.onError(th);
                }
            } catch (Throwable th2) {
                b.b(th2);
                this.f47163a.onError(new io.reactivex.rxjava3.c.a(th, th2));
            }
        }

        public final void onComplete() {
            this.f47163a.onComplete();
        }

        public final void dispose() {
            this.f47165c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47165c.isDisposed();
        }
    }
}
