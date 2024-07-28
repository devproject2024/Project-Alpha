package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainTrackingInfo extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "error")
    private String mError;
    @b(a = "code")
    private int mResponseCode;

    public int getResponseCode() {
        return this.mResponseCode;
    }

    public String getError() {
        return this.mError;
    }
}
