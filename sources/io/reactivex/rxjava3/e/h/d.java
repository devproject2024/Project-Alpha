package io.reactivex.rxjava3.e.h;

import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.e.a.f;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class d extends x {

    /* renamed from: e  reason: collision with root package name */
    static final x f47647e = io.reactivex.rxjava3.i.a.e();

    /* renamed from: b  reason: collision with root package name */
    final boolean f47648b = false;

    /* renamed from: c  reason: collision with root package name */
    final boolean f47649c = false;

    /* renamed from: d  reason: collision with root package name */
    final Executor f47650d;

    public d(Executor executor) {
        this.f47650d = executor;
    }

    public final x.c a() {
        return new c(this.f47650d, this.f47648b, this.f47649c);
    }

    public final io.reactivex.rxjava3.b.c a(Runnable runnable) {
        Runnable a2 = io.reactivex.rxjava3.h.a.a(runnable);
        try {
            if (this.f47650d instanceof ExecutorService) {
                l lVar = new l(a2);
                lVar.setFuture(((ExecutorService) this.f47650d).submit(lVar));
                return lVar;
            } else if (this.f47648b) {
                c.b bVar = new c.b(a2, (io.reactivex.rxjava3.b.d) null);
                this.f47650d.execute(bVar);
                return bVar;
            } else {
                c.a aVar = new c.a(a2);
                this.f47650d.execute(aVar);
                return aVar;
            }
        } catch (RejectedExecutionException e2) {
            io.reactivex.rxjava3.h.a.a((Throwable) e2);
            return io.reactivex.rxjava3.e.a.d.INSTANCE;
        }
    }

    public final io.reactivex.rxjava3.b.c a(Runnable runnable, long j, TimeUnit timeUnit) {
        Runnable a2 = io.reactivex.rxjava3.h.a.a(runnable);
        if (this.f47650d instanceof ScheduledExecutorService) {
            try {
                l lVar = new l(a2);
                lVar.setFuture(((ScheduledExecutorService) this.f47650d).schedule(lVar, j, timeUnit));
                return lVar;
            } catch (RejectedExecutionException e2) {
                io.reactivex.rxjava3.h.a.a((Throwable) e2);
                return io.reactivex.rxjava3.e.a.d.INSTANCE;
            }
        } else {
            b bVar = new b(a2);
            bVar.timed.replace(f47647e.a(new a(bVar), j, timeUnit));
            return bVar;
        }
    }

    public final io.reactivex.rxjava3.b.c a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        if (!(this.f47650d instanceof ScheduledExecutorService)) {
            return super.a(runnable, j, j2, timeUnit);
        }
        try {
            k kVar = new k(io.reactivex.rxjava3.h.a.a(runnable));
            kVar.setFuture(((ScheduledExecutorService) this.f47650d).scheduleAtFixedRate(kVar, j, j2, timeUnit));
            return kVar;
        } catch (RejectedExecutionException e2) {
            io.reactivex.rxjava3.h.a.a((Throwable) e2);
            return io.reactivex.rxjava3.e.a.d.INSTANCE;
        }
    }

    public static final class c extends x.c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final boolean f47653a;

        /* renamed from: b  reason: collision with root package name */
        final boolean f47654b;

        /* renamed from: c  reason: collision with root package name */
        final Executor f47655c;

        /* renamed from: d  reason: collision with root package name */
        final io.reactivex.rxjava3.e.g.a<Runnable> f47656d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f47657e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f47658f = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        final io.reactivex.rxjava3.b.b f47659g = new io.reactivex.rxjava3.b.b();

        public c(Executor executor, boolean z, boolean z2) {
            this.f47655c = executor;
            this.f47656d = new io.reactivex.rxjava3.e.g.a<>();
            this.f47653a = z;
            this.f47654b = z2;
        }

        public final io.reactivex.rxjava3.b.c a(Runnable runnable) {
            io.reactivex.rxjava3.b.c cVar;
            if (this.f47657e) {
                return io.reactivex.rxjava3.e.a.d.INSTANCE;
            }
            Runnable a2 = io.reactivex.rxjava3.h.a.a(runnable);
            if (this.f47653a) {
                cVar = new b(a2, this.f47659g);
                this.f47659g.a(cVar);
            } else {
                cVar = new a(a2);
            }
            this.f47656d.offer(cVar);
            if (this.f47658f.getAndIncrement() == 0) {
                try {
                    this.f47655c.execute(this);
                } catch (RejectedExecutionException e2) {
                    this.f47657e = true;
                    this.f47656d.clear();
                    io.reactivex.rxjava3.h.a.a((Throwable) e2);
                    return io.reactivex.rxjava3.e.a.d.INSTANCE;
                }
            }
            return cVar;
        }

        public final io.reactivex.rxjava3.b.c a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (j <= 0) {
                return a(runnable);
            }
            if (this.f47657e) {
                return io.reactivex.rxjava3.e.a.d.INSTANCE;
            }
            f fVar = new f();
            f fVar2 = new f(fVar);
            m mVar = new m(new C0825c(fVar2, io.reactivex.rxjava3.h.a.a(runnable)), this.f47659g);
            this.f47659g.a((io.reactivex.rxjava3.b.c) mVar);
            Executor executor = this.f47655c;
            if (executor instanceof ScheduledExecutorService) {
                try {
                    mVar.setFuture(((ScheduledExecutorService) executor).schedule(mVar, j, timeUnit));
                } catch (RejectedExecutionException e2) {
                    this.f47657e = true;
                    io.reactivex.rxjava3.h.a.a((Throwable) e2);
                    return io.reactivex.rxjava3.e.a.d.INSTANCE;
                }
            } else {
                mVar.setFuture(new c(d.f47647e.a(mVar, j, timeUnit)));
            }
            fVar.replace(mVar);
            return fVar2;
        }

        public final void dispose() {
            if (!this.f47657e) {
                this.f47657e = true;
                this.f47659g.dispose();
                if (this.f47658f.getAndIncrement() == 0) {
                    this.f47656d.clear();
                }
            }
        }

        public final boolean isDisposed() {
            return this.f47657e;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x004d, code lost:
            if (r3.f47657e == false) goto L_0x0053;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x004f, code lost:
            r1.clear();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0052, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0053, code lost:
            r0 = r3.f47658f.addAndGet(-r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x005a, code lost:
            if (r0 != 0) goto L_0x0030;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r3 = this;
                boolean r0 = r3.f47654b
                if (r0 == 0) goto L_0x002d
                io.reactivex.rxjava3.e.g.a<java.lang.Runnable> r0 = r3.f47656d
                boolean r1 = r3.f47657e
                if (r1 == 0) goto L_0x000e
                r0.clear()
                return
            L_0x000e:
                java.lang.Object r1 = r0.poll()
                java.lang.Runnable r1 = (java.lang.Runnable) r1
                r1.run()
                boolean r1 = r3.f47657e
                if (r1 == 0) goto L_0x001f
                r0.clear()
                return
            L_0x001f:
                java.util.concurrent.atomic.AtomicInteger r0 = r3.f47658f
                int r0 = r0.decrementAndGet()
                if (r0 == 0) goto L_0x002c
                java.util.concurrent.Executor r0 = r3.f47655c
                r0.execute(r3)
            L_0x002c:
                return
            L_0x002d:
                r0 = 1
                io.reactivex.rxjava3.e.g.a<java.lang.Runnable> r1 = r3.f47656d
            L_0x0030:
                boolean r2 = r3.f47657e
                if (r2 == 0) goto L_0x0038
                r1.clear()
                return
            L_0x0038:
                java.lang.Object r2 = r1.poll()
                java.lang.Runnable r2 = (java.lang.Runnable) r2
                if (r2 == 0) goto L_0x004b
                r2.run()
                boolean r2 = r3.f47657e
                if (r2 == 0) goto L_0x0038
                r1.clear()
                return
            L_0x004b:
                boolean r2 = r3.f47657e
                if (r2 == 0) goto L_0x0053
                r1.clear()
                return
            L_0x0053:
                java.util.concurrent.atomic.AtomicInteger r2 = r3.f47658f
                int r0 = -r0
                int r0 = r2.addAndGet(r0)
                if (r0 != 0) goto L_0x0030
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.e.h.d.c.run():void");
        }

        static final class a extends AtomicBoolean implements io.reactivex.rxjava3.b.c, Runnable {
            private static final long serialVersionUID = -2421395018820541164L;
            final Runnable actual;

            a(Runnable runnable) {
                this.actual = runnable;
            }

            public final void run() {
                if (!get()) {
                    try {
                        this.actual.run();
                        lazySet(true);
                    } catch (Throwable th) {
                        lazySet(true);
                        throw th;
                    }
                }
            }

            public final void dispose() {
                lazySet(true);
            }

            public final boolean isDisposed() {
                return get();
            }
        }

        /* renamed from: io.reactivex.rxjava3.e.h.d$c$c  reason: collision with other inner class name */
        final class C0825c implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            private final f f47661b;

            /* renamed from: c  reason: collision with root package name */
            private final Runnable f47662c;

            C0825c(f fVar, Runnable runnable) {
                this.f47661b = fVar;
                this.f47662c = runnable;
            }

            public final void run() {
                this.f47661b.replace(c.this.a(this.f47662c));
            }
        }

        static final class b extends AtomicInteger implements io.reactivex.rxjava3.b.c, Runnable {
            static final int FINISHED = 2;
            static final int INTERRUPTED = 4;
            static final int INTERRUPTING = 3;
            static final int READY = 0;
            static final int RUNNING = 1;
            private static final long serialVersionUID = -3603436687413320876L;
            final Runnable run;
            final io.reactivex.rxjava3.b.d tasks;
            volatile Thread thread;

            b(Runnable runnable, io.reactivex.rxjava3.b.d dVar) {
                this.run = runnable;
                this.tasks = dVar;
            }

            public final void run() {
                if (get() == 0) {
                    this.thread = Thread.currentThread();
                    if (compareAndSet(0, 1)) {
                        try {
                            this.run.run();
                            this.thread = null;
                            if (compareAndSet(1, 2)) {
                                cleanup();
                                return;
                            }
                            while (get() == 3) {
                                Thread.yield();
                            }
                            Thread.interrupted();
                        } catch (Throwable th) {
                            this.thread = null;
                            if (!compareAndSet(1, 2)) {
                                while (get() == 3) {
                                    Thread.yield();
                                }
                                Thread.interrupted();
                            } else {
                                cleanup();
                            }
                            throw th;
                        }
                    } else {
                        this.thread = null;
                    }
                }
            }

            public final void dispose() {
                while (true) {
                    int i2 = get();
                    if (i2 >= 2) {
                        return;
                    }
                    if (i2 == 0) {
                        if (compareAndSet(0, 4)) {
                            cleanup();
                            return;
                        }
                    } else if (compareAndSet(1, 3)) {
                        Thread thread2 = this.thread;
                        if (thread2 != null) {
                            thread2.interrupt();
                            this.thread = null;
                        }
                        set(4);
                        cleanup();
                        return;
                    }
                }
            }

            /* access modifiers changed from: package-private */
            public final void cleanup() {
                io.reactivex.rxjava3.b.d dVar = this.tasks;
                if (dVar != null) {
                    dVar.c(this);
                }
            }

            public final boolean isDisposed() {
                return get() >= 2;
            }
        }
    }

    static final class b extends AtomicReference<Runnable> implements io.reactivex.rxjava3.b.c, Runnable {
        private static final long serialVersionUID = -4101336210206799084L;
        final f direct = new f();
        final f timed = new f();

        b(Runnable runnable) {
            super(runnable);
        }

        public final void run() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                try {
                    runnable.run();
                    lazySet((Object) null);
                    this.timed.lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
                    this.direct.lazySet(io.reactivex.rxjava3.e.a.c.DISPOSED);
                } catch (Throwable th) {
                    io.reactivex.rxjava3.h.a.a(th);
                    throw th;
                }
            }
        }

        public final boolean isDisposed() {
            return get() == null;
        }

        public final void dispose() {
            if (getAndSet((Object) null) != null) {
                this.timed.dispose();
                this.direct.dispose();
            }
        }

        public final Runnable getWrappedRunnable() {
            Runnable runnable = (Runnable) get();
            if (runnable != null) {
                return runnable;
            }
            return io.reactivex.rxjava3.e.b.a.f46646b;
        }
    }

    final class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final b f47652b;

        a(b bVar) {
            this.f47652b = bVar;
        }

        public final void run() {
            this.f47652b.direct.replace(d.this.a(this.f47652b));
        }
    }
}
