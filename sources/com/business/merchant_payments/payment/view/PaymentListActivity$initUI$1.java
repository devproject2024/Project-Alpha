package com.business.merchant_payments.payment.view;

import android.view.View;

public final class PaymentListActivity$initUI$1 implements View.OnClickListener {
    public final /* synthetic */ PaymentListActivity this$0;

    public PaymentListActivity$initUI$1(PaymentListActivity paymentListActivity) {
        this.this$0 = paymentListActivity;
    }

    public final void onClick(View view) {
        PaymentListActivity.access$getMViewModel$p(this.this$0).fetchPayments(this.this$0.getMSummaryListDataHelper().getPageForAPI());
        PaymentListActivity.access$getMViewModel$p(this.this$0).setErrorState(false);
        PaymentListActivity.access$getMViewModel$p(this.this$0).setLoadingState(true);
    }
}
