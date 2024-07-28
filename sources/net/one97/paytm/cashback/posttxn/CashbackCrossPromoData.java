package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CashbackCrossPromoData extends IJRPaytmDataModel {
    @b(a = "creation_level")
    private String creationLevel;
    @b(a = "code")
    private String crossPromoCode;
    @b(a = "cross_promo_text")
    private String crossPromoText;
    @b(a = "cross_promo_usage_text")
    private String crossPromoUsageText;
    @b(a = "cross_promocode_icon")
    private String crossPromocodeIcon;
    @b(a = "cta")
    private String cta;
    @b(a = "cta_deeplink")
    private String ctaDeeplink;
    @b(a = "frontend_redemption_type")
    private String frontendRedemptionType;
    @b(a = "site_id")
    private String siteId;
    @b(a = "terms_conditions")
    private String termsConditions;
    @b(a = "valid_from")
    private String validFrom;
    @b(a = "valid_upto")
    private String validUpto;
    @b(a = "val")
    private String value;

    public String getCreationLevel() {
        return this.creationLevel;
    }

    public String getValidFrom() {
        return this.validFrom;
    }

    public String getCta() {
        return this.cta;
    }

    public String getValidUpto() {
        return this.validUpto;
    }

    public String getCrossPromoText() {
        return this.crossPromoText;
    }

    public String getCrossPromoUsageText() {
        return this.crossPromoUsageText;
    }

    public String getCrossPromoCode() {
        return this.crossPromoCode;
    }

    public String getTermsConditions() {
        return this.termsConditions;
    }

    public String getSiteId() {
        return this.siteId;
    }

    public String getCtaDeeplink() {
        return this.ctaDeeplink;
    }

    public String getCrossPromocodeIcon() {
        return this.crossPromocodeIcon;
    }

    public String getFrontendRedemptionType() {
        return this.frontendRedemptionType;
    }

    public void setFrontendRedemptionType(String str) {
        this.frontendRedemptionType = str;
    }

    public String getValue() {
        return this.value;
    }
}
