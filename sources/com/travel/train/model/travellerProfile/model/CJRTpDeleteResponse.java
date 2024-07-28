package com.travel.train.model.travellerProfile.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTpDeleteResponse extends IJRPaytmDataModel implements IJRDataModel {
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

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return this.code;
    }
}
