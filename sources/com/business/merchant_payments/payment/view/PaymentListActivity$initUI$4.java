package com.business.merchant_payments.payment.view;

import androidx.lifecycle.z;
import com.appsflyer.internal.referrer.Payload;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.nonMigratedPayments.NonMigratedPaymentsModel;
import kotlin.g.b.k;

public final class PaymentListActivity$initUI$4<T> implements z<b<NonMigratedPaymentsModel>> {
    public final /* synthetic */ PaymentListActivity this$0;

    public PaymentListActivity$initUI$4(PaymentListActivity paymentListActivity) {
        this.this$0 = paymentListActivity;
    }

    public final void onChanged(b<NonMigratedPaymentsModel> bVar) {
        k.d(bVar, Payload.RESPONSE);
        this.this$0.handleNonMigratedPaymentsResponse(bVar);
    }
}
