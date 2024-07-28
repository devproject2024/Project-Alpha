package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.y;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.c.e;
import io.reactivex.rxjava3.e.k.j;
import java.util.Collection;

public final class ef<T, U extends Collection<? super T>> extends y<U> implements e<U> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f47394a;

    /* renamed from: b  reason: collision with root package name */
    final r<U> f47395b;

    public ef(u<T> uVar, int i2) {
        this.f47394a = uVar;
        this.f47395b = io.reactivex.rxjava3.e.b.a.a(i2);
    }

    public ef(u<T> uVar, r<U> rVar) {
        this.f47394a = uVar;
        this.f47395b = rVar;
    }

    public final void b(aa<? super U> aaVar) {
        try {
            this.f47394a.subscribe(new a(aaVar, (Collection) j.a(this.f47395b.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            b.b(th);
            d.error(th, (aa<?>) aaVar);
        }
    }

    public final p<U> U_() {
        return io.reactivex.rxjava3.h.a.a(new ee(this.f47394a, this.f47395b));
    }

    static final class a<T, U extends Collection<? super T>> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final aa<? super U> f47396a;

        /* renamed from: b  reason: collision with root package name */
        U f47397b;

        /* renamed from: c  reason: collision with root package name */
        c f47398c;

        a(aa<? super U> aaVar, U u) {
            this.f47396a = aaVar;
            this.f47397b = u;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47398c, cVar)) {
                this.f47398c = cVar;
                this.f47396a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47398c.dispose();
        }

        public final boolean isDisposed() {
            return this.f47398c.isDisposed();
        }

        public final void onNext(T t) {
            this.f47397b.add(t);
        }

        public final void onError(Throwable th) {
            this.f47397b = null;
            this.f47396a.onError(th);
        }

        public final void onComplete() {
            U u = this.f47397b;
            this.f47397b = null;
            this.f47396a.onSuccess(u);
        }
    }
}
