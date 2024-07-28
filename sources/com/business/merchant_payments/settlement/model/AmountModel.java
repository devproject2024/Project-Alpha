package com.business.merchant_payments.settlement.model;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class AmountModel {
    @c(a = "currency")
    public String currency;
    @c(a = "value")
    public String value;

    public static /* synthetic */ AmountModel copy$default(AmountModel amountModel, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = amountModel.currency;
        }
        if ((i2 & 2) != 0) {
            str2 = amountModel.value;
        }
        return amountModel.copy(str, str2);
    }

    public final String component1() {
        return this.currency;
    }

    public final String component2() {
        return this.value;
    }

    public final AmountModel copy(String str, String str2) {
        return new AmountModel(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AmountModel)) {
            return false;
        }
        AmountModel amountModel = (AmountModel) obj;
        return k.a((Object) this.currency, (Object) amountModel.currency) && k.a((Object) this.value, (Object) amountModel.value);
    }

    public final int hashCode() {
        String str = this.currency;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "AmountModel(currency=" + this.currency + ", value=" + this.value + ")";
    }

    public AmountModel(String str, String str2) {
        this.currency = str;
        this.value = str2;
    }

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
