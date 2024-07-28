package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class VerificationResModel extends IJRPaytmDataModel {
    @b(a = "canRetry")
    private final String canRetry;
    @b(a = "message")
    private final String message;
    @b(a = "responseCode")
    private final String responseCode;
    @b(a = "stateCode")
    private final String stateCode;
    @b(a = "status")
    private final String status;
    @b(a = "verifierId")
    private final String verifierId;

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final String getStatus() {
        return this.status;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getStateCode() {
        return this.stateCode;
    }

    public final String getVerifierId() {
        return this.verifierId;
    }

    public final String getCanRetry() {
        return this.canRetry;
    }
}
