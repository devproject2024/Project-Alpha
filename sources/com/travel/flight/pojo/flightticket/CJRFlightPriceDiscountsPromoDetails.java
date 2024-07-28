package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public final class CJRFlightPriceDiscountsPromoDetails extends IJRPaytmDataModel {
    @b(a = "supporting_text")
    private String supporting_text;

    public CJRFlightPriceDiscountsPromoDetails(String str) {
        this.supporting_text = str;
    }

    public final String getSupporting_text() {
        return this.supporting_text;
    }

    public final void setSupporting_text(String str) {
        this.supporting_text = str;
    }
}
