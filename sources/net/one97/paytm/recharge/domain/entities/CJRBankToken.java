package net.one97.paytm.recharge.domain.entities;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBankToken extends IJRPaytmDataModel {
    @b(a = "access_token")
    private String accessToken;
    @b(a = "expires")
    private long expires;
    @b(a = "message")
    private String message;
    @b(a = "request_id")
    private String requestId;
    @b(a = "resourceOwnerId")
    private String resourceOwnerId;
    @b(a = "response_code")
    private String responseCode;
    @b(a = "id")
    private String scope;
    @b(a = "status")
    private String status;

    public String getScope() {
        return this.scope;
    }

    public String getResourceOwnerId() {
        return this.resourceOwnerId;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public long getExpires() {
        return this.expires;
    }

    public String getMessage() {
        return this.message;
    }

    public String getStatus() {
        return this.status;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getRequestId() {
        return this.requestId;
    }
}
