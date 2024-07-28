package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJRPaymentOptions extends IJRPaytmDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "label")
    private String label;

    public String getAmount() {
        return this.amount;
    }

    public String getLabel() {
        return this.label;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CJRPaymentOptions)) {
            return false;
        }
        CJRPaymentOptions cJRPaymentOptions = (CJRPaymentOptions) obj;
        return getLabel().equalsIgnoreCase(cJRPaymentOptions.getLabel()) && getAmount().equalsIgnoreCase(cJRPaymentOptions.getAmount());
    }
}
