package net.one97.paytm.upi.common.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.upi.common.upi.UpiCheckBalanceModel;

public final class CheckBalanceV4Response extends IJRPaytmDataModel {
    @b(a = "respCode")
    private final String responseCode;
    @b(a = "respMessage")
    private final String responseMessage;
    @b(a = "status")
    private final String status;
    @b(a = "userBalanceDetail")
    private final UpiCheckBalanceModel userBalanceDetail;

    public static /* synthetic */ CheckBalanceV4Response copy$default(CheckBalanceV4Response checkBalanceV4Response, UpiCheckBalanceModel upiCheckBalanceModel, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            upiCheckBalanceModel = checkBalanceV4Response.userBalanceDetail;
        }
        if ((i2 & 2) != 0) {
            str = checkBalanceV4Response.status;
        }
        if ((i2 & 4) != 0) {
            str2 = checkBalanceV4Response.responseCode;
        }
        if ((i2 & 8) != 0) {
            str3 = checkBalanceV4Response.responseMessage;
        }
        return checkBalanceV4Response.copy(upiCheckBalanceModel, str, str2, str3);
    }

    public final UpiCheckBalanceModel component1() {
        return this.userBalanceDetail;
    }

    public final String component2() {
        return this.status;
    }

    public final String component3() {
        return this.responseCode;
    }

    public final String component4() {
        return this.responseMessage;
    }

    public final CheckBalanceV4Response copy(UpiCheckBalanceModel upiCheckBalanceModel, String str, String str2, String str3) {
        k.c(str, "status");
        k.c(str2, "responseCode");
        k.c(str3, "responseMessage");
        return new CheckBalanceV4Response(upiCheckBalanceModel, str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CheckBalanceV4Response)) {
            return false;
        }
        CheckBalanceV4Response checkBalanceV4Response = (CheckBalanceV4Response) obj;
        return k.a((Object) this.userBalanceDetail, (Object) checkBalanceV4Response.userBalanceDetail) && k.a((Object) this.status, (Object) checkBalanceV4Response.status) && k.a((Object) this.responseCode, (Object) checkBalanceV4Response.responseCode) && k.a((Object) this.responseMessage, (Object) checkBalanceV4Response.responseMessage);
    }

    public final int hashCode() {
        UpiCheckBalanceModel upiCheckBalanceModel = this.userBalanceDetail;
        int i2 = 0;
        int hashCode = (upiCheckBalanceModel != null ? upiCheckBalanceModel.hashCode() : 0) * 31;
        String str = this.status;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.responseCode;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.responseMessage;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CheckBalanceV4Response(userBalanceDetail=" + this.userBalanceDetail + ", status=" + this.status + ", responseCode=" + this.responseCode + ", responseMessage=" + this.responseMessage + ")";
    }

    public final UpiCheckBalanceModel getUserBalanceDetail() {
        return this.userBalanceDetail;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public CheckBalanceV4Response(UpiCheckBalanceModel upiCheckBalanceModel, String str, String str2, String str3) {
        k.c(str, "status");
        k.c(str2, "responseCode");
        k.c(str3, "responseMessage");
        this.userBalanceDetail = upiCheckBalanceModel;
        this.status = str;
        this.responseCode = str2;
        this.responseMessage = str3;
    }
}
