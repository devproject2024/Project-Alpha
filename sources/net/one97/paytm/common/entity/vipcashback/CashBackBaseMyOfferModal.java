package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class CashBackBaseMyOfferModal extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private VIPCashBackOffer data;

    public static long getSerialVersionUID() {
        return 1;
    }

    public VIPCashBackOffer getData() {
        return this.data;
    }

    public void setData(VIPCashBackOffer vIPCashBackOffer) {
        this.data = vIPCashBackOffer;
    }
}
