package io.reactivex.rxjava3.e.h;

import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.b.a;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

final class e implements c, Callable<Void> {

    /* renamed from: f  reason: collision with root package name */
    static final FutureTask<Void> f47663f = new FutureTask<>(a.f46646b, (Object) null);

    /* renamed from: a  reason: collision with root package name */
    final Runnable f47664a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<Future<?>> f47665b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<Future<?>> f47666c = new AtomicReference<>();

    /* renamed from: d  reason: collision with root package name */
    final ExecutorService f47667d;

    /* renamed from: e  reason: collision with root package name */
    Thread f47668e;

    e(Runnable runnable, ExecutorService executorService) {
        this.f47664a = runnable;
        this.f47667d = executorService;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Void call() {
        this.f47668e = Thread.currentThread();
        try {
            this.f47664a.run();
            this.f47668e = null;
            Future submit = this.f47667d.submit(this);
            while (true) {
                Future future = this.f47665b.get();
                if (future != f47663f) {
                    if (this.f47665b.compareAndSet(future, submit)) {
                        break;
                    }
                } else {
                    submit.cancel(this.f47668e != Thread.currentThread());
                }
            }
            return null;
        } catch (Throwable th) {
            this.f47668e = null;
            io.reactivex.rxjava3.h.a.a(th);
            throw th;
        }
    }

    public final void dispose() {
        Future andSet = this.f47666c.getAndSet(f47663f);
        boolean z = true;
        if (!(andSet == null || andSet == f47663f)) {
            andSet.cancel(this.f47668e != Thread.currentThread());
        }
        Future andSet2 = this.f47665b.getAndSet(f47663f);
        if (andSet2 != null && andSet2 != f47663f) {
            if (this.f47668e == Thread.currentThread()) {
                z = false;
            }
            andSet2.cancel(z);
        }
    }

    public final boolean isDisposed() {
        return this.f47666c.get() == f47663f;
    }

    /* access modifiers changed from: package-private */
    public final void a(Future<?> future) {
        Future future2;
        do {
            future2 = this.f47666c.get();
            if (future2 == f47663f) {
                future.cancel(this.f47668e != Thread.currentThread());
                return;
            }
        } while (!this.f47666c.compareAndSet(future2, future));
    }
}
