package com.paytm.signal.schedulers;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.paytm.notification.b.e;
import com.paytm.signal.b;
import com.paytm.signal.models.Config;
import kotlin.ResultKt;
import kotlin.d.b.a.d;
import kotlin.d.b.a.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;

public final class SyncEventJob extends CoroutineWorker {

    /* renamed from: c  reason: collision with root package name */
    public static final a f43650c = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static int f43651e;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Context f43652d;

    @f(b = "SyncEventJob.kt", c = {16}, d = "doWork", e = "com.paytm.signal.schedulers.SyncEventJob")
    static final class b extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ SyncEventJob this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(SyncEventJob syncEventJob, kotlin.d.d dVar) {
            super(dVar);
            this.this$0 = syncEventJob;
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a((kotlin.d.d<? super ListenableWorker.a>) this);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SyncEventJob(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "appContext");
        k.c(workerParameters, "workerParams");
        this.f43652d = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @f(b = "SyncEventJob.kt", c = {}, d = "invokeSuspend", e = "com.paytm.signal.schedulers.SyncEventJob$doWork$2")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super ListenableWorker.a>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ SyncEventJob this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(SyncEventJob syncEventJob, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = syncEventJob;
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

        public final Object invokeSuspend(Object obj) {
            Config config;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                try {
                    e.f43014a.a("Sync Event Job has started.. ", new Object[0]);
                    b.C0745b bVar = com.paytm.signal.b.f43594e;
                    com.paytm.signal.b a2 = b.C0745b.a(this.this$0.f43652d.getApplicationContext());
                    if (a2 != null) {
                        com.paytm.signal.b.a aVar2 = a2.f43596a;
                        String str = null;
                        if (aVar2 != null) {
                            config = aVar2.f43603a;
                        } else {
                            config = null;
                        }
                        com.paytm.signal.data.a aVar3 = a2.f43598c;
                        if (config != null) {
                            str = config.getServerEndPoints();
                        }
                        if (str == null || aVar3 == null) {
                            SyncEventJob.f43651e = 0;
                            return ListenableWorker.a.c();
                        }
                        try {
                            b bVar2 = b.f43659a;
                            if (b.a(config, aVar3, a2.f43599d, false)) {
                                SyncEventJob.f43651e = 0;
                                return ListenableWorker.a.a();
                            } else if (SyncEventJob.f43651e < 3) {
                                SyncEventJob.f43651e = SyncEventJob.f43651e + 1;
                                return ListenableWorker.a.b();
                            } else {
                                SyncEventJob.f43651e = 0;
                                return ListenableWorker.a.c();
                            }
                        } catch (com.paytm.notification.schedulers.a.a unused) {
                            e.f43014a.a("Do not retry exception rescheduling cancelled", new Object[0]);
                            SyncEventJob.f43651e = 0;
                            return ListenableWorker.a.c();
                        }
                    } else {
                        SyncEventJob.f43651e = 0;
                        e.f43014a.a("SDK Disabled state!!!! Canceling job", new Object[0]);
                        return ListenableWorker.a.c();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    e.f43014a.b(e2);
                    return ListenableWorker.a.c();
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0030  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.d.d<? super androidx.work.ListenableWorker.a> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.paytm.signal.schedulers.SyncEventJob.b
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.paytm.signal.schedulers.SyncEventJob$b r0 = (com.paytm.signal.schedulers.SyncEventJob.b) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.paytm.signal.schedulers.SyncEventJob$b r0 = new com.paytm.signal.schedulers.SyncEventJob$b
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
            com.paytm.signal.schedulers.SyncEventJob$c r2 = new com.paytm.signal.schedulers.SyncEventJob$c
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
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.signal.schedulers.SyncEventJob.a(kotlin.d.d):java.lang.Object");
    }
}
