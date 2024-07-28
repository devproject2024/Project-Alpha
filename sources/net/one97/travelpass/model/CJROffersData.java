package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;

public class CJROffersData extends IJRPaytmDataModel {
    @b(a = "body")
    private CJROffers mOffers;
    @b(a = "status")
    private String status;

    public String getStatus() {
        return this.status;
    }

    public CJROffers getmOffers() {
        return this.mOffers;
    }
}
