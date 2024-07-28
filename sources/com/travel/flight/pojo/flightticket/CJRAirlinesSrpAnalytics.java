package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRAirlinesSrpAnalytics extends IJRPaytmDataModel {
    @b(a = "body")
    private CJRFlightSRPBody body;

    public CJRFlightSRPBody getBody() {
        return this.body;
    }
}
