package net.one97.travelpass.model;

import com.paytm.network.model.IJRPaytmDataModel;

public class TravelPassWithOffersData extends IJRPaytmDataModel {
    private TravelPass travelPass;
    private TravelPassOffers travelPassOffers;

    public TravelPass getTravelPass() {
        return this.travelPass;
    }

    public void setTravelPass(TravelPass travelPass2) {
        this.travelPass = travelPass2;
    }

    public TravelPassOffers getTravelPassOffers() {
        return this.travelPassOffers;
    }

    public void setTravelPassOffers(TravelPassOffers travelPassOffers2) {
        this.travelPassOffers = travelPassOffers2;
    }
}
