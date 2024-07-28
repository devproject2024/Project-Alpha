package com.paytm.business.merchantprofile.model;

import com.business.common_module.f.a;
import com.google.gson.a.c;

public class MerchantLimitModel extends a {
    @c(a = "PPBLLimit")
    @com.google.gson.a.a
    public String PPBLLimit;
    @c(a = "UPILimit")
    @com.google.gson.a.a
    public String UPILimit;
    @c(a = "dailyBankTransferLimit")
    @com.google.gson.a.a
    public String dailyBankTransferLimit;
    @c(a = "dailyCollectionLimit")
    @com.google.gson.a.a
    public String dailyCollectionLimit;
    @c(a = "merchant_type")
    @com.google.gson.a.a
    public String merchantType;
    @c(a = "monthlyBankTransferLimit")
    @com.google.gson.a.a
    public String monthlyBankTransferLimit;
    @c(a = "monthlyCollectionLimit")
    @com.google.gson.a.a
    public String monthlyCollectionLimit;

    public String getPPBLLimit() {
        return this.PPBLLimit;
    }

    public void setPPBLLimit(String str) {
        this.PPBLLimit = str;
    }

    public String getUPILimit() {
        return this.UPILimit;
    }

    public void setUPILimit(String str) {
        this.UPILimit = str;
    }

    public String getMerchantType() {
        return this.merchantType;
    }

    public void setMerchantType(String str) {
        this.merchantType = str;
    }

    public String getDailyCollectionLimit() {
        return this.dailyCollectionLimit;
    }

    public void setDailyCollectionLimit(String str) {
        this.dailyCollectionLimit = str;
    }

    public String getMonthlyCollectionLimit() {
        return this.monthlyCollectionLimit;
    }

    public void setMonthlyCollectionLimit(String str) {
        this.monthlyCollectionLimit = str;
    }

    public String getDailyBankTransferLimit() {
        return this.dailyBankTransferLimit;
    }

    public void setDailyBankTransferLimit(String str) {
        this.dailyBankTransferLimit = str;
    }

    public String getMonthlyBankTransferLimit() {
        return this.monthlyBankTransferLimit;
    }

    public void setMonthlyBankTransferLimit(String str) {
        this.monthlyBankTransferLimit = str;
    }
}
