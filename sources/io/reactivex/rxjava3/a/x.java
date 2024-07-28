package io.reactivex.rxjava3.a;

import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.a.f;
import io.reactivex.rxjava3.e.h.h;
import java.util.concurrent.TimeUnit;

public abstract class x {

    /* renamed from: a  reason: collision with root package name */
    static final long f46613a;

    public abstract c a();

    public void b() {
    }

    static {
        long j;
        long longValue = Long.getLong("rx3.scheduler.drift-tolerance", 15).longValue();
        String property = System.getProperty("rx3.scheduler.drift-tolerance-unit", "minutes");
        if ("seconds".equalsIgnoreCase(property)) {
            j = TimeUnit.SECONDS.toNanos(longValue);
        } else if ("milliseconds".equalsIgnoreCase(property)) {
            j = TimeUnit.MILLISECONDS.toNanos(longValue);
        } else {
            j = TimeUnit.MINUTES.toNanos(longValue);
        }
        f46613a = j;
    }

    public static long a(TimeUnit timeUnit) {
        return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public io.reactivex.rxjava3.b.c a(Runnable runnable) {
        return a(runnable, 0, TimeUnit.NANOSECONDS);
    }

    public io.reactivex.rxjava3.b.c a(Runnable runnable, long j, TimeUnit timeUnit) {
        c a2 = a();
        a aVar = new a(io.reactivex.rxjava3.h.a.a(runnable), a2);
        a2.a(aVar, j, timeUnit);
        return aVar;
    }

    public io.reactivex.rxjava3.b.c a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        c a2 = a();
        b bVar = new b(io.reactivex.rxjava3.h.a.a(runnable), a2);
        io.reactivex.rxjava3.b.c a3 = a2.a(bVar, j, j2, timeUnit);
        return a3 == d.INSTANCE ? a3 : bVar;
    }

    public static abstract class c implements io.reactivex.rxjava3.b.c {
        public abstract io.reactivex.rxjava3.b.c a(Runnable runnable, long j, TimeUnit timeUnit);

        public io.reactivex.rxjava3.b.c a(Runnable runnable) {
            return a(runnable, 0, TimeUnit.NANOSECONDS);
        }

        public final io.reactivex.rxjava3.b.c a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            long j3 = j;
            TimeUnit timeUnit2 = timeUnit;
            f fVar = new f();
            f fVar2 = new f(fVar);
            Runnable a2 = io.reactivex.rxjava3.h.a.a(runnable);
            long nanos = timeUnit2.toNanos(j2);
            long a3 = a(TimeUnit.NANOSECONDS);
            io.reactivex.rxjava3.b.c a4 = a(new a(a3 + timeUnit2.toNanos(j3), a2, a3, fVar2, nanos), j3, timeUnit2);
            if (a4 == d.INSTANCE) {
                return a4;
            }
            fVar.replace(a4);
            return fVar2;
        }

        public static long a(TimeUnit timeUnit) {
            return timeUnit.convert(System.currentTimeMillis(), TimeUnit.MILLISECONDS);
        }

        final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final Runnable f46620a;

            /* renamed from: b  reason: collision with root package name */
            final f f46621b;

            /* renamed from: c  reason: collision with root package name */
            final long f46622c;

            /* renamed from: d  reason: collision with root package name */
            long f46623d;

            /* renamed from: e  reason: collision with root package name */
            long f46624e;

            /* renamed from: f  reason: collision with root package name */
            long f46625f;

            a(long j, Runnable runnable, long j2, f fVar, long j3) {
                this.f46620a = runnable;
                this.f46621b = fVar;
                this.f46622c = j3;
                this.f46624e = j2;
                this.f46625f = j;
            }

            public final void run() {
                long j;
                this.f46620a.run();
                if (!this.f46621b.isDisposed()) {
                    long a2 = c.a(TimeUnit.NANOSECONDS);
                    long j2 = this.f46624e;
                    if (x.f46613a + a2 < j2 || a2 >= j2 + this.f46622c + x.f46613a) {
                        long j3 = this.f46622c;
                        long j4 = a2 + j3;
                        long j5 = this.f46623d + 1;
                        this.f46623d = j5;
                        this.f46625f = j4 - (j3 * j5);
                        j = j4;
                    } else {
                        long j6 = this.f46625f;
                        long j7 = this.f46623d + 1;
                        this.f46623d = j7;
                        j = j6 + (j7 * this.f46622c);
                    }
                    this.f46624e = a2;
                    this.f46621b.replace(c.this.a(this, j - a2, TimeUnit.NANOSECONDS));
                }
            }
        }
    }

    static final class b implements io.reactivex.rxjava3.b.c, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f46617a;

        /* renamed from: b  reason: collision with root package name */
        final c f46618b;

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f46619c;

        b(Runnable runnable, c cVar) {
            this.f46617a = runnable;
            this.f46618b = cVar;
        }

        public final void run() {
            if (!this.f46619c) {
                try {
                    this.f46617a.run();
                } catch (Throwable th) {
                    dispose();
                    io.reactivex.rxjava3.h.a.a(th);
                    throw th;
                }
            }
        }

        public final void dispose() {
            this.f46619c = true;
            this.f46618b.dispose();
        }

        public final boolean isDisposed() {
            return this.f46619c;
        }
    }

    static final class a implements io.reactivex.rxjava3.b.c, Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f46614a;

        /* renamed from: b  reason: collision with root package name */
        final c f46615b;

        /* renamed from: c  reason: collision with root package name */
        Thread f46616c;

        a(Runnable runnable, c cVar) {
            this.f46614a = runnable;
            this.f46615b = cVar;
        }

        public final void run() {
            this.f46616c = Thread.currentThread();
            try {
                this.f46614a.run();
                dispose();
                this.f46616c = null;
            } catch (Throwable th) {
                dispose();
                this.f46616c = null;
                throw th;
            }
        }

        public final void dispose() {
            if (this.f46616c == Thread.currentThread()) {
                c cVar = this.f46615b;
                if (cVar instanceof h) {
                    h hVar = (h) cVar;
                    if (!hVar.f47691c) {
                        hVar.f47691c = true;
                        hVar.f47690b.shutdown();
                        return;
                    }
                    return;
                }
            }
            this.f46615b.dispose();
        }

        public final boolean isDisposed() {
            return this.f46615b.isDisposed();
        }
    }
}
