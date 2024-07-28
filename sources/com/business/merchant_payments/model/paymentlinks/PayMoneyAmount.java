package com.business.merchant_payments.model.paymentlinks;

import com.google.gson.a.c;
import java.io.Serializable;

public class PayMoneyAmount implements Serializable {
    @c(a = "currency")
    public String currency;
    @c(a = "value")
    public String value;

    public void setCurrency(String str) {
        this.currency = str;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }

    public String toString() {
        return "PayMoneyAmount{currency = '" + this.currency + '\'' + ",value = '" + this.value + '\'' + "}";
    }
}
