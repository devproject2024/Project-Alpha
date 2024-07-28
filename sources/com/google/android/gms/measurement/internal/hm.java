package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.a;
import com.google.android.gms.common.util.e;
import com.google.android.gms.internal.measurement.lw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class hm extends dc {

    /* renamed from: a  reason: collision with root package name */
    final Cif f12119a;

    /* renamed from: b  reason: collision with root package name */
    dq f12120b;

    /* renamed from: c  reason: collision with root package name */
    volatile Boolean f12121c;

    /* renamed from: d  reason: collision with root package name */
    private final g f12122d;

    /* renamed from: e  reason: collision with root package name */
    private final jb f12123e;

    /* renamed from: f  reason: collision with root package name */
    private final List<Runnable> f12124f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private final g f12125g;

    protected hm(fc fcVar) {
        super(fcVar);
        this.f12123e = new jb(fcVar.j());
        this.f12119a = new Cif(this);
        this.f12122d = new hp(this, fcVar);
        this.f12125g = new hw(this, fcVar);
    }

    /* access modifiers changed from: protected */
    public final boolean x() {
        return false;
    }

    public final boolean z() {
        h();
        u();
        return this.f12120b != null;
    }

    /* access modifiers changed from: protected */
    public final void A() {
        h();
        u();
        a((Runnable) new hz(this, a(true)));
    }

    /* access modifiers changed from: package-private */
    public final void a(dq dqVar, AbstractSafeParcelable abstractSafeParcelable, zzm zzm) {
        int i2;
        h();
        u();
        int i3 = 0;
        int i4 = 100;
        while (i3 < 1001 && i4 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> A = r().A();
            if (A != null) {
                arrayList.addAll(A);
                i2 = A.size();
            } else {
                i2 = 0;
            }
            if (abstractSafeParcelable != null && i2 < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i5 = 0;
            while (i5 < size) {
                Object obj = arrayList2.get(i5);
                i5++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzan) {
                    try {
                        dqVar.a((zzan) abstractSafeParcelable2, zzm);
                    } catch (RemoteException e2) {
                        J_().f11828c.a("Failed to send event to the service", e2);
                    }
                } else if (abstractSafeParcelable2 instanceof zzkl) {
                    try {
                        dqVar.a((zzkl) abstractSafeParcelable2, zzm);
                    } catch (RemoteException e3) {
                        J_().f11828c.a("Failed to send attribute to the service", e3);
                    }
                } else if (abstractSafeParcelable2 instanceof zzv) {
                    try {
                        dqVar.a((zzv) abstractSafeParcelable2, zzm);
                    } catch (RemoteException e4) {
                        J_().f11828c.a("Failed to send conditional property to the service", e4);
                    }
                } else {
                    J_().f11828c.a("Discarding data. Unrecognized parcel type.");
                }
            }
            i3++;
            i4 = i2;
        }
    }

    /* access modifiers changed from: protected */
    public final void a(zzan zzan, String str) {
        boolean z;
        s.a(zzan);
        h();
        u();
        du r = r();
        Parcel obtain = Parcel.obtain();
        zzan.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            r.J_().f11831f.a("Event is too long for local database. Sending event directly to service");
            z = false;
        } else {
            z = r.a(0, marshall);
        }
        a((Runnable) new hy(this, z, zzan, a(true), str));
    }

    /* access modifiers changed from: protected */
    public final void a(zzv zzv) {
        boolean z;
        s.a(zzv);
        h();
        u();
        du r = r();
        r.L_();
        byte[] a2 = jq.a((Parcelable) zzv);
        if (a2.length > 131072) {
            r.J_().f11831f.a("Conditional user property too long for local database. Sending directly to service");
            z = false;
        } else {
            z = r.a(2, a2);
        }
        a((Runnable) new ib(this, z, new zzv(zzv), a(true), zzv));
    }

    /* access modifiers changed from: protected */
    public final void a(AtomicReference<List<zzv>> atomicReference, String str, String str2, String str3) {
        h();
        u();
        a((Runnable) new ia(this, atomicReference, str, str2, str3, a(false)));
    }

    /* access modifiers changed from: protected */
    public final void a(lw lwVar, String str, String str2) {
        h();
        u();
        a((Runnable) new ie(this, str, str2, a(false), lwVar));
    }

    /* access modifiers changed from: protected */
    public final void a(AtomicReference<List<zzkl>> atomicReference, String str, String str2, String str3, boolean z) {
        h();
        u();
        a((Runnable) new ic(this, atomicReference, str, str2, str3, z, a(false)));
    }

    /* access modifiers changed from: protected */
    public final void a(lw lwVar, String str, String str2, boolean z) {
        h();
        u();
        a((Runnable) new ig(this, str, str2, z, a(false), lwVar));
    }

    /* access modifiers changed from: protected */
    public final void a(zzkl zzkl) {
        h();
        u();
        du r = r();
        Parcel obtain = Parcel.obtain();
        boolean z = false;
        zzkl.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        if (marshall.length > 131072) {
            r.J_().f11831f.a("User property too long for local database. Sending directly to service");
        } else {
            z = r.a(1, marshall);
        }
        a((Runnable) new ho(this, z, zzkl, a(true)));
    }

    /* access modifiers changed from: protected */
    public final void a(AtomicReference<List<zzkl>> atomicReference, boolean z) {
        h();
        u();
        a((Runnable) new hr(this, atomicReference, a(false), z));
    }

    /* access modifiers changed from: protected */
    public final void B() {
        h();
        u();
        zzm a2 = a(false);
        r().z();
        a((Runnable) new hq(this, a2));
    }

    public final void a(AtomicReference<String> atomicReference) {
        h();
        u();
        a((Runnable) new ht(this, atomicReference, a(false)));
    }

    public final void a(lw lwVar) {
        h();
        u();
        a((Runnable) new hs(this, a(false), lwVar));
    }

    /* access modifiers changed from: protected */
    public final void C() {
        h();
        u();
        zzm a2 = a(true);
        boolean d2 = H_().d((String) null, o.av);
        if (d2) {
            r().a(3, new byte[0]);
        }
        a((Runnable) new hv(this, a2, d2));
    }

    /* access modifiers changed from: protected */
    public final void a(hi hiVar) {
        h();
        u();
        a((Runnable) new hu(this, hiVar));
    }

    /* access modifiers changed from: package-private */
    public final void D() {
        h();
        this.f12123e.a();
        this.f12122d.a(o.G.a(null).longValue());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void E() {
        /*
            r6 = this;
            r6.h()
            r6.u()
            boolean r0 = r6.z()
            if (r0 == 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.Boolean r0 = r6.f12121c
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0101
            r6.h()
            r6.u()
            com.google.android.gms.measurement.internal.eh r0 = r6.I_()
            java.lang.Boolean r0 = r0.r()
            if (r0 == 0) goto L_0x002c
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x002c
            r0 = 1
            goto L_0x00fb
        L_0x002c:
            com.google.android.gms.measurement.internal.dr r0 = r6.c()
            int r0 = r0.E()
            if (r0 != r2) goto L_0x003a
        L_0x0036:
            r0 = 1
        L_0x0037:
            r3 = 1
            goto L_0x00da
        L_0x003a:
            com.google.android.gms.measurement.internal.dy r0 = r6.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.k
            java.lang.String r3 = "Checking service availability"
            r0.a(r3)
            com.google.android.gms.measurement.internal.jq r0 = r6.L_()
            int r0 = r0.s()
            if (r0 == 0) goto L_0x00cd
            if (r0 == r2) goto L_0x00bf
            r3 = 2
            if (r0 == r3) goto L_0x0095
            r3 = 3
            if (r0 == r3) goto L_0x0089
            r3 = 9
            if (r0 == r3) goto L_0x007d
            r3 = 18
            if (r0 == r3) goto L_0x0071
            com.google.android.gms.measurement.internal.dy r3 = r6.J_()
            com.google.android.gms.measurement.internal.ea r3 = r3.f11831f
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r4 = "Unexpected service status"
            r3.a(r4, r0)
        L_0x006e:
            r0 = 0
        L_0x006f:
            r3 = 0
            goto L_0x00da
        L_0x0071:
            com.google.android.gms.measurement.internal.dy r0 = r6.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.f11831f
            java.lang.String r3 = "Service updating"
            r0.a(r3)
            goto L_0x0036
        L_0x007d:
            com.google.android.gms.measurement.internal.dy r0 = r6.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.f11831f
            java.lang.String r3 = "Service invalid"
            r0.a(r3)
            goto L_0x006e
        L_0x0089:
            com.google.android.gms.measurement.internal.dy r0 = r6.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.f11831f
            java.lang.String r3 = "Service disabled"
            r0.a(r3)
            goto L_0x006e
        L_0x0095:
            com.google.android.gms.measurement.internal.dy r0 = r6.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.j
            java.lang.String r3 = "Service container out of date"
            r0.a(r3)
            com.google.android.gms.measurement.internal.jq r0 = r6.L_()
            int r0 = r0.r()
            r3 = 17443(0x4423, float:2.4443E-41)
            if (r0 >= r3) goto L_0x00ad
            goto L_0x00ca
        L_0x00ad:
            com.google.android.gms.measurement.internal.eh r0 = r6.I_()
            java.lang.Boolean r0 = r0.r()
            if (r0 == 0) goto L_0x00bd
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x006e
        L_0x00bd:
            r0 = 1
            goto L_0x006f
        L_0x00bf:
            com.google.android.gms.measurement.internal.dy r0 = r6.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.k
            java.lang.String r3 = "Service missing"
            r0.a(r3)
        L_0x00ca:
            r0 = 0
            goto L_0x0037
        L_0x00cd:
            com.google.android.gms.measurement.internal.dy r0 = r6.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.k
            java.lang.String r3 = "Service available"
            r0.a(r3)
            goto L_0x0036
        L_0x00da:
            if (r0 != 0) goto L_0x00f2
            com.google.android.gms.measurement.internal.ke r4 = r6.H_()
            boolean r4 = r4.s()
            if (r4 == 0) goto L_0x00f2
            com.google.android.gms.measurement.internal.dy r3 = r6.J_()
            com.google.android.gms.measurement.internal.ea r3 = r3.f11828c
            java.lang.String r4 = "No way to upload. Consider using the full version of Analytics"
            r3.a(r4)
            r3 = 0
        L_0x00f2:
            if (r3 == 0) goto L_0x00fb
            com.google.android.gms.measurement.internal.eh r3 = r6.I_()
            r3.a((boolean) r0)
        L_0x00fb:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r6.f12121c = r0
        L_0x0101:
            java.lang.Boolean r0 = r6.f12121c
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0171
            com.google.android.gms.measurement.internal.if r0 = r6.f12119a
            com.google.android.gms.measurement.internal.hm r1 = r0.f12199c
            r1.h()
            com.google.android.gms.measurement.internal.hm r1 = r0.f12199c
            android.content.Context r1 = r1.k()
            monitor-enter(r0)
            boolean r3 = r0.f12197a     // Catch:{ all -> 0x016e }
            if (r3 == 0) goto L_0x012a
            com.google.android.gms.measurement.internal.hm r1 = r0.f12199c     // Catch:{ all -> 0x016e }
            com.google.android.gms.measurement.internal.dy r1 = r1.J_()     // Catch:{ all -> 0x016e }
            com.google.android.gms.measurement.internal.ea r1 = r1.k     // Catch:{ all -> 0x016e }
            java.lang.String r2 = "Connection attempt already in progress"
            r1.a(r2)     // Catch:{ all -> 0x016e }
            monitor-exit(r0)     // Catch:{ all -> 0x016e }
            return
        L_0x012a:
            com.google.android.gms.measurement.internal.dv r3 = r0.f12198b     // Catch:{ all -> 0x016e }
            if (r3 == 0) goto L_0x014d
            com.google.android.gms.measurement.internal.dv r3 = r0.f12198b     // Catch:{ all -> 0x016e }
            boolean r3 = r3.h()     // Catch:{ all -> 0x016e }
            if (r3 != 0) goto L_0x013e
            com.google.android.gms.measurement.internal.dv r3 = r0.f12198b     // Catch:{ all -> 0x016e }
            boolean r3 = r3.g()     // Catch:{ all -> 0x016e }
            if (r3 == 0) goto L_0x014d
        L_0x013e:
            com.google.android.gms.measurement.internal.hm r1 = r0.f12199c     // Catch:{ all -> 0x016e }
            com.google.android.gms.measurement.internal.dy r1 = r1.J_()     // Catch:{ all -> 0x016e }
            com.google.android.gms.measurement.internal.ea r1 = r1.k     // Catch:{ all -> 0x016e }
            java.lang.String r2 = "Already awaiting connection attempt"
            r1.a(r2)     // Catch:{ all -> 0x016e }
            monitor-exit(r0)     // Catch:{ all -> 0x016e }
            return
        L_0x014d:
            com.google.android.gms.measurement.internal.dv r3 = new com.google.android.gms.measurement.internal.dv     // Catch:{ all -> 0x016e }
            android.os.Looper r4 = android.os.Looper.getMainLooper()     // Catch:{ all -> 0x016e }
            r3.<init>(r1, r4, r0, r0)     // Catch:{ all -> 0x016e }
            r0.f12198b = r3     // Catch:{ all -> 0x016e }
            com.google.android.gms.measurement.internal.hm r1 = r0.f12199c     // Catch:{ all -> 0x016e }
            com.google.android.gms.measurement.internal.dy r1 = r1.J_()     // Catch:{ all -> 0x016e }
            com.google.android.gms.measurement.internal.ea r1 = r1.k     // Catch:{ all -> 0x016e }
            java.lang.String r3 = "Connecting to remote service"
            r1.a(r3)     // Catch:{ all -> 0x016e }
            r0.f12197a = r2     // Catch:{ all -> 0x016e }
            com.google.android.gms.measurement.internal.dv r1 = r0.f12198b     // Catch:{ all -> 0x016e }
            r1.m()     // Catch:{ all -> 0x016e }
            monitor-exit(r0)     // Catch:{ all -> 0x016e }
            return
        L_0x016e:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x016e }
            throw r1
        L_0x0171:
            com.google.android.gms.measurement.internal.ke r0 = r6.H_()
            boolean r0 = r0.s()
            if (r0 != 0) goto L_0x0204
            android.content.Context r0 = r6.k()
            android.content.pm.PackageManager r0 = r0.getPackageManager()
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            android.content.Context r4 = r6.k()
            java.lang.String r5 = "com.google.android.gms.measurement.AppMeasurementService"
            android.content.Intent r3 = r3.setClassName(r4, r5)
            r4 = 65536(0x10000, float:9.18355E-41)
            java.util.List r0 = r0.queryIntentServices(r3, r4)
            if (r0 == 0) goto L_0x01a1
            int r0 = r0.size()
            if (r0 <= 0) goto L_0x01a1
            r1 = 1
        L_0x01a1:
            if (r1 == 0) goto L_0x01f9
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.google.android.gms.measurement.START"
            r0.<init>(r1)
            android.content.ComponentName r1 = new android.content.ComponentName
            android.content.Context r3 = r6.k()
            java.lang.String r4 = "com.google.android.gms.measurement.AppMeasurementService"
            r1.<init>(r3, r4)
            r0.setComponent(r1)
            com.google.android.gms.measurement.internal.if r1 = r6.f12119a
            com.google.android.gms.measurement.internal.hm r3 = r1.f12199c
            r3.h()
            com.google.android.gms.measurement.internal.hm r3 = r1.f12199c
            android.content.Context r3 = r3.k()
            com.google.android.gms.common.stats.a.a()
            monitor-enter(r1)
            boolean r4 = r1.f12197a     // Catch:{ all -> 0x01f6 }
            if (r4 == 0) goto L_0x01dc
            com.google.android.gms.measurement.internal.hm r0 = r1.f12199c     // Catch:{ all -> 0x01f6 }
            com.google.android.gms.measurement.internal.dy r0 = r0.J_()     // Catch:{ all -> 0x01f6 }
            com.google.android.gms.measurement.internal.ea r0 = r0.k     // Catch:{ all -> 0x01f6 }
            java.lang.String r2 = "Connection attempt already in progress"
            r0.a(r2)     // Catch:{ all -> 0x01f6 }
            monitor-exit(r1)     // Catch:{ all -> 0x01f6 }
            return
        L_0x01dc:
            com.google.android.gms.measurement.internal.hm r4 = r1.f12199c     // Catch:{ all -> 0x01f6 }
            com.google.android.gms.measurement.internal.dy r4 = r4.J_()     // Catch:{ all -> 0x01f6 }
            com.google.android.gms.measurement.internal.ea r4 = r4.k     // Catch:{ all -> 0x01f6 }
            java.lang.String r5 = "Using local app measurement service"
            r4.a(r5)     // Catch:{ all -> 0x01f6 }
            r1.f12197a = r2     // Catch:{ all -> 0x01f6 }
            com.google.android.gms.measurement.internal.hm r2 = r1.f12199c     // Catch:{ all -> 0x01f6 }
            com.google.android.gms.measurement.internal.if r2 = r2.f12119a     // Catch:{ all -> 0x01f6 }
            r4 = 129(0x81, float:1.81E-43)
            com.google.android.gms.common.stats.a.b(r3, r0, r2, r4)     // Catch:{ all -> 0x01f6 }
            monitor-exit(r1)     // Catch:{ all -> 0x01f6 }
            return
        L_0x01f6:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x01f6 }
            throw r0
        L_0x01f9:
            com.google.android.gms.measurement.internal.dy r0 = r6.J_()
            com.google.android.gms.measurement.internal.ea r0 = r0.f11828c
            java.lang.String r1 = "Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest"
            r0.a(r1)
        L_0x0204:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.hm.E():void");
    }

    /* access modifiers changed from: protected */
    public final void a(dq dqVar) {
        h();
        s.a(dqVar);
        this.f12120b = dqVar;
        D();
        G();
    }

    public final void F() {
        h();
        u();
        Cif ifVar = this.f12119a;
        if (ifVar.f12198b != null && (ifVar.f12198b.g() || ifVar.f12198b.h())) {
            ifVar.f12198b.f();
        }
        ifVar.f12198b = null;
        try {
            a.a();
            a.a(k(), this.f12119a);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f12120b = null;
    }

    private final void a(Runnable runnable) throws IllegalStateException {
        h();
        if (z()) {
            runnable.run();
        } else if (((long) this.f12124f.size()) >= 1000) {
            J_().f11828c.a("Discarding data. Max runnable queue size reached");
        } else {
            this.f12124f.add(runnable);
            this.f12125g.a(60000);
            E();
        }
    }

    /* access modifiers changed from: package-private */
    public final void G() {
        h();
        J_().k.a("Processing queued up service tasks", Integer.valueOf(this.f12124f.size()));
        for (Runnable run : this.f12124f) {
            try {
                run.run();
            } catch (Exception e2) {
                J_().f11828c.a("Task exception while flushing queue", e2);
            }
        }
        this.f12124f.clear();
        this.f12125g.c();
    }

    private final zzm a(boolean z) {
        return c().a(z ? J_().O_() : null);
    }

    public final void a(lw lwVar, zzan zzan, String str) {
        h();
        u();
        if (L_().s() != 0) {
            J_().f11831f.a("Not bundling data. Service unavailable or out of date");
            L_().a(lwVar, new byte[0]);
            return;
        }
        a((Runnable) new hx(this, zzan, str, lwVar));
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

    static /* synthetic */ void a(hm hmVar, ComponentName componentName) {
        hmVar.h();
        if (hmVar.f12120b != null) {
            hmVar.f12120b = null;
            hmVar.J_().k.a("Disconnected from device MeasurementService", componentName);
            hmVar.h();
            hmVar.E();
        }
    }

    static /* synthetic */ void a(hm hmVar) {
        hmVar.h();
        if (hmVar.z()) {
            hmVar.J_().k.a("Inactivity, disconnecting from the service");
            hmVar.F();
        }
    }
}
