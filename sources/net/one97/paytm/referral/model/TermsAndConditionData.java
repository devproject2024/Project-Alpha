package net.one97.paytm.referral.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class TermsAndConditionData extends IJRPaytmDataModel {
    @b(a = "terms")
    private String terms;
    @b(a = "terms_title")
    private String termsTitle;

    public TermsAndConditionData() {
        this((String) null, (String) null, 3, (g) null);
    }

    public static /* synthetic */ TermsAndConditionData copy$default(TermsAndConditionData termsAndConditionData, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = termsAndConditionData.terms;
        }
        if ((i2 & 2) != 0) {
            str2 = termsAndConditionData.termsTitle;
        }
        return termsAndConditionData.copy(str, str2);
    }

    public final String component1() {
        return this.terms;
    }

    public final String component2() {
        return this.termsTitle;
    }

    public final TermsAndConditionData copy(String str, String str2) {
        k.c(str, "terms");
        k.c(str2, "termsTitle");
        return new TermsAndConditionData(str, str2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TermsAndConditionData)) {
            return false;
        }
        TermsAndConditionData termsAndConditionData = (TermsAndConditionData) obj;
        return k.a((Object) this.terms, (Object) termsAndConditionData.terms) && k.a((Object) this.termsTitle, (Object) termsAndConditionData.termsTitle);
    }

    public final int hashCode() {
        String str = this.terms;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.termsTitle;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return hashCode + i2;
    }

    public final String toString() {
        return "TermsAndConditionData(terms=" + this.terms + ", termsTitle=" + this.termsTitle + ")";
    }

    public final String getTerms() {
        return this.terms;
    }

    public final void setTerms(String str) {
        k.c(str, "<set-?>");
        this.terms = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TermsAndConditionData(String str, String str2, int i2, g gVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2);
    }

    public final String getTermsTitle() {
        return this.termsTitle;
    }

    public final void setTermsTitle(String str) {
        k.c(str, "<set-?>");
        this.termsTitle = str;
    }

    public TermsAndConditionData(String str, String str2) {
        k.c(str, "terms");
        k.c(str2, "termsTitle");
        this.terms = str;
        this.termsTitle = str2;
    }
}
