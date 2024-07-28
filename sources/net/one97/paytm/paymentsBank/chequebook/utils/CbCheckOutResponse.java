package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CbCheckOutResponse extends IJRPaytmDataModel {
    @b(a = "payload")
    private final CbCheckOutPayLoad checkOutPayload;
    @b(a = "requestId")
    private final String requestId;
    @b(a = "responseCode")
    private final Integer responseCode;
    @b(a = "responseMessage")
    private final String responseMessage;

    public static /* synthetic */ CbCheckOutResponse copy$default(CbCheckOutResponse cbCheckOutResponse, String str, Integer num, String str2, CbCheckOutPayLoad cbCheckOutPayLoad, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cbCheckOutResponse.responseMessage;
        }
        if ((i2 & 2) != 0) {
            num = cbCheckOutResponse.responseCode;
        }
        if ((i2 & 4) != 0) {
            str2 = cbCheckOutResponse.requestId;
        }
        if ((i2 & 8) != 0) {
            cbCheckOutPayLoad = cbCheckOutResponse.checkOutPayload;
        }
        return cbCheckOutResponse.copy(str, num, str2, cbCheckOutPayLoad);
    }

    public final String component1() {
        return this.responseMessage;
    }

    public final Integer component2() {
        return this.responseCode;
    }

    public final String component3() {
        return this.requestId;
    }

    public final CbCheckOutPayLoad component4() {
        return this.checkOutPayload;
    }

    public final CbCheckOutResponse copy(String str, Integer num, String str2, CbCheckOutPayLoad cbCheckOutPayLoad) {
        return new CbCheckOutResponse(str, num, str2, cbCheckOutPayLoad);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbCheckOutResponse)) {
            return false;
        }
        CbCheckOutResponse cbCheckOutResponse = (CbCheckOutResponse) obj;
        return k.a((Object) this.responseMessage, (Object) cbCheckOutResponse.responseMessage) && k.a((Object) this.responseCode, (Object) cbCheckOutResponse.responseCode) && k.a((Object) this.requestId, (Object) cbCheckOutResponse.requestId) && k.a((Object) this.checkOutPayload, (Object) cbCheckOutResponse.checkOutPayload);
    }

    public final int hashCode() {
        String str = this.responseMessage;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.responseCode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.requestId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        CbCheckOutPayLoad cbCheckOutPayLoad = this.checkOutPayload;
        if (cbCheckOutPayLoad != null) {
            i2 = cbCheckOutPayLoad.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CbCheckOutResponse(responseMessage=" + this.responseMessage + ", responseCode=" + this.responseCode + ", requestId=" + this.requestId + ", checkOutPayload=" + this.checkOutPayload + ")";
    }

    public final String getResponseMessage() {
        return this.responseMessage;
    }

    public final Integer getResponseCode() {
        return this.responseCode;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public CbCheckOutResponse(String str, Integer num, String str2, CbCheckOutPayLoad cbCheckOutPayLoad) {
        this.responseMessage = str;
        this.responseCode = num;
        this.requestId = str2;
        this.checkOutPayload = cbCheckOutPayLoad;
    }

    public final CbCheckOutPayLoad getCheckOutPayload() {
        return this.checkOutPayload;
    }
}
