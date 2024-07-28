package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class GetVIPCashBackOffersListModal extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private CashBackMyOffersListModal data;

    public static long getSerialVersionUID() {
        return 1;
    }

    public CashBackMyOffersListModal getData() {
        return this.data;
    }
}
