package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.n;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.b;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ay<T, R> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends n<? extends R>> f47024b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f47025c;

    public ay(u<T> uVar, h<? super T, ? extends n<? extends R>> hVar, boolean z) {
        super(uVar);
        this.f47024b = hVar;
        this.f47025c = z;
    }

    public final void subscribeActual(w<? super R> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47024b, this.f47025c));
    }

    static final class a<T, R> extends AtomicInteger implements w<T>, c {
        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active = new AtomicInteger(1);
        volatile boolean cancelled;
        final boolean delayErrors;
        final w<? super R> downstream;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        final h<? super T, ? extends n<? extends R>> mapper;
        final AtomicReference<io.reactivex.rxjava3.e.g.c<R>> queue = new AtomicReference<>();
        final b set = new b();
        c upstream;

        a(w<? super R> wVar, h<? super T, ? extends n<? extends R>> hVar, boolean z) {
            this.downstream = wVar;
            this.mapper = hVar;
            this.delayErrors = z;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            try {
                n nVar = (n) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                C0806a aVar = new C0806a();
                if (!this.cancelled && this.set.a((c) aVar)) {
                    nVar.a(aVar);
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        public final void onError(Throwable th) {
            this.active.decrementAndGet();
            if (this.errors.tryAddThrowableOrReport(th)) {
                if (!this.delayErrors) {
                    this.set.dispose();
                }
                drain();
            }
        }

        public final void onComplete() {
            this.active.decrementAndGet();
            drain();
        }

        public final void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.set.dispose();
            this.errors.tryTerminateAndReport();
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public final void innerSuccess(a<T, R>.defpackage.a aVar, R r) {
            this.set.c(aVar);
            if (get() == 0) {
                boolean z = true;
                if (compareAndSet(0, 1)) {
                    this.downstream.onNext(r);
                    if (this.active.decrementAndGet() != 0) {
                        z = false;
                    }
                    io.reactivex.rxjava3.e.g.c cVar = this.queue.get();
                    if (!z || (cVar != null && !cVar.isEmpty())) {
                        if (decrementAndGet() == 0) {
                            return;
                        }
                        drainLoop();
                    }
                    this.errors.tryTerminateConsumer((w<?>) this.downstream);
                    return;
                }
            }
            io.reactivex.rxjava3.e.g.c orCreateQueue = getOrCreateQueue();
            synchronized (orCreateQueue) {
                orCreateQueue.offer(r);
            }
            this.active.decrementAndGet();
            if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* access modifiers changed from: package-private */
        public final io.reactivex.rxjava3.e.g.c<R> getOrCreateQueue() {
            io.reactivex.rxjava3.e.g.c<R> cVar = this.queue.get();
            if (cVar != null) {
                return cVar;
            }
            io.reactivex.rxjava3.e.g.c<R> cVar2 = new io.reactivex.rxjava3.e.g.c<>(p.bufferSize());
            if (this.queue.compareAndSet((Object) null, cVar2)) {
                return cVar2;
            }
            return this.queue.get();
        }

        /* access modifiers changed from: package-private */
        public final void innerError(a<T, R>.defpackage.a aVar, Throwable th) {
            this.set.c(aVar);
            if (this.errors.tryAddThrowableOrReport(th)) {
                if (!this.delayErrors) {
                    this.upstream.dispose();
                    this.set.dispose();
                }
                this.active.decrementAndGet();
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerComplete(a<T, R>.defpackage.a aVar) {
            this.set.c(aVar);
            if (get() == 0) {
                boolean z = true;
                if (compareAndSet(0, 1)) {
                    if (this.active.decrementAndGet() != 0) {
                        z = false;
                    }
                    io.reactivex.rxjava3.e.g.c cVar = this.queue.get();
                    if (z && (cVar == null || cVar.isEmpty())) {
                        this.errors.tryTerminateConsumer((w<?>) this.downstream);
                        return;
                    } else if (decrementAndGet() != 0) {
                        drainLoop();
                        return;
                    } else {
                        return;
                    }
                }
            }
            this.active.decrementAndGet();
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        public final void clear() {
            io.reactivex.rxjava3.e.g.c cVar = this.queue.get();
            if (cVar != null) {
                cVar.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drainLoop() {
            w<? super R> wVar = this.downstream;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<io.reactivex.rxjava3.e.g.c<R>> atomicReference = this.queue;
            int i2 = 1;
            while (!this.cancelled) {
                if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                    boolean z = false;
                    boolean z2 = atomicInteger.get() == 0;
                    io.reactivex.rxjava3.e.g.c cVar = atomicReference.get();
                    Object poll = cVar != null ? cVar.poll() : null;
                    if (poll == null) {
                        z = true;
                    }
                    if (z2 && z) {
                        this.errors.tryTerminateConsumer((w<?>) wVar);
                        return;
                    } else if (!z) {
                        wVar.onNext(poll);
                    } else {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                } else {
                    clear();
                    this.errors.tryTerminateConsumer((w<?>) wVar);
                    return;
                }
            }
            clear();
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.ay$a$a  reason: collision with other inner class name */
        final class C0806a extends AtomicReference<c> implements m<R>, c {
            private static final long serialVersionUID = -502562646270949838L;

            C0806a() {
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
            }

            public final void onSuccess(R r) {
                a.this.innerSuccess(this, r);
            }

            public final void onError(Throwable th) {
                a.this.innerError(this, th);
            }

            public final void onComplete() {
                a.this.innerComplete(this);
            }

            public final boolean isDisposed() {
                return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
            }

            public final void dispose() {
                io.reactivex.rxjava3.e.a.c.dispose(this);
            }
        }
    }
}
