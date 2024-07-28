package net.one97.paytm.nativesdk.instruments.upicollect.models;

public class Header {
    private String channelId;
    private String clientId;
    private String requestMsgId;
    private String requestTimestamp;
    private String signature;
    private String txnToken;
    private String version;

    public String getChannelId() {
        return this.channelId;
    }

    public void setChannelId(String str) {
        this.channelId = str;
    }

    public String getTxnToken() {
        return this.txnToken;
    }

    public void setTxnToken(String str) {
        this.txnToken = str;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public String getRequestTimestamp() {
        return this.requestTimestamp;
    }

    public void setRequestTimestamp(String str) {
        this.requestTimestamp = str;
    }

    public String getRequestMsgId() {
        return this.requestMsgId;
    }

    public void setRequestMsgId(String str) {
        this.requestMsgId = str;
    }

    public String getSignature() {
        return this.signature;
    }

    public void setSignature(String str) {
        this.signature = str;
    }
}
