package com.paytmmall.artifact.order.entity.impsdataentity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytmmall.artifact.order.entity.CJRBankDetailsResponse;

public class CJRBankDetails extends IJRPaytmDataModel {
    @b(a = "response")
    private CJRBankDetailsResponse mResponse;
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

    public CJRBankDetailsResponse getResponse() {
        return this.mResponse;
    }
}
