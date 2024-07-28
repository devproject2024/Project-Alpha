package com.alipay.imobile.network.quake;

import com.alipay.iap.android.common.b.c;
import com.alipay.imobile.network.quake.h.d;
import com.alipay.mobile.b.b.a;
import java.util.concurrent.BlockingQueue;

public final class l extends Thread {

    /* renamed from: a  reason: collision with root package name */
    volatile boolean f14920a = false;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<e> f14921b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final BlockingQueue<j> f14922c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final o f14923d;

    /* renamed from: e  reason: collision with root package name */
    private m f14924e;

    /* renamed from: f  reason: collision with root package name */
    private d f14925f;

    public l(BlockingQueue<e> blockingQueue, BlockingQueue<j> blockingQueue2, o oVar, m mVar) {
        this.f14922c = blockingQueue2;
        this.f14921b = blockingQueue;
        this.f14923d = oVar;
        this.f14924e = mVar;
        this.f14925f = new d() {
            public final void a(e eVar, a aVar) {
                l.this.a(eVar, aVar);
            }

            public final void a(e eVar, b bVar) {
                try {
                    if (eVar.j) {
                        eVar.b("network-discard-cancelled");
                        return;
                    }
                    eVar.a("network-http-complete");
                    eVar.a("network-http-consume-time is:" + bVar.networkTimeMs);
                    j jVar = new j();
                    jVar.f14911a = eVar;
                    jVar.f14912b = bVar;
                    l.this.f14922c.add(jVar);
                } catch (Exception e2) {
                    String str = c.f14737a;
                    c.a("Unhandled exception %s", e2.toString());
                    c.j();
                    l.this.f14923d.a(eVar, (a) new com.alipay.imobile.network.quake.c.a((Integer) 0, (Throwable) e2));
                }
            }
        };
    }

    /* access modifiers changed from: private */
    public void a(e eVar, a aVar) {
        this.f14923d.a(eVar, e.a(aVar));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        r2 = (r2 = android.net.Uri.parse(r2)).getHost();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            r0 = 10
            android.os.Process.setThreadPriority(r0)
        L_0x0005:
            java.util.concurrent.BlockingQueue<com.alipay.imobile.network.quake.e> r0 = r5.f14921b     // Catch:{ InterruptedException -> 0x0076 }
            java.lang.Object r0 = r0.take()     // Catch:{ InterruptedException -> 0x0076 }
            com.alipay.imobile.network.quake.e r0 = (com.alipay.imobile.network.quake.e) r0     // Catch:{ InterruptedException -> 0x0076 }
            r1 = 0
            java.lang.String r2 = "network-queue-take"
            r0.a((java.lang.String) r2)     // Catch:{ a -> 0x0071, all -> 0x004e }
            boolean r2 = r0.j     // Catch:{ a -> 0x0071, all -> 0x004e }
            if (r2 == 0) goto L_0x001d
            java.lang.String r2 = "network-discard-cancelled"
            r0.b((java.lang.String) r2)     // Catch:{ a -> 0x0071, all -> 0x004e }
            goto L_0x0005
        L_0x001d:
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ a -> 0x0071, all -> 0x004e }
            r3 = 14
            if (r2 < r3) goto L_0x0040
            java.lang.String r2 = r0.f14769a     // Catch:{ a -> 0x0071, all -> 0x004e }
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ a -> 0x0071, all -> 0x004e }
            if (r3 != 0) goto L_0x003c
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ a -> 0x0071, all -> 0x004e }
            if (r2 == 0) goto L_0x003c
            java.lang.String r2 = r2.getHost()     // Catch:{ a -> 0x0071, all -> 0x004e }
            if (r2 == 0) goto L_0x003c
            int r2 = r2.hashCode()     // Catch:{ a -> 0x0071, all -> 0x004e }
            goto L_0x003d
        L_0x003c:
            r2 = 0
        L_0x003d:
            android.net.TrafficStats.setThreadStatsTag(r2)     // Catch:{ a -> 0x0071, all -> 0x004e }
        L_0x0040:
            com.alipay.imobile.network.quake.m r2 = r5.f14924e     // Catch:{ a -> 0x0071, all -> 0x004e }
            java.lang.String r3 = r0.s     // Catch:{ a -> 0x0071, all -> 0x004e }
            com.alipay.imobile.network.quake.h.c r2 = r2.c(r3)     // Catch:{ a -> 0x0071, all -> 0x004e }
            com.alipay.imobile.network.quake.h.d r3 = r5.f14925f     // Catch:{ a -> 0x0071, all -> 0x004e }
            r2.a(r0, r3)     // Catch:{ a -> 0x0071, all -> 0x004e }
            goto L_0x0005
        L_0x004e:
            r2 = move-exception
            java.lang.String r3 = com.alipay.imobile.network.quake.c.f14737a
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = r2.toString()
            r3[r1] = r4
            java.lang.String r4 = "Unhandled throwable %s"
            com.alipay.iap.android.common.b.c.a(r4, r3)
            com.alipay.iap.android.common.b.c.j()
            com.alipay.imobile.network.quake.c.a r3 = new com.alipay.imobile.network.quake.c.a
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.<init>((java.lang.Integer) r1, (java.lang.Throwable) r2)
            com.alipay.imobile.network.quake.o r1 = r5.f14923d
            r1.a((com.alipay.imobile.network.quake.e) r0, (com.alipay.mobile.b.b.a) r3)
            goto L_0x0005
        L_0x0071:
            r1 = move-exception
            r5.a(r0, r1)
            goto L_0x0005
        L_0x0076:
            boolean r0 = r5.f14920a
            if (r0 == 0) goto L_0x0005
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.l.run():void");
    }
}
