package com.travel.citybus.best.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class BestRecentResponse extends IJRPaytmDataModel {
    @b(a = "response")
    private List<BestRecentTickets> response = null;
    @b(a = "status")
    private String status;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public void setStatusMessage(String str) {
        this.statusMessage = str;
    }

    public List<BestRecentTickets> getResponse() {
        return this.response;
    }

    public void setResponse(List<BestRecentTickets> list) {
        this.response = list;
    }
}
