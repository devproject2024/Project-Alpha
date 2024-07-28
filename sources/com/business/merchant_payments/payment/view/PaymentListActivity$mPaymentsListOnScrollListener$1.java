package com.business.merchant_payments.payment.view;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.g.b.k;

public final class PaymentListActivity$mPaymentsListOnScrollListener$1 extends RecyclerView.l {
    public final /* synthetic */ PaymentListActivity this$0;

    public PaymentListActivity$mPaymentsListOnScrollListener$1(PaymentListActivity paymentListActivity) {
        this.this$0 = paymentListActivity;
    }

    public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
        k.d(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i2, i3);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        if (linearLayoutManager != null && linearLayoutManager.findLastCompletelyVisibleItemPosition() >= PaymentListActivity.access$getMSummaryList$p(this.this$0).size() - 1 && !this.this$0.mFetchingSummaries && this.this$0.getMSummaryListDataHelper().hasMoreRecords()) {
            this.this$0.mFetchingSummaries = true;
            PaymentListActivity.access$getMViewModel$p(this.this$0).fetchPayments(this.this$0.getMSummaryListDataHelper().getPageForAPI());
        }
    }
}
