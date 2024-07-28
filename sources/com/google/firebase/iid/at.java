package com.google.firebase.iid;

import android.content.Intent;
import com.google.android.gms.stats.a;
import java.util.concurrent.TimeUnit;

public final class at {

    /* renamed from: a  reason: collision with root package name */
    private static final long f38839a = TimeUnit.MINUTES.toMillis(1);

    /* renamed from: b  reason: collision with root package name */
    private static final Object f38840b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static a f38841c;

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
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
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
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:698)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public static android.content.ComponentName a(android.content.Context r16, android.content.Intent r17) {
        /*
            r0 = r17
            java.lang.Object r1 = f38840b
            monitor-enter(r1)
            com.google.android.gms.stats.a r2 = f38841c     // Catch:{ all -> 0x00d7 }
            r3 = 1
            if (r2 != 0) goto L_0x001e
            com.google.android.gms.stats.a r2 = new com.google.android.gms.stats.a     // Catch:{ all -> 0x00d7 }
            java.lang.String r4 = "wake:com.google.firebase.iid.WakeLockHolder"
            r5 = r16
            r2.<init>(r5, r4)     // Catch:{ all -> 0x00d7 }
            f38841c = r2     // Catch:{ all -> 0x00d7 }
            android.os.PowerManager$WakeLock r4 = r2.f12457b     // Catch:{ all -> 0x00d7 }
            r4.setReferenceCounted(r3)     // Catch:{ all -> 0x00d7 }
            r2.f12462g = r3     // Catch:{ all -> 0x00d7 }
            goto L_0x0020
        L_0x001e:
            r5 = r16
        L_0x0020:
            java.lang.String r2 = "com.google.firebase.iid.WakeLockHolder.wakefulintent"
            r4 = 0
            boolean r2 = r0.getBooleanExtra(r2, r4)     // Catch:{ all -> 0x00d7 }
            a((android.content.Intent) r0, (boolean) r3)     // Catch:{ all -> 0x00d7 }
            android.content.ComponentName r0 = r16.startService(r17)     // Catch:{ all -> 0x00d7 }
            if (r0 != 0) goto L_0x0033
            r0 = 0
            monitor-exit(r1)     // Catch:{ all -> 0x00d7 }
            return r0
        L_0x0033:
            if (r2 != 0) goto L_0x00d5
            com.google.android.gms.stats.a r2 = f38841c     // Catch:{ all -> 0x00d7 }
            long r14 = f38839a     // Catch:{ all -> 0x00d7 }
            java.util.concurrent.atomic.AtomicInteger r5 = r2.j     // Catch:{ all -> 0x00d7 }
            r5.incrementAndGet()     // Catch:{ all -> 0x00d7 }
            java.lang.String r9 = r2.b()     // Catch:{ all -> 0x00d7 }
            java.lang.Object r12 = r2.f12456a     // Catch:{ all -> 0x00d7 }
            monitor-enter(r12)     // Catch:{ all -> 0x00d7 }
            java.util.Map<java.lang.String, java.lang.Integer[]> r5 = r2.f12463h     // Catch:{ all -> 0x00cf }
            boolean r5 = r5.isEmpty()     // Catch:{ all -> 0x00cf }
            if (r5 == 0) goto L_0x0051
            int r5 = r2.f12464i     // Catch:{ all -> 0x00cf }
            if (r5 <= 0) goto L_0x0060
        L_0x0051:
            android.os.PowerManager$WakeLock r5 = r2.f12457b     // Catch:{ all -> 0x00cf }
            boolean r5 = r5.isHeld()     // Catch:{ all -> 0x00cf }
            if (r5 != 0) goto L_0x0060
            java.util.Map<java.lang.String, java.lang.Integer[]> r5 = r2.f12463h     // Catch:{ all -> 0x00cf }
            r5.clear()     // Catch:{ all -> 0x00cf }
            r2.f12464i = r4     // Catch:{ all -> 0x00cf }
        L_0x0060:
            boolean r5 = r2.f12462g     // Catch:{ all -> 0x00cf }
            if (r5 == 0) goto L_0x008c
            java.util.Map<java.lang.String, java.lang.Integer[]> r5 = r2.f12463h     // Catch:{ all -> 0x00cf }
            java.lang.Object r5 = r5.get(r9)     // Catch:{ all -> 0x00cf }
            java.lang.Integer[] r5 = (java.lang.Integer[]) r5     // Catch:{ all -> 0x00cf }
            if (r5 != 0) goto L_0x007d
            java.util.Map<java.lang.String, java.lang.Integer[]> r5 = r2.f12463h     // Catch:{ all -> 0x00cf }
            java.lang.Integer[] r6 = new java.lang.Integer[r3]     // Catch:{ all -> 0x00cf }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x00cf }
            r6[r4] = r7     // Catch:{ all -> 0x00cf }
            r5.put(r9, r6)     // Catch:{ all -> 0x00cf }
            r4 = 1
            goto L_0x008a
        L_0x007d:
            r6 = r5[r4]     // Catch:{ all -> 0x00cf }
            int r6 = r6.intValue()     // Catch:{ all -> 0x00cf }
            int r6 = r6 + r3
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x00cf }
            r5[r4] = r6     // Catch:{ all -> 0x00cf }
        L_0x008a:
            if (r4 != 0) goto L_0x0094
        L_0x008c:
            boolean r4 = r2.f12462g     // Catch:{ all -> 0x00cf }
            if (r4 != 0) goto L_0x00b5
            int r4 = r2.f12464i     // Catch:{ all -> 0x00cf }
            if (r4 != 0) goto L_0x00b5
        L_0x0094:
            com.google.android.gms.common.stats.d.a()     // Catch:{ all -> 0x00cf }
            android.content.Context r5 = r2.f12461f     // Catch:{ all -> 0x00cf }
            android.os.PowerManager$WakeLock r4 = r2.f12457b     // Catch:{ all -> 0x00cf }
            java.lang.String r6 = com.google.android.gms.common.stats.c.a(r4, r9)     // Catch:{ all -> 0x00cf }
            r7 = 7
            java.lang.String r8 = r2.f12460e     // Catch:{ all -> 0x00cf }
            int r10 = r2.f12459d     // Catch:{ all -> 0x00cf }
            android.os.WorkSource r4 = r2.f12458c     // Catch:{ all -> 0x00cf }
            java.util.List r11 = com.google.android.gms.common.util.r.a((android.os.WorkSource) r4)     // Catch:{ all -> 0x00cf }
            r4 = r12
            r12 = r14
            com.google.android.gms.common.stats.d.a(r5, r6, r7, r8, r9, r10, r11, r12)     // Catch:{ all -> 0x00d3 }
            int r5 = r2.f12464i     // Catch:{ all -> 0x00d3 }
            int r5 = r5 + r3
            r2.f12464i = r5     // Catch:{ all -> 0x00d3 }
            goto L_0x00b6
        L_0x00b5:
            r4 = r12
        L_0x00b6:
            monitor-exit(r4)     // Catch:{ all -> 0x00d3 }
            android.os.PowerManager$WakeLock r3 = r2.f12457b     // Catch:{ all -> 0x00d7 }
            r3.acquire()     // Catch:{ all -> 0x00d7 }
            r3 = 0
            int r5 = (r14 > r3 ? 1 : (r14 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x00d5
            java.util.concurrent.ScheduledExecutorService r3 = com.google.android.gms.stats.a.k     // Catch:{ all -> 0x00d7 }
            com.google.android.gms.stats.c r4 = new com.google.android.gms.stats.c     // Catch:{ all -> 0x00d7 }
            r4.<init>(r2)     // Catch:{ all -> 0x00d7 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00d7 }
            r3.schedule(r4, r14, r2)     // Catch:{ all -> 0x00d7 }
            goto L_0x00d5
        L_0x00cf:
            r0 = move-exception
            r4 = r12
        L_0x00d1:
            monitor-exit(r4)     // Catch:{ all -> 0x00d3 }
            throw r0     // Catch:{ all -> 0x00d7 }
        L_0x00d3:
            r0 = move-exception
            goto L_0x00d1
        L_0x00d5:
            monitor-exit(r1)     // Catch:{ all -> 0x00d7 }
            return r0
        L_0x00d7:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00d7 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.at.a(android.content.Context, android.content.Intent):android.content.ComponentName");
    }

    private static void a(Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        if (r2 == false) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0063, code lost:
        if (r12.f12464i == 1) goto L_0x0065;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0065, code lost:
        com.google.android.gms.common.stats.d.a();
        com.google.android.gms.common.stats.d.a(r12.f12461f, com.google.android.gms.common.stats.c.a(r12.f12457b, r5), 8, r12.f12460e, r5, r12.f12459d, com.google.android.gms.common.util.r.a(r12.f12458c), 0);
        r12.f12464i--;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Intent r12) {
        /*
            java.lang.Object r0 = f38840b
            monitor-enter(r0)
            com.google.android.gms.stats.a r1 = f38841c     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x008e
            java.lang.String r1 = "com.google.firebase.iid.WakeLockHolder.wakefulintent"
            r2 = 0
            boolean r1 = r12.getBooleanExtra(r1, r2)     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x008e
            a((android.content.Intent) r12, (boolean) r2)     // Catch:{ all -> 0x0090 }
            com.google.android.gms.stats.a r12 = f38841c     // Catch:{ all -> 0x0090 }
            java.util.concurrent.atomic.AtomicInteger r1 = r12.j     // Catch:{ all -> 0x0090 }
            int r1 = r1.decrementAndGet()     // Catch:{ all -> 0x0090 }
            if (r1 >= 0) goto L_0x0028
            java.lang.String r1 = r12.f12460e     // Catch:{ all -> 0x0090 }
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch:{ all -> 0x0090 }
            java.lang.String r3 = " release without a matched acquire!"
            r1.concat(r3)     // Catch:{ all -> 0x0090 }
        L_0x0028:
            java.lang.String r5 = r12.b()     // Catch:{ all -> 0x0090 }
            java.lang.Object r10 = r12.f12456a     // Catch:{ all -> 0x0090 }
            monitor-enter(r10)     // Catch:{ all -> 0x0090 }
            boolean r1 = r12.f12462g     // Catch:{ all -> 0x008b }
            r11 = 1
            if (r1 == 0) goto L_0x005d
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f12463h     // Catch:{ all -> 0x008b }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x008b }
            java.lang.Integer[] r1 = (java.lang.Integer[]) r1     // Catch:{ all -> 0x008b }
            if (r1 != 0) goto L_0x003f
            goto L_0x005b
        L_0x003f:
            r3 = r1[r2]     // Catch:{ all -> 0x008b }
            int r3 = r3.intValue()     // Catch:{ all -> 0x008b }
            if (r3 != r11) goto L_0x004e
            java.util.Map<java.lang.String, java.lang.Integer[]> r1 = r12.f12463h     // Catch:{ all -> 0x008b }
            r1.remove(r5)     // Catch:{ all -> 0x008b }
            r2 = 1
            goto L_0x005b
        L_0x004e:
            r3 = r1[r2]     // Catch:{ all -> 0x008b }
            int r3 = r3.intValue()     // Catch:{ all -> 0x008b }
            int r3 = r3 - r11
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x008b }
            r1[r2] = r3     // Catch:{ all -> 0x008b }
        L_0x005b:
            if (r2 != 0) goto L_0x0065
        L_0x005d:
            boolean r1 = r12.f12462g     // Catch:{ all -> 0x008b }
            if (r1 != 0) goto L_0x0086
            int r1 = r12.f12464i     // Catch:{ all -> 0x008b }
            if (r1 != r11) goto L_0x0086
        L_0x0065:
            com.google.android.gms.common.stats.d.a()     // Catch:{ all -> 0x008b }
            android.content.Context r1 = r12.f12461f     // Catch:{ all -> 0x008b }
            android.os.PowerManager$WakeLock r2 = r12.f12457b     // Catch:{ all -> 0x008b }
            java.lang.String r2 = com.google.android.gms.common.stats.c.a(r2, r5)     // Catch:{ all -> 0x008b }
            java.lang.String r4 = r12.f12460e     // Catch:{ all -> 0x008b }
            int r6 = r12.f12459d     // Catch:{ all -> 0x008b }
            android.os.WorkSource r3 = r12.f12458c     // Catch:{ all -> 0x008b }
            java.util.List r7 = com.google.android.gms.common.util.r.a((android.os.WorkSource) r3)     // Catch:{ all -> 0x008b }
            r3 = 8
            r8 = 0
            com.google.android.gms.common.stats.d.a(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x008b }
            int r1 = r12.f12464i     // Catch:{ all -> 0x008b }
            int r1 = r1 - r11
            r12.f12464i = r1     // Catch:{ all -> 0x008b }
        L_0x0086:
            monitor-exit(r10)     // Catch:{ all -> 0x008b }
            r12.a()     // Catch:{ all -> 0x0090 }
            goto L_0x008e
        L_0x008b:
            r12 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x008b }
            throw r12     // Catch:{ all -> 0x0090 }
        L_0x008e:
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            return
        L_0x0090:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0090 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.at.a(android.content.Intent):void");
    }
}
