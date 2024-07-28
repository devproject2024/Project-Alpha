package com.paytm.signal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.work.v;
import com.paytm.notification.b.e;
import com.paytm.signal.b.a;
import com.paytm.signal.c.a;
import com.paytm.signal.models.Config;
import com.paytm.signal.models.SignalEvent;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final C0745b f43594e = new C0745b((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f43595i;
    /* access modifiers changed from: private */
    public static boolean j;
    /* access modifiers changed from: private */
    public static boolean k;
    /* access modifiers changed from: private */
    public static a l;

    /* renamed from: a  reason: collision with root package name */
    public a f43596a;

    /* renamed from: b  reason: collision with root package name */
    com.paytm.signallocation.a.a f43597b;

    /* renamed from: c  reason: collision with root package name */
    public com.paytm.signal.data.a f43598c;

    /* renamed from: d  reason: collision with root package name */
    public com.paytm.signal.schedulers.a f43599d;

    /* renamed from: f  reason: collision with root package name */
    private com.paytm.signal.b.b f43600f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f43601g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f43602h;

    private b(Context context) {
        this.f43602h = context;
    }

    public /* synthetic */ b(Context context, byte b2) {
        this(context);
    }

    private final void a(Context context) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new c(this, context, (d) null), 2, (Object) null);
    }

    /* renamed from: com.paytm.signal.b$b  reason: collision with other inner class name */
    public static final class C0745b {
        private C0745b() {
        }

        public /* synthetic */ C0745b(byte b2) {
            this();
        }

        /* renamed from: com.paytm.signal.b$b$a */
        public static final class a implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f43610a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f43611b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f43612c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ long f43613d;

            public a(a aVar, Context context, boolean z, long j) {
                this.f43610a = aVar;
                this.f43611b = context;
                this.f43612c = z;
                this.f43613d = j;
            }

            public final void run() {
                C0745b bVar = b.f43594e;
                b.l = this.f43610a;
                C0745b bVar2 = b.f43594e;
                C0745b.a(this.f43611b, this.f43612c);
                long currentTimeMillis = System.currentTimeMillis() - this.f43613d;
                StringBuilder sb = new StringBuilder("***** init() worker thread took [");
                sb.append(currentTimeMillis);
                sb.append("] ms ***** ");
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x0055, code lost:
            r4 = com.paytm.signal.b.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
            if (r4 != null) goto L_0x005b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005b, code lost:
            com.paytm.signal.b.c(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x005e, code lost:
            com.paytm.signal.b.a((com.paytm.signal.b) null);
            com.paytm.notification.b.e.f43014a.b(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static void a(android.content.Context r3, boolean r4) {
            /*
                com.paytm.signal.b.j = false     // Catch:{ Exception -> 0x0054 }
                com.paytm.signal.b r0 = com.paytm.signal.b.f43595i     // Catch:{ Exception -> 0x0054 }
                if (r0 != 0) goto L_0x0069
                java.lang.Class<com.paytm.signal.b> r0 = com.paytm.signal.b.class
                monitor-enter(r0)     // Catch:{ Exception -> 0x0054 }
                com.paytm.signal.b$b r1 = com.paytm.signal.b.f43594e     // Catch:{ all -> 0x0051 }
                com.paytm.signal.b r1 = com.paytm.signal.b.f43595i     // Catch:{ all -> 0x0051 }
                if (r1 != 0) goto L_0x004d
                com.paytm.signal.b$b r1 = com.paytm.signal.b.f43594e     // Catch:{ all -> 0x0051 }
                com.paytm.signal.b.k = r4     // Catch:{ all -> 0x0051 }
                r4 = 0
                if (r3 != 0) goto L_0x0026
                com.paytm.notification.b.e$b r3 = com.paytm.notification.b.e.f43014a     // Catch:{ all -> 0x0051 }
                java.lang.String r1 = "Context is null. PAI Signal init failed. "
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0051 }
                r3.a(r1, r4)     // Catch:{ all -> 0x0051 }
                goto L_0x004d
            L_0x0026:
                com.paytm.signal.b$b r1 = com.paytm.signal.b.f43594e     // Catch:{ all -> 0x0051 }
                com.paytm.signal.b r1 = new com.paytm.signal.b     // Catch:{ all -> 0x0051 }
                android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0051 }
                java.lang.String r2 = "context.applicationContext"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)     // Catch:{ all -> 0x0051 }
                r1.<init>(r3, r4)     // Catch:{ all -> 0x0051 }
                com.paytm.signal.b.f43595i = r1     // Catch:{ all -> 0x0051 }
                com.paytm.signal.b$b r3 = com.paytm.signal.b.f43594e     // Catch:{ all -> 0x0051 }
                com.paytm.signal.b r3 = com.paytm.signal.b.f43595i     // Catch:{ all -> 0x0051 }
                if (r3 == 0) goto L_0x0044
                com.paytm.signal.b.b(r3)     // Catch:{ all -> 0x0051 }
            L_0x0044:
                com.paytm.notification.b.e$b r3 = com.paytm.notification.b.e.f43014a     // Catch:{ all -> 0x0051 }
                java.lang.String r1 = "PAI Signal initialized..."
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0051 }
                r3.a(r1, r4)     // Catch:{ all -> 0x0051 }
            L_0x004d:
                kotlin.x r3 = kotlin.x.f47997a     // Catch:{ all -> 0x0051 }
                monitor-exit(r0)     // Catch:{ Exception -> 0x0054 }
                return
            L_0x0051:
                r3 = move-exception
                monitor-exit(r0)     // Catch:{ Exception -> 0x0054 }
                throw r3     // Catch:{ Exception -> 0x0054 }
            L_0x0054:
                r3 = move-exception
                com.paytm.signal.b r4 = com.paytm.signal.b.f43595i
                if (r4 == 0) goto L_0x005e
                com.paytm.signal.b.c(r4)
            L_0x005e:
                r4 = 0
                com.paytm.signal.b.f43595i = r4
                com.paytm.notification.b.e$b r4 = com.paytm.notification.b.e.f43014a
                java.lang.Throwable r3 = (java.lang.Throwable) r3
                r4.b(r3)
            L_0x0069:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.signal.b.C0745b.a(android.content.Context, boolean):void");
        }

        public static b a(Context context) {
            b a2;
            synchronized (b.class) {
                C0745b bVar = b.f43594e;
                if (b.f43595i == null && context != null) {
                    Config b2 = c.f43614a.b(context).b();
                    C0745b bVar2 = b.f43594e;
                    a(context, k.a((Object) b2 != null ? b2.getShowDebugLogs$paytmnotification_paytmRelease() : null, (Object) Boolean.TRUE));
                }
                C0745b bVar3 = b.f43594e;
                a2 = b.f43595i;
            }
            return a2;
        }

        public static void a(SignalEvent signalEvent) {
            k.c(signalEvent, "signalEvent");
            synchronized (b.class) {
                C0745b bVar = b.f43594e;
                b a2 = b.f43595i;
                if (a2 != null) {
                    b.a(a2, signalEvent);
                    x xVar = x.f47997a;
                }
            }
        }

        public static void a() {
            synchronized (b.class) {
                C0745b bVar = b.f43594e;
                b a2 = b.f43595i;
                if (a2 != null) {
                    b.d(a2);
                    x xVar = x.f47997a;
                }
            }
        }

        @f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.signal.PaytmSignal$Companion$login$1")
        /* renamed from: com.paytm.signal.b$b$b  reason: collision with other inner class name */
        public static final class C0746b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            final /* synthetic */ String $userId;
            int label;
            private CoroutineScope p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0746b(String str, kotlin.d.d dVar) {
                super(2, dVar);
                this.$userId = str;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                C0746b bVar = new C0746b(this.$userId, dVar);
                bVar.p$ = (CoroutineScope) obj;
                return bVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C0746b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label == 0) {
                    ResultKt.a(obj);
                    synchronized (b.class) {
                        C0745b bVar = b.f43594e;
                        b a2 = b.f43595i;
                        if (a2 != null) {
                            b.a(a2, this.$userId);
                            x xVar = x.f47997a;
                        }
                    }
                    return x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.signal.PaytmSignal$Companion$logout$1")
        /* renamed from: com.paytm.signal.b$b$c */
        public static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            int label;
            private CoroutineScope p$;

            public c(kotlin.d.d dVar) {
                super(2, dVar);
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                c cVar = new c(dVar);
                cVar.p$ = (CoroutineScope) obj;
                return cVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label == 0) {
                    ResultKt.a(obj);
                    synchronized (b.class) {
                        C0745b bVar = b.f43594e;
                        b a2 = b.f43595i;
                        if (a2 != null) {
                            b.e(a2);
                            x xVar = x.f47997a;
                        }
                    }
                    return x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.signal.PaytmSignal$Companion$onRequestPermissionsResult$1")
        /* renamed from: com.paytm.signal.b$b$d */
        public static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            final /* synthetic */ int[] $grantResults;
            final /* synthetic */ String[] $permissions;
            final /* synthetic */ int $requestCode;
            int label;
            private CoroutineScope p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(int i2, String[] strArr, int[] iArr, kotlin.d.d dVar) {
                super(2, dVar);
                this.$requestCode = i2;
                this.$permissions = strArr;
                this.$grantResults = iArr;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                d dVar2 = new d(this.$requestCode, this.$permissions, this.$grantResults, dVar);
                dVar2.p$ = (CoroutineScope) obj;
                return dVar2;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((d) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label == 0) {
                    ResultKt.a(obj);
                    synchronized (b.class) {
                        C0745b bVar = b.f43594e;
                        b a2 = b.f43595i;
                        if (a2 != null) {
                            b.a(a2, this.$permissions, this.$grantResults);
                            x xVar = x.f47997a;
                        }
                    }
                    return x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.signal.PaytmSignal$Companion$updateConfig$1")
        /* renamed from: com.paytm.signal.b$b$e */
        public static final class e extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            final /* synthetic */ Config $config;
            final /* synthetic */ long $initTime;
            int label;
            private CoroutineScope p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public e(Config config, long j, kotlin.d.d dVar) {
                super(2, dVar);
                this.$config = config;
                this.$initTime = j;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                e eVar = new e(this.$config, this.$initTime, dVar);
                eVar.p$ = (CoroutineScope) obj;
                return eVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((e) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label == 0) {
                    ResultKt.a(obj);
                    synchronized (b.class) {
                        C0745b bVar = b.f43594e;
                        b a2 = b.f43595i;
                        if (a2 != null) {
                            b.a(a2, this.$config);
                        }
                        Integer.valueOf(Log.i("PerformanceLog", "***** updateConfig() worker thread took [" + (System.currentTimeMillis() - this.$initTime) + "] ms ***** "));
                    }
                    return x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final class a extends a.c {
        public final void onActivityPaused(Activity activity) {
            k.c(activity, "activity");
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new C0744a((d) null), 2, (Object) null);
        }

        @f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.signal.PaytmSignal$ActivityListener$onActivityPaused$1")
        /* renamed from: com.paytm.signal.b$a$a  reason: collision with other inner class name */
        static final class C0744a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
            int label;
            private CoroutineScope p$;

            C0744a(d dVar) {
                super(2, dVar);
            }

            public final d<x> create(Object obj, d<?> dVar) {
                k.c(dVar, "completion");
                C0744a aVar = new C0744a(dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C0744a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                Config config;
                com.paytm.signal.data.a aVar;
                com.paytm.signal.b.a aVar2;
                kotlin.d.a.a aVar3 = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label == 0) {
                    ResultKt.a(obj);
                    try {
                        e.f43014a.a("onActivityPaused: send signal events", new Object[0]);
                        C0745b bVar = b.f43594e;
                        b a2 = b.f43595i;
                        com.paytm.signal.schedulers.a aVar4 = null;
                        if (a2 == null || (aVar2 = a2.f43596a) == null) {
                            config = null;
                        } else {
                            config = aVar2.f43603a;
                        }
                        C0745b bVar2 = b.f43594e;
                        b a3 = b.f43595i;
                        if (a3 != null) {
                            aVar = a3.f43598c;
                        } else {
                            aVar = null;
                        }
                        if (!(config == null || aVar == null)) {
                            com.paytm.signal.schedulers.b bVar3 = com.paytm.signal.schedulers.b.f43659a;
                            C0745b bVar4 = b.f43594e;
                            b a4 = b.f43595i;
                            if (a4 != null) {
                                aVar4 = a4.f43599d;
                            }
                            com.paytm.signal.schedulers.b.a(config, aVar, aVar4, false);
                        }
                    } catch (com.paytm.notification.schedulers.a.a e2) {
                        e.f43014a.a("error occured while sending events on onActivityPaused " + e2.getLocalizedMessage(), new Object[0]);
                    }
                    return x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final /* synthetic */ void b(b bVar) {
        com.paytm.signal.c.a aVar;
        bVar.f43598c = c.f43614a.a(bVar.f43602h);
        com.paytm.signal.data.c b2 = c.f43614a.b(bVar.f43602h);
        bVar.f43599d = new com.paytm.signal.schedulers.a(bVar.f43602h);
        bVar.f43596a = new com.paytm.signal.b.a(b2, bVar.f43602h);
        com.paytm.signal.b.a aVar2 = bVar.f43596a;
        if (aVar2 == null) {
            k.a();
        }
        com.paytm.signal.schedulers.a aVar3 = bVar.f43599d;
        if (aVar3 == null) {
            k.a();
        }
        com.paytm.signal.data.a aVar4 = bVar.f43598c;
        if (aVar4 == null) {
            k.a();
        }
        bVar.f43600f = new com.paytm.signal.b.b(aVar2, aVar3, aVar4);
        com.paytm.signallocation.a.c cVar = com.paytm.signallocation.a.c.f43672a;
        com.paytm.signal.b.a aVar5 = bVar.f43596a;
        if (aVar5 == null) {
            k.a();
        }
        com.paytm.signal.schedulers.a aVar6 = bVar.f43599d;
        if (aVar6 == null) {
            k.a();
        }
        com.paytm.signal.b.b bVar2 = bVar.f43600f;
        if (bVar2 == null) {
            k.a();
        }
        bVar.f43597b = cVar.a(aVar5, aVar6, bVar2, b2);
        com.paytm.signal.b.a aVar7 = bVar.f43596a;
        if (aVar7 != null) {
            aVar7.a(bVar.f43602h);
        }
        a.C0747a aVar8 = com.paytm.signal.c.a.f43618d;
        Context context = bVar.f43602h;
        k.c(context, "context");
        if (com.paytm.signal.c.a.j != null) {
            aVar = com.paytm.signal.c.a.j;
            if (aVar == null) {
                throw new u("null cannot be cast to non-null type com.paytm.signal.util.ActivityMonitor");
            }
        } else {
            com.paytm.signal.c.a.j = new com.paytm.signal.c.a((byte) 0);
            com.paytm.signal.c.a a2 = com.paytm.signal.c.a.j;
            if (a2 == null) {
                k.a();
            }
            k.c(context, "context");
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(a2.f43621c);
                aVar = com.paytm.signal.c.a.j;
                if (aVar == null) {
                    throw new u("null cannot be cast to non-null type com.paytm.signal.util.ActivityMonitor");
                }
            } else {
                throw new u("null cannot be cast to non-null type android.app.Application");
            }
        }
        a.b aVar9 = new a();
        k.c(aVar9, "listener");
        synchronized (aVar.f43619a) {
            aVar.f43619a.add(aVar9);
        }
        bVar.f43601g = false;
    }

    @f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.signal.PaytmSignal$closeLocationService$1")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
        final /* synthetic */ Context $context;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, Context context, d dVar) {
            super(2, dVar);
            this.this$0 = bVar;
            this.$context = context;
        }

        public final d<x> create(Object obj, d<?> dVar) {
            k.c(dVar, "completion");
            c cVar = new c(this.this$0, this.$context, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                try {
                    if (this.$context != null) {
                        com.paytm.signallocation.a.a aVar2 = this.this$0.f43597b;
                    }
                } catch (Exception e2) {
                    e.f43014a.b(e2);
                }
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final /* synthetic */ void c(b bVar) {
        try {
            com.paytm.signal.schedulers.a aVar = bVar.f43599d;
            if (aVar != null) {
                try {
                    v a2 = aVar.a();
                    if (a2 != null) {
                        a2.b();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
            bVar.a(bVar.f43602h);
        } catch (Exception e3) {
            e.f43014a.b(e3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x0146 A[Catch:{ a -> 0x0196, Exception -> 0x018a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ void a(com.paytm.signal.b r35, com.paytm.signal.models.Config r36) {
        /*
            r1 = r35
            r0 = r36
            java.lang.String r2 = "os_language"
            com.paytm.notification.b.e$b r3 = com.paytm.notification.b.e.f43014a
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]
            java.lang.String r6 = "Paytm analytics update config.... "
            r3.a(r6, r5)
            com.paytm.signal.b.a r3 = r1.f43596a
            r5 = 0
            if (r3 == 0) goto L_0x0018
            com.paytm.signal.models.Config r3 = r3.f43603a
            goto L_0x0019
        L_0x0018:
            r3 = r5
        L_0x0019:
            java.lang.Boolean r6 = r36.isLocationEnable()
            r7 = 1
            if (r6 == 0) goto L_0x006b
            if (r3 == 0) goto L_0x006b
            boolean r6 = r1.f43601g
            if (r6 == 0) goto L_0x0050
            java.lang.Boolean r6 = r3.isLocationEnable()
            if (r6 == 0) goto L_0x0050
            java.lang.Boolean r6 = r36.isLocationEnable()
            java.lang.Boolean r8 = r3.isLocationEnable()
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r8)
            r6 = r6 ^ r7
            if (r6 != 0) goto L_0x0050
            java.lang.Integer r6 = r3.getLocationSchedulingTime()
            if (r6 == 0) goto L_0x0050
            java.lang.Integer r6 = r36.getLocationSchedulingTime()
            java.lang.Integer r8 = r3.getLocationSchedulingTime()
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r8)
            r6 = r6 ^ r7
            if (r6 == 0) goto L_0x006b
        L_0x0050:
            java.lang.Boolean r6 = r36.isLocationEnable()
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            boolean r6 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r8)
            if (r6 == 0) goto L_0x0066
            java.lang.Integer r6 = r36.getLocationSchedulingTime()
            r3.setLocationSchedulingTime(r6)
            com.paytm.signallocation.a.a r3 = r1.f43597b
            goto L_0x006b
        L_0x0066:
            android.content.Context r3 = r1.f43602h
            r1.a((android.content.Context) r3)
        L_0x006b:
            com.paytm.signal.b.a r3 = r1.f43596a
            if (r3 == 0) goto L_0x0072
            r3.a((com.paytm.signal.models.Config) r0)
        L_0x0072:
            boolean r3 = k
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r0.setShowDebugLogs$paytmnotification_paytmRelease(r3)
            com.paytm.signal.b.a r3 = r1.f43596a
            if (r3 == 0) goto L_0x0082
            r3.a()
        L_0x0082:
            boolean r3 = r1.f43601g
            if (r3 != 0) goto L_0x01f4
            com.paytm.signal.b.b r3 = r1.f43600f
            if (r3 == 0) goto L_0x01b9
            com.paytm.signal.c r6 = com.paytm.signal.c.f43614a
            android.content.Context r8 = r1.f43602h
            com.paytm.signal.data.c r6 = r6.b(r8)
            java.lang.String r8 = "config"
            kotlin.g.b.k.c(r0, r8)
            java.lang.String r8 = "configPreferenceStore"
            kotlin.g.b.k.c(r6, r8)
            java.lang.String r0 = r36.getUserId$paytmnotification_paytmRelease()     // Catch:{ Exception -> 0x01b1 }
            if (r0 == 0) goto L_0x01b9
            java.util.Locale r0 = com.paytm.signal.b.b.b()     // Catch:{ Exception -> 0x01b1 }
            android.content.SharedPreferences r8 = r6.a()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r5 = r8.getString(r2, r5)     // Catch:{ Exception -> 0x01b1 }
            if (r0 == 0) goto L_0x01b9
            r8 = r5
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ Exception -> 0x01b1 }
            if (r8 == 0) goto L_0x00be
            int r8 = r8.length()     // Catch:{ Exception -> 0x01b1 }
            if (r8 != 0) goto L_0x00bc
            goto L_0x00be
        L_0x00bc:
            r8 = 0
            goto L_0x00bf
        L_0x00be:
            r8 = 1
        L_0x00bf:
            if (r8 != 0) goto L_0x00cc
            java.lang.String r8 = r0.toString()     // Catch:{ Exception -> 0x01b1 }
            boolean r5 = kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.Object) r8)     // Catch:{ Exception -> 0x01b1 }
            r5 = r5 ^ r7
            if (r5 == 0) goto L_0x01b9
        L_0x00cc:
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x01b1 }
            android.content.SharedPreferences r6 = r6.a()     // Catch:{ Exception -> 0x01b1 }
            android.content.SharedPreferences$Editor r6 = r6.edit()     // Catch:{ Exception -> 0x01b1 }
            android.content.SharedPreferences$Editor r2 = r6.putString(r2, r5)     // Catch:{ Exception -> 0x01b1 }
            r2.apply()     // Catch:{ Exception -> 0x01b1 }
            com.paytm.signal.models.LanguageEvent r2 = new com.paytm.signal.models.LanguageEvent     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r9 = r0.getLanguage()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r10 = r0.getISO3Language()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r11 = r0.getCountry()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r12 = r0.getISO3Country()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r13 = r0.getDisplayCountry()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r14 = r0.getDisplayName()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r15 = r0.toString()     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r16 = r0.getDisplayLanguage()     // Catch:{ Exception -> 0x01b1 }
            r8 = r2
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x01b1 }
            com.paytm.signal.models.SignalEvent r0 = new com.paytm.signal.models.SignalEvent     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r9 = "device_language"
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r32 = 0
            r33 = 16777212(0xfffffc, float:2.3509881E-38)
            r34 = 0
            r8 = r0
            r10 = r2
            r8.<init>(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r2 = "signalEvent"
            kotlin.g.b.k.c(r0, r2)     // Catch:{ Exception -> 0x01b1 }
            boolean r2 = r3.a((com.paytm.signal.models.SignalEvent) r0)     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            if (r2 == 0) goto L_0x01b9
            java.lang.Integer r0 = r0.getPriority()     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            if (r0 != 0) goto L_0x014d
            goto L_0x0159
        L_0x014d:
            int r0 = r0.intValue()     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            r2 = 100
            if (r0 != r2) goto L_0x0159
            r3.a()     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            goto L_0x01b9
        L_0x0159:
            com.paytm.signal.b.a r0 = r3.f43606a     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            com.paytm.signal.models.Config r0 = r0.f43603a     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            java.lang.Integer r0 = r0.getUploadFrequency()     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            if (r0 == 0) goto L_0x0168
            int r0 = r0.intValue()     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            goto L_0x0169
        L_0x0168:
            r0 = 0
        L_0x0169:
            if (r0 > 0) goto L_0x016e
            r5 = 10000(0x2710, double:4.9407E-320)
            goto L_0x0184
        L_0x016e:
            com.paytm.signal.b.a r0 = r3.f43606a     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            com.paytm.signal.models.Config r0 = r0.f43603a     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            java.lang.Integer r0 = r0.getUploadFrequency()     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            if (r0 != 0) goto L_0x017b
            kotlin.g.b.k.a()     // Catch:{ a -> 0x0196, Exception -> 0x018a }
        L_0x017b:
            int r0 = r0.intValue()     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            long r5 = (long) r0     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            r8 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 * r8
        L_0x0184:
            com.paytm.signal.schedulers.a r0 = r3.f43607b     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            r0.a(r5)     // Catch:{ a -> 0x0196, Exception -> 0x018a }
            goto L_0x01b9
        L_0x018a:
            r0 = move-exception
            r0.printStackTrace()     // Catch:{ Exception -> 0x01b1 }
            com.paytm.notification.b.e$b r2 = com.paytm.notification.b.e.f43014a     // Catch:{ Exception -> 0x01b1 }
            java.lang.Throwable r0 = (java.lang.Throwable) r0     // Catch:{ Exception -> 0x01b1 }
            r2.b(r0)     // Catch:{ Exception -> 0x01b1 }
            goto L_0x01b9
        L_0x0196:
            r0 = move-exception
            com.paytm.notification.b.e$b r2 = com.paytm.notification.b.e.f43014a     // Catch:{ Exception -> 0x01b1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r5 = "DoNotRetryException "
            r3.<init>(r5)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ Exception -> 0x01b1 }
            r3.append(r0)     // Catch:{ Exception -> 0x01b1 }
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x01b1 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x01b1 }
            r2.a(r0, r3)     // Catch:{ Exception -> 0x01b1 }
            goto L_0x01b9
        L_0x01b1:
            r0 = move-exception
            com.paytm.notification.b.e$b r2 = com.paytm.notification.b.e.f43014a
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r2.b(r0)
        L_0x01b9:
            com.paytm.signal.schedulers.c r0 = com.paytm.signal.schedulers.c.f43662a
            android.content.Context r0 = r1.f43602h
            com.paytm.signal.schedulers.c.a((android.content.Context) r0)
            com.paytm.signal.b.a r0 = r1.f43596a
            if (r0 == 0) goto L_0x01d3
            com.paytm.signal.models.Config r0 = r0.f43603a
            if (r0 == 0) goto L_0x01d3
            java.lang.Integer r0 = r0.getTimeSyncFrequency()
            if (r0 == 0) goto L_0x01d3
            int r0 = r0.intValue()
            goto L_0x01d4
        L_0x01d3:
            r0 = 0
        L_0x01d4:
            if (r0 > 0) goto L_0x01da
            r2 = 900000(0xdbba0, double:4.44659E-318)
            goto L_0x01ed
        L_0x01da:
            com.paytm.signal.b.a r0 = r1.f43596a
            if (r0 == 0) goto L_0x01ec
            com.paytm.signal.models.Config r0 = r0.f43603a
            if (r0 == 0) goto L_0x01ec
            java.lang.Integer r0 = r0.getTimeSyncFrequency()
            if (r0 == 0) goto L_0x01ec
            int r4 = r0.intValue()
        L_0x01ec:
            long r2 = (long) r4
        L_0x01ed:
            com.paytm.signal.schedulers.a r0 = r1.f43599d
            if (r0 == 0) goto L_0x01f4
            r0.b(r2)
        L_0x01f4:
            r1.f43601g = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.signal.b.a(com.paytm.signal.b, com.paytm.signal.models.Config):void");
    }

    public static final /* synthetic */ void a(b bVar, SignalEvent signalEvent) {
        try {
            com.paytm.signal.b.b bVar2 = bVar.f43600f;
            if (bVar2 != null) {
                k.c(signalEvent, "signalEvent");
                try {
                    if (bVar2.a(signalEvent)) {
                    }
                } catch (com.paytm.notification.schedulers.a.a e2) {
                    e.b bVar3 = e.f43014a;
                    bVar3.a("DoNotRetryException " + e2.getLocalizedMessage(), new Object[0]);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    e.f43014a.b(e3);
                }
            }
        } catch (Exception e4) {
            e.f43014a.b(e4);
        }
    }

    public static final /* synthetic */ void d(b bVar) {
        try {
            com.paytm.signal.b.b bVar2 = bVar.f43600f;
            if (bVar2 != null) {
                bVar2.a();
            }
        } catch (Exception e2) {
            e.f43014a.b(e2);
        }
    }

    public static final /* synthetic */ void a(b bVar, String str) {
        com.paytm.signal.b.a aVar = bVar.f43596a;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public static final /* synthetic */ void e(b bVar) {
        com.paytm.signal.b.a aVar = bVar.f43596a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static final /* synthetic */ void a(b bVar, String[] strArr, int[] iArr) {
        com.paytm.signallocation.a.a aVar = bVar.f43597b;
        if (aVar != null) {
            aVar.a(bVar.f43602h, strArr, iArr);
        }
    }
}
