package net.one97.paytm.common.entity.shopping;

import com.google.gsonhtcfix.a.b;
import java.util.List;
import net.one97.paytm.common.entity.IJRDataModel;

public class CJRBankOffers implements IJRDataModel {
    public String icon;
    @b(a = "offer")
    public List<CJRPaytmOffers> nestedBankOffers;
    @b(a = "offer_text")
    public String offerText;

    public List<CJRPaytmOffers> getNestedBankOffers() {
        return this.nestedBankOffers;
    }

    public String getIcon() {
        return this.icon;
    }

    public String getOfferText() {
        return this.offerText;
    }
}
