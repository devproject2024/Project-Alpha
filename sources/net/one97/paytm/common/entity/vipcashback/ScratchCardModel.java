package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;

public class ScratchCardModel extends CashBackBaseModal {
    @b(a = "data")
    private ScratchCard data;

    public ScratchCard getData() {
        return this.data;
    }
}
