package net.one97.paytm.paymentsBank.model.chequebook;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class ChequeBookFinResponse extends IJRPaytmDataModel {
    @b(a = "message")
    private String message;
    @b(a = "response")
    private ChequeBookResponse response;
    @b(a = "responseCode")
    private String responseCode;
    @b(a = "status")
    private String statusCode;
    @b(a = "success")
    private boolean success;

    public String getResponseCode() {
        return this.responseCode;
    }

    public void setResponseCode(String str) {
        this.responseCode = str;
    }

    public String getStatusCode() {
        return this.statusCode;
    }

    public void setStatusCode(String str) {
        this.statusCode = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public ChequeBookResponse getResponse() {
        return this.response;
    }

    public void setResponse(ChequeBookResponse chequeBookResponse) {
        this.response = chequeBookResponse;
    }

    public Boolean getSuccess() {
        return Boolean.valueOf(this.success);
    }

    public void setSuccess(Boolean bool) {
        this.success = bool.booleanValue();
    }
}
