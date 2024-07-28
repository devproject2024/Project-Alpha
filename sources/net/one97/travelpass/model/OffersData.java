package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;

public class OffersData extends IJRPaytmDataModel {
    @b(a = "internal")
    private List<InternalOfferData> internalOffersData;
    @b(a = "partner")
    private List<PartnersOfferData> partnersOfferData;

    public List<PartnersOfferData> getPartnersOfferData() {
        return this.partnersOfferData;
    }

    public List<InternalOfferData> getInternalOffersData() {
        return this.internalOffersData;
    }
}
