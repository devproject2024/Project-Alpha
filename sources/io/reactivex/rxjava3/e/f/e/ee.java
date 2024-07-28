package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.k.j;
import java.util.Collection;

public final class ee<T, U extends Collection<? super T>> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final r<U> f47390b;

    public ee(u<T> uVar, r<U> rVar) {
        super(uVar);
        this.f47390b = rVar;
    }

    public final void subscribeActual(w<? super U> wVar) {
        try {
            this.f46900a.subscribe(new a(wVar, (Collection) j.a(this.f47390b.get(), "The collectionSupplier returned a null Collection.")));
        } catch (Throwable th) {
            b.b(th);
            d.error(th, (w<?>) wVar);
        }
    }

    static final class a<T, U extends Collection<? super T>> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super U> f47391a;

        /* renamed from: b  reason: collision with root package name */
        c f47392b;

        /* renamed from: c  reason: collision with root package name */
        U f47393c;

        a(w<? super U> wVar, U u) {
            this.f47391a = wVar;
            this.f47393c = u;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47392b, cVar)) {
                this.f47392b = cVar;
                this.f47391a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47392b.dispose();
        }

        public final boolean isDisposed() {
            return this.f47392b.isDisposed();
        }

        public final void onNext(T t) {
            this.f47393c.add(t);
        }

        public final void onError(Throwable th) {
            this.f47393c = null;
            this.f47391a.onError(th);
        }

        public final void onComplete() {
            U u = this.f47393c;
            this.f47393c = null;
            this.f47391a.onNext(u);
            this.f47391a.onComplete();
        }
    }
}
