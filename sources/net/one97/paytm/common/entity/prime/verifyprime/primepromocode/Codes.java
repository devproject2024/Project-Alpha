package net.one97.paytm.common.entity.prime.verifyprime.primepromocode;

public class Codes {
    private String betterOfferText;
    private String code;
    private String codeStatus;
    private String[] displayTags;
    private String effective_price;
    private String isBetterOfferAvailableOnMall;
    private String isFlashCode;
    private String offerText;
    private String priority;
    private String promo_text;
    private String redemptionType;
    private String savings;
    private String site_id;
    private String terms;
    private String terms_title;
    private String valid_from;
    private String valid_upto;
    private String visible_from;
    private String visible_upto;

    public String getValid_from() {
        return this.valid_from;
    }

    public String getVisible_from() {
        return this.visible_from;
    }

    public String getTerms() {
        return this.terms;
    }

    public String getSite_id() {
        return this.site_id;
    }

    public String getCode() {
        return this.code;
    }

    public String getSavings() {
        return this.savings;
    }

    public String getPromo_text() {
        return this.promo_text;
    }

    public String getValid_upto() {
        return this.valid_upto;
    }

    public String getCodeStatus() {
        return this.codeStatus;
    }

    public String[] getDisplayTags() {
        return this.displayTags;
    }

    public String getTerms_title() {
        return this.terms_title;
    }

    public String getVisible_upto() {
        return this.visible_upto;
    }

    public String getBetterOfferText() {
        return this.betterOfferText;
    }

    public String getIsFlashCode() {
        return this.isFlashCode;
    }

    public String getOfferText() {
        return this.offerText;
    }

    public String getEffective_price() {
        return this.effective_price;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getRedemptionType() {
        return this.redemptionType;
    }

    public String getIsBetterOfferAvailableOnMall() {
        return this.isBetterOfferAvailableOnMall;
    }
}
