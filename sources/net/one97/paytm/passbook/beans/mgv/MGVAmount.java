package net.one97.paytm.passbook.beans.mgv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class MGVAmount extends IJRDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "amountInRs")
    private String amountInRs;
    @b(a = "currency")
    private String currency;
    @b(a = "value")
    private String value;

    public static /* synthetic */ MGVAmount copy$default(MGVAmount mGVAmount, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mGVAmount.currency;
        }
        if ((i2 & 2) != 0) {
            str2 = mGVAmount.value;
        }
        if ((i2 & 4) != 0) {
            str3 = mGVAmount.amount;
        }
        if ((i2 & 8) != 0) {
            str4 = mGVAmount.amountInRs;
        }
        return mGVAmount.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.currency;
    }

    public final String component2() {
        return this.value;
    }

    public final String component3() {
        return this.amount;
    }

    public final String component4() {
        return this.amountInRs;
    }

    public final MGVAmount copy(String str, String str2, String str3, String str4) {
        k.c(str, "currency");
        k.c(str2, "value");
        k.c(str3, "amount");
        k.c(str4, "amountInRs");
        return new MGVAmount(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MGVAmount)) {
            return false;
        }
        MGVAmount mGVAmount = (MGVAmount) obj;
        return k.a((Object) this.currency, (Object) mGVAmount.currency) && k.a((Object) this.value, (Object) mGVAmount.value) && k.a((Object) this.amount, (Object) mGVAmount.amount) && k.a((Object) this.amountInRs, (Object) mGVAmount.amountInRs);
    }

    public final int hashCode() {
        String str = this.currency;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.amount;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.amountInRs;
        if (str4 != null) {
            i2 = str4.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "MGVAmount(currency=" + this.currency + ", value=" + this.value + ", amount=" + this.amount + ", amountInRs=" + this.amountInRs + ")";
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final void setCurrency(String str) {
        k.c(str, "<set-?>");
        this.currency = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        k.c(str, "<set-?>");
        this.value = str;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        k.c(str, "<set-?>");
        this.amount = str;
    }

    public MGVAmount(String str, String str2, String str3, String str4) {
        k.c(str, "currency");
        k.c(str2, "value");
        k.c(str3, "amount");
        k.c(str4, "amountInRs");
        this.currency = str;
        this.value = str2;
        this.amount = str3;
        this.amountInRs = str4;
    }

    public final String getAmountInRs() {
        return this.amountInRs;
    }

    public final void setAmountInRs(String str) {
        k.c(str, "<set-?>");
        this.amountInRs = str;
    }
}
