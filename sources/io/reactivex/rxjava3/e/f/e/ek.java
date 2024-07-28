package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.c.j;
import io.reactivex.rxjava3.j.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ek<T, B, V> extends a<T, p<T>> {

    /* renamed from: b  reason: collision with root package name */
    final u<B> f47412b;

    /* renamed from: c  reason: collision with root package name */
    final h<? super B, ? extends u<V>> f47413c;

    /* renamed from: d  reason: collision with root package name */
    final int f47414d;

    public ek(u<T> uVar, u<B> uVar2, h<? super B, ? extends u<V>> hVar, int i2) {
        super(uVar);
        this.f47412b = uVar2;
        this.f47413c = hVar;
        this.f47414d = i2;
    }

    public final void subscribeActual(w<? super p<T>> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47412b, this.f47413c, this.f47414d));
    }

    static final class a<T, B, V> extends AtomicInteger implements w<T>, io.reactivex.rxjava3.b.c, Runnable {
        private static final long serialVersionUID = 8646217640096099753L;
        final int bufferSize;
        final h<? super B, ? extends u<V>> closingIndicator;
        final w<? super p<T>> downstream;
        final AtomicBoolean downstreamDisposed;
        long emitted;
        final io.reactivex.rxjava3.e.k.c error;
        final u<B> open;
        volatile boolean openDone;
        final j<Object> queue = new io.reactivex.rxjava3.e.g.a();
        final AtomicLong requested;
        final io.reactivex.rxjava3.b.b resources;
        final c<B> startObserver;
        io.reactivex.rxjava3.b.c upstream;
        volatile boolean upstreamCanceled;
        volatile boolean upstreamDone;
        final AtomicLong windowCount;
        final List<f<T>> windows;

        a(w<? super p<T>> wVar, u<B> uVar, h<? super B, ? extends u<V>> hVar, int i2) {
            this.downstream = wVar;
            this.open = uVar;
            this.closingIndicator = hVar;
            this.bufferSize = i2;
            this.resources = new io.reactivex.rxjava3.b.b();
            this.windows = new ArrayList();
            this.windowCount = new AtomicLong(1);
            this.downstreamDisposed = new AtomicBoolean();
            this.error = new io.reactivex.rxjava3.e.k.c();
            this.startObserver = new c<>(this);
            this.requested = new AtomicLong();
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                this.open.subscribe(this.startObserver);
            }
        }

        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public final void onError(Throwable th) {
            this.startObserver.dispose();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(th)) {
                this.upstreamDone = true;
                drain();
            }
        }

        public final void onComplete() {
            this.startObserver.dispose();
            this.resources.dispose();
            this.upstreamDone = true;
            drain();
        }

        public final void dispose() {
            if (!this.downstreamDisposed.compareAndSet(false, true)) {
                return;
            }
            if (this.windowCount.decrementAndGet() == 0) {
                this.upstream.dispose();
                this.startObserver.dispose();
                this.resources.dispose();
                this.error.tryTerminateAndReport();
                this.upstreamCanceled = true;
                drain();
                return;
            }
            this.startObserver.dispose();
        }

        public final boolean isDisposed() {
            return this.downstreamDisposed.get();
        }

        public final void run() {
            if (this.windowCount.decrementAndGet() == 0) {
                this.upstream.dispose();
                this.startObserver.dispose();
                this.resources.dispose();
                this.error.tryTerminateAndReport();
                this.upstreamCanceled = true;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final void open(B b2) {
            this.queue.offer(new b(b2));
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void openError(Throwable th) {
            this.upstream.dispose();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(th)) {
                this.upstreamDone = true;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final void openComplete() {
            this.openDone = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void close(C0816a<T, V> aVar) {
            this.queue.offer(aVar);
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void closeError(Throwable th) {
            this.upstream.dispose();
            this.startObserver.dispose();
            this.resources.dispose();
            if (this.error.tryAddThrowableOrReport(th)) {
                this.upstreamDone = true;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                w<? super p<T>> wVar = this.downstream;
                j<Object> jVar = this.queue;
                List<f<T>> list = this.windows;
                int i2 = 1;
                while (true) {
                    if (this.upstreamCanceled) {
                        jVar.clear();
                        list.clear();
                    } else {
                        boolean z = this.upstreamDone;
                        Object poll = jVar.poll();
                        boolean z2 = false;
                        boolean z3 = poll == null;
                        if (z && (z3 || this.error.get() != null)) {
                            terminateDownstream(wVar);
                            this.upstreamCanceled = true;
                        } else if (!z3) {
                            if (poll instanceof b) {
                                if (!this.downstreamDisposed.get()) {
                                    try {
                                        u uVar = (u) Objects.requireNonNull(this.closingIndicator.apply(((b) poll).f47419a), "The closingIndicator returned a null ObservableSource");
                                        this.windowCount.getAndIncrement();
                                        f a2 = f.a(this.bufferSize, (Runnable) this);
                                        C0816a aVar = new C0816a(this, a2);
                                        wVar.onNext(aVar);
                                        if (!aVar.f47418d.get() && aVar.f47418d.compareAndSet(false, true)) {
                                            z2 = true;
                                        }
                                        if (z2) {
                                            a2.onComplete();
                                        } else {
                                            list.add(a2);
                                            this.resources.a((io.reactivex.rxjava3.b.c) aVar);
                                            uVar.subscribe(aVar);
                                        }
                                    } catch (Throwable th) {
                                        io.reactivex.rxjava3.c.b.b(th);
                                        this.upstream.dispose();
                                        this.startObserver.dispose();
                                        this.resources.dispose();
                                        io.reactivex.rxjava3.c.b.b(th);
                                        this.error.tryAddThrowableOrReport(th);
                                        this.upstreamDone = true;
                                    }
                                }
                            } else if (poll instanceof C0816a) {
                                f<T> fVar = ((C0816a) poll).f47416b;
                                list.remove(fVar);
                                this.resources.c((io.reactivex.rxjava3.b.c) poll);
                                fVar.onComplete();
                            } else {
                                for (f<T> onNext : list) {
                                    onNext.onNext(poll);
                                }
                            }
                        } else if (this.openDone && list.size() == 0) {
                            this.upstream.dispose();
                            this.startObserver.dispose();
                            this.resources.dispose();
                            terminateDownstream(wVar);
                            this.upstreamCanceled = true;
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void terminateDownstream(w<?> wVar) {
            Throwable terminate = this.error.terminate();
            if (terminate == null) {
                for (f<T> onComplete : this.windows) {
                    onComplete.onComplete();
                }
                wVar.onComplete();
            } else if (terminate != io.reactivex.rxjava3.e.k.j.f47736a) {
                for (f<T> onError : this.windows) {
                    onError.onError(terminate);
                }
                wVar.onError(terminate);
            }
        }

        static final class b<B> {

            /* renamed from: a  reason: collision with root package name */
            final B f47419a;

            b(B b2) {
                this.f47419a = b2;
            }
        }

        static final class c<B> extends AtomicReference<io.reactivex.rxjava3.b.c> implements w<B> {
            private static final long serialVersionUID = -3326496781427702834L;
            final a<?, B, ?> parent;

            c(a<?, B, ?> aVar) {
                this.parent = aVar;
            }

            public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
                io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
            }

            public final void onNext(B b2) {
                this.parent.open(b2);
            }

            public final void onError(Throwable th) {
                this.parent.openError(th);
            }

            public final void onComplete() {
                this.parent.openComplete();
            }

            /* access modifiers changed from: package-private */
            public final void dispose() {
                io.reactivex.rxjava3.e.a.c.dispose(this);
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.ek$a$a  reason: collision with other inner class name */
        static final class C0816a<T, V> extends p<T> implements w<V>, io.reactivex.rxjava3.b.c {

            /* renamed from: a  reason: collision with root package name */
            final a<T, ?, V> f47415a;

            /* renamed from: b  reason: collision with root package name */
            final f<T> f47416b;

            /* renamed from: c  reason: collision with root package name */
            final AtomicReference<io.reactivex.rxjava3.b.c> f47417c = new AtomicReference<>();

            /* renamed from: d  reason: collision with root package name */
            final AtomicBoolean f47418d = new AtomicBoolean();

            C0816a(a<T, ?, V> aVar, f<T> fVar) {
                this.f47415a = aVar;
                this.f47416b = fVar;
            }

            public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
                io.reactivex.rxjava3.e.a.c.setOnce(this.f47417c, cVar);
            }

            public final void onNext(V v) {
                if (io.reactivex.rxjava3.e.a.c.dispose(this.f47417c)) {
                    this.f47415a.close(this);
                }
            }

            public final void onError(Throwable th) {
                if (isDisposed()) {
                    io.reactivex.rxjava3.h.a.a(th);
                } else {
                    this.f47415a.closeError(th);
                }
            }

            public final void onComplete() {
                this.f47415a.close(this);
            }

            public final void dispose() {
                io.reactivex.rxjava3.e.a.c.dispose(this.f47417c);
            }

            public final boolean isDisposed() {
                return this.f47417c.get() == io.reactivex.rxjava3.e.a.c.DISPOSED;
            }

            public final void subscribeActual(w<? super T> wVar) {
                this.f47416b.subscribe(wVar);
                this.f47418d.set(true);
            }
        }
    }
}
