package com.travel.travels.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class ReferralGetPromocodeModel extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @c(a = "code")
    private Integer code;
    @c(a = "body")
    private ReferralGetCodeBody getCodeBody;
    @c(a = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public int getCode() {
        return this.code.intValue();
    }

    public void setCode(int i2) {
        this.code = Integer.valueOf(i2);
    }

    public ReferralGetCodeBody getGetCodeBody() {
        return this.getCodeBody;
    }

    public void setGetCodeBody(ReferralGetCodeBody referralGetCodeBody) {
        this.getCodeBody = referralGetCodeBody;
    }
}
