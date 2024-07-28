package com.business.merchant_payments.newhome;

import android.view.View;
import com.business.merchant_payments.newhome.HomeRVAdapter;
import com.business.merchant_payments.settlement.model.BWSettlementCardSummaryAdapterModel;

public final class HomeRVAdapter$BWSettlementSummaryCardViewHolder$bindData$2 implements View.OnClickListener {
    public final /* synthetic */ Object $object;
    public final /* synthetic */ HomeRVAdapter.BWSettlementSummaryCardViewHolder this$0;

    public HomeRVAdapter$BWSettlementSummaryCardViewHolder$bindData$2(HomeRVAdapter.BWSettlementSummaryCardViewHolder bWSettlementSummaryCardViewHolder, Object obj) {
        this.this$0 = bWSettlementSummaryCardViewHolder;
        this.$object = obj;
    }

    public final void onClick(View view) {
        this.this$0.this$0.mListener.onExpandBWPendingSummaryCard(((BWSettlementCardSummaryAdapterModel) this.$object).isPendingSettledListExpanded());
    }
}
