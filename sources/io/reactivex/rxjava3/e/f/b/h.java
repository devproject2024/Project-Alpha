package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.a.m;
import io.reactivex.rxjava3.a.n;
import io.reactivex.rxjava3.e.j.g;
import io.reactivex.rxjava3.e.k.d;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.b;
import org.a.c;

public final class h<T, R> extends a<T, R> {

    /* renamed from: c  reason: collision with root package name */
    final io.reactivex.rxjava3.d.h<? super T, ? extends n<? extends R>> f46804c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f46805d = false;

    /* renamed from: e  reason: collision with root package name */
    final int f46806e = Integer.MAX_VALUE;

    public h(io.reactivex.rxjava3.a.h<T> hVar, io.reactivex.rxjava3.d.h<? super T, ? extends n<? extends R>> hVar2) {
        super(hVar);
        this.f46804c = hVar2;
    }

    public final void b(b<? super R> bVar) {
        this.f46770b.a(new a(bVar, this.f46804c, this.f46805d, this.f46806e));
    }

    static final class a<T, R> extends AtomicInteger implements k<T>, c {
        private static final long serialVersionUID = 8600231336733376951L;
        final AtomicInteger active = new AtomicInteger(1);
        volatile boolean cancelled;
        final boolean delayErrors;
        final b<? super R> downstream;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        final io.reactivex.rxjava3.d.h<? super T, ? extends n<? extends R>> mapper;
        final int maxConcurrency;
        final AtomicReference<io.reactivex.rxjava3.e.g.c<R>> queue = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();
        final io.reactivex.rxjava3.b.b set = new io.reactivex.rxjava3.b.b();
        c upstream;

        a(b<? super R> bVar, io.reactivex.rxjava3.d.h<? super T, ? extends n<? extends R>> hVar, boolean z, int i2) {
            this.downstream = bVar;
            this.mapper = hVar;
            this.delayErrors = z;
            this.maxConcurrency = i2;
        }

        public final void onSubscribe(c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    cVar.request(Long.MAX_VALUE);
                } else {
                    cVar.request((long) i2);
                }
            }
        }

        public final void onNext(T t) {
            try {
                n nVar = (n) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null MaybeSource");
                this.active.getAndIncrement();
                C0790a aVar = new C0790a();
                if (!this.cancelled && this.set.a((io.reactivex.rxjava3.b.c) aVar)) {
                    nVar.a(aVar);
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                this.upstream.cancel();
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

        public final void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
            this.set.dispose();
            this.errors.tryTerminateAndReport();
        }

        public final void request(long j) {
            if (g.validate(j)) {
                d.a(this.requested, j);
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerSuccess(a<T, R>.defpackage.a aVar, R r) {
            this.set.c(aVar);
            if (get() == 0) {
                boolean z = true;
                if (compareAndSet(0, 1)) {
                    if (this.active.decrementAndGet() != 0) {
                        z = false;
                    }
                    if (this.requested.get() != 0) {
                        this.downstream.onNext(r);
                        if (checkTerminate(z, this.queue.get())) {
                            this.errors.tryTerminateConsumer((b<?>) this.downstream);
                            return;
                        }
                        d.b(this.requested, 1);
                        if (this.maxConcurrency != Integer.MAX_VALUE) {
                            this.upstream.request(1);
                        }
                    } else {
                        io.reactivex.rxjava3.e.g.c orCreateQueue = getOrCreateQueue();
                        synchronized (orCreateQueue) {
                            orCreateQueue.offer(r);
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    drainLoop();
                }
            }
            io.reactivex.rxjava3.e.g.c orCreateQueue2 = getOrCreateQueue();
            synchronized (orCreateQueue2) {
                orCreateQueue2.offer(r);
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
            io.reactivex.rxjava3.e.g.c<R> cVar2 = new io.reactivex.rxjava3.e.g.c<>(io.reactivex.rxjava3.a.h.a());
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
                    this.upstream.cancel();
                    this.set.dispose();
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    this.upstream.request(1);
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
                    if (checkTerminate(z, this.queue.get())) {
                        this.errors.tryTerminateConsumer((b<?>) this.downstream);
                        return;
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(1);
                    }
                    if (decrementAndGet() != 0) {
                        drainLoop();
                        return;
                    }
                    return;
                }
            }
            this.active.decrementAndGet();
            if (this.maxConcurrency != Integer.MAX_VALUE) {
                this.upstream.request(1);
            }
            drain();
        }

        static boolean checkTerminate(boolean z, io.reactivex.rxjava3.e.g.c<?> cVar) {
            if (z) {
                return cVar == null || cVar.isEmpty();
            }
            return false;
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
            boolean z;
            int i2;
            b<? super R> bVar = this.downstream;
            AtomicInteger atomicInteger = this.active;
            AtomicReference<io.reactivex.rxjava3.e.g.c<R>> atomicReference = this.queue;
            int i3 = 1;
            do {
                long j = this.requested.get();
                long j2 = 0;
                while (true) {
                    z = false;
                    i2 = (j2 > j ? 1 : (j2 == j ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    } else if (this.cancelled) {
                        clear();
                        return;
                    } else if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                        boolean z2 = atomicInteger.get() == 0;
                        io.reactivex.rxjava3.e.g.c cVar = atomicReference.get();
                        Object poll = cVar != null ? cVar.poll() : null;
                        boolean z3 = poll == null;
                        if (!z2 || !z3) {
                            if (z3) {
                                break;
                            }
                            bVar.onNext(poll);
                            j2++;
                        } else {
                            this.errors.tryTerminateConsumer((b<?>) bVar);
                            return;
                        }
                    } else {
                        clear();
                        this.errors.tryTerminateConsumer((b<?>) bVar);
                        return;
                    }
                }
                if (i2 == 0) {
                    if (this.cancelled) {
                        clear();
                        return;
                    } else if (this.delayErrors || ((Throwable) this.errors.get()) == null) {
                        boolean z4 = atomicInteger.get() == 0;
                        io.reactivex.rxjava3.e.g.c cVar2 = atomicReference.get();
                        if (cVar2 == null || cVar2.isEmpty()) {
                            z = true;
                        }
                        if (z4 && z) {
                            this.errors.tryTerminateConsumer((b<?>) bVar);
                            return;
                        }
                    } else {
                        clear();
                        this.errors.tryTerminateConsumer((b<?>) bVar);
                        return;
                    }
                }
                if (j2 != 0) {
                    d.b(this.requested, j2);
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        this.upstream.request(j2);
                    }
                }
                i3 = addAndGet(-i3);
            } while (i3 != 0);
        }

        /* renamed from: io.reactivex.rxjava3.e.f.b.h$a$a  reason: collision with other inner class name */
        final class C0790a extends AtomicReference<io.reactivex.rxjava3.b.c> implements m<R>, io.reactivex.rxjava3.b.c {
            private static final long serialVersionUID = -502562646270949838L;

            C0790a() {
            }

            public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
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
                return io.reactivex.rxjava3.e.a.c.isDisposed((io.reactivex.rxjava3.b.c) get());
            }

            public final void dispose() {
                io.reactivex.rxjava3.e.a.c.dispose(this);
            }
        }
    }
}
