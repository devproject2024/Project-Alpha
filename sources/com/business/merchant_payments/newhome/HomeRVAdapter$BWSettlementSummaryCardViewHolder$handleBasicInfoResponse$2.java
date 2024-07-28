package com.business.merchant_payments.newhome;

import android.view.View;
import com.business.merchant_payments.newhome.HomeRVAdapter;
import com.business.merchant_payments.settlement.model.BWSettlementCardSummaryAdapterModel;

public final class HomeRVAdapter$BWSettlementSummaryCardViewHolder$handleBasicInfoResponse$2 implements View.OnClickListener {
    public final /* synthetic */ BWSettlementCardSummaryAdapterModel $modelData;
    public final /* synthetic */ HomeRVAdapter.BWSettlementSummaryCardViewHolder this$0;

    public HomeRVAdapter$BWSettlementSummaryCardViewHolder$handleBasicInfoResponse$2(HomeRVAdapter.BWSettlementSummaryCardViewHolder bWSettlementSummaryCardViewHolder, BWSettlementCardSummaryAdapterModel bWSettlementCardSummaryAdapterModel) {
        this.this$0 = bWSettlementSummaryCardViewHolder;
        this.$modelData = bWSettlementCardSummaryAdapterModel;
    }

    public final void onClick(View view) {
        HomeRVListener access$getMListener$p = this.this$0.this$0.mListener;
        String totalAmount = this.$modelData.getModelData().getTotalAmount();
        if (totalAmount == null) {
            totalAmount = "0";
        }
        access$getMListener$p.onSettleNowClick(totalAmount);
    }
}
