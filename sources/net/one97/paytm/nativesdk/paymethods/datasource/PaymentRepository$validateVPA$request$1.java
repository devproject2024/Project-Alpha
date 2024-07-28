package net.one97.paytm.nativesdk.paymethods.datasource;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.instruments.upicollect.models.VerifyVpaResponse;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

final class PaymentRepository$validateVPA$request$1<T> implements Response.Listener<VerifyVpaResponse> {
    final /* synthetic */ PaymentMethodDataSource.Callback $callback;

    PaymentRepository$validateVPA$request$1(PaymentMethodDataSource.Callback callback) {
        this.$callback = callback;
    }

    public final void onResponse(VerifyVpaResponse verifyVpaResponse) {
        if ((verifyVpaResponse != null ? verifyVpaResponse.getBody() : null) == null) {
            this.$callback.onErrorResponse((VolleyError) null, verifyVpaResponse);
        } else {
            this.$callback.onResponse(verifyVpaResponse);
        }
    }
}
