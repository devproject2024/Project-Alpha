package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.l;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;

public final class bw<T> extends l<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47128a;

    public bw(u<T> uVar) {
        this.f47128a = uVar;
    }

    public final void b(m<? super T> mVar) {
        this.f47128a.subscribe(new a(mVar));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final m<? super T> f47129a;

        /* renamed from: b  reason: collision with root package name */
        c f47130b;

        /* renamed from: c  reason: collision with root package name */
        T f47131c;

        a(m<? super T> mVar) {
            this.f47129a = mVar;
        }

        public final void dispose() {
            this.f47130b.dispose();
            this.f47130b = io.reactivex.rxjava3.e.a.c.DISPOSED;
        }

        public final boolean isDisposed() {
            return this.f47130b == io.reactivex.rxjava3.e.a.c.DISPOSED;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47130b, cVar)) {
                this.f47130b = cVar;
                this.f47129a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f47131c = t;
        }

        public final void onError(Throwable th) {
            this.f47130b = io.reactivex.rxjava3.e.a.c.DISPOSED;
            this.f47131c = null;
            this.f47129a.onError(th);
        }

        public final void onComplete() {
            this.f47130b = io.reactivex.rxjava3.e.a.c.DISPOSED;
            T t = this.f47131c;
            if (t != null) {
                this.f47131c = null;
                this.f47129a.onSuccess(t);
                return;
            }
            this.f47129a.onComplete();
        }
    }
}
