package net.one97.paytm.nativesdk.emiSubvention.models;

import com.google.gson.a.a;
import com.google.gson.a.c;

public class CartItem extends BaseModel {
    @c(a = "emi_offers")
    @a
    private EmiOffers emiOffers;

    public EmiOffers getEmiOffers() {
        return this.emiOffers;
    }

    public void setEmiOffers(EmiOffers emiOffers2) {
        this.emiOffers = emiOffers2;
    }
}
