package net.one97.paytm.appManager.sync;

import android.content.Context;
import android.database.sqlite.SQLiteDatabaseLockedException;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import kotlin.ResultKt;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.p;
import kotlin.x;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import net.one97.paytm.appManager.beans.Data;
import net.one97.paytm.appManager.beans.MetaInfo;
import net.one97.paytm.appManager.beans.ResponseData;
import net.one97.paytm.appManager.storage.a.a;
import net.one97.paytm.appManager.storage.db.AppManagerDb;

public final class SyncAndSaveWork extends Worker {

    /* renamed from: g  reason: collision with root package name */
    public static final a f49070g = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static String f49071i = "SyncAndSaveWork";

    /* renamed from: a  reason: collision with root package name */
    public volatile CountDownLatch f49072a;

    /* renamed from: b  reason: collision with root package name */
    ListenableWorker.a f49073b;

    /* renamed from: c  reason: collision with root package name */
    long f49074c;

    /* renamed from: d  reason: collision with root package name */
    volatile int f49075d = 1;

    /* renamed from: e  reason: collision with root package name */
    volatile Long f49076e;

    /* renamed from: f  reason: collision with root package name */
    Context f49077f;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public b f49078h = new b(this);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SyncAndSaveWork(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        k.c(context, "appContext");
        k.c(workerParameters, "workerParams");
        this.f49077f = context;
    }

    public final CountDownLatch a() {
        CountDownLatch countDownLatch = this.f49072a;
        if (countDownLatch == null) {
            k.a("latch");
        }
        return countDownLatch;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        if (net.one97.paytm.appManager.storage.b.a.b(r4.f49077f) != false) goto L_0x0016;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final androidx.work.ListenableWorker.a doWork() {
        /*
            r4 = this;
            java.lang.String r0 = "Result.failure()"
            net.one97.paytm.appManager.sync.a r1 = net.one97.paytm.appManager.sync.a.f49082a     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            int r1 = net.one97.paytm.appManager.sync.a.a()     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            r2 = 2
            r3 = 1
            if (r1 > r2) goto L_0x0016
            net.one97.paytm.appManager.storage.b.a r1 = net.one97.paytm.appManager.storage.b.a.f49053c     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            android.content.Context r1 = r4.f49077f     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            boolean r1 = net.one97.paytm.appManager.storage.b.a.b(r1)     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            if (r1 == 0) goto L_0x0024
        L_0x0016:
            net.one97.paytm.appManager.sync.a r1 = net.one97.paytm.appManager.sync.a.f49082a     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            r1 = 0
            net.one97.paytm.appManager.sync.a.a((int) r1)     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            net.one97.paytm.appManager.storage.b.a r1 = net.one97.paytm.appManager.storage.b.a.f49053c     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            net.one97.paytm.appManager.storage.b.a.a((boolean) r3)     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            androidx.work.ListenableWorker.a.c()     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
        L_0x0024:
            net.one97.paytm.appManager.sync.a r1 = net.one97.paytm.appManager.sync.a.f49082a     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            int r1 = net.one97.paytm.appManager.sync.a.a()     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            int r1 = r1 + r3
            net.one97.paytm.appManager.sync.a.a((int) r1)     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            net.one97.paytm.appManager.storage.b.a r1 = net.one97.paytm.appManager.storage.b.a.f49053c     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            android.content.Context r1 = r4.f49077f     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            long r1 = net.one97.paytm.appManager.storage.b.a.a((android.content.Context) r1)     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            r4.f49074c = r1     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            net.one97.paytm.appManager.b.b$a r1 = net.one97.paytm.appManager.b.b.f49032f     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            net.one97.paytm.appManager.b.b.a.a()     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            java.util.concurrent.CountDownLatch r1 = new java.util.concurrent.CountDownLatch     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            r1.<init>(r3)     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            r4.f49072a = r1     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            r4.c()     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            java.util.concurrent.CountDownLatch r1 = r4.f49072a     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            if (r1 != 0) goto L_0x0050
            java.lang.String r2 = "latch"
            kotlin.g.b.k.a((java.lang.String) r2)     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
        L_0x0050:
            r1.await()     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            net.one97.paytm.appManager.b.b$a r1 = net.one97.paytm.appManager.b.b.f49032f     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            net.one97.paytm.appManager.b.b.a.a()     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            androidx.work.ListenableWorker$a r1 = r4.f49073b     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            if (r1 != 0) goto L_0x0060
            androidx.work.ListenableWorker$a r1 = androidx.work.ListenableWorker.a.c()     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
        L_0x0060:
            r4.f49073b = r1     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            androidx.work.ListenableWorker$a r1 = r4.f49073b     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            if (r1 != 0) goto L_0x0079
            kotlin.g.b.k.a()     // Catch:{ InterruptedException -> 0x0072, all -> 0x006a }
            goto L_0x0079
        L_0x006a:
            androidx.work.ListenableWorker$a r1 = androidx.work.ListenableWorker.a.c()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)
            goto L_0x0079
        L_0x0072:
            androidx.work.ListenableWorker$a r1 = androidx.work.ListenableWorker.a.c()
            kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r0)
        L_0x0079:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.appManager.sync.SyncAndSaveWork.doWork():androidx.work.ListenableWorker$a");
    }

    public static final class b implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SyncAndSaveWork f49079a;

        /* renamed from: b  reason: collision with root package name */
        private final CoroutineExceptionHandler f49080b = new a(CoroutineExceptionHandler.Key, this);

        public static final class a extends kotlin.d.a implements CoroutineExceptionHandler {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ b f49081a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(f.c cVar, b bVar) {
                super(cVar);
                this.f49081a = bVar;
            }

            public final void handleException(f fVar, Throwable th) {
                a aVar = SyncAndSaveWork.f49070g;
                String unused = SyncAndSaveWork.f49071i;
                StringBuilder sb = new StringBuilder();
                sb.append(th);
                sb.append(" handled !");
                this.f49081a.f49079a.f49073b = ListenableWorker.a.c();
                this.f49081a.f49079a.a().countDown();
            }
        }

        b(SyncAndSaveWork syncAndSaveWork) {
            this.f49079a = syncAndSaveWork;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
            r0 = (net.one97.paytm.appManager.beans.ResponseData) r15;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onApiSuccess(com.paytm.network.model.IJRPaytmDataModel r15) {
            /*
                r14 = this;
                java.lang.String r0 = "response"
                kotlin.g.b.k.c(r15, r0)
                boolean r0 = r15 instanceof net.one97.paytm.appManager.beans.ResponseData
                if (r0 == 0) goto L_0x0055
                r0 = r15
                net.one97.paytm.appManager.beans.ResponseData r0 = (net.one97.paytm.appManager.beans.ResponseData) r0
                java.lang.Integer r1 = r0.getStatus()
                if (r1 != 0) goto L_0x0013
                return
            L_0x0013:
                int r1 = r1.intValue()
                r2 = 200(0xc8, float:2.8E-43)
                if (r1 != r2) goto L_0x0055
                kotlin.g.b.x$e r7 = new kotlin.g.b.x$e
                r7.<init>()
                net.one97.paytm.appManager.sync.SyncAndSaveWork r1 = r14.f49079a
                android.content.Context r1 = r1.getApplicationContext()
                net.one97.paytm.appManager.storage.db.AppManagerDb r1 = net.one97.paytm.appManager.storage.db.AppManagerDb.a(r1)
                r7.element = r1
                net.one97.paytm.appManager.beans.Data r4 = r0.getData()
                if (r4 == 0) goto L_0x0055
                kotlinx.coroutines.GlobalScope r0 = kotlinx.coroutines.GlobalScope.INSTANCE
                kotlinx.coroutines.CoroutineScope r0 = (kotlinx.coroutines.CoroutineScope) r0
                kotlinx.coroutines.CoroutineDispatcher r1 = kotlinx.coroutines.Dispatchers.getIO()
                kotlinx.coroutines.CoroutineExceptionHandler r2 = r14.f49080b
                kotlin.d.f r2 = (kotlin.d.f) r2
                kotlin.d.f r9 = r1.plus(r2)
                r10 = 0
                net.one97.paytm.appManager.sync.SyncAndSaveWork$b$b r1 = new net.one97.paytm.appManager.sync.SyncAndSaveWork$b$b
                r5 = 0
                r3 = r1
                r6 = r14
                r8 = r15
                r3.<init>(r4, r5, r6, r7, r8)
                r11 = r1
                kotlin.g.a.m r11 = (kotlin.g.a.m) r11
                r12 = 2
                r13 = 0
                r8 = r0
                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r8, r9, r10, r11, r12, r13)
            L_0x0055:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.appManager.sync.SyncAndSaveWork.b.onApiSuccess(com.paytm.network.model.IJRPaytmDataModel):void");
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            this.f49079a.f49073b = ListenableWorker.a.c();
            this.f49079a.a().countDown();
        }

        /* renamed from: net.one97.paytm.appManager.sync.SyncAndSaveWork$b$b  reason: collision with other inner class name */
        static final class C0866b extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
            final /* synthetic */ x.e $db$inlined;
            final /* synthetic */ Data $it;
            final /* synthetic */ IJRPaytmDataModel $response$inlined;
            int label;
            private CoroutineScope p$;
            final /* synthetic */ b this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0866b(Data data, d dVar, b bVar, x.e eVar, IJRPaytmDataModel iJRPaytmDataModel) {
                super(2, dVar);
                this.$it = data;
                this.this$0 = bVar;
                this.$db$inlined = eVar;
                this.$response$inlined = iJRPaytmDataModel;
            }

            public final d<kotlin.x> create(Object obj, d<?> dVar) {
                k.c(dVar, "completion");
                C0866b bVar = new C0866b(this.$it, dVar, this.this$0, this.$db$inlined, this.$response$inlined);
                bVar.p$ = (CoroutineScope) obj;
                return bVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C0866b) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                net.one97.paytm.appManager.storage.db.c[] list;
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label == 0) {
                    ResultKt.a(obj);
                    try {
                        MetaInfo metaData = this.$it.getMetaData();
                        boolean z = true;
                        if (!p.a(metaData != null ? metaData.getResponseType() : null, "complete", true) || this.this$0.f49079a.f49075d != 1) {
                            net.one97.paytm.appManager.storage.db.c[] list2 = this.$it.getList();
                            if (list2 != null) {
                                ((AppManagerDb) this.$db$inlined.element).a().c((net.one97.paytm.appManager.storage.db.c[]) Arrays.copyOf(list2, list2.length));
                            }
                            net.one97.paytm.appManager.storage.db.c[] deletedList = this.$it.getDeletedList();
                            if (deletedList != null) {
                                ((AppManagerDb) this.$db$inlined.element).a().e((net.one97.paytm.appManager.storage.db.c[]) Arrays.copyOf(deletedList, deletedList.length));
                            }
                        } else {
                            net.one97.paytm.appManager.storage.db.c[] list3 = this.$it.getList();
                            if (list3 != null) {
                                ((AppManagerDb) this.$db$inlined.element).a().d((net.one97.paytm.appManager.storage.db.c[]) Arrays.copyOf(list3, list3.length));
                            }
                        }
                        MetaInfo metaData2 = this.$it.getMetaData();
                        if (metaData2 != null) {
                            if (!metaData2.getHasNext()) {
                                net.one97.paytm.appManager.storage.b.a aVar2 = net.one97.paytm.appManager.storage.b.a.f49053c;
                                Context applicationContext = this.this$0.f49079a.getApplicationContext();
                                k.a((Object) applicationContext, "applicationContext");
                                k.c(applicationContext, "context");
                                k.c(metaData2, "metaInfo");
                                net.one97.paytm.appManager.storage.b.a.a(applicationContext, metaData2.getVersion());
                                long currentTimeMillis = System.currentTimeMillis();
                                k.c(applicationContext, "context");
                                net.one97.paytm.appManager.storage.b.a.c(applicationContext).a(net.one97.paytm.appManager.storage.b.a.f49051a, currentTimeMillis, false);
                                this.this$0.f49079a.f49075d = 0;
                                a aVar3 = a.f49082a;
                                a.a(0);
                                Data data = ((ResponseData) this.$response$inlined).getData();
                                if (!(data == null || (list = data.getList()) == null)) {
                                    if (list != null) {
                                        if (!(list.length == 0)) {
                                            z = false;
                                        }
                                    }
                                    if (!z) {
                                        a.C0865a aVar4 = net.one97.paytm.appManager.storage.a.a.f49048b;
                                        net.one97.paytm.appManager.storage.a.a a2 = a.C0865a.a();
                                        Context context = this.this$0.f49079a.f49077f;
                                        k.c(context, "context");
                                        a2.f49050a.evictAll();
                                        net.one97.paytm.appManager.storage.b.a aVar5 = net.one97.paytm.appManager.storage.b.a.f49053c;
                                        k.c(context, "context");
                                        net.one97.paytm.appManager.storage.b.a.c(context).a(net.one97.paytm.appManager.storage.b.a.f49052b, false);
                                    }
                                }
                                this.this$0.f49079a.f49073b = ListenableWorker.a.a();
                                this.this$0.f49079a.a().countDown();
                            } else {
                                if (this.this$0.f49079a.f49075d == 1) {
                                    this.this$0.f49079a.f49076e = kotlin.d.b.a.b.a(metaData2.getVersion());
                                } else {
                                    Long l = this.this$0.f49079a.f49076e;
                                    if (l == null || l.longValue() != metaData2.getVersion()) {
                                        this.this$0.f49079a.f49075d = 0;
                                    }
                                }
                                this.this$0.f49079a.f49075d++;
                                this.this$0.f49079a.c();
                            }
                        }
                    } catch (SQLiteDatabaseLockedException e2) {
                        a aVar6 = SyncAndSaveWork.f49070g;
                        String unused = SyncAndSaveWork.f49071i;
                        StringBuilder sb = new StringBuilder();
                        a aVar7 = SyncAndSaveWork.f49070g;
                        sb.append(SyncAndSaveWork.f49071i);
                        sb.append(e2.getMessage());
                        this.this$0.f49079a.f49073b = ListenableWorker.a.a();
                        this.this$0.f49079a.a().countDown();
                    }
                    return kotlin.x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    /* access modifiers changed from: private */
    public final void c() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new c(this, (d) null), 2, (Object) null);
    }

    @kotlin.d.b.a.f(b = "SyncAndSaveWork.kt", c = {}, d = "invokeSuspend", e = "net.one97.paytm.appManager.sync.SyncAndSaveWork$syncData$1")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super kotlin.x>, Object> {
        int label;
        private CoroutineScope p$;
        final /* synthetic */ SyncAndSaveWork this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(SyncAndSaveWork syncAndSaveWork, d dVar) {
            super(2, dVar);
            this.this$0 = syncAndSaveWork;
        }

        public final d<kotlin.x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            c cVar = new c(this.this$0, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                net.one97.paytm.appManager.c.b bVar = net.one97.paytm.appManager.c.b.f49042a;
                Context applicationContext = this.this$0.getApplicationContext();
                k.a((Object) applicationContext, "applicationContext");
                com.paytm.network.a a2 = net.one97.paytm.appManager.c.b.a(applicationContext, this.this$0.f49078h, this.this$0.f49075d, this.this$0.f49074c);
                if (a2 != null) {
                    a2.a();
                }
                return kotlin.x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
