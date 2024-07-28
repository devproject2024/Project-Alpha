package net.one97.paytm.cashback.posttxn;

import com.google.gsonhtcfix.a.b;

public class CashbackBaseTagOfferListModel extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private CashbackTagOffersListModel data;

    public static long getSerialVersionUID() {
        return 1;
    }

    public CashbackTagOffersListModel getData() {
        return this.data;
    }

    public void setData(CashbackTagOffersListModel cashbackTagOffersListModel) {
        this.data = cashbackTagOffersListModel;
    }
}
