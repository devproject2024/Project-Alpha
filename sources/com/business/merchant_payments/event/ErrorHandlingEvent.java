package com.business.merchant_payments.event;

public class ErrorHandlingEvent {
    public String errorMsg;
    public String errorText;

    public ErrorHandlingEvent(String str, String str2) {
        this.errorText = str;
        this.errorMsg = str2;
    }

    public String getErrorText() {
        return this.errorText;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}
