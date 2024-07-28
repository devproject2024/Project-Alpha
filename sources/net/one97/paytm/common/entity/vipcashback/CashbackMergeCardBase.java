package net.one97.paytm.common.entity.vipcashback;

import com.google.gsonhtcfix.a.b;
import net.one97.paytm.cashback.posttxn.CashBackBaseModal;
import net.one97.paytm.v2.features.cashbacklanding.model.CashbackCardInfo;

public final class CashbackMergeCardBase extends CashBackBaseModal {
    @b(a = "data")
    private CashbackCardInfo data;

    public final CashbackCardInfo getData() {
        return this.data;
    }

    public final void setData(CashbackCardInfo cashbackCardInfo) {
        this.data = cashbackCardInfo;
    }
}
