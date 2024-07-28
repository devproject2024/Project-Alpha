package net.one97.paytm.nativesdk.dataSource;

import com.android.volley.Response;
import net.one97.paytm.nativesdk.dataSource.models.CreateTranscationResponse;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

final class PaymentsDataImpl$initiateTransaction$createTranspRequest$1<T> implements Response.Listener<CreateTranscationResponse> {
    final /* synthetic */ PaymentMethodDataSource.Callback $callback;

    PaymentsDataImpl$initiateTransaction$createTranspRequest$1(PaymentMethodDataSource.Callback callback) {
        this.$callback = callback;
    }

    public final void onResponse(CreateTranscationResponse createTranscationResponse) {
        this.$callback.onResponse(createTranscationResponse);
    }
}
