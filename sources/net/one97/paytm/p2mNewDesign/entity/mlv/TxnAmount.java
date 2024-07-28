package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class TxnAmount extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "currency")
    private String currency;
    @b(a = "value")
    private Integer value;

    public TxnAmount() {
        this((Integer) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ TxnAmount copy$default(TxnAmount txnAmount, Integer num, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = txnAmount.value;
        }
        if ((i2 & 2) != 0) {
            str = txnAmount.currency;
        }
        return txnAmount.copy(num, str);
    }

    public final Integer component1() {
        return this.value;
    }

    public final String component2() {
        return this.currency;
    }

    public final TxnAmount copy(Integer num, String str) {
        return new TxnAmount(num, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TxnAmount)) {
            return false;
        }
        TxnAmount txnAmount = (TxnAmount) obj;
        return k.a((Object) this.value, (Object) txnAmount.value) && k.a((Object) this.currency, (Object) txnAmount.currency);
    }

    public final int hashCode() {
        Integer num = this.value;
        int i2 = 0;
        int hashCode = (num != null ? num.hashCode() : 0) * 31;
        String str = this.currency;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "TxnAmount(value=" + this.value + ", currency=" + this.currency + ")";
    }

    public TxnAmount(Integer num, String str) {
        this.value = num;
        this.currency = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TxnAmount(Integer num, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str);
    }

    public final Object clone() {
        return super.clone();
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final Integer getValue() {
        return this.value;
    }

    public final void setCurrency(String str) {
        this.currency = str;
    }

    public final void setValue(Integer num) {
        this.value = num;
    }
}
