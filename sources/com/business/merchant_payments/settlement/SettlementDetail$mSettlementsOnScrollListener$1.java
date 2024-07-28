package com.business.merchant_payments.settlement;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class SettlementDetail$mSettlementsOnScrollListener$1 extends RecyclerView.l {
    public final /* synthetic */ SettlementDetail this$0;

    public SettlementDetail$mSettlementsOnScrollListener$1(SettlementDetail settlementDetail) {
        this.this$0 = settlementDetail;
    }

    public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        k.d(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i2, i3);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        k.a((Object) linearLayoutManager);
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        int childCount = linearLayoutManager.getChildCount();
        int itemCount = linearLayoutManager.getItemCount();
        if (!this.this$0.mSettlementListLoading && this.this$0.mIsPaginatingBillList && childCount + findFirstVisibleItemPosition >= itemCount && findFirstVisibleItemPosition > 0) {
            this.this$0.loadMoreSettlementItems();
        }
    }
}
