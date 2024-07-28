package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.c.c;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.e;
import com.google.android.gms.common.util.o;
import java.lang.reflect.InvocationTargetException;

public final class ke extends ft {

    /* renamed from: a  reason: collision with root package name */
    kg f12335a = b.f11715a;

    /* renamed from: b  reason: collision with root package name */
    private Boolean f12336b;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f12337c;

    ke(fc fcVar) {
        super(fcVar);
    }

    public final int a(String str) {
        return b(str, o.o);
    }

    public final boolean a() {
        if (this.f12337c == null) {
            synchronized (this) {
                if (this.f12337c == null) {
                    ApplicationInfo applicationInfo = k().getApplicationInfo();
                    String a2 = o.a();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.f12337c = Boolean.valueOf(str != null && str.equals(a2));
                    }
                    if (this.f12337c == null) {
                        this.f12337c = Boolean.TRUE;
                        J_().f11828c.a("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.f12337c.booleanValue();
    }

    public final long a(String str, dn<Long> dnVar) {
        if (str == null) {
            return dnVar.a(null).longValue();
        }
        String a2 = this.f12335a.a(str, dnVar.f11797a);
        if (TextUtils.isEmpty(a2)) {
            return dnVar.a(null).longValue();
        }
        try {
            return dnVar.a(Long.valueOf(Long.parseLong(a2))).longValue();
        } catch (NumberFormatException unused) {
            return dnVar.a(null).longValue();
        }
    }

    public final int b(String str, dn<Integer> dnVar) {
        if (str == null) {
            return dnVar.a(null).intValue();
        }
        String a2 = this.f12335a.a(str, dnVar.f11797a);
        if (TextUtils.isEmpty(a2)) {
            return dnVar.a(null).intValue();
        }
        try {
            return dnVar.a(Integer.valueOf(Integer.parseInt(a2))).intValue();
        } catch (NumberFormatException unused) {
            return dnVar.a(null).intValue();
        }
    }

    public final double c(String str, dn<Double> dnVar) {
        if (str == null) {
            return dnVar.a(null).doubleValue();
        }
        String a2 = this.f12335a.a(str, dnVar.f11797a);
        if (TextUtils.isEmpty(a2)) {
            return dnVar.a(null).doubleValue();
        }
        try {
            return dnVar.a(Double.valueOf(Double.parseDouble(a2))).doubleValue();
        } catch (NumberFormatException unused) {
            return dnVar.a(null).doubleValue();
        }
    }

    public final boolean d(String str, dn<Boolean> dnVar) {
        if (str == null) {
            return dnVar.a(null).booleanValue();
        }
        String a2 = this.f12335a.a(str, dnVar.f11797a);
        if (TextUtils.isEmpty(a2)) {
            return dnVar.a(null).booleanValue();
        }
        return dnVar.a(Boolean.valueOf(Boolean.parseBoolean(a2))).booleanValue();
    }

    private final Bundle t() {
        try {
            if (k().getPackageManager() == null) {
                J_().f11828c.a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo a2 = c.a(k()).a(k().getPackageName(), 128);
            if (a2 != null) {
                return a2.metaData;
            }
            J_().f11828c.a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e2) {
            J_().f11828c.a("Failed to load metadata: Package name not found", e2);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean b(String str) {
        s.a(str);
        Bundle t = t();
        if (t == null) {
            J_().f11828c.a("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!t.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(t.getBoolean(str));
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029 A[SYNTHETIC, Splitter:B:9:0x0029] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> c(java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.s.a((java.lang.String) r4)
            android.os.Bundle r0 = r3.t()
            r1 = 0
            if (r0 != 0) goto L_0x0017
            com.google.android.gms.measurement.internal.dy r4 = r3.J_()
            com.google.android.gms.measurement.internal.ea r4 = r4.f11828c
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.a(r0)
        L_0x0015:
            r4 = r1
            goto L_0x0026
        L_0x0017:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x001e
            goto L_0x0015
        L_0x001e:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0026:
            if (r4 != 0) goto L_0x0029
            return r1
        L_0x0029:
            android.content.Context r0 = r3.k()     // Catch:{ NotFoundException -> 0x0041 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0041 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0041 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0041 }
            if (r4 != 0) goto L_0x003c
            return r1
        L_0x003c:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0041 }
            return r4
        L_0x0041:
            r4 = move-exception
            com.google.android.gms.measurement.internal.dy r0 = r3.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.a(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ke.c(java.lang.String):java.util.List");
    }

    public final boolean b() {
        Boolean b2 = b("firebase_analytics_collection_deactivated");
        return b2 != null && b2.booleanValue();
    }

    public final Boolean c() {
        Boolean b2 = b("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(b2 == null || b2.booleanValue());
    }

    public static long d() {
        return o.D.a(null).longValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002a, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L_0x002c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(com.google.android.gms.measurement.internal.fb r6) {
        /*
            r5 = this;
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r6.d()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0030
            com.google.android.gms.internal.measurement.jz.a()
            com.google.android.gms.measurement.internal.ke r1 = r5.H_()
            java.lang.String r2 = r6.b()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.o.aC
            boolean r1 = r1.d(r2, r3)
            if (r1 == 0) goto L_0x002c
            java.lang.String r1 = r6.f()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0030
        L_0x002c:
            java.lang.String r1 = r6.e()
        L_0x0030:
            com.google.android.gms.measurement.internal.dn<java.lang.String> r2 = com.google.android.gms.measurement.internal.o.f12350e
            r3 = 0
            java.lang.Object r2 = r2.a(r3)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r2 = r0.scheme(r2)
            com.google.android.gms.measurement.internal.dn<java.lang.String> r4 = com.google.android.gms.measurement.internal.o.f12351f
            java.lang.Object r3 = r4.a(r3)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r2 = r2.encodedAuthority(r3)
            java.lang.String r3 = "config/app/"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L_0x005a
            java.lang.String r1 = r3.concat(r1)
            goto L_0x005f
        L_0x005a:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L_0x005f:
            android.net.Uri$Builder r1 = r2.path(r1)
            java.lang.String r6 = r6.c()
            java.lang.String r2 = "app_instance_id"
            android.net.Uri$Builder r6 = r1.appendQueryParameter(r2, r6)
            java.lang.String r1 = "platform"
            java.lang.String r2 = "android"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r1, r2)
            java.lang.String r1 = "gmp_version"
            java.lang.String r2 = "19000"
            r6.appendQueryParameter(r1, r2)
            android.net.Uri r6 = r0.build()
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ke.a(com.google.android.gms.measurement.internal.fb):java.lang.String");
    }

    public static long e() {
        return o.f12349d.a(null).longValue();
    }

    public final String r() {
        return a("debug.firebase.analytics.app", "");
    }

    /* access modifiers changed from: package-private */
    public final String a(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, str2});
        } catch (ClassNotFoundException e2) {
            J_().f11828c.a("Could not find SystemProperties class", e2);
            return str2;
        } catch (NoSuchMethodException e3) {
            J_().f11828c.a("Could not find SystemProperties.get() method", e3);
            return str2;
        } catch (IllegalAccessException e4) {
            J_().f11828c.a("Could not access SystemProperties.get()", e4);
            return str2;
        } catch (InvocationTargetException e5) {
            J_().f11828c.a("SystemProperties.get() threw an exception", e5);
            return str2;
        }
    }

    public final boolean d(String str) {
        return "1".equals(this.f12335a.a(str, "gaia_collection_enabled"));
    }

    /* access modifiers changed from: package-private */
    public final boolean s() {
        if (this.f12336b == null) {
            this.f12336b = b("app_measurement_lite");
            if (this.f12336b == null) {
                this.f12336b = Boolean.FALSE;
            }
        }
        return this.f12336b.booleanValue() || !this.y.f11944d;
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
