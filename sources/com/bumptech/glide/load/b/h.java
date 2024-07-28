package com.bumptech.glide.load.b;

import android.os.Build;
import android.util.Log;
import androidx.core.g.e;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.load.b.f;
import com.bumptech.glide.load.b.i;
import com.bumptech.glide.load.d.a.o;
import com.bumptech.glide.load.i;
import com.bumptech.glide.load.l;
import java.util.ArrayList;
import java.util.List;

final class h<R> implements a.c, f.a, Comparable<h<?>>, Runnable {
    private com.bumptech.glide.load.g A;
    private Object B;
    private com.bumptech.glide.load.a C;
    private com.bumptech.glide.load.a.d<?> D;
    private volatile boolean E;

    /* renamed from: a  reason: collision with root package name */
    final g<R> f6850a = new g<>();

    /* renamed from: b  reason: collision with root package name */
    final d f6851b;

    /* renamed from: c  reason: collision with root package name */
    final c<?> f6852c = new c<>();

    /* renamed from: d  reason: collision with root package name */
    final e f6853d = new e();

    /* renamed from: e  reason: collision with root package name */
    com.bumptech.glide.d f6854e;

    /* renamed from: f  reason: collision with root package name */
    com.bumptech.glide.load.g f6855f;

    /* renamed from: g  reason: collision with root package name */
    com.bumptech.glide.f f6856g;

    /* renamed from: h  reason: collision with root package name */
    n f6857h;

    /* renamed from: i  reason: collision with root package name */
    int f6858i;
    int j;
    j k;
    i l;
    a<R> m;
    int n;
    f o;
    boolean p;
    Object q;
    com.bumptech.glide.load.g r;
    volatile f s;
    volatile boolean t;
    private final List<Throwable> u = new ArrayList();
    private final com.bumptech.glide.g.a.b v = new b.a();
    private final e.a<h<?>> w;
    private g x;
    private long y;
    private Thread z;

    interface a<R> {
        void a(h<?> hVar);

        void a(q qVar);

        void a(v<R> vVar, com.bumptech.glide.load.a aVar);
    }

    interface d {
        com.bumptech.glide.load.b.b.a a();
    }

    enum f {
        INITIALIZE,
        SWITCH_TO_SOURCE_SERVICE,
        DECODE_DATA
    }

    enum g {
        INITIALIZE,
        RESOURCE_CACHE,
        DATA_CACHE,
        SOURCE,
        ENCODE,
        FINISHED
    }

    public final /* synthetic */ int compareTo(Object obj) {
        h hVar = (h) obj;
        int ordinal = this.f6856g.ordinal() - hVar.f6856g.ordinal();
        return ordinal == 0 ? this.n - hVar.n : ordinal;
    }

    h(d dVar, e.a<h<?>> aVar) {
        this.f6851b = dVar;
        this.w = aVar;
    }

    private void d() {
        if (this.f6853d.b()) {
            a();
        }
    }

    private void e() {
        if (this.f6853d.c()) {
            a();
        }
    }

    /* access modifiers changed from: package-private */
    public final void a() {
        this.f6853d.d();
        this.f6852c.b();
        this.f6850a.a();
        this.E = false;
        this.f6854e = null;
        this.f6855f = null;
        this.l = null;
        this.f6856g = null;
        this.f6857h = null;
        this.m = null;
        this.x = null;
        this.s = null;
        this.z = null;
        this.r = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.y = 0;
        this.t = false;
        this.q = null;
        this.u.clear();
        this.w.a(this);
    }

    public final void run() {
        com.bumptech.glide.load.a.d<?> dVar = this.D;
        try {
            if (this.t) {
                h();
                if (dVar != null) {
                    dVar.b();
                    return;
                }
                return;
            }
            int i2 = AnonymousClass1.f6859a[this.o.ordinal()];
            if (i2 == 1) {
                this.x = a(g.INITIALIZE);
                this.s = f();
                g();
            } else if (i2 == 2) {
                g();
            } else if (i2 == 3) {
                j();
            } else {
                throw new IllegalStateException("Unrecognized run reason: " + this.o);
            }
            if (dVar != null) {
                dVar.b();
            }
        } catch (b e2) {
            throw e2;
        } catch (Throwable th) {
            if (dVar != null) {
                dVar.b();
            }
            throw th;
        }
    }

    private f f() {
        int i2 = AnonymousClass1.f6860b[this.x.ordinal()];
        if (i2 == 1) {
            return new w(this.f6850a, this);
        }
        if (i2 == 2) {
            return new c(this.f6850a, this);
        }
        if (i2 == 3) {
            return new z(this.f6850a, this);
        }
        if (i2 == 4) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: " + this.x);
    }

    private void g() {
        this.z = Thread.currentThread();
        this.y = com.bumptech.glide.g.f.a();
        boolean z2 = false;
        while (!this.t && this.s != null && !(z2 = this.s.a())) {
            this.x = a(this.x);
            this.s = f();
            if (this.x == g.SOURCE) {
                c();
                return;
            }
        }
        if ((this.x == g.FINISHED || this.t) && !z2) {
            h();
        }
    }

    private void h() {
        i();
        this.m.a(new q("Failed to load resource", (List<Throwable>) new ArrayList(this.u)));
        e();
    }

    private void a(v<R> vVar, com.bumptech.glide.load.a aVar) {
        i();
        this.m.a(vVar, aVar);
    }

    private void i() {
        Throwable th;
        this.v.a();
        if (this.E) {
            if (this.u.isEmpty()) {
                th = null;
            } else {
                List<Throwable> list = this.u;
                th = list.get(list.size() - 1);
            }
            throw new IllegalStateException("Already notified", th);
        }
        this.E = true;
    }

    /* access modifiers changed from: package-private */
    public final g a(g gVar) {
        while (true) {
            int i2 = AnonymousClass1.f6860b[gVar.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return this.p ? g.FINISHED : g.SOURCE;
                }
                if (i2 != 3 && i2 != 4) {
                    if (i2 != 5) {
                        throw new IllegalArgumentException("Unrecognized stage: ".concat(String.valueOf(gVar)));
                    } else if (this.k.a()) {
                        return g.RESOURCE_CACHE;
                    } else {
                        gVar = g.RESOURCE_CACHE;
                    }
                }
            } else if (this.k.b()) {
                return g.DATA_CACHE;
            } else {
                gVar = g.DATA_CACHE;
            }
        }
        return g.FINISHED;
    }

    public final void c() {
        this.o = f.SWITCH_TO_SOURCE_SERVICE;
        this.m.a((h<?>) this);
    }

    public final void a(com.bumptech.glide.load.g gVar, Object obj, com.bumptech.glide.load.a.d<?> dVar, com.bumptech.glide.load.a aVar, com.bumptech.glide.load.g gVar2) {
        this.r = gVar;
        this.B = obj;
        this.D = dVar;
        this.C = aVar;
        this.A = gVar2;
        if (Thread.currentThread() != this.z) {
            this.o = f.DECODE_DATA;
            this.m.a((h<?>) this);
            return;
        }
        j();
    }

    public final void a(com.bumptech.glide.load.g gVar, Exception exc, com.bumptech.glide.load.a.d<?> dVar, com.bumptech.glide.load.a aVar) {
        dVar.b();
        q qVar = new q("Fetching data failed", (Throwable) exc);
        qVar.setLoggingDetails(gVar, aVar, dVar.a());
        this.u.add(qVar);
        if (Thread.currentThread() != this.z) {
            this.o = f.SWITCH_TO_SOURCE_SERVICE;
            this.m.a((h<?>) this);
            return;
        }
        g();
    }

    private void j() {
        if (Log.isLoggable("DecodeJob", 2)) {
            long j2 = this.y;
            a("Retrieved data", j2, "data: " + this.B + ", cache key: " + this.r + ", fetcher: " + this.D);
        }
        v<R> vVar = null;
        try {
            vVar = a(this.D, this.B, this.C);
        } catch (q e2) {
            e2.setLoggingDetails(this.A, this.C);
            this.u.add(e2);
        }
        if (vVar != null) {
            b(vVar, this.C);
        } else {
            g();
        }
    }

    private void b(v<R> vVar, com.bumptech.glide.load.a aVar) {
        if (vVar instanceof r) {
            ((r) vVar).e();
        }
        u<R> uVar = null;
        u<R> uVar2 = vVar;
        if (this.f6852c.a()) {
            u<R> a2 = u.a(vVar);
            uVar = a2;
            uVar2 = a2;
        }
        a(uVar2, aVar);
        this.x = g.ENCODE;
        try {
            if (this.f6852c.a()) {
                this.f6852c.a(this.f6851b, this.l);
            }
            d();
        } finally {
            if (uVar != null) {
                uVar.e();
            }
        }
    }

    private <Data> v<R> a(com.bumptech.glide.load.a.d<?> dVar, Data data, com.bumptech.glide.load.a aVar) throws q {
        if (data == null) {
            dVar.b();
            return null;
        }
        try {
            long a2 = com.bumptech.glide.g.f.a();
            v<R> a3 = a(data, aVar, this.f6850a.b(data.getClass()));
            if (Log.isLoggable("DecodeJob", 2)) {
                a("Decoded result ".concat(String.valueOf(a3)), a2, (String) null);
            }
            return a3;
        } finally {
            dVar.b();
        }
    }

    private void a(String str, long j2, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(com.bumptech.glide.g.f.a(j2));
        sb.append(", load key: ");
        sb.append(this.f6857h);
        sb.append(str2 != null ? ", ".concat(String.valueOf(str2)) : "");
        sb.append(", thread: ");
        sb.append(Thread.currentThread().getName());
    }

    public final com.bumptech.glide.g.a.b e_() {
        return this.v;
    }

    /* renamed from: com.bumptech.glide.load.b.h$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f6859a = new int[f.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f6860b = new int[g.values().length];

        /* renamed from: c  reason: collision with root package name */
        static final /* synthetic */ int[] f6861c = new int[com.bumptech.glide.load.c.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(25:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Can't wrap try/catch for region: R(26:0|1|2|3|5|6|7|9|10|11|12|13|15|16|17|18|19|20|21|23|24|25|26|27|28|30) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0047 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0070 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x007a */
        static {
            /*
                com.bumptech.glide.load.c[] r0 = com.bumptech.glide.load.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6861c = r0
                r0 = 1
                int[] r1 = f6861c     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.bumptech.glide.load.c r2 = com.bumptech.glide.load.c.SOURCE     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f6861c     // Catch:{ NoSuchFieldError -> 0x001f }
                com.bumptech.glide.load.c r3 = com.bumptech.glide.load.c.TRANSFORMED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                com.bumptech.glide.load.b.h$g[] r2 = com.bumptech.glide.load.b.h.g.values()
                int r2 = r2.length
                int[] r2 = new int[r2]
                f6860b = r2
                int[] r2 = f6860b     // Catch:{ NoSuchFieldError -> 0x0032 }
                com.bumptech.glide.load.b.h$g r3 = com.bumptech.glide.load.b.h.g.RESOURCE_CACHE     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                int[] r2 = f6860b     // Catch:{ NoSuchFieldError -> 0x003c }
                com.bumptech.glide.load.b.h$g r3 = com.bumptech.glide.load.b.h.g.DATA_CACHE     // Catch:{ NoSuchFieldError -> 0x003c }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                r2 = 3
                int[] r3 = f6860b     // Catch:{ NoSuchFieldError -> 0x0047 }
                com.bumptech.glide.load.b.h$g r4 = com.bumptech.glide.load.b.h.g.SOURCE     // Catch:{ NoSuchFieldError -> 0x0047 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0047 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0047 }
            L_0x0047:
                int[] r3 = f6860b     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.bumptech.glide.load.b.h$g r4 = com.bumptech.glide.load.b.h.g.FINISHED     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r3 = f6860b     // Catch:{ NoSuchFieldError -> 0x005d }
                com.bumptech.glide.load.b.h$g r4 = com.bumptech.glide.load.b.h.g.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x005d }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                com.bumptech.glide.load.b.h$f[] r3 = com.bumptech.glide.load.b.h.f.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f6859a = r3
                int[] r3 = f6859a     // Catch:{ NoSuchFieldError -> 0x0070 }
                com.bumptech.glide.load.b.h$f r4 = com.bumptech.glide.load.b.h.f.INITIALIZE     // Catch:{ NoSuchFieldError -> 0x0070 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0070 }
                r3[r4] = r0     // Catch:{ NoSuchFieldError -> 0x0070 }
            L_0x0070:
                int[] r0 = f6859a     // Catch:{ NoSuchFieldError -> 0x007a }
                com.bumptech.glide.load.b.h$f r3 = com.bumptech.glide.load.b.h.f.SWITCH_TO_SOURCE_SERVICE     // Catch:{ NoSuchFieldError -> 0x007a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x007a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x007a }
            L_0x007a:
                int[] r0 = f6859a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.bumptech.glide.load.b.h$f r1 = com.bumptech.glide.load.b.h.f.DECODE_DATA     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.h.AnonymousClass1.<clinit>():void");
        }
    }

    final class b<Z> implements i.a<Z> {

        /* renamed from: b  reason: collision with root package name */
        private final com.bumptech.glide.load.a f6863b;

        b(com.bumptech.glide.load.a aVar) {
            this.f6863b = aVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v9, resolved type: com.bumptech.glide.load.b.x} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v10, resolved type: com.bumptech.glide.load.b.d} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v24, resolved type: com.bumptech.glide.load.b.x} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: com.bumptech.glide.load.b.x} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.bumptech.glide.load.b.v<Z> a(com.bumptech.glide.load.b.v<Z> r14) {
            /*
                r13 = this;
                com.bumptech.glide.load.b.h r0 = com.bumptech.glide.load.b.h.this
                com.bumptech.glide.load.a r1 = r13.f6863b
                java.lang.Object r2 = r14.b()
                java.lang.Class r10 = r2.getClass()
                com.bumptech.glide.load.a r2 = com.bumptech.glide.load.a.RESOURCE_DISK_CACHE
                r3 = 0
                if (r1 == r2) goto L_0x0024
                com.bumptech.glide.load.b.g<R> r2 = r0.f6850a
                com.bumptech.glide.load.m r2 = r2.c(r10)
                com.bumptech.glide.d r4 = r0.f6854e
                int r5 = r0.f6858i
                int r6 = r0.j
                com.bumptech.glide.load.b.v r4 = r2.transform(r4, r14, r5, r6)
                r9 = r2
                r2 = r4
                goto L_0x0026
            L_0x0024:
                r2 = r14
                r9 = r3
            L_0x0026:
                boolean r4 = r14.equals(r2)
                if (r4 != 0) goto L_0x002f
                r14.d()
            L_0x002f:
                com.bumptech.glide.load.b.g<R> r14 = r0.f6850a
                com.bumptech.glide.d r14 = r14.f6841a
                com.bumptech.glide.g r14 = r14.f6481c
                com.bumptech.glide.d.f r14 = r14.f6587b
                java.lang.Class r4 = r2.a()
                com.bumptech.glide.load.l r14 = r14.a(r4)
                r4 = 0
                r5 = 1
                if (r14 == 0) goto L_0x0045
                r14 = 1
                goto L_0x0046
            L_0x0045:
                r14 = 0
            L_0x0046:
                if (r14 == 0) goto L_0x006b
                com.bumptech.glide.load.b.g<R> r14 = r0.f6850a
                com.bumptech.glide.d r14 = r14.f6841a
                com.bumptech.glide.g r14 = r14.f6481c
                com.bumptech.glide.d.f r14 = r14.f6587b
                java.lang.Class r3 = r2.a()
                com.bumptech.glide.load.l r3 = r14.a(r3)
                if (r3 == 0) goto L_0x0061
                com.bumptech.glide.load.i r14 = r0.l
                com.bumptech.glide.load.c r14 = r3.a(r14)
                goto L_0x006d
            L_0x0061:
                com.bumptech.glide.g$d r14 = new com.bumptech.glide.g$d
                java.lang.Class r0 = r2.a()
                r14.<init>(r0)
                throw r14
            L_0x006b:
                com.bumptech.glide.load.c r14 = com.bumptech.glide.load.c.NONE
            L_0x006d:
                r12 = r3
                com.bumptech.glide.load.b.g<R> r3 = r0.f6850a
                com.bumptech.glide.load.g r6 = r0.r
                java.util.List r3 = r3.c()
                int r7 = r3.size()
                r8 = 0
            L_0x007b:
                if (r8 >= r7) goto L_0x0090
                java.lang.Object r11 = r3.get(r8)
                com.bumptech.glide.load.c.n$a r11 = (com.bumptech.glide.load.c.n.a) r11
                com.bumptech.glide.load.g r11 = r11.f7053a
                boolean r11 = r11.equals(r6)
                if (r11 == 0) goto L_0x008d
                r4 = 1
                goto L_0x0090
            L_0x008d:
                int r8 = r8 + 1
                goto L_0x007b
            L_0x0090:
                r3 = r4 ^ 1
                com.bumptech.glide.load.b.j r4 = r0.k
                boolean r1 = r4.a(r3, r1, r14)
                if (r1 == 0) goto L_0x00f4
                if (r12 == 0) goto L_0x00e6
                int[] r1 = com.bumptech.glide.load.b.h.AnonymousClass1.f6861c
                int r3 = r14.ordinal()
                r1 = r1[r3]
                if (r1 == r5) goto L_0x00d0
                r3 = 2
                if (r1 != r3) goto L_0x00c0
                com.bumptech.glide.load.b.x r14 = new com.bumptech.glide.load.b.x
                com.bumptech.glide.load.b.g<R> r1 = r0.f6850a
                com.bumptech.glide.d r1 = r1.f6841a
                com.bumptech.glide.load.b.a.b r4 = r1.f6480b
                com.bumptech.glide.load.g r5 = r0.r
                com.bumptech.glide.load.g r6 = r0.f6855f
                int r7 = r0.f6858i
                int r8 = r0.j
                com.bumptech.glide.load.i r11 = r0.l
                r3 = r14
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
                goto L_0x00d9
            L_0x00c0:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.String r14 = java.lang.String.valueOf(r14)
                java.lang.String r1 = "Unknown strategy: "
                java.lang.String r14 = r1.concat(r14)
                r0.<init>(r14)
                throw r0
            L_0x00d0:
                com.bumptech.glide.load.b.d r14 = new com.bumptech.glide.load.b.d
                com.bumptech.glide.load.g r1 = r0.r
                com.bumptech.glide.load.g r3 = r0.f6855f
                r14.<init>(r1, r3)
            L_0x00d9:
                com.bumptech.glide.load.b.u r2 = com.bumptech.glide.load.b.u.a(r2)
                com.bumptech.glide.load.b.h$c<?> r0 = r0.f6852c
                r0.f6864a = r14
                r0.f6865b = r12
                r0.f6866c = r2
                goto L_0x00f4
            L_0x00e6:
                com.bumptech.glide.g$d r14 = new com.bumptech.glide.g$d
                java.lang.Object r0 = r2.b()
                java.lang.Class r0 = r0.getClass()
                r14.<init>(r0)
                throw r14
            L_0x00f4:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.h.b.a(com.bumptech.glide.load.b.v):com.bumptech.glide.load.b.v");
        }
    }

    static class e {

        /* renamed from: a  reason: collision with root package name */
        private boolean f6867a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f6868b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f6869c;

        e() {
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean a() {
            this.f6867a = true;
            return e();
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean b() {
            this.f6868b = true;
            return e();
        }

        /* access modifiers changed from: package-private */
        public final synchronized boolean c() {
            this.f6869c = true;
            return e();
        }

        /* access modifiers changed from: package-private */
        public final synchronized void d() {
            this.f6868b = false;
            this.f6867a = false;
            this.f6869c = false;
        }

        private boolean e() {
            return (this.f6869c || this.f6868b) && this.f6867a;
        }
    }

    static class c<Z> {

        /* renamed from: a  reason: collision with root package name */
        com.bumptech.glide.load.g f6864a;

        /* renamed from: b  reason: collision with root package name */
        l<Z> f6865b;

        /* renamed from: c  reason: collision with root package name */
        u<Z> f6866c;

        c() {
        }

        /* access modifiers changed from: package-private */
        public final void a(d dVar, com.bumptech.glide.load.i iVar) {
            try {
                dVar.a().a(this.f6864a, new e(this.f6865b, this.f6866c, iVar));
            } finally {
                this.f6866c.e();
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean a() {
            return this.f6866c != null;
        }

        /* access modifiers changed from: package-private */
        public final void b() {
            this.f6864a = null;
            this.f6865b = null;
            this.f6866c = null;
        }
    }

    private <Data, ResourceType> v<R> a(Data data, com.bumptech.glide.load.a aVar, t<Data, ResourceType, R> tVar) throws q {
        com.bumptech.glide.load.i iVar = this.l;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z2 = aVar == com.bumptech.glide.load.a.RESOURCE_DISK_CACHE || this.f6850a.n;
            Boolean bool = (Boolean) iVar.a(o.f7163e);
            if (bool == null || (bool.booleanValue() && !z2)) {
                iVar = new com.bumptech.glide.load.i();
                iVar.a(this.l);
                iVar.a(o.f7163e, Boolean.valueOf(z2));
            }
        }
        com.bumptech.glide.load.i iVar2 = iVar;
        com.bumptech.glide.load.a.e a2 = this.f6854e.f6481c.f6588c.a(data);
        try {
            return tVar.a(a2, iVar2, this.f6858i, this.j, new b(aVar));
        } finally {
            a2.b();
        }
    }
}
