package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.r;
import java.util.Objects;

public final class ca<T, R> extends a<T, u<? extends R>> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends u<? extends R>> f47145b;

    /* renamed from: c  reason: collision with root package name */
    final h<? super Throwable, ? extends u<? extends R>> f47146c;

    /* renamed from: d  reason: collision with root package name */
    final r<? extends u<? extends R>> f47147d;

    public ca(u<T> uVar, h<? super T, ? extends u<? extends R>> hVar, h<? super Throwable, ? extends u<? extends R>> hVar2, r<? extends u<? extends R>> rVar) {
        super(uVar);
        this.f47145b = hVar;
        this.f47146c = hVar2;
        this.f47147d = rVar;
    }

    public final void subscribeActual(w<? super u<? extends R>> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47145b, this.f47146c, this.f47147d));
    }

    static final class a<T, R> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super u<? extends R>> f47148a;

        /* renamed from: b  reason: collision with root package name */
        final h<? super T, ? extends u<? extends R>> f47149b;

        /* renamed from: c  reason: collision with root package name */
        final h<? super Throwable, ? extends u<? extends R>> f47150c;

        /* renamed from: d  reason: collision with root package name */
        final r<? extends u<? extends R>> f47151d;

        /* renamed from: e  reason: collision with root package name */
        c f47152e;

        a(w<? super u<? extends R>> wVar, h<? super T, ? extends u<? extends R>> hVar, h<? super Throwable, ? extends u<? extends R>> hVar2, r<? extends u<? extends R>> rVar) {
            this.f47148a = wVar;
            this.f47149b = hVar;
            this.f47150c = hVar2;
            this.f47151d = rVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47152e, cVar)) {
                this.f47152e = cVar;
                this.f47148a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f47152e.dispose();
        }

        public final boolean isDisposed() {
            return this.f47152e.isDisposed();
        }

        public final void onNext(T t) {
            try {
                this.f47148a.onNext((u) Objects.requireNonNull(this.f47149b.apply(t), "The onNext ObservableSource returned is null"));
            } catch (Throwable th) {
                b.b(th);
                this.f47148a.onError(th);
            }
        }

        public final void onError(Throwable th) {
            try {
                this.f47148a.onNext((u) Objects.requireNonNull(this.f47150c.apply(th), "The onError ObservableSource returned is null"));
                this.f47148a.onComplete();
            } catch (Throwable th2) {
                b.b(th2);
                this.f47148a.onError(new io.reactivex.rxjava3.c.a(th, th2));
            }
        }

        public final void onComplete() {
            try {
                this.f47148a.onNext((u) Objects.requireNonNull(this.f47151d.get(), "The onComplete ObservableSource returned is null"));
                this.f47148a.onComplete();
            } catch (Throwable th) {
                b.b(th);
                this.f47148a.onError(th);
            }
        }
    }
}
