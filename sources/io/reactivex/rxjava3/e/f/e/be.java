package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;

public final class be<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final f f47042a;

    public be(f fVar) {
        this.f47042a = fVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f47042a.a(new a(wVar));
    }

    public static final class a<T> extends io.reactivex.rxjava3.e.c.a<T> implements d {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47043a;

        /* renamed from: b  reason: collision with root package name */
        c f47044b;

        public a(w<? super T> wVar) {
            this.f47043a = wVar;
        }

        public final void dispose() {
            this.f47044b.dispose();
            this.f47044b = io.reactivex.rxjava3.e.a.c.DISPOSED;
        }

        public final boolean isDisposed() {
            return this.f47044b.isDisposed();
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47044b, cVar)) {
                this.f47044b = cVar;
                this.f47043a.onSubscribe(this);
            }
        }

        public final void onComplete() {
            this.f47044b = io.reactivex.rxjava3.e.a.c.DISPOSED;
            this.f47043a.onComplete();
        }

        public final void onError(Throwable th) {
            this.f47044b = io.reactivex.rxjava3.e.a.c.DISPOSED;
            this.f47043a.onError(th);
        }
    }
}
