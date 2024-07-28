package net.one97.paytm.common.entity.amPark;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRAmParkCustomInfo implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "offer_color")
    private String mOfferColor;
    @b(a = "offer_text")
    private String mOfferText;

    public String getOfferText() {
        return this.mOfferText;
    }

    public void setOfferText(String str) {
        this.mOfferText = str;
    }

    public String getOfferColor() {
        return this.mOfferColor;
    }

    public void setOfferColor(String str) {
        this.mOfferColor = str;
    }
}
