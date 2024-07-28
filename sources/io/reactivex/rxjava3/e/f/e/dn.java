package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.q;

public final class dn<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final q<? super T> f47310b;

    public dn(u<T> uVar, q<? super T> qVar) {
        super(uVar);
        this.f47310b = qVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47310b));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47311a;

        /* renamed from: b  reason: collision with root package name */
        final q<? super T> f47312b;

        /* renamed from: c  reason: collision with root package name */
        c f47313c;

        /* renamed from: d  reason: collision with root package name */
        boolean f47314d;

        a(w<? super T> wVar, q<? super T> qVar) {
            this.f47311a = wVar;
            this.f47312b = qVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47313c, cVar)) {
                this.f47313c = cVar;
                this.f47311a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47313c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47313c.isDisposed();
        }

        public final void onNext(T t) {
            if (this.f47314d) {
                this.f47311a.onNext(t);
                return;
            }
            try {
                if (!this.f47312b.test(t)) {
                    this.f47314d = true;
                    this.f47311a.onNext(t);
                }
            } catch (Throwable th) {
                b.b(th);
                this.f47313c.dispose();
                this.f47311a.onError(th);
            }
        }

        public final void onError(Throwable th) {
            this.f47311a.onError(th);
        }

        public final void onComplete() {
            this.f47311a.onComplete();
        }
    }
}
