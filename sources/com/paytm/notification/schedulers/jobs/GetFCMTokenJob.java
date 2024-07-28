package com.paytm.notification.schedulers.jobs;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import kotlin.d.b.a.d;
import kotlin.d.b.a.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

public final class GetFCMTokenJob extends CoroutineWorker {

    /* renamed from: c  reason: collision with root package name */
    public static final a f43316c = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static int f43317e;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Context f43318d;

    @f(b = "GetFCMTokenJob.kt", c = {17}, d = "doWork", e = "com.paytm.notification.schedulers.jobs.GetFCMTokenJob")
    static final class b extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ GetFCMTokenJob this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(GetFCMTokenJob getFCMTokenJob, kotlin.d.d dVar) {
            super(dVar);
            this.this$0 = getFCMTokenJob;
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a((kotlin.d.d<? super ListenableWorker.a>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetFCMTokenJob(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "appContext");
        k.c(workerParameters, "workerParams");
        this.f43318d = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @f(b = "GetFCMTokenJob.kt", c = {18, 21}, d = "invokeSuspend", e = "com.paytm.notification.schedulers.jobs.GetFCMTokenJob$doWork$2")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super ListenableWorker.a>, Object> {
        Object L$0;
        Object L$1;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ GetFCMTokenJob this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(GetFCMTokenJob getFCMTokenJob, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = getFCMTokenJob;
        }

        public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            c cVar = new c(this.this$0, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
        }

        /* JADX WARNING: Removed duplicated region for block: B:26:0x00a0 A[Catch:{ Exception -> 0x0012 }] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00a8 A[Catch:{ Exception -> 0x0012 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) {
            /*
                r9 = this;
                kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
                int r1 = r9.label
                r2 = 2
                r3 = 1
                r4 = 0
                if (r1 == 0) goto L_0x0025
                if (r1 == r3) goto L_0x001d
                if (r1 != r2) goto L_0x0015
                kotlin.ResultKt.a((java.lang.Object) r10)     // Catch:{ Exception -> 0x0012 }
                goto L_0x009a
            L_0x0012:
                r10 = move-exception
                goto L_0x00d0
            L_0x0015:
                java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r10.<init>(r0)
                throw r10
            L_0x001d:
                java.lang.Object r1 = r9.L$0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                kotlin.ResultKt.a((java.lang.Object) r10)
                goto L_0x0041
            L_0x0025:
                kotlin.ResultKt.a((java.lang.Object) r10)
                kotlinx.coroutines.CoroutineScope r1 = r9.p$
                com.paytm.notification.g$c r10 = com.paytm.notification.g.f43191a
                com.paytm.notification.schedulers.jobs.GetFCMTokenJob r10 = r9.this$0
                android.content.Context r10 = r10.f43318d
                android.content.Context r10 = r10.getApplicationContext()
                r9.L$0 = r1
                r9.label = r3
                java.lang.Object r10 = com.paytm.notification.g.c.a((android.content.Context) r10, (kotlin.d.d<? super com.paytm.notification.g>) r9)
                if (r10 != r0) goto L_0x0041
                return r0
            L_0x0041:
                com.paytm.notification.g r10 = (com.paytm.notification.g) r10
                if (r10 == 0) goto L_0x00d7
                com.paytm.notification.schedulers.b.e r5 = com.paytm.notification.schedulers.b.e.f43267a     // Catch:{ Exception -> 0x0012 }
                com.paytm.notification.schedulers.jobs.GetFCMTokenJob r5 = r9.this$0     // Catch:{ Exception -> 0x0012 }
                android.content.Context r5 = r5.getApplicationContext()     // Catch:{ Exception -> 0x0012 }
                java.lang.String r6 = "applicationContext"
                kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)     // Catch:{ Exception -> 0x0012 }
                com.paytm.notification.j r6 = com.paytm.notification.j.f43241a     // Catch:{ Exception -> 0x0012 }
                com.paytm.notification.data.c.h r6 = r6.c()     // Catch:{ Exception -> 0x0012 }
                r9.L$0 = r1     // Catch:{ Exception -> 0x0012 }
                r9.L$1 = r10     // Catch:{ Exception -> 0x0012 }
                r9.label = r2     // Catch:{ Exception -> 0x0012 }
                com.google.firebase.c r10 = com.paytm.notification.schedulers.b.e.a(r5, r6)     // Catch:{ Exception -> 0x0012 }
                if (r10 != 0) goto L_0x0067
                com.paytm.notification.models.JOB_RESULT r10 = com.paytm.notification.models.JOB_RESULT.RETRY     // Catch:{ Exception -> 0x0012 }
                goto L_0x0097
            L_0x0067:
                kotlin.d.h r1 = new kotlin.d.h     // Catch:{ Exception -> 0x0012 }
                kotlin.d.d r2 = kotlin.d.a.b.a(r9)     // Catch:{ Exception -> 0x0012 }
                r1.<init>(r2)     // Catch:{ Exception -> 0x0012 }
                r2 = r1
                kotlin.d.d r2 = (kotlin.d.d) r2     // Catch:{ Exception -> 0x0012 }
                com.google.firebase.iid.FirebaseInstanceId r7 = com.google.firebase.iid.FirebaseInstanceId.getInstance(r10)     // Catch:{ Exception -> 0x0012 }
                java.lang.String r8 = "FirebaseInstanceId.getInstance(app)"
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r8)     // Catch:{ Exception -> 0x0012 }
                com.google.android.gms.tasks.Task r7 = r7.f()     // Catch:{ Exception -> 0x0012 }
                com.paytm.notification.schedulers.b.e$a r8 = new com.paytm.notification.schedulers.b.e$a     // Catch:{ Exception -> 0x0012 }
                r8.<init>(r2, r10, r5, r6)     // Catch:{ Exception -> 0x0012 }
                com.google.android.gms.tasks.c r8 = (com.google.android.gms.tasks.c) r8     // Catch:{ Exception -> 0x0012 }
                r7.a(r8)     // Catch:{ Exception -> 0x0012 }
                java.lang.Object r10 = r1.a()     // Catch:{ Exception -> 0x0012 }
                kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED     // Catch:{ Exception -> 0x0012 }
                if (r10 != r1) goto L_0x0097
                java.lang.String r1 = "frame"
                kotlin.g.b.k.d(r9, r1)     // Catch:{ Exception -> 0x0012 }
            L_0x0097:
                if (r10 != r0) goto L_0x009a
                return r0
            L_0x009a:
                com.paytm.notification.models.JOB_RESULT r10 = (com.paytm.notification.models.JOB_RESULT) r10     // Catch:{ Exception -> 0x0012 }
                com.paytm.notification.models.JOB_RESULT r0 = com.paytm.notification.models.JOB_RESULT.SUCCESS     // Catch:{ Exception -> 0x0012 }
                if (r10 != r0) goto L_0x00a8
                com.paytm.notification.schedulers.jobs.GetFCMTokenJob.f43317e = r4     // Catch:{ Exception -> 0x0012 }
                androidx.work.ListenableWorker$a r10 = androidx.work.ListenableWorker.a.a()     // Catch:{ Exception -> 0x0012 }
                return r10
            L_0x00a8:
                com.paytm.notification.models.JOB_RESULT r0 = com.paytm.notification.models.JOB_RESULT.RETRY     // Catch:{ Exception -> 0x0012 }
                if (r10 != r0) goto L_0x00c8
                int r10 = com.paytm.notification.schedulers.jobs.GetFCMTokenJob.f43317e     // Catch:{ Exception -> 0x0012 }
                r0 = 3
                if (r10 >= r0) goto L_0x00c0
                int r10 = com.paytm.notification.schedulers.jobs.GetFCMTokenJob.f43317e     // Catch:{ Exception -> 0x0012 }
                int r10 = r10 + r3
                com.paytm.notification.schedulers.jobs.GetFCMTokenJob.f43317e = r10     // Catch:{ Exception -> 0x0012 }
                androidx.work.ListenableWorker$a r10 = androidx.work.ListenableWorker.a.b()     // Catch:{ Exception -> 0x0012 }
                return r10
            L_0x00c0:
                com.paytm.notification.schedulers.jobs.GetFCMTokenJob.f43317e = r4     // Catch:{ Exception -> 0x0012 }
                androidx.work.ListenableWorker$a r10 = androidx.work.ListenableWorker.a.c()     // Catch:{ Exception -> 0x0012 }
                return r10
            L_0x00c8:
                com.paytm.notification.schedulers.jobs.GetFCMTokenJob.f43317e = r4     // Catch:{ Exception -> 0x0012 }
                androidx.work.ListenableWorker$a r10 = androidx.work.ListenableWorker.a.c()     // Catch:{ Exception -> 0x0012 }
                return r10
            L_0x00d0:
                com.paytm.notification.b.e$b r0 = com.paytm.notification.b.e.f43014a
                java.lang.Throwable r10 = (java.lang.Throwable) r10
                r0.b(r10)
            L_0x00d7:
                com.paytm.notification.schedulers.jobs.GetFCMTokenJob.f43317e = r4
                androidx.work.ListenableWorker$a r10 = androidx.work.ListenableWorker.a.c()
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.schedulers.jobs.GetFCMTokenJob.c.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.d.d<? super androidx.work.ListenableWorker.a> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.paytm.notification.schedulers.jobs.GetFCMTokenJob.b
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.paytm.notification.schedulers.jobs.GetFCMTokenJob$b r0 = (com.paytm.notification.schedulers.jobs.GetFCMTokenJob.b) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.paytm.notification.schedulers.jobs.GetFCMTokenJob$b r0 = new com.paytm.notification.schedulers.jobs.GetFCMTokenJob$b
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0030
            if (r2 != r3) goto L_0x0028
            kotlin.ResultKt.a((java.lang.Object) r6)
            goto L_0x004c
        L_0x0028:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0030:
            kotlin.ResultKt.a((java.lang.Object) r6)
            kotlinx.coroutines.CoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getIO()
            kotlin.d.f r6 = (kotlin.d.f) r6
            com.paytm.notification.schedulers.jobs.GetFCMTokenJob$c r2 = new com.paytm.notification.schedulers.jobs.GetFCMTokenJob$c
            r4 = 0
            r2.<init>(r5, r4)
            kotlin.g.a.m r2 = (kotlin.g.a.m) r2
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r2, r0)
            if (r6 != r1) goto L_0x004c
            return r1
        L_0x004c:
            java.lang.String r0 = "withContext(Dispatchers.…xt Result.failure()\n    }"
            kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.schedulers.jobs.GetFCMTokenJob.a(kotlin.d.d):java.lang.Object");
    }
}
