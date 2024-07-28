package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRPGToken extends IJRPaytmDataModel implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "expires")
    private long mExpires;
    @b(a = "resourceOwnerId")
    private String mResourceOwnerId;
    @b(a = "scope")
    private String mScopes;
    @b(a = "access_token")
    private String mToken;

    public String getToken() {
        return this.mToken;
    }

    public void setToken(String str) {
        this.mToken = str;
    }

    public long getExpires() {
        return this.mExpires;
    }

    public void setExpires(long j) {
        this.mExpires = j;
    }

    public String getScopes() {
        return this.mScopes;
    }

    public void setScopes(String str) {
        this.mScopes = str;
    }

    public String getResourceOwnerId() {
        return this.mResourceOwnerId;
    }

    public void setResourceOwnerId(String str) {
        this.mResourceOwnerId = str;
    }

    public String getAccess_token() {
        return this.mToken;
    }

    public String getScope() {
        return this.mScopes;
    }
}
