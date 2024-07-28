package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class GameGratification extends IJRPaytmDataModel {
    @b(a = "background_image_url")
    private String background_image_url;
    @b(a = "background_overlay")
    private String background_overlay;
    @b(a = "offer_image_url")
    private String offer_image_url;
    @b(a = "unlock_text")
    private String unlock_text;

    public String getBackground_image_url() {
        return this.background_image_url;
    }

    public void setBackground_image_url(String str) {
        this.background_image_url = str;
    }

    public String getOffer_image_url() {
        return this.offer_image_url;
    }

    public void setOffer_image_url(String str) {
        this.offer_image_url = str;
    }

    public String getBackground_overlay() {
        return this.background_overlay;
    }

    public void setBackground_overlay(String str) {
        this.background_overlay = str;
    }

    public String getUnlock_text() {
        return this.unlock_text;
    }

    public void setUnlock_text(String str) {
        this.unlock_text = str;
    }
}
