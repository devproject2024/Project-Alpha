package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import java.util.ArrayList;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class CashBackNewOffersListModal extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private CashBackNewOffersListModal data;
    @b(a = "is_next")
    private boolean isNext;
    @b(a = "campaigns")
    private ArrayList<CashBackNewOfferModal> offersList;
    @b(a = "page_offset")
    private int pageOffset;

    public ArrayList<CashBackNewOfferModal> getOffersList() {
        return this.offersList;
    }

    public boolean isNext() {
        return this.isNext;
    }

    public CashBackNewOffersListModal getData() {
        return this.data;
    }

    public int getPageOffset() {
        return this.pageOffset;
    }
}
