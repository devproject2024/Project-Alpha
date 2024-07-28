package net.one97.paytm.common.entity.flightticket;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJROfferCode;

public class CJROffers implements IJRDataModel {
    private static final long serialVersionUID = 1;
    @b(a = "codes")
    private List<CJROfferCode> mOfferCodes;
    @b(a = "offers")
    private List<CJROffersDetails> mOfferDetails;

    public List<CJROffersDetails> getmOfferDetails() {
        return this.mOfferDetails;
    }

    public void setmOfferDetails(List<CJROffersDetails> list) {
        this.mOfferDetails = list;
    }

    public List<CJROfferCode> getmOfferCodes() {
        return this.mOfferCodes;
    }

    public void setmOfferCodes(List<CJROfferCode> list) {
        this.mOfferCodes = list;
    }
}
