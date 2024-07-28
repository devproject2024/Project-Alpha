package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.k;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class dv<T, U> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final u<? extends U> f47341b;

    public dv(u<T> uVar, u<? extends U> uVar2) {
        super(uVar);
        this.f47341b = uVar2;
    }

    public final void subscribeActual(w<? super T> wVar) {
        a aVar = new a(wVar);
        wVar.onSubscribe(aVar);
        this.f47341b.subscribe(aVar.otherObserver);
        this.f46900a.subscribe(aVar);
    }

    static final class a<T, U> extends AtomicInteger implements w<T>, c {
        private static final long serialVersionUID = 1418547743690811973L;
        final w<? super T> downstream;
        final io.reactivex.rxjava3.e.k.c error = new io.reactivex.rxjava3.e.k.c();
        final a<T, U>.defpackage.a otherObserver = new C0814a();
        final AtomicReference<c> upstream = new AtomicReference<>();

        a(w<? super T> wVar) {
            this.downstream = wVar;
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            io.reactivex.rxjava3.e.a.c.dispose(this.otherObserver);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed(this.upstream.get());
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.upstream, cVar);
        }

        public final void onNext(T t) {
            k.a(this.downstream, t, (AtomicInteger) this, this.error);
        }

        public final void onError(Throwable th) {
            io.reactivex.rxjava3.e.a.c.dispose(this.otherObserver);
            k.a((w<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        public final void onComplete() {
            io.reactivex.rxjava3.e.a.c.dispose(this.otherObserver);
            k.a(this.downstream, this, this.error);
        }

        /* access modifiers changed from: package-private */
        public final void otherError(Throwable th) {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            k.a((w<?>) this.downstream, th, (AtomicInteger) this, this.error);
        }

        /* access modifiers changed from: package-private */
        public final void otherComplete() {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            k.a(this.downstream, this, this.error);
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.dv$a$a  reason: collision with other inner class name */
        final class C0814a extends AtomicReference<c> implements w<U> {
            private static final long serialVersionUID = -8693423678067375039L;

            C0814a() {
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
            }

            public final void onNext(U u) {
                io.reactivex.rxjava3.e.a.c.dispose(this);
                a.this.otherComplete();
            }

            public final void onError(Throwable th) {
                a.this.otherError(th);
            }

            public final void onComplete() {
                a.this.otherComplete();
            }
        }
    }
}
