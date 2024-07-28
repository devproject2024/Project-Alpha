package net.one97.paytm.recharge.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class CJRPromoCodeTerms extends IJRPaytmDataModel {
    @b(a = "promocode")
    private String promoCode;
    @b(a = "terms")
    private String terms;
    @b(a = "termsTitle")
    private String termsTitle;

    public CJRPromoCodeTerms() {
        this((String) null, (String) null, (String) null, 7, (g) null);
    }

    public static /* synthetic */ CJRPromoCodeTerms copy$default(CJRPromoCodeTerms cJRPromoCodeTerms, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = cJRPromoCodeTerms.terms;
        }
        if ((i2 & 2) != 0) {
            str2 = cJRPromoCodeTerms.termsTitle;
        }
        if ((i2 & 4) != 0) {
            str3 = cJRPromoCodeTerms.promoCode;
        }
        return cJRPromoCodeTerms.copy(str, str2, str3);
    }

    public final String component1() {
        return this.terms;
    }

    public final String component2() {
        return this.termsTitle;
    }

    public final String component3() {
        return this.promoCode;
    }

    public final CJRPromoCodeTerms copy(String str, String str2, String str3) {
        return new CJRPromoCodeTerms(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CJRPromoCodeTerms)) {
            return false;
        }
        CJRPromoCodeTerms cJRPromoCodeTerms = (CJRPromoCodeTerms) obj;
        return k.a((Object) this.terms, (Object) cJRPromoCodeTerms.terms) && k.a((Object) this.termsTitle, (Object) cJRPromoCodeTerms.termsTitle) && k.a((Object) this.promoCode, (Object) cJRPromoCodeTerms.promoCode);
    }

    public final int hashCode() {
        String str = this.terms;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.termsTitle;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.promoCode;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "CJRPromoCodeTerms(terms=" + this.terms + ", termsTitle=" + this.termsTitle + ", promoCode=" + this.promoCode + ")";
    }

    public final String getTerms() {
        return this.terms;
    }

    public final void setTerms(String str) {
        this.terms = str;
    }

    public final String getTermsTitle() {
        return this.termsTitle;
    }

    public final void setTermsTitle(String str) {
        this.termsTitle = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CJRPromoCodeTerms(String str, String str2, String str3, int i2, g gVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }

    public final String getPromoCode() {
        return this.promoCode;
    }

    public final void setPromoCode(String str) {
        this.promoCode = str;
    }

    public CJRPromoCodeTerms(String str, String str2, String str3) {
        this.terms = str;
        this.termsTitle = str2;
        this.promoCode = str3;
    }
}
