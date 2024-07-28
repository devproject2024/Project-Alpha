package com.google.firebase.remoteconfig.internal;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.b;
import com.google.android.gms.tasks.h;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, a> f39354a = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private static final Executor f39355e = e.a();

    /* renamed from: b  reason: collision with root package name */
    private final ExecutorService f39356b;

    /* renamed from: c  reason: collision with root package name */
    private final n f39357c;

    /* renamed from: d  reason: collision with root package name */
    private Task<f> f39358d = null;

    private a(ExecutorService executorService, n nVar) {
        this.f39356b = executorService;
        this.f39357c = nVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r0 = b();
        r1 = java.util.concurrent.TimeUnit.SECONDS;
        r2 = new com.google.firebase.remoteconfig.internal.a.C0665a((byte) 0);
        r0.a(f39355e, (com.google.android.gms.tasks.OnSuccessListener<? super com.google.firebase.remoteconfig.internal.f>) r2);
        r0.a(f39355e, (com.google.android.gms.tasks.OnFailureListener) r2);
        r0.a(f39355e, (com.google.android.gms.tasks.b) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        if (r2.f39359a.await(5, r1) == false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        if (r0.b() == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        return r0.d();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0053, code lost:
        throw new java.util.concurrent.ExecutionException(r0.e());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005b, code lost:
        throw new java.util.concurrent.TimeoutException("Task await timed out.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.firebase.remoteconfig.internal.f a() {
        /*
            r5 = this;
            monitor-enter(r5)
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.f> r0 = r5.f39358d     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.f> r0 = r5.f39358d     // Catch:{ all -> 0x005e }
            boolean r0 = r0.b()     // Catch:{ all -> 0x005e }
            if (r0 == 0) goto L_0x0017
            com.google.android.gms.tasks.Task<com.google.firebase.remoteconfig.internal.f> r0 = r5.f39358d     // Catch:{ all -> 0x005e }
            java.lang.Object r0 = r0.d()     // Catch:{ all -> 0x005e }
            com.google.firebase.remoteconfig.internal.f r0 = (com.google.firebase.remoteconfig.internal.f) r0     // Catch:{ all -> 0x005e }
            monitor-exit(r5)     // Catch:{ all -> 0x005e }
            return r0
        L_0x0017:
            monitor-exit(r5)     // Catch:{ all -> 0x005e }
            com.google.android.gms.tasks.Task r0 = r5.b()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            com.google.firebase.remoteconfig.internal.a$a r2 = new com.google.firebase.remoteconfig.internal.a$a     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            r3 = 0
            r2.<init>(r3)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            java.util.concurrent.Executor r3 = f39355e     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            r0.a((java.util.concurrent.Executor) r3, r2)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            java.util.concurrent.Executor r3 = f39355e     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            r0.a((java.util.concurrent.Executor) r3, (com.google.android.gms.tasks.OnFailureListener) r2)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            java.util.concurrent.Executor r3 = f39355e     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            r0.a((java.util.concurrent.Executor) r3, (com.google.android.gms.tasks.b) r2)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            java.util.concurrent.CountDownLatch r2 = r2.f39359a     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            r3 = 5
            boolean r1 = r2.await(r3, r1)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            if (r1 == 0) goto L_0x0054
            boolean r1 = r0.b()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            if (r1 == 0) goto L_0x004a
            java.lang.Object r0 = r0.d()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            com.google.firebase.remoteconfig.internal.f r0 = (com.google.firebase.remoteconfig.internal.f) r0     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            return r0
        L_0x004a:
            java.util.concurrent.ExecutionException r1 = new java.util.concurrent.ExecutionException     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            java.lang.Exception r0 = r0.e()     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            r1.<init>(r0)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            throw r1     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
        L_0x0054:
            java.util.concurrent.TimeoutException r0 = new java.util.concurrent.TimeoutException     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            java.lang.String r1 = "Task await timed out."
            r0.<init>(r1)     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
            throw r0     // Catch:{ InterruptedException | ExecutionException | TimeoutException -> 0x005c }
        L_0x005c:
            r0 = 0
            return r0
        L_0x005e:
            r0 = move-exception
            monitor-exit(r5)     // Catch:{ all -> 0x005e }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.remoteconfig.internal.a.a():com.google.firebase.remoteconfig.internal.f");
    }

    public final Task<f> a(f fVar, boolean z) {
        return h.a((Executor) this.f39356b, b.a(this, fVar)).a((Executor) this.f39356b, c.a(this, z, fVar));
    }

    static /* synthetic */ Task a(a aVar, boolean z, f fVar) throws Exception {
        if (z) {
            aVar.a(fVar);
        }
        return h.a(fVar);
    }

    public final synchronized Task<f> b() {
        if (this.f39358d == null || (this.f39358d.a() && !this.f39358d.b())) {
            ExecutorService executorService = this.f39356b;
            n nVar = this.f39357c;
            nVar.getClass();
            this.f39358d = h.a((Executor) executorService, d.a(nVar));
        }
        return this.f39358d;
    }

    public final void c() {
        synchronized (this) {
            this.f39358d = h.a(null);
        }
        this.f39357c.b();
    }

    public final synchronized void a(f fVar) {
        this.f39358d = h.a(fVar);
    }

    /* renamed from: com.google.firebase.remoteconfig.internal.a$a  reason: collision with other inner class name */
    static class C0665a<TResult> implements OnFailureListener, OnSuccessListener<TResult>, b {

        /* renamed from: a  reason: collision with root package name */
        final CountDownLatch f39359a;

        private C0665a() {
            this.f39359a = new CountDownLatch(1);
        }

        /* synthetic */ C0665a(byte b2) {
            this();
        }

        public final void onSuccess(TResult tresult) {
            this.f39359a.countDown();
        }

        public final void onFailure(Exception exc) {
            this.f39359a.countDown();
        }

        public final void a() {
            this.f39359a.countDown();
        }
    }

    public static synchronized a a(ExecutorService executorService, n nVar) {
        a aVar;
        synchronized (a.class) {
            String str = nVar.f39410a;
            if (!f39354a.containsKey(str)) {
                f39354a.put(str, new a(executorService, nVar));
            }
            aVar = f39354a.get(str);
        }
        return aVar;
    }
}
