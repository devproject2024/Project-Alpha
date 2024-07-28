package com.travel.train.model.trainticket;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRVerifyOTPDetails implements IJRDataModel {
    @b(a = "status")
    private String mStatus;
    @b(a = "userId")
    private String mUserID;

    public String getStatus() {
        return this.mStatus;
    }

    public String getUserID() {
        return this.mUserID;
    }
}
