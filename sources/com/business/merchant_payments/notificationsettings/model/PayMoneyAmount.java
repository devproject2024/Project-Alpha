package com.business.merchant_payments.notificationsettings.model;

import kotlin.g.b.k;

public final class PayMoneyAmount {
    public final String currency;
    public final String value;

    public static /* synthetic */ PayMoneyAmount copy$default(PayMoneyAmount payMoneyAmount, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = payMoneyAmount.currency;
        }
        if ((i2 & 2) != 0) {
            str2 = payMoneyAmount.value;
        }
        return payMoneyAmount.copy(str, str2);
    }

    public final String component1() {
        return this.currency;
    }

    public final String component2() {
        return this.value;
    }

    public final PayMoneyAmount copy(String str, String str2) {
        k.d(str, "currency");
        k.d(str2, "value");
        return new PayMoneyAmount(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayMoneyAmount)) {
            return false;
        }
        PayMoneyAmount payMoneyAmount = (PayMoneyAmount) obj;
        return k.a((Object) this.currency, (Object) payMoneyAmount.currency) && k.a((Object) this.value, (Object) payMoneyAmount.value);
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
        return "PayMoneyAmount(currency=" + this.currency + ", value=" + this.value + ")";
    }

    public PayMoneyAmount(String str, String str2) {
        k.d(str, "currency");
        k.d(str2, "value");
        this.currency = str;
        this.value = str2;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getValue() {
        return this.value;
    }
}
