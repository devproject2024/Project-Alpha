package io.reactivex.rxjava3.e.f.b;

import io.reactivex.rxjava3.a.k;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.c.j;
import io.reactivex.rxjava3.e.k.d;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.a.c;

public final class g<T, U> extends a<T, U> {

    /* renamed from: c  reason: collision with root package name */
    final h<? super T, ? extends org.a.a<? extends U>> f46800c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f46801d = false;

    /* renamed from: e  reason: collision with root package name */
    final int f46802e = 2;

    /* renamed from: f  reason: collision with root package name */
    final int f46803f;

    public g(io.reactivex.rxjava3.a.h<T> hVar, h<? super T, ? extends org.a.a<? extends U>> hVar2, int i2) {
        super(hVar);
        this.f46800c = hVar2;
        this.f46803f = i2;
    }

    public final void b(org.a.b<? super U> bVar) {
        if (!t.a(this.f46770b, bVar, this.f46800c)) {
            this.f46770b.a(new b(bVar, this.f46800c, this.f46801d, this.f46802e, this.f46803f));
        }
    }

    static final class b<T, U> extends AtomicInteger implements k<T>, c {
        static final a<?, ?>[] CANCELLED = new a[0];
        static final a<?, ?>[] EMPTY = new a[0];
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final org.a.b<? super U> downstream;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        long lastId;
        int lastIndex;
        final h<? super T, ? extends org.a.a<? extends U>> mapper;
        final int maxConcurrency;
        volatile j<U> queue;
        final AtomicLong requested = new AtomicLong();
        int scalarEmitted;
        final int scalarLimit;
        final AtomicReference<a<?, ?>[]> subscribers = new AtomicReference<>();
        long uniqueId;
        c upstream;

        b(org.a.b<? super U> bVar, h<? super T, ? extends org.a.a<? extends U>> hVar, boolean z, int i2, int i3) {
            this.downstream = bVar;
            this.mapper = hVar;
            this.delayErrors = z;
            this.maxConcurrency = i2;
            this.bufferSize = i3;
            this.scalarLimit = Math.max(1, i2 >> 1);
            this.subscribers.lazySet(EMPTY);
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.j.g.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
                if (!this.cancelled) {
                    int i2 = this.maxConcurrency;
                    if (i2 == Integer.MAX_VALUE) {
                        cVar.request(Long.MAX_VALUE);
                    } else {
                        cVar.request((long) i2);
                    }
                }
            }
        }

        public final void onNext(T t) {
            if (!this.done) {
                try {
                    org.a.a aVar = (org.a.a) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null Publisher");
                    if (aVar instanceof r) {
                        try {
                            Object obj = ((r) aVar).get();
                            if (obj != null) {
                                tryEmitScalar(obj);
                            } else if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                                int i2 = this.scalarEmitted + 1;
                                this.scalarEmitted = i2;
                                int i3 = this.scalarLimit;
                                if (i2 == i3) {
                                    this.scalarEmitted = 0;
                                    this.upstream.request((long) i3);
                                }
                            }
                        } catch (Throwable th) {
                            io.reactivex.rxjava3.c.b.b(th);
                            this.errors.tryAddThrowableOrReport(th);
                            drain();
                        }
                    } else {
                        int i4 = this.bufferSize;
                        long j = this.uniqueId;
                        this.uniqueId = 1 + j;
                        a aVar2 = new a(this, i4, j);
                        if (addInner(aVar2)) {
                            aVar.a(aVar2);
                        }
                    }
                } catch (Throwable th2) {
                    io.reactivex.rxjava3.c.b.b(th2);
                    this.upstream.cancel();
                    onError(th2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean addInner(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) this.subscribers.get();
                if (aVarArr == CANCELLED) {
                    aVar.dispose();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.subscribers.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void removeInner(a<T, U> aVar) {
            a<T, U>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = (a[]) this.subscribers.get();
                int length = aVarArr.length;
                if (length != 0) {
                    int i2 = -1;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (aVarArr[i3] == aVar) {
                            i2 = i3;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (i2 >= 0) {
                        if (length == 1) {
                            aVarArr2 = EMPTY;
                        } else {
                            a<?, ?>[] aVarArr3 = new a[(length - 1)];
                            System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                            System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                            aVarArr2 = aVarArr3;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } while (!this.subscribers.compareAndSet(aVarArr, aVarArr2));
        }

        /* access modifiers changed from: package-private */
        public final io.reactivex.rxjava3.e.c.k<U> getMainQueue() {
            j<U> jVar = this.queue;
            if (jVar == null) {
                int i2 = this.maxConcurrency;
                if (i2 == Integer.MAX_VALUE) {
                    jVar = new io.reactivex.rxjava3.e.g.c<>(this.bufferSize);
                } else {
                    jVar = new io.reactivex.rxjava3.e.g.b<>(i2);
                }
                this.queue = jVar;
            }
            return jVar;
        }

        /* access modifiers changed from: package-private */
        public final void tryEmitScalar(U u) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j = this.requested.get();
                io.reactivex.rxjava3.e.c.k kVar = this.queue;
                if (j == 0 || (kVar != null && !kVar.isEmpty())) {
                    if (kVar == null) {
                        kVar = getMainQueue();
                    }
                    if (!kVar.offer(u)) {
                        onError(new io.reactivex.rxjava3.c.c("Scalar queue full?!"));
                    }
                } else {
                    this.downstream.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    if (this.maxConcurrency != Integer.MAX_VALUE && !this.cancelled) {
                        int i2 = this.scalarEmitted + 1;
                        this.scalarEmitted = i2;
                        int i3 = this.scalarLimit;
                        if (i2 == i3) {
                            this.scalarEmitted = 0;
                            this.upstream.request((long) i3);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!getMainQueue().offer(u)) {
                onError(new io.reactivex.rxjava3.c.c("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            drainLoop();
        }

        /* access modifiers changed from: package-private */
        public final void tryEmit(U u, a<T, U> aVar) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                io.reactivex.rxjava3.e.c.k kVar = aVar.queue;
                if (kVar == null) {
                    kVar = new io.reactivex.rxjava3.e.g.b(this.bufferSize);
                    aVar.queue = kVar;
                }
                if (!kVar.offer(u)) {
                    onError(new io.reactivex.rxjava3.c.c("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                long j = this.requested.get();
                io.reactivex.rxjava3.e.c.k kVar2 = aVar.queue;
                if (j == 0 || (kVar2 != null && !kVar2.isEmpty())) {
                    if (kVar2 == null) {
                        kVar2 = new io.reactivex.rxjava3.e.g.b(this.bufferSize);
                        aVar.queue = kVar2;
                    }
                    if (!kVar2.offer(u)) {
                        onError(new io.reactivex.rxjava3.c.c("Inner queue full?!"));
                    }
                } else {
                    this.downstream.onNext(u);
                    if (j != Long.MAX_VALUE) {
                        this.requested.decrementAndGet();
                    }
                    aVar.requestMore(1);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            drainLoop();
        }

        public final void onError(Throwable th) {
            if (this.done) {
                io.reactivex.rxjava3.h.a.a(th);
            } else if (this.errors.tryAddThrowableOrReport(th)) {
                this.done = true;
                if (!this.delayErrors) {
                    for (a dispose : (a[]) this.subscribers.getAndSet(CANCELLED)) {
                        dispose.dispose();
                    }
                }
                drain();
            }
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public final void request(long j) {
            if (io.reactivex.rxjava3.e.j.g.validate(j)) {
                d.a(this.requested, j);
                drain();
            }
        }

        public final void cancel() {
            j<U> jVar;
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.cancel();
                disposeAll();
                if (getAndIncrement() == 0 && (jVar = this.queue) != null) {
                    jVar.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drainLoop() {
            long j;
            long j2;
            long j3;
            long j4;
            boolean z;
            a[] aVarArr;
            int i2;
            int i3;
            long j5;
            org.a.b<? super U> bVar = this.downstream;
            int i4 = 1;
            while (!checkTerminate()) {
                j<U> jVar = this.queue;
                long j6 = this.requested.get();
                boolean z2 = j6 == Long.MAX_VALUE;
                long j7 = 0;
                if (jVar != null) {
                    long j8 = 0;
                    j = 0;
                    while (j6 != 0) {
                        U poll = jVar.poll();
                        if (!checkTerminate()) {
                            if (poll == null) {
                                break;
                            }
                            bVar.onNext(poll);
                            j++;
                            j8++;
                            j6--;
                        } else {
                            return;
                        }
                    }
                    if (j8 != 0) {
                        if (z2) {
                            j6 = Long.MAX_VALUE;
                        } else {
                            j6 = this.requested.addAndGet(-j8);
                        }
                    }
                } else {
                    j = 0;
                }
                boolean z3 = this.done;
                j<U> jVar2 = this.queue;
                a[] aVarArr2 = (a[]) this.subscribers.get();
                int length = aVarArr2.length;
                if (!z3 || ((jVar2 != null && !jVar2.isEmpty()) || length != 0)) {
                    int i5 = i4;
                    if (length != 0) {
                        long j9 = this.lastId;
                        int i6 = this.lastIndex;
                        if (length <= i6 || aVarArr2[i6].id != j9) {
                            if (length <= i6) {
                                i6 = 0;
                            }
                            int i7 = i6;
                            for (int i8 = 0; i8 < length && aVarArr2[i7].id != j9; i8++) {
                                i7++;
                                if (i7 == length) {
                                    i7 = 0;
                                }
                            }
                            this.lastIndex = i7;
                            this.lastId = aVarArr2[i7].id;
                            i6 = i7;
                        }
                        int i9 = i6;
                        z = false;
                        int i10 = 0;
                        while (true) {
                            if (i10 < length) {
                                if (!checkTerminate()) {
                                    a aVar = aVarArr2[i9];
                                    U u = null;
                                    while (true) {
                                        io.reactivex.rxjava3.e.c.k<U> kVar = aVar.queue;
                                        aVarArr = aVarArr2;
                                        i2 = length;
                                        if (kVar == null) {
                                            break;
                                        }
                                        long j10 = j7;
                                        while (j2 != j7) {
                                            if (!checkTerminate()) {
                                                try {
                                                    u = kVar.poll();
                                                    if (u == null) {
                                                        break;
                                                    }
                                                    bVar.onNext(u);
                                                    j2--;
                                                    j10++;
                                                } catch (Throwable th) {
                                                    Throwable th2 = th;
                                                    io.reactivex.rxjava3.c.b.b(th2);
                                                    aVar.dispose();
                                                    this.errors.tryAddThrowableOrReport(th2);
                                                    if (!this.delayErrors) {
                                                        this.upstream.cancel();
                                                    }
                                                    if (!checkTerminate()) {
                                                        removeInner(aVar);
                                                        i10++;
                                                        i3 = i2;
                                                        z = true;
                                                    } else {
                                                        return;
                                                    }
                                                }
                                            } else {
                                                return;
                                            }
                                        }
                                        if (j10 != j7) {
                                            j2 = !z2 ? this.requested.addAndGet(-j10) : Long.MAX_VALUE;
                                            aVar.requestMore(j10);
                                            j5 = 0;
                                        } else {
                                            j5 = j7;
                                        }
                                        if (j2 == j5 || u == null) {
                                            break;
                                        }
                                        aVarArr2 = aVarArr;
                                        length = i2;
                                        j7 = 0;
                                    }
                                    boolean z4 = aVar.done;
                                    io.reactivex.rxjava3.e.c.k<U> kVar2 = aVar.queue;
                                    if (z4 && (kVar2 == null || kVar2.isEmpty())) {
                                        removeInner(aVar);
                                        if (!checkTerminate()) {
                                            j++;
                                            z = true;
                                        } else {
                                            return;
                                        }
                                    }
                                    if (j2 == 0) {
                                        break;
                                    }
                                    int i11 = i9 + 1;
                                    i3 = i2;
                                    i9 = i11 == i3 ? 0 : i11;
                                    i10++;
                                    length = i3;
                                    aVarArr2 = aVarArr;
                                    j7 = 0;
                                } else {
                                    return;
                                }
                            } else {
                                aVarArr = aVarArr2;
                                break;
                            }
                        }
                        this.lastIndex = i9;
                        this.lastId = aVarArr[i9].id;
                        j4 = j;
                        j3 = 0;
                    } else {
                        j3 = 0;
                        j4 = j;
                        z = false;
                    }
                    if (j4 != j3 && !this.cancelled) {
                        this.upstream.request(j4);
                    }
                    int i12 = i5;
                    if (!z) {
                        i4 = addAndGet(-i12);
                        if (i4 == 0) {
                            return;
                        }
                    } else {
                        i4 = i12;
                    }
                } else {
                    this.errors.tryTerminateConsumer((org.a.b<?>) this.downstream);
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminate() {
            if (this.cancelled) {
                clearScalarQueue();
                return true;
            } else if (this.delayErrors || this.errors.get() == null) {
                return false;
            } else {
                clearScalarQueue();
                this.errors.tryTerminateConsumer((org.a.b<?>) this.downstream);
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final void clearScalarQueue() {
            j<U> jVar = this.queue;
            if (jVar != null) {
                jVar.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public final void disposeAll() {
            a<?, ?>[] aVarArr = (a[]) this.subscribers.getAndSet(CANCELLED);
            if (aVarArr != CANCELLED) {
                for (a<?, ?> dispose : aVarArr) {
                    dispose.dispose();
                }
                this.errors.tryTerminateAndReport();
            }
        }

        /* access modifiers changed from: package-private */
        public final void innerError(a<T, U> aVar, Throwable th) {
            if (this.errors.tryAddThrowableOrReport(th)) {
                aVar.done = true;
                if (!this.delayErrors) {
                    this.upstream.cancel();
                    for (a dispose : (a[]) this.subscribers.getAndSet(CANCELLED)) {
                        dispose.dispose();
                    }
                }
                drain();
            }
        }
    }

    static final class a<T, U> extends AtomicReference<c> implements k<U>, io.reactivex.rxjava3.b.c {
        private static final long serialVersionUID = -4606175640614850599L;
        final int bufferSize;
        volatile boolean done;
        int fusionMode;
        final long id;
        final int limit;
        final b<T, U> parent;
        long produced;
        volatile io.reactivex.rxjava3.e.c.k<U> queue;

        a(b<T, U> bVar, int i2, long j) {
            this.id = j;
            this.parent = bVar;
            this.bufferSize = i2;
            this.limit = i2 >> 2;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.j.g.setOnce(this, cVar)) {
                if (cVar instanceof io.reactivex.rxjava3.e.c.h) {
                    io.reactivex.rxjava3.e.c.h hVar = (io.reactivex.rxjava3.e.c.h) cVar;
                    int requestFusion = hVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.fusionMode = requestFusion;
                        this.queue = hVar;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.fusionMode = requestFusion;
                        this.queue = hVar;
                    }
                }
                cVar.request((long) this.bufferSize);
            }
        }

        public final void onNext(U u) {
            if (this.fusionMode != 2) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        public final void onError(Throwable th) {
            lazySet(io.reactivex.rxjava3.e.j.g.CANCELLED);
            this.parent.innerError(this, th);
        }

        public final void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        /* access modifiers changed from: package-private */
        public final void requestMore(long j) {
            if (this.fusionMode != 1) {
                long j2 = this.produced + j;
                if (j2 >= ((long) this.limit)) {
                    this.produced = 0;
                    ((c) get()).request(j2);
                    return;
                }
                this.produced = j2;
            }
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.j.g.cancel(this);
        }

        public final boolean isDisposed() {
            return get() == io.reactivex.rxjava3.e.j.g.CANCELLED;
        }
    }
}
