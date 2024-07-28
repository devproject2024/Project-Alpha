package com.business.merchant_payments.settlement.view;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public final class OrderListDateRangeActivityMP$showDataInRecyclerView$1 implements SwipeRefreshLayout.b {
    public final /* synthetic */ OrderListDateRangeActivityMP this$0;

    public OrderListDateRangeActivityMP$showDataInRecyclerView$1(OrderListDateRangeActivityMP orderListDateRangeActivityMP) {
        this.this$0 = orderListDateRangeActivityMP;
    }

    public final void onRefresh() {
        this.this$0.loadSettlementRangeSummary();
        this.this$0.loadRecyclerViewSettlementData();
    }
}
