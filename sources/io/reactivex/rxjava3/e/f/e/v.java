package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.c.k;
import io.reactivex.rxjava3.e.k.i;
import io.reactivex.rxjava3.g.f;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class v<T, U> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends u<? extends U>> f47562b;

    /* renamed from: c  reason: collision with root package name */
    final int f47563c;

    /* renamed from: d  reason: collision with root package name */
    final i f47564d;

    /* renamed from: e  reason: collision with root package name */
    final x f47565e;

    public v(u<T> uVar, h<? super T, ? extends u<? extends U>> hVar, int i2, i iVar, x xVar) {
        super(uVar);
        this.f47562b = hVar;
        this.f47564d = iVar;
        this.f47563c = Math.max(8, i2);
        this.f47565e = xVar;
    }

    public final void subscribeActual(w<? super U> wVar) {
        if (this.f47564d == i.IMMEDIATE) {
            this.f46900a.subscribe(new b(new f(wVar), this.f47562b, this.f47563c, this.f47565e.a()));
        } else {
            this.f46900a.subscribe(new a(wVar, this.f47562b, this.f47563c, this.f47564d == i.END, this.f47565e.a()));
        }
    }

    static final class b<T, U> extends AtomicInteger implements w<T>, c, Runnable {
        private static final long serialVersionUID = 8828587559905699186L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean disposed;
        volatile boolean done;
        final w<? super U> downstream;
        int fusionMode;
        final a<U> inner;
        final h<? super T, ? extends u<? extends U>> mapper;
        k<T> queue;
        c upstream;
        final x.c worker;

        b(w<? super U> wVar, h<? super T, ? extends u<? extends U>> hVar, int i2, x.c cVar) {
            this.downstream = wVar;
            this.mapper = hVar;
            this.bufferSize = i2;
            this.inner = new a<>(wVar, this);
            this.worker = cVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof io.reactivex.rxjava3.e.c.f) {
                    io.reactivex.rxjava3.e.c.f fVar = (io.reactivex.rxjava3.e.c.f) cVar;
                    int requestFusion = fVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = fVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = fVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.rxjava3.e.g.c(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.done) {
                if (this.fusionMode == 0) {
                    this.queue.offer(t);
                }
                drain();
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.done = true;
            dispose();
            this.downstream.onError(th);
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerComplete() {
            this.active = false;
            drain();
        }

        public final boolean isDisposed() {
            return this.disposed;
        }

        public final void dispose() {
            this.disposed = true;
            this.inner.dispose();
            this.upstream.dispose();
            this.worker.dispose();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                this.worker.a((Runnable) this);
            }
        }

        public final void run() {
            while (!this.disposed) {
                if (!this.active) {
                    boolean z = this.done;
                    try {
                        T poll = this.queue.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.disposed = true;
                            this.downstream.onComplete();
                            this.worker.dispose();
                            return;
                        } else if (!z2) {
                            try {
                                u uVar = (u) Objects.requireNonNull(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                this.active = true;
                                uVar.subscribe(this.inner);
                            } catch (Throwable th) {
                                io.reactivex.rxjava3.c.b.b(th);
                                dispose();
                                this.queue.clear();
                                this.downstream.onError(th);
                                this.worker.dispose();
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        io.reactivex.rxjava3.c.b.b(th2);
                        dispose();
                        this.queue.clear();
                        this.downstream.onError(th2);
                        this.worker.dispose();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.queue.clear();
        }

        static final class a<U> extends AtomicReference<c> implements w<U> {
            private static final long serialVersionUID = -7449079488798789337L;
            final w<? super U> downstream;
            final b<?, ?> parent;

            a(w<? super U> wVar, b<?, ?> bVar) {
                this.downstream = wVar;
                this.parent = bVar;
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.replace(this, cVar);
            }

            public final void onNext(U u) {
                this.downstream.onNext(u);
            }

            public final void onError(Throwable th) {
                this.parent.dispose();
                this.downstream.onError(th);
            }

            public final void onComplete() {
                this.parent.innerComplete();
            }

            /* access modifiers changed from: package-private */
            public final void dispose() {
                io.reactivex.rxjava3.e.a.c.dispose(this);
            }
        }
    }

    static final class a<T, R> extends AtomicInteger implements w<T>, c, Runnable {
        private static final long serialVersionUID = -6951100001833242599L;
        volatile boolean active;
        final int bufferSize;
        volatile boolean cancelled;
        volatile boolean done;
        final w<? super R> downstream;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        final h<? super T, ? extends u<? extends R>> mapper;
        final C0819a<R> observer;
        k<T> queue;
        int sourceMode;
        final boolean tillTheEnd;
        c upstream;
        final x.c worker;

        a(w<? super R> wVar, h<? super T, ? extends u<? extends R>> hVar, int i2, boolean z, x.c cVar) {
            this.downstream = wVar;
            this.mapper = hVar;
            this.bufferSize = i2;
            this.tillTheEnd = z;
            this.observer = new C0819a<>(wVar, this);
            this.worker = cVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof io.reactivex.rxjava3.e.c.f) {
                    io.reactivex.rxjava3.e.c.f fVar = (io.reactivex.rxjava3.e.c.f) cVar;
                    int requestFusion = fVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = fVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = fVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.rxjava3.e.g.c(this.bufferSize);
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (this.sourceMode == 0) {
                this.queue.offer(t);
            }
            drain();
        }

        public final void onError(Throwable th) {
            if (this.errors.tryAddThrowableOrReport(th)) {
                this.done = true;
                drain();
            }
        }

        public final void onComplete() {
            this.done = true;
            drain();
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        public final void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.observer.dispose();
            this.worker.dispose();
            this.errors.tryTerminateAndReport();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                this.worker.a((Runnable) this);
            }
        }

        public final void run() {
            w<? super R> wVar = this.downstream;
            k<T> kVar = this.queue;
            io.reactivex.rxjava3.e.k.c cVar = this.errors;
            while (true) {
                if (!this.active) {
                    if (this.cancelled) {
                        kVar.clear();
                        return;
                    } else if (this.tillTheEnd || ((Throwable) cVar.get()) == null) {
                        boolean z = this.done;
                        try {
                            T poll = kVar.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.cancelled = true;
                                cVar.tryTerminateConsumer((w<?>) wVar);
                                this.worker.dispose();
                                return;
                            } else if (!z2) {
                                try {
                                    u uVar = (u) Objects.requireNonNull(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                    if (uVar instanceof r) {
                                        try {
                                            Object obj = ((r) uVar).get();
                                            if (obj != null && !this.cancelled) {
                                                wVar.onNext(obj);
                                            }
                                        } catch (Throwable th) {
                                            io.reactivex.rxjava3.c.b.b(th);
                                            cVar.tryAddThrowableOrReport(th);
                                        }
                                    } else {
                                        this.active = true;
                                        uVar.subscribe(this.observer);
                                    }
                                } catch (Throwable th2) {
                                    io.reactivex.rxjava3.c.b.b(th2);
                                    this.cancelled = true;
                                    this.upstream.dispose();
                                    kVar.clear();
                                    cVar.tryAddThrowableOrReport(th2);
                                    cVar.tryTerminateConsumer((w<?>) wVar);
                                    this.worker.dispose();
                                    return;
                                }
                            }
                        } catch (Throwable th3) {
                            io.reactivex.rxjava3.c.b.b(th3);
                            this.cancelled = true;
                            this.upstream.dispose();
                            cVar.tryAddThrowableOrReport(th3);
                            cVar.tryTerminateConsumer((w<?>) wVar);
                            this.worker.dispose();
                            return;
                        }
                    } else {
                        kVar.clear();
                        this.cancelled = true;
                        cVar.tryTerminateConsumer((w<?>) wVar);
                        this.worker.dispose();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.v$a$a  reason: collision with other inner class name */
        static final class C0819a<R> extends AtomicReference<c> implements w<R> {
            private static final long serialVersionUID = 2620149119579502636L;
            final w<? super R> downstream;
            final a<?, R> parent;

            C0819a(w<? super R> wVar, a<?, R> aVar) {
                this.downstream = wVar;
                this.parent = aVar;
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.replace(this, cVar);
            }

            public final void onNext(R r) {
                this.downstream.onNext(r);
            }

            public final void onError(Throwable th) {
                a<?, R> aVar = this.parent;
                if (aVar.errors.tryAddThrowableOrReport(th)) {
                    if (!aVar.tillTheEnd) {
                        aVar.upstream.dispose();
                    }
                    aVar.active = false;
                    aVar.drain();
                }
            }

            public final void onComplete() {
                a<?, R> aVar = this.parent;
                aVar.active = false;
                aVar.drain();
            }

            /* access modifiers changed from: package-private */
            public final void dispose() {
                io.reactivex.rxjava3.e.a.c.dispose(this);
            }
        }
    }
}
