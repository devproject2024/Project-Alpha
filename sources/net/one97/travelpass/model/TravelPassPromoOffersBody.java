package net.one97.travelpass.model;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJROfferCode;

public class TravelPassPromoOffersBody extends IJRPaytmDataModel implements IJRDataModel {
    private ArrayList<CJROfferCode> promotions;

    public ArrayList<CJROfferCode> getPromotions() {
        return this.promotions;
    }

    public void setPromotions(ArrayList<CJROfferCode> arrayList) {
        this.promotions = arrayList;
    }
}
