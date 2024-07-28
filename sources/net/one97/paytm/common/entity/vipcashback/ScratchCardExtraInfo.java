package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class ScratchCardExtraInfo extends CashBackBaseModal {
    @b(a = "bgImageUrl")
    private String bgImageUrl;
    @b(a = "code")
    private String code;
    @b(a = "collectibleDisplayType")
    private String collectibleDisplayType;
    @b(a = "cross_promo_usage_text")
    private String crossPromoUsageText;
    @b(a = "cross_promo_text")
    private String cross_promo_text;
    @b(a = "cross_promocode_icon")
    private String cross_promocode_icon;
    @b(a = "cta")
    private String cta;
    @b(a = "ctaDeeplink")
    private String ctaDeeplink;
    @b(a = "deal_expiry")
    private String dealExpiry;
    @b(a = "deal_icon")
    private String dealIcon;
    @b(a = "deal_redemption_terms")
    private String dealRedemptionTerms;
    @b(a = "deal_terms")
    private String dealTerms;
    @b(a = "deal_text")
    private String dealText;
    @b(a = "deal_usage_text")
    private String dealUsageText;
    @b(a = "deal_valid_from")
    private String dealValidFrom;
    @b(a = "deal_voucher_code")
    private String dealVoucherCode;
    @b(a = "redemptionType")
    private String redemptionType;
    @b(a = "secret")
    private String secret;
    @b(a = "site_id")
    private String site_id;
    @b(a = "terms_conditions")
    private String terms_conditions;
    @b(a = "valid_from")
    private String validFrom;
    @b(a = "valid_upto")
    private String valid_upto;

    public String getCta() {
        return this.cta;
    }

    public void setCta(String str) {
        this.cta = str;
    }

    public String getValidUpto() {
        return this.valid_upto;
    }

    public void setValid_upto(String str) {
        this.valid_upto = str;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String getCross_promo_text() {
        return this.cross_promo_text;
    }

    public void setCross_promo_text(String str) {
        this.cross_promo_text = str;
    }

    public String getRedemptionType() {
        return this.redemptionType;
    }

    public void setRedemptionType(String str) {
        this.redemptionType = str;
    }

    public String getTermsConditions() {
        return this.terms_conditions;
    }

    public void setTerms_conditions(String str) {
        this.terms_conditions = str;
    }

    public String getSite_id() {
        return this.site_id;
    }

    public void setSite_id(String str) {
        this.site_id = str;
    }

    public String getValidFrom() {
        return this.validFrom;
    }

    public String getCross_promocode_icon() {
        return this.cross_promocode_icon;
    }

    public void setCross_promocode_icon(String str) {
        this.cross_promocode_icon = str;
    }

    public String getDealIcon() {
        return this.dealIcon;
    }

    public String getDealText() {
        return this.dealText;
    }

    public String getDealValidFrom() {
        return this.dealValidFrom;
    }

    public String getCollectibleDisplayType() {
        return this.collectibleDisplayType;
    }

    public void setCollectibleDisplayType(String str) {
        this.collectibleDisplayType = str;
    }

    public String getDealExpiry() {
        return this.dealExpiry;
    }

    public String getDealTerms() {
        return this.dealTerms;
    }

    public String getDealUsageText() {
        return this.dealUsageText;
    }

    public String getCrossPromoUsageText() {
        return this.crossPromoUsageText;
    }

    public String getDealVoucherCode() {
        return this.dealVoucherCode;
    }

    public String getDealRedemptionTerms() {
        return this.dealRedemptionTerms;
    }

    public String getCtaDeeplink() {
        return this.ctaDeeplink;
    }

    public String getSecret() {
        return this.secret;
    }

    public String getBgImageUrl() {
        return this.bgImageUrl;
    }
}
