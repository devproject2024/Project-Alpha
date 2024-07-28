package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;

public final class n<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final ac<? extends T> f47609a;

    /* renamed from: b  reason: collision with root package name */
    final h<? super Throwable, ? extends T> f47610b;

    /* renamed from: c  reason: collision with root package name */
    final T f47611c;

    public n(ac<? extends T> acVar, h<? super Throwable, ? extends T> hVar, T t) {
        this.f47609a = acVar;
        this.f47610b = hVar;
        this.f47611c = t;
    }

    public final void b(aa<? super T> aaVar) {
        this.f47609a.a(new a(aaVar));
    }

    final class a implements aa<T> {

        /* renamed from: b  reason: collision with root package name */
        private final aa<? super T> f47613b;

        a(aa<? super T> aaVar) {
            this.f47613b = aaVar;
        }

        public final void onError(Throwable th) {
            T t;
            if (n.this.f47610b != null) {
                try {
                    t = n.this.f47610b.apply(th);
                } catch (Throwable th2) {
                    b.b(th2);
                    this.f47613b.onError(new io.reactivex.rxjava3.c.a(th, th2));
                    return;
                }
            } else {
                t = n.this.f47611c;
            }
            if (t == null) {
                NullPointerException nullPointerException = new NullPointerException("Value supplied was null");
                nullPointerException.initCause(th);
                this.f47613b.onError(nullPointerException);
                return;
            }
            this.f47613b.onSuccess(t);
        }

        public final void onSubscribe(c cVar) {
            this.f47613b.onSubscribe(cVar);
        }

        public final void onSuccess(T t) {
            this.f47613b.onSuccess(t);
        }
    }
}
