package net.one97.paytm.nativesdk.paymethods.datasource;

import com.android.volley.Response;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

final class PaymentRepository$postDataOnCallBack$request$1<T> implements Response.Listener<Object> {
    final /* synthetic */ PaymentMethodDataSource.Callback $callback;

    PaymentRepository$postDataOnCallBack$request$1(PaymentMethodDataSource.Callback callback) {
        this.$callback = callback;
    }

    public final void onResponse(Object obj) {
        this.$callback.onResponse(obj);
    }
}
