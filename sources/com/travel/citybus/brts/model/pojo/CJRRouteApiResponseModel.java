package com.travel.citybus.brts.model.pojo;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRRouteApiResponseModel extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "requestId")
    private String requestId;
    @b(a = "routeResponse")
    private CJRRouteModel routeResponse;
    @b(a = "status")
    private String status;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;

    public CJRRouteModel getRouteResponse() {
        return this.routeResponse;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }
}
