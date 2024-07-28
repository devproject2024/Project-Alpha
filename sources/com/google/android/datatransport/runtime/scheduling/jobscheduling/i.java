package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.l;

final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final h f7924a;

    /* renamed from: b  reason: collision with root package name */
    private final l f7925b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7926c;

    /* renamed from: d  reason: collision with root package name */
    private final Runnable f7927d;

    private i(h hVar, l lVar, int i2, Runnable runnable) {
        this.f7924a = hVar;
        this.f7925b = lVar;
        this.f7926c = i2;
        this.f7927d = runnable;
    }

    public static Runnable a(h hVar, l lVar, int i2, Runnable runnable) {
        return new i(hVar, lVar, i2, runnable);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b9, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r6.f7920d.a(r7, r8 + 1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00c4, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00c5, code lost:
        r9.run();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c8, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00bb */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r13 = this;
            com.google.android.datatransport.runtime.scheduling.jobscheduling.h r6 = r13.f7924a
            com.google.android.datatransport.runtime.l r7 = r13.f7925b
            int r8 = r13.f7926c
            java.lang.Runnable r9 = r13.f7927d
            r10 = 1
            com.google.android.datatransport.runtime.c.b r0 = r6.f7921e     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.scheduling.a.c r1 = r6.f7919c     // Catch:{ a -> 0x00bb }
            r1.getClass()     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.l r2 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.l     // Catch:{ a -> 0x00bb }
            r2.<init>(r1)     // Catch:{ a -> 0x00bb }
            r0.a(r2)     // Catch:{ a -> 0x00bb }
            android.content.Context r0 = r6.f7917a     // Catch:{ a -> 0x00bb }
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ a -> 0x00bb }
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0     // Catch:{ a -> 0x00bb }
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()     // Catch:{ a -> 0x00bb }
            if (r0 == 0) goto L_0x0030
            boolean r0 = r0.isConnected()     // Catch:{ a -> 0x00bb }
            if (r0 == 0) goto L_0x0030
            r0 = 1
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            if (r0 != 0) goto L_0x003f
            com.google.android.datatransport.runtime.c.b r0 = r6.f7921e     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.m r1 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.m     // Catch:{ a -> 0x00bb }
            r1.<init>(r6, r7, r8)     // Catch:{ a -> 0x00bb }
            r0.a(r1)     // Catch:{ a -> 0x00bb }
            goto L_0x00b5
        L_0x003f:
            com.google.android.datatransport.runtime.backends.e r0 = r6.f7918b     // Catch:{ a -> 0x00bb }
            java.lang.String r1 = r7.a()     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.backends.m r0 = r0.a(r1)     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.c.b r1 = r6.f7921e     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.j r2 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.j     // Catch:{ a -> 0x00bb }
            r2.<init>(r6, r7)     // Catch:{ a -> 0x00bb }
            java.lang.Object r1 = r1.a(r2)     // Catch:{ a -> 0x00bb }
            r3 = r1
            java.lang.Iterable r3 = (java.lang.Iterable) r3     // Catch:{ a -> 0x00bb }
            java.util.Iterator r1 = r3.iterator()     // Catch:{ a -> 0x00bb }
            boolean r1 = r1.hasNext()     // Catch:{ a -> 0x00bb }
            if (r1 == 0) goto L_0x00b5
            if (r0 != 0) goto L_0x0070
            java.lang.String r0 = "Uploader"
            java.lang.String r1 = "Unknown backend for %s, deleting event batch for it..."
            com.google.android.datatransport.runtime.a.a.a((java.lang.String) r0, (java.lang.String) r1, (java.lang.Object) r7)     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.backends.g r0 = com.google.android.datatransport.runtime.backends.g.d()     // Catch:{ a -> 0x00bb }
        L_0x006e:
            r2 = r0
            goto L_0x00a7
        L_0x0070:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ a -> 0x00bb }
            r1.<init>()     // Catch:{ a -> 0x00bb }
            java.util.Iterator r2 = r3.iterator()     // Catch:{ a -> 0x00bb }
        L_0x0079:
            boolean r4 = r2.hasNext()     // Catch:{ a -> 0x00bb }
            if (r4 == 0) goto L_0x008d
            java.lang.Object r4 = r2.next()     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.scheduling.a.h r4 = (com.google.android.datatransport.runtime.scheduling.a.h) r4     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.h r4 = r4.c()     // Catch:{ a -> 0x00bb }
            r1.add(r4)     // Catch:{ a -> 0x00bb }
            goto L_0x0079
        L_0x008d:
            com.google.android.datatransport.runtime.backends.a$a r2 = new com.google.android.datatransport.runtime.backends.a$a     // Catch:{ a -> 0x00bb }
            r2.<init>()     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.backends.f$a r1 = r2.a((java.lang.Iterable<com.google.android.datatransport.runtime.h>) r1)     // Catch:{ a -> 0x00bb }
            byte[] r2 = r7.b()     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.backends.f$a r1 = r1.a((byte[]) r2)     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.backends.f r1 = r1.a()     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.backends.g r0 = r0.a((com.google.android.datatransport.runtime.backends.f) r1)     // Catch:{ a -> 0x00bb }
            goto L_0x006e
        L_0x00a7:
            com.google.android.datatransport.runtime.c.b r11 = r6.f7921e     // Catch:{ a -> 0x00bb }
            com.google.android.datatransport.runtime.scheduling.jobscheduling.k r12 = new com.google.android.datatransport.runtime.scheduling.jobscheduling.k     // Catch:{ a -> 0x00bb }
            r0 = r12
            r1 = r6
            r4 = r7
            r5 = r8
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ a -> 0x00bb }
            r11.a(r12)     // Catch:{ a -> 0x00bb }
        L_0x00b5:
            r9.run()
            return
        L_0x00b9:
            r0 = move-exception
            goto L_0x00c5
        L_0x00bb:
            com.google.android.datatransport.runtime.scheduling.jobscheduling.s r0 = r6.f7920d     // Catch:{ all -> 0x00b9 }
            int r8 = r8 + r10
            r0.a(r7, r8)     // Catch:{ all -> 0x00b9 }
            r9.run()
            return
        L_0x00c5:
            r9.run()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.datatransport.runtime.scheduling.jobscheduling.i.run():void");
    }
}
