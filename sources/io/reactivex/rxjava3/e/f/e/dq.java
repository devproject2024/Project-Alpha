package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.c.f;
import io.reactivex.rxjava3.e.c.k;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class dq<T, R> extends a<T, R> {

    /* renamed from: b  reason: collision with root package name */
    final h<? super T, ? extends u<? extends R>> f47323b;

    /* renamed from: c  reason: collision with root package name */
    final int f47324c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f47325d;

    public dq(u<T> uVar, h<? super T, ? extends u<? extends R>> hVar, int i2, boolean z) {
        super(uVar);
        this.f47323b = hVar;
        this.f47324c = i2;
        this.f47325d = z;
    }

    public final void subscribeActual(w<? super R> wVar) {
        if (!db.a(this.f46900a, wVar, this.f47323b)) {
            this.f46900a.subscribe(new b(wVar, this.f47323b, this.f47324c, this.f47325d));
        }
    }

    static final class b<T, R> extends AtomicInteger implements w<T>, c {
        static final a<Object, Object> CANCELLED;
        private static final long serialVersionUID = -3491074160481096299L;
        final AtomicReference<a<T, R>> active = new AtomicReference<>();
        final int bufferSize;
        volatile boolean cancelled;
        final boolean delayErrors;
        volatile boolean done;
        final w<? super R> downstream;
        final io.reactivex.rxjava3.e.k.c errors;
        final h<? super T, ? extends u<? extends R>> mapper;
        volatile long unique;
        c upstream;

        static {
            a<Object, Object> aVar = new a<>((b) null, -1, 1);
            CANCELLED = aVar;
            aVar.cancel();
        }

        b(w<? super R> wVar, h<? super T, ? extends u<? extends R>> hVar, int i2, boolean z) {
            this.downstream = wVar;
            this.mapper = hVar;
            this.bufferSize = i2;
            this.delayErrors = z;
            this.errors = new io.reactivex.rxjava3.e.k.c();
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.validate(this.upstream, cVar)) {
                this.upstream = cVar;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            a<Object, Object> aVar;
            long j = this.unique + 1;
            this.unique = j;
            a aVar2 = this.active.get();
            if (aVar2 != null) {
                aVar2.cancel();
            }
            try {
                u uVar = (u) Objects.requireNonNull(this.mapper.apply(t), "The ObservableSource returned is null");
                a aVar3 = new a(this, j, this.bufferSize);
                do {
                    aVar = this.active.get();
                    if (aVar == CANCELLED) {
                        return;
                    }
                } while (!this.active.compareAndSet(aVar, aVar3));
                uVar.subscribe(aVar3);
            } catch (Throwable th) {
                io.reactivex.rxjava3.c.b.b(th);
                this.upstream.dispose();
                onError(th);
            }
        }

        public final void onError(Throwable th) {
            if (this.done || !this.errors.tryAddThrowable(th)) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            if (!this.delayErrors) {
                disposeInner();
            }
            this.done = true;
            drain();
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                drain();
            }
        }

        public final void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.upstream.dispose();
                disposeInner();
                this.errors.tryTerminateAndReport();
            }
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        /* access modifiers changed from: package-private */
        public final void disposeInner() {
            a andSet = this.active.getAndSet(CANCELLED);
            if (andSet != null) {
                andSet.cancel();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:73:0x000f A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void drain() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L_0x0007
                return
            L_0x0007:
                io.reactivex.rxjava3.a.w<? super R> r0 = r13.downstream
                java.util.concurrent.atomic.AtomicReference<io.reactivex.rxjava3.e.f.e.dq$a<T, R>> r1 = r13.active
                boolean r2 = r13.delayErrors
                r3 = 1
                r4 = 1
            L_0x000f:
                boolean r5 = r13.cancelled
                if (r5 == 0) goto L_0x0014
                return
            L_0x0014:
                boolean r5 = r13.done
                r6 = 0
                if (r5 == 0) goto L_0x004e
                java.lang.Object r5 = r1.get()
                if (r5 != 0) goto L_0x0021
                r5 = 1
                goto L_0x0022
            L_0x0021:
                r5 = 0
            L_0x0022:
                if (r2 == 0) goto L_0x0038
                if (r5 == 0) goto L_0x004e
                io.reactivex.rxjava3.e.k.c r1 = r13.errors
                java.lang.Object r1 = r1.get()
                java.lang.Throwable r1 = (java.lang.Throwable) r1
                if (r1 == 0) goto L_0x0034
                r0.onError(r1)
                return
            L_0x0034:
                r0.onComplete()
                return
            L_0x0038:
                io.reactivex.rxjava3.e.k.c r7 = r13.errors
                java.lang.Object r7 = r7.get()
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L_0x0048
                io.reactivex.rxjava3.e.k.c r1 = r13.errors
                r1.tryTerminateConsumer((io.reactivex.rxjava3.a.w<?>) r0)
                return
            L_0x0048:
                if (r5 == 0) goto L_0x004e
                r0.onComplete()
                return
            L_0x004e:
                java.lang.Object r5 = r1.get()
                io.reactivex.rxjava3.e.f.e.dq$a r5 = (io.reactivex.rxjava3.e.f.e.dq.a) r5
                if (r5 == 0) goto L_0x00b5
                io.reactivex.rxjava3.e.c.k<R> r7 = r5.queue
                if (r7 == 0) goto L_0x00b5
                r8 = 0
            L_0x005b:
                boolean r9 = r13.cancelled
                if (r9 == 0) goto L_0x0060
                return
            L_0x0060:
                java.lang.Object r9 = r1.get()
                if (r5 == r9) goto L_0x0068
            L_0x0066:
                r8 = 1
                goto L_0x00b3
            L_0x0068:
                if (r2 != 0) goto L_0x007a
                io.reactivex.rxjava3.e.k.c r9 = r13.errors
                java.lang.Object r9 = r9.get()
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                if (r9 == 0) goto L_0x007a
                io.reactivex.rxjava3.e.k.c r1 = r13.errors
                r1.tryTerminateConsumer((io.reactivex.rxjava3.a.w<?>) r0)
                return
            L_0x007a:
                boolean r9 = r5.done
                r10 = 0
                java.lang.Object r11 = r7.poll()     // Catch:{ all -> 0x0082 }
                goto L_0x00a0
            L_0x0082:
                r8 = move-exception
                io.reactivex.rxjava3.c.b.b(r8)
                io.reactivex.rxjava3.e.k.c r11 = r13.errors
                r11.tryAddThrowableOrReport(r8)
                r1.compareAndSet(r5, r10)
                if (r2 != 0) goto L_0x009b
                r13.disposeInner()
                io.reactivex.rxjava3.b.c r8 = r13.upstream
                r8.dispose()
                r13.done = r3
                goto L_0x009e
            L_0x009b:
                r5.cancel()
            L_0x009e:
                r11 = r10
                r8 = 1
            L_0x00a0:
                if (r11 != 0) goto L_0x00a4
                r12 = 1
                goto L_0x00a5
            L_0x00a4:
                r12 = 0
            L_0x00a5:
                if (r9 == 0) goto L_0x00ad
                if (r12 == 0) goto L_0x00ad
                r1.compareAndSet(r5, r10)
                goto L_0x0066
            L_0x00ad:
                if (r12 != 0) goto L_0x00b3
                r0.onNext(r11)
                goto L_0x005b
            L_0x00b3:
                if (r8 != 0) goto L_0x000f
            L_0x00b5:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto L_0x000f
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.f.e.dq.b.drain():void");
        }

        /* access modifiers changed from: package-private */
        public final void innerError(a<T, R> aVar, Throwable th) {
            if (aVar.index != this.unique || !this.errors.tryAddThrowable(th)) {
                io.reactivex.rxjava3.h.a.a(th);
                return;
            }
            if (!this.delayErrors) {
                this.upstream.dispose();
                this.done = true;
            }
            aVar.done = true;
            drain();
        }
    }

    static final class a<T, R> extends AtomicReference<c> implements w<R> {
        private static final long serialVersionUID = 3837284832786408377L;
        final int bufferSize;
        volatile boolean done;
        final long index;
        final b<T, R> parent;
        volatile k<R> queue;

        a(b<T, R> bVar, long j, int i2) {
            this.parent = bVar;
            this.index = j;
            this.bufferSize = i2;
        }

        public final void onSubscribe(c cVar) {
            if (io.reactivex.rxjava3.e.a.c.setOnce(this, cVar)) {
                if (cVar instanceof f) {
                    f fVar = (f) cVar;
                    int requestFusion = fVar.requestFusion(7);
                    if (requestFusion == 1) {
                        this.queue = fVar;
                        this.done = true;
                        this.parent.drain();
                        return;
                    } else if (requestFusion == 2) {
                        this.queue = fVar;
                        return;
                    }
                }
                this.queue = new io.reactivex.rxjava3.e.g.c(this.bufferSize);
            }
        }

        public final void onNext(R r) {
            if (this.index == this.parent.unique) {
                if (r != null) {
                    this.queue.offer(r);
                }
                this.parent.drain();
            }
        }

        public final void onError(Throwable th) {
            this.parent.innerError(this, th);
        }

        public final void onComplete() {
            if (this.index == this.parent.unique) {
                this.done = true;
                this.parent.drain();
            }
        }

        public final void cancel() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }
    }
}
