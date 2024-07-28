package net.one97.paytm.nativesdk.common.model;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class MerchantDetails implements BaseDataModel {
    @c(a = "mcc")
    @a
    private String mcc;
    @c(a = "merchantLogo")
    @a
    private String merchantLogo;
    @c(a = "merchantName")
    @a
    private String merchantName;
    @c(a = "merchantVpa")
    @a
    private String merchantVpa;

    public String getMcc() {
        return this.mcc;
    }

    public void setMcc(String str) {
        this.mcc = str;
    }

    public String getMerchantVpa() {
        return this.merchantVpa;
    }

    public void setMerchantVpa(String str) {
        this.merchantVpa = str;
    }

    public String getMerchantName() {
        return this.merchantName;
    }

    public void setMerchantName(String str) {
        this.merchantName = str;
    }

    public String getMerchantLogo() {
        return this.merchantLogo;
    }

    public void setMerchantLogo(String str) {
        this.merchantLogo = str;
    }
}
