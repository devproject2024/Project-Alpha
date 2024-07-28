package com.business.merchant_payments.payment.view;

import android.view.View;
import com.business.merchant_payments.R;
import kotlin.g.b.k;

public final class PaymentListActivity$initUI$2 implements View.OnClickListener {
    public final /* synthetic */ PaymentListActivity this$0;

    public PaymentListActivity$initUI$2(PaymentListActivity paymentListActivity) {
        this.this$0 = paymentListActivity;
    }

    public final void onClick(View view) {
        if (!k.a((Object) this.this$0.mRange, (Object) this.this$0.getString(R.string.mp_custom_date))) {
            PaymentListActivity paymentListActivity = this.this$0;
            paymentListActivity.setMStartDate(paymentListActivity.mSavedStartDate);
            PaymentListActivity paymentListActivity2 = this.this$0;
            paymentListActivity2.setMEndDate(paymentListActivity2.mSavedEndDate);
        }
        PaymentListActivity paymentListActivity3 = this.this$0;
        paymentListActivity3.setReportStartDate(paymentListActivity3.getMStartDate());
        PaymentListActivity paymentListActivity4 = this.this$0;
        paymentListActivity4.setReportEndDate(paymentListActivity4.getMEndDate());
        PaymentListActivity paymentListActivity5 = this.this$0;
        String string = paymentListActivity5.getString(R.string.mp_download_payments_received_for);
        k.b(string, "getString(R.string.mp_do…ad_payments_received_for)");
        paymentListActivity5.openSelectDateBottomSheet(true, string, this.this$0.getMStartDate(), this.this$0.getMEndDate());
    }
}
