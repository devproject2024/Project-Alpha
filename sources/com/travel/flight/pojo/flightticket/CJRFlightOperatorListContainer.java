package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRFlightOperatorListContainer extends IJRPaytmDataModel {
    @b(a = "code")
    private String code;
    @b(a = "body")
    private CJRFlightOperatorList flightOperatorList;
    @b(a = "status")
    private CJRStatus status;

    public CJRFlightOperatorList getFlightOperatorList() {
        return this.flightOperatorList;
    }

    public void setFlightOperatorList(CJRFlightOperatorList cJRFlightOperatorList) {
        this.flightOperatorList = cJRFlightOperatorList;
    }

    public CJRStatus getStatus() {
        return this.status;
    }

    public void setStatus(CJRStatus cJRStatus) {
        this.status = cJRStatus;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String toString() {
        return "CJRFlightOperatorListContainer [flightOperatorList = " + this.flightOperatorList + ", status = " + this.status + ", code = " + this.code + "]";
    }
}
