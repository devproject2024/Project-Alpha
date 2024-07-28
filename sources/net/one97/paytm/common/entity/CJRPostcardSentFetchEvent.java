package net.one97.paytm.common.entity;

import net.one97.paytm.network.CJRWalletDataModel;

public class CJRPostcardSentFetchEvent extends CJRWalletDataModel implements IJRDataModel {
    private String metadata;
    private String orderId;
    private String requestGuid;
    private CJRPostcardFetchResponse response;
    private String status;
    private String statusCode;
    private String statusMessage;
    private String type;

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public String getRequestGuid() {
        return this.requestGuid;
    }

    public void setRequestGuid(String str) {
        this.requestGuid = str;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(String str) {
        this.orderId = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public CJRPostcardFetchResponse getResponse() {
        return this.response;
    }

    public void setResponse(CJRPostcardFetchResponse cJRPostcardFetchResponse) {
        this.response = cJRPostcardFetchResponse;
    }

    public String getMetadata() {
        return this.metadata;
    }

    public void setMetadata(String str) {
        this.metadata = str;
    }
}
