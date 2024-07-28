package com.business.merchant_payments.settlement.view;

import android.view.View;

public final class OrderListDateRangeActivityMP$handleBillListError$1 implements View.OnClickListener {
    public final /* synthetic */ OrderListDateRangeActivityMP this$0;

    public OrderListDateRangeActivityMP$handleBillListError$1(OrderListDateRangeActivityMP orderListDateRangeActivityMP) {
        this.this$0 = orderListDateRangeActivityMP;
    }

    public final void onClick(View view) {
        this.this$0.loadSettlementRangeSummary();
        this.this$0.loadRecyclerViewSettlementData();
    }
}
