package com.travel.bus.pojo.busticket.rnr;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRRnRDetailsBody extends IJRPaytmDataModel {
    @b(a = "data")
    private CJRRnRDetailsData data;

    public CJRRnRDetailsData getData() {
        return this.data;
    }
}
