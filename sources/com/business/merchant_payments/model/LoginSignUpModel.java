package com.business.merchant_payments.model;

import com.google.gson.a.c;

public class LoginSignUpModel extends BaseModel {
    public static final long serialVersionUID = 1;
    @c(a = "code")
    public String mCode;
    @c(a = "email")
    public String mEmail;
    @c(a = "message")
    public String mMessage;
    @c(a = "mobile")
    public String mMobile;
    @c(a = "responseCode")
    public String mResponseCode;
    @c(a = "signupToken")
    public String mSignupToken;
    @c(a = "state")
    public String mState;
    @c(a = "status")
    public String mStatus;

    public String getMessage() {
        return this.mMessage;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getState() {
        return this.mState;
    }

    public String getEmail() {
        return this.mEmail;
    }

    public String getMobile() {
        return this.mMobile;
    }

    public String getSignupToken() {
        return this.mSignupToken;
    }

    public String getResponseCode() {
        return this.mResponseCode;
    }

    public String getmCode() {
        return this.mCode;
    }

    public void setmCode(String str) {
        this.mCode = str;
    }
}
