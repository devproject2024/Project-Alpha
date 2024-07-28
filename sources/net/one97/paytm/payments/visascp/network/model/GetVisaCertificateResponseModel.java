package net.one97.paytm.payments.visascp.network.model;

public class GetVisaCertificateResponseModel extends BaseModel {
    private String responseCode;
    private String responseMessage;
    private String visaCertificateData;

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

    public String getVisaCertificateData() {
        return this.visaCertificateData;
    }

    public void setVisaCertificateData(String str) {
        this.visaCertificateData = str;
    }
}
