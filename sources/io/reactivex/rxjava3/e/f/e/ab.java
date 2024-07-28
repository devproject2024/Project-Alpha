package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.g;
import io.reactivex.rxjava3.a.p;
import io.reactivex.rxjava3.a.r;
import io.reactivex.rxjava3.a.s;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.d.f;
import io.reactivex.rxjava3.e.k.j;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ab<T> extends p<T> {

    /* renamed from: a  reason: collision with root package name */
    final s<T> f46905a;

    public ab(s<T> sVar) {
        this.f46905a = sVar;
    }

    public final void subscribeActual(w<? super T> wVar) {
        a aVar = new a(wVar);
        wVar.onSubscribe(aVar);
        try {
            this.f46905a.subscribe(aVar);
        } catch (Throwable th) {
            io.reactivex.rxjava3.c.b.b(th);
            aVar.onError(th);
        }
    }

    static final class a<T> extends AtomicReference<c> implements r<T>, c {
        private static final long serialVersionUID = -3434801548987643227L;
        final w<? super T> observer;

        a(w<? super T> wVar) {
            this.observer = wVar;
        }

        public final void onNext(T t) {
            if (t == null) {
                onError(j.a("onNext called with a null value."));
            } else if (!isDisposed()) {
                this.observer.onNext(t);
            }
        }

        public final void onError(Throwable th) {
            if (!tryOnError(th)) {
                io.reactivex.rxjava3.h.a.a(th);
            }
        }

        /* JADX INFO: finally extract failed */
        public final boolean tryOnError(Throwable th) {
            if (th == null) {
                th = j.a("onError called with a null Throwable.");
            }
            if (isDisposed()) {
                return false;
            }
            try {
                this.observer.onError(th);
                dispose();
                return true;
            } catch (Throwable th2) {
                dispose();
                throw th2;
            }
        }

        public final void onComplete() {
            if (!isDisposed()) {
                try {
                    this.observer.onComplete();
                } finally {
                    dispose();
                }
            }
        }

        public final void setDisposable(c cVar) {
            io.reactivex.rxjava3.e.a.c.set(this, cVar);
        }

        public final void setCancellable(f fVar) {
            setDisposable(new io.reactivex.rxjava3.e.a.b(fVar));
        }

        public final r<T> serialize() {
            return new b(this);
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }

        public final String toString() {
            return String.format("%s{%s}", new Object[]{getClass().getSimpleName(), super.toString()});
        }
    }

    static final class b<T> extends AtomicInteger implements r<T> {
        private static final long serialVersionUID = 4883307006032401862L;
        volatile boolean done;
        final r<T> emitter;
        final io.reactivex.rxjava3.e.k.c errors = new io.reactivex.rxjava3.e.k.c();
        final io.reactivex.rxjava3.e.g.c<T> queue = new io.reactivex.rxjava3.e.g.c<>(16);

        public final r<T> serialize() {
            return this;
        }

        b(r<T> rVar) {
            this.emitter = rVar;
        }

        public final void onNext(T t) {
            if (!this.done && !this.emitter.isDisposed()) {
                if (t == null) {
                    onError(j.a("onNext called with a null value."));
                    return;
                }
                if (get() != 0 || !compareAndSet(0, 1)) {
                    io.reactivex.rxjava3.e.g.c<T> cVar = this.queue;
                    synchronized (cVar) {
                        cVar.offer(t);
                    }
                    if (getAndIncrement() != 0) {
                        return;
                    }
                } else {
                    this.emitter.onNext(t);
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                drainLoop();
            }
        }

        public final void onError(Throwable th) {
            if (!tryOnError(th)) {
                io.reactivex.rxjava3.h.a.a(th);
            }
        }

        public final boolean tryOnError(Throwable th) {
            if (!this.done && !this.emitter.isDisposed()) {
                if (th == null) {
                    th = j.a("onError called with a null Throwable.");
                }
                if (this.errors.tryAddThrowable(th)) {
                    this.done = true;
                    drain();
                    return true;
                }
            }
            return false;
        }

        public final void onComplete() {
            if (!this.done && !this.emitter.isDisposed()) {
                this.done = true;
                drain();
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
            r<T> rVar = this.emitter;
            io.reactivex.rxjava3.e.g.c<T> cVar = this.queue;
            io.reactivex.rxjava3.e.k.c cVar2 = this.errors;
            int i2 = 1;
            while (!rVar.isDisposed()) {
                if (cVar2.get() != null) {
                    cVar.clear();
                    cVar2.tryTerminateConsumer((g<?>) rVar);
                    return;
                }
                boolean z = this.done;
                T poll = cVar.poll();
                boolean z2 = poll == null;
                if (z && z2) {
                    rVar.onComplete();
                    return;
                } else if (!z2) {
                    rVar.onNext(poll);
                } else {
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
            cVar.clear();
        }

        public final void setDisposable(c cVar) {
            this.emitter.setDisposable(cVar);
        }

        public final void setCancellable(f fVar) {
            this.emitter.setCancellable(fVar);
        }

        public final boolean isDisposed() {
            return this.emitter.isDisposed();
        }

        public final String toString() {
            return this.emitter.toString();
        }
    }
}
