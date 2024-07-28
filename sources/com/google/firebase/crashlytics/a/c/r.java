package com.google.firebase.crashlytics.a.c;

import android.content.SharedPreferences;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.f;
import com.google.firebase.c;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    f<Void> f38305a = new f<>();

    /* renamed from: b  reason: collision with root package name */
    boolean f38306b;

    /* renamed from: c  reason: collision with root package name */
    f<Void> f38307c;

    /* renamed from: d  reason: collision with root package name */
    private Object f38308d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final SharedPreferences f38309e;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f38310f;

    /* renamed from: g  reason: collision with root package name */
    private volatile boolean f38311g;

    /* renamed from: h  reason: collision with root package name */
    private final c f38312h;

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public r(com.google.firebase.c r5) {
        /*
            r4 = this;
            r4.<init>()
            java.lang.Object r0 = new java.lang.Object
            r0.<init>()
            r4.f38308d = r0
            com.google.android.gms.tasks.f r0 = new com.google.android.gms.tasks.f
            r0.<init>()
            r4.f38305a = r0
            r0 = 0
            r4.f38306b = r0
            com.google.android.gms.tasks.f r1 = new com.google.android.gms.tasks.f
            r1.<init>()
            r4.f38307c = r1
            r4.f38312h = r5
            android.content.Context r5 = r5.a()
            if (r5 == 0) goto L_0x008a
            android.content.SharedPreferences r1 = com.google.firebase.crashlytics.a.c.g.a((android.content.Context) r5)
            r4.f38309e = r1
            android.content.SharedPreferences r1 = r4.f38309e
            java.lang.String r2 = "firebase_crashlytics_collection_enabled"
            boolean r1 = r1.contains(r2)
            r2 = 1
            if (r1 == 0) goto L_0x003e
            android.content.SharedPreferences r5 = r4.f38309e
            java.lang.String r0 = "firebase_crashlytics_collection_enabled"
            boolean r5 = r5.getBoolean(r0, r2)
        L_0x003c:
            r0 = 1
            goto L_0x0070
        L_0x003e:
            android.content.pm.PackageManager r1 = r5.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0067 }
            if (r1 == 0) goto L_0x006f
            java.lang.String r5 = r5.getPackageName()     // Catch:{ NameNotFoundException -> 0x0067 }
            r3 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r5 = r1.getApplicationInfo(r5, r3)     // Catch:{ NameNotFoundException -> 0x0067 }
            if (r5 == 0) goto L_0x006f
            android.os.Bundle r1 = r5.metaData     // Catch:{ NameNotFoundException -> 0x0067 }
            if (r1 == 0) goto L_0x006f
            android.os.Bundle r1 = r5.metaData     // Catch:{ NameNotFoundException -> 0x0067 }
            java.lang.String r3 = "firebase_crashlytics_collection_enabled"
            boolean r1 = r1.containsKey(r3)     // Catch:{ NameNotFoundException -> 0x0067 }
            if (r1 == 0) goto L_0x006f
            android.os.Bundle r5 = r5.metaData     // Catch:{ NameNotFoundException -> 0x0067 }
            java.lang.String r1 = "firebase_crashlytics_collection_enabled"
            boolean r5 = r5.getBoolean(r1)     // Catch:{ NameNotFoundException -> 0x0067 }
            goto L_0x003c
        L_0x0067:
            com.google.firebase.crashlytics.a.b r5 = com.google.firebase.crashlytics.a.b.a()
            r1 = 3
            r5.a(r1)
        L_0x006f:
            r5 = 1
        L_0x0070:
            r4.f38311g = r5
            r4.f38310f = r0
            java.lang.Object r5 = r4.f38308d
            monitor-enter(r5)
            boolean r0 = r4.a()     // Catch:{ all -> 0x0087 }
            if (r0 == 0) goto L_0x0085
            com.google.android.gms.tasks.f<java.lang.Void> r0 = r4.f38305a     // Catch:{ all -> 0x0087 }
            r1 = 0
            r0.b(r1)     // Catch:{ all -> 0x0087 }
            r4.f38306b = r2     // Catch:{ all -> 0x0087 }
        L_0x0085:
            monitor-exit(r5)     // Catch:{ all -> 0x0087 }
            return
        L_0x0087:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x0087 }
            throw r0
        L_0x008a:
            java.lang.RuntimeException r5 = new java.lang.RuntimeException
            java.lang.String r0 = "null context"
            r5.<init>(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.c.r.<init>(com.google.firebase.c):void");
    }

    public final boolean a() {
        if (this.f38310f) {
            return this.f38311g;
        }
        return this.f38312h.f();
    }

    public final Task<Void> b() {
        Task<Void> a2;
        synchronized (this.f38308d) {
            a2 = this.f38305a.a();
        }
        return a2;
    }

    public final Task<Void> c() {
        return af.a(this.f38307c.a(), b());
    }
}
