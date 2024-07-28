package net.one97.paytm.paymentsBank.slfd.common.b;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.paymentsBank.slfd.a.a.b;
import net.one97.paytm.paymentsBank.slfd.common.a.a;

public final class a implements g.a, g.b<IJRPaytmDataModel>, a.C0328a {

    /* renamed from: a  reason: collision with root package name */
    private int f18959a;

    /* renamed from: b  reason: collision with root package name */
    private a.b f18960b;

    /* renamed from: c  reason: collision with root package name */
    private final b f18961c;

    /* renamed from: d  reason: collision with root package name */
    private final String f18962d;

    /* renamed from: e  reason: collision with root package name */
    private final String f18963e;

    /* renamed from: f  reason: collision with root package name */
    private final String f18964f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f18965g;

    public a(a.b bVar, b bVar2, String str, String str2, String str3, boolean z) {
        k.c(bVar2, "dataRepository");
        k.c(str, "orderId");
        k.c(str2, "custId");
        k.c(str3, "accNum");
        this.f18960b = bVar;
        this.f18961c = bVar2;
        this.f18962d = str;
        this.f18963e = str2;
        this.f18964f = str3;
        this.f18965g = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0141, code lost:
        r4 = (net.one97.paytm.bankCommon.model.PBCJRAccountSummary) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onResponse(java.lang.Object r4) {
        /*
            r3 = this;
            com.paytm.network.model.IJRPaytmDataModel r4 = (com.paytm.network.model.IJRPaytmDataModel) r4
            boolean r0 = r4 instanceof net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse
            r1 = 0
            if (r0 == 0) goto L_0x013d
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r0 = r3.f18960b
            if (r0 == 0) goto L_0x000e
            r0.b()
        L_0x000e:
            boolean r0 = r3.f18965g
            r2 = 0
            if (r0 == 0) goto L_0x0098
            net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse r4 = (net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse) r4
            net.one97.paytm.paymentsBank.model.slfd.BookingResponse r4 = r4.getBookingResponse()
            if (r4 != 0) goto L_0x0026
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r4 = r3.f18960b
            if (r4 == 0) goto L_0x0022
            r4.a((java.lang.String) r2)
        L_0x0022:
            r3.d()
            return
        L_0x0026:
            java.util.List r4 = r4.getBookingResponseList()
            if (r4 == 0) goto L_0x008e
            int r0 = r4.size()
            if (r0 <= 0) goto L_0x008e
            java.lang.Object r4 = r4.get(r1)
            net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem r4 = (net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem) r4
            java.lang.String r0 = r4.getStatus()
            if (r0 != 0) goto L_0x003f
            return
        L_0x003f:
            int r1 = r0.hashCode()
            r2 = -1867169789(0xffffffff90b54003, float:-7.149054E-29)
            if (r1 == r2) goto L_0x007e
            r2 = -1086574198(0xffffffffbf3c318a, float:-0.7351309)
            if (r1 == r2) goto L_0x006a
            r2 = -682587753(0xffffffffd7508997, float:-2.29289362E14)
            if (r1 == r2) goto L_0x0053
            goto L_0x008d
        L_0x0053:
            java.lang.String r1 = "pending"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x008d
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r0 = r3.f18960b
            if (r0 == 0) goto L_0x0066
            java.lang.String r4 = r4.getMessage()
            r0.a((java.lang.String) r4)
        L_0x0066:
            r3.d()
            return
        L_0x006a:
            java.lang.String r1 = "failure"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x008d
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r0 = r3.f18960b
            if (r0 == 0) goto L_0x008d
            java.lang.String r4 = r4.getMessage()
            r0.b(r4)
            return
        L_0x007e:
            java.lang.String r1 = "success"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x008d
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r0 = r3.f18960b
            if (r0 == 0) goto L_0x008d
            r0.a((net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem) r4)
        L_0x008d:
            return
        L_0x008e:
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r4 = r3.f18960b
            if (r4 == 0) goto L_0x0097
            java.lang.String r0 = "Something went wrong"
            r4.b(r0)
        L_0x0097:
            return
        L_0x0098:
            net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse r4 = (net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse) r4
            net.one97.paytm.paymentsBank.model.slfd.RedemptionResponse r4 = r4.getRedemptionResponse()
            if (r4 == 0) goto L_0x0132
            java.util.List r0 = r4.getRedemptionList()
            if (r0 == 0) goto L_0x00b1
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r0 = r3.f18960b
            if (r0 == 0) goto L_0x00b1
            java.util.List r1 = r4.getRedemptionList()
            r0.a((java.util.List<net.one97.paytm.paymentsBank.model.slfd.RedemptionResponseListItem>) r1)
        L_0x00b1:
            java.lang.Integer r0 = r4.getMasterStatus()
            if (r0 != 0) goto L_0x00b8
            goto L_0x00cc
        L_0x00b8:
            int r1 = r0.intValue()
            r2 = 1182(0x49e, float:1.656E-42)
            if (r1 != r2) goto L_0x00cc
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r0 = r3.f18960b
            if (r0 == 0) goto L_0x00cb
            java.lang.String r4 = r4.getMessage()
            r0.c(r4)
        L_0x00cb:
            return
        L_0x00cc:
            if (r0 != 0) goto L_0x00cf
            goto L_0x00e6
        L_0x00cf:
            int r1 = r0.intValue()
            r2 = 1183(0x49f, float:1.658E-42)
            if (r1 != r2) goto L_0x00e6
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r0 = r3.f18960b
            if (r0 == 0) goto L_0x00e2
            java.lang.String r4 = r4.getMessage()
            r0.e(r4)
        L_0x00e2:
            r3.d()
            return
        L_0x00e6:
            if (r0 != 0) goto L_0x00e9
            goto L_0x00fd
        L_0x00e9:
            int r1 = r0.intValue()
            r2 = 1184(0x4a0, float:1.659E-42)
            if (r1 != r2) goto L_0x00fd
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r0 = r3.f18960b
            if (r0 == 0) goto L_0x00fc
            java.lang.String r4 = r4.getMessage()
            r0.f(r4)
        L_0x00fc:
            return
        L_0x00fd:
            if (r0 != 0) goto L_0x0100
            goto L_0x0108
        L_0x0100:
            int r1 = r0.intValue()
            r2 = 1185(0x4a1, float:1.66E-42)
            if (r1 == r2) goto L_0x0123
        L_0x0108:
            if (r0 != 0) goto L_0x010b
            goto L_0x0114
        L_0x010b:
            int r0 = r0.intValue()
            r1 = 1186(0x4a2, float:1.662E-42)
            if (r0 != r1) goto L_0x0114
            goto L_0x0123
        L_0x0114:
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r0 = r3.f18960b
            if (r0 == 0) goto L_0x011f
            java.lang.String r4 = r4.getMessage()
            r0.e(r4)
        L_0x011f:
            r3.d()
            return
        L_0x0123:
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r0 = r3.f18960b
            if (r0 == 0) goto L_0x012e
            java.lang.String r4 = r4.getMessage()
            r0.d(r4)
        L_0x012e:
            r3.d()
            return
        L_0x0132:
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r4 = r3.f18960b
            if (r4 == 0) goto L_0x0139
            r4.e(r2)
        L_0x0139:
            r3.d()
            return
        L_0x013d:
            boolean r0 = r4 instanceof net.one97.paytm.bankCommon.model.PBCJRAccountSummary
            if (r0 == 0) goto L_0x016d
            net.one97.paytm.bankCommon.model.PBCJRAccountSummary r4 = (net.one97.paytm.bankCommon.model.PBCJRAccountSummary) r4
            java.util.ArrayList r0 = r4.getAccounts()
            if (r0 == 0) goto L_0x016d
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ 1
            if (r0 == 0) goto L_0x016d
            net.one97.paytm.paymentsBank.slfd.common.a.a$b r0 = r3.f18960b
            if (r0 == 0) goto L_0x016d
            java.util.ArrayList r4 = r4.getAccounts()
            java.lang.Object r4 = r4.get(r1)
            java.lang.String r1 = "response.accounts.get(0)"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r1)
            net.one97.paytm.bankCommon.model.PBAccountBalanceModel r4 = (net.one97.paytm.bankCommon.model.PBAccountBalanceModel) r4
            double r1 = r4.getEffectiveBalance()
            r0.a((double) r1)
        L_0x016d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.slfd.common.b.a.onResponse(java.lang.Object):void");
    }

    public final void a() {
        a(true);
        c();
    }

    public final void a(boolean z) {
        a.b bVar;
        if (z && (bVar = this.f18960b) != null) {
            bVar.a();
        }
        this.f18961c.a(this.f18962d, this.f18963e, (g.b<IJRPaytmDataModel>) this, (g.a) this);
    }

    public final void c() {
        this.f18961c.c(this.f18964f, this, this);
    }

    private final void d() {
        int i2 = this.f18959a;
        if (i2 < 3) {
            long j = (((long) i2) * 2000) + 1000;
            a.b bVar = this.f18960b;
            if (bVar != null) {
                bVar.a(j);
            }
            this.f18959a++;
        }
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a.b bVar = this.f18960b;
        if (bVar != null) {
            bVar.ai_();
        }
    }

    public final void b() {
        this.f18960b = null;
        b.a aVar = b.f18944a;
        b.f18945d = null;
    }
}
