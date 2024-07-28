package io.reactivex.rxjava3.e.h;

import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.b.c;
import io.reactivex.rxjava3.e.a.d;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class p extends x {

    /* renamed from: b  reason: collision with root package name */
    private static final p f47703b = new p();

    public static p c() {
        return f47703b;
    }

    public final x.c a() {
        return new c();
    }

    p() {
    }

    public final io.reactivex.rxjava3.b.c a(Runnable runnable) {
        io.reactivex.rxjava3.h.a.a(runnable).run();
        return d.INSTANCE;
    }

    public final io.reactivex.rxjava3.b.c a(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(j);
            io.reactivex.rxjava3.h.a.a(runnable).run();
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            io.reactivex.rxjava3.h.a.a((Throwable) e2);
        }
        return d.INSTANCE;
    }

    static final class c extends x.c implements io.reactivex.rxjava3.b.c {

        /* renamed from: a  reason: collision with root package name */
        final PriorityBlockingQueue<b> f47711a = new PriorityBlockingQueue<>();

        /* renamed from: b  reason: collision with root package name */
        final AtomicInteger f47712b = new AtomicInteger();

        /* renamed from: c  reason: collision with root package name */
        volatile boolean f47713c;

        /* renamed from: d  reason: collision with root package name */
        private final AtomicInteger f47714d = new AtomicInteger();

        c() {
        }

        public final io.reactivex.rxjava3.b.c a(Runnable runnable) {
            return a(runnable, a(TimeUnit.MILLISECONDS));
        }

        public final io.reactivex.rxjava3.b.c a(Runnable runnable, long j, TimeUnit timeUnit) {
            long a2 = a(TimeUnit.MILLISECONDS) + timeUnit.toMillis(j);
            return a(new a(runnable, this, a2), a2);
        }

        private io.reactivex.rxjava3.b.c a(Runnable runnable, long j) {
            if (this.f47713c) {
                return d.INSTANCE;
            }
            b bVar = new b(runnable, Long.valueOf(j), this.f47712b.incrementAndGet());
            this.f47711a.add(bVar);
            if (this.f47714d.getAndIncrement() != 0) {
                return c.CC.b(new a(bVar));
            }
            int i2 = 1;
            while (!this.f47713c) {
                b poll = this.f47711a.poll();
                if (poll == null) {
                    i2 = this.f47714d.addAndGet(-i2);
                    if (i2 == 0) {
                        return d.INSTANCE;
                    }
                } else if (!poll.f47710d) {
                    poll.f47707a.run();
                }
            }
            this.f47711a.clear();
            return d.INSTANCE;
        }

        public final void dispose() {
            this.f47713c = true;
        }

        public final boolean isDisposed() {
            return this.f47713c;
        }

        final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final b f47715a;

            a(b bVar) {
                this.f47715a = bVar;
            }

            public final void run() {
                this.f47715a.f47710d = true;
                c.this.f47711a.remove(this.f47715a);
            }
        }
    }

    static final class b implements Comparable<b> {

        /* renamed from: a  reason: collision with root package name */
        final Runnable f47707a;

        /* renamed from: b  reason: collision with root package name */
        final long f47708b;

        /* renamed from: c  reason: collision with root package name */
        final int f47709c;

        /* renamed from: d  reason: collision with root package name */
        volatile boolean f47710d;

        public final /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            int compare = Long.compare(this.f47708b, bVar.f47708b);
            return compare == 0 ? Integer.compare(this.f47709c, bVar.f47709c) : compare;
        }

        b(Runnable runnable, Long l, int i2) {
            this.f47707a = runnable;
            this.f47708b = l.longValue();
            this.f47709c = i2;
        }
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final Runnable f47704a;

        /* renamed from: b  reason: collision with root package name */
        private final c f47705b;

        /* renamed from: c  reason: collision with root package name */
        private final long f47706c;

        a(Runnable runnable, c cVar, long j) {
            this.f47704a = runnable;
            this.f47705b = cVar;
            this.f47706c = j;
        }

        public final void run() {
            if (!this.f47705b.f47713c) {
                long a2 = c.a(TimeUnit.MILLISECONDS);
                long j = this.f47706c;
                if (j > a2) {
                    try {
                        Thread.sleep(j - a2);
                    } catch (InterruptedException e2) {
                        Thread.currentThread().interrupt();
                        io.reactivex.rxjava3.h.a.a((Throwable) e2);
                        return;
                    }
                }
                if (!this.f47705b.f47713c) {
                    this.f47704a.run();
                }
            }
        }
    }
}
