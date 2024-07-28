package com.travel.bus.pojo.busticket.rnr;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRRnRDetailsData extends IJRPaytmDataModel {
    @b(a = "travels_name")
    private String travelsName;

    public String getTravelsName() {
        return this.travelsName;
    }
}
