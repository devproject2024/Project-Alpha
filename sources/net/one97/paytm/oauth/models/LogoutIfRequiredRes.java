package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class LogoutIfRequiredRes extends IJRPaytmDataModel {
    @b(a = "loggedout")
    private final Boolean loggedout = Boolean.FALSE;
    @b(a = "message")
    private final String message;
    @b(a = "responseCode")
    private final String responseCode;
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

    public final Boolean getLoggedout() {
        return this.loggedout;
    }
}
