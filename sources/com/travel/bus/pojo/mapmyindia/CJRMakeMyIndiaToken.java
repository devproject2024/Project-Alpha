package com.travel.bus.pojo.mapmyindia;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRMakeMyIndiaToken extends IJRPaytmDataModel {
    @a
    @b(a = "access_token")
    private String accessToken;
    @a
    @b(a = "token_type")
    private String tokenType;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getTokenType() {
        return this.tokenType;
    }
}
