package net.one97.paytm.bankCommon.model;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class MinKycDetails implements IJRDataModel {
    @b(a = "isMinKyc")
    private String mIsMinKyc;
    @b(a = "kycState")
    private String mKycState;

    public String getmIsMinKyc() {
        return this.mIsMinKyc;
    }

    public void setmIsMinKyc(String str) {
        this.mIsMinKyc = str;
    }

    public String getmKycState() {
        return this.mKycState;
    }

    public void setmKycState(String str) {
        this.mKycState = str;
    }
}
