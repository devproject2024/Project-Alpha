package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class CJRFlightPriceDiscounts extends IJRPaytmDataModel {
    @b(a = "effective_price")
    private String effective_price;
    @b(a = "original_price")
    private String original_price;
    @b(a = "promo_details")
    private CJRFlightPriceDiscountsPromoDetails promo_details;

    public final CJRFlightPriceDiscountsPromoDetails getPromo_details() {
        return this.promo_details;
    }

    public final void setPromo_details(CJRFlightPriceDiscountsPromoDetails cJRFlightPriceDiscountsPromoDetails) {
        this.promo_details = cJRFlightPriceDiscountsPromoDetails;
    }

    public final String getEffective_price() {
        return this.effective_price;
    }

    public final void setEffective_price(String str) {
        this.effective_price = str;
    }

    public CJRFlightPriceDiscounts(CJRFlightPriceDiscountsPromoDetails cJRFlightPriceDiscountsPromoDetails, String str, String str2) {
        this.promo_details = cJRFlightPriceDiscountsPromoDetails;
        this.effective_price = str;
        this.original_price = str2;
    }

    public final String getOriginal_price() {
        return this.original_price;
    }

    public final void setOriginal_price(String str) {
        this.original_price = str;
    }
}
