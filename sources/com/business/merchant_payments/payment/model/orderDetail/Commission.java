package com.business.merchant_payments.payment.model.orderDetail;

import com.google.gson.a.a;
import com.google.gson.a.c;
import java.io.Serializable;

public final class Commission implements Serializable {
    @c(a = "currency")
    @a
    public String currency;
    @c(a = "value")
    @a
    public String value;

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
