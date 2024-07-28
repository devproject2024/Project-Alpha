package net.one97.paytm.hotel4.service.model.promocode;

public final class PromoCodeApplyData {
    private Integer paytm_cashback;
    private String promocode;
    private String promotext;

    public final String getPromotext() {
        return this.promotext;
    }

    public final void setPromotext(String str) {
        this.promotext = str;
    }

    public final String getPromocode() {
        return this.promocode;
    }

    public final void setPromocode(String str) {
        this.promocode = str;
    }

    public final Integer getPaytm_cashback() {
        return this.paytm_cashback;
    }

    public final void setPaytm_cashback(Integer num) {
        this.paytm_cashback = num;
    }
}
