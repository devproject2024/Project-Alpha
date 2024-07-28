package com.google.android.gms.measurement.internal;

public final class dn<V> {

    /* renamed from: f  reason: collision with root package name */
    private static final Object f11796f = new Object();

    /* renamed from: a  reason: collision with root package name */
    final String f11797a;

    /* renamed from: b  reason: collision with root package name */
    private final dm<V> f11798b;

    /* renamed from: c  reason: collision with root package name */
    private final V f11799c;

    /* renamed from: d  reason: collision with root package name */
    private final V f11800d;

    /* renamed from: e  reason: collision with root package name */
    private final Object f11801e;

    /* renamed from: g  reason: collision with root package name */
    private volatile V f11802g;

    /* renamed from: h  reason: collision with root package name */
    private volatile V f11803h;

    private dn(String str, V v, V v2, dm<V> dmVar) {
        this.f11801e = new Object();
        this.f11802g = null;
        this.f11803h = null;
        this.f11797a = str;
        this.f11799c = v;
        this.f11800d = v2;
        this.f11798b = dmVar;
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:225)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x004a */
    public final V a(V r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f11801e
            monitor-enter(r0)
            V r1 = r3.f11802g     // Catch:{ all -> 0x0072 }
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            if (r4 == 0) goto L_0x0009
            return r4
        L_0x0009:
            com.google.android.gms.measurement.internal.kd r4 = com.google.android.gms.measurement.internal.Cdo.f11804a
            if (r4 != 0) goto L_0x0010
            V r4 = r3.f11799c
            return r4
        L_0x0010:
            java.lang.Object r4 = f11796f
            monitor-enter(r4)
            boolean r0 = com.google.android.gms.measurement.internal.kd.a()     // Catch:{ all -> 0x006f }
            if (r0 == 0) goto L_0x0024
            V r0 = r3.f11803h     // Catch:{ all -> 0x006f }
            if (r0 != 0) goto L_0x0020
            V r0 = r3.f11799c     // Catch:{ all -> 0x006f }
            goto L_0x0022
        L_0x0020:
            V r0 = r3.f11803h     // Catch:{ all -> 0x006f }
        L_0x0022:
            monitor-exit(r4)     // Catch:{ all -> 0x006f }
            return r0
        L_0x0024:
            monitor-exit(r4)     // Catch:{ all -> 0x006f }
            java.util.List r4 = com.google.android.gms.measurement.internal.o.aR     // Catch:{ SecurityException -> 0x005c }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ SecurityException -> 0x005c }
        L_0x002d:
            boolean r0 = r4.hasNext()     // Catch:{ SecurityException -> 0x005c }
            if (r0 == 0) goto L_0x005d
            java.lang.Object r0 = r4.next()     // Catch:{ SecurityException -> 0x005c }
            com.google.android.gms.measurement.internal.dn r0 = (com.google.android.gms.measurement.internal.dn) r0     // Catch:{ SecurityException -> 0x005c }
            boolean r1 = com.google.android.gms.measurement.internal.kd.a()     // Catch:{ SecurityException -> 0x005c }
            if (r1 != 0) goto L_0x0054
            r1 = 0
            com.google.android.gms.measurement.internal.dm<V> r2 = r0.f11798b     // Catch:{ IllegalStateException -> 0x004a }
            if (r2 == 0) goto L_0x004a
            com.google.android.gms.measurement.internal.dm<V> r2 = r0.f11798b     // Catch:{ IllegalStateException -> 0x004a }
            java.lang.Object r1 = r2.a()     // Catch:{ IllegalStateException -> 0x004a }
        L_0x004a:
            java.lang.Object r2 = f11796f     // Catch:{ SecurityException -> 0x005c }
            monitor-enter(r2)     // Catch:{ SecurityException -> 0x005c }
            r0.f11803h = r1     // Catch:{ all -> 0x0051 }
            monitor-exit(r2)     // Catch:{ all -> 0x0051 }
            goto L_0x002d
        L_0x0051:
            r4 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0051 }
            throw r4     // Catch:{ SecurityException -> 0x005c }
        L_0x0054:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ SecurityException -> 0x005c }
            java.lang.String r0 = "Refreshing flag cache must be done on a worker thread."
            r4.<init>(r0)     // Catch:{ SecurityException -> 0x005c }
            throw r4     // Catch:{ SecurityException -> 0x005c }
        L_0x005c:
        L_0x005d:
            com.google.android.gms.measurement.internal.dm<V> r4 = r3.f11798b
            if (r4 != 0) goto L_0x0064
            V r4 = r3.f11799c
            return r4
        L_0x0064:
            java.lang.Object r4 = r4.a()     // Catch:{ SecurityException -> 0x006c, IllegalStateException -> 0x0069 }
            return r4
        L_0x0069:
            V r4 = r3.f11799c
            return r4
        L_0x006c:
            V r4 = r3.f11799c
            return r4
        L_0x006f:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x006f }
            throw r0
        L_0x0072:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0072 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.dn.a(java.lang.Object):java.lang.Object");
    }

    /* synthetic */ dn(String str, Object obj, Object obj2, dm dmVar, byte b2) {
        this(str, obj, obj2, dmVar);
    }
}
