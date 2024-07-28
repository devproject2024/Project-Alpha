package io.reactivex.rxjava3.e.e;

import io.reactivex.rxjava3.a.w;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.k.e;
import io.reactivex.rxjava3.e.k.j;
import io.reactivex.rxjava3.h.a;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

public final class p<T> extends CountDownLatch implements w<T>, c, Future<T> {

    /* renamed from: a  reason: collision with root package name */
    T f46731a;

    /* renamed from: b  reason: collision with root package name */
    Throwable f46732b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<c> f46733c = new AtomicReference<>();

    public final void dispose() {
    }

    public p() {
        super(1);
    }

    public final boolean cancel(boolean z) {
        c cVar;
        do {
            cVar = this.f46733c.get();
            if (cVar == this || cVar == io.reactivex.rxjava3.e.a.c.DISPOSED) {
                return false;
            }
        } while (!this.f46733c.compareAndSet(cVar, io.reactivex.rxjava3.e.a.c.DISPOSED));
        if (cVar != null) {
            cVar.dispose();
        }
        countDown();
        return true;
    }

    public final boolean isCancelled() {
        return io.reactivex.rxjava3.e.a.c.isDisposed(this.f46733c.get());
    }

    public final boolean isDone() {
        return getCount() == 0;
    }

    public final T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            e.a();
            await();
        }
        if (!isCancelled()) {
            Throwable th = this.f46732b;
            if (th == null) {
                return this.f46731a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public final T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            e.a();
            if (!await(j, timeUnit)) {
                throw new TimeoutException(j.a(j, timeUnit));
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f46732b;
            if (th == null) {
                return this.f46731a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }

    public final void onSubscribe(c cVar) {
        io.reactivex.rxjava3.e.a.c.setOnce(this.f46733c, cVar);
    }

    public final void onNext(T t) {
        if (this.f46731a != null) {
            this.f46733c.get().dispose();
            onError(new IndexOutOfBoundsException("More than one element received"));
            return;
        }
        this.f46731a = t;
    }

    public final void onError(Throwable th) {
        c cVar;
        if (this.f46732b != null || (cVar = this.f46733c.get()) == this || cVar == io.reactivex.rxjava3.e.a.c.DISPOSED || !this.f46733c.compareAndSet(cVar, this)) {
            a.a(th);
            return;
        }
        this.f46732b = th;
        countDown();
    }

    public final void onComplete() {
        if (this.f46731a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        c cVar = this.f46733c.get();
        if (cVar != this && cVar != io.reactivex.rxjava3.e.a.c.DISPOSED && this.f46733c.compareAndSet(cVar, this)) {
            countDown();
        }
    }

    public final boolean isDisposed() {
        return isDone();
    }
}
