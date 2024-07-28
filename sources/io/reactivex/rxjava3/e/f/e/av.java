package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.d.r;
import io.reactivex.rxjava3.e.c.f;
import io.reactivex.rxjava3.e.c.j;
import io.reactivex.rxjava3.e.c.k;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class av<T, U> extends a<T, U> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends u<? extends U>> f47015b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f47016c;

    /* renamed from: d  reason: collision with root package name */
    final int f47017d;

    /* renamed from: e  reason: collision with root package name */
    final int f47018e;

    public av(u<T> uVar, h<? super T, ? extends u<? extends U>> hVar, boolean z, int i2, int i3) {
        super(uVar);
        this.f47015b = hVar;
        this.f47016c = z;
        this.f47017d = i2;
        this.f47018e = i3;
    }

    public final void subscribeActual(w<? super U> wVar) {
        if (!db.a(this.f46900a, wVar, this.f47015b)) {
            this.f46900a.subscribe(new b(wVar, this.f47015b, this.f47016c, this.f47017d, this.f47018e));
        }
    }

    static final class b<T, U> extends AtomicInteger implements w<T>, c {
        static final a<?, ?>[] CANCELLED = new a[0];
        static final a<?, ?>[] EMPTY = new a[0];
        private static final long serialVersionUID = -2117620485640801370L;
        final int bufferSize;
        final boolean delayErrors;
        volatile boolean disposed;
        volatile boolean done;
        final w<? super U> downstream;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        int lastIndex;
        final h<? super T, ? extends u<? extends U>> mapper;
        final int maxConcurrency;
        final AtomicReference<a<?, ?>[]> observers;
        volatile j<U> queue;
        Queue<u<? extends U>> sources;
        long uniqueId;
        c upstream;
        int wip;

        b(w<? super U> wVar, h<? super T, ? extends u<? extends U>> hVar, boolean z, int i2, int i3) {
            this.downstream = wVar;
            this.mapper = hVar;
            this.delayErrors = z;
            this.maxConcurrency = i2;
            this.bufferSize = i3;
            if (i2 != Integer.MAX_VALUE) {
                this.sources = new ArrayDeque(i2);
            }
            this.observers = new AtomicReference<>(EMPTY);
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.done) {
                try {
                    u uVar = (u) Objects.requireNonNull(this.mapper.apply(t), "The mapper returned a null ObservableSource");
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        synchronized (this) {
                            if (this.wip == this.maxConcurrency) {
                                this.sources.offer(uVar);
                                return;
                            }
                            this.wip++;
                        }
                    }
                    subscribeInner(uVar);
                } catch (Throwable th) {
                    io.reactivex.rxjava3.c.b.b(th);
                    this.upstream.dispose();
                    onError(th);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void subscribeInner(u<? extends U> uVar) {
            u<? extends U> poll;
            while (uVar instanceof r) {
                if (tryEmitScalar((r) uVar) && this.maxConcurrency != Integer.MAX_VALUE) {
                    boolean z = false;
                    synchronized (this) {
                        poll = this.sources.poll();
                        if (poll == null) {
                            this.wip--;
                            z = true;
                        }
                    }
                    if (z) {
                        drain();
                        return;
                    }
                    uVar = poll;
                } else {
                    return;
                }
            }
            long j = this.uniqueId;
            this.uniqueId = 1 + j;
            a aVar = new a(this, j);
            if (addInner(aVar)) {
                uVar.subscribe(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean addInner(a<T, U> aVar) {
            a<?, ?>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) this.observers.get();
                if (aVarArr == CANCELLED) {
                    aVar.dispose();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[(length + 1)];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!this.observers.compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        /* access modifiers changed from: package-private */
        public final void removeInner(a<T, U> aVar) {
            a<T, U>[] aVarArr;
            a<?, ?>[] aVarArr2;
            do {
                aVarArr = (a[]) this.observers.get();
                int length = aVarArr.length;
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
            } while (!this.observers.compareAndSet(aVarArr, aVarArr2));
        }

        /* access modifiers changed from: package-private */
        public final boolean tryEmitScalar(r<? extends U> rVar) {
            try {
                Object obj = rVar.get();
                if (obj == null) {
                    return true;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
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
                    jVar.offer(obj);
                    if (getAndIncrement() != 0) {
                        return false;
                    }
                } else {
                    this.downstream.onNext(obj);
                    if (decrementAndGet() == 0) {
                        return true;
                    }
                }
                drainLoop();
                return true;
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                this.errors.tryAddThrowableOrReport(th);
                drain();
                return true;
            }
        }

        /* access modifiers changed from: package-private */
        public final void tryEmit(U u, a<T, U> aVar) {
            if (get() != 0 || !compareAndSet(0, 1)) {
                k kVar = aVar.queue;
                if (kVar == null) {
                    kVar = new io.reactivex.rxjava3.e.g.c(this.bufferSize);
                    aVar.queue = kVar;
                }
                kVar.offer(u);
                if (getAndIncrement() != 0) {
                    return;
                }
            } else {
                this.downstream.onNext(u);
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
                drain();
            }
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public final void dispose() {
            this.disposed = true;
            if (disposeAll()) {
                this.errors.tryTerminateAndReport();
            }
        }

        public final boolean isDisposed() {
            return this.disposed;
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drainLoop() {
            int i2;
            w<? super U> wVar = this.downstream;
            int i3 = 1;
            while (!checkTerminate()) {
                j<U> jVar = this.queue;
                int i4 = 0;
                if (jVar != null) {
                    while (!checkTerminate()) {
                        U poll = jVar.poll();
                        if (poll != null) {
                            wVar.onNext(poll);
                            i4++;
                        }
                    }
                    return;
                }
                if (i4 == 0) {
                    boolean z = this.done;
                    j<U> jVar2 = this.queue;
                    a[] aVarArr = (a[]) this.observers.get();
                    int length = aVarArr.length;
                    if (this.maxConcurrency != Integer.MAX_VALUE) {
                        synchronized (this) {
                            i2 = this.sources.size();
                        }
                    } else {
                        i2 = 0;
                    }
                    if (!z || !((jVar2 == null || jVar2.isEmpty()) && length == 0 && i2 == 0)) {
                        if (length != 0) {
                            int min = Math.min(length - 1, this.lastIndex);
                            int i5 = i4;
                            int i6 = 0;
                            while (i6 < length) {
                                if (!checkTerminate()) {
                                    a aVar = aVarArr[min];
                                    k<U> kVar = aVar.queue;
                                    if (kVar != null) {
                                        while (true) {
                                            try {
                                                U poll2 = kVar.poll();
                                                if (poll2 == null) {
                                                    break;
                                                }
                                                wVar.onNext(poll2);
                                                if (checkTerminate()) {
                                                    return;
                                                }
                                            } catch (Throwable th) {
                                                io.reactivex.rxjava3.c.b.b(th);
                                                aVar.dispose();
                                                this.errors.tryAddThrowableOrReport(th);
                                                if (!checkTerminate()) {
                                                    removeInner(aVar);
                                                    i5++;
                                                    min++;
                                                    if (min != length) {
                                                    }
                                                } else {
                                                    return;
                                                }
                                            }
                                        }
                                    }
                                    boolean z2 = aVar.done;
                                    k<U> kVar2 = aVar.queue;
                                    if (z2 && (kVar2 == null || kVar2.isEmpty())) {
                                        removeInner(aVar);
                                        i5++;
                                    }
                                    min++;
                                    if (min != length) {
                                        i6++;
                                    }
                                    min = 0;
                                    i6++;
                                } else {
                                    return;
                                }
                            }
                            this.lastIndex = min;
                            i4 = i5;
                        }
                        if (i4 == 0) {
                            i3 = addAndGet(-i3);
                            if (i3 == 0) {
                                return;
                            }
                        } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                            subscribeMore(i4);
                        }
                    } else {
                        this.errors.tryTerminateConsumer((w<?>) this.downstream);
                        return;
                    }
                } else if (this.maxConcurrency != Integer.MAX_VALUE) {
                    subscribeMore(i4);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void subscribeMore(int i2) {
            while (true) {
                int i3 = i2 - 1;
                if (i2 != 0) {
                    synchronized (this) {
                        u poll = this.sources.poll();
                        if (poll == null) {
                            this.wip--;
                        } else {
                            subscribeInner(poll);
                        }
                    }
                    i2 = i3;
                } else {
                    return;
                }
            }
            while (true) {
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean checkTerminate() {
            if (this.disposed) {
                return true;
            }
            Throwable th = (Throwable) this.errors.get();
            if (this.delayErrors || th == null) {
                return false;
            }
            disposeAll();
            this.errors.tryTerminateConsumer((w<?>) this.downstream);
            return true;
        }

        /* access modifiers changed from: package-private */
        public final boolean disposeAll() {
            this.upstream.dispose();
            a<?, ?>[] aVarArr = (a[]) this.observers.getAndSet(CANCELLED);
            if (aVarArr == CANCELLED) {
                return false;
            }
            for (a<?, ?> dispose : aVarArr) {
                dispose.dispose();
            }
            return true;
        }
    }

    static final class a<T, U> extends AtomicReference<c> implements w<U> {
        private static final long serialVersionUID = -4606175640614850599L;
        volatile boolean done;
        int fusionMode;
        final long id;
        final b<T, U> parent;
        volatile k<U> queue;

        a(b<T, U> bVar, long j) {
            this.id = j;
            this.parent = bVar;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.setOnce(this, cVar) && (cVar instanceof f)) {
                f fVar = (f) cVar;
                int requestFusion = fVar.requestFusion(7);
                if (requestFusion == 1) {
                    this.fusionMode = requestFusion;
                    this.queue = fVar;
                    this.done = true;
                    this.parent.drain();
                } else if (requestFusion == 2) {
                    this.fusionMode = requestFusion;
                    this.queue = fVar;
                }
            }
        }

        public final void onNext(U u) {
            if (this.fusionMode == 0) {
                this.parent.tryEmit(u, this);
            } else {
                this.parent.drain();
            }
        }

        public final void onError(Throwable th) {
            if (this.parent.errors.tryAddThrowableOrReport(th)) {
                if (!this.parent.delayErrors) {
                    this.parent.disposeAll();
                }
                this.done = true;
                this.parent.drain();
            }
        }

        public final void onComplete() {
            this.done = true;
            this.parent.drain();
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }
    }
}
