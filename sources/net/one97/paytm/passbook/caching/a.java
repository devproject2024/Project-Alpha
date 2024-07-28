package net.one97.paytm.passbook.caching;

import android.content.Context;
import com.appsflyer.internal.referrer.Payload;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.concurrent.TimeUnit;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.p;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import net.one97.paytm.common.utility.l;
import net.one97.paytm.passbook.caching.db.PassbookCacheDB;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    PassbookCacheDB f57096a;

    /* renamed from: b  reason: collision with root package name */
    long f57097b;

    /* renamed from: c  reason: collision with root package name */
    int f57098c;

    /* renamed from: d  reason: collision with root package name */
    int f57099d;

    /* renamed from: e  reason: collision with root package name */
    private Context f57100e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f57101f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f57102g;

    @kotlin.d.b.a.f(b = "PbCachingRules.kt", c = {40, 75, 78}, d = "handlerRequestOnIOThread", e = "net/one97/paytm/passbook/caching/PbCachingRules")
    static final class d extends kotlin.d.b.a.d {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(a aVar, kotlin.d.d dVar) {
            super(dVar);
            this.this$0 = aVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a((com.paytm.network.b) null, this);
        }
    }

    private a(Context context, long j2, boolean z) {
        k.c(context, "context");
        this.f57100e = context;
        this.f57097b = j2;
        this.f57098c = 0;
        this.f57099d = -1;
        this.f57101f = z;
        this.f57102g = false;
        PassbookCacheDB.a aVar = PassbookCacheDB.f57107a;
        this.f57096a = PassbookCacheDB.a.a(this.f57100e);
    }

    public /* synthetic */ a(Context context, boolean z) {
        this(context, TimeUnit.DAYS.toMillis(365), z);
    }

    public final void a(com.paytm.network.b bVar) {
        k.c(bVar, "mNetworkCallBuilder");
        if (!this.f57101f) {
            bVar.l().a();
            return;
        }
        try {
            Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new b(CoroutineExceptionHandler.Key), (CoroutineStart) null, new c(this, bVar, (kotlin.d.d) null), 2, (Object) null);
        } catch (Exception e2) {
            l.a((Throwable) e2);
        }
    }

    public static final class e implements com.paytm.network.listener.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57103a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f57104b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.b f57105c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.paytm.network.listener.b f57106d;

        /* renamed from: net.one97.paytm.passbook.caching.a$e$a  reason: collision with other inner class name */
        public static final class C1067a extends kotlin.d.a implements CoroutineExceptionHandler {
            public C1067a(f.c cVar) {
                super(cVar);
            }

            public final void handleException(kotlin.d.f fVar, Throwable th) {
                l.a(th);
            }
        }

        e(a aVar, x.e eVar, com.paytm.network.b bVar, com.paytm.network.listener.b bVar2) {
            this.f57103a = aVar;
            this.f57104b = eVar;
            this.f57105c = bVar;
            this.f57106d = bVar2;
        }

        public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            k.c(networkCustomError, "networkCustomError");
            com.paytm.network.listener.b bVar = this.f57106d;
            k.a((Object) bVar, "apiListener");
            try {
                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), new h(CoroutineExceptionHandler.Key), (CoroutineStart) null, new i(bVar, i2, iJRPaytmDataModel, networkCustomError, (kotlin.d.d) null), 2, (Object) null);
            } catch (Exception e2) {
                l.a((Throwable) e2);
            }
        }

        public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
            k.c(iJRPaytmDataModel, "ijrPaytmDataModel");
            try {
                Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), new C1067a(CoroutineExceptionHandler.Key), (CoroutineStart) null, new b(this, iJRPaytmDataModel, (kotlin.d.d) null), 2, (Object) null);
            } catch (Exception e2) {
                l.a((Throwable) e2);
            }
        }

        @kotlin.d.b.a.f(b = "PbCachingRules.kt", c = {55, 59, 60, 62}, d = "invokeSuspend", e = "net/one97/paytm/passbook/caching/PbCachingRules$handlerRequestOnIOThread$2$onApiSuccess$1")
        static final class b extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
            final /* synthetic */ IJRPaytmDataModel $ijrPaytmDataModel;
            int label;
            private CoroutineScope p$;
            final /* synthetic */ e this$0;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(e eVar, IJRPaytmDataModel iJRPaytmDataModel, kotlin.d.d dVar) {
                super(2, dVar);
                this.this$0 = eVar;
                this.$ijrPaytmDataModel = iJRPaytmDataModel;
            }

            public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
                k.c(dVar, "completion");
                b bVar = new b(this.this$0, this.$ijrPaytmDataModel, dVar);
                bVar.p$ = (CoroutineScope) obj;
                return bVar;
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((b) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
            }

            /* JADX WARNING: Removed duplicated region for block: B:43:0x00cb A[RETURN] */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object invokeSuspend(java.lang.Object r8) {
                /*
                    r7 = this;
                    kotlin.d.a.a r0 = kotlin.d.a.a.COROUTINE_SUSPENDED
                    int r1 = r7.label
                    r2 = 0
                    r3 = 3
                    r4 = 2
                    r5 = 1
                    if (r1 == 0) goto L_0x0038
                    if (r1 == r5) goto L_0x002e
                    if (r1 == r4) goto L_0x0023
                    if (r1 != r3) goto L_0x001b
                    boolean r0 = r8 instanceof kotlin.p.b
                    if (r0 != 0) goto L_0x0016
                    goto L_0x00cc
                L_0x0016:
                    kotlin.p$b r8 = (kotlin.p.b) r8
                    java.lang.Throwable r8 = r8.exception
                    throw r8
                L_0x001b:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L_0x0023:
                    boolean r1 = r8 instanceof kotlin.p.b
                    if (r1 != 0) goto L_0x0029
                    goto L_0x00ac
                L_0x0029:
                    kotlin.p$b r8 = (kotlin.p.b) r8
                    java.lang.Throwable r8 = r8.exception
                    throw r8
                L_0x002e:
                    boolean r1 = r8 instanceof kotlin.p.b
                    if (r1 != 0) goto L_0x0033
                    goto L_0x0098
                L_0x0033:
                    kotlin.p$b r8 = (kotlin.p.b) r8
                    java.lang.Throwable r8 = r8.exception
                    throw r8
                L_0x0038:
                    boolean r1 = r8 instanceof kotlin.p.b
                    if (r1 != 0) goto L_0x00cf
                    net.one97.paytm.passbook.caching.a$e r8 = r7.this$0
                    kotlin.g.b.x$e r8 = r8.f57104b
                    T r8 = r8.element
                    java.lang.Integer r8 = (java.lang.Integer) r8
                    if (r8 == 0) goto L_0x0098
                    net.one97.paytm.passbook.caching.a$e r8 = r7.this$0
                    kotlin.g.b.x$e r8 = r8.f57104b
                    T r8 = r8.element
                    java.lang.Integer r8 = (java.lang.Integer) r8
                    if (r8 != 0) goto L_0x0053
                    kotlin.g.b.k.a()
                L_0x0053:
                    int r8 = r8.intValue()
                    if (r8 < 0) goto L_0x0098
                    net.one97.paytm.passbook.caching.a$e r8 = r7.this$0
                    net.one97.paytm.passbook.caching.a r8 = r8.f57103a
                    int r8 = r8.f57099d
                    if (r8 < 0) goto L_0x0098
                    net.one97.paytm.passbook.caching.a$e r8 = r7.this$0
                    kotlin.g.b.x$e r8 = r8.f57104b
                    T r8 = r8.element
                    java.lang.Integer r8 = (java.lang.Integer) r8
                    if (r8 != 0) goto L_0x006e
                    kotlin.g.b.k.a()
                L_0x006e:
                    int r8 = r8.intValue()
                    net.one97.paytm.passbook.caching.a$e r1 = r7.this$0
                    net.one97.paytm.passbook.caching.a r1 = r1.f57103a
                    int r1 = r1.f57099d
                    if (r8 < r1) goto L_0x0098
                    net.one97.paytm.passbook.caching.a$e r8 = r7.this$0
                    net.one97.paytm.passbook.caching.a r8 = r8.f57103a
                    net.one97.paytm.passbook.caching.a$e r1 = r7.this$0
                    com.paytm.network.b r1 = r1.f57105c
                    r7.label = r5
                    kotlinx.coroutines.CoroutineDispatcher r5 = kotlinx.coroutines.Dispatchers.getIO()
                    net.one97.paytm.passbook.caching.a$a r6 = new net.one97.paytm.passbook.caching.a$a
                    r6.<init>(r8, r1, r2)
                    kotlin.g.a.m r6 = (kotlin.g.a.m) r6
                    kotlin.d.f r5 = (kotlin.d.f) r5
                    java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r5, r6, r7)
                    if (r8 != r0) goto L_0x0098
                    return r0
                L_0x0098:
                    net.one97.paytm.passbook.caching.a$e r8 = r7.this$0
                    com.paytm.network.listener.b r8 = r8.f57106d
                    java.lang.String r1 = "apiListener"
                    kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r1)
                    com.paytm.network.model.IJRPaytmDataModel r1 = r7.$ijrPaytmDataModel
                    r7.label = r4
                    java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new net.one97.paytm.passbook.caching.a.g(r8, r1, (kotlin.d.d) null), r7)
                    if (r8 != r0) goto L_0x00ac
                    return r0
                L_0x00ac:
                    net.one97.paytm.passbook.caching.a$e r8 = r7.this$0
                    net.one97.paytm.passbook.caching.a r8 = r8.f57103a
                    net.one97.paytm.passbook.caching.a$e r1 = r7.this$0
                    com.paytm.network.b r1 = r1.f57105c
                    com.paytm.network.model.IJRPaytmDataModel r4 = r7.$ijrPaytmDataModel
                    r7.label = r3
                    kotlinx.coroutines.CoroutineDispatcher r3 = kotlinx.coroutines.Dispatchers.getIO()
                    net.one97.paytm.passbook.caching.a$f r5 = new net.one97.paytm.passbook.caching.a$f
                    r5.<init>(r8, r1, r4, r2)
                    kotlin.g.a.m r5 = (kotlin.g.a.m) r5
                    kotlin.d.f r3 = (kotlin.d.f) r3
                    java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r3, r5, r7)
                    if (r8 != r0) goto L_0x00cc
                    return r0
                L_0x00cc:
                    kotlin.x r8 = kotlin.x.f47997a
                    return r8
                L_0x00cf:
                    kotlin.p$b r8 = (kotlin.p.b) r8
                    java.lang.Throwable r8 = r8.exception
                    throw r8
                */
                throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.caching.a.e.b.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }
    }

    public static final class b extends kotlin.d.a implements CoroutineExceptionHandler {
        public b(f.c cVar) {
            super(cVar);
        }

        public final void handleException(kotlin.d.f fVar, Throwable th) {
            l.a(th);
        }
    }

    public static final class h extends kotlin.d.a implements CoroutineExceptionHandler {
        public h(f.c cVar) {
            super(cVar);
        }

        public final void handleException(kotlin.d.f fVar, Throwable th) {
            l.a(th);
        }
    }

    private /* synthetic */ Object a(com.paytm.network.listener.b bVar, String str, Class<? extends IJRPaytmDataModel> cls, kotlin.d.d<? super kotlin.x> dVar) {
        return BuildersKt.withContext(Dispatchers.getIO(), new j(this, str, cls, bVar, (kotlin.d.d) null), dVar);
    }

    @kotlin.d.b.a.f(b = "PbCachingRules.kt", c = {100}, d = "invokeSuspend", e = "net/one97/paytm/passbook/caching/PbCachingRules$deleteEntryFromCache$2")
    /* renamed from: net.one97.paytm.passbook.caching.a$a  reason: collision with other inner class name */
    static final class C1066a extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ com.paytm.network.b $mNetworkCallBuilder;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1066a(a aVar, com.paytm.network.b bVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$mNetworkCallBuilder = bVar;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            C1066a aVar = new C1066a(this.this$0, this.$mNetworkCallBuilder, dVar);
            aVar.p$ = (CoroutineScope) obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C1066a) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            net.one97.paytm.passbook.caching.db.b a2;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                PassbookCacheDB passbookCacheDB = this.this$0.f57096a;
                if (passbookCacheDB == null || (a2 = passbookCacheDB.a()) == null) {
                    return null;
                }
                String aVar2 = this.$mNetworkCallBuilder.b().toString();
                String c2 = this.$mNetworkCallBuilder.c();
                k.a((Object) c2, "mNetworkCallBuilder.url");
                String e2 = this.$mNetworkCallBuilder.e();
                k.a((Object) e2, "mNetworkCallBuilder.requestBody");
                a2.a(aVar2, c2, e2);
                return kotlin.x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "PbCachingRules.kt", c = {32, 34}, d = "invokeSuspend", e = "net/one97/paytm/passbook/caching/PbCachingRules$handlerRequest$1")
    static final class c extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ com.paytm.network.b $mNetworkCallBuilder;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a aVar, com.paytm.network.b bVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$mNetworkCallBuilder = bVar;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            c cVar = new c(this.this$0, this.$mNetworkCallBuilder, dVar);
            cVar.p$ = (CoroutineScope) obj;
            return cVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                a aVar2 = this.this$0;
                com.paytm.network.b bVar = this.$mNetworkCallBuilder;
                this.label = 1;
                if (aVar2.a(bVar, this) == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            return kotlin.x.f47997a;
        }
    }

    @kotlin.d.b.a.f(b = "PbCachingRules.kt", c = {127}, d = "invokeSuspend", e = "net/one97/paytm/passbook/caching/PbCachingRules$saveCacheDataOnIO$2")
    static final class f extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ IJRPaytmDataModel $ijrPaytmDataModel;
        final /* synthetic */ com.paytm.network.b $mNetworkCallBuilder;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(a aVar, com.paytm.network.b bVar, IJRPaytmDataModel iJRPaytmDataModel, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$mNetworkCallBuilder = bVar;
            this.$ijrPaytmDataModel = iJRPaytmDataModel;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            f fVar = new f(this.this$0, this.$mNetworkCallBuilder, this.$ijrPaytmDataModel, dVar);
            fVar.p$ = (CoroutineScope) obj;
            return fVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((f) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            net.one97.paytm.passbook.caching.db.b a2;
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                String c2 = this.$mNetworkCallBuilder.c();
                String aVar2 = this.$mNetworkCallBuilder.b().toString();
                String e2 = this.$mNetworkCallBuilder.e();
                String obj2 = this.$mNetworkCallBuilder.d().toString();
                String b2 = new com.google.gson.f().b(this.$ijrPaytmDataModel);
                long currentTimeMillis = System.currentTimeMillis();
                k.a((Object) c2, "url");
                k.a((Object) b2, Payload.RESPONSE);
                net.one97.paytm.passbook.caching.db.a aVar3 = new net.one97.paytm.passbook.caching.db.a((Integer) null, aVar2, c2, (String) null, obj2, e2, b2, currentTimeMillis, this.this$0.f57097b + System.currentTimeMillis(), this.this$0.f57098c);
                PassbookCacheDB passbookCacheDB = this.this$0.f57096a;
                if (passbookCacheDB == null || (a2 = passbookCacheDB.a()) == null) {
                    return null;
                }
                a2.a(aVar3);
                return kotlin.x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "PbCachingRules.kt", c = {122}, d = "invokeSuspend", e = "net/one97/paytm/passbook/caching/PbCachingRules$sendDataOnMainThread$2")
    static final class g extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ IJRPaytmDataModel $data;
        final /* synthetic */ com.paytm.network.listener.b $listener;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(com.paytm.network.listener.b bVar, IJRPaytmDataModel iJRPaytmDataModel, kotlin.d.d dVar) {
            super(2, dVar);
            this.$listener = bVar;
            this.$data = iJRPaytmDataModel;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            g gVar = new g(this.$listener, this.$data, dVar);
            gVar.p$ = (CoroutineScope) obj;
            return gVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((g) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                this.$listener.onApiSuccess(this.$data);
                return kotlin.x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "PbCachingRules.kt", c = {109}, d = "invokeSuspend", e = "net/one97/paytm/passbook/caching/PbCachingRules$sendErrorOnMainThread$1")
    static final class i extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ com.paytm.network.listener.b $apiListener;
        final /* synthetic */ IJRPaytmDataModel $ijrPaytmDataModel;
        final /* synthetic */ NetworkCustomError $networkCustomError;
        final /* synthetic */ int $statusCode;
        int label;
        private CoroutineScope p$;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(com.paytm.network.listener.b bVar, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, kotlin.d.d dVar) {
            super(2, dVar);
            this.$apiListener = bVar;
            this.$statusCode = i2;
            this.$ijrPaytmDataModel = iJRPaytmDataModel;
            this.$networkCustomError = networkCustomError;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            i iVar = new i(this.$apiListener, this.$statusCode, this.$ijrPaytmDataModel, this.$networkCustomError, dVar);
            iVar.p$ = (CoroutineScope) obj;
            return iVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((i) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else if (!(obj instanceof p.b)) {
                this.$apiListener.handleErrorCode(this.$statusCode, this.$ijrPaytmDataModel, this.$networkCustomError);
                return kotlin.x.f47997a;
            } else {
                throw ((p.b) obj).exception;
            }
        }
    }

    @kotlin.d.b.a.f(b = "PbCachingRules.kt", c = {116, 119}, d = "invokeSuspend", e = "net/one97/paytm/passbook/caching/PbCachingRules$sendSavedResponse$2")
    static final class j extends kotlin.d.b.a.k implements m<CoroutineScope, kotlin.d.d<? super kotlin.x>, Object> {
        final /* synthetic */ com.paytm.network.listener.b $listener;
        final /* synthetic */ Class $modelClass;
        final /* synthetic */ String $response;
        Object L$0;
        int label;
        private CoroutineScope p$;
        final /* synthetic */ a this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(a aVar, String str, Class cls, com.paytm.network.listener.b bVar, kotlin.d.d dVar) {
            super(2, dVar);
            this.this$0 = aVar;
            this.$response = str;
            this.$modelClass = cls;
            this.$listener = bVar;
        }

        public final kotlin.d.d<kotlin.x> create(Object obj, kotlin.d.d<?> dVar) {
            k.c(dVar, "completion");
            j jVar = new j(this.this$0, this.$response, this.$modelClass, this.$listener, dVar);
            jVar.p$ = (CoroutineScope) obj;
            return jVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((j) create(obj, (kotlin.d.d) obj2)).invokeSuspend(kotlin.x.f47997a);
        }

        public final Object invokeSuspend(Object obj) {
            kotlin.d.a.a aVar = kotlin.d.a.a.COROUTINE_SUSPENDED;
            int i2 = this.label;
            if (i2 != 0) {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else if (obj instanceof p.b) {
                    throw ((p.b) obj).exception;
                }
            } else if (!(obj instanceof p.b)) {
                IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) new com.google.gson.f().a(this.$response, this.$modelClass);
                com.paytm.network.listener.b bVar = this.$listener;
                this.L$0 = iJRPaytmDataModel;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new g(bVar, iJRPaytmDataModel, (kotlin.d.d) null), this) == aVar) {
                    return aVar;
                }
            } else {
                throw ((p.b) obj).exception;
            }
            return kotlin.x.f47997a;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0101, code lost:
        if (r18 > 0) goto L_0x0213;
     */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0154  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0157  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0166  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0169  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x01b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object a(com.paytm.network.b r30, kotlin.d.d<? super kotlin.x> r31) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r31
            boolean r3 = r2 instanceof net.one97.paytm.passbook.caching.a.d
            if (r3 == 0) goto L_0x001a
            r3 = r2
            net.one97.paytm.passbook.caching.a$d r3 = (net.one97.paytm.passbook.caching.a.d) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x001a
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001f
        L_0x001a:
            net.one97.paytm.passbook.caching.a$d r3 = new net.one97.paytm.passbook.caching.a$d
            r3.<init>(r0, r2)
        L_0x001f:
            java.lang.Object r2 = r3.result
            kotlin.d.a.a r4 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r5 = r3.label
            java.lang.String r6 = "mNetworkCallBuilder.requestBody"
            r7 = 2
            java.lang.String r9 = "mNetworkCallBuilder.url"
            r10 = 1
            if (r5 == 0) goto L_0x0061
            if (r5 == r10) goto L_0x0052
            if (r5 != r7) goto L_0x004a
            java.lang.Object r1 = r3.L$5
            kotlin.g.b.x$e r1 = (kotlin.g.b.x.e) r1
            java.lang.Object r4 = r3.L$1
            com.paytm.network.b r4 = (com.paytm.network.b) r4
            java.lang.Object r3 = r3.L$0
            net.one97.paytm.passbook.caching.a r3 = (net.one97.paytm.passbook.caching.a) r3
            boolean r5 = r2 instanceof kotlin.p.b
            if (r5 != 0) goto L_0x0045
            r13 = r1
            r1 = r4
            goto L_0x0128
        L_0x0045:
            kotlin.p$b r2 = (kotlin.p.b) r2
            java.lang.Throwable r1 = r2.exception
            throw r1
        L_0x004a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0052:
            java.lang.Object r1 = r3.L$1
            com.paytm.network.b r1 = (com.paytm.network.b) r1
            boolean r3 = r2 instanceof kotlin.p.b
            if (r3 != 0) goto L_0x005c
            goto L_0x0254
        L_0x005c:
            kotlin.p$b r2 = (kotlin.p.b) r2
            java.lang.Throwable r1 = r2.exception
            throw r1
        L_0x0061:
            boolean r5 = r2 instanceof kotlin.p.b
            if (r5 != 0) goto L_0x025e
            com.paytm.network.listener.b r2 = r30.a()
            net.one97.paytm.passbook.caching.db.PassbookCacheDB r5 = r0.f57096a
            if (r5 == 0) goto L_0x008e
            net.one97.paytm.passbook.caching.db.b r5 = r5.a()
            if (r5 == 0) goto L_0x008e
            com.paytm.network.a$a r12 = r30.b()
            java.lang.String r12 = r12.toString()
            java.lang.String r13 = r30.c()
            kotlin.g.b.k.a((java.lang.Object) r13, (java.lang.String) r9)
            java.lang.String r14 = r30.e()
            kotlin.g.b.k.a((java.lang.Object) r14, (java.lang.String) r6)
            net.one97.paytm.passbook.caching.db.a r5 = r5.b(r12, r13, r14)
            goto L_0x008f
        L_0x008e:
            r5 = 0
        L_0x008f:
            if (r5 == 0) goto L_0x0094
            java.lang.String r12 = r5.f57117g
            goto L_0x0095
        L_0x0094:
            r12 = 0
        L_0x0095:
            kotlin.g.b.x$e r13 = new kotlin.g.b.x$e
            r13.<init>()
            if (r5 == 0) goto L_0x00a3
            int r14 = r5.j
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            goto L_0x00a4
        L_0x00a3:
            r14 = 0
        L_0x00a4:
            r13.element = r14
            r14 = r12
            java.lang.CharSequence r14 = (java.lang.CharSequence) r14
            if (r14 == 0) goto L_0x00b4
            boolean r15 = kotlin.m.p.a(r14)
            if (r15 == 0) goto L_0x00b2
            goto L_0x00b4
        L_0x00b2:
            r15 = 0
            goto L_0x00b5
        L_0x00b4:
            r15 = 1
        L_0x00b5:
            java.lang.String r8 = "apiListener"
            if (r15 != 0) goto L_0x0212
            boolean r15 = r0.f57102g
            if (r15 != 0) goto L_0x0212
            T r15 = r13.element
            java.lang.Integer r15 = (java.lang.Integer) r15
            if (r15 == 0) goto L_0x00dd
            T r15 = r13.element
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            if (r15 < 0) goto L_0x00dd
            int r15 = r0.f57099d
            if (r15 < 0) goto L_0x00dd
            T r15 = r13.element
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            int r11 = r0.f57099d
            if (r15 >= r11) goto L_0x0212
        L_0x00dd:
            if (r5 == 0) goto L_0x00e6
            long r10 = r5.f57119i
            java.lang.Long r11 = kotlin.d.b.a.b.a(r10)
            goto L_0x00e7
        L_0x00e6:
            r11 = 0
        L_0x00e7:
            if (r11 == 0) goto L_0x0105
            long r10 = java.lang.System.currentTimeMillis()
            r17 = r8
            if (r5 == 0) goto L_0x00f8
            long r7 = r5.f57119i
            java.lang.Long r7 = kotlin.d.b.a.b.a(r7)
            goto L_0x00f9
        L_0x00f8:
            r7 = 0
        L_0x00f9:
            long r7 = r7.longValue()
            int r18 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            r7 = r17
            if (r18 <= 0) goto L_0x0106
            goto L_0x0213
        L_0x0105:
            r7 = r8
        L_0x0106:
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            com.paytm.network.model.IJRPaytmDataModel r7 = r30.g()
            java.lang.Class r7 = r7.getClass()
            r3.L$0 = r0
            r3.L$1 = r1
            r3.L$2 = r2
            r3.L$3 = r5
            r3.L$4 = r12
            r3.L$5 = r13
            r5 = 2
            r3.label = r5
            java.lang.Object r2 = r0.a(r2, r12, r7, r3)
            if (r2 != r4) goto L_0x0127
            return r4
        L_0x0127:
            r3 = r0
        L_0x0128:
            T r2 = r13.element
            java.lang.Integer r2 = (java.lang.Integer) r2
            net.one97.paytm.passbook.caching.db.PassbookCacheDB r4 = r3.f57096a
            if (r4 == 0) goto L_0x0151
            net.one97.paytm.passbook.caching.db.b r4 = r4.a()
            if (r4 == 0) goto L_0x0151
            com.paytm.network.a$a r5 = r1.b()
            java.lang.String r5 = r5.toString()
            java.lang.String r7 = r1.c()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            java.lang.String r8 = r1.e()
            kotlin.g.b.k.a((java.lang.Object) r8, (java.lang.String) r6)
            net.one97.paytm.passbook.caching.db.a r11 = r4.b(r5, r7, r8)
            goto L_0x0152
        L_0x0151:
            r11 = 0
        L_0x0152:
            if (r11 == 0) goto L_0x0157
            java.lang.String r4 = r11.f57117g
            goto L_0x0158
        L_0x0157:
            r4 = 0
        L_0x0158:
            r5 = r4
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            if (r5 == 0) goto L_0x0166
            boolean r5 = kotlin.m.p.a(r5)
            if (r5 == 0) goto L_0x0164
            goto L_0x0166
        L_0x0164:
            r5 = 0
            goto L_0x0167
        L_0x0166:
            r5 = 1
        L_0x0167:
            if (r5 == 0) goto L_0x01b4
            if (r11 == 0) goto L_0x01a2
            long r5 = r11.f57119i
            net.one97.paytm.passbook.caching.db.a r2 = new net.one97.paytm.passbook.caching.db.a
            r17 = 0
            com.paytm.network.a$a r7 = r1.b()
            java.lang.String r18 = r7.toString()
            java.lang.String r7 = r1.c()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            r20 = 0
            java.util.Map r8 = r1.d()
            java.lang.String r21 = r8.toString()
            java.lang.String r22 = r1.e()
            java.lang.String r23 = java.lang.String.valueOf(r4)
            long r24 = java.lang.System.currentTimeMillis()
            r28 = 1
            r16 = r2
            r19 = r7
            r26 = r5
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r26, r28)
            goto L_0x01a3
        L_0x01a2:
            r2 = 0
        L_0x01a3:
            if (r2 == 0) goto L_0x025b
            net.one97.paytm.passbook.caching.db.PassbookCacheDB r1 = r3.f57096a
            if (r1 == 0) goto L_0x025b
            net.one97.paytm.passbook.caching.db.b r1 = r1.a()
            if (r1 == 0) goto L_0x025b
            r1.a(r2)
            goto L_0x025b
        L_0x01b4:
            if (r2 == 0) goto L_0x01c1
            int r2 = r2.intValue()
            r5 = 1
            int r2 = r2 + r5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x01c2
        L_0x01c1:
            r2 = 0
        L_0x01c2:
            if (r2 == 0) goto L_0x0201
            java.lang.Number r2 = (java.lang.Number) r2
            int r28 = r2.intValue()
            if (r11 == 0) goto L_0x0201
            long r5 = r11.f57119i
            net.one97.paytm.passbook.caching.db.a r2 = new net.one97.paytm.passbook.caching.db.a
            r17 = 0
            com.paytm.network.a$a r7 = r1.b()
            java.lang.String r18 = r7.toString()
            java.lang.String r7 = r1.c()
            kotlin.g.b.k.a((java.lang.Object) r7, (java.lang.String) r9)
            r20 = 0
            java.util.Map r8 = r1.d()
            java.lang.String r21 = r8.toString()
            java.lang.String r22 = r1.e()
            java.lang.String r23 = r4.toString()
            long r24 = java.lang.System.currentTimeMillis()
            r16 = r2
            r19 = r7
            r26 = r5
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r26, r28)
            goto L_0x0202
        L_0x0201:
            r2 = 0
        L_0x0202:
            if (r2 == 0) goto L_0x025b
            net.one97.paytm.passbook.caching.db.PassbookCacheDB r1 = r3.f57096a
            if (r1 == 0) goto L_0x025b
            net.one97.paytm.passbook.caching.db.b r1 = r1.a()
            if (r1 == 0) goto L_0x025b
            r1.a(r2)
            goto L_0x025b
        L_0x0212:
            r7 = r8
        L_0x0213:
            net.one97.paytm.passbook.caching.a$e r6 = new net.one97.paytm.passbook.caching.a$e
            r6.<init>(r0, r13, r1, r2)
            com.paytm.network.listener.b r6 = (com.paytm.network.listener.b) r6
            r1.a((com.paytm.network.listener.b) r6)
            boolean r6 = r0.f57101f
            if (r6 == 0) goto L_0x0254
            boolean r6 = r0.f57102g
            if (r6 == 0) goto L_0x0254
            if (r14 == 0) goto L_0x0230
            boolean r6 = kotlin.m.p.a(r14)
            if (r6 == 0) goto L_0x022e
            goto L_0x0230
        L_0x022e:
            r6 = 0
            goto L_0x0231
        L_0x0230:
            r6 = 1
        L_0x0231:
            if (r6 != 0) goto L_0x0254
            kotlin.g.b.k.a((java.lang.Object) r2, (java.lang.String) r7)
            com.paytm.network.model.IJRPaytmDataModel r6 = r30.g()
            java.lang.Class r6 = r6.getClass()
            r3.L$0 = r0
            r3.L$1 = r1
            r3.L$2 = r2
            r3.L$3 = r5
            r3.L$4 = r12
            r3.L$5 = r13
            r5 = 1
            r3.label = r5
            java.lang.Object r2 = r0.a(r2, r12, r6, r3)
            if (r2 != r4) goto L_0x0254
            return r4
        L_0x0254:
            com.paytm.network.a r1 = r1.l()
            r1.a()
        L_0x025b:
            kotlin.x r1 = kotlin.x.f47997a
            return r1
        L_0x025e:
            kotlin.p$b r2 = (kotlin.p.b) r2
            java.lang.Throwable r1 = r2.exception
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.passbook.caching.a.a(com.paytm.network.b, kotlin.d.d):java.lang.Object");
    }
}
