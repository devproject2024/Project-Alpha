package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public final class CashbacktagOffersListDataModel extends CashBackBaseModal {
    @b(a = "superCashGameV3List")
    private final ArrayList<VIPCashBackOffer> myOffers;
    @b(a = "campaignData")
    private ArrayList<CashBackNewOfferModal> newOffers;

    public final ArrayList<CashBackNewOfferModal> getNewOffers() {
        return this.newOffers;
    }

    public final void setNewOffers(ArrayList<CashBackNewOfferModal> arrayList) {
        this.newOffers = arrayList;
    }

    public final ArrayList<VIPCashBackOffer> getMyOffers() {
        return this.myOffers;
    }
}
