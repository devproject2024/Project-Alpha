package com.alipay.imobile.network.quake.i;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    private static long f14901a = -1;

    private e() {
    }

    public static String a() {
        return f.a(b());
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static long b() {
        /*
            long r0 = java.lang.System.currentTimeMillis()
            long r2 = f14901a
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x000d
            f14901a = r0
            return r0
        L_0x000d:
            java.lang.Class<com.alipay.imobile.network.quake.i.e> r0 = com.alipay.imobile.network.quake.i.e.class
            monitor-enter(r0)
            r1 = 5
            java.lang.Thread.sleep(r1)     // Catch:{ InterruptedException -> 0x0018 }
            goto L_0x001d
        L_0x0016:
            r1 = move-exception
            goto L_0x0025
        L_0x0018:
            java.lang.String r1 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x0016 }
            com.alipay.iap.android.common.b.c.j()     // Catch:{ all -> 0x0016 }
        L_0x001d:
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0016 }
            f14901a = r1     // Catch:{ all -> 0x0016 }
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            return r1
        L_0x0025:
            monitor-exit(r0)     // Catch:{ all -> 0x0016 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.i.e.b():long");
    }
}
