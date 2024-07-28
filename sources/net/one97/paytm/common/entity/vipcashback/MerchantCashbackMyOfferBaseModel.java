package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class MerchantCashbackMyOfferBaseModel extends CashBackBaseModal {
    private static final long serialVersionUID = 1;
    @b(a = "data")
    private MerchantGameItem data;

    public static long getSerialVersionUID() {
        return 1;
    }

    public MerchantGameItem getData() {
        return this.data;
    }

    public void setData(MerchantGameItem merchantGameItem) {
        this.data = merchantGameItem;
    }
}
