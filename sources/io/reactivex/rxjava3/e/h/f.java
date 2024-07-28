package io.reactivex.rxjava3.e.h;

import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.e.a.d;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class f extends x {

    /* renamed from: b  reason: collision with root package name */
    static final j f47669b;

    /* renamed from: c  reason: collision with root package name */
    static final j f47670c;

    /* renamed from: d  reason: collision with root package name */
    static final c f47671d;

    /* renamed from: g  reason: collision with root package name */
    static final a f47672g;

    /* renamed from: h  reason: collision with root package name */
    private static final long f47673h = Long.getLong("rx3.io-keep-alive-time", 60).longValue();

    /* renamed from: i  reason: collision with root package name */
    private static final TimeUnit f47674i = TimeUnit.SECONDS;

    /* renamed from: e  reason: collision with root package name */
    final ThreadFactory f47675e;

    /* renamed from: f  reason: collision with root package name */
    final AtomicReference<a> f47676f;

    static {
        c cVar = new c(new j("RxCachedThreadSchedulerShutdown"));
        f47671d = cVar;
        cVar.dispose();
        int max = Math.max(1, Math.min(10, Integer.getInteger("rx3.io-priority", 5).intValue()));
        f47669b = new j("RxCachedThreadScheduler", max);
        f47670c = new j("RxCachedWorkerPoolEvictor", max);
        a aVar = new a(0, (TimeUnit) null, f47669b);
        f47672g = aVar;
        aVar.c();
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final long f47677a;

        /* renamed from: b  reason: collision with root package name */
        final ConcurrentLinkedQueue<c> f47678b;

        /* renamed from: c  reason: collision with root package name */
        final io.reactivex.rxjava3.b.b f47679c;

        /* renamed from: d  reason: collision with root package name */
        private final ScheduledExecutorService f47680d;

        /* renamed from: e  reason: collision with root package name */
        private final Future<?> f47681e;

        /* renamed from: f  reason: collision with root package name */
        private final ThreadFactory f47682f;

        a(long j, TimeUnit timeUnit, ThreadFactory threadFactory) {
            ScheduledFuture<?> scheduledFuture;
            this.f47677a = timeUnit != null ? timeUnit.toNanos(j) : 0;
            this.f47678b = new ConcurrentLinkedQueue<>();
            this.f47679c = new io.reactivex.rxjava3.b.b();
            this.f47682f = threadFactory;
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, f.f47670c);
                long j2 = this.f47677a;
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(this, j2, j2, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f47680d = scheduledExecutorService;
            this.f47681e = scheduledFuture;
        }

        public final void run() {
            ConcurrentLinkedQueue<c> concurrentLinkedQueue = this.f47678b;
            io.reactivex.rxjava3.b.b bVar = this.f47679c;
            if (!concurrentLinkedQueue.isEmpty()) {
                long nanoTime = System.nanoTime();
                Iterator<c> it2 = concurrentLinkedQueue.iterator();
                while (it2.hasNext()) {
                    c next = it2.next();
                    if (next.f47687a > nanoTime) {
                        return;
                    }
                    if (concurrentLinkedQueue.remove(next)) {
                        bVar.b(next);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final c a() {
            if (this.f47679c.isDisposed()) {
                return f.f47671d;
            }
            while (!this.f47678b.isEmpty()) {
                c poll = this.f47678b.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f47682f);
            this.f47679c.a((io.reactivex.rxjava3.b.c) cVar);
            return cVar;
        }

        static long b() {
            return System.nanoTime();
        }

        /* access modifiers changed from: package-private */
        public final void c() {
            this.f47679c.dispose();
            Future<?> future = this.f47681e;
            if (future != null) {
                future.cancel(true);
            }
            ScheduledExecutorService scheduledExecutorService = this.f47680d;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.shutdownNow();
            }
        }
    }

    public f() {
        this(f47669b);
    }

    private f(ThreadFactory threadFactory) {
        this.f47675e = threadFactory;
        this.f47676f = new AtomicReference<>(f47672g);
        b();
    }

    public final void b() {
        a aVar = new a(f47673h, f47674i, this.f47675e);
        if (!this.f47676f.compareAndSet(f47672g, aVar)) {
            aVar.c();
        }
    }

    public final x.c a() {
        return new b(this.f47676f.get());
    }

    static final class b extends x.c {

        /* renamed from: a  reason: collision with root package name */
        final AtomicBoolean f47683a = new AtomicBoolean();

        /* renamed from: b  reason: collision with root package name */
        private final io.reactivex.rxjava3.b.b f47684b;

        /* renamed from: c  reason: collision with root package name */
        private final a f47685c;

        /* renamed from: d  reason: collision with root package name */
        private final c f47686d;

        b(a aVar) {
            this.f47685c = aVar;
            this.f47684b = new io.reactivex.rxjava3.b.b();
            this.f47686d = aVar.a();
        }

        public final void dispose() {
            if (this.f47683a.compareAndSet(false, true)) {
                this.f47684b.dispose();
                a aVar = this.f47685c;
                c cVar = this.f47686d;
                cVar.f47687a = a.b() + aVar.f47677a;
                aVar.f47678b.offer(cVar);
            }
        }

        public final boolean isDisposed() {
            return this.f47683a.get();
        }

        public final io.reactivex.rxjava3.b.c a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f47684b.isDisposed()) {
                return d.INSTANCE;
            }
            return this.f47686d.a(runnable, j, timeUnit, this.f47684b);
        }
    }

    static final class c extends h {

        /* renamed from: a  reason: collision with root package name */
        long f47687a = 0;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
