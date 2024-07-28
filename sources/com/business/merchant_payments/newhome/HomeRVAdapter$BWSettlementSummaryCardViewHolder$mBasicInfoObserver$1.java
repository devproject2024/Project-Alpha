package com.business.merchant_payments.newhome;

import androidx.lifecycle.z;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.kyc.KycBankInfoModel;
import com.business.merchant_payments.newhome.HomeRVAdapter;

public final class HomeRVAdapter$BWSettlementSummaryCardViewHolder$mBasicInfoObserver$1<T> implements z<b<KycBankInfoModel>> {
    public final /* synthetic */ HomeRVAdapter.BWSettlementSummaryCardViewHolder this$0;

    public HomeRVAdapter$BWSettlementSummaryCardViewHolder$mBasicInfoObserver$1(HomeRVAdapter.BWSettlementSummaryCardViewHolder bWSettlementSummaryCardViewHolder) {
        this.this$0 = bWSettlementSummaryCardViewHolder;
    }

    public final void onChanged(b<KycBankInfoModel> bVar) {
        this.this$0.mBasicInfoResponse = bVar;
        int adapterPosition = this.this$0.getAdapterPosition();
        if (adapterPosition != -1) {
            HomeRVAdapter.BWSettlementSummaryCardViewHolder bWSettlementSummaryCardViewHolder = this.this$0;
            bWSettlementSummaryCardViewHolder.bindData(bWSettlementSummaryCardViewHolder.this$0.mList.get(adapterPosition), adapterPosition);
        }
    }
}
