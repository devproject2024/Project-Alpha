package net.one97.paytm.nativesdk.paymethods.datasource;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;

final class PaymentRepository$validateWalletOtpRequest$$inlined$let$lambda$2 implements Response.ErrorListener {
    final /* synthetic */ PaymentMethodDataSource.Callback $callback$inlined;
    final /* synthetic */ String $otp$inlined;
    final /* synthetic */ PaymentRepository this$0;

    PaymentRepository$validateWalletOtpRequest$$inlined$let$lambda$2(PaymentRepository paymentRepository, String str, PaymentMethodDataSource.Callback callback) {
        this.this$0 = paymentRepository;
        this.$otp$inlined = str;
        this.$callback$inlined = callback;
    }

    public final void onErrorResponse(VolleyError volleyError) {
        this.$callback$inlined.onErrorResponse(volleyError, null);
    }
}
