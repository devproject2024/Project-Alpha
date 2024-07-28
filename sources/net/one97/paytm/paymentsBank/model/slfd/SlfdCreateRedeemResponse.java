package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class SlfdCreateRedeemResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "message")
    private String message;
    @b(a = "order_id")
    private String orderId;
    @b(a = "response_code")
    private Integer responseCode;
    @b(a = "status")
    private String status;
    @b(a = "txn_id")
    private String txn_id;

    public SlfdCreateRedeemResponse() {
        this((String) null, (String) null, (Integer) null, (String) null, (String) null, 31, (g) null);
    }

    public static /* synthetic */ SlfdCreateRedeemResponse copy$default(SlfdCreateRedeemResponse slfdCreateRedeemResponse, String str, String str2, Integer num, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = slfdCreateRedeemResponse.message;
        }
        if ((i2 & 2) != 0) {
            str2 = slfdCreateRedeemResponse.orderId;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            num = slfdCreateRedeemResponse.responseCode;
        }
        Integer num2 = num;
        if ((i2 & 8) != 0) {
            str3 = slfdCreateRedeemResponse.status;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            str4 = slfdCreateRedeemResponse.txn_id;
        }
        return slfdCreateRedeemResponse.copy(str, str5, num2, str6, str4);
    }

    public final String component1() {
        return this.message;
    }

    public final String component2() {
        return this.orderId;
    }

    public final Integer component3() {
        return this.responseCode;
    }

    public final String component4() {
        return this.status;
    }

    public final String component5() {
        return this.txn_id;
    }

    public final SlfdCreateRedeemResponse copy(String str, String str2, Integer num, String str3, String str4) {
        return new SlfdCreateRedeemResponse(str, str2, num, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SlfdCreateRedeemResponse)) {
            return false;
        }
        SlfdCreateRedeemResponse slfdCreateRedeemResponse = (SlfdCreateRedeemResponse) obj;
        return k.a((Object) this.message, (Object) slfdCreateRedeemResponse.message) && k.a((Object) this.orderId, (Object) slfdCreateRedeemResponse.orderId) && k.a((Object) this.responseCode, (Object) slfdCreateRedeemResponse.responseCode) && k.a((Object) this.status, (Object) slfdCreateRedeemResponse.status) && k.a((Object) this.txn_id, (Object) slfdCreateRedeemResponse.txn_id);
    }

    public final int hashCode() {
        String str = this.message;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.orderId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.responseCode;
        int hashCode3 = (hashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.status;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.txn_id;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode4 + i2;
    }

    public final String toString() {
        return "SlfdCreateRedeemResponse(message=" + this.message + ", orderId=" + this.orderId + ", responseCode=" + this.responseCode + ", status=" + this.status + ", txn_id=" + this.txn_id + ")";
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final void setOrderId(String str) {
        this.orderId = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SlfdCreateRedeemResponse(java.lang.String r5, java.lang.String r6, java.lang.Integer r7, java.lang.String r8, java.lang.String r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x0008
            r11 = r0
            goto L_0x0009
        L_0x0008:
            r11 = r5
        L_0x0009:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r6
        L_0x0010:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0019
            r5 = 0
            java.lang.Integer r7 = java.lang.Integer.valueOf(r5)
        L_0x0019:
            r2 = r7
            r5 = r10 & 8
            if (r5 == 0) goto L_0x0020
            r3 = r0
            goto L_0x0021
        L_0x0020:
            r3 = r8
        L_0x0021:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0027
            r10 = r0
            goto L_0x0028
        L_0x0027:
            r10 = r9
        L_0x0028:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.paymentsBank.model.slfd.SlfdCreateRedeemResponse.<init>(java.lang.String, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.g.b.g):void");
    }

    public final Integer getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public SlfdCreateRedeemResponse(String str, String str2, Integer num, String str3, String str4) {
        this.message = str;
        this.orderId = str2;
        this.responseCode = num;
        this.status = str3;
        this.txn_id = str4;
    }

    public final String getTxn_id() {
        return this.txn_id;
    }

    public final void setTxn_id(String str) {
        this.txn_id = str;
    }
}
