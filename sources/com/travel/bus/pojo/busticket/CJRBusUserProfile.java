package com.travel.bus.pojo.busticket;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import com.travel.bus.pojo.CJRTpUserProfileBody;

public class CJRBusUserProfile extends IJRPaytmDataModel {
    @c(a = "body")
    private CJRTpUserProfileBody body;

    public CJRTpUserProfileBody getBody() {
        return this.body;
    }
}
