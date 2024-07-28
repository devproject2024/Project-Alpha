package com.travel.train.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class ReferralValidationModel extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @c(a = "body")
    private String body;
    @c(a = "code")
    private int code;
    @c(a = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return this.code;
    }

    public String getBody() {
        return this.body;
    }
}
