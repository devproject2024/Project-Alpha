package com.google.firebase.messaging;

import android.content.Context;
import java.util.concurrent.Executor;

final class c {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f39000a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f39001b;

    /* renamed from: c  reason: collision with root package name */
    private final n f39002c;

    public c(Context context, n nVar, Executor executor) {
        this.f39000a = executor;
        this.f39001b = context;
        this.f39002c = nVar;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a() {
        /*
            r8 = this;
            com.google.firebase.messaging.n r0 = r8.f39002c
            java.lang.String r1 = "gcm.n.noui"
            boolean r0 = r0.b(r1)
            r1 = 1
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            android.content.Context r0 = r8.f39001b
            java.lang.String r2 = "keyguard"
            java.lang.Object r0 = r0.getSystemService(r2)
            android.app.KeyguardManager r0 = (android.app.KeyguardManager) r0
            boolean r0 = r0.inKeyguardRestrictedInputMode()
            r2 = 0
            if (r0 != 0) goto L_0x0058
            boolean r0 = com.google.android.gms.common.util.n.d()
            if (r0 != 0) goto L_0x0028
            r3 = 10
            android.os.SystemClock.sleep(r3)
        L_0x0028:
            int r0 = android.os.Process.myPid()
            android.content.Context r3 = r8.f39001b
            java.lang.String r4 = "activity"
            java.lang.Object r3 = r3.getSystemService(r4)
            android.app.ActivityManager r3 = (android.app.ActivityManager) r3
            java.util.List r3 = r3.getRunningAppProcesses()
            if (r3 == 0) goto L_0x0058
            java.util.Iterator r3 = r3.iterator()
        L_0x0040:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0058
            java.lang.Object r4 = r3.next()
            android.app.ActivityManager$RunningAppProcessInfo r4 = (android.app.ActivityManager.RunningAppProcessInfo) r4
            int r5 = r4.pid
            if (r5 != r0) goto L_0x0040
            int r0 = r4.importance
            r3 = 100
            if (r0 != r3) goto L_0x0058
            r0 = 1
            goto L_0x0059
        L_0x0058:
            r0 = 0
        L_0x0059:
            if (r0 == 0) goto L_0x005c
            return r2
        L_0x005c:
            com.google.firebase.messaging.n r0 = r8.f39002c
            java.lang.String r2 = "gcm.n.image"
            java.lang.String r0 = r0.a((java.lang.String) r2)
            com.google.firebase.messaging.k r0 = com.google.firebase.messaging.k.a(r0)
            if (r0 == 0) goto L_0x0077
            java.util.concurrent.Executor r2 = r8.f39000a
            com.google.firebase.messaging.l r3 = new com.google.firebase.messaging.l
            r3.<init>(r0)
            com.google.android.gms.tasks.Task r2 = com.google.android.gms.tasks.h.a((java.util.concurrent.Executor) r2, r3)
            r0.f39016b = r2
        L_0x0077:
            android.content.Context r2 = r8.f39001b
            com.google.firebase.messaging.n r3 = r8.f39002c
            com.google.firebase.messaging.a$a r2 = com.google.firebase.messaging.a.a((android.content.Context) r2, (com.google.firebase.messaging.n) r3)
            androidx.core.app.h$e r3 = r2.f38996a
            if (r0 == 0) goto L_0x00d6
            com.google.android.gms.tasks.Task<android.graphics.Bitmap> r4 = r0.f39016b     // Catch:{ ExecutionException -> 0x00b6, InterruptedException -> 0x00ab, TimeoutException -> 0x00a7 }
            java.lang.Object r4 = com.google.android.gms.common.internal.s.a(r4)     // Catch:{ ExecutionException -> 0x00b6, InterruptedException -> 0x00ab, TimeoutException -> 0x00a7 }
            com.google.android.gms.tasks.Task r4 = (com.google.android.gms.tasks.Task) r4     // Catch:{ ExecutionException -> 0x00b6, InterruptedException -> 0x00ab, TimeoutException -> 0x00a7 }
            r5 = 5
            java.util.concurrent.TimeUnit r7 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ ExecutionException -> 0x00b6, InterruptedException -> 0x00ab, TimeoutException -> 0x00a7 }
            java.lang.Object r4 = com.google.android.gms.tasks.h.a(r4, r5, r7)     // Catch:{ ExecutionException -> 0x00b6, InterruptedException -> 0x00ab, TimeoutException -> 0x00a7 }
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4     // Catch:{ ExecutionException -> 0x00b6, InterruptedException -> 0x00ab, TimeoutException -> 0x00a7 }
            r3.a((android.graphics.Bitmap) r4)     // Catch:{ ExecutionException -> 0x00b6, InterruptedException -> 0x00ab, TimeoutException -> 0x00a7 }
            androidx.core.app.h$b r5 = new androidx.core.app.h$b     // Catch:{ ExecutionException -> 0x00b6, InterruptedException -> 0x00ab, TimeoutException -> 0x00a7 }
            r5.<init>()     // Catch:{ ExecutionException -> 0x00b6, InterruptedException -> 0x00ab, TimeoutException -> 0x00a7 }
            r5.f2708a = r4     // Catch:{ ExecutionException -> 0x00b6, InterruptedException -> 0x00ab, TimeoutException -> 0x00a7 }
            androidx.core.app.h$b r4 = r5.a()     // Catch:{ ExecutionException -> 0x00b6, InterruptedException -> 0x00ab, TimeoutException -> 0x00a7 }
            r3.a((androidx.core.app.h.C0039h) r4)     // Catch:{ ExecutionException -> 0x00b6, InterruptedException -> 0x00ab, TimeoutException -> 0x00a7 }
            goto L_0x00d6
        L_0x00a7:
            r0.close()
            goto L_0x00d6
        L_0x00ab:
            r0.close()
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            r0.interrupt()
            goto L_0x00d6
        L_0x00b6:
            r0 = move-exception
            java.lang.Throwable r0 = r0.getCause()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r3 = r3 + 26
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Failed to download image: "
            r4.append(r3)
            r4.append(r0)
        L_0x00d6:
            r0 = 3
            java.lang.String r3 = "FirebaseMessaging"
            android.util.Log.isLoggable(r3, r0)
            android.content.Context r0 = r8.f39001b
            java.lang.String r3 = "notification"
            java.lang.Object r0 = r0.getSystemService(r3)
            android.app.NotificationManager r0 = (android.app.NotificationManager) r0
            java.lang.String r3 = r2.f38997b
            int r4 = r2.f38998c
            androidx.core.app.h$e r2 = r2.f38996a
            android.app.Notification r2 = r2.d()
            r0.notify(r3, r4, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.messaging.c.a():boolean");
    }
}
