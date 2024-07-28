package net.one97.paytm.passbook.beans;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public class CJRPGToken extends IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "expires")
    private long mExpires;
    @b(a = "resourceOwnerId")
    private String mResourceOwnerId;
    @b(a = "scope")
    private String mScopes;
    @b(a = "access_token")
    private String mToken;

    public void setToken(String str) {
        this.mToken = str;
    }

    public String getToken() {
        return this.mToken;
    }

    public void setExpires(long j) {
        this.mExpires = j;
    }

    public long getExpires() {
        return this.mExpires;
    }

    public void setScopes(String str) {
        this.mScopes = str;
    }

    public String getScopes() {
        return this.mScopes;
    }

    public void setResourceOwnerId(String str) {
        this.mResourceOwnerId = str;
    }

    public String getResourceOwnerId() {
        return this.mResourceOwnerId;
    }

    public String getAccess_token() {
        return this.mToken;
    }

    public String getScope() {
        return this.mScopes;
    }
}
