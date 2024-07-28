package net.one97.paytm.nativesdk.common.model;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class TransactionResponse implements BaseDataModel {
    @c(a = "errorMessage")
    @a
    private String errorMessage;
    @c(a = "retryAllowed")
    @a
    private Boolean retryAllowed;

    public Boolean getRetryAllowed() {
        return this.retryAllowed;
    }

    public void setRetryAllowed(Boolean bool) {
        this.retryAllowed = bool;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String str) {
        this.errorMessage = str;
    }
}
