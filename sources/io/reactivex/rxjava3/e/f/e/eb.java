package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.d.h;
import io.reactivex.rxjava3.e.a.f;
import io.reactivex.rxjava3.e.f.e.ec;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class eb<T, U, V> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final u<U> f47376b;

    /* renamed from: c  reason: collision with root package name */
    final h<? super T, ? extends u<V>> f47377c;

    /* renamed from: d  reason: collision with root package name */
    final u<? extends T> f47378d;

    interface d extends ec.d {
        void onTimeoutError(long j, Throwable th);
    }

    public eb(p<T> pVar, u<U> uVar, h<? super T, ? extends u<V>> hVar, u<? extends T> uVar2) {
        super(pVar);
        this.f47376b = uVar;
        this.f47377c = hVar;
        this.f47378d = uVar2;
    }

    public final void subscribeActual(w<? super T> wVar) {
        u<? extends T> uVar = this.f47378d;
        if (uVar == null) {
            c cVar = new c(wVar, this.f47377c);
            wVar.onSubscribe(cVar);
            cVar.startFirstTimeout(this.f47376b);
            this.f46900a.subscribe(cVar);
            return;
        }
        b bVar = new b(wVar, this.f47377c, uVar);
        wVar.onSubscribe(bVar);
        bVar.startFirstTimeout(this.f47376b);
        this.f46900a.subscribe(bVar);
    }

    static final class c<T> extends AtomicLong implements w<T>, io.reactivex.rxjava3.b.c, d {
        private static final long serialVersionUID = 3764492702657003550L;
        final w<? super T> downstream;
        final h<? super T, ? extends u<?>> itemTimeoutIndicator;
        final f task = new f();
        final AtomicReference<io.reactivex.rxjava3.b.c> upstream = new AtomicReference<>();

        c(w<? super T> wVar, h<? super T, ? extends u<?>> hVar) {
            this.downstream = wVar;
            this.itemTimeoutIndicator = hVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.upstream, cVar);
        }

        public final void onNext(T t) {
            long j = get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (compareAndSet(j, j2)) {
                    io.reactivex.rxjava3.b.c cVar = (io.reactivex.rxjava3.b.c) this.task.get();
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    this.downstream.onNext(t);
                    try {
                        u uVar = (u) Objects.requireNonNull(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null ObservableSource.");
                        a aVar = new a(j2, this);
                        if (this.task.replace(aVar)) {
                            uVar.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        this.upstream.get().dispose();
                        getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void startFirstTimeout(u<?> uVar) {
            if (uVar != null) {
                a aVar = new a(0, this);
                if (this.task.replace(aVar)) {
                    uVar.subscribe(aVar);
                }
            }
        }

        public final void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th);
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
            }
        }

        public final void onTimeout(long j) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
                this.downstream.onError(new TimeoutException());
            }
        }

        public final void onTimeoutError(long j, Throwable th) {
            if (compareAndSet(j, Long.MAX_VALUE)) {
                io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
                this.downstream.onError(th);
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            this.task.dispose();
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed(this.upstream.get());
        }
    }

    static final class b<T> extends AtomicReference<io.reactivex.rxjava3.b.c> implements w<T>, io.reactivex.rxjava3.b.c, d {
        private static final long serialVersionUID = -7508389464265974549L;
        final w<? super T> downstream;
        u<? extends T> fallback;
        final AtomicLong index;
        final h<? super T, ? extends u<?>> itemTimeoutIndicator;
        final f task = new f();
        final AtomicReference<io.reactivex.rxjava3.b.c> upstream;

        b(w<? super T> wVar, h<? super T, ? extends u<?>> hVar, u<? extends T> uVar) {
            this.downstream = wVar;
            this.itemTimeoutIndicator = hVar;
            this.fallback = uVar;
            this.index = new AtomicLong();
            this.upstream = new AtomicReference<>();
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.upstream, cVar);
        }

        public final void onNext(T t) {
            long j = this.index.get();
            if (j != Long.MAX_VALUE) {
                long j2 = 1 + j;
                if (this.index.compareAndSet(j, j2)) {
                    io.reactivex.rxjava3.b.c cVar = (io.reactivex.rxjava3.b.c) this.task.get();
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    this.downstream.onNext(t);
                    try {
                        u uVar = (u) Objects.requireNonNull(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null ObservableSource.");
                        a aVar = new a(j2, this);
                        if (this.task.replace(aVar)) {
                            uVar.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        io.reactivex.rxjava3.c.b.b(th);
                        this.upstream.get().dispose();
                        this.index.getAndSet(Long.MAX_VALUE);
                        this.downstream.onError(th);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void startFirstTimeout(u<?> uVar) {
            if (uVar != null) {
                a aVar = new a(0, this);
                if (this.task.replace(aVar)) {
                    uVar.subscribe(aVar);
                }
            }
        }

        public final void onError(Throwable th) {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onError(th);
                this.task.dispose();
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void onComplete() {
            if (this.index.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.task.dispose();
                this.downstream.onComplete();
                this.task.dispose();
            }
        }

        public final void onTimeout(long j) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
                u<? extends T> uVar = this.fallback;
                this.fallback = null;
                uVar.subscribe(new ec.a(this.downstream, this));
            }
        }

        public final void onTimeoutError(long j, Throwable th) {
            if (this.index.compareAndSet(j, Long.MAX_VALUE)) {
                io.reactivex.rxjava3.e.a.c.dispose(this);
                this.downstream.onError(th);
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this.upstream);
            io.reactivex.rxjava3.e.a.c.dispose(this);
            this.task.dispose();
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((io.reactivex.rxjava3.b.c) get());
        }
    }

    static final class a extends AtomicReference<io.reactivex.rxjava3.b.c> implements w<Object>, io.reactivex.rxjava3.b.c {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final d parent;

        a(long j, d dVar) {
            this.idx = j;
            this.parent = dVar;
        }

        public final void onSubscribe(io.reactivex.rxjava3.b.c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }

        public final void onNext(Object obj) {
            io.reactivex.rxjava3.b.c cVar = (io.reactivex.rxjava3.b.c) get();
            if (cVar != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                cVar.dispose();
                lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
                this.parent.onTimeout(this.idx);
            }
        }

        public final void onError(Throwable th) {
            if (get() != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
                this.parent.onTimeoutError(this.idx, th);
                return;
            }
            io.reactivex.rxjava3.h.a.a(th);
        }

        public final void onComplete() {
            if (get() != io.reactivex.rxjava3.e.a.c.DISPOSED) {
                lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
                this.parent.onTimeout(this.idx);
            }
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((io.reactivex.rxjava3.b.c) get());
        }
    }
}
