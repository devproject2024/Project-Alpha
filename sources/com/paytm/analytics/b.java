package com.paytm.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import androidx.work.v;
import com.paytm.analytics.b.a;
import com.paytm.analytics.c.a;
import com.paytm.analytics.models.Config;
import com.paytm.analytics.models.LanguageEvent;
import com.paytm.analytics.models.PaytmLocation;
import com.paytm.analytics.models.SignalEvent;
import easypay.manager.Constants;
import java.util.Locale;
import kotlin.ResultKt;
import kotlin.d.b.a.f;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.g;
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
    public static final C0683b f40911e = new C0683b((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static volatile b f40912i;
    /* access modifiers changed from: private */
    public static boolean j;
    /* access modifiers changed from: private */
    public static boolean k;
    /* access modifiers changed from: private */
    public static a l;

    /* renamed from: a  reason: collision with root package name */
    public a f40913a;

    /* renamed from: b  reason: collision with root package name */
    public com.paytm.location.a.a f40914b;

    /* renamed from: c  reason: collision with root package name */
    public com.paytm.analytics.data.a f40915c;

    /* renamed from: d  reason: collision with root package name */
    public com.paytm.analytics.schedulers.a f40916d;

    /* renamed from: f  reason: collision with root package name */
    private com.paytm.analytics.b.b f40917f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f40918g;

    /* renamed from: h  reason: collision with root package name */
    private final Context f40919h;

    private b(Context context) {
        this.f40919h = context;
    }

    public /* synthetic */ b(Context context, byte b2) {
        this(context);
    }

    private final void a(Context context) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new c(this, context, (d) null), 2, (Object) null);
    }

    /* renamed from: com.paytm.analytics.b$b  reason: collision with other inner class name */
    public static final class C0683b {
        private C0683b() {
        }

        public /* synthetic */ C0683b(byte b2) {
            this();
        }

        /* renamed from: com.paytm.analytics.b$b$c */
        public static final class c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f40927a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f40928b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f40929c = false;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ long f40930d;

            public c(a aVar, Context context, long j) {
                this.f40927a = aVar;
                this.f40928b = context;
                this.f40930d = j;
            }

            public final void run() {
                C0683b bVar = b.f40911e;
                b.l = this.f40927a;
                C0683b bVar2 = b.f40911e;
                C0683b.a(this.f40928b, this.f40929c);
                long currentTimeMillis = System.currentTimeMillis() - this.f40930d;
                StringBuilder sb = new StringBuilder("***** init() worker thread took [");
                sb.append(currentTimeMillis);
                sb.append("] ms ***** ");
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:26:0x006f, code lost:
            r3 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0070, code lost:
            r4 = com.paytm.analytics.b.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x0074, code lost:
            if (r4 != null) goto L_0x0076;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x0076, code lost:
            com.paytm.analytics.b.c(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x0079, code lost:
            com.paytm.analytics.b.a((com.paytm.analytics.b) null);
            com.paytm.a.a.b.f40832a.b(r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        static void a(android.content.Context r3, boolean r4) {
            /*
                r0 = 0
                com.paytm.analytics.b.j = r0     // Catch:{ Exception -> 0x006f }
                com.paytm.analytics.b r1 = com.paytm.analytics.b.f40912i     // Catch:{ Exception -> 0x006f }
                if (r1 != 0) goto L_0x0084
                java.lang.Class<com.paytm.analytics.b> r1 = com.paytm.analytics.b.class
                monitor-enter(r1)     // Catch:{ Exception -> 0x006f }
                com.paytm.analytics.b$b r2 = com.paytm.analytics.b.f40911e     // Catch:{ all -> 0x006c }
                com.paytm.analytics.b r2 = com.paytm.analytics.b.f40912i     // Catch:{ all -> 0x006c }
                if (r2 != 0) goto L_0x0068
                com.paytm.analytics.b$b r2 = com.paytm.analytics.b.f40911e     // Catch:{ all -> 0x006c }
                com.paytm.analytics.b.k = r4     // Catch:{ all -> 0x006c }
                if (r4 == 0) goto L_0x0029
                com.paytm.a.a.b$b r4 = com.paytm.a.a.b.f40832a     // Catch:{ all -> 0x006c }
                com.paytm.a.a.b$a r2 = new com.paytm.a.a.b$a     // Catch:{ all -> 0x006c }
                r2.<init>()     // Catch:{ all -> 0x006c }
                com.paytm.a.a.b$c r2 = (com.paytm.a.a.b.c) r2     // Catch:{ all -> 0x006c }
                r4.a((com.paytm.a.a.b.c) r2)     // Catch:{ all -> 0x006c }
                goto L_0x0035
            L_0x0029:
                com.paytm.a.a.b$b r4 = com.paytm.a.a.b.f40832a     // Catch:{ all -> 0x006c }
                com.paytm.a.a.a r2 = new com.paytm.a.a.a     // Catch:{ all -> 0x006c }
                r2.<init>()     // Catch:{ all -> 0x006c }
                com.paytm.a.a.b$c r2 = (com.paytm.a.a.b.c) r2     // Catch:{ all -> 0x006c }
                r4.a((com.paytm.a.a.b.c) r2)     // Catch:{ all -> 0x006c }
            L_0x0035:
                if (r3 != 0) goto L_0x0041
                com.paytm.a.a.b$b r3 = com.paytm.a.a.b.f40832a     // Catch:{ all -> 0x006c }
                java.lang.String r4 = "Context is null. PAI Signal init failed. "
                java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x006c }
                r3.a(r4, r0)     // Catch:{ all -> 0x006c }
                goto L_0x0068
            L_0x0041:
                com.paytm.analytics.b$b r4 = com.paytm.analytics.b.f40911e     // Catch:{ all -> 0x006c }
                com.paytm.analytics.b r4 = new com.paytm.analytics.b     // Catch:{ all -> 0x006c }
                android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x006c }
                java.lang.String r2 = "context.applicationContext"
                kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.String) r2)     // Catch:{ all -> 0x006c }
                r4.<init>(r3, r0)     // Catch:{ all -> 0x006c }
                com.paytm.analytics.b.f40912i = r4     // Catch:{ all -> 0x006c }
                com.paytm.analytics.b$b r3 = com.paytm.analytics.b.f40911e     // Catch:{ all -> 0x006c }
                com.paytm.analytics.b r3 = com.paytm.analytics.b.f40912i     // Catch:{ all -> 0x006c }
                if (r3 == 0) goto L_0x005f
                com.paytm.analytics.b.b((com.paytm.analytics.b) r3)     // Catch:{ all -> 0x006c }
            L_0x005f:
                com.paytm.a.a.b$b r3 = com.paytm.a.a.b.f40832a     // Catch:{ all -> 0x006c }
                java.lang.String r4 = "PAI Signal initialized..."
                java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch:{ all -> 0x006c }
                r3.a(r4, r0)     // Catch:{ all -> 0x006c }
            L_0x0068:
                kotlin.x r3 = kotlin.x.f47997a     // Catch:{ all -> 0x006c }
                monitor-exit(r1)     // Catch:{ Exception -> 0x006f }
                return
            L_0x006c:
                r3 = move-exception
                monitor-exit(r1)     // Catch:{ Exception -> 0x006f }
                throw r3     // Catch:{ Exception -> 0x006f }
            L_0x006f:
                r3 = move-exception
                com.paytm.analytics.b r4 = com.paytm.analytics.b.f40912i
                if (r4 == 0) goto L_0x0079
                com.paytm.analytics.b.c(r4)
            L_0x0079:
                r4 = 0
                com.paytm.analytics.b.f40912i = r4
                com.paytm.a.a.b$b r4 = com.paytm.a.a.b.f40832a
                java.lang.Throwable r3 = (java.lang.Throwable) r3
                r4.b(r3)
            L_0x0084:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.analytics.b.C0683b.a(android.content.Context, boolean):void");
        }

        public static boolean a() {
            boolean z;
            synchronized (b.class) {
                C0683b bVar = b.f40911e;
                z = b.f40912i != null && !b.j;
            }
            return z;
        }

        public static b a(Context context) {
            b a2;
            synchronized (b.class) {
                C0683b bVar = b.f40911e;
                if (b.f40912i == null && context != null) {
                    Config b2 = c.f40931a.b(context).b();
                    C0683b bVar2 = b.f40911e;
                    a(context, k.a((Object) b2 != null ? b2.getShowDebugLogs$paytmanalytics_release() : null, (Object) Boolean.TRUE));
                }
                C0683b bVar3 = b.f40911e;
                a2 = b.f40912i;
            }
            return a2;
        }

        public static void a(Config config) {
            k.c(config, Constants.EASY_PAY_CONFIG_PREF_KEY);
            long currentTimeMillis = System.currentTimeMillis();
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new g(config, currentTimeMillis, (kotlin.d.d) null), 2, (Object) null);
            StringBuilder sb = new StringBuilder("***** updateConfig() UI thread took [");
            sb.append(System.currentTimeMillis() - currentTimeMillis);
            sb.append("] ms ***** ");
        }

        public static void a(SignalEvent signalEvent) {
            k.c(signalEvent, "signalEvent");
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new f(signalEvent, (kotlin.d.d) null), 2, (Object) null);
        }

        public static void b() {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new e((kotlin.d.d) null), 2, (Object) null);
        }

        public static void c() {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new a((kotlin.d.d) null), 2, (Object) null);
        }

        @kotlin.d.b.a.f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.analytics.PaytmSignal$Companion$disable$1")
        /* renamed from: com.paytm.analytics.b$b$a */
        static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            int label;
            private CoroutineScope p$;

            a(kotlin.d.d dVar) {
                super(2, dVar);
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                a aVar = new a(dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label == 0) {
                    ResultKt.a(obj);
                    b.j = true;
                    synchronized (b.class) {
                        C0683b bVar = b.f40911e;
                        b a2 = b.f40912i;
                        if (a2 != null) {
                            b.c(a2);
                        }
                        C0683b bVar2 = b.f40911e;
                        b.f40912i = null;
                        x xVar = x.f47997a;
                    }
                    return x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @kotlin.d.b.a.f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.analytics.PaytmSignal$Companion$getLastKnownLocation$1")
        /* renamed from: com.paytm.analytics.b$b$b  reason: collision with other inner class name */
        public static final class C0684b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            final /* synthetic */ d $locationCallback;
            int label;
            private CoroutineScope p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public C0684b(d dVar, kotlin.d.d dVar2) {
                super(2, dVar2);
                this.$locationCallback = dVar;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                C0684b bVar = new C0684b(this.$locationCallback, dVar);
                bVar.p$ = (CoroutineScope) obj;
                return bVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C0684b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label == 0) {
                    ResultKt.a(obj);
                    synchronized (b.class) {
                        C0683b bVar = b.f40911e;
                        b a2 = b.f40912i;
                        if (a2 != null) {
                            b.a(a2, this.$locationCallback);
                            x xVar = x.f47997a;
                        }
                    }
                    return x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @kotlin.d.b.a.f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.analytics.PaytmSignal$Companion$login$1")
        /* renamed from: com.paytm.analytics.b$b$d */
        public static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            final /* synthetic */ String $userId;
            int label;
            private CoroutineScope p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public d(String str, kotlin.d.d dVar) {
                super(2, dVar);
                this.$userId = str;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                d dVar2 = new d(this.$userId, dVar);
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
                        C0683b bVar = b.f40911e;
                        b a2 = b.f40912i;
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

        @kotlin.d.b.a.f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.analytics.PaytmSignal$Companion$logout$1")
        /* renamed from: com.paytm.analytics.b$b$e */
        static final class e extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            int label;
            private CoroutineScope p$;

            e(kotlin.d.d dVar) {
                super(2, dVar);
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                e eVar = new e(dVar);
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
                        C0683b bVar = b.f40911e;
                        b a2 = b.f40912i;
                        if (a2 != null) {
                            b.d(a2);
                            x xVar = x.f47997a;
                        }
                    }
                    return x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @kotlin.d.b.a.f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.analytics.PaytmSignal$Companion$pushEvent$1")
        /* renamed from: com.paytm.analytics.b$b$f */
        static final class f extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            final /* synthetic */ SignalEvent $signalEvent;
            int label;
            private CoroutineScope p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(SignalEvent signalEvent, kotlin.d.d dVar) {
                super(2, dVar);
                this.$signalEvent = signalEvent;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                f fVar = new f(this.$signalEvent, dVar);
                fVar.p$ = (CoroutineScope) obj;
                return fVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((f) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label == 0) {
                    ResultKt.a(obj);
                    synchronized (b.class) {
                        C0683b bVar = b.f40911e;
                        b a2 = b.f40912i;
                        if (a2 != null) {
                            b.a(a2, this.$signalEvent);
                            x xVar = x.f47997a;
                        }
                    }
                    return x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @kotlin.d.b.a.f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.analytics.PaytmSignal$Companion$updateConfig$1")
        /* renamed from: com.paytm.analytics.b$b$g */
        static final class g extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            final /* synthetic */ Config $config;
            final /* synthetic */ long $initTime;
            int label;
            private CoroutineScope p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(Config config, long j, kotlin.d.d dVar) {
                super(2, dVar);
                this.$config = config;
                this.$initTime = j;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                g gVar = new g(this.$config, this.$initTime, dVar);
                gVar.p$ = (CoroutineScope) obj;
                return gVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((g) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label == 0) {
                    ResultKt.a(obj);
                    synchronized (b.class) {
                        C0683b bVar = b.f40911e;
                        b a2 = b.f40912i;
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
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new C0682a((d) null), 2, (Object) null);
        }

        @f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.analytics.PaytmSignal$ActivityListener$onActivityPaused$1")
        /* renamed from: com.paytm.analytics.b$a$a  reason: collision with other inner class name */
        static final class C0682a extends kotlin.d.b.a.k implements m<CoroutineScope, d<? super x>, Object> {
            int label;
            private CoroutineScope p$;

            C0682a(d dVar) {
                super(2, dVar);
            }

            public final d<x> create(Object obj, d<?> dVar) {
                k.c(dVar, "completion");
                C0682a aVar = new C0682a(dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((C0682a) create(obj, (d) obj2)).invokeSuspend(x.f47997a);
            }

            public final Object invokeSuspend(Object obj) {
                Config config;
                com.paytm.analytics.data.a aVar;
                com.paytm.analytics.b.a aVar2;
                kotlin.d.a.a aVar3 = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label == 0) {
                    ResultKt.a(obj);
                    try {
                        com.paytm.a.a.b.f40832a.a("onActivityPaused: send signal events", new Object[0]);
                        C0683b bVar = b.f40911e;
                        b a2 = b.f40912i;
                        com.paytm.analytics.schedulers.a aVar4 = null;
                        if (a2 == null || (aVar2 = a2.f40913a) == null) {
                            config = null;
                        } else {
                            config = aVar2.f40920a;
                        }
                        C0683b bVar2 = b.f40911e;
                        b a3 = b.f40912i;
                        if (a3 != null) {
                            aVar = a3.f40915c;
                        } else {
                            aVar = null;
                        }
                        if (!(config == null || aVar == null)) {
                            com.paytm.analytics.schedulers.b bVar3 = com.paytm.analytics.schedulers.b.f40976a;
                            C0683b bVar4 = b.f40911e;
                            b a4 = b.f40912i;
                            if (a4 != null) {
                                aVar4 = a4.f40916d;
                            }
                            com.paytm.analytics.schedulers.b.a(config, aVar, aVar4, false);
                        }
                    } catch (com.paytm.a.a e2) {
                        com.paytm.a.a.b.f40832a.a("error occured while sending events on onActivityPaused " + e2.getLocalizedMessage(), new Object[0]);
                    }
                    return x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }

    public static final /* synthetic */ void b(b bVar) {
        com.paytm.analytics.c.a aVar;
        bVar.f40915c = c.f40931a.a(bVar.f40919h);
        com.paytm.analytics.data.c b2 = c.f40931a.b(bVar.f40919h);
        bVar.f40916d = new com.paytm.analytics.schedulers.a(bVar.f40919h);
        bVar.f40913a = new com.paytm.analytics.b.a(b2, bVar.f40919h);
        com.paytm.analytics.b.a aVar2 = bVar.f40913a;
        if (aVar2 == null) {
            k.a();
        }
        com.paytm.analytics.schedulers.a aVar3 = bVar.f40916d;
        if (aVar3 == null) {
            k.a();
        }
        com.paytm.analytics.data.a aVar4 = bVar.f40915c;
        if (aVar4 == null) {
            k.a();
        }
        bVar.f40917f = new com.paytm.analytics.b.b(aVar2, aVar3, aVar4);
        com.paytm.location.a.b bVar2 = com.paytm.location.a.b.f42840a;
        com.paytm.analytics.b.a aVar5 = bVar.f40913a;
        if (aVar5 == null) {
            k.a();
        }
        com.paytm.analytics.schedulers.a aVar6 = bVar.f40916d;
        if (aVar6 == null) {
            k.a();
        }
        com.paytm.analytics.b.b bVar3 = bVar.f40917f;
        if (bVar3 == null) {
            k.a();
        }
        bVar.f40914b = bVar2.a(aVar5, aVar6, bVar3, b2);
        com.paytm.analytics.b.a aVar7 = bVar.f40913a;
        if (aVar7 != null) {
            aVar7.a(bVar.f40919h);
        }
        a.C0685a aVar8 = com.paytm.analytics.c.a.f40935d;
        Context context = bVar.f40919h;
        k.c(context, "context");
        if (com.paytm.analytics.c.a.j != null) {
            aVar = com.paytm.analytics.c.a.j;
            if (aVar == null) {
                throw new u("null cannot be cast to non-null type com.paytm.analytics.util.ActivityMonitor");
            }
        } else {
            com.paytm.analytics.c.a.j = new com.paytm.analytics.c.a((byte) 0);
            com.paytm.analytics.c.a a2 = com.paytm.analytics.c.a.j;
            if (a2 == null) {
                k.a();
            }
            k.c(context, "context");
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                ((Application) applicationContext).registerActivityLifecycleCallbacks(a2.f40938c);
                aVar = com.paytm.analytics.c.a.j;
                if (aVar == null) {
                    throw new u("null cannot be cast to non-null type com.paytm.analytics.util.ActivityMonitor");
                }
            } else {
                throw new u("null cannot be cast to non-null type android.app.Application");
            }
        }
        a.b aVar9 = new a();
        k.c(aVar9, "listener");
        synchronized (aVar.f40936a) {
            aVar.f40936a.add(aVar9);
        }
        bVar.f40918g = false;
    }

    @f(b = "PaytmSignal.kt", c = {}, d = "invokeSuspend", e = "com.paytm.analytics.PaytmSignal$closeLocationService$1")
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
            com.paytm.location.a.a aVar;
            kotlin.d.a.a aVar2 = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label == 0) {
                ResultKt.a(obj);
                try {
                    if (!(this.$context == null || (aVar = this.this$0.f40914b) == null)) {
                        aVar.d();
                    }
                } catch (Exception e2) {
                    com.paytm.a.a.b.f40832a.b(e2);
                }
                return x.f47997a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final /* synthetic */ void c(b bVar) {
        try {
            com.paytm.analytics.schedulers.a aVar = bVar.f40916d;
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
            bVar.a(bVar.f40919h);
        } catch (Exception e3) {
            com.paytm.a.a.b.f40832a.b(e3);
        }
    }

    public static final /* synthetic */ void a(b bVar, Config config) {
        Config config2;
        long j2;
        Config config3;
        Integer timeSyncFrequency;
        Config config4;
        Integer timeSyncFrequency2;
        boolean z;
        b bVar2 = bVar;
        Config config5 = config;
        int i2 = 0;
        com.paytm.a.a.b.f40832a.a("Paytm analytics update config.... ", new Object[0]);
        com.paytm.analytics.b.a aVar = bVar2.f40913a;
        if (aVar != null) {
            config2 = aVar.f40920a;
        } else {
            config2 = null;
        }
        if (!(config.isLocationEnable() == null || config2 == null || (bVar2.f40918g && config2.isLocationEnable() != null && !(!k.a((Object) config.isLocationEnable(), (Object) config2.isLocationEnable())) && config2.getLocationSchedulingTime() != null && !(!k.a((Object) config.getLocationSchedulingTime(), (Object) config2.getLocationSchedulingTime()))))) {
            if (k.a((Object) config.isLocationEnable(), (Object) Boolean.TRUE)) {
                config2.setLocationSchedulingTime(config.getLocationSchedulingTime());
                com.paytm.location.a.a aVar2 = bVar2.f40914b;
                if (aVar2 != null) {
                    aVar2.c();
                }
            } else {
                bVar2.a(bVar2.f40919h);
            }
        }
        com.paytm.analytics.b.a aVar3 = bVar2.f40913a;
        if (aVar3 != null) {
            aVar3.a(config5);
        }
        config5.setShowDebugLogs$paytmanalytics_release(Boolean.valueOf(k));
        com.paytm.analytics.b.a aVar4 = bVar2.f40913a;
        if (aVar4 != null) {
            aVar4.a();
        }
        com.paytm.location.a.a aVar5 = bVar2.f40914b;
        if (aVar5 != null) {
            aVar5.b();
        }
        if (!bVar2.f40918g) {
            com.paytm.analytics.b.b bVar3 = bVar2.f40917f;
            if (bVar3 != null) {
                com.paytm.location.a.a aVar6 = bVar2.f40914b;
                PaytmLocation a2 = aVar6 != null ? aVar6.a() : null;
                com.paytm.analytics.data.c b2 = c.f40931a.b(bVar2.f40919h);
                k.c(config5, Constants.EASY_PAY_CONFIG_PREF_KEY);
                k.c(b2, "configPreferenceStore");
                try {
                    if (config.getUserId$paytmanalytics_release() != null) {
                        Locale a3 = com.paytm.analytics.b.b.a();
                        String string = b2.a().getString("os_language", (String) null);
                        if (a3 != null) {
                            CharSequence charSequence = string;
                            if (charSequence != null) {
                                if (charSequence.length() != 0) {
                                    z = false;
                                    if (z || (!k.a((Object) string, (Object) a3.toString()))) {
                                        b2.a().edit().putString("os_language", a3.toString()).apply();
                                        bVar3.a(new SignalEvent("device_language", new LanguageEvent(a3.getLanguage(), a3.getISO3Language(), a3.getCountry(), a3.getISO3Country(), a3.getDisplayCountry(), a3.getDisplayName(), a3.toString(), a3.getDisplayLanguage()), (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16777212, (g) null), a2);
                                    }
                                }
                            }
                            z = true;
                            b2.a().edit().putString("os_language", a3.toString()).apply();
                            bVar3.a(new SignalEvent("device_language", new LanguageEvent(a3.getLanguage(), a3.getISO3Language(), a3.getCountry(), a3.getISO3Country(), a3.getDisplayCountry(), a3.getDisplayName(), a3.toString(), a3.getDisplayLanguage()), (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (Integer) null, (Long) null, (String) null, (String) null, (Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 16777212, (g) null), a2);
                        }
                    }
                } catch (Exception e2) {
                    com.paytm.a.a.b.f40832a.b(e2);
                }
            }
            com.paytm.analytics.schedulers.c cVar = com.paytm.analytics.schedulers.c.f40979a;
            com.paytm.analytics.schedulers.c.a(bVar2.f40919h);
            com.paytm.analytics.b.a aVar7 = bVar2.f40913a;
            if (((aVar7 == null || (config4 = aVar7.f40920a) == null || (timeSyncFrequency2 = config4.getTimeSyncFrequency()) == null) ? 0 : timeSyncFrequency2.intValue()) <= 0) {
                j2 = 900000;
            } else {
                com.paytm.analytics.b.a aVar8 = bVar2.f40913a;
                if (!(aVar8 == null || (config3 = aVar8.f40920a) == null || (timeSyncFrequency = config3.getTimeSyncFrequency()) == null)) {
                    i2 = timeSyncFrequency.intValue();
                }
                j2 = (long) i2;
            }
            com.paytm.analytics.schedulers.a aVar9 = bVar2.f40916d;
            if (aVar9 != null) {
                aVar9.b(j2);
            }
        }
        bVar2.f40918g = true;
    }

    public static final /* synthetic */ void a(b bVar, SignalEvent signalEvent) {
        try {
            com.paytm.analytics.b.b bVar2 = bVar.f40917f;
            if (bVar2 != null) {
                com.paytm.location.a.a aVar = bVar.f40914b;
                bVar2.a(signalEvent, aVar != null ? aVar.a() : null);
            }
        } catch (Exception e2) {
            com.paytm.a.a.b.f40832a.b(e2);
        }
    }

    public static final /* synthetic */ void a(b bVar, String str) {
        com.paytm.analytics.b.a aVar = bVar.f40913a;
        if (aVar != null) {
            aVar.a(str);
        }
    }

    public static final /* synthetic */ void d(b bVar) {
        com.paytm.analytics.b.a aVar = bVar.f40913a;
        if (aVar != null) {
            aVar.b();
        }
    }

    public static final /* synthetic */ void a(b bVar, d dVar) {
        com.paytm.location.a.a aVar = bVar.f40914b;
        PaytmLocation paytmLocation = null;
        if ((aVar != null ? aVar.a() : null) != null) {
            com.paytm.location.a.a aVar2 = bVar.f40914b;
            PaytmLocation a2 = aVar2 != null ? aVar2.a() : null;
            if (a2 == null) {
                k.a();
            }
            Float latitude = a2.getLatitude();
            if (latitude == null) {
                k.a();
            }
            if (Float.compare(latitude.floatValue(), 0.0f) != 0) {
                com.paytm.location.a.a aVar3 = bVar.f40914b;
                if (aVar3 != null) {
                    paytmLocation = aVar3.a();
                }
                if (paytmLocation == null) {
                    k.a();
                }
                dVar.a(paytmLocation);
                return;
            }
        }
        com.paytm.location.a.a aVar4 = bVar.f40914b;
        if (aVar4 != null) {
            aVar4.a(dVar);
        }
    }
}
