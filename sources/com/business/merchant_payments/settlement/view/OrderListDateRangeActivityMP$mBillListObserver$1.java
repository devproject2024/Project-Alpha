package com.business.merchant_payments.settlement.view;

import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.settlement.model.SettlementBillListModel;
import kotlin.g.b.k;

public final class OrderListDateRangeActivityMP$mBillListObserver$1<T> implements z<b<SettlementBillListModel>> {
    public final /* synthetic */ OrderListDateRangeActivityMP this$0;

    public OrderListDateRangeActivityMP$mBillListObserver$1(OrderListDateRangeActivityMP orderListDateRangeActivityMP) {
        this.this$0 = orderListDateRangeActivityMP;
    }

    public final void onChanged(b<SettlementBillListModel> bVar) {
        if (!this.this$0.isFinishing()) {
            OrderListDateRangeActivityMP orderListDateRangeActivityMP = this.this$0;
            k.b(bVar, "it");
            orderListDateRangeActivityMP.handleBillListResponse(bVar);
        }
    }
}
