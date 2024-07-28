package io.reactivex.rxjava3.e.h;

import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.b;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.a.d;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class o extends x {

    /* renamed from: d  reason: collision with root package name */
    static final j f47696d = new j("RxSingleScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx3.single-priority", 5).intValue())), true);

    /* renamed from: e  reason: collision with root package name */
    static final ScheduledExecutorService f47697e;

    /* renamed from: b  reason: collision with root package name */
    final ThreadFactory f47698b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<ScheduledExecutorService> f47699c;

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f47697e = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
    }

    public o() {
        this(f47696d);
    }

    private o(ThreadFactory threadFactory) {
        this.f47699c = new AtomicReference<>();
        this.f47698b = threadFactory;
        this.f47699c.lazySet(n.a(threadFactory));
    }

    public final void b() {
        ScheduledExecutorService scheduledExecutorService;
        ScheduledExecutorService scheduledExecutorService2 = null;
        do {
            scheduledExecutorService = this.f47699c.get();
            if (scheduledExecutorService != f47697e) {
                if (scheduledExecutorService2 != null) {
                    scheduledExecutorService2.shutdown();
                    return;
                }
                return;
            } else if (scheduledExecutorService2 == null) {
                scheduledExecutorService2 = n.a(this.f47698b);
            }
        } while (!this.f47699c.compareAndSet(scheduledExecutorService, scheduledExecutorService2));
    }

    public final x.c a() {
        return new a(this.f47699c.get());
    }

    public final c a(Runnable runnable, long j, TimeUnit timeUnit) {
        Future future;
        l lVar = new l(io.reactivex.rxjava3.h.a.a(runnable));
        if (j <= 0) {
            try {
                future = this.f47699c.get().submit(lVar);
            } catch (RejectedExecutionException e2) {
                io.reactivex.rxjava3.h.a.a((Throwable) e2);
                return d.INSTANCE;
            }
        } else {
            future = this.f47699c.get().schedule(lVar, j, timeUnit);
        }
        lVar.setFuture(future);
        return lVar;
    }

    public final c a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        Future future;
        Runnable a2 = io.reactivex.rxjava3.h.a.a(runnable);
        if (j2 <= 0) {
            ScheduledExecutorService scheduledExecutorService = this.f47699c.get();
            e eVar = new e(a2, scheduledExecutorService);
            if (j <= 0) {
                try {
                    future = scheduledExecutorService.submit(eVar);
                } catch (RejectedExecutionException e2) {
                    io.reactivex.rxjava3.h.a.a((Throwable) e2);
                    return d.INSTANCE;
                }
            } else {
                future = scheduledExecutorService.schedule(eVar, j, timeUnit);
            }
            eVar.a(future);
            return eVar;
        }
        k kVar = new k(a2);
        try {
            kVar.setFuture(this.f47699c.get().scheduleAtFixedRate(kVar, j, j2, timeUnit));
            return kVar;
        } catch (RejectedExecutionException e3) {
            io.reactivex.rxjava3.h.a.a((Throwable) e3);
            return d.INSTANCE;
        }
    }

    static final class a extends x.c {

        /* renamed from: a  reason: collision with root package name */
        final ScheduledExecutorService f47700a;

        /* renamed from: b  reason: collision with root package name */
        final b f47701b = new b();

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f47702c;

        a(ScheduledExecutorService scheduledExecutorService) {
            this.f47700a = scheduledExecutorService;
        }

        public final c a(Runnable runnable, long j, TimeUnit timeUnit) {
            Future future;
            if (this.f47702c) {
                return d.INSTANCE;
            }
            m mVar = new m(io.reactivex.rxjava3.h.a.a(runnable), this.f47701b);
            this.f47701b.a((c) mVar);
            if (j <= 0) {
                try {
                    future = this.f47700a.submit(mVar);
                } catch (RejectedExecutionException e2) {
                    dispose();
                    io.reactivex.rxjava3.h.a.a((Throwable) e2);
                    return d.INSTANCE;
                }
            } else {
                future = this.f47700a.schedule(mVar, j, timeUnit);
            }
            mVar.setFuture(future);
            return mVar;
        }

        public final void dispose() {
            if (!this.f47702c) {
                this.f47702c = true;
                this.f47701b.dispose();
            }
        }

        public final boolean isDisposed() {
            return this.f47702c;
        }
    }
}
