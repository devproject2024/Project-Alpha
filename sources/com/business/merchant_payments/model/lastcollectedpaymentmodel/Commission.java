package com.business.merchant_payments.model.lastcollectedpaymentmodel;

public class Commission {
    public String currency;
    public String value;

    public String getCurrency() {
        return this.currency;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
