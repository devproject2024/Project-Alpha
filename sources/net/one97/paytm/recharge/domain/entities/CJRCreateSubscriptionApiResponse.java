package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class CJRCreateSubscriptionApiResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "hitPG")
    private final String hitPG;
    @b(a = "MID")
    private final String mid;
    @b(a = "native_withdraw")
    private final String nativeWithDraw;
    @b(a = "native_withdraw_details")
    private final CJRNativeWithDrawDetails nativeWithDrawDetail;
    @b(a = "ORDER_ID")
    private final Long orderId;
    @b(a = "status")
    private final String status;
    @b(a = "TXN_AMOUNT")
    private final Long txnAmount;

    public CJRCreateSubscriptionApiResponse() {
        this((String) null, (String) null, (Long) null, (String) null, (Long) null, (String) null, (CJRNativeWithDrawDetails) null, 127, (g) null);
    }

    public static /* synthetic */ CJRCreateSubscriptionApiResponse copy$default(CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse, String str, String str2, Long l, String str3, Long l2, String str4, CJRNativeWithDrawDetails cJRNativeWithDrawDetails, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRCreateSubscriptionApiResponse.status;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRCreateSubscriptionApiResponse.hitPG;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            l = cJRCreateSubscriptionApiResponse.orderId;
        }
        Long l3 = l;
        if ((i2 & 8) != 0) {
            str3 = cJRCreateSubscriptionApiResponse.mid;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            l2 = cJRCreateSubscriptionApiResponse.txnAmount;
        }
        Long l4 = l2;
        if ((i2 & 32) != 0) {
            str4 = cJRCreateSubscriptionApiResponse.nativeWithDraw;
        }
        String str7 = str4;
        if ((i2 & 64) != 0) {
            cJRNativeWithDrawDetails = cJRCreateSubscriptionApiResponse.nativeWithDrawDetail;
        }
        return cJRCreateSubscriptionApiResponse.copy(str, str5, l3, str6, l4, str7, cJRNativeWithDrawDetails);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.hitPG;
    }

    public final Long component3() {
        return this.orderId;
    }

    public final String component4() {
        return this.mid;
    }

    public final Long component5() {
        return this.txnAmount;
    }

    public final String component6() {
        return this.nativeWithDraw;
    }

    public final CJRNativeWithDrawDetails component7() {
        return this.nativeWithDrawDetail;
    }

    public final CJRCreateSubscriptionApiResponse copy(String str, String str2, Long l, String str3, Long l2, String str4, CJRNativeWithDrawDetails cJRNativeWithDrawDetails) {
        return new CJRCreateSubscriptionApiResponse(str, str2, l, str3, l2, str4, cJRNativeWithDrawDetails);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRCreateSubscriptionApiResponse)) {
            return false;
        }
        CJRCreateSubscriptionApiResponse cJRCreateSubscriptionApiResponse = (CJRCreateSubscriptionApiResponse) obj;
        return k.a((Object) this.status, (Object) cJRCreateSubscriptionApiResponse.status) && k.a((Object) this.hitPG, (Object) cJRCreateSubscriptionApiResponse.hitPG) && k.a((Object) this.orderId, (Object) cJRCreateSubscriptionApiResponse.orderId) && k.a((Object) this.mid, (Object) cJRCreateSubscriptionApiResponse.mid) && k.a((Object) this.txnAmount, (Object) cJRCreateSubscriptionApiResponse.txnAmount) && k.a((Object) this.nativeWithDraw, (Object) cJRCreateSubscriptionApiResponse.nativeWithDraw) && k.a((Object) this.nativeWithDrawDetail, (Object) cJRCreateSubscriptionApiResponse.nativeWithDrawDetail);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.hitPG;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Long l = this.orderId;
        int hashCode3 = (hashCode2 + (l != null ? l.hashCode() : 0)) * 31;
        String str3 = this.mid;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Long l2 = this.txnAmount;
        int hashCode5 = (hashCode4 + (l2 != null ? l2.hashCode() : 0)) * 31;
        String str4 = this.nativeWithDraw;
        int hashCode6 = (hashCode5 + (str4 != null ? str4.hashCode() : 0)) * 31;
        CJRNativeWithDrawDetails cJRNativeWithDrawDetails = this.nativeWithDrawDetail;
        if (cJRNativeWithDrawDetails != null) {
            i2 = cJRNativeWithDrawDetails.hashCode();
        }
        return hashCode6 + i2;
    }

    public final String toString() {
        return "CJRCreateSubscriptionApiResponse(status=" + this.status + ", hitPG=" + this.hitPG + ", orderId=" + this.orderId + ", mid=" + this.mid + ", txnAmount=" + this.txnAmount + ", nativeWithDraw=" + this.nativeWithDraw + ", nativeWithDrawDetail=" + this.nativeWithDrawDetail + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getHitPG() {
        return this.hitPG;
    }

    public final Long getOrderId() {
        return this.orderId;
    }

    public final String getMid() {
        return this.mid;
    }

    public final Long getTxnAmount() {
        return this.txnAmount;
    }

    public final String getNativeWithDraw() {
        return this.nativeWithDraw;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CJRCreateSubscriptionApiResponse(java.lang.String r7, java.lang.String r8, java.lang.Long r9, java.lang.String r10, java.lang.Long r11, java.lang.String r12, net.one97.paytm.recharge.domain.entities.CJRNativeWithDrawDetails r13, int r14, kotlin.g.b.g r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.recharge.domain.entities.CJRCreateSubscriptionApiResponse.<init>(java.lang.String, java.lang.String, java.lang.Long, java.lang.String, java.lang.Long, java.lang.String, net.one97.paytm.recharge.domain.entities.CJRNativeWithDrawDetails, int, kotlin.g.b.g):void");
    }

    public final CJRNativeWithDrawDetails getNativeWithDrawDetail() {
        return this.nativeWithDrawDetail;
    }

    public CJRCreateSubscriptionApiResponse(String str, String str2, Long l, String str3, Long l2, String str4, CJRNativeWithDrawDetails cJRNativeWithDrawDetails) {
        this.status = str;
        this.hitPG = str2;
        this.orderId = l;
        this.mid = str3;
        this.txnAmount = l2;
        this.nativeWithDraw = str4;
        this.nativeWithDrawDetail = cJRNativeWithDrawDetails;
    }
}
