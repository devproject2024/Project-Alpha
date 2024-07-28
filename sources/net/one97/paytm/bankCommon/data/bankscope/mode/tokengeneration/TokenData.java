package net.one97.paytm.bankCommon.data.bankscope.mode.tokengeneration;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class TokenData extends IJRPaytmDataModel {
    @a
    @b(a = "access_token")
    private String accessToken;
    @a
    @b(a = "expires")
    private String expires;
    @a
    @b(a = "refresh_token")
    private String refreshToken;
    @a
    @b(a = "scope")
    private String scope;
    @a
    @b(a = "token_type")
    private String tokenType;

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final void setAccessToken(String str) {
        this.accessToken = str;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    public final void setTokenType(String str) {
        this.tokenType = str;
    }

    public final String getExpires() {
        return this.expires;
    }

    public final void setExpires(String str) {
        this.expires = str;
    }

    public final String getScope() {
        return this.scope;
    }

    public final void setScope(String str) {
        this.scope = str;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final void setRefreshToken(String str) {
        this.refreshToken = str;
    }
}
