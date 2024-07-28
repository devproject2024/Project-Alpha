package net.one97.paytm.common.entity.paymentsbank;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRVerifyPasscodeResponse extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "access_token")
    private String mAccessToken;
    @b(a = "error")
    private String mError;
    @b(a = "error_description")
    private String mErrorDescription;
    @b(a = "expires")
    private long mExpires;
    @b(a = "resourceOwnerId")
    private String mResourceOwnerId;
    @b(a = "scope")
    private String mScope;
    @b(a = "responseCodeLocal")
    private int responseCodeLocal;

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

    public int getResponseCodeLocal() {
        return this.responseCodeLocal;
    }

    public void setResponseCodeLocal(int i2) {
        this.responseCodeLocal = i2;
    }
}
