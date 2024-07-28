package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class MinKycDetails implements IJRDataModel {
    @b(a = "isMinKyc")
    private boolean mIsMinKyc;
    @b(a = "kycState")
    private String mKycState;

    public boolean getmIsMinKyc() {
        return this.mIsMinKyc;
    }

    public void setmIsMinKyc(boolean z) {
        this.mIsMinKyc = z;
    }

    public String getmKycState() {
        return this.mKycState;
    }

    public void setmKycState(String str) {
        this.mKycState = str;
    }
}
