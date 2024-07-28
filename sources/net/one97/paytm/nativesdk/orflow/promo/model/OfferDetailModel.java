package net.one97.paytm.nativesdk.orflow.promo.model;

import kotlin.g.b.k;
import net.one97.paytm.nativesdk.common.model.BaseDataModel;

public final class OfferDetailModel implements BaseDataModel {
    private String promocode;
    private String terms;
    private String termsTitle;

    public static /* synthetic */ OfferDetailModel copy$default(OfferDetailModel offerDetailModel, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = offerDetailModel.terms;
        }
        if ((i2 & 2) != 0) {
            str2 = offerDetailModel.promocode;
        }
        if ((i2 & 4) != 0) {
            str3 = offerDetailModel.termsTitle;
        }
        return offerDetailModel.copy(str, str2, str3);
    }

    public final String component1() {
        return this.terms;
    }

    public final String component2() {
        return this.promocode;
    }

    public final String component3() {
        return this.termsTitle;
    }

    public final OfferDetailModel copy(String str, String str2, String str3) {
        return new OfferDetailModel(str, str2, str3);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OfferDetailModel)) {
            return false;
        }
        OfferDetailModel offerDetailModel = (OfferDetailModel) obj;
        return k.a((Object) this.terms, (Object) offerDetailModel.terms) && k.a((Object) this.promocode, (Object) offerDetailModel.promocode) && k.a((Object) this.termsTitle, (Object) offerDetailModel.termsTitle);
    }

    public final int hashCode() {
        String str = this.terms;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.promocode;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.termsTitle;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode2 + i2;
    }

    public final String toString() {
        return "OfferDetailModel(terms=" + this.terms + ", promocode=" + this.promocode + ", termsTitle=" + this.termsTitle + ")";
    }

    public OfferDetailModel(String str, String str2, String str3) {
        this.terms = str;
        this.promocode = str2;
        this.termsTitle = str3;
    }

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

    public final String getTermsTitle() {
        return this.termsTitle;
    }

    public final void setTermsTitle(String str) {
        this.termsTitle = str;
    }
}
