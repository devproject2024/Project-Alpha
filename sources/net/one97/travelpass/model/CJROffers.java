package net.one97.travelpass.model;

import com.google.gsonhtcfix.a.b;
import com.paytm.network.model.IJRPaytmDataModel;
import java.util.List;
import net.one97.paytm.common.entity.shopping.CJROfferCode;

public class CJROffers extends IJRPaytmDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "codes")
    private List<CJROfferCode> mOfferCodes;

    public List<CJROfferCode> getPromotions() {
        return this.mOfferCodes;
    }

    public void setmOfferCodes(List<CJROfferCode> list) {
        this.mOfferCodes = list;
    }
}
