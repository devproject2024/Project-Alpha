package com.travel.flight.pojo.flightticket.insurance;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRInsuranceModel extends IJRPaytmDataModel {
    @b(a = "body")
    private CJRInsuranceBody body;

    public CJRInsuranceBody getBody() {
        return this.body;
    }
}
