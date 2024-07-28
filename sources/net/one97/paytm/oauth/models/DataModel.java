package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class DataModel extends IJRPaytmDataModel {
    @c(a = "deviceBindingExist")
    private final boolean deviceBindingExist;
    @c(a = "sessionId")
    private final String sessionId;

    public final boolean getDeviceBindingExist() {
        return this.deviceBindingExist;
    }

    public final String getSessionId() {
        return this.sessionId;
    }
}
