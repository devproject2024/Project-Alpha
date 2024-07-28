package net.one97.paytm.paymentsBank.chequebook.utils;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.k;

public final class CbTrackingResponse extends IJRPaytmDataModel {
    @b(a = "requestId")
    private final String requestId;
    @b(a = "responseCode")
    private final Integer responseCode;
    @b(a = "responseMessage")
    private final String responseMessage;
    @b(a = "payload")
    private final CbTrackingPayLoad trackingPayload;

    public static /* synthetic */ CbTrackingResponse copy$default(CbTrackingResponse cbTrackingResponse, String str, Integer num, String str2, CbTrackingPayLoad cbTrackingPayLoad, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cbTrackingResponse.responseMessage;
        }
        if ((i2 & 2) != 0) {
            num = cbTrackingResponse.responseCode;
        }
        if ((i2 & 4) != 0) {
            str2 = cbTrackingResponse.requestId;
        }
        if ((i2 & 8) != 0) {
            cbTrackingPayLoad = cbTrackingResponse.trackingPayload;
        }
        return cbTrackingResponse.copy(str, num, str2, cbTrackingPayLoad);
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

    public final CbTrackingPayLoad component4() {
        return this.trackingPayload;
    }

    public final CbTrackingResponse copy(String str, Integer num, String str2, CbTrackingPayLoad cbTrackingPayLoad) {
        return new CbTrackingResponse(str, num, str2, cbTrackingPayLoad);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CbTrackingResponse)) {
            return false;
        }
        CbTrackingResponse cbTrackingResponse = (CbTrackingResponse) obj;
        return k.a((Object) this.responseMessage, (Object) cbTrackingResponse.responseMessage) && k.a((Object) this.responseCode, (Object) cbTrackingResponse.responseCode) && k.a((Object) this.requestId, (Object) cbTrackingResponse.requestId) && k.a((Object) this.trackingPayload, (Object) cbTrackingResponse.trackingPayload);
    }

    public final int hashCode() {
        String str = this.responseMessage;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Integer num = this.responseCode;
        int hashCode2 = (hashCode + (num != null ? num.hashCode() : 0)) * 31;
        String str2 = this.requestId;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        CbTrackingPayLoad cbTrackingPayLoad = this.trackingPayload;
        if (cbTrackingPayLoad != null) {
            i2 = cbTrackingPayLoad.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "CbTrackingResponse(responseMessage=" + this.responseMessage + ", responseCode=" + this.responseCode + ", requestId=" + this.requestId + ", trackingPayload=" + this.trackingPayload + ")";
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

    public CbTrackingResponse(String str, Integer num, String str2, CbTrackingPayLoad cbTrackingPayLoad) {
        this.responseMessage = str;
        this.responseCode = num;
        this.requestId = str2;
        this.trackingPayload = cbTrackingPayLoad;
    }

    public final CbTrackingPayLoad getTrackingPayload() {
        return this.trackingPayload;
    }
}
