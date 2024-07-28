package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.q;

public final class i<T> extends a<T, Boolean> {

    /* renamed from: b  reason: collision with root package name */
    final q<? super T> f47476b;

    public i(u<T> uVar, q<? super T> qVar) {
        super(uVar);
        this.f47476b = qVar;
    }

    public final void subscribeActual(w<? super Boolean> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47476b));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super Boolean> f47477a;

        /* renamed from: b  reason: collision with root package name */
        final q<? super T> f47478b;

        /* renamed from: c  reason: collision with root package name */
        c f47479c;

        /* renamed from: d  reason: collision with root package name */
        boolean f47480d;

        a(w<? super Boolean> wVar, q<? super T> qVar) {
            this.f47477a = wVar;
            this.f47478b = qVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47479c, cVar)) {
                this.f47479c = cVar;
                this.f47477a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f47480d) {
                try {
                    if (this.f47478b.test(t)) {
                        this.f47480d = true;
                        this.f47479c.dispose();
                        this.f47477a.onNext(Boolean.TRUE);
                        this.f47477a.onComplete();
                    }
                } catch (Throwable th) {
                    b.b(th);
                    this.f47479c.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47480d) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47480d = true;
            this.f47477a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47480d) {
                this.f47480d = true;
                this.f47477a.onNext(Boolean.FALSE);
                this.f47477a.onComplete();
            }
        }

        public final void dispose() {
            this.f47479c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47479c.isDisposed();
        }
    }
}
