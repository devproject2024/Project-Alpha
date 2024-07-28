package com.business.merchant_payments.model.v2;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class Pcfee {
    @c(a = "currency")
    @a
    public String currency;
    @c(a = "value")
    @a
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
