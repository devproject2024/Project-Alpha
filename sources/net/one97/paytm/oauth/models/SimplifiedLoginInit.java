package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class SimplifiedLoginInit extends IJRPaytmDataModel {
    @b(a = "countryCode")
    private String countryCode;
    @b(a = "message")
    private String message;
    @b(a = "mobile")
    private String mobile;
    @b(a = "oauthCode")
    private String oauthCode;
    @b(a = "passwordViolation")
    private Boolean passwordViolation;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "stateToken")
    private String stateToken;
    @b(a = "status")
    private String status;

    public Boolean getPasswordViolation() {
        return this.passwordViolation;
    }

    public void setPasswordViolation(Boolean bool) {
        this.passwordViolation = bool;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String str) {
        this.countryCode = str;
    }

    public String getMobile() {
        return this.mobile;
    }

    public void setMobile(String str) {
        this.mobile = str;
    }

    public String getStateToken() {
        return this.stateToken;
    }

    public void setStateToken(String str) {
        this.stateToken = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getOauthCode() {
        return this.oauthCode;
    }

    public void setOauthCode(String str) {
        this.oauthCode = str;
    }

    public String toString() {
        return "status: " + this.status + ", responseCode: " + this.responseCode + ", countryCode: " + this.countryCode + ", mobile: " + this.mobile + ", stateToken: " + this.stateToken + ", message: " + this.message + ", oauthCode: " + this.oauthCode;
    }
}
