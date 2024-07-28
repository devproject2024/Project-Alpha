package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Pair;
import com.google.android.exoplayer2.a;
import com.google.android.exoplayer2.aa;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.b;
import com.google.android.exoplayer2.l;
import com.google.android.exoplayer2.m;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.trackselection.f;
import com.google.android.exoplayer2.trackselection.g;
import com.google.android.exoplayer2.trackselection.i;
import com.google.android.exoplayer2.trackselection.j;
import com.google.android.exoplayer2.z;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class l extends a implements j {

    /* renamed from: b  reason: collision with root package name */
    final j f32603b;

    /* renamed from: c  reason: collision with root package name */
    final Handler f32604c;

    /* renamed from: d  reason: collision with root package name */
    public final m f32605d;

    /* renamed from: e  reason: collision with root package name */
    public o f32606e;

    /* renamed from: f  reason: collision with root package name */
    boolean f32607f;

    /* renamed from: g  reason: collision with root package name */
    int f32608g;

    /* renamed from: h  reason: collision with root package name */
    int f32609h;

    /* renamed from: i  reason: collision with root package name */
    boolean f32610i;
    public int j;
    x k;
    public i l;
    w m;
    private final ab[] n;
    private final i o;
    private final Handler p;
    private final CopyOnWriteArrayList<a.C0528a> q;
    private final ah.a r;
    private final ArrayDeque<Runnable> s;
    private boolean t;
    private boolean u;
    private af v;
    private int w;
    private int x;
    private long y;

    public final z.c h() {
        return null;
    }

    public final z.b i() {
        return null;
    }

    public l(ab[] abVarArr, i iVar, q qVar, d dVar, b bVar, Looper looper) {
        ab[] abVarArr2 = abVarArr;
        StringBuilder sb = new StringBuilder("Init ");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" [ExoPlayerLib/2.10.5] [");
        sb.append(ae.f32503e);
        sb.append("]");
        com.google.android.exoplayer2.g.l.b();
        com.google.android.exoplayer2.g.a.b(abVarArr2.length > 0);
        this.n = (ab[]) com.google.android.exoplayer2.g.a.a(abVarArr);
        this.o = (i) com.google.android.exoplayer2.g.a.a(iVar);
        this.f32607f = false;
        this.f32609h = 0;
        this.f32610i = false;
        this.q = new CopyOnWriteArrayList<>();
        this.f32603b = new j(new ad[abVarArr2.length], new f[abVarArr2.length], (Object) null);
        this.r = new ah.a();
        this.k = x.f33726a;
        this.v = af.f31110e;
        this.f32608g = 0;
        this.f32604c = new Handler(looper) {
            public final void handleMessage(Message message) {
                l.this.a(message);
            }
        };
        this.m = w.a(0, this.f32603b);
        this.s = new ArrayDeque<>();
        this.f32605d = new m(abVarArr, iVar, this.f32603b, qVar, dVar, this.f32607f, this.f32609h, this.f32610i, this.f32604c, bVar);
        this.p = new Handler(this.f32605d.f32622b.getLooper());
    }

    public final Looper j() {
        return this.f32604c.getLooper();
    }

    public final void a(z.a aVar) {
        this.q.addIfAbsent(new a.C0528a(aVar));
    }

    public final void b(z.a aVar) {
        Iterator<a.C0528a> it2 = this.q.iterator();
        while (it2.hasNext()) {
            a.C0528a next = it2.next();
            if (next.f31071a.equals(aVar)) {
                next.f31072b = true;
                this.q.remove(next);
            }
        }
    }

    public final int k() {
        return this.m.f33722f;
    }

    public final int l() {
        return this.f32608g;
    }

    public final i m() {
        return this.l;
    }

    public final void a(o oVar, boolean z, boolean z2) {
        this.l = null;
        this.f32606e = oVar;
        w a2 = a(z, z2, 2);
        this.t = true;
        this.j++;
        this.f32605d.f32621a.a(z ? 1 : 0, z2 ? 1 : 0, oVar).sendToTarget();
        a(a2, false, 4, 1, false);
    }

    public final void a(boolean z) {
        a(z, 0);
    }

    public final void a(boolean z, int i2) {
        boolean a2 = a();
        boolean z2 = this.f32607f && this.f32608g == 0;
        boolean z3 = z && i2 == 0;
        if (z2 != z3) {
            this.f32605d.a(z3);
        }
        boolean z4 = this.f32607f != z;
        this.f32607f = z;
        this.f32608g = i2;
        boolean a3 = a();
        boolean z5 = a2 != a3;
        if (z4 || z5) {
            a((a.b) new a.b(z4, z, this.m.f33722f, z5, a3) {
                private final /* synthetic */ boolean f$0;
                private final /* synthetic */ boolean f$1;
                private final /* synthetic */ int f$2;
                private final /* synthetic */ boolean f$3;
                private final /* synthetic */ boolean f$4;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                    this.f$3 = r4;
                    this.f$4 = r5;
                }

                public final void invokeListener(z.a aVar) {
                    l.a(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, aVar);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a(boolean z, boolean z2, int i2, boolean z3, boolean z4, z.a aVar) {
        if (z) {
            aVar.a(i2);
        }
        if (z3) {
            aVar.b(z4);
        }
    }

    public final boolean n() {
        return this.f32607f;
    }

    public final void a(int i2) {
        if (this.f32609h != i2) {
            this.f32609h = i2;
            this.f32605d.f32621a.a(12, i2).sendToTarget();
            a((a.b) new a.b(i2) {
                private final /* synthetic */ int f$0;

                {
                    this.f$0 = r1;
                }

                public final void invokeListener(z.a aVar) {
                    aVar.b();
                }
            });
        }
    }

    public final int o() {
        return this.f32609h;
    }

    public final void b(boolean z) {
        if (this.f32610i != z) {
            this.f32610i = z;
            this.f32605d.f32621a.a(13, z ? 1 : 0).sendToTarget();
            a((a.b) new a.b(z) {
                private final /* synthetic */ boolean f$0;

                {
                    this.f$0 = r1;
                }

                public final void invokeListener(z.a aVar) {
                    aVar.c();
                }
            });
        }
    }

    public final boolean p() {
        return this.f32610i;
    }

    public final void a(int i2, long j2) {
        long j3;
        ah ahVar = this.m.f33717a;
        if (i2 < 0 || (!ahVar.a() && i2 >= ahVar.b())) {
            throw new p(ahVar, i2, j2);
        }
        this.u = true;
        this.j++;
        if (w()) {
            com.google.android.exoplayer2.g.l.c();
            this.f32604c.obtainMessage(0, 1, -1, this.m).sendToTarget();
            return;
        }
        this.w = i2;
        if (ahVar.a()) {
            this.y = j2 == -9223372036854775807L ? 0 : j2;
            this.x = 0;
        } else {
            if (j2 == -9223372036854775807L) {
                j3 = ahVar.a(i2, this.f31070a).f31136h;
            } else {
                j3 = c.b(j2);
            }
            long j4 = j3;
            Pair<Object, Long> a2 = ahVar.a(this.f31070a, this.r, i2, j4);
            this.y = c.a(j4);
            this.x = ahVar.a(a2.first);
        }
        this.f32605d.f32621a.a(3, (Object) new m.d(ahVar, i2, c.b(j2))).sendToTarget();
        a((a.b) $$Lambda$l$xv8x6V4T6_0tOQ5DeEw3QCG74.INSTANCE);
    }

    public final x q() {
        return this.k;
    }

    public final void r() {
        StringBuilder sb = new StringBuilder("Release ");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" [ExoPlayerLib/2.10.5] [");
        sb.append(ae.f32503e);
        sb.append("] [");
        sb.append(n.a());
        sb.append("]");
        com.google.android.exoplayer2.g.l.b();
        this.f32606e = null;
        this.f32605d.a();
        this.f32604c.removeCallbacksAndMessages((Object) null);
        this.m = a(false, false, 1);
    }

    public final aa a(aa.b bVar) {
        return new aa(this.f32605d, bVar, this.m.f33717a, s(), this.p);
    }

    private int E() {
        if (F()) {
            return this.x;
        }
        return this.m.f33717a.a(this.m.f33719c.f33224a);
    }

    public final int s() {
        if (F()) {
            return this.w;
        }
        return this.m.f33717a.a(this.m.f33719c.f33224a, this.r).f31125c;
    }

    public final long t() {
        if (!w()) {
            return g();
        }
        o.a aVar = this.m.f33719c;
        this.m.f33717a.a(aVar.f33224a, this.r);
        return c.a(this.r.c(aVar.f33225b, aVar.f33226c));
    }

    public final long u() {
        if (F()) {
            return this.y;
        }
        if (this.m.f33719c.a()) {
            return c.a(this.m.m);
        }
        return a(this.m.f33719c, this.m.m);
    }

    public final long v() {
        return c.a(this.m.l);
    }

    public final boolean w() {
        return !F() && this.m.f33719c.a();
    }

    public final int x() {
        if (w()) {
            return this.m.f33719c.f33225b;
        }
        return -1;
    }

    public final int y() {
        if (w()) {
            return this.m.f33719c.f33226c;
        }
        return -1;
    }

    public final long z() {
        if (!w()) {
            return u();
        }
        this.m.f33717a.a(this.m.f33719c.f33224a, this.r);
        if (this.m.f33721e == -9223372036854775807L) {
            return c.a(this.m.f33717a.a(s(), this.f31070a).f31136h);
        }
        return c.a(this.r.f31127e) + c.a(this.m.f33721e);
    }

    public final long A() {
        if (F()) {
            return this.y;
        }
        if (this.m.j.f33227d != this.m.f33719c.f33227d) {
            return c.a(this.m.f33717a.a(s(), this.f31070a).f31137i);
        }
        long j2 = this.m.k;
        if (this.m.j.a()) {
            ah.a a2 = this.m.f33717a.a(this.m.j.f33224a, this.r);
            long a3 = a2.a(this.m.j.f33225b);
            j2 = a3 == Long.MIN_VALUE ? a2.f31126d : a3;
        }
        return a(this.m.j, j2);
    }

    public final int b(int i2) {
        return this.n[i2].a();
    }

    public final TrackGroupArray B() {
        return this.m.f33724h;
    }

    public final g C() {
        return this.m.f33725i.f33511c;
    }

    public final ah D() {
        return this.m.f33717a;
    }

    /* access modifiers changed from: package-private */
    public final void a(Message message) {
        Message message2 = message;
        int i2 = message2.what;
        boolean z = true;
        if (i2 == 0) {
            w wVar = (w) message2.obj;
            int i3 = message2.arg1;
            if (message2.arg2 == -1) {
                z = false;
            }
            int i4 = message2.arg2;
            this.j -= i3;
            if (this.j == 0) {
                if (wVar.f33720d == -9223372036854775807L) {
                    o.a aVar = wVar.f33719c;
                    wVar = new w(wVar.f33717a, wVar.f33718b, aVar, 0, aVar.a() ? wVar.f33721e : -9223372036854775807L, wVar.f33722f, wVar.f33723g, wVar.f33724h, wVar.f33725i, aVar, 0, 0, 0);
                }
                if (!this.m.f33717a.a() && wVar.f33717a.a()) {
                    this.x = 0;
                    this.w = 0;
                    this.y = 0;
                }
                int i5 = this.t ? 0 : 2;
                boolean z2 = this.u;
                this.t = false;
                this.u = false;
                a(wVar, z, i4, i5, z2);
            }
        } else if (i2 == 1) {
            x xVar = (x) message2.obj;
            if (!this.k.equals(xVar)) {
                this.k = xVar;
                a((a.b) new a.b() {
                    public final void invokeListener(z.a aVar) {
                        aVar.e();
                    }
                });
            }
        } else if (i2 == 2) {
            i iVar = (i) message2.obj;
            this.l = iVar;
            a((a.b) new a.b() {
                public final void invokeListener(z.a aVar) {
                    aVar.a(i.this);
                }
            });
        } else {
            throw new IllegalStateException();
        }
    }

    public final w a(boolean z, boolean z2, int i2) {
        long j2;
        long j3 = 0;
        boolean z3 = false;
        if (z) {
            this.w = 0;
            this.x = 0;
            this.y = 0;
        } else {
            this.w = s();
            this.x = E();
            this.y = u();
        }
        if (z || z2) {
            z3 = true;
        }
        o.a a2 = z3 ? this.m.a(this.f32610i, this.f31070a) : this.m.f33719c;
        if (!z3) {
            j3 = this.m.m;
        }
        long j4 = j3;
        if (z3) {
            j2 = -9223372036854775807L;
        } else {
            j2 = this.m.f33721e;
        }
        return new w(z2 ? ah.f31122a : this.m.f33717a, z2 ? null : this.m.f33718b, a2, j4, j2, i2, false, z2 ? TrackGroupArray.f32783a : this.m.f33724h, z2 ? this.f32603b : this.m.f33725i, a2, j4, 0, j4);
    }

    public final void a(w wVar, boolean z, int i2, int i3, boolean z2) {
        boolean a2 = a();
        w wVar2 = this.m;
        this.m = wVar;
        a((Runnable) new a(wVar, wVar2, this.q, this.o, z, i2, i3, z2, this.f32607f, a2 != a()));
    }

    private void a(a.b bVar) {
        a((Runnable) new Runnable(new CopyOnWriteArrayList(this.q), bVar) {
            private final /* synthetic */ CopyOnWriteArrayList f$0;
            private final /* synthetic */ a.b f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                l.a((CopyOnWriteArrayList<a.C0528a>) this.f$0, this.f$1);
            }
        });
    }

    private void a(Runnable runnable) {
        boolean z = !this.s.isEmpty();
        this.s.addLast(runnable);
        if (!z) {
            while (!this.s.isEmpty()) {
                this.s.peekFirst().run();
                this.s.removeFirst();
            }
        }
    }

    private long a(o.a aVar, long j2) {
        long a2 = c.a(j2);
        this.m.f33717a.a(aVar.f33224a, this.r);
        return a2 + c.a(this.r.f31127e);
    }

    private boolean F() {
        return this.m.f33717a.a() || this.j > 0;
    }

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final w f32612a;

        /* renamed from: b  reason: collision with root package name */
        private final CopyOnWriteArrayList<a.C0528a> f32613b;

        /* renamed from: c  reason: collision with root package name */
        private final i f32614c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f32615d;

        /* renamed from: e  reason: collision with root package name */
        private final int f32616e;

        /* renamed from: f  reason: collision with root package name */
        private final int f32617f;

        /* renamed from: g  reason: collision with root package name */
        private final boolean f32618g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f32619h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f32620i;
        private final boolean j;
        private final boolean k;
        private final boolean l;
        private final boolean m;

        public a(w wVar, w wVar2, CopyOnWriteArrayList<a.C0528a> copyOnWriteArrayList, i iVar, boolean z, int i2, int i3, boolean z2, boolean z3, boolean z4) {
            this.f32612a = wVar;
            this.f32613b = new CopyOnWriteArrayList<>(copyOnWriteArrayList);
            this.f32614c = iVar;
            this.f32615d = z;
            this.f32616e = i2;
            this.f32617f = i3;
            this.f32618g = z2;
            this.l = z3;
            this.m = z4;
            boolean z5 = true;
            this.f32619h = wVar2.f33722f != wVar.f33722f;
            this.f32620i = (wVar2.f33717a == wVar.f33717a && wVar2.f33718b == wVar.f33718b) ? false : true;
            this.j = wVar2.f33723g != wVar.f33723g;
            this.k = wVar2.f33725i == wVar.f33725i ? false : z5;
        }

        public final void run() {
            if (this.f32620i || this.f32617f == 0) {
                l.a(this.f32613b, (a.b) new a.b() {
                    public final void invokeListener(z.a aVar) {
                        l.a.this.f(aVar);
                    }
                });
            }
            if (this.f32615d) {
                l.a(this.f32613b, (a.b) new a.b() {
                    public final void invokeListener(z.a aVar) {
                        l.a.this.e(aVar);
                    }
                });
            }
            if (this.k) {
                this.f32614c.a(this.f32612a.f33725i.f33512d);
                l.a(this.f32613b, (a.b) new a.b() {
                    public final void invokeListener(z.a aVar) {
                        l.a.this.d(aVar);
                    }
                });
            }
            if (this.j) {
                l.a(this.f32613b, (a.b) new a.b() {
                    public final void invokeListener(z.a aVar) {
                        l.a.this.c(aVar);
                    }
                });
            }
            if (this.f32619h) {
                l.a(this.f32613b, (a.b) new a.b() {
                    public final void invokeListener(z.a aVar) {
                        l.a.this.b(aVar);
                    }
                });
            }
            if (this.m) {
                l.a(this.f32613b, (a.b) new a.b() {
                    public final void invokeListener(z.a aVar) {
                        l.a.this.a(aVar);
                    }
                });
            }
            if (this.f32618g) {
                l.a(this.f32613b, (a.b) $$Lambda$VVrWTUCl9PpWKqEaDzOiWgsvgEQ.INSTANCE);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void f(z.a aVar) {
            aVar.a(this.f32612a.f33717a);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void e(z.a aVar) {
            aVar.d();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(z.a aVar) {
            aVar.a();
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(z.a aVar) {
            aVar.a(this.f32612a.f33723g);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void b(z.a aVar) {
            aVar.a(this.f32612a.f33722f);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(z.a aVar) {
            aVar.b(this.f32612a.f33722f == 3);
        }
    }

    /* access modifiers changed from: package-private */
    public static void a(CopyOnWriteArrayList<a.C0528a> copyOnWriteArrayList, a.b bVar) {
        Iterator<a.C0528a> it2 = copyOnWriteArrayList.iterator();
        while (it2.hasNext()) {
            a.C0528a next = it2.next();
            if (!next.f31072b) {
                bVar.invokeListener(next.f31071a);
            }
        }
    }
}
