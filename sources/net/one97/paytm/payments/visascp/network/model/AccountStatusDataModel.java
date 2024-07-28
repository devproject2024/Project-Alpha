package net.one97.paytm.payments.visascp.network.model;

import com.google.gson.a.c;

public class AccountStatusDataModel extends BaseModel {
    @c(a = "cardAlias")
    private String mCardAlias;
    @c(a = "deviceId")
    private String mDeviceId;
    @c(a = "eligibleTimeStamp")
    private String mEligibleTimeStamp;
    @c(a = "resultCode")
    private String mResultCode;
    @c(a = "status")
    private String mStatus;

    public String getDeviceId() {
        return this.mDeviceId;
    }

    public String getCardAlias() {
        return this.mCardAlias;
    }

    public String getStatus() {
        return this.mStatus;
    }

    public String getResultCode() {
        return this.mResultCode;
    }

    public String getEligibleTimeStamp() {
        return this.mEligibleTimeStamp;
    }
}
