package org.greenrobot.eventbus;

final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final i f72823a = new i();

    /* renamed from: b  reason: collision with root package name */
    private final c f72824b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f72825c;

    b(c cVar) {
        this.f72824b = cVar;
    }

    public final void a(n nVar, Object obj) {
        h a2 = h.a(nVar, obj);
        synchronized (this) {
            this.f72823a.a(a2);
            if (!this.f72825c) {
                this.f72825c = true;
                this.f72824b.f72852c.execute(this);
            }
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0025 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r3 = this;
        L_0x0000:
            r0 = 0
            org.greenrobot.eventbus.i r1 = r3.f72823a     // Catch:{ InterruptedException -> 0x0025 }
            org.greenrobot.eventbus.h r1 = r1.b()     // Catch:{ InterruptedException -> 0x0025 }
            if (r1 != 0) goto L_0x001d
            monitor-enter(r3)     // Catch:{ InterruptedException -> 0x0025 }
            org.greenrobot.eventbus.i r1 = r3.f72823a     // Catch:{ all -> 0x001a }
            org.greenrobot.eventbus.h r1 = r1.a()     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0018
            r3.f72825c = r0     // Catch:{ all -> 0x001a }
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            r3.f72825c = r0
            return
        L_0x0018:
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            throw r1     // Catch:{ InterruptedException -> 0x0025 }
        L_0x001d:
            org.greenrobot.eventbus.c r2 = r3.f72824b     // Catch:{ InterruptedException -> 0x0025 }
            r2.a((org.greenrobot.eventbus.h) r1)     // Catch:{ InterruptedException -> 0x0025 }
            goto L_0x0000
        L_0x0023:
            r1 = move-exception
            goto L_0x003d
        L_0x0025:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
            r1.<init>()     // Catch:{ all -> 0x0023 }
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0023 }
            r1.append(r2)     // Catch:{ all -> 0x0023 }
            java.lang.String r2 = " was interruppted"
            r1.append(r2)     // Catch:{ all -> 0x0023 }
            r3.f72825c = r0
            return
        L_0x003d:
            r3.f72825c = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.greenrobot.eventbus.b.run():void");
    }
}
