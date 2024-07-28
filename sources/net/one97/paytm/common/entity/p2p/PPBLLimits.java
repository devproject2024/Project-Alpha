package net.one97.paytm.common.entity.p2p;

import com.google.gsonhtcfix.a.b;
import kotlin.g.b.g;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.IJRDataModel;

public final class PPBLLimits extends CJRWalletDataModel implements Cloneable, IJRDataModel {
    @b(a = "impsMaxLimit")
    private Double impsMaxLimit;
    @b(a = "minLimit")
    private Double minLimit;
    @b(a = "neftMaxLimit")
    private Double neftMaxLimit;
    @b(a = "upiMaxLimit")
    private Double upiMaxLimit;

    public PPBLLimits() {
        this((Double) null, (Double) null, (Double) null, (Double) null, 15, (g) null);
    }

    public static /* synthetic */ PPBLLimits copy$default(PPBLLimits pPBLLimits, Double d2, Double d3, Double d4, Double d5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            d2 = pPBLLimits.minLimit;
        }
        if ((i2 & 2) != 0) {
            d3 = pPBLLimits.upiMaxLimit;
        }
        if ((i2 & 4) != 0) {
            d4 = pPBLLimits.impsMaxLimit;
        }
        if ((i2 & 8) != 0) {
            d5 = pPBLLimits.neftMaxLimit;
        }
        return pPBLLimits.copy(d2, d3, d4, d5);
    }

    public final Double component1() {
        return this.minLimit;
    }

    public final Double component2() {
        return this.upiMaxLimit;
    }

    public final Double component3() {
        return this.impsMaxLimit;
    }

    public final Double component4() {
        return this.neftMaxLimit;
    }

    public final PPBLLimits copy(Double d2, Double d3, Double d4, Double d5) {
        return new PPBLLimits(d2, d3, d4, d5);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PPBLLimits)) {
            return false;
        }
        PPBLLimits pPBLLimits = (PPBLLimits) obj;
        return k.a((Object) this.minLimit, (Object) pPBLLimits.minLimit) && k.a((Object) this.upiMaxLimit, (Object) pPBLLimits.upiMaxLimit) && k.a((Object) this.impsMaxLimit, (Object) pPBLLimits.impsMaxLimit) && k.a((Object) this.neftMaxLimit, (Object) pPBLLimits.neftMaxLimit);
    }

    public final int hashCode() {
        Double d2 = this.minLimit;
        int i2 = 0;
        int hashCode = (d2 != null ? d2.hashCode() : 0) * 31;
        Double d3 = this.upiMaxLimit;
        int hashCode2 = (hashCode + (d3 != null ? d3.hashCode() : 0)) * 31;
        Double d4 = this.impsMaxLimit;
        int hashCode3 = (hashCode2 + (d4 != null ? d4.hashCode() : 0)) * 31;
        Double d5 = this.neftMaxLimit;
        if (d5 != null) {
            i2 = d5.hashCode();
        }
        return hashCode3 + i2;
    }

    public final String toString() {
        return "PPBLLimits(minLimit=" + this.minLimit + ", upiMaxLimit=" + this.upiMaxLimit + ", impsMaxLimit=" + this.impsMaxLimit + ", neftMaxLimit=" + this.neftMaxLimit + ")";
    }

    public final Object clone() {
        return super.clone();
    }

    public final Double getMinLimit() {
        return this.minLimit;
    }

    public final void setMinLimit(Double d2) {
        this.minLimit = d2;
    }

    public final Double getUpiMaxLimit() {
        return this.upiMaxLimit;
    }

    public final void setUpiMaxLimit(Double d2) {
        this.upiMaxLimit = d2;
    }

    public final Double getImpsMaxLimit() {
        return this.impsMaxLimit;
    }

    public final void setImpsMaxLimit(Double d2) {
        this.impsMaxLimit = d2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PPBLLimits(Double d2, Double d3, Double d4, Double d5, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : d2, (i2 & 2) != 0 ? null : d3, (i2 & 4) != 0 ? null : d4, (i2 & 8) != 0 ? null : d5);
    }

    public final Double getNeftMaxLimit() {
        return this.neftMaxLimit;
    }

    public final void setNeftMaxLimit(Double d2) {
        this.neftMaxLimit = d2;
    }

    public PPBLLimits(Double d2, Double d3, Double d4, Double d5) {
        this.minLimit = d2;
        this.upiMaxLimit = d3;
        this.impsMaxLimit = d4;
        this.neftMaxLimit = d5;
    }
}
