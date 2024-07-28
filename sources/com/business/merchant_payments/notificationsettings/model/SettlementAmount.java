package com.business.merchant_payments.notificationsettings.model;

import kotlin.g.b.k;

public final class SettlementAmount {
    public final String currency;
    public final String value;

    public static /* synthetic */ SettlementAmount copy$default(SettlementAmount settlementAmount, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = settlementAmount.currency;
        }
        if ((i2 & 2) != 0) {
            str2 = settlementAmount.value;
        }
        return settlementAmount.copy(str, str2);
    }

    public final String component1() {
        return this.currency;
    }

    public final String component2() {
        return this.value;
    }

    public final SettlementAmount copy(String str, String str2) {
        k.d(str, "currency");
        k.d(str2, "value");
        return new SettlementAmount(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SettlementAmount)) {
            return false;
        }
        SettlementAmount settlementAmount = (SettlementAmount) obj;
        return k.a((Object) this.currency, (Object) settlementAmount.currency) && k.a((Object) this.value, (Object) settlementAmount.value);
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
        return "SettlementAmount(currency=" + this.currency + ", value=" + this.value + ")";
    }

    public SettlementAmount(String str, String str2) {
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
