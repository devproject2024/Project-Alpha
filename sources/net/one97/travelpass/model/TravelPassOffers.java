package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.f;
import com.paytm.network.model.IJRPaytmDataModel;

public class TravelPassOffers extends IJRPaytmDataModel {
    @b(a = "code")
    private int code;
    @b(a = "message")
    private String name;
    @b(a = "body")
    private TravelPassOfferData offersData;

    public String getName() {
        return this.name;
    }

    public int getCode() {
        return this.code;
    }

    public TravelPassOfferData getOffersData() {
        return this.offersData;
    }

    public IJRPaytmDataModel parseResponse(String str, f fVar) throws Exception {
        return super.parseResponse(str, fVar);
    }
}
