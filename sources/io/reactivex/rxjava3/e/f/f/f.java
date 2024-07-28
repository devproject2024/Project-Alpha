package io.reactivex.rxjava3.e.f.f;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.g;
import io.reactivex.rxjava3.e.a.d;

public final class f<T> extends y<T> {

    /* renamed from: a  reason: collision with root package name */
    final ac<T> f47590a;

    /* renamed from: b  reason: collision with root package name */
    final g<? super c> f47591b;

    public f(ac<T> acVar, g<? super c> gVar) {
        this.f47590a = acVar;
        this.f47591b = gVar;
    }

    public final void b(aa<? super T> aaVar) {
        this.f47590a.a(new a(aaVar, this.f47591b));
    }

    static final class a<T> implements aa<T> {

        /* renamed from: a  reason: collision with root package name */
        final aa<? super T> f47592a;

        /* renamed from: b  reason: collision with root package name */
        final g<? super c> f47593b;

        /* renamed from: c  reason: collision with root package name */
        boolean f47594c;

        a(aa<? super T> aaVar, g<? super c> gVar) {
            this.f47592a = aaVar;
            this.f47593b = gVar;
        }

        public final void onSubscribe(c cVar) {
            try {
                this.f47593b.accept(cVar);
                this.f47592a.onSubscribe(cVar);
            } catch (Throwable th) {
                b.b(th);
                this.f47594c = true;
                cVar.dispose();
                d.error(th, (aa<?>) this.f47592a);
            }
        }

        public final void onSuccess(T t) {
            if (!this.f47594c) {
                this.f47592a.onSuccess(t);
            }
        }

        public final void onError(Throwable th) {
            if (this.f47594c) {
                io.reactivex.rxjava3.h.a.a(th);
            } else {
                this.f47592a.onError(th);
            }
        }
    }
}
