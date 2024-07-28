package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class TokenV3Data extends IJRPaytmDataModel {
    @b(a = "accessToken")
    private final String accessToken;
    @b(a = "expiresIn")
    private final Long expiresIn = 0L;
    @b(a = "refreshToken")
    private final String refreshToken;
    @b(a = "scope")
    private final String scope;
    @b(a = "tokenType")
    private final String tokenType;

    public final String getScope() {
        return this.scope;
    }

    public final String getTokenType() {
        return this.tokenType;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final Long getExpiresIn() {
        return this.expiresIn;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }
}
