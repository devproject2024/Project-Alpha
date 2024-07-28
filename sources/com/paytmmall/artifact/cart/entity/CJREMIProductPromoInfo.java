package com.paytmmall.artifact.cart.entity;

import com.paytm.network.model.IJRPaytmDataModel;

public class CJREMIProductPromoInfo extends IJRPaytmDataModel {
    private String appliedPromoCode;
    private String cashbackText;
    private String cashbackValue;

    public String getAppliedPromoCode() {
        return this.appliedPromoCode;
    }

    public void setAppliedPromoCode(String str) {
        this.appliedPromoCode = str;
    }

    public String getCashbackValue() {
        return this.cashbackValue;
    }

    public void setCashbackValue(String str) {
        this.cashbackValue = str;
    }

    public String getCashbackText() {
        return this.cashbackText;
    }

    public void setCashbackText(String str) {
        this.cashbackText = str;
    }
}
