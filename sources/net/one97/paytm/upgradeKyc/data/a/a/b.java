package net.one97.paytm.upgradeKyc.data.a.a;

import kotlin.d.b.a.d;
import kotlin.d.b.a.f;
import kotlin.g.b.k;
import kotlin.x;
import net.one97.paytm.common.entity.auth.KYCFetchTnc;
import net.one97.paytm.common.entity.auth.KYCTncAccept;
import net.one97.paytm.common.entity.upgradeKyc.KYCStatusV3;
import net.one97.paytm.upgradeKyc.data.models.aotpexpire.AOTPExpireApiResponse;

public final class b implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65778a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static b f65779d;

    /* renamed from: b  reason: collision with root package name */
    private final a f65780b;

    /* renamed from: c  reason: collision with root package name */
    private final a f65781c;

    @f(b = "AotpExpiryRepository.kt", c = {24}, d = "getKycDetailsStatus", e = "net.one97.paytm.upgradeKyc.data.datasource.aotpexpiry.AotpExpiryRepository")
    /* renamed from: net.one97.paytm.upgradeKyc.data.a.a.b$b  reason: collision with other inner class name */
    static final class C1302b extends d {
        Object L$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ b this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1302b(b bVar, kotlin.d.d dVar) {
            super(dVar);
            this.this$0 = bVar;
        }

        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.c(this);
        }
    }

    private b(a aVar, a aVar2) {
        this.f65780b = aVar;
        this.f65781c = aVar2;
    }

    public /* synthetic */ b(a aVar, a aVar2, byte b2) {
        this(aVar, aVar2);
    }

    public final Object a(kotlin.d.d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<KYCFetchTnc>> dVar) {
        return this.f65781c.a(dVar);
    }

    public final Object a(int i2, String str, kotlin.d.d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<KYCTncAccept>> dVar) {
        return this.f65781c.a(i2, str, dVar);
    }

    public final Object b(kotlin.d.d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<AOTPExpireApiResponse>> dVar) {
        return this.f65781c.b(dVar);
    }

    public final void a(KYCStatusV3 kYCStatusV3) {
        k.c(kYCStatusV3, "kycData");
        this.f65780b.a(kYCStatusV3);
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static b a(a aVar, a aVar2) {
            k.c(aVar, "otpExpiryLocalDataSource");
            k.c(aVar2, "aotpExpiryRemoteDataSource");
            if (b.f65779d == null) {
                synchronized (b.class) {
                    if (b.f65779d == null) {
                        b.f65779d = new b(aVar, aVar2, (byte) 0);
                    }
                    x xVar = x.f47997a;
                }
            }
            b a2 = b.f65779d;
            if (a2 == null) {
                k.a();
            }
            return a2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0022  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object c(kotlin.d.d<? super net.one97.paytm.upgradeKyc.kycV3.b.b<net.one97.paytm.common.entity.upgradeKyc.KYCStatusV3>> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof net.one97.paytm.upgradeKyc.data.a.a.b.C1302b
            if (r0 == 0) goto L_0x0014
            r0 = r5
            net.one97.paytm.upgradeKyc.data.a.a.b$b r0 = (net.one97.paytm.upgradeKyc.data.a.a.b.C1302b) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            net.one97.paytm.upgradeKyc.data.a.a.b$b r0 = new net.one97.paytm.upgradeKyc.data.a.a.b$b
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            kotlin.d.a.a r1 = kotlin.d.a.a.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r0 = r0.L$0
            net.one97.paytm.upgradeKyc.data.a.a.b r0 = (net.one97.paytm.upgradeKyc.data.a.a.b) r0
            boolean r1 = r5 instanceof kotlin.p.b
            if (r1 != 0) goto L_0x002d
            goto L_0x004c
        L_0x002d:
            kotlin.p$b r5 = (kotlin.p.b) r5
            java.lang.Throwable r5 = r5.exception
            throw r5
        L_0x0032:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x003a:
            boolean r2 = r5 instanceof kotlin.p.b
            if (r2 != 0) goto L_0x0065
            net.one97.paytm.upgradeKyc.data.a.a.a r5 = r4.f65781c
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.c(r0)
            if (r5 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r0 = r4
        L_0x004c:
            net.one97.paytm.upgradeKyc.kycV3.b.b r5 = (net.one97.paytm.upgradeKyc.kycV3.b.b) r5
            net.one97.paytm.upgradeKyc.kycV3.b.d r1 = r5.f66168a
            net.one97.paytm.upgradeKyc.kycV3.b.d r2 = net.one97.paytm.upgradeKyc.kycV3.b.d.SUCCESS
            if (r1 != r2) goto L_0x0064
            ResultType r1 = r5.f66169b
            if (r1 == 0) goto L_0x0064
            ResultType r1 = r5.f66169b
            if (r1 != 0) goto L_0x005f
            kotlin.g.b.k.a()
        L_0x005f:
            net.one97.paytm.common.entity.upgradeKyc.KYCStatusV3 r1 = (net.one97.paytm.common.entity.upgradeKyc.KYCStatusV3) r1
            r0.a((net.one97.paytm.common.entity.upgradeKyc.KYCStatusV3) r1)
        L_0x0064:
            return r5
        L_0x0065:
            kotlin.p$b r5 = (kotlin.p.b) r5
            java.lang.Throwable r5 = r5.exception
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upgradeKyc.data.a.a.b.c(kotlin.d.d):java.lang.Object");
    }
}
