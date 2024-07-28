package com.paytm.business.merchantprofile.event;

public class OtpWrongEvent {
    public String message;

    public OtpWrongEvent() {
    }

    public OtpWrongEvent(String str) {
        this.message = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }
}
