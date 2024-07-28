package com.paytm.notification;

import android.app.Activity;
import android.content.Context;
import com.paytm.notification.a;
import com.paytm.notification.b.e;
import com.paytm.notification.d;
import com.paytm.notification.data.datasource.dao.l;
import com.paytm.notification.f;
import com.paytm.notification.i;
import com.paytm.notification.models.NotificationProjectConfig;
import com.paytm.notification.models.NotificationUserConfig;
import com.paytm.notification.models.PushConfig;
import com.paytm.notification.models.callback.ChannelProviderCallback;
import com.paytm.notification.models.callback.ChannelReadyCallback;
import com.paytm.notification.models.callback.ConfigChannelReadyCallback;
import com.paytm.notification.models.callback.ConfigReadyCallback;
import com.paytm.notification.models.callback.ErrorReportCallback;
import com.paytm.notification.models.callback.InboxHandlerReadyCallback;
import com.paytm.notification.models.callback.PushManagerReadyCallback;
import com.paytm.notification.schedulers.b;
import com.paytm.signal.b;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.ResultKt;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.h;
import kotlin.x;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final c f43191a = new c((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static Context f43192h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static volatile g f43193i;
    /* access modifiers changed from: private */
    public static boolean j;
    /* access modifiers changed from: private */
    public static ChannelProviderCallback k;
    /* access modifiers changed from: private */
    public static ErrorReportCallback l;
    /* access modifiers changed from: private */
    public static ConfigReadyCallback m;
    /* access modifiers changed from: private */
    public static ChannelReadyCallback n;
    /* access modifiers changed from: private */
    public static ConfigChannelReadyCallback o;
    /* access modifiers changed from: private */
    public static Boolean p = Boolean.FALSE;
    /* access modifiers changed from: private */
    public static Boolean q = Boolean.FALSE;
    /* access modifiers changed from: private */
    public static boolean r;
    /* access modifiers changed from: private */
    public static List<l> s;
    /* access modifiers changed from: private */
    public static final ReentrantLock t = new ReentrantLock();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Context f43194b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f43195c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f43196d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public String f43197e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public long f43198f;

    /* renamed from: g  reason: collision with root package name */
    private final kotlin.g f43199g;

    static final class b extends kotlin.g.b.l implements kotlin.g.a.a<Long> {
        public static final b INSTANCE = new b();

        b() {
            super(0);
        }

        public final long invoke() {
            return 5000;
        }
    }

    private g() {
        this.f43199g = h.a(b.INSTANCE);
    }

    public /* synthetic */ g(byte b2) {
        this();
    }

    /* access modifiers changed from: private */
    public static NotificationUserConfig p() {
        return j.f43241a.c().a();
    }

    static final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public static final d f43208a = new d();

        d() {
        }

        public final void run() {
            try {
                c cVar = g.f43191a;
                g.s = c.b();
            } catch (Exception e2) {
                com.paytm.notification.b.e.f43014a.b(e2);
            }
        }
    }

    public static e a() throws com.paytm.notification.a.a.a {
        f.a aVar = f.f43174a;
        if (f.f43175h != null) {
            return f.f43175h;
        }
        throw new com.paytm.notification.a.a.a("You need to call init() at least once to create the singleton");
    }

    public static final class c {
        private c() {
        }

        public /* synthetic */ c(byte b2) {
            this();
        }

        public static int a() {
            try {
                d.a aVar = d.f43032a;
                if (d.f43033g == null) {
                    return -1;
                }
                d.a aVar2 = d.f43032a;
                c h2 = d.f43033g;
                if (h2 == null) {
                    k.a();
                }
                return h2.d();
            } catch (Exception unused) {
                return -1;
            }
        }

        public static void a(PushManagerReadyCallback pushManagerReadyCallback) {
            k.c(pushManagerReadyCallback, "pushManagerReadyCallback");
            i.a aVar = i.f43209d;
            if (i.f43210i != null) {
                i.a aVar2 = i.f43209d;
                i d2 = i.f43210i;
                if (d2 == null) {
                    k.a();
                }
                pushManagerReadyCallback.onCallbackReady(d2);
                return;
            }
            synchronized (g.class) {
                i.a aVar3 = i.f43209d;
                if (i.f43210i != null) {
                    try {
                        i.a aVar4 = i.f43209d;
                        i d3 = i.f43210i;
                        if (d3 == null) {
                            k.a();
                        }
                        pushManagerReadyCallback.onCallbackReady(d3);
                    } catch (Exception e2) {
                        com.paytm.notification.b.e.f43014a.b(e2, "pushManagerReadyCallback.onCallbackReady() error", new Object[0]);
                    }
                } else {
                    com.paytm.notification.b.e.f43014a.d("getPushHandler() PushManager.instance == null", new Object[0]);
                }
                x xVar = x.f47997a;
            }
        }

        public static void a(InboxHandlerReadyCallback inboxHandlerReadyCallback) {
            k.c(inboxHandlerReadyCallback, "inboxHandlerReadyCallback");
            d.a aVar = d.f43032a;
            if (d.f43033g != null) {
                d.a aVar2 = d.f43032a;
                c h2 = d.f43033g;
                if (h2 == null) {
                    k.a();
                }
                inboxHandlerReadyCallback.onCallbackReady(h2);
                return;
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new a(inboxHandlerReadyCallback, (kotlin.d.d) null), 2, (Object) null);
        }

        public static List<l> b() {
            if (g.s == null) {
                g.s = j.f43241a.b().a();
            }
            List<l> c2 = g.s;
            if (c2 == null) {
                k.a();
            }
            return c2;
        }

        public static void a(String str) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new f(str, (kotlin.d.d) null), 2, (Object) null);
        }

        public static void c() {
            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), (CoroutineStart) null, new e((kotlin.d.d) null), 2, (Object) null);
        }

        public static final class b implements InboxHandlerReadyCallback {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ com.paytm.notification.schedulers.d f43201a;

            b(com.paytm.notification.schedulers.d dVar) {
                this.f43201a = dVar;
            }

            public final void onCallbackReady(c cVar) {
                k.c(cVar, "inboxHandler");
                cVar.a(this.f43201a);
            }
        }

        public static Object a(Context context, kotlin.d.d<? super g> dVar) {
            return BuildersKt.withContext(Dispatchers.getIO(), new d(context, (kotlin.d.d) null), dVar);
        }

        /* renamed from: com.paytm.notification.g$c$c  reason: collision with other inner class name */
        public static final class C0726c implements Runnable {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ErrorReportCallback f43202a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ Context f43203b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ boolean f43204c = false;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ ChannelProviderCallback f43205d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ PushConfig f43206e;

            /* renamed from: f  reason: collision with root package name */
            final /* synthetic */ NotificationProjectConfig f43207f;

            public C0726c(ErrorReportCallback errorReportCallback, Context context, ChannelProviderCallback channelProviderCallback, PushConfig pushConfig, NotificationProjectConfig notificationProjectConfig) {
                this.f43202a = errorReportCallback;
                this.f43203b = context;
                this.f43205d = channelProviderCallback;
                this.f43206e = pushConfig;
                this.f43207f = notificationProjectConfig;
            }

            public final void run() {
                e a2;
                e a3;
                synchronized (g.class) {
                    e eVar = null;
                    try {
                        c cVar = g.f43191a;
                        g.l = this.f43202a;
                        ErrorReportCallback errorReportCallback = this.f43202a;
                        if (errorReportCallback != null) {
                            errorReportCallback.onErrorLog("[PushSDK] init()");
                        }
                        c cVar2 = g.f43191a;
                        c.a(this.f43203b, this.f43204c);
                        g.k = this.f43205d;
                        c cVar3 = g.f43191a;
                        g e2 = g.f43193i;
                        if ((e2 != null ? e2.f43197e : null) != null) {
                            c cVar4 = g.f43191a;
                            c cVar5 = g.f43191a;
                            g e3 = g.f43193i;
                            String e4 = e3 != null ? e3.f43197e : null;
                            if (e4 == null) {
                                k.a();
                            }
                            c.b(e4);
                        }
                    } catch (Exception e5) {
                        com.paytm.notification.b.e.f43014a.b(e5);
                    }
                    try {
                        c cVar6 = g.f43191a;
                        if (!(g.f43193i == null || (a3 = g.a()) == null)) {
                            a3.a(this.f43206e);
                        }
                        j.f43241a.c().a(this.f43207f);
                        c cVar7 = g.f43191a;
                        if (!(g.f43193i == null || (a2 = g.a()) == null)) {
                            a2.b();
                        }
                        c cVar8 = g.f43191a;
                        if (g.f43193i != null) {
                            eVar = g.a();
                        }
                        if (eVar == null) {
                            k.a();
                        }
                        c cVar9 = g.f43191a;
                        g e6 = g.f43193i;
                        if (e6 == null) {
                            k.a();
                        }
                        eVar.a(e6, this.f43207f);
                    } catch (Exception e7) {
                        com.paytm.notification.b.e.f43014a.b(e7);
                    }
                    x xVar = x.f47997a;
                }
                return;
            }
        }

        public static void b(String str) {
            k.c(str, "channelId");
            com.paytm.notification.b.e.f43014a.a("Channel id: ".concat(String.valueOf(str)), new Object[0]);
            ChannelProviderCallback n = g.k;
            if (n != null) {
                n.onChannelCreated(str);
            }
            g.k = null;
        }

        public static boolean d() {
            c cVar = g.f43191a;
            return g.f43193i == null || g.j;
        }

        @kotlin.d.b.a.f(b = "PaytmNotifications.kt", c = {}, d = "invokeSuspend", e = "com.paytm.notification.PaytmNotifications$Companion$getInboxHandler$1")
        static final class a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            final /* synthetic */ InboxHandlerReadyCallback $inboxHandlerReadyCallback;
            int label;
            private CoroutineScope p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(InboxHandlerReadyCallback inboxHandlerReadyCallback, kotlin.d.d dVar) {
                super(2, dVar);
                this.$inboxHandlerReadyCallback = inboxHandlerReadyCallback;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                a aVar = new a(this.$inboxHandlerReadyCallback, dVar);
                aVar.p$ = (CoroutineScope) obj;
                return aVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
            }

            /* renamed from: com.paytm.notification.g$c$a$a  reason: collision with other inner class name */
            static final class C0725a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
                int label;
                private CoroutineScope p$;
                final /* synthetic */ a this$0;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0725a(kotlin.d.d dVar, a aVar) {
                    super(2, dVar);
                    this.this$0 = aVar;
                }

                public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                    k.c(dVar, "completion");
                    C0725a aVar = new C0725a(dVar, this.this$0);
                    aVar.p$ = (CoroutineScope) obj;
                    return aVar;
                }

                public final Object invoke(Object obj, Object obj2) {
                    return ((C0725a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(x.f47997a);
                }

                public final Object invokeSuspend(Object obj) {
                    kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                    if (this.label == 0) {
                        ResultKt.a(obj);
                        try {
                            InboxHandlerReadyCallback inboxHandlerReadyCallback = this.this$0.$inboxHandlerReadyCallback;
                            d.a aVar2 = d.f43032a;
                            c h2 = d.f43033g;
                            if (h2 == null) {
                                k.a();
                            }
                            inboxHandlerReadyCallback.onCallbackReady(h2);
                        } catch (Exception e2) {
                            com.paytm.notification.b.e.f43014a.b(e2, "inboxHandlerReadyCallback.onCallbackReady() error", new Object[0]);
                        }
                        return x.f47997a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }

            public final Object invokeSuspend(Object obj) {
                kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
                if (this.label == 0) {
                    ResultKt.a(obj);
                    synchronized (g.class) {
                        d.a aVar2 = d.f43032a;
                        if (d.f43033g != null) {
                            Job unused = BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new C0725a((kotlin.d.d) null, this), 2, (Object) null);
                        } else {
                            com.paytm.notification.b.e.f43014a.d("getInboxHandler() InboxMessageManager.instance == null", new Object[0]);
                            x xVar = x.f47997a;
                        }
                    }
                    return x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @kotlin.d.b.a.f(b = "PaytmNotifications.kt", c = {}, d = "invokeSuspend", e = "com.paytm.notification.PaytmNotifications$Companion$initializedInstance$2")
        static final class d extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super g>, Object> {
            final /* synthetic */ Context $context;
            int label;
            private CoroutineScope p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(Context context, kotlin.d.d dVar) {
                super(2, dVar);
                this.$context = context;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                d dVar2 = new d(this.$context, dVar);
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
                    c cVar = g.f43191a;
                    if (g.f43193i == null && this.$context != null) {
                        NotificationUserConfig a2 = j.f43241a.c().a();
                        c cVar2 = g.f43191a;
                        c.a(this.$context, k.a((Object) a2.getShowDebugLogs$paytmnotification_paytmRelease(), (Object) Boolean.TRUE));
                    }
                    c cVar3 = g.f43191a;
                    return g.f43193i;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @kotlin.d.b.a.f(b = "PaytmNotifications.kt", c = {}, d = "invokeSuspend", e = "com.paytm.notification.PaytmNotifications$Companion$logout$1")
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
                    synchronized (g.class) {
                        c cVar = g.f43191a;
                        g e2 = g.f43193i;
                        if (e2 != null) {
                            g.d(e2);
                            x xVar = x.f47997a;
                        }
                    }
                    return x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        @kotlin.d.b.a.f(b = "PaytmNotifications.kt", c = {}, d = "invokeSuspend", e = "com.paytm.notification.PaytmNotifications$Companion$updateCustomerId$1")
        static final class f extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super x>, Object> {
            final /* synthetic */ String $customerId;
            int label;
            private CoroutineScope p$;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(String str, kotlin.d.d dVar) {
                super(2, dVar);
                this.$customerId = str;
            }

            public final kotlin.d.d<x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                f fVar = new f(this.$customerId, dVar);
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
                    synchronized (g.class) {
                        try {
                            c cVar = g.f43191a;
                            ErrorReportCallback f2 = g.l;
                            if (f2 != null) {
                                f2.onErrorLog("[PushSDK] logIn()");
                            }
                            c cVar2 = g.f43191a;
                            ErrorReportCallback f3 = g.l;
                            if (f3 != null) {
                                String str = this.$customerId;
                                if (str == null) {
                                    str = "";
                                }
                                f3.onSetUserIdentifier(str);
                            }
                        } catch (Exception e2) {
                            com.paytm.notification.b.e.f43014a.b(e2);
                        }
                        c cVar3 = g.f43191a;
                        g e3 = g.f43193i;
                        if (e3 != null) {
                            g.a(e3, this.$customerId);
                            x xVar = x.f47997a;
                        }
                    }
                    return x.f47997a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(7:6|7|(12:9|(1:11)|12|(1:14)|15|(1:17)|18|(4:20|(2:22|(4:27|(1:29)|30|32)(1:26))|31|32)|33|34|35|(3:39|(1:41)|42))|43|44|45|46) */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x0144, code lost:
            r6 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x0149, code lost:
            if (com.paytm.notification.g.e() != null) goto L_0x014b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x014f, code lost:
            if (com.paytm.notification.g.e() == null) goto L_0x0151;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x0151, code lost:
            kotlin.g.b.k.a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:58:0x0154, code lost:
            com.paytm.notification.g.m();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:59:0x0157, code lost:
            com.paytm.notification.g.c((com.paytm.notification.g) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:60:0x015c, code lost:
            throw r6;
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x013c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static final /* synthetic */ void a(android.content.Context r6, boolean r7) {
            /*
                r0 = 0
                android.content.Context r1 = r6.getApplicationContext()     // Catch:{ a -> 0x0144 }
                com.paytm.notification.g.f43192h = r1     // Catch:{ a -> 0x0144 }
                com.paytm.notification.g r1 = com.paytm.notification.g.f43193i     // Catch:{ a -> 0x0144 }
                if (r1 != 0) goto L_0x0143
                java.lang.Class<com.paytm.notification.g> r1 = com.paytm.notification.g.class
                monitor-enter(r1)     // Catch:{ a -> 0x0144 }
                com.paytm.notification.g$c r2 = com.paytm.notification.g.f43191a     // Catch:{ all -> 0x0140 }
                com.paytm.notification.g r2 = com.paytm.notification.g.f43193i     // Catch:{ all -> 0x0140 }
                if (r2 != 0) goto L_0x013c
                com.paytm.notification.g$c r2 = com.paytm.notification.g.f43191a     // Catch:{ all -> 0x0140 }
                com.paytm.notification.g.r = r7     // Catch:{ all -> 0x0140 }
                com.paytm.notification.g$c r7 = com.paytm.notification.g.f43191a     // Catch:{ all -> 0x0140 }
                com.paytm.notification.g r7 = new com.paytm.notification.g     // Catch:{ all -> 0x0140 }
                r2 = 0
                r7.<init>(r2)     // Catch:{ all -> 0x0140 }
                com.paytm.notification.g.f43193i = r7     // Catch:{ all -> 0x0140 }
                com.paytm.notification.g$c r7 = com.paytm.notification.g.f43191a     // Catch:{ all -> 0x0140 }
                com.paytm.notification.g r7 = com.paytm.notification.g.f43193i     // Catch:{ all -> 0x0140 }
                if (r7 == 0) goto L_0x0038
                android.content.Context r2 = r6.getApplicationContext()     // Catch:{ all -> 0x0140 }
                r7.f43194b = r2     // Catch:{ all -> 0x0140 }
            L_0x0038:
                com.paytm.notification.g$c r7 = com.paytm.notification.g.f43191a     // Catch:{ all -> 0x0140 }
                com.paytm.notification.g r7 = com.paytm.notification.g.f43193i     // Catch:{ all -> 0x0140 }
                if (r7 == 0) goto L_0x004c
                android.content.Context r7 = r6.getApplicationContext()     // Catch:{ all -> 0x0140 }
                java.lang.String r2 = "context.applicationContext"
                kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r2)     // Catch:{ all -> 0x0140 }
                com.paytm.notification.g.b((android.content.Context) r7)     // Catch:{ all -> 0x0140 }
            L_0x004c:
                com.paytm.notification.g$c r7 = com.paytm.notification.g.f43191a     // Catch:{ all -> 0x0140 }
                com.paytm.notification.g r7 = com.paytm.notification.g.f43193i     // Catch:{ all -> 0x0140 }
                if (r7 == 0) goto L_0x0060
                android.content.Context r6 = r6.getApplicationContext()     // Catch:{ all -> 0x0140 }
                java.lang.String r2 = "context.applicationContext"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r2)     // Catch:{ all -> 0x0140 }
                com.paytm.notification.g.b(r7, r6)     // Catch:{ all -> 0x0140 }
            L_0x0060:
                java.lang.Class<com.paytm.notification.g> r6 = com.paytm.notification.g.class
                r6.getName()     // Catch:{ all -> 0x0140 }
                com.paytm.notification.j r6 = com.paytm.notification.j.f43241a     // Catch:{ all -> 0x0140 }
                com.paytm.notification.data.c.h r6 = r6.c()     // Catch:{ all -> 0x0140 }
                com.paytm.notification.models.NotificationUserConfig r6 = r6.a()     // Catch:{ all -> 0x0140 }
                java.lang.Boolean r7 = r6.getEnableInboxCountSchedule$paytmnotification_paytmRelease()     // Catch:{ all -> 0x0140 }
                java.lang.Boolean r2 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0140 }
                boolean r7 = kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.Object) r2)     // Catch:{ all -> 0x0140 }
                if (r7 == 0) goto L_0x00cf
                java.lang.Long r7 = r6.getInboxCountScheduleInterval$paytmnotification_paytmRelease()     // Catch:{ all -> 0x0140 }
                if (r7 == 0) goto L_0x00a0
                java.lang.Long r7 = r6.getInboxCountScheduleInterval$paytmnotification_paytmRelease()     // Catch:{ all -> 0x0140 }
                if (r7 == 0) goto L_0x0092
                long r2 = r7.longValue()     // Catch:{ all -> 0x0140 }
                r4 = 0
                int r7 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r7 != 0) goto L_0x0092
                goto L_0x00a0
            L_0x0092:
                java.lang.Long r6 = r6.getInboxCountScheduleInterval$paytmnotification_paytmRelease()     // Catch:{ all -> 0x0140 }
                if (r6 != 0) goto L_0x009b
                kotlin.g.b.k.a()     // Catch:{ all -> 0x0140 }
            L_0x009b:
                long r6 = r6.longValue()     // Catch:{ all -> 0x0140 }
                goto L_0x00a8
            L_0x00a0:
                java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.HOURS     // Catch:{ all -> 0x0140 }
                r2 = 4
                long r6 = r6.toMillis(r2)     // Catch:{ all -> 0x0140 }
            L_0x00a8:
                com.paytm.notification.schedulers.d$a r2 = new com.paytm.notification.schedulers.d$a     // Catch:{ all -> 0x0140 }
                r2.<init>()     // Catch:{ all -> 0x0140 }
                com.paytm.notification.schedulers.c$a$a r3 = com.paytm.notification.schedulers.c.a.f43288a     // Catch:{ all -> 0x0140 }
                int r3 = com.paytm.notification.schedulers.c.a.C0730a.b()     // Catch:{ all -> 0x0140 }
                r2.f43305b = r3     // Catch:{ all -> 0x0140 }
                com.paytm.notification.schedulers.c$b$a r3 = com.paytm.notification.schedulers.c.b.f43295a     // Catch:{ all -> 0x0140 }
                int r3 = com.paytm.notification.schedulers.c.b.a.b()     // Catch:{ all -> 0x0140 }
                r2.f43304a = r3     // Catch:{ all -> 0x0140 }
                r2.f43306c = r6     // Catch:{ all -> 0x0140 }
                com.paytm.notification.schedulers.d r6 = r2.b()     // Catch:{ all -> 0x0140 }
                com.paytm.notification.g$c r7 = com.paytm.notification.g.f43191a     // Catch:{ all -> 0x0140 }
                com.paytm.notification.g$c$b r7 = new com.paytm.notification.g$c$b     // Catch:{ all -> 0x0140 }
                r7.<init>(r6)     // Catch:{ all -> 0x0140 }
                com.paytm.notification.models.callback.InboxHandlerReadyCallback r7 = (com.paytm.notification.models.callback.InboxHandlerReadyCallback) r7     // Catch:{ all -> 0x0140 }
                a((com.paytm.notification.models.callback.InboxHandlerReadyCallback) r7)     // Catch:{ all -> 0x0140 }
            L_0x00cf:
                com.paytm.notification.g$c r6 = com.paytm.notification.g.f43191a     // Catch:{ all -> 0x0140 }
                com.paytm.notification.data.datasource.a r6 = com.paytm.notification.data.datasource.a.f43088i     // Catch:{ Exception -> 0x013c }
                android.content.SharedPreferences r6 = r6.a()     // Catch:{ Exception -> 0x013c }
                java.lang.String r7 = com.paytm.notification.data.datasource.a.f43086g     // Catch:{ Exception -> 0x013c }
                java.lang.String r6 = r6.getString(r7, r0)     // Catch:{ Exception -> 0x013c }
                java.lang.String r7 = "11.2.15-PAYTM"
                if (r6 == 0) goto L_0x00e9
                boolean r2 = kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ Exception -> 0x013c }
                r2 = r2 ^ 1
                if (r2 == 0) goto L_0x013c
            L_0x00e9:
                com.paytm.notification.b.a r2 = com.paytm.notification.b.a.f42999a     // Catch:{ Exception -> 0x013c }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
                java.lang.String r3 = "SDK version update(): "
                r2.<init>(r3)     // Catch:{ Exception -> 0x013c }
                r2.append(r6)     // Catch:{ Exception -> 0x013c }
                java.lang.String r3 = " to "
                r2.append(r3)     // Catch:{ Exception -> 0x013c }
                r2.append(r7)     // Catch:{ Exception -> 0x013c }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x013c }
                com.paytm.notification.b.a.c((java.lang.String) r2)     // Catch:{ Exception -> 0x013c }
                com.paytm.notification.models.callback.ErrorReportCallback r2 = com.paytm.notification.g.l     // Catch:{ Exception -> 0x013c }
                if (r2 == 0) goto L_0x0123
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x013c }
                java.lang.String r4 = "SDK version update(): "
                r3.<init>(r4)     // Catch:{ Exception -> 0x013c }
                r3.append(r6)     // Catch:{ Exception -> 0x013c }
                java.lang.String r6 = " to "
                r3.append(r6)     // Catch:{ Exception -> 0x013c }
                r3.append(r7)     // Catch:{ Exception -> 0x013c }
                java.lang.String r6 = r3.toString()     // Catch:{ Exception -> 0x013c }
                r2.onErrorLog(r6)     // Catch:{ Exception -> 0x013c }
            L_0x0123:
                com.paytm.notification.data.datasource.a r6 = com.paytm.notification.data.datasource.a.f43088i     // Catch:{ Exception -> 0x013c }
                java.lang.String r2 = "version"
                kotlin.g.b.k.c(r7, r2)     // Catch:{ Exception -> 0x013c }
                android.content.SharedPreferences r6 = r6.a()     // Catch:{ Exception -> 0x013c }
                android.content.SharedPreferences$Editor r6 = r6.edit()     // Catch:{ Exception -> 0x013c }
                java.lang.String r2 = com.paytm.notification.data.datasource.a.f43086g     // Catch:{ Exception -> 0x013c }
                android.content.SharedPreferences$Editor r6 = r6.putString(r2, r7)     // Catch:{ Exception -> 0x013c }
                r6.apply()     // Catch:{ Exception -> 0x013c }
            L_0x013c:
                kotlin.x r6 = kotlin.x.f47997a     // Catch:{ all -> 0x0140 }
                monitor-exit(r1)     // Catch:{ a -> 0x0144 }
                return
            L_0x0140:
                r6 = move-exception
                monitor-exit(r1)     // Catch:{ a -> 0x0144 }
                throw r6     // Catch:{ a -> 0x0144 }
            L_0x0143:
                return
            L_0x0144:
                r6 = move-exception
                com.paytm.notification.g r7 = com.paytm.notification.g.f43193i
                if (r7 == 0) goto L_0x0157
                com.paytm.notification.g r7 = com.paytm.notification.g.f43193i
                if (r7 != 0) goto L_0x0154
                kotlin.g.b.k.a()
            L_0x0154:
                com.paytm.notification.g.m()
            L_0x0157:
                com.paytm.notification.g.f43193i = r0
                java.lang.Throwable r6 = (java.lang.Throwable) r6
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.notification.g.c.a(android.content.Context, boolean):void");
        }
    }

    public static final class e implements com.paytm.signal.a {
        e() {
        }
    }

    public final class a extends a.b {
        public final void onActivityStopped(Activity activity) {
            k.c(activity, "activity");
        }

        public a() {
        }

        public final void onActivityPaused(Activity activity) {
            k.c(activity, "activity");
            g.this.f43198f = System.currentTimeMillis();
        }

        public final void onActivityResumed(Activity activity) {
            k.c(activity, "activity");
            if (System.currentTimeMillis() - g.this.f43198f > ((Number) g.this.f43199g.getValue()).longValue()) {
                try {
                    NotificationUserConfig b2 = g.p();
                    Boolean bool = null;
                    if ((b2 != null ? b2.getCustomerId$paytmnotification_paytmRelease() : null) != null) {
                        NotificationUserConfig b3 = g.p();
                        if (b3 != null) {
                            bool = b3.isInboxEnabled$paytmnotification_paytmRelease();
                        }
                        if (k.a((Object) bool, (Object) Boolean.TRUE)) {
                            d.a aVar = d.f43032a;
                            c h2 = d.f43033g;
                            if (h2 != null) {
                                h2.b();
                            }
                            d.a aVar2 = d.f43032a;
                            c h3 = d.f43033g;
                            if (h3 != null) {
                                h3.c();
                                return;
                            }
                            return;
                        }
                    }
                    d.a aVar3 = d.f43032a;
                    c h4 = d.f43033g;
                    if (h4 != null) {
                        h4.g();
                    }
                } catch (Exception e2) {
                    com.paytm.notification.b.e.f43014a.b(e2);
                }
            }
        }
    }

    public static final /* synthetic */ void a(g gVar, String str) {
        com.paytm.notification.b.e.f43014a.a("Paytm notifications initialized.... ", new Object[0]);
        e a2 = a();
        if (a2 == null) {
            k.a();
        }
        a2.a(str);
        if (str != null && !gVar.f43196d) {
            NotificationUserConfig p2 = p();
            Boolean bool = null;
            if (k.a((Object) p2 != null ? p2.isInboxEnabled$paytmnotification_paytmRelease() : null, (Object) Boolean.TRUE)) {
                d.a aVar = d.f43032a;
                c h2 = d.f43033g;
                if (h2 == null) {
                    k.a();
                }
                h2.b();
                d.a aVar2 = d.f43032a;
                c h3 = d.f43033g;
                if (h3 == null) {
                    k.a();
                }
                h3.c();
            } else {
                d.a aVar3 = d.f43032a;
                c h4 = d.f43033g;
                if (h4 == null) {
                    k.a();
                }
                h4.g();
            }
            NotificationUserConfig p3 = p();
            if (p3 != null) {
                bool = p3.isFlashEnabled$paytmnotification_paytmRelease();
            }
            if (k.a((Object) bool, (Object) Boolean.TRUE)) {
                i.a aVar4 = i.f43209d;
                i d2 = i.f43210i;
                if (d2 != null) {
                    d2.b();
                }
            } else {
                i.a aVar5 = i.f43209d;
                i d3 = i.f43210i;
                if (d3 != null) {
                    d3.c();
                }
            }
            gVar.f43196d = true;
        }
    }

    public static final /* synthetic */ void d(g gVar) {
        try {
            ErrorReportCallback errorReportCallback = l;
            if (errorReportCallback != null) {
                errorReportCallback.onErrorLog("[PushSDK] logout()");
            }
            ErrorReportCallback errorReportCallback2 = l;
            if (errorReportCallback2 != null) {
                errorReportCallback2.onSetUserIdentifier("");
            }
        } catch (Exception e2) {
            com.paytm.notification.b.e.f43014a.b(e2);
        }
        com.paytm.notification.b.a aVar = com.paytm.notification.b.a.f42999a;
        com.paytm.notification.b.a.c("Logout()");
        e a2 = a();
        if (a2 != null) {
            a2.a();
        }
        d.a aVar2 = d.f43032a;
        c h2 = d.f43033g;
        if (h2 == null) {
            k.a();
        }
        h2.f();
        gVar.f43195c = false;
        gVar.f43196d = false;
        i.a aVar3 = i.f43209d;
        i d2 = i.f43210i;
        if (d2 != null) {
            d2.c();
        }
        i.a aVar4 = i.f43209d;
        i d3 = i.f43210i;
        if (d3 != null) {
            androidx.core.app.k a3 = androidx.core.app.k.a(d3.f43212b);
            k.a((Object) a3, "NotificationManagerCompat.from(context)");
            for (com.paytm.notification.data.datasource.dao.i iVar : d3.f43213c.c()) {
                a3.a(iVar.p);
            }
        }
        d.a aVar5 = d.f43032a;
        c h3 = d.f43033g;
        if (h3 == null) {
            k.a();
        }
        h3.g();
    }

    public static final /* synthetic */ void b(Context context) {
        b.C0745b bVar = com.paytm.signal.b.f43594e;
        boolean z = r;
        long currentTimeMillis = System.currentTimeMillis();
        new Thread(new b.C0745b.a(new e(), context, z, currentTimeMillis)).start();
        StringBuilder sb = new StringBuilder("***** init() UI thread took [");
        sb.append(System.currentTimeMillis() - currentTimeMillis);
        sb.append("] ms ***** ");
    }

    public static final /* synthetic */ void b(g gVar, Context context) {
        b.a aVar = com.paytm.notification.schedulers.b.f43250b;
        k.c(context, "context");
        try {
            synchronized (com.paytm.notification.schedulers.b.class) {
                if (com.paytm.notification.schedulers.b.f43251c == null) {
                    Context applicationContext = context.getApplicationContext();
                    k.a((Object) applicationContext, "context.applicationContext");
                    com.paytm.notification.schedulers.b.f43251c = new com.paytm.notification.schedulers.b(applicationContext, (byte) 0);
                }
                x xVar = x.f47997a;
            }
            f.a aVar2 = f.f43174a;
            b.a aVar3 = com.paytm.notification.schedulers.b.f43250b;
            com.paytm.notification.schedulers.c a2 = b.a.a();
            if (a2 == null) {
                k.a();
            }
            k.c(context, "context");
            k.c(a2, "jobScheduler");
            synchronized (f.class) {
                if (f.f43175h == null) {
                    Context applicationContext2 = context.getApplicationContext();
                    k.a((Object) applicationContext2, "context.applicationContext");
                    f.f43175h = new f(applicationContext2, a2, (byte) 0);
                }
                x xVar2 = x.f47997a;
            }
            i.a aVar4 = i.f43209d;
            b.a aVar5 = com.paytm.notification.schedulers.b.f43250b;
            com.paytm.notification.schedulers.c a3 = b.a.a();
            if (a3 == null) {
                k.a();
            }
            k.c(context, "context");
            k.c(a3, "jobScheduler");
            synchronized (f.class) {
                if (i.f43210i == null) {
                    Context applicationContext3 = context.getApplicationContext();
                    k.a((Object) applicationContext3, "context.applicationContext");
                    i.f43210i = new i(applicationContext3, a3, j.f43241a.a(), j.f43241a.c(), j.f43241a.b(), (byte) 0);
                }
                x xVar3 = x.f47997a;
            }
            gVar.f43197e = j.f43241a.c().f();
            d.a aVar6 = d.f43032a;
            b.a aVar7 = com.paytm.notification.schedulers.b.f43250b;
            com.paytm.notification.schedulers.c a4 = b.a.a();
            if (a4 == null) {
                k.a();
            }
            k.c(context, "context");
            k.c(a4, "jobScheduler");
            synchronized (f.class) {
                if (d.f43033g == null) {
                    Context applicationContext4 = context.getApplicationContext();
                    k.a((Object) applicationContext4, "context.applicationContext");
                    d.f43033g = new d(applicationContext4, a4, j.f43241a.d(), j.f43241a.a(), (byte) 0);
                }
                x xVar4 = x.f47997a;
            }
            NotificationUserConfig p2 = p();
            if (k.a((Object) p2 != null ? p2.isFlashEnabled$paytmnotification_paytmRelease() : null, (Object) Boolean.TRUE)) {
                a.C0717a aVar8 = a.f42997a;
                a.C0717a.a(context);
                i.a aVar9 = i.f43209d;
                i d2 = i.f43210i;
                if (d2 != null) {
                    com.paytm.notification.b.e.f43014a.b("starting flash component", new Object[0]);
                    d2.f43211a.execute(new i.n(d2));
                }
            }
            if (r) {
                com.paytm.notification.b.e.f43014a.a((e.c) new e.a());
            } else {
                com.paytm.notification.b.e.f43014a.a((e.c) new com.paytm.notification.b.d());
            }
            a.C0717a aVar10 = a.f42997a;
            Context context2 = gVar.f43194b;
            if (context2 == null) {
                k.a();
            }
            a.C0717a.a(context2);
            Context context3 = gVar.f43194b;
            if (context3 == null) {
                k.a();
            }
            a.a(context3, new a());
            new Thread(d.f43208a).start();
        } catch (IllegalStateException e2) {
            Throwable th = e2;
            com.paytm.notification.b.e.f43014a.b(th);
            com.paytm.notification.b.e.f43014a.b(th);
            throw new com.paytm.notification.a.a.a("Can not initialize JobManager");
        }
    }

    public static final /* synthetic */ void m() {
        try {
            b.a aVar = com.paytm.notification.schedulers.b.f43250b;
            com.paytm.notification.schedulers.c a2 = b.a.a();
            if (a2 == null) {
                k.a();
            }
            a2.h();
        } catch (Exception e2) {
            com.paytm.notification.b.e.f43014a.b(e2);
        }
    }
}
