package net.one97.paytm.nativesdk.paymethods.datasource;

import com.android.volley.Response;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.transactionsummary.model.TxnSummaryResponse;

final class PaymentRepository$checkSubsPaymentStatus$request$1<T> implements Response.Listener<TxnSummaryResponse> {
    final /* synthetic */ PaymentMethodDataSource.Callback $callback;

    PaymentRepository$checkSubsPaymentStatus$request$1(PaymentMethodDataSource.Callback callback) {
        this.$callback = callback;
    }

    public final void onResponse(TxnSummaryResponse txnSummaryResponse) {
        this.$callback.onResponse(txnSummaryResponse);
    }
}
