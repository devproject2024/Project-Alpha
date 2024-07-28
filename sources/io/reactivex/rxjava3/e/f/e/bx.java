package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import java.util.NoSuchElementException;

public final class bx<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47132a;

    /* renamed from: b  reason: collision with root package name */
    final T f47133b;

    public bx(u<T> uVar, T t) {
        this.f47132a = uVar;
        this.f47133b = t;
    }

    public final void b(aa<? super T> aaVar) {
        this.f47132a.subscribe(new a(aaVar, this.f47133b));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final aa<? super T> f47134a;

        /* renamed from: b  reason: collision with root package name */
        final T f47135b;

        /* renamed from: c  reason: collision with root package name */
        c f47136c;

        /* renamed from: d  reason: collision with root package name */
        T f47137d;

        a(aa<? super T> aaVar, T t) {
            this.f47134a = aaVar;
            this.f47135b = t;
        }

        public final void dispose() {
            this.f47136c.dispose();
            this.f47136c = io.reactivex.rxjava3.e.a.c.DISPOSED;
        }

        public final boolean isDisposed() {
            return this.f47136c == io.reactivex.rxjava3.e.a.c.DISPOSED;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47136c, cVar)) {
                this.f47136c = cVar;
                this.f47134a.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.f47137d = t;
        }

        public final void onError(Throwable th) {
            this.f47136c = io.reactivex.rxjava3.e.a.c.DISPOSED;
            this.f47137d = null;
            this.f47134a.onError(th);
        }

        public final void onComplete() {
            this.f47136c = io.reactivex.rxjava3.e.a.c.DISPOSED;
            T t = this.f47137d;
            if (t != null) {
                this.f47137d = null;
                this.f47134a.onSuccess(t);
                return;
            }
            T t2 = this.f47135b;
            if (t2 != null) {
                this.f47134a.onSuccess(t2);
            } else {
                this.f47134a.onError(new NoSuchElementException());
            }
        }
    }
}
