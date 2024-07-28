package com.business.merchant_payments.settlement.view;

import androidx.lifecycle.z;
import com.business.merchant_payments.settlement.model.SettlementRangeSummaryModel;
import kotlin.g.b.k;

public final class OrderListDateRangeActivityMP$mSettlementRangeSummaryObserver$1<T> implements z<SettlementRangeSummaryModel> {
    public final /* synthetic */ OrderListDateRangeActivityMP this$0;

    public OrderListDateRangeActivityMP$mSettlementRangeSummaryObserver$1(OrderListDateRangeActivityMP orderListDateRangeActivityMP) {
        this.this$0 = orderListDateRangeActivityMP;
    }

    public final void onChanged(SettlementRangeSummaryModel settlementRangeSummaryModel) {
        if (!this.this$0.isFinishing()) {
            OrderListDateRangeActivityMP orderListDateRangeActivityMP = this.this$0;
            k.b(settlementRangeSummaryModel, "it");
            orderListDateRangeActivityMP.handleSettlementRangeSummaryResponse(settlementRangeSummaryModel);
        }
    }
}
