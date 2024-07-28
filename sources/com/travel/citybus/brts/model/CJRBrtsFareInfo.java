package com.travel.citybus.brts.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBrtsFareInfo extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "response")
    private CJRBrtsFareResponse mResponse;
    private String requestId;

    public String getRequestId() {
        return this.requestId;
    }

    public CJRBrtsFareResponse getResponse() {
        return this.mResponse;
    }

    public void setmResponse(CJRBrtsFareResponse cJRBrtsFareResponse) {
        this.mResponse = cJRBrtsFareResponse;
    }
}
