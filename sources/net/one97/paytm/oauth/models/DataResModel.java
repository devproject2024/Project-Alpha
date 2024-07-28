package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class DataResModel extends IJRPaytmDataModel {
    @c(a = "authenticationValueType")
    private final String authenticationValueType;
    @c(a = "stateToken")
    private final String stateToken;

    public final String getAuthenticationValueType() {
        return this.authenticationValueType;
    }

    public final String getStateToken() {
        return this.stateToken;
    }
}
