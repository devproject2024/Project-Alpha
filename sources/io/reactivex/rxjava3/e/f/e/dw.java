package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.q;

public final class dw<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final q<? super T> f47342b;

    public dw(u<T> uVar, q<? super T> qVar) {
        super(uVar);
        this.f47342b = qVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47342b));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47343a;

        /* renamed from: b  reason: collision with root package name */
        final q<? super T> f47344b;

        /* renamed from: c  reason: collision with root package name */
        c f47345c;

        /* renamed from: d  reason: collision with root package name */
        boolean f47346d;

        a(w<? super T> wVar, q<? super T> qVar) {
            this.f47343a = wVar;
            this.f47344b = qVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47345c, cVar)) {
                this.f47345c = cVar;
                this.f47343a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47345c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47345c.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f47346d) {
                this.f47343a.onNext(t);
                try {
                    if (this.f47344b.test(t)) {
                        this.f47346d = true;
                        this.f47345c.dispose();
                        this.f47343a.onComplete();
                    }
                } catch (Throwable th) {
                    b.b(th);
                    this.f47345c.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (!this.f47346d) {
                this.f47346d = true;
                this.f47343a.onError(th);
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void onComplete() {
            if (!this.f47346d) {
                this.f47346d = true;
                this.f47343a.onComplete();
            }
        }
    }
}
