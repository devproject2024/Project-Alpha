package com.travel.train.model.travellerProfile.model;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTpUserProfile extends IJRPaytmDataModel implements IJRDataModel {
    @c(a = "body")
    private CJRTpUserProfileBody body;
    private String message;

    public String getMessage() {
        return this.message;
    }

    public CJRTpUserProfileBody getBody() {
        return this.body;
    }
}
