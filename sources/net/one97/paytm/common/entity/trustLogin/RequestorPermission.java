package net.one97.paytm.common.entity.trustLogin;

import java.io.Serializable;

public class RequestorPermission implements Serializable {
    boolean isRequestorClient;
    String message;
    String responseCode;
    String status;

    public String getStatus() {
        return this.status;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isRequestorClient() {
        return this.isRequestorClient;
    }
}
