package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.g.f;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class dy<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f47352b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f47353c;

    /* renamed from: d  reason: collision with root package name */
    final x f47354d;

    public dy(u<T> uVar, long j, TimeUnit timeUnit, x xVar) {
        super(uVar);
        this.f47352b = j;
        this.f47353c = timeUnit;
        this.f47354d = xVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(new f(wVar), this.f47352b, this.f47353c, this.f47354d.a()));
    }

    static final class a<T> extends AtomicReference<c> implements w<T>, c, Runnable {
        private static final long serialVersionUID = 786994795061867455L;
        final w<? super T> downstream;
        volatile boolean gate;
        final long timeout;
        final TimeUnit unit;
        c upstream;
        final x.c worker;

        a(w<? super T> wVar, long j, TimeUnit timeUnit, x.c cVar) {
            this.downstream = wVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.gate) {
                this.gate = true;
                this.downstream.onNext(t);
                c cVar = (c) get();
                if (cVar != null) {
                    cVar.dispose();
                }
                io.reactivex.rxjava3.e.a.c.replace(this, this.worker.a(this, this.timeout, this.unit));
            }
        }

        public final void run() {
            this.gate = false;
        }

        public final void onError(Throwable th) {
            this.downstream.onError(th);
            this.worker.dispose();
        }

        public final void onComplete() {
            this.downstream.onComplete();
            this.worker.dispose();
        }

        public final void dispose() {
            this.upstream.dispose();
            this.worker.dispose();
        }

        public final boolean isDisposed() {
            return this.worker.isDisposed();
        }
    }
}
