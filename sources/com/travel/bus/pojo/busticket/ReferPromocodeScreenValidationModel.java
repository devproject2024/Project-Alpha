package com.travel.bus.pojo.busticket;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public class ReferPromocodeScreenValidationModel extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @c(a = "body")
    private String body;
    @c(a = "message")
    private String message;

    public String getMessage() {
        return this.message;
    }

    public String getBody() {
        return this.body;
    }
}
