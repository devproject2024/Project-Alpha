package net.one97.paytm.nativesdk.dataSource;

import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.instruments.netbanking.modal.NBResponse;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

public final class PaymentsDataImpl$getNBList$1 implements PaymentMethodDataSource.Callback<NBResponse> {
    final /* synthetic */ PaymentMethodDataSource.Callback $callback;

    PaymentsDataImpl$getNBList$1(PaymentMethodDataSource.Callback callback) {
        this.$callback = callback;
    }

    public final void onResponse(NBResponse nBResponse) {
        this.$callback.onResponse(nBResponse);
    }

    public final void onErrorResponse(VolleyError volleyError, NBResponse nBResponse) {
        this.$callback.onErrorResponse(volleyError, nBResponse);
    }
}
