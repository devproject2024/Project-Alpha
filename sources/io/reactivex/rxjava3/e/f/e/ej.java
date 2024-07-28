package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.j.f;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ej<T, B> extends a<T, p<T>> {

    /* renamed from: b  reason: collision with root package name */
    final u<B> f47408b;

    /* renamed from: c  reason: collision with root package name */
    final int f47409c;

    public ej(u<T> uVar, u<B> uVar2, int i2) {
        super(uVar);
        this.f47408b = uVar2;
        this.f47409c = i2;
    }

    public final void subscribeActual(w<? super p<T>> wVar) {
        b bVar = new b(wVar, this.f47409c);
        wVar.onSubscribe(bVar);
        this.f47408b.subscribe(bVar.boundaryObserver);
        this.f46900a.subscribe(bVar);
    }

    static final class b<T, B> extends AtomicInteger implements w<T>, c, Runnable {
        static final Object NEXT_WINDOW = new Object();
        private static final long serialVersionUID = 2233020065421370272L;
        final a<T, B> boundaryObserver = new a<>(this);
        final int capacityHint;
        volatile boolean done;
        final w<? super p<T>> downstream;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        final io.reactivex.rxjava3.e.g.a<Object> queue = new io.reactivex.rxjava3.e.g.a<>();
        final AtomicBoolean stopWindows = new AtomicBoolean();
        final AtomicReference<c> upstream = new AtomicReference<>();
        f<T> window;
        final AtomicInteger windows = new AtomicInteger(1);

        b(w<? super p<T>> wVar, int i2) {
            this.downstream = wVar;
            this.capacityHint = i2;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.setOnce(this.upstream, cVar)) {
                innerNext();
            }
        }

        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public final void onError(Throwable th) {
            this.boundaryObserver.dispose();
            if (this.errors.tryAddThrowableOrReport(th)) {
                this.done = true;
                drain();
            }
        }

        public final void onComplete() {
            this.boundaryObserver.dispose();
            this.done = true;
            drain();
        }

        public final void dispose() {
            if (this.stopWindows.compareAndSet(false, true)) {
                this.boundaryObserver.dispose();
                if (this.windows.decrementAndGet() == 0) {
                    io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
                }
            }
        }

        public final boolean isDisposed() {
            return this.stopWindows.get();
        }

        public final void run() {
            if (this.windows.decrementAndGet() == 0) {
                io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerNext() {
            this.queue.offer(NEXT_WINDOW);
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void innerError(Throwable th) {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            if (this.errors.tryAddThrowableOrReport(th)) {
                this.done = true;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerComplete() {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            this.done = true;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                w<? super p<T>> wVar = this.downstream;
                io.reactivex.rxjava3.e.g.a<Object> aVar = this.queue;
                io.reactivex.rxjava3.e.k.c cVar = this.errors;
                int i2 = 1;
                while (this.windows.get() != 0) {
                    f<T> fVar = this.window;
                    boolean z = this.done;
                    if (!z || cVar.get() == null) {
                        Object poll = aVar.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            Throwable terminate = cVar.terminate();
                            if (terminate == null) {
                                if (fVar != null) {
                                    this.window = null;
                                    fVar.onComplete();
                                }
                                wVar.onComplete();
                                return;
                            }
                            if (fVar != null) {
                                this.window = null;
                                fVar.onError(terminate);
                            }
                            wVar.onError(terminate);
                            return;
                        } else if (z2) {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        } else if (poll != NEXT_WINDOW) {
                            fVar.onNext(poll);
                        } else {
                            if (fVar != null) {
                                this.window = null;
                                fVar.onComplete();
                            }
                            if (!this.stopWindows.get()) {
                                f<T> a2 = f.a(this.capacityHint, (Runnable) this);
                                this.window = a2;
                                this.windows.getAndIncrement();
                                el elVar = new el(a2);
                                wVar.onNext(elVar);
                                if (elVar.a()) {
                                    a2.onComplete();
                                }
                            }
                        }
                    } else {
                        aVar.clear();
                        Throwable terminate2 = cVar.terminate();
                        if (fVar != null) {
                            this.window = null;
                            fVar.onError(terminate2);
                        }
                        wVar.onError(terminate2);
                        return;
                    }
                }
                aVar.clear();
                this.window = null;
            }
        }
    }

    static final class a<T, B> extends io.reactivex.rxjava3.g.c<B> {

        /* renamed from: a  reason: collision with root package name */
        final b<T, B> f47410a;

        /* renamed from: b  reason: collision with root package name */
        boolean f47411b;

        a(b<T, B> bVar) {
            this.f47410a = bVar;
        }

        public final void onNext(B b2) {
            if (!this.f47411b) {
                this.f47410a.innerNext();
            }
        }

        public final void onError(Throwable th) {
            if (this.f47411b) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.f47411b = true;
            this.f47410a.innerError(th);
        }

        public final void onComplete() {
            if (!this.f47411b) {
                this.f47411b = true;
                this.f47410a.innerComplete();
            }
        }
    }
}
