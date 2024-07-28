package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRIRCTCuserId extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "display_time")
    private String mDisplayTime;
    @b(a = "user_id")
    private String mUserId;

    public String getmUserId() {
        return this.mUserId;
    }

    public String getmDisplayTime() {
        return this.mDisplayTime;
    }
}
