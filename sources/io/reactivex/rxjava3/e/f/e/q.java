package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.b;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import java.util.Objects;

public final class q<T, U> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final r<? extends U> f47535b;

    /* renamed from: c  reason: collision with root package name */
    final b<? super U, ? super T> f47536c;

    public q(u<T> uVar, r<? extends U> rVar, b<? super U, ? super T> bVar) {
        super(uVar);
        this.f47535b = rVar;
        this.f47536c = bVar;
    }

    public final void subscribeActual(w<? super U> wVar) {
        try {
            this.f46900a.subscribe(new a(wVar, Objects.requireNonNull(this.f47535b.get(), "The initialSupplier returned a null value"), this.f47536c));
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            d.error(th, (w<?>) wVar);
        }
    }

    static final class a<T, U> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super U> f47537a;

        /* renamed from: b  reason: collision with root package name */
        final b<? super U, ? super T> f47538b;

        /* renamed from: c  reason: collision with root package name */
        final U f47539c;

        /* renamed from: d  reason: collision with root package name */
        c f47540d;

        /* renamed from: e  reason: collision with root package name */
        boolean f47541e;

        a(w<? super U> wVar, U u, b<? super U, ? super T> bVar) {
            this.f47537a = wVar;
            this.f47538b = bVar;
            this.f47539c = u;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47540d, cVar)) {
                this.f47540d = cVar;
                this.f47537a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47540d.dispose();
        }

        public final boolean isDisposed() {
            return this.f47540d.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f47541e) {
                try {
                    this.f47538b.accept(this.f47539c, t);
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    this.f47540d.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47541e) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47541e = true;
            this.f47537a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47541e) {
                this.f47541e = true;
                this.f47537a.onNext(this.f47539c);
                this.f47537a.onComplete();
            }
        }
    }
}
