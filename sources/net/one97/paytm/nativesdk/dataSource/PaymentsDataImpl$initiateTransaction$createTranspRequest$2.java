package net.one97.paytm.nativesdk.dataSource;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

final class PaymentsDataImpl$initiateTransaction$createTranspRequest$2 implements Response.ErrorListener {
    final /* synthetic */ PaymentMethodDataSource.Callback $callback;

    PaymentsDataImpl$initiateTransaction$createTranspRequest$2(PaymentMethodDataSource.Callback callback) {
        this.$callback = callback;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.$callback.onErrorResponse(volleyError, null);
    }
}
