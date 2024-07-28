package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class CashBackMyOffersListModal extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private CashBackMyOffersListModal data;
    @b(a = "has_expired_offers")
    private boolean hasExpiredOffers;
    @b(a = "is_next")
    private boolean isNext;
    @b(a = "supercash_list")
    private ArrayList<VIPCashBackOffer> offersList;

    public ArrayList<VIPCashBackOffer> getOffersList() {
        return this.offersList;
    }

    public boolean isNext() {
        return this.isNext;
    }

    public CashBackMyOffersListModal getData() {
        return this.data;
    }

    public boolean hasExpiredOffers() {
        return this.hasExpiredOffers;
    }
}
