package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.h;
import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.e.j.g;
import io.reactivex.rxjava3.e.k.d;
import java.util.concurrent.atomic.AtomicLong;

public final class n<T> extends a<T, T> {

    /* renamed from: c  reason: collision with root package name */
    final x f46815c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f46816d = false;

    /* renamed from: e  reason: collision with root package name */
    final int f46817e;

    public n(h<T> hVar, x xVar, int i2) {
        super(hVar);
        this.f46815c = xVar;
        this.f46817e = i2;
    }

    public final void b(org.a.b<? super T> bVar) {
        x.c a2 = this.f46815c.a();
        if (bVar instanceof io.reactivex.rxjava3.e.c.c) {
            this.f46770b.a(new b((io.reactivex.rxjava3.e.c.c) bVar, a2, this.f46816d, this.f46817e));
        } else {
            this.f46770b.a(new c(bVar, a2, this.f46816d, this.f46817e));
        }
    }

    static abstract class a<T> extends io.reactivex.rxjava3.e.j.a<T> implements k<T>, Runnable {
        private static final long serialVersionUID = -8241002408341274697L;
        volatile boolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final int limit;
        boolean outputFused;
        final int prefetch;
        long produced;
        io.reactivex.rxjava3.e.c.k<T> queue;
        final AtomicLong requested = new AtomicLong();
        int sourceMode;
        org.a.c upstream;
        final x.c worker;

        /* access modifiers changed from: package-private */
        public abstract void runAsync();

        /* access modifiers changed from: package-private */
        public abstract void runBackfused();

        /* access modifiers changed from: package-private */
        public abstract void runSync();

        a(x.c cVar, boolean z, int i2) {
            this.worker = cVar;
            this.delayError = z;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
        }

        public final void onNext(T t) {
            if (!this.done) {
                if (this.sourceMode == 2) {
                    trySchedule();
                    return;
                }
                if (!this.queue.offer(t)) {
                    this.upstream.cancel();
                    this.error = new io.reactivex.rxjava3.c.c("Queue is full?!");
                    this.done = true;
                }
                trySchedule();
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            this.error = th;
            this.done = true;
            trySchedule();
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                trySchedule();
            }
        }

        public final void request(long j) {
            if (g.validate(j)) {
                d.a(this.requested, j);
                trySchedule();
            }
        }

        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                this.worker.dispose();
                if (!this.outputFused && getAndIncrement() == 0) {
                    this.queue.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void trySchedule() {
            if (getAndIncrement() == 0) {
                this.worker.a((Runnable) this);
            }
        }

        public final void run() {
            if (this.outputFused) {
                runBackfused();
            } else if (this.sourceMode == 1) {
                runSync();
            } else {
                runAsync();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminated(boolean z, boolean z2, org.a.b<?> bVar) {
            if (this.cancelled) {
                clear();
                return true;
            } else if (!z) {
                return false;
            } else {
                if (!this.delayError) {
                    Throwable th = this.error;
                    if (th != null) {
                        this.cancelled = true;
                        clear();
                        bVar.onError(th);
                        this.worker.dispose();
                        return true;
                    } else if (!z2) {
                        return false;
                    } else {
                        this.cancelled = true;
                        bVar.onComplete();
                        this.worker.dispose();
                        return true;
                    }
                } else if (!z2) {
                    return false;
                } else {
                    this.cancelled = true;
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        bVar.onError(th2);
                    } else {
                        bVar.onComplete();
                    }
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

        public final void clear() {
            this.queue.clear();
        }

        public final boolean isEmpty() {
            return this.queue.isEmpty();
        }
    }

    static final class c<T> extends a<T> implements k<T> {
        private static final long serialVersionUID = -4547113800637756442L;
        final org.a.b<? super T> downstream;

        c(org.a.b<? super T> bVar, x.c cVar, boolean z, int i2) {
            super(cVar, z, i2);
            this.downstream = bVar;
        }

        public final void onSubscribe(org.a.c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof io.reactivex.rxjava3.e.c.h) {
                    io.reactivex.rxjava3.e.c.h hVar = (io.reactivex.rxjava3.e.c.h) cVar;
                    int requestFusion = hVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = hVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = hVar;
                        this.downstream.onSubscribe(this);
                        cVar.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new io.reactivex.rxjava3.e.g.b(this.prefetch);
                this.downstream.onSubscribe(this);
                cVar.request((long) this.prefetch);
            }
        }

        /* access modifiers changed from: package-private */
        public final void runSync() {
            org.a.b<? super T> bVar = this.downstream;
            io.reactivex.rxjava3.e.c.k kVar = this.queue;
            long j = this.produced;
            int i2 = 1;
            do {
                long j2 = this.requested.get();
                while (j != j2) {
                    try {
                        Object poll = kVar.poll();
                        if (!this.cancelled) {
                            if (poll == null) {
                                this.cancelled = true;
                                bVar.onComplete();
                                this.worker.dispose();
                                return;
                            }
                            bVar.onNext(poll);
                            j++;
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        bVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (!this.cancelled) {
                    if (kVar.isEmpty()) {
                        this.cancelled = true;
                        bVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    this.produced = j;
                    i2 = addAndGet(-i2);
                } else {
                    return;
                }
            } while (i2 != 0);
        }

        /* access modifiers changed from: package-private */
        public final void runAsync() {
            int i2;
            org.a.b<? super T> bVar = this.downstream;
            io.reactivex.rxjava3.e.c.k kVar = this.queue;
            long j = this.produced;
            int i3 = 1;
            while (true) {
                long j2 = this.requested.get();
                while (true) {
                    i2 = (j > j2 ? 1 : (j == j2 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.done;
                    try {
                        Object poll = kVar.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2, bVar)) {
                            if (z2) {
                                break;
                            }
                            bVar.onNext(poll);
                            j++;
                            if (j == ((long) this.limit)) {
                                if (j2 != Long.MAX_VALUE) {
                                    j2 = this.requested.addAndGet(-j);
                                }
                                this.upstream.request(j);
                                j = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        kVar.clear();
                        bVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (i2 != 0 || !checkTerminated(this.done, kVar.isEmpty(), bVar)) {
                    int i4 = get();
                    if (i3 == i4) {
                        this.produced = j;
                        i3 = addAndGet(-i3);
                        if (i3 == 0) {
                            return;
                        }
                    } else {
                        i3 = i4;
                    }
                } else {
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void runBackfused() {
            int i2 = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.downstream.onNext(null);
                if (z) {
                    this.cancelled = true;
                    Throwable th = this.error;
                    if (th != null) {
                        this.downstream.onError(th);
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
            }
        }

        public final T poll() throws Throwable {
            T poll = this.queue.poll();
            if (!(poll == null || this.sourceMode == 1)) {
                long j = this.produced + 1;
                if (j == ((long) this.limit)) {
                    this.produced = 0;
                    this.upstream.request(j);
                } else {
                    this.produced = j;
                }
            }
            return poll;
        }
    }

    static final class b<T> extends a<T> {
        private static final long serialVersionUID = 644624475404284533L;
        long consumed;
        final io.reactivex.rxjava3.e.c.c<? super T> downstream;

        b(io.reactivex.rxjava3.e.c.c<? super T> cVar, x.c cVar2, boolean z, int i2) {
            super(cVar2, z, i2);
            this.downstream = cVar;
        }

        public final void onSubscribe(org.a.c cVar) {
            if (g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                if (cVar instanceof io.reactivex.rxjava3.e.c.h) {
                    io.reactivex.rxjava3.e.c.h hVar = (io.reactivex.rxjava3.e.c.h) cVar;
                    int requestFusion = hVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.sourceMode = 1;
                        this.queue = hVar;
                        this.done = true;
                        this.downstream.onSubscribe(this);
                        return;
                    } else if (requestFusion == 2) {
                        this.sourceMode = 2;
                        this.queue = hVar;
                        this.downstream.onSubscribe(this);
                        cVar.request((long) this.prefetch);
                        return;
                    }
                }
                this.queue = new io.reactivex.rxjava3.e.g.b(this.prefetch);
                this.downstream.onSubscribe(this);
                cVar.request((long) this.prefetch);
            }
        }

        /* access modifiers changed from: package-private */
        public final void runSync() {
            io.reactivex.rxjava3.e.c.c<? super T> cVar = this.downstream;
            io.reactivex.rxjava3.e.c.k kVar = this.queue;
            long j = this.produced;
            int i2 = 1;
            do {
                long j2 = this.requested.get();
                while (j != j2) {
                    try {
                        Object poll = kVar.poll();
                        if (!this.cancelled) {
                            if (poll == null) {
                                this.cancelled = true;
                                cVar.onComplete();
                                this.worker.dispose();
                                return;
                            } else if (cVar.a(poll)) {
                                j++;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (!this.cancelled) {
                    if (kVar.isEmpty()) {
                        this.cancelled = true;
                        cVar.onComplete();
                        this.worker.dispose();
                        return;
                    }
                    this.produced = j;
                    i2 = addAndGet(-i2);
                } else {
                    return;
                }
            } while (i2 != 0);
        }

        /* access modifiers changed from: package-private */
        public final void runAsync() {
            int i2;
            io.reactivex.rxjava3.e.c.c<? super T> cVar = this.downstream;
            io.reactivex.rxjava3.e.c.k kVar = this.queue;
            long j = this.produced;
            long j2 = this.consumed;
            int i3 = 1;
            do {
                long j3 = this.requested.get();
                while (true) {
                    i2 = (j > j3 ? 1 : (j == j3 ? 0 : -1));
                    if (i2 == 0) {
                        break;
                    }
                    boolean z = this.done;
                    try {
                        Object poll = kVar.poll();
                        boolean z2 = poll == null;
                        if (!checkTerminated(z, z2, cVar)) {
                            if (z2) {
                                break;
                            }
                            if (cVar.a(poll)) {
                                j++;
                            }
                            j2++;
                            if (j2 == ((long) this.limit)) {
                                this.upstream.request(j2);
                                j2 = 0;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        this.cancelled = true;
                        this.upstream.cancel();
                        kVar.clear();
                        cVar.onError(th);
                        this.worker.dispose();
                        return;
                    }
                }
                if (i2 != 0 || !checkTerminated(this.done, kVar.isEmpty(), cVar)) {
                    this.produced = j;
                    this.consumed = j2;
                    i3 = addAndGet(-i3);
                } else {
                    return;
                }
            } while (i3 != 0);
        }

        /* access modifiers changed from: package-private */
        public final void runBackfused() {
            int i2 = 1;
            while (!this.cancelled) {
                boolean z = this.done;
                this.downstream.onNext(null);
                if (z) {
                    this.cancelled = true;
                    Throwable th = this.error;
                    if (th != null) {
                        this.downstream.onError(th);
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
            }
        }

        public final T poll() throws Throwable {
            T poll = this.queue.poll();
            if (!(poll == null || this.sourceMode == 1)) {
                long j = this.consumed + 1;
                if (j == ((long) this.limit)) {
                    this.consumed = 0;
                    this.upstream.request(j);
                } else {
                    this.consumed = j;
                }
            }
            return poll;
        }
    }
}
