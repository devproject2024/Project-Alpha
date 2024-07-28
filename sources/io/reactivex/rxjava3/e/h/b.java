package io.reactivex.rxjava3.e.h;

import io.reactivex.rxjava3.a.x;
import io.reactivex.rxjava3.e.a.d;
import io.reactivex.rxjava3.e.a.e;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class b extends x {

    /* renamed from: b  reason: collision with root package name */
    static final C0824b f47632b;

    /* renamed from: c  reason: collision with root package name */
    static final j f47633c = new j("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx3.computation-priority", 5).intValue())), true);

    /* renamed from: d  reason: collision with root package name */
    static final int f47634d;

    /* renamed from: e  reason: collision with root package name */
    static final c f47635e;

    /* renamed from: f  reason: collision with root package name */
    final ThreadFactory f47636f;

    /* renamed from: g  reason: collision with root package name */
    final AtomicReference<C0824b> f47637g;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        int intValue = Integer.getInteger("rx3.computation-threads", 0).intValue();
        if (intValue > 0 && intValue <= availableProcessors) {
            availableProcessors = intValue;
        }
        f47634d = availableProcessors;
        c cVar = new c(new j("RxComputationShutdown"));
        f47635e = cVar;
        cVar.dispose();
        C0824b bVar = new C0824b(0, f47633c);
        f47632b = bVar;
        bVar.b();
    }

    /* renamed from: io.reactivex.rxjava3.e.h.b$b  reason: collision with other inner class name */
    static final class C0824b {

        /* renamed from: a  reason: collision with root package name */
        final int f47643a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f47644b;

        /* renamed from: c  reason: collision with root package name */
        long f47645c;

        C0824b(int i2, ThreadFactory threadFactory) {
            this.f47643a = i2;
            this.f47644b = new c[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f47644b[i3] = new c(threadFactory);
            }
        }

        public final c a() {
            int i2 = this.f47643a;
            if (i2 == 0) {
                return b.f47635e;
            }
            c[] cVarArr = this.f47644b;
            long j = this.f47645c;
            this.f47645c = 1 + j;
            return cVarArr[(int) (j % ((long) i2))];
        }

        public final void b() {
            for (c dispose : this.f47644b) {
                dispose.dispose();
            }
        }
    }

    public b() {
        this(f47633c);
    }

    private b(ThreadFactory threadFactory) {
        this.f47636f = threadFactory;
        this.f47637g = new AtomicReference<>(f47632b);
        b();
    }

    public final x.c a() {
        return new a(this.f47637g.get().a());
    }

    public final io.reactivex.rxjava3.b.c a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.f47637g.get().a().b(runnable, j, timeUnit);
    }

    public final io.reactivex.rxjava3.b.c a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.f47637g.get().a().b(runnable, j, j2, timeUnit);
    }

    public final void b() {
        C0824b bVar = new C0824b(f47634d, this.f47636f);
        if (!this.f47637g.compareAndSet(f47632b, bVar)) {
            bVar.b();
        }
    }

    static final class a extends x.c {

        /* renamed from: a  reason: collision with root package name */
        volatile boolean f47638a;

        /* renamed from: b  reason: collision with root package name */
        private final e f47639b = new e();

        /* renamed from: c  reason: collision with root package name */
        private final io.reactivex.rxjava3.b.b f47640c = new io.reactivex.rxjava3.b.b();

        /* renamed from: d  reason: collision with root package name */
        private final e f47641d = new e();

        /* renamed from: e  reason: collision with root package name */
        private final c f47642e;

        a(c cVar) {
            this.f47642e = cVar;
            this.f47641d.a(this.f47639b);
            this.f47641d.a(this.f47640c);
        }

        public final void dispose() {
            if (!this.f47638a) {
                this.f47638a = true;
                this.f47641d.dispose();
            }
        }

        public final boolean isDisposed() {
            return this.f47638a;
        }

        public final io.reactivex.rxjava3.b.c a(Runnable runnable) {
            if (this.f47638a) {
                return d.INSTANCE;
            }
            return this.f47642e.a(runnable, 0, TimeUnit.MILLISECONDS, this.f47639b);
        }

        public final io.reactivex.rxjava3.b.c a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (this.f47638a) {
                return d.INSTANCE;
            }
            return this.f47642e.a(runnable, j, timeUnit, this.f47640c);
        }
    }

    static final class c extends h {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }
}
