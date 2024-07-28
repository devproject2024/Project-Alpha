package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;
import net.one97.paytm.cashback.posttxn.VIPCashBackOfferV4;

public class CashBackGameDetailV4 extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private VIPCashBackOfferV4 data;

    public static long getSerialVersionUID() {
        return 1;
    }

    public VIPCashBackOfferV4 getData() {
        return this.data;
    }
}
