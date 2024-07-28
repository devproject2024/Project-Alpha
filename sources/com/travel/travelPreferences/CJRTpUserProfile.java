package com.travel.travelPreferences;

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

    public void setMessage(String str) {
        this.message = str;
    }

    public CJRTpUserProfileBody getBody() {
        return this.body;
    }

    public void setBody(CJRTpUserProfileBody cJRTpUserProfileBody) {
        this.body = cJRTpUserProfileBody;
    }
}
