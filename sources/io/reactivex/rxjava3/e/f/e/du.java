package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class du<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f47335b;

    /* renamed from: c  reason: collision with root package name */
    final long f47336c;

    /* renamed from: d  reason: collision with root package name */
    final TimeUnit f47337d;

    /* renamed from: e  reason: collision with root package name */
    final x f47338e;

    /* renamed from: f  reason: collision with root package name */
    final int f47339f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f47340g;

    public du(u<T> uVar, long j, long j2, TimeUnit timeUnit, x xVar, int i2, boolean z) {
        super(uVar);
        this.f47335b = j;
        this.f47336c = j2;
        this.f47337d = timeUnit;
        this.f47338e = xVar;
        this.f47339f = i2;
        this.f47340g = z;
    }

    public final void subscribeActual(w<? super T> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47335b, this.f47336c, this.f47337d, this.f47338e, this.f47339f, this.f47340g));
    }

    static final class a<T> extends AtomicBoolean implements w<T>, c {
        private static final long serialVersionUID = -5677354903406201275L;
        volatile boolean cancelled;
        final long count;
        final boolean delayError;
        final w<? super T> downstream;
        Throwable error;
        final io.reactivex.rxjava3.e.g.c<Object> queue;
        final x scheduler;
        final long time;
        final TimeUnit unit;
        c upstream;

        a(w<? super T> wVar, long j, long j2, TimeUnit timeUnit, x xVar, int i2, boolean z) {
            this.downstream = wVar;
            this.count = j;
            this.time = j2;
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
            long j;
            long j2;
            io.reactivex.rxjava3.e.g.c<Object> cVar = this.queue;
            long a2 = x.a(this.unit);
            long j3 = this.time;
            long j4 = this.count;
            boolean z = j4 == Long.MAX_VALUE;
            cVar.a(Long.valueOf(a2), t);
            while (!cVar.isEmpty()) {
                if (((Long) cVar.a()).longValue() > a2 - j3) {
                    if (!z) {
                        long j5 = cVar.f47631i.get();
                        while (true) {
                            j = cVar.f47624b.get();
                            j2 = cVar.f47631i.get();
                            if (j5 == j2) {
                                break;
                            }
                            j5 = j2;
                        }
                        if (((long) (((int) (j - j2)) >> 1)) <= j4) {
                            return;
                        }
                    } else {
                        return;
                    }
                }
                cVar.poll();
                cVar.poll();
            }
        }

        public final void onError(Throwable th) {
            this.error = th;
            drain();
        }

        public final void onComplete() {
            drain();
        }

        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                if (compareAndSet(false, true)) {
                    this.queue.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            Throwable th;
            if (compareAndSet(false, true)) {
                w<? super T> wVar = this.downstream;
                io.reactivex.rxjava3.e.g.c<Object> cVar = this.queue;
                boolean z = this.delayError;
                long a2 = x.a(this.unit) - this.time;
                while (!this.cancelled) {
                    if (z || (th = this.error) == null) {
                        Object poll = cVar.poll();
                        if (poll == null) {
                            Throwable th2 = this.error;
                            if (th2 != null) {
                                wVar.onError(th2);
                                return;
                            } else {
                                wVar.onComplete();
                                return;
                            }
                        } else {
                            Object poll2 = cVar.poll();
                            if (((Long) poll).longValue() >= a2) {
                                wVar.onNext(poll2);
                            }
                        }
                    } else {
                        cVar.clear();
                        wVar.onError(th);
                        return;
                    }
                }
                cVar.clear();
            }
        }
    }
}
