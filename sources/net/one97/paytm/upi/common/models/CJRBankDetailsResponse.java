package net.one97.paytm.upi.common.models;

import com.google.gson.a.c;
import net.one97.paytm.upi.common.UpiBaseDataModel;

public class CJRBankDetailsResponse implements UpiBaseDataModel {
    @c(a = "bankName")
    private String mBankName;
    @c(a = "branch")
    private String mBranch;
    @c(a = "city")
    private String mCity;
    @c(a = "ifscCode")
    private String mIfscCode;
    @c(a = "state")
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
