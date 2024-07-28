package net.one97.paytm.recharge.common.b.c;

import android.content.Context;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.e.ai;
import net.one97.paytm.recharge.model.imps.CJRImpsRefundBodyModel;
import net.one97.paytm.recharge.model.imps.CJRImpsRefundHeadModel;
import net.one97.paytm.recharge.model.imps.CJRImpsRefundModel;
import net.one97.paytm.recharge.ordersummary.f.s;

public final class e implements s {

    /* renamed from: b  reason: collision with root package name */
    public static final a f60936b = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static e f60937c;

    /* renamed from: a  reason: collision with root package name */
    public Context f60938a;

    public e(Context context) {
        k.c(context, "context");
        this.f60938a = context;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static e a(Context context) {
            k.c(context, "context");
            e b2 = e.f60937c;
            if (b2 != null) {
                return b2;
            }
            e eVar = new e(context);
            e.f60937c = eVar;
            return eVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r1.c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(net.one97.paytm.recharge.common.f.b r1) {
        /*
            if (r1 == 0) goto L_0x0011
            java.lang.String r0 = r1.c()
            if (r0 == 0) goto L_0x0011
            int r0 = java.lang.Integer.parseInt(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x001c
            if (r1 == 0) goto L_0x001b
            java.lang.String r0 = "1"
            r1.a(r0)
        L_0x001b:
            return
        L_0x001c:
            int r0 = r0.intValue()
            int r0 = r0 + 1
            if (r1 == 0) goto L_0x002b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.a(r0)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.b.c.e.a(net.one97.paytm.recharge.common.f.b):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r1.b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(net.one97.paytm.recharge.common.f.c r1) {
        /*
            if (r1 == 0) goto L_0x0011
            java.lang.String r0 = r1.b()
            if (r0 == 0) goto L_0x0011
            int r0 = java.lang.Integer.parseInt(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x001c
            if (r1 == 0) goto L_0x001b
            java.lang.String r0 = "1"
            r1.a((java.lang.String) r0)
        L_0x001b:
            return
        L_0x001c:
            int r0 = r0.intValue()
            int r0 = r0 + 1
            if (r1 == 0) goto L_0x002b
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r1.a((java.lang.String) r0)
        L_0x002b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.b.c.e.a(net.one97.paytm.recharge.common.f.c):void");
    }

    public static final class c implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f60942a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f60943b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ s.a f60944c;

        public c(e eVar, x.e eVar2, s.a aVar) {
            this.f60942a = eVar;
            this.f60943b = eVar2;
            this.f60944c = aVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            if (!e.b((net.one97.paytm.recharge.common.f.c) this.f60943b.element)) {
                s.a aVar = this.f60944c;
                if (networkCustomError != null) {
                    aVar.a(str, networkCustomError, (Integer) 0);
                    return;
                }
                throw new u("null cannot be cast to non-null type com.paytm.network.model.NetworkCustomError");
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f60944c.a(str, iJRPaytmDataModel, (Integer) 0);
        }
    }

    public final CJRImpsRefundModel a() {
        CJRImpsRefundModel cJRImpsRefundModel = new CJRImpsRefundModel(new CJRImpsRefundHeadModel(), new CJRImpsRefundBodyModel());
        CJRImpsRefundHeadModel head = cJRImpsRefundModel.getHead();
        if (head != null) {
            head.setRequestId(com.paytm.utility.b.A(this.f60938a));
        }
        CJRImpsRefundHeadModel head2 = cJRImpsRefundModel.getHead();
        if (head2 != null) {
            head2.setRequestTimestamp(String.valueOf(System.currentTimeMillis()));
        }
        CJRImpsRefundHeadModel head3 = cJRImpsRefundModel.getHead();
        if (head3 != null) {
            head3.setToken(com.paytm.utility.d.a(this.f60938a));
        }
        CJRImpsRefundHeadModel head4 = cJRImpsRefundModel.getHead();
        if (head4 != null) {
            head4.setTokenType(SDKConstants.SSO);
        }
        CJRImpsRefundBodyModel body = cJRImpsRefundModel.getBody();
        if (body != null) {
            body.setChannelId("APP");
        }
        return cJRImpsRefundModel;
    }

    public final void a(String str, s.a aVar) {
        NetworkCustomError networkCustomError = new NetworkCustomError();
        networkCustomError.setAlertMessage(this.f60938a.getResources().getString(R.string.no_internet));
        networkCustomError.setmAlertTitle(this.f60938a.getResources().getString(R.string.no_connection));
        aVar.a(str, networkCustomError, (Integer) 0);
    }

    /* renamed from: net.one97.paytm.recharge.common.b.c.e$e  reason: collision with other inner class name */
    public static final class C1178e implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f60948a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f60949b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ s.a f60950c;

        public C1178e(e eVar, x.e eVar2, s.a aVar) {
            this.f60948a = eVar;
            this.f60949b = eVar2;
            this.f60950c = aVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            if (!e.b((net.one97.paytm.recharge.common.f.c) this.f60949b.element) && networkCustomError != null) {
                this.f60950c.a(str, networkCustomError, (Integer) 2);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f60950c.a(str, iJRPaytmDataModel, (Integer) 2);
        }
    }

    public static final class b implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f60939a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f60940b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ s.a f60941c;

        public b(e eVar, x.e eVar2, s.a aVar) {
            this.f60939a = eVar;
            this.f60940b = eVar2;
            this.f60941c = aVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            if (!e.b((net.one97.paytm.recharge.common.f.c) this.f60940b.element) && networkCustomError != null) {
                this.f60941c.a(str, networkCustomError, (Integer) 1);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f60941c.a(str, iJRPaytmDataModel, (Integer) 1);
        }
    }

    public static final class d implements ai {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f60945a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.e f60946b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ s.a f60947c;

        public d(e eVar, x.e eVar2, s.a aVar) {
            this.f60945a = eVar;
            this.f60946b = eVar2;
            this.f60947c = aVar;
        }

        public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError, Object obj) {
            k.c(str, "tag");
            if (!e.b((net.one97.paytm.recharge.common.f.b) this.f60946b.element) && networkCustomError != null) {
                this.f60947c.a(str, networkCustomError, (Integer) 3);
            }
        }

        public final void a_(String str, IJRPaytmDataModel iJRPaytmDataModel, Object obj) {
            k.c(str, "tag");
            this.f60947c.a(str, iJRPaytmDataModel, (Integer) 3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r2.b();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ boolean b(net.one97.paytm.recharge.common.f.c r2) {
        /*
            if (r2 == 0) goto L_0x0011
            java.lang.String r0 = r2.b()
            if (r0 == 0) goto L_0x0011
            int r0 = java.lang.Integer.parseInt(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x0015
            goto L_0x0028
        L_0x0015:
            int r0 = r0.intValue()
            r1 = 1
            if (r0 != r1) goto L_0x0028
            a((net.one97.paytm.recharge.common.f.c) r2)
            net.one97.paytm.recharge.common.f.d.a()
            net.one97.paytm.recharge.common.f.a r2 = (net.one97.paytm.recharge.common.f.a) r2
            net.one97.paytm.recharge.common.f.d.b(r2)
            return r1
        L_0x0028:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.b.c.e.b(net.one97.paytm.recharge.common.f.c):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r0 = r2.c();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final /* synthetic */ boolean b(net.one97.paytm.recharge.common.f.b r2) {
        /*
            if (r2 == 0) goto L_0x0011
            java.lang.String r0 = r2.c()
            if (r0 == 0) goto L_0x0011
            int r0 = java.lang.Integer.parseInt(r0)
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            if (r0 != 0) goto L_0x0015
            goto L_0x0028
        L_0x0015:
            int r0 = r0.intValue()
            r1 = 1
            if (r0 != r1) goto L_0x0028
            a((net.one97.paytm.recharge.common.f.b) r2)
            net.one97.paytm.recharge.common.f.d.a()
            net.one97.paytm.recharge.common.f.a r2 = (net.one97.paytm.recharge.common.f.a) r2
            net.one97.paytm.recharge.common.f.d.b(r2)
            return r1
        L_0x0028:
            r2 = 0
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.common.b.c.e.b(net.one97.paytm.recharge.common.f.b):boolean");
    }
}
