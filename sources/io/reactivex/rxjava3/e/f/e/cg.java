package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.c.f;
import io.reactivex.rxjava3.e.c.k;
import io.reactivex.rxjava3.e.e.b;
import io.reactivex.rxjava3.e.h.p;

public final class cg<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final x f47159b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f47160c;

    /* renamed from: d  reason: collision with root package name */
    final int f47161d;

    public cg(u<T> uVar, x xVar, boolean z, int i2) {
        super(uVar);
        this.f47159b = xVar;
        this.f47160c = z;
        this.f47161d = i2;
    }

    public final void subscribeActual(w<? super T> wVar) {
        x xVar = this.f47159b;
        if (xVar instanceof p) {
            this.f46900a.subscribe(wVar);
            return;
        }
        this.f46900a.subscribe(new a(wVar, xVar.a(), this.f47160c, this.f47161d));
    }

    static final class a<T> extends b<T> implements w<T>, Runnable {
        private static final long serialVersionUID = 6576896619930983584L;
        final int bufferSize;
        final boolean delayError;
        volatile boolean disposed;
        volatile boolean done;
        final w<? super T> downstream;
        Throwable error;
        boolean outputFused;
        k<T> queue;
        int sourceMode;
        c upstream;
        final x.c worker;

        a(w<? super T> wVar, x.c cVar, boolean z, int i2) {
            this.downstream = wVar;
            this.worker = cVar;
            this.delayError = z;
            this.bufferSize = i2;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof f) {
                    f fVar = (f) cVar;
                    int requestFusion = fVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = fVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        schedule();
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
            if (!this.done) {
                if (this.sourceMode != 2) {
                    this.queue.offer(t);
                }
                schedule();
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.error = th;
            this.done = true;
            schedule();
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                schedule();
            }
        }

        public final void dispose() {
            if (!this.disposed) {
                this.disposed = true;
                this.upstream.dispose();
                this.worker.dispose();
                if (!this.outputFused && getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.disposed;
        }

        /* access modifiers changed from: package-private */
        public final void schedule() {
            if (getAndIncrement() == 0) {
                this.worker.a((Runnable) this);
            }
        }

        /* access modifiers changed from: package-private */
        public final void drainNormal() {
            k<T> kVar = this.queue;
            w<? super T> wVar = this.downstream;
            int i2 = 1;
            while (!checkTerminated(this.done, kVar.isEmpty(), wVar)) {
                while (true) {
                    boolean z = this.done;
                    try {
                        T poll = kVar.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2, wVar)) {
                            if (!z2) {
                                wVar.onNext(poll);
                            } else {
                                i2 = addAndGet(-i2);
                                if (i2 == 0) {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        this.disposed = true;
                        this.upstream.dispose();
                        kVar.clear();
                        wVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void drainFused() {
            int i2 = 1;
            while (!this.disposed) {
                boolean z = this.done;
                Throwable th = this.error;
                if (this.delayError || !z || th == null) {
                    this.downstream.onNext(null);
                    if (z) {
                        this.disposed = true;
                        Throwable th2 = this.error;
                        if (th2 != null) {
                            this.downstream.onError(th2);
                        } else {
                            this.downstream.onComplete();
                        }
                        this.worker.dispose();
                        return;
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    this.disposed = true;
                    this.downstream.onError(th);
                    this.worker.dispose();
                    return;
                }
            }
        }

        public final void run() {
            if (this.outputFused) {
                drainFused();
            } else {
                drainNormal();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(boolean z, boolean z2, w<? super T> wVar) {
            if (this.disposed) {
                this.queue.clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                Throwable th = this.error;
                if (this.delayError) {
                    if (!z2) {
                        return false;
                    }
                    this.disposed = true;
                    if (th != null) {
                        wVar.onError(th);
                    } else {
                        wVar.onComplete();
                    }
                    this.worker.dispose();
                    return true;
                } else if (th != null) {
                    this.disposed = true;
                    this.queue.clear();
                    wVar.onError(th);
                    this.worker.dispose();
                    return true;
                } else if (!z2) {
                    return false;
                } else {
                    this.disposed = true;
                    wVar.onComplete();
                    this.worker.dispose();
                    return true;
                }
            }
        }

        public final int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            this.outputFused = true;
            return 2;
        }

        public final T poll() throws Throwable {
            return this.queue.poll();
        }

        public final void clear() {
            this.queue.clear();
        }

        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }
}
