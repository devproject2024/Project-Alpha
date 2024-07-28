package net.one97.paytm.o2o.movies.entity;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import kotlin.g.b.k;

public final class CJRInsuranceConfig implements Serializable {
    @b(a = "share_booking_id")
    private Boolean share_booking_id;
    @b(a = "terms_cond")
    private CJRCPTermsAndCond terms_cond;

    public static /* synthetic */ CJRInsuranceConfig copy$default(CJRInsuranceConfig cJRInsuranceConfig, CJRCPTermsAndCond cJRCPTermsAndCond, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            cJRCPTermsAndCond = cJRInsuranceConfig.terms_cond;
        }
        if ((i2 & 2) != 0) {
            bool = cJRInsuranceConfig.share_booking_id;
        }
        return cJRInsuranceConfig.copy(cJRCPTermsAndCond, bool);
    }

    public final CJRCPTermsAndCond component1() {
        return this.terms_cond;
    }

    public final Boolean component2() {
        return this.share_booking_id;
    }

    public final CJRInsuranceConfig copy(CJRCPTermsAndCond cJRCPTermsAndCond, Boolean bool) {
        return new CJRInsuranceConfig(cJRCPTermsAndCond, bool);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRInsuranceConfig)) {
            return false;
        }
        CJRInsuranceConfig cJRInsuranceConfig = (CJRInsuranceConfig) obj;
        return k.a((Object) this.terms_cond, (Object) cJRInsuranceConfig.terms_cond) && k.a((Object) this.share_booking_id, (Object) cJRInsuranceConfig.share_booking_id);
    }

    public final int hashCode() {
        CJRCPTermsAndCond cJRCPTermsAndCond = this.terms_cond;
        int i2 = 0;
        int hashCode = (cJRCPTermsAndCond != null ? cJRCPTermsAndCond.hashCode() : 0) * 31;
        Boolean bool = this.share_booking_id;
        if (bool != null) {
            i2 = bool.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "CJRInsuranceConfig(terms_cond=" + this.terms_cond + ", share_booking_id=" + this.share_booking_id + ")";
    }

    public CJRInsuranceConfig(CJRCPTermsAndCond cJRCPTermsAndCond, Boolean bool) {
        this.terms_cond = cJRCPTermsAndCond;
        this.share_booking_id = bool;
    }

    public final CJRCPTermsAndCond getTerms_cond() {
        return this.terms_cond;
    }

    public final void setTerms_cond(CJRCPTermsAndCond cJRCPTermsAndCond) {
        this.terms_cond = cJRCPTermsAndCond;
    }

    public final Boolean getShare_booking_id() {
        return this.share_booking_id;
    }

    public final void setShare_booking_id(Boolean bool) {
        this.share_booking_id = bool;
    }
}
