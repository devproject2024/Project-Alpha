package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class CFSVoucherTotalBalance {
    @c(a = "amount")
    private final String amount;
    @c(a = "amountInRs")
    private final String amountInRs;
    @c(a = "currency")
    private final String currency;
    @c(a = "value")
    private final String value;

    public static /* synthetic */ CFSVoucherTotalBalance copy$default(CFSVoucherTotalBalance cFSVoucherTotalBalance, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cFSVoucherTotalBalance.currency;
        }
        if ((i2 & 2) != 0) {
            str2 = cFSVoucherTotalBalance.value;
        }
        if ((i2 & 4) != 0) {
            str3 = cFSVoucherTotalBalance.amount;
        }
        if ((i2 & 8) != 0) {
            str4 = cFSVoucherTotalBalance.amountInRs;
        }
        return cFSVoucherTotalBalance.copy(str, str2, str3, str4);
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

    public final CFSVoucherTotalBalance copy(String str, String str2, String str3, String str4) {
        return new CFSVoucherTotalBalance(str, str2, str3, str4);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CFSVoucherTotalBalance)) {
            return false;
        }
        CFSVoucherTotalBalance cFSVoucherTotalBalance = (CFSVoucherTotalBalance) obj;
        return k.a((Object) this.currency, (Object) cFSVoucherTotalBalance.currency) && k.a((Object) this.value, (Object) cFSVoucherTotalBalance.value) && k.a((Object) this.amount, (Object) cFSVoucherTotalBalance.amount) && k.a((Object) this.amountInRs, (Object) cFSVoucherTotalBalance.amountInRs);
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
        return "CFSVoucherTotalBalance(currency=" + this.currency + ", value=" + this.value + ", amount=" + this.amount + ", amountInRs=" + this.amountInRs + ")";
    }

    public CFSVoucherTotalBalance(String str, String str2, String str3, String str4) {
        this.currency = str;
        this.value = str2;
        this.amount = str3;
        this.amountInRs = str4;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getAmountInRs() {
        return this.amountInRs;
    }
}
