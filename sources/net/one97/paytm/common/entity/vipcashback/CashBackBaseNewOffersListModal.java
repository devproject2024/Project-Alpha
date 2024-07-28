package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class CashBackBaseNewOffersListModal extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private CashBackNewOffersListModal data;

    public static long getSerialVersionUID() {
        return 1;
    }

    public CashBackNewOffersListModal getData() {
        return this.data;
    }

    public void setData(CashBackNewOffersListModal cashBackNewOffersListModal) {
        this.data = cashBackNewOffersListModal;
    }
}
