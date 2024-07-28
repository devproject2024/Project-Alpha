package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class FlightStatus implements IJRDataModel {
    @a
    @b(a = "message")
    private CJRFlightPromoMessage CJRFlightPromoMessage;
    @a
    @b(a = "result")
    private String result;

    public String getResult() {
        return this.result;
    }

    public void setResult(String str) {
        this.result = str;
    }

    public CJRFlightPromoMessage getMessage() {
        return this.CJRFlightPromoMessage;
    }

    public void setMessage(CJRFlightPromoMessage cJRFlightPromoMessage) {
        this.CJRFlightPromoMessage = cJRFlightPromoMessage;
    }
}
