package net.one97.paytm.common.entity.upgradeKyc;

import net.one97.paytm.common.entity.IJRDataModel;

public class KYCForm60 implements IJRDataModel {
    private String agriculturalIncome;
    private String nonAgriculturalIncome;

    public String getAgriIncom() {
        return this.agriculturalIncome;
    }

    public void setAgriIncom(String str) {
        this.agriculturalIncome = str;
    }

    public String getNonAgriIncom() {
        return this.nonAgriculturalIncome;
    }

    public void setNonAgriIncom(String str) {
        this.nonAgriculturalIncome = str;
    }
}
