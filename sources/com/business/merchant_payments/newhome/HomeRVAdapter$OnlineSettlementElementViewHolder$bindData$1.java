package com.business.merchant_payments.newhome;

import android.view.View;
import com.business.merchant_payments.newhome.HomeRVAdapter;
import com.business.merchant_payments.settlement.model.SettlementBillListItemModel;

public final class HomeRVAdapter$OnlineSettlementElementViewHolder$bindData$1 implements View.OnClickListener {
    public final /* synthetic */ Object $object;
    public final /* synthetic */ int $position;
    public final /* synthetic */ HomeRVAdapter.OnlineSettlementElementViewHolder this$0;

    public HomeRVAdapter$OnlineSettlementElementViewHolder$bindData$1(HomeRVAdapter.OnlineSettlementElementViewHolder onlineSettlementElementViewHolder, Object obj, int i2) {
        this.this$0 = onlineSettlementElementViewHolder;
        this.$object = obj;
        this.$position = i2;
    }

    public final void onClick(View view) {
        this.this$0.sendGAEventOnClick((SettlementBillListItemModel) this.$object);
        this.this$0.this$0.mListener.onToggleCompressState(((SettlementBillListItemModel) this.$object).isExpanded(), this.$position);
    }
}
