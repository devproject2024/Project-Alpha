package com.travel.citybus.best.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class BestEPurseTokenResponse extends IJRPaytmDataModel {
    @b(a = "requestId")
    private String requestId;
    @b(a = "response")
    private BestEPurse response;
    @b(a = "status")
    private String status;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;

    public String getRequestId() {
        return this.requestId;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getStatus() {
        return this.status;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public BestEPurse getResponse() {
        return this.response;
    }
}
