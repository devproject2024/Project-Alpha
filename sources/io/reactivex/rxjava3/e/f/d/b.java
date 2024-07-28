package io.reactivex.rxjava3.e.f.d;

import io.reactivex.rxjava3.a.d;
import io.reactivex.rxjava3.a.f;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.c.k;
import io.reactivex.rxjava3.e.k.i;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class b<T> extends io.reactivex.rxjava3.a.b {

    /* renamed from: a  reason: collision with root package name */
    final p<T> f46871a;

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends f> f46872b;

    /* renamed from: c  reason: collision with root package name */
    final i f46873c;

    /* renamed from: d  reason: collision with root package name */
    final int f46874d;

    public b(p<T> pVar, h<? super T, ? extends f> hVar, i iVar, int i2) {
        this.f46871a = pVar;
        this.f46872b = hVar;
        this.f46873c = iVar;
        this.f46874d = i2;
    }

    public final void b(d dVar) {
        if (!h.a((Object) this.f46871a, this.f46872b, dVar)) {
            this.f46871a.subscribe(new a(dVar, this.f46872b, this.f46873c, this.f46874d));
        }
    }

    static final class a<T> extends AtomicInteger implements w<T>, c {
        private static final long serialVersionUID = 3610901111000061034L;
        volatile boolean active;
        volatile boolean disposed;
        volatile boolean done;
        final d downstream;
        final i errorMode;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        final C0795a inner = new C0795a(this);
        final h<? super T, ? extends f> mapper;
        final int prefetch;
        k<T> queue;
        c upstream;

        a(d dVar, h<? super T, ? extends f> hVar, i iVar, int i2) {
            this.downstream = dVar;
            this.mapper = hVar;
            this.errorMode = iVar;
            this.prefetch = i2;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof io.reactivex.rxjava3.e.c.f) {
                    io.reactivex.rxjava3.e.c.f fVar = (io.reactivex.rxjava3.e.c.f) cVar;
                    int requestFusion = fVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.queue = fVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.queue = fVar;
                        this.downstream.onSubscribe(this);
                        return;
                    }
                }
                this.queue = new io.reactivex.rxjava3.e.g.c(this.prefetch);
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (t != null) {
                this.queue.offer(t);
            }
            drain();
        }

        public final void onError(Throwable th) {
            if (!this.errors.tryAddThrowableOrReport(th)) {
                return;
            }
            if (this.errorMode == i.IMMEDIATE) {
                this.disposed = true;
                this.inner.dispose();
                this.errors.tryTerminateConsumer(this.downstream);
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                    return;
                }
                return;
            }
            this.done = true;
            drain();
        }

        public final void onComplete() {
            this.done = true;
            drain();
        }

        public final void dispose() {
            this.disposed = true;
            this.upstream.dispose();
            this.inner.dispose();
            this.errors.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        public final boolean isDisposed() {
            return this.disposed;
        }

        /* access modifiers changed from: package-private */
        public final void innerError(Throwable th) {
            if (!this.errors.tryAddThrowableOrReport(th)) {
                return;
            }
            if (this.errorMode == i.IMMEDIATE) {
                this.disposed = true;
                this.upstream.dispose();
                this.errors.tryTerminateConsumer(this.downstream);
                if (getAndIncrement() == 0) {
                    this.queue.clear();
                    return;
                }
                return;
            }
            this.active = false;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void innerComplete() {
            this.active = false;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            boolean z;
            if (getAndIncrement() == 0) {
                io.reactivex.rxjava3.e.k.c cVar = this.errors;
                i iVar = this.errorMode;
                while (!this.disposed) {
                    if (!this.active) {
                        if (iVar != i.BOUNDARY || cVar.get() == null) {
                            boolean z2 = this.done;
                            f fVar = null;
                            try {
                                T poll = this.queue.poll();
                                if (poll != null) {
                                    fVar = (f) Objects.requireNonNull(this.mapper.apply(poll), "The mapper returned a null CompletableSource");
                                    z = false;
                                } else {
                                    z = true;
                                }
                                if (z2 && z) {
                                    this.disposed = true;
                                    cVar.tryTerminateConsumer(this.downstream);
                                    return;
                                } else if (!z) {
                                    this.active = true;
                                    fVar.a(this.inner);
                                }
                            } catch (Throwable th) {
                                io.reactivex.rxjava3.c.b.b(th);
                                this.disposed = true;
                                this.queue.clear();
                                this.upstream.dispose();
                                cVar.tryAddThrowableOrReport(th);
                                cVar.tryTerminateConsumer(this.downstream);
                                return;
                            }
                        } else {
                            this.disposed = true;
                            this.queue.clear();
                            cVar.tryTerminateConsumer(this.downstream);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.queue.clear();
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.d.b$a$a  reason: collision with other inner class name */
        static final class C0795a extends AtomicReference<c> implements d {
            private static final long serialVersionUID = 5638352172918776687L;
            final a<?> parent;

            C0795a(a<?> aVar) {
                this.parent = aVar;
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.replace(this, cVar);
            }

            public final void onError(Throwable th) {
                this.parent.innerError(th);
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
}
