package com.travel.travelPreferences;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBusUserDeleteProfile extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "body")
    private String body;
    @b(a = "code")
    private int code;
    @b(a = "message")
    private String message;

    public String getBody() {
        return this.body;
    }

    public void setBody(String str) {
        this.body = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int i2) {
        this.code = i2;
    }
}
