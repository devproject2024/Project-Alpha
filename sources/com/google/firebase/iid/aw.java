package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.a.b;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.f;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class aw implements ServiceConnection {

    /* renamed from: a  reason: collision with root package name */
    private final Context f38844a;

    /* renamed from: b  reason: collision with root package name */
    private final Intent f38845b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f38846c;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<a> f38847d;

    /* renamed from: e  reason: collision with root package name */
    private au f38848e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f38849f;

    public aw(Context context, String str) {
        this(context, str, new ScheduledThreadPoolExecutor(0, new b("Firebase-FirebaseInstanceIdServiceConnection")));
    }

    private aw(Context context, String str, ScheduledExecutorService scheduledExecutorService) {
        this.f38847d = new ArrayDeque();
        this.f38849f = false;
        this.f38844a = context.getApplicationContext();
        this.f38845b = new Intent(str).setPackage(this.f38844a.getPackageName());
        this.f38846c = scheduledExecutorService;
    }

    static class a {

        /* renamed from: a  reason: collision with root package name */
        final Intent f38850a;

        /* renamed from: b  reason: collision with root package name */
        final f<Void> f38851b = new f<>();

        a(Intent intent) {
            this.f38850a = intent;
        }

        /* access modifiers changed from: package-private */
        public final void a() {
            this.f38851b.b(null);
        }
    }

    public final synchronized Task<Void> a(Intent intent) {
        a aVar;
        Log.isLoggable("FirebaseInstanceId", 3);
        aVar = new a(intent);
        ScheduledExecutorService scheduledExecutorService = this.f38846c;
        aVar.f38851b.f12478a.a((Executor) scheduledExecutorService, new ay(scheduledExecutorService.schedule(new ax(aVar), 9000, TimeUnit.MILLISECONDS)));
        this.f38847d.add(aVar);
        a();
        return aVar.f38851b.f12478a;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:24|25|26|(2:28|29)|30|31) */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0098, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:30:0x0092 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a() {
        /*
            r5 = this;
            monitor-enter(r5)
            java.lang.String r0 = "FirebaseInstanceId"
            r1 = 3
            android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x009b }
        L_0x0007:
            java.util.Queue<com.google.firebase.iid.aw$a> r0 = r5.f38847d     // Catch:{ all -> 0x009b }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x009b }
            if (r0 != 0) goto L_0x0099
            java.lang.String r0 = "FirebaseInstanceId"
            android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x009b }
            com.google.firebase.iid.au r0 = r5.f38848e     // Catch:{ all -> 0x009b }
            if (r0 == 0) goto L_0x005b
            com.google.firebase.iid.au r0 = r5.f38848e     // Catch:{ all -> 0x009b }
            boolean r0 = r0.isBinderAlive()     // Catch:{ all -> 0x009b }
            if (r0 == 0) goto L_0x005b
            java.lang.String r0 = "FirebaseInstanceId"
            android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x009b }
            java.util.Queue<com.google.firebase.iid.aw$a> r0 = r5.f38847d     // Catch:{ all -> 0x009b }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x009b }
            com.google.firebase.iid.aw$a r0 = (com.google.firebase.iid.aw.a) r0     // Catch:{ all -> 0x009b }
            com.google.firebase.iid.au r2 = r5.f38848e     // Catch:{ all -> 0x009b }
            int r3 = android.os.Binder.getCallingUid()     // Catch:{ all -> 0x009b }
            int r4 = android.os.Process.myUid()     // Catch:{ all -> 0x009b }
            if (r3 != r4) goto L_0x0053
            java.lang.String r3 = "FirebaseInstanceId"
            android.util.Log.isLoggable(r3, r1)     // Catch:{ all -> 0x009b }
            com.google.firebase.iid.au$a r2 = r2.f38842a     // Catch:{ all -> 0x009b }
            android.content.Intent r3 = r0.f38850a     // Catch:{ all -> 0x009b }
            com.google.android.gms.tasks.Task r2 = r2.a(r3)     // Catch:{ all -> 0x009b }
            java.util.concurrent.Executor r3 = com.google.firebase.iid.g.a()     // Catch:{ all -> 0x009b }
            com.google.firebase.iid.av r4 = new com.google.firebase.iid.av     // Catch:{ all -> 0x009b }
            r4.<init>(r0)     // Catch:{ all -> 0x009b }
            r2.a((java.util.concurrent.Executor) r3, r4)     // Catch:{ all -> 0x009b }
            goto L_0x0007
        L_0x0053:
            java.lang.SecurityException r0 = new java.lang.SecurityException     // Catch:{ all -> 0x009b }
            java.lang.String r1 = "Binding only allowed within app"
            r0.<init>(r1)     // Catch:{ all -> 0x009b }
            throw r0     // Catch:{ all -> 0x009b }
        L_0x005b:
            java.lang.String r0 = "FirebaseInstanceId"
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch:{ all -> 0x009b }
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x007b
            boolean r0 = r5.f38849f     // Catch:{ all -> 0x009b }
            if (r0 != 0) goto L_0x006b
            r0 = 1
            goto L_0x006c
        L_0x006b:
            r0 = 0
        L_0x006c:
            r3 = 39
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x009b }
            r4.<init>(r3)     // Catch:{ all -> 0x009b }
            java.lang.String r3 = "binder is dead. start connection? "
            r4.append(r3)     // Catch:{ all -> 0x009b }
            r4.append(r0)     // Catch:{ all -> 0x009b }
        L_0x007b:
            boolean r0 = r5.f38849f     // Catch:{ all -> 0x009b }
            if (r0 != 0) goto L_0x0097
            r5.f38849f = r2     // Catch:{ all -> 0x009b }
            com.google.android.gms.common.stats.a.a()     // Catch:{ SecurityException -> 0x0092 }
            android.content.Context r0 = r5.f38844a     // Catch:{ SecurityException -> 0x0092 }
            android.content.Intent r2 = r5.f38845b     // Catch:{ SecurityException -> 0x0092 }
            r3 = 65
            boolean r0 = com.google.android.gms.common.stats.a.b(r0, r2, r5, r3)     // Catch:{ SecurityException -> 0x0092 }
            if (r0 == 0) goto L_0x0092
            monitor-exit(r5)
            return
        L_0x0092:
            r5.f38849f = r1     // Catch:{ all -> 0x009b }
            r5.b()     // Catch:{ all -> 0x009b }
        L_0x0097:
            monitor-exit(r5)
            return
        L_0x0099:
            monitor-exit(r5)
            return
        L_0x009b:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.aw.a():void");
    }

    private void b() {
        while (!this.f38847d.isEmpty()) {
            this.f38847d.poll().a();
        }
    }

    public final synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
            sb.append("onServiceConnected: ");
            sb.append(valueOf);
        }
        this.f38849f = false;
        if (!(iBinder instanceof au)) {
            String valueOf2 = String.valueOf(iBinder);
            StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf2).length() + 28);
            sb2.append("Invalid service connection: ");
            sb2.append(valueOf2);
            b();
            return;
        }
        this.f38848e = (au) iBinder;
        a();
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            String valueOf = String.valueOf(componentName);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
            sb.append("onServiceDisconnected: ");
            sb.append(valueOf);
        }
        a();
    }
}
