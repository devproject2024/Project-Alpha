package com.paytm.notification.schedulers.jobs;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import kotlin.d.b.a.d;
import kotlin.d.b.a.f;
import kotlin.g.b.k;

public final class SyncFlashStatusJob extends CoroutineWorker {

    /* renamed from: c  reason: collision with root package name */
    public static final a f43330c = new a((byte) 0);

    /* renamed from: d  reason: collision with root package name */
    private final Context f43331d;

    @f(b = "SyncFlashStatusJob.kt", c = {18}, d = "doWork", e = "com.paytm.notification.schedulers.jobs.SyncFlashStatusJob")
    static final class b extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SyncFlashStatusJob this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(SyncFlashStatusJob syncFlashStatusJob, kotlin.d.d dVar) {
            super(dVar);
            this.this$0 = syncFlashStatusJob;
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a(this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SyncFlashStatusJob(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "appContext");
        k.c(workerParameters, "workerParams");
        this.f43331d = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004c A[SYNTHETIC, Splitter:B:17:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.d.d<? super androidx.work.ListenableWorker.a> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.paytm.notification.schedulers.jobs.SyncFlashStatusJob.b
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.paytm.notification.schedulers.jobs.SyncFlashStatusJob$b r0 = (com.paytm.notification.schedulers.jobs.SyncFlashStatusJob.b) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.paytm.notification.schedulers.jobs.SyncFlashStatusJob$b r0 = new com.paytm.notification.schedulers.jobs.SyncFlashStatusJob$b
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0030
            if (r2 != r3) goto L_0x0028
            kotlin.ResultKt.a((java.lang.Object) r6)
            goto L_0x0046
        L_0x0028:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0030:
            kotlin.ResultKt.a((java.lang.Object) r6)
            com.paytm.notification.g$c r6 = com.paytm.notification.g.f43191a
            android.content.Context r6 = r5.f43331d
            android.content.Context r6 = r6.getApplicationContext()
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = com.paytm.notification.g.c.a((android.content.Context) r6, (kotlin.d.d<? super com.paytm.notification.g>) r0)
            if (r6 != r1) goto L_0x0046
            return r1
        L_0x0046:
            com.paytm.notification.g r6 = (com.paytm.notification.g) r6
            java.lang.String r0 = "Result.failure()"
            if (r6 == 0) goto L_0x00d5
            com.paytm.notification.j r6 = com.paytm.notification.j.f43241a     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            com.paytm.notification.data.c.h r6 = r6.c()     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            com.paytm.notification.models.NotificationUserConfig r1 = r6.a()     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            java.lang.String r2 = r1.getServerEndPoints$paytmnotification_paytmRelease()     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            r3 = 0
            if (r2 != 0) goto L_0x0070
            com.paytm.notification.b.e$b r6 = com.paytm.notification.b.e.f43014a     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            java.lang.String r1 = "Reschedule Job: serverEndPoints == null. Config may not be available yet."
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            r6.c(r1, r2)     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            androidx.work.ListenableWorker$a r6 = androidx.work.ListenableWorker.a.b()     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            java.lang.String r1 = "Result.retry()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            return r6
        L_0x0070:
            java.lang.String r2 = r6.f()     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            if (r2 != 0) goto L_0x0087
            com.paytm.notification.b.e$b r6 = com.paytm.notification.b.e.f43014a     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            java.lang.String r1 = "Null channel id job cancelled"
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            r6.b(r1, r2)     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            androidx.work.ListenableWorker$a r6 = androidx.work.ListenableWorker.a.c()     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            return r6
        L_0x0087:
            com.paytm.notification.schedulers.b.h r2 = new com.paytm.notification.schedulers.b.h     // Catch:{ a -> 0x009f }
            com.paytm.notification.j r4 = com.paytm.notification.j.f43241a     // Catch:{ a -> 0x009f }
            com.paytm.notification.data.c.d r4 = r4.e()     // Catch:{ a -> 0x009f }
            r2.<init>(r1, r6, r4)     // Catch:{ a -> 0x009f }
            r2.a()     // Catch:{ a -> 0x009f }
            androidx.work.ListenableWorker$a r6 = androidx.work.ListenableWorker.a.a()     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            java.lang.String r1 = "Result.success()"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            return r6
        L_0x009f:
            r6 = move-exception
            com.paytm.notification.b.e$b r1 = com.paytm.notification.b.e.f43014a     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            java.lang.String r4 = "[DoNotRetry] SyncFlashStatus error: "
            r2.<init>(r4)     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            java.lang.String r4 = r6.getMessage()     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            r2.append(r4)     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            java.lang.String r2 = r2.toString()     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            r1.a(r2, r3)     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            r6.printStackTrace()     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            androidx.work.ListenableWorker$a r6 = androidx.work.ListenableWorker.a.c()     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)     // Catch:{ a -> 0x00cd, Exception -> 0x00c4 }
            return r6
        L_0x00c4:
            r6 = move-exception
            com.paytm.notification.b.e$b r1 = com.paytm.notification.b.e.f43014a
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r1.b(r6)
            goto L_0x00d5
        L_0x00cd:
            r6 = move-exception
            com.paytm.notification.b.e$b r1 = com.paytm.notification.b.e.f43014a
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            r1.b(r6)
        L_0x00d5:
            androidx.work.ListenableWorker$a r6 = androidx.work.ListenableWorker.a.c()
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.schedulers.jobs.SyncFlashStatusJob.a(kotlin.d.d):java.lang.Object");
    }
}
