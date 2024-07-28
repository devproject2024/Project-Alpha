package com.travel.flight.pojo.flightticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class CJROffers extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "codes")
    private List<CJRFlightOfferCode> mOfferCodes;
    private String stringResponse;

    public List<CJRFlightOfferCode> getmOfferCodes() {
        return this.mOfferCodes;
    }

    public void setmOfferCodes(List<CJRFlightOfferCode> list) {
        this.mOfferCodes = list;
    }
}
