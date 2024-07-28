package com.business.merchant_payments.settlement.view;

import androidx.lifecycle.z;
import com.business.merchant_payments.common.ErrorUtil;
import com.business.merchant_payments.settlement.model.BWSettlementM2BTransactionDetailObservableModel;
import kotlin.g.b.k;

public final class OrderListDateRangeActivityMP$mBillListDetailObserver$1<T> implements z<BWSettlementM2BTransactionDetailObservableModel> {
    public final /* synthetic */ OrderListDateRangeActivityMP this$0;

    public OrderListDateRangeActivityMP$mBillListDetailObserver$1(OrderListDateRangeActivityMP orderListDateRangeActivityMP) {
        this.this$0 = orderListDateRangeActivityMP;
    }

    public final void onChanged(BWSettlementM2BTransactionDetailObservableModel bWSettlementM2BTransactionDetailObservableModel) {
        if (!this.this$0.isFinishing() && !ErrorUtil.handleInvalidToken(bWSettlementM2BTransactionDetailObservableModel.getWrappedData().f7356a)) {
            OrderListDateRangeActivityMP orderListDateRangeActivityMP = this.this$0;
            k.b(bWSettlementM2BTransactionDetailObservableModel, "it");
            orderListDateRangeActivityMP.handleBillListDetailResponse(bWSettlementM2BTransactionDetailObservableModel);
        }
    }
}
