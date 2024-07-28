package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.jz;
import com.google.android.gms.internal.measurement.lq;
import java.util.List;

public final class dr extends dc {

    /* renamed from: a  reason: collision with root package name */
    List<String> f11805a;

    /* renamed from: b  reason: collision with root package name */
    private String f11806b;

    /* renamed from: c  reason: collision with root package name */
    private String f11807c;

    /* renamed from: d  reason: collision with root package name */
    private int f11808d;

    /* renamed from: e  reason: collision with root package name */
    private String f11809e;

    /* renamed from: f  reason: collision with root package name */
    private String f11810f;

    /* renamed from: g  reason: collision with root package name */
    private long f11811g;

    /* renamed from: h  reason: collision with root package name */
    private long f11812h;

    /* renamed from: i  reason: collision with root package name */
    private int f11813i;
    private String j;
    private String k;
    private String l;

    dr(fc fcVar, long j2) {
        super(fcVar);
        this.f11812h = j2;
    }

    /* access modifiers changed from: protected */
    public final boolean x() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x024c  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x025c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ea  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x017f A[Catch:{ IllegalStateException -> 0x01e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0181 A[Catch:{ IllegalStateException -> 0x01e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0195 A[SYNTHETIC, Splitter:B:76:0x0195] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01c1 A[Catch:{ IllegalStateException -> 0x01e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01d8 A[Catch:{ IllegalStateException -> 0x01e8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0206  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void y() {
        /*
            r12 = this;
            android.content.Context r0 = r12.k()
            java.lang.String r0 = r0.getPackageName()
            android.content.Context r1 = r12.k()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            java.lang.String r2 = "Unknown"
            java.lang.String r3 = ""
            r4 = 0
            java.lang.String r5 = "unknown"
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r1 != 0) goto L_0x002d
            com.google.android.gms.measurement.internal.dy r7 = r12.J_()
            com.google.android.gms.measurement.internal.ea r7 = r7.f11828c
            java.lang.Object r8 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r0)
            java.lang.String r9 = "PackageManager is null, app identity information might be inaccurate. appId"
            r7.a(r9, r8)
        L_0x002b:
            r8 = r2
            goto L_0x0089
        L_0x002d:
            java.lang.String r5 = r1.getInstallerPackageName(r0)     // Catch:{ IllegalArgumentException -> 0x0032 }
            goto L_0x0041
        L_0x0032:
            com.google.android.gms.measurement.internal.dy r7 = r12.J_()
            com.google.android.gms.measurement.internal.ea r7 = r7.f11828c
            java.lang.Object r8 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r0)
            java.lang.String r9 = "Error retrieving app installer package name. appId"
            r7.a(r9, r8)
        L_0x0041:
            if (r5 != 0) goto L_0x0046
            java.lang.String r5 = "manual_install"
            goto L_0x004f
        L_0x0046:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r5)
            if (r7 == 0) goto L_0x004f
            r5 = r3
        L_0x004f:
            android.content.Context r7 = r12.k()     // Catch:{ NameNotFoundException -> 0x0077 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0077 }
            android.content.pm.PackageInfo r7 = r1.getPackageInfo(r7, r4)     // Catch:{ NameNotFoundException -> 0x0077 }
            if (r7 == 0) goto L_0x002b
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0077 }
            java.lang.CharSequence r8 = r1.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0077 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0077 }
            if (r9 != 0) goto L_0x006e
            java.lang.String r8 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0077 }
            goto L_0x006f
        L_0x006e:
            r8 = r2
        L_0x006f:
            java.lang.String r2 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0074 }
            int r6 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0074 }
            goto L_0x0089
        L_0x0074:
            r7 = r2
            r2 = r8
            goto L_0x0078
        L_0x0077:
            r7 = r2
        L_0x0078:
            com.google.android.gms.measurement.internal.dy r8 = r12.J_()
            com.google.android.gms.measurement.internal.ea r8 = r8.f11828c
            java.lang.Object r9 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r0)
            java.lang.String r10 = "Error retrieving package info. appId, appName"
            r8.a(r10, r9, r2)
            r8 = r2
            r2 = r7
        L_0x0089:
            r12.f11806b = r0
            r12.f11809e = r5
            r12.f11807c = r2
            r12.f11808d = r6
            r12.f11810f = r8
            r5 = 0
            r12.f11811g = r5
            android.content.Context r2 = r12.k()
            com.google.android.gms.common.api.Status r2 = com.google.android.gms.common.api.internal.g.a((android.content.Context) r2)
            r5 = 1
            if (r2 == 0) goto L_0x00aa
            boolean r6 = r2.c()
            if (r6 == 0) goto L_0x00aa
            r6 = 1
            goto L_0x00ab
        L_0x00aa:
            r6 = 0
        L_0x00ab:
            com.google.android.gms.measurement.internal.fc r7 = r12.y
            java.lang.String r7 = r7.f11941a
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            java.lang.String r8 = "am"
            if (r7 != 0) goto L_0x00c3
            com.google.android.gms.measurement.internal.fc r7 = r12.y
            java.lang.String r7 = r7.f11942b
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x00c3
            r7 = 1
            goto L_0x00c4
        L_0x00c3:
            r7 = 0
        L_0x00c4:
            r6 = r6 | r7
            if (r6 != 0) goto L_0x00e8
            if (r2 != 0) goto L_0x00d5
            com.google.android.gms.measurement.internal.dy r2 = r12.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.f11828c
            java.lang.String r7 = "GoogleService failed to initialize (no status)"
            r2.a(r7)
            goto L_0x00e8
        L_0x00d5:
            com.google.android.gms.measurement.internal.dy r7 = r12.J_()
            com.google.android.gms.measurement.internal.ea r7 = r7.f11828c
            int r9 = r2.f8360g
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r2 = r2.f8361h
            java.lang.String r10 = "GoogleService failed to initialize, status"
            r7.a(r10, r9, r2)
        L_0x00e8:
            if (r6 == 0) goto L_0x0153
            com.google.android.gms.measurement.internal.ke r2 = r12.H_()
            java.lang.String r6 = "firebase_analytics_collection_enabled"
            java.lang.Boolean r2 = r2.b(r6)
            com.google.android.gms.measurement.internal.ke r6 = r12.H_()
            boolean r6 = r6.b()
            if (r6 == 0) goto L_0x0114
            com.google.android.gms.measurement.internal.fc r2 = r12.y
            java.lang.String r2 = r2.f11941a
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0153
            com.google.android.gms.measurement.internal.dy r2 = r12.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.f11834i
            java.lang.String r6 = "Collection disabled with firebase_analytics_collection_deactivated=1"
            r2.a(r6)
            goto L_0x0153
        L_0x0114:
            if (r2 == 0) goto L_0x0132
            boolean r6 = r2.booleanValue()
            if (r6 != 0) goto L_0x0132
            com.google.android.gms.measurement.internal.fc r2 = r12.y
            java.lang.String r2 = r2.f11941a
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x0153
            com.google.android.gms.measurement.internal.dy r2 = r12.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.f11834i
            java.lang.String r6 = "Collection disabled with firebase_analytics_collection_enabled=0"
            r2.a(r6)
            goto L_0x0153
        L_0x0132:
            if (r2 != 0) goto L_0x0146
            boolean r2 = com.google.android.gms.common.api.internal.g.b()
            if (r2 == 0) goto L_0x0146
            com.google.android.gms.measurement.internal.dy r2 = r12.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.f11834i
            java.lang.String r6 = "Collection disabled with google_app_measurement_enable=0"
            r2.a(r6)
            goto L_0x0153
        L_0x0146:
            com.google.android.gms.measurement.internal.dy r2 = r12.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.k
            java.lang.String r6 = "Collection enabled"
            r2.a(r6)
            r2 = 1
            goto L_0x0154
        L_0x0153:
            r2 = 0
        L_0x0154:
            r12.j = r3
            r12.k = r3
            r12.l = r3
            com.google.android.gms.measurement.internal.fc r6 = r12.y
            java.lang.String r6 = r6.f11941a
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x0174
            com.google.android.gms.measurement.internal.fc r6 = r12.y
            java.lang.String r6 = r6.f11942b
            boolean r6 = r8.equals(r6)
            if (r6 == 0) goto L_0x0174
            com.google.android.gms.measurement.internal.fc r6 = r12.y
            java.lang.String r6 = r6.f11941a
            r12.k = r6
        L_0x0174:
            r6 = 0
            java.lang.String r7 = com.google.android.gms.common.api.internal.g.a()     // Catch:{ IllegalStateException -> 0x01e8 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x01e8 }
            if (r8 == 0) goto L_0x0181
            r8 = r3
            goto L_0x0182
        L_0x0181:
            r8 = r7
        L_0x0182:
            r12.j = r8     // Catch:{ IllegalStateException -> 0x01e8 }
            com.google.android.gms.internal.measurement.jz.a()     // Catch:{ IllegalStateException -> 0x01e8 }
            com.google.android.gms.measurement.internal.ke r8 = r12.H_()     // Catch:{ IllegalStateException -> 0x01e8 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.o.aC     // Catch:{ IllegalStateException -> 0x01e8 }
            boolean r8 = r8.d(r6, r9)     // Catch:{ IllegalStateException -> 0x01e8 }
            java.lang.String r9 = "admob_app_id"
            if (r8 == 0) goto L_0x01c1
            com.google.android.gms.common.internal.v r8 = new com.google.android.gms.common.internal.v     // Catch:{ IllegalStateException -> 0x01e8 }
            android.content.Context r10 = r12.k()     // Catch:{ IllegalStateException -> 0x01e8 }
            r8.<init>(r10)     // Catch:{ IllegalStateException -> 0x01e8 }
            java.lang.String r10 = "ga_app_id"
            java.lang.String r10 = r8.a(r10)     // Catch:{ IllegalStateException -> 0x01e8 }
            boolean r11 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IllegalStateException -> 0x01e8 }
            if (r11 == 0) goto L_0x01ab
            goto L_0x01ac
        L_0x01ab:
            r3 = r10
        L_0x01ac:
            r12.l = r3     // Catch:{ IllegalStateException -> 0x01e8 }
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x01e8 }
            if (r3 == 0) goto L_0x01ba
            boolean r3 = android.text.TextUtils.isEmpty(r10)     // Catch:{ IllegalStateException -> 0x01e8 }
            if (r3 != 0) goto L_0x01d6
        L_0x01ba:
            java.lang.String r3 = r8.a(r9)     // Catch:{ IllegalStateException -> 0x01e8 }
            r12.k = r3     // Catch:{ IllegalStateException -> 0x01e8 }
            goto L_0x01d6
        L_0x01c1:
            boolean r3 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x01e8 }
            if (r3 != 0) goto L_0x01d6
            com.google.android.gms.common.internal.v r3 = new com.google.android.gms.common.internal.v     // Catch:{ IllegalStateException -> 0x01e8 }
            android.content.Context r7 = r12.k()     // Catch:{ IllegalStateException -> 0x01e8 }
            r3.<init>(r7)     // Catch:{ IllegalStateException -> 0x01e8 }
            java.lang.String r3 = r3.a(r9)     // Catch:{ IllegalStateException -> 0x01e8 }
            r12.k = r3     // Catch:{ IllegalStateException -> 0x01e8 }
        L_0x01d6:
            if (r2 == 0) goto L_0x01f8
            com.google.android.gms.measurement.internal.dy r2 = r12.J_()     // Catch:{ IllegalStateException -> 0x01e8 }
            com.google.android.gms.measurement.internal.ea r2 = r2.k     // Catch:{ IllegalStateException -> 0x01e8 }
            java.lang.String r3 = "App package, google app id"
            java.lang.String r7 = r12.f11806b     // Catch:{ IllegalStateException -> 0x01e8 }
            java.lang.String r8 = r12.j     // Catch:{ IllegalStateException -> 0x01e8 }
            r2.a(r3, r7, r8)     // Catch:{ IllegalStateException -> 0x01e8 }
            goto L_0x01f8
        L_0x01e8:
            r2 = move-exception
            com.google.android.gms.measurement.internal.dy r3 = r12.J_()
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c
            java.lang.Object r0 = com.google.android.gms.measurement.internal.dy.a((java.lang.String) r0)
            java.lang.String r7 = "getGoogleAppId or isMeasurementEnabled failed with exception. appId"
            r3.a(r7, r0, r2)
        L_0x01f8:
            r12.f11805a = r6
            com.google.android.gms.measurement.internal.ke r0 = r12.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.ak
            boolean r0 = r0.d(r6, r2)
            if (r0 == 0) goto L_0x0246
            com.google.android.gms.measurement.internal.ke r0 = r12.H_()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.c(r2)
            if (r0 == 0) goto L_0x0242
            int r2 = r0.size()
            if (r2 != 0) goto L_0x0225
            com.google.android.gms.measurement.internal.dy r2 = r12.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.f11831f
            java.lang.String r3 = "Safelisted event list cannot be empty. Ignoring"
            r2.a(r3)
        L_0x0223:
            r5 = 0
            goto L_0x0242
        L_0x0225:
            java.util.Iterator r2 = r0.iterator()
        L_0x0229:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0242
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.measurement.internal.jq r6 = r12.L_()
            java.lang.String r7 = "safelisted event"
            boolean r3 = r6.b((java.lang.String) r7, (java.lang.String) r3)
            if (r3 != 0) goto L_0x0229
            goto L_0x0223
        L_0x0242:
            if (r5 == 0) goto L_0x0246
            r12.f11805a = r0
        L_0x0246:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 16
            if (r0 < r2) goto L_0x025c
            if (r1 == 0) goto L_0x0259
            android.content.Context r0 = r12.k()
            boolean r0 = com.google.android.gms.common.c.a.a(r0)
            r12.f11813i = r0
            return
        L_0x0259:
            r12.f11813i = r4
            return
        L_0x025c:
            r12.f11813i = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.dr.y():void");
    }

    /* access modifiers changed from: package-private */
    public final zzm a(String str) {
        String str2;
        long j2;
        boolean z;
        boolean z2;
        Boolean b2;
        h();
        String z3 = z();
        String A = A();
        u();
        String str3 = this.f11807c;
        long D = (long) D();
        u();
        String str4 = this.f11809e;
        u();
        h();
        if (this.f11811g == 0) {
            this.f11811g = this.y.e().a(k(), k().getPackageName());
        }
        long j3 = this.f11811g;
        boolean r = this.y.r();
        boolean z4 = !I_().t;
        h();
        if (!this.y.r()) {
            str2 = null;
        } else {
            str2 = F();
        }
        fc fcVar = this.y;
        Long valueOf = Long.valueOf(fcVar.b().f11866i.a());
        if (valueOf.longValue() == 0) {
            j2 = fcVar.k;
            z2 = r;
            z = z4;
        } else {
            z2 = r;
            z = z4;
            j2 = Math.min(fcVar.k, valueOf.longValue());
        }
        int E = E();
        boolean booleanValue = H_().c().booleanValue();
        Boolean b3 = H_().b("google_analytics_ssaid_collection_enabled");
        boolean z5 = b3 == null || b3.booleanValue();
        eh I_ = I_();
        I_.h();
        boolean z6 = I_.c().getBoolean("deferred_analytics_collection", false);
        String B = B();
        Boolean valueOf2 = (!H_().d((String) null, o.aa) || (b2 = H_().b("google_analytics_default_allow_ad_personalization_signals")) == null) ? null : Boolean.valueOf(!b2.booleanValue());
        long j4 = this.f11812h;
        List<String> list = H_().d((String) null, o.ak) ? this.f11805a : null;
        jz.a();
        return new zzm(z3, A, str3, D, str4, 19000, j3, str, z2, z, str2, 0, j2, E, booleanValue, z5, z6, B, valueOf2, j4, list, H_().d((String) null, o.aC) ? C() : null);
    }

    private final String F() {
        lq.a();
        if (H_().d((String) null, o.aF)) {
            J_().k.a("Disabled IID for tests.");
            return null;
        }
        try {
            Class<?> loadClass = k().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            if (loadClass == null) {
                return null;
            }
            try {
                Object invoke = loadClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{k()});
                if (invoke == null) {
                    return null;
                }
                try {
                    return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                } catch (Exception unused) {
                    J_().f11833h.a("Failed to retrieve Firebase Instance Id");
                    return null;
                }
            } catch (Exception unused2) {
                J_().f11832g.a("Failed to obtain Firebase Analytics instance");
                return null;
            }
        } catch (ClassNotFoundException unused3) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final String z() {
        u();
        return this.f11806b;
    }

    /* access modifiers changed from: package-private */
    public final String A() {
        u();
        return this.j;
    }

    /* access modifiers changed from: package-private */
    public final String B() {
        u();
        return this.k;
    }

    /* access modifiers changed from: package-private */
    public final String C() {
        u();
        return this.l;
    }

    /* access modifiers changed from: package-private */
    public final int D() {
        u();
        return this.f11808d;
    }

    /* access modifiers changed from: package-private */
    public final int E() {
        u();
        return this.f11813i;
    }

    public final /* bridge */ /* synthetic */ void M_() {
        super.M_();
    }

    public final /* bridge */ /* synthetic */ void g() {
        super.g();
    }

    public final /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public final /* bridge */ /* synthetic */ z a() {
        return super.a();
    }

    public final /* bridge */ /* synthetic */ ge b() {
        return super.b();
    }

    public final /* bridge */ /* synthetic */ dr c() {
        return super.c();
    }

    public final /* bridge */ /* synthetic */ hm d() {
        return super.d();
    }

    public final /* bridge */ /* synthetic */ hl e() {
        return super.e();
    }

    public final /* bridge */ /* synthetic */ du r() {
        return super.r();
    }

    public final /* bridge */ /* synthetic */ is s() {
        return super.s();
    }

    public final /* bridge */ /* synthetic */ i i() {
        return super.i();
    }

    public final /* bridge */ /* synthetic */ e j() {
        return super.j();
    }

    public final /* bridge */ /* synthetic */ Context k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ dw l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ jq L_() {
        return super.L_();
    }

    public final /* bridge */ /* synthetic */ eu K_() {
        return super.K_();
    }

    public final /* bridge */ /* synthetic */ dy J_() {
        return super.J_();
    }

    public final /* bridge */ /* synthetic */ eh I_() {
        return super.I_();
    }

    public final /* bridge */ /* synthetic */ ke H_() {
        return super.H_();
    }
}
