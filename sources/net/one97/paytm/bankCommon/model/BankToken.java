package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class BankToken extends IJRPaytmDataModel {
    @b(a = "access_token")
    private String accessToken;
    @b(a = "message")
    private String mMessage;
    @b(a = "response_code")
    private int mResponseCode;
    @b(a = "status")
    private String mStatus;
    @b(a = "request_id")
    private String requestId;

    public String getmStatus() {
        return this.mStatus;
    }

    public void setmStatus(String str) {
        this.mStatus = str;
    }

    public int getmResponseCode() {
        return this.mResponseCode;
    }

    public void setmResponseCode(int i2) {
        this.mResponseCode = i2;
    }

    public String getmMessage() {
        return this.mMessage;
    }

    public void setmMessage(String str) {
        this.mMessage = str;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String str) {
        this.requestId = str;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }
}
