package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.google.android.exoplayer2.ah;
import com.google.android.exoplayer2.f.ad;
import com.google.android.exoplayer2.f.i;
import com.google.android.exoplayer2.f.s;
import com.google.android.exoplayer2.f.w;
import com.google.android.exoplayer2.f.x;
import com.google.android.exoplayer2.f.y;
import com.google.android.exoplayer2.f.z;
import com.google.android.exoplayer2.g.ae;
import com.google.android.exoplayer2.g.l;
import com.google.android.exoplayer2.n;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.b.g;
import com.google.android.exoplayer2.source.dash.a;
import com.google.android.exoplayer2.source.dash.a.m;
import com.google.android.exoplayer2.source.dash.f;
import com.google.android.exoplayer2.source.dash.h;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class DashMediaSource extends com.google.android.exoplayer2.source.b {
    private final y A;
    private final Object B;
    private i C;
    /* access modifiers changed from: private */
    public x D;
    private ad E;
    private Uri F;
    private long G;

    /* renamed from: b  reason: collision with root package name */
    final w f32867b;

    /* renamed from: c  reason: collision with root package name */
    final p.a f32868c;

    /* renamed from: d  reason: collision with root package name */
    final Object f32869d;

    /* renamed from: e  reason: collision with root package name */
    final Runnable f32870e;
    /* access modifiers changed from: package-private */

    /* renamed from: f  reason: collision with root package name */
    public IOException f32871f;

    /* renamed from: g  reason: collision with root package name */
    Handler f32872g;

    /* renamed from: h  reason: collision with root package name */
    Uri f32873h;

    /* renamed from: i  reason: collision with root package name */
    com.google.android.exoplayer2.source.dash.a.b f32874i;
    boolean j;
    long k;
    long l;
    int m;
    long n;
    int o;
    private final boolean p;
    private final i.a q;
    private final a.C0547a r;
    private final com.google.android.exoplayer2.source.g s;
    private final long t;
    private final boolean u;
    private final z.a<? extends com.google.android.exoplayer2.source.dash.a.b> v;
    private final d w;
    private final SparseArray<c> x;
    private final Runnable y;
    private final h.b z;

    /* synthetic */ DashMediaSource(Uri uri, i.a aVar, z.a aVar2, a.C0547a aVar3, com.google.android.exoplayer2.source.g gVar, w wVar, long j2, boolean z2, Object obj, byte b2) {
        this(uri, aVar, aVar2, aVar3, gVar, wVar, j2, z2, obj);
    }

    static {
        n.a("goog.exo.dash");
    }

    public static final class Factory {

        /* renamed from: a  reason: collision with root package name */
        private final a.C0547a f32875a;

        /* renamed from: b  reason: collision with root package name */
        private final i.a f32876b;

        /* renamed from: c  reason: collision with root package name */
        private z.a<? extends com.google.android.exoplayer2.source.dash.a.b> f32877c;

        /* renamed from: d  reason: collision with root package name */
        private List<StreamKey> f32878d;

        /* renamed from: e  reason: collision with root package name */
        private com.google.android.exoplayer2.source.g f32879e;

        /* renamed from: f  reason: collision with root package name */
        private w f32880f;

        /* renamed from: g  reason: collision with root package name */
        private long f32881g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f32882h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f32883i;
        private Object j;

        public Factory(i.a aVar) {
            this(new f.a(aVar), aVar);
        }

        public Factory(a.C0547a aVar, i.a aVar2) {
            this.f32875a = (a.C0547a) com.google.android.exoplayer2.g.a.a(aVar);
            this.f32876b = aVar2;
            this.f32880f = new s();
            this.f32881g = 30000;
            this.f32879e = new com.google.android.exoplayer2.source.h();
        }

        public final Factory setStreamKeys(List<StreamKey> list) {
            com.google.android.exoplayer2.g.a.b(!this.f32883i);
            this.f32878d = list;
            return this;
        }

        public final DashMediaSource createMediaSource(Uri uri) {
            this.f32883i = true;
            if (this.f32877c == null) {
                this.f32877c = new com.google.android.exoplayer2.source.dash.a.c();
            }
            List<StreamKey> list = this.f32878d;
            if (list != null) {
                this.f32877c = new com.google.android.exoplayer2.offline.b(this.f32877c, list);
            }
            return new DashMediaSource((Uri) com.google.android.exoplayer2.g.a.a(uri), this.f32876b, this.f32877c, this.f32875a, this.f32879e, this.f32880f, this.f32881g, this.f32882h, this.j, (byte) 0);
        }
    }

    private DashMediaSource(Uri uri, i.a aVar, z.a<? extends com.google.android.exoplayer2.source.dash.a.b> aVar2, a.C0547a aVar3, com.google.android.exoplayer2.source.g gVar, w wVar, long j2, boolean z2, Object obj) {
        this.F = uri;
        this.f32874i = null;
        this.f32873h = uri;
        this.q = aVar;
        this.v = aVar2;
        this.r = aVar3;
        this.f32867b = wVar;
        this.t = j2;
        this.u = z2;
        this.s = gVar;
        this.B = obj;
        this.p = false;
        this.f32868c = a((o.a) null);
        this.f32869d = new Object();
        this.x = new SparseArray<>();
        this.z = new b(this, (byte) 0);
        this.n = -9223372036854775807L;
        if (this.p) {
            com.google.android.exoplayer2.g.a.b(!null.f32908d);
            this.w = null;
            this.y = null;
            this.f32870e = null;
            this.A = new y.a();
            return;
        }
        this.w = new d(this, (byte) 0);
        this.A = new e();
        this.y = new Runnable() {
            public final void run() {
                DashMediaSource.this.c();
            }
        };
        this.f32870e = new Runnable() {
            public final void run() {
                DashMediaSource.this.e();
            }
        };
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e() {
        a(false);
    }

    public final void a(ad adVar) {
        this.E = adVar;
        if (this.p) {
            a(false);
            return;
        }
        this.C = this.q.a();
        this.D = new x("Loader:DashMediaSource");
        this.f32872g = new Handler();
        c();
    }

    public final void b() throws IOException {
        this.A.a();
    }

    public final com.google.android.exoplayer2.source.n a(o.a aVar, com.google.android.exoplayer2.f.b bVar, long j2) {
        o.a aVar2 = aVar;
        int intValue = ((Integer) aVar2.f33224a).intValue() - this.o;
        long j3 = this.f32874i.a(intValue).f32934b;
        com.google.android.exoplayer2.g.a.a(aVar2 != null);
        c cVar = new c(this.o + intValue, this.f32874i, intValue, this.r, this.E, this.f32867b, this.f32800a.a(0, aVar2, j3), this.G, this.A, bVar, this.s, this.z);
        this.x.put(cVar.f32978a, cVar);
        return cVar;
    }

    public final void a(com.google.android.exoplayer2.source.n nVar) {
        c cVar = (c) nVar;
        h hVar = cVar.f32979b;
        hVar.f33028i = true;
        hVar.f33022c.removeCallbacksAndMessages((Object) null);
        for (com.google.android.exoplayer2.source.b.g<a> a2 : cVar.f32982e) {
            a2.a((g.b<a>) cVar);
        }
        cVar.f32981d = null;
        cVar.f32980c.b();
        this.x.remove(cVar.f32978a);
    }

    public final void a() {
        this.j = false;
        this.C = null;
        x xVar = this.D;
        if (xVar != null) {
            xVar.a((x.e) null);
            this.D = null;
        }
        this.k = 0;
        this.l = 0;
        this.f32874i = this.p ? this.f32874i : null;
        this.f32873h = this.F;
        this.f32871f = null;
        Handler handler = this.f32872g;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f32872g = null;
        }
        this.G = 0;
        this.m = 0;
        this.n = -9223372036854775807L;
        this.o = 0;
        this.x.clear();
    }

    /* access modifiers changed from: package-private */
    public final void a(z<?> zVar, long j2, long j3) {
        z<?> zVar2 = zVar;
        this.f32868c.b(zVar2.f32483a, zVar2.f32485c.f32354b, zVar2.f32485c.f32355c, zVar2.f32484b, j2, j3, zVar2.f32485c.f32353a);
    }

    /* access modifiers changed from: package-private */
    public final void a(m mVar, z.a<Long> aVar) {
        a(new z(this.C, Uri.parse(mVar.f32976b), 5, aVar), new g(this, (byte) 0), 1);
    }

    /* access modifiers changed from: package-private */
    public final void a(long j2) {
        this.G = j2;
        a(true);
    }

    /* access modifiers changed from: package-private */
    public final void a(IOException iOException) {
        l.b("Failed to resolve UtcTiming element.", iOException);
        a(true);
    }

    /* access modifiers changed from: package-private */
    public final void a(boolean z2) {
        long j2;
        boolean z3;
        long j3;
        long j4;
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            int keyAt = this.x.keyAt(i2);
            if (keyAt >= this.o) {
                this.x.valueAt(i2).a(this.f32874i, keyAt - this.o);
            }
        }
        int a2 = this.f32874i.a() - 1;
        f a3 = f.a(this.f32874i.a(0), this.f32874i.b(0));
        f a4 = f.a(this.f32874i.a(a2), this.f32874i.b(a2));
        long j5 = a3.f32897b;
        long j6 = a4.f32898c;
        if (!this.f32874i.f32908d || a4.f32896a) {
            j2 = j5;
            z3 = false;
        } else {
            j6 = Math.min((d() - com.google.android.exoplayer2.c.b(this.f32874i.f32905a)) - com.google.android.exoplayer2.c.b(this.f32874i.a(a2).f32934b), j6);
            if (this.f32874i.f32910f != -9223372036854775807L) {
                long b2 = j6 - com.google.android.exoplayer2.c.b(this.f32874i.f32910f);
                while (b2 < 0 && a2 > 0) {
                    a2--;
                    b2 += this.f32874i.b(a2);
                }
                if (a2 == 0) {
                    j4 = Math.max(j5, b2);
                } else {
                    j4 = this.f32874i.b(0);
                }
                j5 = j4;
            }
            j2 = j5;
            z3 = true;
        }
        long j7 = j6 - j2;
        for (int i3 = 0; i3 < this.f32874i.a() - 1; i3++) {
            j7 += this.f32874i.b(i3);
        }
        if (this.f32874i.f32908d) {
            long j8 = this.t;
            if (!this.u && this.f32874i.f32911g != -9223372036854775807L) {
                j8 = this.f32874i.f32911g;
            }
            long b3 = j7 - com.google.android.exoplayer2.c.b(j8);
            if (b3 < 5000000) {
                b3 = Math.min(5000000, j7 / 2);
            }
            j3 = b3;
        } else {
            j3 = 0;
        }
        a((ah) new a(this.f32874i.f32905a, this.f32874i.f32905a + this.f32874i.a(0).f32934b + com.google.android.exoplayer2.c.a(j2), this.o, j2, j7, j3, this.f32874i, this.B), (Object) this.f32874i);
        if (!this.p) {
            this.f32872g.removeCallbacks(this.f32870e);
            if (z3) {
                this.f32872g.postDelayed(this.f32870e, 5000);
            }
            if (this.j) {
                c();
            } else if (z2 && this.f32874i.f32908d && this.f32874i.f32909e != -9223372036854775807L) {
                long j9 = this.f32874i.f32909e;
                if (j9 == 0) {
                    j9 = 5000;
                }
                b(Math.max(0, (this.k + j9) - SystemClock.elapsedRealtime()));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(long j2) {
        this.f32872g.postDelayed(this.y, j2);
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        Uri uri;
        this.f32872g.removeCallbacks(this.y);
        if (!this.D.b()) {
            if (this.D.c()) {
                this.j = true;
                return;
            }
            synchronized (this.f32869d) {
                uri = this.f32873h;
            }
            this.j = false;
            a(new z(this.C, uri, 4, this.v), this.w, this.f32867b.a(4));
        }
    }

    private <T> void a(z<T> zVar, x.a<z<T>> aVar, int i2) {
        this.f32868c.a(zVar.f32483a, zVar.f32484b, this.D.a(zVar, aVar, i2));
    }

    private long d() {
        if (this.G != 0) {
            return com.google.android.exoplayer2.c.b(SystemClock.elapsedRealtime() + this.G);
        }
        return com.google.android.exoplayer2.c.b(System.currentTimeMillis());
    }

    static final class f {

        /* renamed from: a  reason: collision with root package name */
        public final boolean f32896a;

        /* renamed from: b  reason: collision with root package name */
        public final long f32897b;

        /* renamed from: c  reason: collision with root package name */
        public final long f32898c;

        public static f a(com.google.android.exoplayer2.source.dash.a.f fVar, long j) {
            boolean z;
            int i2;
            boolean z2;
            com.google.android.exoplayer2.source.dash.a.f fVar2 = fVar;
            long j2 = j;
            int size = fVar2.f32935c.size();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i4 >= size) {
                    z = false;
                    break;
                }
                int i5 = fVar2.f32935c.get(i4).f32901b;
                if (i5 == 1 || i5 == 2) {
                    z = true;
                } else {
                    i4++;
                }
            }
            long j3 = Long.MAX_VALUE;
            int i6 = 0;
            boolean z3 = false;
            boolean z4 = false;
            long j4 = 0;
            while (i6 < size) {
                com.google.android.exoplayer2.source.dash.a.a aVar = fVar2.f32935c.get(i6);
                if (!z || aVar.f32901b != 3) {
                    d d2 = aVar.f32902c.get(i3).d();
                    if (d2 == null) {
                        return new f(true, 0, j);
                    }
                    boolean b2 = d2.b() | z4;
                    int c2 = d2.c(j2);
                    if (c2 == 0) {
                        i2 = size;
                        z2 = z;
                        z4 = b2;
                        z3 = true;
                        j4 = 0;
                        j3 = 0;
                    } else {
                        if (!z3) {
                            z2 = z;
                            long a2 = d2.a();
                            i2 = size;
                            long max = Math.max(j4, d2.a(a2));
                            if (c2 != -1) {
                                long j5 = (a2 + ((long) c2)) - 1;
                                j4 = max;
                                j3 = Math.min(j3, d2.a(j5) + d2.b(j5, j2));
                            } else {
                                j4 = max;
                            }
                        } else {
                            i2 = size;
                            z2 = z;
                        }
                        z4 = b2;
                    }
                } else {
                    i2 = size;
                    z2 = z;
                }
                i6++;
                i3 = 0;
                fVar2 = fVar;
                z = z2;
                size = i2;
            }
            return new f(z4, j4, j3);
        }

        private f(boolean z, long j, long j2) {
            this.f32896a = z;
            this.f32897b = j;
            this.f32898c = j2;
        }
    }

    static final class a extends ah {

        /* renamed from: b  reason: collision with root package name */
        private final long f32884b;

        /* renamed from: c  reason: collision with root package name */
        private final long f32885c;

        /* renamed from: d  reason: collision with root package name */
        private final int f32886d;

        /* renamed from: e  reason: collision with root package name */
        private final long f32887e;

        /* renamed from: f  reason: collision with root package name */
        private final long f32888f;

        /* renamed from: g  reason: collision with root package name */
        private final long f32889g;

        /* renamed from: h  reason: collision with root package name */
        private final com.google.android.exoplayer2.source.dash.a.b f32890h;

        /* renamed from: i  reason: collision with root package name */
        private final Object f32891i;

        public final int b() {
            return 1;
        }

        public a(long j, long j2, int i2, long j3, long j4, long j5, com.google.android.exoplayer2.source.dash.a.b bVar, Object obj) {
            this.f32884b = j;
            this.f32885c = j2;
            this.f32886d = i2;
            this.f32887e = j3;
            this.f32888f = j4;
            this.f32889g = j5;
            this.f32890h = bVar;
            this.f32891i = obj;
        }

        public final int c() {
            return this.f32890h.a();
        }

        /* JADX WARNING: Removed duplicated region for block: B:28:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00a1  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x00ba  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x00bd  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.google.android.exoplayer2.ah.b a(int r32, com.google.android.exoplayer2.ah.b r33, boolean r34, long r35) {
            /*
                r31 = this;
                r0 = r31
                r1 = 1
                r2 = r32
                com.google.android.exoplayer2.g.a.a((int) r2, (int) r1)
                long r2 = r0.f32889g
                com.google.android.exoplayer2.source.dash.a.b r4 = r0.f32890h
                boolean r4 = r4.f32908d
                r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                r7 = 0
                if (r4 != 0) goto L_0x001a
            L_0x0016:
                r24 = r2
                goto L_0x009c
            L_0x001a:
                r8 = 0
                int r4 = (r35 > r8 ? 1 : (r35 == r8 ? 0 : -1))
                if (r4 <= 0) goto L_0x002c
                long r2 = r2 + r35
                long r8 = r0.f32888f
                int r4 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
                if (r4 <= 0) goto L_0x002c
                r24 = r5
                goto L_0x009c
            L_0x002c:
                long r8 = r0.f32887e
                long r8 = r8 + r2
                com.google.android.exoplayer2.source.dash.a.b r4 = r0.f32890h
                long r10 = r4.b(r7)
                r4 = 0
            L_0x0036:
                com.google.android.exoplayer2.source.dash.a.b r12 = r0.f32890h
                int r12 = r12.a()
                int r12 = r12 - r1
                if (r4 >= r12) goto L_0x004d
                int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r12 < 0) goto L_0x004d
                long r8 = r8 - r10
                int r4 = r4 + 1
                com.google.android.exoplayer2.source.dash.a.b r10 = r0.f32890h
                long r10 = r10.b(r4)
                goto L_0x0036
            L_0x004d:
                com.google.android.exoplayer2.source.dash.a.b r12 = r0.f32890h
                com.google.android.exoplayer2.source.dash.a.f r4 = r12.a((int) r4)
                java.util.List<com.google.android.exoplayer2.source.dash.a.a> r12 = r4.f32935c
                int r12 = r12.size()
                r13 = 0
            L_0x005a:
                r14 = -1
                if (r13 >= r12) goto L_0x006f
                java.util.List<com.google.android.exoplayer2.source.dash.a.a> r15 = r4.f32935c
                java.lang.Object r15 = r15.get(r13)
                com.google.android.exoplayer2.source.dash.a.a r15 = (com.google.android.exoplayer2.source.dash.a.a) r15
                int r15 = r15.f32901b
                r1 = 2
                if (r15 != r1) goto L_0x006b
                goto L_0x0070
            L_0x006b:
                int r13 = r13 + 1
                r1 = 1
                goto L_0x005a
            L_0x006f:
                r13 = -1
            L_0x0070:
                if (r13 != r14) goto L_0x0073
                goto L_0x0016
            L_0x0073:
                java.util.List<com.google.android.exoplayer2.source.dash.a.a> r1 = r4.f32935c
                java.lang.Object r1 = r1.get(r13)
                com.google.android.exoplayer2.source.dash.a.a r1 = (com.google.android.exoplayer2.source.dash.a.a) r1
                java.util.List<com.google.android.exoplayer2.source.dash.a.i> r1 = r1.f32902c
                java.lang.Object r1 = r1.get(r7)
                com.google.android.exoplayer2.source.dash.a.i r1 = (com.google.android.exoplayer2.source.dash.a.i) r1
                com.google.android.exoplayer2.source.dash.d r1 = r1.d()
                if (r1 == 0) goto L_0x0016
                int r4 = r1.c(r10)
                if (r4 != 0) goto L_0x0090
                goto L_0x0016
            L_0x0090:
                long r10 = r1.a(r8, r10)
                long r10 = r1.a(r10)
                long r2 = r2 + r10
                long r2 = r2 - r8
                goto L_0x0016
            L_0x009c:
                if (r34 == 0) goto L_0x00a1
                java.lang.Object r1 = r0.f32891i
                goto L_0x00a2
            L_0x00a1:
                r1 = 0
            L_0x00a2:
                r17 = r1
                com.google.android.exoplayer2.source.dash.a.b r1 = r0.f32890h
                boolean r1 = r1.f32908d
                if (r1 == 0) goto L_0x00bd
                com.google.android.exoplayer2.source.dash.a.b r1 = r0.f32890h
                long r1 = r1.f32909e
                int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                if (r3 == 0) goto L_0x00bd
                com.google.android.exoplayer2.source.dash.a.b r1 = r0.f32890h
                long r1 = r1.f32906b
                int r3 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
                if (r3 != 0) goto L_0x00bd
                r23 = 1
                goto L_0x00bf
            L_0x00bd:
                r23 = 0
            L_0x00bf:
                long r1 = r0.f32884b
                long r3 = r0.f32885c
                r22 = 1
                long r5 = r0.f32888f
                com.google.android.exoplayer2.source.dash.a.b r7 = r0.f32890h
                int r7 = r7.a()
                r8 = 1
                int r28 = r7 + -1
                long r7 = r0.f32887e
                r16 = r33
                r18 = r1
                r20 = r3
                r26 = r5
                r29 = r7
                com.google.android.exoplayer2.ah$b r1 = r16.a(r17, r18, r20, r22, r23, r24, r26, r28, r29)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.a.a(int, com.google.android.exoplayer2.ah$b, boolean, long):com.google.android.exoplayer2.ah$b");
        }

        public final int a(Object obj) {
            int intValue;
            if ((obj instanceof Integer) && (intValue = ((Integer) obj).intValue() - this.f32886d) >= 0 && intValue < this.f32890h.a()) {
                return intValue;
            }
            return -1;
        }

        public final ah.a a(int i2, ah.a aVar, boolean z) {
            com.google.android.exoplayer2.g.a.a(i2, this.f32890h.a());
            Integer num = null;
            String str = z ? this.f32890h.a(i2).f32933a : null;
            if (z) {
                num = Integer.valueOf(this.f32886d + i2);
            }
            return aVar.a(str, num, this.f32890h.b(i2), com.google.android.exoplayer2.c.b(this.f32890h.a(i2).f32934b - this.f32890h.a(0).f32934b) - this.f32887e);
        }

        public final Object a(int i2) {
            com.google.android.exoplayer2.g.a.a(i2, this.f32890h.a());
            return Integer.valueOf(this.f32886d + i2);
        }
    }

    final class b implements h.b {
        private b() {
        }

        /* synthetic */ b(DashMediaSource dashMediaSource, byte b2) {
            this();
        }

        public final void a() {
            DashMediaSource dashMediaSource = DashMediaSource.this;
            dashMediaSource.f32872g.removeCallbacks(dashMediaSource.f32870e);
            dashMediaSource.c();
        }

        public final void a(long j) {
            DashMediaSource dashMediaSource = DashMediaSource.this;
            if (dashMediaSource.n == -9223372036854775807L || dashMediaSource.n < j) {
                dashMediaSource.n = j;
            }
        }
    }

    final class d implements x.a<z<com.google.android.exoplayer2.source.dash.a.b>> {
        private d() {
        }

        /* synthetic */ d(DashMediaSource dashMediaSource, byte b2) {
            this();
        }

        public final /* bridge */ /* synthetic */ x.b a(x.d dVar, long j, long j2, IOException iOException, int i2) {
            x.b bVar;
            z zVar = (z) dVar;
            DashMediaSource dashMediaSource = DashMediaSource.this;
            long a2 = dashMediaSource.f32867b.a(iOException, i2);
            if (a2 == -9223372036854775807L) {
                bVar = x.f32467d;
            } else {
                bVar = x.a(false, a2);
            }
            dashMediaSource.f32868c.a(zVar.f32483a, zVar.f32485c.f32354b, zVar.f32485c.f32355c, zVar.f32484b, j, j2, zVar.f32485c.f32353a, iOException, !bVar.a());
            return bVar;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0092  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00ba  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final /* synthetic */ void a(com.google.android.exoplayer2.f.x.d r17, long r18, long r20) {
            /*
                r16 = this;
                r12 = r18
                r0 = r17
                com.google.android.exoplayer2.f.z r0 = (com.google.android.exoplayer2.f.z) r0
                r14 = r16
                com.google.android.exoplayer2.source.dash.DashMediaSource r15 = com.google.android.exoplayer2.source.dash.DashMediaSource.this
                com.google.android.exoplayer2.source.p$a r1 = r15.f32868c
                com.google.android.exoplayer2.f.l r2 = r0.f32483a
                com.google.android.exoplayer2.f.ab r3 = r0.f32485c
                android.net.Uri r3 = r3.f32354b
                com.google.android.exoplayer2.f.ab r4 = r0.f32485c
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> r4 = r4.f32355c
                int r5 = r0.f32484b
                com.google.android.exoplayer2.f.ab r6 = r0.f32485c
                long r10 = r6.f32353a
                r6 = r18
                r8 = r20
                r1.a(r2, r3, r4, r5, r6, r8, r10)
                T r1 = r0.f32486d
                com.google.android.exoplayer2.source.dash.a.b r1 = (com.google.android.exoplayer2.source.dash.a.b) r1
                com.google.android.exoplayer2.source.dash.a.b r2 = r15.f32874i
                r3 = 0
                if (r2 != 0) goto L_0x002e
                r2 = 0
                goto L_0x0034
            L_0x002e:
                com.google.android.exoplayer2.source.dash.a.b r2 = r15.f32874i
                int r2 = r2.a()
            L_0x0034:
                com.google.android.exoplayer2.source.dash.a.f r4 = r1.a((int) r3)
                long r4 = r4.f32934b
                r6 = 0
            L_0x003b:
                if (r6 >= r2) goto L_0x004c
                com.google.android.exoplayer2.source.dash.a.b r7 = r15.f32874i
                com.google.android.exoplayer2.source.dash.a.f r7 = r7.a((int) r6)
                long r7 = r7.f32934b
                int r9 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
                if (r9 >= 0) goto L_0x004c
                int r6 = r6 + 1
                goto L_0x003b
            L_0x004c:
                boolean r4 = r1.f32908d
                r5 = 1
                if (r4 == 0) goto L_0x00bc
                int r4 = r2 - r6
                int r7 = r1.a()
                if (r4 <= r7) goto L_0x005e
                com.google.android.exoplayer2.g.l.c()
            L_0x005c:
                r4 = 1
                goto L_0x0090
            L_0x005e:
                long r7 = r15.n
                r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r4 == 0) goto L_0x008f
                long r7 = r1.f32912h
                r9 = 1000(0x3e8, double:4.94E-321)
                long r7 = r7 * r9
                long r9 = r15.n
                int r4 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                if (r4 > 0) goto L_0x008f
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                java.lang.String r7 = "Loaded stale dynamic manifest: "
                r4.<init>(r7)
                long r7 = r1.f32912h
                r4.append(r7)
                java.lang.String r7 = ", "
                r4.append(r7)
                long r7 = r15.n
                r4.append(r7)
                com.google.android.exoplayer2.g.l.c()
                goto L_0x005c
            L_0x008f:
                r4 = 0
            L_0x0090:
                if (r4 == 0) goto L_0x00ba
                int r1 = r15.m
                int r2 = r1 + 1
                r15.m = r2
                com.google.android.exoplayer2.f.w r2 = r15.f32867b
                int r0 = r0.f32484b
                int r0 = r2.a((int) r0)
                if (r1 >= r0) goto L_0x00b2
                int r0 = r15.m
                int r0 = r0 - r5
                int r0 = r0 * 1000
                r1 = 5000(0x1388, float:7.006E-42)
                int r0 = java.lang.Math.min(r0, r1)
                long r0 = (long) r0
                r15.b((long) r0)
                return
            L_0x00b2:
                com.google.android.exoplayer2.source.dash.b r0 = new com.google.android.exoplayer2.source.dash.b
                r0.<init>()
                r15.f32871f = r0
                return
            L_0x00ba:
                r15.m = r3
            L_0x00bc:
                r15.f32874i = r1
                boolean r1 = r15.j
                com.google.android.exoplayer2.source.dash.a.b r4 = r15.f32874i
                boolean r4 = r4.f32908d
                r1 = r1 & r4
                r15.j = r1
                long r7 = r12 - r20
                r15.k = r7
                r15.l = r12
                com.google.android.exoplayer2.source.dash.a.b r1 = r15.f32874i
                android.net.Uri r1 = r1.j
                if (r1 == 0) goto L_0x00ee
                java.lang.Object r1 = r15.f32869d
                monitor-enter(r1)
                com.google.android.exoplayer2.f.l r0 = r0.f32483a     // Catch:{ all -> 0x00eb }
                android.net.Uri r0 = r0.f32395a     // Catch:{ all -> 0x00eb }
                android.net.Uri r4 = r15.f32873h     // Catch:{ all -> 0x00eb }
                if (r0 != r4) goto L_0x00e0
                r0 = 1
                goto L_0x00e1
            L_0x00e0:
                r0 = 0
            L_0x00e1:
                if (r0 == 0) goto L_0x00e9
                com.google.android.exoplayer2.source.dash.a.b r0 = r15.f32874i     // Catch:{ all -> 0x00eb }
                android.net.Uri r0 = r0.j     // Catch:{ all -> 0x00eb }
                r15.f32873h = r0     // Catch:{ all -> 0x00eb }
            L_0x00e9:
                monitor-exit(r1)     // Catch:{ all -> 0x00eb }
                goto L_0x00ee
            L_0x00eb:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00eb }
                throw r0
            L_0x00ee:
                if (r2 != 0) goto L_0x016e
                com.google.android.exoplayer2.source.dash.a.b r0 = r15.f32874i
                boolean r0 = r0.f32908d
                if (r0 == 0) goto L_0x016a
                com.google.android.exoplayer2.source.dash.a.b r0 = r15.f32874i
                com.google.android.exoplayer2.source.dash.a.m r0 = r0.f32913i
                if (r0 == 0) goto L_0x016a
                com.google.android.exoplayer2.source.dash.a.b r0 = r15.f32874i
                com.google.android.exoplayer2.source.dash.a.m r0 = r0.f32913i
                java.lang.String r1 = r0.f32975a
                java.lang.String r2 = "urn:mpeg:dash:utc:direct:2014"
                boolean r2 = com.google.android.exoplayer2.g.ae.a((java.lang.Object) r1, (java.lang.Object) r2)
                if (r2 != 0) goto L_0x0158
                java.lang.String r2 = "urn:mpeg:dash:utc:direct:2012"
                boolean r2 = com.google.android.exoplayer2.g.ae.a((java.lang.Object) r1, (java.lang.Object) r2)
                if (r2 == 0) goto L_0x0115
                goto L_0x0158
            L_0x0115:
                java.lang.String r2 = "urn:mpeg:dash:utc:http-iso:2014"
                boolean r2 = com.google.android.exoplayer2.g.ae.a((java.lang.Object) r1, (java.lang.Object) r2)
                if (r2 != 0) goto L_0x014f
                java.lang.String r2 = "urn:mpeg:dash:utc:http-iso:2012"
                boolean r2 = com.google.android.exoplayer2.g.ae.a((java.lang.Object) r1, (java.lang.Object) r2)
                if (r2 == 0) goto L_0x0128
                goto L_0x014f
            L_0x0128:
                java.lang.String r2 = "urn:mpeg:dash:utc:http-xsdate:2014"
                boolean r2 = com.google.android.exoplayer2.g.ae.a((java.lang.Object) r1, (java.lang.Object) r2)
                if (r2 != 0) goto L_0x0146
                java.lang.String r2 = "urn:mpeg:dash:utc:http-xsdate:2012"
                boolean r1 = com.google.android.exoplayer2.g.ae.a((java.lang.Object) r1, (java.lang.Object) r2)
                if (r1 == 0) goto L_0x013b
                goto L_0x0146
            L_0x013b:
                java.io.IOException r0 = new java.io.IOException
                java.lang.String r1 = "Unsupported UTC timing scheme"
                r0.<init>(r1)
                r15.a((java.io.IOException) r0)
                return
            L_0x0146:
                com.google.android.exoplayer2.source.dash.DashMediaSource$h r1 = new com.google.android.exoplayer2.source.dash.DashMediaSource$h
                r1.<init>(r3)
                r15.a(r0, r1)
                return
            L_0x014f:
                com.google.android.exoplayer2.source.dash.DashMediaSource$c r1 = new com.google.android.exoplayer2.source.dash.DashMediaSource$c
                r1.<init>()
                r15.a(r0, r1)
                return
            L_0x0158:
                java.lang.String r0 = r0.f32976b     // Catch:{ v -> 0x0165 }
                long r0 = com.google.android.exoplayer2.g.ae.g(r0)     // Catch:{ v -> 0x0165 }
                long r2 = r15.l     // Catch:{ v -> 0x0165 }
                long r0 = r0 - r2
                r15.a((long) r0)     // Catch:{ v -> 0x0165 }
                return
            L_0x0165:
                r0 = move-exception
                r15.a((java.io.IOException) r0)
                return
            L_0x016a:
                r15.a((boolean) r5)
                return
            L_0x016e:
                int r0 = r15.o
                int r0 = r0 + r6
                r15.o = r0
                r15.a((boolean) r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.dash.DashMediaSource.d.a(com.google.android.exoplayer2.f.x$d, long, long):void");
        }

        public final /* bridge */ /* synthetic */ void a(x.d dVar, long j, long j2, boolean z) {
            DashMediaSource.this.a((z<?>) (z) dVar, j, j2);
        }
    }

    final class g implements x.a<z<Long>> {
        private g() {
        }

        /* synthetic */ g(DashMediaSource dashMediaSource, byte b2) {
            this();
        }

        public final /* bridge */ /* synthetic */ x.b a(x.d dVar, long j, long j2, IOException iOException, int i2) {
            z zVar = (z) dVar;
            DashMediaSource dashMediaSource = DashMediaSource.this;
            dashMediaSource.f32868c.a(zVar.f32483a, zVar.f32485c.f32354b, zVar.f32485c.f32355c, zVar.f32484b, j, j2, zVar.f32485c.f32353a, iOException, true);
            dashMediaSource.a(iOException);
            return x.f32466c;
        }

        public final /* synthetic */ void a(x.d dVar, long j, long j2) {
            z zVar = (z) dVar;
            DashMediaSource dashMediaSource = DashMediaSource.this;
            dashMediaSource.f32868c.a(zVar.f32483a, zVar.f32485c.f32354b, zVar.f32485c.f32355c, zVar.f32484b, j, j2, zVar.f32485c.f32353a);
            dashMediaSource.a(((Long) zVar.f32486d).longValue() - j);
        }

        public final /* bridge */ /* synthetic */ void a(x.d dVar, long j, long j2, boolean z) {
            DashMediaSource.this.a((z<?>) (z) dVar, j, j2);
        }
    }

    static final class h implements z.a<Long> {
        private h() {
        }

        /* synthetic */ h(byte b2) {
            this();
        }

        public final /* synthetic */ Object a(Uri uri, InputStream inputStream) throws IOException {
            return Long.valueOf(ae.g(new BufferedReader(new InputStreamReader(inputStream)).readLine()));
        }
    }

    static final class c implements z.a<Long> {

        /* renamed from: a  reason: collision with root package name */
        private static final Pattern f32893a = Pattern.compile("(.+?)(Z|((\\+|-|−)(\\d\\d)(:?(\\d\\d))?))");

        c() {
        }

        public final /* bridge */ /* synthetic */ Object a(Uri uri, InputStream inputStream) throws IOException {
            return a(inputStream);
        }

        private static Long a(InputStream inputStream) throws IOException {
            String readLine = new BufferedReader(new InputStreamReader(inputStream, Charset.forName(AppConstants.UTF_8))).readLine();
            try {
                Matcher matcher = f32893a.matcher(readLine);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                    long time = simpleDateFormat.parse(group).getTime();
                    if (!"Z".equals(matcher.group(2))) {
                        long j = "+".equals(matcher.group(4)) ? 1 : -1;
                        long parseLong = Long.parseLong(matcher.group(5));
                        String group2 = matcher.group(7);
                        time -= j * ((((parseLong * 60) + (TextUtils.isEmpty(group2) ? 0 : Long.parseLong(group2))) * 60) * 1000);
                    }
                    return Long.valueOf(time);
                }
                throw new v("Couldn't parse timestamp: ".concat(String.valueOf(readLine)));
            } catch (ParseException e2) {
                throw new v((Throwable) e2);
            }
        }
    }

    final class e implements y {
        e() {
        }

        public final void a() throws IOException {
            x unused = DashMediaSource.this.D;
            if (DashMediaSource.this.f32871f != null) {
                throw DashMediaSource.this.f32871f;
            }
        }
    }
}
