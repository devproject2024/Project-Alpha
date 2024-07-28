package net.one97.paytm.common.entity.wallet;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRLimitStatusResponse implements IJRDataModel {
    @b(a = "allowedLimit")
    private double mAllowedLimit;
    @b(a = "allowedP2BForSdMerchant")
    private String mAllowedP2BForSdMerchant;
    @b(a = "creditConsumed")
    private double mCreditConsumed;
    @b(a = "thresholdAchieved")
    private String mThresholdAchieved;
    @b(a = "walletRbiType")
    private String mWalletRbiType;

    public String getAllowedP2BForSdMerchant() {
        return this.mAllowedP2BForSdMerchant;
    }

    public String getWalletRbiType() {
        return this.mWalletRbiType;
    }

    public String getThresholdAchieved() {
        return this.mThresholdAchieved;
    }

    public double getAllowedLimit() {
        return this.mAllowedLimit;
    }

    public double getCreditConsumed() {
        return this.mCreditConsumed;
    }
}
