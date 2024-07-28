package net.one97.paytm.common.entity.trustlist;

public class TrustListRequest {
    private Request request;
    private String signature;

    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request2) {
        this.request = request2;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }
}
