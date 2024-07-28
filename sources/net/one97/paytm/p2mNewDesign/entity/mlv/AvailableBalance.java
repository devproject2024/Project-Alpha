package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class AvailableBalance extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "amount")
    private String amount;
    @b(a = "currency")
    private String currency;
    @b(a = "value")
    private String value;

    public AvailableBalance() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ AvailableBalance copy$default(AvailableBalance availableBalance, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = availableBalance.currency;
        }
        if ((i2 & 2) != 0) {
            str2 = availableBalance.value;
        }
        if ((i2 & 4) != 0) {
            str3 = availableBalance.amount;
        }
        return availableBalance.copy(str, str2, str3);
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

    public final AvailableBalance copy(String str, String str2, String str3) {
        return new AvailableBalance(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AvailableBalance)) {
            return false;
        }
        AvailableBalance availableBalance = (AvailableBalance) obj;
        return k.a((Object) this.currency, (Object) availableBalance.currency) && k.a((Object) this.value, (Object) availableBalance.value) && k.a((Object) this.amount, (Object) availableBalance.amount);
    }

    public final int hashCode() {
        String str = this.currency;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.amount;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "AvailableBalance(currency=" + this.currency + ", value=" + this.value + ", amount=" + this.amount + ")";
    }

    public AvailableBalance(String str, String str2, String str3) {
        this.currency = str;
        this.value = str2;
        this.amount = str3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AvailableBalance(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setAmount(String str) {
        this.amount = str;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
