package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.internal.s;
import com.google.android.gms.common.util.e;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public final class eu extends fw {
    /* access modifiers changed from: private */
    public static final AtomicLong j = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ey f11904a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ey f11905b;

    /* renamed from: c  reason: collision with root package name */
    private final PriorityBlockingQueue<ez<?>> f11906c = new PriorityBlockingQueue<>();

    /* renamed from: d  reason: collision with root package name */
    private final BlockingQueue<ez<?>> f11907d = new LinkedBlockingQueue();

    /* renamed from: e  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f11908e = new ew(this, "Thread death: Uncaught exception on worker thread");

    /* renamed from: f  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f11909f = new ew(this, "Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final Object f11910g = new Object();
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public final Semaphore f11911h = new Semaphore(2);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public volatile boolean f11912i;

    eu(fc fcVar) {
        super(fcVar);
    }

    /* access modifiers changed from: protected */
    public final boolean a() {
        return false;
    }

    public final void h() {
        if (Thread.currentThread() != this.f11904a) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    public final void g() {
        if (Thread.currentThread() != this.f11905b) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public final boolean c() {
        return Thread.currentThread() == this.f11904a;
    }

    public final <V> Future<V> a(Callable<V> callable) throws IllegalStateException {
        w();
        s.a(callable);
        ez ezVar = new ez(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f11904a) {
            if (!this.f11906c.isEmpty()) {
                J_().f11831f.a("Callable skipped the worker queue.");
            }
            ezVar.run();
        } else {
            a((ez<?>) ezVar);
        }
        return ezVar;
    }

    public final <V> Future<V> b(Callable<V> callable) throws IllegalStateException {
        w();
        s.a(callable);
        ez ezVar = new ez(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f11904a) {
            ezVar.run();
        } else {
            a((ez<?>) ezVar);
        }
        return ezVar;
    }

    public final void a(Runnable runnable) throws IllegalStateException {
        w();
        s.a(runnable);
        a((ez<?>) new ez(this, runnable, "Task exception on worker thread"));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(6:15|16|(1:18)(1:19)|20|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0022, code lost:
        if (r5.length() == 0) goto L_0x0029;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r4 = "Timed out waiting for ".concat(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        r4 = new java.lang.String("Timed out waiting for ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002f, code lost:
        r3.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = J_().f11831f;
        r5 = java.lang.String.valueOf(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        if (r5.length() != 0) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0045, code lost:
        r4 = "Interrupted waiting for ".concat(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        r4 = new java.lang.String("Interrupted waiting for ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0050, code lost:
        r3.a(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000c, code lost:
        r2 = r2.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (r2 != null) goto L_0x0032;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = J_().f11831f;
        r5 = java.lang.String.valueOf(r5);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> T a(java.util.concurrent.atomic.AtomicReference<T> r2, long r3, java.lang.String r5, java.lang.Runnable r6) {
        /*
            r1 = this;
            monitor-enter(r2)
            com.google.android.gms.measurement.internal.eu r0 = r1.K_()     // Catch:{ all -> 0x0056 }
            r0.a((java.lang.Runnable) r6)     // Catch:{ all -> 0x0056 }
            r2.wait(r3)     // Catch:{ InterruptedException -> 0x0033 }
            monitor-exit(r2)     // Catch:{ all -> 0x0056 }
            java.lang.Object r2 = r2.get()
            if (r2 != 0) goto L_0x0032
            com.google.android.gms.measurement.internal.dy r3 = r1.J_()
            com.google.android.gms.measurement.internal.ea r3 = r3.f11831f
            java.lang.String r4 = "Timed out waiting for "
            java.lang.String r5 = java.lang.String.valueOf(r5)
            int r6 = r5.length()
            if (r6 == 0) goto L_0x0029
            java.lang.String r4 = r4.concat(r5)
            goto L_0x002f
        L_0x0029:
            java.lang.String r5 = new java.lang.String
            r5.<init>(r4)
            r4 = r5
        L_0x002f:
            r3.a(r4)
        L_0x0032:
            return r2
        L_0x0033:
            com.google.android.gms.measurement.internal.dy r3 = r1.J_()     // Catch:{ all -> 0x0056 }
            com.google.android.gms.measurement.internal.ea r3 = r3.f11831f     // Catch:{ all -> 0x0056 }
            java.lang.String r4 = "Interrupted waiting for "
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x0056 }
            int r6 = r5.length()     // Catch:{ all -> 0x0056 }
            if (r6 == 0) goto L_0x004a
            java.lang.String r4 = r4.concat(r5)     // Catch:{ all -> 0x0056 }
            goto L_0x0050
        L_0x004a:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0056 }
            r5.<init>(r4)     // Catch:{ all -> 0x0056 }
            r4 = r5
        L_0x0050:
            r3.a(r4)     // Catch:{ all -> 0x0056 }
            r3 = 0
            monitor-exit(r2)     // Catch:{ all -> 0x0056 }
            return r3
        L_0x0056:
            r3 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0056 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.eu.a(java.util.concurrent.atomic.AtomicReference, long, java.lang.String, java.lang.Runnable):java.lang.Object");
    }

    private final void a(ez<?> ezVar) {
        synchronized (this.f11910g) {
            this.f11906c.add(ezVar);
            if (this.f11904a == null) {
                this.f11904a = new ey(this, "Measurement Worker", this.f11906c);
                this.f11904a.setUncaughtExceptionHandler(this.f11908e);
                this.f11904a.start();
            } else {
                this.f11904a.a();
            }
        }
    }

    public final void b(Runnable runnable) throws IllegalStateException {
        w();
        s.a(runnable);
        ez ezVar = new ez(this, runnable, "Task exception on network thread");
        synchronized (this.f11910g) {
            this.f11907d.add(ezVar);
            if (this.f11905b == null) {
                this.f11905b = new ey(this, "Measurement Network", this.f11907d);
                this.f11905b.setUncaughtExceptionHandler(this.f11909f);
                this.f11905b.start();
            } else {
                this.f11905b.a();
            }
        }
    }

    public final /* bridge */ /* synthetic */ void M_() {
        super.M_();
    }

    public final /* bridge */ /* synthetic */ i i() {
        return super.i();
    }

    public final /* bridge */ /* synthetic */ e j() {
        return super.j();
    }

    public final /* bridge */ /* synthetic */ Context k() {
        return super.k();
    }

    public final /* bridge */ /* synthetic */ dw l() {
        return super.l();
    }

    public final /* bridge */ /* synthetic */ jq L_() {
        return super.L_();
    }

    public final /* bridge */ /* synthetic */ eu K_() {
        return super.K_();
    }

    public final /* bridge */ /* synthetic */ dy J_() {
        return super.J_();
    }

    public final /* bridge */ /* synthetic */ eh I_() {
        return super.I_();
    }

    public final /* bridge */ /* synthetic */ ke H_() {
        return super.H_();
    }
}
