package net.one97.paytm.nativesdk.common.model;

public class PromoCodeData implements BaseDataModel {
    private String promoCode;
    private String promoCodeMsg;
    private String promoCodeTypeName;
    private String promoCodeValid;
    private String promoMsg;

    public String getPromoCode() {
        return this.promoCode;
    }

    public void setPromoCode(String str) {
        this.promoCode = str;
    }

    public String getPromoMsg() {
        return this.promoMsg;
    }

    public void setPromoMsg(String str) {
        this.promoMsg = str;
    }

    public String getPromoCodeValid() {
        return this.promoCodeValid;
    }

    public void setPromoCodeValid(String str) {
        this.promoCodeValid = str;
    }

    public String getPromoCodeTypeName() {
        return this.promoCodeTypeName;
    }

    public void setPromoCodeTypeName(String str) {
        this.promoCodeTypeName = str;
    }

    public String getPromoCodeMsg() {
        return this.promoCodeMsg;
    }

    public void setPromoCodeMsg(String str) {
        this.promoCodeMsg = str;
    }
}
