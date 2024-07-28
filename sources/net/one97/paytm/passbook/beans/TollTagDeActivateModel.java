package net.one97.paytm.passbook.beans;

import net.one97.paytm.passbook.mapping.IJRDataModel;

public class TollTagDeActivateModel extends IJRDataModel {
    private String orderId;
    private String requestGuid;
    private String response;
    private String status;
    private String statusCode;
    private String statusMessage;
    private TollTagResponseEntryModel uniqueRefrence;

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

    public String getResponse() {
        return this.response;
    }

    public void setResponse(String str) {
        this.response = str;
    }

    public TollTagResponseEntryModel getUniqueRefrence() {
        return this.uniqueRefrence;
    }

    public void setUniqueRefrence(TollTagResponseEntryModel tollTagResponseEntryModel) {
        this.uniqueRefrence = tollTagResponseEntryModel;
    }
}
