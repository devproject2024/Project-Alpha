package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.g.f;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class cz<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f47232b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f47233c;

    /* renamed from: d  reason: collision with root package name */
    final x f47234d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f47235e;

    public cz(u<T> uVar, long j, TimeUnit timeUnit, x xVar, boolean z) {
        super(uVar);
        this.f47232b = j;
        this.f47233c = timeUnit;
        this.f47234d = xVar;
        this.f47235e = z;
    }

    public final void subscribeActual(w<? super T> wVar) {
        f fVar = new f(wVar);
        if (this.f47235e) {
            this.f46900a.subscribe(new a(fVar, this.f47232b, this.f47233c, this.f47234d));
        } else {
            this.f46900a.subscribe(new b(fVar, this.f47232b, this.f47233c, this.f47234d));
        }
    }

    static abstract class c<T> extends AtomicReference<T> implements w<T>, io.reactivex.rxjava3.b.c, Runnable {
        private static final long serialVersionUID = -3517602651313910099L;
        final w<? super T> downstream;
        final long period;
        final x scheduler;
        final AtomicReference<io.reactivex.rxjava3.b.c> timer = new AtomicReference<>();
        final TimeUnit unit;
        io.reactivex.rxjava3.b.c upstream;

        /* access modifiers changed from: package-private */
        public abstract void complete();

        c(w<? super T> wVar, long j, TimeUnit timeUnit, x xVar) {
            this.downstream = wVar;
            this.period = j;
            this.unit = timeUnit;
            this.scheduler = xVar;
        }

        public void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                x xVar = this.scheduler;
                long j = this.period;
                io.reactivex.rxjava3.e.a.c.replace(this.timer, xVar.a(this, j, j, this.unit));
            }
        }

        public void onNext(T t) {
            lazySet(t);
        }

        public void onError(Throwable th) {
            cancelTimer();
            this.downstream.onError(th);
        }

        public void onComplete() {
            cancelTimer();
            complete();
        }

        /* access modifiers changed from: package-private */
        public void cancelTimer() {
            io.reactivex.rxjava3.e.a.c.dispose(this.timer);
        }

        public void dispose() {
            cancelTimer();
            this.upstream.dispose();
        }

        public boolean isDisposed() {
            return this.upstream.isDisposed();
        }

        /* access modifiers changed from: package-private */
        public void emit() {
            Object andSet = getAndSet((Object) null);
            if (andSet != null) {
                this.downstream.onNext(andSet);
            }
        }
    }

    static final class b<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;

        b(w<? super T> wVar, long j, TimeUnit timeUnit, x xVar) {
            super(wVar, j, timeUnit, xVar);
        }

        /* access modifiers changed from: package-private */
        public final void complete() {
            this.downstream.onComplete();
        }

        public final void run() {
            emit();
        }
    }

    static final class a<T> extends c<T> {
        private static final long serialVersionUID = -7139995637533111443L;
        final AtomicInteger wip = new AtomicInteger(1);

        a(w<? super T> wVar, long j, TimeUnit timeUnit, x xVar) {
            super(wVar, j, timeUnit, xVar);
        }

        /* access modifiers changed from: package-private */
        public final void complete() {
            emit();
            if (this.wip.decrementAndGet() == 0) {
                this.downstream.onComplete();
            }
        }

        public final void run() {
            if (this.wip.incrementAndGet() == 2) {
                emit();
                if (this.wip.decrementAndGet() == 0) {
                    this.downstream.onComplete();
                }
            }
        }
    }
}
