package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class UpdatePhoneResModel extends IJRPaytmDataModel {
    @b(a = "message")
    private final String message;
    @b(a = "meta")
    private final String meta;
    @b(a = "responseCode")
    private final String responseCode;
    @b(a = "state")
    private final String state;
    @b(a = "status")
    private final String status;

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getState() {
        return this.state;
    }

    public final String getMeta() {
        return this.meta;
    }
}
