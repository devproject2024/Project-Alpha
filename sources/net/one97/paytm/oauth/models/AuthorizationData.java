package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class AuthorizationData extends IJRPaytmDataModel {
    @c(a = "code")
    private final String code;

    public final String getCode() {
        return this.code;
    }
}
