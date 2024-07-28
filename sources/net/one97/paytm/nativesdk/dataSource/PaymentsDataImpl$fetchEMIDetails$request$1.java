package net.one97.paytm.nativesdk.dataSource;

import com.android.volley.Response;
import net.one97.paytm.nativesdk.instruments.debitCreditcard.model.EmiResponse;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

final class PaymentsDataImpl$fetchEMIDetails$request$1<T> implements Response.Listener<EmiResponse> {
    final /* synthetic */ PaymentMethodDataSource.Callback $callback;

    PaymentsDataImpl$fetchEMIDetails$request$1(PaymentMethodDataSource.Callback callback) {
        this.$callback = callback;
    }

    public final void onResponse(EmiResponse emiResponse) {
        this.$callback.onResponse(emiResponse);
    }
}
