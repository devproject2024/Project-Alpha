package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.a.f;

public final class ag<T, U> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<? extends T> f46945a;

    /* renamed from: b  reason: collision with root package name */
    final u<U> f46946b;

    public ag(u<? extends T> uVar, u<U> uVar2) {
        this.f46945a = uVar;
        this.f46946b = uVar2;
    }

    public final void subscribeActual(w<? super T> wVar) {
        f fVar = new f();
        wVar.onSubscribe(fVar);
        this.f46946b.subscribe(new a(fVar, wVar));
    }

    final class a implements w<U> {

        /* renamed from: a  reason: collision with root package name */
        final f f46947a;

        /* renamed from: b  reason: collision with root package name */
        final w<? super T> f46948b;

        /* renamed from: c  reason: collision with root package name */
        boolean f46949c;

        a(f fVar, w<? super T> wVar) {
            this.f46947a = fVar;
            this.f46948b = wVar;
        }

        public final void onSubscribe(c cVar) {
            this.f46947a.update(cVar);
        }

        public final void onNext(U u) {
            onComplete();
        }

        public final void onError(Throwable th) {
            if (this.f46949c) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f46949c = true;
            this.f46948b.onError(th);
        }

        public final void onComplete() {
            if (!this.f46949c) {
                this.f46949c = true;
                ag.this.f46945a.subscribe(new C0803a());
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.ag$a$a  reason: collision with other inner class name */
        final class C0803a implements w<T> {
            C0803a() {
            }

            public final void onSubscribe(c cVar) {
                a.this.f46947a.update(cVar);
            }

            public final void onNext(T t) {
                a.this.f46948b.onNext(t);
            }

            public final void onError(Throwable th) {
                a.this.f46948b.onError(th);
            }

            public final void onComplete() {
                a.this.f46948b.onComplete();
            }
        }
    }
}
