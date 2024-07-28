package com.business.merchant_payments.settlement;

import androidx.lifecycle.z;
import com.business.merchant_payments.common.BaseActivity;
import com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel;
import kotlin.g.b.k;

public final class SettlementDetail$BWSettlementM2BTransactionDetailObservableModel$1<T> implements z<BWSettlementM2BTransactionDetailObservableModel> {
    public final /* synthetic */ SettlementDetail this$0;

    public SettlementDetail$BWSettlementM2BTransactionDetailObservableModel$1(SettlementDetail settlementDetail) {
        this.this$0 = settlementDetail;
    }

    public final void onChanged(BWSettlementM2BTransactionDetailObservableModel bWSettlementM2BTransactionDetailObservableModel) {
        SettlementDetail settlementDetail = this.this$0;
        if (settlementDetail != null && !settlementDetail.isFinishing() && (settlementDetail instanceof BaseActivity)) {
            SettlementDetail settlementDetail2 = this.this$0;
            k.b(bWSettlementM2BTransactionDetailObservableModel, "it");
            settlementDetail2.handleM2bTransactionDetail(bWSettlementM2BTransactionDetailObservableModel);
        }
    }
}
