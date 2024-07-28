package net.one97.paytm.oauth.models;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class AuthEncryptedSSOToken extends IJRPaytmDataModel {
    @b(a = "code")
    private String code;
    @b(a = "sso_token_enc")
    private String encSSSOToken;
    @b(a = "error")
    private String error;
    @b(a = "status")
    private String status;

    public String getEncSSSOToken() {
        return this.encSSSOToken;
    }

    public void setEncSSSOToken(String str) {
        this.encSSSOToken = str;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String getError() {
        return this.error;
    }

    public void setError(String str) {
        this.error = str;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }
}
