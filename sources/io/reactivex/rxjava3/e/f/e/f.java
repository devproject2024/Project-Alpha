package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.q;

public final class f<T> extends a<T, Boolean> {

    /* renamed from: b  reason: collision with root package name */
    final q<? super T> f47460b;

    public f(u<T> uVar, q<? super T> qVar) {
        super(uVar);
        this.f47460b = qVar;
    }

    public final void subscribeActual(w<? super Boolean> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47460b));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super Boolean> f47461a;

        /* renamed from: b  reason: collision with root package name */
        final q<? super T> f47462b;

        /* renamed from: c  reason: collision with root package name */
        c f47463c;

        /* renamed from: d  reason: collision with root package name */
        boolean f47464d;

        a(w<? super Boolean> wVar, q<? super T> qVar) {
            this.f47461a = wVar;
            this.f47462b = qVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47463c, cVar)) {
                this.f47463c = cVar;
                this.f47461a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.f47464d) {
                try {
                    if (!this.f47462b.test(t)) {
                        this.f47464d = true;
                        this.f47463c.dispose();
                        this.f47461a.onNext(Boolean.FALSE);
                        this.f47461a.onComplete();
                    }
                } catch (Throwable th) {
                    b.b(th);
                    this.f47463c.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47464d) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47464d = true;
            this.f47461a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47464d) {
                this.f47464d = true;
                this.f47461a.onNext(Boolean.TRUE);
                this.f47461a.onComplete();
            }
        }

        public final void dispose() {
            this.f47463c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47463c.isDisposed();
        }
    }
}
