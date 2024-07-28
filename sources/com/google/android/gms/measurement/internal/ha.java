package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.appsflyer.internal.referrer.Payload;
import com.google.android.gms.internal.measurement.jn;
import com.google.android.gms.internal.measurement.kf;

final class ha implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ ge f12090a;

    private ha(ge geVar) {
        this.f12090a = geVar;
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.f12090a.J_().k.a("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.f12090a.L_();
                        String str = jq.a(intent) ? "gs" : "auto";
                        String queryParameter = data.getQueryParameter(Payload.REFERRER);
                        boolean z = bundle == null;
                        kf.a();
                        if (o.az.a(null).booleanValue()) {
                            this.f12090a.K_().a((Runnable) new gz(this, z, data, str, queryParameter));
                        } else {
                            a(z, data, str, queryParameter);
                        }
                        this.f12090a.e().a(activity, bundle);
                        return;
                    }
                }
                this.f12090a.e().a(activity, bundle);
            }
        } catch (Exception e2) {
            this.f12090a.J_().f11828c.a("Throwable caught in onActivityCreated", e2);
        } finally {
            this.f12090a.e().a(activity, bundle);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009e A[SYNTHETIC, Splitter:B:33:0x009e] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00e6 A[Catch:{ Exception -> 0x01a7 }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00f8 A[SYNTHETIC, Splitter:B:49:0x00f8] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0127 A[Catch:{ Exception -> 0x01a7 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0128 A[Catch:{ Exception -> 0x01a7 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(boolean r18, android.net.Uri r19, java.lang.String r20, java.lang.String r21) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            r2 = r21
            com.google.android.gms.measurement.internal.ge r3 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.ke r3 = r3.H_()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.o.aw     // Catch:{ Exception -> 0x01a7 }
            r5 = 0
            boolean r3 = r3.d(r5, r4)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r4 = "Activity created with data 'referrer' without required params"
            java.lang.String r6 = "utm_medium"
            java.lang.String r7 = "_cis"
            java.lang.String r8 = "utm_source"
            java.lang.String r9 = "utm_campaign"
            java.lang.String r10 = "gclid"
            if (r3 != 0) goto L_0x0043
            com.google.android.gms.measurement.internal.ge r3 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.ke r3 = r3.H_()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.o.ay     // Catch:{ Exception -> 0x01a7 }
            boolean r3 = r3.d(r5, r11)     // Catch:{ Exception -> 0x01a7 }
            if (r3 != 0) goto L_0x0043
            com.google.android.gms.measurement.internal.ge r3 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.ke r3 = r3.H_()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.o.ax     // Catch:{ Exception -> 0x01a7 }
            boolean r3 = r3.d(r5, r11)     // Catch:{ Exception -> 0x01a7 }
            if (r3 == 0) goto L_0x0041
            goto L_0x0043
        L_0x0041:
            r3 = r5
            goto L_0x0098
        L_0x0043:
            com.google.android.gms.measurement.internal.ge r3 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.jq r3 = r3.L_()     // Catch:{ Exception -> 0x01a7 }
            boolean r11 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x01a7 }
            if (r11 == 0) goto L_0x0050
            goto L_0x0041
        L_0x0050:
            boolean r11 = r2.contains(r10)     // Catch:{ Exception -> 0x01a7 }
            if (r11 != 0) goto L_0x0072
            boolean r11 = r2.contains(r9)     // Catch:{ Exception -> 0x01a7 }
            if (r11 != 0) goto L_0x0072
            boolean r11 = r2.contains(r8)     // Catch:{ Exception -> 0x01a7 }
            if (r11 != 0) goto L_0x0072
            boolean r11 = r2.contains(r6)     // Catch:{ Exception -> 0x01a7 }
            if (r11 != 0) goto L_0x0072
            com.google.android.gms.measurement.internal.dy r3 = r3.J_()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.ea r3 = r3.j     // Catch:{ Exception -> 0x01a7 }
            r3.a(r4)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x0041
        L_0x0072:
            java.lang.String r11 = "https://google.com/search?"
            java.lang.String r12 = java.lang.String.valueOf(r21)     // Catch:{ Exception -> 0x01a7 }
            int r13 = r12.length()     // Catch:{ Exception -> 0x01a7 }
            if (r13 == 0) goto L_0x0083
            java.lang.String r11 = r11.concat(r12)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x0089
        L_0x0083:
            java.lang.String r12 = new java.lang.String     // Catch:{ Exception -> 0x01a7 }
            r12.<init>(r11)     // Catch:{ Exception -> 0x01a7 }
            r11 = r12
        L_0x0089:
            android.net.Uri r11 = android.net.Uri.parse(r11)     // Catch:{ Exception -> 0x01a7 }
            android.os.Bundle r3 = r3.a((android.net.Uri) r11)     // Catch:{ Exception -> 0x01a7 }
            if (r3 == 0) goto L_0x0098
            java.lang.String r11 = "referrer"
            r3.putString(r7, r11)     // Catch:{ Exception -> 0x01a7 }
        L_0x0098:
            r11 = 1
            r12 = 0
            java.lang.String r13 = "_cmp"
            if (r18 == 0) goto L_0x00e6
            com.google.android.gms.measurement.internal.ge r14 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.jq r14 = r14.L_()     // Catch:{ Exception -> 0x01a7 }
            r15 = r19
            android.os.Bundle r14 = r14.a((android.net.Uri) r15)     // Catch:{ Exception -> 0x01a7 }
            if (r14 == 0) goto L_0x00e7
            java.lang.String r15 = "intent"
            r14.putString(r7, r15)     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.ge r7 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.ke r7 = r7.H_()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r15 = com.google.android.gms.measurement.internal.o.aw     // Catch:{ Exception -> 0x01a7 }
            boolean r7 = r7.d(r5, r15)     // Catch:{ Exception -> 0x01a7 }
            if (r7 == 0) goto L_0x00e0
            boolean r7 = r14.containsKey(r10)     // Catch:{ Exception -> 0x01a7 }
            if (r7 != 0) goto L_0x00e0
            if (r3 == 0) goto L_0x00e0
            boolean r7 = r3.containsKey(r10)     // Catch:{ Exception -> 0x01a7 }
            if (r7 == 0) goto L_0x00e0
            java.lang.String r7 = "_cer"
            java.lang.String r15 = "gclid=%s"
            java.lang.Object[] r5 = new java.lang.Object[r11]     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r16 = r3.getString(r10)     // Catch:{ Exception -> 0x01a7 }
            r5[r12] = r16     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r5 = java.lang.String.format(r15, r5)     // Catch:{ Exception -> 0x01a7 }
            r14.putString(r7, r5)     // Catch:{ Exception -> 0x01a7 }
        L_0x00e0:
            com.google.android.gms.measurement.internal.ge r5 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            r5.a((java.lang.String) r0, (java.lang.String) r13, (android.os.Bundle) r14)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x00e7
        L_0x00e6:
            r14 = 0
        L_0x00e7:
            com.google.android.gms.measurement.internal.ge r5 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.ke r5 = r5.H_()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.o.ay     // Catch:{ Exception -> 0x01a7 }
            r15 = 0
            boolean r5 = r5.d(r15, r7)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r7 = "auto"
            if (r5 == 0) goto L_0x0121
            com.google.android.gms.measurement.internal.ge r5 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.ke r5 = r5.H_()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.o.ax     // Catch:{ Exception -> 0x01a7 }
            boolean r5 = r5.d(r15, r11)     // Catch:{ Exception -> 0x01a7 }
            if (r5 != 0) goto L_0x0121
            if (r3 == 0) goto L_0x0121
            boolean r5 = r3.containsKey(r10)     // Catch:{ Exception -> 0x01a7 }
            if (r5 == 0) goto L_0x0121
            if (r14 == 0) goto L_0x0116
            boolean r5 = r14.containsKey(r10)     // Catch:{ Exception -> 0x01a7 }
            if (r5 != 0) goto L_0x0121
        L_0x0116:
            com.google.android.gms.measurement.internal.ge r5 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r11 = "_lgclid"
            java.lang.String r14 = r3.getString(r10)     // Catch:{ Exception -> 0x01a7 }
            r5.a((java.lang.String) r7, (java.lang.String) r11, (java.lang.Object) r14)     // Catch:{ Exception -> 0x01a7 }
        L_0x0121:
            boolean r5 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x01a7 }
            if (r5 == 0) goto L_0x0128
            return
        L_0x0128:
            com.google.android.gms.measurement.internal.ge r5 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.dy r5 = r5.J_()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.ea r5 = r5.j     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r11 = "Activity created with referrer"
            r5.a(r11, r2)     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.ge r5 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.ke r5 = r5.H_()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.o.ax     // Catch:{ Exception -> 0x01a7 }
            r14 = 0
            boolean r5 = r5.d(r14, r11)     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r11 = "_ldl"
            if (r5 == 0) goto L_0x0162
            if (r3 == 0) goto L_0x014e
            com.google.android.gms.measurement.internal.ge r2 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            r2.a((java.lang.String) r0, (java.lang.String) r13, (android.os.Bundle) r3)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x015b
        L_0x014e:
            com.google.android.gms.measurement.internal.ge r0 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.dy r0 = r0.J_()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.ea r0 = r0.j     // Catch:{ Exception -> 0x01a7 }
            java.lang.String r3 = "Referrer does not contain valid parameters"
            r0.a(r3, r2)     // Catch:{ Exception -> 0x01a7 }
        L_0x015b:
            com.google.android.gms.measurement.internal.ge r0 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            r2 = 0
            r0.a((java.lang.String) r7, (java.lang.String) r11, (java.lang.Object) r2)     // Catch:{ Exception -> 0x01a7 }
            return
        L_0x0162:
            boolean r0 = r2.contains(r10)     // Catch:{ Exception -> 0x01a7 }
            if (r0 == 0) goto L_0x018d
            boolean r0 = r2.contains(r9)     // Catch:{ Exception -> 0x01a7 }
            if (r0 != 0) goto L_0x018c
            boolean r0 = r2.contains(r8)     // Catch:{ Exception -> 0x01a7 }
            if (r0 != 0) goto L_0x018c
            boolean r0 = r2.contains(r6)     // Catch:{ Exception -> 0x01a7 }
            if (r0 != 0) goto L_0x018c
            java.lang.String r0 = "utm_term"
            boolean r0 = r2.contains(r0)     // Catch:{ Exception -> 0x01a7 }
            if (r0 != 0) goto L_0x018c
            java.lang.String r0 = "utm_content"
            boolean r0 = r2.contains(r0)     // Catch:{ Exception -> 0x01a7 }
            if (r0 == 0) goto L_0x018d
        L_0x018c:
            r12 = 1
        L_0x018d:
            if (r12 != 0) goto L_0x019b
            com.google.android.gms.measurement.internal.ge r0 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.dy r0 = r0.J_()     // Catch:{ Exception -> 0x01a7 }
            com.google.android.gms.measurement.internal.ea r0 = r0.j     // Catch:{ Exception -> 0x01a7 }
            r0.a(r4)     // Catch:{ Exception -> 0x01a7 }
            return
        L_0x019b:
            boolean r0 = android.text.TextUtils.isEmpty(r21)     // Catch:{ Exception -> 0x01a7 }
            if (r0 != 0) goto L_0x01a6
            com.google.android.gms.measurement.internal.ge r0 = r1.f12090a     // Catch:{ Exception -> 0x01a7 }
            r0.a((java.lang.String) r7, (java.lang.String) r11, (java.lang.Object) r2)     // Catch:{ Exception -> 0x01a7 }
        L_0x01a6:
            return
        L_0x01a7:
            r0 = move-exception
            com.google.android.gms.measurement.internal.ge r2 = r1.f12090a
            com.google.android.gms.measurement.internal.dy r2 = r2.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.f11828c
            java.lang.String r3 = "Throwable caught in handleReferrerForOnActivityCreated"
            r2.a(r3, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ha.a(boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    public final void onActivityDestroyed(Activity activity) {
        this.f12090a.e().f12116d.remove(activity);
    }

    public final void onActivityPaused(Activity activity) {
        hl e2 = this.f12090a.e();
        hi a2 = e2.a(activity);
        e2.f12115c = e2.f12114b;
        e2.f12114b = null;
        e2.K_().a((Runnable) new hn(e2, a2));
        is s = this.f12090a.s();
        s.K_().a((Runnable) new iu(s, s.j().b()));
    }

    public final void onActivityResumed(Activity activity) {
        jn.a();
        if (o.V.a(null).booleanValue()) {
            this.f12090a.s().z();
            this.f12090a.e().b(activity);
            return;
        }
        this.f12090a.e().b(activity);
        this.f12090a.s().z();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        hi hiVar;
        hl e2 = this.f12090a.e();
        if (bundle != null && (hiVar = e2.f12116d.get(activity)) != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putLong("id", hiVar.f12107c);
            bundle2.putString("name", hiVar.f12105a);
            bundle2.putString("referrer_name", hiVar.f12106b);
            bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
        }
    }

    /* synthetic */ ha(ge geVar, byte b2) {
        this(geVar);
    }
}
