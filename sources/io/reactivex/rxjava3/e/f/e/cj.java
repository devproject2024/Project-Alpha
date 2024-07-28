package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;

public final class cj<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super Throwable, ? extends T> f47172b;

    public cj(u<T> uVar, h<? super Throwable, ? extends T> hVar) {
        super(uVar);
        this.f47172b = hVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47172b));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47173a;

        /* renamed from: b  reason: collision with root package name */
        final h<? super Throwable, ? extends T> f47174b;

        /* renamed from: c  reason: collision with root package name */
        c f47175c;

        a(w<? super T> wVar, h<? super Throwable, ? extends T> hVar) {
            this.f47173a = wVar;
            this.f47174b = hVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47175c, cVar)) {
                this.f47175c = cVar;
                this.f47173a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47175c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47175c.isDisposed();
        }

        public final void onNext(T t) {
            this.f47173a.onNext(t);
        }

        public final void onError(Throwable th) {
            try {
                Object apply = this.f47174b.apply(th);
                if (apply == null) {
                    NullPointerException nullPointerException = new NullPointerException("The supplied value is null");
                    nullPointerException.initCause(th);
                    this.f47173a.onError(nullPointerException);
                    return;
                }
                this.f47173a.onNext(apply);
                this.f47173a.onComplete();
            } catch (Throwable th2) {
                b.b(th2);
                this.f47173a.onError(new io.reactivex.rxjava3.c.a(th, th2));
            }
        }

        public final void onComplete() {
            this.f47173a.onComplete();
        }
    }
}
