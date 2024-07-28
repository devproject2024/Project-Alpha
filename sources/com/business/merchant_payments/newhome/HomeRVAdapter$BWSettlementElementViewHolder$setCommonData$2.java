package com.business.merchant_payments.newhome;

import android.view.View;
import com.business.merchant_payments.newhome.HomeRVAdapter;
import com.business.merchant_payments.settlement.model.SettlementBillListItemModel;

public final class HomeRVAdapter$BWSettlementElementViewHolder$setCommonData$2 implements View.OnClickListener {
    public final /* synthetic */ SettlementBillListItemModel $modelData;
    public final /* synthetic */ int $position;
    public final /* synthetic */ HomeRVAdapter.BWSettlementElementViewHolder this$0;

    public HomeRVAdapter$BWSettlementElementViewHolder$setCommonData$2(HomeRVAdapter.BWSettlementElementViewHolder bWSettlementElementViewHolder, SettlementBillListItemModel settlementBillListItemModel, int i2) {
        this.this$0 = bWSettlementElementViewHolder;
        this.$modelData = settlementBillListItemModel;
        this.$position = i2;
    }

    public final void onClick(View view) {
        this.this$0.sendGAEventOnClick(this.$modelData);
        this.this$0.this$0.mListener.onBWSettlementItemClick(this.$modelData.isExpanded(), this.$position, this.$modelData);
    }
}
