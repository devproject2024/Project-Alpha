package net.one97.paytm.bankCommon.data.bankscope;

import kotlin.d.b.a.d;
import kotlin.d.b.a.f;
import kotlin.g.b.k;
import kotlin.x;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f16256a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static b f16257d;

    /* renamed from: b  reason: collision with root package name */
    private final a f16258b;

    /* renamed from: c  reason: collision with root package name */
    private final a f16259c;

    @f(b = "BankScopeTokenRepository.kt", c = {37}, d = "getBankScopeUsingRefreshToken", e = "net.one97.paytm.bankCommon.data.bankscope.BankScopeTokenRepository")
    /* renamed from: net.one97.paytm.bankCommon.data.bankscope.b$b  reason: collision with other inner class name */
    static final class C0224b extends d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0224b(b bVar, kotlin.d.d dVar) {
            super(dVar);
            this.this$0 = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a((String) null, (kotlin.d.d<? super net.one97.paytm.bankCommon.b.c<? extends Object>>) this);
        }
    }

    @f(b = "BankScopeTokenRepository.kt", c = {15}, d = "validateBankPassCodeAndGetBankScopeToken", e = "net.one97.paytm.bankCommon.data.bankscope.BankScopeTokenRepository")
    static final class c extends d {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(b bVar, kotlin.d.d dVar) {
            super(dVar);
            this.this$0 = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.a((String) null, (String) null, this);
        }
    }

    private b(a aVar, a aVar2) {
        this.f16258b = aVar;
        this.f16259c = aVar2;
    }

    public /* synthetic */ b(a aVar, a aVar2, byte b2) {
        this(aVar, aVar2);
    }

    public final Object b(String str, String str2, kotlin.d.d<? super net.one97.paytm.bankCommon.b.c<? extends Object>> dVar) {
        return this.f16259c.b(str, str2, dVar);
    }

    public final Object a(kotlin.d.d<? super net.one97.paytm.bankCommon.b.c<? extends Object>> dVar) {
        return this.f16259c.a(dVar);
    }

    public final void a(String str, String str2) {
        k.c(str, "bankScopeToken");
        k.c(str2, "bankRefreshToken");
        this.f16258b.a(str, str2);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(a aVar, a aVar2) {
            k.c(aVar, "localBankScopeTokenDataSource");
            k.c(aVar2, "remoteBankScopeTokenDataSource");
            if (b.f16257d == null) {
                synchronized (b.class) {
                    a aVar3 = b.f16256a;
                    if (b.f16257d == null) {
                        a aVar4 = b.f16256a;
                        b.f16257d = new b(aVar, aVar2, (byte) 0);
                    }
                    x xVar = x.f47997a;
                }
            }
            b a2 = b.f16257d;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r5, java.lang.String r6, kotlin.d.d<? super net.one97.paytm.bankCommon.b.c<? extends java.lang.Object>> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof net.one97.paytm.bankCommon.data.bankscope.b.c
            if (r0 == 0) goto L_0x0014
            r0 = r7
            net.one97.paytm.bankCommon.data.bankscope.b$c r0 = (net.one97.paytm.bankCommon.data.bankscope.b.c) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            net.one97.paytm.bankCommon.data.bankscope.b$c r0 = new net.one97.paytm.bankCommon.data.bankscope.b$c
            r0.<init>(r4, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$0
            net.one97.paytm.bankCommon.data.bankscope.b r5 = (net.one97.paytm.bankCommon.data.bankscope.b) r5
            boolean r6 = r7 instanceof kotlin.p.b
            if (r6 != 0) goto L_0x002d
            goto L_0x0050
        L_0x002d:
            kotlin.p$b r7 = (kotlin.p.b) r7
            java.lang.Throwable r5 = r7.exception
            throw r5
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            boolean r2 = r7 instanceof kotlin.p.b
            if (r2 != 0) goto L_0x009c
            net.one97.paytm.bankCommon.data.bankscope.a r7 = r4.f16259c
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            java.lang.Object r7 = r7.a(r5, r6, r0)
            if (r7 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r5 = r4
        L_0x0050:
            net.one97.paytm.bankCommon.b.c r7 = (net.one97.paytm.bankCommon.b.c) r7
            net.one97.paytm.bankCommon.b.d r6 = r7.f16216a
            net.one97.paytm.bankCommon.b.d r0 = net.one97.paytm.bankCommon.b.d.SUCCESS
            if (r6 != r0) goto L_0x009b
            T r6 = r7.f16217b
            if (r6 == 0) goto L_0x0093
            net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse r6 = (net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse) r6
            if (r6 == 0) goto L_0x0065
            java.lang.Integer r0 = r6.getResponseCode()
            goto L_0x0066
        L_0x0065:
            r0 = 0
        L_0x0066:
            if (r0 == 0) goto L_0x009b
            java.lang.Integer r0 = r6.getResponseCode()
            if (r0 != 0) goto L_0x006f
            goto L_0x009b
        L_0x006f:
            int r0 = r0.intValue()
            r1 = 200(0xc8, float:2.8E-43)
            if (r0 != r1) goto L_0x009b
            if (r6 == 0) goto L_0x009b
            net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.TokenData r6 = r6.getData()
            if (r6 == 0) goto L_0x009b
            java.lang.String r0 = r6.getAccessToken()
            java.lang.String r1 = ""
            if (r0 != 0) goto L_0x0088
            r0 = r1
        L_0x0088:
            java.lang.String r6 = r6.getRefreshToken()
            if (r6 != 0) goto L_0x008f
            r6 = r1
        L_0x008f:
            r5.a((java.lang.String) r0, (java.lang.String) r6)
            goto L_0x009b
        L_0x0093:
            kotlin.u r5 = new kotlin.u
            java.lang.String r6 = "null cannot be cast to non-null type net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse"
            r5.<init>(r6)
            throw r5
        L_0x009b:
            return r7
        L_0x009c:
            kotlin.p$b r7 = (kotlin.p.b) r7
            java.lang.Throwable r5 = r7.exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankCommon.data.bankscope.b.a(java.lang.String, java.lang.String, kotlin.d.d):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(java.lang.String r5, kotlin.d.d<? super net.one97.paytm.bankCommon.b.c<? extends java.lang.Object>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof net.one97.paytm.bankCommon.data.bankscope.b.C0224b
            if (r0 == 0) goto L_0x0014
            r0 = r6
            net.one97.paytm.bankCommon.data.bankscope.b$b r0 = (net.one97.paytm.bankCommon.data.bankscope.b.C0224b) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            net.one97.paytm.bankCommon.data.bankscope.b$b r0 = new net.one97.paytm.bankCommon.data.bankscope.b$b
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r5 = r0.L$0
            net.one97.paytm.bankCommon.data.bankscope.b r5 = (net.one97.paytm.bankCommon.data.bankscope.b) r5
            boolean r0 = r6 instanceof kotlin.p.b
            if (r0 != 0) goto L_0x002d
            goto L_0x004e
        L_0x002d:
            kotlin.p$b r6 = (kotlin.p.b) r6
            java.lang.Throwable r5 = r6.exception
            throw r5
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003a:
            boolean r2 = r6 instanceof kotlin.p.b
            if (r2 != 0) goto L_0x009a
            net.one97.paytm.bankCommon.data.bankscope.a r6 = r4.f16259c
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.a((java.lang.String) r5, (kotlin.d.d<? super net.one97.paytm.bankCommon.b.c<? extends java.lang.Object>>) r0)
            if (r6 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r5 = r4
        L_0x004e:
            net.one97.paytm.bankCommon.b.c r6 = (net.one97.paytm.bankCommon.b.c) r6
            net.one97.paytm.bankCommon.b.d r0 = r6.f16216a
            net.one97.paytm.bankCommon.b.d r1 = net.one97.paytm.bankCommon.b.d.SUCCESS
            if (r0 != r1) goto L_0x0099
            T r0 = r6.f16217b
            if (r0 == 0) goto L_0x0091
            net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse r0 = (net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse) r0
            if (r0 == 0) goto L_0x0063
            java.lang.Integer r1 = r0.getResponseCode()
            goto L_0x0064
        L_0x0063:
            r1 = 0
        L_0x0064:
            if (r1 == 0) goto L_0x0099
            java.lang.Integer r1 = r0.getResponseCode()
            if (r1 != 0) goto L_0x006d
            goto L_0x0099
        L_0x006d:
            int r1 = r1.intValue()
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 != r2) goto L_0x0099
            if (r0 == 0) goto L_0x0099
            net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.TokenData r0 = r0.getData()
            if (r0 == 0) goto L_0x0099
            java.lang.String r1 = r0.getAccessToken()
            java.lang.String r2 = ""
            if (r1 != 0) goto L_0x0086
            r1 = r2
        L_0x0086:
            java.lang.String r0 = r0.getRefreshToken()
            if (r0 != 0) goto L_0x008d
            r0 = r2
        L_0x008d:
            r5.a((java.lang.String) r1, (java.lang.String) r0)
            goto L_0x0099
        L_0x0091:
            kotlin.u r5 = new kotlin.u
            java.lang.String r6 = "null cannot be cast to non-null type net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration.ValidateTokenApiResponse"
            r5.<init>(r6)
            throw r5
        L_0x0099:
            return r6
        L_0x009a:
            kotlin.p$b r6 = (kotlin.p.b) r6
            java.lang.Throwable r5 = r6.exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankCommon.data.bankscope.b.a(java.lang.String, kotlin.d.d):java.lang.Object");
    }
}
