package com.bumptech.glide.load.b;

import androidx.core.g.e;
import com.bumptech.glide.e.i;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.g.j;
import com.bumptech.glide.load.b.h;
import com.bumptech.glide.load.b.p;
import com.bumptech.glide.load.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

public final class l<R> implements a.c, h.a<R> {

    /* renamed from: f  reason: collision with root package name */
    private static final c f6906f = new c();

    /* renamed from: a  reason: collision with root package name */
    final e f6907a;

    /* renamed from: b  reason: collision with root package name */
    boolean f6908b;

    /* renamed from: c  reason: collision with root package name */
    com.bumptech.glide.load.a f6909c;

    /* renamed from: d  reason: collision with root package name */
    q f6910d;

    /* renamed from: e  reason: collision with root package name */
    p<?> f6911e;

    /* renamed from: g  reason: collision with root package name */
    private final com.bumptech.glide.g.a.b f6912g;

    /* renamed from: h  reason: collision with root package name */
    private final p.a f6913h;

    /* renamed from: i  reason: collision with root package name */
    private final e.a<l<?>> f6914i;
    private final c j;
    private final m k;
    private final com.bumptech.glide.load.b.c.a l;
    private final com.bumptech.glide.load.b.c.a m;
    private final com.bumptech.glide.load.b.c.a n;
    private final com.bumptech.glide.load.b.c.a o;
    private final AtomicInteger p;
    private g q;
    private boolean r;
    private boolean s;
    private boolean t;
    private v<?> u;
    private boolean v;
    private boolean w;
    private h<R> x;
    private volatile boolean y;

    l(com.bumptech.glide.load.b.c.a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, m mVar, p.a aVar5, e.a<l<?>> aVar6) {
        this(aVar, aVar2, aVar3, aVar4, mVar, aVar5, aVar6, f6906f);
    }

    private l(com.bumptech.glide.load.b.c.a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, m mVar, p.a aVar5, e.a<l<?>> aVar6, c cVar) {
        this.f6907a = new e();
        this.f6912g = new b.a();
        this.p = new AtomicInteger();
        this.l = aVar;
        this.m = aVar2;
        this.n = aVar3;
        this.o = aVar4;
        this.k = mVar;
        this.f6913h = aVar5;
        this.f6914i = aVar6;
        this.j = cVar;
    }

    /* access modifiers changed from: package-private */
    public final synchronized l<R> a(g gVar, boolean z, boolean z2, boolean z3, boolean z4) {
        this.q = gVar;
        this.r = z;
        this.s = z2;
        this.t = z3;
        this.f6908b = z4;
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(com.bumptech.glide.load.b.h<R> r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            r2.x = r3     // Catch:{ all -> 0x0023 }
            com.bumptech.glide.load.b.h$g r0 = com.bumptech.glide.load.b.h.g.INITIALIZE     // Catch:{ all -> 0x0023 }
            com.bumptech.glide.load.b.h$g r0 = r3.a(r0)     // Catch:{ all -> 0x0023 }
            com.bumptech.glide.load.b.h$g r1 = com.bumptech.glide.load.b.h.g.RESOURCE_CACHE     // Catch:{ all -> 0x0023 }
            if (r0 == r1) goto L_0x0014
            com.bumptech.glide.load.b.h$g r1 = com.bumptech.glide.load.b.h.g.DATA_CACHE     // Catch:{ all -> 0x0023 }
            if (r0 != r1) goto L_0x0012
            goto L_0x0014
        L_0x0012:
            r0 = 0
            goto L_0x0015
        L_0x0014:
            r0 = 1
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            com.bumptech.glide.load.b.c.a r0 = r2.l     // Catch:{ all -> 0x0023 }
            goto L_0x001e
        L_0x001a:
            com.bumptech.glide.load.b.c.a r0 = r2.c()     // Catch:{ all -> 0x0023 }
        L_0x001e:
            r0.execute(r3)     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            return
        L_0x0023:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.l.b(com.bumptech.glide.load.b.h):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized void a(i iVar, Executor executor) {
        this.f6912g.a();
        this.f6907a.f6921a.add(new d(iVar, executor));
        boolean z = true;
        if (this.v) {
            a(1);
            executor.execute(new b(iVar));
        } else if (this.w) {
            a(1);
            executor.execute(new a(iVar));
        } else {
            if (this.y) {
                z = false;
            }
            j.a(z, "Cannot add callbacks to a cancelled EngineJob");
        }
    }

    public final synchronized void a(i iVar) {
        this.f6912g.a();
        this.f6907a.f6921a.remove(e.b(iVar));
        if (this.f6907a.a()) {
            boolean z = true;
            if (!d()) {
                this.y = true;
                h<R> hVar = this.x;
                hVar.t = true;
                f fVar = hVar.s;
                if (fVar != null) {
                    fVar.b();
                }
                this.k.a(this, this.q);
            }
            if (!this.v) {
                if (!this.w) {
                    z = false;
                }
            }
            if (z && this.p.get() == 0) {
                e();
            }
        }
    }

    private com.bumptech.glide.load.b.c.a c() {
        if (this.s) {
            return this.n;
        }
        return this.t ? this.o : this.m;
    }

    private boolean d() {
        return this.w || this.v || this.y;
    }

    private synchronized void a(int i2) {
        j.a(d(), "Not yet complete!");
        if (this.p.getAndAdd(i2) == 0 && this.f6911e != null) {
            this.f6911e.e();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        p<?> pVar;
        synchronized (this) {
            this.f6912g.a();
            j.a(d(), "Not yet complete!");
            int decrementAndGet = this.p.decrementAndGet();
            j.a(decrementAndGet >= 0, "Can't decrement below 0");
            if (decrementAndGet == 0) {
                pVar = this.f6911e;
                e();
            } else {
                pVar = null;
            }
        }
        if (pVar != null) {
            pVar.f();
        }
    }

    private synchronized void e() {
        if (this.q != null) {
            this.f6907a.f6921a.clear();
            this.q = null;
            this.f6911e = null;
            this.u = null;
            this.w = false;
            this.y = false;
            this.v = false;
            h<R> hVar = this.x;
            if (hVar.f6853d.a()) {
                hVar.a();
            }
            this.x = null;
            this.f6910d = null;
            this.f6909c = null;
            this.f6914i.a(this);
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004d, code lost:
        r6.k.a(r6, r7, r0);
        r7 = r8.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005a, code lost:
        if (r7.hasNext() == false) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        r8 = r7.next();
        r8.f6920b.execute(new com.bumptech.glide.load.b.l.b(r6, r8.f6919a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0072, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.bumptech.glide.load.b.v<R> r7, com.bumptech.glide.load.a r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.u = r7     // Catch:{ all -> 0x0086 }
            r6.f6909c = r8     // Catch:{ all -> 0x0086 }
            monitor-exit(r6)     // Catch:{ all -> 0x0086 }
            monitor-enter(r6)
            com.bumptech.glide.g.a.b r7 = r6.f6912g     // Catch:{ all -> 0x0083 }
            r7.a()     // Catch:{ all -> 0x0083 }
            boolean r7 = r6.y     // Catch:{ all -> 0x0083 }
            if (r7 == 0) goto L_0x001a
            com.bumptech.glide.load.b.v<?> r7 = r6.u     // Catch:{ all -> 0x0083 }
            r7.d()     // Catch:{ all -> 0x0083 }
            r6.e()     // Catch:{ all -> 0x0083 }
            monitor-exit(r6)     // Catch:{ all -> 0x0083 }
            return
        L_0x001a:
            com.bumptech.glide.load.b.l$e r7 = r6.f6907a     // Catch:{ all -> 0x0083 }
            boolean r7 = r7.a()     // Catch:{ all -> 0x0083 }
            if (r7 != 0) goto L_0x007b
            boolean r7 = r6.v     // Catch:{ all -> 0x0083 }
            if (r7 != 0) goto L_0x0073
            com.bumptech.glide.load.b.v<?> r1 = r6.u     // Catch:{ all -> 0x0083 }
            boolean r2 = r6.r     // Catch:{ all -> 0x0083 }
            com.bumptech.glide.load.g r4 = r6.q     // Catch:{ all -> 0x0083 }
            com.bumptech.glide.load.b.p$a r5 = r6.f6913h     // Catch:{ all -> 0x0083 }
            com.bumptech.glide.load.b.p r7 = new com.bumptech.glide.load.b.p     // Catch:{ all -> 0x0083 }
            r3 = 1
            r0 = r7
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0083 }
            r6.f6911e = r7     // Catch:{ all -> 0x0083 }
            r7 = 1
            r6.v = r7     // Catch:{ all -> 0x0083 }
            com.bumptech.glide.load.b.l$e r8 = r6.f6907a     // Catch:{ all -> 0x0083 }
            com.bumptech.glide.load.b.l$e r8 = r8.c()     // Catch:{ all -> 0x0083 }
            int r0 = r8.b()     // Catch:{ all -> 0x0083 }
            int r0 = r0 + r7
            r6.a((int) r0)     // Catch:{ all -> 0x0083 }
            com.bumptech.glide.load.g r7 = r6.q     // Catch:{ all -> 0x0083 }
            com.bumptech.glide.load.b.p<?> r0 = r6.f6911e     // Catch:{ all -> 0x0083 }
            monitor-exit(r6)     // Catch:{ all -> 0x0083 }
            com.bumptech.glide.load.b.m r1 = r6.k
            r1.a(r6, r7, r0)
            java.util.Iterator r7 = r8.iterator()
        L_0x0056:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x006f
            java.lang.Object r8 = r7.next()
            com.bumptech.glide.load.b.l$d r8 = (com.bumptech.glide.load.b.l.d) r8
            java.util.concurrent.Executor r0 = r8.f6920b
            com.bumptech.glide.load.b.l$b r1 = new com.bumptech.glide.load.b.l$b
            com.bumptech.glide.e.i r8 = r8.f6919a
            r1.<init>(r8)
            r0.execute(r1)
            goto L_0x0056
        L_0x006f:
            r6.a()
            return
        L_0x0073:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0083 }
            java.lang.String r8 = "Already have resource"
            r7.<init>(r8)     // Catch:{ all -> 0x0083 }
            throw r7     // Catch:{ all -> 0x0083 }
        L_0x007b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0083 }
            java.lang.String r8 = "Received a resource without any callbacks to notify"
            r7.<init>(r8)     // Catch:{ all -> 0x0083 }
            throw r7     // Catch:{ all -> 0x0083 }
        L_0x0083:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0083 }
            throw r7
        L_0x0086:
            r7 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0086 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.l.a(com.bumptech.glide.load.b.v, com.bumptech.glide.load.a):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0033, code lost:
        r3.k.a(r3, r0, (com.bumptech.glide.load.b.p<?>) null);
        r4 = r1.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0041, code lost:
        if (r4.hasNext() == false) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0043, code lost:
        r0 = r4.next();
        r0.f6920b.execute(new com.bumptech.glide.load.b.l.a(r3, r0.f6919a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.bumptech.glide.load.b.q r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.f6910d = r4     // Catch:{ all -> 0x006d }
            monitor-exit(r3)     // Catch:{ all -> 0x006d }
            monitor-enter(r3)
            com.bumptech.glide.g.a.b r4 = r3.f6912g     // Catch:{ all -> 0x006a }
            r4.a()     // Catch:{ all -> 0x006a }
            boolean r4 = r3.y     // Catch:{ all -> 0x006a }
            if (r4 == 0) goto L_0x0013
            r3.e()     // Catch:{ all -> 0x006a }
            monitor-exit(r3)     // Catch:{ all -> 0x006a }
            return
        L_0x0013:
            com.bumptech.glide.load.b.l$e r4 = r3.f6907a     // Catch:{ all -> 0x006a }
            boolean r4 = r4.a()     // Catch:{ all -> 0x006a }
            if (r4 != 0) goto L_0x0062
            boolean r4 = r3.w     // Catch:{ all -> 0x006a }
            if (r4 != 0) goto L_0x005a
            r4 = 1
            r3.w = r4     // Catch:{ all -> 0x006a }
            com.bumptech.glide.load.g r0 = r3.q     // Catch:{ all -> 0x006a }
            com.bumptech.glide.load.b.l$e r1 = r3.f6907a     // Catch:{ all -> 0x006a }
            com.bumptech.glide.load.b.l$e r1 = r1.c()     // Catch:{ all -> 0x006a }
            int r2 = r1.b()     // Catch:{ all -> 0x006a }
            int r2 = r2 + r4
            r3.a((int) r2)     // Catch:{ all -> 0x006a }
            monitor-exit(r3)     // Catch:{ all -> 0x006a }
            com.bumptech.glide.load.b.m r4 = r3.k
            r2 = 0
            r4.a(r3, r0, r2)
            java.util.Iterator r4 = r1.iterator()
        L_0x003d:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0056
            java.lang.Object r0 = r4.next()
            com.bumptech.glide.load.b.l$d r0 = (com.bumptech.glide.load.b.l.d) r0
            java.util.concurrent.Executor r1 = r0.f6920b
            com.bumptech.glide.load.b.l$a r2 = new com.bumptech.glide.load.b.l$a
            com.bumptech.glide.e.i r0 = r0.f6919a
            r2.<init>(r0)
            r1.execute(r2)
            goto L_0x003d
        L_0x0056:
            r3.a()
            return
        L_0x005a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006a }
            java.lang.String r0 = "Already failed once"
            r4.<init>(r0)     // Catch:{ all -> 0x006a }
            throw r4     // Catch:{ all -> 0x006a }
        L_0x0062:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x006a }
            java.lang.String r0 = "Received an exception without any callbacks to notify"
            r4.<init>(r0)     // Catch:{ all -> 0x006a }
            throw r4     // Catch:{ all -> 0x006a }
        L_0x006a:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x006a }
            throw r4
        L_0x006d:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x006d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.l.a(com.bumptech.glide.load.b.q):void");
    }

    public final void a(h<?> hVar) {
        c().execute(hVar);
    }

    public final com.bumptech.glide.g.a.b e_() {
        return this.f6912g;
    }

    class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final i f6916b;

        a(i iVar) {
            this.f6916b = iVar;
        }

        public final void run() {
            synchronized (this.f6916b.h()) {
                synchronized (l.this) {
                    if (l.this.f6907a.a(this.f6916b)) {
                        l lVar = l.this;
                        try {
                            this.f6916b.a(lVar.f6910d);
                        } catch (Throwable th) {
                            throw new b(th);
                        }
                    }
                    l.this.a();
                }
            }
        }
    }

    class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final i f6918b;

        b(i iVar) {
            this.f6918b = iVar;
        }

        public final void run() {
            synchronized (this.f6918b.h()) {
                synchronized (l.this) {
                    if (l.this.f6907a.a(this.f6918b)) {
                        l.this.f6911e.e();
                        l lVar = l.this;
                        try {
                            this.f6918b.a(lVar.f6911e, lVar.f6909c);
                            l.this.a(this.f6918b);
                        } catch (Throwable th) {
                            throw new b(th);
                        }
                    }
                    l.this.a();
                }
            }
        }
    }

    static final class e implements Iterable<d> {

        /* renamed from: a  reason: collision with root package name */
        final List<d> f6921a;

        e() {
            this(new ArrayList(2));
        }

        private e(List<d> list) {
            this.f6921a = list;
        }

        /* access modifiers changed from: package-private */
        public final boolean a(i iVar) {
            return this.f6921a.contains(b(iVar));
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return this.f6921a.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public final int b() {
            return this.f6921a.size();
        }

        /* access modifiers changed from: package-private */
        public final e c() {
            return new e(new ArrayList(this.f6921a));
        }

        static d b(i iVar) {
            return new d(iVar, com.bumptech.glide.g.e.b());
        }

        public final Iterator<d> iterator() {
            return this.f6921a.iterator();
        }
    }

    static final class d {

        /* renamed from: a  reason: collision with root package name */
        final i f6919a;

        /* renamed from: b  reason: collision with root package name */
        final Executor f6920b;

        d(i iVar, Executor executor) {
            this.f6919a = iVar;
            this.f6920b = executor;
        }

        public final boolean equals(Object obj) {
            if (obj instanceof d) {
                return this.f6919a.equals(((d) obj).f6919a);
            }
            return false;
        }

        public final int hashCode() {
            return this.f6919a.hashCode();
        }
    }

    static class c {
        c() {
        }
    }
}
