package net.one97.paytm.nativesdk.common.model;

import com.google.gson.a.c;

public class SimplifiedPaymentsOffer {
    @c(a = "applyAvailablePromo")
    private String applyAvailablePromo;
    @c(a = "promoCode")
    private String promoCode;
    @c(a = "validatePromo")
    private String validatePromo;

    public String getPromoCode() {
        return this.promoCode;
    }

    public String getApplyAvailablePromo() {
        return this.applyAvailablePromo;
    }

    public String getValidatePromo() {
        return this.validatePromo;
    }

    public void setPromoCode(String str) {
        this.promoCode = str;
    }

    public void setApplyAvailablePromo(String str) {
        this.applyAvailablePromo = str;
    }

    public void setValidatePromo(String str) {
        this.validatePromo = str;
    }
}
