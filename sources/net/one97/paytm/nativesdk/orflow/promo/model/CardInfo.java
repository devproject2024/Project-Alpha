package net.one97.paytm.nativesdk.orflow.promo.model;

import net.one97.paytm.nativesdk.common.model.SavedInstruments;

public class CardInfo extends SavedInstruments {
    private boolean isSavedCard;
    private String promoCode;
    private String title;

    public boolean isSavedCard() {
        return this.isSavedCard;
    }

    public void setSavedCard(boolean z) {
        this.isSavedCard = z;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getPromoCode() {
        return this.promoCode;
    }

    public void setPromoCode(String str) {
        this.promoCode = str;
    }
}
