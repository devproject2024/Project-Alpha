package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class DeviceBindingConfigResModel extends IJRPaytmDataModel {
    @c(a = "data")
    private final Data data;
    @c(a = "message")
    private final String message;
    @c(a = "responseCode")
    private final String responseCode;
    @c(a = "status")
    private final String status;

    public final Data getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final String getStatus() {
        return this.status;
    }
}
