package com.alipay.imobile.network.quake;

import com.alipay.imobile.network.quake.e;
import com.alipay.mobile.b.b.a;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class f implements e.b, e.c, Future {

    /* renamed from: a  reason: collision with root package name */
    private e f14783a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f14784b = false;

    /* renamed from: c  reason: collision with root package name */
    private Object f14785c;

    /* renamed from: d  reason: collision with root package name */
    private a f14786d;

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized java.lang.Object a(java.lang.Long r6) throws java.lang.InterruptedException, java.util.concurrent.ExecutionException, java.util.concurrent.TimeoutException {
        /*
            r5 = this;
            monitor-enter(r5)
            com.alipay.mobile.b.b.a r0 = r5.f14786d     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x003c
            boolean r0 = r5.f14784b     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x000d
            java.lang.Object r6 = r5.f14785c     // Catch:{ all -> 0x0044 }
            monitor-exit(r5)
            return r6
        L_0x000d:
            r0 = 0
            if (r6 != 0) goto L_0x0015
        L_0x0011:
            r5.wait(r0)     // Catch:{ all -> 0x0044 }
            goto L_0x0022
        L_0x0015:
            long r2 = r6.longValue()     // Catch:{ all -> 0x0044 }
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x0022
            long r0 = r6.longValue()     // Catch:{ all -> 0x0044 }
            goto L_0x0011
        L_0x0022:
            com.alipay.mobile.b.b.a r6 = r5.f14786d     // Catch:{ all -> 0x0044 }
            if (r6 != 0) goto L_0x0034
            boolean r6 = r5.f14784b     // Catch:{ all -> 0x0044 }
            if (r6 == 0) goto L_0x002e
            java.lang.Object r6 = r5.f14785c     // Catch:{ all -> 0x0044 }
            monitor-exit(r5)
            return r6
        L_0x002e:
            java.util.concurrent.TimeoutException r6 = new java.util.concurrent.TimeoutException     // Catch:{ all -> 0x0044 }
            r6.<init>()     // Catch:{ all -> 0x0044 }
            throw r6     // Catch:{ all -> 0x0044 }
        L_0x0034:
            java.util.concurrent.ExecutionException r6 = new java.util.concurrent.ExecutionException     // Catch:{ all -> 0x0044 }
            com.alipay.mobile.b.b.a r0 = r5.f14786d     // Catch:{ all -> 0x0044 }
            r6.<init>(r0)     // Catch:{ all -> 0x0044 }
            throw r6     // Catch:{ all -> 0x0044 }
        L_0x003c:
            java.util.concurrent.ExecutionException r6 = new java.util.concurrent.ExecutionException     // Catch:{ all -> 0x0044 }
            com.alipay.mobile.b.b.a r0 = r5.f14786d     // Catch:{ all -> 0x0044 }
            r6.<init>(r0)     // Catch:{ all -> 0x0044 }
            throw r6     // Catch:{ all -> 0x0044 }
        L_0x0044:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.imobile.network.quake.f.a(java.lang.Long):java.lang.Object");
    }

    public final synchronized void a(a aVar) {
        this.f14786d = aVar;
        notifyAll();
    }

    public final synchronized void a(Object obj) {
        this.f14784b = true;
        this.f14785c = obj;
        notifyAll();
    }

    public final Object get() throws InterruptedException, ExecutionException {
        try {
            return a((Long) null);
        } catch (TimeoutException e2) {
            throw new AssertionError(e2);
        }
    }

    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return a(Long.valueOf(TimeUnit.MILLISECONDS.convert(j, timeUnit)));
    }

    public final synchronized boolean isDone() {
        return this.f14784b || this.f14786d != null || isCancelled();
    }

    public final synchronized boolean cancel(boolean z) {
        if (this.f14783a == null) {
            return false;
        }
        if (isDone()) {
            return false;
        }
        this.f14783a.j = true;
        return true;
    }

    public final boolean isCancelled() {
        e eVar = this.f14783a;
        return eVar != null && eVar.j;
    }
}
