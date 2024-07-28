package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class CashBackBaseNewOfferDetailV4 extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private CashBackNewOffersDetailModelV4 data;

    public static long getSerialVersionUID() {
        return 1;
    }

    public CashBackNewOffersDetailModelV4 getData() {
        return this.data;
    }
}
