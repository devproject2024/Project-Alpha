package net.one97.paytm.nativesdk.common.model;

import com.google.gson.a.c;

public class CJRVerifyPasscodeResponse implements BaseDataModel {
    @c(a = "access_token")
    private String mAccessToken;
    @c(a = "error")
    private String mError;
    @c(a = "error_description")
    private String mErrorDescription;
    @c(a = "expires")
    private long mExpires;
    @c(a = "resourceOwnerId")
    private String mResourceOwnerId;
    @c(a = "scope")
    private String mScope;

    public String getScope() {
        return this.mScope;
    }

    public void setScope(String str) {
        this.mScope = str;
    }

    public String getResourceOwnerId() {
        return this.mResourceOwnerId;
    }

    public void setResourceOwnerId(String str) {
        this.mResourceOwnerId = str;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }

    public void setAccessToken(String str) {
        this.mAccessToken = str;
    }

    public long getExpires() {
        return this.mExpires;
    }

    public void setExpires(long j) {
        this.mExpires = j;
    }

    public String getError() {
        return this.mError;
    }

    public void setError(String str) {
        this.mError = str;
    }

    public String getErrorDescription() {
        return this.mErrorDescription;
    }

    public void setErrorDescription(String str) {
        this.mErrorDescription = str;
    }
}
