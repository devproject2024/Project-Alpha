package com.paytmmall.artifact.cart.entity;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;

public class CJROffers extends IJRPaytmDataModel {
    @b(a = "codes")
    private ArrayList<CJROfferCode> mOfferCodes;

    public void setOfferCodes(ArrayList<CJROfferCode> arrayList) {
        this.mOfferCodes = arrayList;
    }

    public ArrayList<CJROfferCode> getOfferCodes() {
        return this.mOfferCodes;
    }
}
