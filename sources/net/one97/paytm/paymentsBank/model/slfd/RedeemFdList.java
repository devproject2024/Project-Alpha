package net.one97.paytm.paymentsBank.model.slfd;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class RedeemFdList extends IJRPaytmDataModel {
    @b(a = "amount")
    private double amount;
    @b(a = "fd_id")
    private String fdId;

    public static /* synthetic */ RedeemFdList copy$default(RedeemFdList redeemFdList, double d2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = redeemFdList.amount;
        }
        if ((i2 & 2) != 0) {
            str = redeemFdList.fdId;
        }
        return redeemFdList.copy(d2, str);
    }

    public final double component1() {
        return this.amount;
    }

    public final String component2() {
        return this.fdId;
    }

    public final RedeemFdList copy(double d2, String str) {
        k.c(str, "fdId");
        return new RedeemFdList(d2, str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedeemFdList)) {
            return false;
        }
        RedeemFdList redeemFdList = (RedeemFdList) obj;
        return Double.compare(this.amount, redeemFdList.amount) == 0 && k.a((Object) this.fdId, (Object) redeemFdList.fdId);
    }

    public final int hashCode() {
        long doubleToLongBits = Double.doubleToLongBits(this.amount);
        int i2 = ((int) (doubleToLongBits ^ (doubleToLongBits >>> 32))) * 31;
        String str = this.fdId;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public final String toString() {
        return "RedeemFdList(amount=" + this.amount + ", fdId=" + this.fdId + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RedeemFdList(double d2, String str, int i2, g gVar) {
        this((i2 & 1) != 0 ? 0.0d : d2, str);
    }

    public final double getAmount() {
        return this.amount;
    }

    public final void setAmount(double d2) {
        this.amount = d2;
    }

    public RedeemFdList(double d2, String str) {
        k.c(str, "fdId");
        this.amount = d2;
        this.fdId = str;
    }

    public final String getFdId() {
        return this.fdId;
    }

    public final void setFdId(String str) {
        k.c(str, "<set-?>");
        this.fdId = str;
    }
}
