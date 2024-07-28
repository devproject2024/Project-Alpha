package net.one97.paytm.p2mNewDesign.models;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class AmountV2 extends CJRWalletDataModel implements IJRDataModel {
    @b(a = "currency")
    private String currency;
    @b(a = "value")
    private Double value;

    public AmountV2() {
        this((String) null, (Double) null, 3, (g) null);
    }

    public static /* synthetic */ AmountV2 copy$default(AmountV2 amountV2, String str, Double d2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = amountV2.currency;
        }
        if ((i2 & 2) != 0) {
            d2 = amountV2.value;
        }
        return amountV2.copy(str, d2);
    }

    public final String component1() {
        return this.currency;
    }

    public final Double component2() {
        return this.value;
    }

    public final AmountV2 copy(String str, Double d2) {
        return new AmountV2(str, d2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AmountV2)) {
            return false;
        }
        AmountV2 amountV2 = (AmountV2) obj;
        return k.a((Object) this.currency, (Object) amountV2.currency) && k.a((Object) this.value, (Object) amountV2.value);
    }

    public final int hashCode() {
        String str = this.currency;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        Double d2 = this.value;
        if (d2 != null) {
            i2 = d2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "AmountV2(currency=" + this.currency + ", value=" + this.value + ")";
    }

    public AmountV2(String str, Double d2) {
        this.currency = str;
        this.value = d2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AmountV2(String str, Double d2, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : d2);
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final Double getValue() {
        return this.value;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setValue(Double d2) {
        this.value = d2;
    }
}
