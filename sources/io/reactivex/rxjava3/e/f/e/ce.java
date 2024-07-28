package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.aa;
import io.reactivex.rxjava3.a.ac;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.c.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ce<T> extends a<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final ac<? extends T> f47157b;

    public ce(p<T> pVar, ac<? extends T> acVar) {
        super(pVar);
        this.f47157b = acVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        a aVar = new a(wVar);
        wVar.onSubscribe(aVar);
        this.f46900a.subscribe(aVar);
        this.f47157b.a(aVar.otherObserver);
    }

    static final class a<T> extends AtomicInteger implements w<T>, c {
        static final int OTHER_STATE_CONSUMED_OR_EMPTY = 2;
        static final int OTHER_STATE_HAS_VALUE = 1;
        private static final long serialVersionUID = -4592979584110982903L;
        volatile boolean disposed;
        final w<? super T> downstream;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        final AtomicReference<c> mainDisposable = new AtomicReference<>();
        volatile boolean mainDone;
        final C0810a<T> otherObserver = new C0810a<>(this);
        volatile int otherState;
        volatile j<T> queue;
        T singleItem;

        a(w<? super T> wVar) {
            this.downstream = wVar;
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this.mainDisposable, cVar);
        }

        public final void onNext(T t) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t);
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                getOrCreateQueue().offer(t);
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        public final void onError(Throwable th) {
            if (this.errors.tryAddThrowableOrReport(th)) {
                io.reactivex.rxjava3.e.a.c.dispose(this.otherObserver);
                drain();
            }
        }

        public final void onComplete() {
            this.mainDone = true;
            drain();
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed(this.mainDisposable.get());
        }

        public final void dispose() {
            this.disposed = true;
            io.reactivex.rxjava3.e.a.c.dispose(this.mainDisposable);
            io.reactivex.rxjava3.e.a.c.dispose(this.otherObserver);
            this.errors.tryTerminateAndReport();
            if (getAndIncrement() == 0) {
                this.queue = null;
                this.singleItem = null;
            }
        }

        /* access modifiers changed from: package-private */
        public final void otherSuccess(T t) {
            if (compareAndSet(0, 1)) {
                this.downstream.onNext(t);
                this.otherState = 2;
            } else {
                this.singleItem = t;
                this.otherState = 1;
                if (getAndIncrement() != 0) {
                    return;
                }
            }
            drainLoop();
        }

        /* access modifiers changed from: package-private */
        public final void otherError(Throwable th) {
            if (this.errors.tryAddThrowableOrReport(th)) {
                io.reactivex.rxjava3.e.a.c.dispose(this.mainDisposable);
                drain();
            }
        }

        /* access modifiers changed from: package-private */
        public final j<T> getOrCreateQueue() {
            j<T> jVar = this.queue;
            if (jVar != null) {
                return jVar;
            }
            io.reactivex.rxjava3.e.g.c cVar = new io.reactivex.rxjava3.e.g.c(p.bufferSize());
            this.queue = cVar;
            return cVar;
        }

        /* access modifiers changed from: package-private */
        public final void drain() {
            if (getAndIncrement() == 0) {
                drainLoop();
            }
        }

        /* access modifiers changed from: package-private */
        public final void drainLoop() {
            w<? super T> wVar = this.downstream;
            int i2 = 1;
            while (!this.disposed) {
                if (this.errors.get() != null) {
                    this.singleItem = null;
                    this.queue = null;
                    this.errors.tryTerminateConsumer((w<?>) wVar);
                    return;
                }
                int i3 = this.otherState;
                if (i3 == 1) {
                    T t = this.singleItem;
                    this.singleItem = null;
                    this.otherState = 2;
                    wVar.onNext(t);
                    i3 = 2;
                }
                boolean z = this.mainDone;
                j<T> jVar = this.queue;
                T poll = jVar != null ? jVar.poll() : null;
                boolean z2 = poll == null;
                if (z && z2 && i3 == 2) {
                    this.queue = null;
                    wVar.onComplete();
                    return;
                } else if (!z2) {
                    wVar.onNext(poll);
                } else {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
            this.singleItem = null;
            this.queue = null;
        }

        /* renamed from: io.reactivex.rxjava3.e.f.e.ce$a$a  reason: collision with other inner class name */
        static final class C0810a<T> extends AtomicReference<c> implements aa<T> {
            private static final long serialVersionUID = -2935427570954647017L;
            final a<T> parent;

            C0810a(a<T> aVar) {
                this.parent = aVar;
            }

            public final void onSubscribe(c cVar) {
                io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
            }

            public final void onSuccess(T t) {
                this.parent.otherSuccess(t);
            }

            public final void onError(Throwable th) {
                this.parent.otherError(th);
            }
        }
    }
}
