package androidx.lifecycle;

import androidx.arch.core.a.a;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class d<T> {

    /* renamed from: a  reason: collision with root package name */
    final Executor f3656a;

    /* renamed from: b  reason: collision with root package name */
    public final LiveData<T> f3657b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicBoolean f3658c = new AtomicBoolean(true);

    /* renamed from: d  reason: collision with root package name */
    final AtomicBoolean f3659d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    final Runnable f3660e = new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r5 = this;
            L_0x0000:
                androidx.lifecycle.d r0 = androidx.lifecycle.d.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f3659d
                r1 = 1
                r2 = 0
                boolean r0 = r0.compareAndSet(r2, r1)
                if (r0 == 0) goto L_0x003b
                r0 = 0
                r3 = r0
                r0 = 0
            L_0x000f:
                androidx.lifecycle.d r4 = androidx.lifecycle.d.this     // Catch:{ all -> 0x0032 }
                java.util.concurrent.atomic.AtomicBoolean r4 = r4.f3658c     // Catch:{ all -> 0x0032 }
                boolean r4 = r4.compareAndSet(r1, r2)     // Catch:{ all -> 0x0032 }
                if (r4 == 0) goto L_0x0021
                androidx.lifecycle.d r0 = androidx.lifecycle.d.this     // Catch:{ all -> 0x0032 }
                java.lang.Object r3 = r0.b()     // Catch:{ all -> 0x0032 }
                r0 = 1
                goto L_0x000f
            L_0x0021:
                if (r0 == 0) goto L_0x002a
                androidx.lifecycle.d r1 = androidx.lifecycle.d.this     // Catch:{ all -> 0x0032 }
                androidx.lifecycle.LiveData<T> r1 = r1.f3657b     // Catch:{ all -> 0x0032 }
                r1.postValue(r3)     // Catch:{ all -> 0x0032 }
            L_0x002a:
                androidx.lifecycle.d r1 = androidx.lifecycle.d.this
                java.util.concurrent.atomic.AtomicBoolean r1 = r1.f3659d
                r1.set(r2)
                goto L_0x003c
            L_0x0032:
                r0 = move-exception
                androidx.lifecycle.d r1 = androidx.lifecycle.d.this
                java.util.concurrent.atomic.AtomicBoolean r1 = r1.f3659d
                r1.set(r2)
                throw r0
            L_0x003b:
                r0 = 0
            L_0x003c:
                if (r0 == 0) goto L_0x0048
                androidx.lifecycle.d r0 = androidx.lifecycle.d.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f3658c
                boolean r0 = r0.get()
                if (r0 != 0) goto L_0x0000
            L_0x0048:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.d.AnonymousClass2.run():void");
        }
    };

    /* renamed from: f  reason: collision with root package name */
    final Runnable f3661f = new Runnable() {
        public final void run() {
            boolean hasActiveObservers = d.this.f3657b.hasActiveObservers();
            if (d.this.f3658c.compareAndSet(false, true) && hasActiveObservers) {
                d.this.f3656a.execute(d.this.f3660e);
            }
        }
    };

    /* access modifiers changed from: protected */
    public abstract T b();

    public d(Executor executor) {
        this.f3656a = executor;
        this.f3657b = new LiveData<T>() {
            /* access modifiers changed from: protected */
            public final void onActive() {
                d.this.f3656a.execute(d.this.f3660e);
            }
        };
    }

    public final void a() {
        a.a().c(this.f3661f);
    }
}
