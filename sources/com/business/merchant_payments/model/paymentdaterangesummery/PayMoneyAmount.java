package com.business.merchant_payments.model.paymentdaterangesummery;

import com.business.common_module.f.a;
import com.google.gson.a.c;

public final class PayMoneyAmount extends a {
    @c(a = "currency")
    public String currency;
    @c(a = "value")
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
