package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: io.reactivex.rxjava3.e.f.e.do  reason: invalid class name */
public final class Cdo<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final x f47315b;

    public Cdo(u<T> uVar, x xVar) {
        super(uVar);
        this.f47315b = xVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        a aVar = new a(wVar);
        wVar.onSubscribe(aVar);
        aVar.setDisposable(this.f47315b.a((Runnable) new b(aVar)));
    }

    /* renamed from: io.reactivex.rxjava3.e.f.e.do$a */
    static final class a<T> extends AtomicReference<c> implements w<T>, c {
        private static final long serialVersionUID = 8094547886072529208L;
        final w<? super T> downstream;
        final AtomicReference<c> upstream = new AtomicReference<>();

        a(w<? super T> wVar) {
            this.downstream = wVar;
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.upstream, cVar);
        }

        public final void onNext(T t) {
            this.downstream.onNext(t);
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public final void onComplete() {
            this.downstream.onComplete();
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }

        /* access modifiers changed from: package-private */
        public final void setDisposable(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }
    }

    /* renamed from: io.reactivex.rxjava3.e.f.e.do$b */
    final class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final a<T> f47317b;

        b(a<T> aVar) {
            this.f47317b = aVar;
        }

        public final void run() {
            Cdo.this.f46900a.subscribe(this.f47317b);
        }
    }
}
