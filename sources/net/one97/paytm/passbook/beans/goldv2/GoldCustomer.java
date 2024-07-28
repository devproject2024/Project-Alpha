package net.one97.paytm.passbook.beans.goldv2;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.passbook.mapping.IJRDataModel;

public final class GoldCustomer extends IJRDataModel {
    @b(a = "net_worth_in_grams")
    private final Double netWorthInGm;
    @b(a = "net_worth_in_rupees")
    private final Double netWorthInRs;

    public GoldCustomer() {
        this((Double) null, (Double) null, 3, (g) null);
    }

    public static /* synthetic */ GoldCustomer copy$default(GoldCustomer goldCustomer, Double d2, Double d3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = goldCustomer.netWorthInRs;
        }
        if ((i2 & 2) != 0) {
            d3 = goldCustomer.netWorthInGm;
        }
        return goldCustomer.copy(d2, d3);
    }

    public final Double component1() {
        return this.netWorthInRs;
    }

    public final Double component2() {
        return this.netWorthInGm;
    }

    public final GoldCustomer copy(Double d2, Double d3) {
        return new GoldCustomer(d2, d3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoldCustomer)) {
            return false;
        }
        GoldCustomer goldCustomer = (GoldCustomer) obj;
        return k.a((Object) this.netWorthInRs, (Object) goldCustomer.netWorthInRs) && k.a((Object) this.netWorthInGm, (Object) goldCustomer.netWorthInGm);
    }

    public final int hashCode() {
        Double d2 = this.netWorthInRs;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        Double d3 = this.netWorthInGm;
        if (d3 != null) {
            i2 = d3.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "GoldCustomer(netWorthInRs=" + this.netWorthInRs + ", netWorthInGm=" + this.netWorthInGm + ")";
    }

    public final Double getNetWorthInRs() {
        return this.netWorthInRs;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoldCustomer(Double d2, Double d3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : d2, (i2 & 2) != 0 ? null : d3);
    }

    public final Double getNetWorthInGm() {
        return this.netWorthInGm;
    }

    public GoldCustomer(Double d2, Double d3) {
        this.netWorthInRs = d2;
        this.netWorthInGm = d3;
    }
}
