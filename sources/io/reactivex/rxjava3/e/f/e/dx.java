package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.q;

public final class dx<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final q<? super T> f47347b;

    public dx(u<T> uVar, q<? super T> qVar) {
        super(uVar);
        this.f47347b = qVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47347b));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47348a;

        /* renamed from: b  reason: collision with root package name */
        final q<? super T> f47349b;

        /* renamed from: c  reason: collision with root package name */
        c f47350c;

        /* renamed from: d  reason: collision with root package name */
        boolean f47351d;

        a(w<? super T> wVar, q<? super T> qVar) {
            this.f47348a = wVar;
            this.f47349b = qVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47350c, cVar)) {
                this.f47350c = cVar;
                this.f47348a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47350c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47350c.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f47351d) {
                try {
                    if (!this.f47349b.test(t)) {
                        this.f47351d = true;
                        this.f47350c.dispose();
                        this.f47348a.onComplete();
                        return;
                    }
                    this.f47348a.onNext(t);
                } catch (Throwable th) {
                    b.b(th);
                    this.f47350c.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47351d) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47351d = true;
            this.f47348a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47351d) {
                this.f47351d = true;
                this.f47348a.onComplete();
            }
        }
    }
}
