package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CbPreValidateResponse extends IJRPaytmDataModel {
    @b(a = "payload")
    private final CbPreValidatePayLoad preValidatePayload;
    @b(a = "requestId")
    private final String requestId;
    @b(a = "responseCode")
    private final Integer responseCode;
    @b(a = "responseMessage")
    private final String responseMessage;

    public static /* synthetic */ CbPreValidateResponse copy$default(CbPreValidateResponse cbPreValidateResponse, Integer num, String str, String str2, CbPreValidatePayLoad cbPreValidatePayLoad, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = cbPreValidateResponse.responseCode;
        }
        if ((i2 & 2) != 0) {
            str = cbPreValidateResponse.responseMessage;
        }
        if ((i2 & 4) != 0) {
            str2 = cbPreValidateResponse.requestId;
        }
        if ((i2 & 8) != 0) {
            cbPreValidatePayLoad = cbPreValidateResponse.preValidatePayload;
        }
        return cbPreValidateResponse.copy(num, str, str2, cbPreValidatePayLoad);
    }

    public final Integer component1() {
        return this.responseCode;
    }

    public final String component2() {
        return this.responseMessage;
    }

    public final String component3() {
        return this.requestId;
    }

    public final CbPreValidatePayLoad component4() {
        return this.preValidatePayload;
    }

    public final CbPreValidateResponse copy(Integer num, String str, String str2, CbPreValidatePayLoad cbPreValidatePayLoad) {
        return new CbPreValidateResponse(num, str, str2, cbPreValidatePayLoad);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbPreValidateResponse)) {
            return false;
        }
        CbPreValidateResponse cbPreValidateResponse = (CbPreValidateResponse) obj;
        return k.a((Object) this.responseCode, (Object) cbPreValidateResponse.responseCode) && k.a((Object) this.responseMessage, (Object) cbPreValidateResponse.responseMessage) && k.a((Object) this.requestId, (Object) cbPreValidateResponse.requestId) && k.a((Object) this.preValidatePayload, (Object) cbPreValidateResponse.preValidatePayload);
    }

    public final int hashCode() {
        Integer num = this.responseCode;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.responseMessage;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.requestId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        CbPreValidatePayLoad cbPreValidatePayLoad = this.preValidatePayload;
        if (cbPreValidatePayLoad != null) {
            i2 = cbPreValidatePayLoad.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CbPreValidateResponse(responseCode=" + this.responseCode + ", responseMessage=" + this.responseMessage + ", requestId=" + this.requestId + ", preValidatePayload=" + this.preValidatePayload + ")";
    }

    public final Integer getResponseCode() {
        return this.responseCode;
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public CbPreValidateResponse(Integer num, String str, String str2, CbPreValidatePayLoad cbPreValidatePayLoad) {
        this.responseCode = num;
        this.responseMessage = str;
        this.requestId = str2;
        this.preValidatePayload = cbPreValidatePayLoad;
    }

    public final CbPreValidatePayLoad getPreValidatePayload() {
        return this.preValidatePayload;
    }
}
