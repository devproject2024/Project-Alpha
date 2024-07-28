package net.one97.paytm.paymentsBank.forgotpasscode.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class OvdOtpSendResponse extends IJRPaytmDataModel {
    @b(a = "challengeToken")
    private String challengeToken;
    @b(a = "challengeType")
    private String challengeType;
    @b(a = "message")
    private String message;
    @b(a = "otpToken")
    private String otpToken;
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

    public void setChallengeToken(String str) {
        this.challengeToken = str;
    }

    public String getOtpToken() {
        return this.otpToken;
    }

    public void setOtpToken(String str) {
        this.otpToken = str;
    }
}
