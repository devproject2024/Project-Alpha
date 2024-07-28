package net.one97.paytm.upgradeKyc.data.models.aotpexpire;

import com.google.gsonhtcfix.a.a;
import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class AOTPExpireApiResponse extends IJRPaytmDataModel {
    @a
    @b(a = "message")
    private String message;
    @a
    @b(a = "responseCode")
    private String responseCode;
    @a
    @b(a = "status")
    private String status;

    public final String getStatus() {
        return this.status;
    }

    public final void setStatus(String str) {
        this.status = str;
    }

    public final String getResponseCode() {
        return this.responseCode;
    }

    public final void setResponseCode(String str) {
        this.responseCode = str;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        this.message = str;
    }
}
