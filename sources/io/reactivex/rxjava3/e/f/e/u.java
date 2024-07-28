package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.c.b;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.c.f;
import io.reactivex.rxjava3.e.c.k;
import io.reactivex.rxjava3.e.e.q;
import io.reactivex.rxjava3.e.e.r;
import io.reactivex.rxjava3.e.k.i;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class u<T, R> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends io.reactivex.rxjava3.a.u<? extends R>> f47558b;

    /* renamed from: c  reason: collision with root package name */
    final i f47559c;

    /* renamed from: d  reason: collision with root package name */
    final int f47560d;

    /* renamed from: e  reason: collision with root package name */
    final int f47561e;

    public u(io.reactivex.rxjava3.a.u<T> uVar, h<? super T, ? extends io.reactivex.rxjava3.a.u<? extends R>> hVar, i iVar, int i2, int i3) {
        super(uVar);
        this.f47558b = hVar;
        this.f47559c = iVar;
        this.f47560d = i2;
        this.f47561e = i3;
    }

    public final void subscribeActual(w<? super R> wVar) {
        this.f46900a.subscribe(new a(wVar, this.f47558b, this.f47560d, this.f47561e, this.f47559c));
    }

    static final class a<T, R> extends AtomicInteger implements w<T>, c, r<R> {
        private static final long serialVersionUID = 8080567949447303262L;
        int activeCount;
        volatile boolean cancelled;
        q<R> current;
        volatile boolean done;
        final w<? super R> downstream;
        final i errorMode;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        final h<? super T, ? extends io.reactivex.rxjava3.a.u<? extends R>> mapper;
        final int maxConcurrency;
        final ArrayDeque<q<R>> observers = new ArrayDeque<>();
        final int prefetch;
        k<T> queue;
        int sourceMode;
        c upstream;

        a(w<? super R> wVar, h<? super T, ? extends io.reactivex.rxjava3.a.u<? extends R>> hVar, int i2, int i3, i iVar) {
            this.downstream = wVar;
            this.mapper = hVar;
            this.maxConcurrency = i2;
            this.prefetch = i3;
            this.errorMode = iVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof f) {
                    f fVar = (f) cVar;
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
                this.queue = new io.reactivex.rxjava3.e.g.c(this.prefetch);
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

        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                this.errors.tryTerminateAndReport();
                drainAndDispose();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drainAndDispose() {
            if (getAndIncrement() == 0) {
                do {
                    this.queue.clear();
                    disposeAll();
                } while (decrementAndGet() != 0);
            }
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public final void disposeAll() {
            q<R> qVar = this.current;
            if (qVar != null) {
                qVar.dispose();
            }
            while (true) {
                q poll = this.observers.poll();
                if (poll != null) {
                    poll.dispose();
                } else {
                    return;
                }
            }
        }

        public final void innerNext(q<R> qVar, R r) {
            qVar.queue().offer(r);
            drain();
        }

        public final void innerError(q<R> qVar, Throwable th) {
            if (this.errors.tryAddThrowableOrReport(th)) {
                if (this.errorMode == i.IMMEDIATE) {
                    this.upstream.dispose();
                }
                qVar.setDone();
                drain();
            }
        }

        public final void innerComplete(q<R> qVar) {
            qVar.setDone();
            drain();
        }

        public final void drain() {
            if (getAndIncrement() == 0) {
                k<T> kVar = this.queue;
                ArrayDeque<q<R>> arrayDeque = this.observers;
                w<? super R> wVar = this.downstream;
                i iVar = this.errorMode;
                int i2 = 1;
                while (true) {
                    int i3 = this.activeCount;
                    while (true) {
                        if (i3 == this.maxConcurrency) {
                            break;
                        } else if (this.cancelled) {
                            kVar.clear();
                            disposeAll();
                            return;
                        } else if (iVar != i.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                            try {
                                T poll = kVar.poll();
                                if (poll == null) {
                                    break;
                                }
                                io.reactivex.rxjava3.a.u uVar = (io.reactivex.rxjava3.a.u) Objects.requireNonNull(this.mapper.apply(poll), "The mapper returned a null ObservableSource");
                                q qVar = new q(this, this.prefetch);
                                arrayDeque.offer(qVar);
                                uVar.subscribe(qVar);
                                i3++;
                            } catch (Throwable th) {
                                b.b(th);
                                this.upstream.dispose();
                                kVar.clear();
                                disposeAll();
                                this.errors.tryAddThrowableOrReport(th);
                                this.errors.tryTerminateConsumer((w<?>) this.downstream);
                                return;
                            }
                        } else {
                            kVar.clear();
                            disposeAll();
                            this.errors.tryTerminateConsumer((w<?>) this.downstream);
                            return;
                        }
                    }
                    this.activeCount = i3;
                    if (this.cancelled) {
                        kVar.clear();
                        disposeAll();
                        return;
                    } else if (iVar != i.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                        q<R> qVar2 = this.current;
                        if (qVar2 == null) {
                            if (iVar != i.BOUNDARY || ((Throwable) this.errors.get()) == null) {
                                boolean z = this.done;
                                q<R> poll2 = arrayDeque.poll();
                                boolean z2 = poll2 == null;
                                if (!z || !z2) {
                                    if (!z2) {
                                        this.current = poll2;
                                    }
                                    qVar2 = poll2;
                                } else if (((Throwable) this.errors.get()) != null) {
                                    kVar.clear();
                                    disposeAll();
                                    this.errors.tryTerminateConsumer((w<?>) wVar);
                                    return;
                                } else {
                                    wVar.onComplete();
                                    return;
                                }
                            } else {
                                kVar.clear();
                                disposeAll();
                                this.errors.tryTerminateConsumer((w<?>) wVar);
                                return;
                            }
                        }
                        if (qVar2 != null) {
                            k<R> queue2 = qVar2.queue();
                            while (!this.cancelled) {
                                boolean isDone = qVar2.isDone();
                                if (iVar != i.IMMEDIATE || ((Throwable) this.errors.get()) == null) {
                                    try {
                                        R poll3 = queue2.poll();
                                        boolean z3 = poll3 == null;
                                        if (isDone && z3) {
                                            this.current = null;
                                            this.activeCount--;
                                        } else if (!z3) {
                                            wVar.onNext(poll3);
                                        }
                                    } catch (Throwable th2) {
                                        b.b(th2);
                                        this.errors.tryAddThrowableOrReport(th2);
                                        this.current = null;
                                        this.activeCount--;
                                    }
                                } else {
                                    kVar.clear();
                                    disposeAll();
                                    this.errors.tryTerminateConsumer((w<?>) wVar);
                                    return;
                                }
                            }
                            kVar.clear();
                            disposeAll();
                            return;
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        kVar.clear();
                        disposeAll();
                        this.errors.tryTerminateConsumer((w<?>) this.downstream);
                        return;
                    }
                }
            }
        }
    }
}
