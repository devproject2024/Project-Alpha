package com.paytmmall.artifact.order.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.artifact.order.entity.impsdataentity.CJRBankResponse;

public class CJRCity extends IJRPaytmDataModel {
    @b(a = "response")
    private CJRBankResponse mResponse;
    @b(a = "statusCode")
    private String mStatusCode;
    @b(a = "statusMessage")
    private String mStatusMessage;

    public String getStatusCode() {
        return this.mStatusCode;
    }

    public String getStatusMessage() {
        return this.mStatusMessage;
    }

    public CJRBankResponse getResponse() {
        return this.mResponse;
    }
}
