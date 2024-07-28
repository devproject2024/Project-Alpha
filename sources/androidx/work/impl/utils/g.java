package androidx.work.impl.utils;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public final class g implements Executor {

    /* renamed from: a  reason: collision with root package name */
    private final ArrayDeque<a> f5450a = new ArrayDeque<>();

    /* renamed from: b  reason: collision with root package name */
    private final Executor f5451b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f5452c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private volatile Runnable f5453d;

    public g(Executor executor) {
        this.f5451b = executor;
    }

    public final void execute(Runnable runnable) {
        synchronized (this.f5452c) {
            this.f5450a.add(new a(this, runnable));
            if (this.f5453d == null) {
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        synchronized (this.f5452c) {
            Runnable poll = this.f5450a.poll();
            this.f5453d = poll;
            if (poll != null) {
                this.f5451b.execute(this.f5453d);
            }
        }
    }

    public final boolean b() {
        boolean z;
        synchronized (this.f5452c) {
            z = !this.f5450a.isEmpty();
        }
        return z;
    }

    static class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final g f5454a;

        /* renamed from: b  reason: collision with root package name */
        final Runnable f5455b;

        a(g gVar, Runnable runnable) {
            this.f5454a = gVar;
            this.f5455b = runnable;
        }

        public final void run() {
            try {
                this.f5455b.run();
            } finally {
                this.f5454a.a();
            }
        }
    }
}
