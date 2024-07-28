package net.one97.paytm.paymentsBank.forgotpasscode.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class OVDVerifyChallengeResponse extends IJRPaytmDataModel {
    @b(a = "access_token")
    private String access_token;
    @b(a = "challengeToken")
    private String challengeToken;
    @b(a = "challengeType")
    private String challengeType;
    @b(a = "expires")
    private long expires;
    @b(a = "message")
    private String message;
    @b(a = "request_id")
    private String requestId;
    @b(a = "response_code")
    private Integer responseCode;
    @b(a = "status")
    private String status;

    public String getChallengeType() {
        return this.challengeType;
    }

    public void setChallengeType(String str) {
        this.challengeType = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public Integer getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(Integer num) {
        this.responseCode = num;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getChallengeToken() {
        return this.challengeToken;
    }

    public String getAccess_token() {
        return this.access_token;
    }

    public void setAccess_token(String str) {
        this.access_token = str;
    }

    public long getExpires() {
        return this.expires;
    }

    public void setExpires(long j) {
        this.expires = j;
    }

    public void setChallengeToken(String str) {
        this.challengeToken = str;
    }
}
