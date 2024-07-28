package com.travel.bus.pojo.busticket.rnr;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRRnRDetailsModel extends IJRPaytmDataModel {
    @b(a = "body")
    private CJRRnRDetailsBody body;

    public CJRRnRDetailsBody getBody() {
        return this.body;
    }
}
