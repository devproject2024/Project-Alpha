package net.one97.paytm.addmoney.common.paymethodresponse;

import net.one97.paytm.common.entity.IJRDataModel;

public class MerchantDetails implements IJRDataModel {
    private String mcc;
    private String merchantName;
    private String merchantVpa;

    public void setMcc(String str) {
        this.mcc = str;
    }

    public String getMcc() {
        return this.mcc;
    }

    public void setMerchantVpa(String str) {
        this.merchantVpa = str;
    }

    public String getMerchantVpa() {
        return this.merchantVpa;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public String getMerchantName() {
        return this.merchantName;
    }
}
