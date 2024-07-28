package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CbOrderStatusResponse extends IJRPaytmDataModel {
    @b(a = "payload")
    private final CbOrderStatusPayLoad checkOutPayload;
    @b(a = "requestId")
    private final String requestId;
    @b(a = "responseCode")
    private final Integer responseCode;
    @b(a = "responseMessage")
    private final String responseMessage;

    public static /* synthetic */ CbOrderStatusResponse copy$default(CbOrderStatusResponse cbOrderStatusResponse, String str, Integer num, String str2, CbOrderStatusPayLoad cbOrderStatusPayLoad, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cbOrderStatusResponse.responseMessage;
        }
        if ((i2 & 2) != 0) {
            num = cbOrderStatusResponse.responseCode;
        }
        if ((i2 & 4) != 0) {
            str2 = cbOrderStatusResponse.requestId;
        }
        if ((i2 & 8) != 0) {
            cbOrderStatusPayLoad = cbOrderStatusResponse.checkOutPayload;
        }
        return cbOrderStatusResponse.copy(str, num, str2, cbOrderStatusPayLoad);
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

    public final CbOrderStatusPayLoad component4() {
        return this.checkOutPayload;
    }

    public final CbOrderStatusResponse copy(String str, Integer num, String str2, CbOrderStatusPayLoad cbOrderStatusPayLoad) {
        return new CbOrderStatusResponse(str, num, str2, cbOrderStatusPayLoad);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbOrderStatusResponse)) {
            return false;
        }
        CbOrderStatusResponse cbOrderStatusResponse = (CbOrderStatusResponse) obj;
        return k.a((Object) this.responseMessage, (Object) cbOrderStatusResponse.responseMessage) && k.a((Object) this.responseCode, (Object) cbOrderStatusResponse.responseCode) && k.a((Object) this.requestId, (Object) cbOrderStatusResponse.requestId) && k.a((Object) this.checkOutPayload, (Object) cbOrderStatusResponse.checkOutPayload);
    }

    public final int hashCode() {
        String str = this.responseMessage;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.responseCode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.requestId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        CbOrderStatusPayLoad cbOrderStatusPayLoad = this.checkOutPayload;
        if (cbOrderStatusPayLoad != null) {
            i2 = cbOrderStatusPayLoad.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CbOrderStatusResponse(responseMessage=" + this.responseMessage + ", responseCode=" + this.responseCode + ", requestId=" + this.requestId + ", checkOutPayload=" + this.checkOutPayload + ")";
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

    public CbOrderStatusResponse(String str, Integer num, String str2, CbOrderStatusPayLoad cbOrderStatusPayLoad) {
        this.responseMessage = str;
        this.responseCode = num;
        this.requestId = str2;
        this.checkOutPayload = cbOrderStatusPayLoad;
    }

    public final CbOrderStatusPayLoad getCheckOutPayload() {
        return this.checkOutPayload;
    }
}
