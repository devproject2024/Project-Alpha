package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.r;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class m<T, U extends Collection<? super T>, Open, Close> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final r<U> f47496b;

    /* renamed from: c  reason: collision with root package name */
    final u<? extends Open> f47497c;

    /* renamed from: d  reason: collision with root package name */
    final h<? super Open, ? extends u<? extends Close>> f47498d;

    public m(u<T> uVar, u<? extends Open> uVar2, h<? super Open, ? extends u<? extends Close>> hVar, r<U> rVar) {
        super(uVar);
        this.f47497c = uVar2;
        this.f47498d = hVar;
        this.f47496b = rVar;
    }

    public final void subscribeActual(w<? super U> wVar) {
        a aVar = new a(wVar, this.f47497c, this.f47498d, this.f47496b);
        wVar.onSubscribe(aVar);
        this.f46900a.subscribe(aVar);
    }

    static final class a<T, C extends Collection<? super T>, Open, Close> extends AtomicInteger implements w<T>, c {
        private static final long serialVersionUID = -8466418554264089604L;
        final h<? super Open, ? extends u<? extends Close>> bufferClose;
        final u<? extends Open> bufferOpen;
        final r<C> bufferSupplier;
        Map<Long, C> buffers = new LinkedHashMap();
        volatile boolean cancelled;
        volatile boolean done;
        final w<? super C> downstream;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        long index;
        final io.reactivex.rxjava3.b.b observers = new io.reactivex.rxjava3.b.b();
        final io.reactivex.rxjava3.e.g.c<C> queue = new io.reactivex.rxjava3.e.g.c<>(p.bufferSize());
        final AtomicReference<c> upstream = new AtomicReference<>();

        a(w<? super C> wVar, u<? extends Open> uVar, h<? super Open, ? extends u<? extends Close>> hVar, r<C> rVar) {
            this.downstream = wVar;
            this.bufferSupplier = rVar;
            this.bufferOpen = uVar;
            this.bufferClose = hVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.setOnce(this.upstream, cVar)) {
                C0817a aVar = new C0817a(this);
                this.observers.a((c) aVar);
                this.bufferOpen.subscribe(aVar);
            }
        }

        public final void onNext(T t) {
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map != null) {
                    for (C add : map.values()) {
                        add.add(t);
                    }
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.errors.tryAddThrowableOrReport(th)) {
                this.observers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                this.done = true;
                drain();
            }
        }

        public final void onComplete() {
            this.observers.dispose();
            synchronized (this) {
                Map<Long, C> map = this.buffers;
                if (map != null) {
                    for (C offer : map.values()) {
                        this.queue.offer(offer);
                    }
                    this.buffers = null;
                    this.done = true;
                    drain();
                }
            }
        }

        public final void dispose() {
            if (io.reactivex.rxjava3.e.a.c.dispose(this.upstream)) {
                this.cancelled = true;
                this.observers.dispose();
                synchronized (this) {
                    this.buffers = null;
                }
                if (getAndIncrement() != 0) {
                    this.queue.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed(this.upstream.get());
        }

        /* access modifiers changed from: package-private */
        public final void open(Open open) {
            try {
                Collection collection = (Collection) Objects.requireNonNull(this.bufferSupplier.get(), "The bufferSupplier returned a null Collection");
                u uVar = (u) Objects.requireNonNull(this.bufferClose.apply(open), "The bufferClose returned a null ObservableSource");
                long j = this.index;
                this.index = 1 + j;
                synchronized (this) {
                    Map<Long, C> map = this.buffers;
                    if (map != null) {
                        map.put(Long.valueOf(j), collection);
                        b bVar = new b(this, j);
                        this.observers.a((c) bVar);
                        uVar.subscribe(bVar);
                    }
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
                onError(th);
            }
        }

        /* access modifiers changed from: package-private */
        public final void openComplete(C0817a<Open> aVar) {
            this.observers.c(aVar);
            if (this.observers.b() == 0) {
                io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
                this.done = true;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
            if (r4 == false) goto L_0x0031;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
            r3.done = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void close(io.reactivex.rxjava3.e.f.e.m.b<T, C> r4, long r5) {
            /*
                r3 = this;
                io.reactivex.rxjava3.b.b r0 = r3.observers
                r0.c(r4)
                io.reactivex.rxjava3.b.b r4 = r3.observers
                int r4 = r4.b()
                r0 = 1
                if (r4 != 0) goto L_0x0015
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.b.c> r4 = r3.upstream
                io.reactivex.rxjava3.e.a.c.dispose(r4)
                r4 = 1
                goto L_0x0016
            L_0x0015:
                r4 = 0
            L_0x0016:
                monitor-enter(r3)
                java.util.Map<java.lang.Long, C> r1 = r3.buffers     // Catch:{ all -> 0x0035 }
                if (r1 != 0) goto L_0x001d
                monitor-exit(r3)     // Catch:{ all -> 0x0035 }
                return
            L_0x001d:
                io.reactivex.rxjava3.e.g.c<C> r1 = r3.queue     // Catch:{ all -> 0x0035 }
                java.util.Map<java.lang.Long, C> r2 = r3.buffers     // Catch:{ all -> 0x0035 }
                java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0035 }
                java.lang.Object r5 = r2.remove(r5)     // Catch:{ all -> 0x0035 }
                r1.offer(r5)     // Catch:{ all -> 0x0035 }
                monitor-exit(r3)     // Catch:{ all -> 0x0035 }
                if (r4 == 0) goto L_0x0031
                r3.done = r0
            L_0x0031:
                r3.drain()
                return
            L_0x0035:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0035 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.m.a.close(io.reactivex.rxjava3.e.f.e.m$b, long):void");
        }

        /* access modifiers changed from: package-private */
        public final void boundaryError(c cVar, Throwable th) {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            this.observers.c(cVar);
            onError(th);
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                w<? super C> wVar = this.downstream;
                io.reactivex.rxjava3.e.g.c<C> cVar = this.queue;
                int i2 = 1;
                while (!this.cancelled) {
                    boolean z = this.done;
                    if (!z || this.errors.get() == null) {
                        Collection collection = (Collection) cVar.poll();
                        boolean z2 = collection == null;
                        if (z && z2) {
                            wVar.onComplete();
                            return;
                        } else if (!z2) {
                            wVar.onNext(collection);
                        } else {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        }
                    } else {
                        cVar.clear();
                        this.errors.tryTerminateConsumer((w<?>) wVar);
                        return;
                    }
                }
                cVar.clear();
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.m$a$a  reason: collision with other inner class name */
        static final class C0817a<Open> extends AtomicReference<c> implements w<Open>, c {
            private static final long serialVersionUID = -8498650778633225126L;
            final a<?, ?, Open, ?> parent;

            C0817a(a<?, ?, Open, ?> aVar) {
                this.parent = aVar;
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
            }

            public final void onNext(Open open) {
                this.parent.open(open);
            }

            public final void onError(Throwable th) {
                lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
                this.parent.boundaryError(this, th);
            }

            public final void onComplete() {
                lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
                this.parent.openComplete(this);
            }

            public final void dispose() {
                io.reactivex.rxjava3.e.a.c.dispose(this);
            }

            public final boolean isDisposed() {
                return get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
            }
        }
    }

    static final class b<T, C extends Collection<? super T>> extends AtomicReference<c> implements w<Object>, c {
        private static final long serialVersionUID = -8498650778633225126L;
        final long index;
        final a<T, C, ?, ?> parent;

        b(a<T, C, ?, ?> aVar, long j) {
            this.parent = aVar;
            this.index = j;
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }

        public final void onNext(Object obj) {
            c cVar = (c) get();
            if (cVar != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
                cVar.dispose();
                this.parent.close(this, this.index);
            }
        }

        public final void onError(Throwable th) {
            if (get() != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
                this.parent.boundaryError(this, th);
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void onComplete() {
            if (get() != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
                this.parent.close(this, this.index);
            }
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
        }
    }
}
