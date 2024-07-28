package net.one97.paytm.oauth.models;

import com.google.gson.a.c;
import com.paytm.network.model.IJRPaytmDataModel;

public final class VerificationInitResModel extends IJRPaytmDataModel {
    @c(a = "message")
    private final String message;
    @c(a = "responseCode")
    private final String responseCode;
    @c(a = "stateCode")
    private final String stateCode;
    @c(a = "status")
    private final String status;
    @c(a = "verificationMethods")
    private final String verificationMethods;
    @c(a = "verifierId")
    private final String verifierId;

    public final String getStateCode() {
        return this.stateCode;
    }

    public final String getVerifierId() {
        return this.verifierId;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final String getVerificationMethods() {
        return this.verificationMethods;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getStatus() {
        return this.status;
    }
}
