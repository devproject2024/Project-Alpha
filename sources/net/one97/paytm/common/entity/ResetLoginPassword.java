package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class ResetLoginPassword extends IJRPaytmDataModel {
    @b(a = "code")
    private String code;
    @b(a = "displayMessage")
    private String displayMessage;
    @b(a = "message")
    private String message;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "state")
    private String state;
    @b(a = "status")
    private String status;
    @b(a = "statusCode")
    private String statusCode;
    @b(a = "statusMessage")
    private String statusMessage;

    public String getStatus() {
        return this.status;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public String getDisplayMessage() {
        return this.displayMessage;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public String getState() {
        return this.state;
    }

    public String getMessage() {
        return this.message;
    }

    public String getCode() {
        return this.code;
    }

    public String getResponseCode() {
        return this.responseCode;
    }
}
