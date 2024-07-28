package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.g.f;

public final class dm<T, U> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final u<U> f47299b;

    public dm(u<T> uVar, u<U> uVar2) {
        super(uVar);
        this.f47299b = uVar2;
    }

    public final void subscribeActual(w<? super T> wVar) {
        f fVar = new f(wVar);
        io.reactivex.rxjava3.e.a.a aVar = new io.reactivex.rxjava3.e.a.a(2);
        fVar.onSubscribe(aVar);
        b bVar = new b(fVar, aVar);
        this.f47299b.subscribe(new a(aVar, bVar, fVar));
        this.f46900a.subscribe(bVar);
    }

    static final class b<T> implements w<T> {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47305a;

        /* renamed from: b  reason: collision with root package name */
        final io.reactivex.rxjava3.e.a.a f47306b;

        /* renamed from: c  reason: collision with root package name */
        c f47307c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f47308d;

        /* renamed from: e  reason: collision with root package name */
        boolean f47309e;

        b(w<? super T> wVar, io.reactivex.rxjava3.e.a.a aVar) {
            this.f47305a = wVar;
            this.f47306b = aVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47307c, cVar)) {
                this.f47307c = cVar;
                this.f47306b.setResource(0, cVar);
            }
        }

        public final void onNext(T t) {
            if (this.f47309e) {
                this.f47305a.onNext(t);
            } else if (this.f47308d) {
                this.f47309e = true;
                this.f47305a.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            this.f47306b.dispose();
            this.f47305a.onError(th);
        }

        public final void onComplete() {
            this.f47306b.dispose();
            this.f47305a.onComplete();
        }
    }

    final class a implements w<U> {

        /* renamed from: a  reason: collision with root package name */
        final io.reactivex.rxjava3.e.a.a f47300a;

        /* renamed from: b  reason: collision with root package name */
        final b<T> f47301b;

        /* renamed from: c  reason: collision with root package name */
        final f<T> f47302c;

        /* renamed from: d  reason: collision with root package name */
        c f47303d;

        a(io.reactivex.rxjava3.e.a.a aVar, b<T> bVar, f<T> fVar) {
            this.f47300a = aVar;
            this.f47301b = bVar;
            this.f47302c = fVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.f47303d, cVar)) {
                this.f47303d = cVar;
                this.f47300a.setResource(1, cVar);
            }
        }

        public final void onNext(U u) {
            this.f47303d.dispose();
            this.f47301b.f47308d = true;
        }

        public final void onError(Throwable th) {
            this.f47300a.dispose();
            this.f47302c.onError(th);
        }

        public final void onComplete() {
            this.f47301b.f47308d = true;
        }
    }
}
