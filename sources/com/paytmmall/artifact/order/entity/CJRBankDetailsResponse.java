package com.paytmmall.artifact.order.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRBankDetailsResponse extends IJRPaytmDataModel {
    @b(a = "bankName")
    private String mBankName;
    @b(a = "branch")
    private String mBranch;
    @b(a = "city")
    private String mCity;
    @b(a = "ifscCode")
    private String mIfscCode;
    @b(a = "state")
    private String mState;

    public String getBankName() {
        return this.mBankName;
    }

    public String getState() {
        return this.mState;
    }

    public String getCity() {
        return this.mCity;
    }

    public String getBranch() {
        return this.mBranch;
    }

    public String getIfscCode() {
        return this.mIfscCode;
    }
}
