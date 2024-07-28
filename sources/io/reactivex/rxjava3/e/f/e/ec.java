package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.e.a.f;
import io.reactivex.rxjava3.e.k.j;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ec<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final long f47379b;

    /* renamed from: c  reason: collision with root package name */
    final TimeUnit f47380c;

    /* renamed from: d  reason: collision with root package name */
    final x f47381d;

    /* renamed from: e  reason: collision with root package name */
    final u<? extends T> f47382e;

    interface d {
        void onTimeout(long j);
    }

    public ec(p<T> pVar, long j, TimeUnit timeUnit, x xVar, u<? extends T> uVar) {
        super(pVar);
        this.f47379b = j;
        this.f47380c = timeUnit;
        this.f47381d = xVar;
        this.f47382e = uVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        if (this.f47382e == null) {
            c cVar = new c(wVar, this.f47379b, this.f47380c, this.f47381d.a());
            wVar.onSubscribe(cVar);
            cVar.startTimeout(0);
            this.f46900a.subscribe(cVar);
            return;
        }
        b bVar = new b(wVar, this.f47379b, this.f47380c, this.f47381d.a(), this.f47382e);
        wVar.onSubscribe(bVar);
        bVar.startTimeout(0);
        this.f46900a.subscribe(bVar);
    }

    static final class c<T> extends AtomicLong implements w<T>, io.reactivex.rxjava3.b.c, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final w<? super T> downstream;
        final f task = new f();
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<io.reactivex.rxjava3.b.c> upstream = new AtomicReference<>();
        final x.c worker;

        c(w<? super T> wVar, long j, TimeUnit timeUnit, x.c cVar) {
            this.downstream = wVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.upstream, cVar);
        }

        public final void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    ((io.reactivex.rxjava3.b.c) this.task.get()).dispose();
                    this.downstream.onNext(t);
                    startTimeout(j2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void startTimeout(long j) {
            this.task.replace(this.worker.a(new e(j, this), this.timeout, this.unit));
        }

        public final void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th);
                this.worker.dispose();
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        public final void onTimeout(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
                this.downstream.onError(new TimeoutException(j.a(this.timeout, this.unit)));
                this.worker.dispose();
            }
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            this.worker.dispose();
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed(this.upstream.get());
        }
    }

    static final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final d f47385a;

        /* renamed from: b  reason: collision with root package name */
        final long f47386b;

        e(long j, d dVar) {
            this.f47386b = j;
            this.f47385a = dVar;
        }

        public final void run() {
            this.f47385a.onTimeout(this.f47386b);
        }
    }

    static final class b<T> extends AtomicReference<io.reactivex.rxjava3.b.c> implements w<T>, io.reactivex.rxjava3.b.c, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final w<? super T> downstream;
        u<? extends T> fallback;
        final AtomicLong index = new AtomicLong();
        final f task = new f();
        final long timeout;
        final TimeUnit unit;
        final AtomicReference<io.reactivex.rxjava3.b.c> upstream = new AtomicReference<>();
        final x.c worker;

        b(w<? super T> wVar, long j, TimeUnit timeUnit, x.c cVar, u<? extends T> uVar) {
            this.downstream = wVar;
            this.timeout = j;
            this.unit = timeUnit;
            this.worker = cVar;
            this.fallback = uVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.upstream, cVar);
        }

        public final void onNext(T t) {
            long j = this.index.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.index.compareAndSet(j, j2)) {
                    ((io.reactivex.rxjava3.b.c) this.task.get()).dispose();
                    this.downstream.onNext(t);
                    startTimeout(j2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void startTimeout(long j) {
            this.task.replace(this.worker.a(new e(j, this), this.timeout, this.unit));
        }

        public final void onError(Throwable th) {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th);
                this.worker.dispose();
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.worker.dispose();
            }
        }

        public final void onTimeout(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
                u<? extends T> uVar = this.fallback;
                this.fallback = null;
                uVar.subscribe(new a(this.downstream, this));
                this.worker.dispose();
            }
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            io.reactivex.rxjava3.e.a.c.dispose(this);
            this.worker.dispose();
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((io.reactivex.rxjava3.b.c) get());
        }
    }

    static final class a<T> implements w<T> {

        /* renamed from: a  reason: collision with root package name */
        final w<? super T> f47383a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<io.reactivex.rxjava3.b.c> f47384b;

        a(w<? super T> wVar, AtomicReference<io.reactivex.rxjava3.b.c> atomicReference) {
            this.f47383a = wVar;
            this.f47384b = atomicReference;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.replace(this.f47384b, cVar);
        }

        public final void onNext(T t) {
            this.f47383a.onNext(t);
        }

        public final void onError(Throwable th) {
            this.f47383a.onError(th);
        }

        public final void onComplete() {
            this.f47383a.onComplete();
        }
    }
}
