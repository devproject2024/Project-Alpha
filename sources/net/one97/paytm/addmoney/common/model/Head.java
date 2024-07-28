package net.one97.paytm.addmoney.common.model;

public class Head {
    private String clientId;
    private String mid;
    private String requestId;
    String requestTimestamp;
    private String token;
    private String tokenType;
    private String version;

    public String getRequestTimestamp() {
        return this.requestTimestamp;
    }

    public void setRequestTimeStamp(String str) {
        this.requestTimestamp = str;
    }

    public Head(String str, String str2, String str3, String str4, String str5, String str6) {
        this.tokenType = str;
        this.token = str2;
        this.requestId = str3;
        this.mid = str4;
        this.clientId = str5;
        this.version = str6;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(String str) {
        this.tokenType = str;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getMid() {
        return this.mid;
    }

    public void setMid(String str) {
        this.mid = str;
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

    public String toString() {
        return "ClassPojo [tokenType = " + this.tokenType + ", token = " + this.token + ", requestId = " + this.requestId + ", mid = " + this.mid + ", clientId = " + this.clientId + ", version = " + this.version + "]";
    }
}
