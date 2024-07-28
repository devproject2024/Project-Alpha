package com.google.firebase.crashlytics.a.a;

import android.os.Bundle;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class c implements a, b {

    /* renamed from: a  reason: collision with root package name */
    private final e f38136a;

    /* renamed from: b  reason: collision with root package name */
    private final int f38137b;

    /* renamed from: c  reason: collision with root package name */
    private final TimeUnit f38138c;

    /* renamed from: d  reason: collision with root package name */
    private final Object f38139d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private CountDownLatch f38140e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f38141f = false;

    public c(e eVar, TimeUnit timeUnit) {
        this.f38136a = eVar;
        this.f38137b = 500;
        this.f38138c = timeUnit;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:9|10) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        com.google.firebase.crashlytics.a.b.a().a(3);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0041 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r7, android.os.Bundle r8) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.f38139d
            monitor-enter(r0)
            com.google.firebase.crashlytics.a.b r1 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x004d }
            r2 = 3
            r1.a(r2)     // Catch:{ all -> 0x004d }
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch     // Catch:{ all -> 0x004d }
            r3 = 1
            r1.<init>(r3)     // Catch:{ all -> 0x004d }
            r6.f38140e = r1     // Catch:{ all -> 0x004d }
            r1 = 0
            r6.f38141f = r1     // Catch:{ all -> 0x004d }
            com.google.firebase.crashlytics.a.a.e r1 = r6.f38136a     // Catch:{ all -> 0x004d }
            r1.a(r7, r8)     // Catch:{ all -> 0x004d }
            com.google.firebase.crashlytics.a.b r7 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x004d }
            r7.a(r2)     // Catch:{ all -> 0x004d }
            java.util.concurrent.CountDownLatch r7 = r6.f38140e     // Catch:{ InterruptedException -> 0x0041 }
            int r8 = r6.f38137b     // Catch:{ InterruptedException -> 0x0041 }
            long r4 = (long) r8     // Catch:{ InterruptedException -> 0x0041 }
            java.util.concurrent.TimeUnit r8 = r6.f38138c     // Catch:{ InterruptedException -> 0x0041 }
            boolean r7 = r7.await(r4, r8)     // Catch:{ InterruptedException -> 0x0041 }
            if (r7 == 0) goto L_0x0039
            r6.f38141f = r3     // Catch:{ InterruptedException -> 0x0041 }
            com.google.firebase.crashlytics.a.b r7 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ InterruptedException -> 0x0041 }
            r7.a(r2)     // Catch:{ InterruptedException -> 0x0041 }
            goto L_0x0048
        L_0x0039:
            com.google.firebase.crashlytics.a.b r7 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ InterruptedException -> 0x0041 }
            r7.a(r2)     // Catch:{ InterruptedException -> 0x0041 }
            goto L_0x0048
        L_0x0041:
            com.google.firebase.crashlytics.a.b r7 = com.google.firebase.crashlytics.a.b.a()     // Catch:{ all -> 0x004d }
            r7.a(r2)     // Catch:{ all -> 0x004d }
        L_0x0048:
            r7 = 0
            r6.f38140e = r7     // Catch:{ all -> 0x004d }
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            return
        L_0x004d:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x004d }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.a.a.c.a(java.lang.String, android.os.Bundle):void");
    }

    public final void b(String str, Bundle bundle) {
        CountDownLatch countDownLatch = this.f38140e;
        if (countDownLatch != null && "_ae".equals(str)) {
            countDownLatch.countDown();
        }
    }
}
