package net.one97.paytm.p2mNewDesign.entity.mlv.myorders;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.network.CJRWalletDataModel;

public final class PayMode extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "amount")
    private Double amount;
    @b(a = "payment_mode")
    private String paymentMode;

    public PayMode() {
        this((Double) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ PayMode copy$default(PayMode payMode, Double d2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = payMode.amount;
        }
        if ((i2 & 2) != 0) {
            str = payMode.paymentMode;
        }
        return payMode.copy(d2, str);
    }

    public final Double component1() {
        return this.amount;
    }

    public final String component2() {
        return this.paymentMode;
    }

    public final PayMode copy(Double d2, String str) {
        return new PayMode(d2, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PayMode)) {
            return false;
        }
        PayMode payMode = (PayMode) obj;
        return k.a((Object) this.amount, (Object) payMode.amount) && k.a((Object) this.paymentMode, (Object) payMode.paymentMode);
    }

    public final int hashCode() {
        Double d2 = this.amount;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        String str = this.paymentMode;
        if (str != null) {
            i2 = str.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "PayMode(amount=" + this.amount + ", paymentMode=" + this.paymentMode + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final Double getAmount() {
        return this.amount;
    }

    public final void setAmount(Double d2) {
        this.amount = d2;
    }

    public PayMode(Double d2, String str) {
        this.amount = d2;
        this.paymentMode = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PayMode(Double d2, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : d2, (i2 & 2) != 0 ? null : str);
    }

    public final String getPaymentMode() {
        return this.paymentMode;
    }

    public final void setPaymentMode(String str) {
        this.paymentMode = str;
    }
}
