package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.c.c;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.ag;
import com.google.android.gms.internal.measurement.aj;
import com.google.android.gms.internal.measurement.dv;
import com.google.android.gms.internal.measurement.jg;
import com.google.android.gms.internal.measurement.jh;
import com.google.android.gms.internal.measurement.jz;
import com.google.android.gms.internal.measurement.zzv;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.views.cutomeviews.CropImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.OverlappingFileLockException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import net.one97.paytm.dynamic.module.movie.EventsModuleManager;

public class jj implements fv {

    /* renamed from: f  reason: collision with root package name */
    private static volatile jj f12264f;

    /* renamed from: a  reason: collision with root package name */
    hg f12265a;

    /* renamed from: b  reason: collision with root package name */
    final fc f12266b;

    /* renamed from: c  reason: collision with root package name */
    List<Runnable> f12267c;

    /* renamed from: d  reason: collision with root package name */
    int f12268d;

    /* renamed from: e  reason: collision with root package name */
    int f12269e;

    /* renamed from: g  reason: collision with root package name */
    private ev f12270g;

    /* renamed from: h  reason: collision with root package name */
    private ec f12271h;

    /* renamed from: i  reason: collision with root package name */
    private d f12272i;
    private ef j;
    private jf k;
    private jv l;
    private final jn m;
    private boolean n;
    private boolean o;
    private boolean p;
    private long q;
    private boolean r;
    private boolean s;
    private boolean t;
    private FileLock u;
    private FileChannel v;
    private List<Long> w;
    private List<Long> x;
    private long y;

    class a implements f {

        /* renamed from: a  reason: collision with root package name */
        aj.g f12273a;

        /* renamed from: b  reason: collision with root package name */
        List<Long> f12274b;

        /* renamed from: c  reason: collision with root package name */
        List<aj.c> f12275c;

        /* renamed from: d  reason: collision with root package name */
        private long f12276d;

        private a() {
        }

        public final void a(aj.g gVar) {
            s.a(gVar);
            this.f12273a = gVar;
        }

        public final boolean a(long j, aj.c cVar) {
            s.a(cVar);
            if (this.f12275c == null) {
                this.f12275c = new ArrayList();
            }
            if (this.f12274b == null) {
                this.f12274b = new ArrayList();
            }
            if (this.f12275c.size() > 0 && a(this.f12275c.get(0)) != a(cVar)) {
                return false;
            }
            long n = this.f12276d + ((long) cVar.n());
            if (n >= ((long) Math.max(0, o.f12354i.a(null).intValue()))) {
                return false;
            }
            this.f12276d = n;
            this.f12275c.add(cVar);
            this.f12274b.add(Long.valueOf(j));
            if (this.f12275c.size() >= Math.max(1, o.j.a(null).intValue())) {
                return false;
            }
            return true;
        }

        /* synthetic */ a(jj jjVar, byte b2) {
            this();
        }

        private static long a(aj.c cVar) {
            return ((cVar.zzf / 1000) / 60) / 60;
        }
    }

    public static jj a(Context context) {
        s.a(context);
        s.a(context.getApplicationContext());
        if (f12264f == null) {
            synchronized (jj.class) {
                if (f12264f == null) {
                    f12264f = new jj(new jo(context));
                }
            }
        }
        return f12264f;
    }

    private jj(jo joVar) {
        this(joVar, (byte) 0);
    }

    private jj(jo joVar, byte b2) {
        this.n = false;
        s.a(joVar);
        this.f12266b = fc.a(joVar.f12283a, (zzv) null);
        this.y = -1;
        jn jnVar = new jn(this);
        jnVar.x();
        this.m = jnVar;
        ec ecVar = new ec(this);
        ecVar.x();
        this.f12271h = ecVar;
        ev evVar = new ev(this);
        evVar.x();
        this.f12270g = evVar;
        this.f12266b.K_().a((Runnable) new ji(this, joVar));
    }

    public final dy J_() {
        return this.f12266b.J_();
    }

    public final eu K_() {
        return this.f12266b.K_();
    }

    public final ev a() {
        a((jg) this.f12270g);
        return this.f12270g;
    }

    public final ec b() {
        a((jg) this.f12271h);
        return this.f12271h;
    }

    public final d c() {
        a((jg) this.f12272i);
        return this.f12272i;
    }

    private final ef m() {
        ef efVar = this.j;
        if (efVar != null) {
            return efVar;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    private final jf p() {
        a((jg) this.k);
        return this.k;
    }

    public final jv d() {
        a((jg) this.l);
        return this.l;
    }

    public final jn e() {
        a((jg) this.m);
        return this.m;
    }

    public final Context k() {
        return this.f12266b.k();
    }

    public final e j() {
        return this.f12266b.j();
    }

    /* access modifiers changed from: package-private */
    public final void f() {
        this.f12266b.K_().h();
    }

    /* access modifiers changed from: package-private */
    public final void g() {
        if (!this.n) {
            throw new IllegalStateException("UploadController is not initialized");
        }
    }

    static void a(jg jgVar) {
        if (jgVar == null) {
            throw new IllegalStateException("Upload Component not created");
        } else if (!jgVar.v()) {
            String valueOf = String.valueOf(jgVar.getClass());
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("Component not initialized: ");
            sb.append(valueOf);
            throw new IllegalStateException(sb.toString());
        }
    }

    private final long q() {
        long a2 = this.f12266b.j().a();
        eh b2 = this.f12266b.b();
        b2.w();
        b2.h();
        long a3 = b2.f11865h.a();
        if (a3 == 0) {
            a3 = 1 + ((long) b2.L_().d().nextInt(86400000));
            b2.f11865h.a(a3);
        }
        return ((((a2 + a3) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public final void a(zzan zzan, String str) {
        zzan zzan2 = zzan;
        fb b2 = c().b(str);
        if (b2 == null || TextUtils.isEmpty(b2.k())) {
            this.f12266b.J_().j.a("No app data available; dropping event", str);
            return;
        }
        Boolean b3 = b(b2);
        if (b3 == null) {
            if (!"_ui".equals(zzan2.f12368a)) {
                this.f12266b.J_().f11831f.a("Could not find package. appId", dy.a(str));
            }
        } else if (!b3.booleanValue()) {
            this.f12266b.J_().f11828c.a("App version does not match; dropping event. appId", dy.a(str));
            return;
        }
        String d2 = b2.d();
        String k2 = b2.k();
        long l2 = b2.l();
        String m2 = b2.m();
        long n2 = b2.n();
        long o2 = b2.o();
        boolean q2 = b2.q();
        String h2 = b2.h();
        long w2 = b2.w();
        boolean x2 = b2.x();
        boolean y2 = b2.y();
        String e2 = b2.e();
        Boolean z = b2.z();
        long p2 = b2.p();
        List<String> A = b2.A();
        jz.a();
        zzm zzm = r2;
        zzm zzm2 = new zzm(str, d2, k2, l2, m2, n2, o2, (String) null, q2, false, h2, w2, 0, 0, x2, y2, false, e2, z, p2, A, this.f12266b.f11945e.d(b2.b(), o.aC) ? b2.f() : null);
        a(zzan2, zzm);
    }

    /* access modifiers changed from: package-private */
    public final void a(zzan zzan, zzm zzm) {
        List<zzv> list;
        List<zzv> list2;
        List<zzv> list3;
        zzan zzan2 = zzan;
        zzm zzm2 = zzm;
        s.a(zzm);
        s.a(zzm2.f12380a);
        f();
        g();
        String str = zzm2.f12380a;
        long j2 = zzan2.f12371d;
        if (e().a(zzan2, zzm2)) {
            if (!zzm2.f12387h) {
                c(zzm2);
                return;
            }
            if (this.f12266b.f11945e.d(str, o.ak) && zzm2.u != null) {
                if (zzm2.u.contains(zzan2.f12368a)) {
                    Bundle a2 = zzan2.f12369b.a();
                    a2.putLong("ga_safelisted", 1);
                    zzan2 = new zzan(zzan2.f12368a, new zzam(a2), zzan2.f12370c, zzan2.f12371d);
                } else {
                    this.f12266b.J_().j.a("Dropping non-safelisted event. appId, event name, origin", str, zzan2.f12368a, zzan2.f12370c);
                    return;
                }
            }
            c().b();
            try {
                d c2 = c();
                s.a(str);
                c2.h();
                c2.w();
                int i2 = (j2 > 0 ? 1 : (j2 == 0 ? 0 : -1));
                if (i2 < 0) {
                    c2.J_().f11831f.a("Invalid time querying timed out conditional properties", dy.a(str), Long.valueOf(j2));
                    list = Collections.emptyList();
                } else {
                    list = c2.a("active=0 and app_id=? and abs(? - creation_timestamp) > trigger_timeout", new String[]{str, String.valueOf(j2)});
                }
                for (zzv next : list) {
                    if (next != null) {
                        this.f12266b.J_().j.a("User property timed out", next.f12389a, this.f12266b.f().c(next.f12391c.f12372a), next.f12391c.a());
                        if (next.f12395g != null) {
                            b(new zzan(next.f12395g, j2), zzm2);
                        }
                        c().e(str, next.f12391c.f12372a);
                    }
                }
                d c3 = c();
                s.a(str);
                c3.h();
                c3.w();
                if (i2 < 0) {
                    c3.J_().f11831f.a("Invalid time querying expired conditional properties", dy.a(str), Long.valueOf(j2));
                    list2 = Collections.emptyList();
                } else {
                    list2 = c3.a("active<>0 and app_id=? and abs(? - triggered_timestamp) > time_to_live", new String[]{str, String.valueOf(j2)});
                }
                ArrayList arrayList = new ArrayList(list2.size());
                for (zzv next2 : list2) {
                    if (next2 != null) {
                        this.f12266b.J_().j.a("User property expired", next2.f12389a, this.f12266b.f().c(next2.f12391c.f12372a), next2.f12391c.a());
                        c().b(str, next2.f12391c.f12372a);
                        if (next2.k != null) {
                            arrayList.add(next2.k);
                        }
                        c().e(str, next2.f12391c.f12372a);
                    }
                }
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    b(new zzan((zzan) obj, j2), zzm2);
                }
                d c4 = c();
                String str2 = zzan2.f12368a;
                s.a(str);
                s.a(str2);
                c4.h();
                c4.w();
                if (i2 < 0) {
                    c4.J_().f11831f.a("Invalid time querying triggered conditional properties", dy.a(str), c4.l().a(str2), Long.valueOf(j2));
                    list3 = Collections.emptyList();
                } else {
                    list3 = c4.a("active=0 and app_id=? and trigger_event_name=? and abs(? - creation_timestamp) <= trigger_timeout", new String[]{str, str2, String.valueOf(j2)});
                }
                ArrayList arrayList3 = new ArrayList(list3.size());
                for (zzv next3 : list3) {
                    if (next3 != null) {
                        zzkl zzkl = next3.f12391c;
                        jr jrVar = r4;
                        jr jrVar2 = new jr(next3.f12389a, next3.f12390b, zzkl.f12372a, j2, zzkl.a());
                        if (c().a(jrVar)) {
                            this.f12266b.J_().j.a("User property triggered", next3.f12389a, this.f12266b.f().c(jrVar.f12291c), jrVar.f12293e);
                        } else {
                            this.f12266b.J_().f11828c.a("Too many active user properties, ignoring", dy.a(next3.f12389a), this.f12266b.f().c(jrVar.f12291c), jrVar.f12293e);
                        }
                        if (next3.f12397i != null) {
                            arrayList3.add(next3.f12397i);
                        }
                        next3.f12391c = new zzkl(jrVar);
                        next3.f12393e = true;
                        c().a(next3);
                    }
                }
                b(zzan2, zzm2);
                ArrayList arrayList4 = arrayList3;
                int size2 = arrayList4.size();
                int i4 = 0;
                while (i4 < size2) {
                    Object obj2 = arrayList4.get(i4);
                    i4++;
                    b(new zzan((zzan) obj2, j2), zzm2);
                }
                c().c();
            } finally {
                c().x_();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x0269 A[Catch:{ SQLiteException -> 0x0233, all -> 0x08d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x029d A[Catch:{ SQLiteException -> 0x0233, all -> 0x08d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x02ee A[Catch:{ SQLiteException -> 0x0233, all -> 0x08d5 }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x0319  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(com.google.android.gms.measurement.internal.zzan r36, com.google.android.gms.measurement.internal.zzm r37) {
        /*
            r35 = this;
            r1 = r35
            r2 = r36
            r3 = r37
            java.lang.String r4 = "_s"
            com.google.android.gms.common.internal.s.a(r37)
            java.lang.String r5 = r3.f12380a
            com.google.android.gms.common.internal.s.a((java.lang.String) r5)
            long r5 = java.lang.System.nanoTime()
            r35.f()
            r35.g()
            java.lang.String r15 = r3.f12380a
            com.google.android.gms.measurement.internal.jn r7 = r35.e()
            boolean r7 = r7.a((com.google.android.gms.measurement.internal.zzan) r2, (com.google.android.gms.measurement.internal.zzm) r3)
            if (r7 != 0) goto L_0x0027
            return
        L_0x0027:
            boolean r7 = r3.f12387h
            if (r7 != 0) goto L_0x002f
            r1.c(r3)
            return
        L_0x002f:
            com.google.android.gms.measurement.internal.ev r7 = r35.a()
            java.lang.String r8 = r2.f12368a
            boolean r7 = r7.b(r15, r8)
            java.lang.String r14 = "_ev"
            java.lang.String r13 = "_err"
            r17 = 1
            r11 = 0
            r12 = 0
            if (r7 == 0) goto L_0x00d6
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()
            com.google.android.gms.measurement.internal.ea r3 = r3.f11831f
            java.lang.Object r4 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r15)
            com.google.android.gms.measurement.internal.fc r5 = r1.f12266b
            com.google.android.gms.measurement.internal.dw r5 = r5.f()
            java.lang.String r6 = r2.f12368a
            java.lang.String r5 = r5.a((java.lang.String) r6)
            java.lang.String r6 = "Dropping blacklisted event. appId"
            r3.a(r6, r4, r5)
            com.google.android.gms.measurement.internal.ev r3 = r35.a()
            boolean r3 = r3.g(r15)
            if (r3 != 0) goto L_0x0077
            com.google.android.gms.measurement.internal.ev r3 = r35.a()
            boolean r3 = r3.h(r15)
            if (r3 == 0) goto L_0x0075
            goto L_0x0077
        L_0x0075:
            r17 = 0
        L_0x0077:
            if (r17 != 0) goto L_0x008e
            java.lang.String r3 = r2.f12368a
            boolean r3 = r13.equals(r3)
            if (r3 != 0) goto L_0x008e
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b
            com.google.android.gms.measurement.internal.jq r3 = r3.e()
            r4 = 11
            java.lang.String r2 = r2.f12368a
            r3.b(r4, r14, r2, r12)
        L_0x008e:
            if (r17 == 0) goto L_0x00d5
            com.google.android.gms.measurement.internal.d r2 = r35.c()
            com.google.android.gms.measurement.internal.fb r2 = r2.b(r15)
            if (r2 == 0) goto L_0x00d5
            long r3 = r2.t()
            long r5 = r2.s()
            long r3 = java.lang.Math.max(r3, r5)
            com.google.android.gms.measurement.internal.fc r5 = r1.f12266b
            com.google.android.gms.common.util.e r5 = r5.j()
            long r5 = r5.a()
            long r5 = r5 - r3
            long r3 = java.lang.Math.abs(r5)
            com.google.android.gms.measurement.internal.dn<java.lang.Long> r5 = com.google.android.gms.measurement.internal.o.z
            java.lang.Object r5 = r5.a(r11)
            java.lang.Long r5 = (java.lang.Long) r5
            long r5 = r5.longValue()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L_0x00d5
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()
            com.google.android.gms.measurement.internal.ea r3 = r3.j
            java.lang.String r4 = "Fetching config for blacklisted app"
            r3.a(r4)
            r1.a((com.google.android.gms.measurement.internal.fb) r2)
        L_0x00d5:
            return
        L_0x00d6:
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b
            com.google.android.gms.measurement.internal.dy r7 = r7.J_()
            r10 = 2
            boolean r7 = r7.a((int) r10)
            if (r7 == 0) goto L_0x00fa
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b
            com.google.android.gms.measurement.internal.dy r7 = r7.J_()
            com.google.android.gms.measurement.internal.ea r7 = r7.k
            com.google.android.gms.measurement.internal.fc r8 = r1.f12266b
            com.google.android.gms.measurement.internal.dw r8 = r8.f()
            java.lang.String r8 = r8.a((com.google.android.gms.measurement.internal.zzan) r2)
            java.lang.String r9 = "Logging event"
            r7.a(r9, r8)
        L_0x00fa:
            com.google.android.gms.measurement.internal.d r7 = r35.c()
            r7.b()
            r1.c(r3)     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = "_iap"
            java.lang.String r8 = r2.f12368a     // Catch:{ all -> 0x08d5 }
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x08d5 }
            java.lang.String r8 = "ecommerce_purchase"
            if (r7 != 0) goto L_0x0120
            java.lang.String r7 = r2.f12368a     // Catch:{ all -> 0x08d5 }
            boolean r7 = r8.equals(r7)     // Catch:{ all -> 0x08d5 }
            if (r7 == 0) goto L_0x0119
            goto L_0x0120
        L_0x0119:
            r24 = r5
            r26 = r13
            r6 = 0
            goto L_0x02ac
        L_0x0120:
            com.google.android.gms.measurement.internal.zzam r7 = r2.f12369b     // Catch:{ all -> 0x08d5 }
            java.lang.String r9 = "currency"
            java.lang.String r7 = r7.d(r9)     // Catch:{ all -> 0x08d5 }
            java.lang.String r9 = r2.f12368a     // Catch:{ all -> 0x08d5 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x08d5 }
            java.lang.String r9 = "value"
            if (r8 == 0) goto L_0x0184
            com.google.android.gms.measurement.internal.zzam r8 = r2.f12369b     // Catch:{ all -> 0x08d5 }
            java.lang.Double r8 = r8.c(r9)     // Catch:{ all -> 0x08d5 }
            double r18 = r8.doubleValue()     // Catch:{ all -> 0x08d5 }
            r20 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r18 = r18 * r20
            r22 = 0
            int r8 = (r18 > r22 ? 1 : (r18 == r22 ? 0 : -1))
            if (r8 != 0) goto L_0x0157
            com.google.android.gms.measurement.internal.zzam r8 = r2.f12369b     // Catch:{ all -> 0x08d5 }
            java.lang.Long r8 = r8.b(r9)     // Catch:{ all -> 0x08d5 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x08d5 }
            double r8 = (double) r8     // Catch:{ all -> 0x08d5 }
            double r18 = r8 * r20
        L_0x0157:
            r8 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r16 = (r18 > r8 ? 1 : (r18 == r8 ? 0 : -1))
            if (r16 > 0) goto L_0x0168
            r8 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r16 = (r18 > r8 ? 1 : (r18 == r8 ? 0 : -1))
            if (r16 < 0) goto L_0x0168
            long r8 = java.lang.Math.round(r18)     // Catch:{ all -> 0x08d5 }
            goto L_0x018e
        L_0x0168:
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dy r7 = r7.J_()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ea r7 = r7.f11831f     // Catch:{ all -> 0x08d5 }
            java.lang.String r8 = "Data lost. Currency value is too big. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r15)     // Catch:{ all -> 0x08d5 }
            java.lang.Double r10 = java.lang.Double.valueOf(r18)     // Catch:{ all -> 0x08d5 }
            r7.a(r8, r9, r10)     // Catch:{ all -> 0x08d5 }
            r24 = r5
            r26 = r13
            r6 = 0
            goto L_0x029b
        L_0x0184:
            com.google.android.gms.measurement.internal.zzam r8 = r2.f12369b     // Catch:{ all -> 0x08d5 }
            java.lang.Long r8 = r8.b(r9)     // Catch:{ all -> 0x08d5 }
            long r8 = r8.longValue()     // Catch:{ all -> 0x08d5 }
        L_0x018e:
            boolean r10 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08d5 }
            if (r10 != 0) goto L_0x0295
            java.util.Locale r10 = java.util.Locale.US     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r7.toUpperCase(r10)     // Catch:{ all -> 0x08d5 }
            java.lang.String r10 = "[A-Z]{3}"
            boolean r10 = r7.matches(r10)     // Catch:{ all -> 0x08d5 }
            if (r10 == 0) goto L_0x0295
            java.lang.String r10 = "_ltv_"
            java.lang.String r7 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x08d5 }
            int r18 = r7.length()     // Catch:{ all -> 0x08d5 }
            if (r18 == 0) goto L_0x01b3
            java.lang.String r7 = r10.concat(r7)     // Catch:{ all -> 0x08d5 }
            goto L_0x01b8
        L_0x01b3:
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x08d5 }
            r7.<init>(r10)     // Catch:{ all -> 0x08d5 }
        L_0x01b8:
            r10 = r7
            com.google.android.gms.measurement.internal.d r7 = r35.c()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jr r7 = r7.c((java.lang.String) r15, (java.lang.String) r10)     // Catch:{ all -> 0x08d5 }
            if (r7 == 0) goto L_0x01fb
            java.lang.Object r11 = r7.f12293e     // Catch:{ all -> 0x08d5 }
            boolean r11 = r11 instanceof java.lang.Long     // Catch:{ all -> 0x08d5 }
            if (r11 != 0) goto L_0x01ca
            goto L_0x01fb
        L_0x01ca:
            java.lang.Object r7 = r7.f12293e     // Catch:{ all -> 0x08d5 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x08d5 }
            long r19 = r7.longValue()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jr r21 = new com.google.android.gms.measurement.internal.jr     // Catch:{ all -> 0x08d5 }
            java.lang.String r11 = r2.f12370c     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.common.util.e r7 = r7.j()     // Catch:{ all -> 0x08d5 }
            long r22 = r7.a()     // Catch:{ all -> 0x08d5 }
            long r19 = r19 + r8
            java.lang.Long r19 = java.lang.Long.valueOf(r19)     // Catch:{ all -> 0x08d5 }
            r7 = r21
            r8 = r15
            r9 = r11
            r11 = 2
            r24 = r5
            r5 = 2
            r6 = 0
            r11 = r22
            r26 = r13
            r13 = r19
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x08d5 }
            r5 = r21
            goto L_0x025f
        L_0x01fb:
            r24 = r5
            r26 = r13
            r5 = 2
            r6 = 0
            com.google.android.gms.measurement.internal.d r7 = r35.c()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r11 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ke r11 = r11.f11945e     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dn<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.o.E     // Catch:{ all -> 0x08d5 }
            int r11 = r11.b(r15, r12)     // Catch:{ all -> 0x08d5 }
            int r11 = r11 + -1
            com.google.android.gms.common.internal.s.a((java.lang.String) r15)     // Catch:{ all -> 0x08d5 }
            r7.h()     // Catch:{ all -> 0x08d5 }
            r7.w()     // Catch:{ all -> 0x08d5 }
            android.database.sqlite.SQLiteDatabase r12 = r7.e()     // Catch:{ SQLiteException -> 0x0233 }
            java.lang.String r13 = "delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);"
            r5 = 3
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x0233 }
            r5[r6] = r15     // Catch:{ SQLiteException -> 0x0233 }
            r5[r17] = r15     // Catch:{ SQLiteException -> 0x0233 }
            java.lang.String r11 = java.lang.String.valueOf(r11)     // Catch:{ SQLiteException -> 0x0233 }
            r16 = 2
            r5[r16] = r11     // Catch:{ SQLiteException -> 0x0233 }
            r12.execSQL(r13, r5)     // Catch:{ SQLiteException -> 0x0233 }
            goto L_0x0244
        L_0x0233:
            r0 = move-exception
            r5 = r0
            com.google.android.gms.measurement.internal.dy r7 = r7.J_()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ea r7 = r7.f11828c     // Catch:{ all -> 0x08d5 }
            java.lang.String r11 = "Error pruning currencies. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r15)     // Catch:{ all -> 0x08d5 }
            r7.a(r11, r12, r5)     // Catch:{ all -> 0x08d5 }
        L_0x0244:
            com.google.android.gms.measurement.internal.jr r5 = new com.google.android.gms.measurement.internal.jr     // Catch:{ all -> 0x08d5 }
            java.lang.String r11 = r2.f12370c     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.common.util.e r7 = r7.j()     // Catch:{ all -> 0x08d5 }
            long r12 = r7.a()     // Catch:{ all -> 0x08d5 }
            java.lang.Long r16 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x08d5 }
            r7 = r5
            r8 = r15
            r9 = r11
            r11 = r12
            r13 = r16
            r7.<init>(r8, r9, r10, r11, r13)     // Catch:{ all -> 0x08d5 }
        L_0x025f:
            com.google.android.gms.measurement.internal.d r7 = r35.c()     // Catch:{ all -> 0x08d5 }
            boolean r7 = r7.a((com.google.android.gms.measurement.internal.jr) r5)     // Catch:{ all -> 0x08d5 }
            if (r7 != 0) goto L_0x029a
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dy r7 = r7.J_()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ea r7 = r7.f11828c     // Catch:{ all -> 0x08d5 }
            java.lang.String r8 = "Too many unique user properties are set. Ignoring user property. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r15)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r10 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dw r10 = r10.f()     // Catch:{ all -> 0x08d5 }
            java.lang.String r11 = r5.f12291c     // Catch:{ all -> 0x08d5 }
            java.lang.String r10 = r10.c(r11)     // Catch:{ all -> 0x08d5 }
            java.lang.Object r5 = r5.f12293e     // Catch:{ all -> 0x08d5 }
            r7.a(r8, r9, r10, r5)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r5 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jq r5 = r5.e()     // Catch:{ all -> 0x08d5 }
            r7 = 9
            r8 = 0
            r5.b(r7, r8, r8, r6)     // Catch:{ all -> 0x08d5 }
            goto L_0x029a
        L_0x0295:
            r24 = r5
            r26 = r13
            r6 = 0
        L_0x029a:
            r12 = 1
        L_0x029b:
            if (r12 != 0) goto L_0x02ac
            com.google.android.gms.measurement.internal.d r2 = r35.c()     // Catch:{ all -> 0x08d5 }
            r2.c()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.d r2 = r35.c()
            r2.x_()
            return
        L_0x02ac:
            java.lang.String r5 = r2.f12368a     // Catch:{ all -> 0x08d5 }
            boolean r5 = com.google.android.gms.measurement.internal.jq.a((java.lang.String) r5)     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r2.f12368a     // Catch:{ all -> 0x08d5 }
            r8 = r26
            boolean r16 = r8.equals(r7)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.d r7 = r35.c()     // Catch:{ all -> 0x08d5 }
            long r8 = r35.q()     // Catch:{ all -> 0x08d5 }
            r11 = 1
            r13 = 0
            r20 = 0
            r10 = r15
            r12 = r5
            r6 = r14
            r14 = r16
            r22 = r15
            r15 = r20
            com.google.android.gms.measurement.internal.c r7 = r7.a(r8, r10, r11, r12, r13, r14, r15)     // Catch:{ all -> 0x08d5 }
            long r8 = r7.f11744b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dn<java.lang.Integer> r10 = com.google.android.gms.measurement.internal.o.k     // Catch:{ all -> 0x08d5 }
            r11 = 0
            java.lang.Object r10 = r10.a(r11)     // Catch:{ all -> 0x08d5 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x08d5 }
            int r10 = r10.intValue()     // Catch:{ all -> 0x08d5 }
            long r10 = (long) r10     // Catch:{ all -> 0x08d5 }
            long r8 = r8 - r10
            r10 = 1000(0x3e8, double:4.94E-321)
            r12 = 1
            r14 = 0
            int r20 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r20 <= 0) goto L_0x0319
            long r8 = r8 % r10
            int r2 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x030a
            com.google.android.gms.measurement.internal.fc r2 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dy r2 = r2.J_()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ea r2 = r2.f11828c     // Catch:{ all -> 0x08d5 }
            java.lang.String r3 = "Data loss. Too many events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r22)     // Catch:{ all -> 0x08d5 }
            long r5 = r7.f11744b     // Catch:{ all -> 0x08d5 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x08d5 }
            r2.a(r3, r4, r5)     // Catch:{ all -> 0x08d5 }
        L_0x030a:
            com.google.android.gms.measurement.internal.d r2 = r35.c()     // Catch:{ all -> 0x08d5 }
            r2.c()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.d r2 = r35.c()
            r2.x_()
            return
        L_0x0319:
            if (r5 == 0) goto L_0x036b
            long r8 = r7.f11743a     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dn<java.lang.Integer> r12 = com.google.android.gms.measurement.internal.o.m     // Catch:{ all -> 0x08d5 }
            r13 = 0
            java.lang.Object r12 = r12.a(r13)     // Catch:{ all -> 0x08d5 }
            java.lang.Integer r12 = (java.lang.Integer) r12     // Catch:{ all -> 0x08d5 }
            int r12 = r12.intValue()     // Catch:{ all -> 0x08d5 }
            long r12 = (long) r12     // Catch:{ all -> 0x08d5 }
            long r8 = r8 - r12
            int r12 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r12 <= 0) goto L_0x036b
            long r8 = r8 % r10
            r3 = 1
            int r5 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x034e
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ all -> 0x08d5 }
            java.lang.String r4 = "Data loss. Too many public events logged. appId, count"
            java.lang.Object r5 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r22)     // Catch:{ all -> 0x08d5 }
            long r7 = r7.f11743a     // Catch:{ all -> 0x08d5 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x08d5 }
            r3.a(r4, r5, r7)     // Catch:{ all -> 0x08d5 }
        L_0x034e:
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jq r3 = r3.e()     // Catch:{ all -> 0x08d5 }
            r4 = 16
            java.lang.String r2 = r2.f12368a     // Catch:{ all -> 0x08d5 }
            r5 = 0
            r3.b(r4, r6, r2, r5)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.d r2 = r35.c()     // Catch:{ all -> 0x08d5 }
            r2.c()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.d r2 = r35.c()
            r2.x_()
            return
        L_0x036b:
            if (r16 == 0) goto L_0x03b9
            long r8 = r7.f11746d     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ke r6 = r6.f11945e     // Catch:{ all -> 0x08d5 }
            java.lang.String r10 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dn<java.lang.Integer> r11 = com.google.android.gms.measurement.internal.o.l     // Catch:{ all -> 0x08d5 }
            int r6 = r6.b(r10, r11)     // Catch:{ all -> 0x08d5 }
            r10 = 1000000(0xf4240, float:1.401298E-39)
            int r6 = java.lang.Math.min(r10, r6)     // Catch:{ all -> 0x08d5 }
            r10 = 0
            int r6 = java.lang.Math.max(r10, r6)     // Catch:{ all -> 0x08d5 }
            long r10 = (long) r6     // Catch:{ all -> 0x08d5 }
            long r8 = r8 - r10
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 <= 0) goto L_0x03b9
            r10 = 1
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 != 0) goto L_0x03aa
            com.google.android.gms.measurement.internal.fc r2 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dy r2 = r2.J_()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ea r2 = r2.f11828c     // Catch:{ all -> 0x08d5 }
            java.lang.String r3 = "Too many error events logged. appId, count"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r22)     // Catch:{ all -> 0x08d5 }
            long r5 = r7.f11746d     // Catch:{ all -> 0x08d5 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x08d5 }
            r2.a(r3, r4, r5)     // Catch:{ all -> 0x08d5 }
        L_0x03aa:
            com.google.android.gms.measurement.internal.d r2 = r35.c()     // Catch:{ all -> 0x08d5 }
            r2.c()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.d r2 = r35.c()
            r2.x_()
            return
        L_0x03b9:
            com.google.android.gms.measurement.internal.zzam r6 = r2.f12369b     // Catch:{ all -> 0x08d5 }
            android.os.Bundle r6 = r6.a()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jq r7 = r7.e()     // Catch:{ all -> 0x08d5 }
            java.lang.String r8 = "_o"
            java.lang.String r9 = r2.f12370c     // Catch:{ all -> 0x08d5 }
            r7.a((android.os.Bundle) r6, (java.lang.String) r8, (java.lang.Object) r9)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jq r7 = r7.e()     // Catch:{ all -> 0x08d5 }
            r12 = r22
            boolean r7 = r7.f(r12)     // Catch:{ all -> 0x08d5 }
            java.lang.String r13 = "_r"
            if (r7 == 0) goto L_0x03fa
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jq r7 = r7.e()     // Catch:{ all -> 0x08d5 }
            java.lang.String r8 = "_dbg"
            r9 = 1
            java.lang.Long r11 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x08d5 }
            r7.a((android.os.Bundle) r6, (java.lang.String) r8, (java.lang.Object) r11)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jq r7 = r7.e()     // Catch:{ all -> 0x08d5 }
            java.lang.Long r8 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x08d5 }
            r7.a((android.os.Bundle) r6, (java.lang.String) r13, (java.lang.Object) r8)     // Catch:{ all -> 0x08d5 }
        L_0x03fa:
            java.lang.String r7 = r2.f12368a     // Catch:{ all -> 0x08d5 }
            boolean r7 = r4.equals(r7)     // Catch:{ all -> 0x08d5 }
            java.lang.String r8 = "_sno"
            if (r7 == 0) goto L_0x042f
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ke r7 = r7.f11945e     // Catch:{ all -> 0x08d5 }
            java.lang.String r9 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.o.Q     // Catch:{ all -> 0x08d5 }
            boolean r7 = r7.d(r9, r10)     // Catch:{ all -> 0x08d5 }
            if (r7 == 0) goto L_0x042f
            com.google.android.gms.measurement.internal.d r7 = r35.c()     // Catch:{ all -> 0x08d5 }
            java.lang.String r9 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jr r7 = r7.c((java.lang.String) r9, (java.lang.String) r8)     // Catch:{ all -> 0x08d5 }
            if (r7 == 0) goto L_0x042f
            java.lang.Object r9 = r7.f12293e     // Catch:{ all -> 0x08d5 }
            boolean r9 = r9 instanceof java.lang.Long     // Catch:{ all -> 0x08d5 }
            if (r9 == 0) goto L_0x042f
            com.google.android.gms.measurement.internal.fc r9 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jq r9 = r9.e()     // Catch:{ all -> 0x08d5 }
            java.lang.Object r7 = r7.f12293e     // Catch:{ all -> 0x08d5 }
            r9.a((android.os.Bundle) r6, (java.lang.String) r8, (java.lang.Object) r7)     // Catch:{ all -> 0x08d5 }
        L_0x042f:
            java.lang.String r7 = r2.f12368a     // Catch:{ all -> 0x08d5 }
            boolean r4 = r4.equals(r7)     // Catch:{ all -> 0x08d5 }
            if (r4 == 0) goto L_0x045b
            com.google.android.gms.measurement.internal.fc r4 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ke r4 = r4.f11945e     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.o.U     // Catch:{ all -> 0x08d5 }
            boolean r4 = r4.d(r7, r9)     // Catch:{ all -> 0x08d5 }
            if (r4 == 0) goto L_0x045b
            com.google.android.gms.measurement.internal.fc r4 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ke r4 = r4.f11945e     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.o.Q     // Catch:{ all -> 0x08d5 }
            boolean r4 = r4.d(r7, r9)     // Catch:{ all -> 0x08d5 }
            if (r4 != 0) goto L_0x045b
            com.google.android.gms.measurement.internal.zzkl r4 = new com.google.android.gms.measurement.internal.zzkl     // Catch:{ all -> 0x08d5 }
            r4.<init>((java.lang.String) r8)     // Catch:{ all -> 0x08d5 }
            r1.b((com.google.android.gms.measurement.internal.zzkl) r4, (com.google.android.gms.measurement.internal.zzm) r3)     // Catch:{ all -> 0x08d5 }
        L_0x045b:
            com.google.android.gms.measurement.internal.d r4 = r35.c()     // Catch:{ all -> 0x08d5 }
            long r7 = r4.c(r12)     // Catch:{ all -> 0x08d5 }
            int r4 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
            if (r4 <= 0) goto L_0x047c
            com.google.android.gms.measurement.internal.fc r4 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dy r4 = r4.J_()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ea r4 = r4.f11831f     // Catch:{ all -> 0x08d5 }
            java.lang.String r9 = "Data lost. Too many events stored on disk, deleted. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r12)     // Catch:{ all -> 0x08d5 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x08d5 }
            r4.a(r9, r10, r7)     // Catch:{ all -> 0x08d5 }
        L_0x047c:
            com.google.android.gms.measurement.internal.l r4 = new com.google.android.gms.measurement.internal.l     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r8 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            java.lang.String r9 = r2.f12370c     // Catch:{ all -> 0x08d5 }
            java.lang.String r11 = r2.f12368a     // Catch:{ all -> 0x08d5 }
            long r14 = r2.f12371d     // Catch:{ all -> 0x08d5 }
            r26 = 0
            r7 = r4
            r10 = r12
            r2 = r12
            r28 = r13
            r12 = r14
            r14 = r26
            r16 = r6
            r7.<init>((com.google.android.gms.measurement.internal.fc) r8, (java.lang.String) r9, (java.lang.String) r10, (java.lang.String) r11, (long) r12, (long) r14, (android.os.Bundle) r16)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.d r6 = r35.c()     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r4.f12339b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.k r6 = r6.a((java.lang.String) r2, (java.lang.String) r7)     // Catch:{ all -> 0x08d5 }
            if (r6 != 0) goto L_0x04fa
            com.google.android.gms.measurement.internal.d r6 = r35.c()     // Catch:{ all -> 0x08d5 }
            long r6 = r6.g(r2)     // Catch:{ all -> 0x08d5 }
            r8 = 500(0x1f4, double:2.47E-321)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 < 0) goto L_0x04e9
            if (r5 == 0) goto L_0x04e9
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ all -> 0x08d5 }
            java.lang.String r5 = "Too many event names used, ignoring event. appId, name, supported count"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r2)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dw r6 = r6.f()     // Catch:{ all -> 0x08d5 }
            java.lang.String r4 = r4.f12339b     // Catch:{ all -> 0x08d5 }
            java.lang.String r4 = r6.a((java.lang.String) r4)     // Catch:{ all -> 0x08d5 }
            r6 = 500(0x1f4, float:7.0E-43)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x08d5 }
            r3.a(r5, r2, r4, r6)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r2 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jq r2 = r2.e()     // Catch:{ all -> 0x08d5 }
            r3 = 8
            r4 = 0
            r5 = 0
            r2.b(r3, r4, r4, r5)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.d r2 = r35.c()
            r2.x_()
            return
        L_0x04e9:
            r5 = 0
            com.google.android.gms.measurement.internal.k r6 = new com.google.android.gms.measurement.internal.k     // Catch:{ all -> 0x08d5 }
            java.lang.String r9 = r4.f12339b     // Catch:{ all -> 0x08d5 }
            r10 = 0
            r12 = 0
            long r14 = r4.f12340c     // Catch:{ all -> 0x08d5 }
            r7 = r6
            r8 = r2
            r7.<init>(r8, r9, r10, r12, r14)     // Catch:{ all -> 0x08d5 }
            goto L_0x0509
        L_0x04fa:
            r5 = 0
            com.google.android.gms.measurement.internal.fc r2 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            long r7 = r6.f12318f     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.l r4 = r4.a(r2, r7)     // Catch:{ all -> 0x08d5 }
            long r7 = r4.f12340c     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.k r6 = r6.a(r7)     // Catch:{ all -> 0x08d5 }
        L_0x0509:
            com.google.android.gms.measurement.internal.d r2 = r35.c()     // Catch:{ all -> 0x08d5 }
            r2.a((com.google.android.gms.measurement.internal.k) r6)     // Catch:{ all -> 0x08d5 }
            r35.f()     // Catch:{ all -> 0x08d5 }
            r35.g()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.common.internal.s.a(r4)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.common.internal.s.a(r37)     // Catch:{ all -> 0x08d5 }
            java.lang.String r2 = r4.f12338a     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.common.internal.s.a((java.lang.String) r2)     // Catch:{ all -> 0x08d5 }
            java.lang.String r2 = r4.f12338a     // Catch:{ all -> 0x08d5 }
            java.lang.String r6 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            boolean r2 = r2.equals(r6)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.common.internal.s.b((boolean) r2)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.internal.measurement.aj$g$a r2 = com.google.android.gms.internal.measurement.aj.g.c()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.internal.measurement.aj$g$a r2 = r2.a()     // Catch:{ all -> 0x08d5 }
            java.lang.String r6 = "android"
            com.google.android.gms.internal.measurement.aj$g$a r2 = r2.a((java.lang.String) r6)     // Catch:{ all -> 0x08d5 }
            java.lang.String r6 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08d5 }
            if (r6 != 0) goto L_0x0547
            java.lang.String r6 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            r2.f((java.lang.String) r6)     // Catch:{ all -> 0x08d5 }
        L_0x0547:
            java.lang.String r6 = r3.f12383d     // Catch:{ all -> 0x08d5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08d5 }
            if (r6 != 0) goto L_0x0554
            java.lang.String r6 = r3.f12383d     // Catch:{ all -> 0x08d5 }
            r2.e((java.lang.String) r6)     // Catch:{ all -> 0x08d5 }
        L_0x0554:
            java.lang.String r6 = r3.f12382c     // Catch:{ all -> 0x08d5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08d5 }
            if (r6 != 0) goto L_0x0561
            java.lang.String r6 = r3.f12382c     // Catch:{ all -> 0x08d5 }
            r2.g((java.lang.String) r6)     // Catch:{ all -> 0x08d5 }
        L_0x0561:
            long r6 = r3.j     // Catch:{ all -> 0x08d5 }
            r8 = -2147483648(0xffffffff80000000, double:NaN)
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0570
            long r6 = r3.j     // Catch:{ all -> 0x08d5 }
            int r7 = (int) r6     // Catch:{ all -> 0x08d5 }
            r2.g((int) r7)     // Catch:{ all -> 0x08d5 }
        L_0x0570:
            long r6 = r3.f12384e     // Catch:{ all -> 0x08d5 }
            r2.f((long) r6)     // Catch:{ all -> 0x08d5 }
            java.lang.String r6 = r3.f12381b     // Catch:{ all -> 0x08d5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08d5 }
            if (r6 != 0) goto L_0x0582
            java.lang.String r6 = r3.f12381b     // Catch:{ all -> 0x08d5 }
            r2.k((java.lang.String) r6)     // Catch:{ all -> 0x08d5 }
        L_0x0582:
            com.google.android.gms.internal.measurement.jz.a()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ke r6 = r6.f11945e     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.o.aC     // Catch:{ all -> 0x08d5 }
            boolean r6 = r6.d(r7, r8)     // Catch:{ all -> 0x08d5 }
            if (r6 == 0) goto L_0x05cc
            java.lang.String r6 = r2.n()     // Catch:{ all -> 0x08d5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08d5 }
            if (r6 == 0) goto L_0x05aa
            java.lang.String r6 = r3.v     // Catch:{ all -> 0x08d5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08d5 }
            if (r6 != 0) goto L_0x05aa
            java.lang.String r6 = r3.v     // Catch:{ all -> 0x08d5 }
            r2.o(r6)     // Catch:{ all -> 0x08d5 }
        L_0x05aa:
            java.lang.String r6 = r2.n()     // Catch:{ all -> 0x08d5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08d5 }
            if (r6 == 0) goto L_0x05fe
            java.lang.String r6 = r2.r()     // Catch:{ all -> 0x08d5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08d5 }
            if (r6 == 0) goto L_0x05fe
            java.lang.String r6 = r3.r     // Catch:{ all -> 0x08d5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08d5 }
            if (r6 != 0) goto L_0x05fe
            java.lang.String r6 = r3.r     // Catch:{ all -> 0x08d5 }
            r2.n(r6)     // Catch:{ all -> 0x08d5 }
            goto L_0x05fe
        L_0x05cc:
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ke r6 = r6.f11945e     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.o.ag     // Catch:{ all -> 0x08d5 }
            r8 = 0
            boolean r6 = r6.d(r8, r7)     // Catch:{ all -> 0x08d5 }
            if (r6 == 0) goto L_0x05f1
            java.lang.String r6 = r2.n()     // Catch:{ all -> 0x08d5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08d5 }
            if (r6 == 0) goto L_0x05fe
            java.lang.String r6 = r3.r     // Catch:{ all -> 0x08d5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08d5 }
            if (r6 != 0) goto L_0x05fe
            java.lang.String r6 = r3.r     // Catch:{ all -> 0x08d5 }
            r2.n(r6)     // Catch:{ all -> 0x08d5 }
            goto L_0x05fe
        L_0x05f1:
            java.lang.String r6 = r3.r     // Catch:{ all -> 0x08d5 }
            boolean r6 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x08d5 }
            if (r6 != 0) goto L_0x05fe
            java.lang.String r6 = r3.r     // Catch:{ all -> 0x08d5 }
            r2.n(r6)     // Catch:{ all -> 0x08d5 }
        L_0x05fe:
            long r6 = r3.f12385f     // Catch:{ all -> 0x08d5 }
            r8 = 0
            int r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x060b
            long r6 = r3.f12385f     // Catch:{ all -> 0x08d5 }
            r2.g((long) r6)     // Catch:{ all -> 0x08d5 }
        L_0x060b:
            long r6 = r3.t     // Catch:{ all -> 0x08d5 }
            r2.j((long) r6)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ke r6 = r6.f11945e     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r10 = com.google.android.gms.measurement.internal.o.ad     // Catch:{ all -> 0x08d5 }
            boolean r6 = r6.d(r7, r10)     // Catch:{ all -> 0x08d5 }
            if (r6 == 0) goto L_0x062b
            com.google.android.gms.measurement.internal.jn r6 = r35.e()     // Catch:{ all -> 0x08d5 }
            java.util.List r6 = r6.b()     // Catch:{ all -> 0x08d5 }
            if (r6 == 0) goto L_0x062b
            r2.d((java.lang.Iterable<? extends java.lang.Integer>) r6)     // Catch:{ all -> 0x08d5 }
        L_0x062b:
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.eh r6 = r6.b()     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            android.util.Pair r6 = r6.a((java.lang.String) r7)     // Catch:{ all -> 0x08d5 }
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x08d5 }
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7     // Catch:{ all -> 0x08d5 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08d5 }
            if (r7 != 0) goto L_0x065c
            boolean r7 = r3.o     // Catch:{ all -> 0x08d5 }
            if (r7 == 0) goto L_0x06ba
            java.lang.Object r7 = r6.first     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x08d5 }
            r2.h((java.lang.String) r7)     // Catch:{ all -> 0x08d5 }
            java.lang.Object r7 = r6.second     // Catch:{ all -> 0x08d5 }
            if (r7 == 0) goto L_0x06ba
            java.lang.Object r6 = r6.second     // Catch:{ all -> 0x08d5 }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x08d5 }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x08d5 }
            r2.a((boolean) r6)     // Catch:{ all -> 0x08d5 }
            goto L_0x06ba
        L_0x065c:
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.i r6 = r6.l()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            android.content.Context r7 = r7.k()     // Catch:{ all -> 0x08d5 }
            boolean r6 = r6.a(r7)     // Catch:{ all -> 0x08d5 }
            if (r6 != 0) goto L_0x06ba
            boolean r6 = r3.p     // Catch:{ all -> 0x08d5 }
            if (r6 == 0) goto L_0x06ba
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            android.content.Context r6 = r6.k()     // Catch:{ all -> 0x08d5 }
            android.content.ContentResolver r6 = r6.getContentResolver()     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = "android_id"
            java.lang.String r6 = android.provider.Settings.Secure.getString(r6, r7)     // Catch:{ all -> 0x08d5 }
            if (r6 != 0) goto L_0x069c
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dy r6 = r6.J_()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ea r6 = r6.f11831f     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = "null secure ID. appId"
            java.lang.String r10 = r2.k()     // Catch:{ all -> 0x08d5 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r10)     // Catch:{ all -> 0x08d5 }
            r6.a(r7, r10)     // Catch:{ all -> 0x08d5 }
            java.lang.String r6 = "null"
            goto L_0x06b7
        L_0x069c:
            boolean r7 = r6.isEmpty()     // Catch:{ all -> 0x08d5 }
            if (r7 == 0) goto L_0x06b7
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dy r7 = r7.J_()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ea r7 = r7.f11831f     // Catch:{ all -> 0x08d5 }
            java.lang.String r10 = "empty secure ID. appId"
            java.lang.String r11 = r2.k()     // Catch:{ all -> 0x08d5 }
            java.lang.Object r11 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r11)     // Catch:{ all -> 0x08d5 }
            r7.a(r10, r11)     // Catch:{ all -> 0x08d5 }
        L_0x06b7:
            r2.m(r6)     // Catch:{ all -> 0x08d5 }
        L_0x06ba:
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.i r6 = r6.l()     // Catch:{ all -> 0x08d5 }
            r6.w()     // Catch:{ all -> 0x08d5 }
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.internal.measurement.aj$g$a r6 = r2.c((java.lang.String) r6)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.i r7 = r7.l()     // Catch:{ all -> 0x08d5 }
            r7.w()     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.internal.measurement.aj$g$a r6 = r6.b((java.lang.String) r7)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.i r7 = r7.l()     // Catch:{ all -> 0x08d5 }
            long r10 = r7.N_()     // Catch:{ all -> 0x08d5 }
            int r7 = (int) r10     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.internal.measurement.aj$g$a r6 = r6.e((int) r7)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.i r7 = r7.l()     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r7.c()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.internal.measurement.aj$g$a r6 = r6.d((java.lang.String) r7)     // Catch:{ all -> 0x08d5 }
            long r10 = r3.l     // Catch:{ all -> 0x08d5 }
            r6.i((long) r10)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            boolean r6 = r6.r()     // Catch:{ all -> 0x08d5 }
            if (r6 == 0) goto L_0x0718
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ke r6 = r6.f11945e     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.o.f12346a     // Catch:{ all -> 0x08d5 }
            r10 = 0
            boolean r6 = r6.d(r10, r7)     // Catch:{ all -> 0x08d5 }
            if (r6 == 0) goto L_0x0718
            boolean r6 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x08d5 }
            if (r6 != 0) goto L_0x0718
            r2.p()     // Catch:{ all -> 0x08d5 }
        L_0x0718:
            com.google.android.gms.measurement.internal.d r6 = r35.c()     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fb r6 = r6.b(r7)     // Catch:{ all -> 0x08d5 }
            if (r6 != 0) goto L_0x078b
            com.google.android.gms.measurement.internal.fb r6 = new com.google.android.gms.measurement.internal.fb     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            java.lang.String r10 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            r6.<init>(r7, r10)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jq r7 = r7.e()     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r7.t()     // Catch:{ all -> 0x08d5 }
            r6.a((java.lang.String) r7)     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r3.k     // Catch:{ all -> 0x08d5 }
            r6.f((java.lang.String) r7)     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r3.f12381b     // Catch:{ all -> 0x08d5 }
            r6.b((java.lang.String) r7)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.eh r7 = r7.b()     // Catch:{ all -> 0x08d5 }
            java.lang.String r10 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r7.b((java.lang.String) r10)     // Catch:{ all -> 0x08d5 }
            r6.e((java.lang.String) r7)     // Catch:{ all -> 0x08d5 }
            r6.g((long) r8)     // Catch:{ all -> 0x08d5 }
            r6.a((long) r8)     // Catch:{ all -> 0x08d5 }
            r6.b((long) r8)     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r3.f12382c     // Catch:{ all -> 0x08d5 }
            r6.g((java.lang.String) r7)     // Catch:{ all -> 0x08d5 }
            long r10 = r3.j     // Catch:{ all -> 0x08d5 }
            r6.c((long) r10)     // Catch:{ all -> 0x08d5 }
            java.lang.String r7 = r3.f12383d     // Catch:{ all -> 0x08d5 }
            r6.h((java.lang.String) r7)     // Catch:{ all -> 0x08d5 }
            long r10 = r3.f12384e     // Catch:{ all -> 0x08d5 }
            r6.d((long) r10)     // Catch:{ all -> 0x08d5 }
            long r10 = r3.f12385f     // Catch:{ all -> 0x08d5 }
            r6.e((long) r10)     // Catch:{ all -> 0x08d5 }
            boolean r7 = r3.f12387h     // Catch:{ all -> 0x08d5 }
            r6.a((boolean) r7)     // Catch:{ all -> 0x08d5 }
            long r10 = r3.l     // Catch:{ all -> 0x08d5 }
            r6.j(r10)     // Catch:{ all -> 0x08d5 }
            long r10 = r3.t     // Catch:{ all -> 0x08d5 }
            r6.f((long) r10)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.d r7 = r35.c()     // Catch:{ all -> 0x08d5 }
            r7.a((com.google.android.gms.measurement.internal.fb) r6)     // Catch:{ all -> 0x08d5 }
        L_0x078b:
            java.lang.String r7 = r6.c()     // Catch:{ all -> 0x08d5 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08d5 }
            if (r7 != 0) goto L_0x079c
            java.lang.String r7 = r6.c()     // Catch:{ all -> 0x08d5 }
            r2.i((java.lang.String) r7)     // Catch:{ all -> 0x08d5 }
        L_0x079c:
            java.lang.String r7 = r6.h()     // Catch:{ all -> 0x08d5 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ all -> 0x08d5 }
            if (r7 != 0) goto L_0x07ad
            java.lang.String r6 = r6.h()     // Catch:{ all -> 0x08d5 }
            r2.l(r6)     // Catch:{ all -> 0x08d5 }
        L_0x07ad:
            com.google.android.gms.measurement.internal.d r6 = r35.c()     // Catch:{ all -> 0x08d5 }
            java.lang.String r3 = r3.f12380a     // Catch:{ all -> 0x08d5 }
            java.util.List r3 = r6.a((java.lang.String) r3)     // Catch:{ all -> 0x08d5 }
            r6 = 0
        L_0x07b8:
            int r7 = r3.size()     // Catch:{ all -> 0x08d5 }
            if (r6 >= r7) goto L_0x07ef
            com.google.android.gms.internal.measurement.aj$k$a r7 = com.google.android.gms.internal.measurement.aj.k.d()     // Catch:{ all -> 0x08d5 }
            java.lang.Object r10 = r3.get(r6)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jr r10 = (com.google.android.gms.measurement.internal.jr) r10     // Catch:{ all -> 0x08d5 }
            java.lang.String r10 = r10.f12291c     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.internal.measurement.aj$k$a r7 = r7.a((java.lang.String) r10)     // Catch:{ all -> 0x08d5 }
            java.lang.Object r10 = r3.get(r6)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jr r10 = (com.google.android.gms.measurement.internal.jr) r10     // Catch:{ all -> 0x08d5 }
            long r10 = r10.f12292d     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.internal.measurement.aj$k$a r7 = r7.a((long) r10)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jn r10 = r35.e()     // Catch:{ all -> 0x08d5 }
            java.lang.Object r11 = r3.get(r6)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.jr r11 = (com.google.android.gms.measurement.internal.jr) r11     // Catch:{ all -> 0x08d5 }
            java.lang.Object r11 = r11.f12293e     // Catch:{ all -> 0x08d5 }
            r10.a((com.google.android.gms.internal.measurement.aj.k.a) r7, (java.lang.Object) r11)     // Catch:{ all -> 0x08d5 }
            r2.a((com.google.android.gms.internal.measurement.aj.k.a) r7)     // Catch:{ all -> 0x08d5 }
            int r6 = r6 + 1
            goto L_0x07b8
        L_0x07ef:
            com.google.android.gms.measurement.internal.d r3 = r35.c()     // Catch:{ IOException -> 0x0869 }
            com.google.android.gms.internal.measurement.ff r6 = r2.w()     // Catch:{ IOException -> 0x0869 }
            com.google.android.gms.internal.measurement.dv r6 = (com.google.android.gms.internal.measurement.dv) r6     // Catch:{ IOException -> 0x0869 }
            com.google.android.gms.internal.measurement.aj$g r6 = (com.google.android.gms.internal.measurement.aj.g) r6     // Catch:{ IOException -> 0x0869 }
            long r2 = r3.a((com.google.android.gms.internal.measurement.aj.g) r6)     // Catch:{ IOException -> 0x0869 }
            com.google.android.gms.measurement.internal.d r6 = r35.c()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.zzam r7 = r4.f12342e     // Catch:{ all -> 0x08d5 }
            if (r7 == 0) goto L_0x0860
            com.google.android.gms.measurement.internal.zzam r7 = r4.f12342e     // Catch:{ all -> 0x08d5 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x08d5 }
        L_0x080d:
            boolean r10 = r7.hasNext()     // Catch:{ all -> 0x08d5 }
            if (r10 == 0) goto L_0x0826
            java.lang.Object r10 = r7.next()     // Catch:{ all -> 0x08d5 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x08d5 }
            r11 = r28
            boolean r10 = r11.equals(r10)     // Catch:{ all -> 0x08d5 }
            if (r10 == 0) goto L_0x0823
        L_0x0821:
            r5 = 1
            goto L_0x0860
        L_0x0823:
            r28 = r11
            goto L_0x080d
        L_0x0826:
            com.google.android.gms.measurement.internal.ev r7 = r35.a()     // Catch:{ all -> 0x08d5 }
            java.lang.String r10 = r4.f12338a     // Catch:{ all -> 0x08d5 }
            java.lang.String r11 = r4.f12339b     // Catch:{ all -> 0x08d5 }
            boolean r7 = r7.c(r10, r11)     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.d r26 = r35.c()     // Catch:{ all -> 0x08d5 }
            long r27 = r35.q()     // Catch:{ all -> 0x08d5 }
            java.lang.String r10 = r4.f12338a     // Catch:{ all -> 0x08d5 }
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r29 = r10
            com.google.android.gms.measurement.internal.c r10 = r26.a(r27, r29, r30, r31, r32, r33, r34)     // Catch:{ all -> 0x08d5 }
            if (r7 == 0) goto L_0x0860
            long r10 = r10.f11747e     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r7 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ke r7 = r7.f11945e     // Catch:{ all -> 0x08d5 }
            java.lang.String r12 = r4.f12338a     // Catch:{ all -> 0x08d5 }
            int r7 = r7.a((java.lang.String) r12)     // Catch:{ all -> 0x08d5 }
            long r12 = (long) r7     // Catch:{ all -> 0x08d5 }
            int r7 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r7 >= 0) goto L_0x0860
            goto L_0x0821
        L_0x0860:
            boolean r2 = r6.a((com.google.android.gms.measurement.internal.l) r4, (long) r2, (boolean) r5)     // Catch:{ all -> 0x08d5 }
            if (r2 == 0) goto L_0x0880
            r1.q = r8     // Catch:{ all -> 0x08d5 }
            goto L_0x0880
        L_0x0869:
            r0 = move-exception
            r3 = r0
            com.google.android.gms.measurement.internal.fc r5 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dy r5 = r5.J_()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ea r5 = r5.f11828c     // Catch:{ all -> 0x08d5 }
            java.lang.String r6 = "Data loss. Failed to insert raw event metadata. appId"
            java.lang.String r2 = r2.k()     // Catch:{ all -> 0x08d5 }
            java.lang.Object r2 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r2)     // Catch:{ all -> 0x08d5 }
            r5.a(r6, r2, r3)     // Catch:{ all -> 0x08d5 }
        L_0x0880:
            com.google.android.gms.measurement.internal.d r2 = r35.c()     // Catch:{ all -> 0x08d5 }
            r2.c()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.fc r2 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dy r2 = r2.J_()     // Catch:{ all -> 0x08d5 }
            r3 = 2
            boolean r2 = r2.a((int) r3)     // Catch:{ all -> 0x08d5 }
            if (r2 == 0) goto L_0x08ab
            com.google.android.gms.measurement.internal.fc r2 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dy r2 = r2.J_()     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.ea r2 = r2.k     // Catch:{ all -> 0x08d5 }
            java.lang.String r3 = "Event recorded"
            com.google.android.gms.measurement.internal.fc r5 = r1.f12266b     // Catch:{ all -> 0x08d5 }
            com.google.android.gms.measurement.internal.dw r5 = r5.f()     // Catch:{ all -> 0x08d5 }
            java.lang.String r4 = r5.a((com.google.android.gms.measurement.internal.l) r4)     // Catch:{ all -> 0x08d5 }
            r2.a(r3, r4)     // Catch:{ all -> 0x08d5 }
        L_0x08ab:
            com.google.android.gms.measurement.internal.d r2 = r35.c()
            r2.x_()
            r35.i()
            com.google.android.gms.measurement.internal.fc r2 = r1.f12266b
            com.google.android.gms.measurement.internal.dy r2 = r2.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.k
            long r3 = java.lang.System.nanoTime()
            long r3 = r3 - r24
            r5 = 500000(0x7a120, double:2.47033E-318)
            long r3 = r3 + r5
            r5 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 / r5
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            java.lang.String r4 = "Background event processing time, ms"
            r2.a(r4, r3)
            return
        L_0x08d5:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.measurement.internal.d r3 = r35.c()
            r3.x_()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.jj.b(com.google.android.gms.measurement.internal.zzan, com.google.android.gms.measurement.internal.zzm):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:95|96) */
    /* JADX WARNING: Code restructure failed: missing block: B:96:?, code lost:
        r15.f12266b.J_().f11828c.a("Failed to parse upload URL. Not uploading. appId", com.google.android.gms.measurement.internal.dy.a(r4), r12);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:95:0x0295 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h() {
        /*
            r15 = this;
            r15.f()
            r15.g()
            r0 = 1
            r15.t = r0
            r1 = 0
            com.google.android.gms.measurement.internal.fc r2 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.hm r2 = r2.i()     // Catch:{ all -> 0x02cf }
            java.lang.Boolean r2 = r2.f12121c     // Catch:{ all -> 0x02cf }
            if (r2 != 0) goto L_0x0027
            com.google.android.gms.measurement.internal.fc r0 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.dy r0 = r0.J_()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.ea r0 = r0.f11831f     // Catch:{ all -> 0x02cf }
            java.lang.String r2 = "Upload data called on the client side before use of service was decided"
            r0.a(r2)     // Catch:{ all -> 0x02cf }
            r15.t = r1
            r15.s()
            return
        L_0x0027:
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x02cf }
            if (r2 == 0) goto L_0x0040
            com.google.android.gms.measurement.internal.fc r0 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.dy r0 = r0.J_()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c     // Catch:{ all -> 0x02cf }
            java.lang.String r2 = "Upload called in the client side when service should be used"
            r0.a(r2)     // Catch:{ all -> 0x02cf }
            r15.t = r1
            r15.s()
            return
        L_0x0040:
            long r2 = r15.q     // Catch:{ all -> 0x02cf }
            r4 = 0
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0051
            r15.i()     // Catch:{ all -> 0x02cf }
            r15.t = r1
            r15.s()
            return
        L_0x0051:
            r15.f()     // Catch:{ all -> 0x02cf }
            java.util.List<java.lang.Long> r2 = r15.w     // Catch:{ all -> 0x02cf }
            if (r2 == 0) goto L_0x005a
            r2 = 1
            goto L_0x005b
        L_0x005a:
            r2 = 0
        L_0x005b:
            if (r2 == 0) goto L_0x0070
            com.google.android.gms.measurement.internal.fc r0 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.dy r0 = r0.J_()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.ea r0 = r0.k     // Catch:{ all -> 0x02cf }
            java.lang.String r2 = "Uploading requested multiple times"
            r0.a(r2)     // Catch:{ all -> 0x02cf }
            r15.t = r1
            r15.s()
            return
        L_0x0070:
            com.google.android.gms.measurement.internal.ec r2 = r15.b()     // Catch:{ all -> 0x02cf }
            boolean r2 = r2.b()     // Catch:{ all -> 0x02cf }
            if (r2 != 0) goto L_0x0090
            com.google.android.gms.measurement.internal.fc r0 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.dy r0 = r0.J_()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.ea r0 = r0.k     // Catch:{ all -> 0x02cf }
            java.lang.String r2 = "Network not connected, ignoring upload request"
            r0.a(r2)     // Catch:{ all -> 0x02cf }
            r15.i()     // Catch:{ all -> 0x02cf }
            r15.t = r1
            r15.s()
            return
        L_0x0090:
            com.google.android.gms.measurement.internal.fc r2 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.common.util.e r2 = r2.j()     // Catch:{ all -> 0x02cf }
            long r2 = r2.a()     // Catch:{ all -> 0x02cf }
            long r6 = com.google.android.gms.measurement.internal.ke.e()     // Catch:{ all -> 0x02cf }
            long r6 = r2 - r6
            r15.a((long) r6)     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.fc r6 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.eh r6 = r6.b()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.el r6 = r6.f11861d     // Catch:{ all -> 0x02cf }
            long r6 = r6.a()     // Catch:{ all -> 0x02cf }
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 == 0) goto L_0x00ca
            com.google.android.gms.measurement.internal.fc r4 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.dy r4 = r4.J_()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.ea r4 = r4.j     // Catch:{ all -> 0x02cf }
            java.lang.String r5 = "Uploading events. Elapsed time since last upload attempt (ms)"
            long r6 = r2 - r6
            long r6 = java.lang.Math.abs(r6)     // Catch:{ all -> 0x02cf }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x02cf }
            r4.a(r5, r6)     // Catch:{ all -> 0x02cf }
        L_0x00ca:
            com.google.android.gms.measurement.internal.d r4 = r15.c()     // Catch:{ all -> 0x02cf }
            java.lang.String r4 = r4.f()     // Catch:{ all -> 0x02cf }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x02cf }
            r6 = -1
            if (r5 != 0) goto L_0x02a7
            long r8 = r15.y     // Catch:{ all -> 0x02cf }
            int r5 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r5 != 0) goto L_0x00ea
            com.google.android.gms.measurement.internal.d r5 = r15.c()     // Catch:{ all -> 0x02cf }
            long r5 = r5.m()     // Catch:{ all -> 0x02cf }
            r15.y = r5     // Catch:{ all -> 0x02cf }
        L_0x00ea:
            com.google.android.gms.measurement.internal.fc r5 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.ke r5 = r5.f11945e     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.dn<java.lang.Integer> r6 = com.google.android.gms.measurement.internal.o.f12352g     // Catch:{ all -> 0x02cf }
            int r5 = r5.b(r4, r6)     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.fc r6 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.ke r6 = r6.f11945e     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.dn<java.lang.Integer> r7 = com.google.android.gms.measurement.internal.o.f12353h     // Catch:{ all -> 0x02cf }
            int r6 = r6.b(r4, r7)     // Catch:{ all -> 0x02cf }
            int r6 = java.lang.Math.max(r1, r6)     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.d r7 = r15.c()     // Catch:{ all -> 0x02cf }
            java.util.List r5 = r7.a((java.lang.String) r4, (int) r5, (int) r6)     // Catch:{ all -> 0x02cf }
            boolean r6 = r5.isEmpty()     // Catch:{ all -> 0x02cf }
            if (r6 != 0) goto L_0x02c9
            java.util.Iterator r6 = r5.iterator()     // Catch:{ all -> 0x02cf }
        L_0x0114:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x02cf }
            r8 = 0
            if (r7 == 0) goto L_0x0130
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x02cf }
            android.util.Pair r7 = (android.util.Pair) r7     // Catch:{ all -> 0x02cf }
            java.lang.Object r7 = r7.first     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.aj$g r7 = (com.google.android.gms.internal.measurement.aj.g) r7     // Catch:{ all -> 0x02cf }
            java.lang.String r9 = r7.zzw     // Catch:{ all -> 0x02cf }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x02cf }
            if (r9 != 0) goto L_0x0114
            java.lang.String r6 = r7.zzw     // Catch:{ all -> 0x02cf }
            goto L_0x0131
        L_0x0130:
            r6 = r8
        L_0x0131:
            if (r6 == 0) goto L_0x015c
            r7 = 0
        L_0x0134:
            int r9 = r5.size()     // Catch:{ all -> 0x02cf }
            if (r7 >= r9) goto L_0x015c
            java.lang.Object r9 = r5.get(r7)     // Catch:{ all -> 0x02cf }
            android.util.Pair r9 = (android.util.Pair) r9     // Catch:{ all -> 0x02cf }
            java.lang.Object r9 = r9.first     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.aj$g r9 = (com.google.android.gms.internal.measurement.aj.g) r9     // Catch:{ all -> 0x02cf }
            java.lang.String r10 = r9.zzw     // Catch:{ all -> 0x02cf }
            boolean r10 = android.text.TextUtils.isEmpty(r10)     // Catch:{ all -> 0x02cf }
            if (r10 != 0) goto L_0x0159
            java.lang.String r9 = r9.zzw     // Catch:{ all -> 0x02cf }
            boolean r9 = r9.equals(r6)     // Catch:{ all -> 0x02cf }
            if (r9 != 0) goto L_0x0159
            java.util.List r5 = r5.subList(r1, r7)     // Catch:{ all -> 0x02cf }
            goto L_0x015c
        L_0x0159:
            int r7 = r7 + 1
            goto L_0x0134
        L_0x015c:
            com.google.android.gms.internal.measurement.aj$f$a r6 = com.google.android.gms.internal.measurement.aj.f.a()     // Catch:{ all -> 0x02cf }
            int r7 = r5.size()     // Catch:{ all -> 0x02cf }
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x02cf }
            int r10 = r5.size()     // Catch:{ all -> 0x02cf }
            r9.<init>(r10)     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.fc r10 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.ke r10 = r10.f11945e     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.o.f12346a     // Catch:{ all -> 0x02cf }
            boolean r10 = r10.d(r8, r11)     // Catch:{ all -> 0x02cf }
            if (r10 == 0) goto L_0x0185
            com.google.android.gms.measurement.internal.fc r10 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.ke r10 = r10.f11945e     // Catch:{ all -> 0x02cf }
            boolean r10 = r10.d(r4)     // Catch:{ all -> 0x02cf }
            if (r10 == 0) goto L_0x0185
            r10 = 1
            goto L_0x0186
        L_0x0185:
            r10 = 0
        L_0x0186:
            r11 = 0
        L_0x0187:
            if (r11 >= r7) goto L_0x01e1
            java.lang.Object r12 = r5.get(r11)     // Catch:{ all -> 0x02cf }
            android.util.Pair r12 = (android.util.Pair) r12     // Catch:{ all -> 0x02cf }
            java.lang.Object r12 = r12.first     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.aj$g r12 = (com.google.android.gms.internal.measurement.aj.g) r12     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.dv$b r12 = r12.m()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.dv$b r12 = (com.google.android.gms.internal.measurement.dv.b) r12     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.aj$g$a r12 = (com.google.android.gms.internal.measurement.aj.g.a) r12     // Catch:{ all -> 0x02cf }
            java.lang.Object r13 = r5.get(r11)     // Catch:{ all -> 0x02cf }
            android.util.Pair r13 = (android.util.Pair) r13     // Catch:{ all -> 0x02cf }
            java.lang.Object r13 = r13.second     // Catch:{ all -> 0x02cf }
            java.lang.Long r13 = (java.lang.Long) r13     // Catch:{ all -> 0x02cf }
            r9.add(r13)     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.aj$g$a r13 = r12.o_()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.aj$g$a r13 = r13.a((long) r2)     // Catch:{ all -> 0x02cf }
            r13.b((boolean) r1)     // Catch:{ all -> 0x02cf }
            if (r10 != 0) goto L_0x01b8
            r12.p_()     // Catch:{ all -> 0x02cf }
        L_0x01b8:
            com.google.android.gms.measurement.internal.fc r13 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.ke r13 = r13.f11945e     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.o.af     // Catch:{ all -> 0x02cf }
            boolean r13 = r13.d(r4, r14)     // Catch:{ all -> 0x02cf }
            if (r13 == 0) goto L_0x01db
            com.google.android.gms.internal.measurement.ff r13 = r12.w()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.dv r13 = (com.google.android.gms.internal.measurement.dv) r13     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.aj$g r13 = (com.google.android.gms.internal.measurement.aj.g) r13     // Catch:{ all -> 0x02cf }
            byte[] r13 = r13.i()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.jn r14 = r15.e()     // Catch:{ all -> 0x02cf }
            long r13 = r14.a((byte[]) r13)     // Catch:{ all -> 0x02cf }
            r12.k((long) r13)     // Catch:{ all -> 0x02cf }
        L_0x01db:
            r6.a(r12)     // Catch:{ all -> 0x02cf }
            int r11 = r11 + 1
            goto L_0x0187
        L_0x01e1:
            com.google.android.gms.measurement.internal.fc r5 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.dy r5 = r5.J_()     // Catch:{ all -> 0x02cf }
            r10 = 2
            boolean r5 = r5.a((int) r10)     // Catch:{ all -> 0x02cf }
            if (r5 == 0) goto L_0x01ff
            com.google.android.gms.measurement.internal.jn r5 = r15.e()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.ff r10 = r6.w()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.dv r10 = (com.google.android.gms.internal.measurement.dv) r10     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.aj$f r10 = (com.google.android.gms.internal.measurement.aj.f) r10     // Catch:{ all -> 0x02cf }
            java.lang.String r5 = r5.a((com.google.android.gms.internal.measurement.aj.f) r10)     // Catch:{ all -> 0x02cf }
            goto L_0x0200
        L_0x01ff:
            r5 = r8
        L_0x0200:
            r15.e()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.ff r10 = r6.w()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.dv r10 = (com.google.android.gms.internal.measurement.dv) r10     // Catch:{ all -> 0x02cf }
            com.google.android.gms.internal.measurement.aj$f r10 = (com.google.android.gms.internal.measurement.aj.f) r10     // Catch:{ all -> 0x02cf }
            byte[] r10 = r10.i()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.dn<java.lang.String> r11 = com.google.android.gms.measurement.internal.o.q     // Catch:{ all -> 0x02cf }
            java.lang.Object r8 = r11.a(r8)     // Catch:{ all -> 0x02cf }
            r12 = r8
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x02cf }
            java.net.URL r8 = new java.net.URL     // Catch:{ MalformedURLException -> 0x0295 }
            r8.<init>(r12)     // Catch:{ MalformedURLException -> 0x0295 }
            boolean r11 = r9.isEmpty()     // Catch:{ MalformedURLException -> 0x0295 }
            if (r11 != 0) goto L_0x0225
            r11 = 1
            goto L_0x0226
        L_0x0225:
            r11 = 0
        L_0x0226:
            com.google.android.gms.common.internal.s.b((boolean) r11)     // Catch:{ MalformedURLException -> 0x0295 }
            java.util.List<java.lang.Long> r11 = r15.w     // Catch:{ MalformedURLException -> 0x0295 }
            if (r11 == 0) goto L_0x023b
            com.google.android.gms.measurement.internal.fc r9 = r15.f12266b     // Catch:{ MalformedURLException -> 0x0295 }
            com.google.android.gms.measurement.internal.dy r9 = r9.J_()     // Catch:{ MalformedURLException -> 0x0295 }
            com.google.android.gms.measurement.internal.ea r9 = r9.f11828c     // Catch:{ MalformedURLException -> 0x0295 }
            java.lang.String r11 = "Set uploading progress before finishing the previous upload"
            r9.a(r11)     // Catch:{ MalformedURLException -> 0x0295 }
            goto L_0x0242
        L_0x023b:
            java.util.ArrayList r11 = new java.util.ArrayList     // Catch:{ MalformedURLException -> 0x0295 }
            r11.<init>(r9)     // Catch:{ MalformedURLException -> 0x0295 }
            r15.w = r11     // Catch:{ MalformedURLException -> 0x0295 }
        L_0x0242:
            com.google.android.gms.measurement.internal.fc r9 = r15.f12266b     // Catch:{ MalformedURLException -> 0x0295 }
            com.google.android.gms.measurement.internal.eh r9 = r9.b()     // Catch:{ MalformedURLException -> 0x0295 }
            com.google.android.gms.measurement.internal.el r9 = r9.f11862e     // Catch:{ MalformedURLException -> 0x0295 }
            r9.a(r2)     // Catch:{ MalformedURLException -> 0x0295 }
            java.lang.String r2 = "?"
            if (r7 <= 0) goto L_0x0257
            com.google.android.gms.internal.measurement.aj$g r2 = r6.a()     // Catch:{ MalformedURLException -> 0x0295 }
            java.lang.String r2 = r2.zzs     // Catch:{ MalformedURLException -> 0x0295 }
        L_0x0257:
            com.google.android.gms.measurement.internal.fc r3 = r15.f12266b     // Catch:{ MalformedURLException -> 0x0295 }
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()     // Catch:{ MalformedURLException -> 0x0295 }
            com.google.android.gms.measurement.internal.ea r3 = r3.k     // Catch:{ MalformedURLException -> 0x0295 }
            java.lang.String r6 = "Uploading data. app, uncompressed size, data"
            int r7 = r10.length     // Catch:{ MalformedURLException -> 0x0295 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ MalformedURLException -> 0x0295 }
            r3.a(r6, r2, r7, r5)     // Catch:{ MalformedURLException -> 0x0295 }
            r15.s = r0     // Catch:{ MalformedURLException -> 0x0295 }
            com.google.android.gms.measurement.internal.ec r6 = r15.b()     // Catch:{ MalformedURLException -> 0x0295 }
            com.google.android.gms.measurement.internal.jl r11 = new com.google.android.gms.measurement.internal.jl     // Catch:{ MalformedURLException -> 0x0295 }
            r11.<init>(r15, r4)     // Catch:{ MalformedURLException -> 0x0295 }
            r6.h()     // Catch:{ MalformedURLException -> 0x0295 }
            r6.w()     // Catch:{ MalformedURLException -> 0x0295 }
            com.google.android.gms.common.internal.s.a(r8)     // Catch:{ MalformedURLException -> 0x0295 }
            com.google.android.gms.common.internal.s.a(r10)     // Catch:{ MalformedURLException -> 0x0295 }
            com.google.android.gms.common.internal.s.a(r11)     // Catch:{ MalformedURLException -> 0x0295 }
            com.google.android.gms.measurement.internal.eu r0 = r6.K_()     // Catch:{ MalformedURLException -> 0x0295 }
            com.google.android.gms.measurement.internal.eg r2 = new com.google.android.gms.measurement.internal.eg     // Catch:{ MalformedURLException -> 0x0295 }
            r3 = 0
            r5 = r2
            r7 = r4
            r9 = r10
            r10 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11)     // Catch:{ MalformedURLException -> 0x0295 }
            r0.b((java.lang.Runnable) r2)     // Catch:{ MalformedURLException -> 0x0295 }
            goto L_0x02c9
        L_0x0295:
            com.google.android.gms.measurement.internal.fc r0 = r15.f12266b     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.dy r0 = r0.J_()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c     // Catch:{ all -> 0x02cf }
            java.lang.String r2 = "Failed to parse upload URL. Not uploading. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r4)     // Catch:{ all -> 0x02cf }
            r0.a(r2, r3, r12)     // Catch:{ all -> 0x02cf }
            goto L_0x02c9
        L_0x02a7:
            r15.y = r6     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.d r0 = r15.c()     // Catch:{ all -> 0x02cf }
            long r4 = com.google.android.gms.measurement.internal.ke.e()     // Catch:{ all -> 0x02cf }
            long r2 = r2 - r4
            java.lang.String r0 = r0.a((long) r2)     // Catch:{ all -> 0x02cf }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x02cf }
            if (r2 != 0) goto L_0x02c9
            com.google.android.gms.measurement.internal.d r2 = r15.c()     // Catch:{ all -> 0x02cf }
            com.google.android.gms.measurement.internal.fb r0 = r2.b(r0)     // Catch:{ all -> 0x02cf }
            if (r0 == 0) goto L_0x02c9
            r15.a((com.google.android.gms.measurement.internal.fb) r0)     // Catch:{ all -> 0x02cf }
        L_0x02c9:
            r15.t = r1
            r15.s()
            return
        L_0x02cf:
            r0 = move-exception
            r15.t = r1
            r15.s()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.jj.h():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v21, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v48, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v49, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v22, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v50, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v51, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v52, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v53, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v54, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v55, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v56, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v57, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v58, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v59, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v61, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v62, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v63, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v74, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v75, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v28, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v77, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v78, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v79, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v37, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v38, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v39, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v41, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v43, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v45, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v47, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v49, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v50, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v51, resolved type: java.lang.String} */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0040, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0041, code lost:
        r2 = r0;
        r6 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x025e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x025f, code lost:
        r5 = r0;
        r6 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        r5 = r0;
        r6 = null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0040 A[ExcHandler: all (r0v21 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r11 
      PHI: (r11v32 java.lang.String) = (r11v0 java.lang.String), (r11v0 java.lang.String), (r11v41 java.lang.String), (r11v43 java.lang.String), (r11v45 java.lang.String), (r11v47 java.lang.String), (r11v49 java.lang.String), (r11v50 java.lang.String), (r11v51 java.lang.String) binds: [B:9:0x0031, B:10:?, B:44:0x00d9, B:50:0x00e6, B:51:?, B:22:0x0079, B:28:0x0086, B:30:0x008a, B:31:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:9:0x0031] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x027c A[SYNTHETIC, Splitter:B:150:0x027c] */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0283 A[Catch:{ IOException -> 0x0231, all -> 0x0e98 }] */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0291 A[Catch:{ IOException -> 0x0231, all -> 0x0e98 }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x03bd A[Catch:{ IOException -> 0x0231, all -> 0x0e98 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x03bf A[Catch:{ IOException -> 0x0231, all -> 0x0e98 }] */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x03c2 A[Catch:{ IOException -> 0x0231, all -> 0x0e98 }] */
    /* JADX WARNING: Removed duplicated region for block: B:211:0x03c3 A[Catch:{ IOException -> 0x0231, all -> 0x0e98 }] */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0592 A[Catch:{ IOException -> 0x0231, all -> 0x0e98 }] */
    /* JADX WARNING: Removed duplicated region for block: B:294:0x0661 A[Catch:{ IOException -> 0x0231, all -> 0x0e98 }] */
    /* JADX WARNING: Removed duplicated region for block: B:335:0x0775 A[Catch:{ IOException -> 0x0231, all -> 0x0e98 }] */
    /* JADX WARNING: Removed duplicated region for block: B:336:0x078b A[Catch:{ IOException -> 0x0231, all -> 0x0e98 }] */
    /* JADX WARNING: Removed duplicated region for block: B:589:0x0e80 A[SYNTHETIC, Splitter:B:589:0x0e80] */
    /* JADX WARNING: Removed duplicated region for block: B:596:0x0e94 A[SYNTHETIC, Splitter:B:596:0x0e94] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean a(long r54) {
        /*
            r53 = this;
            r1 = r53
            com.google.android.gms.measurement.internal.d r2 = r53.c()
            r2.b()
            com.google.android.gms.measurement.internal.jj$a r2 = new com.google.android.gms.measurement.internal.jj$a     // Catch:{ all -> 0x0e98 }
            r3 = 0
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.d r4 = r53.c()     // Catch:{ all -> 0x0e98 }
            long r5 = r1.y     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.common.internal.s.a(r2)     // Catch:{ all -> 0x0e98 }
            r4.h()     // Catch:{ all -> 0x0e98 }
            r4.w()     // Catch:{ all -> 0x0e98 }
            r8 = -1
            r10 = 2
            r11 = 0
            r12 = 1
            android.database.sqlite.SQLiteDatabase r15 = r4.e()     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            boolean r13 = android.text.TextUtils.isEmpty(r11)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            if (r13 == 0) goto L_0x009c
            int r13 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r13 == 0) goto L_0x004a
            java.lang.String[] r14 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            java.lang.String r16 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            r14[r3] = r16     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            java.lang.String r16 = java.lang.String.valueOf(r54)     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            r14[r12] = r16     // Catch:{ SQLiteException -> 0x0045, all -> 0x0040 }
            goto L_0x0052
        L_0x0040:
            r0 = move-exception
            r2 = r0
            r6 = r11
            goto L_0x0e92
        L_0x0045:
            r0 = move-exception
            r5 = r0
            r6 = r11
            goto L_0x026b
        L_0x004a:
            java.lang.String[] r14 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            java.lang.String r16 = java.lang.String.valueOf(r54)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            r14[r3] = r16     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
        L_0x0052:
            if (r13 == 0) goto L_0x0057
            java.lang.String r13 = "rowid <= ? and "
            goto L_0x0059
        L_0x0057:
            java.lang.String r13 = ""
        L_0x0059:
            int r7 = r13.length()     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            int r7 = r7 + 148
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            r11.<init>(r7)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            java.lang.String r7 = "select app_id, metadata_fingerprint from raw_events where "
            r11.append(r7)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            r11.append(r13)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            java.lang.String r7 = "app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r11.append(r7)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            java.lang.String r7 = r11.toString()     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            android.database.Cursor r11 = r15.rawQuery(r7, r14)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            boolean r7 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x025e, all -> 0x0040 }
            if (r7 != 0) goto L_0x0086
            if (r11 == 0) goto L_0x027f
            r11.close()     // Catch:{ all -> 0x0e98 }
            goto L_0x027f
        L_0x0086:
            java.lang.String r7 = r11.getString(r3)     // Catch:{ SQLiteException -> 0x025e, all -> 0x0040 }
            java.lang.String r13 = r11.getString(r12)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0040 }
            r11.close()     // Catch:{ SQLiteException -> 0x0096, all -> 0x0040 }
            r22 = r11
            r11 = r7
            r7 = r13
            goto L_0x00f1
        L_0x0096:
            r0 = move-exception
            r5 = r0
            r6 = r11
            r11 = r7
            goto L_0x026b
        L_0x009c:
            int r7 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r7 == 0) goto L_0x00ad
            java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            r13 = 0
            r11[r3] = r13     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            java.lang.String r13 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            r11[r12] = r13     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            r13 = r11
            goto L_0x00b2
        L_0x00ad:
            r11 = 0
            java.lang.String[] r13 = new java.lang.String[]{r11}     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
        L_0x00b2:
            if (r7 == 0) goto L_0x00b7
            java.lang.String r7 = " and rowid <= ?"
            goto L_0x00b9
        L_0x00b7:
            java.lang.String r7 = ""
        L_0x00b9:
            int r11 = r7.length()     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            int r11 = r11 + 84
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            r14.<init>(r11)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            java.lang.String r11 = "select metadata_fingerprint from raw_events where app_id = ?"
            r14.append(r11)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            r14.append(r7)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            java.lang.String r7 = " order by rowid limit 1;"
            r14.append(r7)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            java.lang.String r7 = r14.toString()     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            android.database.Cursor r11 = r15.rawQuery(r7, r13)     // Catch:{ SQLiteException -> 0x0267, all -> 0x0262 }
            boolean r7 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x025e, all -> 0x0040 }
            if (r7 != 0) goto L_0x00e6
            if (r11 == 0) goto L_0x027f
            r11.close()     // Catch:{ all -> 0x0e98 }
            goto L_0x027f
        L_0x00e6:
            java.lang.String r13 = r11.getString(r3)     // Catch:{ SQLiteException -> 0x025e, all -> 0x0040 }
            r11.close()     // Catch:{ SQLiteException -> 0x025e, all -> 0x0040 }
            r22 = r11
            r7 = r13
            r11 = 0
        L_0x00f1:
            java.lang.String r14 = "raw_events_metadata"
            java.lang.String r13 = "metadata"
            java.lang.String[] r16 = new java.lang.String[]{r13}     // Catch:{ SQLiteException -> 0x0259, all -> 0x0253 }
            java.lang.String r17 = "app_id = ? and metadata_fingerprint = ?"
            java.lang.String[] r13 = new java.lang.String[r10]     // Catch:{ SQLiteException -> 0x0259, all -> 0x0253 }
            r13[r3] = r11     // Catch:{ SQLiteException -> 0x0259, all -> 0x0253 }
            r13[r12] = r7     // Catch:{ SQLiteException -> 0x0259, all -> 0x0253 }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            java.lang.String r21 = "2"
            r23 = r13
            r13 = r15
            r24 = r15
            r15 = r16
            r16 = r17
            r17 = r23
            android.database.Cursor r15 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x0259, all -> 0x0253 }
            boolean r13 = r15.moveToFirst()     // Catch:{ SQLiteException -> 0x024f, all -> 0x024b }
            if (r13 != 0) goto L_0x013e
            com.google.android.gms.measurement.internal.dy r5 = r4.J_()     // Catch:{ SQLiteException -> 0x0139, all -> 0x0134 }
            com.google.android.gms.measurement.internal.ea r5 = r5.f11828c     // Catch:{ SQLiteException -> 0x0139, all -> 0x0134 }
            java.lang.String r6 = "Raw event metadata record is missing. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0139, all -> 0x0134 }
            r5.a(r6, r7)     // Catch:{ SQLiteException -> 0x0139, all -> 0x0134 }
            if (r15 == 0) goto L_0x027f
            r15.close()     // Catch:{ all -> 0x0e98 }
            goto L_0x027f
        L_0x0134:
            r0 = move-exception
            r2 = r0
            r6 = r15
            goto L_0x0e92
        L_0x0139:
            r0 = move-exception
            r5 = r0
            r6 = r15
            goto L_0x026b
        L_0x013e:
            byte[] r13 = r15.getBlob(r3)     // Catch:{ SQLiteException -> 0x024f, all -> 0x024b }
            com.google.android.gms.internal.measurement.aj$g$a r14 = com.google.android.gms.internal.measurement.aj.g.c()     // Catch:{ IOException -> 0x0231 }
            com.google.android.gms.internal.measurement.fe r13 = com.google.android.gms.measurement.internal.jn.a(r14, (byte[]) r13)     // Catch:{ IOException -> 0x0231 }
            com.google.android.gms.internal.measurement.aj$g$a r13 = (com.google.android.gms.internal.measurement.aj.g.a) r13     // Catch:{ IOException -> 0x0231 }
            com.google.android.gms.internal.measurement.ff r13 = r13.w()     // Catch:{ IOException -> 0x0231 }
            com.google.android.gms.internal.measurement.dv r13 = (com.google.android.gms.internal.measurement.dv) r13     // Catch:{ IOException -> 0x0231 }
            com.google.android.gms.internal.measurement.aj$g r13 = (com.google.android.gms.internal.measurement.aj.g) r13     // Catch:{ IOException -> 0x0231 }
            boolean r14 = r15.moveToNext()     // Catch:{ SQLiteException -> 0x024f, all -> 0x024b }
            if (r14 == 0) goto L_0x0169
            com.google.android.gms.measurement.internal.dy r14 = r4.J_()     // Catch:{ SQLiteException -> 0x0139, all -> 0x0134 }
            com.google.android.gms.measurement.internal.ea r14 = r14.f11831f     // Catch:{ SQLiteException -> 0x0139, all -> 0x0134 }
            java.lang.String r10 = "Get multiple raw event metadata records, expected one. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0139, all -> 0x0134 }
            r14.a(r10, r12)     // Catch:{ SQLiteException -> 0x0139, all -> 0x0134 }
        L_0x0169:
            r15.close()     // Catch:{ SQLiteException -> 0x024f, all -> 0x024b }
            r2.a(r13)     // Catch:{ SQLiteException -> 0x024f, all -> 0x024b }
            int r10 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r10 == 0) goto L_0x0189
            java.lang.String r10 = "app_id = ? and metadata_fingerprint = ? and rowid <= ?"
            r12 = 3
            java.lang.String[] r13 = new java.lang.String[r12]     // Catch:{ SQLiteException -> 0x0139, all -> 0x0134 }
            r13[r3] = r11     // Catch:{ SQLiteException -> 0x0139, all -> 0x0134 }
            r12 = 1
            r13[r12] = r7     // Catch:{ SQLiteException -> 0x0139, all -> 0x0134 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0139, all -> 0x0134 }
            r6 = 2
            r13[r6] = r5     // Catch:{ SQLiteException -> 0x0139, all -> 0x0134 }
            r16 = r10
            r17 = r13
            goto L_0x0197
        L_0x0189:
            java.lang.String r5 = "app_id = ? and metadata_fingerprint = ?"
            r6 = 2
            java.lang.String[] r10 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x024f, all -> 0x024b }
            r10[r3] = r11     // Catch:{ SQLiteException -> 0x024f, all -> 0x024b }
            r6 = 1
            r10[r6] = r7     // Catch:{ SQLiteException -> 0x024f, all -> 0x024b }
            r16 = r5
            r17 = r10
        L_0x0197:
            java.lang.String r14 = "raw_events"
            java.lang.String r5 = "rowid"
            java.lang.String r6 = "name"
            java.lang.String r7 = "timestamp"
            java.lang.String r10 = "data"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r10}     // Catch:{ SQLiteException -> 0x024f, all -> 0x024b }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            r21 = 0
            r13 = r24
            r6 = r15
            r15 = r5
            android.database.Cursor r5 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x0249 }
            boolean r6 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            if (r6 != 0) goto L_0x01d2
            com.google.android.gms.measurement.internal.dy r6 = r4.J_()     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            com.google.android.gms.measurement.internal.ea r6 = r6.f11831f     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            java.lang.String r7 = "Raw event data disappeared while in transaction. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            r6.a(r7, r10)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            if (r5 == 0) goto L_0x027f
            r5.close()     // Catch:{ all -> 0x0e98 }
            goto L_0x027f
        L_0x01d2:
            long r6 = r5.getLong(r3)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            r10 = 3
            byte[] r12 = r5.getBlob(r10)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            com.google.android.gms.internal.measurement.aj$c$a r10 = com.google.android.gms.internal.measurement.aj.c.c()     // Catch:{ IOException -> 0x020b }
            com.google.android.gms.internal.measurement.fe r10 = com.google.android.gms.measurement.internal.jn.a(r10, (byte[]) r12)     // Catch:{ IOException -> 0x020b }
            com.google.android.gms.internal.measurement.aj$c$a r10 = (com.google.android.gms.internal.measurement.aj.c.a) r10     // Catch:{ IOException -> 0x020b }
            r12 = 1
            java.lang.String r13 = r5.getString(r12)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            com.google.android.gms.internal.measurement.aj$c$a r12 = r10.a((java.lang.String) r13)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            r13 = 2
            long r14 = r5.getLong(r13)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            r12.a((long) r14)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            com.google.android.gms.internal.measurement.ff r10 = r10.w()     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            com.google.android.gms.internal.measurement.dv r10 = (com.google.android.gms.internal.measurement.dv) r10     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            com.google.android.gms.internal.measurement.aj$c r10 = (com.google.android.gms.internal.measurement.aj.c) r10     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            boolean r6 = r2.a(r6, r10)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            if (r6 != 0) goto L_0x021c
            if (r5 == 0) goto L_0x027f
            r5.close()     // Catch:{ all -> 0x0e98 }
            goto L_0x027f
        L_0x020b:
            r0 = move-exception
            r6 = r0
            com.google.android.gms.measurement.internal.dy r7 = r4.J_()     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            com.google.android.gms.measurement.internal.ea r7 = r7.f11828c     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            java.lang.String r10 = "Data loss. Failed to merge raw event. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            r7.a(r10, r12, r6)     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
        L_0x021c:
            boolean r6 = r5.moveToNext()     // Catch:{ SQLiteException -> 0x022e, all -> 0x0229 }
            if (r6 != 0) goto L_0x01d2
            if (r5 == 0) goto L_0x027f
            r5.close()     // Catch:{ all -> 0x0e98 }
            goto L_0x027f
        L_0x0229:
            r0 = move-exception
            r2 = r0
            r6 = r5
            goto L_0x0e92
        L_0x022e:
            r0 = move-exception
            r6 = r5
            goto L_0x0251
        L_0x0231:
            r0 = move-exception
            r6 = r15
            r5 = r0
            com.google.android.gms.measurement.internal.dy r7 = r4.J_()     // Catch:{ SQLiteException -> 0x0249 }
            com.google.android.gms.measurement.internal.ea r7 = r7.f11828c     // Catch:{ SQLiteException -> 0x0249 }
            java.lang.String r10 = "Data loss. Failed to merge raw event metadata. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r11)     // Catch:{ SQLiteException -> 0x0249 }
            r7.a(r10, r12, r5)     // Catch:{ SQLiteException -> 0x0249 }
            if (r6 == 0) goto L_0x027f
            r6.close()     // Catch:{ all -> 0x0e98 }
            goto L_0x027f
        L_0x0249:
            r0 = move-exception
            goto L_0x0251
        L_0x024b:
            r0 = move-exception
            r6 = r15
            goto L_0x0e91
        L_0x024f:
            r0 = move-exception
            r6 = r15
        L_0x0251:
            r5 = r0
            goto L_0x026b
        L_0x0253:
            r0 = move-exception
            r2 = r0
            r6 = r22
            goto L_0x0e92
        L_0x0259:
            r0 = move-exception
            r5 = r0
            r6 = r22
            goto L_0x026b
        L_0x025e:
            r0 = move-exception
            r5 = r0
            r6 = r11
            goto L_0x026a
        L_0x0262:
            r0 = move-exception
            r2 = r0
            r6 = 0
            goto L_0x0e92
        L_0x0267:
            r0 = move-exception
            r5 = r0
            r6 = 0
        L_0x026a:
            r11 = 0
        L_0x026b:
            com.google.android.gms.measurement.internal.dy r4 = r4.J_()     // Catch:{ all -> 0x0e90 }
            com.google.android.gms.measurement.internal.ea r4 = r4.f11828c     // Catch:{ all -> 0x0e90 }
            java.lang.String r7 = "Data loss. Error selecting raw event. appId"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r11)     // Catch:{ all -> 0x0e90 }
            r4.a(r7, r10, r5)     // Catch:{ all -> 0x0e90 }
            if (r6 == 0) goto L_0x027f
            r6.close()     // Catch:{ all -> 0x0e98 }
        L_0x027f:
            java.util.List<com.google.android.gms.internal.measurement.aj$c> r4 = r2.f12275c     // Catch:{ all -> 0x0e98 }
            if (r4 == 0) goto L_0x028e
            java.util.List<com.google.android.gms.internal.measurement.aj$c> r4 = r2.f12275c     // Catch:{ all -> 0x0e98 }
            boolean r4 = r4.isEmpty()     // Catch:{ all -> 0x0e98 }
            if (r4 == 0) goto L_0x028c
            goto L_0x028e
        L_0x028c:
            r4 = 0
            goto L_0x028f
        L_0x028e:
            r4 = 1
        L_0x028f:
            if (r4 != 0) goto L_0x0e80
            com.google.android.gms.internal.measurement.aj$g r4 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv$b r4 = r4.m()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv$b r4 = (com.google.android.gms.internal.measurement.dv.b) r4     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g$a r4 = (com.google.android.gms.internal.measurement.aj.g.a) r4     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g$a r4 = r4.d()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.fc r5 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ke r5 = r5.f11945e     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r6 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r6 = r6.zzs     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.o.Z     // Catch:{ all -> 0x0e98 }
            boolean r5 = r5.d(r6, r7)     // Catch:{ all -> 0x0e98 }
            r6 = -1
            r8 = -1
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r16 = 0
        L_0x02b7:
            java.util.List<com.google.android.gms.internal.measurement.aj$c> r7 = r2.f12275c     // Catch:{ all -> 0x0e98 }
            int r7 = r7.size()     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = "_e"
            java.lang.String r3 = "_et"
            r21 = r12
            r25 = r13
            if (r11 >= r7) goto L_0x07de
            java.util.List<com.google.android.gms.internal.measurement.aj$c> r7 = r2.f12275c     // Catch:{ all -> 0x0e98 }
            java.lang.Object r7 = r7.get(r11)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c r7 = (com.google.android.gms.internal.measurement.aj.c) r7     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv$b r7 = r7.m()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv$b r7 = (com.google.android.gms.internal.measurement.dv.b) r7     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c$a r7 = (com.google.android.gms.internal.measurement.aj.c.a) r7     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ev r14 = r53.a()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r12 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r12 = r12.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.String r13 = r7.d()     // Catch:{ all -> 0x0e98 }
            boolean r12 = r14.b(r12, r13)     // Catch:{ all -> 0x0e98 }
            java.lang.String r13 = "_err"
            if (r12 == 0) goto L_0x035e
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11831f     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = "Dropping blacklisted raw event. appId"
            com.google.android.gms.internal.measurement.aj$g r12 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r12 = r12.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r12)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.fc r14 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dw r14 = r14.f()     // Catch:{ all -> 0x0e98 }
            r22 = r15
            java.lang.String r15 = r7.d()     // Catch:{ all -> 0x0e98 }
            java.lang.String r14 = r14.a((java.lang.String) r15)     // Catch:{ all -> 0x0e98 }
            r3.a(r10, r12, r14)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ev r3 = r53.a()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r10 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = r10.zzs     // Catch:{ all -> 0x0e98 }
            boolean r3 = r3.g(r10)     // Catch:{ all -> 0x0e98 }
            if (r3 != 0) goto L_0x032f
            com.google.android.gms.measurement.internal.ev r3 = r53.a()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r10 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = r10.zzs     // Catch:{ all -> 0x0e98 }
            boolean r3 = r3.h(r10)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x032d
            goto L_0x032f
        L_0x032d:
            r3 = 0
            goto L_0x0330
        L_0x032f:
            r3 = 1
        L_0x0330:
            if (r3 != 0) goto L_0x034e
            java.lang.String r3 = r7.d()     // Catch:{ all -> 0x0e98 }
            boolean r3 = r13.equals(r3)     // Catch:{ all -> 0x0e98 }
            if (r3 != 0) goto L_0x034e
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.jq r3 = r3.e()     // Catch:{ all -> 0x0e98 }
            r10 = 11
            java.lang.String r12 = "_ev"
            java.lang.String r7 = r7.d()     // Catch:{ all -> 0x0e98 }
            r13 = 0
            r3.b(r10, r12, r7, r13)     // Catch:{ all -> 0x0e98 }
        L_0x034e:
            r27 = r5
            r30 = r9
            r10 = r11
            r12 = r21
            r15 = r22
            r13 = r25
            r9 = 3
            r11 = r4
            r4 = -1
            goto L_0x07d3
        L_0x035e:
            r22 = r15
            com.google.android.gms.measurement.internal.ev r12 = r53.a()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r14 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r14 = r14.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.String r15 = r7.d()     // Catch:{ all -> 0x0e98 }
            boolean r12 = r12.c(r14, r15)     // Catch:{ all -> 0x0e98 }
            java.lang.String r14 = "_c"
            if (r12 != 0) goto L_0x03cc
            r53.e()     // Catch:{ all -> 0x0e98 }
            java.lang.String r15 = r7.d()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.common.internal.s.a((java.lang.String) r15)     // Catch:{ all -> 0x0e98 }
            r24 = r11
            int r11 = r15.hashCode()     // Catch:{ all -> 0x0e98 }
            r27 = r5
            r5 = 94660(0x171c4, float:1.32647E-40)
            if (r11 == r5) goto L_0x03aa
            r5 = 95025(0x17331, float:1.33158E-40)
            if (r11 == r5) goto L_0x03a0
            r5 = 95027(0x17333, float:1.33161E-40)
            if (r11 == r5) goto L_0x0396
            goto L_0x03b4
        L_0x0396:
            java.lang.String r5 = "_ui"
            boolean r5 = r15.equals(r5)     // Catch:{ all -> 0x0e98 }
            if (r5 == 0) goto L_0x03b4
            r5 = 1
            goto L_0x03b5
        L_0x03a0:
            java.lang.String r5 = "_ug"
            boolean r5 = r15.equals(r5)     // Catch:{ all -> 0x0e98 }
            if (r5 == 0) goto L_0x03b4
            r5 = 2
            goto L_0x03b5
        L_0x03aa:
            java.lang.String r5 = "_in"
            boolean r5 = r15.equals(r5)     // Catch:{ all -> 0x0e98 }
            if (r5 == 0) goto L_0x03b4
            r5 = 0
            goto L_0x03b5
        L_0x03b4:
            r5 = -1
        L_0x03b5:
            if (r5 == 0) goto L_0x03bf
            r11 = 1
            if (r5 == r11) goto L_0x03bf
            r11 = 2
            if (r5 == r11) goto L_0x03bf
            r5 = 0
            goto L_0x03c0
        L_0x03bf:
            r5 = 1
        L_0x03c0:
            if (r5 == 0) goto L_0x03c3
            goto L_0x03d0
        L_0x03c3:
            r29 = r3
            r11 = r4
            r28 = r8
            r30 = r9
            goto L_0x0590
        L_0x03cc:
            r27 = r5
            r24 = r11
        L_0x03d0:
            r28 = r8
            r5 = 0
            r11 = 0
            r15 = 0
        L_0x03d5:
            int r8 = r7.b()     // Catch:{ all -> 0x0e98 }
            r29 = r3
            java.lang.String r3 = "_r"
            if (r5 >= r8) goto L_0x043f
            com.google.android.gms.internal.measurement.aj$e r8 = r7.a((int) r5)     // Catch:{ all -> 0x0e98 }
            java.lang.String r8 = r8.zzd     // Catch:{ all -> 0x0e98 }
            boolean r8 = r14.equals(r8)     // Catch:{ all -> 0x0e98 }
            if (r8 == 0) goto L_0x040c
            com.google.android.gms.internal.measurement.aj$e r3 = r7.a((int) r5)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv$b r3 = r3.m()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv$b r3 = (com.google.android.gms.internal.measurement.dv.b) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e$a r3 = (com.google.android.gms.internal.measurement.aj.e.a) r3     // Catch:{ all -> 0x0e98 }
            r30 = r9
            r8 = 1
            com.google.android.gms.internal.measurement.aj$e$a r3 = r3.a((long) r8)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ff r3 = r3.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r3 = (com.google.android.gms.internal.measurement.dv) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e r3 = (com.google.android.gms.internal.measurement.aj.e) r3     // Catch:{ all -> 0x0e98 }
            r7.a((int) r5, (com.google.android.gms.internal.measurement.aj.e) r3)     // Catch:{ all -> 0x0e98 }
            r11 = 1
            goto L_0x0438
        L_0x040c:
            r30 = r9
            com.google.android.gms.internal.measurement.aj$e r8 = r7.a((int) r5)     // Catch:{ all -> 0x0e98 }
            java.lang.String r8 = r8.zzd     // Catch:{ all -> 0x0e98 }
            boolean r3 = r3.equals(r8)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x0438
            com.google.android.gms.internal.measurement.aj$e r3 = r7.a((int) r5)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv$b r3 = r3.m()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv$b r3 = (com.google.android.gms.internal.measurement.dv.b) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e$a r3 = (com.google.android.gms.internal.measurement.aj.e.a) r3     // Catch:{ all -> 0x0e98 }
            r8 = 1
            com.google.android.gms.internal.measurement.aj$e$a r3 = r3.a((long) r8)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ff r3 = r3.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r3 = (com.google.android.gms.internal.measurement.dv) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e r3 = (com.google.android.gms.internal.measurement.aj.e) r3     // Catch:{ all -> 0x0e98 }
            r7.a((int) r5, (com.google.android.gms.internal.measurement.aj.e) r3)     // Catch:{ all -> 0x0e98 }
            r15 = 1
        L_0x0438:
            int r5 = r5 + 1
            r3 = r29
            r9 = r30
            goto L_0x03d5
        L_0x043f:
            r30 = r9
            if (r11 != 0) goto L_0x0471
            if (r12 == 0) goto L_0x0471
            com.google.android.gms.measurement.internal.fc r5 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r5 = r5.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r5 = r5.k     // Catch:{ all -> 0x0e98 }
            java.lang.String r8 = "Marking event as conversion"
            com.google.android.gms.measurement.internal.fc r9 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dw r9 = r9.f()     // Catch:{ all -> 0x0e98 }
            java.lang.String r11 = r7.d()     // Catch:{ all -> 0x0e98 }
            java.lang.String r9 = r9.a((java.lang.String) r11)     // Catch:{ all -> 0x0e98 }
            r5.a(r8, r9)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e$a r5 = com.google.android.gms.internal.measurement.aj.e.d()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e$a r5 = r5.a((java.lang.String) r14)     // Catch:{ all -> 0x0e98 }
            r8 = 1
            com.google.android.gms.internal.measurement.aj$e$a r5 = r5.a((long) r8)     // Catch:{ all -> 0x0e98 }
            r7.a((com.google.android.gms.internal.measurement.aj.e.a) r5)     // Catch:{ all -> 0x0e98 }
        L_0x0471:
            if (r15 != 0) goto L_0x049f
            com.google.android.gms.measurement.internal.fc r5 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r5 = r5.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r5 = r5.k     // Catch:{ all -> 0x0e98 }
            java.lang.String r8 = "Marking event as real-time"
            com.google.android.gms.measurement.internal.fc r9 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dw r9 = r9.f()     // Catch:{ all -> 0x0e98 }
            java.lang.String r11 = r7.d()     // Catch:{ all -> 0x0e98 }
            java.lang.String r9 = r9.a((java.lang.String) r11)     // Catch:{ all -> 0x0e98 }
            r5.a(r8, r9)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e$a r5 = com.google.android.gms.internal.measurement.aj.e.d()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e$a r5 = r5.a((java.lang.String) r3)     // Catch:{ all -> 0x0e98 }
            r8 = 1
            com.google.android.gms.internal.measurement.aj$e$a r5 = r5.a((long) r8)     // Catch:{ all -> 0x0e98 }
            r7.a((com.google.android.gms.internal.measurement.aj.e.a) r5)     // Catch:{ all -> 0x0e98 }
        L_0x049f:
            com.google.android.gms.measurement.internal.d r31 = r53.c()     // Catch:{ all -> 0x0e98 }
            long r32 = r53.q()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r5 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = r5.zzs     // Catch:{ all -> 0x0e98 }
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 1
            r34 = r5
            com.google.android.gms.measurement.internal.c r5 = r31.a(r32, r34, r35, r36, r37, r38, r39)     // Catch:{ all -> 0x0e98 }
            long r8 = r5.f11747e     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.fc r5 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ke r5 = r5.f11945e     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r11 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r11 = r11.zzs     // Catch:{ all -> 0x0e98 }
            int r5 = r5.a((java.lang.String) r11)     // Catch:{ all -> 0x0e98 }
            r11 = r4
            long r4 = (long) r5     // Catch:{ all -> 0x0e98 }
            int r15 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r15 <= 0) goto L_0x04d3
            a((com.google.android.gms.internal.measurement.aj.c.a) r7, (java.lang.String) r3)     // Catch:{ all -> 0x0e98 }
            goto L_0x04d5
        L_0x04d3:
            r21 = 1
        L_0x04d5:
            java.lang.String r3 = r7.d()     // Catch:{ all -> 0x0e98 }
            boolean r3 = com.google.android.gms.measurement.internal.jq.a((java.lang.String) r3)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x0590
            if (r12 == 0) goto L_0x0590
            com.google.android.gms.measurement.internal.d r31 = r53.c()     // Catch:{ all -> 0x0e98 }
            long r32 = r53.q()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r3 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r3 = r3.zzs     // Catch:{ all -> 0x0e98 }
            r35 = 0
            r36 = 0
            r37 = 1
            r38 = 0
            r39 = 0
            r34 = r3
            com.google.android.gms.measurement.internal.c r3 = r31.a(r32, r34, r35, r36, r37, r38, r39)     // Catch:{ all -> 0x0e98 }
            long r3 = r3.f11745c     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.fc r5 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ke r5 = r5.f11945e     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r8 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r8 = r8.zzs     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dn<java.lang.Integer> r9 = com.google.android.gms.measurement.internal.o.n     // Catch:{ all -> 0x0e98 }
            int r5 = r5.b(r8, r9)     // Catch:{ all -> 0x0e98 }
            long r8 = (long) r5     // Catch:{ all -> 0x0e98 }
            int r5 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r5 <= 0) goto L_0x0590
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11831f     // Catch:{ all -> 0x0e98 }
            java.lang.String r4 = "Too many conversions. Not logging as conversion. appId"
            com.google.android.gms.internal.measurement.aj$g r5 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = r5.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r5)     // Catch:{ all -> 0x0e98 }
            r3.a(r4, r5)     // Catch:{ all -> 0x0e98 }
            r3 = 0
            r4 = 0
            r5 = 0
            r8 = -1
        L_0x052b:
            int r9 = r7.b()     // Catch:{ all -> 0x0e98 }
            if (r3 >= r9) goto L_0x0553
            com.google.android.gms.internal.measurement.aj$e r9 = r7.a((int) r3)     // Catch:{ all -> 0x0e98 }
            java.lang.String r15 = r9.zzd     // Catch:{ all -> 0x0e98 }
            boolean r15 = r14.equals(r15)     // Catch:{ all -> 0x0e98 }
            if (r15 == 0) goto L_0x0547
            com.google.android.gms.internal.measurement.dv$b r5 = r9.m()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv$b r5 = (com.google.android.gms.internal.measurement.dv.b) r5     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e$a r5 = (com.google.android.gms.internal.measurement.aj.e.a) r5     // Catch:{ all -> 0x0e98 }
            r8 = r3
            goto L_0x0550
        L_0x0547:
            java.lang.String r9 = r9.zzd     // Catch:{ all -> 0x0e98 }
            boolean r9 = r13.equals(r9)     // Catch:{ all -> 0x0e98 }
            if (r9 == 0) goto L_0x0550
            r4 = 1
        L_0x0550:
            int r3 = r3 + 1
            goto L_0x052b
        L_0x0553:
            if (r4 == 0) goto L_0x055b
            if (r5 == 0) goto L_0x055b
            r7.b((int) r8)     // Catch:{ all -> 0x0e98 }
            goto L_0x0590
        L_0x055b:
            if (r5 == 0) goto L_0x057b
            java.lang.Object r3 = r5.clone()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv$b r3 = (com.google.android.gms.internal.measurement.dv.b) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e$a r3 = (com.google.android.gms.internal.measurement.aj.e.a) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e$a r3 = r3.a((java.lang.String) r13)     // Catch:{ all -> 0x0e98 }
            r4 = 10
            com.google.android.gms.internal.measurement.aj$e$a r3 = r3.a((long) r4)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ff r3 = r3.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r3 = (com.google.android.gms.internal.measurement.dv) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e r3 = (com.google.android.gms.internal.measurement.aj.e) r3     // Catch:{ all -> 0x0e98 }
            r7.a((int) r8, (com.google.android.gms.internal.measurement.aj.e) r3)     // Catch:{ all -> 0x0e98 }
            goto L_0x0590
        L_0x057b:
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c     // Catch:{ all -> 0x0e98 }
            java.lang.String r4 = "Did not find conversion parameter. appId"
            com.google.android.gms.internal.measurement.aj$g r5 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = r5.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r5)     // Catch:{ all -> 0x0e98 }
            r3.a(r4, r5)     // Catch:{ all -> 0x0e98 }
        L_0x0590:
            if (r12 == 0) goto L_0x064f
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0e98 }
            java.util.List r4 = r7.a()     // Catch:{ all -> 0x0e98 }
            r3.<init>(r4)     // Catch:{ all -> 0x0e98 }
            r4 = 0
            r5 = -1
            r8 = -1
        L_0x059e:
            int r9 = r3.size()     // Catch:{ all -> 0x0e98 }
            if (r4 >= r9) goto L_0x05cb
            java.lang.String r9 = "value"
            java.lang.Object r12 = r3.get(r4)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e r12 = (com.google.android.gms.internal.measurement.aj.e) r12     // Catch:{ all -> 0x0e98 }
            java.lang.String r12 = r12.zzd     // Catch:{ all -> 0x0e98 }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x0e98 }
            if (r9 == 0) goto L_0x05b7
            r5 = r4
            goto L_0x05c8
        L_0x05b7:
            java.lang.String r9 = "currency"
            java.lang.Object r12 = r3.get(r4)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e r12 = (com.google.android.gms.internal.measurement.aj.e) r12     // Catch:{ all -> 0x0e98 }
            java.lang.String r12 = r12.zzd     // Catch:{ all -> 0x0e98 }
            boolean r9 = r9.equals(r12)     // Catch:{ all -> 0x0e98 }
            if (r9 == 0) goto L_0x05c8
            r8 = r4
        L_0x05c8:
            int r4 = r4 + 1
            goto L_0x059e
        L_0x05cb:
            r4 = -1
            if (r5 == r4) goto L_0x0650
            java.lang.Object r4 = r3.get(r5)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e r4 = (com.google.android.gms.internal.measurement.aj.e) r4     // Catch:{ all -> 0x0e98 }
            boolean r4 = r4.b()     // Catch:{ all -> 0x0e98 }
            if (r4 != 0) goto L_0x0602
            java.lang.Object r4 = r3.get(r5)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e r4 = (com.google.android.gms.internal.measurement.aj.e) r4     // Catch:{ all -> 0x0e98 }
            boolean r4 = r4.c()     // Catch:{ all -> 0x0e98 }
            if (r4 != 0) goto L_0x0602
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11833h     // Catch:{ all -> 0x0e98 }
            java.lang.String r4 = "Value must be specified with a numeric type."
            r3.a(r4)     // Catch:{ all -> 0x0e98 }
            r7.b((int) r5)     // Catch:{ all -> 0x0e98 }
            a((com.google.android.gms.internal.measurement.aj.c.a) r7, (java.lang.String) r14)     // Catch:{ all -> 0x0e98 }
            r3 = 18
            java.lang.String r4 = "value"
            a((com.google.android.gms.internal.measurement.aj.c.a) r7, (int) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0e98 }
            goto L_0x064f
        L_0x0602:
            r4 = -1
            if (r8 != r4) goto L_0x0608
            r3 = 1
            r9 = 3
            goto L_0x0632
        L_0x0608:
            java.lang.Object r3 = r3.get(r8)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e r3 = (com.google.android.gms.internal.measurement.aj.e) r3     // Catch:{ all -> 0x0e98 }
            java.lang.String r3 = r3.zze     // Catch:{ all -> 0x0e98 }
            int r8 = r3.length()     // Catch:{ all -> 0x0e98 }
            r9 = 3
            if (r8 == r9) goto L_0x0619
        L_0x0617:
            r3 = 1
            goto L_0x0632
        L_0x0619:
            r8 = 0
        L_0x061a:
            int r12 = r3.length()     // Catch:{ all -> 0x0e98 }
            if (r8 >= r12) goto L_0x0631
            int r12 = r3.codePointAt(r8)     // Catch:{ all -> 0x0e98 }
            boolean r13 = java.lang.Character.isLetter(r12)     // Catch:{ all -> 0x0e98 }
            if (r13 != 0) goto L_0x062b
            goto L_0x0617
        L_0x062b:
            int r12 = java.lang.Character.charCount(r12)     // Catch:{ all -> 0x0e98 }
            int r8 = r8 + r12
            goto L_0x061a
        L_0x0631:
            r3 = 0
        L_0x0632:
            if (r3 == 0) goto L_0x0651
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11833h     // Catch:{ all -> 0x0e98 }
            java.lang.String r8 = "Value parameter discarded. You must also supply a 3-letter ISO_4217 currency code in the currency parameter."
            r3.a(r8)     // Catch:{ all -> 0x0e98 }
            r7.b((int) r5)     // Catch:{ all -> 0x0e98 }
            a((com.google.android.gms.internal.measurement.aj.c.a) r7, (java.lang.String) r14)     // Catch:{ all -> 0x0e98 }
            r3 = 19
            java.lang.String r5 = "currency"
            a((com.google.android.gms.internal.measurement.aj.c.a) r7, (int) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0e98 }
            goto L_0x0651
        L_0x064f:
            r4 = -1
        L_0x0650:
            r9 = 3
        L_0x0651:
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ke r3 = r3.f11945e     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r5 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = r5.zzs     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r8 = com.google.android.gms.measurement.internal.o.Y     // Catch:{ all -> 0x0e98 }
            boolean r3 = r3.d(r5, r8)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x075f
            java.lang.String r3 = r7.d()     // Catch:{ all -> 0x0e98 }
            boolean r3 = r10.equals(r3)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x06b6
            r53.e()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ff r3 = r7.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r3 = (com.google.android.gms.internal.measurement.dv) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c r3 = (com.google.android.gms.internal.measurement.aj.c) r3     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = "_fr"
            com.google.android.gms.internal.measurement.aj$e r3 = com.google.android.gms.measurement.internal.jn.a((com.google.android.gms.internal.measurement.aj.c) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0e98 }
            if (r3 != 0) goto L_0x075f
            if (r30 == 0) goto L_0x06ae
            long r12 = r30.f()     // Catch:{ all -> 0x0e98 }
            long r14 = r7.f()     // Catch:{ all -> 0x0e98 }
            long r12 = r12 - r14
            long r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x0e98 }
            r14 = 1000(0x3e8, double:4.94E-321)
            int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r3 > 0) goto L_0x06ae
            java.lang.Object r3 = r30.clone()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv$b r3 = (com.google.android.gms.internal.measurement.dv.b) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c$a r3 = (com.google.android.gms.internal.measurement.aj.c.a) r3     // Catch:{ all -> 0x0e98 }
            boolean r5 = r1.a((com.google.android.gms.internal.measurement.aj.c.a) r7, (com.google.android.gms.internal.measurement.aj.c.a) r3)     // Catch:{ all -> 0x0e98 }
            if (r5 == 0) goto L_0x06ae
            r11.a((int) r6, (com.google.android.gms.internal.measurement.aj.c.a) r3)     // Catch:{ all -> 0x0e98 }
            r8 = r28
            r5 = r29
        L_0x06a8:
            r16 = 0
            r30 = 0
            goto L_0x0763
        L_0x06ae:
            r16 = r7
            r8 = r22
        L_0x06b2:
            r5 = r29
            goto L_0x0763
        L_0x06b6:
            java.lang.String r3 = "_vs"
            java.lang.String r5 = r7.d()     // Catch:{ all -> 0x0e98 }
            boolean r3 = r3.equals(r5)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x0708
            r53.e()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ff r3 = r7.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r3 = (com.google.android.gms.internal.measurement.dv) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c r3 = (com.google.android.gms.internal.measurement.aj.c) r3     // Catch:{ all -> 0x0e98 }
            r5 = r29
            com.google.android.gms.internal.measurement.aj$e r3 = com.google.android.gms.measurement.internal.jn.a((com.google.android.gms.internal.measurement.aj.c) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0e98 }
            if (r3 != 0) goto L_0x0705
            if (r16 == 0) goto L_0x06fe
            long r12 = r16.f()     // Catch:{ all -> 0x0e98 }
            long r14 = r7.f()     // Catch:{ all -> 0x0e98 }
            long r12 = r12 - r14
            long r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x0e98 }
            r14 = 1000(0x3e8, double:4.94E-321)
            int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r3 > 0) goto L_0x06fe
            java.lang.Object r3 = r16.clone()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv$b r3 = (com.google.android.gms.internal.measurement.dv.b) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c$a r3 = (com.google.android.gms.internal.measurement.aj.c.a) r3     // Catch:{ all -> 0x0e98 }
            boolean r8 = r1.a((com.google.android.gms.internal.measurement.aj.c.a) r3, (com.google.android.gms.internal.measurement.aj.c.a) r7)     // Catch:{ all -> 0x0e98 }
            if (r8 == 0) goto L_0x06fe
            r8 = r28
            r11.a((int) r8, (com.google.android.gms.internal.measurement.aj.c.a) r3)     // Catch:{ all -> 0x0e98 }
            goto L_0x06a8
        L_0x06fe:
            r8 = r28
            r30 = r7
            r6 = r22
            goto L_0x0763
        L_0x0705:
            r8 = r28
            goto L_0x0763
        L_0x0708:
            r8 = r28
            r5 = r29
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ke r3 = r3.f11945e     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r12 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r12 = r12.zzs     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.o.aG     // Catch:{ all -> 0x0e98 }
            boolean r3 = r3.d(r12, r13)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x0763
            java.lang.String r3 = "_ab"
            java.lang.String r12 = r7.d()     // Catch:{ all -> 0x0e98 }
            boolean r3 = r3.equals(r12)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x0763
            r53.e()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ff r3 = r7.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r3 = (com.google.android.gms.internal.measurement.dv) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c r3 = (com.google.android.gms.internal.measurement.aj.c) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e r3 = com.google.android.gms.measurement.internal.jn.a((com.google.android.gms.internal.measurement.aj.c) r3, (java.lang.String) r5)     // Catch:{ all -> 0x0e98 }
            if (r3 != 0) goto L_0x0763
            if (r16 == 0) goto L_0x0763
            long r12 = r16.f()     // Catch:{ all -> 0x0e98 }
            long r14 = r7.f()     // Catch:{ all -> 0x0e98 }
            long r12 = r12 - r14
            long r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x0e98 }
            r14 = 4000(0xfa0, double:1.9763E-320)
            int r3 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r3 > 0) goto L_0x0763
            java.lang.Object r3 = r16.clone()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv$b r3 = (com.google.android.gms.internal.measurement.dv.b) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c$a r3 = (com.google.android.gms.internal.measurement.aj.c.a) r3     // Catch:{ all -> 0x0e98 }
            r1.b((com.google.android.gms.internal.measurement.aj.c.a) r3, (com.google.android.gms.internal.measurement.aj.c.a) r7)     // Catch:{ all -> 0x0e98 }
            r11.a((int) r8, (com.google.android.gms.internal.measurement.aj.c.a) r3)     // Catch:{ all -> 0x0e98 }
            r16 = 0
            goto L_0x0763
        L_0x075f:
            r8 = r28
            goto L_0x06b2
        L_0x0763:
            if (r27 != 0) goto L_0x07bb
            java.lang.String r3 = r7.d()     // Catch:{ all -> 0x0e98 }
            boolean r3 = r10.equals(r3)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x07bb
            int r3 = r7.b()     // Catch:{ all -> 0x0e98 }
            if (r3 != 0) goto L_0x078b
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11831f     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = "Engagement event does not contain any parameters. appId"
            com.google.android.gms.internal.measurement.aj$g r10 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = r10.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r10)     // Catch:{ all -> 0x0e98 }
            r3.a(r5, r10)     // Catch:{ all -> 0x0e98 }
            goto L_0x07bb
        L_0x078b:
            r53.e()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ff r3 = r7.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r3 = (com.google.android.gms.internal.measurement.dv) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c r3 = (com.google.android.gms.internal.measurement.aj.c) r3     // Catch:{ all -> 0x0e98 }
            java.lang.Object r3 = com.google.android.gms.measurement.internal.jn.b(r3, r5)     // Catch:{ all -> 0x0e98 }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ all -> 0x0e98 }
            if (r3 != 0) goto L_0x07b4
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11831f     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = "Engagement event does not include duration. appId"
            com.google.android.gms.internal.measurement.aj$g r10 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = r10.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.Object r10 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r10)     // Catch:{ all -> 0x0e98 }
            r3.a(r5, r10)     // Catch:{ all -> 0x0e98 }
            goto L_0x07bb
        L_0x07b4:
            long r12 = r3.longValue()     // Catch:{ all -> 0x0e98 }
            long r13 = r25 + r12
            goto L_0x07bd
        L_0x07bb:
            r13 = r25
        L_0x07bd:
            java.util.List<com.google.android.gms.internal.measurement.aj$c> r3 = r2.f12275c     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ff r5 = r7.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r5 = (com.google.android.gms.internal.measurement.dv) r5     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c r5 = (com.google.android.gms.internal.measurement.aj.c) r5     // Catch:{ all -> 0x0e98 }
            r10 = r24
            r3.set(r10, r5)     // Catch:{ all -> 0x0e98 }
            int r15 = r22 + 1
            r11.a((com.google.android.gms.internal.measurement.aj.c.a) r7)     // Catch:{ all -> 0x0e98 }
            r12 = r21
        L_0x07d3:
            int r3 = r10 + 1
            r4 = r11
            r5 = r27
            r9 = r30
            r11 = r3
            r3 = 0
            goto L_0x02b7
        L_0x07de:
            r11 = r4
            r27 = r5
            r22 = r15
            r5 = r3
            if (r27 == 0) goto L_0x0837
            r4 = r22
            r13 = r25
            r3 = 0
        L_0x07eb:
            if (r3 >= r4) goto L_0x0839
            com.google.android.gms.internal.measurement.aj$c r6 = r11.a((int) r3)     // Catch:{ all -> 0x0e98 }
            java.lang.String r7 = r6.zze     // Catch:{ all -> 0x0e98 }
            boolean r7 = r10.equals(r7)     // Catch:{ all -> 0x0e98 }
            if (r7 == 0) goto L_0x080c
            r53.e()     // Catch:{ all -> 0x0e98 }
            java.lang.String r7 = "_fr"
            com.google.android.gms.internal.measurement.aj$e r7 = com.google.android.gms.measurement.internal.jn.a((com.google.android.gms.internal.measurement.aj.c) r6, (java.lang.String) r7)     // Catch:{ all -> 0x0e98 }
            if (r7 == 0) goto L_0x080c
            r11.b((int) r3)     // Catch:{ all -> 0x0e98 }
            int r4 = r4 + -1
            int r3 = r3 + -1
            goto L_0x0834
        L_0x080c:
            r53.e()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e r6 = com.google.android.gms.measurement.internal.jn.a((com.google.android.gms.internal.measurement.aj.c) r6, (java.lang.String) r5)     // Catch:{ all -> 0x0e98 }
            if (r6 == 0) goto L_0x0834
            boolean r7 = r6.b()     // Catch:{ all -> 0x0e98 }
            if (r7 == 0) goto L_0x0822
            long r6 = r6.zzf     // Catch:{ all -> 0x0e98 }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0e98 }
            goto L_0x0823
        L_0x0822:
            r6 = 0
        L_0x0823:
            if (r6 == 0) goto L_0x0834
            long r7 = r6.longValue()     // Catch:{ all -> 0x0e98 }
            r15 = 0
            int r9 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r9 <= 0) goto L_0x0834
            long r6 = r6.longValue()     // Catch:{ all -> 0x0e98 }
            long r13 = r13 + r6
        L_0x0834:
            r6 = 1
            int r3 = r3 + r6
            goto L_0x07eb
        L_0x0837:
            r13 = r25
        L_0x0839:
            r3 = 0
            r1.a((com.google.android.gms.internal.measurement.aj.g.a) r11, (long) r13, (boolean) r3)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ke r3 = r3.f11945e     // Catch:{ all -> 0x0e98 }
            java.lang.String r4 = r11.k()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.o.an     // Catch:{ all -> 0x0e98 }
            boolean r3 = r3.d(r4, r5)     // Catch:{ all -> 0x0e98 }
            java.lang.String r4 = "_se"
            if (r3 == 0) goto L_0x08c1
            java.util.List r3 = r11.b()     // Catch:{ all -> 0x0e98 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0e98 }
        L_0x0857:
            boolean r5 = r3.hasNext()     // Catch:{ all -> 0x0e98 }
            if (r5 == 0) goto L_0x086f
            java.lang.Object r5 = r3.next()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c r5 = (com.google.android.gms.internal.measurement.aj.c) r5     // Catch:{ all -> 0x0e98 }
            java.lang.String r6 = "_s"
            java.lang.String r5 = r5.zze     // Catch:{ all -> 0x0e98 }
            boolean r5 = r6.equals(r5)     // Catch:{ all -> 0x0e98 }
            if (r5 == 0) goto L_0x0857
            r3 = 1
            goto L_0x0870
        L_0x086f:
            r3 = 0
        L_0x0870:
            if (r3 == 0) goto L_0x087d
            com.google.android.gms.measurement.internal.d r3 = r53.c()     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = r11.k()     // Catch:{ all -> 0x0e98 }
            r3.b((java.lang.String) r5, (java.lang.String) r4)     // Catch:{ all -> 0x0e98 }
        L_0x087d:
            com.google.android.gms.internal.measurement.lf.a()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ke r3 = r3.f11945e     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = r11.k()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.o.ao     // Catch:{ all -> 0x0e98 }
            boolean r3 = r3.d(r5, r6)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x08bc
            java.lang.String r3 = "_sid"
            int r3 = com.google.android.gms.measurement.internal.jn.a((com.google.android.gms.internal.measurement.aj.g.a) r11, (java.lang.String) r3)     // Catch:{ all -> 0x0e98 }
            if (r3 < 0) goto L_0x089a
            r3 = 1
            goto L_0x089b
        L_0x089a:
            r3 = 0
        L_0x089b:
            if (r3 != 0) goto L_0x08bc
            int r3 = com.google.android.gms.measurement.internal.jn.a((com.google.android.gms.internal.measurement.aj.g.a) r11, (java.lang.String) r4)     // Catch:{ all -> 0x0e98 }
            if (r3 < 0) goto L_0x08dc
            r11.d((int) r3)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11831f     // Catch:{ all -> 0x0e98 }
            java.lang.String r4 = "Session engagement user property is in the bundle without session ID. appId"
            com.google.android.gms.internal.measurement.aj$g r5 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = r5.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r5)     // Catch:{ all -> 0x0e98 }
            r3.a(r4, r5)     // Catch:{ all -> 0x0e98 }
            goto L_0x08dc
        L_0x08bc:
            r3 = 1
            r1.a((com.google.android.gms.internal.measurement.aj.g.a) r11, (long) r13, (boolean) r3)     // Catch:{ all -> 0x0e98 }
            goto L_0x08dc
        L_0x08c1:
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ke r3 = r3.f11945e     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = r11.k()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.o.aq     // Catch:{ all -> 0x0e98 }
            boolean r3 = r3.d(r5, r6)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x08dc
            com.google.android.gms.measurement.internal.d r3 = r53.c()     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = r11.k()     // Catch:{ all -> 0x0e98 }
            r3.b((java.lang.String) r5, (java.lang.String) r4)     // Catch:{ all -> 0x0e98 }
        L_0x08dc:
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ke r3 = r3.f11945e     // Catch:{ all -> 0x0e98 }
            java.lang.String r4 = r11.k()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.o.aa     // Catch:{ all -> 0x0e98 }
            boolean r3 = r3.d(r4, r5)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x097a
            com.google.android.gms.measurement.internal.jn r3 = r53.e()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r4 = r3.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r4 = r4.k     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = "Checking account type status for ad personalization signals"
            r4.a(r5)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ev r4 = r3.E_()     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = r11.k()     // Catch:{ all -> 0x0e98 }
            boolean r4 = r4.e(r5)     // Catch:{ all -> 0x0e98 }
            if (r4 == 0) goto L_0x097a
            com.google.android.gms.measurement.internal.d r4 = r3.F_()     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = r11.k()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.fb r4 = r4.b(r5)     // Catch:{ all -> 0x0e98 }
            if (r4 == 0) goto L_0x097a
            boolean r4 = r4.x()     // Catch:{ all -> 0x0e98 }
            if (r4 == 0) goto L_0x097a
            com.google.android.gms.measurement.internal.i r4 = r3.i()     // Catch:{ all -> 0x0e98 }
            boolean r4 = r4.e()     // Catch:{ all -> 0x0e98 }
            if (r4 == 0) goto L_0x097a
            com.google.android.gms.measurement.internal.dy r4 = r3.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r4 = r4.j     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = "Turning off ad personalization due to account type"
            r4.a(r5)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$k$a r4 = com.google.android.gms.internal.measurement.aj.k.d()     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = "_npa"
            com.google.android.gms.internal.measurement.aj$k$a r4 = r4.a((java.lang.String) r5)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.i r3 = r3.i()     // Catch:{ all -> 0x0e98 }
            r3.h()     // Catch:{ all -> 0x0e98 }
            long r5 = r3.f12163a     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$k$a r3 = r4.a((long) r5)     // Catch:{ all -> 0x0e98 }
            r4 = 1
            com.google.android.gms.internal.measurement.aj$k$a r3 = r3.b((long) r4)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ff r3 = r3.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r3 = (com.google.android.gms.internal.measurement.dv) r3     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$k r3 = (com.google.android.gms.internal.measurement.aj.k) r3     // Catch:{ all -> 0x0e98 }
            r4 = 0
        L_0x0958:
            int r5 = r11.f()     // Catch:{ all -> 0x0e98 }
            if (r4 >= r5) goto L_0x0974
            java.lang.String r5 = "_npa"
            com.google.android.gms.internal.measurement.aj$k r6 = r11.c((int) r4)     // Catch:{ all -> 0x0e98 }
            java.lang.String r6 = r6.zze     // Catch:{ all -> 0x0e98 }
            boolean r5 = r5.equals(r6)     // Catch:{ all -> 0x0e98 }
            if (r5 == 0) goto L_0x0971
            r11.a((int) r4, (com.google.android.gms.internal.measurement.aj.k) r3)     // Catch:{ all -> 0x0e98 }
            r4 = 1
            goto L_0x0975
        L_0x0971:
            int r4 = r4 + 1
            goto L_0x0958
        L_0x0974:
            r4 = 0
        L_0x0975:
            if (r4 != 0) goto L_0x097a
            r11.a((com.google.android.gms.internal.measurement.aj.k) r3)     // Catch:{ all -> 0x0e98 }
        L_0x097a:
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ke r3 = r3.f11945e     // Catch:{ all -> 0x0e98 }
            java.lang.String r4 = r11.k()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.o.aB     // Catch:{ all -> 0x0e98 }
            boolean r3 = r3.d(r4, r5)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x098d
            a((com.google.android.gms.internal.measurement.aj.g.a) r11)     // Catch:{ all -> 0x0e98 }
        L_0x098d:
            com.google.android.gms.internal.measurement.aj$g$a r3 = r11.o()     // Catch:{ all -> 0x0e98 }
            java.lang.String r4 = r11.k()     // Catch:{ all -> 0x0e98 }
            java.util.List r5 = r11.e()     // Catch:{ all -> 0x0e98 }
            java.util.List r6 = r11.b()     // Catch:{ all -> 0x0e98 }
            long r7 = r11.g()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.common.internal.s.a((java.lang.String) r4)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.jv r9 = r53.d()     // Catch:{ all -> 0x0e98 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0e98 }
            java.util.List r4 = r9.a(r4, r6, r5, r7)     // Catch:{ all -> 0x0e98 }
            r3.c((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.aj.a>) r4)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ke r3 = r3.f11945e     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r4 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r4 = r4.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = "1"
            com.google.android.gms.measurement.internal.kg r3 = r3.f12335a     // Catch:{ all -> 0x0e98 }
            java.lang.String r6 = "measurement.event_sampling_enabled"
            java.lang.String r3 = r3.a(r4, r6)     // Catch:{ all -> 0x0e98 }
            boolean r3 = r5.equals(r3)     // Catch:{ all -> 0x0e98 }
            if (r3 == 0) goto L_0x0ce9
            java.util.HashMap r3 = new java.util.HashMap     // Catch:{ all -> 0x0ce4 }
            r3.<init>()     // Catch:{ all -> 0x0ce4 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0ce4 }
            r4.<init>()     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.measurement.internal.fc r5 = r1.f12266b     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.measurement.internal.jq r5 = r5.e()     // Catch:{ all -> 0x0ce4 }
            java.security.SecureRandom r5 = r5.d()     // Catch:{ all -> 0x0ce4 }
            r6 = 0
        L_0x09e0:
            int r7 = r11.c()     // Catch:{ all -> 0x0ce4 }
            if (r6 >= r7) goto L_0x0caf
            com.google.android.gms.internal.measurement.aj$c r7 = r11.a((int) r6)     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.internal.measurement.dv$b r7 = r7.m()     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.internal.measurement.dv$b r7 = (com.google.android.gms.internal.measurement.dv.b) r7     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.internal.measurement.aj$c$a r7 = (com.google.android.gms.internal.measurement.aj.c.a) r7     // Catch:{ all -> 0x0ce4 }
            java.lang.String r8 = r7.d()     // Catch:{ all -> 0x0ce4 }
            java.lang.String r9 = "_ep"
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0ce4 }
            if (r8 == 0) goto L_0x0a70
            r53.e()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ff r8 = r7.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r8 = (com.google.android.gms.internal.measurement.dv) r8     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c r8 = (com.google.android.gms.internal.measurement.aj.c) r8     // Catch:{ all -> 0x0e98 }
            java.lang.String r9 = "_en"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.jn.b(r8, r9)     // Catch:{ all -> 0x0e98 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0e98 }
            java.lang.Object r9 = r3.get(r8)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.k r9 = (com.google.android.gms.measurement.internal.k) r9     // Catch:{ all -> 0x0e98 }
            if (r9 != 0) goto L_0x0a28
            com.google.android.gms.measurement.internal.d r9 = r53.c()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r10 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = r10.zzs     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.k r9 = r9.a((java.lang.String) r10, (java.lang.String) r8)     // Catch:{ all -> 0x0e98 }
            r3.put(r8, r9)     // Catch:{ all -> 0x0e98 }
        L_0x0a28:
            java.lang.Long r8 = r9.f12321i     // Catch:{ all -> 0x0e98 }
            if (r8 != 0) goto L_0x0a67
            java.lang.Long r8 = r9.j     // Catch:{ all -> 0x0e98 }
            long r12 = r8.longValue()     // Catch:{ all -> 0x0e98 }
            r14 = 1
            int r8 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r8 <= 0) goto L_0x0a42
            r53.e()     // Catch:{ all -> 0x0e98 }
            java.lang.String r8 = "_sr"
            java.lang.Long r10 = r9.j     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.jn.a((com.google.android.gms.internal.measurement.aj.c.a) r7, (java.lang.String) r8, (java.lang.Object) r10)     // Catch:{ all -> 0x0e98 }
        L_0x0a42:
            java.lang.Boolean r8 = r9.k     // Catch:{ all -> 0x0e98 }
            if (r8 == 0) goto L_0x0a5c
            java.lang.Boolean r8 = r9.k     // Catch:{ all -> 0x0e98 }
            boolean r8 = r8.booleanValue()     // Catch:{ all -> 0x0e98 }
            if (r8 == 0) goto L_0x0a5c
            r53.e()     // Catch:{ all -> 0x0e98 }
            java.lang.String r8 = "_efs"
            r9 = 1
            java.lang.Long r12 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.jn.a((com.google.android.gms.internal.measurement.aj.c.a) r7, (java.lang.String) r8, (java.lang.Object) r12)     // Catch:{ all -> 0x0e98 }
        L_0x0a5c:
            com.google.android.gms.internal.measurement.ff r8 = r7.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r8 = (com.google.android.gms.internal.measurement.dv) r8     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c r8 = (com.google.android.gms.internal.measurement.aj.c) r8     // Catch:{ all -> 0x0e98 }
            r4.add(r8)     // Catch:{ all -> 0x0e98 }
        L_0x0a67:
            r11.a((int) r6, (com.google.android.gms.internal.measurement.aj.c.a) r7)     // Catch:{ all -> 0x0e98 }
        L_0x0a6a:
            r19 = r2
            r15 = r5
            r1 = r6
            goto L_0x0ca6
        L_0x0a70:
            com.google.android.gms.measurement.internal.ev r8 = r53.a()     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.internal.measurement.aj$g r9 = r2.f12273a     // Catch:{ all -> 0x0ce4 }
            java.lang.String r9 = r9.zzs     // Catch:{ all -> 0x0ce4 }
            long r8 = r8.f(r9)     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.measurement.internal.fc r10 = r1.f12266b     // Catch:{ all -> 0x0ce4 }
            r10.e()     // Catch:{ all -> 0x0ce4 }
            long r12 = r7.f()     // Catch:{ all -> 0x0ce4 }
            long r12 = com.google.android.gms.measurement.internal.jq.a((long) r12, (long) r8)     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.internal.measurement.ff r10 = r7.w()     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.internal.measurement.dv r10 = (com.google.android.gms.internal.measurement.dv) r10     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.internal.measurement.aj$c r10 = (com.google.android.gms.internal.measurement.aj.c) r10     // Catch:{ all -> 0x0ce4 }
            java.lang.String r14 = "_dbg"
            r25 = r8
            r15 = 1
            java.lang.Long r8 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x0ce4 }
            boolean r9 = android.text.TextUtils.isEmpty(r14)     // Catch:{ all -> 0x0ce4 }
            if (r9 != 0) goto L_0x0ad1
            if (r8 != 0) goto L_0x0aa4
            goto L_0x0ad1
        L_0x0aa4:
            com.google.android.gms.internal.measurement.ed<com.google.android.gms.internal.measurement.aj$e> r9 = r10.zzd     // Catch:{ all -> 0x0e98 }
            java.util.Iterator r9 = r9.iterator()     // Catch:{ all -> 0x0e98 }
        L_0x0aaa:
            boolean r10 = r9.hasNext()     // Catch:{ all -> 0x0e98 }
            if (r10 == 0) goto L_0x0ad1
            java.lang.Object r10 = r9.next()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$e r10 = (com.google.android.gms.internal.measurement.aj.e) r10     // Catch:{ all -> 0x0e98 }
            java.lang.String r15 = r10.zzd     // Catch:{ all -> 0x0e98 }
            boolean r15 = r14.equals(r15)     // Catch:{ all -> 0x0e98 }
            if (r15 == 0) goto L_0x0aaa
            boolean r9 = r8 instanceof java.lang.Long     // Catch:{ all -> 0x0e98 }
            if (r9 == 0) goto L_0x0ad1
            long r9 = r10.zzf     // Catch:{ all -> 0x0e98 }
            java.lang.Long r9 = java.lang.Long.valueOf(r9)     // Catch:{ all -> 0x0e98 }
            boolean r8 = r8.equals(r9)     // Catch:{ all -> 0x0e98 }
            if (r8 != 0) goto L_0x0acf
            goto L_0x0ad1
        L_0x0acf:
            r8 = 1
            goto L_0x0ad2
        L_0x0ad1:
            r8 = 0
        L_0x0ad2:
            if (r8 != 0) goto L_0x0ae5
            com.google.android.gms.measurement.internal.ev r8 = r53.a()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r9 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r9 = r9.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = r7.d()     // Catch:{ all -> 0x0e98 }
            int r8 = r8.d(r9, r10)     // Catch:{ all -> 0x0e98 }
            goto L_0x0ae6
        L_0x0ae5:
            r8 = 1
        L_0x0ae6:
            if (r8 > 0) goto L_0x0b0d
            com.google.android.gms.measurement.internal.fc r9 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r9 = r9.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r9 = r9.f11831f     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = "Sample rate must be positive. event, rate"
            java.lang.String r12 = r7.d()     // Catch:{ all -> 0x0e98 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0e98 }
            r9.a(r10, r12, r8)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ff r8 = r7.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r8 = (com.google.android.gms.internal.measurement.dv) r8     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c r8 = (com.google.android.gms.internal.measurement.aj.c) r8     // Catch:{ all -> 0x0e98 }
            r4.add(r8)     // Catch:{ all -> 0x0e98 }
            r11.a((int) r6, (com.google.android.gms.internal.measurement.aj.c.a) r7)     // Catch:{ all -> 0x0e98 }
            goto L_0x0a6a
        L_0x0b0d:
            java.lang.String r9 = r7.d()     // Catch:{ all -> 0x0ce4 }
            java.lang.Object r9 = r3.get(r9)     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.measurement.internal.k r9 = (com.google.android.gms.measurement.internal.k) r9     // Catch:{ all -> 0x0ce4 }
            if (r9 != 0) goto L_0x0b8f
            com.google.android.gms.measurement.internal.d r9 = r53.c()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r10 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = r10.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.String r14 = r7.d()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.k r9 = r9.a((java.lang.String) r10, (java.lang.String) r14)     // Catch:{ all -> 0x0e98 }
            if (r9 != 0) goto L_0x0b8f
            com.google.android.gms.measurement.internal.fc r9 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r9 = r9.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r9 = r9.f11831f     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = "Event being bundled has no eventAggregate. appId, eventName"
            com.google.android.gms.internal.measurement.aj$g r14 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r14 = r14.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.String r15 = r7.d()     // Catch:{ all -> 0x0e98 }
            r9.a(r10, r14, r15)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.fc r9 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ke r9 = r9.f11945e     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r10 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = r10.zzs     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.o.am     // Catch:{ all -> 0x0e98 }
            boolean r9 = r9.d(r10, r14)     // Catch:{ all -> 0x0e98 }
            if (r9 == 0) goto L_0x0b76
            com.google.android.gms.measurement.internal.k r9 = new com.google.android.gms.measurement.internal.k     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r10 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = r10.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.String r29 = r7.d()     // Catch:{ all -> 0x0e98 }
            r30 = 1
            r32 = 1
            r34 = 1
            long r36 = r7.f()     // Catch:{ all -> 0x0e98 }
            r38 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 0
            r27 = r9
            r28 = r10
            r27.<init>(r28, r29, r30, r32, r34, r36, r38, r40, r41, r42, r43)     // Catch:{ all -> 0x0e98 }
            goto L_0x0b8f
        L_0x0b76:
            com.google.android.gms.measurement.internal.k r9 = new com.google.android.gms.measurement.internal.k     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r10 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = r10.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.String r46 = r7.d()     // Catch:{ all -> 0x0e98 }
            r47 = 1
            r49 = 1
            long r51 = r7.f()     // Catch:{ all -> 0x0e98 }
            r44 = r9
            r45 = r10
            r44.<init>(r45, r46, r47, r49, r51)     // Catch:{ all -> 0x0e98 }
        L_0x0b8f:
            r53.e()     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.internal.measurement.ff r10 = r7.w()     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.internal.measurement.dv r10 = (com.google.android.gms.internal.measurement.dv) r10     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.internal.measurement.aj$c r10 = (com.google.android.gms.internal.measurement.aj.c) r10     // Catch:{ all -> 0x0ce4 }
            java.lang.String r14 = "_eid"
            java.lang.Object r10 = com.google.android.gms.measurement.internal.jn.b(r10, r14)     // Catch:{ all -> 0x0ce4 }
            java.lang.Long r10 = (java.lang.Long) r10     // Catch:{ all -> 0x0ce4 }
            if (r10 == 0) goto L_0x0ba6
            r14 = 1
            goto L_0x0ba7
        L_0x0ba6:
            r14 = 0
        L_0x0ba7:
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)     // Catch:{ all -> 0x0ce4 }
            r15 = 1
            if (r8 != r15) goto L_0x0bdc
            com.google.android.gms.internal.measurement.ff r8 = r7.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r8 = (com.google.android.gms.internal.measurement.dv) r8     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c r8 = (com.google.android.gms.internal.measurement.aj.c) r8     // Catch:{ all -> 0x0e98 }
            r4.add(r8)     // Catch:{ all -> 0x0e98 }
            boolean r8 = r14.booleanValue()     // Catch:{ all -> 0x0e98 }
            if (r8 == 0) goto L_0x0bd7
            java.lang.Long r8 = r9.f12321i     // Catch:{ all -> 0x0e98 }
            if (r8 != 0) goto L_0x0bcb
            java.lang.Long r8 = r9.j     // Catch:{ all -> 0x0e98 }
            if (r8 != 0) goto L_0x0bcb
            java.lang.Boolean r8 = r9.k     // Catch:{ all -> 0x0e98 }
            if (r8 == 0) goto L_0x0bd7
        L_0x0bcb:
            r8 = 0
            com.google.android.gms.measurement.internal.k r9 = r9.a(r8, r8, r8)     // Catch:{ all -> 0x0e98 }
            java.lang.String r8 = r7.d()     // Catch:{ all -> 0x0e98 }
            r3.put(r8, r9)     // Catch:{ all -> 0x0e98 }
        L_0x0bd7:
            r11.a((int) r6, (com.google.android.gms.internal.measurement.aj.c.a) r7)     // Catch:{ all -> 0x0e98 }
            goto L_0x0a6a
        L_0x0bdc:
            int r15 = r5.nextInt(r8)     // Catch:{ all -> 0x0ce4 }
            if (r15 != 0) goto L_0x0c21
            r53.e()     // Catch:{ all -> 0x0e98 }
            java.lang.String r10 = "_sr"
            r15 = r5
            r16 = r6
            long r5 = (long) r8     // Catch:{ all -> 0x0e98 }
            java.lang.Long r8 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.jn.a((com.google.android.gms.internal.measurement.aj.c.a) r7, (java.lang.String) r10, (java.lang.Object) r8)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ff r8 = r7.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r8 = (com.google.android.gms.internal.measurement.dv) r8     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$c r8 = (com.google.android.gms.internal.measurement.aj.c) r8     // Catch:{ all -> 0x0e98 }
            r4.add(r8)     // Catch:{ all -> 0x0e98 }
            boolean r8 = r14.booleanValue()     // Catch:{ all -> 0x0e98 }
            if (r8 == 0) goto L_0x0c0c
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0e98 }
            r6 = 0
            com.google.android.gms.measurement.internal.k r9 = r9.a(r6, r5, r6)     // Catch:{ all -> 0x0e98 }
        L_0x0c0c:
            java.lang.String r5 = r7.d()     // Catch:{ all -> 0x0e98 }
            r6 = r15
            long r14 = r7.f()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.k r8 = r9.a(r14, r12)     // Catch:{ all -> 0x0e98 }
            r3.put(r5, r8)     // Catch:{ all -> 0x0e98 }
            r19 = r2
            r15 = r6
            goto L_0x0ca1
        L_0x0c21:
            r16 = r6
            r6 = r5
            java.lang.Long r5 = r9.f12320h     // Catch:{ all -> 0x0ce4 }
            if (r5 == 0) goto L_0x0c32
            java.lang.Long r5 = r9.f12320h     // Catch:{ all -> 0x0e98 }
            long r25 = r5.longValue()     // Catch:{ all -> 0x0e98 }
            r19 = r2
            r15 = r6
            goto L_0x0c44
        L_0x0c32:
            com.google.android.gms.measurement.internal.fc r5 = r1.f12266b     // Catch:{ all -> 0x0ce4 }
            r5.e()     // Catch:{ all -> 0x0ce4 }
            r15 = r6
            long r5 = r7.g()     // Catch:{ all -> 0x0ce4 }
            r19 = r2
            r1 = r25
            long r25 = com.google.android.gms.measurement.internal.jq.a((long) r5, (long) r1)     // Catch:{ all -> 0x0ce4 }
        L_0x0c44:
            int r1 = (r25 > r12 ? 1 : (r25 == r12 ? 0 : -1))
            if (r1 == 0) goto L_0x0c8f
            r53.e()     // Catch:{ all -> 0x0ce4 }
            java.lang.String r1 = "_efs"
            r5 = 1
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.measurement.internal.jn.a((com.google.android.gms.internal.measurement.aj.c.a) r7, (java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x0ce4 }
            r53.e()     // Catch:{ all -> 0x0ce4 }
            java.lang.String r1 = "_sr"
            long r5 = (long) r8     // Catch:{ all -> 0x0ce4 }
            java.lang.Long r2 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.measurement.internal.jn.a((com.google.android.gms.internal.measurement.aj.c.a) r7, (java.lang.String) r1, (java.lang.Object) r2)     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.internal.measurement.ff r1 = r7.w()     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.internal.measurement.dv r1 = (com.google.android.gms.internal.measurement.dv) r1     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.internal.measurement.aj$c r1 = (com.google.android.gms.internal.measurement.aj.c) r1     // Catch:{ all -> 0x0ce4 }
            r4.add(r1)     // Catch:{ all -> 0x0ce4 }
            boolean r1 = r14.booleanValue()     // Catch:{ all -> 0x0ce4 }
            if (r1 == 0) goto L_0x0c7f
            java.lang.Long r1 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x0ce4 }
            java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0ce4 }
            r5 = 0
            com.google.android.gms.measurement.internal.k r9 = r9.a(r5, r1, r2)     // Catch:{ all -> 0x0ce4 }
        L_0x0c7f:
            java.lang.String r1 = r7.d()     // Catch:{ all -> 0x0ce4 }
            long r5 = r7.f()     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.measurement.internal.k r2 = r9.a(r5, r12)     // Catch:{ all -> 0x0ce4 }
            r3.put(r1, r2)     // Catch:{ all -> 0x0ce4 }
            goto L_0x0ca1
        L_0x0c8f:
            boolean r1 = r14.booleanValue()     // Catch:{ all -> 0x0ce4 }
            if (r1 == 0) goto L_0x0ca1
            java.lang.String r1 = r7.d()     // Catch:{ all -> 0x0ce4 }
            r2 = 0
            com.google.android.gms.measurement.internal.k r5 = r9.a(r10, r2, r2)     // Catch:{ all -> 0x0ce4 }
            r3.put(r1, r5)     // Catch:{ all -> 0x0ce4 }
        L_0x0ca1:
            r1 = r16
            r11.a((int) r1, (com.google.android.gms.internal.measurement.aj.c.a) r7)     // Catch:{ all -> 0x0ce4 }
        L_0x0ca6:
            int r6 = r1 + 1
            r1 = r53
            r5 = r15
            r2 = r19
            goto L_0x09e0
        L_0x0caf:
            r19 = r2
            int r1 = r4.size()     // Catch:{ all -> 0x0ce4 }
            int r2 = r11.c()     // Catch:{ all -> 0x0ce4 }
            if (r1 >= r2) goto L_0x0cc2
            com.google.android.gms.internal.measurement.aj$g$a r1 = r11.d()     // Catch:{ all -> 0x0ce4 }
            r1.a((java.lang.Iterable<? extends com.google.android.gms.internal.measurement.aj.c>) r4)     // Catch:{ all -> 0x0ce4 }
        L_0x0cc2:
            java.util.Set r1 = r3.entrySet()     // Catch:{ all -> 0x0ce4 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0ce4 }
        L_0x0cca:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0ce4 }
            if (r2 == 0) goto L_0x0ceb
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0ce4 }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.measurement.internal.d r3 = r53.c()     // Catch:{ all -> 0x0ce4 }
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x0ce4 }
            com.google.android.gms.measurement.internal.k r2 = (com.google.android.gms.measurement.internal.k) r2     // Catch:{ all -> 0x0ce4 }
            r3.a((com.google.android.gms.measurement.internal.k) r2)     // Catch:{ all -> 0x0ce4 }
            goto L_0x0cca
        L_0x0ce4:
            r0 = move-exception
            r1 = r53
            goto L_0x0e99
        L_0x0ce9:
            r19 = r2
        L_0x0ceb:
            r1 = r53
            com.google.android.gms.measurement.internal.fc r2 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ke r2 = r2.f11945e     // Catch:{ all -> 0x0e98 }
            java.lang.String r3 = r11.k()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.o.aB     // Catch:{ all -> 0x0e98 }
            boolean r2 = r2.d(r3, r4)     // Catch:{ all -> 0x0e98 }
            if (r2 != 0) goto L_0x0d00
            a((com.google.android.gms.internal.measurement.aj.g.a) r11)     // Catch:{ all -> 0x0e98 }
        L_0x0d00:
            r2 = r19
            com.google.android.gms.internal.measurement.aj$g r3 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r3 = r3.zzs     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.d r4 = r53.c()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.fb r4 = r4.b(r3)     // Catch:{ all -> 0x0e98 }
            if (r4 != 0) goto L_0x0d26
            com.google.android.gms.measurement.internal.fc r4 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r4 = r4.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r4 = r4.f11828c     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = "Bundling raw events w/o app info. appId"
            com.google.android.gms.internal.measurement.aj$g r6 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r6 = r6.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r6)     // Catch:{ all -> 0x0e98 }
            r4.a(r5, r6)     // Catch:{ all -> 0x0e98 }
            goto L_0x0d8c
        L_0x0d26:
            int r5 = r11.c()     // Catch:{ all -> 0x0e98 }
            if (r5 <= 0) goto L_0x0d8c
            long r5 = r4.j()     // Catch:{ all -> 0x0e98 }
            r7 = 0
            int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0d3a
            r11.e((long) r5)     // Catch:{ all -> 0x0e98 }
            goto L_0x0d3d
        L_0x0d3a:
            r11.j()     // Catch:{ all -> 0x0e98 }
        L_0x0d3d:
            long r7 = r4.i()     // Catch:{ all -> 0x0e98 }
            r9 = 0
            int r12 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r12 != 0) goto L_0x0d48
            goto L_0x0d49
        L_0x0d48:
            r5 = r7
        L_0x0d49:
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 == 0) goto L_0x0d51
            r11.d((long) r5)     // Catch:{ all -> 0x0e98 }
            goto L_0x0d54
        L_0x0d51:
            r11.i()     // Catch:{ all -> 0x0e98 }
        L_0x0d54:
            r4.u()     // Catch:{ all -> 0x0e98 }
            long r5 = r4.r()     // Catch:{ all -> 0x0e98 }
            int r6 = (int) r5     // Catch:{ all -> 0x0e98 }
            r11.f((int) r6)     // Catch:{ all -> 0x0e98 }
            long r5 = r11.g()     // Catch:{ all -> 0x0e98 }
            r4.a((long) r5)     // Catch:{ all -> 0x0e98 }
            long r5 = r11.h()     // Catch:{ all -> 0x0e98 }
            r4.b((long) r5)     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.fc r5 = r4.f11932a     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.eu r5 = r5.K_()     // Catch:{ all -> 0x0e98 }
            r5.h()     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = r4.f11940i     // Catch:{ all -> 0x0e98 }
            r6 = 0
            r4.i((java.lang.String) r6)     // Catch:{ all -> 0x0e98 }
            if (r5 == 0) goto L_0x0d82
            r11.j((java.lang.String) r5)     // Catch:{ all -> 0x0e98 }
            goto L_0x0d85
        L_0x0d82:
            r11.m()     // Catch:{ all -> 0x0e98 }
        L_0x0d85:
            com.google.android.gms.measurement.internal.d r5 = r53.c()     // Catch:{ all -> 0x0e98 }
            r5.a((com.google.android.gms.measurement.internal.fb) r4)     // Catch:{ all -> 0x0e98 }
        L_0x0d8c:
            int r4 = r11.c()     // Catch:{ all -> 0x0e98 }
            if (r4 <= 0) goto L_0x0de3
            com.google.android.gms.measurement.internal.ev r4 = r53.a()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r5 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = r5.zzs     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ag$b r4 = r4.a((java.lang.String) r5)     // Catch:{ all -> 0x0e98 }
            if (r4 == 0) goto L_0x0dad
            boolean r5 = r4.a()     // Catch:{ all -> 0x0e98 }
            if (r5 != 0) goto L_0x0da7
            goto L_0x0dad
        L_0x0da7:
            long r4 = r4.zzd     // Catch:{ all -> 0x0e98 }
            r11.h((long) r4)     // Catch:{ all -> 0x0e98 }
            goto L_0x0dd2
        L_0x0dad:
            com.google.android.gms.internal.measurement.aj$g r4 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r4 = r4.zzac     // Catch:{ all -> 0x0e98 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0e98 }
            if (r4 == 0) goto L_0x0dbd
            r4 = -1
            r11.h((long) r4)     // Catch:{ all -> 0x0e98 }
            goto L_0x0dd2
        L_0x0dbd:
            com.google.android.gms.measurement.internal.fc r4 = r1.f12266b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.dy r4 = r4.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r4 = r4.f11831f     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = "Did not find measurement config or missing version info. appId"
            com.google.android.gms.internal.measurement.aj$g r6 = r2.f12273a     // Catch:{ all -> 0x0e98 }
            java.lang.String r6 = r6.zzs     // Catch:{ all -> 0x0e98 }
            java.lang.Object r6 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r6)     // Catch:{ all -> 0x0e98 }
            r4.a(r5, r6)     // Catch:{ all -> 0x0e98 }
        L_0x0dd2:
            com.google.android.gms.measurement.internal.d r4 = r53.c()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.ff r5 = r11.w()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.dv r5 = (com.google.android.gms.internal.measurement.dv) r5     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.internal.measurement.aj$g r5 = (com.google.android.gms.internal.measurement.aj.g) r5     // Catch:{ all -> 0x0e98 }
            r12 = r21
            r4.a((com.google.android.gms.internal.measurement.aj.g) r5, (boolean) r12)     // Catch:{ all -> 0x0e98 }
        L_0x0de3:
            com.google.android.gms.measurement.internal.d r4 = r53.c()     // Catch:{ all -> 0x0e98 }
            java.util.List<java.lang.Long> r2 = r2.f12274b     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.common.internal.s.a(r2)     // Catch:{ all -> 0x0e98 }
            r4.h()     // Catch:{ all -> 0x0e98 }
            r4.w()     // Catch:{ all -> 0x0e98 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0e98 }
            java.lang.String r6 = "rowid in ("
            r5.<init>(r6)     // Catch:{ all -> 0x0e98 }
            r6 = 0
        L_0x0dfa:
            int r7 = r2.size()     // Catch:{ all -> 0x0e98 }
            if (r6 >= r7) goto L_0x0e17
            if (r6 == 0) goto L_0x0e07
            java.lang.String r7 = ","
            r5.append(r7)     // Catch:{ all -> 0x0e98 }
        L_0x0e07:
            java.lang.Object r7 = r2.get(r6)     // Catch:{ all -> 0x0e98 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0e98 }
            long r7 = r7.longValue()     // Catch:{ all -> 0x0e98 }
            r5.append(r7)     // Catch:{ all -> 0x0e98 }
            int r6 = r6 + 1
            goto L_0x0dfa
        L_0x0e17:
            java.lang.String r6 = ")"
            r5.append(r6)     // Catch:{ all -> 0x0e98 }
            android.database.sqlite.SQLiteDatabase r6 = r4.e()     // Catch:{ all -> 0x0e98 }
            java.lang.String r7 = "raw_events"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0e98 }
            r8 = 0
            int r5 = r6.delete(r7, r5, r8)     // Catch:{ all -> 0x0e98 }
            int r6 = r2.size()     // Catch:{ all -> 0x0e98 }
            if (r5 == r6) goto L_0x0e48
            com.google.android.gms.measurement.internal.dy r4 = r4.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r4 = r4.f11828c     // Catch:{ all -> 0x0e98 }
            java.lang.String r6 = "Deleted fewer rows from raw events table than expected"
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0e98 }
            int r2 = r2.size()     // Catch:{ all -> 0x0e98 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ all -> 0x0e98 }
            r4.a(r6, r5, r2)     // Catch:{ all -> 0x0e98 }
        L_0x0e48:
            com.google.android.gms.measurement.internal.d r2 = r53.c()     // Catch:{ all -> 0x0e98 }
            android.database.sqlite.SQLiteDatabase r4 = r2.e()     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = "delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x0e5f }
            r7 = 0
            r6[r7] = r3     // Catch:{ SQLiteException -> 0x0e5f }
            r7 = 1
            r6[r7] = r3     // Catch:{ SQLiteException -> 0x0e5f }
            r4.execSQL(r5, r6)     // Catch:{ SQLiteException -> 0x0e5f }
            goto L_0x0e70
        L_0x0e5f:
            r0 = move-exception
            r4 = r0
            com.google.android.gms.measurement.internal.dy r2 = r2.J_()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.ea r2 = r2.f11828c     // Catch:{ all -> 0x0e98 }
            java.lang.String r5 = "Failed to remove unused event metadata. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r3)     // Catch:{ all -> 0x0e98 }
            r2.a(r5, r3, r4)     // Catch:{ all -> 0x0e98 }
        L_0x0e70:
            com.google.android.gms.measurement.internal.d r2 = r53.c()     // Catch:{ all -> 0x0e98 }
            r2.c()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.d r2 = r53.c()
            r2.x_()
            r2 = 1
            return r2
        L_0x0e80:
            com.google.android.gms.measurement.internal.d r2 = r53.c()     // Catch:{ all -> 0x0e98 }
            r2.c()     // Catch:{ all -> 0x0e98 }
            com.google.android.gms.measurement.internal.d r2 = r53.c()
            r2.x_()
            r2 = 0
            return r2
        L_0x0e90:
            r0 = move-exception
        L_0x0e91:
            r2 = r0
        L_0x0e92:
            if (r6 == 0) goto L_0x0e97
            r6.close()     // Catch:{ all -> 0x0e98 }
        L_0x0e97:
            throw r2     // Catch:{ all -> 0x0e98 }
        L_0x0e98:
            r0 = move-exception
        L_0x0e99:
            r2 = r0
            com.google.android.gms.measurement.internal.d r3 = r53.c()
            r3.x_()
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.jj.a(long):boolean");
    }

    private static void a(aj.g.a aVar) {
        aVar.b(Long.MAX_VALUE).c(Long.MIN_VALUE);
        for (int i2 = 0; i2 < aVar.c(); i2++) {
            aj.c a2 = aVar.a(i2);
            if (a2.zzf < aVar.g()) {
                aVar.b(a2.zzf);
            }
            if (a2.zzf > aVar.h()) {
                aVar.c(a2.zzf);
            }
        }
    }

    private final void a(aj.g.a aVar, long j2, boolean z) {
        jr jrVar;
        String str = z ? "_se" : "_lte";
        jr c2 = c().c(aVar.k(), str);
        if (c2 == null || c2.f12293e == null) {
            jrVar = new jr(aVar.k(), "auto", str, this.f12266b.j().a(), Long.valueOf(j2));
        } else {
            jrVar = new jr(aVar.k(), "auto", str, this.f12266b.j().a(), Long.valueOf(((Long) c2.f12293e).longValue() + j2));
        }
        aj.k kVar = (aj.k) ((dv) aj.k.d().a(str).a(this.f12266b.j().a()).b(((Long) jrVar.f12293e).longValue()).w());
        boolean z2 = false;
        int a2 = jn.a(aVar, str);
        if (a2 >= 0) {
            aVar.a(a2, kVar);
            z2 = true;
        }
        if (!z2) {
            aVar.a(kVar);
        }
        if (j2 > 0) {
            c().a(jrVar);
            this.f12266b.J_().j.a("Updated engagement user property. scope, value", z ? "session-scoped" : "lifetime", jrVar.f12293e);
        }
    }

    private final boolean a(aj.c.a aVar, aj.c.a aVar2) {
        s.b("_e".equals(aVar.d()));
        e();
        aj.e a2 = jn.a((aj.c) ((dv) aVar.w()), "_sc");
        String str = null;
        String str2 = a2 == null ? null : a2.zze;
        e();
        aj.e a3 = jn.a((aj.c) ((dv) aVar2.w()), "_pc");
        if (a3 != null) {
            str = a3.zze;
        }
        if (str == null || !str.equals(str2)) {
            return false;
        }
        b(aVar, aVar2);
        return true;
    }

    private final void b(aj.c.a aVar, aj.c.a aVar2) {
        s.b("_e".equals(aVar.d()));
        e();
        aj.e a2 = jn.a((aj.c) ((dv) aVar.w()), "_et");
        if (a2.b() && a2.zzf > 0) {
            long j2 = a2.zzf;
            e();
            aj.e a3 = jn.a((aj.c) ((dv) aVar2.w()), "_et");
            if (a3 != null && a3.zzf > 0) {
                j2 += a3.zzf;
            }
            e();
            jn.a(aVar2, "_et", (Object) Long.valueOf(j2));
            e();
            jn.a(aVar, "_fr", (Object) 1L);
        }
    }

    private static void a(aj.c.a aVar, String str) {
        List<aj.e> a2 = aVar.a();
        for (int i2 = 0; i2 < a2.size(); i2++) {
            if (str.equals(a2.get(i2).zzd)) {
                aVar.b(i2);
                return;
            }
        }
    }

    private static void a(aj.c.a aVar, int i2, String str) {
        List<aj.e> a2 = aVar.a();
        int i3 = 0;
        while (i3 < a2.size()) {
            if (!"_err".equals(a2.get(i3).zzd)) {
                i3++;
            } else {
                return;
            }
        }
        aVar.a((aj.e) ((dv) aj.e.d().a("_err").a((long) i2).w())).a((aj.e) ((dv) aj.e.d().a("_ev").b(str).w()));
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public final void a(int i2, Throwable th, byte[] bArr) {
        d c2;
        f();
        g();
        if (bArr == null) {
            try {
                bArr = new byte[0];
            } catch (Throwable th2) {
                this.s = false;
                s();
                throw th2;
            }
        }
        List<Long> list = this.w;
        this.w = null;
        boolean z = true;
        if ((i2 == 200 || i2 == 204) && th == null) {
            try {
                this.f12266b.b().f11861d.a(this.f12266b.j().a());
                this.f12266b.b().f11862e.a(0);
                i();
                this.f12266b.J_().k.a("Successful upload. Got network response. code, size", Integer.valueOf(i2), Integer.valueOf(bArr.length));
                c().b();
                try {
                    for (Long next : list) {
                        try {
                            c2 = c();
                            long longValue = next.longValue();
                            c2.h();
                            c2.w();
                            if (c2.e().delete("queue", "rowid=?", new String[]{String.valueOf(longValue)}) != 1) {
                                throw new SQLiteException("Deleted fewer rows from queue than expected");
                            }
                        } catch (SQLiteException e2) {
                            c2.J_().f11828c.a("Failed to delete a bundle in a queue table", e2);
                            throw e2;
                        } catch (SQLiteException e3) {
                            if (this.x == null || !this.x.contains(next)) {
                                throw e3;
                            }
                        }
                    }
                    c().c();
                    c().x_();
                    this.x = null;
                    if (!b().b() || !r()) {
                        this.y = -1;
                        i();
                    } else {
                        h();
                    }
                    this.q = 0;
                } catch (Throwable th3) {
                    c().x_();
                    throw th3;
                }
            } catch (SQLiteException e4) {
                this.f12266b.J_().f11828c.a("Database error while trying to delete uploaded bundles", e4);
                this.q = this.f12266b.j().b();
                this.f12266b.J_().k.a("Disable upload, time", Long.valueOf(this.q));
            }
        } else {
            this.f12266b.J_().k.a("Network upload failed. Will retry later. code, error", Integer.valueOf(i2), th);
            this.f12266b.b().f11862e.a(this.f12266b.j().a());
            if (i2 != 503) {
                if (i2 != 429) {
                    z = false;
                }
            }
            if (z) {
                this.f12266b.b().f11863f.a(this.f12266b.j().a());
            }
            c().a(list);
            i();
        }
        this.s = false;
        s();
    }

    private final boolean r() {
        f();
        g();
        return c().C_() || !TextUtils.isEmpty(c().f());
    }

    private final void a(fb fbVar) {
        androidx.a.a aVar;
        f();
        jz.a();
        if (this.f12266b.f11945e.d(fbVar.b(), o.aC)) {
            if (TextUtils.isEmpty(fbVar.d()) && TextUtils.isEmpty(fbVar.f()) && TextUtils.isEmpty(fbVar.e())) {
                a(fbVar.b(), CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
                return;
            }
        } else if (TextUtils.isEmpty(fbVar.d()) && TextUtils.isEmpty(fbVar.e())) {
            a(fbVar.b(), CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE, (Throwable) null, (byte[]) null, (Map<String, List<String>>) null);
            return;
        }
        String a2 = this.f12266b.f11945e.a(fbVar);
        try {
            URL url = new URL(a2);
            this.f12266b.J_().k.a("Fetching remote configuration", fbVar.b());
            ag.b a3 = a().a(fbVar.b());
            String b2 = a().b(fbVar.b());
            if (a3 == null || TextUtils.isEmpty(b2)) {
                aVar = null;
            } else {
                androidx.a.a aVar2 = new androidx.a.a();
                aVar2.put("If-Modified-Since", b2);
                aVar = aVar2;
            }
            this.r = true;
            ec b3 = b();
            String b4 = fbVar.b();
            jk jkVar = new jk(this);
            b3.h();
            b3.w();
            s.a(url);
            s.a(jkVar);
            b3.K_().b((Runnable) new eg(b3, b4, url, (byte[]) null, aVar, jkVar));
        } catch (MalformedURLException unused) {
            this.f12266b.J_().f11828c.a("Failed to parse config URL. Not fetching. appId", dy.a(fbVar.b()), a2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0134 A[Catch:{ all -> 0x0183, all -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0142 A[Catch:{ all -> 0x0183, all -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0168 A[Catch:{ all -> 0x0183, all -> 0x018c }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x016c A[Catch:{ all -> 0x0183, all -> 0x018c }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r7, int r8, java.lang.Throwable r9, byte[] r10, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r11) {
        /*
            r6 = this;
            r6.f()
            r6.g()
            com.google.android.gms.common.internal.s.a((java.lang.String) r7)
            r0 = 0
            if (r10 != 0) goto L_0x000e
            byte[] r10 = new byte[r0]     // Catch:{ all -> 0x018c }
        L_0x000e:
            com.google.android.gms.measurement.internal.fc r1 = r6.f12266b     // Catch:{ all -> 0x018c }
            com.google.android.gms.measurement.internal.dy r1 = r1.J_()     // Catch:{ all -> 0x018c }
            com.google.android.gms.measurement.internal.ea r1 = r1.k     // Catch:{ all -> 0x018c }
            java.lang.String r2 = "onConfigFetched. Response size"
            int r3 = r10.length     // Catch:{ all -> 0x018c }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x018c }
            r1.a(r2, r3)     // Catch:{ all -> 0x018c }
            com.google.android.gms.measurement.internal.d r1 = r6.c()     // Catch:{ all -> 0x018c }
            r1.b()     // Catch:{ all -> 0x018c }
            com.google.android.gms.measurement.internal.d r1 = r6.c()     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.fb r1 = r1.b(r7)     // Catch:{ all -> 0x0183 }
            r2 = 200(0xc8, float:2.8E-43)
            r3 = 304(0x130, float:4.26E-43)
            r4 = 1
            if (r8 == r2) goto L_0x003c
            r2 = 204(0xcc, float:2.86E-43)
            if (r8 == r2) goto L_0x003c
            if (r8 != r3) goto L_0x0040
        L_0x003c:
            if (r9 != 0) goto L_0x0040
            r2 = 1
            goto L_0x0041
        L_0x0040:
            r2 = 0
        L_0x0041:
            if (r1 != 0) goto L_0x0056
            com.google.android.gms.measurement.internal.fc r8 = r6.f12266b     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.dy r8 = r8.J_()     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.ea r8 = r8.f11831f     // Catch:{ all -> 0x0183 }
            java.lang.String r9 = "App does not exist in onConfigFetched. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r7)     // Catch:{ all -> 0x0183 }
            r8.a(r9, r7)     // Catch:{ all -> 0x0183 }
            goto L_0x016f
        L_0x0056:
            r5 = 404(0x194, float:5.66E-43)
            if (r2 != 0) goto L_0x00c4
            if (r8 != r5) goto L_0x005d
            goto L_0x00c4
        L_0x005d:
            com.google.android.gms.measurement.internal.fc r10 = r6.f12266b     // Catch:{ all -> 0x0183 }
            com.google.android.gms.common.util.e r10 = r10.j()     // Catch:{ all -> 0x0183 }
            long r10 = r10.a()     // Catch:{ all -> 0x0183 }
            r1.i((long) r10)     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.d r10 = r6.c()     // Catch:{ all -> 0x0183 }
            r10.a((com.google.android.gms.measurement.internal.fb) r1)     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.fc r10 = r6.f12266b     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.dy r10 = r10.J_()     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.ea r10 = r10.k     // Catch:{ all -> 0x0183 }
            java.lang.String r11 = "Fetching config failed. code, error"
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0183 }
            r10.a(r11, r1, r9)     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.ev r9 = r6.a()     // Catch:{ all -> 0x0183 }
            r9.c(r7)     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.fc r7 = r6.f12266b     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.eh r7 = r7.b()     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.el r7 = r7.f11862e     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.fc r9 = r6.f12266b     // Catch:{ all -> 0x0183 }
            com.google.android.gms.common.util.e r9 = r9.j()     // Catch:{ all -> 0x0183 }
            long r9 = r9.a()     // Catch:{ all -> 0x0183 }
            r7.a(r9)     // Catch:{ all -> 0x0183 }
            r7 = 503(0x1f7, float:7.05E-43)
            if (r8 == r7) goto L_0x00a8
            r7 = 429(0x1ad, float:6.01E-43)
            if (r8 != r7) goto L_0x00a7
            goto L_0x00a8
        L_0x00a7:
            r4 = 0
        L_0x00a8:
            if (r4 == 0) goto L_0x00bf
            com.google.android.gms.measurement.internal.fc r7 = r6.f12266b     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.eh r7 = r7.b()     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.el r7 = r7.f11863f     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.fc r8 = r6.f12266b     // Catch:{ all -> 0x0183 }
            com.google.android.gms.common.util.e r8 = r8.j()     // Catch:{ all -> 0x0183 }
            long r8 = r8.a()     // Catch:{ all -> 0x0183 }
            r7.a(r8)     // Catch:{ all -> 0x0183 }
        L_0x00bf:
            r6.i()     // Catch:{ all -> 0x0183 }
            goto L_0x016f
        L_0x00c4:
            r9 = 0
            if (r11 == 0) goto L_0x00d0
            java.lang.String r2 = "Last-Modified"
            java.lang.Object r11 = r11.get(r2)     // Catch:{ all -> 0x0183 }
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x0183 }
            goto L_0x00d1
        L_0x00d0:
            r11 = r9
        L_0x00d1:
            if (r11 == 0) goto L_0x00e0
            int r2 = r11.size()     // Catch:{ all -> 0x0183 }
            if (r2 <= 0) goto L_0x00e0
            java.lang.Object r11 = r11.get(r0)     // Catch:{ all -> 0x0183 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x0183 }
            goto L_0x00e1
        L_0x00e0:
            r11 = r9
        L_0x00e1:
            if (r8 == r5) goto L_0x00fd
            if (r8 != r3) goto L_0x00e6
            goto L_0x00fd
        L_0x00e6:
            com.google.android.gms.measurement.internal.ev r9 = r6.a()     // Catch:{ all -> 0x0183 }
            boolean r9 = r9.a(r7, r10, r11)     // Catch:{ all -> 0x0183 }
            if (r9 != 0) goto L_0x011e
            com.google.android.gms.measurement.internal.d r7 = r6.c()     // Catch:{ all -> 0x018c }
            r7.x_()     // Catch:{ all -> 0x018c }
            r6.r = r0
            r6.s()
            return
        L_0x00fd:
            com.google.android.gms.measurement.internal.ev r11 = r6.a()     // Catch:{ all -> 0x0183 }
            com.google.android.gms.internal.measurement.ag$b r11 = r11.a((java.lang.String) r7)     // Catch:{ all -> 0x0183 }
            if (r11 != 0) goto L_0x011e
            com.google.android.gms.measurement.internal.ev r11 = r6.a()     // Catch:{ all -> 0x0183 }
            boolean r9 = r11.a(r7, r9, r9)     // Catch:{ all -> 0x0183 }
            if (r9 != 0) goto L_0x011e
            com.google.android.gms.measurement.internal.d r7 = r6.c()     // Catch:{ all -> 0x018c }
            r7.x_()     // Catch:{ all -> 0x018c }
            r6.r = r0
            r6.s()
            return
        L_0x011e:
            com.google.android.gms.measurement.internal.fc r9 = r6.f12266b     // Catch:{ all -> 0x0183 }
            com.google.android.gms.common.util.e r9 = r9.j()     // Catch:{ all -> 0x0183 }
            long r2 = r9.a()     // Catch:{ all -> 0x0183 }
            r1.h((long) r2)     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.d r9 = r6.c()     // Catch:{ all -> 0x0183 }
            r9.a((com.google.android.gms.measurement.internal.fb) r1)     // Catch:{ all -> 0x0183 }
            if (r8 != r5) goto L_0x0142
            com.google.android.gms.measurement.internal.fc r8 = r6.f12266b     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.dy r8 = r8.J_()     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.ea r8 = r8.f11833h     // Catch:{ all -> 0x0183 }
            java.lang.String r9 = "Config not found. Using empty config. appId"
            r8.a(r9, r7)     // Catch:{ all -> 0x0183 }
            goto L_0x0158
        L_0x0142:
            com.google.android.gms.measurement.internal.fc r7 = r6.f12266b     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.dy r7 = r7.J_()     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.ea r7 = r7.k     // Catch:{ all -> 0x0183 }
            java.lang.String r9 = "Successfully fetched config. Got network response. code, size"
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0183 }
            int r10 = r10.length     // Catch:{ all -> 0x0183 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0183 }
            r7.a(r9, r8, r10)     // Catch:{ all -> 0x0183 }
        L_0x0158:
            com.google.android.gms.measurement.internal.ec r7 = r6.b()     // Catch:{ all -> 0x0183 }
            boolean r7 = r7.b()     // Catch:{ all -> 0x0183 }
            if (r7 == 0) goto L_0x016c
            boolean r7 = r6.r()     // Catch:{ all -> 0x0183 }
            if (r7 == 0) goto L_0x016c
            r6.h()     // Catch:{ all -> 0x0183 }
            goto L_0x016f
        L_0x016c:
            r6.i()     // Catch:{ all -> 0x0183 }
        L_0x016f:
            com.google.android.gms.measurement.internal.d r7 = r6.c()     // Catch:{ all -> 0x0183 }
            r7.c()     // Catch:{ all -> 0x0183 }
            com.google.android.gms.measurement.internal.d r7 = r6.c()     // Catch:{ all -> 0x018c }
            r7.x_()     // Catch:{ all -> 0x018c }
            r6.r = r0
            r6.s()
            return
        L_0x0183:
            r7 = move-exception
            com.google.android.gms.measurement.internal.d r8 = r6.c()     // Catch:{ all -> 0x018c }
            r8.x_()     // Catch:{ all -> 0x018c }
            throw r7     // Catch:{ all -> 0x018c }
        L_0x018c:
            r7 = move-exception
            r6.r = r0
            r6.s()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.jj.a(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x019e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01ba  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i() {
        /*
            r21 = this;
            r0 = r21
            r21.f()
            r21.g()
            boolean r1 = r21.u()
            r2 = 0
            if (r1 != 0) goto L_0x001c
            com.google.android.gms.measurement.internal.fc r1 = r0.f12266b
            com.google.android.gms.measurement.internal.ke r1 = r1.f11945e
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.o.ac
            boolean r1 = r1.d(r2, r3)
            if (r1 != 0) goto L_0x001c
            return
        L_0x001c:
            long r3 = r0.q
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x005f
            com.google.android.gms.measurement.internal.fc r1 = r0.f12266b
            com.google.android.gms.common.util.e r1 = r1.j()
            long r3 = r1.b()
            r7 = 3600000(0x36ee80, double:1.7786363E-317)
            long r9 = r0.q
            long r3 = r3 - r9
            long r3 = java.lang.Math.abs(r3)
            long r7 = r7 - r3
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x005d
            com.google.android.gms.measurement.internal.fc r1 = r0.f12266b
            com.google.android.gms.measurement.internal.dy r1 = r1.J_()
            com.google.android.gms.measurement.internal.ea r1 = r1.k
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r3 = "Upload has been suspended. Will update scheduling later in approximately ms"
            r1.a(r3, r2)
            com.google.android.gms.measurement.internal.ef r1 = r21.m()
            r1.b()
            com.google.android.gms.measurement.internal.jf r1 = r21.p()
            r1.b()
            return
        L_0x005d:
            r0.q = r5
        L_0x005f:
            com.google.android.gms.measurement.internal.fc r1 = r0.f12266b
            boolean r1 = r1.u()
            if (r1 == 0) goto L_0x0261
            boolean r1 = r21.r()
            if (r1 != 0) goto L_0x006f
            goto L_0x0261
        L_0x006f:
            com.google.android.gms.measurement.internal.fc r1 = r0.f12266b
            com.google.android.gms.common.util.e r1 = r1.j()
            long r3 = r1.a()
            com.google.android.gms.measurement.internal.dn<java.lang.Long> r1 = com.google.android.gms.measurement.internal.o.A
            java.lang.Object r1 = r1.a(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r7 = r1.longValue()
            long r7 = java.lang.Math.max(r5, r7)
            com.google.android.gms.measurement.internal.d r1 = r21.c()
            boolean r1 = r1.D_()
            if (r1 != 0) goto L_0x00a0
            com.google.android.gms.measurement.internal.d r1 = r21.c()
            boolean r1 = r1.y_()
            if (r1 == 0) goto L_0x009e
            goto L_0x00a0
        L_0x009e:
            r1 = 0
            goto L_0x00a1
        L_0x00a0:
            r1 = 1
        L_0x00a1:
            if (r1 == 0) goto L_0x00db
            com.google.android.gms.measurement.internal.fc r10 = r0.f12266b
            com.google.android.gms.measurement.internal.ke r10 = r10.f11945e
            java.lang.String r10 = r10.r()
            boolean r11 = android.text.TextUtils.isEmpty(r10)
            if (r11 != 0) goto L_0x00ca
            java.lang.String r11 = ".none."
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00ca
            com.google.android.gms.measurement.internal.dn<java.lang.Long> r10 = com.google.android.gms.measurement.internal.o.v
            java.lang.Object r10 = r10.a(r2)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r5, r10)
            goto L_0x00eb
        L_0x00ca:
            com.google.android.gms.measurement.internal.dn<java.lang.Long> r10 = com.google.android.gms.measurement.internal.o.u
            java.lang.Object r10 = r10.a(r2)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r5, r10)
            goto L_0x00eb
        L_0x00db:
            com.google.android.gms.measurement.internal.dn<java.lang.Long> r10 = com.google.android.gms.measurement.internal.o.t
            java.lang.Object r10 = r10.a(r2)
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r10 = java.lang.Math.max(r5, r10)
        L_0x00eb:
            com.google.android.gms.measurement.internal.fc r12 = r0.f12266b
            com.google.android.gms.measurement.internal.eh r12 = r12.b()
            com.google.android.gms.measurement.internal.el r12 = r12.f11861d
            long r12 = r12.a()
            com.google.android.gms.measurement.internal.fc r14 = r0.f12266b
            com.google.android.gms.measurement.internal.eh r14 = r14.b()
            com.google.android.gms.measurement.internal.el r14 = r14.f11862e
            long r14 = r14.a()
            com.google.android.gms.measurement.internal.d r16 = r21.c()
            r17 = r10
            long r9 = r16.A_()
            com.google.android.gms.measurement.internal.d r11 = r21.c()
            r19 = r3
            long r2 = r11.B_()
            long r2 = java.lang.Math.max(r9, r2)
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x0122
        L_0x011f:
            r7 = r5
            goto L_0x019a
        L_0x0122:
            long r2 = r2 - r19
            long r2 = java.lang.Math.abs(r2)
            long r3 = r19 - r2
            long r12 = r12 - r19
            long r9 = java.lang.Math.abs(r12)
            long r9 = r19 - r9
            long r14 = r14 - r19
            long r11 = java.lang.Math.abs(r14)
            long r11 = r19 - r11
            long r9 = java.lang.Math.max(r9, r11)
            long r7 = r7 + r3
            if (r1 == 0) goto L_0x014b
            int r1 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r1 <= 0) goto L_0x014b
            long r1 = java.lang.Math.min(r3, r9)
            long r7 = r1 + r17
        L_0x014b:
            com.google.android.gms.measurement.internal.jn r1 = r21.e()
            r13 = r17
            boolean r1 = r1.a((long) r9, (long) r13)
            if (r1 != 0) goto L_0x0159
            long r9 = r9 + r13
            r7 = r9
        L_0x0159:
            int r1 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r1 == 0) goto L_0x019a
            int r1 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x019a
            r1 = 0
        L_0x0162:
            r2 = 20
            com.google.android.gms.measurement.internal.dn<java.lang.Integer> r3 = com.google.android.gms.measurement.internal.o.C
            r4 = 0
            java.lang.Object r3 = r3.a(r4)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            r9 = 0
            int r3 = java.lang.Math.max(r9, r3)
            int r2 = java.lang.Math.min(r2, r3)
            if (r1 >= r2) goto L_0x011f
            r2 = 1
            long r2 = r2 << r1
            com.google.android.gms.measurement.internal.dn<java.lang.Long> r10 = com.google.android.gms.measurement.internal.o.B
            java.lang.Object r10 = r10.a(r4)
            java.lang.Long r10 = (java.lang.Long) r10
            long r13 = r10.longValue()
            long r13 = java.lang.Math.max(r5, r13)
            long r13 = r13 * r2
            long r7 = r7 + r13
            int r2 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r2 <= 0) goto L_0x0197
            goto L_0x019a
        L_0x0197:
            int r1 = r1 + 1
            goto L_0x0162
        L_0x019a:
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 != 0) goto L_0x01ba
            com.google.android.gms.measurement.internal.fc r1 = r0.f12266b
            com.google.android.gms.measurement.internal.dy r1 = r1.J_()
            com.google.android.gms.measurement.internal.ea r1 = r1.k
            java.lang.String r2 = "Next upload time is 0"
            r1.a(r2)
            com.google.android.gms.measurement.internal.ef r1 = r21.m()
            r1.b()
            com.google.android.gms.measurement.internal.jf r1 = r21.p()
            r1.b()
            return
        L_0x01ba:
            com.google.android.gms.measurement.internal.ec r1 = r21.b()
            boolean r1 = r1.b()
            if (r1 != 0) goto L_0x01e0
            com.google.android.gms.measurement.internal.fc r1 = r0.f12266b
            com.google.android.gms.measurement.internal.dy r1 = r1.J_()
            com.google.android.gms.measurement.internal.ea r1 = r1.k
            java.lang.String r2 = "No network"
            r1.a(r2)
            com.google.android.gms.measurement.internal.ef r1 = r21.m()
            r1.a()
            com.google.android.gms.measurement.internal.jf r1 = r21.p()
            r1.b()
            return
        L_0x01e0:
            com.google.android.gms.measurement.internal.fc r1 = r0.f12266b
            com.google.android.gms.measurement.internal.eh r1 = r1.b()
            com.google.android.gms.measurement.internal.el r1 = r1.f11863f
            long r1 = r1.a()
            com.google.android.gms.measurement.internal.dn<java.lang.Long> r3 = com.google.android.gms.measurement.internal.o.r
            r4 = 0
            java.lang.Object r3 = r3.a(r4)
            java.lang.Long r3 = (java.lang.Long) r3
            long r3 = r3.longValue()
            long r3 = java.lang.Math.max(r5, r3)
            com.google.android.gms.measurement.internal.jn r9 = r21.e()
            boolean r9 = r9.a((long) r1, (long) r3)
            if (r9 != 0) goto L_0x020c
            long r1 = r1 + r3
            long r7 = java.lang.Math.max(r7, r1)
        L_0x020c:
            com.google.android.gms.measurement.internal.ef r1 = r21.m()
            r1.b()
            com.google.android.gms.measurement.internal.fc r1 = r0.f12266b
            com.google.android.gms.common.util.e r1 = r1.j()
            long r1 = r1.a()
            long r7 = r7 - r1
            int r1 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r1 > 0) goto L_0x0248
            com.google.android.gms.measurement.internal.dn<java.lang.Long> r1 = com.google.android.gms.measurement.internal.o.w
            r2 = 0
            java.lang.Object r1 = r1.a(r2)
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            long r7 = java.lang.Math.max(r5, r1)
            com.google.android.gms.measurement.internal.fc r1 = r0.f12266b
            com.google.android.gms.measurement.internal.eh r1 = r1.b()
            com.google.android.gms.measurement.internal.el r1 = r1.f11861d
            com.google.android.gms.measurement.internal.fc r2 = r0.f12266b
            com.google.android.gms.common.util.e r2 = r2.j()
            long r2 = r2.a()
            r1.a(r2)
        L_0x0248:
            com.google.android.gms.measurement.internal.fc r1 = r0.f12266b
            com.google.android.gms.measurement.internal.dy r1 = r1.J_()
            com.google.android.gms.measurement.internal.ea r1 = r1.k
            java.lang.Long r2 = java.lang.Long.valueOf(r7)
            java.lang.String r3 = "Upload scheduled in approximately ms"
            r1.a(r3, r2)
            com.google.android.gms.measurement.internal.jf r1 = r21.p()
            r1.a(r7)
            return
        L_0x0261:
            com.google.android.gms.measurement.internal.fc r1 = r0.f12266b
            com.google.android.gms.measurement.internal.dy r1 = r1.J_()
            com.google.android.gms.measurement.internal.ea r1 = r1.k
            java.lang.String r2 = "Nothing to upload or uploading impossible"
            r1.a(r2)
            com.google.android.gms.measurement.internal.ef r1 = r21.m()
            r1.b()
            com.google.android.gms.measurement.internal.jf r1 = r21.p()
            r1.b()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.jj.i():void");
    }

    private final void s() {
        f();
        if (this.r || this.s || this.t) {
            this.f12266b.J_().k.a("Not stopping services. fetch, network, upload", Boolean.valueOf(this.r), Boolean.valueOf(this.s), Boolean.valueOf(this.t));
            return;
        }
        this.f12266b.J_().k.a("Stopping uploading service(s)");
        List<Runnable> list = this.f12267c;
        if (list != null) {
            for (Runnable run : list) {
                run.run();
            }
            this.f12267c.clear();
        }
    }

    private final Boolean b(fb fbVar) {
        try {
            if (fbVar.l() != -2147483648L) {
                if (fbVar.l() == ((long) c.a(this.f12266b.k()).b(fbVar.b(), 0).versionCode)) {
                    return Boolean.TRUE;
                }
            } else {
                String str = c.a(this.f12266b.k()).b(fbVar.b(), 0).versionName;
                if (fbVar.k() != null && fbVar.k().equals(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final boolean t() {
        FileLock fileLock;
        f();
        if (!this.f12266b.f11945e.d((String) null, o.aA) || (fileLock = this.u) == null || !fileLock.isValid()) {
            try {
                this.v = new RandomAccessFile(new File(this.f12266b.k().getFilesDir(), "google_app_measurement.db"), "rw").getChannel();
                this.u = this.v.tryLock();
                if (this.u != null) {
                    this.f12266b.J_().k.a("Storage concurrent access okay");
                    return true;
                }
                this.f12266b.J_().f11828c.a("Storage concurrent data access panic");
                return false;
            } catch (FileNotFoundException e2) {
                this.f12266b.J_().f11828c.a("Failed to acquire storage lock", e2);
                return false;
            } catch (IOException e3) {
                this.f12266b.J_().f11828c.a("Failed to access storage lock file", e3);
                return false;
            } catch (OverlappingFileLockException e4) {
                this.f12266b.J_().f11831f.a("Storage lock already acquired", e4);
                return false;
            }
        } else {
            this.f12266b.J_().k.a("Storage concurrent access okay");
            return true;
        }
    }

    private final int a(FileChannel fileChannel) {
        f();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.f12266b.J_().f11828c.a("Bad channel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read != 4) {
                if (read != -1) {
                    this.f12266b.J_().f11831f.a("Unexpected data length. Bytes read", Integer.valueOf(read));
                }
                return 0;
            }
            allocate.flip();
            return allocate.getInt();
        } catch (IOException e2) {
            this.f12266b.J_().f11828c.a("Failed to read from channel", e2);
            return 0;
        }
    }

    private final boolean a(int i2, FileChannel fileChannel) {
        f();
        if (fileChannel == null || !fileChannel.isOpen()) {
            this.f12266b.J_().f11828c.a("Bad channel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i2);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            if (this.f12266b.f11945e.d((String) null, o.aP) && Build.VERSION.SDK_INT <= 19) {
                fileChannel.position(0);
            }
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() != 4) {
                this.f12266b.J_().f11828c.a("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            }
            return true;
        } catch (IOException e2) {
            this.f12266b.J_().f11828c.a("Failed to write to channel", e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void l() {
        f();
        g();
        if (!this.p) {
            this.p = true;
            f();
            g();
            if ((this.f12266b.f11945e.d((String) null, o.ac) || u()) && t()) {
                int a2 = a(this.v);
                int D = this.f12266b.m().D();
                f();
                if (a2 > D) {
                    this.f12266b.J_().f11828c.a("Panic: can't downgrade version. Previous, current version", Integer.valueOf(a2), Integer.valueOf(D));
                } else if (a2 < D) {
                    if (a(D, this.v)) {
                        this.f12266b.J_().k.a("Storage version upgraded. Previous, current version", Integer.valueOf(a2), Integer.valueOf(D));
                    } else {
                        this.f12266b.J_().f11828c.a("Storage version upgrade failed. Previous, current version", Integer.valueOf(a2), Integer.valueOf(D));
                    }
                }
            }
        }
        if (!this.o && !this.f12266b.f11945e.d((String) null, o.ac)) {
            this.f12266b.J_().f11834i.a("This instance being marked as an uploader");
            this.o = true;
            i();
        }
    }

    private final boolean u() {
        f();
        g();
        return this.o;
    }

    /* access modifiers changed from: package-private */
    public final void a(zzm zzm) {
        if (this.w != null) {
            this.x = new ArrayList();
            this.x.addAll(this.w);
        }
        d c2 = c();
        String str = zzm.f12380a;
        s.a(str);
        c2.h();
        c2.w();
        try {
            SQLiteDatabase e2 = c2.e();
            String[] strArr = {str};
            int delete = e2.delete("apps", "app_id=?", strArr) + 0 + e2.delete(EventsModuleManager.MODULE_NAME, "app_id=?", strArr) + e2.delete("user_attributes", "app_id=?", strArr) + e2.delete("conditional_properties", "app_id=?", strArr) + e2.delete("raw_events", "app_id=?", strArr) + e2.delete("raw_events_metadata", "app_id=?", strArr) + e2.delete("queue", "app_id=?", strArr) + e2.delete("audience_filter_values", "app_id=?", strArr) + e2.delete("main_event_params", "app_id=?", strArr);
            if (delete > 0) {
                c2.J_().k.a("Reset analytics data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e3) {
            c2.J_().f11828c.a("Error resetting analytics data. appId, error", dy.a(str), e3);
        }
        jg.a();
        if (!this.f12266b.f11945e.d((String) null, o.aH)) {
            zzm a2 = a(this.f12266b.k(), zzm.f12380a, zzm.f12381b, zzm.f12387h, zzm.o, zzm.p, zzm.m, zzm.r, zzm.v);
            if (zzm.f12387h) {
                b(a2);
            }
        } else if (zzm.f12387h) {
            b(zzm);
        }
    }

    private final zzm a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, long j2, String str3, String str4) {
        String str5;
        String str6;
        int i2;
        String str7 = str;
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            this.f12266b.J_().f11828c.a("PackageManager is null, can not log app install information");
            return null;
        }
        try {
            str5 = packageManager.getInstallerPackageName(str7);
        } catch (IllegalArgumentException unused) {
            this.f12266b.J_().f11828c.a("Error retrieving installer package name. appId", dy.a(str));
            str5 = "Unknown";
        }
        if (str5 == null) {
            str5 = "manual_install";
        } else if ("com.android.vending".equals(str5)) {
            str5 = "";
        }
        String str8 = str5;
        try {
            PackageInfo b2 = c.a(context).b(str7, 0);
            if (b2 != null) {
                CharSequence b3 = c.a(context).b(str7);
                if (!TextUtils.isEmpty(b3)) {
                    String charSequence = b3.toString();
                }
                str6 = b2.versionName;
                i2 = b2.versionCode;
            } else {
                str6 = "Unknown";
                i2 = Integer.MIN_VALUE;
            }
            long j3 = (long) i2;
            long a2 = this.f12266b.e().a(context, str7);
            jz.a();
            return new zzm(str, str2, str6, j3, str8, 19000, a2, (String) null, z, false, "", 0, j2, 0, z2, z3, false, str3, (Boolean) null, 0, (List<String>) null, this.f12266b.f11945e.d(str7, o.aC) ? str4 : null);
        } catch (PackageManager.NameNotFoundException unused2) {
            this.f12266b.J_().f11828c.a("Error retrieving newly installed package info. appId, appName", dy.a(str), "Unknown");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(zzkl zzkl, zzm zzm) {
        k a2;
        f();
        g();
        if (e(zzm)) {
            if (!zzm.f12387h) {
                c(zzm);
                return;
            }
            int c2 = this.f12266b.e().c(zzkl.f12372a);
            int i2 = 0;
            if (c2 != 0) {
                this.f12266b.e();
                String a3 = jq.a(zzkl.f12372a, 24, true);
                if (zzkl.f12372a != null) {
                    i2 = zzkl.f12372a.length();
                }
                this.f12266b.e().b(c2, "_ev", a3, i2);
                return;
            }
            int b2 = this.f12266b.e().b(zzkl.f12372a, zzkl.a());
            if (b2 != 0) {
                this.f12266b.e();
                String a4 = jq.a(zzkl.f12372a, 24, true);
                Object a5 = zzkl.a();
                if (a5 != null && ((a5 instanceof String) || (a5 instanceof CharSequence))) {
                    i2 = String.valueOf(a5).length();
                }
                this.f12266b.e().b(b2, "_ev", a4, i2);
                return;
            }
            this.f12266b.e();
            Object c3 = jq.c(zzkl.f12372a, zzkl.a());
            if (c3 != null) {
                if ("_sid".equals(zzkl.f12372a) && this.f12266b.f11945e.d(zzm.f12380a, o.Q)) {
                    long j2 = zzkl.f12373b;
                    String str = zzkl.f12376e;
                    long j3 = 0;
                    jr c4 = c().c(zzm.f12380a, "_sno");
                    if (c4 == null || !(c4.f12293e instanceof Long)) {
                        if (c4 != null) {
                            this.f12266b.J_().f11831f.a("Retrieved last session number from database does not contain a valid (long) value", c4.f12293e);
                        }
                        if (this.f12266b.f11945e.d(zzm.f12380a, o.T) && (a2 = c().a(zzm.f12380a, "_s")) != null) {
                            j3 = a2.f12315c;
                            this.f12266b.J_().k.a("Backfill the session number. Last used session number", Long.valueOf(j3));
                        }
                    } else {
                        j3 = ((Long) c4.f12293e).longValue();
                    }
                    a(new zzkl("_sno", j2, Long.valueOf(j3 + 1), str), zzm);
                }
                jr jrVar = new jr(zzm.f12380a, zzkl.f12376e, zzkl.f12372a, zzkl.f12373b, c3);
                this.f12266b.J_().j.a("Setting user property", this.f12266b.f().c(jrVar.f12291c), c3);
                c().b();
                try {
                    c(zzm);
                    boolean a6 = c().a(jrVar);
                    c().c();
                    if (a6) {
                        this.f12266b.J_().j.a("User property set", this.f12266b.f().c(jrVar.f12291c), jrVar.f12293e);
                    } else {
                        this.f12266b.J_().f11828c.a("Too many unique user properties are set. Ignoring user property", this.f12266b.f().c(jrVar.f12291c), jrVar.f12293e);
                        this.f12266b.e().b(9, (String) null, (String) null, 0);
                    }
                } finally {
                    c().x_();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(zzkl zzkl, zzm zzm) {
        f();
        g();
        if (e(zzm)) {
            if (!zzm.f12387h) {
                c(zzm);
            } else if (!this.f12266b.f11945e.d(zzm.f12380a, o.aa)) {
                this.f12266b.J_().j.a("Removing user property", this.f12266b.f().c(zzkl.f12372a));
                c().b();
                try {
                    c(zzm);
                    c().b(zzm.f12380a, zzkl.f12372a);
                    c().c();
                    this.f12266b.J_().j.a("User property removed", this.f12266b.f().c(zzkl.f12372a));
                } finally {
                    c().x_();
                }
            } else if (!"_npa".equals(zzkl.f12372a) || zzm.s == null) {
                this.f12266b.J_().j.a("Removing user property", this.f12266b.f().c(zzkl.f12372a));
                c().b();
                try {
                    c(zzm);
                    c().b(zzm.f12380a, zzkl.f12372a);
                    c().c();
                    this.f12266b.J_().j.a("User property removed", this.f12266b.f().c(zzkl.f12372a));
                } finally {
                    c().x_();
                }
            } else {
                this.f12266b.J_().j.a("Falling back to manifest metadata value for ad personalization");
                a(new zzkl("_npa", this.f12266b.j().a(), Long.valueOf(zzm.s.booleanValue() ? 1 : 0), "auto"), zzm);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0497 A[Catch:{ SQLiteException -> 0x01c8, all -> 0x04c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0211 A[Catch:{ SQLiteException -> 0x01c8, all -> 0x04c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0213 A[Catch:{ SQLiteException -> 0x01c8, all -> 0x04c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0217 A[Catch:{ SQLiteException -> 0x01c8, all -> 0x04c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0242 A[Catch:{ SQLiteException -> 0x01c8, all -> 0x04c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x024f A[Catch:{ SQLiteException -> 0x01c8, all -> 0x04c2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0262 A[Catch:{ SQLiteException -> 0x01c8, all -> 0x04c2 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.google.android.gms.measurement.internal.zzm r24) {
        /*
            r23 = this;
            r1 = r23
            r2 = r24
            java.lang.String r3 = "_sys"
            java.lang.String r4 = "_pfo"
            java.lang.String r5 = "_uwa"
            java.lang.String r0 = "app_id=?"
            r23.f()
            r23.g()
            com.google.android.gms.common.internal.s.a(r24)
            java.lang.String r6 = r2.f12380a
            com.google.android.gms.common.internal.s.a((java.lang.String) r6)
            boolean r6 = r23.e(r24)
            if (r6 != 0) goto L_0x0021
            return
        L_0x0021:
            com.google.android.gms.measurement.internal.d r6 = r23.c()
            java.lang.String r7 = r2.f12380a
            com.google.android.gms.measurement.internal.fb r6 = r6.b(r7)
            r7 = 0
            if (r6 == 0) goto L_0x0054
            java.lang.String r9 = r6.d()
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 == 0) goto L_0x0054
            java.lang.String r9 = r2.f12381b
            boolean r9 = android.text.TextUtils.isEmpty(r9)
            if (r9 != 0) goto L_0x0054
            r6.h((long) r7)
            com.google.android.gms.measurement.internal.d r9 = r23.c()
            r9.a((com.google.android.gms.measurement.internal.fb) r6)
            com.google.android.gms.measurement.internal.ev r6 = r23.a()
            java.lang.String r9 = r2.f12380a
            r6.d(r9)
        L_0x0054:
            boolean r6 = r2.f12387h
            if (r6 != 0) goto L_0x005c
            r23.c(r24)
            return
        L_0x005c:
            long r9 = r2.m
            int r6 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r6 != 0) goto L_0x006c
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b
            com.google.android.gms.common.util.e r6 = r6.j()
            long r9 = r6.a()
        L_0x006c:
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b
            com.google.android.gms.measurement.internal.ke r6 = r6.f11945e
            java.lang.String r11 = r2.f12380a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.o.aa
            boolean r6 = r6.d(r11, r12)
            if (r6 == 0) goto L_0x0083
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b
            com.google.android.gms.measurement.internal.i r6 = r6.l()
            r6.d()
        L_0x0083:
            int r6 = r2.n
            r15 = 0
            r13 = 1
            if (r6 == 0) goto L_0x00a3
            if (r6 == r13) goto L_0x00a3
            com.google.android.gms.measurement.internal.fc r11 = r1.f12266b
            com.google.android.gms.measurement.internal.dy r11 = r11.J_()
            com.google.android.gms.measurement.internal.ea r11 = r11.f11831f
            java.lang.String r12 = r2.f12380a
            java.lang.Object r12 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r12)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r14 = "Incorrect app type, assuming installed app. appId, appType"
            r11.a(r14, r12, r6)
            r6 = 0
        L_0x00a3:
            com.google.android.gms.measurement.internal.d r11 = r23.c()
            r11.b()
            com.google.android.gms.measurement.internal.fc r11 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.ke r11 = r11.f11945e     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r14 = com.google.android.gms.measurement.internal.o.aa     // Catch:{ all -> 0x04c2 }
            boolean r11 = r11.d(r12, r14)     // Catch:{ all -> 0x04c2 }
            if (r11 == 0) goto L_0x0121
            com.google.android.gms.measurement.internal.d r11 = r23.c()     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            java.lang.String r14 = "_npa"
            com.google.android.gms.measurement.internal.jr r14 = r11.c((java.lang.String) r12, (java.lang.String) r14)     // Catch:{ all -> 0x04c2 }
            if (r14 == 0) goto L_0x00d0
            java.lang.String r11 = "auto"
            java.lang.String r12 = r14.f12290b     // Catch:{ all -> 0x04c2 }
            boolean r11 = r11.equals(r12)     // Catch:{ all -> 0x04c2 }
            if (r11 == 0) goto L_0x0121
        L_0x00d0:
            java.lang.Boolean r11 = r2.s     // Catch:{ all -> 0x04c2 }
            if (r11 == 0) goto L_0x010b
            com.google.android.gms.measurement.internal.zzkl r12 = new com.google.android.gms.measurement.internal.zzkl     // Catch:{ all -> 0x04c2 }
            java.lang.String r16 = "_npa"
            java.lang.Boolean r11 = r2.s     // Catch:{ all -> 0x04c2 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x04c2 }
            if (r11 == 0) goto L_0x00e3
            r17 = 1
            goto L_0x00e5
        L_0x00e3:
            r17 = 0
        L_0x00e5:
            java.lang.Long r17 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x04c2 }
            java.lang.String r18 = "auto"
            r11 = r12
            r7 = r12
            r12 = r16
            r19 = r3
            r8 = r14
            r3 = 1
            r13 = r9
            r15 = r17
            r16 = r18
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04c2 }
            if (r8 == 0) goto L_0x0107
            java.lang.Object r8 = r8.f12293e     // Catch:{ all -> 0x04c2 }
            java.lang.Long r11 = r7.f12374c     // Catch:{ all -> 0x04c2 }
            boolean r8 = r8.equals(r11)     // Catch:{ all -> 0x04c2 }
            if (r8 != 0) goto L_0x0124
        L_0x0107:
            r1.a((com.google.android.gms.measurement.internal.zzkl) r7, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04c2 }
            goto L_0x0124
        L_0x010b:
            r19 = r3
            r8 = r14
            r3 = 1
            if (r8 == 0) goto L_0x0124
            com.google.android.gms.measurement.internal.zzkl r7 = new com.google.android.gms.measurement.internal.zzkl     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = "_npa"
            r15 = 0
            java.lang.String r16 = "auto"
            r11 = r7
            r13 = r9
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04c2 }
            r1.b((com.google.android.gms.measurement.internal.zzkl) r7, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04c2 }
            goto L_0x0124
        L_0x0121:
            r19 = r3
            r3 = 1
        L_0x0124:
            com.google.android.gms.measurement.internal.d r7 = r23.c()     // Catch:{ all -> 0x04c2 }
            java.lang.String r8 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.fb r7 = r7.b(r8)     // Catch:{ all -> 0x04c2 }
            if (r7 == 0) goto L_0x01d9
            com.google.android.gms.measurement.internal.fc r11 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            r11.e()     // Catch:{ all -> 0x04c2 }
            java.lang.String r11 = r2.f12381b     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = r7.d()     // Catch:{ all -> 0x04c2 }
            java.lang.String r13 = r2.r     // Catch:{ all -> 0x04c2 }
            java.lang.String r14 = r7.e()     // Catch:{ all -> 0x04c2 }
            boolean r11 = com.google.android.gms.measurement.internal.jq.a((java.lang.String) r11, (java.lang.String) r12, (java.lang.String) r13, (java.lang.String) r14)     // Catch:{ all -> 0x04c2 }
            if (r11 == 0) goto L_0x01d9
            com.google.android.gms.measurement.internal.fc r11 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.dy r11 = r11.J_()     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.ea r11 = r11.f11831f     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = "New GMP App Id passed in. Removing cached database data. appId"
            java.lang.String r13 = r7.b()     // Catch:{ all -> 0x04c2 }
            java.lang.Object r13 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r13)     // Catch:{ all -> 0x04c2 }
            r11.a(r12, r13)     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.d r11 = r23.c()     // Catch:{ all -> 0x04c2 }
            java.lang.String r7 = r7.b()     // Catch:{ all -> 0x04c2 }
            r11.w()     // Catch:{ all -> 0x04c2 }
            r11.h()     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.common.internal.s.a((java.lang.String) r7)     // Catch:{ all -> 0x04c2 }
            android.database.sqlite.SQLiteDatabase r12 = r11.e()     // Catch:{ SQLiteException -> 0x01c8 }
            java.lang.String[] r13 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x01c8 }
            r15 = 0
            r13[r15] = r7     // Catch:{ SQLiteException -> 0x01c8 }
            java.lang.String r14 = "events"
            int r14 = r12.delete(r14, r0, r13)     // Catch:{ SQLiteException -> 0x01c8 }
            int r14 = r14 + r15
            java.lang.String r15 = "user_attributes"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01c8 }
            int r14 = r14 + r15
            java.lang.String r15 = "conditional_properties"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01c8 }
            int r14 = r14 + r15
            java.lang.String r15 = "apps"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01c8 }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01c8 }
            int r14 = r14 + r15
            java.lang.String r15 = "raw_events_metadata"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01c8 }
            int r14 = r14 + r15
            java.lang.String r15 = "event_filters"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01c8 }
            int r14 = r14 + r15
            java.lang.String r15 = "property_filters"
            int r15 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01c8 }
            int r14 = r14 + r15
            java.lang.String r15 = "audience_filter_values"
            int r0 = r12.delete(r15, r0, r13)     // Catch:{ SQLiteException -> 0x01c8 }
            int r14 = r14 + r0
            if (r14 <= 0) goto L_0x01d8
            com.google.android.gms.measurement.internal.dy r0 = r11.J_()     // Catch:{ SQLiteException -> 0x01c8 }
            com.google.android.gms.measurement.internal.ea r0 = r0.k     // Catch:{ SQLiteException -> 0x01c8 }
            java.lang.String r12 = "Deleted application data. app, records"
            java.lang.Integer r13 = java.lang.Integer.valueOf(r14)     // Catch:{ SQLiteException -> 0x01c8 }
            r0.a(r12, r7, r13)     // Catch:{ SQLiteException -> 0x01c8 }
            goto L_0x01d8
        L_0x01c8:
            r0 = move-exception
            com.google.android.gms.measurement.internal.dy r11 = r11.J_()     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.ea r11 = r11.f11828c     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = "Error deleting application data. appId, error"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r7)     // Catch:{ all -> 0x04c2 }
            r11.a(r12, r7, r0)     // Catch:{ all -> 0x04c2 }
        L_0x01d8:
            r7 = 0
        L_0x01d9:
            if (r7 == 0) goto L_0x023a
            long r11 = r7.l()     // Catch:{ all -> 0x04c2 }
            r13 = -2147483648(0xffffffff80000000, double:NaN)
            int r0 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r0 == 0) goto L_0x01f4
            long r11 = r7.l()     // Catch:{ all -> 0x04c2 }
            r17 = r4
            long r3 = r2.j     // Catch:{ all -> 0x04c2 }
            int r0 = (r11 > r3 ? 1 : (r11 == r3 ? 0 : -1))
            if (r0 == 0) goto L_0x01f6
            r0 = 1
            goto L_0x01f7
        L_0x01f4:
            r17 = r4
        L_0x01f6:
            r0 = 0
        L_0x01f7:
            long r3 = r7.l()     // Catch:{ all -> 0x04c2 }
            int r11 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r11 != 0) goto L_0x0213
            java.lang.String r3 = r7.k()     // Catch:{ all -> 0x04c2 }
            if (r3 == 0) goto L_0x0213
            java.lang.String r3 = r7.k()     // Catch:{ all -> 0x04c2 }
            java.lang.String r4 = r2.f12382c     // Catch:{ all -> 0x04c2 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x04c2 }
            if (r3 != 0) goto L_0x0213
            r3 = 1
            goto L_0x0214
        L_0x0213:
            r3 = 0
        L_0x0214:
            r0 = r0 | r3
            if (r0 == 0) goto L_0x023c
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04c2 }
            r0.<init>()     // Catch:{ all -> 0x04c2 }
            java.lang.String r3 = "_pv"
            java.lang.String r4 = r7.k()     // Catch:{ all -> 0x04c2 }
            r0.putString(r3, r4)     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.zzan r3 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = "_au"
            com.google.android.gms.measurement.internal.zzam r13 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04c2 }
            r13.<init>(r0)     // Catch:{ all -> 0x04c2 }
            java.lang.String r14 = "auto"
            r11 = r3
            r4 = 0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04c2 }
            r1.a((com.google.android.gms.measurement.internal.zzan) r3, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04c2 }
            goto L_0x023d
        L_0x023a:
            r17 = r4
        L_0x023c:
            r4 = 0
        L_0x023d:
            r23.c(r24)     // Catch:{ all -> 0x04c2 }
            if (r6 != 0) goto L_0x024f
            com.google.android.gms.measurement.internal.d r0 = r23.c()     // Catch:{ all -> 0x04c2 }
            java.lang.String r3 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            java.lang.String r7 = "_f"
            com.google.android.gms.measurement.internal.k r0 = r0.a((java.lang.String) r3, (java.lang.String) r7)     // Catch:{ all -> 0x04c2 }
            goto L_0x0260
        L_0x024f:
            r3 = 1
            if (r6 != r3) goto L_0x025f
            com.google.android.gms.measurement.internal.d r0 = r23.c()     // Catch:{ all -> 0x04c2 }
            java.lang.String r3 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            java.lang.String r7 = "_v"
            com.google.android.gms.measurement.internal.k r0 = r0.a((java.lang.String) r3, (java.lang.String) r7)     // Catch:{ all -> 0x04c2 }
            goto L_0x0260
        L_0x025f:
            r0 = 0
        L_0x0260:
            if (r0 != 0) goto L_0x0497
            r11 = 3600000(0x36ee80, double:1.7786363E-317)
            long r13 = r9 / r11
            r15 = 1
            long r13 = r13 + r15
            long r13 = r13 * r11
            java.lang.String r0 = "_dac"
            java.lang.String r3 = "_r"
            java.lang.String r7 = "_c"
            java.lang.String r15 = "_et"
            if (r6 != 0) goto L_0x0400
            com.google.android.gms.measurement.internal.zzkl r6 = new com.google.android.gms.measurement.internal.zzkl     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = "_fot"
            java.lang.Long r16 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x04c2 }
            java.lang.String r20 = "auto"
            r11 = r6
            r13 = r9
            r8 = r15
            r15 = r16
            r16 = r20
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04c2 }
            r1.a((com.google.android.gms.measurement.internal.zzkl) r6, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.ke r6 = r6.f11945e     // Catch:{ all -> 0x04c2 }
            java.lang.String r11 = r2.f12381b     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r12 = com.google.android.gms.measurement.internal.o.O     // Catch:{ all -> 0x04c2 }
            boolean r6 = r6.d(r11, r12)     // Catch:{ all -> 0x04c2 }
            if (r6 == 0) goto L_0x02a7
            r23.f()     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.fc r6 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.em r6 = r6.f11949i     // Catch:{ all -> 0x04c2 }
            java.lang.String r11 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            r6.a(r11)     // Catch:{ all -> 0x04c2 }
        L_0x02a7:
            r23.f()     // Catch:{ all -> 0x04c2 }
            r23.g()     // Catch:{ all -> 0x04c2 }
            android.os.Bundle r6 = new android.os.Bundle     // Catch:{ all -> 0x04c2 }
            r6.<init>()     // Catch:{ all -> 0x04c2 }
            r11 = 1
            r6.putLong(r7, r11)     // Catch:{ all -> 0x04c2 }
            r6.putLong(r3, r11)     // Catch:{ all -> 0x04c2 }
            r11 = 0
            r6.putLong(r5, r11)     // Catch:{ all -> 0x04c2 }
            r3 = r17
            r6.putLong(r3, r11)     // Catch:{ all -> 0x04c2 }
            r7 = r19
            r6.putLong(r7, r11)     // Catch:{ all -> 0x04c2 }
            java.lang.String r13 = "_sysu"
            r6.putLong(r13, r11)     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.fc r11 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.ke r11 = r11.f11945e     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r13 = com.google.android.gms.measurement.internal.o.Y     // Catch:{ all -> 0x04c2 }
            boolean r11 = r11.d(r12, r13)     // Catch:{ all -> 0x04c2 }
            if (r11 == 0) goto L_0x02e2
            r11 = 1
            r6.putLong(r8, r11)     // Catch:{ all -> 0x04c2 }
            goto L_0x02e4
        L_0x02e2:
            r11 = 1
        L_0x02e4:
            boolean r13 = r2.q     // Catch:{ all -> 0x04c2 }
            if (r13 == 0) goto L_0x02eb
            r6.putLong(r0, r11)     // Catch:{ all -> 0x04c2 }
        L_0x02eb:
            com.google.android.gms.measurement.internal.d r0 = r23.c()     // Catch:{ all -> 0x04c2 }
            java.lang.String r11 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.common.internal.s.a((java.lang.String) r11)     // Catch:{ all -> 0x04c2 }
            r0.h()     // Catch:{ all -> 0x04c2 }
            r0.w()     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = "first_open_count"
            long r13 = r0.h(r11, r12)     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.fc r0 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            android.content.Context r0 = r0.k()     // Catch:{ all -> 0x04c2 }
            android.content.pm.PackageManager r0 = r0.getPackageManager()     // Catch:{ all -> 0x04c2 }
            if (r0 != 0) goto L_0x0324
            com.google.android.gms.measurement.internal.fc r0 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.dy r0 = r0.J_()     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c     // Catch:{ all -> 0x04c2 }
            java.lang.String r4 = "PackageManager is null, first open report might be inaccurate. appId"
            java.lang.String r5 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            java.lang.Object r5 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r5)     // Catch:{ all -> 0x04c2 }
            r0.a(r4, r5)     // Catch:{ all -> 0x04c2 }
            r4 = r13
        L_0x0320:
            r11 = 0
            goto L_0x03e5
        L_0x0324:
            com.google.android.gms.measurement.internal.fc r0 = r1.f12266b     // Catch:{ NameNotFoundException -> 0x0335 }
            android.content.Context r0 = r0.k()     // Catch:{ NameNotFoundException -> 0x0335 }
            com.google.android.gms.common.c.b r0 = com.google.android.gms.common.c.c.a(r0)     // Catch:{ NameNotFoundException -> 0x0335 }
            java.lang.String r11 = r2.f12380a     // Catch:{ NameNotFoundException -> 0x0335 }
            android.content.pm.PackageInfo r0 = r0.b(r11, r4)     // Catch:{ NameNotFoundException -> 0x0335 }
            goto L_0x034a
        L_0x0335:
            r0 = move-exception
            com.google.android.gms.measurement.internal.fc r11 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.dy r11 = r11.J_()     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.ea r11 = r11.f11828c     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = "Package info is null, first open report might be inaccurate. appId"
            java.lang.String r15 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            java.lang.Object r15 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r15)     // Catch:{ all -> 0x04c2 }
            r11.a(r12, r15, r0)     // Catch:{ all -> 0x04c2 }
            r0 = 0
        L_0x034a:
            if (r0 == 0) goto L_0x039d
            long r11 = r0.firstInstallTime     // Catch:{ all -> 0x04c2 }
            r15 = 0
            int r17 = (r11 > r15 ? 1 : (r11 == r15 ? 0 : -1))
            if (r17 == 0) goto L_0x039d
            long r11 = r0.firstInstallTime     // Catch:{ all -> 0x04c2 }
            r15 = r5
            long r4 = r0.lastUpdateTime     // Catch:{ all -> 0x04c2 }
            int r0 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x037f
            com.google.android.gms.measurement.internal.fc r0 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.ke r0 = r0.f11945e     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.o.aI     // Catch:{ all -> 0x04c2 }
            r5 = 0
            boolean r0 = r0.d(r5, r4)     // Catch:{ all -> 0x04c2 }
            if (r0 == 0) goto L_0x0377
            r11 = 0
            int r0 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r0 != 0) goto L_0x037d
            r4 = r15
            r11 = 1
            r6.putLong(r4, r11)     // Catch:{ all -> 0x04c2 }
            goto L_0x037d
        L_0x0377:
            r4 = r15
            r11 = 1
            r6.putLong(r4, r11)     // Catch:{ all -> 0x04c2 }
        L_0x037d:
            r0 = 0
            goto L_0x0381
        L_0x037f:
            r5 = 0
            r0 = 1
        L_0x0381:
            com.google.android.gms.measurement.internal.zzkl r4 = new com.google.android.gms.measurement.internal.zzkl     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = "_fi"
            if (r0 == 0) goto L_0x038a
            r15 = 1
            goto L_0x038c
        L_0x038a:
            r15 = 0
        L_0x038c:
            java.lang.Long r15 = java.lang.Long.valueOf(r15)     // Catch:{ all -> 0x04c2 }
            java.lang.String r16 = "auto"
            r11 = r4
            r21 = r13
            r13 = r9
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04c2 }
            r1.a((com.google.android.gms.measurement.internal.zzkl) r4, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04c2 }
            goto L_0x03a0
        L_0x039d:
            r21 = r13
            r5 = 0
        L_0x03a0:
            com.google.android.gms.measurement.internal.fc r0 = r1.f12266b     // Catch:{ NameNotFoundException -> 0x03b2 }
            android.content.Context r0 = r0.k()     // Catch:{ NameNotFoundException -> 0x03b2 }
            com.google.android.gms.common.c.b r0 = com.google.android.gms.common.c.c.a(r0)     // Catch:{ NameNotFoundException -> 0x03b2 }
            java.lang.String r4 = r2.f12380a     // Catch:{ NameNotFoundException -> 0x03b2 }
            r11 = 0
            android.content.pm.ApplicationInfo r0 = r0.a((java.lang.String) r4, (int) r11)     // Catch:{ NameNotFoundException -> 0x03b2 }
            goto L_0x03c7
        L_0x03b2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.fc r4 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.dy r4 = r4.J_()     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.ea r4 = r4.f11828c     // Catch:{ all -> 0x04c2 }
            java.lang.String r11 = "Application info is null, first open report might be inaccurate. appId"
            java.lang.String r12 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            java.lang.Object r12 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r12)     // Catch:{ all -> 0x04c2 }
            r4.a(r11, r12, r0)     // Catch:{ all -> 0x04c2 }
            r0 = r5
        L_0x03c7:
            if (r0 == 0) goto L_0x03e1
            int r4 = r0.flags     // Catch:{ all -> 0x04c2 }
            r5 = 1
            r4 = r4 & r5
            if (r4 == 0) goto L_0x03d4
            r4 = 1
            r6.putLong(r7, r4)     // Catch:{ all -> 0x04c2 }
        L_0x03d4:
            int r0 = r0.flags     // Catch:{ all -> 0x04c2 }
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x03e1
            java.lang.String r0 = "_sysu"
            r4 = 1
            r6.putLong(r0, r4)     // Catch:{ all -> 0x04c2 }
        L_0x03e1:
            r4 = r21
            goto L_0x0320
        L_0x03e5:
            int r0 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r0 < 0) goto L_0x03ec
            r6.putLong(r3, r4)     // Catch:{ all -> 0x04c2 }
        L_0x03ec:
            com.google.android.gms.measurement.internal.zzan r0 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = "_f"
            com.google.android.gms.measurement.internal.zzam r13 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04c2 }
            r13.<init>(r6)     // Catch:{ all -> 0x04c2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04c2 }
            r1.a((com.google.android.gms.measurement.internal.zzan) r0, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04c2 }
            goto L_0x0456
        L_0x0400:
            r8 = r15
            r4 = 1
            if (r6 != r4) goto L_0x0456
            com.google.android.gms.measurement.internal.zzkl r4 = new com.google.android.gms.measurement.internal.zzkl     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = "_fvt"
            java.lang.Long r15 = java.lang.Long.valueOf(r13)     // Catch:{ all -> 0x04c2 }
            java.lang.String r16 = "auto"
            r11 = r4
            r13 = r9
            r11.<init>(r12, r13, r15, r16)     // Catch:{ all -> 0x04c2 }
            r1.a((com.google.android.gms.measurement.internal.zzkl) r4, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04c2 }
            r23.f()     // Catch:{ all -> 0x04c2 }
            r23.g()     // Catch:{ all -> 0x04c2 }
            android.os.Bundle r4 = new android.os.Bundle     // Catch:{ all -> 0x04c2 }
            r4.<init>()     // Catch:{ all -> 0x04c2 }
            r5 = 1
            r4.putLong(r7, r5)     // Catch:{ all -> 0x04c2 }
            r4.putLong(r3, r5)     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.ke r3 = r3.f11945e     // Catch:{ all -> 0x04c2 }
            java.lang.String r5 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.o.Y     // Catch:{ all -> 0x04c2 }
            boolean r3 = r3.d(r5, r6)     // Catch:{ all -> 0x04c2 }
            r5 = 1
            if (r3 == 0) goto L_0x043c
            r4.putLong(r8, r5)     // Catch:{ all -> 0x04c2 }
        L_0x043c:
            boolean r3 = r2.q     // Catch:{ all -> 0x04c2 }
            if (r3 == 0) goto L_0x0443
            r4.putLong(r0, r5)     // Catch:{ all -> 0x04c2 }
        L_0x0443:
            com.google.android.gms.measurement.internal.zzan r0 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = "_v"
            com.google.android.gms.measurement.internal.zzam r13 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04c2 }
            r13.<init>(r4)     // Catch:{ all -> 0x04c2 }
            java.lang.String r14 = "auto"
            r11 = r0
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04c2 }
            r1.a((com.google.android.gms.measurement.internal.zzan) r0, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04c2 }
        L_0x0456:
            com.google.android.gms.measurement.internal.fc r0 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.ke r0 = r0.f11945e     // Catch:{ all -> 0x04c2 }
            java.lang.String r3 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.o.Z     // Catch:{ all -> 0x04c2 }
            boolean r0 = r0.d(r3, r4)     // Catch:{ all -> 0x04c2 }
            if (r0 != 0) goto L_0x04b3
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04c2 }
            r0.<init>()     // Catch:{ all -> 0x04c2 }
            r3 = 1
            r0.putLong(r8, r3)     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.fc r3 = r1.f12266b     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.ke r3 = r3.f11945e     // Catch:{ all -> 0x04c2 }
            java.lang.String r4 = r2.f12380a     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.o.Y     // Catch:{ all -> 0x04c2 }
            boolean r3 = r3.d(r4, r5)     // Catch:{ all -> 0x04c2 }
            if (r3 == 0) goto L_0x0483
            java.lang.String r3 = "_fr"
            r4 = 1
            r0.putLong(r3, r4)     // Catch:{ all -> 0x04c2 }
        L_0x0483:
            com.google.android.gms.measurement.internal.zzan r3 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = "_e"
            com.google.android.gms.measurement.internal.zzam r13 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04c2 }
            r13.<init>(r0)     // Catch:{ all -> 0x04c2 }
            java.lang.String r14 = "auto"
            r11 = r3
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04c2 }
            r1.a((com.google.android.gms.measurement.internal.zzan) r3, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04c2 }
            goto L_0x04b3
        L_0x0497:
            boolean r0 = r2.f12388i     // Catch:{ all -> 0x04c2 }
            if (r0 == 0) goto L_0x04b3
            android.os.Bundle r0 = new android.os.Bundle     // Catch:{ all -> 0x04c2 }
            r0.<init>()     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.zzan r3 = new com.google.android.gms.measurement.internal.zzan     // Catch:{ all -> 0x04c2 }
            java.lang.String r12 = "_cd"
            com.google.android.gms.measurement.internal.zzam r13 = new com.google.android.gms.measurement.internal.zzam     // Catch:{ all -> 0x04c2 }
            r13.<init>(r0)     // Catch:{ all -> 0x04c2 }
            java.lang.String r14 = "auto"
            r11 = r3
            r15 = r9
            r11.<init>(r12, r13, r14, r15)     // Catch:{ all -> 0x04c2 }
            r1.a((com.google.android.gms.measurement.internal.zzan) r3, (com.google.android.gms.measurement.internal.zzm) r2)     // Catch:{ all -> 0x04c2 }
        L_0x04b3:
            com.google.android.gms.measurement.internal.d r0 = r23.c()     // Catch:{ all -> 0x04c2 }
            r0.c()     // Catch:{ all -> 0x04c2 }
            com.google.android.gms.measurement.internal.d r0 = r23.c()
            r0.x_()
            return
        L_0x04c2:
            r0 = move-exception
            com.google.android.gms.measurement.internal.d r2 = r23.c()
            r2.x_()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.jj.b(com.google.android.gms.measurement.internal.zzm):void");
    }

    /* access modifiers changed from: package-private */
    public final zzm a(String str) {
        String str2 = str;
        fb b2 = c().b(str2);
        if (b2 == null || TextUtils.isEmpty(b2.k())) {
            this.f12266b.J_().j.a("No app data available; dropping", str2);
            return null;
        }
        Boolean b3 = b(b2);
        if (b3 == null || b3.booleanValue()) {
            String d2 = b2.d();
            String k2 = b2.k();
            long l2 = b2.l();
            String m2 = b2.m();
            long n2 = b2.n();
            long o2 = b2.o();
            boolean q2 = b2.q();
            String h2 = b2.h();
            long w2 = b2.w();
            boolean x2 = b2.x();
            boolean y2 = b2.y();
            String e2 = b2.e();
            Boolean z = b2.z();
            long p2 = b2.p();
            List<String> A = b2.A();
            jz.a();
            return new zzm(str, d2, k2, l2, m2, n2, o2, (String) null, q2, false, h2, w2, 0, 0, x2, y2, false, e2, z, p2, A, this.f12266b.f11945e.d(str2, o.aC) ? b2.f() : null);
        }
        this.f12266b.J_().f11828c.a("App version does not match; dropping. appId", dy.a(str));
        return null;
    }

    /* access modifiers changed from: package-private */
    public final void a(zzv zzv, zzm zzm) {
        s.a(zzv);
        s.a(zzv.f12389a);
        s.a(zzv.f12390b);
        s.a(zzv.f12391c);
        s.a(zzv.f12391c.f12372a);
        f();
        g();
        if (e(zzm)) {
            if (!zzm.f12387h) {
                c(zzm);
                return;
            }
            zzv zzv2 = new zzv(zzv);
            boolean z = false;
            zzv2.f12393e = false;
            c().b();
            try {
                zzv d2 = c().d(zzv2.f12389a, zzv2.f12391c.f12372a);
                if (d2 != null && !d2.f12390b.equals(zzv2.f12390b)) {
                    this.f12266b.J_().f11831f.a("Updating a conditional user property with different origin. name, origin, origin (from DB)", this.f12266b.f().c(zzv2.f12391c.f12372a), zzv2.f12390b, d2.f12390b);
                }
                if (d2 != null && d2.f12393e) {
                    zzv2.f12390b = d2.f12390b;
                    zzv2.f12392d = d2.f12392d;
                    zzv2.f12396h = d2.f12396h;
                    zzv2.f12394f = d2.f12394f;
                    zzv2.f12397i = d2.f12397i;
                    zzv2.f12393e = d2.f12393e;
                    zzv2.f12391c = new zzkl(zzv2.f12391c.f12372a, d2.f12391c.f12373b, zzv2.f12391c.a(), d2.f12391c.f12376e);
                } else if (TextUtils.isEmpty(zzv2.f12394f)) {
                    zzv2.f12391c = new zzkl(zzv2.f12391c.f12372a, zzv2.f12392d, zzv2.f12391c.a(), zzv2.f12391c.f12376e);
                    zzv2.f12393e = true;
                    z = true;
                }
                if (zzv2.f12393e) {
                    zzkl zzkl = zzv2.f12391c;
                    jr jrVar = new jr(zzv2.f12389a, zzv2.f12390b, zzkl.f12372a, zzkl.f12373b, zzkl.a());
                    if (c().a(jrVar)) {
                        this.f12266b.J_().j.a("User property updated immediately", zzv2.f12389a, this.f12266b.f().c(jrVar.f12291c), jrVar.f12293e);
                    } else {
                        this.f12266b.J_().f11828c.a("(2)Too many active user properties, ignoring", dy.a(zzv2.f12389a), this.f12266b.f().c(jrVar.f12291c), jrVar.f12293e);
                    }
                    if (z && zzv2.f12397i != null) {
                        b(new zzan(zzv2.f12397i, zzv2.f12392d), zzm);
                    }
                }
                if (c().a(zzv2)) {
                    this.f12266b.J_().j.a("Conditional property added", zzv2.f12389a, this.f12266b.f().c(zzv2.f12391c.f12372a), zzv2.f12391c.a());
                } else {
                    this.f12266b.J_().f11828c.a("Too many conditional properties, ignoring", dy.a(zzv2.f12389a), this.f12266b.f().c(zzv2.f12391c.f12372a), zzv2.f12391c.a());
                }
                c().c();
            } finally {
                c().x_();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void b(zzv zzv, zzm zzm) {
        s.a(zzv);
        s.a(zzv.f12389a);
        s.a(zzv.f12391c);
        s.a(zzv.f12391c.f12372a);
        f();
        g();
        if (e(zzm)) {
            if (!zzm.f12387h) {
                c(zzm);
                return;
            }
            c().b();
            try {
                c(zzm);
                zzv d2 = c().d(zzv.f12389a, zzv.f12391c.f12372a);
                if (d2 != null) {
                    this.f12266b.J_().j.a("Removing conditional user property", zzv.f12389a, this.f12266b.f().c(zzv.f12391c.f12372a));
                    c().e(zzv.f12389a, zzv.f12391c.f12372a);
                    if (d2.f12393e) {
                        c().b(zzv.f12389a, zzv.f12391c.f12372a);
                    }
                    if (zzv.k != null) {
                        Bundle bundle = null;
                        if (zzv.k.f12369b != null) {
                            bundle = zzv.k.f12369b.a();
                        }
                        Bundle bundle2 = bundle;
                        b(this.f12266b.e().a(zzv.f12389a, zzv.k.f12368a, bundle2, d2.f12390b, zzv.k.f12371d), zzm);
                    }
                } else {
                    this.f12266b.J_().f11831f.a("Conditional user property doesn't exist", dy.a(zzv.f12389a), this.f12266b.f().c(zzv.f12391c.f12372a));
                }
                c().c();
            } finally {
                c().x_();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d9  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ff  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0137  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0145  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x018d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.measurement.internal.fb a(com.google.android.gms.measurement.internal.zzm r9, com.google.android.gms.measurement.internal.fb r10, java.lang.String r11) {
        /*
            r8 = this;
            r0 = 1
            if (r10 != 0) goto L_0x001e
            com.google.android.gms.measurement.internal.fb r10 = new com.google.android.gms.measurement.internal.fb
            com.google.android.gms.measurement.internal.fc r1 = r8.f12266b
            java.lang.String r2 = r9.f12380a
            r10.<init>(r1, r2)
            com.google.android.gms.measurement.internal.fc r1 = r8.f12266b
            com.google.android.gms.measurement.internal.jq r1 = r1.e()
            java.lang.String r1 = r1.t()
            r10.a((java.lang.String) r1)
            r10.e((java.lang.String) r11)
        L_0x001c:
            r11 = 1
            goto L_0x003a
        L_0x001e:
            java.lang.String r1 = r10.g()
            boolean r1 = r11.equals(r1)
            if (r1 != 0) goto L_0x0039
            r10.e((java.lang.String) r11)
            com.google.android.gms.measurement.internal.fc r11 = r8.f12266b
            com.google.android.gms.measurement.internal.jq r11 = r11.e()
            java.lang.String r11 = r11.t()
            r10.a((java.lang.String) r11)
            goto L_0x001c
        L_0x0039:
            r11 = 0
        L_0x003a:
            java.lang.String r1 = r9.f12381b
            java.lang.String r2 = r10.d()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x004c
            java.lang.String r11 = r9.f12381b
            r10.b((java.lang.String) r11)
            r11 = 1
        L_0x004c:
            java.lang.String r1 = r9.r
            java.lang.String r2 = r10.e()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x005e
            java.lang.String r11 = r9.r
            r10.c((java.lang.String) r11)
            r11 = 1
        L_0x005e:
            com.google.android.gms.internal.measurement.jz.a()
            com.google.android.gms.measurement.internal.fc r1 = r8.f12266b
            com.google.android.gms.measurement.internal.ke r1 = r1.f11945e
            java.lang.String r2 = r10.b()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.o.aC
            boolean r1 = r1.d(r2, r3)
            if (r1 == 0) goto L_0x0083
            java.lang.String r1 = r9.v
            java.lang.String r2 = r10.f()
            boolean r1 = android.text.TextUtils.equals(r1, r2)
            if (r1 != 0) goto L_0x0083
            java.lang.String r11 = r9.v
            r10.d((java.lang.String) r11)
            r11 = 1
        L_0x0083:
            java.lang.String r1 = r9.k
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x009d
            java.lang.String r1 = r9.k
            java.lang.String r2 = r10.h()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x009d
            java.lang.String r11 = r9.k
            r10.f((java.lang.String) r11)
            r11 = 1
        L_0x009d:
            long r1 = r9.f12384e
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00b5
            long r1 = r9.f12384e
            long r5 = r10.n()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00b5
            long r1 = r9.f12384e
            r10.d((long) r1)
            r11 = 1
        L_0x00b5:
            java.lang.String r1 = r9.f12382c
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x00cf
            java.lang.String r1 = r9.f12382c
            java.lang.String r2 = r10.k()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00cf
            java.lang.String r11 = r9.f12382c
            r10.g((java.lang.String) r11)
            r11 = 1
        L_0x00cf:
            long r1 = r9.j
            long r5 = r10.l()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x00df
            long r1 = r9.j
            r10.c((long) r1)
            r11 = 1
        L_0x00df:
            java.lang.String r1 = r9.f12383d
            if (r1 == 0) goto L_0x00f5
            java.lang.String r1 = r9.f12383d
            java.lang.String r2 = r10.m()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00f5
            java.lang.String r11 = r9.f12383d
            r10.h((java.lang.String) r11)
            r11 = 1
        L_0x00f5:
            long r1 = r9.f12385f
            long r5 = r10.o()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0105
            long r1 = r9.f12385f
            r10.e((long) r1)
            r11 = 1
        L_0x0105:
            boolean r1 = r9.f12387h
            boolean r2 = r10.q()
            if (r1 == r2) goto L_0x0113
            boolean r11 = r9.f12387h
            r10.a((boolean) r11)
            r11 = 1
        L_0x0113:
            java.lang.String r1 = r9.f12386g
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x012d
            java.lang.String r1 = r9.f12386g
            java.lang.String r2 = r10.v()
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x012d
            java.lang.String r11 = r9.f12386g
            r10.i((java.lang.String) r11)
            r11 = 1
        L_0x012d:
            long r1 = r9.l
            long r5 = r10.w()
            int r7 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x013d
            long r1 = r9.l
            r10.j(r1)
            r11 = 1
        L_0x013d:
            boolean r1 = r9.o
            boolean r2 = r10.x()
            if (r1 == r2) goto L_0x014b
            boolean r11 = r9.o
            r10.b((boolean) r11)
            r11 = 1
        L_0x014b:
            boolean r1 = r9.p
            boolean r2 = r10.y()
            if (r1 == r2) goto L_0x0159
            boolean r11 = r9.p
            r10.c((boolean) r11)
            r11 = 1
        L_0x0159:
            com.google.android.gms.measurement.internal.fc r1 = r8.f12266b
            com.google.android.gms.measurement.internal.ke r1 = r1.f11945e
            java.lang.String r2 = r9.f12380a
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r5 = com.google.android.gms.measurement.internal.o.aa
            boolean r1 = r1.d(r2, r5)
            if (r1 == 0) goto L_0x0175
            java.lang.Boolean r1 = r9.s
            java.lang.Boolean r2 = r10.z()
            if (r1 == r2) goto L_0x0175
            java.lang.Boolean r11 = r9.s
            r10.a((java.lang.Boolean) r11)
            r11 = 1
        L_0x0175:
            long r1 = r9.t
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x018b
            long r1 = r9.t
            long r3 = r10.p()
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x018b
            long r1 = r9.t
            r10.f((long) r1)
            r11 = 1
        L_0x018b:
            if (r11 == 0) goto L_0x0194
            com.google.android.gms.measurement.internal.d r9 = r8.c()
            r9.a((com.google.android.gms.measurement.internal.fb) r10)
        L_0x0194:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.jj.a(com.google.android.gms.measurement.internal.zzm, com.google.android.gms.measurement.internal.fb, java.lang.String):com.google.android.gms.measurement.internal.fb");
    }

    /* access modifiers changed from: package-private */
    public final fb c(zzm zzm) {
        f();
        g();
        s.a(zzm);
        s.a(zzm.f12380a);
        fb b2 = c().b(zzm.f12380a);
        String b3 = this.f12266b.b().b(zzm.f12380a);
        jh.a();
        if (!this.f12266b.f11945e.d((String) null, o.aK)) {
            return a(zzm, b2, b3);
        }
        if (b2 == null) {
            b2 = new fb(this.f12266b, zzm.f12380a);
            b2.a(this.f12266b.e().t());
            b2.e(b3);
        } else if (!b3.equals(b2.g())) {
            b2.e(b3);
            b2.a(this.f12266b.e().t());
        }
        b2.b(zzm.f12381b);
        b2.c(zzm.r);
        jz.a();
        if (this.f12266b.f11945e.d(b2.b(), o.aC)) {
            b2.d(zzm.v);
        }
        if (!TextUtils.isEmpty(zzm.k)) {
            b2.f(zzm.k);
        }
        if (zzm.f12384e != 0) {
            b2.d(zzm.f12384e);
        }
        if (!TextUtils.isEmpty(zzm.f12382c)) {
            b2.g(zzm.f12382c);
        }
        b2.c(zzm.j);
        if (zzm.f12383d != null) {
            b2.h(zzm.f12383d);
        }
        b2.e(zzm.f12385f);
        b2.a(zzm.f12387h);
        if (!TextUtils.isEmpty(zzm.f12386g)) {
            b2.i(zzm.f12386g);
        }
        b2.j(zzm.l);
        b2.b(zzm.o);
        b2.c(zzm.p);
        if (this.f12266b.f11945e.d(zzm.f12380a, o.aa)) {
            b2.a(zzm.s);
        }
        b2.f(zzm.t);
        if (b2.a()) {
            c().a(b2);
        }
        return b2;
    }

    /* access modifiers changed from: package-private */
    public final String d(zzm zzm) {
        try {
            return (String) this.f12266b.K_().a(new jm(this, zzm)).get(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e2) {
            this.f12266b.J_().f11828c.a("Failed to get app instance id. appId", dy.a(zzm.f12380a), e2);
            return null;
        }
    }

    private final boolean e(zzm zzm) {
        jz.a();
        return this.f12266b.f11945e.d(zzm.f12380a, o.aC) ? !TextUtils.isEmpty(zzm.f12381b) || !TextUtils.isEmpty(zzm.v) || !TextUtils.isEmpty(zzm.r) : !TextUtils.isEmpty(zzm.f12381b) || !TextUtils.isEmpty(zzm.r);
    }

    static /* synthetic */ void a(jj jjVar) {
        jjVar.f12266b.K_().h();
        d dVar = new d(jjVar);
        dVar.x();
        jjVar.f12272i = dVar;
        jjVar.f12266b.f11945e.f12335a = jjVar.f12270g;
        jv jvVar = new jv(jjVar);
        jvVar.x();
        jjVar.l = jvVar;
        hg hgVar = new hg(jjVar);
        hgVar.x();
        jjVar.f12265a = hgVar;
        jf jfVar = new jf(jjVar);
        jfVar.x();
        jjVar.k = jfVar;
        jjVar.j = new ef(jjVar);
        if (jjVar.f12268d != jjVar.f12269e) {
            jjVar.f12266b.J_().f11828c.a("Not all upload components initialized", Integer.valueOf(jjVar.f12268d), Integer.valueOf(jjVar.f12269e));
        }
        jjVar.n = true;
    }
}
