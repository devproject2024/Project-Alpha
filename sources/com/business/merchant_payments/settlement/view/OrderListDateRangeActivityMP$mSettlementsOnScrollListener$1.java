package com.business.merchant_payments.settlement.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class OrderListDateRangeActivityMP$mSettlementsOnScrollListener$1 extends RecyclerView.l {
    public final /* synthetic */ OrderListDateRangeActivityMP this$0;

    public OrderListDateRangeActivityMP$mSettlementsOnScrollListener$1(OrderListDateRangeActivityMP orderListDateRangeActivityMP) {
        this.this$0 = orderListDateRangeActivityMP;
    }

    public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        k.d(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i2, i3);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        k.a((Object) linearLayoutManager);
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int childCount = linearLayoutManager.getChildCount();
        int itemCount = linearLayoutManager.getItemCount();
        if (!this.this$0.mIsListLoading && this.this$0.mIsPaginating && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition > 0) {
            this.this$0.loadMoreSettlementItems();
        }
    }
}
