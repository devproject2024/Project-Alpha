package net.one97.paytm.recharge.model;

import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.CJRRechargeCart;

public final class CJRAmountPreFetchDetails {
    private String amount;
    private CJRRechargeCart cjrRechargeCart;
    private String rechargeNumber;

    public CJRAmountPreFetchDetails() {
        this((String) null, (CJRRechargeCart) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ CJRAmountPreFetchDetails copy$default(CJRAmountPreFetchDetails cJRAmountPreFetchDetails, String str, CJRRechargeCart cJRRechargeCart, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRAmountPreFetchDetails.amount;
        }
        if ((i2 & 2) != 0) {
            cJRRechargeCart = cJRAmountPreFetchDetails.cjrRechargeCart;
        }
        if ((i2 & 4) != 0) {
            str2 = cJRAmountPreFetchDetails.rechargeNumber;
        }
        return cJRAmountPreFetchDetails.copy(str, cJRRechargeCart, str2);
    }

    public final String component1() {
        return this.amount;
    }

    public final CJRRechargeCart component2() {
        return this.cjrRechargeCart;
    }

    public final String component3() {
        return this.rechargeNumber;
    }

    public final CJRAmountPreFetchDetails copy(String str, CJRRechargeCart cJRRechargeCart, String str2) {
        return new CJRAmountPreFetchDetails(str, cJRRechargeCart, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRAmountPreFetchDetails)) {
            return false;
        }
        CJRAmountPreFetchDetails cJRAmountPreFetchDetails = (CJRAmountPreFetchDetails) obj;
        return k.a((Object) this.amount, (Object) cJRAmountPreFetchDetails.amount) && k.a((Object) this.cjrRechargeCart, (Object) cJRAmountPreFetchDetails.cjrRechargeCart) && k.a((Object) this.rechargeNumber, (Object) cJRAmountPreFetchDetails.rechargeNumber);
    }

    public final int hashCode() {
        String str = this.amount;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        CJRRechargeCart cJRRechargeCart = this.cjrRechargeCart;
        int hashCode2 = (hashCode + (cJRRechargeCart != null ? cJRRechargeCart.hashCode() : 0)) * 31;
        String str2 = this.rechargeNumber;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CJRAmountPreFetchDetails(amount=" + this.amount + ", cjrRechargeCart=" + this.cjrRechargeCart + ", rechargeNumber=" + this.rechargeNumber + ")";
    }

    public CJRAmountPreFetchDetails(String str, CJRRechargeCart cJRRechargeCart, String str2) {
        this.amount = str;
        this.cjrRechargeCart = cJRRechargeCart;
        this.rechargeNumber = str2;
    }

    public final String getAmount() {
        return this.amount;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final CJRRechargeCart getCjrRechargeCart() {
        return this.cjrRechargeCart;
    }

    public final void setCjrRechargeCart(CJRRechargeCart cJRRechargeCart) {
        this.cjrRechargeCart = cJRRechargeCart;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRAmountPreFetchDetails(String str, CJRRechargeCart cJRRechargeCart, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : cJRRechargeCart, (i2 & 4) != 0 ? null : str2);
    }

    public final String getRechargeNumber() {
        return this.rechargeNumber;
    }

    public final void setRechargeNumber(String str) {
        this.rechargeNumber = str;
    }
}
