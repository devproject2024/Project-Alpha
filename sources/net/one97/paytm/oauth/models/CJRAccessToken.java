package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRAccessToken extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "access_token")
    private String mAccessToken;
    @b(a = "error")
    private String mError;
    @b(a = "error_description")
    private String mErrorDescription;
    @b(a = "scope")
    private String mScope;
    @b(a = "tokenType")
    private String mTokenType;

    public String getError() {
        return this.mError;
    }

    public String getErrorDescription() {
        return this.mErrorDescription;
    }

    public String getTokenType() {
        return this.mTokenType;
    }

    public String getScope() {
        return this.mScope;
    }

    public String getAccessToken() {
        return this.mAccessToken;
    }
}
