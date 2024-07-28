package net.one97.paytm.payments.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROauthAadharValidate extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "access_token")
    private String mAccess_token;
    @b(a = "expires")
    private String mExpires;
    @b(a = "message")
    private String mMessage;
    @b(a = "resourceOwnerId")
    private String mResourceOwnerId;
    @b(a = "responseCode")
    private String mResponseCode;
    @b(a = "scope")
    private String mScope;
    @b(a = "status")
    private String mStatus;

    public String getScope() {
        return this.mScope;
    }

    public String getResourceOwnerId() {
        return this.mResourceOwnerId;
    }

    public String getAccessToken() {
        return this.mAccess_token;
    }

    public String getExpires() {
        return this.mExpires;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getResponseCode() {
        return this.mResponseCode;
    }

    public String getMessage() {
        return this.mMessage;
    }
}
