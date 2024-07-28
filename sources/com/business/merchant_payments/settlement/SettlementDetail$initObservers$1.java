package com.business.merchant_payments.settlement;

import android.view.View;

public final class SettlementDetail$initObservers$1 implements View.OnClickListener {
    public final /* synthetic */ SettlementDetail this$0;

    public SettlementDetail$initObservers$1(SettlementDetail settlementDetail) {
        this.this$0 = settlementDetail;
    }

    public final void onClick(View view) {
        SettlementDetail settlementDetail = this.this$0;
        settlementDetail.callSettlementDetailApi(SettlementDetail.access$getStartDate$p(settlementDetail));
    }
}
