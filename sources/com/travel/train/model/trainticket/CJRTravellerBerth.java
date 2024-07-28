package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTravellerBerth extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "BerthCode")
    private String mBerthCode;
    @b(a = "BerthName")
    private String mBerthName;

    public String getBerthName() {
        return this.mBerthName;
    }

    public String getBerthCode() {
        return this.mBerthCode;
    }
}
