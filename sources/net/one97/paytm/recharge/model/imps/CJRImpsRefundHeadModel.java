package net.one97.paytm.recharge.model.imps;

public final class CJRImpsRefundHeadModel {
    private String requestId;
    private String requestTimestamp;
    private String token;
    private String tokenType;
    private String version;

    public final String getVersion() {
        return this.version;
    }

    public final void setVersion(String str) {
        this.version = str;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final void setRequestId(String str) {
        this.requestId = str;
    }

    public final String getRequestTimestamp() {
        return this.requestTimestamp;
    }

    public final void setRequestTimestamp(String str) {
        this.requestTimestamp = str;
    }

    public final String getToken() {
        return this.token;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    public final void setTokenType(String str) {
        this.tokenType = str;
    }
}
