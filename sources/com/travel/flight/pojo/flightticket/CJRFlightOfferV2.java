package com.travel.flight.pojo.flightticket;

import com.paytm.network.model.IJRPaytmDataModel;

public class CJRFlightOfferV2 extends IJRPaytmDataModel {
    private CJRFlightOffer flightOffer;
    private String stringResponse;

    public CJRFlightOffer getFlightOffer() {
        return this.flightOffer;
    }

    public void setFlightOffer(CJRFlightOffer cJRFlightOffer) {
        this.flightOffer = cJRFlightOffer;
    }

    public String getStringResponse() {
        return this.stringResponse;
    }

    public void setStringResponse(String str) {
        this.stringResponse = str;
    }
}
