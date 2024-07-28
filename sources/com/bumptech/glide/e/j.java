package com.bumptech.glide.e;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.d;
import com.bumptech.glide.e.a.i;
import com.bumptech.glide.e.b.g;
import com.bumptech.glide.f;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.load.b.k;
import com.bumptech.glide.load.b.q;
import com.bumptech.glide.load.b.v;
import java.util.List;
import java.util.concurrent.Executor;

public final class j<R> implements i, d, i {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f6565a = Log.isLoggable("Request", 2);
    private int A;
    private int B;
    private boolean C;
    private RuntimeException D;

    /* renamed from: b  reason: collision with root package name */
    private final String f6566b;

    /* renamed from: c  reason: collision with root package name */
    private final b f6567c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f6568d;

    /* renamed from: e  reason: collision with root package name */
    private final g<R> f6569e;

    /* renamed from: f  reason: collision with root package name */
    private final e f6570f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f6571g;

    /* renamed from: h  reason: collision with root package name */
    private final d f6572h;

    /* renamed from: i  reason: collision with root package name */
    private final Object f6573i;
    private final Class<R> j;
    private final a<?> k;
    private final int l;
    private final int m;
    private final f n;
    private final com.bumptech.glide.e.a.j<R> o;
    private final List<g<R>> p;
    private final g<? super R> q;
    private final Executor r;
    private v<R> s;
    private k.d t;
    private long u;
    private volatile k v;
    private a w;
    private Drawable x;
    private Drawable y;
    private Drawable z;

    enum a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public static <R> j<R> a(Context context, d dVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i2, int i3, f fVar, com.bumptech.glide.e.a.j<R> jVar, g<R> gVar, List<g<R>> list, e eVar, k kVar, g<? super R> gVar2, Executor executor) {
        return new j(context, dVar, obj, obj2, cls, aVar, i2, i3, fVar, jVar, gVar, list, eVar, kVar, gVar2, executor);
    }

    private j(Context context, d dVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i2, int i3, f fVar, com.bumptech.glide.e.a.j<R> jVar, g<R> gVar, List<g<R>> list, e eVar, k kVar, g<? super R> gVar2, Executor executor) {
        d dVar2 = dVar;
        this.f6566b = f6565a ? String.valueOf(super.hashCode()) : null;
        this.f6567c = new b.a();
        this.f6568d = obj;
        this.f6571g = context;
        this.f6572h = dVar2;
        this.f6573i = obj2;
        this.j = cls;
        this.k = aVar;
        this.l = i2;
        this.m = i3;
        this.n = fVar;
        this.o = jVar;
        this.f6569e = gVar;
        this.p = list;
        this.f6570f = eVar;
        this.v = kVar;
        this.q = gVar2;
        this.r = executor;
        this.w = a.PENDING;
        if (this.D == null && dVar2.f6485g) {
            this.D = new RuntimeException("Glide request origin trace");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a3, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f6568d
            monitor-enter(r0)
            r4.i()     // Catch:{ all -> 0x00ac }
            com.bumptech.glide.g.a.b r1 = r4.f6567c     // Catch:{ all -> 0x00ac }
            r1.a()     // Catch:{ all -> 0x00ac }
            long r1 = com.bumptech.glide.g.f.a()     // Catch:{ all -> 0x00ac }
            r4.u = r1     // Catch:{ all -> 0x00ac }
            java.lang.Object r1 = r4.f6573i     // Catch:{ all -> 0x00ac }
            if (r1 != 0) goto L_0x003c
            int r1 = r4.l     // Catch:{ all -> 0x00ac }
            int r2 = r4.m     // Catch:{ all -> 0x00ac }
            boolean r1 = com.bumptech.glide.g.k.a((int) r1, (int) r2)     // Catch:{ all -> 0x00ac }
            if (r1 == 0) goto L_0x0027
            int r1 = r4.l     // Catch:{ all -> 0x00ac }
            r4.A = r1     // Catch:{ all -> 0x00ac }
            int r1 = r4.m     // Catch:{ all -> 0x00ac }
            r4.B = r1     // Catch:{ all -> 0x00ac }
        L_0x0027:
            android.graphics.drawable.Drawable r1 = r4.k()     // Catch:{ all -> 0x00ac }
            if (r1 != 0) goto L_0x002f
            r1 = 5
            goto L_0x0030
        L_0x002f:
            r1 = 3
        L_0x0030:
            com.bumptech.glide.load.b.q r2 = new com.bumptech.glide.load.b.q     // Catch:{ all -> 0x00ac }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x00ac }
            r4.a((com.bumptech.glide.load.b.q) r2, (int) r1)     // Catch:{ all -> 0x00ac }
            monitor-exit(r0)     // Catch:{ all -> 0x00ac }
            return
        L_0x003c:
            com.bumptech.glide.e.j$a r1 = r4.w     // Catch:{ all -> 0x00ac }
            com.bumptech.glide.e.j$a r2 = com.bumptech.glide.e.j.a.RUNNING     // Catch:{ all -> 0x00ac }
            if (r1 == r2) goto L_0x00a4
            com.bumptech.glide.e.j$a r1 = r4.w     // Catch:{ all -> 0x00ac }
            com.bumptech.glide.e.j$a r2 = com.bumptech.glide.e.j.a.COMPLETE     // Catch:{ all -> 0x00ac }
            if (r1 != r2) goto L_0x0051
            com.bumptech.glide.load.b.v<R> r1 = r4.s     // Catch:{ all -> 0x00ac }
            com.bumptech.glide.load.a r2 = com.bumptech.glide.load.a.MEMORY_CACHE     // Catch:{ all -> 0x00ac }
            r4.a((com.bumptech.glide.load.b.v<?>) r1, (com.bumptech.glide.load.a) r2)     // Catch:{ all -> 0x00ac }
            monitor-exit(r0)     // Catch:{ all -> 0x00ac }
            return
        L_0x0051:
            com.bumptech.glide.e.j$a r1 = com.bumptech.glide.e.j.a.WAITING_FOR_SIZE     // Catch:{ all -> 0x00ac }
            r4.w = r1     // Catch:{ all -> 0x00ac }
            int r1 = r4.l     // Catch:{ all -> 0x00ac }
            int r2 = r4.m     // Catch:{ all -> 0x00ac }
            boolean r1 = com.bumptech.glide.g.k.a((int) r1, (int) r2)     // Catch:{ all -> 0x00ac }
            if (r1 == 0) goto L_0x0067
            int r1 = r4.l     // Catch:{ all -> 0x00ac }
            int r2 = r4.m     // Catch:{ all -> 0x00ac }
            r4.a((int) r1, (int) r2)     // Catch:{ all -> 0x00ac }
            goto L_0x006c
        L_0x0067:
            com.bumptech.glide.e.a.j<R> r1 = r4.o     // Catch:{ all -> 0x00ac }
            r1.a((com.bumptech.glide.e.a.i) r4)     // Catch:{ all -> 0x00ac }
        L_0x006c:
            com.bumptech.glide.e.j$a r1 = r4.w     // Catch:{ all -> 0x00ac }
            com.bumptech.glide.e.j$a r2 = com.bumptech.glide.e.j.a.RUNNING     // Catch:{ all -> 0x00ac }
            if (r1 == r2) goto L_0x0078
            com.bumptech.glide.e.j$a r1 = r4.w     // Catch:{ all -> 0x00ac }
            com.bumptech.glide.e.j$a r2 = com.bumptech.glide.e.j.a.WAITING_FOR_SIZE     // Catch:{ all -> 0x00ac }
            if (r1 != r2) goto L_0x0087
        L_0x0078:
            boolean r1 = r4.n()     // Catch:{ all -> 0x00ac }
            if (r1 == 0) goto L_0x0087
            com.bumptech.glide.e.a.j<R> r1 = r4.o     // Catch:{ all -> 0x00ac }
            android.graphics.drawable.Drawable r2 = r4.j()     // Catch:{ all -> 0x00ac }
            r1.b((android.graphics.drawable.Drawable) r2)     // Catch:{ all -> 0x00ac }
        L_0x0087:
            boolean r1 = f6565a     // Catch:{ all -> 0x00ac }
            if (r1 == 0) goto L_0x00a2
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            java.lang.String r2 = "finished run method in "
            r1.<init>(r2)     // Catch:{ all -> 0x00ac }
            long r2 = r4.u     // Catch:{ all -> 0x00ac }
            double r2 = com.bumptech.glide.g.f.a(r2)     // Catch:{ all -> 0x00ac }
            r1.append(r2)     // Catch:{ all -> 0x00ac }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00ac }
            r4.a((java.lang.String) r1)     // Catch:{ all -> 0x00ac }
        L_0x00a2:
            monitor-exit(r0)     // Catch:{ all -> 0x00ac }
            return
        L_0x00a4:
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00ac }
            java.lang.String r2 = "Cannot restart a running request"
            r1.<init>(r2)     // Catch:{ all -> 0x00ac }
            throw r1     // Catch:{ all -> 0x00ac }
        L_0x00ac:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ac }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.j.a():void");
    }

    private void i() {
        if (this.C) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0062, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0064, code lost:
        r0 = r5.v;
        com.bumptech.glide.load.b.k.a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0054  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f6568d
            monitor-enter(r0)
            r5.i()     // Catch:{ all -> 0x006a }
            com.bumptech.glide.g.a.b r1 = r5.f6567c     // Catch:{ all -> 0x006a }
            r1.a()     // Catch:{ all -> 0x006a }
            com.bumptech.glide.e.j$a r1 = r5.w     // Catch:{ all -> 0x006a }
            com.bumptech.glide.e.j$a r2 = com.bumptech.glide.e.j.a.CLEARED     // Catch:{ all -> 0x006a }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            return
        L_0x0013:
            r5.i()     // Catch:{ all -> 0x006a }
            com.bumptech.glide.g.a.b r1 = r5.f6567c     // Catch:{ all -> 0x006a }
            r1.a()     // Catch:{ all -> 0x006a }
            com.bumptech.glide.e.a.j<R> r1 = r5.o     // Catch:{ all -> 0x006a }
            r1.b((com.bumptech.glide.e.a.i) r5)     // Catch:{ all -> 0x006a }
            com.bumptech.glide.load.b.k$d r1 = r5.t     // Catch:{ all -> 0x006a }
            r2 = 0
            if (r1 == 0) goto L_0x0038
            com.bumptech.glide.load.b.k$d r1 = r5.t     // Catch:{ all -> 0x006a }
            com.bumptech.glide.load.b.k r3 = com.bumptech.glide.load.b.k.this     // Catch:{ all -> 0x006a }
            monitor-enter(r3)     // Catch:{ all -> 0x006a }
            com.bumptech.glide.load.b.l<?> r4 = r1.f6903a     // Catch:{ all -> 0x0035 }
            com.bumptech.glide.e.i r1 = r1.f6904b     // Catch:{ all -> 0x0035 }
            r4.a((com.bumptech.glide.e.i) r1)     // Catch:{ all -> 0x0035 }
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            r5.t = r2     // Catch:{ all -> 0x006a }
            goto L_0x0038
        L_0x0035:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            throw r1     // Catch:{ all -> 0x006a }
        L_0x0038:
            com.bumptech.glide.load.b.v<R> r1 = r5.s     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0041
            com.bumptech.glide.load.b.v<R> r1 = r5.s     // Catch:{ all -> 0x006a }
            r5.s = r2     // Catch:{ all -> 0x006a }
            goto L_0x0042
        L_0x0041:
            r1 = r2
        L_0x0042:
            com.bumptech.glide.e.e r2 = r5.f6570f     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x0051
            com.bumptech.glide.e.e r2 = r5.f6570f     // Catch:{ all -> 0x006a }
            boolean r2 = r2.d(r5)     // Catch:{ all -> 0x006a }
            if (r2 == 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r2 = 0
            goto L_0x0052
        L_0x0051:
            r2 = 1
        L_0x0052:
            if (r2 == 0) goto L_0x005d
            com.bumptech.glide.e.a.j<R> r2 = r5.o     // Catch:{ all -> 0x006a }
            android.graphics.drawable.Drawable r3 = r5.j()     // Catch:{ all -> 0x006a }
            r2.a((android.graphics.drawable.Drawable) r3)     // Catch:{ all -> 0x006a }
        L_0x005d:
            com.bumptech.glide.e.j$a r2 = com.bumptech.glide.e.j.a.CLEARED     // Catch:{ all -> 0x006a }
            r5.w = r2     // Catch:{ all -> 0x006a }
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0069
            com.bumptech.glide.load.b.k r0 = r5.v
            com.bumptech.glide.load.b.k.a(r1)
        L_0x0069:
            return
        L_0x006a:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x006a }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.j.b():void");
    }

    public final void c() {
        synchronized (this.f6568d) {
            if (d()) {
                b();
            }
        }
    }

    public final boolean d() {
        boolean z2;
        synchronized (this.f6568d) {
            if (this.w != a.RUNNING) {
                if (this.w != a.WAITING_FOR_SIZE) {
                    z2 = false;
                }
            }
            z2 = true;
        }
        return z2;
    }

    public final boolean e() {
        boolean z2;
        synchronized (this.f6568d) {
            z2 = this.w == a.COMPLETE;
        }
        return z2;
    }

    public final boolean f() {
        boolean z2;
        synchronized (this.f6568d) {
            z2 = this.w == a.CLEARED;
        }
        return z2;
    }

    public final boolean g() {
        boolean z2;
        synchronized (this.f6568d) {
            z2 = this.w == a.COMPLETE;
        }
        return z2;
    }

    private Drawable j() {
        if (this.y == null) {
            this.y = this.k.f6511i;
            if (this.y == null && this.k.j > 0) {
                this.y = a(this.k.j);
            }
        }
        return this.y;
    }

    private Drawable k() {
        if (this.z == null) {
            this.z = this.k.q;
            if (this.z == null && this.k.r > 0) {
                this.z = a(this.k.r);
            }
        }
        return this.z;
    }

    private Drawable a(int i2) {
        Resources.Theme theme;
        if (this.k.w != null) {
            theme = this.k.w;
        } else {
            theme = this.f6571g.getTheme();
        }
        return com.bumptech.glide.load.d.c.a.a((Context) this.f6572h, i2, theme);
    }

    private void l() {
        if (n()) {
            Drawable drawable = null;
            if (this.f6573i == null) {
                drawable = k();
            }
            if (drawable == null) {
                if (this.x == null) {
                    this.x = this.k.f6509g;
                    if (this.x == null && this.k.f6510h > 0) {
                        this.x = a(this.k.f6510h);
                    }
                }
                drawable = this.x;
            }
            if (drawable == null) {
                drawable = j();
            }
            this.o.c(drawable);
        }
    }

    public final void a(int i2, int i3) {
        Object obj;
        this.f6567c.a();
        Object obj2 = this.f6568d;
        synchronized (obj2) {
            try {
                if (f6565a) {
                    a("Got onSizeReady in " + com.bumptech.glide.g.f.a(this.u));
                }
                if (this.w == a.WAITING_FOR_SIZE) {
                    this.w = a.RUNNING;
                    float f2 = this.k.f6506d;
                    this.A = a(i2, f2);
                    this.B = a(i3, f2);
                    if (f6565a) {
                        a("finished setup for calling load in " + com.bumptech.glide.g.f.a(this.u));
                    }
                    obj = obj2;
                    try {
                        this.t = this.v.a(this.f6572h, this.f6573i, this.k.n, this.A, this.B, this.k.u, this.j, this.n, this.k.f6507e, this.k.t, this.k.o, this.k.A, this.k.s, this.k.k, this.k.y, this.k.B, this.k.z, this, this.r);
                        if (this.w != a.RUNNING) {
                            this.t = null;
                        }
                        if (f6565a) {
                            a("finished onSizeReady in " + com.bumptech.glide.g.f.a(this.u));
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                obj = obj2;
                throw th;
            }
        }
    }

    private static int a(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * ((float) i2));
    }

    private boolean m() {
        e eVar = this.f6570f;
        return eVar == null || eVar.b(this);
    }

    private boolean n() {
        e eVar = this.f6570f;
        return eVar == null || eVar.c(this);
    }

    private boolean o() {
        e eVar = this.f6570f;
        return eVar == null || !eVar.h().g();
    }

    private void p() {
        e eVar = this.f6570f;
        if (eVar != null) {
            eVar.f(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004e, code lost:
        r7 = r5.v;
        com.bumptech.glide.load.b.k.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a7, code lost:
        if (r6 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00a9, code lost:
        r7 = r5.v;
        com.bumptech.glide.load.b.k.a(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.bumptech.glide.load.b.v<?> r6, com.bumptech.glide.load.a r7) {
        /*
            r5 = this;
            com.bumptech.glide.g.a.b r0 = r5.f6567c
            r0.a()
            r0 = 0
            java.lang.Object r1 = r5.f6568d     // Catch:{ all -> 0x00b9 }
            monitor-enter(r1)     // Catch:{ all -> 0x00b9 }
            r5.t = r0     // Catch:{ all -> 0x00af }
            if (r6 != 0) goto L_0x002c
            com.bumptech.glide.load.b.q r6 = new com.bumptech.glide.load.b.q     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "Expected to receive a Resource<R> with an object of "
            r7.<init>(r2)     // Catch:{ all -> 0x00af }
            java.lang.Class<R> r2 = r5.j     // Catch:{ all -> 0x00af }
            r7.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r2 = " inside, but instead got null."
            r7.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x00af }
            r6.<init>(r7)     // Catch:{ all -> 0x00af }
            r5.a((com.bumptech.glide.load.b.q) r6)     // Catch:{ all -> 0x00af }
            monitor-exit(r1)     // Catch:{ all -> 0x00af }
            return
        L_0x002c:
            java.lang.Object r2 = r6.b()     // Catch:{ all -> 0x00af }
            if (r2 == 0) goto L_0x0059
            java.lang.Class<R> r3 = r5.j     // Catch:{ all -> 0x00af }
            java.lang.Class r4 = r2.getClass()     // Catch:{ all -> 0x00af }
            boolean r3 = r3.isAssignableFrom(r4)     // Catch:{ all -> 0x00af }
            if (r3 != 0) goto L_0x003f
            goto L_0x0059
        L_0x003f:
            boolean r3 = r5.m()     // Catch:{ all -> 0x00af }
            if (r3 != 0) goto L_0x0054
            r5.s = r0     // Catch:{ all -> 0x00b7 }
            com.bumptech.glide.e.j$a r7 = com.bumptech.glide.e.j.a.COMPLETE     // Catch:{ all -> 0x00b7 }
            r5.w = r7     // Catch:{ all -> 0x00b7 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b7 }
            if (r6 == 0) goto L_0x0053
            com.bumptech.glide.load.b.k r7 = r5.v
            com.bumptech.glide.load.b.k.a(r6)
        L_0x0053:
            return
        L_0x0054:
            r5.a(r6, r2, r7)     // Catch:{ all -> 0x00af }
            monitor-exit(r1)     // Catch:{ all -> 0x00af }
            return
        L_0x0059:
            r5.s = r0     // Catch:{ all -> 0x00b7 }
            com.bumptech.glide.load.b.q r7 = new com.bumptech.glide.load.b.q     // Catch:{ all -> 0x00b7 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b7 }
            java.lang.String r3 = "Expected to receive an object of "
            r0.<init>(r3)     // Catch:{ all -> 0x00b7 }
            java.lang.Class<R> r3 = r5.j     // Catch:{ all -> 0x00b7 }
            r0.append(r3)     // Catch:{ all -> 0x00b7 }
            java.lang.String r3 = " but instead got "
            r0.append(r3)     // Catch:{ all -> 0x00b7 }
            if (r2 == 0) goto L_0x0075
            java.lang.Class r3 = r2.getClass()     // Catch:{ all -> 0x00b7 }
            goto L_0x0077
        L_0x0075:
            java.lang.String r3 = ""
        L_0x0077:
            r0.append(r3)     // Catch:{ all -> 0x00b7 }
            java.lang.String r3 = "{"
            r0.append(r3)     // Catch:{ all -> 0x00b7 }
            r0.append(r2)     // Catch:{ all -> 0x00b7 }
            java.lang.String r3 = "} inside Resource{"
            r0.append(r3)     // Catch:{ all -> 0x00b7 }
            r0.append(r6)     // Catch:{ all -> 0x00b7 }
            java.lang.String r3 = "}."
            r0.append(r3)     // Catch:{ all -> 0x00b7 }
            if (r2 == 0) goto L_0x0097
            java.lang.String r2 = ""
            goto L_0x0099
        L_0x0097:
            java.lang.String r2 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L_0x0099:
            r0.append(r2)     // Catch:{ all -> 0x00b7 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00b7 }
            r7.<init>(r0)     // Catch:{ all -> 0x00b7 }
            r5.a((com.bumptech.glide.load.b.q) r7)     // Catch:{ all -> 0x00b7 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b7 }
            if (r6 == 0) goto L_0x00ae
            com.bumptech.glide.load.b.k r7 = r5.v
            com.bumptech.glide.load.b.k.a(r6)
        L_0x00ae:
            return
        L_0x00af:
            r6 = move-exception
            r7 = r6
            r6 = r0
        L_0x00b2:
            monitor-exit(r1)     // Catch:{ all -> 0x00b7 }
            throw r7     // Catch:{ all -> 0x00b4 }
        L_0x00b4:
            r7 = move-exception
            r0 = r6
            goto L_0x00ba
        L_0x00b7:
            r7 = move-exception
            goto L_0x00b2
        L_0x00b9:
            r7 = move-exception
        L_0x00ba:
            if (r0 == 0) goto L_0x00c1
            com.bumptech.glide.load.b.k r6 = r5.v
            com.bumptech.glide.load.b.k.a(r0)
        L_0x00c1:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.j.a(com.bumptech.glide.load.b.v, com.bumptech.glide.load.a):void");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x009e A[Catch:{ all -> 0x00b3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00af  */
    /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.bumptech.glide.load.b.v<R> r11, R r12, com.bumptech.glide.load.a r13) {
        /*
            r10 = this;
            boolean r6 = r10.o()
            com.bumptech.glide.e.j$a r0 = com.bumptech.glide.e.j.a.COMPLETE
            r10.w = r0
            r10.s = r11
            com.bumptech.glide.d r11 = r10.f6572h
            int r11 = r11.f6486h
            r0 = 3
            if (r11 > r0) goto L_0x005d
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "Finished loading "
            r11.<init>(r0)
            java.lang.Class r0 = r12.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r11.append(r0)
            java.lang.String r0 = " from "
            r11.append(r0)
            r11.append(r13)
            java.lang.String r0 = " for "
            r11.append(r0)
            java.lang.Object r0 = r10.f6573i
            r11.append(r0)
            java.lang.String r0 = " with size ["
            r11.append(r0)
            int r0 = r10.A
            r11.append(r0)
            java.lang.String r0 = "x"
            r11.append(r0)
            int r0 = r10.B
            r11.append(r0)
            java.lang.String r0 = "] in "
            r11.append(r0)
            long r0 = r10.u
            double r0 = com.bumptech.glide.g.f.a(r0)
            r11.append(r0)
            java.lang.String r0 = " ms"
            r11.append(r0)
        L_0x005d:
            r11 = 1
            r10.C = r11
            r7 = 0
            java.util.List<com.bumptech.glide.e.g<R>> r0 = r10.p     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x0085
            java.util.List<com.bumptech.glide.e.g<R>> r0 = r10.p     // Catch:{ all -> 0x00b3 }
            java.util.Iterator r8 = r0.iterator()     // Catch:{ all -> 0x00b3 }
            r9 = 0
        L_0x006c:
            boolean r0 = r8.hasNext()     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x0086
            java.lang.Object r0 = r8.next()     // Catch:{ all -> 0x00b3 }
            com.bumptech.glide.e.g r0 = (com.bumptech.glide.e.g) r0     // Catch:{ all -> 0x00b3 }
            java.lang.Object r2 = r10.f6573i     // Catch:{ all -> 0x00b3 }
            com.bumptech.glide.e.a.j<R> r3 = r10.o     // Catch:{ all -> 0x00b3 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b3 }
            r9 = r9 | r0
            goto L_0x006c
        L_0x0085:
            r9 = 0
        L_0x0086:
            com.bumptech.glide.e.g<R> r0 = r10.f6569e     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x009a
            com.bumptech.glide.e.g<R> r0 = r10.f6569e     // Catch:{ all -> 0x00b3 }
            java.lang.Object r2 = r10.f6573i     // Catch:{ all -> 0x00b3 }
            com.bumptech.glide.e.a.j<R> r3 = r10.o     // Catch:{ all -> 0x00b3 }
            r1 = r12
            r4 = r13
            r5 = r6
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b3 }
            if (r0 == 0) goto L_0x009a
            goto L_0x009b
        L_0x009a:
            r11 = 0
        L_0x009b:
            r11 = r11 | r9
            if (r11 != 0) goto L_0x00a9
            com.bumptech.glide.e.b.g<? super R> r11 = r10.q     // Catch:{ all -> 0x00b3 }
            com.bumptech.glide.e.b.f r11 = r11.a(r13, r6)     // Catch:{ all -> 0x00b3 }
            com.bumptech.glide.e.a.j<R> r13 = r10.o     // Catch:{ all -> 0x00b3 }
            r13.a(r12, r11)     // Catch:{ all -> 0x00b3 }
        L_0x00a9:
            r10.C = r7
            com.bumptech.glide.e.e r11 = r10.f6570f
            if (r11 == 0) goto L_0x00b2
            r11.e(r10)
        L_0x00b2:
            return
        L_0x00b3:
            r11 = move-exception
            r10.C = r7
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.e.j.a(com.bumptech.glide.load.b.v, java.lang.Object, com.bumptech.glide.load.a):void");
    }

    public final void a(q qVar) {
        a(qVar, 5);
    }

    public final Object h() {
        this.f6567c.a();
        return this.f6568d;
    }

    /* JADX INFO: finally extract failed */
    private void a(q qVar, int i2) {
        boolean z2;
        this.f6567c.a();
        synchronized (this.f6568d) {
            qVar.setOrigin(this.D);
            int i3 = this.f6572h.f6486h;
            if (i3 <= i2) {
                StringBuilder sb = new StringBuilder("Load failed for ");
                sb.append(this.f6573i);
                sb.append(" with size [");
                sb.append(this.A);
                sb.append("x");
                sb.append(this.B);
                sb.append("]");
                if (i3 <= 4) {
                    qVar.logRootCauses("Glide");
                }
            }
            this.t = null;
            this.w = a.FAILED;
            boolean z3 = true;
            this.C = true;
            try {
                if (this.p != null) {
                    z2 = false;
                    for (g<R> onLoadFailed : this.p) {
                        z2 |= onLoadFailed.onLoadFailed(qVar, this.f6573i, this.o, o());
                    }
                } else {
                    z2 = false;
                }
                if (this.f6569e == null || !this.f6569e.onLoadFailed(qVar, this.f6573i, this.o, o())) {
                    z3 = false;
                }
                if (!z2 && !z3) {
                    l();
                }
                this.C = false;
                p();
            } catch (Throwable th) {
                this.C = false;
                throw th;
            }
        }
    }

    public final boolean a(d dVar) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        a<?> aVar;
        f fVar;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        a<?> aVar2;
        f fVar2;
        int size2;
        d dVar2 = dVar;
        if (!(dVar2 instanceof j)) {
            return false;
        }
        synchronized (this.f6568d) {
            i2 = this.l;
            i3 = this.m;
            obj = this.f6573i;
            cls = this.j;
            aVar = this.k;
            fVar = this.n;
            size = this.p != null ? this.p.size() : 0;
        }
        j jVar = (j) dVar2;
        synchronized (jVar.f6568d) {
            i4 = jVar.l;
            i5 = jVar.m;
            obj2 = jVar.f6573i;
            cls2 = jVar.j;
            aVar2 = jVar.k;
            fVar2 = jVar.n;
            size2 = jVar.p != null ? jVar.p.size() : 0;
        }
        return i2 == i4 && i3 == i5 && com.bumptech.glide.g.k.b(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && fVar == fVar2 && size == size2;
    }

    private void a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" this: ");
        sb.append(this.f6566b);
    }
}
