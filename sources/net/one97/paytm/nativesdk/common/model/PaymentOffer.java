package net.one97.paytm.nativesdk.common.model;

public class PaymentOffer implements BaseDataModel {
    private String isPromoVisible;
    private Offer offer;
    private String promoCode;
    private String termTitle;
    private String termsUrl;
    private String validFrom;
    private String validUpto;

    public String getPromoCode() {
        return this.promoCode;
    }

    public void setPromoCode(String str) {
        this.promoCode = str;
    }

    public Offer getOffer() {
        return this.offer;
    }

    public void setOffer(Offer offer2) {
        this.offer = offer2;
    }

    public String getTermsUrl() {
        return this.termsUrl;
    }

    public void setTermsUrl(String str) {
        this.termsUrl = str;
    }

    public String getTermTitle() {
        return this.termTitle;
    }

    public void setTermTitle(String str) {
        this.termTitle = str;
    }

    public String getValidFrom() {
        return this.validFrom;
    }

    public void setValidFrom(String str) {
        this.validFrom = str;
    }

    public String getValidUpto() {
        return this.validUpto;
    }

    public void setValidUpto(String str) {
        this.validUpto = str;
    }

    public String getIsPromoVisible() {
        return this.isPromoVisible;
    }

    public void setIsPromoVisible(String str) {
        this.isPromoVisible = str;
    }

    public static class Offer {
        private String icon;
        private String text;
        private String title;

        public String getTitle() {
            return this.title;
        }

        public void setTitle(String str) {
            this.title = str;
        }

        public String getText() {
            return this.text;
        }

        public void setText(String str) {
            this.text = str;
        }

        public String getIcon() {
            return this.icon;
        }

        public void setIcon(String str) {
            this.icon = str;
        }
    }
}
