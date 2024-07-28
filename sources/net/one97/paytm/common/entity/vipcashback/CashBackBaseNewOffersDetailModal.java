package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class CashBackBaseNewOffersDetailModal extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private CashBackNewOffersDetailModal data;

    public static long getSerialVersionUID() {
        return 1;
    }

    public CashBackNewOffersDetailModal getData() {
        return this.data;
    }
}
