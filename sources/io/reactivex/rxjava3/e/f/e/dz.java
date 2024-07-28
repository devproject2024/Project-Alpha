package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class dz<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f47355b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f47356c;

    /* renamed from: d  reason: collision with root package name */
    final x f47357d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f47358e;

    public dz(p<T> pVar, long j, TimeUnit timeUnit, x xVar, boolean z) {
        super(pVar);
        this.f47355b = j;
        this.f47356c = timeUnit;
        this.f47357d = xVar;
        this.f47358e = z;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47355b, this.f47356c, this.f47357d.a(), this.f47358e));
    }

    static final class a<T> extends AtomicInteger implements w<T>, c, Runnable {
        private static final long serialVersionUID = -8296689127439125014L;
        volatile boolean cancelled;
        volatile boolean done;
        final w<? super T> downstream;
        final boolean emitLast;
        Throwable error;
        final AtomicReference<T> latest = new AtomicReference<>();
        final long timeout;
        volatile boolean timerFired;
        boolean timerRunning;
        final TimeUnit unit;
        c upstream;
        final x.c worker;

        a(w<? super T> wVar, long j, TimeUnit timeUnit, x.c cVar, boolean z) {
            this.downstream = wVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
            this.emitLast = z;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.latest.set(t);
            drain();
        }

        public final void onError(Throwable th) {
            this.error = th;
            this.done = true;
            drain();
        }

        public final void onComplete() {
            this.done = true;
            drain();
        }

        public final void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.latest.lazySet((Object) null);
            }
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        public final void run() {
            this.timerFired = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.latest;
                w<? super T> wVar = this.downstream;
                int i2 = 1;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (!z || this.error == null) {
                        boolean z2 = atomicReference.get() == null;
                        if (z) {
                            T andSet = atomicReference.getAndSet((Object) null);
                            if (!z2 && this.emitLast) {
                                wVar.onNext(andSet);
                            }
                            wVar.onComplete();
                            this.worker.dispose();
                            return;
                        }
                        if (z2) {
                            if (this.timerFired) {
                                this.timerRunning = false;
                                this.timerFired = false;
                            }
                        } else if (!this.timerRunning || this.timerFired) {
                            wVar.onNext(atomicReference.getAndSet((Object) null));
                            this.timerFired = false;
                            this.timerRunning = true;
                            this.worker.a(this, this.timeout, this.unit);
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        wVar.onError(this.error);
                        this.worker.dispose();
                        return;
                    }
                }
                atomicReference.lazySet((Object) null);
            }
        }
    }
}
