package net.one97.paytm.common.entity.trustLogin;

import java.io.Serializable;

public class TrustLoginObject implements Serializable {
    String data;
    String responseCode;
    String responseMessage;
    String status;

    public String getStatus() {
        return this.status;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public String getData() {
        return this.data;
    }
}
