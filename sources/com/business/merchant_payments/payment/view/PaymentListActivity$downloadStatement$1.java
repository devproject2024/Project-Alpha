package com.business.merchant_payments.payment.view;

import android.view.View;
import com.google.android.material.snackbar.Snackbar;

public final class PaymentListActivity$downloadStatement$1 implements View.OnClickListener {
    public final /* synthetic */ PaymentListActivity this$0;

    public PaymentListActivity$downloadStatement$1(PaymentListActivity paymentListActivity) {
        this.this$0 = paymentListActivity;
    }

    public final void onClick(View view) {
        Snackbar mSnackBar = this.this$0.getMSnackBar();
        if (mSnackBar != null) {
            mSnackBar.d();
        }
        this.this$0.downloadStatement();
    }
}
