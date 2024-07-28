package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.a.a;
import com.alipay.iap.android.webapp.sdk.app.manager.AppManagerUtil;
import com.google.android.gms.common.api.internal.g;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.jn;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicReference;

public final class ge extends dc {

    /* renamed from: a  reason: collision with root package name */
    protected ha f12016a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f12017b = true;

    /* renamed from: c  reason: collision with root package name */
    private gd f12018c;

    /* renamed from: d  reason: collision with root package name */
    private final Set<gb> f12019d = new CopyOnWriteArraySet();

    /* renamed from: e  reason: collision with root package name */
    private boolean f12020e;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicReference<String> f12021f = new AtomicReference<>();

    protected ge(fc fcVar) {
        super(fcVar);
    }

    /* access modifiers changed from: protected */
    public final boolean x() {
        return false;
    }

    public final void z() {
        if (k().getApplicationContext() instanceof Application) {
            ((Application) k().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f12016a);
        }
    }

    public final void a(boolean z) {
        u();
        K_().a((Runnable) new gw(this, z));
    }

    public final void b(boolean z) {
        u();
        K_().a((Runnable) new gv(this, z));
    }

    /* access modifiers changed from: private */
    public final void G() {
        if (H_().d((String) null, o.ab)) {
            h();
            String a2 = I_().o.a();
            if (a2 != null) {
                if ("unset".equals(a2)) {
                    a(AppManagerUtil.EXTEND_PREFIX_DEFAULT, "_npa", (Object) null, j().a());
                } else {
                    a(AppManagerUtil.EXTEND_PREFIX_DEFAULT, "_npa", (Object) Long.valueOf("true".equals(a2) ? 1 : 0), j().a());
                }
            }
        }
        if (!this.y.r() || !this.f12017b) {
            J_().j.a("Updating Scion state (FE)");
            d().A();
            return;
        }
        J_().j.a("Recording app launch after enabling measurement for the first time (FE)");
        C();
        jn.a();
        if (H_().d((String) null, o.aM)) {
            s().f12227b.a();
        }
    }

    public final void a(String str, String str2, Bundle bundle) {
        a(str, str2, bundle, true, true, j().a());
    }

    /* access modifiers changed from: package-private */
    public final void b(String str, String str2, Bundle bundle) {
        h();
        a(str, str2, j().a(), bundle);
    }

    /* access modifiers changed from: package-private */
    public final void a(String str, String str2, long j, Bundle bundle) {
        h();
        a(str, str2, j, bundle, true, this.f12018c == null || jq.e(str2), false, (String) null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x03d5  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x03f1  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x04aa  */
    /* JADX WARNING: Removed duplicated region for block: B:168:0x04bb  */
    /* JADX WARNING: Removed duplicated region for block: B:189:0x0555  */
    /* JADX WARNING: Removed duplicated region for block: B:199:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r29, java.lang.String r30, long r31, android.os.Bundle r33, boolean r34, boolean r35, boolean r36, java.lang.String r37) {
        /*
            r28 = this;
            r7 = r28
            r8 = r29
            r15 = r30
            r13 = r31
            r12 = r33
            com.google.android.gms.common.internal.s.a((java.lang.String) r29)
            com.google.android.gms.common.internal.s.a(r33)
            r28.h()
            r28.u()
            com.google.android.gms.measurement.internal.fc r0 = r7.y
            boolean r0 = r0.r()
            if (r0 != 0) goto L_0x002a
            com.google.android.gms.measurement.internal.dy r0 = r28.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.j
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.a(r1)
            return
        L_0x002a:
            com.google.android.gms.measurement.internal.ke r0 = r28.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.o.ak
            r11 = 0
            boolean r0 = r0.d(r11, r1)
            if (r0 == 0) goto L_0x0051
            com.google.android.gms.measurement.internal.dr r0 = r28.c()
            java.util.List<java.lang.String> r0 = r0.f11805a
            if (r0 == 0) goto L_0x0051
            boolean r0 = r0.contains(r15)
            if (r0 != 0) goto L_0x0051
            com.google.android.gms.measurement.internal.dy r0 = r28.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.j
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.a(r1, r15, r8)
            return
        L_0x0051:
            boolean r0 = r7.f12020e
            r16 = 0
            r10 = 1
            if (r0 != 0) goto L_0x00a3
            r7.f12020e = r10
            com.google.android.gms.measurement.internal.fc r0 = r7.y     // Catch:{ ClassNotFoundException -> 0x0098 }
            boolean r0 = r0.f11944d     // Catch:{ ClassNotFoundException -> 0x0098 }
            java.lang.String r1 = "com.google.android.gms.tagmanager.TagManagerService"
            if (r0 != 0) goto L_0x006f
            android.content.Context r0 = r28.k()     // Catch:{ ClassNotFoundException -> 0x0098 }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0098 }
            java.lang.Class r0 = java.lang.Class.forName(r1, r10, r0)     // Catch:{ ClassNotFoundException -> 0x0098 }
            goto L_0x0073
        L_0x006f:
            java.lang.Class r0 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException -> 0x0098 }
        L_0x0073:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r10]     // Catch:{ Exception -> 0x008b }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r16] = r3     // Catch:{ Exception -> 0x008b }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x008b }
            java.lang.Object[] r1 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x008b }
            android.content.Context r2 = r28.k()     // Catch:{ Exception -> 0x008b }
            r1[r16] = r2     // Catch:{ Exception -> 0x008b }
            r0.invoke(r11, r1)     // Catch:{ Exception -> 0x008b }
            goto L_0x00a3
        L_0x008b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.dy r1 = r28.J_()     // Catch:{ ClassNotFoundException -> 0x0098 }
            com.google.android.gms.measurement.internal.ea r1 = r1.f11831f     // Catch:{ ClassNotFoundException -> 0x0098 }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.a(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0098 }
            goto L_0x00a3
        L_0x0098:
            com.google.android.gms.measurement.internal.dy r0 = r28.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.f11834i
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.a(r1)
        L_0x00a3:
            com.google.android.gms.measurement.internal.ke r0 = r28.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.o.aw
            boolean r0 = r0.d(r11, r1)
            if (r0 == 0) goto L_0x00d4
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x00d4
            java.lang.String r0 = "gclid"
            boolean r1 = r12.containsKey(r0)
            if (r1 == 0) goto L_0x00d4
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.common.util.e r0 = r28.j()
            long r5 = r0.a()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            r1 = r28
            r1.a((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
        L_0x00d4:
            java.lang.String r0 = "_ev"
            r1 = 40
            if (r36 == 0) goto L_0x0139
            java.lang.String r2 = "_iap"
            boolean r2 = r2.equals(r15)
            if (r2 != 0) goto L_0x0139
            com.google.android.gms.measurement.internal.fc r2 = r7.y
            com.google.android.gms.measurement.internal.jq r2 = r2.e()
            java.lang.String r3 = "event"
            boolean r4 = r2.a((java.lang.String) r3, (java.lang.String) r15)
            r5 = 2
            if (r4 != 0) goto L_0x00f2
            goto L_0x0107
        L_0x00f2:
            java.lang.String[] r4 = com.google.android.gms.measurement.internal.fx.f12002a
            boolean r4 = r2.a((java.lang.String) r3, (java.lang.String[]) r4, (java.lang.String) r15)
            if (r4 != 0) goto L_0x00ff
            r2 = 13
            r5 = 13
            goto L_0x0107
        L_0x00ff:
            boolean r2 = r2.a((java.lang.String) r3, (int) r1, (java.lang.String) r15)
            if (r2 != 0) goto L_0x0106
            goto L_0x0107
        L_0x0106:
            r5 = 0
        L_0x0107:
            if (r5 == 0) goto L_0x0139
            com.google.android.gms.measurement.internal.dy r2 = r28.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.f11830e
            com.google.android.gms.measurement.internal.dw r3 = r28.l()
            java.lang.String r3 = r3.a((java.lang.String) r15)
            java.lang.String r4 = "Invalid public event name. Event will not be logged (FE)"
            r2.a(r4, r3)
            com.google.android.gms.measurement.internal.fc r2 = r7.y
            r2.e()
            java.lang.String r1 = com.google.android.gms.measurement.internal.jq.a((java.lang.String) r15, (int) r1, (boolean) r10)
            if (r15 == 0) goto L_0x012e
            int r16 = r30.length()
            r2 = r16
            goto L_0x012f
        L_0x012e:
            r2 = 0
        L_0x012f:
            com.google.android.gms.measurement.internal.fc r3 = r7.y
            com.google.android.gms.measurement.internal.jq r3 = r3.e()
            r3.a((int) r5, (java.lang.String) r0, (java.lang.String) r1, (int) r2)
            return
        L_0x0139:
            com.google.android.gms.measurement.internal.hl r2 = r28.e()
            com.google.android.gms.measurement.internal.hi r2 = r2.z()
            java.lang.String r3 = "_sc"
            if (r2 == 0) goto L_0x014d
            boolean r4 = r12.containsKey(r3)
            if (r4 != 0) goto L_0x014d
            r2.f12108d = r10
        L_0x014d:
            if (r34 == 0) goto L_0x0153
            if (r36 == 0) goto L_0x0153
            r4 = 1
            goto L_0x0154
        L_0x0153:
            r4 = 0
        L_0x0154:
            com.google.android.gms.measurement.internal.hl.a((com.google.android.gms.measurement.internal.hi) r2, (android.os.Bundle) r12, (boolean) r4)
            java.lang.String r4 = "am"
            boolean r17 = r4.equals(r8)
            boolean r4 = com.google.android.gms.measurement.internal.jq.e(r30)
            if (r34 == 0) goto L_0x0194
            com.google.android.gms.measurement.internal.gd r5 = r7.f12018c
            if (r5 == 0) goto L_0x0194
            if (r4 != 0) goto L_0x0194
            if (r17 != 0) goto L_0x0194
            com.google.android.gms.measurement.internal.dy r0 = r28.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.j
            com.google.android.gms.measurement.internal.dw r1 = r28.l()
            java.lang.String r1 = r1.a((java.lang.String) r15)
            com.google.android.gms.measurement.internal.dw r2 = r28.l()
            java.lang.String r2 = r2.a((android.os.Bundle) r12)
            java.lang.String r3 = "Passing event to registered event handler (FE)"
            r0.a(r3, r1, r2)
            com.google.android.gms.measurement.internal.gd r1 = r7.f12018c
            r2 = r29
            r3 = r30
            r4 = r33
            r5 = r31
            r1.a(r2, r3, r4, r5)
            return
        L_0x0194:
            com.google.android.gms.measurement.internal.fc r4 = r7.y
            boolean r4 = r4.u()
            if (r4 != 0) goto L_0x019d
            return
        L_0x019d:
            com.google.android.gms.measurement.internal.jq r4 = r28.L_()
            int r4 = r4.b((java.lang.String) r15)
            if (r4 == 0) goto L_0x01d5
            com.google.android.gms.measurement.internal.dy r2 = r28.J_()
            com.google.android.gms.measurement.internal.ea r2 = r2.f11830e
            com.google.android.gms.measurement.internal.dw r3 = r28.l()
            java.lang.String r3 = r3.a((java.lang.String) r15)
            java.lang.String r5 = "Invalid event name. Event will not be logged (FE)"
            r2.a(r5, r3)
            r28.L_()
            java.lang.String r1 = com.google.android.gms.measurement.internal.jq.a((java.lang.String) r15, (int) r1, (boolean) r10)
            if (r15 == 0) goto L_0x01ca
            int r16 = r30.length()
            r2 = r16
            goto L_0x01cb
        L_0x01ca:
            r2 = 0
        L_0x01cb:
            com.google.android.gms.measurement.internal.fc r3 = r7.y
            com.google.android.gms.measurement.internal.jq r3 = r3.e()
            r3.b(r4, r0, r1, r2)
            return
        L_0x01d5:
            java.lang.String r0 = "_sn"
            java.lang.String r5 = "_o"
            java.lang.String r1 = "_si"
            java.lang.String[] r4 = new java.lang.String[]{r5, r0, r3, r1}
            java.util.List r4 = java.util.Arrays.asList(r4)
            java.util.List r18 = java.util.Collections.unmodifiableList(r4)
            com.google.android.gms.measurement.internal.jq r9 = r28.L_()
            r4 = 1
            r6 = 1
            r10 = r37
            r11 = r30
            r12 = r33
            r13 = r18
            r14 = r36
            r7 = r15
            r15 = r4
            android.os.Bundle r15 = r9.a(r10, r11, r12, r13, r14, r15)
            if (r15 == 0) goto L_0x0226
            boolean r4 = r15.containsKey(r3)
            if (r4 == 0) goto L_0x0226
            boolean r4 = r15.containsKey(r1)
            if (r4 != 0) goto L_0x020c
            goto L_0x0226
        L_0x020c:
            java.lang.String r0 = r15.getString(r0)
            java.lang.String r3 = r15.getString(r3)
            long r9 = r15.getLong(r1)
            java.lang.Long r1 = java.lang.Long.valueOf(r9)
            com.google.android.gms.measurement.internal.hi r11 = new com.google.android.gms.measurement.internal.hi
            long r9 = r1.longValue()
            r11.<init>(r0, r3, r9)
            goto L_0x0227
        L_0x0226:
            r11 = 0
        L_0x0227:
            if (r11 != 0) goto L_0x022b
            r0 = r2
            goto L_0x022c
        L_0x022b:
            r0 = r11
        L_0x022c:
            com.google.android.gms.measurement.internal.ke r1 = r28.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.Y
            r9 = 0
            boolean r1 = r1.d(r9, r2)
            r10 = 0
            java.lang.String r14 = "_ae"
            if (r1 == 0) goto L_0x0262
            com.google.android.gms.measurement.internal.hl r1 = r28.e()
            com.google.android.gms.measurement.internal.hi r1 = r1.z()
            if (r1 == 0) goto L_0x0262
            boolean r1 = r14.equals(r7)
            if (r1 == 0) goto L_0x0262
            com.google.android.gms.measurement.internal.is r1 = r28.s()
            com.google.android.gms.measurement.internal.ja r1 = r1.f12228c
            long r1 = r1.a()
            int r3 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r3 <= 0) goto L_0x0262
            com.google.android.gms.measurement.internal.jq r3 = r28.L_()
            r3.a((android.os.Bundle) r15, (long) r1)
        L_0x0262:
            com.google.android.gms.internal.measurement.iv.a()
            com.google.android.gms.measurement.internal.ke r1 = r28.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.aL
            boolean r1 = r1.d(r9, r2)
            if (r1 == 0) goto L_0x02e0
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x02c1
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r7)
            if (r1 == 0) goto L_0x02c1
            com.google.android.gms.measurement.internal.jq r1 = r28.L_()
            java.lang.String r2 = "_ffr"
            java.lang.String r2 = r15.getString(r2)
            boolean r3 = com.google.android.gms.common.util.p.a(r2)
            if (r3 == 0) goto L_0x0293
            r2 = r9
            goto L_0x0297
        L_0x0293:
            java.lang.String r2 = r2.trim()
        L_0x0297:
            com.google.android.gms.measurement.internal.eh r3 = r1.I_()
            com.google.android.gms.measurement.internal.en r3 = r3.x
            java.lang.String r3 = r3.a()
            boolean r3 = com.google.android.gms.measurement.internal.jq.c((java.lang.String) r2, (java.lang.String) r3)
            if (r3 == 0) goto L_0x02b4
            com.google.android.gms.measurement.internal.dy r1 = r1.J_()
            com.google.android.gms.measurement.internal.ea r1 = r1.j
            java.lang.String r2 = "Not logging duplicate session_start_with_rollout event"
            r1.a(r2)
            r1 = 0
            goto L_0x02be
        L_0x02b4:
            com.google.android.gms.measurement.internal.eh r1 = r1.I_()
            com.google.android.gms.measurement.internal.en r1 = r1.x
            r1.a(r2)
            r1 = 1
        L_0x02be:
            if (r1 != 0) goto L_0x02e0
            return
        L_0x02c1:
            boolean r1 = r14.equals(r7)
            if (r1 == 0) goto L_0x02e0
            com.google.android.gms.measurement.internal.jq r1 = r28.L_()
            com.google.android.gms.measurement.internal.eh r1 = r1.I_()
            com.google.android.gms.measurement.internal.en r1 = r1.x
            java.lang.String r1 = r1.a()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x02e0
            java.lang.String r2 = "_ffr"
            r15.putString(r2, r1)
        L_0x02e0:
            java.util.ArrayList r13 = new java.util.ArrayList
            r13.<init>()
            r13.add(r15)
            com.google.android.gms.measurement.internal.jq r1 = r28.L_()
            java.security.SecureRandom r1 = r1.d()
            long r3 = r1.nextLong()
            com.google.android.gms.measurement.internal.ke r1 = r28.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.S
            boolean r1 = r1.d(r9, r2)
            if (r1 == 0) goto L_0x039b
            com.google.android.gms.measurement.internal.eh r1 = r28.I_()
            com.google.android.gms.measurement.internal.el r1 = r1.r
            long r1 = r1.a()
            int r12 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r12 <= 0) goto L_0x039b
            com.google.android.gms.measurement.internal.eh r1 = r28.I_()
            r10 = r31
            boolean r1 = r1.a((long) r10)
            if (r1 == 0) goto L_0x039d
            com.google.android.gms.measurement.internal.eh r1 = r28.I_()
            com.google.android.gms.measurement.internal.ej r1 = r1.u
            boolean r1 = r1.a()
            if (r1 == 0) goto L_0x039d
            com.google.android.gms.measurement.internal.dy r1 = r28.J_()
            com.google.android.gms.measurement.internal.ea r1 = r1.k
            java.lang.String r2 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.a(r2)
            com.google.android.gms.measurement.internal.ke r1 = r28.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.P
            boolean r1 = r1.d(r9, r2)
            if (r1 == 0) goto L_0x0358
            r12 = 0
            com.google.android.gms.common.util.e r1 = r28.j()
            long r21 = r1.a()
            java.lang.String r2 = "auto"
            java.lang.String r23 = "_sid"
            r1 = r28
            r24 = r3
            r3 = r23
            r4 = r12
            r12 = r5
            r5 = r21
            r1.a((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            goto L_0x035b
        L_0x0358:
            r24 = r3
            r12 = r5
        L_0x035b:
            com.google.android.gms.measurement.internal.ke r1 = r28.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.Q
            boolean r1 = r1.d(r9, r2)
            if (r1 == 0) goto L_0x0379
            r4 = 0
            com.google.android.gms.common.util.e r1 = r28.j()
            long r5 = r1.a()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r1 = r28
            r1.a((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
        L_0x0379:
            com.google.android.gms.internal.measurement.lf.a()
            com.google.android.gms.measurement.internal.ke r1 = r28.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.ap
            boolean r1 = r1.d(r9, r2)
            if (r1 == 0) goto L_0x03a0
            r4 = 0
            com.google.android.gms.common.util.e r1 = r28.j()
            long r5 = r1.a()
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            r1 = r28
            r1.a((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            goto L_0x03a0
        L_0x039b:
            r10 = r31
        L_0x039d:
            r24 = r3
            r12 = r5
        L_0x03a0:
            com.google.android.gms.measurement.internal.ke r1 = r28.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.R
            boolean r1 = r1.d(r9, r2)
            if (r1 == 0) goto L_0x03d5
            java.lang.String r1 = "extend_session"
            r2 = 0
            long r1 = r15.getLong(r1, r2)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x03d5
            com.google.android.gms.measurement.internal.dy r1 = r28.J_()
            com.google.android.gms.measurement.internal.ea r1 = r1.k
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.a(r2)
            r5 = r7
            r7 = r28
            com.google.android.gms.measurement.internal.fc r1 = r7.y
            com.google.android.gms.measurement.internal.is r1 = r1.c()
            com.google.android.gms.measurement.internal.jc r1 = r1.f12227b
            r6 = 1
            r1.a(r10, r6)
            goto L_0x03d9
        L_0x03d5:
            r6 = 1
            r5 = r7
            r7 = r28
        L_0x03d9:
            java.util.Set r1 = r15.keySet()
            int r2 = r33.size()
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.util.Arrays.sort(r1)
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x03ef:
            if (r3 >= r2) goto L_0x049e
            r9 = r1[r3]
            java.lang.Object r19 = r15.get(r9)
            r28.L_()
            android.os.Bundle[] r6 = com.google.android.gms.measurement.internal.jq.a((java.lang.Object) r19)
            if (r6 == 0) goto L_0x0479
            r33 = r1
            int r1 = r6.length
            r15.putInt(r9, r1)
            r19 = r2
            r1 = 0
        L_0x0409:
            int r2 = r6.length
            if (r1 >= r2) goto L_0x046a
            r2 = r6[r1]
            r34 = r15
            r15 = 1
            com.google.android.gms.measurement.internal.hl.a((com.google.android.gms.measurement.internal.hi) r0, (android.os.Bundle) r2, (boolean) r15)
            com.google.android.gms.measurement.internal.jq r20 = r28.L_()
            r21 = 0
            java.lang.String r22 = "_ep"
            r26 = r9
            r9 = r20
            r10 = r37
            r11 = r22
            r27 = r12
            r12 = r2
            r2 = r13
            r13 = r18
            r20 = r0
            r0 = r14
            r14 = r36
            r22 = r0
            r23 = 1
            r0 = r34
            r15 = r21
            android.os.Bundle r9 = r9.a(r10, r11, r12, r13, r14, r15)
            java.lang.String r10 = "_en"
            r9.putString(r10, r5)
            java.lang.String r10 = "_eid"
            r11 = r24
            r9.putLong(r10, r11)
            java.lang.String r10 = "_gn"
            r13 = r26
            r9.putString(r10, r13)
            int r10 = r6.length
            java.lang.String r14 = "_ll"
            r9.putInt(r14, r10)
            java.lang.String r10 = "_i"
            r9.putInt(r10, r1)
            r2.add(r9)
            int r1 = r1 + 1
            r15 = r0
            r9 = r13
            r0 = r20
            r14 = r22
            r12 = r27
            r10 = r31
            r13 = r2
            goto L_0x0409
        L_0x046a:
            r20 = r0
            r27 = r12
            r2 = r13
            r22 = r14
            r0 = r15
            r11 = r24
            r23 = 1
            int r1 = r6.length
            int r4 = r4 + r1
            goto L_0x0489
        L_0x0479:
            r20 = r0
            r33 = r1
            r19 = r2
            r27 = r12
            r2 = r13
            r22 = r14
            r0 = r15
            r11 = r24
            r23 = 1
        L_0x0489:
            int r3 = r3 + 1
            r1 = r33
            r15 = r0
            r13 = r2
            r24 = r11
            r2 = r19
            r0 = r20
            r14 = r22
            r12 = r27
            r6 = 1
            r10 = r31
            goto L_0x03ef
        L_0x049e:
            r27 = r12
            r2 = r13
            r22 = r14
            r0 = r15
            r11 = r24
            r23 = 1
            if (r4 == 0) goto L_0x04b4
            java.lang.String r1 = "_eid"
            r0.putLong(r1, r11)
            java.lang.String r1 = "_epc"
            r0.putInt(r1, r4)
        L_0x04b4:
            r0 = 0
        L_0x04b5:
            int r1 = r2.size()
            if (r0 >= r1) goto L_0x0541
            java.lang.Object r1 = r2.get(r0)
            android.os.Bundle r1 = (android.os.Bundle) r1
            if (r0 == 0) goto L_0x04c5
            r3 = 1
            goto L_0x04c6
        L_0x04c5:
            r3 = 0
        L_0x04c6:
            if (r3 == 0) goto L_0x04cb
            java.lang.String r3 = "_ep"
            goto L_0x04cc
        L_0x04cb:
            r3 = r5
        L_0x04cc:
            r9 = r27
            r1.putString(r9, r8)
            if (r35 == 0) goto L_0x04db
            com.google.android.gms.measurement.internal.jq r4 = r28.L_()
            android.os.Bundle r1 = r4.a((android.os.Bundle) r1)
        L_0x04db:
            r10 = r1
            com.google.android.gms.measurement.internal.dy r1 = r28.J_()
            com.google.android.gms.measurement.internal.ea r1 = r1.j
            com.google.android.gms.measurement.internal.dw r4 = r28.l()
            java.lang.String r4 = r4.a((java.lang.String) r5)
            com.google.android.gms.measurement.internal.dw r6 = r28.l()
            java.lang.String r6 = r6.a((android.os.Bundle) r10)
            java.lang.String r11 = "Logging event (FE)"
            r1.a(r11, r4, r6)
            com.google.android.gms.measurement.internal.zzan r11 = new com.google.android.gms.measurement.internal.zzan
            com.google.android.gms.measurement.internal.zzam r4 = new com.google.android.gms.measurement.internal.zzam
            r4.<init>(r10)
            r1 = r11
            r12 = r2
            r2 = r3
            r3 = r4
            r4 = r29
            r13 = r5
            r14 = 1
            r5 = r31
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.hm r1 = r28.d()
            r15 = r37
            r1.a((com.google.android.gms.measurement.internal.zzan) r11, (java.lang.String) r15)
            if (r17 != 0) goto L_0x0537
            java.util.Set<com.google.android.gms.measurement.internal.gb> r1 = r7.f12019d
            java.util.Iterator r11 = r1.iterator()
        L_0x051c:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x0537
            java.lang.Object r1 = r11.next()
            com.google.android.gms.measurement.internal.gb r1 = (com.google.android.gms.measurement.internal.gb) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r10)
            r2 = r29
            r3 = r30
            r5 = r31
            r1.a(r2, r3, r4, r5)
            goto L_0x051c
        L_0x0537:
            int r0 = r0 + 1
            r27 = r9
            r2 = r12
            r5 = r13
            r23 = 1
            goto L_0x04b5
        L_0x0541:
            r13 = r5
            r14 = 1
            com.google.android.gms.measurement.internal.hl r0 = r28.e()
            com.google.android.gms.measurement.internal.hi r0 = r0.z()
            if (r0 == 0) goto L_0x055c
            r0 = r22
            boolean r0 = r0.equals(r13)
            if (r0 == 0) goto L_0x055c
            com.google.android.gms.measurement.internal.is r0 = r28.s()
            r0.a((boolean) r14, (boolean) r14)
        L_0x055c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ge.a(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void a(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        a(str == null ? AppManagerUtil.EXTEND_PREFIX_DEFAULT : str, str2, j, bundle == null ? new Bundle() : bundle, z2, !z2 || this.f12018c == null || jq.e(str2), !z);
    }

    private final void a(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3) {
        K_().a((Runnable) new gj(this, str, str2, j, jq.b(bundle), z, z2, z3));
    }

    public final void a(String str, String str2, Object obj) {
        a(str, str2, obj, true, j().a());
    }

    public final void a(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = AppManagerUtil.EXTEND_PREFIX_DEFAULT;
        }
        String str3 = str;
        int i2 = 6;
        int i3 = 0;
        if (z) {
            i2 = L_().c(str2);
        } else {
            jq L_ = L_();
            if (L_.a("user property", str2)) {
                if (!L_.a("user property", fz.f12004a, str2)) {
                    i2 = 15;
                } else if (L_.a("user property", 24, str2)) {
                    i2 = 0;
                }
            }
        }
        if (i2 != 0) {
            L_();
            String a2 = jq.a(str2, 24, true);
            if (str2 != null) {
                i3 = str2.length();
            }
            this.y.e().a(i2, "_ev", a2, i3);
        } else if (obj != null) {
            int b2 = L_().b(str2, obj);
            if (b2 != 0) {
                L_();
                String a3 = jq.a(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i3 = String.valueOf(obj).length();
                }
                this.y.e().a(b2, "_ev", a3, i3);
                return;
            }
            L_();
            Object c2 = jq.c(str2, obj);
            if (c2 != null) {
                a(str3, str2, j, c2);
            }
        } else {
            a(str3, str2, j, (Object) null);
        }
    }

    private final void a(String str, String str2, long j, Object obj) {
        K_().a((Runnable) new gi(this, str, str2, obj, j));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0088  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r9, java.lang.String r10, java.lang.Object r11, long r12) {
        /*
            r8 = this;
            com.google.android.gms.common.internal.s.a((java.lang.String) r9)
            com.google.android.gms.common.internal.s.a((java.lang.String) r10)
            r8.h()
            r8.u()
            com.google.android.gms.measurement.internal.ke r0 = r8.H_()
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.o.ab
            r2 = 0
            boolean r0 = r0.d(r2, r1)
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L_0x0072
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x0072
            boolean r0 = r11 instanceof java.lang.String
            if (r0 == 0) goto L_0x0061
            r0 = r11
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L_0x0061
            java.util.Locale r10 = java.util.Locale.ENGLISH
            java.lang.String r10 = r0.toLowerCase(r10)
            java.lang.String r11 = "false"
            boolean r10 = r11.equals(r10)
            r2 = 1
            if (r10 == 0) goto L_0x0042
            r4 = r2
            goto L_0x0044
        L_0x0042:
            r4 = 0
        L_0x0044:
            java.lang.Long r10 = java.lang.Long.valueOf(r4)
            com.google.android.gms.measurement.internal.eh r0 = r8.I_()
            com.google.android.gms.measurement.internal.en r0 = r0.o
            r4 = r10
            java.lang.Long r4 = (java.lang.Long) r4
            long r4 = r4.longValue()
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L_0x005c
            java.lang.String r11 = "true"
        L_0x005c:
            r0.a(r11)
            r6 = r10
            goto L_0x0070
        L_0x0061:
            if (r11 != 0) goto L_0x0072
            com.google.android.gms.measurement.internal.eh r10 = r8.I_()
            com.google.android.gms.measurement.internal.en r10 = r10.o
            java.lang.String r0 = "unset"
            r10.a(r0)
            r6 = r11
        L_0x0070:
            r3 = r1
            goto L_0x0074
        L_0x0072:
            r3 = r10
            r6 = r11
        L_0x0074:
            com.google.android.gms.measurement.internal.fc r10 = r8.y
            boolean r10 = r10.r()
            if (r10 != 0) goto L_0x0088
            com.google.android.gms.measurement.internal.dy r9 = r8.J_()
            com.google.android.gms.measurement.internal.ea r9 = r9.j
            java.lang.String r10 = "User property not set since app measurement is disabled"
            r9.a(r10)
            return
        L_0x0088:
            com.google.android.gms.measurement.internal.fc r10 = r8.y
            boolean r10 = r10.u()
            if (r10 != 0) goto L_0x0091
            return
        L_0x0091:
            com.google.android.gms.measurement.internal.dy r10 = r8.J_()
            com.google.android.gms.measurement.internal.ea r10 = r10.j
            com.google.android.gms.measurement.internal.dw r11 = r8.l()
            java.lang.String r11 = r11.a((java.lang.String) r3)
            java.lang.String r0 = "Setting user property (FE)"
            r10.a(r0, r11, r6)
            com.google.android.gms.measurement.internal.zzkl r10 = new com.google.android.gms.measurement.internal.zzkl
            r2 = r10
            r4 = r12
            r7 = r9
            r2.<init>(r3, r4, r6, r7)
            com.google.android.gms.measurement.internal.hm r9 = r8.d()
            r9.a((com.google.android.gms.measurement.internal.zzkl) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ge.a(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final List<zzkl> A() {
        u();
        J_().j.a("Fetching user attributes (FE)");
        if (K_().c()) {
            J_().f11828c.a("Cannot get all user properties from analytics worker thread");
            return Collections.emptyList();
        } else if (kd.a()) {
            J_().f11828c.a("Cannot get all user properties from main thread");
            return Collections.emptyList();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.y.K_().a(atomicReference, 5000, "get user properties", new gk(this, atomicReference));
            List<zzkl> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            J_().f11831f.a("Timed out waiting for get user properties");
            return Collections.emptyList();
        }
    }

    public final String B() {
        return this.f12021f.get();
    }

    /* access modifiers changed from: package-private */
    public final void a(String str) {
        this.f12021f.set(str);
    }

    public final void C() {
        h();
        u();
        if (this.y.u()) {
            if (H_().d((String) null, o.au)) {
                Boolean b2 = H_().b("google_analytics_deferred_deep_link_enabled");
                if (b2 != null && b2.booleanValue()) {
                    J_().j.a("Deferred Deep Link feature enabled.");
                    K_().a((Runnable) new gh(this));
                }
            }
            d().C();
            this.f12017b = false;
            String u = I_().u();
            if (!TextUtils.isEmpty(u)) {
                i().w();
                if (!u.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", u);
                    a("auto", "_ou", bundle);
                }
            }
        }
    }

    public final void a(gd gdVar) {
        gd gdVar2;
        h();
        u();
        if (!(gdVar == null || gdVar == (gdVar2 = this.f12018c))) {
            s.a(gdVar2 == null, (Object) "EventInterceptor already set.");
        }
        this.f12018c = gdVar;
    }

    public final void a(gb gbVar) {
        u();
        s.a(gbVar);
        if (!this.f12019d.add(gbVar)) {
            J_().f11831f.a("OnEventListener already registered");
        }
    }

    public final void b(gb gbVar) {
        u();
        s.a(gbVar);
        if (!this.f12019d.remove(gbVar)) {
            J_().f11831f.a("OnEventListener had not been registered");
        }
    }

    public final void a(Bundle bundle, long j) {
        s.a(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            J_().f11831f.a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        b(bundle2, j);
    }

    public final void b(Bundle bundle, long j) {
        s.a(bundle);
        fy.a(bundle, "app_id", String.class, null);
        fy.a(bundle, "origin", String.class, null);
        fy.a(bundle, "name", String.class, null);
        fy.a(bundle, "value", Object.class, null);
        fy.a(bundle, "trigger_event_name", String.class, null);
        fy.a(bundle, "trigger_timeout", Long.class, 0L);
        fy.a(bundle, "timed_out_event_name", String.class, null);
        fy.a(bundle, "timed_out_event_params", Bundle.class, null);
        fy.a(bundle, "triggered_event_name", String.class, null);
        fy.a(bundle, "triggered_event_params", Bundle.class, null);
        fy.a(bundle, "time_to_live", Long.class, 0L);
        fy.a(bundle, "expired_event_name", String.class, null);
        fy.a(bundle, "expired_event_params", Bundle.class, null);
        s.a(bundle.getString("name"));
        s.a(bundle.getString("origin"));
        s.a(bundle.get("value"));
        bundle.putLong("creation_timestamp", j);
        String string = bundle.getString("name");
        Object obj = bundle.get("value");
        if (L_().c(string) != 0) {
            J_().f11828c.a("Invalid conditional user property name", l().c(string));
        } else if (L_().b(string, obj) != 0) {
            J_().f11828c.a("Invalid conditional user property value", l().c(string), obj);
        } else {
            L_();
            Object c2 = jq.c(string, obj);
            if (c2 == null) {
                J_().f11828c.a("Unable to normalize conditional user property value", l().c(string), obj);
                return;
            }
            fy.a(bundle, c2);
            long j2 = bundle.getLong("trigger_timeout");
            if (TextUtils.isEmpty(bundle.getString("trigger_event_name")) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong("time_to_live");
                if (j3 > 15552000000L || j3 < 1) {
                    J_().f11828c.a("Invalid conditional user property time to live", l().c(string), Long.valueOf(j3));
                } else {
                    K_().a((Runnable) new go(this, bundle));
                }
            } else {
                J_().f11828c.a("Invalid conditional user property timeout", l().c(string), Long.valueOf(j2));
            }
        }
    }

    public final void c(String str, String str2, Bundle bundle) {
        a((String) null, str, str2, bundle);
    }

    public final void a(String str, String str2, String str3, Bundle bundle) {
        long a2 = j().a();
        s.a(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString("name", str2);
        bundle2.putLong("creation_timestamp", a2);
        if (str3 != null) {
            bundle2.putString("expired_event_name", str3);
            bundle2.putBundle("expired_event_params", bundle);
        }
        K_().a((Runnable) new gn(this, bundle2));
    }

    public final ArrayList<Bundle> a(String str, String str2, String str3) {
        if (K_().c()) {
            J_().f11828c.a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (kd.a()) {
            J_().f11828c.a("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.y.K_().a(atomicReference, 5000, "get conditional user properties", new gq(this, atomicReference, str, str2, str3));
            List list = (List) atomicReference.get();
            if (list != null) {
                return jq.b((List<zzv>) list);
            }
            J_().f11831f.a("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    public final Map<String, Object> a(String str, String str2, String str3, boolean z) {
        if (K_().c()) {
            J_().f11828c.a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        } else if (kd.a()) {
            J_().f11828c.a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.y.K_().a(atomicReference, 5000, "get user properties", new gs(this, atomicReference, str, str2, str3, z));
            List<zzkl> list = (List) atomicReference.get();
            if (list == null) {
                J_().f11831f.a("Timed out waiting for handle get user properties");
                return Collections.emptyMap();
            }
            a aVar = new a(list.size());
            for (zzkl zzkl : list) {
                aVar.put(zzkl.f12372a, zzkl.a());
            }
            return aVar;
        }
    }

    public final String D() {
        hi hiVar = this.y.h().f12114b;
        if (hiVar != null) {
            return hiVar.f12105a;
        }
        return null;
    }

    public final String E() {
        hi hiVar = this.y.h().f12114b;
        if (hiVar != null) {
            return hiVar.f12106b;
        }
        return null;
    }

    public final String F() {
        if (this.y.f11941a != null) {
            return this.y.f11941a;
        }
        try {
            return g.a();
        } catch (IllegalStateException e2) {
            this.y.J_().f11828c.a("getGoogleAppId failed with exception", e2);
            return null;
        }
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

    static /* synthetic */ void a(ge geVar, boolean z) {
        geVar.h();
        geVar.u();
        geVar.J_().j.a("Setting app measurement enabled (FE)", Boolean.valueOf(z));
        geVar.I_().b(z);
        geVar.G();
    }

    static /* synthetic */ void a(ge geVar, Bundle bundle) {
        Bundle bundle2 = bundle;
        geVar.h();
        geVar.u();
        s.a(bundle);
        s.a(bundle2.getString("name"));
        s.a(bundle2.getString("origin"));
        s.a(bundle2.get("value"));
        if (!geVar.y.r()) {
            geVar.J_().j.a("Conditional property not sent since collection is disabled");
            return;
        }
        zzkl zzkl = new zzkl(bundle2.getString("name"), bundle2.getLong("triggered_timestamp"), bundle2.get("value"), bundle2.getString("origin"));
        try {
            zzan a2 = geVar.L_().a(bundle2.getString("app_id"), bundle2.getString("triggered_event_name"), bundle2.getBundle("triggered_event_params"), bundle2.getString("origin"), 0);
            geVar.d().a(new zzv(bundle2.getString("app_id"), bundle2.getString("origin"), zzkl, bundle2.getLong("creation_timestamp"), false, bundle2.getString("trigger_event_name"), geVar.L_().a(bundle2.getString("app_id"), bundle2.getString("timed_out_event_name"), bundle2.getBundle("timed_out_event_params"), bundle2.getString("origin"), 0), bundle2.getLong("trigger_timeout"), a2, bundle2.getLong("time_to_live"), geVar.L_().a(bundle2.getString("app_id"), bundle2.getString("expired_event_name"), bundle2.getBundle("expired_event_params"), bundle2.getString("origin"), 0)));
        } catch (IllegalArgumentException unused) {
        }
    }

    static /* synthetic */ void b(ge geVar, Bundle bundle) {
        Bundle bundle2 = bundle;
        geVar.h();
        geVar.u();
        s.a(bundle);
        s.a(bundle2.getString("name"));
        if (!geVar.y.r()) {
            geVar.J_().j.a("Conditional property not cleared since collection is disabled");
            return;
        }
        zzkl zzkl = new zzkl(bundle2.getString("name"), 0, (Object) null, (String) null);
        try {
            zzan a2 = geVar.L_().a(bundle2.getString("app_id"), bundle2.getString("expired_event_name"), bundle2.getBundle("expired_event_params"), bundle2.getString("origin"), bundle2.getLong("creation_timestamp"));
            zzkl zzkl2 = zzkl;
            geVar.d().a(new zzv(bundle2.getString("app_id"), bundle2.getString("origin"), zzkl2, bundle2.getLong("creation_timestamp"), bundle2.getBoolean("active"), bundle2.getString("trigger_event_name"), (zzan) null, bundle2.getLong("trigger_timeout"), (zzan) null, bundle2.getLong("time_to_live"), a2));
        } catch (IllegalArgumentException unused) {
        }
    }
}
