package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.c;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.a.d;
import java.util.Objects;

public final class dd<T, R> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final c<R, ? super T, R> f47252b;

    /* renamed from: c  reason: collision with root package name */
    final r<R> f47253c;

    public dd(u<T> uVar, r<R> rVar, c<R, ? super T, R> cVar) {
        super(uVar);
        this.f47252b = cVar;
        this.f47253c = rVar;
    }

    public final void subscribeActual(w<? super R> wVar) {
        try {
            this.f46900a.subscribe(new a(wVar, this.f47252b, Objects.requireNonNull(this.f47253c.get(), "The seed supplied is null")));
        } catch (Throwable th) {
            b.b(th);
            d.error(th, (w<?>) wVar);
        }
    }

    static final class a<T, R> implements w<T>, io.reactivex.rxjava3.b.c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super R> f47254a;

        /* renamed from: b  reason: collision with root package name */
        final c<R, ? super T, R> f47255b;

        /* renamed from: c  reason: collision with root package name */
        R f47256c;

        /* renamed from: d  reason: collision with root package name */
        io.reactivex.rxjava3.b.c f47257d;

        /* renamed from: e  reason: collision with root package name */
        boolean f47258e;

        a(w<? super R> wVar, c<R, ? super T, R> cVar, R r) {
            this.f47254a = wVar;
            this.f47255b = cVar;
            this.f47256c = r;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47257d, cVar)) {
                this.f47257d = cVar;
                this.f47254a.onSubscribe(this);
                this.f47254a.onNext(this.f47256c);
            }
        }

        public final void dispose() {
            this.f47257d.dispose();
        }

        public final boolean isDisposed() {
            return this.f47257d.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f47258e) {
                try {
                    R requireNonNull = Objects.requireNonNull(this.f47255b.a(this.f47256c, t), "The accumulator returned a null value");
                    this.f47256c = requireNonNull;
                    this.f47254a.onNext(requireNonNull);
                } catch (Throwable th) {
                    b.b(th);
                    this.f47257d.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f47258e) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47258e = true;
            this.f47254a.onError(th);
        }

        public final void onComplete() {
            if (!this.f47258e) {
                this.f47258e = true;
                this.f47254a.onComplete();
            }
        }
    }
}
