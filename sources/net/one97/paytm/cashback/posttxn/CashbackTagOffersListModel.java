package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;

public class CashbackTagOffersListModel extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "superCashGameV4List")
    private ArrayList<VIPCashBackOfferV4> myOffers;
    @b(a = "campaignData")
    private ArrayList<Campaign> newOffers;

    public static long getSerialVersionUID() {
        return 1;
    }

    public ArrayList<Campaign> getNewOffers() {
        return this.newOffers;
    }

    public void setData(ArrayList<Campaign> arrayList) {
        this.newOffers = arrayList;
    }

    public ArrayList<VIPCashBackOfferV4> getMyOffers() {
        return this.myOffers;
    }
}
