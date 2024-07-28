package io.reactivex.rxjava3.e.f.c;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.n;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.q;

public final class g<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final q<? super Throwable> f46857b;

    public g(n<T> nVar, q<? super Throwable> qVar) {
        super(nVar);
        this.f46857b = qVar;
    }

    public final void b(m<? super T> mVar) {
        this.f46848a.a(new a(mVar, this.f46857b));
    }

    public static final class a<T> implements aa<T>, m<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final m<? super T> f46858a;

        /* renamed from: b  reason: collision with root package name */
        final q<? super Throwable> f46859b;

        /* renamed from: c  reason: collision with root package name */
        c f46860c;

        public a(m<? super T> mVar, q<? super Throwable> qVar) {
            this.f46858a = mVar;
            this.f46859b = qVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46860c, cVar)) {
                this.f46860c = cVar;
                this.f46858a.onSubscribe(this);
            }
        }

        public final void onSuccess(T t) {
            this.f46858a.onSuccess(t);
        }

        public final void onError(Throwable th) {
            try {
                if (this.f46859b.test(th)) {
                    this.f46858a.onComplete();
                } else {
                    this.f46858a.onError(th);
                }
            } catch (Throwable th2) {
                b.b(th2);
                this.f46858a.onError(new io.reactivex.rxjava3.c.a(th, th2));
            }
        }

        public final void onComplete() {
            this.f46858a.onComplete();
        }

        public final void dispose() {
            this.f46860c.dispose();
        }

        public final boolean isDisposed() {
            return this.f46860c.isDisposed();
        }
    }
}
