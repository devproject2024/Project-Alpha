package net.one97.paytm.upi.common.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;
import net.one97.paytm.upi.util.UpiRequestBuilder;

public final class GetOtpResponse extends IJRPaytmDataModel {
    @b(a = "respCode")
    private final String respCode;
    @b(a = "respMessage")
    private final String respMessage;
    @b(a = "seqNo")
    private final String seqNo;
    @b(a = "status")
    private final String status;

    public static /* synthetic */ GetOtpResponse copy$default(GetOtpResponse getOtpResponse, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = getOtpResponse.status;
        }
        if ((i2 & 2) != 0) {
            str2 = getOtpResponse.respCode;
        }
        if ((i2 & 4) != 0) {
            str3 = getOtpResponse.respMessage;
        }
        if ((i2 & 8) != 0) {
            str4 = getOtpResponse.seqNo;
        }
        return getOtpResponse.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.status;
    }

    public final String component2() {
        return this.respCode;
    }

    public final String component3() {
        return this.respMessage;
    }

    public final String component4() {
        return this.seqNo;
    }

    public final GetOtpResponse copy(String str, String str2, String str3, String str4) {
        k.c(str, "status");
        k.c(str2, "respCode");
        k.c(str3, "respMessage");
        k.c(str4, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        return new GetOtpResponse(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetOtpResponse)) {
            return false;
        }
        GetOtpResponse getOtpResponse = (GetOtpResponse) obj;
        return k.a((Object) this.status, (Object) getOtpResponse.status) && k.a((Object) this.respCode, (Object) getOtpResponse.respCode) && k.a((Object) this.respMessage, (Object) getOtpResponse.respMessage) && k.a((Object) this.seqNo, (Object) getOtpResponse.seqNo);
    }

    public final int hashCode() {
        String str = this.status;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.respCode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.respMessage;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.seqNo;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "GetOtpResponse(status=" + this.status + ", respCode=" + this.respCode + ", respMessage=" + this.respMessage + ", seqNo=" + this.seqNo + ")";
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getRespCode() {
        return this.respCode;
    }

    public final String getRespMessage() {
        return this.respMessage;
    }

    public final String getSeqNo() {
        return this.seqNo;
    }

    public GetOtpResponse(String str, String str2, String str3, String str4) {
        k.c(str, "status");
        k.c(str2, "respCode");
        k.c(str3, "respMessage");
        k.c(str4, UpiRequestBuilder.KEY_SEQ_NO_CAMEL_CASE);
        this.status = str;
        this.respCode = str2;
        this.respMessage = str3;
        this.seqNo = str4;
    }
}
