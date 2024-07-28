package net.one97.paytm.common.entity.vipcashback;

import com.google.gson.a.c;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public final class VoucherTermsResponse extends CashBackBaseModal {
    @c(a = "promocode")
    private String promocode;
    @c(a = "siteId")
    private String siteId;
    @c(a = "terms")
    private String terms;
    @c(a = "termsTitle")
    private String termsTitle;

    public final String getTerms() {
        return this.terms;
    }

    public final void setTerms(String str) {
        this.terms = str;
    }

    public final String getPromocode() {
        return this.promocode;
    }

    public final void setPromocode(String str) {
        this.promocode = str;
    }

    public final String getSiteId() {
        return this.siteId;
    }

    public final void setSiteId(String str) {
        this.siteId = str;
    }

    public final String getTermsTitle() {
        return this.termsTitle;
    }

    public final void setTermsTitle(String str) {
        this.termsTitle = str;
    }
}
