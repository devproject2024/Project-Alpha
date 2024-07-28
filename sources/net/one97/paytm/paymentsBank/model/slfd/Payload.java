package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.upi.util.UpiConstants;

public final class Payload extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "amount")
    private final Double amount;
    @b(a = "benfname1")
    private final String beneficiaryName1;
    @b(a = "benfname2")
    private final String beneficiaryName2;
    @b(a = "errorMessage")
    private final String errorMessage;
    @b(a = "message")
    private final String message;
    @b(a = "order_id")
    private final String order_id;
    @b(a = "orderid")
    private final String orderid;
    @b(a = "pg_url_to_hit")
    private final String pgUrl;
    @b(a = "status")
    private final String status;
    @b(a = "targetAccountNumber")
    private final String targetAccountNumber;

    public static /* synthetic */ Payload copy$default(Payload payload, String str, String str2, Double d2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, Object obj) {
        Payload payload2 = payload;
        int i3 = i2;
        return payload.copy((i3 & 1) != 0 ? payload2.status : str, (i3 & 2) != 0 ? payload2.errorMessage : str2, (i3 & 4) != 0 ? payload2.amount : d2, (i3 & 8) != 0 ? payload2.message : str3, (i3 & 16) != 0 ? payload2.orderid : str4, (i3 & 32) != 0 ? payload2.order_id : str5, (i3 & 64) != 0 ? payload2.pgUrl : str6, (i3 & 128) != 0 ? payload2.targetAccountNumber : str7, (i3 & UpiConstants.REQUEST_OPEN_APP_PERMISSION_READ_SMS) != 0 ? payload2.beneficiaryName1 : str8, (i3 & 512) != 0 ? payload2.beneficiaryName2 : str9);
    }

    public final String component1() {
        return this.status;
    }

    public final String component10() {
        return this.beneficiaryName2;
    }

    public final String component2() {
        return this.errorMessage;
    }

    public final Double component3() {
        return this.amount;
    }

    public final String component4() {
        return this.message;
    }

    public final String component5() {
        return this.orderid;
    }

    public final String component6() {
        return this.order_id;
    }

    public final String component7() {
        return this.pgUrl;
    }

    public final String component8() {
        return this.targetAccountNumber;
    }

    public final String component9() {
        return this.beneficiaryName1;
    }

    public final Payload copy(String str, String str2, Double d2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        k.c(str, "status");
        return new Payload(str, str2, d2, str3, str4, str5, str6, str7, str8, str9);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Payload)) {
            return false;
        }
        Payload payload = (Payload) obj;
        return k.a((Object) this.status, (Object) payload.status) && k.a((Object) this.errorMessage, (Object) payload.errorMessage) && k.a((Object) this.amount, (Object) payload.amount) && k.a((Object) this.message, (Object) payload.message) && k.a((Object) this.orderid, (Object) payload.orderid) && k.a((Object) this.order_id, (Object) payload.order_id) && k.a((Object) this.pgUrl, (Object) payload.pgUrl) && k.a((Object) this.targetAccountNumber, (Object) payload.targetAccountNumber) && k.a((Object) this.beneficiaryName1, (Object) payload.beneficiaryName1) && k.a((Object) this.beneficiaryName2, (Object) payload.beneficiaryName2);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.errorMessage;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Double d2 = this.amount;
        int hashCode3 = (hashCode2 + (d2 != null ? d2.hashCode() : 0)) * 31;
        String str3 = this.message;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.orderid;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.order_id;
        int hashCode6 = (hashCode5 + (str5 != null ? str5.hashCode() : 0)) * 31;
        String str6 = this.pgUrl;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.targetAccountNumber;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.beneficiaryName1;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.beneficiaryName2;
        if (str9 != null) {
            i2 = str9.hashCode();
        }
        return hashCode9 + i2;
    }

    public final String toString() {
        return "Payload(status=" + this.status + ", errorMessage=" + this.errorMessage + ", amount=" + this.amount + ", message=" + this.message + ", orderid=" + this.orderid + ", order_id=" + this.order_id + ", pgUrl=" + this.pgUrl + ", targetAccountNumber=" + this.targetAccountNumber + ", beneficiaryName1=" + this.beneficiaryName1 + ", beneficiaryName2=" + this.beneficiaryName2 + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getOrderid() {
        return this.orderid;
    }

    public final String getOrder_id() {
        return this.order_id;
    }

    public final String getPgUrl() {
        return this.pgUrl;
    }

    public final String getTargetAccountNumber() {
        return this.targetAccountNumber;
    }

    public final String getBeneficiaryName1() {
        return this.beneficiaryName1;
    }

    public Payload(String str, String str2, Double d2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        k.c(str, "status");
        this.status = str;
        this.errorMessage = str2;
        this.amount = d2;
        this.message = str3;
        this.orderid = str4;
        this.order_id = str5;
        this.pgUrl = str6;
        this.targetAccountNumber = str7;
        this.beneficiaryName1 = str8;
        this.beneficiaryName2 = str9;
    }

    public final String getBeneficiaryName2() {
        return this.beneficiaryName2;
    }
}
