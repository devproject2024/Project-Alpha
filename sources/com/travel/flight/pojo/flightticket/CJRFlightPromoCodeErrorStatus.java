package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRFlightPromoCodeErrorStatus extends IJRPaytmDataModel {
    @b(a = "message")
    private CJRFlightPromocodeErrorMessage message;
    @b(a = "result")
    private String result;

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public CJRFlightPromocodeErrorMessage getMessage() {
        return this.message;
    }

    public void setMessage(CJRFlightPromocodeErrorMessage cJRFlightPromocodeErrorMessage) {
        this.message = cJRFlightPromocodeErrorMessage;
    }
}
