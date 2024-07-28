package com.travel.travels.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class ReferViewEarningModel extends IJRPaytmDataModel {
    @b(a = "body")
    private ReferViewEarningBody body;
    @b(a = "code")
    private int code;
    @b(a = "message")
    private String message;

    public ReferViewEarningBody getBody() {
        return this.body;
    }

    public void setBody(ReferViewEarningBody referViewEarningBody) {
        this.body = referViewEarningBody;
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
