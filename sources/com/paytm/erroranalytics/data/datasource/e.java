package com.paytm.erroranalytics.data.datasource;

import com.paytm.erroranalytics.data.datasource.dao.a;
import java.util.List;

public final class e implements d {

    /* renamed from: a  reason: collision with root package name */
    private a f42804a;

    public e(a aVar) {
        this.f42804a = aVar;
    }

    public final void a(com.paytm.erroranalytics.c.b.a aVar) {
        this.f42804a.a(aVar);
        String str = com.paytm.erroranalytics.e.f42808a;
    }

    public final List<com.paytm.erroranalytics.c.b.a> a() {
        return this.f42804a.a();
    }

    public final void a(List<Long> list) {
        this.f42804a.a(list);
        String str = com.paytm.erroranalytics.e.f42808a;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0 = com.paytm.erroranalytics.e.f42808a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003e, code lost:
        return;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x003b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.paytm.erroranalytics.data.datasource.dao.a r0 = r2.f42804a     // Catch:{ Exception -> 0x003b }
            int r0 = r0.b()     // Catch:{ Exception -> 0x003b }
            int r1 = 1200 - r0
            if (r1 <= 0) goto L_0x000d
            monitor-exit(r2)
            return
        L_0x000d:
            int r0 = r0 + -1200
            r1 = 100
            if (r0 <= r1) goto L_0x001a
            com.paytm.erroranalytics.data.datasource.dao.a r1 = r2.f42804a     // Catch:{ Exception -> 0x003b }
            java.util.List r0 = r1.a((int) r0)     // Catch:{ Exception -> 0x003b }
            goto L_0x0020
        L_0x001a:
            com.paytm.erroranalytics.data.datasource.dao.a r0 = r2.f42804a     // Catch:{ Exception -> 0x003b }
            java.util.List r0 = r0.a((int) r1)     // Catch:{ Exception -> 0x003b }
        L_0x0020:
            com.paytm.erroranalytics.data.datasource.dao.a r1 = r2.f42804a     // Catch:{ Exception -> 0x003b }
            r1.a((java.util.List<java.lang.Long>) r0)     // Catch:{ Exception -> 0x003b }
            java.lang.String r0 = com.paytm.erroranalytics.e.f42808a     // Catch:{ Exception -> 0x003b }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x003b }
            java.lang.String r1 = "Event database health check total events "
            r0.<init>(r1)     // Catch:{ Exception -> 0x003b }
            com.paytm.erroranalytics.data.datasource.dao.a r1 = r2.f42804a     // Catch:{ Exception -> 0x003b }
            int r1 = r1.b()     // Catch:{ Exception -> 0x003b }
            r0.append(r1)     // Catch:{ Exception -> 0x003b }
            monitor-exit(r2)
            return
        L_0x0039:
            r0 = move-exception
            goto L_0x003f
        L_0x003b:
            java.lang.String r0 = com.paytm.erroranalytics.e.f42808a     // Catch:{ all -> 0x0039 }
            monitor-exit(r2)
            return
        L_0x003f:
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.erroranalytics.data.datasource.e.b():void");
    }
}
