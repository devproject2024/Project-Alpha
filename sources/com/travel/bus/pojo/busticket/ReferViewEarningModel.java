package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class ReferViewEarningModel extends IJRPaytmDataModel {
    @b(a = "body")
    private ReferViewEarningBody body;

    public ReferViewEarningBody getBody() {
        return this.body;
    }
}
