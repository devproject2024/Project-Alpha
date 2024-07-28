package net.one97.paytm.payments.visascp.network.model;

import com.google.gson.a.c;

public class AuthCodeJwsResponseModel extends BaseModel {
    @c(a = "authCode")
    private String mAuthCode;
    @c(a = "vDeviceId")
    private String mDeviceId;
    @c(a = "publicKey")
    private PublicKeyObject mPublicKey;

    public String getAuthCode() {
        return this.mAuthCode;
    }

    public void setAuthCode(String str) {
        this.mAuthCode = str;
    }

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    public PublicKeyObject getPublicKey() {
        return this.mPublicKey;
    }

    public void setPublicKey(PublicKeyObject publicKeyObject) {
        this.mPublicKey = publicKeyObject;
    }
}
