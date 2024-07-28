package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;

public final class FetchAccessTokenReqModel {
    @b(a = "accessToken")
    private String accessToken;
    @b(a = "code")
    private String code;
    @b(a = "deviceId")
    private final String deviceId;
    @b(a = "grantType")
    private final String grantType;
    @b(a = "refreshToken")
    private String refreshToken;

    public FetchAccessTokenReqModel(String str, String str2) {
        k.c(str, "grantType");
        k.c(str2, "deviceId");
        this.grantType = str;
        this.deviceId = str2;
    }

    public final String getGrantType() {
        return this.grantType;
    }

    public final String getDeviceId() {
        return this.deviceId;
    }

    public final String getCode() {
        return this.code;
    }

    public final void setCode(String str) {
        this.code = str;
    }

    public final String getRefreshToken() {
        return this.refreshToken;
    }

    public final void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public final String getAccessToken() {
        return this.accessToken;
    }

    public final void setAccessToken(String str) {
        this.accessToken = str;
    }
}
