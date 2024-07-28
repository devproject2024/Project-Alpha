package com.google.firebase.perf.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.internal.p001firebaseperf.ak;
import com.google.android.gms.internal.p001firebaseperf.al;
import com.google.android.gms.internal.p001firebaseperf.ap;
import com.google.android.gms.internal.p001firebaseperf.ar;
import com.google.android.gms.internal.p001firebaseperf.bc;
import com.google.android.gms.internal.p001firebaseperf.bj;
import com.google.android.gms.internal.p001firebaseperf.bp;
import com.google.android.gms.internal.p001firebaseperf.by;
import com.google.android.gms.internal.p001firebaseperf.dq;
import com.google.firebase.c;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.perf.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class g {

    /* renamed from: c  reason: collision with root package name */
    private static g f39198c;

    /* renamed from: a  reason: collision with root package name */
    public final ExecutorService f39199a = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: b  reason: collision with root package name */
    x f39200b = null;

    /* renamed from: d  reason: collision with root package name */
    private c f39201d;

    /* renamed from: e  reason: collision with root package name */
    private a f39202e;

    /* renamed from: f  reason: collision with root package name */
    private FirebaseInstanceId f39203f = null;

    /* renamed from: g  reason: collision with root package name */
    private Context f39204g;

    /* renamed from: h  reason: collision with root package name */
    private com.google.android.gms.clearcut.a f39205h = null;

    /* renamed from: i  reason: collision with root package name */
    private String f39206i;
    private final ap.a j = ap.c();
    private a k = null;
    private FeatureControl l = null;
    private boolean m;

    public static g a() {
        if (f39198c == null) {
            synchronized (g.class) {
                if (f39198c == null) {
                    try {
                        c.e();
                        f39198c = new g();
                    } catch (IllegalStateException unused) {
                        return null;
                    }
                }
            }
        }
        return f39198c;
    }

    private g() {
        this.f39199a.execute(new j(this));
    }

    public final void a(by byVar, ar arVar) {
        this.f39199a.execute(new i(this, byVar, arVar));
        SessionManager.zzcl().zzcn();
    }

    public final void a(bc bcVar, ar arVar) {
        this.f39199a.execute(new k(this, bcVar, arVar));
        SessionManager.zzcl().zzcn();
    }

    public final void a(boolean z) {
        this.f39199a.execute(new n(this, z));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c6, code lost:
        if (com.google.firebase.perf.internal.x.a((java.util.List<com.google.android.gms.internal.p001firebaseperf.bq>) r11.c().zzkx) == false) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ee, code lost:
        if (com.google.firebase.perf.internal.x.a((java.util.List<com.google.android.gms.internal.p001firebaseperf.bq>) r11.e().zzkx) == false) goto L_0x014d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(com.google.android.gms.internal.p001firebaseperf.bp r11) {
        /*
            r10 = this;
            com.google.android.gms.clearcut.a r0 = r10.f39205h
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.google.firebase.perf.a r0 = r10.f39202e
            boolean r0 = r0.b()
            if (r0 == 0) goto L_0x01c8
            com.google.android.gms.internal.firebase-perf.ap r0 = r11.a()
            boolean r0 = r0.a()
            if (r0 != 0) goto L_0x0018
            return
        L_0x0018:
            android.content.Context r0 = r10.f39204g
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            boolean r2 = r11.b()
            if (r2 == 0) goto L_0x0031
            com.google.firebase.perf.internal.o r2 = new com.google.firebase.perf.internal.o
            com.google.android.gms.internal.firebase-perf.by r3 = r11.c()
            r2.<init>(r3)
            r1.add(r2)
        L_0x0031:
            boolean r2 = r11.d()
            if (r2 == 0) goto L_0x0043
            com.google.firebase.perf.internal.p r2 = new com.google.firebase.perf.internal.p
            com.google.android.gms.internal.firebase-perf.bj r3 = r11.e()
            r2.<init>(r3, r0)
            r1.add(r2)
        L_0x0043:
            int r0 = r11.zzii
            r2 = 1
            r0 = r0 & r2
            r3 = 0
            if (r0 == 0) goto L_0x004c
            r0 = 1
            goto L_0x004d
        L_0x004c:
            r0 = 0
        L_0x004d:
            if (r0 == 0) goto L_0x005b
            com.google.firebase.perf.internal.h r0 = new com.google.firebase.perf.internal.h
            com.google.android.gms.internal.firebase-perf.ap r4 = r11.a()
            r0.<init>(r4)
            r1.add(r0)
        L_0x005b:
            boolean r0 = r11.f()
            if (r0 == 0) goto L_0x0074
            com.google.firebase.perf.internal.m r0 = new com.google.firebase.perf.internal.m
            com.google.android.gms.internal.firebase-perf.bc r4 = r11.zzlq
            if (r4 != 0) goto L_0x006c
            com.google.android.gms.internal.firebase-perf.bc r4 = com.google.android.gms.internal.p001firebaseperf.bc.e()
            goto L_0x006e
        L_0x006c:
            com.google.android.gms.internal.firebase-perf.bc r4 = r11.zzlq
        L_0x006e:
            r0.<init>(r4)
            r1.add(r0)
        L_0x0074:
            boolean r0 = r1.isEmpty()
            if (r0 == 0) goto L_0x007c
        L_0x007a:
            r0 = 0
            goto L_0x0095
        L_0x007c:
            java.util.ArrayList r1 = (java.util.ArrayList) r1
            int r0 = r1.size()
            r4 = 0
        L_0x0083:
            if (r4 >= r0) goto L_0x0094
            java.lang.Object r5 = r1.get(r4)
            int r4 = r4 + 1
            com.google.firebase.perf.internal.v r5 = (com.google.firebase.perf.internal.v) r5
            boolean r5 = r5.a()
            if (r5 != 0) goto L_0x0083
            goto L_0x007a
        L_0x0094:
            r0 = 1
        L_0x0095:
            if (r0 != 0) goto L_0x0098
            return
        L_0x0098:
            com.google.firebase.perf.internal.x r0 = r10.f39200b
            boolean r1 = r11.b()
            r4 = 1232348160(0x49742400, float:1000000.0)
            r5 = 1120403456(0x42c80000, float:100.0)
            if (r1 == 0) goto L_0x00c8
            com.google.firebase.perf.internal.RemoteConfigManager r1 = r0.f39243d
            java.lang.String r6 = "trace_sampling_rate"
            float r1 = r1.zza((java.lang.String) r6, (float) r5)
            float r1 = r1 * r4
            long r6 = (long) r1
            long r8 = r0.f39240a
            int r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r1 > 0) goto L_0x00b9
            r1 = 1
            goto L_0x00ba
        L_0x00b9:
            r1 = 0
        L_0x00ba:
            if (r1 != 0) goto L_0x00c8
            com.google.android.gms.internal.firebase-perf.by r1 = r11.c()
            com.google.android.gms.internal.firebase-perf.dz<com.google.android.gms.internal.firebase-perf.bq> r1 = r1.zzkx
            boolean r1 = com.google.firebase.perf.internal.x.a((java.util.List<com.google.android.gms.internal.p001firebaseperf.bq>) r1)
            if (r1 == 0) goto L_0x014d
        L_0x00c8:
            boolean r1 = r11.d()
            if (r1 == 0) goto L_0x00f0
            com.google.firebase.perf.internal.RemoteConfigManager r1 = r0.f39243d
            java.lang.String r6 = "network_sampling_rate"
            float r1 = r1.zza((java.lang.String) r6, (float) r5)
            float r1 = r1 * r4
            long r4 = (long) r1
            long r6 = r0.f39240a
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 > 0) goto L_0x00e1
            r1 = 1
            goto L_0x00e2
        L_0x00e1:
            r1 = 0
        L_0x00e2:
            if (r1 != 0) goto L_0x00f0
            com.google.android.gms.internal.firebase-perf.bj r1 = r11.e()
            com.google.android.gms.internal.firebase-perf.dz<com.google.android.gms.internal.firebase-perf.bq> r1 = r1.zzkx
            boolean r1 = com.google.firebase.perf.internal.x.a((java.util.List<com.google.android.gms.internal.p001firebaseperf.bq>) r1)
            if (r1 == 0) goto L_0x014d
        L_0x00f0:
            boolean r1 = r11.b()
            if (r1 == 0) goto L_0x0127
            com.google.android.gms.internal.firebase-perf.by r1 = r11.c()
            java.lang.String r1 = r1.zzmd
            com.google.android.gms.internal.firebase-perf.w r4 = com.google.android.gms.internal.p001firebaseperf.w.FOREGROUND_TRACE_NAME
            java.lang.String r4 = r4.toString()
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L_0x011a
            com.google.android.gms.internal.firebase-perf.by r1 = r11.c()
            java.lang.String r1 = r1.zzmd
            com.google.android.gms.internal.firebase-perf.w r4 = com.google.android.gms.internal.p001firebaseperf.w.BACKGROUND_TRACE_NAME
            java.lang.String r4 = r4.toString()
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L_0x0127
        L_0x011a:
            com.google.android.gms.internal.firebase-perf.by r1 = r11.c()
            com.google.android.gms.internal.firebase-perf.er<java.lang.String, java.lang.Long> r1 = r1.zzmg
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0127
            goto L_0x012d
        L_0x0127:
            boolean r1 = r11.f()
            if (r1 == 0) goto L_0x012f
        L_0x012d:
            r1 = 0
            goto L_0x0130
        L_0x012f:
            r1 = 1
        L_0x0130:
            if (r1 != 0) goto L_0x0133
            goto L_0x014e
        L_0x0133:
            boolean r1 = r11.d()
            if (r1 == 0) goto L_0x0140
            com.google.firebase.perf.internal.z r0 = r0.f39242c
            boolean r2 = r0.a()
            goto L_0x014e
        L_0x0140:
            boolean r1 = r11.b()
            if (r1 == 0) goto L_0x014d
            com.google.firebase.perf.internal.z r0 = r0.f39241b
            boolean r2 = r0.a()
            goto L_0x014e
        L_0x014d:
            r2 = 0
        L_0x014e:
            if (r2 != 0) goto L_0x01bb
            boolean r0 = r11.d()
            if (r0 == 0) goto L_0x0162
            com.google.firebase.perf.internal.a r0 = r10.k
            com.google.android.gms.internal.firebase-perf.x r1 = com.google.android.gms.internal.p001firebaseperf.x.NETWORK_TRACE_EVENT_RATE_LIMITED
            java.lang.String r1 = r1.toString()
            r0.a((java.lang.String) r1)
            goto L_0x0173
        L_0x0162:
            boolean r0 = r11.b()
            if (r0 == 0) goto L_0x0173
            com.google.firebase.perf.internal.a r0 = r10.k
            com.google.android.gms.internal.firebase-perf.x r1 = com.google.android.gms.internal.p001firebaseperf.x.TRACE_EVENT_RATE_LIMITED
            java.lang.String r1 = r1.toString()
            r0.a((java.lang.String) r1)
        L_0x0173:
            boolean r0 = r10.m
            if (r0 == 0) goto L_0x01ba
            boolean r0 = r11.d()
            if (r0 == 0) goto L_0x0199
            java.lang.String r0 = "Rate Limited NetworkRequestMetric - "
            com.google.android.gms.internal.firebase-perf.bj r11 = r11.e()
            java.lang.String r11 = r11.zzkm
            java.lang.String r11 = java.lang.String.valueOf(r11)
            int r1 = r11.length()
            if (r1 == 0) goto L_0x0193
            r0.concat(r11)
            return
        L_0x0193:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r0)
            return
        L_0x0199:
            boolean r0 = r11.b()
            if (r0 == 0) goto L_0x01ba
            java.lang.String r0 = "Rate Limited TraceMetric - "
            com.google.android.gms.internal.firebase-perf.by r11 = r11.c()
            java.lang.String r11 = r11.zzmd
            java.lang.String r11 = java.lang.String.valueOf(r11)
            int r1 = r11.length()
            if (r1 == 0) goto L_0x01b5
            r0.concat(r11)
            return
        L_0x01b5:
            java.lang.String r11 = new java.lang.String
            r11.<init>(r0)
        L_0x01ba:
            return
        L_0x01bb:
            byte[] r11 = r11.j()
            com.google.android.gms.clearcut.a r0 = r10.f39205h     // Catch:{ SecurityException -> 0x01c8 }
            com.google.android.gms.clearcut.a$a r11 = r0.a((byte[]) r11)     // Catch:{ SecurityException -> 0x01c8 }
            r11.a()     // Catch:{ SecurityException -> 0x01c8 }
        L_0x01c8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.g.a(com.google.android.gms.internal.firebase-perf.bp):void");
    }

    private static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    private final void b() {
        if (!this.j.a() && this.f39202e.b()) {
            if (this.f39203f == null) {
                this.f39203f = FirebaseInstanceId.a();
            }
            String d2 = this.f39203f.d();
            if (d2 != null && !d2.isEmpty()) {
                this.j.b(d2);
            }
        }
    }

    static /* synthetic */ void a(g gVar) {
        gVar.f39201d = c.e();
        gVar.f39202e = a.a();
        gVar.f39204g = gVar.f39201d.a();
        gVar.f39206i = gVar.f39201d.c().f38755b;
        gVar.j.a(gVar.f39206i).a(ak.a().a(gVar.f39204g.getPackageName()).b("1.0.0.240228580").c(a(gVar.f39204g)));
        gVar.b();
        if (gVar.f39205h == null) {
            try {
                gVar.f39205h = com.google.android.gms.clearcut.a.a(gVar.f39204g, "FIREPERF");
            } catch (SecurityException e2) {
                String valueOf = String.valueOf(e2.getMessage());
                if (valueOf.length() != 0) {
                    "Caught SecurityException while init ClearcutLogger: ".concat(valueOf);
                } else {
                    new String("Caught SecurityException while init ClearcutLogger: ");
                }
                gVar.f39205h = null;
            }
        }
        RemoteConfigManager.zzbz().zzcb();
        x xVar = gVar.f39200b;
        if (xVar == null) {
            xVar = new x(gVar.f39204g);
        }
        gVar.f39200b = xVar;
        a aVar = gVar.k;
        if (aVar == null) {
            aVar = a.a();
        }
        gVar.k = aVar;
        FeatureControl featureControl = gVar.l;
        if (featureControl == null) {
            featureControl = FeatureControl.zzao();
        }
        gVar.l = featureControl;
        gVar.m = al.a(gVar.f39204g);
    }

    static /* synthetic */ void a(g gVar, by byVar, ar arVar) {
        if (gVar.f39202e.b()) {
            if (gVar.m) {
                String.format("Logging TraceMetric - %s %dms", new Object[]{byVar.zzmd, Long.valueOf(byVar.zzmf / 1000)});
            }
            if (!gVar.l.zzap()) {
                byVar = (by) ((dq) ((by.a) byVar.n()).a().k());
                if (gVar.m) {
                    String.format("Sessions are disabled. Dropping all sessions from Trace - %s", new Object[]{byVar.zzmd});
                }
            }
            gVar.b();
            gVar.a((bp) ((dq) bp.g().a(((ap.a) ((dq.a) gVar.j.clone())).a(arVar).a((Map<String, String>) new HashMap(gVar.f39202e.f39178a))).a(byVar).k()));
        }
    }

    static /* synthetic */ void a(g gVar, bj bjVar, ar arVar) {
        if (gVar.f39202e.b()) {
            if (gVar.m) {
                long j2 = 0;
                long j3 = !bjVar.e() ? 0 : bjVar.zzkw;
                if (bjVar.b()) {
                    j2 = bjVar.zzkp;
                }
                String.format("Logging NetworkRequestMetric - %s %db %dms,", new Object[]{bjVar.zzkm, Long.valueOf(j2), Long.valueOf(j3 / 1000)});
            }
            if (!gVar.l.zzap()) {
                bjVar = (bj) ((dq) ((bj.b) bjVar.n()).f().k());
                if (gVar.m) {
                    String.format("Sessions are disabled. Dropping all sessions from Network Request - %s", new Object[]{bjVar.zzkm});
                }
            }
            gVar.b();
            gVar.a((bp) ((dq) bp.g().a(gVar.j.a(arVar)).a(bjVar).k()));
        }
    }

    static /* synthetic */ void a(g gVar, bc bcVar, ar arVar) {
        if (gVar.f39202e.b()) {
            if (gVar.m) {
                String.format("Logging GaugeMetric. Cpu Metrics: %d, Memory Metrics: %d, Has Metadata: %b, Session ID: %s", new Object[]{Integer.valueOf(bcVar.b()), Integer.valueOf(bcVar.c()), Boolean.valueOf(bcVar.a()), bcVar.zzjz});
            }
            if (gVar.l.zzap()) {
                bp.a g2 = bp.g();
                gVar.b();
                g2.a(gVar.j.a(arVar)).a(bcVar);
                gVar.a((bp) ((dq) g2.k()));
            }
        }
    }
}
