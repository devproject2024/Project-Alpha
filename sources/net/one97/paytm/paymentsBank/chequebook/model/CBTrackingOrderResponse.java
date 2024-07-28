package net.one97.paytm.paymentsBank.chequebook.model;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CBTrackingOrderResponse extends IJRPaytmDataModel {
    @a
    @b(a = "payload")
    private CBTrackingOrderPayloadResponse cbTrackingOrderPayloadResponse;
    @a
    @b(a = "requestId")
    private String requestId;
    @a
    @b(a = "responseCode")
    private String responseCode;
    @a
    @b(a = "responseMessage")
    private String responseMessage;

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public void setResponseMessage(String str) {
        this.responseMessage = str;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public CBTrackingOrderPayloadResponse getCbTrackingOrderPayloadResponse() {
        return this.cbTrackingOrderPayloadResponse;
    }

    public void setCbTrackingOrderPayloadResponse(CBTrackingOrderPayloadResponse cBTrackingOrderPayloadResponse) {
        this.cbTrackingOrderPayloadResponse = cBTrackingOrderPayloadResponse;
    }
}
