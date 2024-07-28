package net.one97.paytm.nativesdk.common.model;

import android.text.TextUtils;

public class PaymentOfferDetails implements BaseDataModel {
    private String cashbackAmount;
    private String instantDiscount;
    private String payMethod;
    private String promoVisibility;
    private String promocodeApplied;
    private String promotext;

    public String getPromocodeApplied() {
        return this.promocodeApplied;
    }

    public void setPromocodeApplied(String str) {
        this.promocodeApplied = str;
    }

    public String getPromoText() {
        return this.promotext;
    }

    public void setPromoText(String str) {
        this.promotext = str;
    }

    public String getInstantDiscount() {
        return this.instantDiscount;
    }

    public void setInstantDiscount(String str) {
        this.instantDiscount = str;
    }

    public String getCashbackAmount() {
        return this.cashbackAmount;
    }

    public void setCashbackAmount(String str) {
        this.cashbackAmount = str;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMethod(String str) {
        this.payMethod = str;
    }

    public String getPromoVisibility() {
        return this.promoVisibility;
    }

    public void setPromoVisibility(String str) {
        this.promoVisibility = str;
    }

    private boolean isPromoVisible() {
        return !TextUtils.isEmpty(this.promoVisibility) && "true".equalsIgnoreCase(this.promoVisibility.toLowerCase());
    }
}
