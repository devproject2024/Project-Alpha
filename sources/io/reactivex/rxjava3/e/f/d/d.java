package io.reactivex.rxjava3.e.f.d;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.c.j;
import io.reactivex.rxjava3.e.k.i;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class d<T, R> extends p<R> {

    /* renamed from: a  reason: collision with root package name */
    final u<T> f46879a;

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends ac<? extends R>> f46880b;

    /* renamed from: c  reason: collision with root package name */
    final i f46881c;

    /* renamed from: d  reason: collision with root package name */
    final int f46882d;

    public d(u<T> uVar, h<? super T, ? extends ac<? extends R>> hVar, i iVar, int i2) {
        this.f46879a = uVar;
        this.f46880b = hVar;
        this.f46881c = iVar;
        this.f46882d = i2;
    }

    public final void subscribeActual(w<? super R> wVar) {
        if (!h.b(this.f46879a, this.f46880b, wVar)) {
            this.f46879a.subscribe(new a(wVar, this.f46880b, this.f46882d, this.f46881c));
        }
    }

    static final class a<T, R> extends AtomicInteger implements w<T>, c {
        static final int STATE_ACTIVE = 1;
        static final int STATE_INACTIVE = 0;
        static final int STATE_RESULT_VALUE = 2;
        private static final long serialVersionUID = -9140123220065488293L;
        volatile boolean cancelled;
        volatile boolean done;
        final w<? super R> downstream;
        final i errorMode;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        final C0797a<R> inner = new C0797a<>(this);
        R item;
        final h<? super T, ? extends ac<? extends R>> mapper;
        final j<T> queue;
        volatile int state;
        c upstream;

        a(w<? super R> wVar, h<? super T, ? extends ac<? extends R>> hVar, int i2, i iVar) {
            this.downstream = wVar;
            this.mapper = hVar;
            this.errorMode = iVar;
            this.queue = new io.reactivex.rxjava3.e.g.c(i2);
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            this.queue.offer(t);
            drain();
        }

        public final void onError(Throwable th) {
            if (this.errors.tryAddThrowableOrReport(th)) {
                if (this.errorMode == i.IMMEDIATE) {
                    this.inner.dispose();
                }
                this.done = true;
                drain();
            }
        }

        public final void onComplete() {
            this.done = true;
            drain();
        }

        public final void dispose() {
            this.cancelled = true;
            this.upstream.dispose();
            this.inner.dispose();
            this.errors.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.queue.clear();
                this.item = null;
            }
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public final void innerSuccess(R r) {
            this.item = r;
            this.state = 2;
            drain();
        }

        /* access modifiers changed from: package-private */
        public final void innerError(Throwable th) {
            if (this.errors.tryAddThrowableOrReport(th)) {
                if (this.errorMode != i.END) {
                    this.upstream.dispose();
                }
                this.state = 0;
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                w<? super R> wVar = this.downstream;
                i iVar = this.errorMode;
                j<T> jVar = this.queue;
                io.reactivex.rxjava3.e.k.c cVar = this.errors;
                int i2 = 1;
                while (true) {
                    if (this.cancelled) {
                        jVar.clear();
                        this.item = null;
                    } else {
                        int i3 = this.state;
                        if (cVar.get() == null || !(iVar == i.IMMEDIATE || (iVar == i.BOUNDARY && i3 == 0))) {
                            boolean z = false;
                            if (i3 == 0) {
                                boolean z2 = this.done;
                                T poll = jVar.poll();
                                if (poll == null) {
                                    z = true;
                                }
                                if (z2 && z) {
                                    cVar.tryTerminateConsumer((w<?>) wVar);
                                    return;
                                } else if (!z) {
                                    try {
                                        ac acVar = (ac) Objects.requireNonNull(this.mapper.apply(poll), "The mapper returned a null SingleSource");
                                        this.state = 1;
                                        acVar.a(this.inner);
                                    } catch (Throwable th) {
                                        b.b(th);
                                        this.upstream.dispose();
                                        jVar.clear();
                                        cVar.tryAddThrowableOrReport(th);
                                        cVar.tryTerminateConsumer((w<?>) wVar);
                                        return;
                                    }
                                }
                            } else if (i3 == 2) {
                                R r = this.item;
                                this.item = null;
                                wVar.onNext(r);
                                this.state = 0;
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                jVar.clear();
                this.item = null;
                cVar.tryTerminateConsumer((w<?>) wVar);
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.f.d.d$a$a  reason: collision with other inner class name */
        static final class C0797a<R> extends AtomicReference<c> implements aa<R> {
            private static final long serialVersionUID = -3051469169682093892L;
            final a<?, R> parent;

            C0797a(a<?, R> aVar) {
                this.parent = aVar;
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.replace(this, cVar);
            }

            public final void onSuccess(R r) {
                this.parent.innerSuccess(r);
            }

            public final void onError(Throwable th) {
                this.parent.innerError(th);
            }

            /* access modifiers changed from: package-private */
            public final void dispose() {
                io.reactivex.rxjava3.e.a.c.dispose(this);
            }
        }
    }
}
