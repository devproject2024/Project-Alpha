package com.alipay.imobile.network.quake.i;

import android.os.SystemClock;
import com.alipay.imobile.network.quake.c;
import java.util.ArrayList;
import java.util.List;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    private final List<a> f14906a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private boolean f14907b = false;

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f14908a;

        /* renamed from: b  reason: collision with root package name */
        public final long f14909b;

        /* renamed from: c  reason: collision with root package name */
        public final long f14910c;

        public a(String str, long j, long j2) {
            this.f14908a = str;
            this.f14909b = j;
            this.f14910c = j2;
        }
    }

    public final synchronized void a(String str, long j) {
        if (!this.f14907b) {
            this.f14906a.add(new a(str, j, SystemClock.elapsedRealtime()));
        } else {
            throw new IllegalStateException("Marker added to finished log");
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        if (!this.f14907b) {
            a("Request on the loose");
            String str = c.f14737a;
            com.alipay.iap.android.common.b.c.c();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a3, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void a(java.lang.String r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            r0 = 1
            r11.f14907b = r0     // Catch:{ all -> 0x00a4 }
            java.util.List<com.alipay.imobile.network.quake.i.h$a> r1 = r11.f14906a     // Catch:{ all -> 0x00a4 }
            boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x00a4 }
            r2 = 0
            r4 = 0
            if (r1 == 0) goto L_0x0011
            r5 = r2
            goto L_0x002e
        L_0x0011:
            java.util.List<com.alipay.imobile.network.quake.i.h$a> r1 = r11.f14906a     // Catch:{ all -> 0x00a4 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x00a4 }
            com.alipay.imobile.network.quake.i.h$a r1 = (com.alipay.imobile.network.quake.i.h.a) r1     // Catch:{ all -> 0x00a4 }
            long r5 = r1.f14910c     // Catch:{ all -> 0x00a4 }
            java.util.List<com.alipay.imobile.network.quake.i.h$a> r1 = r11.f14906a     // Catch:{ all -> 0x00a4 }
            java.util.List<com.alipay.imobile.network.quake.i.h$a> r7 = r11.f14906a     // Catch:{ all -> 0x00a4 }
            int r7 = r7.size()     // Catch:{ all -> 0x00a4 }
            int r7 = r7 - r0
            java.lang.Object r1 = r1.get(r7)     // Catch:{ all -> 0x00a4 }
            com.alipay.imobile.network.quake.i.h$a r1 = (com.alipay.imobile.network.quake.i.h.a) r1     // Catch:{ all -> 0x00a4 }
            long r7 = r1.f14910c     // Catch:{ all -> 0x00a4 }
            long r5 = r7 - r5
        L_0x002e:
            int r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0034
            monitor-exit(r11)
            return
        L_0x0034:
            java.util.List<com.alipay.imobile.network.quake.i.h$a> r1 = r11.f14906a     // Catch:{ all -> 0x00a4 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x00a4 }
            com.alipay.imobile.network.quake.i.h$a r1 = (com.alipay.imobile.network.quake.i.h.a) r1     // Catch:{ all -> 0x00a4 }
            long r1 = r1.f14910c     // Catch:{ all -> 0x00a4 }
            java.lang.StringBuffer r3 = new java.lang.StringBuffer     // Catch:{ all -> 0x00a4 }
            r3.<init>()     // Catch:{ all -> 0x00a4 }
            java.lang.String r7 = "(%-4d ms) %s"
            r8 = 2
            java.lang.Object[] r9 = new java.lang.Object[r8]     // Catch:{ all -> 0x00a4 }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ all -> 0x00a4 }
            r9[r4] = r5     // Catch:{ all -> 0x00a4 }
            r9[r0] = r12     // Catch:{ all -> 0x00a4 }
            java.lang.String r12 = com.alipay.iap.android.common.b.c.a(r7, r9)     // Catch:{ all -> 0x00a4 }
            r3.append(r12)     // Catch:{ all -> 0x00a4 }
            java.lang.String r12 = "\n"
            r3.append(r12)     // Catch:{ all -> 0x00a4 }
            java.util.List<com.alipay.imobile.network.quake.i.h$a> r12 = r11.f14906a     // Catch:{ all -> 0x00a4 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x00a4 }
        L_0x0062:
            boolean r5 = r12.hasNext()     // Catch:{ all -> 0x00a4 }
            if (r5 == 0) goto L_0x0097
            java.lang.Object r5 = r12.next()     // Catch:{ all -> 0x00a4 }
            com.alipay.imobile.network.quake.i.h$a r5 = (com.alipay.imobile.network.quake.i.h.a) r5     // Catch:{ all -> 0x00a4 }
            long r6 = r5.f14910c     // Catch:{ all -> 0x00a4 }
            java.lang.String r9 = "(+%-4d) [%2d] %s"
            r10 = 3
            java.lang.Object[] r10 = new java.lang.Object[r10]     // Catch:{ all -> 0x00a4 }
            long r1 = r6 - r1
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00a4 }
            r10[r4] = r1     // Catch:{ all -> 0x00a4 }
            long r1 = r5.f14909b     // Catch:{ all -> 0x00a4 }
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x00a4 }
            r10[r0] = r1     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = r5.f14908a     // Catch:{ all -> 0x00a4 }
            r10[r8] = r1     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = com.alipay.iap.android.common.b.c.a(r9, r10)     // Catch:{ all -> 0x00a4 }
            r3.append(r1)     // Catch:{ all -> 0x00a4 }
            java.lang.String r1 = "\n"
            r3.append(r1)     // Catch:{ all -> 0x00a4 }
            r1 = r6
            goto L_0x0062
        L_0x0097:
            int r12 = r3.length()     // Catch:{ all -> 0x00a4 }
            if (r12 <= 0) goto L_0x00a2
            java.lang.String r12 = com.alipay.imobile.network.quake.c.f14737a     // Catch:{ all -> 0x00a4 }
            com.alipay.iap.android.common.b.c.c()     // Catch:{ all -> 0x00a4 }
        L_0x00a2:
            monitor-exit(r11)
            return
        L_0x00a4:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.i.h.a(java.lang.String):void");
    }
}
