package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.ArrayList;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJROffers extends IJRPaytmDataModel implements IJRDataModel {
    @b(a = "codes")
    private ArrayList<CJROfferCode> mOfferCodes;

    public void setOfferCodes(ArrayList<CJROfferCode> arrayList) {
        this.mOfferCodes = arrayList;
    }

    public ArrayList<CJROfferCode> getOfferCodes() {
        return this.mOfferCodes;
    }
}
