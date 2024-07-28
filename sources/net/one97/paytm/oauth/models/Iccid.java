package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class Iccid extends IJRPaytmDataModel {
    @c(a = "responseCode")
    private final String responseCode;
    @c(a = "verifiedIccid")
    private final String verifiedIccid;

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final String getVerifiedIccid() {
        return this.verifiedIccid;
    }
}
