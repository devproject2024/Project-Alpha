package com.travel.bus.pojo.busticket;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.shopping.CJROfferCode;

public class CJRBusOffers extends IJRPaytmDataModel {
    @b(a = "codes")
    private ArrayList<CJROfferCode> mOfferCodes;

    public void setOfferCodes(ArrayList<CJROfferCode> arrayList) {
        this.mOfferCodes = arrayList;
    }

    public ArrayList<CJROfferCode> getOfferCodes() {
        return this.mOfferCodes;
    }
}
