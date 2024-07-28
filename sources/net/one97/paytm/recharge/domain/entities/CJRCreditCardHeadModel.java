package net.one97.paytm.recharge.domain.entities;

public final class CJRCreditCardHeadModel {
    private String channelId;
    private String clientId;
    private String requestTimeStamp;
    private String requestTimestamp;
    private String responseTimestamp;
    private String signature;
    private String version;

    public final String getClientId() {
        return this.clientId;
    }

    public final void setClientId(String str) {
        this.clientId = str;
    }

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getRequestTimeStamp() {
        return this.requestTimeStamp;
    }

    public final void setRequestTimeStamp(String str) {
        this.requestTimeStamp = str;
    }

    public final String getRequestTimestamp() {
        return this.requestTimestamp;
    }

    public final void setRequestTimestamp(String str) {
        this.requestTimestamp = str;
    }

    public final String getResponseTimestamp() {
        return this.responseTimestamp;
    }

    public final void setResponseTimestamp(String str) {
        this.responseTimestamp = str;
    }

    public final String getChannelId() {
        return this.channelId;
    }

    public final void setChannelId(String str) {
        this.channelId = str;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final void setSignature(String str) {
        this.signature = str;
    }
}
