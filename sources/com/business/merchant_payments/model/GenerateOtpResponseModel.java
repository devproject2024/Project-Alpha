package com.business.merchant_payments.model;

import com.google.gson.a.c;

public class GenerateOtpResponseModel extends BaseModel {
    public static final long serialVersionUID = 1;
    @c(a = "message")
    public String message;
    @c(a = "responseCode")
    public String responseCode;
    @c(a = "state")
    public String state;
    @c(a = "status")
    public String status;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String str) {
        this.state = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
