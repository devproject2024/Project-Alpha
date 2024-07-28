package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBusRnRHome extends IJRPaytmDataModel {
    @b(a = "body")
    private CJRBusRatingInfo ratingInfo;

    public CJRBusRatingInfo getRatingInfo() {
        return this.ratingInfo;
    }
}
