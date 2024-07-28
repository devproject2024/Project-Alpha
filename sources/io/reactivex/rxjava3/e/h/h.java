package io.reactivex.rxjava3.e.h;

import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.h.a;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class h extends x.c implements c {

    /* renamed from: b  reason: collision with root package name */
    public final ScheduledExecutorService f47690b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f47691c;

    public h(ThreadFactory threadFactory) {
        this.f47690b = n.a(threadFactory);
    }

    public final c a(Runnable runnable) {
        return a(runnable, 0, (TimeUnit) null);
    }

    public final c a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (this.f47691c) {
            return d.INSTANCE;
        }
        return a(runnable, j, timeUnit, (io.reactivex.rxjava3.b.d) null);
    }

    public final c b(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        l lVar = new l(a.a(runnable));
        if (j <= 0) {
            try {
                future = this.f47690b.submit(lVar);
            } catch (RejectedExecutionException e2) {
                a.a((Throwable) e2);
                return d.INSTANCE;
            }
        } else {
            future = this.f47690b.schedule(lVar, j, timeUnit);
        }
        lVar.setFuture(future);
        return lVar;
    }

    public final c b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future future;
        Runnable a2 = a.a(runnable);
        if (j2 <= 0) {
            e eVar = new e(a2, this.f47690b);
            if (j <= 0) {
                try {
                    future = this.f47690b.submit(eVar);
                } catch (RejectedExecutionException e2) {
                    a.a((Throwable) e2);
                    return d.INSTANCE;
                }
            } else {
                future = this.f47690b.schedule(eVar, j, timeUnit);
            }
            eVar.a(future);
            return eVar;
        }
        k kVar = new k(a2);
        try {
            kVar.setFuture(this.f47690b.scheduleAtFixedRate(kVar, j, j2, timeUnit));
            return kVar;
        } catch (RejectedExecutionException e3) {
            a.a((Throwable) e3);
            return d.INSTANCE;
        }
    }

    public final m a(Runnable runnable, long j, TimeUnit timeUnit, io.reactivex.rxjava3.b.d dVar) {
        Future future;
        m mVar = new m(a.a(runnable), dVar);
        if (dVar != null && !dVar.a(mVar)) {
            return mVar;
        }
        if (j <= 0) {
            try {
                future = this.f47690b.submit(mVar);
            } catch (RejectedExecutionException e2) {
                if (dVar != null) {
                    dVar.b(mVar);
                }
                a.a((Throwable) e2);
            }
        } else {
            future = this.f47690b.schedule(mVar, j, timeUnit);
        }
        mVar.setFuture(future);
        return mVar;
    }

    public void dispose() {
        if (!this.f47691c) {
            this.f47691c = true;
            this.f47690b.shutdownNow();
        }
    }

    public boolean isDisposed() {
        return this.f47691c;
    }
}
