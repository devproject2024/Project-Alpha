package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class dl<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f47294b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f47295c;

    /* renamed from: d  reason: collision with root package name */
    final x f47296d;

    /* renamed from: e  reason: collision with root package name */
    final int f47297e;

    /* renamed from: f  reason: collision with root package name */
    final boolean f47298f;

    public dl(u<T> uVar, long j, TimeUnit timeUnit, x xVar, int i2, boolean z) {
        super(uVar);
        this.f47294b = j;
        this.f47295c = timeUnit;
        this.f47296d = xVar;
        this.f47297e = i2;
        this.f47298f = z;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47294b, this.f47295c, this.f47296d, this.f47297e, this.f47298f));
    }

    static final class a<T> extends AtomicInteger implements w<T>, c {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        final w<? super T> downstream;
        Throwable error;
        final io.reactivex.rxjava3.e.g.c<Object> queue;
        final x scheduler;
        final long time;
        final TimeUnit unit;
        c upstream;

        a(w<? super T> wVar, long j, TimeUnit timeUnit, x xVar, int i2, boolean z) {
            this.downstream = wVar;
            this.time = j;
            this.unit = timeUnit;
            this.scheduler = xVar;
            this.queue = new io.reactivex.rxjava3.e.g.c<>(i2);
            this.delayError = z;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.queue.a(Long.valueOf(x.a(this.unit)), t);
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
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                w<? super T> wVar = this.downstream;
                io.reactivex.rxjava3.e.g.c<Object> cVar = this.queue;
                boolean z = this.delayError;
                TimeUnit timeUnit = this.unit;
                long j = this.time;
                int i2 = 1;
                while (!this.cancelled) {
                    boolean z2 = this.done;
                    Long l = (Long) cVar.a();
                    boolean z3 = l == null;
                    long a2 = x.a(timeUnit);
                    if (!z3 && l.longValue() > a2 - j) {
                        z3 = true;
                    }
                    if (z2) {
                        if (!z) {
                            Throwable th = this.error;
                            if (th != null) {
                                this.queue.clear();
                                wVar.onError(th);
                                return;
                            } else if (z3) {
                                wVar.onComplete();
                                return;
                            }
                        } else if (z3) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                wVar.onError(th2);
                                return;
                            } else {
                                wVar.onComplete();
                                return;
                            }
                        }
                    }
                    if (!z3) {
                        cVar.poll();
                        wVar.onNext(cVar.poll());
                    } else {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
                this.queue.clear();
            }
        }
    }
}
