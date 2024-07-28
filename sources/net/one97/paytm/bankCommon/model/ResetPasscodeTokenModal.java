package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class ResetPasscodeTokenModal extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "access_token")
    private String mAccess_token;
    @b(a = "error")
    private String mError;
    @b(a = "error_description")
    private String mError_description;
    @b(a = "expires")
    private String mExpires;
    @b(a = "resourceOwnerId")
    private String mResourceOwnerId;
    @b(a = "scope")
    private String mScope;

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

    public String getError() {
        return this.mError;
    }

    public String getErrorDescription() {
        return this.mError_description;
    }
}
