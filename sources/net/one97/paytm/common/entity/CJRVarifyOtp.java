package net.one97.paytm.common.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRVarifyOtp extends IJRPaytmDataModel {
    @b(a = "code")
    private String mCode;
    @b(a = "message")
    private String mMessage;
    @b(a = "status")
    private String mStatus;
    @b(a = "responseCode")
    private String responseCode;

    public String getStatus() {
        return this.mStatus;
    }

    public String getMessage() {
        return this.mMessage;
    }

    public String getCode() {
        return this.mCode;
    }

    public String getResponseCode() {
        return this.responseCode;
    }
}
