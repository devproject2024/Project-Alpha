package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.g;

public final class an<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final g<? super T> f46972b;

    /* renamed from: c  reason: collision with root package name */
    final g<? super Throwable> f46973c;

    /* renamed from: d  reason: collision with root package name */
    final io.reactivex.rxjava3.d.a f46974d;

    /* renamed from: e  reason: collision with root package name */
    final io.reactivex.rxjava3.d.a f46975e;

    public an(u<T> uVar, g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.rxjava3.d.a aVar, io.reactivex.rxjava3.d.a aVar2) {
        super(uVar);
        this.f46972b = gVar;
        this.f46973c = gVar2;
        this.f46974d = aVar;
        this.f46975e = aVar2;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f46972b, this.f46973c, this.f46974d, this.f46975e));
    }

    static final class a<T> implements w<T>, c {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f46976a;

        /* renamed from: b  reason: collision with root package name */
        final g<? super T> f46977b;

        /* renamed from: c  reason: collision with root package name */
        final g<? super Throwable> f46978c;

        /* renamed from: d  reason: collision with root package name */
        final io.reactivex.rxjava3.d.a f46979d;

        /* renamed from: e  reason: collision with root package name */
        final io.reactivex.rxjava3.d.a f46980e;

        /* renamed from: f  reason: collision with root package name */
        c f46981f;

        /* renamed from: g  reason: collision with root package name */
        boolean f46982g;

        a(w<? super T> wVar, g<? super T> gVar, g<? super Throwable> gVar2, io.reactivex.rxjava3.d.a aVar, io.reactivex.rxjava3.d.a aVar2) {
            this.f46976a = wVar;
            this.f46977b = gVar;
            this.f46978c = gVar2;
            this.f46979d = aVar;
            this.f46980e = aVar2;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f46981f, cVar)) {
                this.f46981f = cVar;
                this.f46976a.onSubscribe(this);
            }
        }

        public final void dispose() {
            this.f46981f.dispose();
        }

        public final boolean isDisposed() {
            return this.f46981f.isDisposed();
        }

        public final void onNext(T t) {
            if (!this.f46982g) {
                try {
                    this.f46977b.accept(t);
                    this.f46976a.onNext(t);
                } catch (Throwable th) {
                    b.b(th);
                    this.f46981f.dispose();
                    onError(th);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.f46982g) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f46982g = true;
            try {
                this.f46978c.accept(th);
            } catch (Throwable th2) {
                b.b(th2);
                th = new io.reactivex.rxjava3.c.a(th, th2);
            }
            this.f46976a.onError(th);
            try {
                this.f46980e.run();
            } catch (Throwable th3) {
                b.b(th3);
                io.reactivex.rxjava3.h.a.a(th3);
            }
        }

        public final void onComplete() {
            if (!this.f46982g) {
                try {
                    this.f46979d.run();
                    this.f46982g = true;
                    this.f46976a.onComplete();
                    try {
                        this.f46980e.run();
                    } catch (Throwable th) {
                        b.b(th);
                        io.reactivex.rxjava3.h.a.a(th);
                    }
                } catch (Throwable th2) {
                    b.b(th2);
                    onError(th2);
                }
            }
        }
    }
}
