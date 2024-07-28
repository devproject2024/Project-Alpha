package com.paytmmall.clpartifact.modal.clpCommon;

import com.google.gson.a.c;
import kotlin.g.b.k;

public final class PromosDM {
    @c(a = "code")
    private final String code;
    @c(a = "offer")
    private final OfferDM offer;
    @c(a = "offerText")
    private final String offerText;
    @c(a = "savings")
    private final String savings;
    @c(a = "terms")
    private final String terms;
    @c(a = "termsUrl")
    private final String termsUrl;
    @c(a = "terms_title")
    private final String terms_title;
    @c(a = "totalSaving")
    private final Float totalSaving;

    public static /* synthetic */ PromosDM copy$default(PromosDM promosDM, String str, String str2, String str3, String str4, String str5, Float f2, String str6, OfferDM offerDM, int i2, Object obj) {
        PromosDM promosDM2 = promosDM;
        int i3 = i2;
        return promosDM.copy((i3 & 1) != 0 ? promosDM2.code : str, (i3 & 2) != 0 ? promosDM2.savings : str2, (i3 & 4) != 0 ? promosDM2.terms : str3, (i3 & 8) != 0 ? promosDM2.offerText : str4, (i3 & 16) != 0 ? promosDM2.termsUrl : str5, (i3 & 32) != 0 ? promosDM2.totalSaving : f2, (i3 & 64) != 0 ? promosDM2.terms_title : str6, (i3 & 128) != 0 ? promosDM2.offer : offerDM);
    }

    public final String component1() {
        return this.code;
    }

    public final String component2() {
        return this.savings;
    }

    public final String component3() {
        return this.terms;
    }

    public final String component4() {
        return this.offerText;
    }

    public final String component5() {
        return this.termsUrl;
    }

    public final Float component6() {
        return this.totalSaving;
    }

    public final String component7() {
        return this.terms_title;
    }

    public final OfferDM component8() {
        return this.offer;
    }

    public final PromosDM copy(String str, String str2, String str3, String str4, String str5, Float f2, String str6, OfferDM offerDM) {
        return new PromosDM(str, str2, str3, str4, str5, f2, str6, offerDM);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PromosDM)) {
            return false;
        }
        PromosDM promosDM = (PromosDM) obj;
        return k.a((Object) this.code, (Object) promosDM.code) && k.a((Object) this.savings, (Object) promosDM.savings) && k.a((Object) this.terms, (Object) promosDM.terms) && k.a((Object) this.offerText, (Object) promosDM.offerText) && k.a((Object) this.termsUrl, (Object) promosDM.termsUrl) && k.a((Object) this.totalSaving, (Object) promosDM.totalSaving) && k.a((Object) this.terms_title, (Object) promosDM.terms_title) && k.a((Object) this.offer, (Object) promosDM.offer);
    }

    public final int hashCode() {
        String str = this.code;
        int i2 = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.savings;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.terms;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.offerText;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.termsUrl;
        int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
        Float f2 = this.totalSaving;
        int hashCode6 = (hashCode5 + (f2 != null ? f2.hashCode() : 0)) * 31;
        String str6 = this.terms_title;
        int hashCode7 = (hashCode6 + (str6 != null ? str6.hashCode() : 0)) * 31;
        OfferDM offerDM = this.offer;
        if (offerDM != null) {
            i2 = offerDM.hashCode();
        }
        return hashCode7 + i2;
    }

    public final String toString() {
        return "PromosDM(code=" + this.code + ", savings=" + this.savings + ", terms=" + this.terms + ", offerText=" + this.offerText + ", termsUrl=" + this.termsUrl + ", totalSaving=" + this.totalSaving + ", terms_title=" + this.terms_title + ", offer=" + this.offer + ")";
    }

    public PromosDM(String str, String str2, String str3, String str4, String str5, Float f2, String str6, OfferDM offerDM) {
        this.code = str;
        this.savings = str2;
        this.terms = str3;
        this.offerText = str4;
        this.termsUrl = str5;
        this.totalSaving = f2;
        this.terms_title = str6;
        this.offer = offerDM;
    }

    public final String getCode() {
        return this.code;
    }

    public final String getSavings() {
        return this.savings;
    }

    public final String getTerms() {
        return this.terms;
    }

    public final String getOfferText() {
        return this.offerText;
    }

    public final String getTermsUrl() {
        return this.termsUrl;
    }

    public final Float getTotalSaving() {
        return this.totalSaving;
    }

    public final String getTerms_title() {
        return this.terms_title;
    }

    public final OfferDM getOffer() {
        return this.offer;
    }
}
