package com.travel.bus.pojo.busticket;

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

    public int getCode() {
        return this.code.intValue();
    }

    public ReferralGetCodeBody getGetCodeBody() {
        return this.getCodeBody;
    }
}
