package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.s;
import java.util.concurrent.BlockingQueue;

final class ey extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private final Object f11923a;

    /* renamed from: b  reason: collision with root package name */
    private final BlockingQueue<ez<?>> f11924b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f11925c = false;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ eu f11926d;

    public ey(eu euVar, String str, BlockingQueue<ez<?>> blockingQueue) {
        this.f11926d = euVar;
        s.a(str);
        s.a(blockingQueue);
        this.f11923a = new Object();
        this.f11924b = blockingQueue;
        setName(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0076, code lost:
        b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0079, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            if (r0 != 0) goto L_0x0013
            com.google.android.gms.measurement.internal.eu r1 = r5.f11926d     // Catch:{ InterruptedException -> 0x000e }
            java.util.concurrent.Semaphore r1 = r1.f11911h     // Catch:{ InterruptedException -> 0x000e }
            r1.acquire()     // Catch:{ InterruptedException -> 0x000e }
            r0 = 1
            goto L_0x0001
        L_0x000e:
            r1 = move-exception
            r5.a(r1)
            goto L_0x0001
        L_0x0013:
            int r0 = android.os.Process.myTid()     // Catch:{ all -> 0x0082 }
            int r0 = android.os.Process.getThreadPriority(r0)     // Catch:{ all -> 0x0082 }
        L_0x001b:
            java.util.concurrent.BlockingQueue<com.google.android.gms.measurement.internal.ez<?>> r1 = r5.f11924b     // Catch:{ all -> 0x0082 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x0082 }
            com.google.android.gms.measurement.internal.ez r1 = (com.google.android.gms.measurement.internal.ez) r1     // Catch:{ all -> 0x0082 }
            if (r1 == 0) goto L_0x0034
            boolean r2 = r1.f11927a     // Catch:{ all -> 0x0082 }
            if (r2 == 0) goto L_0x002b
            r2 = r0
            goto L_0x002d
        L_0x002b:
            r2 = 10
        L_0x002d:
            android.os.Process.setThreadPriority(r2)     // Catch:{ all -> 0x0082 }
            r1.run()     // Catch:{ all -> 0x0082 }
            goto L_0x001b
        L_0x0034:
            java.lang.Object r1 = r5.f11923a     // Catch:{ all -> 0x0082 }
            monitor-enter(r1)     // Catch:{ all -> 0x0082 }
            java.util.concurrent.BlockingQueue<com.google.android.gms.measurement.internal.ez<?>> r2 = r5.f11924b     // Catch:{ all -> 0x007f }
            java.lang.Object r2 = r2.peek()     // Catch:{ all -> 0x007f }
            if (r2 != 0) goto L_0x0053
            com.google.android.gms.measurement.internal.eu r2 = r5.f11926d     // Catch:{ all -> 0x007f }
            boolean r2 = r2.f11912i     // Catch:{ all -> 0x007f }
            if (r2 != 0) goto L_0x0053
            java.lang.Object r2 = r5.f11923a     // Catch:{ InterruptedException -> 0x004f }
            r3 = 30000(0x7530, double:1.4822E-319)
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r2 = move-exception
            r5.a(r2)     // Catch:{ all -> 0x007f }
        L_0x0053:
            monitor-exit(r1)     // Catch:{ all -> 0x007f }
            com.google.android.gms.measurement.internal.eu r1 = r5.f11926d     // Catch:{ all -> 0x0082 }
            java.lang.Object r1 = r1.f11910g     // Catch:{ all -> 0x0082 }
            monitor-enter(r1)     // Catch:{ all -> 0x0082 }
            java.util.concurrent.BlockingQueue<com.google.android.gms.measurement.internal.ez<?>> r2 = r5.f11924b     // Catch:{ all -> 0x007c }
            java.lang.Object r2 = r2.peek()     // Catch:{ all -> 0x007c }
            if (r2 != 0) goto L_0x007a
            com.google.android.gms.measurement.internal.eu r0 = r5.f11926d     // Catch:{ all -> 0x007c }
            com.google.android.gms.measurement.internal.ke r0 = r0.H_()     // Catch:{ all -> 0x007c }
            com.google.android.gms.measurement.internal.dn<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.o.aO     // Catch:{ all -> 0x007c }
            r3 = 0
            boolean r0 = r0.d(r3, r2)     // Catch:{ all -> 0x007c }
            if (r0 == 0) goto L_0x0075
            r5.b()     // Catch:{ all -> 0x007c }
        L_0x0075:
            monitor-exit(r1)     // Catch:{ all -> 0x007c }
            r5.b()
            return
        L_0x007a:
            monitor-exit(r1)     // Catch:{ all -> 0x007c }
            goto L_0x001b
        L_0x007c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x007c }
            throw r0     // Catch:{ all -> 0x0082 }
        L_0x007f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x007f }
            throw r0     // Catch:{ all -> 0x0082 }
        L_0x0082:
            r0 = move-exception
            r5.b()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.ey.run():void");
    }

    private final void b() {
        synchronized (this.f11926d.f11910g) {
            if (!this.f11925c) {
                this.f11926d.f11911h.release();
                this.f11926d.f11910g.notifyAll();
                if (this == this.f11926d.f11904a) {
                    ey unused = this.f11926d.f11904a = null;
                } else if (this == this.f11926d.f11905b) {
                    ey unused2 = this.f11926d.f11905b = null;
                } else {
                    this.f11926d.J_().f11828c.a("Current scheduler thread is neither worker nor network");
                }
                this.f11925c = true;
            }
        }
    }

    public final void a() {
        synchronized (this.f11923a) {
            this.f11923a.notifyAll();
        }
    }

    private final void a(InterruptedException interruptedException) {
        this.f11926d.J_().f11831f.a(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
    }
}
