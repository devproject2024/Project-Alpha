package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.a.d;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class s<T, R> extends p<R> {

    /* renamed from: a  reason: collision with root package name */
    final u<? extends T>[] f47550a;

    /* renamed from: b  reason: collision with root package name */
    final Iterable<? extends u<? extends T>> f47551b;

    /* renamed from: c  reason: collision with root package name */
    final h<? super Object[], ? extends R> f47552c;

    /* renamed from: d  reason: collision with root package name */
    final int f47553d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f47554e;

    public s(u<? extends T>[] uVarArr, Iterable<? extends u<? extends T>> iterable, h<? super Object[], ? extends R> hVar, int i2, boolean z) {
        this.f47550a = uVarArr;
        this.f47551b = iterable;
        this.f47552c = hVar;
        this.f47553d = i2;
        this.f47554e = z;
    }

    public final void subscribeActual(w<? super R> wVar) {
        int i2;
        u<? extends T>[] uVarArr = this.f47550a;
        if (uVarArr == null) {
            uVarArr = new u[8];
            try {
                i2 = 0;
                for (u uVar : this.f47551b) {
                    if (i2 == uVarArr.length) {
                        u<? extends T>[] uVarArr2 = new u[((i2 >> 2) + i2)];
                        System.arraycopy(uVarArr, 0, uVarArr2, 0, i2);
                        uVarArr = uVarArr2;
                    }
                    int i3 = i2 + 1;
                    uVarArr[i2] = (u) Objects.requireNonNull(uVar, "The Iterator returned a null ObservableSource");
                    i2 = i3;
                }
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                d.error(th, (w<?>) wVar);
                return;
            }
        } else {
            i2 = uVarArr.length;
        }
        int i4 = i2;
        if (i4 == 0) {
            d.complete((w<?>) wVar);
            return;
        }
        new b(wVar, this.f47552c, i4, this.f47553d, this.f47554e).subscribe(uVarArr);
    }

    static final class b<T, R> extends AtomicInteger implements c {
        private static final long serialVersionUID = 8567835998786448817L;
        int active;
        volatile boolean cancelled;
        final h<? super Object[], ? extends R> combiner;
        int complete;
        final boolean delayError;
        volatile boolean done;
        final w<? super R> downstream;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        Object[] latest;
        final a<T, R>[] observers;
        final io.reactivex.rxjava3.e.g.c<Object[]> queue;

        b(w<? super R> wVar, h<? super Object[], ? extends R> hVar, int i2, int i3, boolean z) {
            this.downstream = wVar;
            this.combiner = hVar;
            this.delayError = z;
            this.latest = new Object[i2];
            a<T, R>[] aVarArr = new a[i2];
            for (int i4 = 0; i4 < i2; i4++) {
                aVarArr[i4] = new a<>(this, i4);
            }
            this.observers = aVarArr;
            this.queue = new io.reactivex.rxjava3.e.g.c<>(i3);
        }

        public final void subscribe(u<? extends T>[] uVarArr) {
            a<T, R>[] aVarArr = this.observers;
            int length = aVarArr.length;
            this.downstream.onSubscribe(this);
            for (int i2 = 0; i2 < length && !this.done && !this.cancelled; i2++) {
                uVarArr[i2].subscribe(aVarArr[i2]);
            }
        }

        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                cancelSources();
                drain();
            }
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public final void cancelSources() {
            for (a<T, R> dispose : this.observers) {
                dispose.dispose();
            }
        }

        /* access modifiers changed from: package-private */
        public final void clear(io.reactivex.rxjava3.e.g.c<?> cVar) {
            synchronized (this) {
                this.latest = null;
            }
            cVar.clear();
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                io.reactivex.rxjava3.e.g.c<Object[]> cVar = this.queue;
                w<? super R> wVar = this.downstream;
                boolean z = this.delayError;
                int i2 = 1;
                while (!this.cancelled) {
                    if (z || this.errors.get() == null) {
                        boolean z2 = this.done;
                        Object[] poll = cVar.poll();
                        boolean z3 = poll == null;
                        if (z2 && z3) {
                            clear(cVar);
                            this.errors.tryTerminateConsumer((w<?>) wVar);
                            return;
                        } else if (!z3) {
                            try {
                                wVar.onNext(Objects.requireNonNull(this.combiner.apply(poll), "The combiner returned a null value"));
                            } catch (Throwable th) {
                                io.reactivex.rxjava3.c.b.b(th);
                                this.errors.tryAddThrowableOrReport(th);
                                cancelSources();
                                clear(cVar);
                                this.errors.tryTerminateConsumer((w<?>) wVar);
                                return;
                            }
                        } else {
                            i2 = addAndGet(-i2);
                            if (i2 == 0) {
                                return;
                            }
                        }
                    } else {
                        cancelSources();
                        clear(cVar);
                        this.errors.tryTerminateConsumer((w<?>) wVar);
                        return;
                    }
                }
                clear(cVar);
                this.errors.tryTerminateAndReport();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0023, code lost:
            if (r4 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0025, code lost:
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void innerNext(int r4, T r5) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.latest     // Catch:{ all -> 0x0029 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                return
            L_0x0007:
                r1 = r0[r4]     // Catch:{ all -> 0x0029 }
                int r2 = r3.active     // Catch:{ all -> 0x0029 }
                if (r1 != 0) goto L_0x0011
                int r2 = r2 + 1
                r3.active = r2     // Catch:{ all -> 0x0029 }
            L_0x0011:
                r0[r4] = r5     // Catch:{ all -> 0x0029 }
                int r4 = r0.length     // Catch:{ all -> 0x0029 }
                if (r2 != r4) goto L_0x0021
                io.reactivex.rxjava3.e.g.c<java.lang.Object[]> r4 = r3.queue     // Catch:{ all -> 0x0029 }
                java.lang.Object r5 = r0.clone()     // Catch:{ all -> 0x0029 }
                r4.offer(r5)     // Catch:{ all -> 0x0029 }
                r4 = 1
                goto L_0x0022
            L_0x0021:
                r4 = 0
            L_0x0022:
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                if (r4 == 0) goto L_0x0028
                r3.drain()
            L_0x0028:
                return
            L_0x0029:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0029 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.s.b.innerNext(int, java.lang.Object):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0023, code lost:
            if (r1 == r4.length) goto L_0x0025;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void innerError(int r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                io.reactivex.rxjava3.e.k.c r0 = r2.errors
                boolean r4 = r0.tryAddThrowableOrReport(r4)
                if (r4 == 0) goto L_0x0035
                boolean r4 = r2.delayError
                r0 = 1
                if (r4 == 0) goto L_0x002c
                monitor-enter(r2)
                java.lang.Object[] r4 = r2.latest     // Catch:{ all -> 0x0029 }
                if (r4 != 0) goto L_0x0014
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                return
            L_0x0014:
                r3 = r4[r3]     // Catch:{ all -> 0x0029 }
                if (r3 != 0) goto L_0x001a
                r3 = 1
                goto L_0x001b
            L_0x001a:
                r3 = 0
            L_0x001b:
                if (r3 != 0) goto L_0x0025
                int r1 = r2.complete     // Catch:{ all -> 0x0029 }
                int r1 = r1 + r0
                r2.complete = r1     // Catch:{ all -> 0x0029 }
                int r4 = r4.length     // Catch:{ all -> 0x0029 }
                if (r1 != r4) goto L_0x0027
            L_0x0025:
                r2.done = r0     // Catch:{ all -> 0x0029 }
            L_0x0027:
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                goto L_0x002d
            L_0x0029:
                r3 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0029 }
                throw r3
            L_0x002c:
                r3 = 1
            L_0x002d:
                if (r3 == 0) goto L_0x0032
                r2.cancelSources()
            L_0x0032:
                r2.drain()
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.s.b.innerError(int, java.lang.Throwable):void");
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0017, code lost:
            if (r2 == r0.length) goto L_0x0019;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x001c, code lost:
            if (r4 == false) goto L_0x0021;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x001e, code lost:
            cancelSources();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0021, code lost:
            drain();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0024, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void innerComplete(int r4) {
            /*
                r3 = this;
                monitor-enter(r3)
                java.lang.Object[] r0 = r3.latest     // Catch:{ all -> 0x0025 }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                return
            L_0x0007:
                r4 = r0[r4]     // Catch:{ all -> 0x0025 }
                r1 = 1
                if (r4 != 0) goto L_0x000e
                r4 = 1
                goto L_0x000f
            L_0x000e:
                r4 = 0
            L_0x000f:
                if (r4 != 0) goto L_0x0019
                int r2 = r3.complete     // Catch:{ all -> 0x0025 }
                int r2 = r2 + r1
                r3.complete = r2     // Catch:{ all -> 0x0025 }
                int r0 = r0.length     // Catch:{ all -> 0x0025 }
                if (r2 != r0) goto L_0x001b
            L_0x0019:
                r3.done = r1     // Catch:{ all -> 0x0025 }
            L_0x001b:
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                if (r4 == 0) goto L_0x0021
                r3.cancelSources()
            L_0x0021:
                r3.drain()
                return
            L_0x0025:
                r4 = move-exception
                monitor-exit(r3)     // Catch:{ all -> 0x0025 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.s.b.innerComplete(int):void");
        }
    }

    static final class a<T, R> extends AtomicReference<c> implements w<T> {
        private static final long serialVersionUID = -4823716997131257941L;
        final int index;
        final b<T, R> parent;

        a(b<T, R> bVar, int i2) {
            this.parent = bVar;
            this.index = i2;
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }

        public final void onNext(T t) {
            this.parent.innerNext(this.index, t);
        }

        public final void onError(Throwable th) {
            this.parent.innerError(this.index, th);
        }

        public final void onComplete() {
            this.parent.innerComplete(this.index);
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }
    }
}
