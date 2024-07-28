package net.one97.paytm.passbook.beans;

import net.one97.paytm.passbook.mapping.IJRDataModel;

public class GiftVoucherResponseData extends IJRDataModel {
    private String orderId;
    private String requestGuid;
    private GiftVoucherListResponse response;
    private String status;
    private String statusCode;
    private String statusMessage;

    public GiftVoucherListResponse getResponse() {
        return this.response;
    }

    public void setResponse(GiftVoucherListResponse giftVoucherListResponse) {
        this.response = giftVoucherListResponse;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
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

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public String toString() {
        return "ClassPojo [response = " + this.response + ", statusCode = " + this.statusCode + ", status = " + this.status + ", requestGuid = " + this.requestGuid + ", orderId = " + this.orderId + ", statusMessage = " + this.statusMessage + "]";
    }
}
