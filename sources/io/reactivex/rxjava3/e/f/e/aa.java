package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.c.e;

public final class aa<T> extends y<Long> implements e<Long> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f46901a;

    public aa(u<T> uVar) {
        this.f46901a = uVar;
    }

    public final void b(io.reactivex.rxjava3.a.aa<? super Long> aaVar) {
        this.f46901a.subscribe(new a(aaVar));
    }

    public final p<Long> U_() {
        return io.reactivex.rxjava3.h.a.a(new z(this.f46901a));
    }

    static final class a implements w<Object>, c {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.a.aa<? super Long> f46902a;

        /* renamed from: b  reason: collision with root package name */
        c f46903b;

        /* renamed from: c  reason: collision with root package name */
        long f46904c;

        a(io.reactivex.rxjava3.a.aa<? super Long> aaVar) {
            this.f46902a = aaVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46903b, cVar)) {
                this.f46903b = cVar;
                this.f46902a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f46903b.dispose();
            this.f46903b = io.reactivex.rxjava3.e.a.c.DISPOSED;
        }

        public final boolean isDisposed() {
            return this.f46903b.isDisposed();
        }

        public final void onNext(Object obj) {
            this.f46904c++;
        }

        public final void onError(Throwable th) {
            this.f46903b = io.reactivex.rxjava3.e.a.c.DISPOSED;
            this.f46902a.onError(th);
        }

        public final void onComplete() {
            this.f46903b = io.reactivex.rxjava3.e.a.c.DISPOSED;
            this.f46902a.onSuccess(Long.valueOf(this.f46904c));
        }
    }
}
