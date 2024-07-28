package net.one97.paytm.p2mNewDesign.entity.mlv;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class PayableAmount extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "currency")
    private String currency;
    @b(a = "value")
    private Integer value;

    public PayableAmount() {
        this((Integer) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ PayableAmount copy$default(PayableAmount payableAmount, Integer num, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = payableAmount.value;
        }
        if ((i2 & 2) != 0) {
            str = payableAmount.currency;
        }
        return payableAmount.copy(num, str);
    }

    public final Integer component1() {
        return this.value;
    }

    public final String component2() {
        return this.currency;
    }

    public final PayableAmount copy(Integer num, String str) {
        return new PayableAmount(num, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayableAmount)) {
            return false;
        }
        PayableAmount payableAmount = (PayableAmount) obj;
        return k.a((Object) this.value, (Object) payableAmount.value) && k.a((Object) this.currency, (Object) payableAmount.currency);
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
        return "PayableAmount(value=" + this.value + ", currency=" + this.currency + ")";
    }

    public PayableAmount(Integer num, String str) {
        this.value = num;
        this.currency = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PayableAmount(Integer num, String str, int i2, g gVar) {
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
