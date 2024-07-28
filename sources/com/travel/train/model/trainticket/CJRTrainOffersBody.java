package com.travel.train.model.trainticket;

import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRTrainOffersBody extends IJRPaytmDataModel implements IJRDataModel {
    private ArrayList<CJRTrainOfferCode> promotions;

    public ArrayList<CJRTrainOfferCode> getPromotions() {
        return this.promotions;
    }
}
