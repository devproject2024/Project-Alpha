package net.one97.paytm.nativesdk.orflow.promo.model;

import net.one97.paytm.nativesdk.common.model.CJPayMethodResponse;

public final class ValidatePromoResponse {
    private boolean isBankOffer;
    private CJPayMethodResponse payment_instruments;
    private String paytm_promocode;
    private String promofailuretext;
    private String promostatus;
    private String responseString;

    public final String getPaytm_promocode() {
        return this.paytm_promocode;
    }

    public final void setPaytm_promocode(String str) {
        this.paytm_promocode = str;
    }

    public final String getPromostatus() {
        return this.promostatus;
    }

    public final void setPromostatus(String str) {
        this.promostatus = str;
    }

    public final String getPromofailuretext() {
        return this.promofailuretext;
    }

    public final void setPromofailuretext(String str) {
        this.promofailuretext = str;
    }

    public final CJPayMethodResponse getPayment_instruments() {
        return this.payment_instruments;
    }

    public final void setPayment_instruments(CJPayMethodResponse cJPayMethodResponse) {
        this.payment_instruments = cJPayMethodResponse;
    }

    public final boolean isBankOffer() {
        return this.isBankOffer;
    }

    public final void setBankOffer(boolean z) {
        this.isBankOffer = z;
    }

    public final String getResponseString() {
        return this.responseString;
    }

    public final void setResponseString(String str) {
        this.responseString = str;
    }
}
