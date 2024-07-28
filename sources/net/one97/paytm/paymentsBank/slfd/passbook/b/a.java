package net.one97.paytm.paymentsBank.slfd.passbook.b;

import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import kotlin.g.b.k;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.paymentsBank.slfd.a.a.b;
import net.one97.paytm.paymentsBank.slfd.passbook.a.a;

public final class a implements g.a, g.b<IJRPaytmDataModel>, a.C0340a {

    /* renamed from: a  reason: collision with root package name */
    private final String f19253a;

    /* renamed from: b  reason: collision with root package name */
    private final String f19254b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19255c;

    /* renamed from: d  reason: collision with root package name */
    private final b f19256d;

    /* renamed from: e  reason: collision with root package name */
    private a.b f19257e;

    public a(String str, String str2, String str3, b bVar, a.b bVar2) {
        k.c(str, "orderId");
        k.c(str2, "custId");
        k.c(str3, SDKConstants.TXN_TYPE);
        k.c(bVar, "dataRepository");
        this.f19253a = str;
        this.f19254b = str2;
        this.f19255c = str3;
        this.f19256d = bVar;
        this.f19257e = bVar2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void onResponse(java.lang.Object r10) {
        /*
            r9 = this;
            com.paytm.network.model.IJRPaytmDataModel r10 = (com.paytm.network.model.IJRPaytmDataModel) r10
            boolean r0 = r10 instanceof net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse
            if (r0 == 0) goto L_0x018f
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r0 = r9.f19257e
            if (r0 == 0) goto L_0x000d
            r0.aj_()
        L_0x000d:
            java.lang.String r0 = r9.f19255c
            int r1 = r0.hashCode()
            r2 = -1087827628(0xffffffffbf291154, float:-0.66042066)
            r3 = 1184(0x4a0, float:1.659E-42)
            r4 = 1186(0x4a2, float:1.662E-42)
            r5 = 1185(0x4a1, float:1.66E-42)
            r6 = 1183(0x49f, float:1.658E-42)
            r7 = 0
            r8 = 1182(0x49e, float:1.656E-42)
            if (r1 == r2) goto L_0x00c1
            r2 = -1037516960(0xffffffffc228bf60, float:-42.18689)
            if (r1 == r2) goto L_0x002a
            goto L_0x0188
        L_0x002a:
            java.lang.String r1 = "IBL_FD_REDEMPTION"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0188
            net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse r10 = (net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse) r10
            net.one97.paytm.paymentsBank.model.slfd.RedemptionResponse r10 = r10.getRedemptionResponse()
            if (r10 == 0) goto L_0x00b9
            java.util.List r0 = r10.getRedemptionList()
            if (r0 == 0) goto L_0x004b
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r0 = r9.f19257e
            if (r0 == 0) goto L_0x004b
            java.util.List r1 = r10.getRedemptionList()
            r0.a((java.util.List<net.one97.paytm.paymentsBank.model.slfd.RedemptionResponseListItem>) r1)
        L_0x004b:
            java.lang.Integer r0 = r10.getMasterStatus()
            if (r0 != 0) goto L_0x0052
            goto L_0x0064
        L_0x0052:
            int r1 = r0.intValue()
            if (r1 != r8) goto L_0x0064
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r0 = r9.f19257e
            if (r0 == 0) goto L_0x0063
            java.lang.String r10 = r10.getMessage()
            r0.f(r10)
        L_0x0063:
            return
        L_0x0064:
            if (r0 != 0) goto L_0x0067
            goto L_0x0079
        L_0x0067:
            int r1 = r0.intValue()
            if (r1 != r6) goto L_0x0079
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r0 = r9.f19257e
            if (r0 == 0) goto L_0x0078
            java.lang.String r10 = r10.getMessage()
            r0.d(r10)
        L_0x0078:
            return
        L_0x0079:
            if (r0 != 0) goto L_0x007c
            goto L_0x008e
        L_0x007c:
            int r1 = r0.intValue()
            if (r1 != r3) goto L_0x008e
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r0 = r9.f19257e
            if (r0 == 0) goto L_0x008d
            java.lang.String r10 = r10.getMessage()
            r0.e(r10)
        L_0x008d:
            return
        L_0x008e:
            if (r0 != 0) goto L_0x0091
            goto L_0x0097
        L_0x0091:
            int r1 = r0.intValue()
            if (r1 == r5) goto L_0x00ad
        L_0x0097:
            if (r0 != 0) goto L_0x009a
            goto L_0x00a1
        L_0x009a:
            int r0 = r0.intValue()
            if (r0 != r4) goto L_0x00a1
            goto L_0x00ad
        L_0x00a1:
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r0 = r9.f19257e
            if (r0 == 0) goto L_0x00ac
            java.lang.String r10 = r10.getMessage()
            r0.d(r10)
        L_0x00ac:
            return
        L_0x00ad:
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r0 = r9.f19257e
            if (r0 == 0) goto L_0x00b8
            java.lang.String r10 = r10.getMessage()
            r0.g(r10)
        L_0x00b8:
            return
        L_0x00b9:
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r10 = r9.f19257e
            if (r10 == 0) goto L_0x00c0
            r10.d(r7)
        L_0x00c0:
            return
        L_0x00c1:
            java.lang.String r1 = "IBL_FD_CREATION"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0188
            net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse r10 = (net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse) r10
            net.one97.paytm.paymentsBank.model.slfd.BookingResponse r10 = r10.getBookingResponse()
            if (r10 != 0) goto L_0x00db
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r10 = r9.f19257e
            if (r10 == 0) goto L_0x00da
            java.lang.String r0 = "Something went wrong"
            r10.c(r0)
        L_0x00da:
            return
        L_0x00db:
            java.util.List r0 = r10.getBookingResponseList()
            java.lang.Integer r1 = r10.getMasterStatus()
            if (r1 != 0) goto L_0x00e6
            goto L_0x00ff
        L_0x00e6:
            int r2 = r1.intValue()
            if (r2 != r8) goto L_0x00ff
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r1 = r9.f19257e
            if (r1 == 0) goto L_0x00f7
            java.lang.String r10 = r10.getMessage()
            r1.b((java.lang.String) r10)
        L_0x00f7:
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r10 = r9.f19257e
            if (r10 == 0) goto L_0x00fe
            r10.b((java.util.List<net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem>) r0)
        L_0x00fe:
            return
        L_0x00ff:
            if (r1 != 0) goto L_0x0102
            goto L_0x0114
        L_0x0102:
            int r2 = r1.intValue()
            if (r2 != r6) goto L_0x0114
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r0 = r9.f19257e
            if (r0 == 0) goto L_0x0113
            java.lang.String r10 = r10.getMessage()
            r0.a((java.lang.String) r10)
        L_0x0113:
            return
        L_0x0114:
            if (r1 != 0) goto L_0x0117
            goto L_0x011d
        L_0x0117:
            int r2 = r1.intValue()
            if (r2 == r5) goto L_0x013c
        L_0x011d:
            if (r1 != 0) goto L_0x0120
            goto L_0x0127
        L_0x0120:
            int r2 = r1.intValue()
            if (r2 != r4) goto L_0x0127
            goto L_0x013c
        L_0x0127:
            if (r1 != 0) goto L_0x012a
            return
        L_0x012a:
            int r0 = r1.intValue()
            if (r0 != r3) goto L_0x0187
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r0 = r9.f19257e
            if (r0 == 0) goto L_0x0187
            java.lang.String r10 = r10.getMessage()
            r0.c(r10)
            return
        L_0x013c:
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r1 = r9.f19257e
            if (r1 == 0) goto L_0x0147
            java.lang.String r10 = r10.getMessage()
            r1.a((java.lang.String) r10)
        L_0x0147:
            r10 = 0
            if (r0 == 0) goto L_0x0178
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0157:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0175
            java.lang.Object r2 = r0.next()
            r3 = r2
            net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem r3 = (net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem) r3
            java.lang.String r3 = r3.getStatus()
            java.lang.String r4 = "success"
            boolean r3 = kotlin.m.p.a((java.lang.String) r3, (java.lang.String) r4, (boolean) r10)
            if (r3 == 0) goto L_0x0157
            r1.add(r2)
            goto L_0x0157
        L_0x0175:
            r7 = r1
            java.util.List r7 = (java.util.List) r7
        L_0x0178:
            if (r7 == 0) goto L_0x017e
            int r10 = r7.size()
        L_0x017e:
            if (r10 <= 0) goto L_0x0187
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r10 = r9.f19257e
            if (r10 == 0) goto L_0x0187
            r10.b((java.util.List<net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem>) r7)
        L_0x0187:
            return
        L_0x0188:
            net.one97.paytm.paymentsBank.slfd.passbook.a.a$b r10 = r9.f19257e
            if (r10 == 0) goto L_0x018f
            r10.b()
        L_0x018f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.slfd.passbook.b.a.onResponse(java.lang.Object):void");
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        a.b bVar = this.f19257e;
        if (bVar != null) {
            bVar.b();
        }
    }

    public final void b() {
        this.f19257e = null;
        b.a aVar = b.f18944a;
        b.f18945d = null;
    }

    public final void a() {
        a.b bVar = this.f19257e;
        if (bVar != null) {
            bVar.a();
        }
        this.f19256d.a(this.f19253a, this.f19254b, (g.b<IJRPaytmDataModel>) this, (g.a) this);
    }
}
