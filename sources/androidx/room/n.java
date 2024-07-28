package androidx.room;

import androidx.arch.core.a.a;
import androidx.lifecycle.LiveData;
import androidx.room.g;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

final class n<T> extends LiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    final j f4480a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f4481b;

    /* renamed from: c  reason: collision with root package name */
    final Callable<T> f4482c;

    /* renamed from: d  reason: collision with root package name */
    final g.b f4483d;

    /* renamed from: e  reason: collision with root package name */
    final AtomicBoolean f4484e = new AtomicBoolean(true);

    /* renamed from: f  reason: collision with root package name */
    final AtomicBoolean f4485f = new AtomicBoolean(false);

    /* renamed from: g  reason: collision with root package name */
    final AtomicBoolean f4486g = new AtomicBoolean(false);

    /* renamed from: h  reason: collision with root package name */
    final Runnable f4487h = new Runnable() {
        /* JADX WARNING: Removed duplicated region for block: B:22:0x005d  */
        /* JADX WARNING: Removed duplicated region for block: B:5:0x0025  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r5 = this;
                androidx.room.n r0 = androidx.room.n.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f4486g
                r1 = 1
                r2 = 0
                boolean r0 = r0.compareAndSet(r2, r1)
                if (r0 == 0) goto L_0x001b
                androidx.room.n r0 = androidx.room.n.this
                androidx.room.j r0 = r0.f4480a
                androidx.room.g r0 = r0.getInvalidationTracker()
                androidx.room.n r3 = androidx.room.n.this
                androidx.room.g$b r3 = r3.f4483d
                r0.b(r3)
            L_0x001b:
                androidx.room.n r0 = androidx.room.n.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f4485f
                boolean r0 = r0.compareAndSet(r2, r1)
                if (r0 == 0) goto L_0x005d
                r0 = 0
                r3 = r0
                r0 = 0
            L_0x0028:
                androidx.room.n r4 = androidx.room.n.this     // Catch:{ all -> 0x0054 }
                java.util.concurrent.atomic.AtomicBoolean r4 = r4.f4484e     // Catch:{ all -> 0x0054 }
                boolean r4 = r4.compareAndSet(r1, r2)     // Catch:{ all -> 0x0054 }
                if (r4 == 0) goto L_0x0045
                androidx.room.n r0 = androidx.room.n.this     // Catch:{ Exception -> 0x003c }
                java.util.concurrent.Callable<T> r0 = r0.f4482c     // Catch:{ Exception -> 0x003c }
                java.lang.Object r3 = r0.call()     // Catch:{ Exception -> 0x003c }
                r0 = 1
                goto L_0x0028
            L_0x003c:
                r0 = move-exception
                java.lang.RuntimeException r1 = new java.lang.RuntimeException     // Catch:{ all -> 0x0054 }
                java.lang.String r3 = "Exception while computing database live data."
                r1.<init>(r3, r0)     // Catch:{ all -> 0x0054 }
                throw r1     // Catch:{ all -> 0x0054 }
            L_0x0045:
                if (r0 == 0) goto L_0x004c
                androidx.room.n r4 = androidx.room.n.this     // Catch:{ all -> 0x0054 }
                r4.postValue(r3)     // Catch:{ all -> 0x0054 }
            L_0x004c:
                androidx.room.n r3 = androidx.room.n.this
                java.util.concurrent.atomic.AtomicBoolean r3 = r3.f4485f
                r3.set(r2)
                goto L_0x005e
            L_0x0054:
                r0 = move-exception
                androidx.room.n r1 = androidx.room.n.this
                java.util.concurrent.atomic.AtomicBoolean r1 = r1.f4485f
                r1.set(r2)
                throw r0
            L_0x005d:
                r0 = 0
            L_0x005e:
                if (r0 == 0) goto L_0x006a
                androidx.room.n r0 = androidx.room.n.this
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.f4484e
                boolean r0 = r0.get()
                if (r0 != 0) goto L_0x001b
            L_0x006a:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.n.AnonymousClass1.run():void");
        }
    };

    /* renamed from: i  reason: collision with root package name */
    final Runnable f4488i = new Runnable() {
        public final void run() {
            boolean hasActiveObservers = n.this.hasActiveObservers();
            if (n.this.f4484e.compareAndSet(false, true) && hasActiveObservers) {
                n.this.a().execute(n.this.f4487h);
            }
        }
    };
    private final f j;

    n(j jVar, f fVar, boolean z, Callable<T> callable, String[] strArr) {
        this.f4480a = jVar;
        this.f4481b = z;
        this.f4482c = callable;
        this.j = fVar;
        this.f4483d = new g.b(strArr) {
            public final void a(Set<String> set) {
                a.a().c(n.this.f4488i);
            }
        };
    }

    public final void onActive() {
        super.onActive();
        this.j.f4415a.add(this);
        a().execute(this.f4487h);
    }

    public final void onInactive() {
        super.onInactive();
        this.j.f4415a.remove(this);
    }

    /* access modifiers changed from: package-private */
    public final Executor a() {
        if (this.f4481b) {
            return this.f4480a.getTransactionExecutor();
        }
        return this.f4480a.getQueryExecutor();
    }
}
