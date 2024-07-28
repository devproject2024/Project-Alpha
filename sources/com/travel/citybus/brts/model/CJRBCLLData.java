package com.travel.citybus.brts.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.citybus.brts.model.CJRAmountPax;

public class CJRBCLLData extends IJRPaytmDataModel {
    @b(a = "requestId")
    private String requestId;
    @b(a = "response")
    private CJRAmountPax.CJRBCLLResponse response;
    @b(a = "status")
    private String status;
    @b(a = "statusMessage")
    private String statusMessage;

    public String getStatus() {
        return this.status;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public CJRAmountPax.CJRBCLLResponse getResponse() {
        return this.response;
    }

    public void setResponse(CJRAmountPax.CJRBCLLResponse cJRBCLLResponse) {
        this.response = cJRBCLLResponse;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }
}
