package net.one97.paytm.paymentsBank.createfd.d;

import com.business.merchant_payments.common.utility.AppUtility;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sendbird.android.constant.StringSet;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.a;
import net.one97.paytm.bankCommon.model.PBCJRAccountSummary;
import net.one97.paytm.paymentsBank.createfd.c.e;
import net.one97.paytm.paymentsBank.createfd.model.CreateFdModel;
import net.one97.paytm.paymentsBank.createfd.utils.b;
import net.one97.paytm.paymentsBank.model.slfd.BookingResponse;
import net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse;
import net.one97.paytm.paymentsBank.utils.i;
import net.one97.paytm.paymentsBank.utils.j;

public final class b implements g.a, g.b<IJRPaytmDataModel>, e.a {

    /* renamed from: a  reason: collision with root package name */
    private PBCJRAccountSummary f18140a;

    /* renamed from: b  reason: collision with root package name */
    private String f18141b;

    /* renamed from: c  reason: collision with root package name */
    private double f18142c;

    /* renamed from: d  reason: collision with root package name */
    private final net.one97.paytm.paymentsBank.slfd.a.a.b f18143d;

    /* renamed from: e  reason: collision with root package name */
    private final e.b f18144e;

    public b(net.one97.paytm.paymentsBank.slfd.a.a.b bVar, e.b bVar2) {
        k.c(bVar, "dataRepository");
        k.c(bVar2, "view");
        this.f18143d = bVar;
        this.f18144e = bVar2;
        if (j.a().equals("ISA")) {
            this.f18141b = "isa";
        } else {
            this.f18141b = "ica";
        }
        this.f18142c = 1.0d;
    }

    public final /* synthetic */ void onResponse(Object obj) {
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        if (iJRPaytmDataModel instanceof TransactionDetailResponse) {
            this.f18144e.a((TransactionDetailResponse) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CreateFdModel) {
            this.f18144e.a((CreateFdModel) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof PBCJRAccountSummary) {
            this.f18140a = (PBCJRAccountSummary) iJRPaytmDataModel;
            this.f18144e.g();
        }
    }

    public final void a(String str, String str2) {
        k.c(str, StringSet.token);
        k.c(str2, "amt");
        this.f18144e.a(true);
        this.f18143d.b(str, str2, this, this);
    }

    public final b.a.c a(TransactionDetailResponse transactionDetailResponse) {
        BookingResponse bookingResponse;
        Integer masterStatus;
        if (transactionDetailResponse == null || (bookingResponse = transactionDetailResponse.getBookingResponse()) == null || (masterStatus = bookingResponse.getMasterStatus()) == null) {
            return d();
        }
        int intValue = masterStatus.intValue();
        b.a aVar = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        if (intValue == net.one97.paytm.paymentsBank.createfd.utils.b.s) {
            return b.a.c.FAILED;
        }
        b.a aVar2 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a;
        if (intValue == net.one97.paytm.paymentsBank.createfd.utils.b.q) {
            return b.a.c.SUCCESS;
        }
        return d();
    }

    private b.a.c d() {
        if (this.f18142c >= 5.0d) {
            return b.a.c.PENDING;
        }
        return b.a.c.PROCESSING;
    }

    public final long a() {
        double d2 = this.f18142c;
        this.f18142c = 1.0d + d2;
        return ((long) Math.pow(2.0d, d2)) * 1000;
    }

    public final String b(String str, String str2) {
        k.c(str2, "dotPlaceName");
        if (str != null) {
            try {
                if (p.a((CharSequence) str, (CharSequence) AppUtility.CENTER_DOT, false)) {
                    String substring = str.substring(0, p.a((CharSequence) str, AppUtility.CENTER_DOT, 0, false, 6));
                    k.a((Object) substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String substring2 = str.substring(p.a((CharSequence) str, AppUtility.CENTER_DOT, 0, false, 6) + 1, str.length());
                    k.a((Object) substring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    String ab = a.ab(substring);
                    k.a((Object) ab, "CJRAppUtility.getCleanString(str)");
                    String a2 = i.a(Long.parseLong(ab));
                    k.a((Object) a2, "NumberToWordsConverter.c…leanString(str).toLong())");
                    String ab2 = a.ab(substring2);
                    k.a((Object) ab2, "CJRAppUtility.getCleanString(decimal)");
                    String a3 = i.a(Long.parseLong(ab2));
                    return a2 + " " + str2 + " " + a3;
                }
            } catch (Exception unused) {
                return "";
            }
        }
        String ab3 = a.ab(str);
        k.a((Object) ab3, "CJRAppUtility.getCleanString(amount)");
        return i.a(Long.parseLong(ab3));
    }

    public final void a(String str) {
        k.c(str, "orderId");
        net.one97.paytm.paymentsBank.slfd.a.a.b bVar = this.f18143d;
        String str2 = this.f18141b;
        if (str2 == null) {
            k.a();
        }
        bVar.c(str, str2, this, this);
    }

    public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (iJRPaytmDataModel instanceof TransactionDetailResponse) {
            e.b bVar = this.f18144e;
            if (networkCustomError == null) {
                k.a();
            }
            bVar.a(networkCustomError, b.a.c.PENDING);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028 A[Catch:{ Exception -> 0x0034 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 == 0) goto L_0x0021
            net.one97.paytm.paymentsBank.model.slfd.BookingResponse r5 = r5.getBookingResponse()     // Catch:{ Exception -> 0x0034 }
            if (r5 == 0) goto L_0x0021
            java.util.List r5 = r5.getBookingResponseList()     // Catch:{ Exception -> 0x0034 }
            if (r5 == 0) goto L_0x0021
            r1 = 0
            java.lang.Object r5 = r5.get(r1)     // Catch:{ Exception -> 0x0034 }
            net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem r5 = (net.one97.paytm.paymentsBank.model.slfd.BookingResponseListItem) r5     // Catch:{ Exception -> 0x0034 }
            if (r5 == 0) goto L_0x0021
            long r1 = r5.getFdBookingDate()     // Catch:{ Exception -> 0x0034 }
            java.lang.Long r5 = java.lang.Long.valueOf(r1)     // Catch:{ Exception -> 0x0034 }
            goto L_0x0022
        L_0x0021:
            r5 = r0
        L_0x0022:
            net.one97.paytm.paymentsBank.createfd.utils.b$a r1 = net.one97.paytm.paymentsBank.createfd.utils.b.f18186a     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = "hh:mm a, dd MMM yyyy"
            if (r5 != 0) goto L_0x002b
            kotlin.g.b.k.a()     // Catch:{ Exception -> 0x0034 }
        L_0x002b:
            long r2 = r5.longValue()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r5 = net.one97.paytm.paymentsBank.createfd.utils.b.a.a(r1, r2)     // Catch:{ Exception -> 0x0034 }
            return r5
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.createfd.d.b.b(net.one97.paytm.paymentsBank.model.slfd.TransactionDetailResponse):java.lang.String");
    }

    public final void b() {
        this.f18143d.c("", this, this);
    }

    public final PBCJRAccountSummary c() {
        return this.f18140a;
    }
}
