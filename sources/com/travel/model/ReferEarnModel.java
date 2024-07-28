package com.travel.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class ReferEarnModel extends IJRPaytmDataModel {
    @b(a = "body")
    private ReferEarnBody body;
    @b(a = "code")
    private Integer code;
    @b(a = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer num) {
        this.code = num;
    }

    public ReferEarnBody getBody() {
        return this.body;
    }

    public void setBody(ReferEarnBody referEarnBody) {
        this.body = referEarnBody;
    }
}
