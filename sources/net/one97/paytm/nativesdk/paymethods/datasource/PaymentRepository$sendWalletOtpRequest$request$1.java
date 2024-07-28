package net.one97.paytm.nativesdk.paymethods.datasource;

import com.android.volley.Response;
import net.one97.paytm.nativesdk.paymethods.datasource.PaymentMethodDataSource;
import net.one97.paytm.nativesdk.walletOtp.WalletOtpResponse;

final class PaymentRepository$sendWalletOtpRequest$request$1<T> implements Response.Listener<WalletOtpResponse> {
    final /* synthetic */ PaymentMethodDataSource.Callback $callback;

    PaymentRepository$sendWalletOtpRequest$request$1(PaymentMethodDataSource.Callback callback) {
        this.$callback = callback;
    }

    public final void onResponse(WalletOtpResponse walletOtpResponse) {
        this.$callback.onResponse(walletOtpResponse);
    }
}
