package d.a.a;

final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final i f45939a = new i();

    /* renamed from: b  reason: collision with root package name */
    private final c f45940b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f45941c;

    b(c cVar) {
        this.f45940b = cVar;
    }

    public final void a(m mVar, Object obj) {
        h a2 = h.a(mVar, obj);
        synchronized (this) {
            this.f45939a.a(a2);
            if (!this.f45941c) {
                this.f45941c = true;
                this.f45940b.f45946c.execute(this);
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
            d.a.a.i r1 = r3.f45939a     // Catch:{ InterruptedException -> 0x0025 }
            d.a.a.h r1 = r1.b()     // Catch:{ InterruptedException -> 0x0025 }
            if (r1 != 0) goto L_0x001d
            monitor-enter(r3)     // Catch:{ InterruptedException -> 0x0025 }
            d.a.a.i r1 = r3.f45939a     // Catch:{ all -> 0x001a }
            d.a.a.h r1 = r1.a()     // Catch:{ all -> 0x001a }
            if (r1 != 0) goto L_0x0018
            r3.f45941c = r0     // Catch:{ all -> 0x001a }
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            r3.f45941c = r0
            return
        L_0x0018:
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r1 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x001a }
            throw r1     // Catch:{ InterruptedException -> 0x0025 }
        L_0x001d:
            d.a.a.c r2 = r3.f45940b     // Catch:{ InterruptedException -> 0x0025 }
            r2.a((d.a.a.h) r1)     // Catch:{ InterruptedException -> 0x0025 }
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
            r3.f45941c = r0
            return
        L_0x003d:
            r3.f45941c = r0
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.b.run():void");
    }
}
