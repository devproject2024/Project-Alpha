package com.business.merchant_payments.requestmoney;

import android.content.Context;
import com.business.merchant_payments.model.v2.OrderDetailV2Model;
import com.business.merchant_payments.payment.viewmodel.OnlineTxnDetailsViewModel;
import com.business.merchant_payments.payment.viewmodel.RefundDetailsViewModel;
import kotlin.g.b.k;

public final class EdcPrintReciept {
    public static final EdcPrintReciept INSTANCE = new EdcPrintReciept();

    public final void printPaymentReciept(Context context, OnlineTxnDetailsViewModel onlineTxnDetailsViewModel) {
        k.d(context, "context");
        k.d(onlineTxnDetailsViewModel, "viewModel");
    }

    public final void printRefundReceipt(Context context, RefundDetailsViewModel refundDetailsViewModel, OrderDetailV2Model orderDetailV2Model) {
        k.d(context, "context");
        k.d(refundDetailsViewModel, "refundDetailsViewModel");
    }
}
