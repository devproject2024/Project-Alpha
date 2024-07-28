package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class RenderDataResModel extends IJRPaytmDataModel {
    @c(a = "callbackUrl")
    private final String callBackUrl;
    @c(a = "callbackType")
    private final String callbackType;

    public final String getCallBackUrl() {
        return this.callBackUrl;
    }

    public final String getCallbackType() {
        return this.callbackType;
    }
}
