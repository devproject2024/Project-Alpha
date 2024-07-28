package com.bumptech.glide.load.b;

import android.util.Log;
import androidx.core.g.e;
import com.alipay.mobile.h5container.api.H5Param;
import com.bumptech.glide.e.i;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.f;
import com.bumptech.glide.load.b.b.a;
import com.bumptech.glide.load.b.b.h;
import com.bumptech.glide.load.b.h;
import com.bumptech.glide.load.b.p;
import com.bumptech.glide.load.g;

public final class k implements h.a, m, p.a {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f6880a = Log.isLoggable("Engine", 2);

    /* renamed from: b  reason: collision with root package name */
    private final s f6881b;

    /* renamed from: c  reason: collision with root package name */
    private final o f6882c;

    /* renamed from: d  reason: collision with root package name */
    private final h f6883d;

    /* renamed from: e  reason: collision with root package name */
    private final b f6884e;

    /* renamed from: f  reason: collision with root package name */
    private final y f6885f;

    /* renamed from: g  reason: collision with root package name */
    private final c f6886g;

    /* renamed from: h  reason: collision with root package name */
    private final a f6887h;

    /* renamed from: i  reason: collision with root package name */
    private final a f6888i;

    public k(h hVar, a.C0094a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, com.bumptech.glide.load.b.c.a aVar5, boolean z) {
        this(hVar, aVar, aVar2, aVar3, aVar4, aVar5, z, (byte) 0);
    }

    private k(h hVar, a.C0094a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, com.bumptech.glide.load.b.c.a aVar5, boolean z, byte b2) {
        this.f6883d = hVar;
        this.f6886g = new c(aVar);
        a aVar6 = new a(z);
        this.f6888i = aVar6;
        synchronized (this) {
            synchronized (aVar6) {
                aVar6.f6720c = this;
            }
        }
        this.f6882c = new o();
        this.f6881b = new s();
        this.f6884e = new b(aVar2, aVar3, aVar4, aVar5, this, this);
        this.f6887h = new a(this.f6886g);
        this.f6885f = new y();
        hVar.a((h.a) this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01ab, code lost:
        return r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d3 A[Catch:{ all -> 0x00c3 }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x01ac A[Catch:{ all -> 0x00c3 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <R> com.bumptech.glide.load.b.k.d a(com.bumptech.glide.d r20, java.lang.Object r21, com.bumptech.glide.load.g r22, int r23, int r24, java.lang.Class<?> r25, java.lang.Class<R> r26, com.bumptech.glide.f r27, com.bumptech.glide.load.b.j r28, java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.m<?>> r29, boolean r30, boolean r31, com.bumptech.glide.load.i r32, boolean r33, boolean r34, boolean r35, boolean r36, com.bumptech.glide.e.i r37, java.util.concurrent.Executor r38) {
        /*
            r19 = this;
            r7 = r19
            r0 = r20
            r6 = r21
            r5 = r22
            r4 = r23
            r3 = r24
            r2 = r27
            r1 = r28
            r15 = r32
            r14 = r36
            r13 = r37
            r12 = r38
            boolean r8 = f6880a
            if (r8 == 0) goto L_0x0021
            long r8 = com.bumptech.glide.g.f.a()
            goto L_0x0023
        L_0x0021:
            r8 = 0
        L_0x0023:
            r10 = r8
            com.bumptech.glide.load.b.n r9 = new com.bumptech.glide.load.b.n
            r8 = r9
            r4 = r9
            r9 = r21
            r17 = r10
            r10 = r22
            r11 = r23
            r12 = r24
            r13 = r29
            r14 = r25
            r15 = r26
            r16 = r32
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)
            monitor-enter(r19)
            if (r33 == 0) goto L_0x00c6
            com.bumptech.glide.load.b.a r9 = r7.f6888i     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.b.p r9 = r9.b(r4)     // Catch:{ all -> 0x00c3 }
            if (r9 == 0) goto L_0x004b
            r9.e()     // Catch:{ all -> 0x00c3 }
        L_0x004b:
            if (r9 == 0) goto L_0x0066
            boolean r10 = f6880a     // Catch:{ all -> 0x00c3 }
            if (r10 == 0) goto L_0x0059
            java.lang.String r10 = "Loaded resource from active resources"
            r11 = r17
            a((java.lang.String) r10, (long) r11, (com.bumptech.glide.load.g) r4)     // Catch:{ all -> 0x00c3 }
            goto L_0x005b
        L_0x0059:
            r11 = r17
        L_0x005b:
            r13 = r23
            r15 = r1
            r8 = r2
            r14 = r5
            r10 = r6
            r1 = r9
            r9 = r3
            r6 = r4
            goto L_0x00d1
        L_0x0066:
            r11 = r17
            com.bumptech.glide.load.b.b.h r9 = r7.f6883d     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.b.v r9 = r9.a((com.bumptech.glide.load.g) r4)     // Catch:{ all -> 0x00c3 }
            if (r9 != 0) goto L_0x007b
            r13 = r23
            r15 = r1
            r8 = r2
            r9 = r3
            r17 = r4
            r14 = r5
            r10 = r6
            r1 = 0
            goto L_0x00a8
        L_0x007b:
            boolean r10 = r9 instanceof com.bumptech.glide.load.b.p     // Catch:{ all -> 0x00c3 }
            if (r10 == 0) goto L_0x008c
            com.bumptech.glide.load.b.p r9 = (com.bumptech.glide.load.b.p) r9     // Catch:{ all -> 0x00c3 }
            r13 = r23
            r15 = r1
            r8 = r2
            r17 = r4
            r14 = r5
            r10 = r6
            r1 = r9
            r9 = r3
            goto L_0x00a8
        L_0x008c:
            com.bumptech.glide.load.b.p r10 = new com.bumptech.glide.load.b.p     // Catch:{ all -> 0x00c3 }
            r13 = 1
            r14 = 1
            r15 = r1
            r1 = r10
            r8 = r2
            r2 = r9
            r9 = r3
            r3 = r13
            r13 = r23
            r17 = r4
            r4 = r14
            r14 = r5
            r5 = r17
            r18 = r10
            r10 = r6
            r6 = r19
            r1.<init>(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00c3 }
            r1 = r18
        L_0x00a8:
            if (r1 == 0) goto L_0x00b5
            r1.e()     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.b.a r2 = r7.f6888i     // Catch:{ all -> 0x00c3 }
            r6 = r17
            r2.a(r6, r1)     // Catch:{ all -> 0x00c3 }
            goto L_0x00b7
        L_0x00b5:
            r6 = r17
        L_0x00b7:
            if (r1 == 0) goto L_0x00d0
            boolean r2 = f6880a     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x00d1
            java.lang.String r2 = "Loaded resource from cache"
            a((java.lang.String) r2, (long) r11, (com.bumptech.glide.load.g) r6)     // Catch:{ all -> 0x00c3 }
            goto L_0x00d1
        L_0x00c3:
            r0 = move-exception
            goto L_0x01b6
        L_0x00c6:
            r13 = r23
            r15 = r1
            r8 = r2
            r9 = r3
            r14 = r5
            r10 = r6
            r11 = r17
            r6 = r4
        L_0x00d0:
            r1 = 0
        L_0x00d1:
            if (r1 != 0) goto L_0x01ac
            com.bumptech.glide.load.b.s r1 = r7.f6881b     // Catch:{ all -> 0x00c3 }
            r5 = r36
            java.util.Map r1 = r1.a(r5)     // Catch:{ all -> 0x00c3 }
            java.lang.Object r1 = r1.get(r6)     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.b.l r1 = (com.bumptech.glide.load.b.l) r1     // Catch:{ all -> 0x00c3 }
            if (r1 == 0) goto L_0x00fa
            r4 = r37
            r3 = r38
            r1.a((com.bumptech.glide.e.i) r4, (java.util.concurrent.Executor) r3)     // Catch:{ all -> 0x00c3 }
            boolean r0 = f6880a     // Catch:{ all -> 0x00c3 }
            if (r0 == 0) goto L_0x00f3
            java.lang.String r0 = "Added to existing load"
            a((java.lang.String) r0, (long) r11, (com.bumptech.glide.load.g) r6)     // Catch:{ all -> 0x00c3 }
        L_0x00f3:
            com.bumptech.glide.load.b.k$d r0 = new com.bumptech.glide.load.b.k$d     // Catch:{ all -> 0x00c3 }
            r0.<init>(r4, r1)     // Catch:{ all -> 0x00c3 }
            goto L_0x01aa
        L_0x00fa:
            r4 = r37
            r3 = r38
            com.bumptech.glide.load.b.k$b r1 = r7.f6884e     // Catch:{ all -> 0x00c3 }
            androidx.core.g.e$a<com.bumptech.glide.load.b.l<?>> r1 = r1.f6899g     // Catch:{ all -> 0x00c3 }
            java.lang.Object r1 = r1.a()     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.b.l r1 = (com.bumptech.glide.load.b.l) r1     // Catch:{ all -> 0x00c3 }
            java.lang.String r2 = "Argument must not be null"
            java.lang.Object r1 = com.bumptech.glide.g.j.a(r1, (java.lang.String) r2)     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.b.l r1 = (com.bumptech.glide.load.b.l) r1     // Catch:{ all -> 0x00c3 }
            r2 = r6
            r17 = r11
            r11 = r3
            r3 = r33
            r12 = r4
            r4 = r34
            r11 = r5
            r5 = r35
            r12 = r6
            r6 = r36
            com.bumptech.glide.load.b.l r1 = r1.a(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.b.k$a r2 = r7.f6887h     // Catch:{ all -> 0x00c3 }
            androidx.core.g.e$a<com.bumptech.glide.load.b.h<?>> r3 = r2.f6890b     // Catch:{ all -> 0x00c3 }
            java.lang.Object r3 = r3.a()     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.b.h r3 = (com.bumptech.glide.load.b.h) r3     // Catch:{ all -> 0x00c3 }
            java.lang.String r4 = "Argument must not be null"
            java.lang.Object r3 = com.bumptech.glide.g.j.a(r3, (java.lang.String) r4)     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.b.h r3 = (com.bumptech.glide.load.b.h) r3     // Catch:{ all -> 0x00c3 }
            int r4 = r2.f6891c     // Catch:{ all -> 0x00c3 }
            int r5 = r4 + 1
            r2.f6891c = r5     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.b.g<R> r2 = r3.f6850a     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.b.h$d r5 = r3.f6851b     // Catch:{ all -> 0x00c3 }
            r2.f6841a = r0     // Catch:{ all -> 0x00c3 }
            r2.f6842b = r10     // Catch:{ all -> 0x00c3 }
            r2.j = r14     // Catch:{ all -> 0x00c3 }
            r2.f6843c = r13     // Catch:{ all -> 0x00c3 }
            r2.f6844d = r9     // Catch:{ all -> 0x00c3 }
            r2.l = r15     // Catch:{ all -> 0x00c3 }
            r6 = r25
            r2.f6845e = r6     // Catch:{ all -> 0x00c3 }
            r2.f6846f = r5     // Catch:{ all -> 0x00c3 }
            r5 = r26
            r2.f6849i = r5     // Catch:{ all -> 0x00c3 }
            r2.k = r8     // Catch:{ all -> 0x00c3 }
            r5 = r32
            r2.f6847g = r5     // Catch:{ all -> 0x00c3 }
            r6 = r29
            r2.f6848h = r6     // Catch:{ all -> 0x00c3 }
            r6 = r30
            r2.m = r6     // Catch:{ all -> 0x00c3 }
            r6 = r31
            r2.n = r6     // Catch:{ all -> 0x00c3 }
            r3.f6854e = r0     // Catch:{ all -> 0x00c3 }
            r3.f6855f = r14     // Catch:{ all -> 0x00c3 }
            r3.f6856g = r8     // Catch:{ all -> 0x00c3 }
            r3.f6857h = r12     // Catch:{ all -> 0x00c3 }
            r3.f6858i = r13     // Catch:{ all -> 0x00c3 }
            r3.j = r9     // Catch:{ all -> 0x00c3 }
            r3.k = r15     // Catch:{ all -> 0x00c3 }
            r3.p = r11     // Catch:{ all -> 0x00c3 }
            r3.l = r5     // Catch:{ all -> 0x00c3 }
            r3.m = r1     // Catch:{ all -> 0x00c3 }
            r3.n = r4     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.b.h$f r0 = com.bumptech.glide.load.b.h.f.INITIALIZE     // Catch:{ all -> 0x00c3 }
            r3.o = r0     // Catch:{ all -> 0x00c3 }
            r3.q = r10     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.b.s r0 = r7.f6881b     // Catch:{ all -> 0x00c3 }
            boolean r2 = r1.f6908b     // Catch:{ all -> 0x00c3 }
            java.util.Map r0 = r0.a(r2)     // Catch:{ all -> 0x00c3 }
            r0.put(r12, r1)     // Catch:{ all -> 0x00c3 }
            r0 = r37
            r2 = r38
            r4 = r12
            r1.a((com.bumptech.glide.e.i) r0, (java.util.concurrent.Executor) r2)     // Catch:{ all -> 0x00c3 }
            r1.b(r3)     // Catch:{ all -> 0x00c3 }
            boolean r2 = f6880a     // Catch:{ all -> 0x00c3 }
            if (r2 == 0) goto L_0x01a4
            java.lang.String r2 = "Started new load"
            r8 = r17
            a((java.lang.String) r2, (long) r8, (com.bumptech.glide.load.g) r4)     // Catch:{ all -> 0x00c3 }
        L_0x01a4:
            com.bumptech.glide.load.b.k$d r2 = new com.bumptech.glide.load.b.k$d     // Catch:{ all -> 0x00c3 }
            r2.<init>(r0, r1)     // Catch:{ all -> 0x00c3 }
            r0 = r2
        L_0x01aa:
            monitor-exit(r19)     // Catch:{ all -> 0x00c3 }
            return r0
        L_0x01ac:
            r0 = r37
            monitor-exit(r19)     // Catch:{ all -> 0x00c3 }
            com.bumptech.glide.load.a r2 = com.bumptech.glide.load.a.MEMORY_CACHE
            r0.a(r1, r2)
            r0 = 0
            return r0
        L_0x01b6:
            monitor-exit(r19)     // Catch:{ all -> 0x00c3 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.b.k.a(com.bumptech.glide.d, java.lang.Object, com.bumptech.glide.load.g, int, int, java.lang.Class, java.lang.Class, com.bumptech.glide.f, com.bumptech.glide.load.b.j, java.util.Map, boolean, boolean, com.bumptech.glide.load.i, boolean, boolean, boolean, boolean, com.bumptech.glide.e.i, java.util.concurrent.Executor):com.bumptech.glide.load.b.k$d");
    }

    private static void a(String str, long j, g gVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" in ");
        sb.append(f.a(j));
        sb.append("ms, key: ");
        sb.append(gVar);
    }

    public static void a(v<?> vVar) {
        if (vVar instanceof p) {
            ((p) vVar).f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public final synchronized void a(l<?> lVar, g gVar) {
        this.f6881b.a(gVar, lVar);
    }

    public final void b(v<?> vVar) {
        this.f6885f.a(vVar, true);
    }

    public final void a(g gVar, p<?> pVar) {
        this.f6888i.a(gVar);
        if (pVar.f6930a) {
            this.f6883d.a(gVar, pVar);
        } else {
            this.f6885f.a(pVar, false);
        }
    }

    public class d {

        /* renamed from: a  reason: collision with root package name */
        public final l<?> f6903a;

        /* renamed from: b  reason: collision with root package name */
        public final i f6904b;

        d(i iVar, l<?> lVar) {
            this.f6904b = iVar;
            this.f6903a = lVar;
        }
    }

    static class c implements h.d {

        /* renamed from: a  reason: collision with root package name */
        private final a.C0094a f6901a;

        /* renamed from: b  reason: collision with root package name */
        private volatile com.bumptech.glide.load.b.b.a f6902b;

        c(a.C0094a aVar) {
            this.f6901a = aVar;
        }

        public final com.bumptech.glide.load.b.b.a a() {
            if (this.f6902b == null) {
                synchronized (this) {
                    if (this.f6902b == null) {
                        this.f6902b = this.f6901a.a();
                    }
                    if (this.f6902b == null) {
                        this.f6902b = new com.bumptech.glide.load.b.b.b();
                    }
                }
            }
            return this.f6902b;
        }
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final h.d f6889a;

        /* renamed from: b  reason: collision with root package name */
        final e.a<h<?>> f6890b = com.bumptech.glide.g.a.a.a(H5Param.WEBVIEW_FONT_SIZE_LARGER, new a.C0091a<h<?>>() {
            public final /* synthetic */ Object a() {
                return new h(a.this.f6889a, a.this.f6890b);
            }
        });

        /* renamed from: c  reason: collision with root package name */
        int f6891c;

        a(h.d dVar) {
            this.f6889a = dVar;
        }
    }

    static class b {

        /* renamed from: a  reason: collision with root package name */
        final com.bumptech.glide.load.b.c.a f6893a;

        /* renamed from: b  reason: collision with root package name */
        final com.bumptech.glide.load.b.c.a f6894b;

        /* renamed from: c  reason: collision with root package name */
        final com.bumptech.glide.load.b.c.a f6895c;

        /* renamed from: d  reason: collision with root package name */
        final com.bumptech.glide.load.b.c.a f6896d;

        /* renamed from: e  reason: collision with root package name */
        final m f6897e;

        /* renamed from: f  reason: collision with root package name */
        final p.a f6898f;

        /* renamed from: g  reason: collision with root package name */
        final e.a<l<?>> f6899g = com.bumptech.glide.g.a.a.a(H5Param.WEBVIEW_FONT_SIZE_LARGER, new a.C0091a<l<?>>() {
            public final /* synthetic */ Object a() {
                return new l(b.this.f6893a, b.this.f6894b, b.this.f6895c, b.this.f6896d, b.this.f6897e, b.this.f6898f, b.this.f6899g);
            }
        });

        b(com.bumptech.glide.load.b.c.a aVar, com.bumptech.glide.load.b.c.a aVar2, com.bumptech.glide.load.b.c.a aVar3, com.bumptech.glide.load.b.c.a aVar4, m mVar, p.a aVar5) {
            this.f6893a = aVar;
            this.f6894b = aVar2;
            this.f6895c = aVar3;
            this.f6896d = aVar4;
            this.f6897e = mVar;
            this.f6898f = aVar5;
        }
    }

    public final synchronized void a(l<?> lVar, g gVar, p<?> pVar) {
        if (pVar != null) {
            if (pVar.f6930a) {
                this.f6888i.a(gVar, pVar);
            }
        }
        this.f6881b.a(gVar, lVar);
    }
}
