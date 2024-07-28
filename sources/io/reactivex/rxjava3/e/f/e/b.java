package io.reactivex.rxjava3.e.f.e;

import io.reactivex.rxjava3.a.u;
import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.e;
import io.reactivex.rxjava3.e.k.j;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class b<T> implements Iterable<T> {

    /* renamed from: a  reason: collision with root package name */
    final u<? extends T> f47028a;

    /* renamed from: b  reason: collision with root package name */
    final int f47029b;

    public b(u<? extends T> uVar, int i2) {
        this.f47028a = uVar;
        this.f47029b = i2;
    }

    public final Iterator<T> iterator() {
        a aVar = new a(this.f47029b);
        this.f47028a.subscribe(aVar);
        return aVar;
    }

    static final class a<T> extends AtomicReference<c> implements w<T>, c, Iterator<T> {
        private static final long serialVersionUID = 6695226475494099826L;
        final Condition condition = this.lock.newCondition();
        volatile boolean done;
        volatile Throwable error;
        final Lock lock = new ReentrantLock();
        final io.reactivex.rxjava3.e.g.c<T> queue;

        a(int i2) {
            this.queue = new io.reactivex.rxjava3.e.g.c<>(i2);
        }

        public final boolean hasNext() {
            while (!isDisposed()) {
                boolean z = this.done;
                boolean isEmpty = this.queue.isEmpty();
                if (z) {
                    Throwable th = this.error;
                    if (th != null) {
                        throw j.a(th);
                    } else if (isEmpty) {
                        return false;
                    }
                }
                if (!isEmpty) {
                    return true;
                }
                e.a();
                this.lock.lock();
                while (!this.done && this.queue.isEmpty() && !isDisposed()) {
                    try {
                        this.condition.await();
                    } catch (InterruptedException e2) {
                        io.reactivex.rxjava3.e.a.c.dispose(this);
                        signalConsumer();
                        throw j.a((Throwable) e2);
                    } catch (Throwable th2) {
                        this.lock.unlock();
                        throw th2;
                    }
                }
                this.lock.unlock();
            }
            Throwable th3 = this.error;
            if (th3 == null) {
                return false;
            }
            throw j.a(th3);
        }

        public final T next() {
            if (hasNext()) {
                return this.queue.poll();
            }
            throw new NoSuchElementException();
        }

        public final void onSubscribe(c cVar) {
            io.reactivex.rxjava3.e.a.c.setOnce(this, cVar);
        }

        public final void onNext(T t) {
            this.queue.offer(t);
            signalConsumer();
        }

        public final void onError(Throwable th) {
            this.error = th;
            this.done = true;
            signalConsumer();
        }

        public final void onComplete() {
            this.done = true;
            signalConsumer();
        }

        /* access modifiers changed from: package-private */
        public final void signalConsumer() {
            this.lock.lock();
            try {
                this.condition.signalAll();
            } finally {
                this.lock.unlock();
            }
        }

        public final void remove() {
            throw new UnsupportedOperationException("remove");
        }

        public final void dispose() {
            io.reactivex.rxjava3.e.a.c.dispose(this);
            signalConsumer();
        }

        public final boolean isDisposed() {
            return io.reactivex.rxjava3.e.a.c.isDisposed((c) get());
        }
    }
}
