package net.one97.paytm.nativesdk.common.model;

public class TermsAndConditionModel implements BaseDataModel {
    private String promocode;
    private int siteId;
    private String terms;
    private String termsTitle;

    public String getTerms() {
        return this.terms;
    }

    public void setTerms(String str) {
        this.terms = str;
    }

    public String getPromocode() {
        return this.promocode;
    }

    public void setPromocode(String str) {
        this.promocode = str;
    }

    public int getSiteId() {
        return this.siteId;
    }

    public void setSiteId(int i2) {
        this.siteId = i2;
    }

    public String getTermsTitle() {
        return this.termsTitle;
    }

    public void setTermsTitle(String str) {
        this.termsTitle = str;
    }
}
