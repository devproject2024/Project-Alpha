package com.business.merchant_payments.payment.view;

import androidx.lifecycle.z;
import com.appsflyer.internal.referrer.Payload;
import com.business.common_module.utilities.a.b;
import com.business.merchant_payments.model.orderList.V2OrderListModel;
import kotlin.g.b.k;

public final class PaymentListActivity$initUI$5<T> implements z<b<V2OrderListModel>> {
    public final /* synthetic */ PaymentListActivity this$0;

    public PaymentListActivity$initUI$5(PaymentListActivity paymentListActivity) {
        this.this$0 = paymentListActivity;
    }

    public final void onChanged(b<V2OrderListModel> bVar) {
        k.d(bVar, Payload.RESPONSE);
        this.this$0.handleV2OrderListResponse(bVar);
    }
}
